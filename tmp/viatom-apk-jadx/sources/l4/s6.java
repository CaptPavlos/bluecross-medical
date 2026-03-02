package l4;

import com.uptodown.activities.PublicProfileActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s6 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10818a;

    /* renamed from: b, reason: collision with root package name */
    public int f10819b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10820c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f10821d;
    public final /* synthetic */ h5.e1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s6(PublicProfileActivity publicProfileActivity, kotlin.jvm.internal.x xVar, h5.e1 e1Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10818a = i10;
        this.f10820c = publicProfileActivity;
        this.f10821d = xVar;
        this.e = e1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10818a) {
            case 0:
                return new s6(this.f10820c, this.f10821d, this.e, cVar, 0);
            default:
                return new s6(this.f10820c, this.f10821d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10818a) {
            case 0:
                ((s6) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((s6) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10818a;
        h5.e1 e1Var = this.e;
        kotlin.jvm.internal.x xVar = this.f10821d;
        x6.a aVar = x6.a.f13718a;
        PublicProfileActivity publicProfileActivity = this.f10820c;
        switch (i10) {
            case 0:
                int i11 = this.f10819b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i12 = PublicProfileActivity.K;
                u7.m0 m0Var = publicProfileActivity.o0().f10295b;
                r6 r6Var = new r6(publicProfileActivity, xVar, e1Var);
                this.f10819b = 1;
                m0Var.collect(r6Var, this);
                return aVar;
            default:
                int i13 = this.f10819b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i14 = PublicProfileActivity.K;
                u7.m0 m0Var2 = publicProfileActivity.o0().f10297d;
                t6 t6Var = new t6(publicProfileActivity, xVar, e1Var);
                this.f10819b = 1;
                m0Var2.collect(t6Var, this);
                return aVar;
        }
    }
}
