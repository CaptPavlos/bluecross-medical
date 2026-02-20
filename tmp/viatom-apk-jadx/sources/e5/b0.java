package e5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7680a;

    /* renamed from: b, reason: collision with root package name */
    public int f7681b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j0 f7682c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(j0 j0Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7680a = i10;
        this.f7682c = j0Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7680a) {
            case 0:
                return new b0(this.f7682c, cVar, 0);
            case 1:
                return new b0(this.f7682c, cVar, 1);
            case 2:
                return new b0(this.f7682c, cVar, 2);
            case 3:
                return new b0(this.f7682c, cVar, 3);
            case 4:
                return new b0(this.f7682c, cVar, 4);
            case 5:
                return new b0(this.f7682c, cVar, 5);
            case 6:
                return new b0(this.f7682c, cVar, 6);
            case 7:
                return new b0(this.f7682c, cVar, 7);
            case 8:
                return new b0(this.f7682c, cVar, 8);
            case 9:
                return new b0(this.f7682c, cVar, 9);
            case 10:
                return new b0(this.f7682c, cVar, 10);
            case 11:
                return new b0(this.f7682c, cVar, 11);
            case 12:
                return new b0(this.f7682c, cVar, 12);
            case 13:
                return new b0(this.f7682c, cVar, 13);
            case 14:
                return new b0(this.f7682c, cVar, 14);
            case 15:
                return new b0(this.f7682c, cVar, 15);
            case 16:
                return new b0(this.f7682c, cVar, 16);
            default:
                return new b0(this.f7682c, cVar, 17);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7680a) {
            case 0:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 1:
                return ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 2:
                return ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 3:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 4:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 5:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 6:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 7:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 8:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 9:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 10:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 11:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 12:
                return ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 13:
                return ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 14:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 15:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 16:
                return ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            default:
                ((b0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f7680a) {
            case 0:
                int i10 = this.f7681b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var = this.f7682c;
                u7.m0 m0Var = j0Var.G().f7706p;
                a0 a0Var = new a0(j0Var, 0);
                this.f7681b = 1;
                m0Var.collect(a0Var, this);
                return x6.a.f13718a;
            case 1:
                int i11 = this.f7681b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    j0 j0Var2 = this.f7682c;
                    FragmentActivity fragmentActivityRequireActivity = j0Var2.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    w2.r rVar = new w2.r(fragmentActivityRequireActivity, String.valueOf(j0Var2.D().A), j0Var2.D().G, new c0(j0Var2, 0));
                    this.f7681b = 1;
                    Object objX = rVar.x(this);
                    x6.a aVar = x6.a.f13718a;
                    if (objX == aVar) {
                        return aVar;
                    }
                } else {
                    if (i11 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return s6.w.f12711a;
            case 2:
                int i12 = this.f7681b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    this.f7681b = 1;
                    Object objA = j0.a(this.f7682c, this);
                    x6.a aVar2 = x6.a.f13718a;
                    if (objA == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i12 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return s6.w.f12711a;
            case 3:
                int i13 = this.f7681b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var3 = this.f7682c;
                u7.m0 m0Var2 = j0Var3.G().f;
                a0 a0Var2 = new a0(j0Var3, 1);
                this.f7681b = 1;
                m0Var2.collect(a0Var2, this);
                return x6.a.f13718a;
            case 4:
                int i14 = this.f7681b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var4 = this.f7682c;
                u7.m0 m0Var3 = j0Var4.G().f7704n;
                a0 a0Var3 = new a0(j0Var4, 2);
                this.f7681b = 1;
                m0Var3.collect(a0Var3, this);
                return x6.a.f13718a;
            case 5:
                int i15 = this.f7681b;
                if (i15 != 0) {
                    if (i15 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var5 = this.f7682c;
                u7.m0 m0Var4 = j0Var5.G().h;
                a0 a0Var4 = new a0(j0Var5, 3);
                this.f7681b = 1;
                m0Var4.collect(a0Var4, this);
                return x6.a.f13718a;
            case 6:
                int i16 = this.f7681b;
                if (i16 != 0) {
                    if (i16 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var6 = this.f7682c;
                u7.m0 m0Var5 = j0Var6.G().f7696b;
                a0 a0Var5 = new a0(j0Var6, 4);
                this.f7681b = 1;
                m0Var5.collect(a0Var5, this);
                return x6.a.f13718a;
            case 7:
                int i17 = this.f7681b;
                if (i17 != 0) {
                    if (i17 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var7 = this.f7682c;
                u7.m0 m0Var6 = j0Var7.G().f7698d;
                a0 a0Var6 = new a0(j0Var7, 5);
                this.f7681b = 1;
                m0Var6.collect(a0Var6, this);
                return x6.a.f13718a;
            case 8:
                int i18 = this.f7681b;
                if (i18 != 0) {
                    if (i18 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var8 = this.f7682c;
                u7.m0 m0Var7 = j0Var8.G().f7700j;
                a0 a0Var7 = new a0(j0Var8, 6);
                this.f7681b = 1;
                m0Var7.collect(a0Var7, this);
                return x6.a.f13718a;
            case 9:
                int i19 = this.f7681b;
                if (i19 != 0) {
                    if (i19 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var9 = this.f7682c;
                u7.m0 m0Var8 = j0Var9.G().f7702l;
                a0 a0Var8 = new a0(j0Var9, 7);
                this.f7681b = 1;
                m0Var8.collect(a0Var8, this);
                return x6.a.f13718a;
            case 10:
                int i20 = this.f7681b;
                if (i20 != 0) {
                    if (i20 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var10 = this.f7682c;
                u7.m0 m0Var9 = j0Var10.G().B;
                a0 a0Var9 = new a0(j0Var10, 8);
                this.f7681b = 1;
                m0Var9.collect(a0Var9, this);
                return x6.a.f13718a;
            case 11:
                int i21 = this.f7681b;
                if (i21 != 0) {
                    if (i21 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var11 = this.f7682c;
                u7.m0 m0Var10 = j0Var11.G().f7714z;
                a0 a0Var10 = new a0(j0Var11, 9);
                this.f7681b = 1;
                m0Var10.collect(a0Var10, this);
                return x6.a.f13718a;
            case 12:
                int i22 = this.f7681b;
                if (i22 == 0) {
                    s6.a.e(obj);
                    j0 j0Var12 = this.f7682c;
                    FragmentActivity fragmentActivityRequireActivity2 = j0Var12.requireActivity();
                    fragmentActivityRequireActivity2.getClass();
                    w2.r rVar2 = new w2.r(fragmentActivityRequireActivity2, String.valueOf(j0Var12.D().A), j0Var12.D().G, new w(j0Var12, 5));
                    this.f7681b = 1;
                    Object objX2 = rVar2.x(this);
                    x6.a aVar3 = x6.a.f13718a;
                    if (objX2 == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i22 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return s6.w.f12711a;
            case 13:
                int i23 = this.f7681b;
                if (i23 == 0) {
                    s6.a.e(obj);
                    j0 j0Var13 = this.f7682c;
                    FragmentActivity fragmentActivityRequireActivity3 = j0Var13.requireActivity();
                    fragmentActivityRequireActivity3.getClass();
                    w2.r rVar3 = new w2.r(fragmentActivityRequireActivity3, String.valueOf(j0Var13.D().A), j0Var13.D().G, new c0(j0Var13, 5));
                    this.f7681b = 1;
                    Object objX3 = rVar3.x(this);
                    x6.a aVar4 = x6.a.f13718a;
                    if (objX3 == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i23 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return s6.w.f12711a;
            case 14:
                int i24 = this.f7681b;
                if (i24 != 0) {
                    if (i24 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var14 = this.f7682c;
                u7.m0 m0Var11 = j0Var14.G().F;
                a0 a0Var11 = new a0(j0Var14, 10);
                this.f7681b = 1;
                m0Var11.collect(a0Var11, this);
                return x6.a.f13718a;
            case 15:
                int i25 = this.f7681b;
                if (i25 != 0) {
                    if (i25 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var15 = this.f7682c;
                u7.m0 m0Var12 = j0Var15.G().t;
                a0 a0Var12 = new a0(j0Var15, 11);
                this.f7681b = 1;
                m0Var12.collect(a0Var12, this);
                return x6.a.f13718a;
            case 16:
                int i26 = this.f7681b;
                if (i26 == 0) {
                    s6.a.e(obj);
                    j0 j0Var16 = this.f7682c;
                    Context contextRequireContext = j0Var16.requireContext();
                    contextRequireContext.getClass();
                    w2.r rVar4 = new w2.r(contextRequireContext, j0Var16.D(), null, null, 7);
                    this.f7681b = 1;
                    Object objG = rVar4.G(this);
                    x6.a aVar5 = x6.a.f13718a;
                    if (objG == aVar5) {
                        return aVar5;
                    }
                } else {
                    if (i26 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return s6.w.f12711a;
            default:
                int i27 = this.f7681b;
                if (i27 != 0) {
                    if (i27 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                j0 j0Var17 = this.f7682c;
                u7.m0 m0Var13 = j0Var17.G().E;
                a0 a0Var13 = new a0(j0Var17, 12);
                this.f7681b = 1;
                m0Var13.collect(a0Var13, this);
                return x6.a.f13718a;
        }
    }
}
