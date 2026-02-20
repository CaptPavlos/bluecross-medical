package l4;

import com.uptodown.activities.FreeUpSpaceActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10702a;

    /* renamed from: b, reason: collision with root package name */
    public int f10703b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FreeUpSpaceActivity f10704c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(FreeUpSpaceActivity freeUpSpaceActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10702a = i10;
        this.f10704c = freeUpSpaceActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10702a) {
            case 0:
                return new p0(this.f10704c, cVar, 0);
            default:
                return new p0(this.f10704c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10702a) {
            case 0:
                return ((p0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            default:
                ((p0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f10702a;
        x6.a aVar = x6.a.f13718a;
        FreeUpSpaceActivity freeUpSpaceActivity = this.f10704c;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i11 = this.f10703b;
                s6.w wVar = s6.w.f12711a;
                if (i11 == 0) {
                    s6.a.e(obj);
                    o0 o0Var = new o0(freeUpSpaceActivity, cVar, 0);
                    this.f10703b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new c5.a(freeUpSpaceActivity, o0Var, null), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        return aVar;
                    }
                } else {
                    if (i11 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return wVar;
            default:
                int i12 = this.f10703b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i13 = FreeUpSpaceActivity.M;
                u7.m0 m0Var = ((v0) freeUpSpaceActivity.I.getValue()).f10899b;
                a3.f1 f1Var = new a3.f1(freeUpSpaceActivity, 4);
                this.f10703b = 1;
                m0Var.collect(f1Var, this);
                return aVar;
        }
    }
}
