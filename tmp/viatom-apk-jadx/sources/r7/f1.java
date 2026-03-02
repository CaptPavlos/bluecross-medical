package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 extends g {

    /* renamed from: i, reason: collision with root package name */
    public final i1 f12398i;

    public f1(w6.c cVar, i1 i1Var) {
        super(1, cVar);
        this.f12398i = i1Var;
    }

    @Override // r7.g
    public final Throwable p(i1 i1Var) {
        Throwable thC;
        i1 i1Var2 = this.f12398i;
        i1Var2.getClass();
        Object obj = i1.f12408a.get(i1Var2);
        return (!(obj instanceof h1) || (thC = ((h1) obj).c()) == null) ? obj instanceof p ? ((p) obj).f12426a : i1Var.e() : thC;
    }

    @Override // r7.g
    public final String y() {
        return "AwaitContinuation";
    }
}
