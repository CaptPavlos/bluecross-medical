package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @Px
    private int slideDistance = -1;
    private int slideEdge;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i10) {
        this.slideEdge = i10;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i10, @Px int i11) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i10 == 3) {
            return createTranslationXAnimator(view2, i11 + translationX, translationX, translationX);
        }
        if (i10 == 5) {
            return createTranslationXAnimator(view2, translationX - i11, translationX, translationX);
        }
        if (i10 == 48) {
            return createTranslationYAnimator(view2, translationY - i11, translationY, translationY);
        }
        if (i10 == 80) {
            return createTranslationYAnimator(view2, i11 + translationY, translationY, translationY);
        }
        if (i10 == 8388611) {
            return createTranslationXAnimator(view2, isRtl(view) ? i11 + translationX : translationX - i11, translationX, translationX);
        }
        if (i10 == 8388613) {
            return createTranslationXAnimator(view2, isRtl(view) ? translationX - i11 : i11 + translationX, translationX, translationX);
        }
        com.google.gson.internal.a.n(a3.a.f(i10, "Invalid slide direction: "));
        return null;
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i10, @Px int i11) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i10 == 3) {
            return createTranslationXAnimator(view2, translationX, translationX - i11, translationX);
        }
        if (i10 == 5) {
            return createTranslationXAnimator(view2, translationX, i11 + translationX, translationX);
        }
        if (i10 == 48) {
            return createTranslationYAnimator(view2, translationY, i11 + translationY, translationY);
        }
        if (i10 == 80) {
            return createTranslationYAnimator(view2, translationY, translationY - i11, translationY);
        }
        if (i10 == 8388611) {
            return createTranslationXAnimator(view2, translationX, isRtl(view) ? translationX - i11 : i11 + translationX, translationX);
        }
        if (i10 == 8388613) {
            return createTranslationXAnimator(view2, translationX, isRtl(view) ? i11 + translationX : translationX - i11, translationX);
        }
        com.google.gson.internal.a.n(a3.a.f(i10, "Invalid slide direction: "));
        return null;
    }

    private static Animator createTranslationXAnimator(final View view, float f, float f10, final float f11) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f, f10));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f11);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(final View view, float f, float f10, final float f11) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f, f10));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f11);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i10 = this.slideDistance;
        return i10 != -1 ? i10 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        return view.getLayoutDirection() == 1;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i10) {
        if (i10 >= 0) {
            this.slideDistance = i10;
        } else {
            com.google.gson.internal.a.n("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
    }

    public void setSlideEdge(int i10) {
        this.slideEdge = i10;
    }
}
