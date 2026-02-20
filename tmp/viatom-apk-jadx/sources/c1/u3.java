package c1;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1499a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f1500b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w3 f1501c;

    public /* synthetic */ u3(w3 w3Var, i0 i0Var, int i10) {
        this.f1499a = i10;
        this.f1500b = i0Var;
        this.f1501c = w3Var;
    }

    private final void a() {
        w3 w3Var = this.f1501c;
        synchronized (w3Var) {
            try {
                w3Var.f1552a = false;
                x3 x3Var = w3Var.f1554c;
                if (!x3Var.x()) {
                    w0 w0Var = x3Var.f1149a.f;
                    u1.m(w0Var);
                    w0Var.f1545n.b("Connected to service");
                    i0 i0Var = this.f1500b;
                    x3Var.g();
                    x3Var.f1572d = i0Var;
                    x3Var.t();
                    x3Var.v();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1499a) {
            case 0:
                a();
                return;
            default:
                w3 w3Var = this.f1501c;
                synchronized (w3Var) {
                    try {
                        w3Var.f1552a = false;
                        x3 x3Var = w3Var.f1554c;
                        if (!x3Var.x()) {
                            w0 w0Var = x3Var.f1149a.f;
                            u1.m(w0Var);
                            w0Var.f1544m.b("Connected to remote service");
                            i0 i0Var = this.f1500b;
                            x3Var.g();
                            x3Var.f1572d = i0Var;
                            x3Var.t();
                            x3Var.v();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                x3 x3Var2 = this.f1501c.f1554c;
                ScheduledExecutorService scheduledExecutorService = x3Var2.g;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    x3Var2.g = null;
                    return;
                }
                return;
        }
    }
}
