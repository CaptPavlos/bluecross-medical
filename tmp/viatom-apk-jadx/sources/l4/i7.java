package l4;

import com.uptodown.activities.RecommendedActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i7 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10495a;

    /* renamed from: b, reason: collision with root package name */
    public int f10496b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f10497c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i7(RecommendedActivity recommendedActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10495a = i10;
        this.f10497c = recommendedActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10495a) {
            case 0:
                return new i7(this.f10497c, cVar, 0);
            default:
                return new i7(this.f10497c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10495a) {
            case 0:
                ((i7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((i7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10495a;
        x6.a aVar = x6.a.f13718a;
        RecommendedActivity recommendedActivity = this.f10497c;
        switch (i10) {
            case 0:
                int i11 = this.f10496b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i12 = RecommendedActivity.Z;
                u7.m0 m0Var = recommendedActivity.C0().f10597b;
                h7 h7Var = new h7(recommendedActivity, 0);
                this.f10496b = 1;
                m0Var.collect(h7Var, this);
                return aVar;
            default:
                int i13 = this.f10496b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i14 = RecommendedActivity.Z;
                u7.m0 m0Var2 = recommendedActivity.C0().f10599d;
                h7 h7Var2 = new h7(recommendedActivity, 1);
                this.f10496b = 1;
                m0Var2.collect(h7Var2, this);
                return aVar;
        }
    }
}
