package x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13630a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t4.d f13631b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(int i10, t4.d dVar, w6.c cVar) {
        super(2, cVar);
        this.f13630a = i10;
        this.f13631b = dVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13630a) {
            case 0:
                return new m(0, this.f13631b, cVar);
            case 1:
                return new m(1, this.f13631b, cVar);
            default:
                return new m(2, this.f13631b, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13630a) {
        }
        return ((m) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f13630a;
        s6.w wVar = s6.w.f12711a;
        t4.d dVar = this.f13631b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                if (dVar != null) {
                    dVar.n();
                    break;
                }
                break;
            case 1:
                s6.a.e(obj);
                if (dVar != null) {
                    dVar.c(100);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                if (dVar != null) {
                    dVar.o();
                    break;
                }
                break;
        }
        return wVar;
    }
}
