package e5;

import android.content.Context;
import c1.w4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7802a;

    /* renamed from: b, reason: collision with root package name */
    public int f7803b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m1 f7804c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k1(m1 m1Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7802a = i10;
        this.f7804c = m1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7802a) {
            case 0:
                return new k1(this.f7804c, cVar, 0);
            case 1:
                return new k1(this.f7804c, cVar, 1);
            default:
                return new k1(this.f7804c, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7802a) {
            case 0:
                break;
            case 1:
                ((k1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((k1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f7802a;
        x6.a aVar = x6.a.f13718a;
        m1 m1Var = this.f7804c;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i11 = this.f7803b;
                s6.w wVar = s6.w.f12711a;
                if (i11 == 0) {
                    s6.a.e(obj);
                    Context contextRequireContext = m1Var.requireContext();
                    contextRequireContext.getClass();
                    w4 w4Var = new w4(contextRequireContext, (short) 0);
                    this.f7803b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new a6.n(w4Var, cVar, 10), y7.d.f14116a, this);
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
            case 1:
                int i12 = this.f7803b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                u7.m0 m0Var = m1Var.b().f10377b;
                l1 l1Var = new l1(m1Var);
                this.f7803b = 1;
                m0Var.collect(l1Var, this);
                return aVar;
            default:
                int i13 = this.f7803b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                u7.m0 m0Var2 = m1Var.b().f10379d;
                a3.f1 f1Var = new a3.f1(m1Var, 1);
                this.f7803b = 1;
                m0Var2.collect(f1Var, this);
                return aVar;
        }
    }
}
