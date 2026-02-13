package x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13664a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d5.j f13665b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.w f13666c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(d5.j jVar, kotlin.jvm.internal.w wVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f13664a = i10;
        this.f13665b = jVar;
        this.f13666c = wVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13664a) {
            case 0:
                return new t(this.f13665b, this.f13666c, cVar, 0);
            case 1:
                return new t(this.f13665b, this.f13666c, cVar, 1);
            case 2:
                return new t(this.f13665b, this.f13666c, cVar, 2);
            default:
                return new t(this.f13665b, this.f13666c, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13664a) {
            case 0:
                t tVar = (t) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                tVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                t tVar2 = (t) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                tVar2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                t tVar3 = (t) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                tVar3.invokeSuspend(wVar4);
                return wVar4;
            default:
                t tVar4 = (t) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                tVar4.invokeSuspend(wVar5);
                return wVar5;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13664a) {
            case 0:
                s6.a.e(obj);
                this.f13665b.k(this.f13666c.f10137a);
                break;
            case 1:
                s6.a.e(obj);
                this.f13665b.k(this.f13666c.f10137a);
                break;
            case 2:
                s6.a.e(obj);
                this.f13665b.k(this.f13666c.f10137a);
                break;
            default:
                s6.a.e(obj);
                this.f13665b.k(this.f13666c.f10137a);
                break;
        }
        return s6.w.f12711a;
    }
}
