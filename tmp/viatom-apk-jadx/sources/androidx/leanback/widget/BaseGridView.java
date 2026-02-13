package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class BaseGridView extends RecyclerView {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_ALIGNED = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_ITEM = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_PAGE = 2;
    public static final float ITEM_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    private static final int PFLAG_RETAIN_FOCUS_FOR_CHILD = 1;
    public static final int SAVE_ALL_CHILD = 3;
    public static final int SAVE_LIMITED_CHILD = 2;
    public static final int SAVE_NO_CHILD = 0;
    public static final int SAVE_ON_SCREEN_CHILD = 1;
    public static final int WINDOW_ALIGN_BOTH_EDGE = 3;
    public static final int WINDOW_ALIGN_HIGH_EDGE = 2;
    public static final int WINDOW_ALIGN_LOW_EDGE = 1;
    public static final int WINDOW_ALIGN_NO_EDGE = 0;
    public static final float WINDOW_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    private boolean mAnimateChildLayout;
    private boolean mHasOverlappingRendering;
    int mInitialPrefetchItemCount;
    GridLayoutManager mLayoutManager;
    private OnKeyInterceptListener mOnKeyInterceptListener;
    private OnMotionInterceptListener mOnMotionInterceptListener;
    private OnTouchInterceptListener mOnTouchInterceptListener;
    private OnUnhandledKeyListener mOnUnhandledKeyListener;
    private int mPrivateFlag;
    private RecyclerView.ItemAnimator mSavedItemAnimator;
    private SmoothScrollByBehavior mSmoothScrollByBehavior;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnKeyInterceptListener {
        boolean onInterceptKeyEvent(KeyEvent keyEvent);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnLayoutCompletedListener {
        void onLayoutCompleted(RecyclerView.State state);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnMotionInterceptListener {
        boolean onInterceptMotionEvent(MotionEvent motionEvent);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnTouchInterceptListener {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnUnhandledKeyListener {
        boolean onUnhandledKey(KeyEvent keyEvent);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface SmoothScrollByBehavior {
        int configSmoothScrollByDuration(int i10, int i11);

        Interpolator configSmoothScrollByInterpolator(int i10, int i11);
    }

    public BaseGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAnimateChildLayout = true;
        this.mHasOverlappingRendering = true;
        this.mInitialPrefetchItemCount = 4;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this);
        this.mLayoutManager = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        setPreserveFocusAfterLayout(false);
        setDescendantFocusability(262144);
        setHasFixedSize(true);
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setOverScrollMode(2);
        ((SimpleItemAnimator) getItemAnimator()).setSupportsChangeAnimations(false);
        super.addRecyclerListener(new RecyclerView.RecyclerListener() { // from class: androidx.leanback.widget.BaseGridView.1
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                BaseGridView.this.mLayoutManager.onChildRecycled(viewHolder);
            }
        });
    }

    public void addOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.addOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public final void addOnLayoutCompletedListener(OnLayoutCompletedListener onLayoutCompletedListener) {
        this.mLayoutManager.addOnLayoutCompletedListener(onLayoutCompletedListener);
    }

    public void animateIn() {
        this.mLayoutManager.slideIn();
    }

    public void animateOut() {
        this.mLayoutManager.slideOut();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        OnMotionInterceptListener onMotionInterceptListener = this.mOnMotionInterceptListener;
        if (onMotionInterceptListener == null || !onMotionInterceptListener.onInterceptMotionEvent(motionEvent)) {
            return super.dispatchGenericFocusedEvent(motionEvent);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        OnKeyInterceptListener onKeyInterceptListener = this.mOnKeyInterceptListener;
        if ((onKeyInterceptListener != null && onKeyInterceptListener.onInterceptKeyEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        OnUnhandledKeyListener onUnhandledKeyListener = this.mOnUnhandledKeyListener;
        return onUnhandledKeyListener != null && onUnhandledKeyListener.onUnhandledKey(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        OnTouchInterceptListener onTouchInterceptListener = this.mOnTouchInterceptListener;
        if (onTouchInterceptListener == null || !onTouchInterceptListener.onInterceptTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public View focusSearch(int i10) {
        if (isFocused()) {
            GridLayoutManager gridLayoutManager = this.mLayoutManager;
            View viewFindViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.getSelection());
            if (viewFindViewByPosition != null) {
                return focusSearch(viewFindViewByPosition, i10);
            }
        }
        return super.focusSearch(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        return this.mLayoutManager.getChildDrawingOrder(this, i10, i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getExtraLayoutSpace() {
        return this.mLayoutManager.getExtraLayoutSpace();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getFocusScrollStrategy() {
        return this.mLayoutManager.getFocusScrollStrategy();
    }

    @Deprecated
    public int getHorizontalMargin() {
        return this.mLayoutManager.getHorizontalSpacing();
    }

    public int getHorizontalSpacing() {
        return this.mLayoutManager.getHorizontalSpacing();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getItemAlignmentOffset() {
        return this.mLayoutManager.getItemAlignmentOffset();
    }

    public float getItemAlignmentOffsetPercent() {
        return this.mLayoutManager.getItemAlignmentOffsetPercent();
    }

    public int getItemAlignmentViewId() {
        return this.mLayoutManager.getItemAlignmentViewId();
    }

    public OnUnhandledKeyListener getOnUnhandledKeyListener() {
        return this.mOnUnhandledKeyListener;
    }

    public final int getSaveChildrenLimitNumber() {
        return this.mLayoutManager.mChildrenStates.getLimitNumber();
    }

    public final int getSaveChildrenPolicy() {
        return this.mLayoutManager.mChildrenStates.getSavePolicy();
    }

    public int getSelectedPosition() {
        return this.mLayoutManager.getSelection();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getSelectedSubPosition() {
        return this.mLayoutManager.getSubSelection();
    }

    public SmoothScrollByBehavior getSmoothScrollByBehavior() {
        return this.mSmoothScrollByBehavior;
    }

    public final int getSmoothScrollMaxPendingMoves() {
        return this.mLayoutManager.mMaxPendingMoves;
    }

    public final float getSmoothScrollSpeedFactor() {
        return this.mLayoutManager.mSmoothScrollSpeedFactor;
    }

    @Deprecated
    public int getVerticalMargin() {
        return this.mLayoutManager.getVerticalSpacing();
    }

    public int getVerticalSpacing() {
        return this.mLayoutManager.getVerticalSpacing();
    }

    public void getViewSelectedOffsets(View view, int[] iArr) {
        this.mLayoutManager.getViewSelectedOffsets(view, iArr);
    }

    public int getWindowAlignment() {
        return this.mLayoutManager.getWindowAlignment();
    }

    public int getWindowAlignmentOffset() {
        return this.mLayoutManager.getWindowAlignmentOffset();
    }

    public float getWindowAlignmentOffsetPercent() {
        return this.mLayoutManager.getWindowAlignmentOffsetPercent();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    public boolean hasPreviousViewInSameRow(int i10) {
        return this.mLayoutManager.hasPreviousViewInSameRow(i10);
    }

    @SuppressLint({"CustomViewStyleable"})
    public void initBaseGridViewAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseGridView);
        this.mLayoutManager.setFocusOutAllowed(typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutFront, false), typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutEnd, false));
        this.mLayoutManager.setFocusOutSideAllowed(typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideStart, true), typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideEnd, true));
        this.mLayoutManager.setVerticalSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_verticalSpacing, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_verticalMargin, 0)));
        this.mLayoutManager.setHorizontalSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_horizontalSpacing, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_horizontalMargin, 0)));
        int i10 = R.styleable.lbBaseGridView_android_gravity;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            setGravity(typedArrayObtainStyledAttributes.getInt(i10, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean isChildLayoutAnimated() {
        return this.mAnimateChildLayout;
    }

    public final boolean isChildrenDrawingOrderEnabledInternal() {
        return isChildrenDrawingOrderEnabled();
    }

    public boolean isFocusDrawingOrderEnabled() {
        return super.isChildrenDrawingOrderEnabled();
    }

    public final boolean isFocusSearchDisabled() {
        return this.mLayoutManager.isFocusSearchDisabled();
    }

    public boolean isItemAlignmentOffsetWithPadding() {
        return this.mLayoutManager.isItemAlignmentOffsetWithPadding();
    }

    public boolean isScrollEnabled() {
        return this.mLayoutManager.isScrollEnabled();
    }

    public boolean isWindowAlignmentPreferKeyLineOverHighEdge() {
        return this.mLayoutManager.mWindowAlignment.mainAxis().isPreferKeylineOverHighEdge();
    }

    public boolean isWindowAlignmentPreferKeyLineOverLowEdge() {
        return this.mLayoutManager.mWindowAlignment.mainAxis().isPreferKeylineOverLowEdge();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z9, int i10, Rect rect) {
        super.onFocusChanged(z9, i10, rect);
        this.mLayoutManager.onFocusChanged(z9, i10, rect);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if ((this.mPrivateFlag & 1) == 1) {
            return false;
        }
        return this.mLayoutManager.gridOnRequestFocusInDescendants(this, i10, rect);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        GridLayoutManager gridLayoutManager = this.mLayoutManager;
        if (gridLayoutManager != null) {
            gridLayoutManager.onRtlPropertiesChanged(i10);
        }
    }

    public void removeOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.removeOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public final void removeOnLayoutCompletedListener(OnLayoutCompletedListener onLayoutCompletedListener) {
        this.mLayoutManager.removeOnLayoutCompletedListener(onLayoutCompletedListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        boolean z9 = view.hasFocus() && isFocusable();
        if (z9) {
            this.mPrivateFlag = 1 | this.mPrivateFlag;
            requestFocus();
        }
        super.removeView(view);
        if (z9) {
            this.mPrivateFlag ^= -2;
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        boolean zHasFocus = getChildAt(i10).hasFocus();
        if (zHasFocus) {
            this.mPrivateFlag |= 1;
            requestFocus();
        }
        super.removeViewAt(i10);
        if (zHasFocus) {
            this.mPrivateFlag ^= -2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i10) {
        if (this.mLayoutManager.isSlidingChildViews()) {
            this.mLayoutManager.setSelectionWithSub(i10, 0, 0);
        } else {
            super.scrollToPosition(i10);
        }
    }

    public void setAnimateChildLayout(boolean z9) {
        if (this.mAnimateChildLayout != z9) {
            this.mAnimateChildLayout = z9;
            if (z9) {
                super.setItemAnimator(this.mSavedItemAnimator);
            } else {
                this.mSavedItemAnimator = getItemAnimator();
                super.setItemAnimator(null);
            }
        }
    }

    public void setChildrenVisibility(int i10) {
        this.mLayoutManager.setChildrenVisibility(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExtraLayoutSpace(int i10) {
        this.mLayoutManager.setExtraLayoutSpace(i10);
    }

    public void setFocusDrawingOrderEnabled(boolean z9) {
        super.setChildrenDrawingOrderEnabled(z9);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setFocusScrollStrategy(int i10) {
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            com.google.gson.internal.a.n("Invalid scrollStrategy");
        } else {
            this.mLayoutManager.setFocusScrollStrategy(i10);
            requestLayout();
        }
    }

    public final void setFocusSearchDisabled(boolean z9) {
        setDescendantFocusability(z9 ? 393216 : 262144);
        this.mLayoutManager.setFocusSearchDisabled(z9);
    }

    public void setGravity(int i10) {
        this.mLayoutManager.setGravity(i10);
        requestLayout();
    }

    public void setHasOverlappingRendering(boolean z9) {
        this.mHasOverlappingRendering = z9;
    }

    @Deprecated
    public void setHorizontalMargin(int i10) {
        setHorizontalSpacing(i10);
    }

    public void setHorizontalSpacing(int i10) {
        this.mLayoutManager.setHorizontalSpacing(i10);
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.mInitialPrefetchItemCount = i10;
    }

    public void setItemAlignmentOffset(int i10) {
        this.mLayoutManager.setItemAlignmentOffset(i10);
        requestLayout();
    }

    public void setItemAlignmentOffsetPercent(float f) {
        this.mLayoutManager.setItemAlignmentOffsetPercent(f);
        requestLayout();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z9) {
        this.mLayoutManager.setItemAlignmentOffsetWithPadding(z9);
        requestLayout();
    }

    public void setItemAlignmentViewId(int i10) {
        this.mLayoutManager.setItemAlignmentViewId(i10);
    }

    @Deprecated
    public void setItemMargin(int i10) {
        setItemSpacing(i10);
    }

    public void setItemSpacing(int i10) {
        this.mLayoutManager.setItemSpacing(i10);
        requestLayout();
    }

    public void setLayoutEnabled(boolean z9) {
        this.mLayoutManager.setLayoutEnabled(z9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.mLayoutManager = gridLayoutManager;
            gridLayoutManager.setGridView(this);
            super.setLayoutManager(layoutManager);
            return;
        }
        super.setLayoutManager(null);
        GridLayoutManager gridLayoutManager2 = this.mLayoutManager;
        if (gridLayoutManager2 != null) {
            gridLayoutManager2.setGridView(null);
        }
        this.mLayoutManager = null;
    }

    public void setOnChildLaidOutListener(OnChildLaidOutListener onChildLaidOutListener) {
        this.mLayoutManager.setOnChildLaidOutListener(onChildLaidOutListener);
    }

    @SuppressLint({"ReferencesDeprecated"})
    public void setOnChildSelectedListener(OnChildSelectedListener onChildSelectedListener) {
        this.mLayoutManager.setOnChildSelectedListener(onChildSelectedListener);
    }

    public void setOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.setOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public void setOnKeyInterceptListener(OnKeyInterceptListener onKeyInterceptListener) {
        this.mOnKeyInterceptListener = onKeyInterceptListener;
    }

    public void setOnMotionInterceptListener(OnMotionInterceptListener onMotionInterceptListener) {
        this.mOnMotionInterceptListener = onMotionInterceptListener;
    }

    public void setOnTouchInterceptListener(OnTouchInterceptListener onTouchInterceptListener) {
        this.mOnTouchInterceptListener = onTouchInterceptListener;
    }

    public void setOnUnhandledKeyListener(OnUnhandledKeyListener onUnhandledKeyListener) {
        this.mOnUnhandledKeyListener = onUnhandledKeyListener;
    }

    public void setPruneChild(boolean z9) {
        this.mLayoutManager.setPruneChild(z9);
    }

    public final void setSaveChildrenLimitNumber(int i10) {
        this.mLayoutManager.mChildrenStates.setLimitNumber(i10);
    }

    public final void setSaveChildrenPolicy(int i10) {
        this.mLayoutManager.mChildrenStates.setSavePolicy(i10);
    }

    public void setScrollEnabled(boolean z9) {
        this.mLayoutManager.setScrollEnabled(z9);
    }

    public void setSelectedPosition(final int i10, final ViewHolderTask viewHolderTask) {
        if (viewHolderTask != null) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition = findViewHolderForPosition(i10);
            if (viewHolderFindViewHolderForPosition == null || hasPendingAdapterUpdates()) {
                addOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() { // from class: androidx.leanback.widget.BaseGridView.3
                    @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
                    public void onChildViewHolderSelectedAndPositioned(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i11, int i12) {
                        if (i11 == i10) {
                            BaseGridView.this.removeOnChildViewHolderSelectedListener(this);
                            viewHolderTask.run(viewHolder);
                        }
                    }
                });
            } else {
                viewHolderTask.run(viewHolderFindViewHolderForPosition);
            }
        }
        setSelectedPosition(i10);
    }

    public void setSelectedPositionSmooth(final int i10, final ViewHolderTask viewHolderTask) {
        if (viewHolderTask != null) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition = findViewHolderForPosition(i10);
            if (viewHolderFindViewHolderForPosition == null || hasPendingAdapterUpdates()) {
                addOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() { // from class: androidx.leanback.widget.BaseGridView.2
                    @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
                    public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i11, int i12) {
                        if (i11 == i10) {
                            BaseGridView.this.removeOnChildViewHolderSelectedListener(this);
                            viewHolderTask.run(viewHolder);
                        }
                    }
                });
            } else {
                viewHolderTask.run(viewHolderFindViewHolderForPosition);
            }
        }
        setSelectedPositionSmooth(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionSmoothWithSub(int i10, int i11) {
        this.mLayoutManager.setSelectionSmoothWithSub(i10, i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionWithSub(int i10, int i11) {
        this.mLayoutManager.setSelectionWithSub(i10, i11, 0);
    }

    public final void setSmoothScrollByBehavior(SmoothScrollByBehavior smoothScrollByBehavior) {
        this.mSmoothScrollByBehavior = smoothScrollByBehavior;
    }

    public final void setSmoothScrollMaxPendingMoves(int i10) {
        this.mLayoutManager.mMaxPendingMoves = i10;
    }

    public final void setSmoothScrollSpeedFactor(float f) {
        this.mLayoutManager.mSmoothScrollSpeedFactor = f;
    }

    @Deprecated
    public void setVerticalMargin(int i10) {
        setVerticalSpacing(i10);
    }

    public void setVerticalSpacing(int i10) {
        this.mLayoutManager.setVerticalSpacing(i10);
        requestLayout();
    }

    public void setWindowAlignment(int i10) {
        this.mLayoutManager.setWindowAlignment(i10);
        requestLayout();
    }

    public void setWindowAlignmentOffset(int i10) {
        this.mLayoutManager.setWindowAlignmentOffset(i10);
        requestLayout();
    }

    public void setWindowAlignmentOffsetPercent(float f) {
        this.mLayoutManager.setWindowAlignmentOffsetPercent(f);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverHighEdge(boolean z9) {
        this.mLayoutManager.mWindowAlignment.mainAxis().setPreferKeylineOverHighEdge(z9);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverLowEdge(boolean z9) {
        this.mLayoutManager.mWindowAlignment.mainAxis().setPreferKeylineOverLowEdge(z9);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i10, int i11) {
        SmoothScrollByBehavior smoothScrollByBehavior = this.mSmoothScrollByBehavior;
        if (smoothScrollByBehavior != null) {
            smoothScrollBy(i10, i11, smoothScrollByBehavior.configSmoothScrollByInterpolator(i10, i11), this.mSmoothScrollByBehavior.configSmoothScrollByDuration(i10, i11));
        } else {
            smoothScrollBy(i10, i11, null, Integer.MIN_VALUE);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i10) {
        if (this.mLayoutManager.isSlidingChildViews()) {
            this.mLayoutManager.setSelectionWithSub(i10, 0, 0);
        } else {
            super.smoothScrollToPosition(i10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionWithSub(int i10, int i11, int i12) {
        this.mLayoutManager.setSelectionWithSub(i10, i11, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i10, int i11, Interpolator interpolator) {
        SmoothScrollByBehavior smoothScrollByBehavior = this.mSmoothScrollByBehavior;
        if (smoothScrollByBehavior != null) {
            smoothScrollBy(i10, i11, interpolator, smoothScrollByBehavior.configSmoothScrollByDuration(i10, i11));
        } else {
            smoothScrollBy(i10, i11, interpolator, Integer.MIN_VALUE);
        }
    }

    public void setSelectedPosition(int i10, int i11) {
        this.mLayoutManager.setSelection(i10, i11);
    }

    public void setSelectedPositionSmooth(int i10) {
        this.mLayoutManager.setSelectionSmooth(i10);
    }

    public void setSelectedPosition(int i10) {
        this.mLayoutManager.setSelection(i10, 0);
    }
}
