package l4;

import com.uptodown.activities.PublicProfileActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v6 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10914a;

    /* renamed from: b, reason: collision with root package name */
    public int f10915b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10916c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v6(PublicProfileActivity publicProfileActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10914a = i10;
        this.f10916c = publicProfileActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10914a) {
            case 0:
                return new v6(this.f10916c, cVar, 0);
            default:
                return new v6(this.f10916c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10914a) {
            case 0:
                ((v6) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((v6) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10914a;
        x6.a aVar = x6.a.f13718a;
        PublicProfileActivity publicProfileActivity = this.f10916c;
        switch (i10) {
            case 0:
                int i11 = this.f10915b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i12 = PublicProfileActivity.K;
                u7.m0 m0Var = publicProfileActivity.o0().f;
                u6 u6Var = new u6(publicProfileActivity, 0);
                this.f10915b = 1;
                m0Var.collect(u6Var, this);
                return aVar;
            default:
                int i13 = this.f10915b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i14 = PublicProfileActivity.K;
                u7.m0 m0Var2 = publicProfileActivity.o0().h;
                u6 u6Var2 = new u6(publicProfileActivity, 1);
                this.f10915b = 1;
                m0Var2.collect(u6Var2, this);
                return aVar;
        }
    }
}
