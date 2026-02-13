package l4;

import com.uptodown.activities.UserDeviceDetailsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class bb extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10264a;

    /* renamed from: b, reason: collision with root package name */
    public int f10265b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f10266c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bb(UserDeviceDetailsActivity userDeviceDetailsActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10264a = i10;
        this.f10266c = userDeviceDetailsActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10264a) {
            case 0:
                return new bb(this.f10266c, cVar, 0);
            case 1:
                return new bb(this.f10266c, cVar, 1);
            default:
                return new bb(this.f10266c, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10264a) {
            case 0:
                ((bb) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 1:
                ((bb) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((bb) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10264a) {
            case 0:
                int i10 = this.f10265b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                UserDeviceDetailsActivity userDeviceDetailsActivity = this.f10266c;
                u7.m0 m0Var = userDeviceDetailsActivity.o0().f10505c;
                ab abVar = new ab(userDeviceDetailsActivity, 0);
                this.f10265b = 1;
                m0Var.collect(abVar, this);
                return x6.a.f13718a;
            case 1:
                int i11 = this.f10265b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                UserDeviceDetailsActivity userDeviceDetailsActivity2 = this.f10266c;
                u7.m0 m0Var2 = userDeviceDetailsActivity2.o0().e;
                ab abVar2 = new ab(userDeviceDetailsActivity2, 1);
                this.f10265b = 1;
                m0Var2.collect(abVar2, this);
                return x6.a.f13718a;
            default:
                int i12 = this.f10265b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                UserDeviceDetailsActivity userDeviceDetailsActivity3 = this.f10266c;
                u7.m0 m0Var3 = userDeviceDetailsActivity3.o0().g;
                ab abVar3 = new ab(userDeviceDetailsActivity3, 2);
                this.f10265b = 1;
                m0Var3.collect(abVar3, this);
                return x6.a.f13718a;
        }
    }
}
