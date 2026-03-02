package l4;

import android.content.Context;
import com.uptodown.activities.FeedActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10274a;

    /* renamed from: b, reason: collision with root package name */
    public int f10275b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FeedActivity f10276c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c0(FeedActivity feedActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10274a = i10;
        this.f10276c = feedActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10274a) {
            case 0:
                return new c0(this.f10276c, cVar, 0);
            case 1:
                return new c0(this.f10276c, cVar, 1);
            default:
                return new c0(this.f10276c, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10274a) {
            case 0:
                ((c0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 1:
                ((c0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            default:
                return ((c0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f10274a;
        FeedActivity feedActivity = this.f10276c;
        x6.a aVar = x6.a.f13718a;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i11 = this.f10275b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i12 = FeedActivity.L;
                u7.m0 m0Var = feedActivity.o0().f10377b;
                b0 b0Var = new b0(feedActivity);
                this.f10275b = 1;
                m0Var.collect(b0Var, this);
                return aVar;
            case 1:
                int i13 = this.f10275b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i14 = FeedActivity.L;
                u7.m0 m0Var2 = feedActivity.o0().f10379d;
                a3.f1 f1Var = new a3.f1(feedActivity, 2);
                this.f10275b = 1;
                m0Var2.collect(f1Var, this);
                return aVar;
            default:
                int i15 = this.f10275b;
                s6.w wVar = s6.w.f12711a;
                if (i15 == 0) {
                    s6.a.e(obj);
                    c1.w4 w4Var = new c1.w4((Context) feedActivity, (short) 0);
                    this.f10275b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new a6.n(w4Var, cVar, 10), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        return aVar;
                    }
                } else {
                    if (i15 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return wVar;
        }
    }
}
