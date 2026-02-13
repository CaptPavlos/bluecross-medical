package w2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f13465a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f13466b;

    /* renamed from: c, reason: collision with root package name */
    public final FirebaseMessaging f13467c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadPoolExecutor f13468d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new o0.a("firebase-iid-executor"));

    public s(FirebaseMessaging firebaseMessaging, long j10) {
        this.f13467c = firebaseMessaging;
        this.f13465a = j10;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) firebaseMessaging.f2434b.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f13466b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public final boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f13467c.f2434b.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final boolean b() throws IOException {
        try {
            if (this.f13467c.a() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e.getMessage() != null) {
                    throw e;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        PowerManager.WakeLock wakeLock = this.f13466b;
        r rVarY = r.y();
        FirebaseMessaging firebaseMessaging = this.f13467c;
        if (rVarY.A(firebaseMessaging.f2434b)) {
            wakeLock.acquire();
        }
        try {
            try {
                synchronized (firebaseMessaging) {
                    firebaseMessaging.f2437i = true;
                }
                if (!firebaseMessaging.h.f()) {
                    firebaseMessaging.f(false);
                    if (r.y().A(firebaseMessaging.f2434b)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                if (!r.y().z(firebaseMessaging.f2434b) || a()) {
                    if (b()) {
                        firebaseMessaging.f(false);
                    } else {
                        firebaseMessaging.h(this.f13465a);
                    }
                    if (r.y().A(firebaseMessaging.f2434b)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                h0.r rVar = new h0.r();
                rVar.f8400c = this;
                rVar.a();
                if (r.y().A(firebaseMessaging.f2434b)) {
                    wakeLock.release();
                }
            } catch (IOException e) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e.getMessage() + ". Won't retry the operation.");
                firebaseMessaging.f(false);
                if (r.y().A(firebaseMessaging.f2434b)) {
                    wakeLock.release();
                }
            }
        } catch (Throwable th) {
            if (r.y().A(firebaseMessaging.f2434b)) {
                wakeLock.release();
            }
            throw th;
        }
    }
}
