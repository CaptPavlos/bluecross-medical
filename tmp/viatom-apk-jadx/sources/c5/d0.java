package c5;

import e5.x0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1667a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f1668b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(x0 x0Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1667a = i10;
        this.f1668b = x0Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1667a) {
            case 0:
                return new d0(this.f1668b, cVar, 0);
            case 1:
                return new d0(this.f1668b, cVar, 1);
            default:
                return new d0(this.f1668b, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1667a) {
            case 0:
                d0 d0Var = (d0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                d0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                d0 d0Var2 = (d0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                d0Var2.invokeSuspend(wVar3);
                return wVar3;
            default:
                d0 d0Var3 = (d0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                d0Var3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1667a) {
            case 0:
                s6.a.e(obj);
                this.f1668b.G();
                break;
            case 1:
                s6.a.e(obj);
                this.f1668b.i();
                break;
            default:
                s6.a.e(obj);
                this.f1668b.i();
                break;
        }
        return s6.w.f12711a;
    }
}
