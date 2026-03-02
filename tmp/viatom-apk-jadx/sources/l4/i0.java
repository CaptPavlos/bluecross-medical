package l4;

import com.uptodown.activities.FollowListActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10480a;

    /* renamed from: b, reason: collision with root package name */
    public int f10481b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FollowListActivity f10482c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(FollowListActivity followListActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10480a = i10;
        this.f10482c = followListActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10480a) {
            case 0:
                return new i0(this.f10482c, cVar, 0);
            default:
                return new i0(this.f10482c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10480a) {
            case 0:
                ((i0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((i0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10480a;
        x6.a aVar = x6.a.f13718a;
        FollowListActivity followListActivity = this.f10482c;
        switch (i10) {
            case 0:
                int i11 = this.f10481b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i12 = FollowListActivity.L;
                u7.m0 m0Var = followListActivity.o0().f10642b;
                h0 h0Var = new h0(followListActivity);
                this.f10481b = 1;
                m0Var.collect(h0Var, this);
                return aVar;
            default:
                int i13 = this.f10481b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i14 = FollowListActivity.L;
                u7.m0 m0Var2 = followListActivity.o0().f10644d;
                a3.f1 f1Var = new a3.f1(followListActivity, 3);
                this.f10481b = 1;
                m0Var2.collect(f1Var, this);
                return aVar;
        }
    }
}
