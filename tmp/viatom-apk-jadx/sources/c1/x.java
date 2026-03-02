package c1;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import com.uptodown.util.views.UsernameTextView;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1556a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1557b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1558c;

    public x(z zVar, long j10) {
        this.f1557b = j10;
        Objects.requireNonNull(zVar);
        this.f1558c = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f1556a;
        long j10 = this.f1557b;
        Object obj = this.f1558c;
        switch (i10) {
            case 0:
                ((z) obj).m(j10);
                break;
            case 1:
                n3 n3Var = (n3) obj;
                z zVar = n3Var.f1149a.f1484n;
                u1.j(zVar);
                zVar.j(j10);
                n3Var.e = null;
                break;
            default:
                UsernameTextView usernameTextView = (UsernameTextView) obj;
                ValueAnimator valueAnimator = usernameTextView.f6729a;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.setDuration(j10);
                valueAnimatorOfFloat.setRepeatCount(1);
                valueAnimatorOfFloat.setRepeatMode(2);
                valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                valueAnimatorOfFloat.addUpdateListener(new com.google.android.material.motion.c(usernameTextView, 3));
                usernameTextView.f6729a = valueAnimatorOfFloat;
                valueAnimatorOfFloat.start();
                Handler animationHandler = usernameTextView.getAnimationHandler();
                if (animationHandler != null) {
                    animationHandler.postDelayed(this, usernameTextView.e);
                    break;
                }
                break;
        }
    }

    public x(n3 n3Var, long j10) {
        this.f1557b = j10;
        Objects.requireNonNull(n3Var);
        this.f1558c = n3Var;
    }

    public x(UsernameTextView usernameTextView, long j10) {
        this.f1558c = usernameTextView;
        this.f1557b = j10;
    }
}
