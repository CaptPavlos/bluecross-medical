package com.google.android.material.navigationrail;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarDividerView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class NavigationRailView extends NavigationBarView {
    static final int COLLAPSED_MAX_ITEM_COUNT = 7;
    private static final TimeInterpolator CUBIC_BEZIER_INTERPOLATOR = new PathInterpolator(0.38f, 1.21f, 0.22f, 1.0f);
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    private static final int EXPAND_DURATION = 500;
    private static final int FADE_DURATION = 100;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    private int collapsedIconGravity;
    private int collapsedItemGravity;
    private int collapsedItemMinHeight;
    private int collapsedItemSpacing;
    private NavigationRailFrameLayout contentContainer;
    private final int contentMarginTop;
    private boolean expanded;
    private int expandedIconGravity;
    private int expandedItemGravity;
    private int expandedItemMinHeight;
    private int expandedItemSpacing;
    private final int headerMarginBottom;

    @Nullable
    private View headerView;
    private final int maxExpandedWidth;
    private final int minExpandedWidth;

    @Nullable
    private Boolean paddingBottomSystemWindowInsets;

    @Nullable
    private Boolean paddingStartSystemWindowInsets;

    @Nullable
    private Boolean paddingTopSystemWindowInsets;
    private final boolean scrollingEnabled;
    private boolean submenuDividersEnabled;

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.expanded = false;
        this.collapsedItemMinHeight = -1;
        this.collapsedIconGravity = 0;
        this.collapsedItemGravity = 49;
        Context context2 = getContext();
        this.expandedItemSpacing = getContext().getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_expanded_item_spacing);
        this.expandedItemGravity = NavigationBarView.ITEM_GRAVITY_START_CENTER;
        this.expandedIconGravity = 1;
        TintTypedArray tintTypedArrayObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.NavigationRailView, i10, i11, new int[0]);
        int i12 = R.styleable.NavigationRailView_contentMarginTop;
        Resources resources = getResources();
        int i13 = R.dimen.mtrl_navigation_rail_margin;
        this.contentMarginTop = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(i12, resources.getDimensionPixelSize(i13));
        this.headerMarginBottom = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_headerMarginBottom, getResources().getDimensionPixelSize(i13));
        this.scrollingEnabled = tintTypedArrayObtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_scrollingEnabled, false);
        setSubmenuDividersEnabled(tintTypedArrayObtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_submenuDividersEnabled, false));
        addContentContainer();
        int resourceId = tintTypedArrayObtainTintedStyledAttributes.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            addHeaderView(resourceId);
        }
        setMenuGravity(tintTypedArrayObtainTintedStyledAttributes.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        int i14 = R.styleable.NavigationRailView_itemMinHeight;
        int dimensionPixelSize = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(i14, -1);
        int dimensionPixelSize2 = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(i14, -1);
        int i15 = R.styleable.NavigationRailView_collapsedItemMinHeight;
        dimensionPixelSize = tintTypedArrayObtainTintedStyledAttributes.hasValue(i15) ? tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(i15, -1) : dimensionPixelSize;
        int i16 = R.styleable.NavigationRailView_expandedItemMinHeight;
        dimensionPixelSize2 = tintTypedArrayObtainTintedStyledAttributes.hasValue(i16) ? tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(i16, -1) : dimensionPixelSize2;
        setCollapsedItemMinimumHeight(dimensionPixelSize);
        setExpandedItemMinimumHeight(dimensionPixelSize2);
        this.minExpandedWidth = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedMinWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_min_expanded_width));
        this.maxExpandedWidth = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedMaxWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_max_expanded_width));
        int i17 = R.styleable.NavigationRailView_paddingTopSystemWindowInsets;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i17)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(tintTypedArrayObtainTintedStyledAttributes.getBoolean(i17, false));
        }
        int i18 = R.styleable.NavigationRailView_paddingBottomSystemWindowInsets;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i18)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(tintTypedArrayObtainTintedStyledAttributes.getBoolean(i18, false));
        }
        int i19 = R.styleable.NavigationRailView_paddingStartSystemWindowInsets;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i19)) {
            this.paddingStartSystemWindowInsets = Boolean.valueOf(tintTypedArrayObtainTintedStyledAttributes.getBoolean(i19, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float fLerp = AnimationUtils.lerp(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.getFontScale(context2) - 1.0f);
        float fLerp2 = AnimationUtils.lerp(getItemPaddingTop(), dimensionPixelOffset, fLerp);
        float fLerp3 = AnimationUtils.lerp(getItemPaddingBottom(), dimensionPixelOffset2, fLerp);
        setItemPaddingTop(Math.round(fLerp2));
        setItemPaddingBottom(Math.round(fLerp3));
        setCollapsedItemSpacing(tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_itemSpacing, 0));
        setExpanded(tintTypedArrayObtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_expanded, false));
        tintTypedArrayObtainTintedStyledAttributes.recycle();
        applyWindowInsets();
    }

    private void addContentContainer() {
        View view = (View) getMenuView();
        NavigationRailFrameLayout navigationRailFrameLayout = new NavigationRailFrameLayout(getContext());
        this.contentContainer = navigationRailFrameLayout;
        navigationRailFrameLayout.setPaddingTop(this.contentMarginTop);
        this.contentContainer.setScrollingEnabled(this.scrollingEnabled);
        this.contentContainer.setClipChildren(false);
        this.contentContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.contentContainer.addView(view);
        if (!this.scrollingEnabled) {
            addView(this.contentContainer);
            return;
        }
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(this.contentContainer);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(scrollView);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.navigationrail.NavigationRailView.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout());
                NavigationRailView navigationRailView = NavigationRailView.this;
                if (navigationRailView.shouldApplyWindowInsetPadding(navigationRailView.paddingTopSystemWindowInsets)) {
                    relativePadding.top += insets.top;
                }
                NavigationRailView navigationRailView2 = NavigationRailView.this;
                if (navigationRailView2.shouldApplyWindowInsetPadding(navigationRailView2.paddingBottomSystemWindowInsets)) {
                    relativePadding.bottom += insets.bottom;
                }
                NavigationRailView navigationRailView3 = NavigationRailView.this;
                if (navigationRailView3.shouldApplyWindowInsetPadding(navigationRailView3.paddingStartSystemWindowInsets)) {
                    if (ViewUtils.isLayoutRtl(view)) {
                        relativePadding.start = Math.max(insets.right, insets2.right) + relativePadding.start;
                    } else {
                        relativePadding.start = Math.max(insets.left, insets2.left) + relativePadding.start;
                    }
                }
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
    }

    private int getMaxChildWidth() {
        int childCount = getNavigationRailMenuView().getChildCount();
        int iMax = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getNavigationRailMenuView().getChildAt(i10);
            if (childAt.getVisibility() != 8 && !(childAt instanceof NavigationBarDividerView)) {
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
        }
        return iMax;
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private int makeExpandedWidthMeasureSpec(int i10, int i11) {
        int iMin = Math.min(this.minExpandedWidth, View.MeasureSpec.getSize(i10));
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            return i10;
        }
        int iMax = Math.max(i11, iMin);
        View view = this.headerView;
        if (view != null) {
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(getSuggestedMinimumWidth(), Math.min(iMax, this.maxExpandedWidth)), 1073741824);
    }

    private int makeMinWidthSpec(int i10) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i10) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
    }

    private void setExpanded(boolean z9) {
        if (this.expanded == z9) {
            return;
        }
        startTransitionAnimation();
        this.expanded = z9;
        int i10 = this.collapsedIconGravity;
        int i11 = this.collapsedItemSpacing;
        int i12 = this.collapsedItemMinHeight;
        int i13 = this.collapsedItemGravity;
        if (z9) {
            i10 = this.expandedIconGravity;
            i11 = this.expandedItemSpacing;
            i12 = this.expandedItemMinHeight;
            i13 = this.expandedItemGravity;
        }
        getNavigationRailMenuView().setItemGravity(i13);
        super.setItemIconGravity(i10);
        getNavigationRailMenuView().setItemSpacing(i11);
        getNavigationRailMenuView().setItemMinimumHeight(i12);
        getNavigationRailMenuView().setExpanded(z9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldApplyWindowInsetPadding(Boolean bool) {
        return bool != null ? bool.booleanValue() : getFitsSystemWindows();
    }

    private void startTransitionAnimation() {
        if (isLaidOut()) {
            Transition interpolator = new ChangeBounds().setDuration(500L).setInterpolator(CUBIC_BEZIER_INTERPOLATOR);
            Transition duration = new Fade().setDuration(100L);
            Transition duration2 = new Fade().setDuration(100L);
            LabelMoveTransition labelMoveTransition = new LabelMoveTransition();
            Transition duration3 = new Fade().setDuration(100L);
            int childCount = getNavigationRailMenuView().getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getNavigationRailMenuView().getChildAt(i10);
                if (childAt instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) childAt;
                    interpolator.excludeTarget((View) navigationBarItemView.getLabelGroup(), true);
                    interpolator.excludeTarget((View) navigationBarItemView.getExpandedLabelGroup(), true);
                    if (this.expanded) {
                        duration2.addTarget(navigationBarItemView.getExpandedLabelGroup());
                        duration.addTarget(navigationBarItemView.getLabelGroup());
                    } else {
                        duration2.addTarget(navigationBarItemView.getLabelGroup());
                        duration.addTarget(navigationBarItemView.getExpandedLabelGroup());
                    }
                    labelMoveTransition.addTarget(navigationBarItemView.getExpandedLabelGroup());
                }
                duration3.addTarget(childAt);
            }
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setOrdering(0);
            transitionSet.addTransition(interpolator).addTransition(duration).addTransition(labelMoveTransition);
            if (!this.expanded) {
                transitionSet.addTransition(duration3);
            }
            TransitionSet transitionSet2 = new TransitionSet();
            transitionSet2.setOrdering(0);
            transitionSet2.addTransition(duration2);
            if (this.expanded) {
                transitionSet2.addTransition(duration3);
            }
            TransitionSet transitionSet3 = new TransitionSet();
            transitionSet3.setOrdering(1);
            transitionSet3.addTransition(transitionSet2).addTransition(transitionSet);
            TransitionManager.beginDelayedTransition((ViewGroup) getParent(), transitionSet3);
        }
    }

    public void addHeaderView(@NonNull View view) {
        removeHeaderView();
        this.headerView = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.bottomMargin = this.headerMarginBottom;
        this.contentContainer.addView(view, 0, layoutParams);
    }

    public void collapse() {
        if (this.expanded) {
            setExpanded(false);
            announceForAccessibility(getResources().getString(R.string.nav_rail_collapsed_a11y_label));
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationRailMenuView createNavigationBarMenuView(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    public void expand() {
        if (this.expanded) {
            return;
        }
        setExpanded(true);
        announceForAccessibility(getResources().getString(R.string.nav_rail_expanded_a11y_label));
    }

    public int getCollapsedItemMinimumHeight() {
        return this.collapsedItemMinHeight;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getCollapsedMaxItemCount() {
        return 7;
    }

    public int getExpandedItemMinimumHeight() {
        return this.expandedItemMinHeight;
    }

    @Nullable
    public View getHeaderView() {
        return this.headerView;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getItemGravity() {
        return getNavigationRailMenuView().getItemGravity();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getItemIconGravity() {
        return getNavigationRailMenuView().getItemIconGravity();
    }

    public int getItemMinimumHeight() {
        return getNavigationRailMenuView().getItemMinimumHeight();
    }

    public int getItemSpacing() {
        return getNavigationRailMenuView().getItemSpacing();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public boolean getSubmenuDividersEnabled() {
        return this.submenuDividersEnabled;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public boolean isSubMenuSupported() {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMakeMinWidthSpec = makeMinWidthSpec(i10);
        if (this.expanded) {
            measureChild(getNavigationRailMenuView(), i10, i11);
            View view = this.headerView;
            if (view != null) {
                measureChild(view, i10, i11);
            }
            iMakeMinWidthSpec = makeExpandedWidthMeasureSpec(i10, getMaxChildWidth());
            if (getItemActiveIndicatorExpandedWidth() == -1) {
                getNavigationRailMenuView().updateActiveIndicator(View.MeasureSpec.getSize(iMakeMinWidthSpec));
            }
        }
        super.onMeasure(iMakeMinWidthSpec, i11);
        if (this.contentContainer.getMeasuredHeight() < getMeasuredHeight()) {
            measureChild(this.contentContainer, iMakeMinWidthSpec, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void removeHeaderView() {
        View view = this.headerView;
        if (view != null) {
            this.contentContainer.removeView(view);
            this.headerView = null;
        }
    }

    public void setCollapsedItemMinimumHeight(@Px int i10) {
        this.collapsedItemMinHeight = i10;
        if (this.expanded) {
            return;
        }
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i10);
    }

    public void setCollapsedItemSpacing(@Px int i10) {
        this.collapsedItemSpacing = i10;
        if (this.expanded) {
            return;
        }
        getNavigationRailMenuView().setItemSpacing(i10);
    }

    public void setExpandedItemMinimumHeight(@Px int i10) {
        this.expandedItemMinHeight = i10;
        if (this.expanded) {
            ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i10);
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setItemGravity(int i10) {
        this.collapsedItemGravity = i10;
        this.expandedItemGravity = i10;
        super.setItemGravity(i10);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setItemIconGravity(int i10) {
        this.collapsedIconGravity = i10;
        this.expandedIconGravity = i10;
        super.setItemIconGravity(i10);
    }

    public void setItemMinimumHeight(@Px int i10) {
        this.collapsedItemMinHeight = i10;
        this.expandedItemMinHeight = i10;
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i10);
    }

    public void setItemSpacing(@Px int i10) {
        this.collapsedItemSpacing = i10;
        this.expandedItemSpacing = i10;
        getNavigationRailMenuView().setItemSpacing(i10);
    }

    public void setMenuGravity(int i10) {
        getNavigationRailMenuView().setMenuGravity(i10);
    }

    public void setSubmenuDividersEnabled(boolean z9) {
        if (this.submenuDividersEnabled == z9) {
            return;
        }
        this.submenuDividersEnabled = z9;
        getNavigationRailMenuView().setSubmenuDividersEnabled(z9);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldAddMenuView() {
        return true;
    }

    public void addHeaderView(@LayoutRes int i10) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, false));
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }
}
