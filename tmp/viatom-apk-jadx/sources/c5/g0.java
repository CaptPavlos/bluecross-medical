package c5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1687a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5.w f1688b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(g5.w wVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1687a = i10;
        this.f1688b = wVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1687a) {
            case 0:
                return new g0(this.f1688b, cVar, 0);
            default:
                return new g0(this.f1688b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1687a) {
            case 0:
                g0 g0Var = (g0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                g0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                g0 g0Var2 = (g0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                g0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1687a) {
            case 0:
                s6.a.e(obj);
                this.f1688b.i();
                break;
            default:
                s6.a.e(obj);
                this.f1688b.i();
                break;
        }
        return s6.w.f12711a;
    }
}
