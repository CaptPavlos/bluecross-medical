package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class SlideKitkat extends Visibility {
    private static final String TAG = "SlideKitkat";
    private CalculateSlide mSlideCalculator;
    private int mSlideEdge;
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    private static final CalculateSlide sCalculateLeft = new CalculateSlideHorizontal() { // from class: androidx.leanback.transition.SlideKitkat.1
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getTranslationX() - view.getWidth();
        }
    };
    private static final CalculateSlide sCalculateTop = new CalculateSlideVertical() { // from class: androidx.leanback.transition.SlideKitkat.2
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getTranslationY() - view.getHeight();
        }
    };
    private static final CalculateSlide sCalculateRight = new CalculateSlideHorizontal() { // from class: androidx.leanback.transition.SlideKitkat.3
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getTranslationX() + view.getWidth();
        }
    };
    private static final CalculateSlide sCalculateBottom = new CalculateSlideVertical() { // from class: androidx.leanback.transition.SlideKitkat.4
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getTranslationY() + view.getHeight();
        }
    };
    private static final CalculateSlide sCalculateStart = new CalculateSlideHorizontal() { // from class: androidx.leanback.transition.SlideKitkat.5
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getLayoutDirection() == 1 ? view.getTranslationX() + view.getWidth() : view.getTranslationX() - view.getWidth();
        }
    };
    private static final CalculateSlide sCalculateEnd = new CalculateSlideHorizontal() { // from class: androidx.leanback.transition.SlideKitkat.6
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getLayoutDirection() == 1 ? view.getTranslationX() - view.getWidth() : view.getTranslationX() + view.getWidth();
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface CalculateSlide {
        float getGone(View view);

        float getHere(View view);

        Property<View, Float> getProperty();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class CalculateSlideHorizontal implements CalculateSlide {
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getHere(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public Property<View, Float> getProperty() {
            return View.TRANSLATION_X;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class CalculateSlideVertical implements CalculateSlide {
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getHere(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public Property<View, Float> getProperty() {
            return View.TRANSLATION_Y;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SlideAnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;
        private final float mEndValue;
        private final int mFinalVisibility;
        private float mPausedValue;
        private final Property<View, Float> mProp;
        private final float mTerminalValue;
        private final View mView;

        public SlideAnimatorListener(View view, Property<View, Float> property, float f, float f10, int i10) {
            this.mProp = property;
            this.mView = view;
            this.mTerminalValue = f;
            this.mEndValue = f10;
            this.mFinalVisibility = i10;
            view.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mView.setTag(R.id.lb_slide_transition_value, new float[]{this.mView.getTranslationX(), this.mView.getTranslationY()});
            this.mProp.set(this.mView, Float.valueOf(this.mTerminalValue));
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.mCanceled) {
                this.mProp.set(this.mView, Float.valueOf(this.mTerminalValue));
            }
            this.mView.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.mPausedValue = this.mProp.get(this.mView).floatValue();
            this.mProp.set(this.mView, Float.valueOf(this.mEndValue));
            this.mView.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.mProp.set(this.mView, Float.valueOf(this.mPausedValue));
            this.mView.setVisibility(0);
        }
    }

    public SlideKitkat(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(typedArrayObtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, 80));
        long j10 = typedArrayObtainStyledAttributes.getInt(R.styleable.lbSlide_android_duration, -1);
        if (j10 >= 0) {
            setDuration(j10);
        }
        long j11 = typedArrayObtainStyledAttributes.getInt(R.styleable.lbSlide_android_startDelay, -1);
        if (j11 > 0) {
            setStartDelay(j11);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.lbSlide_android_interpolator, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private Animator createAnimation(View view, Property<View, Float> property, float f, float f10, float f11, TimeInterpolator timeInterpolator, int i10) {
        int i11 = R.id.lb_slide_transition_value;
        float[] fArr = (float[]) view.getTag(i11);
        if (fArr != null) {
            f = View.TRANSLATION_Y == property ? fArr[1] : fArr[0];
            view.setTag(i11, null);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, property, f, f10);
        SlideAnimatorListener slideAnimatorListener = new SlideAnimatorListener(view, property, f11, f10, i10);
        objectAnimatorOfFloat.addListener(slideAnimatorListener);
        objectAnimatorOfFloat.addPauseListener(slideAnimatorListener);
        objectAnimatorOfFloat.setInterpolator(timeInterpolator);
        return objectAnimatorOfFloat;
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i10, TransitionValues transitionValues2, int i11) {
        View view = transitionValues2 != null ? transitionValues2.view : null;
        if (view == null) {
            return null;
        }
        float here = this.mSlideCalculator.getHere(view);
        return createAnimation(view, this.mSlideCalculator.getProperty(), this.mSlideCalculator.getGone(view), here, here, sDecelerate, 0);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i10, TransitionValues transitionValues2, int i11) {
        View view = transitionValues != null ? transitionValues.view : null;
        if (view == null) {
            return null;
        }
        float here = this.mSlideCalculator.getHere(view);
        return createAnimation(view, this.mSlideCalculator.getProperty(), here, this.mSlideCalculator.getGone(view), here, sAccelerate, 4);
    }

    public void setSlideEdge(int i10) {
        if (i10 == 3) {
            this.mSlideCalculator = sCalculateLeft;
        } else if (i10 == 5) {
            this.mSlideCalculator = sCalculateRight;
        } else if (i10 == 48) {
            this.mSlideCalculator = sCalculateTop;
        } else if (i10 == 80) {
            this.mSlideCalculator = sCalculateBottom;
        } else if (i10 == 8388611) {
            this.mSlideCalculator = sCalculateStart;
        } else {
            if (i10 != 8388613) {
                a.n("Invalid slide direction");
                return;
            }
            this.mSlideCalculator = sCalculateEnd;
        }
        this.mSlideEdge = i10;
    }

    public SlideKitkat() {
        setSlideEdge(80);
    }
}
