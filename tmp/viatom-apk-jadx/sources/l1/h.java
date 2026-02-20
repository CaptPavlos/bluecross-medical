package l1;

import a3.z0;
import java.util.concurrent.Executor;
import q1.q;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements q1.d {

    /* renamed from: b, reason: collision with root package name */
    public static final h f10183b = new h(0);

    /* renamed from: c, reason: collision with root package name */
    public static final h f10184c = new h(1);

    /* renamed from: d, reason: collision with root package name */
    public static final h f10185d = new h(2);
    public static final h e = new h(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10186a;

    public /* synthetic */ h(int i10) {
        this.f10186a = i10;
    }

    @Override // q1.d
    public final Object c(z0 z0Var) {
        switch (this.f10186a) {
            case 0:
                Object objF = z0Var.f(new q(p1.a.class, Executor.class));
                objF.getClass();
                return y.k((Executor) objF);
            case 1:
                Object objF2 = z0Var.f(new q(p1.c.class, Executor.class));
                objF2.getClass();
                return y.k((Executor) objF2);
            case 2:
                Object objF3 = z0Var.f(new q(p1.b.class, Executor.class));
                objF3.getClass();
                return y.k((Executor) objF3);
            default:
                Object objF4 = z0Var.f(new q(p1.d.class, Executor.class));
                objF4.getClass();
                return y.k((Executor) objF4);
        }
    }
}
