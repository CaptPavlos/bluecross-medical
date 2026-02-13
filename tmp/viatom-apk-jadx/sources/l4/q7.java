package l4;

import com.uptodown.activities.RepliesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q7 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10766a;

    /* renamed from: b, reason: collision with root package name */
    public int f10767b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f10768c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q7(RepliesActivity repliesActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10766a = i10;
        this.f10768c = repliesActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10766a) {
            case 0:
                return new q7(this.f10768c, cVar, 0);
            case 1:
                return new q7(this.f10768c, cVar, 1);
            case 2:
                return new q7(this.f10768c, cVar, 2);
            case 3:
                return new q7(this.f10768c, cVar, 3);
            default:
                return new q7(this.f10768c, cVar, 4);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10766a) {
            case 0:
                ((q7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 1:
                ((q7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 2:
                ((q7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 3:
                ((q7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((q7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10766a) {
            case 0:
                int i10 = this.f10767b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                RepliesActivity repliesActivity = this.f10768c;
                u7.m0 m0Var = repliesActivity.o0().f11032b;
                p7 p7Var = new p7(repliesActivity);
                this.f10767b = 1;
                m0Var.collect(p7Var, this);
                return x6.a.f13718a;
            case 1:
                int i11 = this.f10767b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                RepliesActivity repliesActivity2 = this.f10768c;
                u7.m0 m0Var2 = repliesActivity2.o0().f11034d;
                r7 r7Var = new r7(repliesActivity2, 0);
                this.f10767b = 1;
                m0Var2.collect(r7Var, this);
                return x6.a.f13718a;
            case 2:
                int i12 = this.f10767b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                RepliesActivity repliesActivity3 = this.f10768c;
                u7.m0 m0Var3 = repliesActivity3.o0().f;
                r7 r7Var2 = new r7(repliesActivity3, 1);
                this.f10767b = 1;
                m0Var3.collect(r7Var2, this);
                return x6.a.f13718a;
            case 3:
                int i13 = this.f10767b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                RepliesActivity repliesActivity4 = this.f10768c;
                u7.m0 m0Var4 = repliesActivity4.o0().h;
                r7 r7Var3 = new r7(repliesActivity4, 2);
                this.f10767b = 1;
                m0Var4.collect(r7Var3, this);
                return x6.a.f13718a;
            default:
                int i14 = this.f10767b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                RepliesActivity repliesActivity5 = this.f10768c;
                u7.m0 m0Var5 = repliesActivity5.o0().f11036j;
                r7 r7Var4 = new r7(repliesActivity5, 3);
                this.f10767b = 1;
                m0Var5.collect(r7Var4, this);
                return x6.a.f13718a;
        }
    }
}
