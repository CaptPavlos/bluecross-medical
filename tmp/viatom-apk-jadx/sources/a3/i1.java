package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f91a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f92b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k1 f93c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i1(k1 k1Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f91a = i10;
        this.f93c = k1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f91a) {
            case 0:
                i1 i1Var = new i1(this.f93c, cVar, 0);
                i1Var.f92b = obj;
                return i1Var;
            default:
                i1 i1Var2 = new i1(this.f93c, cVar, 1);
                i1Var2.f92b = obj;
                return i1Var2;
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        o0 o0Var = (o0) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f91a) {
        }
        return ((i1) create(o0Var, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.i1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
