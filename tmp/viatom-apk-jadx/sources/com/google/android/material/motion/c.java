package com.google.android.material.motion;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.google.android.material.progressindicator.DeterminateDrawable;
import com.uptodown.util.views.UsernameTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2358a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2359b;

    public /* synthetic */ c(Object obj, int i10) {
        this.f2358a = i10;
        this.f2359b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2358a) {
            case 0:
                MaterialMainContainerBackHelper.lambda$createCornerAnimator$1((ClippableRoundedCornerLayout) this.f2359b, valueAnimator);
                break;
            case 1:
                DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0((DrawerLayout) this.f2359b, valueAnimator);
                break;
            case 2:
                ((DeterminateDrawable) this.f2359b).lambda$maybeInitializeAmplitudeAnimator$1(valueAnimator);
                break;
            case 3:
                UsernameTextView usernameTextView = (UsernameTextView) this.f2359b;
                valueAnimator.getClass();
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                usernameTextView.f6730b = ((Float) animatedValue).floatValue();
                usernameTextView.invalidate();
                break;
            default:
                View view = (View) this.f2359b;
                valueAnimator.getClass();
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                animatedValue2.getClass();
                view.setAlpha(((Float) animatedValue2).floatValue());
                break;
        }
    }
}
