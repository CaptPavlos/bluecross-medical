package x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13662a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d5.j f13663b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(d5.j jVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f13662a = i10;
        this.f13663b = jVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13662a) {
            case 0:
                return new s(this.f13663b, cVar, 0);
            case 1:
                return new s(this.f13663b, cVar, 1);
            case 2:
                return new s(this.f13663b, cVar, 2);
            case 3:
                return new s(this.f13663b, cVar, 3);
            case 4:
                return new s(this.f13663b, cVar, 4);
            case 5:
                return new s(this.f13663b, cVar, 5);
            case 6:
                return new s(this.f13663b, cVar, 6);
            default:
                return new s(this.f13663b, cVar, 7);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13662a) {
            case 0:
                s sVar = (s) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                sVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                s sVar2 = (s) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                sVar2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                s sVar3 = (s) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                sVar3.invokeSuspend(wVar4);
                return wVar4;
            case 3:
                s sVar4 = (s) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                sVar4.invokeSuspend(wVar5);
                return wVar5;
            case 4:
                s sVar5 = (s) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                sVar5.invokeSuspend(wVar6);
                return wVar6;
            case 5:
                s sVar6 = (s) create(wVar, cVar);
                s6.w wVar7 = s6.w.f12711a;
                sVar6.invokeSuspend(wVar7);
                return wVar7;
            case 6:
                s sVar7 = (s) create(wVar, cVar);
                s6.w wVar8 = s6.w.f12711a;
                sVar7.invokeSuspend(wVar8);
                return wVar8;
            default:
                s sVar8 = (s) create(wVar, cVar);
                s6.w wVar9 = s6.w.f12711a;
                sVar8.invokeSuspend(wVar9);
                return wVar9;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13662a) {
            case 0:
                s6.a.e(obj);
                this.f13663b.c();
                break;
            case 1:
                s6.a.e(obj);
                this.f13663b.c();
                break;
            case 2:
                s6.a.e(obj);
                this.f13663b.j();
                break;
            case 3:
                s6.a.e(obj);
                this.f13663b.j();
                break;
            case 4:
                s6.a.e(obj);
                this.f13663b.c();
                break;
            case 5:
                s6.a.e(obj);
                this.f13663b.c();
                break;
            case 6:
                s6.a.e(obj);
                this.f13663b.j();
                break;
            default:
                s6.a.e(obj);
                this.f13663b.j();
                break;
        }
        return s6.w.f12711a;
    }
}
