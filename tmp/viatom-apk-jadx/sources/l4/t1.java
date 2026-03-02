package l4;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import com.uptodown.R;
import com.uptodown.activities.LoginActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t1 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10836a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f10837b;

    public /* synthetic */ t1(LoginActivity loginActivity, int i10) {
        this.f10836a = i10;
        this.f10837b = loginActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i10 = this.f10836a;
        LoginActivity loginActivity = this.f10837b;
        animation.getClass();
        switch (i10) {
            case 0:
                int i11 = LoginActivity.P;
                ((LinearLayout) loginActivity.v0().f7402c.f882a).setVisibility(8);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new t1(loginActivity, 3));
                ((LinearLayout) loginActivity.v0().f7403d.f7082b).setVisibility(0);
                ((LinearLayout) loginActivity.v0().f7403d.f7082b).startAnimation(alphaAnimation);
                break;
            case 1:
                int i12 = LoginActivity.P;
                ((LinearLayout) loginActivity.v0().f7403d.f7082b).setVisibility(8);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setInterpolator(new AccelerateInterpolator());
                alphaAnimation2.setDuration(200L);
                alphaAnimation2.setAnimationListener(new t1(loginActivity, 2));
                ((LinearLayout) loginActivity.v0().f7402c.f882a).setVisibility(0);
                ((LinearLayout) loginActivity.v0().f7402c.f882a).startAnimation(alphaAnimation2);
                break;
            case 2:
                int i13 = LoginActivity.P;
                ((LinearLayout) loginActivity.v0().f7402c.f882a).setVisibility(0);
                loginActivity.v0().f.setText(R.string.title_login);
                break;
            default:
                int i14 = LoginActivity.P;
                ((LinearLayout) loginActivity.v0().f7403d.f7082b).setVisibility(0);
                loginActivity.v0().f.setText(R.string.title_sign_up);
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i10 = this.f10836a;
        animation.getClass();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i10 = this.f10836a;
        animation.getClass();
    }
}
