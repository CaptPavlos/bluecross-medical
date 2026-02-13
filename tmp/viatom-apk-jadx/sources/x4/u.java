package x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13667a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d5.j f13668b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f13669c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(d5.j jVar, kotlin.jvm.internal.v vVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f13667a = i10;
        this.f13668b = jVar;
        this.f13669c = vVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13667a) {
            case 0:
                return new u(this.f13668b, this.f13669c, cVar, 0);
            case 1:
                return new u(this.f13668b, this.f13669c, cVar, 1);
            case 2:
                return new u(this.f13668b, this.f13669c, cVar, 2);
            default:
                return new u(this.f13668b, this.f13669c, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13667a) {
            case 0:
                u uVar = (u) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                uVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                u uVar2 = (u) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                uVar2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                u uVar3 = (u) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                uVar3.invokeSuspend(wVar4);
                return wVar4;
            default:
                u uVar4 = (u) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                uVar4.invokeSuspend(wVar5);
                return wVar5;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13667a) {
            case 0:
                s6.a.e(obj);
                this.f13668b.b(this.f13669c.f10136a);
                break;
            case 1:
                s6.a.e(obj);
                this.f13668b.b(this.f13669c.f10136a);
                break;
            case 2:
                s6.a.e(obj);
                this.f13668b.b(this.f13669c.f10136a);
                break;
            default:
                s6.a.e(obj);
                this.f13668b.b(this.f13669c.f10136a);
                break;
        }
        return s6.w.f12711a;
    }
}
