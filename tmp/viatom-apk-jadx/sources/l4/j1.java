package l4;

import com.uptodown.activities.ListsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10512a;

    /* renamed from: b, reason: collision with root package name */
    public int f10513b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ListsActivity f10514c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j1(ListsActivity listsActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10512a = i10;
        this.f10514c = listsActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10512a) {
            case 0:
                return new j1(this.f10514c, cVar, 0);
            case 1:
                return new j1(this.f10514c, cVar, 1);
            case 2:
                return new j1(this.f10514c, cVar, 2);
            default:
                return new j1(this.f10514c, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10512a) {
            case 0:
                ((j1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 1:
                ((j1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 2:
                ((j1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((j1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10512a;
        x6.a aVar = x6.a.f13718a;
        ListsActivity listsActivity = this.f10514c;
        switch (i10) {
            case 0:
                int i11 = this.f10513b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i12 = ListsActivity.K;
                u7.m0 m0Var = listsActivity.p0().f10706b;
                i1 i1Var = new i1(listsActivity, 0);
                this.f10513b = 1;
                m0Var.collect(i1Var, this);
                return aVar;
            case 1:
                int i13 = this.f10513b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i14 = ListsActivity.K;
                u7.m0 m0Var2 = listsActivity.p0().e;
                i1 i1Var2 = new i1(listsActivity, 1);
                this.f10513b = 1;
                m0Var2.collect(i1Var2, this);
                return aVar;
            case 2:
                int i15 = this.f10513b;
                if (i15 != 0) {
                    if (i15 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i16 = ListsActivity.K;
                u7.m0 m0Var3 = listsActivity.p0().h;
                i1 i1Var3 = new i1(listsActivity, 2);
                this.f10513b = 1;
                m0Var3.collect(i1Var3, this);
                return aVar;
            default:
                int i17 = this.f10513b;
                if (i17 != 0) {
                    if (i17 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i18 = ListsActivity.K;
                u7.m0 m0Var4 = listsActivity.p0().f10711k;
                i1 i1Var4 = new i1(listsActivity, 3);
                this.f10513b = 1;
                m0Var4.collect(i1Var4, this);
                return aVar;
        }
    }
}
