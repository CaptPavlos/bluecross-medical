package s4;

import c1.g1;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12598a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g1 f12599b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(g1 g1Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12598a = i10;
        this.f12599b = g1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12598a) {
            case 0:
                return new o(this.f12599b, cVar, 0);
            default:
                return new o(this.f12599b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12598a) {
            case 0:
                o oVar = (o) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                oVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                o oVar2 = (o) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                oVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f12598a) {
            case 0:
                s6.a.e(obj);
                ((t4.d) this.f12599b.f1232d).l();
                break;
            default:
                s6.a.e(obj);
                ((t4.d) this.f12599b.f1232d).r();
                break;
        }
        return s6.w.f12711a;
    }
}
