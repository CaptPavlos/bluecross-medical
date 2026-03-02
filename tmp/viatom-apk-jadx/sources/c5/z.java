package c5;

import h5.o0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1773a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w2.r f1774b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o0 f1775c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(w2.r rVar, o0 o0Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1773a = i10;
        this.f1774b = rVar;
        this.f1775c = o0Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1773a) {
            case 0:
                return new z(this.f1774b, this.f1775c, cVar, 0);
            default:
                return new z(this.f1774b, this.f1775c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1773a) {
            case 0:
                z zVar = (z) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                zVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                z zVar2 = (z) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                zVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1773a) {
            case 0:
                s6.a.e(obj);
                ((g5.z) this.f1774b.e).m(this.f1775c);
                break;
            default:
                s6.a.e(obj);
                ((g5.z) this.f1774b.e).m(this.f1775c);
                break;
        }
        return s6.w.f12711a;
    }
}
