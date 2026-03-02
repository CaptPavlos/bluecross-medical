package c5;

import c1.w4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1745a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f1746b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.k f1747c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w4 f1748d;
    public final /* synthetic */ v5.g e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(t tVar, h5.k kVar, w4 w4Var, v5.g gVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1745a = i10;
        this.f1746b = tVar;
        this.f1747c = kVar;
        this.f1748d = w4Var;
        this.e = gVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1745a) {
            case 0:
                return new r(this.f1746b, this.f1747c, this.f1748d, this.e, cVar, 0);
            default:
                return new r(this.f1746b, this.f1747c, this.f1748d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1745a) {
        }
        return ((r) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1745a) {
            case 0:
                s6.a.e(obj);
                return t.a(this.f1746b, this.f1747c, this.f1748d, this.e);
            default:
                s6.a.e(obj);
                return t.a(this.f1746b, this.f1747c, this.f1748d, this.e);
        }
    }
}
