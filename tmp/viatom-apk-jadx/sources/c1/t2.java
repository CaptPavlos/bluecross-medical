package c1;

import android.os.SystemClock;
import android.text.TextUtils;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1465a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1466b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c3 f1467c;

    public t2(c3 c3Var, long j10, int i10) {
        this.f1465a = i10;
        switch (i10) {
            case 1:
                this.f1466b = j10;
                Objects.requireNonNull(c3Var);
                this.f1467c = c3Var;
                break;
            default:
                this.f1466b = j10;
                Objects.requireNonNull(c3Var);
                this.f1467c = c3Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1465a) {
            case 0:
                u1 u1Var = this.f1467c.f1149a;
                h1 h1Var = u1Var.e;
                u1.k(h1Var);
                e1 e1Var = h1Var.f1248k;
                long j10 = this.f1466b;
                e1Var.b(j10);
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1544m.c(Long.valueOf(j10), "Session timeout duration set");
                break;
            default:
                c3 c3Var = this.f1467c;
                c3Var.g();
                c3Var.h();
                u1 u1Var2 = c3Var.f1149a;
                w0 w0Var2 = u1Var2.f;
                u1.m(w0Var2);
                w0Var2.f1544m.b("Resetting analytics data (FE)");
                g4 g4Var = u1Var2.h;
                u1.l(g4Var);
                g4Var.g();
                f4 f4Var = g4Var.f;
                ((e4) f4Var.f1220c).c();
                ((g4) f4Var.f1221d).f1149a.f1481k.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                f4Var.f1218a = jElapsedRealtime;
                f4Var.f1219b = jElapsedRealtime;
                u1Var2.r().l();
                boolean z9 = !u1Var2.d();
                h1 h1Var2 = u1Var2.e;
                u1.k(h1Var2);
                h1Var2.f.b(this.f1466b);
                u1 u1Var3 = h1Var2.f1149a;
                h1 h1Var3 = u1Var3.e;
                u1.k(h1Var3);
                if (!TextUtils.isEmpty(h1Var3.f1258v.n())) {
                    h1Var2.f1258v.o(null);
                }
                h1Var2.f1253p.b(0L);
                h1Var2.f1254q.b(0L);
                if (!u1Var3.f1478d.t()) {
                    h1Var2.p(z9);
                }
                h1Var2.f1259w.o(null);
                h1Var2.f1260x.b(0L);
                h1Var2.y.M(null);
                x3 x3VarP = u1Var2.p();
                x3VarP.g();
                x3VarP.h();
                d5 d5VarW = x3VarP.w(false);
                x3VarP.s();
                x3VarP.f1149a.o().k();
                x3VarP.u(new s3(x3VarP, d5VarW, 0));
                u1.l(g4Var);
                g4Var.e.C();
                c3Var.f1088s = z9;
                u1Var2.p().k(new AtomicReference());
                break;
        }
    }
}
