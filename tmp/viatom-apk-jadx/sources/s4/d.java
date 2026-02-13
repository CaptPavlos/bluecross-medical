package s4;

import c1.g1;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12549a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g1 f12550b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12551c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(g1 g1Var, int i10, w6.c cVar, int i11) {
        super(2, cVar);
        this.f12549a = i11;
        this.f12550b = g1Var;
        this.f12551c = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12549a) {
            case 0:
                return new d(this.f12550b, this.f12551c, cVar, 0);
            default:
                return new d(this.f12550b, this.f12551c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12549a) {
            case 0:
                d dVar = (d) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                dVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                d dVar2 = (d) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                dVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f12549a) {
            case 0:
                s6.a.e(obj);
                ((d0.i) this.f12550b.f1232d).D(this.f12551c);
                break;
            default:
                s6.a.e(obj);
                ((d0.i) this.f12550b.f1232d).D(this.f12551c);
                break;
        }
        return s6.w.f12711a;
    }
}
