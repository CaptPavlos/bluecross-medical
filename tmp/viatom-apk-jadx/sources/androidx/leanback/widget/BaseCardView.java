package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class BaseCardView extends FrameLayout {
    public static final int CARD_REGION_VISIBLE_ACTIVATED = 1;
    public static final int CARD_REGION_VISIBLE_ALWAYS = 0;
    public static final int CARD_REGION_VISIBLE_SELECTED = 2;
    public static final int CARD_TYPE_INFO_OVER = 1;
    public static final int CARD_TYPE_INFO_UNDER = 2;
    public static final int CARD_TYPE_INFO_UNDER_WITH_EXTRA = 3;
    private static final int CARD_TYPE_INVALID = 4;
    public static final int CARD_TYPE_MAIN_ONLY = 0;
    private static final boolean DEBUG = false;
    private static final int[] LB_PRESSED_STATE_SET = {android.R.attr.state_pressed};
    private static final String TAG = "BaseCardView";
    private final int mActivatedAnimDuration;
    private Animation mAnim;
    private final Runnable mAnimationTrigger;
    private int mCardType;
    private boolean mDelaySelectedAnim;
    ArrayList<View> mExtraViewList;
    private int mExtraVisibility;
    float mInfoAlpha;
    float mInfoOffset;
    ArrayList<View> mInfoViewList;
    float mInfoVisFraction;
    private int mInfoVisibility;
    private ArrayList<View> mMainViewList;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private final int mSelectedAnimDuration;
    private int mSelectedAnimationDelay;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class AnimationBase extends Animation {
        public AnimationBase() {
        }

        @VisibleForTesting
        public final void mockEnd() {
            applyTransformation(1.0f, null);
            BaseCardView.this.cancelAnimations();
        }

        @VisibleForTesting
        public final void mockStart() {
            getTransformation(0L, null);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class InfoAlphaAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoAlphaAnimation(float f, float f10) {
            super();
            this.mStartValue = f;
            this.mDelta = f10 - f;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            BaseCardView.this.mInfoAlpha = (f * this.mDelta) + this.mStartValue;
            for (int i10 = 0; i10 < BaseCardView.this.mInfoViewList.size(); i10++) {
                BaseCardView.this.mInfoViewList.get(i10).setAlpha(BaseCardView.this.mInfoAlpha);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class InfoHeightAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoHeightAnimation(float f, float f10) {
            super();
            this.mStartValue = f;
            this.mDelta = f10 - f;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            BaseCardView baseCardView = BaseCardView.this;
            baseCardView.mInfoVisFraction = (f * this.mDelta) + this.mStartValue;
            baseCardView.requestLayout();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class InfoOffsetAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoOffsetAnimation(float f, float f10) {
            super();
            this.mStartValue = f;
            this.mDelta = f10 - f;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            BaseCardView baseCardView = BaseCardView.this;
            baseCardView.mInfoOffset = (f * this.mDelta) + this.mStartValue;
            baseCardView.requestLayout();
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    public BaseCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAnimationTrigger = new Runnable() { // from class: androidx.leanback.widget.BaseCardView.1
            @Override // java.lang.Runnable
            public void run() {
                BaseCardView.this.animateInfoOffset(true);
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbBaseCardView, i10, 0);
        try {
            this.mCardType = typedArrayObtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_cardType, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbBaseCardView_cardForeground);
            if (drawable != null) {
                setForeground(drawable);
            }
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbBaseCardView_cardBackground);
            if (drawable2 != null) {
                setBackground(drawable2);
            }
            this.mInfoVisibility = typedArrayObtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_infoVisibility, 1);
            int integer = typedArrayObtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_extraVisibility, 2);
            this.mExtraVisibility = integer;
            int i11 = this.mInfoVisibility;
            if (integer < i11) {
                this.mExtraVisibility = i11;
            }
            this.mSelectedAnimationDelay = typedArrayObtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_selectedAnimationDelay, getResources().getInteger(androidx.leanback.R.integer.lb_card_selected_animation_delay));
            this.mSelectedAnimDuration = typedArrayObtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_selectedAnimationDuration, getResources().getInteger(androidx.leanback.R.integer.lb_card_selected_animation_duration));
            this.mActivatedAnimDuration = typedArrayObtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_activatedAnimationDuration, getResources().getInteger(androidx.leanback.R.integer.lb_card_activated_animation_duration));
            typedArrayObtainStyledAttributes.recycle();
            this.mDelaySelectedAnim = true;
            this.mMainViewList = new ArrayList<>();
            this.mInfoViewList = new ArrayList<>();
            this.mExtraViewList = new ArrayList<>();
            this.mInfoOffset = 0.0f;
            this.mInfoVisFraction = getFinalInfoVisFraction();
            this.mInfoAlpha = getFinalInfoAlpha();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void animateInfoAlpha(boolean z9) {
        cancelAnimations();
        if (z9) {
            for (int i10 = 0; i10 < this.mInfoViewList.size(); i10++) {
                this.mInfoViewList.get(i10).setVisibility(0);
            }
        }
        if ((z9 ? 1.0f : 0.0f) == this.mInfoAlpha) {
            return;
        }
        InfoAlphaAnimation infoAlphaAnimation = new InfoAlphaAnimation(this.mInfoAlpha, z9 ? 1.0f : 0.0f);
        this.mAnim = infoAlphaAnimation;
        infoAlphaAnimation.setDuration(this.mActivatedAnimDuration);
        this.mAnim.setInterpolator(new DecelerateInterpolator());
        this.mAnim.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.leanback.widget.BaseCardView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (BaseCardView.this.mInfoAlpha == 0.0d) {
                    for (int i11 = 0; i11 < BaseCardView.this.mInfoViewList.size(); i11++) {
                        BaseCardView.this.mInfoViewList.get(i11).setVisibility(8);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(this.mAnim);
    }

    private void animateInfoHeight(boolean z9) {
        cancelAnimations();
        if (z9) {
            for (int i10 = 0; i10 < this.mInfoViewList.size(); i10++) {
                this.mInfoViewList.get(i10).setVisibility(0);
            }
        }
        float f = z9 ? 1.0f : 0.0f;
        if (this.mInfoVisFraction == f) {
            return;
        }
        InfoHeightAnimation infoHeightAnimation = new InfoHeightAnimation(this.mInfoVisFraction, f);
        this.mAnim = infoHeightAnimation;
        infoHeightAnimation.setDuration(this.mSelectedAnimDuration);
        this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnim.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.leanback.widget.BaseCardView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (BaseCardView.this.mInfoVisFraction == 0.0f) {
                    for (int i11 = 0; i11 < BaseCardView.this.mInfoViewList.size(); i11++) {
                        BaseCardView.this.mInfoViewList.get(i11).setVisibility(8);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(this.mAnim);
    }

    private void applyActiveState() {
        int i10;
        if (hasInfoRegion() && (i10 = this.mInfoVisibility) == 1) {
            setInfoViewVisibility(isRegionVisible(i10));
        }
    }

    private void applySelectedState(boolean z9) {
        removeCallbacks(this.mAnimationTrigger);
        if (this.mCardType != 3) {
            if (this.mInfoVisibility == 2) {
                setInfoViewVisibility(z9);
            }
        } else {
            if (!z9) {
                animateInfoOffset(false);
                return;
            }
            boolean z10 = this.mDelaySelectedAnim;
            Runnable runnable = this.mAnimationTrigger;
            if (z10) {
                postDelayed(runnable, this.mSelectedAnimationDelay);
            } else {
                post(runnable);
                this.mDelaySelectedAnim = true;
            }
        }
    }

    private void findChildrenViews() {
        this.mMainViewList.clear();
        this.mInfoViewList.clear();
        this.mExtraViewList.clear();
        int childCount = getChildCount();
        boolean z9 = hasInfoRegion() && isCurrentRegionVisible(this.mInfoVisibility);
        boolean z10 = hasExtraRegion() && this.mInfoOffset > 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null) {
                int i11 = ((LayoutParams) childAt.getLayoutParams()).viewType;
                if (i11 == 1) {
                    childAt.setAlpha(this.mInfoAlpha);
                    this.mInfoViewList.add(childAt);
                    childAt.setVisibility(z9 ? 0 : 8);
                } else if (i11 == 2) {
                    this.mExtraViewList.add(childAt);
                    childAt.setVisibility(z10 ? 0 : 8);
                } else {
                    this.mMainViewList.add(childAt);
                    childAt.setVisibility(0);
                }
            }
        }
    }

    private boolean hasExtraRegion() {
        return this.mCardType == 3;
    }

    private boolean hasInfoRegion() {
        return this.mCardType != 0;
    }

    private boolean isCurrentRegionVisible(int i10) {
        if (i10 == 0) {
            return true;
        }
        if (i10 == 1) {
            return isActivated();
        }
        if (i10 != 2) {
            return false;
        }
        return this.mCardType == 2 ? this.mInfoVisFraction > 0.0f : isSelected();
    }

    private boolean isRegionVisible(int i10) {
        if (i10 == 0) {
            return true;
        }
        if (i10 == 1) {
            return isActivated();
        }
        if (i10 != 2) {
            return false;
        }
        return isSelected();
    }

    private void setInfoViewVisibility(boolean z9) {
        int i10 = this.mCardType;
        if (i10 != 3) {
            if (i10 != 2) {
                if (i10 == 1) {
                    animateInfoAlpha(z9);
                    return;
                }
                return;
            } else {
                if (this.mInfoVisibility == 2) {
                    animateInfoHeight(z9);
                    return;
                }
                for (int i11 = 0; i11 < this.mInfoViewList.size(); i11++) {
                    this.mInfoViewList.get(i11).setVisibility(z9 ? 0 : 8);
                }
                return;
            }
        }
        if (z9) {
            for (int i12 = 0; i12 < this.mInfoViewList.size(); i12++) {
                this.mInfoViewList.get(i12).setVisibility(0);
            }
            return;
        }
        for (int i13 = 0; i13 < this.mInfoViewList.size(); i13++) {
            this.mInfoViewList.get(i13).setVisibility(8);
        }
        for (int i14 = 0; i14 < this.mExtraViewList.size(); i14++) {
            this.mExtraViewList.get(i14).setVisibility(8);
        }
        this.mInfoOffset = 0.0f;
    }

    public void animateInfoOffset(boolean z9) {
        cancelAnimations();
        int i10 = 0;
        if (z9) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mMeasuredWidth, 1073741824);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMax = 0;
            for (int i11 = 0; i11 < this.mExtraViewList.size(); i11++) {
                View view = this.mExtraViewList.get(i11);
                view.setVisibility(0);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredHeight());
            }
            i10 = iMax;
        }
        InfoOffsetAnimation infoOffsetAnimation = new InfoOffsetAnimation(this.mInfoOffset, z9 ? i10 : 0.0f);
        this.mAnim = infoOffsetAnimation;
        infoOffsetAnimation.setDuration(this.mSelectedAnimDuration);
        this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnim.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.leanback.widget.BaseCardView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (BaseCardView.this.mInfoOffset == 0.0f) {
                    for (int i12 = 0; i12 < BaseCardView.this.mExtraViewList.size(); i12++) {
                        BaseCardView.this.mExtraViewList.get(i12).setVisibility(8);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(this.mAnim);
    }

    public void cancelAnimations() {
        Animation animation = this.mAnim;
        if (animation != null) {
            animation.cancel();
            this.mAnim = null;
            clearAnimation();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCardType() {
        return this.mCardType;
    }

    @Deprecated
    public int getExtraVisibility() {
        return this.mExtraVisibility;
    }

    public final float getFinalInfoAlpha() {
        return (this.mCardType == 1 && this.mInfoVisibility == 2 && !isSelected()) ? 0.0f : 1.0f;
    }

    public final float getFinalInfoVisFraction() {
        return (this.mCardType == 2 && this.mInfoVisibility == 2 && !isSelected()) ? 0.0f : 1.0f;
    }

    public int getInfoVisibility() {
        return this.mInfoVisibility;
    }

    public boolean isSelectedAnimationDelayed() {
        return this.mDelaySelectedAnim;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        boolean z9 = false;
        boolean z10 = false;
        for (int i11 : super.onCreateDrawableState(i10)) {
            if (i11 == 16842919) {
                z9 = true;
            }
            if (i11 == 16842910) {
                z10 = true;
            }
        }
        return (z9 && z10) ? View.PRESSED_ENABLED_STATE_SET : z9 ? LB_PRESSED_STATE_SET : z10 ? View.ENABLED_STATE_SET : View.EMPTY_STATE_SET;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mAnimationTrigger);
        cancelAnimations();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i10, int i11, int i12, int i13) {
        float paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < this.mMainViewList.size(); i14++) {
            View view = this.mMainViewList.get(i14);
            if (view.getVisibility() != 8) {
                view.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.mMeasuredWidth, (int) (view.getMeasuredHeight() + paddingTop));
                paddingTop += view.getMeasuredHeight();
            }
        }
        if (hasInfoRegion()) {
            float measuredHeight = 0.0f;
            for (int i15 = 0; i15 < this.mInfoViewList.size(); i15++) {
                measuredHeight += this.mInfoViewList.get(i15).getMeasuredHeight();
            }
            int i16 = this.mCardType;
            if (i16 == 1) {
                paddingTop -= measuredHeight;
                if (paddingTop < 0.0f) {
                    paddingTop = 0.0f;
                }
            } else if (i16 != 2) {
                paddingTop -= this.mInfoOffset;
            } else if (this.mInfoVisibility == 2) {
                measuredHeight *= this.mInfoVisFraction;
            }
            for (int i17 = 0; i17 < this.mInfoViewList.size(); i17++) {
                View view2 = this.mInfoViewList.get(i17);
                if (view2.getVisibility() != 8) {
                    int measuredHeight2 = view2.getMeasuredHeight();
                    if (measuredHeight2 > measuredHeight) {
                        measuredHeight2 = (int) measuredHeight;
                    }
                    float f = measuredHeight2;
                    paddingTop += f;
                    view2.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.mMeasuredWidth, (int) paddingTop);
                    measuredHeight -= f;
                    if (measuredHeight <= 0.0f) {
                        break;
                    }
                }
            }
            if (hasExtraRegion()) {
                for (int i18 = 0; i18 < this.mExtraViewList.size(); i18++) {
                    View view3 = this.mExtraViewList.get(i18);
                    if (view3.getVisibility() != 8) {
                        view3.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.mMeasuredWidth, (int) (view3.getMeasuredHeight() + paddingTop));
                        paddingTop += view3.getMeasuredHeight();
                    }
                }
            }
        }
        onSizeChanged(0, 0, i12 - i10, i13 - i11);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        int measuredHeight2;
        boolean z9 = false;
        this.mMeasuredWidth = 0;
        this.mMeasuredHeight = 0;
        findChildrenViews();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int measuredHeight3 = 0;
        int iCombineMeasuredStates = 0;
        for (int i12 = 0; i12 < this.mMainViewList.size(); i12++) {
            View view = this.mMainViewList.get(i12);
            if (view.getVisibility() != 8) {
                measureChild(view, iMakeMeasureSpec, iMakeMeasureSpec);
                this.mMeasuredWidth = Math.max(this.mMeasuredWidth, view.getMeasuredWidth());
                measuredHeight3 += view.getMeasuredHeight();
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
            }
        }
        setPivotX(this.mMeasuredWidth / 2);
        setPivotY(measuredHeight3 / 2);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mMeasuredWidth, 1073741824);
        if (hasInfoRegion()) {
            measuredHeight = 0;
            for (int i13 = 0; i13 < this.mInfoViewList.size(); i13++) {
                View view2 = this.mInfoViewList.get(i13);
                if (view2.getVisibility() != 8) {
                    measureChild(view2, iMakeMeasureSpec2, iMakeMeasureSpec);
                    if (this.mCardType != 1) {
                        measuredHeight += view2.getMeasuredHeight();
                    }
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
                }
            }
            if (hasExtraRegion()) {
                measuredHeight2 = 0;
                for (int i14 = 0; i14 < this.mExtraViewList.size(); i14++) {
                    View view3 = this.mExtraViewList.get(i14);
                    if (view3.getVisibility() != 8) {
                        measureChild(view3, iMakeMeasureSpec2, iMakeMeasureSpec);
                        measuredHeight2 += view3.getMeasuredHeight();
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
                    }
                }
            } else {
                measuredHeight2 = 0;
            }
        } else {
            measuredHeight = 0;
            measuredHeight2 = 0;
        }
        if (hasInfoRegion() && this.mInfoVisibility == 2) {
            z9 = true;
        }
        float f = measuredHeight3;
        float f10 = measuredHeight;
        if (z9) {
            f10 *= this.mInfoVisFraction;
        }
        this.mMeasuredHeight = (int) (((f + f10) + measuredHeight2) - (z9 ? 0.0f : this.mInfoOffset));
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + this.mMeasuredWidth, i10, iCombineMeasuredStates), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + this.mMeasuredHeight, i11, iCombineMeasuredStates << 16));
    }

    @Override // android.view.View
    public void setActivated(boolean z9) {
        if (z9 != isActivated()) {
            super.setActivated(z9);
            applyActiveState();
        }
    }

    public void setCardType(int i10) {
        if (this.mCardType != i10) {
            if (i10 < 0 || i10 >= 4) {
                Log.e(TAG, "Invalid card type specified: " + i10 + ". Defaulting to type CARD_TYPE_MAIN_ONLY.");
                this.mCardType = 0;
            } else {
                this.mCardType = i10;
            }
            requestLayout();
        }
    }

    @Deprecated
    public void setExtraVisibility(int i10) {
        if (this.mExtraVisibility != i10) {
            this.mExtraVisibility = i10;
        }
    }

    public void setInfoVisibility(int i10) {
        if (this.mInfoVisibility != i10) {
            cancelAnimations();
            this.mInfoVisibility = i10;
            this.mInfoVisFraction = getFinalInfoVisFraction();
            requestLayout();
            float finalInfoAlpha = getFinalInfoAlpha();
            if (finalInfoAlpha != this.mInfoAlpha) {
                this.mInfoAlpha = finalInfoAlpha;
                for (int i11 = 0; i11 < this.mInfoViewList.size(); i11++) {
                    this.mInfoViewList.get(i11).setAlpha(this.mInfoAlpha);
                }
            }
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z9) {
        if (z9 != isSelected()) {
            super.setSelected(z9);
            applySelectedState(isSelected());
        }
    }

    public void setSelectedAnimationDelayed(boolean z9) {
        this.mDelaySelectedAnim = z9;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.View
    public String toString() {
        return super.toString();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int VIEW_TYPE_EXTRA = 2;
        public static final int VIEW_TYPE_INFO = 1;
        public static final int VIEW_TYPE_MAIN = 0;

        @ViewDebug.ExportedProperty(category = TtmlNode.TAG_LAYOUT, mapping = {@ViewDebug.IntToString(from = 0, to = "MAIN"), @ViewDebug.IntToString(from = 1, to = "INFO"), @ViewDebug.IntToString(from = 2, to = "EXTRA")})
        public int viewType;

        @SuppressLint({"CustomViewStyleable"})
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.viewType = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbBaseCardView_Layout);
            this.viewType = typedArrayObtainStyledAttributes.getInt(androidx.leanback.R.styleable.lbBaseCardView_Layout_layout_viewType, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.viewType = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.viewType = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.viewType = 0;
            this.viewType = layoutParams.viewType;
        }
    }

    public BaseCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.baseCardViewStyle);
    }

    public BaseCardView(Context context) {
        this(context, null);
    }
}
