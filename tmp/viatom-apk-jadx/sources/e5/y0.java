package e5;

import android.content.Context;
import c1.w4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7906a;

    /* renamed from: b, reason: collision with root package name */
    public int f7907b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c1 f7908c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f7909d;
    public final /* synthetic */ long e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y0(int i10, long j10, Context context, c1 c1Var, w6.c cVar) {
        super(2, cVar);
        this.f7906a = i10;
        this.f7908c = c1Var;
        this.f7909d = context;
        this.e = j10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7906a) {
            case 0:
                return new y0(0, this.e, this.f7909d, this.f7908c, cVar);
            case 1:
                return new y0(1, this.e, this.f7909d, this.f7908c, cVar);
            case 2:
                return new y0(2, this.e, this.f7909d, this.f7908c, cVar);
            default:
                return new y0(3, this.e, this.f7909d, this.f7908c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7906a) {
        }
        return ((y0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f7906a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        Context context = this.f7909d;
        c1 c1Var = this.f7908c;
        switch (i10) {
            case 0:
                u7.m0 m0Var = c1Var.X;
                int i11 = this.f7907b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    x0 x0Var = new x0(context, c1Var, 0);
                    if (!((Boolean) m0Var.getValue()).booleanValue()) {
                        Boolean bool = Boolean.TRUE;
                        m0Var.getClass();
                        m0Var.g(null, bool);
                        w4 w4Var = new w4(context, (short) 0);
                        this.f7907b = 1;
                        y7.e eVar = r7.i0.f12407a;
                        Object objZ = r7.y.z(new c5.e0(w4Var, this.e, x0Var, (w6.c) null, 0), y7.d.f14116a, this);
                        if (objZ != aVar) {
                            objZ = wVar;
                        }
                        if (objZ == aVar) {
                            break;
                        }
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            case 1:
                u7.m0 m0Var2 = c1Var.X;
                int i12 = this.f7907b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    x0 x0Var2 = new x0(context, c1Var, 1);
                    if (!((Boolean) m0Var2.getValue()).booleanValue()) {
                        Boolean bool2 = Boolean.TRUE;
                        m0Var2.getClass();
                        m0Var2.g(null, bool2);
                        w4 w4Var2 = new w4(context, (short) 0);
                        this.f7907b = 1;
                        y7.e eVar2 = r7.i0.f12407a;
                        Object objZ2 = r7.y.z(new c5.e0(w4Var2, this.e, x0Var2, (w6.c) null, 1), y7.d.f14116a, this);
                        if (objZ2 != aVar) {
                            objZ2 = wVar;
                        }
                        if (objZ2 == aVar) {
                            break;
                        }
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            case 2:
                u7.m0 m0Var3 = c1Var.W;
                int i13 = this.f7907b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    x0 x0Var3 = new x0(context, c1Var, 2);
                    if (!((Boolean) m0Var3.getValue()).booleanValue()) {
                        Boolean bool3 = Boolean.TRUE;
                        m0Var3.getClass();
                        m0Var3.g(null, bool3);
                        c5.b0 b0Var = new c5.b0(context, false);
                        this.f7907b = 1;
                        y7.e eVar3 = r7.i0.f12407a;
                        Object objZ3 = r7.y.z(new c5.e0(b0Var, this.e, x0Var3, (w6.c) null, 2), y7.d.f14116a, this);
                        if (objZ3 != aVar) {
                            objZ3 = wVar;
                        }
                        if (objZ3 == aVar) {
                            break;
                        }
                    }
                } else if (i13 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                u7.m0 m0Var4 = c1Var.W;
                int i14 = this.f7907b;
                if (i14 == 0) {
                    s6.a.e(obj);
                    x0 x0Var4 = new x0(context, c1Var, 3);
                    if (!((Boolean) m0Var4.getValue()).booleanValue()) {
                        Boolean bool4 = Boolean.TRUE;
                        m0Var4.getClass();
                        m0Var4.g(null, bool4);
                        c5.b0 b0Var2 = new c5.b0(context, false);
                        this.f7907b = 1;
                        if (b0Var2.b(this.e, x0Var4, this) == aVar) {
                            break;
                        }
                    }
                } else if (i14 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
        }
        return aVar;
    }
}
