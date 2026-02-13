package c5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1681a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5.u f1682b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(g5.u uVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1681a = i10;
        this.f1682b = uVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1681a) {
            case 0:
                return new f0(this.f1682b, cVar, 0);
            case 1:
                return new f0(this.f1682b, cVar, 1);
            case 2:
                return new f0(this.f1682b, cVar, 2);
            case 3:
                return new f0(this.f1682b, cVar, 3);
            case 4:
                return new f0(this.f1682b, cVar, 4);
            default:
                return new f0(this.f1682b, cVar, 5);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1681a) {
            case 0:
                f0 f0Var = (f0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                f0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                f0 f0Var2 = (f0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                f0Var2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                f0 f0Var3 = (f0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                f0Var3.invokeSuspend(wVar4);
                return wVar4;
            case 3:
                f0 f0Var4 = (f0) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                f0Var4.invokeSuspend(wVar5);
                return wVar5;
            case 4:
                f0 f0Var5 = (f0) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                f0Var5.invokeSuspend(wVar6);
                return wVar6;
            default:
                f0 f0Var6 = (f0) create(wVar, cVar);
                s6.w wVar7 = s6.w.f12711a;
                f0Var6.invokeSuspend(wVar7);
                return wVar7;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1681a) {
            case 0:
                s6.a.e(obj);
                this.f1682b.M();
                break;
            case 1:
                s6.a.e(obj);
                this.f1682b.i();
                break;
            case 2:
                s6.a.e(obj);
                this.f1682b.i();
                break;
            case 3:
                s6.a.e(obj);
                this.f1682b.M();
                break;
            case 4:
                s6.a.e(obj);
                this.f1682b.i();
                break;
            default:
                s6.a.e(obj);
                this.f1682b.i();
                break;
        }
        return s6.w.f12711a;
    }
}
