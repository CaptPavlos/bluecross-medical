package c1;

import j$.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1510a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1511b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1512c;

    public v1(v4 v4Var, d5 d5Var) {
        this.f1510a = 2;
        this.f1512c = d5Var;
        Objects.requireNonNull(v4Var);
        this.f1511b = v4Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1510a) {
            case 0:
                d2 d2Var = (d2) this.f1511b;
                d2Var.f1108a.B();
                n nVar = d2Var.f1108a.f1520c;
                v4.U(nVar);
                return nVar.b0((String) this.f1512c);
            case 1:
                d2 d2Var2 = (d2) this.f1511b;
                d2Var2.f1108a.B();
                return new i(d2Var2.f1108a.p0(((d5) this.f1512c).f1114a));
            default:
                d5 d5Var = (d5) this.f1512c;
                String str = d5Var.f1114a;
                i0.y.g(str);
                v4 v4Var = (v4) this.f1511b;
                k2 k2VarD = v4Var.d(str);
                j2 j2Var = j2.ANALYTICS_STORAGE;
                if (k2VarD.i(j2Var) && k2.c(100, d5Var.f1128s).i(j2Var)) {
                    return v4Var.c0(d5Var).E();
                }
                v4Var.a().f1545n.b("Analytics storage consent denied. Returning null app instance id");
                return null;
        }
    }

    public /* synthetic */ v1(d2 d2Var, Object obj, int i10) {
        this.f1510a = i10;
        this.f1512c = obj;
        this.f1511b = d2Var;
    }
}
