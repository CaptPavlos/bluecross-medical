package c1;

import android.os.Handler;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class o {

    /* renamed from: d, reason: collision with root package name */
    public static volatile com.google.android.gms.internal.measurement.h0 f1377d;

    /* renamed from: a, reason: collision with root package name */
    public final g2 f1378a;

    /* renamed from: b, reason: collision with root package name */
    public final k1.a f1379b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f1380c;

    public o(g2 g2Var) {
        i0.y.g(g2Var);
        this.f1378a = g2Var;
        this.f1379b = new k1.a(this, g2Var, 1, false);
    }

    public abstract void a();

    public final void b(long j10) {
        c();
        if (j10 >= 0) {
            g2 g2Var = this.f1378a;
            g2Var.f().getClass();
            this.f1380c = System.currentTimeMillis();
            if (d().postDelayed(this.f1379b, j10)) {
                return;
            }
            g2Var.a().f.c(Long.valueOf(j10), "Failed to schedule delayed post. time");
        }
    }

    public final void c() {
        this.f1380c = 0L;
        d().removeCallbacks(this.f1379b);
    }

    public final Handler d() {
        com.google.android.gms.internal.measurement.h0 h0Var;
        if (f1377d != null) {
            return f1377d;
        }
        synchronized (o.class) {
            try {
                if (f1377d == null) {
                    f1377d = new com.google.android.gms.internal.measurement.h0(this.f1378a.e().getMainLooper(), 0);
                }
                h0Var = f1377d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return h0Var;
    }
}
