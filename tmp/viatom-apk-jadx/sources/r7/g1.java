package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g1 extends e1 {
    public final i1 e;
    public final h1 f;
    public final k g;
    public final Object h;

    public g1(i1 i1Var, h1 h1Var, k kVar, Object obj) {
        this.e = i1Var;
        this.f = h1Var;
        this.g = kVar;
        this.h = obj;
    }

    @Override // r7.e1
    public final boolean i() {
        return false;
    }

    @Override // r7.e1
    public final void j(Throwable th) {
        k kVar = this.g;
        k kVarS = i1.S(kVar);
        i1 i1Var = this.e;
        h1 h1Var = this.f;
        Object obj = this.h;
        if (kVarS == null || !i1Var.b0(h1Var, kVarS, obj)) {
            h1Var.f12406a.c(new w7.h(2), 2);
            k kVarS2 = i1.S(kVar);
            if (kVarS2 == null || !i1Var.b0(h1Var, kVarS2, obj)) {
                i1Var.t(i1Var.D(h1Var, obj));
            }
        }
    }
}
