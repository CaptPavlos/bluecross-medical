package e5;

import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x0 implements g5.t, g5.u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7900a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7901b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c1 f7902c;

    public /* synthetic */ x0(Context context, c1 c1Var, int i10) {
        this.f7900a = i10;
        this.f7901b = context;
        this.f7902c = c1Var;
    }

    @Override // g5.t
    public void G() {
        switch (this.f7900a) {
            case 0:
                new t1.c(this.f7901b, 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "added"), "recommended");
                c1 c1Var = this.f7902c;
                com.mbridge.msdk.dycreator.baseview.a.o(1, c1Var.F, null);
                u7.m0 m0Var = c1Var.X;
                Boolean bool = Boolean.FALSE;
                m0Var.getClass();
                m0Var.g(null, bool);
                break;
            default:
                new t1.c(this.f7901b, 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "added"), "wishlist");
                c1 c1Var2 = this.f7902c;
                com.mbridge.msdk.dycreator.baseview.a.o(1, c1Var2.E, null);
                u7.m0 m0Var2 = c1Var2.W;
                Boolean bool2 = Boolean.FALSE;
                m0Var2.getClass();
                m0Var2.g(null, bool2);
                break;
        }
    }

    @Override // g5.u
    public void M() {
        switch (this.f7900a) {
            case 1:
                new t1.c(this.f7901b, 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "removed"), "recommended");
                c1 c1Var = this.f7902c;
                com.mbridge.msdk.dycreator.baseview.a.o(0, c1Var.F, null);
                u7.m0 m0Var = c1Var.X;
                Boolean bool = Boolean.FALSE;
                m0Var.getClass();
                m0Var.g(null, bool);
                break;
            default:
                new t1.c(this.f7901b, 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "removed"), "wishlist");
                c1 c1Var2 = this.f7902c;
                com.mbridge.msdk.dycreator.baseview.a.o(0, c1Var2.E, null);
                u7.m0 m0Var2 = c1Var2.W;
                Boolean bool2 = Boolean.FALSE;
                m0Var2.getClass();
                m0Var2.g(null, bool2);
                break;
        }
    }

    @Override // g5.v
    public final void i() {
        switch (this.f7900a) {
            case 0:
                c1 c1Var = this.f7902c;
                com.mbridge.msdk.dycreator.baseview.a.o(0, c1Var.F, null);
                u7.m0 m0Var = c1Var.X;
                Boolean bool = Boolean.FALSE;
                m0Var.getClass();
                m0Var.g(null, bool);
                break;
            case 1:
                c1 c1Var2 = this.f7902c;
                com.mbridge.msdk.dycreator.baseview.a.o(1, c1Var2.F, null);
                u7.m0 m0Var2 = c1Var2.X;
                Boolean bool2 = Boolean.FALSE;
                m0Var2.getClass();
                m0Var2.g(null, bool2);
                break;
            case 2:
                c1 c1Var3 = this.f7902c;
                com.mbridge.msdk.dycreator.baseview.a.o(0, c1Var3.E, null);
                u7.m0 m0Var3 = c1Var3.W;
                Boolean bool3 = Boolean.FALSE;
                m0Var3.getClass();
                m0Var3.g(null, bool3);
                break;
            default:
                c1 c1Var4 = this.f7902c;
                com.mbridge.msdk.dycreator.baseview.a.o(1, c1Var4.E, null);
                u7.m0 m0Var4 = c1Var4.W;
                Boolean bool4 = Boolean.FALSE;
                m0Var4.getClass();
                m0Var4.g(null, bool4);
                break;
        }
    }
}
