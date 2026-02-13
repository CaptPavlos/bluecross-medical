package e5;

import android.view.View;
import android.view.animation.Animation;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7721a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7722b;

    public /* synthetic */ d0(Object obj, int i10) {
        this.f7721a = i10;
        this.f7722b = obj;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f7721a) {
            case 0:
                j0 j0Var = (j0) this.f7722b;
                d5.b bVar = j0Var.f7785b;
                bVar.getClass();
                bVar.e.removeAllViews();
                j0Var.G().V.set(false);
                return;
            default:
                View view = ((z5.d) this.f7722b).f14416d;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                } else {
                    kotlin.jvm.internal.l.i("vBackground");
                    throw null;
                }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i10 = this.f7721a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i10 = this.f7721a;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }
}
