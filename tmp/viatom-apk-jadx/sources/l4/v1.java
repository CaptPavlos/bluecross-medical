package l4;

import com.uptodown.activities.LoginActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10901a;

    /* renamed from: b, reason: collision with root package name */
    public int f10902b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f10903c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v1(LoginActivity loginActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10901a = i10;
        this.f10903c = loginActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10901a) {
            case 0:
                return new v1(this.f10903c, cVar, 0);
            default:
                return new v1(this.f10903c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10901a) {
            case 0:
                ((v1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((v1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10901a;
        x6.a aVar = x6.a.f13718a;
        LoginActivity loginActivity = this.f10903c;
        int i11 = 1;
        switch (i10) {
            case 0:
                int i12 = this.f10902b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i13 = LoginActivity.P;
                u7.m0 m0Var = loginActivity.w0().f10383b;
                u1 u1Var = new u1(loginActivity, 0);
                this.f10902b = 1;
                m0Var.collect(u1Var, this);
                return aVar;
            default:
                int i14 = this.f10902b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i15 = LoginActivity.P;
                u7.m0 m0Var2 = loginActivity.w0().f10385d;
                u1 u1Var2 = new u1(loginActivity, i11);
                this.f10902b = 1;
                m0Var2.collect(u1Var2, this);
                return aVar;
        }
    }
}
