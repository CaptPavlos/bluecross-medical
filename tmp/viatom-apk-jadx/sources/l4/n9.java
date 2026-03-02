package l4;

import android.view.animation.Animation;
import com.uptodown.R;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n9 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10662a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Updates f10663b;

    public /* synthetic */ n9(Updates updates, int i10) {
        this.f10662a = i10;
        this.f10663b = updates;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f10662a) {
            case 0:
                break;
            default:
                int i10 = Updates.f6656p0;
                Updates updates = this.f10663b;
                updates.I0().g.setPadding(0, 0, 0, (int) updates.getResources().getDimension(R.dimen.bottom_button_updates_padding));
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i10 = this.f10662a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        switch (this.f10662a) {
            case 0:
                int i10 = Updates.f6656p0;
                this.f10663b.I0().g.setPadding(0, 0, 0, 0);
                break;
        }
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
