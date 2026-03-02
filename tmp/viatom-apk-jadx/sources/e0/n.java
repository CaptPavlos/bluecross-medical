package e0;

import android.content.Context;
import android.util.Log;
import h1.p;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {
    public static n e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7616a;

    /* renamed from: b, reason: collision with root package name */
    public int f7617b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7618c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7619d;

    public n(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f7619d = new k(this);
        this.f7617b = 1;
        this.f7618c = scheduledExecutorService;
        this.f7616a = context.getApplicationContext();
    }

    public static synchronized n a(Context context) {
        try {
            if (e == null) {
                e = new n(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new o0.a("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    public synchronized p b(l lVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(lVar.toString()));
            }
            if (!((k) this.f7619d).d(lVar)) {
                k kVar = new k(this);
                this.f7619d = kVar;
                kVar.d(lVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return lVar.f7613b.f8418a;
    }

    public n(Context context, h5.h hVar, g5.l lVar, int i10) {
        hVar.getClass();
        this.f7616a = context;
        this.f7618c = hVar;
        this.f7619d = lVar;
        this.f7617b = i10;
    }
}
