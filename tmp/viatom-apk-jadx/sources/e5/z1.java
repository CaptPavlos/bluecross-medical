package e5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7920a;

    /* renamed from: b, reason: collision with root package name */
    public int f7921b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b2 f7922c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z1(b2 b2Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7920a = i10;
        this.f7922c = b2Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7920a) {
            case 0:
                return new z1(this.f7922c, cVar, 0);
            default:
                return new z1(this.f7922c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7920a) {
            case 0:
                ((z1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((z1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f7920a) {
            case 0:
                int i10 = this.f7921b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                b2 b2Var = this.f7922c;
                u7.m0 m0Var = b2Var.d().f7750d;
                y1 y1Var = new y1(b2Var, 0);
                this.f7921b = 1;
                m0Var.collect(y1Var, this);
                return x6.a.f13718a;
            default:
                int i11 = this.f7921b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                b2 b2Var2 = this.f7922c;
                u7.m0 m0Var2 = b2Var2.d().f7748b;
                y1 y1Var2 = new y1(b2Var2, 1);
                this.f7921b = 1;
                m0Var2.collect(y1Var2, this);
                return x6.a.f13718a;
        }
    }
}
