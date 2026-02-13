package c5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1734a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5.t f1735b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n0(g5.t tVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1734a = i10;
        this.f1735b = tVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1734a) {
            case 0:
                return new n0(this.f1735b, cVar, 0);
            case 1:
                return new n0(this.f1735b, cVar, 1);
            default:
                return new n0(this.f1735b, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1734a) {
            case 0:
                n0 n0Var = (n0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                n0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                n0 n0Var2 = (n0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                n0Var2.invokeSuspend(wVar3);
                return wVar3;
            default:
                n0 n0Var3 = (n0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                n0Var3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1734a) {
            case 0:
                s6.a.e(obj);
                this.f1735b.G();
                break;
            case 1:
                s6.a.e(obj);
                this.f1735b.i();
                break;
            default:
                s6.a.e(obj);
                this.f1735b.i();
                break;
        }
        return s6.w.f12711a;
    }
}
