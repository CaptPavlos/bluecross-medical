package l4;

import com.uptodown.activities.ReviewsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d8 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10332a;

    /* renamed from: b, reason: collision with root package name */
    public int f10333b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f10334c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d8(ReviewsActivity reviewsActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10332a = i10;
        this.f10334c = reviewsActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10332a) {
            case 0:
                return new d8(this.f10334c, cVar, 0);
            case 1:
                return new d8(this.f10334c, cVar, 1);
            case 2:
                return new d8(this.f10334c, cVar, 2);
            default:
                return new d8(this.f10334c, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10332a) {
            case 0:
                ((d8) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 1:
                ((d8) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 2:
                ((d8) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((d8) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10332a;
        x6.a aVar = x6.a.f13718a;
        ReviewsActivity reviewsActivity = this.f10334c;
        switch (i10) {
            case 0:
                int i11 = this.f10333b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i12 = ReviewsActivity.M;
                u7.m0 m0Var = reviewsActivity.p0().f10557b;
                c8 c8Var = new c8(reviewsActivity);
                this.f10333b = 1;
                m0Var.collect(c8Var, this);
                return aVar;
            case 1:
                int i13 = this.f10333b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i14 = ReviewsActivity.M;
                u7.m0 m0Var2 = reviewsActivity.p0().f10559d;
                e8 e8Var = new e8(reviewsActivity, 0);
                this.f10333b = 1;
                m0Var2.collect(e8Var, this);
                return aVar;
            case 2:
                int i15 = this.f10333b;
                if (i15 != 0) {
                    if (i15 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i16 = ReviewsActivity.M;
                u7.m0 m0Var3 = reviewsActivity.p0().f;
                e8 e8Var2 = new e8(reviewsActivity, 1);
                this.f10333b = 1;
                m0Var3.collect(e8Var2, this);
                return aVar;
            default:
                int i17 = this.f10333b;
                if (i17 != 0) {
                    if (i17 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i18 = ReviewsActivity.M;
                u7.m0 m0Var4 = reviewsActivity.p0().h;
                e8 e8Var3 = new e8(reviewsActivity, 2);
                this.f10333b = 1;
                m0Var4.collect(e8Var3, this);
                return aVar;
        }
    }
}
