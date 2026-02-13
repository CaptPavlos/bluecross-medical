package c5;

import h5.x0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1739a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f1740b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x0 f1741c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(t tVar, x0 x0Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1739a = i10;
        this.f1740b = tVar;
        this.f1741c = x0Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1739a) {
            case 0:
                return new p(this.f1740b, this.f1741c, cVar, 0);
            case 1:
                return new p(this.f1740b, this.f1741c, cVar, 1);
            default:
                return new p(this.f1740b, this.f1741c, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1739a) {
            case 0:
                p pVar = (p) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                pVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                p pVar2 = (p) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                pVar2.invokeSuspend(wVar3);
                return wVar3;
            default:
                p pVar3 = (p) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                pVar3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1739a) {
            case 0:
                s6.a.e(obj);
                ((g5.h) this.f1740b.f1758d).k(this.f1741c);
                break;
            case 1:
                s6.a.e(obj);
                ((g5.h) this.f1740b.f1758d).i(this.f1741c);
                break;
            default:
                s6.a.e(obj);
                ((g5.h) this.f1740b.f1758d).c(this.f1741c);
                break;
        }
        return s6.w.f12711a;
    }
}
