package w2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13481a;

    /* renamed from: b, reason: collision with root package name */
    public final c5.t f13482b;

    /* renamed from: c, reason: collision with root package name */
    public final d5.j f13483c;

    /* renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f13484d;
    public final ScheduledThreadPoolExecutor f;
    public final u h;
    public final ArrayMap e = new ArrayMap();
    public boolean g = false;

    public w(FirebaseMessaging firebaseMessaging, c5.t tVar, u uVar, d5.j jVar, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f13484d = firebaseMessaging;
        this.f13482b = tVar;
        this.h = uVar;
        this.f13483c = jVar;
        this.f13481a = context;
        this.f = scheduledThreadPoolExecutor;
    }

    public static void a(h1.p pVar) throws IOException {
        try {
            r0.f.j(pVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e3);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static boolean d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    public final void b(String str) throws IOException {
        String strA = this.f13484d.a();
        d5.j jVar = this.f13483c;
        jVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        a(jVar.d(jVar.o(strA, "/topics/" + str, bundle)));
    }

    public final void c(String str) throws IOException {
        String strA = this.f13484d.a();
        d5.j jVar = this.f13483c;
        jVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        a(jVar.d(jVar.o(strA, "/topics/" + str, bundle)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(t tVar) {
        synchronized (this.e) {
            try {
                String str = tVar.f13472c;
                if (this.e.containsKey(str)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.e.get(str);
                    h1.i iVar = (h1.i) arrayDeque.poll();
                    if (iVar != null) {
                        iVar.a(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.e.remove(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void f(boolean z9) {
        this.g = z9;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083 A[Catch: IOException -> 0x005d, TryCatch #1 {IOException -> 0x005d, blocks: (B:15:0x0028, B:32:0x0083, B:34:0x0089, B:20:0x0039, B:22:0x0041, B:24:0x004a, B:27:0x005f, B:29:0x0067, B:31:0x0070), top: B:54:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.w.g():boolean");
    }

    public final void h(long j10) {
        this.f.schedule(new y(this, this.f13481a, this.f13482b, Math.min(Math.max(30L, 2 * j10), 28800L)), j10, TimeUnit.SECONDS);
        f(true);
    }
}
