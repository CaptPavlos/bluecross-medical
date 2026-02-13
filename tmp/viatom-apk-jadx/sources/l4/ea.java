package l4;

import com.uptodown.activities.UserActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ea extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10368a;

    /* renamed from: b, reason: collision with root package name */
    public int f10369b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UserActivity f10370c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ea(UserActivity userActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10368a = i10;
        this.f10370c = userActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10368a) {
            case 0:
                return new ea(this.f10370c, cVar, 0);
            case 1:
                return new ea(this.f10370c, cVar, 1);
            case 2:
                return new ea(this.f10370c, cVar, 2);
            default:
                return new ea(this.f10370c, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10368a) {
            case 0:
                ((ea) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 1:
                ((ea) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 2:
                ((ea) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((ea) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10368a) {
            case 0:
                int i10 = this.f10369b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                UserActivity userActivity = this.f10370c;
                u7.m0 m0Var = ((ob) userActivity.J.getValue()).f10699b;
                da daVar = new da(userActivity, 0);
                this.f10369b = 1;
                m0Var.collect(daVar, this);
                return x6.a.f13718a;
            case 1:
                int i11 = this.f10369b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                UserActivity userActivity2 = this.f10370c;
                u7.m0 m0Var2 = userActivity2.p0().f10857b;
                da daVar2 = new da(userActivity2, 1);
                this.f10369b = 1;
                m0Var2.collect(daVar2, this);
                return x6.a.f13718a;
            case 2:
                int i12 = this.f10369b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                UserActivity userActivity3 = this.f10370c;
                u7.m0 m0Var3 = userActivity3.p0().f10859d;
                da daVar3 = new da(userActivity3, 2);
                this.f10369b = 1;
                m0Var3.collect(daVar3, this);
                return x6.a.f13718a;
            default:
                int i13 = this.f10369b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                UserActivity userActivity4 = this.f10370c;
                u7.m0 m0Var4 = userActivity4.p0().f;
                da daVar4 = new da(userActivity4, 3);
                this.f10369b = 1;
                m0Var4.collect(daVar4, this);
                return x6.a.f13718a;
        }
    }
}
