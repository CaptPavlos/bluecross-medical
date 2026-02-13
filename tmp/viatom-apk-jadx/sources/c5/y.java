package c5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1771a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w2.r f1772b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(w2.r rVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1771a = i10;
        this.f1772b = rVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1771a) {
            case 0:
                return new y(this.f1772b, cVar, 0);
            case 1:
                return new y(this.f1772b, cVar, 1);
            case 2:
                return new y(this.f1772b, cVar, 2);
            case 3:
                return new y(this.f1772b, cVar, 3);
            default:
                return new y(this.f1772b, cVar, 4);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1771a) {
            case 0:
                y yVar = (y) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                yVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                y yVar2 = (y) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                yVar2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                y yVar3 = (y) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                yVar3.invokeSuspend(wVar4);
                return wVar4;
            case 3:
                y yVar4 = (y) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                yVar4.invokeSuspend(wVar5);
                return wVar5;
            default:
                y yVar5 = (y) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                yVar5.invokeSuspend(wVar6);
                return wVar6;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1771a) {
            case 0:
                s6.a.e(obj);
                ((g5.z) this.f1772b.e).q();
                break;
            case 1:
                s6.a.e(obj);
                ((g5.z) this.f1772b.e).q();
                break;
            case 2:
                s6.a.e(obj);
                ((g5.z) this.f1772b.e).q();
                break;
            case 3:
                s6.a.e(obj);
                ((g5.z) this.f1772b.e).q();
                break;
            default:
                s6.a.e(obj);
                ((g5.z) this.f1772b.e).q();
                break;
        }
        return s6.w.f12711a;
    }
}
