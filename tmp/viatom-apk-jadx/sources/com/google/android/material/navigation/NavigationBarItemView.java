package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.carousel.a;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.internal.BaselineLayout;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class NavigationBarItemView extends FrameLayout implements NavigationBarMenuItemView {
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_LABELED_TRANSFORM;
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight;
    private int activeIndicatorDesiredWidth;
    private boolean activeIndicatorEnabled;
    private int activeIndicatorExpandedDesiredHeight;
    private int activeIndicatorExpandedDesiredWidth;
    private int activeIndicatorExpandedMarginHorizontal;
    private int activeIndicatorLabelPadding;
    private int activeIndicatorMarginHorizontal;
    private float activeIndicatorProgress;
    private boolean activeIndicatorResizeable;
    private ActiveIndicatorTransform activeIndicatorTransform;

    @NonNull
    private final View activeIndicatorView;

    @Nullable
    private BadgeDrawable badgeDrawable;
    private int badgeFixedEdge;
    private boolean boldText;

    @NonNull
    private final LinearLayout contentContainer;
    private BaselineLayout currentLabelGroup;
    private boolean expanded;
    private BaselineLayout expandedLabelGroup;
    private float expandedLabelScaleDownFactor;
    private float expandedLabelScaleUpFactor;
    private float expandedLabelShiftAmountY;
    private TextView expandedLargeLabel;
    private TextView expandedSmallLabel;

    @StyleRes
    private int horizontalTextAppearanceActive;

    @StyleRes
    private int horizontalTextAppearanceInactive;
    private final ImageView icon;

    @NonNull
    private final FrameLayout iconContainer;
    private int iconLabelHorizontalSpacing;

    @Nullable
    private ColorStateList iconTint;
    private boolean initialized;

    @NonNull
    private final LinearLayout innerContentContainer;
    private boolean isShifting;
    private Rect itemActiveIndicatorExpandedPadding;

    @Nullable
    Drawable itemBackground;

    @Nullable
    private MenuItemImpl itemData;
    private int itemGravity;
    private int itemIconGravity;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition;
    private ColorStateList itemRippleColor;
    private final BaselineLayout labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private boolean measurePaddingFromBaseline;
    private boolean onlyShowWhenExpanded;

    @Nullable
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private boolean scaleLabelSizeWithFont;
    private float scaleUpFactor;
    private float shiftAmountY;
    private final TextView smallLabel;

    @StyleRes
    private int textAppearanceActive;

    @StyleRes
    private int textAppearanceInactive;

    @Nullable
    private ColorStateList textColor;

    @Nullable
    private Drawable wrappedIconDrawable;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ActiveIndicatorTransform {
        private static final float ALPHA_FRACTION = 0.2f;
        private static final float SCALE_X_HIDDEN = 0.4f;
        private static final float SCALE_X_SHOWN = 1.0f;

        private ActiveIndicatorTransform() {
        }

        public float calculateAlpha(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
            return AnimationUtils.lerp(0.0f, 1.0f, f10 == 0.0f ? 0.8f : 0.0f, f10 == 0.0f ? 1.0f : 0.2f, f);
        }

        public float calculateScaleX(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
            return AnimationUtils.lerp(SCALE_X_HIDDEN, 1.0f, f);
        }

        public float calculateScaleY(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
            return 1.0f;
        }

        public void updateForProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, @NonNull View view) {
            view.setScaleX(calculateScaleX(f));
            view.setScaleY(calculateScaleY(f));
            view.setAlpha(calculateAlpha(f, f10));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        public float calculateScaleY(float f) {
            return calculateScaleX(f);
        }
    }

    static {
        ACTIVE_INDICATOR_LABELED_TRANSFORM = new ActiveIndicatorTransform();
        ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new ActiveIndicatorUnlabeledTransform();
    }

    public NavigationBarItemView(@NonNull Context context) throws Resources.NotFoundException {
        super(context);
        this.initialized = false;
        this.itemPosition = -1;
        this.textAppearanceActive = 0;
        this.textAppearanceInactive = 0;
        this.horizontalTextAppearanceActive = 0;
        this.horizontalTextAppearanceInactive = 0;
        this.boldText = false;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0.0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorExpandedDesiredWidth = -2;
        this.activeIndicatorExpandedDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        this.activeIndicatorExpandedMarginHorizontal = 0;
        this.badgeFixedEdge = 0;
        this.itemGravity = 49;
        this.expanded = false;
        this.onlyShowWhenExpanded = false;
        this.measurePaddingFromBaseline = false;
        this.scaleLabelSizeWithFont = false;
        this.itemActiveIndicatorExpandedPadding = new Rect();
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.contentContainer = (LinearLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_content_container);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_inner_content_container);
        this.innerContentContainer = linearLayout;
        this.activeIndicatorView = findViewById(com.google.android.material.R.id.navigation_bar_item_active_indicator_view);
        this.iconContainer = (FrameLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container);
        this.icon = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        BaselineLayout baselineLayout = (BaselineLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.labelGroup = baselineLayout;
        TextView textView = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.smallLabel = textView;
        TextView textView2 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.largeLabel = textView2;
        initializeDefaultExpandedLabelGroupViews();
        this.currentLabelGroup = baselineLayout;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = baselineLayout.getPaddingBottom();
        this.activeIndicatorLabelPadding = 0;
        this.iconLabelHorizontalSpacing = 0;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        this.expandedSmallLabel.setImportantForAccessibility(2);
        this.expandedLargeLabel.setImportantForAccessibility(2);
        setFocusable(true);
        calculateTextScaleFactors();
        this.activeIndicatorExpandedDesiredHeight = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_item_expanded_active_indicator_height_default);
        linearLayout.addOnLayoutChangeListener(new a(this, 1));
    }

    private void addDefaultExpandedLabelGroupViews() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.innerContentContainer.addView(this.expandedLabelGroup, layoutParams);
        setExpandedLabelGroupMargins();
    }

    private void calculateTextScaleFactors() {
        float textSize = this.smallLabel.getTextSize();
        float textSize2 = this.largeLabel.getTextSize();
        this.shiftAmountY = textSize - textSize2;
        this.scaleUpFactor = (textSize2 * 1.0f) / textSize;
        this.scaleDownFactor = (textSize * 1.0f) / textSize2;
        float textSize3 = this.expandedSmallLabel.getTextSize();
        float textSize4 = this.expandedLargeLabel.getTextSize();
        this.expandedLabelShiftAmountY = textSize3 - textSize4;
        this.expandedLabelScaleUpFactor = (textSize4 * 1.0f) / textSize3;
        this.expandedLabelScaleDownFactor = (textSize3 * 1.0f) / textSize4;
    }

    private static Drawable createItemBackgroundCompat(@NonNull ColorStateList colorStateList) {
        return new RippleDrawable(RippleUtils.convertToRippleDrawableColor(colorStateList), null, null);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i10 = 0;
        for (int i11 = 0; i11 < iIndexOfChild; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iconContainer.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.icon.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    private void initializeDefaultExpandedLabelGroupViews() throws Resources.NotFoundException {
        float dimension = getResources().getDimension(com.google.android.material.R.dimen.default_navigation_text_size);
        float dimension2 = getResources().getDimension(com.google.android.material.R.dimen.default_navigation_active_text_size);
        BaselineLayout baselineLayout = new BaselineLayout(getContext());
        this.expandedLabelGroup = baselineLayout;
        baselineLayout.setVisibility(8);
        this.expandedLabelGroup.setDuplicateParentStateEnabled(true);
        this.expandedLabelGroup.setMeasurePaddingFromBaseline(this.measurePaddingFromBaseline);
        TextView textView = new TextView(getContext());
        this.expandedSmallLabel = textView;
        textView.setMaxLines(1);
        TextView textView2 = this.expandedSmallLabel;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView2.setEllipsize(truncateAt);
        this.expandedSmallLabel.setDuplicateParentStateEnabled(true);
        this.expandedSmallLabel.setIncludeFontPadding(false);
        this.expandedSmallLabel.setGravity(16);
        this.expandedSmallLabel.setTextSize(dimension);
        TextView textView3 = new TextView(getContext());
        this.expandedLargeLabel = textView3;
        textView3.setMaxLines(1);
        this.expandedLargeLabel.setEllipsize(truncateAt);
        this.expandedLargeLabel.setDuplicateParentStateEnabled(true);
        this.expandedLargeLabel.setVisibility(4);
        this.expandedLargeLabel.setIncludeFontPadding(false);
        this.expandedLargeLabel.setGravity(16);
        this.expandedLargeLabel.setTextSize(dimension2);
        this.expandedLabelGroup.addView(this.expandedSmallLabel);
        this.expandedLabelGroup.addView(this.expandedLargeLabel);
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        return this.activeIndicatorResizeable && this.labelVisibilityMode == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        boolean z9;
        if (this.icon.getVisibility() == 0) {
            tryUpdateBadgeBounds(this.icon);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.innerContentContainer.getLayoutParams();
        int i18 = (i12 - i10) + layoutParams.rightMargin + layoutParams.leftMargin;
        int i19 = (i13 - i11) + layoutParams.topMargin + layoutParams.bottomMargin;
        boolean z10 = true;
        if (this.itemIconGravity == 1 && this.activeIndicatorExpandedDesiredWidth == -2) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
            if (this.activeIndicatorExpandedDesiredWidth != -2 || this.activeIndicatorView.getMeasuredWidth() == i18) {
                z9 = false;
            } else {
                layoutParams2.width = Math.max(i18, Math.min(this.activeIndicatorDesiredWidth, getMeasuredWidth() - (this.activeIndicatorMarginHorizontal * 2)));
                z9 = true;
            }
            if (this.activeIndicatorView.getMeasuredHeight() < i19) {
                layoutParams2.height = i19;
            } else {
                z10 = z9;
            }
            if (z10) {
                this.activeIndicatorView.setLayoutParams(layoutParams2);
            }
        }
    }

    private void maybeAnimateActiveIndicatorToProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) final float f) {
        if (!this.activeIndicatorEnabled || !this.initialized || !isAttachedToWindow()) {
            setActiveIndicatorProgress(f, f);
            return;
        }
        ValueAnimator valueAnimator = this.activeIndicatorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.activeIndicatorAnimator = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.activeIndicatorProgress, f);
        this.activeIndicatorAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                NavigationBarItemView.this.setActiveIndicatorProgress(((Float) valueAnimator2.getAnimatedValue()).floatValue(), f);
            }
        });
        this.activeIndicatorAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.activeIndicatorAnimator.setDuration(MotionUtils.resolveThemeDuration(getContext(), com.google.android.material.R.attr.motionDurationLong2, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
        this.activeIndicatorAnimator.start();
    }

    private void refreshChecked() {
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    private void refreshItemBackground() {
        Drawable drawableCreateItemBackgroundCompat = this.itemBackground;
        RippleDrawable rippleDrawable = null;
        boolean z9 = true;
        if (this.itemRippleColor != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.activeIndicatorEnabled && getActiveIndicatorDrawable() != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.itemRippleColor), null, activeIndicatorDrawable);
                z9 = false;
            } else if (drawableCreateItemBackgroundCompat == null) {
                drawableCreateItemBackgroundCompat = createItemBackgroundCompat(this.itemRippleColor);
            }
        }
        this.iconContainer.setPadding(0, 0, 0, 0);
        this.iconContainer.setForeground(rippleDrawable);
        setBackground(drawableCreateItemBackgroundCompat);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActiveIndicatorProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, float f10) {
        this.activeIndicatorTransform.updateForProgress(f, f10, this.activeIndicatorView);
        this.activeIndicatorProgress = f;
    }

    private void setExpandedLabelGroupMargins() {
        int i10 = this.icon.getLayoutParams().width > 0 ? this.iconLabelHorizontalSpacing : 0;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.expandedLabelGroup.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.rightMargin = getLayoutDirection() == 1 ? i10 : 0;
            layoutParams.leftMargin = getLayoutDirection() != 1 ? i10 : 0;
        }
    }

    private void setLabelPivots(TextView textView) {
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
    }

    private void setLayoutConfigurationIconAndLabel(View view, View view2, float f, float f10) {
        setViewMarginAndGravity(this.contentContainer, this.itemIconGravity == 0 ? (int) (this.itemPaddingTop + f10) : 0, 0, this.itemGravity);
        LinearLayout linearLayout = this.innerContentContainer;
        int i10 = this.itemIconGravity;
        setViewMarginAndGravity(linearLayout, i10 == 0 ? 0 : this.itemActiveIndicatorExpandedPadding.top, i10 == 0 ? 0 : this.itemActiveIndicatorExpandedPadding.bottom, i10 == 0 ? 17 : NavigationBarView.ITEM_GRAVITY_START_CENTER);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.currentLabelGroup.setVisibility(0);
        setViewScaleValues(view, 1.0f, 1.0f, 0);
        setViewScaleValues(view2, f, f, 4);
    }

    private void setLayoutConfigurationIconOnly() {
        LinearLayout linearLayout = this.contentContainer;
        int i10 = this.itemPaddingTop;
        setViewMarginAndGravity(linearLayout, i10, i10, this.itemIconGravity == 0 ? 17 : this.itemGravity);
        setViewMarginAndGravity(this.innerContentContainer, 0, 0, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.currentLabelGroup.setVisibility(8);
    }

    private void setTextAppearanceForLabel(TextView textView, int i10) {
        if (this.scaleLabelSizeWithFont) {
            TextViewCompat.setTextAppearance(textView, i10);
        } else {
            setTextAppearanceWithoutFontScaling(textView, i10);
        }
    }

    private static void setTextAppearanceWithoutFontScaling(TextView textView, @StyleRes int i10) {
        TextViewCompat.setTextAppearance(textView, i10);
        int unscaledTextSize = MaterialResources.getUnscaledTextSize(textView.getContext(), i10, 0);
        if (unscaledTextSize != 0) {
            textView.setTextSize(0, unscaledTextSize);
        }
    }

    private static void setViewMarginAndGravity(@NonNull View view, int i10, int i11, int i12) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i10;
        layoutParams.bottomMargin = i11;
        layoutParams.gravity = i12;
        view.setLayoutParams(layoutParams);
    }

    private static void setViewScaleValues(@NonNull View view, float f, float f10, int i10) {
        view.setScaleX(f);
        view.setScaleY(f10);
        view.setVisibility(i10);
    }

    private void tryAttachBadgeToAnchor(@Nullable View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view);
        }
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
            }
            this.badgeDrawable = null;
        }
    }

    private void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, null);
        }
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled()) {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
        } else {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        }
    }

    private void updateActiveLabelBoldness() {
        TextView textView = this.largeLabel;
        textView.setTypeface(textView.getTypeface(), this.boldText ? 1 : 0);
        TextView textView2 = this.expandedLargeLabel;
        textView2.setTypeface(textView2.getTypeface(), this.boldText ? 1 : 0);
    }

    private void updateActiveLabelTextAppearance(@Nullable TextView textView, @StyleRes int i10) {
        if (textView == null) {
            return;
        }
        setTextAppearanceForLabel(textView, i10);
        calculateTextScaleFactors();
        textView.setMinimumHeight(MaterialResources.getUnscaledLineHeight(textView.getContext(), i10, 0));
        ColorStateList colorStateList = this.textColor;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        updateActiveLabelBoldness();
    }

    private void updateInactiveLabelTextAppearance(@Nullable TextView textView, @StyleRes int i10) {
        if (textView == null) {
            return;
        }
        setTextAppearanceForLabel(textView, i10);
        calculateTextScaleFactors();
        textView.setMinimumHeight(MaterialResources.getUnscaledLineHeight(textView.getContext(), i10, 0));
        ColorStateList colorStateList = this.textColor;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void updateItemIconGravity() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        this.badgeFixedEdge = 0;
        this.currentLabelGroup = this.labelGroup;
        int i16 = 8;
        if (this.itemIconGravity == 1) {
            if (this.expandedLabelGroup.getParent() == null) {
                addDefaultExpandedLabelGroupViews();
            }
            Rect rect = this.itemActiveIndicatorExpandedPadding;
            int i17 = rect.left;
            int i18 = rect.right;
            int i19 = rect.top;
            i10 = rect.bottom;
            this.badgeFixedEdge = 1;
            int i20 = this.activeIndicatorExpandedMarginHorizontal;
            this.currentLabelGroup = this.expandedLabelGroup;
            i14 = i19;
            i13 = i18;
            i12 = i17;
            i11 = i20;
            i15 = 0;
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 8;
            i16 = 0;
        }
        this.labelGroup.setVisibility(i16);
        this.expandedLabelGroup.setVisibility(i15);
        ((FrameLayout.LayoutParams) this.contentContainer.getLayoutParams()).gravity = this.itemGravity;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.innerContentContainer.getLayoutParams();
        layoutParams.leftMargin = i12;
        layoutParams.rightMargin = i13;
        layoutParams.topMargin = i14;
        layoutParams.bottomMargin = i10;
        setPadding(i11, 0, i11, 0);
        updateActiveIndicatorLayoutParams(getWidth());
    }

    private static void updateViewPaddingBottom(@NonNull View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    private void updateVisibility() {
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            setVisibility((!menuItemImpl.isVisible() || (!this.expanded && this.onlyShowWhenExpanded)) ? 8 : 0);
        }
    }

    public void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.activeIndicatorEnabled) {
            this.iconContainer.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        return this.activeIndicatorView.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @NonNull
    public BaselineLayout getExpandedLabelGroup() {
        return this.expandedLabelGroup;
    }

    @DrawableRes
    public int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    @DimenRes
    public int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    @NonNull
    public BaselineLayout getLabelGroup() {
        return this.labelGroup;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.contentContainer.getLayoutParams();
        return this.contentContainer.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        if (this.itemIconGravity == 1) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.innerContentContainer.getLayoutParams();
            return this.innerContentContainer.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), this.labelGroup.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i10) {
        this.itemData = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle();
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, tooltipText);
        }
        updateVisibility();
        this.initialized = true;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuItemView
    public boolean isExpanded() {
        return this.expanded;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuItemView
    public boolean isOnlyVisibleWhenExpanded() {
        return this.onlyShowWhenExpanded;
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.badgeDrawable.getContentDescription()));
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            accessibilityNodeInfoCompatWrap.setClickable(false);
            accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        accessibilityNodeInfoCompatWrap.setRoleDescription(getResources().getString(com.google.android.material.R.string.item_view_role_description));
    }

    @Override // android.view.View
    public void onSizeChanged(final int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.1
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarItemView.this.updateActiveIndicatorLayoutParams(i10);
            }
        });
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        this.activeIndicatorView.setBackground(drawable);
        refreshItemBackground();
    }

    public void setActiveIndicatorEnabled(boolean z9) {
        this.activeIndicatorEnabled = z9;
        refreshItemBackground();
        this.activeIndicatorView.setVisibility(z9 ? 0 : 8);
        requestLayout();
    }

    public void setActiveIndicatorExpandedHeight(int i10) {
        this.activeIndicatorExpandedDesiredHeight = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorExpandedMarginHorizontal(@Px int i10) {
        this.activeIndicatorExpandedMarginHorizontal = i10;
        if (this.itemIconGravity == 1) {
            setPadding(i10, 0, i10, 0);
        }
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorExpandedPadding(@NonNull Rect rect) {
        this.itemActiveIndicatorExpandedPadding = rect;
    }

    public void setActiveIndicatorExpandedWidth(int i10) {
        this.activeIndicatorExpandedDesiredWidth = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorHeight(int i10) {
        this.activeIndicatorDesiredHeight = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i10) {
        if (this.activeIndicatorLabelPadding != i10) {
            this.activeIndicatorLabelPadding = i10;
            ((LinearLayout.LayoutParams) this.labelGroup.getLayoutParams()).topMargin = i10;
            if (this.expandedLabelGroup.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.expandedLabelGroup.getLayoutParams();
                layoutParams.rightMargin = getLayoutDirection() == 1 ? i10 : 0;
                if (getLayoutDirection() == 1) {
                    i10 = 0;
                }
                layoutParams.leftMargin = i10;
                requestLayout();
            }
        }
    }

    public void setActiveIndicatorMarginHorizontal(@Px int i10) {
        this.activeIndicatorMarginHorizontal = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z9) {
        this.activeIndicatorResizeable = z9;
    }

    public void setActiveIndicatorWidth(int i10) {
        this.activeIndicatorDesiredWidth = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        if (this.badgeDrawable == badgeDrawable) {
            return;
        }
        if (hasBadge() && this.icon != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            tryRemoveBadgeFromAnchor(this.icon);
        }
        this.badgeDrawable = badgeDrawable;
        badgeDrawable.setBadgeFixedEdge(this.badgeFixedEdge);
        ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z9) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z9) {
        setLabelPivots(this.largeLabel);
        setLabelPivots(this.smallLabel);
        setLabelPivots(this.expandedLargeLabel);
        setLabelPivots(this.expandedSmallLabel);
        maybeAnimateActiveIndicatorToProgress(z9 ? 1.0f : 0.0f);
        TextView textView = this.largeLabel;
        TextView textView2 = this.smallLabel;
        float f = this.shiftAmountY;
        float f10 = this.scaleUpFactor;
        float f11 = this.scaleDownFactor;
        if (this.itemIconGravity == 1) {
            textView = this.expandedLargeLabel;
            textView2 = this.expandedSmallLabel;
            f = this.expandedLabelShiftAmountY;
            f10 = this.expandedLabelScaleUpFactor;
            f11 = this.expandedLabelScaleDownFactor;
        }
        int i10 = this.labelVisibilityMode;
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        setLayoutConfigurationIconOnly();
                    }
                } else if (z9) {
                    setLayoutConfigurationIconAndLabel(textView, textView2, f10, f);
                } else {
                    setLayoutConfigurationIconAndLabel(textView2, textView, f11, 0.0f);
                }
            } else if (z9) {
                setLayoutConfigurationIconAndLabel(textView, textView2, f10, 0.0f);
            } else {
                setLayoutConfigurationIconOnly();
            }
        } else if (this.isShifting) {
            if (z9) {
                setLayoutConfigurationIconAndLabel(textView, textView2, f10, 0.0f);
            } else {
                setLayoutConfigurationIconOnly();
            }
        } else if (z9) {
            setLayoutConfigurationIconAndLabel(textView, textView2, f10, f);
        } else {
            setLayoutConfigurationIconAndLabel(textView2, textView, f11, 0.0f);
        }
        refreshDrawableState();
        setSelected(z9);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z9) {
        super.setEnabled(z9);
        this.smallLabel.setEnabled(z9);
        this.largeLabel.setEnabled(z9);
        this.expandedSmallLabel.setEnabled(z9);
        this.expandedLargeLabel.setEnabled(z9);
        this.icon.setEnabled(z9);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuItemView
    public void setExpanded(boolean z9) {
        this.expanded = z9;
        updateVisibility();
    }

    public void setHorizontalTextAppearanceActive(@StyleRes int i10) {
        this.horizontalTextAppearanceActive = i10;
        TextView textView = this.expandedLargeLabel;
        if (i10 == 0) {
            i10 = this.textAppearanceActive;
        }
        updateActiveLabelTextAppearance(textView, i10);
    }

    public void setHorizontalTextAppearanceInactive(@StyleRes int i10) {
        this.horizontalTextAppearanceInactive = i10;
        TextView textView = this.expandedSmallLabel;
        if (i10 == 0) {
            i10 = this.textAppearanceInactive;
        }
        updateInactiveLabelTextAppearance(textView, i10);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.wrappedIconDrawable = drawable;
            ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconLabelHorizontalSpacing(int i10) {
        if (this.iconLabelHorizontalSpacing != i10) {
            this.iconLabelHorizontalSpacing = i10;
            setExpandedLabelGroupMargins();
            requestLayout();
        }
    }

    public void setIconSize(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.icon.setLayoutParams(layoutParams);
        setExpandedLabelGroupMargins();
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData == null || (drawable = this.wrappedIconDrawable) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.wrappedIconDrawable.invalidateSelf();
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.itemBackground = drawable;
        refreshItemBackground();
    }

    public void setItemGravity(int i10) {
        this.itemGravity = i10;
        requestLayout();
    }

    public void setItemIconGravity(int i10) {
        if (this.itemIconGravity != i10) {
            this.itemIconGravity = i10;
            updateItemIconGravity();
            refreshItemBackground();
        }
    }

    public void setItemPaddingBottom(int i10) {
        if (this.itemPaddingBottom != i10) {
            this.itemPaddingBottom = i10;
            refreshChecked();
        }
    }

    public void setItemPaddingTop(int i10) {
        if (this.itemPaddingTop != i10) {
            this.itemPaddingTop = i10;
            refreshChecked();
        }
    }

    public void setItemPosition(int i10) {
        this.itemPosition = i10;
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        refreshItemBackground();
    }

    public void setLabelFontScalingEnabled(boolean z9) {
        this.scaleLabelSizeWithFont = z9;
        setTextAppearanceActive(this.textAppearanceActive);
        setTextAppearanceInactive(this.textAppearanceInactive);
        setHorizontalTextAppearanceActive(this.horizontalTextAppearanceActive);
        setHorizontalTextAppearanceInactive(this.horizontalTextAppearanceInactive);
    }

    public void setLabelMaxLines(int i10) {
        this.smallLabel.setMaxLines(i10);
        this.largeLabel.setMaxLines(i10);
        this.expandedSmallLabel.setMaxLines(i10);
        this.expandedLargeLabel.setMaxLines(i10);
        if (Build.VERSION.SDK_INT > 34) {
            this.smallLabel.setGravity(17);
            this.largeLabel.setGravity(17);
        } else {
            TextView textView = this.smallLabel;
            if (i10 > 1) {
                textView.setEllipsize(null);
                this.largeLabel.setEllipsize(null);
                this.smallLabel.setGravity(17);
                this.largeLabel.setGravity(17);
            } else {
                textView.setGravity(16);
                this.largeLabel.setGravity(16);
            }
        }
        requestLayout();
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.labelVisibilityMode != i10) {
            this.labelVisibilityMode = i10;
            updateActiveIndicatorTransform();
            updateActiveIndicatorLayoutParams(getWidth());
            refreshChecked();
        }
    }

    public void setMeasureBottomPaddingFromLabelBaseline(boolean z9) {
        this.measurePaddingFromBaseline = z9;
        this.labelGroup.setMeasurePaddingFromBaseline(z9);
        this.smallLabel.setIncludeFontPadding(z9);
        this.largeLabel.setIncludeFontPadding(z9);
        this.expandedLabelGroup.setMeasurePaddingFromBaseline(z9);
        this.expandedSmallLabel.setIncludeFontPadding(z9);
        this.expandedLargeLabel.setIncludeFontPadding(z9);
        requestLayout();
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuItemView
    public void setOnlyShowWhenExpanded(boolean z9) {
        this.onlyShowWhenExpanded = z9;
        updateVisibility();
    }

    public void setShifting(boolean z9) {
        if (this.isShifting != z9) {
            this.isShifting = z9;
            refreshChecked();
        }
    }

    public void setTextAppearanceActive(@StyleRes int i10) {
        this.textAppearanceActive = i10;
        updateActiveLabelTextAppearance(this.largeLabel, i10);
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z9) {
        this.boldText = z9;
        setTextAppearanceActive(this.textAppearanceActive);
        setHorizontalTextAppearanceActive(this.horizontalTextAppearanceActive);
        updateActiveLabelBoldness();
    }

    public void setTextAppearanceInactive(@StyleRes int i10) {
        this.textAppearanceInactive = i10;
        updateInactiveLabelTextAppearance(this.smallLabel, i10);
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
            this.expandedSmallLabel.setTextColor(colorStateList);
            this.expandedLargeLabel.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        this.expandedSmallLabel.setText(charSequence);
        this.expandedLargeLabel.setText(charSequence);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.itemData;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void updateActiveIndicatorLayoutParams(int i10) {
        if (i10 > 0 || getVisibility() != 0) {
            int iMin = Math.min(this.activeIndicatorDesiredWidth, i10 - (this.activeIndicatorMarginHorizontal * 2));
            int iMax = this.activeIndicatorDesiredHeight;
            if (this.itemIconGravity == 1) {
                int measuredWidth = i10 - (this.activeIndicatorExpandedMarginHorizontal * 2);
                int i11 = this.activeIndicatorExpandedDesiredWidth;
                if (i11 != -1) {
                    measuredWidth = i11 == -2 ? this.contentContainer.getMeasuredWidth() : Math.min(i11, measuredWidth);
                }
                iMin = measuredWidth;
                iMax = Math.max(this.activeIndicatorExpandedDesiredHeight, this.innerContentContainer.getMeasuredHeight());
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
            if (isActiveIndicatorResizeableAndUnlabeled()) {
                iMax = iMin;
            }
            layoutParams.height = iMax;
            layoutParams.width = Math.max(0, iMin);
            this.activeIndicatorView.setLayoutParams(layoutParams);
        }
    }

    public void setItemBackground(int i10) {
        setItemBackground(i10 == 0 ? null : getContext().getDrawable(i10));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z9, char c10) {
    }
}
