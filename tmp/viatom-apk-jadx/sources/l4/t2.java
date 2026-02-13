package l4;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.uptodown.R;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t2 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10838a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f10839b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10840c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10841d;

    public t2(w wVar, z5.d dVar, e5.d0 d0Var) {
        this.f10839b = wVar;
        this.f10840c = dVar;
        this.f10841d = d0Var;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f10838a) {
            case 0:
                new Handler(Looper.getMainLooper()).postDelayed(new androidx.work.impl.e((ImageView) this.f10839b, (Animation) this.f10841d, (ImageView) this.f10840c, animation, 1), 1500L);
                return;
            default:
                z5.d dVar = (z5.d) this.f10840c;
                RelativeLayout relativeLayout = dVar.e;
                if (relativeLayout == null) {
                    kotlin.jvm.internal.l.i("rlAppInfoSelected");
                    throw null;
                }
                relativeLayout.setVisibility(8);
                dVar.f14414b.setVisibility(8);
                dVar.f14424p.set(false);
                return;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i10 = this.f10838a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) throws Resources.NotFoundException {
        switch (this.f10838a) {
            case 0:
                return;
            default:
                w wVar = (w) this.f10839b;
                wVar.getClass();
                View view = ((z5.d) this.f10840c).f14416d;
                if (view == null) {
                    kotlin.jvm.internal.l.i("vBackground");
                    throw null;
                }
                e5.d0 d0Var = (e5.d0) this.f10841d;
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(wVar, R.anim.fade_out);
                float f = UptodownApp.E;
                boolean z9 = true;
                try {
                    SharedPreferences sharedPreferences = wVar.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("animations")) {
                        z9 = sharedPreferences.getBoolean("animations", true);
                    }
                } catch (Exception unused) {
                }
                if (!z9) {
                    d0Var.onAnimationEnd(animationLoadAnimation);
                    return;
                }
                float f10 = UptodownApp.E;
                animationLoadAnimation.setAnimationListener(d0Var);
                view.startAnimation(animationLoadAnimation);
                return;
        }
    }

    public t2(ImageView imageView, Animation animation, ImageView imageView2) {
        this.f10839b = imageView;
        this.f10841d = animation;
        this.f10840c = imageView2;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }
}
