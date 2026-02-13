package com.mbridge.msdk.video.dynview.h;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {
    private PropertyValuesHolder b(Property property, float f) {
        float f10 = (-2.0f) * f;
        float f11 = f * 2.0f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, f10), Keyframe.ofFloat(0.2f, f10), Keyframe.ofFloat(0.3f, f11), Keyframe.ofFloat(0.4f, f10), Keyframe.ofFloat(0.5f, f11), Keyframe.ofFloat(0.6f, f10), Keyframe.ofFloat(0.7f, f11), Keyframe.ofFloat(0.8f, f10), Keyframe.ofFloat(0.9f, f11), Keyframe.ofFloat(1.0f, 0.0f));
    }

    private PropertyValuesHolder c(Property property, float f) {
        float f10 = f - 0.4f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, f), Keyframe.ofFloat(0.1f, f10), Keyframe.ofFloat(0.2f, f10), Keyframe.ofFloat(0.3f, f), Keyframe.ofFloat(0.4f, f), Keyframe.ofFloat(0.5f, f), Keyframe.ofFloat(0.6f, f), Keyframe.ofFloat(0.7f, f), Keyframe.ofFloat(0.8f, f), Keyframe.ofFloat(0.9f, f), Keyframe.ofFloat(1.0f, f));
    }

    public final void a(final View view, long j10) {
        if (view == null) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = view.getLayoutParams().width == 0 ? ValueAnimator.ofInt(0, iF) : ValueAnimator.ofInt(iF, 0);
        valueAnimatorOfInt.setDuration(j10);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.setLayoutParams(layoutParams);
            }
        });
        ValueAnimator valueAnimatorOfFloat = view.getLayoutParams().width == 0 ? ValueAnimator.ofFloat(0.0f, 1.0f) : ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(j10);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                view.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfFloat);
        animatorSet.start();
    }

    public final void a(final List<View> list, int i10, int i11, long j10) {
        ValueAnimator duration = ValueAnimator.ofInt(i10, i11).setDuration(j10);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                List list2 = list;
                if (list2 == null || list2.size() <= 0) {
                    return;
                }
                for (View view : list) {
                    if (view != null) {
                        view.setPadding(0, 0, 0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        view.requestLayout();
                    }
                }
            }
        });
        duration.start();
    }

    public final void a(final View view, int i10, int i11, int i12, int i13, long j10) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i11);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view2 = view;
                if (view2 != null) {
                    view2.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    view.requestLayout();
                }
            }
        });
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(i12, i13);
        valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view2 = view;
                if (view2 != null) {
                    view2.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    view.requestLayout();
                    if (view.getVisibility() != 0) {
                        view.setVisibility(0);
                    }
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfInt2);
        animatorSet.setDuration(j10);
        animatorSet.start();
    }

    public final void c(View view, long j10) {
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(j10);
        }
    }

    private PropertyValuesHolder a(Property property, float f) {
        float f10 = f - 0.2f;
        float f11 = f + 0.3f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, f), Keyframe.ofFloat(0.1f, f - 0.4f), Keyframe.ofFloat(0.2f, f10), Keyframe.ofFloat(0.3f, f11), Keyframe.ofFloat(0.4f, f10), Keyframe.ofFloat(0.5f, f11), Keyframe.ofFloat(0.6f, f - 0.1f), Keyframe.ofFloat(0.7f, f11), Keyframe.ofFloat(0.8f, f), Keyframe.ofFloat(0.9f, 0.1f + f), Keyframe.ofFloat(1.0f, f));
    }

    public final ObjectAnimator c(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, b(View.ROTATION, 2.0f)).setDuration(1000L);
        duration.setRepeatCount(-1);
        return duration;
    }

    public final void b(final View view, long j10) {
        if (view != null) {
            view.setAlpha(1.0f);
            view.animate().alpha(0.0f).setDuration(j10).setListener(new Animator.AnimatorListener() { // from class: com.mbridge.msdk.video.dynview.h.b.1
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    View view2 = view;
                    if (view2 == null || !(view2 instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) view2).removeAllViews();
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    View view2 = view;
                    if (view2 == null || !(view2 instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) view2).removeAllViews();
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }
            });
        }
    }

    public final ObjectAnimator b(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, c(View.SCALE_X, 1.0f), c(View.SCALE_Y, 1.0f)).setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        duration.setRepeatCount(-1);
        return duration;
    }

    public final ObjectAnimator a(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, a(View.SCALE_X, 1.0f), a(View.SCALE_Y, 1.0f), b(View.ROTATION_X, 5.0f)).setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        duration.setRepeatCount(-1);
        return duration;
    }
}
