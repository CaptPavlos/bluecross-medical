package c5;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1742a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f1743b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1744c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(t tVar, ArrayList arrayList, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1742a = i10;
        this.f1743b = tVar;
        this.f1744c = arrayList;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1742a) {
            case 0:
                return new q(this.f1743b, this.f1744c, cVar, 0);
            default:
                return new q(this.f1743b, this.f1744c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1742a) {
            case 0:
                q qVar = (q) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                qVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                q qVar2 = (q) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                qVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1742a) {
            case 0:
                s6.a.e(obj);
                ((g5.h) this.f1743b.f1758d).e(this.f1744c);
                break;
            default:
                s6.a.e(obj);
                ((g5.h) this.f1743b.f1758d).j(this.f1744c);
                break;
        }
        return s6.w.f12711a;
    }
}
