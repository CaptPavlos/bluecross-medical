package w2;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f13436a;

    /* renamed from: b, reason: collision with root package name */
    public final FirebaseMessagingService f13437b;

    /* renamed from: c, reason: collision with root package name */
    public final n5 f13438c;

    public g(FirebaseMessagingService firebaseMessagingService, n5 n5Var, ExecutorService executorService) {
        this.f13436a = executorService;
        this.f13437b = firebaseMessagingService;
        this.f13438c = n5Var;
    }

    public final boolean a() {
        m mVar;
        if (this.f13438c.U("gcm.n.noui")) {
            return true;
        }
        FirebaseMessagingService firebaseMessagingService = this.f13437b;
        if (!((KeyguardManager) firebaseMessagingService.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) firebaseMessagingService.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        if (next.importance == 100) {
                            return false;
                        }
                    }
                }
            }
        }
        String strC0 = this.f13438c.c0("gcm.n.image");
        if (TextUtils.isEmpty(strC0)) {
            mVar = null;
        } else {
            try {
                mVar = new m(new URL(strC0));
            } catch (MalformedURLException unused) {
                Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + strC0);
            }
        }
        if (mVar != null) {
            ExecutorService executorService = this.f13436a;
            h1.i iVar = new h1.i();
            mVar.f13453b = executorService.submit(new androidx.browser.trusted.c(29, mVar, iVar));
            mVar.f13454c = iVar.f8418a;
        }
        e eVarA = f.a(this.f13437b, this.f13438c);
        NotificationCompat.Builder builder = eVarA.f13433a;
        if (mVar != null) {
            try {
                h1.p pVar = mVar.f13454c;
                i0.y.g(pVar);
                Bitmap bitmap = (Bitmap) r0.f.j(pVar, 5L, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
            } catch (InterruptedException unused2) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                mVar.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                Log.w("FirebaseMessaging", "Failed to download image: " + e.getCause());
            } catch (TimeoutException unused3) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                mVar.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f13437b.getSystemService("notification")).notify(eVarA.f13434b, 0, eVarA.f13433a.build());
        return true;
    }
}
