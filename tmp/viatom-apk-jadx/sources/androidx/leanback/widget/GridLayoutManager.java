package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.GridView;
import androidx.annotation.VisibleForTesting;
import androidx.collection.CircularIntArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.Grid;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.leanback.widget.WindowAlignment;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class GridLayoutManager extends RecyclerView.LayoutManager {
    static final boolean DEBUG = false;
    static final int DEFAULT_MAX_PENDING_MOVES = 10;
    static final int MIN_MS_SMOOTH_SCROLL_MAIN_SCREEN = 30;
    private static final int NEXT_ITEM = 1;
    private static final int NEXT_ROW = 3;
    static final int PF_FAST_RELAYOUT = 4;
    static final int PF_FAST_RELAYOUT_UPDATED_SELECTED_POSITION = 8;
    static final int PF_FOCUS_OUT_BACK = 4096;
    static final int PF_FOCUS_OUT_FRONT = 2048;
    static final int PF_FOCUS_OUT_MASKS = 6144;
    static final int PF_FOCUS_OUT_SIDE_END = 16384;
    static final int PF_FOCUS_OUT_SIDE_MASKS = 24576;
    static final int PF_FOCUS_OUT_SIDE_START = 8192;
    static final int PF_FOCUS_SEARCH_DISABLED = 32768;
    static final int PF_FORCE_FULL_LAYOUT = 256;
    static final int PF_IN_LAYOUT_SEARCH_FOCUS = 16;
    static final int PF_IN_SELECTION = 32;
    static final int PF_LAYOUT_EATEN_IN_SLIDING = 128;
    static final int PF_LAYOUT_ENABLED = 512;
    static final int PF_PRUNE_CHILD = 65536;
    static final int PF_REVERSE_FLOW_MASK = 786432;
    static final int PF_REVERSE_FLOW_PRIMARY = 262144;
    static final int PF_REVERSE_FLOW_SECONDARY = 524288;
    static final int PF_ROW_SECONDARY_SIZE_REFRESH = 1024;
    static final int PF_SCROLL_ENABLED = 131072;
    static final int PF_SLIDING = 64;
    static final int PF_STAGE_LAYOUT = 1;
    static final int PF_STAGE_MASK = 3;
    static final int PF_STAGE_SCROLL = 2;
    private static final int PREV_ITEM = 0;
    private static final int PREV_ROW = 2;
    private static final String TAG = "GridLayoutManager";
    private static final Rect sTempRect = new Rect();
    static int[] sTwoInts = new int[2];
    AudioManager mAudioManager;
    BaseGridView mBaseGridView;
    OnChildLaidOutListener mChildLaidOutListener;
    private OnChildSelectedListener mChildSelectedListener;
    private ArrayList<OnChildViewHolderSelectedListener> mChildViewHolderSelectedListeners;
    int mChildVisibility;
    final ViewsStateBundle mChildrenStates;
    GridLinearSmoothScroller mCurrentSmoothScroller;
    int[] mDisappearingPositions;
    private int mExtraLayoutSpace;
    int mExtraLayoutSpaceInPreLayout;
    private FacetProviderAdapter mFacetProviderAdapter;
    private int mFixedRowSizeSecondary;
    int mFlag;
    int mFocusPosition;
    private int mFocusPositionOffset;
    private int mFocusScrollStrategy;
    private int mGravity;
    Grid mGrid;
    private final Grid.Provider mGridProvider;
    private int mHorizontalSpacing;
    private final ItemAlignment mItemAlignment;
    int mMaxPendingMoves;
    private int mMaxSizeSecondary;
    private final int[] mMeasuredDimension;
    int mNumRows;
    private int mNumRowsRequested;

    @VisibleForTesting
    ArrayList<BaseGridView.OnLayoutCompletedListener> mOnLayoutCompletedListeners;
    int mOrientation;
    private OrientationHelper mOrientationHelper;
    PendingMoveSmoothScroller mPendingMoveSmoothScroller;
    int mPositionDeltaInPreLayout;
    final SparseIntArray mPositionToRowInPostLayout;
    private int mPrimaryScrollExtra;
    RecyclerView.Recycler mRecycler;
    private final Runnable mRequestLayoutRunnable;
    private int[] mRowSizeSecondary;
    private int mRowSizeSecondaryRequested;
    private int mSaveContextLevel;
    int mScrollOffsetSecondary;
    private int mSizePrimary;
    float mSmoothScrollSpeedFactor;
    private int mSpacingPrimary;
    private int mSpacingSecondary;
    RecyclerView.State mState;
    int mSubFocusPosition;
    private int mVerticalSpacing;
    final WindowAlignment mWindowAlignment;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public abstract class GridLinearSmoothScroller extends LinearSmoothScroller {
        boolean mSkipOnStopInternal;

        public GridLinearSmoothScroller() {
            super(GridLayoutManager.this.mBaseGridView.getContext());
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return super.calculateSpeedPerPixel(displayMetrics) * GridLayoutManager.this.mSmoothScrollSpeedFactor;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i10) {
            int iCalculateTimeForScrolling = super.calculateTimeForScrolling(i10);
            if (GridLayoutManager.this.mWindowAlignment.mainAxis().getSize() > 0) {
                float size = (30.0f / GridLayoutManager.this.mWindowAlignment.mainAxis().getSize()) * i10;
                if (iCalculateTimeForScrolling < size) {
                    return (int) size;
                }
            }
            return iCalculateTimeForScrolling;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStop() {
            super.onStop();
            if (!this.mSkipOnStopInternal) {
                onStopInternal();
            }
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            if (gridLayoutManager.mCurrentSmoothScroller == this) {
                gridLayoutManager.mCurrentSmoothScroller = null;
            }
            if (gridLayoutManager.mPendingMoveSmoothScroller == this) {
                gridLayoutManager.mPendingMoveSmoothScroller = null;
            }
        }

        public void onStopInternal() {
            View viewFindViewByPosition = findViewByPosition(getTargetPosition());
            if (viewFindViewByPosition == null) {
                if (getTargetPosition() >= 0) {
                    GridLayoutManager.this.scrollToSelection(getTargetPosition(), 0, false, 0);
                    return;
                }
                return;
            }
            if (GridLayoutManager.this.mFocusPosition != getTargetPosition()) {
                GridLayoutManager.this.mFocusPosition = getTargetPosition();
            }
            if (GridLayoutManager.this.hasFocus()) {
                GridLayoutManager.this.mFlag |= 32;
                viewFindViewByPosition.requestFocus();
                GridLayoutManager.this.mFlag &= -33;
            }
            GridLayoutManager.this.dispatchChildSelected();
            GridLayoutManager.this.dispatchChildSelectedAndPositioned();
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int i10;
            int i11;
            if (GridLayoutManager.this.getScrollPosition(view, null, GridLayoutManager.sTwoInts)) {
                if (GridLayoutManager.this.mOrientation == 0) {
                    int[] iArr = GridLayoutManager.sTwoInts;
                    i11 = iArr[0];
                    i10 = iArr[1];
                } else {
                    int[] iArr2 = GridLayoutManager.sTwoInts;
                    int i12 = iArr2[1];
                    i10 = iArr2[0];
                    i11 = i12;
                }
                action.update(i11, i10, calculateTimeForDeceleration((int) Math.sqrt((i10 * i10) + (i11 * i11))), this.mDecelerateInterpolator);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class PendingMoveSmoothScroller extends GridLinearSmoothScroller {
        static final int TARGET_UNDEFINED = -2;
        private int mPendingMoves;
        private final boolean mStaggeredGrid;

        public PendingMoveSmoothScroller(int i10, boolean z9) {
            super();
            this.mPendingMoves = i10;
            this.mStaggeredGrid = z9;
            setTargetPosition(-2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i10) {
            int i11 = this.mPendingMoves;
            if (i11 == 0) {
                return null;
            }
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            int i12 = ((gridLayoutManager.mFlag & 262144) == 0 ? i11 >= 0 : i11 <= 0) ? 1 : -1;
            return gridLayoutManager.mOrientation == 0 ? new PointF(i12, 0.0f) : new PointF(0.0f, i12);
        }

        public void consumePendingMovesAfterLayout() {
            int i10;
            if (this.mStaggeredGrid && (i10 = this.mPendingMoves) != 0) {
                this.mPendingMoves = GridLayoutManager.this.processSelectionMoves(true, i10);
            }
            int i11 = this.mPendingMoves;
            if (i11 == 0 || ((i11 > 0 && GridLayoutManager.this.hasCreatedLastItem()) || (this.mPendingMoves < 0 && GridLayoutManager.this.hasCreatedFirstItem()))) {
                setTargetPosition(GridLayoutManager.this.mFocusPosition);
                stop();
            }
        }

        public void consumePendingMovesBeforeLayout() {
            int i10;
            View viewFindViewByPosition;
            if (this.mStaggeredGrid || (i10 = this.mPendingMoves) == 0) {
                return;
            }
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            int i11 = i10 > 0 ? gridLayoutManager.mFocusPosition + gridLayoutManager.mNumRows : gridLayoutManager.mFocusPosition - gridLayoutManager.mNumRows;
            View view = null;
            while (this.mPendingMoves != 0 && (viewFindViewByPosition = findViewByPosition(i11)) != null) {
                if (GridLayoutManager.this.canScrollTo(viewFindViewByPosition)) {
                    GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                    gridLayoutManager2.mFocusPosition = i11;
                    gridLayoutManager2.mSubFocusPosition = 0;
                    int i12 = this.mPendingMoves;
                    if (i12 > 0) {
                        this.mPendingMoves = i12 - 1;
                    } else {
                        this.mPendingMoves = i12 + 1;
                    }
                    view = viewFindViewByPosition;
                }
                int i13 = this.mPendingMoves;
                GridLayoutManager gridLayoutManager3 = GridLayoutManager.this;
                i11 = i13 > 0 ? i11 + gridLayoutManager3.mNumRows : i11 - gridLayoutManager3.mNumRows;
            }
            if (view == null || !GridLayoutManager.this.hasFocus()) {
                return;
            }
            GridLayoutManager.this.mFlag |= 32;
            view.requestFocus();
            GridLayoutManager.this.mFlag &= -33;
        }

        public void decreasePendingMoves() {
            int i10 = this.mPendingMoves;
            if (i10 > (-GridLayoutManager.this.mMaxPendingMoves)) {
                this.mPendingMoves = i10 - 1;
            }
        }

        public void increasePendingMoves() {
            int i10 = this.mPendingMoves;
            if (i10 < GridLayoutManager.this.mMaxPendingMoves) {
                this.mPendingMoves = i10 + 1;
            }
        }

        @Override // androidx.leanback.widget.GridLayoutManager.GridLinearSmoothScroller
        public void onStopInternal() {
            super.onStopInternal();
            this.mPendingMoves = 0;
            View viewFindViewByPosition = findViewByPosition(getTargetPosition());
            if (viewFindViewByPosition != null) {
                GridLayoutManager.this.scrollToView(viewFindViewByPosition, true);
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    public GridLayoutManager(BaseGridView baseGridView) {
        this.mSmoothScrollSpeedFactor = 1.0f;
        this.mMaxPendingMoves = 10;
        this.mOrientation = 0;
        this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
        this.mPositionToRowInPostLayout = new SparseIntArray();
        this.mFlag = 221696;
        this.mChildSelectedListener = null;
        this.mChildViewHolderSelectedListeners = null;
        this.mOnLayoutCompletedListeners = null;
        this.mChildLaidOutListener = null;
        this.mFocusPosition = -1;
        this.mSubFocusPosition = 0;
        this.mFocusPositionOffset = 0;
        this.mGravity = 8388659;
        this.mNumRowsRequested = 1;
        this.mFocusScrollStrategy = 0;
        this.mWindowAlignment = new WindowAlignment();
        this.mItemAlignment = new ItemAlignment();
        this.mMeasuredDimension = new int[2];
        this.mChildrenStates = new ViewsStateBundle();
        this.mRequestLayoutRunnable = new Runnable() { // from class: androidx.leanback.widget.GridLayoutManager.1
            @Override // java.lang.Runnable
            public void run() {
                GridLayoutManager.this.requestLayout();
            }
        };
        this.mGridProvider = new Grid.Provider() { // from class: androidx.leanback.widget.GridLayoutManager.2
            @Override // androidx.leanback.widget.Grid.Provider
            public void addItem(Object obj, int i10, int i11, int i12, int i13) {
                int i14;
                int i15;
                PendingMoveSmoothScroller pendingMoveSmoothScroller;
                View view = (View) obj;
                if (i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE) {
                    boolean zIsReversedFlow = GridLayoutManager.this.mGrid.isReversedFlow();
                    GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                    i13 = !zIsReversedFlow ? gridLayoutManager.mWindowAlignment.mainAxis().getPaddingMin() : gridLayoutManager.mWindowAlignment.mainAxis().getSize() - GridLayoutManager.this.mWindowAlignment.mainAxis().getPaddingMax();
                }
                if (GridLayoutManager.this.mGrid.isReversedFlow()) {
                    i14 = i13 - i11;
                    i15 = i13;
                } else {
                    i15 = i11 + i13;
                    i14 = i13;
                }
                int rowStartSecondary = GridLayoutManager.this.getRowStartSecondary(i12) + GridLayoutManager.this.mWindowAlignment.secondAxis().getPaddingMin();
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                int i16 = rowStartSecondary - gridLayoutManager2.mScrollOffsetSecondary;
                gridLayoutManager2.mChildrenStates.loadView(view, i10);
                GridLayoutManager.this.layoutChild(i12, view, i14, i15, i16);
                if (!GridLayoutManager.this.mState.isPreLayout()) {
                    GridLayoutManager.this.updateScrollLimits();
                }
                GridLayoutManager gridLayoutManager3 = GridLayoutManager.this;
                if ((gridLayoutManager3.mFlag & 3) != 1 && (pendingMoveSmoothScroller = gridLayoutManager3.mPendingMoveSmoothScroller) != null) {
                    pendingMoveSmoothScroller.consumePendingMovesAfterLayout();
                }
                GridLayoutManager gridLayoutManager4 = GridLayoutManager.this;
                if (gridLayoutManager4.mChildLaidOutListener != null) {
                    RecyclerView.ViewHolder childViewHolder = gridLayoutManager4.mBaseGridView.getChildViewHolder(view);
                    GridLayoutManager gridLayoutManager5 = GridLayoutManager.this;
                    gridLayoutManager5.mChildLaidOutListener.onChildLaidOut(gridLayoutManager5.mBaseGridView, view, i10, childViewHolder == null ? -1L : childViewHolder.getItemId());
                }
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int createItem(int i10, boolean z9, Object[] objArr, boolean z10) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                View viewForPosition = gridLayoutManager.getViewForPosition(i10 - gridLayoutManager.mPositionDeltaInPreLayout);
                if (!((LayoutParams) viewForPosition.getLayoutParams()).isItemRemoved()) {
                    if (z10) {
                        GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                        if (z9) {
                            gridLayoutManager2.addDisappearingView(viewForPosition);
                        } else {
                            gridLayoutManager2.addDisappearingView(viewForPosition, 0);
                        }
                    } else {
                        GridLayoutManager gridLayoutManager3 = GridLayoutManager.this;
                        if (z9) {
                            gridLayoutManager3.addView(viewForPosition);
                        } else {
                            gridLayoutManager3.addView(viewForPosition, 0);
                        }
                    }
                    int i11 = GridLayoutManager.this.mChildVisibility;
                    if (i11 != -1) {
                        viewForPosition.setVisibility(i11);
                    }
                    PendingMoveSmoothScroller pendingMoveSmoothScroller = GridLayoutManager.this.mPendingMoveSmoothScroller;
                    if (pendingMoveSmoothScroller != null) {
                        pendingMoveSmoothScroller.consumePendingMovesBeforeLayout();
                    }
                    int subPositionByView = GridLayoutManager.this.getSubPositionByView(viewForPosition, viewForPosition.findFocus());
                    GridLayoutManager gridLayoutManager4 = GridLayoutManager.this;
                    int i12 = gridLayoutManager4.mFlag;
                    if ((i12 & 3) != 1) {
                        if (i10 == gridLayoutManager4.mFocusPosition && subPositionByView == gridLayoutManager4.mSubFocusPosition && gridLayoutManager4.mPendingMoveSmoothScroller == null) {
                            gridLayoutManager4.dispatchChildSelected();
                        }
                    } else if ((i12 & 4) == 0) {
                        if ((i12 & 16) == 0 && i10 == gridLayoutManager4.mFocusPosition && subPositionByView == gridLayoutManager4.mSubFocusPosition) {
                            gridLayoutManager4.dispatchChildSelected();
                        } else if ((i12 & 16) != 0 && i10 >= gridLayoutManager4.mFocusPosition && viewForPosition.hasFocusable()) {
                            GridLayoutManager gridLayoutManager5 = GridLayoutManager.this;
                            gridLayoutManager5.mFocusPosition = i10;
                            gridLayoutManager5.mSubFocusPosition = subPositionByView;
                            gridLayoutManager5.mFlag &= -17;
                            gridLayoutManager5.dispatchChildSelected();
                        }
                    }
                    GridLayoutManager.this.measureChild(viewForPosition);
                }
                objArr[0] = viewForPosition;
                GridLayoutManager gridLayoutManager6 = GridLayoutManager.this;
                return gridLayoutManager6.mOrientation == 0 ? gridLayoutManager6.getDecoratedMeasuredWidthWithMargin(viewForPosition) : gridLayoutManager6.getDecoratedMeasuredHeightWithMargin(viewForPosition);
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int getCount() {
                return GridLayoutManager.this.mState.getItemCount() + GridLayoutManager.this.mPositionDeltaInPreLayout;
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int getEdge(int i10) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i10 - gridLayoutManager.mPositionDeltaInPreLayout);
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                return (gridLayoutManager2.mFlag & 262144) != 0 ? gridLayoutManager2.getViewMax(viewFindViewByPosition) : gridLayoutManager2.getViewMin(viewFindViewByPosition);
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int getMinIndex() {
                return GridLayoutManager.this.mPositionDeltaInPreLayout;
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int getSize(int i10) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                return gridLayoutManager.getViewPrimarySize(gridLayoutManager.findViewByPosition(i10 - gridLayoutManager.mPositionDeltaInPreLayout));
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public void removeItem(int i10) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i10 - gridLayoutManager.mPositionDeltaInPreLayout);
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                if ((gridLayoutManager2.mFlag & 3) == 1) {
                    gridLayoutManager2.detachAndScrapView(viewFindViewByPosition, gridLayoutManager2.mRecycler);
                } else {
                    gridLayoutManager2.removeAndRecycleView(viewFindViewByPosition, gridLayoutManager2.mRecycler);
                }
            }
        };
        this.mBaseGridView = baseGridView;
        this.mChildVisibility = -1;
        setItemPrefetchEnabled(false);
    }

    private void addA11yActionMovingBackward(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, boolean z9) {
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.addAction(z9 ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT);
        } else {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        }
        accessibilityNodeInfoCompat.setScrollable(true);
    }

    private void addA11yActionMovingForward(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, boolean z9) {
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.addAction(z9 ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT);
        } else {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
        }
        accessibilityNodeInfoCompat.setScrollable(true);
    }

    private boolean appendOneColumnVisibleItems() {
        return this.mGrid.appendOneColumnVisibleItems();
    }

    private void appendVisibleItems() {
        this.mGrid.appendVisibleItems((this.mFlag & 262144) != 0 ? (-this.mExtraLayoutSpace) - this.mExtraLayoutSpaceInPreLayout : this.mSizePrimary + this.mExtraLayoutSpace + this.mExtraLayoutSpaceInPreLayout);
    }

    private void discardLayoutInfo() {
        this.mGrid = null;
        this.mRowSizeSecondary = null;
        this.mFlag &= -1025;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[LOOP:1: B:21:0x0088->B:22:0x008a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb A[LOOP:3: B:31:0x00bb->B:48:?, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void fastRelayout() {
        /*
            r13 = this;
            int r0 = r13.getChildCount()
            androidx.leanback.widget.Grid r1 = r13.mGrid
            int r1 = r1.getFirstVisibleIndex()
            int r2 = r13.mFlag
            r2 = r2 & (-9)
            r13.mFlag = r2
            r2 = 0
        L11:
            if (r2 >= r0) goto Ld2
            android.view.View r3 = r13.getChildAt(r2)
            int r4 = r13.getAdapterPositionByView(r3)
            if (r1 == r4) goto L1f
        L1d:
            r7 = r13
            goto L80
        L1f:
            androidx.leanback.widget.Grid r4 = r13.mGrid
            androidx.leanback.widget.Grid$Location r4 = r4.getLocation(r1)
            if (r4 != 0) goto L28
            goto L1d
        L28:
            int r5 = r4.mRow
            int r5 = r13.getRowStartSecondary(r5)
            androidx.leanback.widget.WindowAlignment r6 = r13.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r6 = r6.secondAxis()
            int r6 = r6.getPaddingMin()
            int r5 = r5 + r6
            int r6 = r13.mScrollOffsetSecondary
            int r12 = r5 - r6
            int r10 = r13.getViewMin(r3)
            int r5 = r13.getViewPrimarySize(r3)
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.leanback.widget.GridLayoutManager$LayoutParams r6 = (androidx.leanback.widget.GridLayoutManager.LayoutParams) r6
            boolean r6 = r6.viewNeedsUpdate()
            if (r6 == 0) goto L63
            int r6 = r13.mFlag
            r6 = r6 | 8
            r13.mFlag = r6
            androidx.recyclerview.widget.RecyclerView$Recycler r6 = r13.mRecycler
            r13.detachAndScrapView(r3, r6)
            android.view.View r3 = r13.getViewForPosition(r1)
            r13.addView(r3, r2)
        L63:
            r9 = r3
            r13.measureChild(r9)
            int r3 = r13.mOrientation
            if (r3 != 0) goto L73
            int r3 = r13.getDecoratedMeasuredWidthWithMargin(r9)
        L6f:
            int r6 = r10 + r3
            r11 = r6
            goto L78
        L73:
            int r3 = r13.getDecoratedMeasuredHeightWithMargin(r9)
            goto L6f
        L78:
            int r8 = r4.mRow
            r7 = r13
            r7.layoutChild(r8, r9, r10, r11, r12)
            if (r5 == r3) goto Lcc
        L80:
            androidx.leanback.widget.Grid r3 = r7.mGrid
            int r3 = r3.getLastVisibleIndex()
            int r0 = r0 + (-1)
        L88:
            if (r0 < r2) goto L96
            android.view.View r4 = r13.getChildAt(r0)
            androidx.recyclerview.widget.RecyclerView$Recycler r5 = r7.mRecycler
            r13.detachAndScrapView(r4, r5)
            int r0 = r0 + (-1)
            goto L88
        L96:
            androidx.leanback.widget.Grid r0 = r7.mGrid
            r0.invalidateItemsAfter(r1)
            int r0 = r7.mFlag
            r1 = 65536(0x10000, float:9.1835E-41)
            r0 = r0 & r1
            if (r0 == 0) goto Lbb
            r13.appendVisibleItems()
            int r0 = r7.mFocusPosition
            if (r0 < 0) goto Ld3
            if (r0 > r3) goto Ld3
        Lab:
            androidx.leanback.widget.Grid r0 = r7.mGrid
            int r0 = r0.getLastVisibleIndex()
            int r1 = r7.mFocusPosition
            if (r0 >= r1) goto Ld3
            androidx.leanback.widget.Grid r0 = r7.mGrid
            r0.appendOneColumnVisibleItems()
            goto Lab
        Lbb:
            androidx.leanback.widget.Grid r0 = r7.mGrid
            boolean r0 = r0.appendOneColumnVisibleItems()
            if (r0 == 0) goto Ld3
            androidx.leanback.widget.Grid r0 = r7.mGrid
            int r0 = r0.getLastVisibleIndex()
            if (r0 >= r3) goto Ld3
            goto Lbb
        Lcc:
            int r2 = r2 + 1
            int r1 = r1 + 1
            goto L11
        Ld2:
            r7 = r13
        Ld3:
            r13.updateScrollLimits()
            r13.updateSecondaryScrollLimits()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.fastRelayout():void");
    }

    private int findImmediateChildIndex(View view) {
        BaseGridView baseGridView;
        View viewFindContainingItemView;
        if (view == null || (baseGridView = this.mBaseGridView) == null || view == baseGridView || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return -1;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (getChildAt(i10) == viewFindContainingItemView) {
                return i10;
            }
        }
        return -1;
    }

    private void focusToViewInLayout(boolean z9, boolean z10, int i10, int i11) {
        View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
        if (viewFindViewByPosition != null && z10) {
            scrollToView(viewFindViewByPosition, false, i10, i11);
        }
        if (viewFindViewByPosition != null && z9 && !viewFindViewByPosition.hasFocus()) {
            viewFindViewByPosition.requestFocus();
            return;
        }
        if (z9 || this.mBaseGridView.hasFocus()) {
            return;
        }
        if (viewFindViewByPosition == null || !viewFindViewByPosition.hasFocusable()) {
            int childCount = getChildCount();
            int i12 = 0;
            while (true) {
                if (i12 < childCount) {
                    viewFindViewByPosition = getChildAt(i12);
                    if (viewFindViewByPosition != null && viewFindViewByPosition.hasFocusable()) {
                        this.mBaseGridView.focusableViewAvailable(viewFindViewByPosition);
                        break;
                    }
                    i12++;
                } else {
                    break;
                }
            }
        } else {
            this.mBaseGridView.focusableViewAvailable(viewFindViewByPosition);
        }
        if (z10 && viewFindViewByPosition != null && viewFindViewByPosition.hasFocus()) {
            scrollToView(viewFindViewByPosition, false, i10, i11);
        }
    }

    private void forceRequestLayout() {
        ViewCompat.postOnAnimation(this.mBaseGridView, this.mRequestLayoutRunnable);
    }

    private int getAdapterPositionByIndex(int i10) {
        return getAdapterPositionByView(getChildAt(i10));
    }

    private int getAdapterPositionByView(View view) {
        LayoutParams layoutParams;
        if (view == null || (layoutParams = (LayoutParams) view.getLayoutParams()) == null || layoutParams.isItemRemoved()) {
            return -1;
        }
        return layoutParams.getAbsoluteAdapterPosition();
    }

    private int getAdjustedPrimaryAlignedScrollDistance(int i10, View view, View view2) {
        int subPositionByView = getSubPositionByView(view, view2);
        if (subPositionByView == 0) {
            return i10;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return (layoutParams.getAlignMultiple()[subPositionByView] - layoutParams.getAlignMultiple()[0]) + i10;
    }

    private boolean getAlignedPosition(View view, View view2, int[] iArr) {
        int primaryAlignedScrollDistance = getPrimaryAlignedScrollDistance(view);
        if (view2 != null) {
            primaryAlignedScrollDistance = getAdjustedPrimaryAlignedScrollDistance(primaryAlignedScrollDistance, view, view2);
        }
        int secondaryScrollDistance = getSecondaryScrollDistance(view);
        int i10 = primaryAlignedScrollDistance + this.mPrimaryScrollExtra;
        if (i10 == 0 && secondaryScrollDistance == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
        iArr[0] = i10;
        iArr[1] = secondaryScrollDistance;
        return true;
    }

    private int getMovement(int i10) {
        int i11 = this.mOrientation;
        if (i11 == 0) {
            if (i10 == 17) {
                return (this.mFlag & 262144) == 0 ? 0 : 1;
            }
            if (i10 == 33) {
                return 2;
            }
            if (i10 == 66) {
                return (this.mFlag & 262144) == 0 ? 1 : 0;
            }
            if (i10 == 130) {
                return 3;
            }
        } else if (i11 == 1) {
            if (i10 == 17) {
                return (this.mFlag & 524288) == 0 ? 2 : 3;
            }
            if (i10 == 33) {
                return 0;
            }
            if (i10 == 66) {
                return (this.mFlag & 524288) == 0 ? 3 : 2;
            }
            if (i10 == 130) {
                return 1;
            }
        }
        return 17;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean getNoneAlignedPosition(android.view.View r13, int[] r14) {
        /*
            r12 = this;
            int r0 = r12.getAdapterPositionByView(r13)
            int r1 = r12.getViewMin(r13)
            int r2 = r12.getViewMax(r13)
            androidx.leanback.widget.WindowAlignment r3 = r12.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r3 = r3.mainAxis()
            int r3 = r3.getPaddingMin()
            androidx.leanback.widget.WindowAlignment r4 = r12.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r4 = r4.mainAxis()
            int r4 = r4.getClientSize()
            androidx.leanback.widget.Grid r5 = r12.mGrid
            int r5 = r5.getRowIndex(r0)
            r6 = 1
            r7 = 0
            r8 = 2
            r9 = 0
            if (r1 >= r3) goto L6f
            int r1 = r12.mFocusScrollStrategy
            if (r1 != r8) goto L6c
            r1 = r13
        L31:
            boolean r10 = r12.prependOneColumnVisibleItems()
            if (r10 == 0) goto L69
            androidx.leanback.widget.Grid r1 = r12.mGrid
            int r10 = r1.getFirstVisibleIndex()
            androidx.collection.CircularIntArray[] r1 = r1.getItemPositionsInRows(r10, r0)
            r1 = r1[r5]
            int r10 = r1.get(r7)
            android.view.View r10 = r12.findViewByPosition(r10)
            int r11 = r12.getViewMin(r10)
            int r11 = r2 - r11
            if (r11 <= r4) goto L67
            int r0 = r1.size()
            if (r0 <= r8) goto L64
            int r0 = r1.get(r8)
            android.view.View r0 = r12.findViewByPosition(r0)
            r2 = r9
            r9 = r0
            goto La5
        L64:
            r2 = r9
            r9 = r10
            goto La5
        L67:
            r1 = r10
            goto L31
        L69:
            r2 = r9
            r9 = r1
            goto La5
        L6c:
            r2 = r9
        L6d:
            r9 = r13
            goto La5
        L6f:
            int r10 = r4 + r3
            if (r2 <= r10) goto La4
            int r2 = r12.mFocusScrollStrategy
            if (r2 != r8) goto La2
        L77:
            androidx.leanback.widget.Grid r2 = r12.mGrid
            int r8 = r2.getLastVisibleIndex()
            androidx.collection.CircularIntArray[] r2 = r2.getItemPositionsInRows(r0, r8)
            r2 = r2[r5]
            int r8 = r2.size()
            int r8 = r8 - r6
            int r2 = r2.get(r8)
            android.view.View r2 = r12.findViewByPosition(r2)
            int r8 = r12.getViewMax(r2)
            int r8 = r8 - r1
            if (r8 <= r4) goto L99
            r2 = r9
            goto L9f
        L99:
            boolean r8 = r12.appendOneColumnVisibleItems()
            if (r8 != 0) goto L77
        L9f:
            if (r2 == 0) goto L6d
            goto La5
        La2:
            r2 = r13
            goto La5
        La4:
            r2 = r9
        La5:
            if (r9 == 0) goto Lad
            int r0 = r12.getViewMin(r9)
        Lab:
            int r0 = r0 - r3
            goto Lb6
        Lad:
            if (r2 == 0) goto Lb5
            int r0 = r12.getViewMax(r2)
            int r3 = r3 + r4
            goto Lab
        Lb5:
            r0 = r7
        Lb6:
            if (r9 == 0) goto Lba
            r13 = r9
            goto Lbd
        Lba:
            if (r2 == 0) goto Lbd
            r13 = r2
        Lbd:
            int r13 = r12.getSecondaryScrollDistance(r13)
            if (r0 != 0) goto Lc7
            if (r13 == 0) goto Lc6
            goto Lc7
        Lc6:
            return r7
        Lc7:
            r14[r7] = r0
            r14[r6] = r13
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.getNoneAlignedPosition(android.view.View, int[]):boolean");
    }

    private int getPrimaryAlignedScrollDistance(View view) {
        return this.mWindowAlignment.mainAxis().getScroll(getViewCenter(view));
    }

    private int getRowSizeSecondary(int i10) {
        int i11 = this.mFixedRowSizeSecondary;
        if (i11 != 0) {
            return i11;
        }
        int[] iArr = this.mRowSizeSecondary;
        if (iArr == null) {
            return 0;
        }
        return iArr[i10];
    }

    private int getSecondaryScrollDistance(View view) {
        return this.mWindowAlignment.secondAxis().getScroll(getViewCenterSecondary(view));
    }

    private int getSizeSecondary() {
        int i10 = (this.mFlag & 524288) != 0 ? 0 : this.mNumRows - 1;
        return getRowStartSecondary(i10) + getRowSizeSecondary(i10);
    }

    private int getViewCenter(View view) {
        return this.mOrientation == 0 ? getViewCenterX(view) : getViewCenterY(view);
    }

    private int getViewCenterSecondary(View view) {
        return this.mOrientation == 0 ? getViewCenterY(view) : getViewCenterX(view);
    }

    private int getViewCenterX(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.getOpticalLeft(view) + layoutParams.getAlignX();
    }

    private int getViewCenterY(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.getOpticalTop(view) + layoutParams.getAlignY();
    }

    private boolean gridOnRequestFocusInDescendantsAligned(int i10, Rect rect) {
        View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
        if (viewFindViewByPosition != null) {
            return viewFindViewByPosition.requestFocus(i10, rect);
        }
        return false;
    }

    private boolean gridOnRequestFocusInDescendantsUnaligned(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        int paddingMin = this.mWindowAlignment.mainAxis().getPaddingMin();
        int clientSize = this.mWindowAlignment.mainAxis().getClientSize() + paddingMin;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && getViewMin(childAt) >= paddingMin && getViewMax(childAt) <= clientSize && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i13;
        }
        return false;
    }

    private void initScrollController() {
        this.mWindowAlignment.reset();
        this.mWindowAlignment.horizontal.setSize(getWidth());
        this.mWindowAlignment.vertical.setSize(getHeight());
        this.mWindowAlignment.horizontal.setPadding(getPaddingLeft(), getPaddingRight());
        this.mWindowAlignment.vertical.setPadding(getPaddingTop(), getPaddingBottom());
        this.mSizePrimary = this.mWindowAlignment.mainAxis().getSize();
        this.mScrollOffsetSecondary = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean layoutInit() {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$State r0 = r5.mState
            int r0 = r0.getItemCount()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L10
            r5.mFocusPosition = r1
            r5.mSubFocusPosition = r3
            goto L22
        L10:
            int r4 = r5.mFocusPosition
            if (r4 < r0) goto L1a
            int r0 = r0 - r2
            r5.mFocusPosition = r0
            r5.mSubFocusPosition = r3
            goto L22
        L1a:
            if (r4 != r1) goto L22
            if (r0 <= 0) goto L22
            r5.mFocusPosition = r3
            r5.mSubFocusPosition = r3
        L22:
            androidx.recyclerview.widget.RecyclerView$State r0 = r5.mState
            boolean r0 = r0.didStructureChange()
            if (r0 != 0) goto L52
            androidx.leanback.widget.Grid r0 = r5.mGrid
            if (r0 == 0) goto L52
            int r0 = r0.getFirstVisibleIndex()
            if (r0 < 0) goto L52
            int r0 = r5.mFlag
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L52
            androidx.leanback.widget.Grid r0 = r5.mGrid
            int r0 = r0.getNumRows()
            int r1 = r5.mNumRows
            if (r0 != r1) goto L52
            r5.updateScrollController()
            r5.updateSecondaryScrollLimits()
            androidx.leanback.widget.Grid r0 = r5.mGrid
            int r1 = r5.mSpacingPrimary
            r0.setSpacing(r1)
            return r2
        L52:
            int r0 = r5.mFlag
            r0 = r0 & (-257(0xfffffffffffffeff, float:NaN))
            r5.mFlag = r0
            androidx.leanback.widget.Grid r0 = r5.mGrid
            r1 = 262144(0x40000, float:3.67342E-40)
            if (r0 == 0) goto L76
            int r4 = r5.mNumRows
            int r0 = r0.getNumRows()
            if (r4 != r0) goto L76
            int r0 = r5.mFlag
            r0 = r0 & r1
            if (r0 == 0) goto L6d
            r0 = r2
            goto L6e
        L6d:
            r0 = r3
        L6e:
            androidx.leanback.widget.Grid r4 = r5.mGrid
            boolean r4 = r4.isReversedFlow()
            if (r0 == r4) goto L8f
        L76:
            int r0 = r5.mNumRows
            androidx.leanback.widget.Grid r0 = androidx.leanback.widget.Grid.createGrid(r0)
            r5.mGrid = r0
            androidx.leanback.widget.Grid$Provider r4 = r5.mGridProvider
            r0.setProvider(r4)
            androidx.leanback.widget.Grid r0 = r5.mGrid
            int r4 = r5.mFlag
            r1 = r1 & r4
            if (r1 == 0) goto L8b
            goto L8c
        L8b:
            r2 = r3
        L8c:
            r0.setReversedFlow(r2)
        L8f:
            r5.initScrollController()
            r5.updateSecondaryScrollLimits()
            androidx.leanback.widget.Grid r0 = r5.mGrid
            int r1 = r5.mSpacingPrimary
            r0.setSpacing(r1)
            androidx.recyclerview.widget.RecyclerView$Recycler r0 = r5.mRecycler
            r5.detachAndScrapAttachedViews(r0)
            androidx.leanback.widget.Grid r0 = r5.mGrid
            r0.resetVisibleIndex()
            androidx.leanback.widget.WindowAlignment r0 = r5.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r0 = r0.mainAxis()
            r0.invalidateScrollMin()
            androidx.leanback.widget.WindowAlignment r0 = r5.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r0 = r0.mainAxis()
            r0.invalidateScrollMax()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.layoutInit():boolean");
    }

    private void leaveContext() {
        int i10 = this.mSaveContextLevel - 1;
        this.mSaveContextLevel = i10;
        if (i10 == 0) {
            this.mRecycler = null;
            this.mState = null;
            this.mPositionDeltaInPreLayout = 0;
            this.mExtraLayoutSpaceInPreLayout = 0;
        }
    }

    private void measureScrapChild(int i10, int i11, int i12, int[] iArr) {
        View viewForPosition = this.mRecycler.getViewForPosition(i10);
        if (viewForPosition != null) {
            LayoutParams layoutParams = (LayoutParams) viewForPosition.getLayoutParams();
            Rect rect = sTempRect;
            calculateItemDecorationsForChild(viewForPosition, rect);
            int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.left + rect.right;
            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.top + rect.bottom;
            viewForPosition.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingRight() + getPaddingLeft() + i13, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + i14, ((ViewGroup.MarginLayoutParams) layoutParams).height));
            iArr[0] = getDecoratedMeasuredWidthWithMargin(viewForPosition);
            iArr[1] = getDecoratedMeasuredHeightWithMargin(viewForPosition);
            this.mRecycler.recycleView(viewForPosition);
        }
    }

    private void offsetChildrenPrimary(int i10) {
        int childCount = getChildCount();
        int i11 = 0;
        if (this.mOrientation == 1) {
            while (i11 < childCount) {
                getChildAt(i11).offsetTopAndBottom(i10);
                i11++;
            }
        } else {
            while (i11 < childCount) {
                getChildAt(i11).offsetLeftAndRight(i10);
                i11++;
            }
        }
    }

    private void offsetChildrenSecondary(int i10) {
        int childCount = getChildCount();
        int i11 = 0;
        if (this.mOrientation == 0) {
            while (i11 < childCount) {
                getChildAt(i11).offsetTopAndBottom(i10);
                i11++;
            }
        } else {
            while (i11 < childCount) {
                getChildAt(i11).offsetLeftAndRight(i10);
                i11++;
            }
        }
    }

    private boolean prependOneColumnVisibleItems() {
        return this.mGrid.prependOneColumnVisibleItems();
    }

    private void prependVisibleItems() {
        this.mGrid.prependVisibleItems((this.mFlag & 262144) != 0 ? this.mSizePrimary + this.mExtraLayoutSpace + this.mExtraLayoutSpaceInPreLayout : (-this.mExtraLayoutSpace) - this.mExtraLayoutSpaceInPreLayout);
    }

    private boolean processRowSizeSecondary(boolean z9) {
        if (this.mFixedRowSizeSecondary != 0 || this.mRowSizeSecondary == null) {
            return false;
        }
        Grid grid = this.mGrid;
        CircularIntArray[] itemPositionsInRows = grid == null ? null : grid.getItemPositionsInRows();
        boolean z10 = false;
        int i10 = -1;
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            CircularIntArray circularIntArray = itemPositionsInRows == null ? null : itemPositionsInRows[i11];
            int size = circularIntArray == null ? 0 : circularIntArray.size();
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13 += 2) {
                int i14 = circularIntArray.get(i13 + 1);
                for (int i15 = circularIntArray.get(i13); i15 <= i14; i15++) {
                    View viewFindViewByPosition = findViewByPosition(i15 - this.mPositionDeltaInPreLayout);
                    if (viewFindViewByPosition != null) {
                        if (z9) {
                            measureChild(viewFindViewByPosition);
                        }
                        int decoratedMeasuredHeightWithMargin = this.mOrientation == 0 ? getDecoratedMeasuredHeightWithMargin(viewFindViewByPosition) : getDecoratedMeasuredWidthWithMargin(viewFindViewByPosition);
                        if (decoratedMeasuredHeightWithMargin > i12) {
                            i12 = decoratedMeasuredHeightWithMargin;
                        }
                    }
                }
            }
            int itemCount = this.mState.getItemCount();
            if (!this.mBaseGridView.hasFixedSize() && z9 && i12 < 0 && itemCount > 0) {
                if (i10 < 0) {
                    int i16 = this.mFocusPosition;
                    if (i16 < 0) {
                        i16 = 0;
                    } else if (i16 >= itemCount) {
                        i16 = itemCount - 1;
                    }
                    if (getChildCount() > 0) {
                        int layoutPosition = this.mBaseGridView.getChildViewHolder(getChildAt(0)).getLayoutPosition();
                        int layoutPosition2 = this.mBaseGridView.getChildViewHolder(getChildAt(getChildCount() - 1)).getLayoutPosition();
                        if (i16 >= layoutPosition && i16 <= layoutPosition2) {
                            i16 = i16 - layoutPosition <= layoutPosition2 - i16 ? layoutPosition - 1 : layoutPosition2 + 1;
                            if (i16 < 0 && layoutPosition2 < itemCount - 1) {
                                i16 = layoutPosition2 + 1;
                            } else if (i16 >= itemCount && layoutPosition > 0) {
                                i16 = layoutPosition - 1;
                            }
                        }
                    }
                    if (i16 >= 0 && i16 < itemCount) {
                        measureScrapChild(i16, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0), this.mMeasuredDimension);
                        int i17 = this.mOrientation;
                        int[] iArr = this.mMeasuredDimension;
                        i10 = i17 == 0 ? iArr[1] : iArr[0];
                    }
                }
                if (i10 >= 0) {
                    i12 = i10;
                }
            }
            if (i12 < 0) {
                i12 = 0;
            }
            int[] iArr2 = this.mRowSizeSecondary;
            if (iArr2[i11] != i12) {
                iArr2[i11] = i12;
                z10 = true;
            }
        }
        return z10;
    }

    private void removeInvisibleViewsAtEnd() {
        int i10 = this.mFlag;
        if ((65600 & i10) == 65536) {
            this.mGrid.removeInvisibleItemsAtEnd(this.mFocusPosition, (i10 & 262144) != 0 ? -this.mExtraLayoutSpace : this.mSizePrimary + this.mExtraLayoutSpace);
        }
    }

    private void removeInvisibleViewsAtFront() {
        int i10 = this.mFlag;
        if ((65600 & i10) == 65536) {
            this.mGrid.removeInvisibleItemsAtFront(this.mFocusPosition, (i10 & 262144) != 0 ? this.mSizePrimary + this.mExtraLayoutSpace : -this.mExtraLayoutSpace);
        }
    }

    private void saveContext(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i10 = this.mSaveContextLevel;
        if (i10 == 0) {
            this.mRecycler = recycler;
            this.mState = state;
            this.mPositionDeltaInPreLayout = 0;
            this.mExtraLayoutSpaceInPreLayout = 0;
        }
        this.mSaveContextLevel = i10 + 1;
    }

    private int scrollDirectionPrimary(int i10) {
        int minScroll;
        int i11 = this.mFlag;
        if ((i11 & 64) == 0 && (i11 & 3) != 1 && (i10 <= 0 ? !(i10 >= 0 || this.mWindowAlignment.mainAxis().isMinUnknown() || i10 >= (minScroll = this.mWindowAlignment.mainAxis().getMinScroll())) : !(this.mWindowAlignment.mainAxis().isMaxUnknown() || i10 <= (minScroll = this.mWindowAlignment.mainAxis().getMaxScroll())))) {
            i10 = minScroll;
        }
        if (i10 == 0) {
            return 0;
        }
        offsetChildrenPrimary(-i10);
        if ((this.mFlag & 3) == 1) {
            updateScrollLimits();
            return i10;
        }
        int childCount = getChildCount();
        if ((this.mFlag & 262144) == 0 ? i10 >= 0 : i10 <= 0) {
            appendVisibleItems();
        } else {
            prependVisibleItems();
        }
        boolean z9 = getChildCount() > childCount;
        int childCount2 = getChildCount();
        if ((262144 & this.mFlag) == 0 ? i10 >= 0 : i10 <= 0) {
            removeInvisibleViewsAtFront();
        } else {
            removeInvisibleViewsAtEnd();
        }
        if (z9 | (getChildCount() < childCount2)) {
            updateRowSecondarySizeRefresh();
        }
        this.mBaseGridView.invalidate();
        updateScrollLimits();
        return i10;
    }

    private int scrollDirectionSecondary(int i10) {
        if (i10 == 0) {
            return 0;
        }
        offsetChildrenSecondary(-i10);
        this.mScrollOffsetSecondary += i10;
        updateSecondaryScrollLimits();
        this.mBaseGridView.invalidate();
        return i10;
    }

    private void scrollGrid(int i10, int i11, boolean z9) {
        if ((this.mFlag & 3) == 1) {
            scrollDirectionPrimary(i10);
            scrollDirectionSecondary(i11);
            return;
        }
        if (this.mOrientation != 0) {
            i11 = i10;
            i10 = i11;
        }
        BaseGridView baseGridView = this.mBaseGridView;
        if (z9) {
            baseGridView.smoothScrollBy(i10, i11);
        } else {
            baseGridView.scrollBy(i10, i11);
            dispatchChildSelectedAndPositioned();
        }
    }

    private void scrollToView(View view, View view2, boolean z9, int i10, int i11) {
        if ((this.mFlag & 64) != 0) {
            return;
        }
        int adapterPositionByView = getAdapterPositionByView(view);
        int subPositionByView = getSubPositionByView(view, view2);
        if (adapterPositionByView != this.mFocusPosition || subPositionByView != this.mSubFocusPosition) {
            this.mFocusPosition = adapterPositionByView;
            this.mSubFocusPosition = subPositionByView;
            this.mFocusPositionOffset = 0;
            if ((this.mFlag & 3) != 1) {
                dispatchChildSelected();
            }
            if (this.mBaseGridView.isChildrenDrawingOrderEnabledInternal()) {
                this.mBaseGridView.invalidate();
            }
        }
        if (view == null) {
            return;
        }
        if (!view.hasFocus() && this.mBaseGridView.hasFocus()) {
            view.requestFocus();
        }
        if ((this.mFlag & 131072) == 0 && z9) {
            return;
        }
        if (!getScrollPosition(view, view2, sTwoInts) && i10 == 0 && i11 == 0) {
            return;
        }
        int[] iArr = sTwoInts;
        scrollGrid(iArr[0] + i10, iArr[1] + i11, z9);
    }

    private void sendTypeViewScrolledAccessibilityEvent() {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(4096);
        this.mBaseGridView.onInitializeAccessibilityEvent(accessibilityEventObtain);
        BaseGridView baseGridView = this.mBaseGridView;
        baseGridView.requestSendAccessibilityEvent(baseGridView, accessibilityEventObtain);
    }

    private void updateChildAlignments(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.getItemAlignmentFacet() == null) {
            layoutParams.setAlignX(this.mItemAlignment.horizontal.getAlignmentPosition(view));
            layoutParams.setAlignY(this.mItemAlignment.vertical.getAlignmentPosition(view));
            return;
        }
        layoutParams.calculateItemAlignments(this.mOrientation, view);
        int i10 = this.mOrientation;
        ItemAlignment itemAlignment = this.mItemAlignment;
        if (i10 == 0) {
            layoutParams.setAlignY(itemAlignment.vertical.getAlignmentPosition(view));
        } else {
            layoutParams.setAlignX(itemAlignment.horizontal.getAlignmentPosition(view));
        }
    }

    private void updateRowSecondarySizeRefresh() {
        int i10 = (this.mFlag & (-1025)) | (processRowSizeSecondary(false) ? 1024 : 0);
        this.mFlag = i10;
        if ((i10 & 1024) != 0) {
            forceRequestLayout();
        }
    }

    private void updateScrollController() {
        this.mWindowAlignment.horizontal.setSize(getWidth());
        this.mWindowAlignment.vertical.setSize(getHeight());
        this.mWindowAlignment.horizontal.setPadding(getPaddingLeft(), getPaddingRight());
        this.mWindowAlignment.vertical.setPadding(getPaddingTop(), getPaddingBottom());
        this.mSizePrimary = this.mWindowAlignment.mainAxis().getSize();
    }

    private void updateSecondaryScrollLimits() {
        WindowAlignment.Axis axisSecondAxis = this.mWindowAlignment.secondAxis();
        int paddingMin = axisSecondAxis.getPaddingMin() - this.mScrollOffsetSecondary;
        int sizeSecondary = getSizeSecondary() + paddingMin;
        axisSecondAxis.updateMinMax(paddingMin, sizeSecondary, paddingMin, sizeSecondary);
    }

    public void addOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        if (this.mChildViewHolderSelectedListeners == null) {
            this.mChildViewHolderSelectedListeners = new ArrayList<>();
        }
        this.mChildViewHolderSelectedListeners.add(onChildViewHolderSelectedListener);
    }

    public void addOnLayoutCompletedListener(BaseGridView.OnLayoutCompletedListener onLayoutCompletedListener) {
        if (this.mOnLayoutCompletedListeners == null) {
            this.mOnLayoutCompletedListeners = new ArrayList<>();
        }
        this.mOnLayoutCompletedListeners.add(onLayoutCompletedListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0 || this.mNumRows > 1;
    }

    public boolean canScrollTo(View view) {
        if (view.getVisibility() == 0) {
            return !hasFocus() || view.hasFocusable();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1 || this.mNumRows > 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        try {
            saveContext(null, state);
            if (this.mOrientation != 0) {
                i10 = i11;
            }
            if (getChildCount() != 0 && i10 != 0) {
                this.mGrid.collectAdjacentPrefetchPositions(i10 < 0 ? -this.mExtraLayoutSpace : this.mSizePrimary + this.mExtraLayoutSpace, i10, layoutPrefetchRegistry);
                leaveContext();
            }
        } finally {
            leaveContext();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i10, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i11 = this.mBaseGridView.mInitialPrefetchItemCount;
        if (i10 == 0 || i11 == 0) {
            return;
        }
        int iMax = Math.max(0, Math.min(this.mFocusPosition - ((i11 - 1) / 2), i10 - i11));
        for (int i12 = iMax; i12 < i10 && i12 < iMax + i11; i12++) {
            layoutPrefetchRegistry.addPosition(i12, 0);
        }
    }

    public void dispatchChildSelected() {
        if (this.mChildSelectedListener != null || hasOnChildViewHolderSelectedListener()) {
            int i10 = this.mFocusPosition;
            View viewFindViewByPosition = i10 == -1 ? null : findViewByPosition(i10);
            if (viewFindViewByPosition != null) {
                RecyclerView.ViewHolder childViewHolder = this.mBaseGridView.getChildViewHolder(viewFindViewByPosition);
                OnChildSelectedListener onChildSelectedListener = this.mChildSelectedListener;
                if (onChildSelectedListener != null) {
                    onChildSelectedListener.onChildSelected(this.mBaseGridView, viewFindViewByPosition, this.mFocusPosition, childViewHolder == null ? -1L : childViewHolder.getItemId());
                }
                fireOnChildViewHolderSelected(this.mBaseGridView, childViewHolder, this.mFocusPosition, this.mSubFocusPosition);
            } else {
                OnChildSelectedListener onChildSelectedListener2 = this.mChildSelectedListener;
                if (onChildSelectedListener2 != null) {
                    onChildSelectedListener2.onChildSelected(this.mBaseGridView, null, -1, -1L);
                }
                fireOnChildViewHolderSelected(this.mBaseGridView, null, -1, 0);
            }
            if ((this.mFlag & 3) == 1 || this.mBaseGridView.isLayoutRequested()) {
                return;
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (getChildAt(i11).isLayoutRequested()) {
                    forceRequestLayout();
                    return;
                }
            }
        }
    }

    public void dispatchChildSelectedAndPositioned() {
        if (hasOnChildViewHolderSelectedListener()) {
            int i10 = this.mFocusPosition;
            View viewFindViewByPosition = i10 == -1 ? null : findViewByPosition(i10);
            if (viewFindViewByPosition != null) {
                fireOnChildViewHolderSelectedAndPositioned(this.mBaseGridView, this.mBaseGridView.getChildViewHolder(viewFindViewByPosition), this.mFocusPosition, this.mSubFocusPosition);
                return;
            }
            OnChildSelectedListener onChildSelectedListener = this.mChildSelectedListener;
            if (onChildSelectedListener != null) {
                onChildSelectedListener.onChildSelected(this.mBaseGridView, null, -1, -1L);
            }
            fireOnChildViewHolderSelectedAndPositioned(this.mBaseGridView, null, -1, 0);
        }
    }

    public void fillScrapViewsInPostLayout() {
        List<RecyclerView.ViewHolder> scrapList = this.mRecycler.getScrapList();
        int size = scrapList.size();
        if (size == 0) {
            return;
        }
        int[] iArr = this.mDisappearingPositions;
        if (iArr == null || size > iArr.length) {
            int length = iArr == null ? 16 : iArr.length;
            while (length < size) {
                length <<= 1;
            }
            this.mDisappearingPositions = new int[length];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            int absoluteAdapterPosition = scrapList.get(i11).getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition >= 0) {
                this.mDisappearingPositions[i10] = absoluteAdapterPosition;
                i10++;
            }
        }
        if (i10 > 0) {
            Arrays.sort(this.mDisappearingPositions, 0, i10);
            this.mGrid.fillDisappearingItems(this.mDisappearingPositions, i10, this.mPositionToRowInPostLayout);
        }
        this.mPositionToRowInPostLayout.clear();
    }

    public void fireOnChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            this.mChildViewHolderSelectedListeners.get(size).onChildViewHolderSelected(recyclerView, viewHolder, i10, i11);
        }
    }

    public void fireOnChildViewHolderSelectedAndPositioned(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            this.mChildViewHolderSelectedListeners.get(size).onChildViewHolderSelectedAndPositioned(recyclerView, viewHolder, i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof RecyclerView.LayoutParams ? new LayoutParams((RecyclerView.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public AudioManager getAudioManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mBaseGridView.getContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        }
        return this.mAudioManager;
    }

    public int getChildDrawingOrder(RecyclerView recyclerView, int i10, int i11) {
        int iIndexOfChild;
        View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
        return (viewFindViewByPosition != null && i11 >= (iIndexOfChild = recyclerView.indexOfChild(viewFindViewByPosition))) ? i11 < i10 + (-1) ? ((iIndexOfChild + i10) - 1) - i11 : iIndexOfChild : i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Grid grid;
        return (this.mOrientation != 1 || (grid = this.mGrid) == null) ? super.getColumnCountForAccessibility(recycler, state) : grid.getNumRows();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedBottom(View view) {
        return super.getDecoratedBottom(view) - ((LayoutParams) view.getLayoutParams()).mBottomInset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        rect.left += layoutParams.mLeftInset;
        rect.top += layoutParams.mTopInset;
        rect.right -= layoutParams.mRightInset;
        rect.bottom -= layoutParams.mBottomInset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedLeft(View view) {
        return super.getDecoratedLeft(view) + ((LayoutParams) view.getLayoutParams()).mLeftInset;
    }

    public int getDecoratedMeasuredHeightWithMargin(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    public int getDecoratedMeasuredWidthWithMargin(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedRight(View view) {
        return super.getDecoratedRight(view) - ((LayoutParams) view.getLayoutParams()).mRightInset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedTop(View view) {
        return super.getDecoratedTop(view) + ((LayoutParams) view.getLayoutParams()).mTopInset;
    }

    public int getExtraLayoutSpace() {
        return this.mExtraLayoutSpace;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E getFacet(RecyclerView.ViewHolder viewHolder, Class<? extends E> cls) {
        FacetProviderAdapter facetProviderAdapter;
        FacetProvider facetProvider;
        E e = viewHolder instanceof FacetProvider ? (E) ((FacetProvider) viewHolder).getFacet(cls) : null;
        return (e != null || (facetProviderAdapter = this.mFacetProviderAdapter) == null || (facetProvider = facetProviderAdapter.getFacetProvider(viewHolder.getItemViewType())) == null) ? e : (E) facetProvider.getFacet(cls);
    }

    public int getFocusScrollStrategy() {
        return this.mFocusScrollStrategy;
    }

    public int getHorizontalSpacing() {
        return this.mHorizontalSpacing;
    }

    public int getItemAlignmentOffset() {
        return this.mItemAlignment.mainAxis().getItemAlignmentOffset();
    }

    public float getItemAlignmentOffsetPercent() {
        return this.mItemAlignment.mainAxis().getItemAlignmentOffsetPercent();
    }

    public int getItemAlignmentViewId() {
        return this.mItemAlignment.mainAxis().getItemAlignmentViewId();
    }

    public int getOpticalBottom(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalBottom(view);
    }

    public int getOpticalLeft(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalLeft(view);
    }

    public int getOpticalRight(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalRight(view);
    }

    public int getOpticalTop(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalTop(view);
    }

    public boolean getPruneChild() {
        return (this.mFlag & 65536) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Grid grid;
        return (this.mOrientation != 0 || (grid = this.mGrid) == null) ? super.getRowCountForAccessibility(recycler, state) : grid.getNumRows();
    }

    public int getRowStartSecondary(int i10) {
        int rowSizeSecondary = 0;
        if ((this.mFlag & 524288) != 0) {
            for (int i11 = this.mNumRows - 1; i11 > i10; i11--) {
                rowSizeSecondary += getRowSizeSecondary(i11) + this.mSpacingSecondary;
            }
            return rowSizeSecondary;
        }
        int rowSizeSecondary2 = 0;
        while (rowSizeSecondary < i10) {
            rowSizeSecondary2 += getRowSizeSecondary(rowSizeSecondary) + this.mSpacingSecondary;
            rowSizeSecondary++;
        }
        return rowSizeSecondary2;
    }

    public boolean getScrollPosition(View view, View view2, int[] iArr) {
        int i10 = this.mFocusScrollStrategy;
        return (i10 == 1 || i10 == 2) ? getNoneAlignedPosition(view, iArr) : getAlignedPosition(view, view2, iArr);
    }

    public int getSelection() {
        return this.mFocusPosition;
    }

    public int getSlideOutDistance() {
        int left;
        int right;
        int top;
        if (this.mOrientation == 1) {
            int i10 = -getHeight();
            return (getChildCount() <= 0 || (top = getChildAt(0).getTop()) >= 0) ? i10 : i10 + top;
        }
        if ((this.mFlag & 262144) != 0) {
            int width = getWidth();
            return (getChildCount() <= 0 || (right = getChildAt(0).getRight()) <= width) ? width : right;
        }
        int i11 = -getWidth();
        return (getChildCount() <= 0 || (left = getChildAt(0).getLeft()) >= 0) ? i11 : i11 + left;
    }

    public int getSubPositionByView(View view, View view2) {
        ItemAlignmentFacet itemAlignmentFacet;
        if (view != null && view2 != null && (itemAlignmentFacet = ((LayoutParams) view.getLayoutParams()).getItemAlignmentFacet()) != null) {
            ItemAlignmentFacet.ItemAlignmentDef[] alignmentDefs = itemAlignmentFacet.getAlignmentDefs();
            if (alignmentDefs.length > 1) {
                while (view2 != view) {
                    int id = view2.getId();
                    if (id != -1) {
                        for (int i10 = 1; i10 < alignmentDefs.length; i10++) {
                            if (alignmentDefs[i10].getItemAlignmentFocusViewId() == id) {
                                return i10;
                            }
                        }
                    }
                    view2 = (View) view2.getParent();
                }
            }
        }
        return 0;
    }

    public int getSubSelection() {
        return this.mSubFocusPosition;
    }

    public String getTag() {
        return "GridLayoutManager:" + this.mBaseGridView.getId();
    }

    public int getVerticalSpacing() {
        return this.mVerticalSpacing;
    }

    public View getViewForPosition(int i10) {
        View viewForPosition = this.mRecycler.getViewForPosition(i10);
        ((LayoutParams) viewForPosition.getLayoutParams()).setItemAlignmentFacet((ItemAlignmentFacet) getFacet(this.mBaseGridView.getChildViewHolder(viewForPosition), ItemAlignmentFacet.class));
        return viewForPosition;
    }

    public int getViewMax(View view) {
        return this.mOrientationHelper.getDecoratedEnd(view);
    }

    public int getViewMin(View view) {
        return this.mOrientationHelper.getDecoratedStart(view);
    }

    public int getViewPrimarySize(View view) {
        Rect rect = sTempRect;
        getDecoratedBoundsWithMargins(view, rect);
        return this.mOrientation == 0 ? rect.width() : rect.height();
    }

    public void getViewSelectedOffsets(View view, int[] iArr) {
        if (this.mOrientation == 0) {
            iArr[0] = getPrimaryAlignedScrollDistance(view);
            iArr[1] = getSecondaryScrollDistance(view);
        } else {
            iArr[1] = getPrimaryAlignedScrollDistance(view);
            iArr[0] = getSecondaryScrollDistance(view);
        }
    }

    public int getWindowAlignment() {
        return this.mWindowAlignment.mainAxis().getWindowAlignment();
    }

    public int getWindowAlignmentOffset() {
        return this.mWindowAlignment.mainAxis().getWindowAlignmentOffset();
    }

    public float getWindowAlignmentOffsetPercent() {
        return this.mWindowAlignment.mainAxis().getWindowAlignmentOffsetPercent();
    }

    public boolean gridOnRequestFocusInDescendants(RecyclerView recyclerView, int i10, Rect rect) {
        int i11 = this.mFocusScrollStrategy;
        return (i11 == 1 || i11 == 2) ? gridOnRequestFocusInDescendantsUnaligned(i10, rect) : gridOnRequestFocusInDescendantsAligned(i10, rect);
    }

    public boolean hasCreatedFirstItem() {
        return getItemCount() == 0 || this.mBaseGridView.findViewHolderForAdapterPosition(0) != null;
    }

    public boolean hasCreatedLastItem() {
        int itemCount = getItemCount();
        return itemCount == 0 || this.mBaseGridView.findViewHolderForAdapterPosition(itemCount - 1) != null;
    }

    public boolean hasDoneFirstLayout() {
        return this.mGrid != null;
    }

    public boolean hasOnChildViewHolderSelectedListener() {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean hasPreviousViewInSameRow(int i10) {
        Grid grid = this.mGrid;
        if (grid != null && i10 != -1 && grid.getFirstVisibleIndex() >= 0) {
            if (this.mGrid.getFirstVisibleIndex() > 0) {
                return true;
            }
            int i11 = this.mGrid.getLocation(i10).mRow;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                int adapterPositionByIndex = getAdapterPositionByIndex(childCount);
                Grid.Location location = this.mGrid.getLocation(adapterPositionByIndex);
                if (location != null && location.mRow == i11 && adapterPositionByIndex < i10) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFocusSearchDisabled() {
        return (this.mFlag & 32768) != 0;
    }

    public boolean isItemAlignmentOffsetWithPadding() {
        return this.mItemAlignment.mainAxis().isItemAlignmentOffsetWithPadding();
    }

    public boolean isItemFullyVisible(int i10) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.mBaseGridView.findViewHolderForAdapterPosition(i10);
        return viewHolderFindViewHolderForAdapterPosition != null && viewHolderFindViewHolderForAdapterPosition.itemView.getLeft() >= 0 && viewHolderFindViewHolderForAdapterPosition.itemView.getRight() <= this.mBaseGridView.getWidth() && viewHolderFindViewHolderForAdapterPosition.itemView.getTop() >= 0 && viewHolderFindViewHolderForAdapterPosition.itemView.getBottom() <= this.mBaseGridView.getHeight();
    }

    public boolean isScrollEnabled() {
        return (this.mFlag & 131072) != 0;
    }

    public boolean isSlidingChildViews() {
        return (this.mFlag & 64) != 0;
    }

    public void layoutChild(int i10, View view, int i11, int i12, int i13) {
        int rowSizeSecondary;
        int i14;
        int i15;
        int i16;
        int i17;
        int decoratedMeasuredHeightWithMargin = this.mOrientation == 0 ? getDecoratedMeasuredHeightWithMargin(view) : getDecoratedMeasuredWidthWithMargin(view);
        int i18 = this.mFixedRowSizeSecondary;
        if (i18 > 0) {
            decoratedMeasuredHeightWithMargin = Math.min(decoratedMeasuredHeightWithMargin, i18);
        }
        int i19 = this.mGravity;
        int i20 = i19 & 112;
        int absoluteGravity = (this.mFlag & PF_REVERSE_FLOW_MASK) != 0 ? Gravity.getAbsoluteGravity(i19 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK, 1) : i19 & 7;
        int i21 = this.mOrientation;
        if ((i21 != 0 || i20 != 48) && (i21 != 1 || absoluteGravity != 3)) {
            if ((i21 == 0 && i20 == 80) || (i21 == 1 && absoluteGravity == 5)) {
                rowSizeSecondary = getRowSizeSecondary(i10) - decoratedMeasuredHeightWithMargin;
            } else if ((i21 == 0 && i20 == 16) || (i21 == 1 && absoluteGravity == 1)) {
                rowSizeSecondary = (getRowSizeSecondary(i10) - decoratedMeasuredHeightWithMargin) / 2;
            }
            i13 += rowSizeSecondary;
        }
        if (this.mOrientation == 0) {
            i16 = i11;
            i17 = i12;
            i14 = i13;
            i15 = decoratedMeasuredHeightWithMargin + i13;
        } else {
            i14 = i11;
            i15 = i12;
            i16 = i13;
            i17 = decoratedMeasuredHeightWithMargin + i13;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutDecoratedWithMargins(view, i16, i14, i17, i15);
        Rect rect = sTempRect;
        super.getDecoratedBoundsWithMargins(view, rect);
        layoutParams.setOpticalInsets(i16 - rect.left, i14 - rect.top, rect.right - i17, rect.bottom - i15);
        updateChildAlignments(view);
    }

    public void measureChild(View view) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = sTempRect;
        calculateItemDecorationsForChild(view, rect);
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.left + rect.right;
        int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.top + rect.bottom;
        int iMakeMeasureSpec = this.mRowSizeSecondaryRequested == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(this.mFixedRowSizeSecondary, 1073741824);
        if (this.mOrientation == 0) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i10, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, i11, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        } else {
            int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height);
            childMeasureSpec = ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, i10, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            childMeasureSpec2 = childMeasureSpec3;
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        if (adapter != null) {
            discardLayoutInfo();
            this.mFocusPosition = -1;
            this.mFocusPositionOffset = 0;
            this.mChildrenStates.clear();
        }
        if (adapter2 instanceof FacetProviderAdapter) {
            this.mFacetProviderAdapter = (FacetProviderAdapter) adapter2;
        } else {
            this.mFacetProviderAdapter = null;
        }
        super.onAdapterChanged(adapter, adapter2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009c  */
    /* JADX WARN: Type inference failed for: r17v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onAddFocusables(androidx.recyclerview.widget.RecyclerView r19, @android.annotation.SuppressLint({"ConcreteCollection"}) java.util.ArrayList<android.view.View> r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.onAddFocusables(androidx.recyclerview.widget.RecyclerView, java.util.ArrayList, int, int):boolean");
    }

    public void onChildRecycled(RecyclerView.ViewHolder viewHolder) {
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition != -1) {
            this.mChildrenStates.saveOffscreenView(viewHolder.itemView, absoluteAdapterPosition);
        }
    }

    public void onFocusChanged(boolean z9, int i10, Rect rect) {
        if (!z9) {
            return;
        }
        int i11 = this.mFocusPosition;
        while (true) {
            View viewFindViewByPosition = findViewByPosition(i11);
            if (viewFindViewByPosition == null) {
                return;
            }
            if (viewFindViewByPosition.getVisibility() == 0 && viewFindViewByPosition.hasFocusable()) {
                viewFindViewByPosition.requestFocus();
                return;
            }
            i11++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        saveContext(recycler, state);
        int itemCount = state.getItemCount();
        int i10 = this.mFlag;
        boolean z9 = (262144 & i10) != 0;
        if ((i10 & 2048) == 0 || (itemCount > 1 && !isItemFullyVisible(0))) {
            addA11yActionMovingBackward(accessibilityNodeInfoCompat, z9);
        }
        if ((this.mFlag & 4096) == 0 || (itemCount > 1 && !isItemFullyVisible(itemCount - 1))) {
            addA11yActionMovingForward(accessibilityNodeInfoCompat, z9);
        }
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
        leaveContext();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.mGrid == null || !(layoutParams instanceof LayoutParams)) {
            return;
        }
        int absoluteAdapterPosition = ((LayoutParams) layoutParams).getAbsoluteAdapterPosition();
        int rowIndex = absoluteAdapterPosition >= 0 ? this.mGrid.getRowIndex(absoluteAdapterPosition) : -1;
        if (rowIndex < 0) {
            return;
        }
        int numRows = absoluteAdapterPosition / this.mGrid.getNumRows();
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(rowIndex, 1, numRows, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(numRows, 1, rowIndex, 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onInterceptFocusSearch(View view, int i10) {
        View viewFindNextFocus;
        View viewFindNextFocus2;
        if ((this.mFlag & 32768) != 0) {
            return view;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (i10 == 2 || i10 == 1) {
            if (canScrollVertically()) {
                viewFindNextFocus = focusFinder.findNextFocus(this.mBaseGridView, view, i10 == 2 ? TsExtractor.TS_STREAM_TYPE_HDMV_DTS : 33);
            } else {
                viewFindNextFocus = null;
            }
            if (canScrollHorizontally()) {
                viewFindNextFocus2 = focusFinder.findNextFocus(this.mBaseGridView, view, (getLayoutDirection() == 1) ^ (i10 == 2) ? 66 : 17);
            } else {
                viewFindNextFocus2 = viewFindNextFocus;
            }
        } else {
            viewFindNextFocus2 = focusFinder.findNextFocus(this.mBaseGridView, view, i10);
        }
        if (viewFindNextFocus2 != null) {
            return viewFindNextFocus2;
        }
        if (this.mBaseGridView.getDescendantFocusability() == 393216) {
            return this.mBaseGridView.getParent().focusSearch(view, i10);
        }
        int movement = getMovement(i10);
        boolean z9 = this.mBaseGridView.getScrollState() != 0;
        if (movement == 1) {
            if (z9 || (this.mFlag & 4096) == 0) {
                viewFindNextFocus2 = view;
            }
            if ((this.mFlag & 131072) != 0 && !hasCreatedLastItem()) {
                processPendingMovement(true);
                viewFindNextFocus2 = view;
            }
        } else if (movement == 0) {
            if (z9 || (this.mFlag & 2048) == 0) {
                viewFindNextFocus2 = view;
            }
            if ((this.mFlag & 131072) != 0 && !hasCreatedFirstItem()) {
                processPendingMovement(false);
                viewFindNextFocus2 = view;
            }
        } else if (movement == 3) {
        }
        if (viewFindNextFocus2 != null) {
            return viewFindNextFocus2;
        }
        View viewFocusSearch = this.mBaseGridView.getParent().focusSearch(view, i10);
        return viewFocusSearch != null ? viewFocusSearch : view != null ? view : this.mBaseGridView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        Grid grid;
        int i12;
        if (this.mFocusPosition != -1 && (grid = this.mGrid) != null && grid.getFirstVisibleIndex() >= 0 && (i12 = this.mFocusPositionOffset) != Integer.MIN_VALUE && i10 <= this.mFocusPosition + i12) {
            this.mFocusPositionOffset = i12 + i11;
        }
        this.mChildrenStates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mFocusPositionOffset = 0;
        this.mChildrenStates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        int i13;
        int i14 = this.mFocusPosition;
        if (i14 != -1 && (i13 = this.mFocusPositionOffset) != Integer.MIN_VALUE) {
            int i15 = i14 + i13;
            if (i10 <= i15 && i15 < i10 + i12) {
                this.mFocusPositionOffset = (i11 - i10) + i13;
            } else if (i10 < i15 && i11 > i15 - i12) {
                this.mFocusPositionOffset = i13 - i12;
            } else if (i10 > i15 && i11 < i15) {
                this.mFocusPositionOffset = i13 + i12;
            }
        }
        this.mChildrenStates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        Grid grid;
        int i12;
        int i13;
        int i14;
        if (this.mFocusPosition != -1 && (grid = this.mGrid) != null && grid.getFirstVisibleIndex() >= 0 && (i12 = this.mFocusPositionOffset) != Integer.MIN_VALUE && i10 <= (i14 = (i13 = this.mFocusPosition) + i12)) {
            if (i10 + i11 > i14) {
                this.mFocusPosition = (i10 - i14) + i12 + i13;
                this.mFocusPositionOffset = Integer.MIN_VALUE;
            } else {
                this.mFocusPositionOffset = i12 - i11;
            }
        }
        this.mChildrenStates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            this.mChildrenStates.remove(i10);
            i10++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int remainingScrollHorizontal;
        int remainingScrollVertical;
        int i10;
        int i11;
        int i12;
        if (this.mNumRows != 0 && state.getItemCount() >= 0) {
            if ((this.mFlag & 64) != 0 && getChildCount() > 0) {
                this.mFlag |= 128;
                return;
            }
            int i13 = this.mFlag;
            if ((i13 & 512) == 0) {
                discardLayoutInfo();
                removeAndRecycleAllViews(recycler);
                return;
            }
            this.mFlag = (i13 & (-4)) | 1;
            saveContext(recycler, state);
            int iMax = Integer.MIN_VALUE;
            if (state.isPreLayout()) {
                updatePositionDeltaInPreLayout();
                int childCount = getChildCount();
                if (this.mGrid != null && childCount > 0) {
                    int oldPosition = this.mBaseGridView.getChildViewHolder(getChildAt(0)).getOldPosition();
                    int oldPosition2 = this.mBaseGridView.getChildViewHolder(getChildAt(childCount - 1)).getOldPosition();
                    int iMin = Integer.MAX_VALUE;
                    while (i < childCount) {
                        View childAt = getChildAt(i);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        int childAdapterPosition = this.mBaseGridView.getChildAdapterPosition(childAt);
                        if (layoutParams.isItemChanged() || layoutParams.isItemRemoved() || childAt.isLayoutRequested() || ((!childAt.hasFocus() && this.mFocusPosition == layoutParams.getAbsoluteAdapterPosition()) || ((childAt.hasFocus() && this.mFocusPosition != layoutParams.getAbsoluteAdapterPosition()) || childAdapterPosition < oldPosition || childAdapterPosition > oldPosition2))) {
                            iMin = Math.min(iMin, getViewMin(childAt));
                            iMax = Math.max(iMax, getViewMax(childAt));
                        }
                        i++;
                    }
                    if (iMax > iMin) {
                        this.mExtraLayoutSpaceInPreLayout = iMax - iMin;
                    }
                    appendVisibleItems();
                    prependVisibleItems();
                }
                this.mFlag &= -4;
                leaveContext();
                return;
            }
            if (state.willRunPredictiveAnimations()) {
                updatePositionToRowMapInPostLayout();
            }
            boolean z9 = !isSmoothScrolling() && this.mFocusScrollStrategy == 0;
            int i14 = this.mFocusPosition;
            if (i14 != -1 && (i12 = this.mFocusPositionOffset) != Integer.MIN_VALUE) {
                this.mFocusPosition = i14 + i12;
                this.mSubFocusPosition = 0;
            }
            this.mFocusPositionOffset = 0;
            View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
            int i15 = this.mFocusPosition;
            int i16 = this.mSubFocusPosition;
            boolean zHasFocus = this.mBaseGridView.hasFocus();
            Grid grid = this.mGrid;
            int firstVisibleIndex = grid != null ? grid.getFirstVisibleIndex() : -1;
            Grid grid2 = this.mGrid;
            int lastVisibleIndex = grid2 != null ? grid2.getLastVisibleIndex() : -1;
            if (this.mOrientation == 0) {
                remainingScrollVertical = state.getRemainingScrollHorizontal();
                remainingScrollHorizontal = state.getRemainingScrollVertical();
            } else {
                remainingScrollHorizontal = state.getRemainingScrollHorizontal();
                remainingScrollVertical = state.getRemainingScrollVertical();
            }
            boolean zLayoutInit = layoutInit();
            int i17 = this.mFlag;
            if (zLayoutInit) {
                this.mFlag = i17 | 4;
                this.mGrid.setStart(this.mFocusPosition);
                fastRelayout();
            } else {
                this.mFlag = i17 & (-5);
                this.mFlag = (z9 ? 16 : 0) | (i17 & (-21));
                if (z9 && (firstVisibleIndex < 0 || (i10 = this.mFocusPosition) > lastVisibleIndex || i10 < firstVisibleIndex)) {
                    firstVisibleIndex = this.mFocusPosition;
                    lastVisibleIndex = firstVisibleIndex;
                }
                this.mGrid.setStart(firstVisibleIndex);
                if (lastVisibleIndex != -1) {
                    while (appendOneColumnVisibleItems() && findViewByPosition(lastVisibleIndex) == null) {
                    }
                }
            }
            while (true) {
                updateScrollLimits();
                int firstVisibleIndex2 = this.mGrid.getFirstVisibleIndex();
                int lastVisibleIndex2 = this.mGrid.getLastVisibleIndex();
                focusToViewInLayout(zHasFocus, z9, -remainingScrollVertical, -remainingScrollHorizontal);
                appendVisibleItems();
                prependVisibleItems();
                if (this.mGrid.getFirstVisibleIndex() == firstVisibleIndex2 && this.mGrid.getLastVisibleIndex() == lastVisibleIndex2) {
                    break;
                }
            }
            removeInvisibleViewsAtFront();
            removeInvisibleViewsAtEnd();
            if (state.willRunPredictiveAnimations()) {
                fillScrapViewsInPostLayout();
            }
            int i18 = this.mFlag;
            if ((i18 & 1024) != 0) {
                this.mFlag = i18 & (-1025);
            } else {
                updateRowSecondarySizeRefresh();
            }
            if (((this.mFlag & 4) != 0 && ((i11 = this.mFocusPosition) != i15 || this.mSubFocusPosition != i16 || findViewByPosition(i11) != viewFindViewByPosition || (this.mFlag & 8) != 0)) || (this.mFlag & 20) == 16) {
                dispatchChildSelected();
            }
            dispatchChildSelectedAndPositioned();
            if ((this.mFlag & 64) != 0) {
                scrollDirectionPrimary(getSlideOutDistance());
            }
            this.mFlag &= -4;
            leaveContext();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        ArrayList<BaseGridView.OnLayoutCompletedListener> arrayList = this.mOnLayoutCompletedListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mOnLayoutCompletedListeners.get(size).onLayoutCompleted(state);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i10, int i11) {
        int size;
        int size2;
        int mode;
        int paddingLeft;
        int paddingRight;
        int sizeSecondary;
        saveContext(recycler, state);
        if (this.mOrientation == 0) {
            size2 = View.MeasureSpec.getSize(i10);
            size = View.MeasureSpec.getSize(i11);
            mode = View.MeasureSpec.getMode(i11);
            paddingLeft = getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            size = View.MeasureSpec.getSize(i10);
            size2 = View.MeasureSpec.getSize(i11);
            mode = View.MeasureSpec.getMode(i10);
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i12 = paddingRight + paddingLeft;
        this.mMaxSizeSecondary = size;
        int i13 = this.mRowSizeSecondaryRequested;
        if (i13 == -2) {
            int i14 = this.mNumRowsRequested;
            if (i14 == 0) {
                i14 = 1;
            }
            this.mNumRows = i14;
            this.mFixedRowSizeSecondary = 0;
            int[] iArr = this.mRowSizeSecondary;
            if (iArr == null || iArr.length != i14) {
                this.mRowSizeSecondary = new int[i14];
            }
            if (this.mState.isPreLayout()) {
                updatePositionDeltaInPreLayout();
            }
            processRowSizeSecondary(true);
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(getSizeSecondary() + i12, this.mMaxSizeSecondary);
            } else if (mode == 0) {
                sizeSecondary = getSizeSecondary();
                size = sizeSecondary + i12;
            } else {
                if (mode != 1073741824) {
                    c.g("wrong spec");
                    return;
                }
                size = this.mMaxSizeSecondary;
            }
        } else {
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    if (i13 == 0) {
                        i13 = size - i12;
                    }
                    this.mFixedRowSizeSecondary = i13;
                    int i15 = this.mNumRowsRequested;
                    if (i15 == 0) {
                        i15 = 1;
                    }
                    this.mNumRows = i15;
                    sizeSecondary = ((i15 - 1) * this.mSpacingSecondary) + (i13 * i15);
                    size = sizeSecondary + i12;
                } else if (mode != 1073741824) {
                    c.g("wrong spec");
                    return;
                }
            }
            int i16 = this.mNumRowsRequested;
            if (i16 == 0 && i13 == 0) {
                this.mNumRows = 1;
                this.mFixedRowSizeSecondary = size - i12;
            } else if (i16 == 0) {
                this.mFixedRowSizeSecondary = i13;
                int i17 = this.mSpacingSecondary;
                this.mNumRows = (size + i17) / (i13 + i17);
            } else if (i13 == 0) {
                this.mNumRows = i16;
                this.mFixedRowSizeSecondary = ((size - i12) - ((i16 - 1) * this.mSpacingSecondary)) / i16;
            } else {
                this.mNumRows = i16;
                this.mFixedRowSizeSecondary = i13;
            }
            if (mode == Integer.MIN_VALUE) {
                int i18 = this.mFixedRowSizeSecondary;
                int i19 = this.mNumRows;
                int i20 = ((i19 - 1) * this.mSpacingSecondary) + (i18 * i19) + i12;
                if (i20 < size) {
                    size = i20;
                }
            }
        }
        if (this.mOrientation == 0) {
            setMeasuredDimension(size2, size);
        } else {
            setMeasuredDimension(size, size2);
        }
        leaveContext();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean onRequestChildFocus(RecyclerView recyclerView, RecyclerView.State state, View view, View view2) {
        if ((this.mFlag & 32768) == 0 && getAdapterPositionByView(view) != -1 && (this.mFlag & 35) == 0) {
            scrollToView(view, view2, true);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mFocusPosition = savedState.mIndex;
            this.mFocusPositionOffset = 0;
            this.mChildrenStates.loadFromBundle(savedState.mChildStates);
            this.mFlag |= 256;
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onRtlPropertiesChanged(int r6) {
        /*
            r5 = this;
            int r0 = r5.mOrientation
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Ld
            if (r6 != r2) goto Lb
            r0 = 262144(0x40000, float:3.67342E-40)
            goto L11
        Lb:
            r0 = r1
            goto L11
        Ld:
            if (r6 != r2) goto Lb
            r0 = 524288(0x80000, float:7.34684E-40)
        L11:
            int r3 = r5.mFlag
            r4 = 786432(0xc0000, float:1.102026E-39)
            r4 = r4 & r3
            if (r4 != r0) goto L19
            return
        L19:
            r4 = -786433(0xfffffffffff3ffff, float:NaN)
            r3 = r3 & r4
            r0 = r0 | r3
            r0 = r0 | 256(0x100, float:3.59E-43)
            r5.mFlag = r0
            androidx.leanback.widget.WindowAlignment r0 = r5.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r0 = r0.horizontal
            if (r6 != r2) goto L29
            r1 = r2
        L29:
            r0.setReversedFlow(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.onRtlPropertiesChanged(int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.mIndex = getSelection();
        Bundle bundleSaveAsBundle = this.mChildrenStates.saveAsBundle();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int adapterPositionByView = getAdapterPositionByView(childAt);
            if (adapterPositionByView != -1) {
                bundleSaveAsBundle = this.mChildrenStates.saveOnScreenView(bundleSaveAsBundle, childAt, adapterPositionByView);
            }
        }
        savedState.mChildStates = bundleSaveAsBundle;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.Recycler r5, androidx.recyclerview.widget.RecyclerView.State r6, int r7, android.os.Bundle r8) {
        /*
            r4 = this;
            boolean r8 = r4.isScrollEnabled()
            r0 = 1
            if (r8 != 0) goto L8
            return r0
        L8:
            r4.saveContext(r5, r6)
            int r5 = r4.mFlag
            r8 = 262144(0x40000, float:3.67342E-40)
            r5 = r5 & r8
            r8 = 0
            if (r5 == 0) goto L15
            r5 = r0
            goto L16
        L15:
            r5 = r8
        L16:
            int r1 = r4.mOrientation
            r2 = 8192(0x2000, float:1.148E-41)
            r3 = 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L34
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r1 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT
            int r1 = r1.getId()
            if (r7 != r1) goto L29
            if (r5 == 0) goto L3c
            goto L46
        L29:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r1 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT
            int r1 = r1.getId()
            if (r7 != r1) goto L47
            if (r5 == 0) goto L46
            goto L3c
        L34:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r5 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP
            int r5 = r5.getId()
            if (r7 != r5) goto L3e
        L3c:
            r7 = r2
            goto L47
        L3e:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r5 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN
            int r5 = r5.getId()
            if (r7 != r5) goto L47
        L46:
            r7 = r3
        L47:
            int r5 = r4.mFocusPosition
            if (r5 != 0) goto L4f
            if (r7 != r2) goto L4f
            r1 = r0
            goto L50
        L4f:
            r1 = r8
        L50:
            int r6 = r6.getItemCount()
            int r6 = r6 - r0
            if (r5 != r6) goto L5b
            if (r7 != r3) goto L5b
            r5 = r0
            goto L5c
        L5b:
            r5 = r8
        L5c:
            if (r1 != 0) goto L75
            if (r5 == 0) goto L61
            goto L75
        L61:
            if (r7 == r3) goto L6e
            if (r7 == r2) goto L66
            goto L78
        L66:
            r4.processPendingMovement(r8)
            r5 = -1
            r4.processSelectionMoves(r8, r5)
            goto L78
        L6e:
            r4.processPendingMovement(r0)
            r4.processSelectionMoves(r8, r0)
            goto L78
        L75:
            r4.sendTypeViewScrolledAccessibilityEvent()
        L78:
            r4.leaveContext()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
    }

    public void processPendingMovement(boolean z9) {
        int i10;
        if (z9) {
            if (hasCreatedLastItem()) {
                return;
            }
        } else if (hasCreatedFirstItem()) {
            return;
        }
        PendingMoveSmoothScroller pendingMoveSmoothScroller = this.mPendingMoveSmoothScroller;
        if (pendingMoveSmoothScroller == null) {
            PendingMoveSmoothScroller pendingMoveSmoothScroller2 = new PendingMoveSmoothScroller(z9 ? 1 : -1, this.mNumRows > 1);
            this.mFocusPositionOffset = 0;
            startSmoothScroll(pendingMoveSmoothScroller2);
        } else if (z9) {
            pendingMoveSmoothScroller.increasePendingMoves();
        } else {
            pendingMoveSmoothScroller.decreasePendingMoves();
        }
        if (this.mOrientation == 0) {
            i10 = 4;
            if (getLayoutDirection() != 1 ? !z9 : z9) {
                i10 = 3;
            }
        } else {
            i10 = z9 ? 2 : 1;
        }
        getAudioManager().playSoundEffect(i10);
    }

    public int processSelectionMoves(boolean z9, int i10) {
        Grid grid = this.mGrid;
        if (grid == null) {
            return i10;
        }
        int i11 = this.mFocusPosition;
        int rowIndex = i11 != -1 ? grid.getRowIndex(i11) : -1;
        int childCount = getChildCount();
        View view = null;
        for (int i12 = 0; i12 < childCount && i10 != 0; i12++) {
            int i13 = i10 > 0 ? i12 : (childCount - 1) - i12;
            View childAt = getChildAt(i13);
            if (canScrollTo(childAt)) {
                int adapterPositionByIndex = getAdapterPositionByIndex(i13);
                int rowIndex2 = this.mGrid.getRowIndex(adapterPositionByIndex);
                if (rowIndex == -1) {
                    i11 = adapterPositionByIndex;
                    view = childAt;
                    rowIndex = rowIndex2;
                } else if (rowIndex2 == rowIndex && ((i10 > 0 && adapterPositionByIndex > i11) || (i10 < 0 && adapterPositionByIndex < i11))) {
                    i10 = i10 > 0 ? i10 - 1 : i10 + 1;
                    i11 = adapterPositionByIndex;
                    view = childAt;
                }
            }
        }
        if (view != null) {
            if (z9) {
                if (hasFocus()) {
                    this.mFlag |= 32;
                    view.requestFocus();
                    this.mFlag &= -33;
                }
                this.mFocusPosition = i11;
                this.mSubFocusPosition = 0;
                return i10;
            }
            scrollToView(view, true);
        }
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            removeAndRecycleViewAt(childCount, recycler);
        }
    }

    public void removeOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList != null) {
            arrayList.remove(onChildViewHolderSelectedListener);
        }
    }

    public void removeOnLayoutCompletedListener(BaseGridView.OnLayoutCompletedListener onLayoutCompletedListener) {
        ArrayList<BaseGridView.OnLayoutCompletedListener> arrayList = this.mOnLayoutCompletedListeners;
        if (arrayList != null) {
            arrayList.remove(onLayoutCompletedListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z9) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if ((this.mFlag & 512) == 0 || !hasDoneFirstLayout()) {
            return 0;
        }
        saveContext(recycler, state);
        this.mFlag = (this.mFlag & (-4)) | 2;
        int iScrollDirectionPrimary = this.mOrientation == 0 ? scrollDirectionPrimary(i10) : scrollDirectionSecondary(i10);
        leaveContext();
        this.mFlag &= -4;
        return iScrollDirectionPrimary;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        setSelection(i10, 0, false, 0);
    }

    public void scrollToSelection(int i10, int i11, boolean z9, int i12) {
        this.mPrimaryScrollExtra = i12;
        View viewFindViewByPosition = findViewByPosition(i10);
        boolean zIsSmoothScrolling = isSmoothScrolling();
        if (!zIsSmoothScrolling && !this.mBaseGridView.isLayoutRequested() && viewFindViewByPosition != null && getAdapterPositionByView(viewFindViewByPosition) == i10) {
            this.mFlag |= 32;
            scrollToView(viewFindViewByPosition, z9);
            this.mFlag &= -33;
            return;
        }
        int i13 = this.mFlag;
        if ((i13 & 512) == 0 || (i13 & 64) != 0) {
            this.mFocusPosition = i10;
            this.mSubFocusPosition = i11;
            this.mFocusPositionOffset = Integer.MIN_VALUE;
            return;
        }
        if (z9 && !this.mBaseGridView.isLayoutRequested()) {
            this.mFocusPosition = i10;
            this.mSubFocusPosition = i11;
            this.mFocusPositionOffset = Integer.MIN_VALUE;
            if (!hasDoneFirstLayout()) {
                Log.w(getTag(), "setSelectionSmooth should not be called before first layout pass");
                return;
            }
            int iStartPositionSmoothScroller = startPositionSmoothScroller(i10);
            if (iStartPositionSmoothScroller != this.mFocusPosition) {
                this.mFocusPosition = iStartPositionSmoothScroller;
                this.mSubFocusPosition = 0;
                return;
            }
            return;
        }
        if (zIsSmoothScrolling) {
            skipSmoothScrollerOnStopInternal();
            this.mBaseGridView.stopScroll();
        }
        if (!this.mBaseGridView.isLayoutRequested() && viewFindViewByPosition != null && getAdapterPositionByView(viewFindViewByPosition) == i10) {
            this.mFlag |= 32;
            scrollToView(viewFindViewByPosition, z9);
            this.mFlag &= -33;
        } else {
            this.mFocusPosition = i10;
            this.mSubFocusPosition = i11;
            this.mFocusPositionOffset = Integer.MIN_VALUE;
            this.mFlag |= 256;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if ((this.mFlag & 512) == 0 || !hasDoneFirstLayout()) {
            return 0;
        }
        this.mFlag = (this.mFlag & (-4)) | 2;
        saveContext(recycler, state);
        int iScrollDirectionPrimary = this.mOrientation == 1 ? scrollDirectionPrimary(i10) : scrollDirectionSecondary(i10);
        leaveContext();
        this.mFlag &= -4;
        return iScrollDirectionPrimary;
    }

    public void setChildrenVisibility(int i10) {
        this.mChildVisibility = i10;
        if (i10 != -1) {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                getChildAt(i11).setVisibility(this.mChildVisibility);
            }
        }
    }

    public void setExtraLayoutSpace(int i10) {
        int i11 = this.mExtraLayoutSpace;
        if (i11 == i10) {
            return;
        }
        if (i11 < 0) {
            com.google.gson.internal.a.n("ExtraLayoutSpace must >= 0");
        } else {
            this.mExtraLayoutSpace = i10;
            requestLayout();
        }
    }

    public void setFocusOutAllowed(boolean z9, boolean z10) {
        this.mFlag = (z9 ? 2048 : 0) | (this.mFlag & (-6145)) | (z10 ? 4096 : 0);
    }

    public void setFocusOutSideAllowed(boolean z9, boolean z10) {
        this.mFlag = (z9 ? 8192 : 0) | (this.mFlag & (-24577)) | (z10 ? 16384 : 0);
    }

    public void setFocusScrollStrategy(int i10) {
        this.mFocusScrollStrategy = i10;
    }

    public void setFocusSearchDisabled(boolean z9) {
        this.mFlag = (z9 ? 32768 : 0) | (this.mFlag & (-32769));
    }

    public void setGravity(int i10) {
        this.mGravity = i10;
    }

    public void setGridView(BaseGridView baseGridView) {
        this.mBaseGridView = baseGridView;
        this.mGrid = null;
    }

    public void setHorizontalSpacing(int i10) {
        if (this.mOrientation == 0) {
            this.mHorizontalSpacing = i10;
            this.mSpacingPrimary = i10;
        } else {
            this.mHorizontalSpacing = i10;
            this.mSpacingSecondary = i10;
        }
    }

    public void setItemAlignmentOffset(int i10) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffset(i10);
        updateChildAlignments();
    }

    public void setItemAlignmentOffsetPercent(float f) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffsetPercent(f);
        updateChildAlignments();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z9) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffsetWithPadding(z9);
        updateChildAlignments();
    }

    public void setItemAlignmentViewId(int i10) {
        this.mItemAlignment.mainAxis().setItemAlignmentViewId(i10);
        updateChildAlignments();
    }

    public void setItemSpacing(int i10) {
        this.mHorizontalSpacing = i10;
        this.mVerticalSpacing = i10;
        this.mSpacingSecondary = i10;
        this.mSpacingPrimary = i10;
    }

    public void setLayoutEnabled(boolean z9) {
        int i10 = this.mFlag;
        if (((i10 & 512) != 0) != z9) {
            this.mFlag = (i10 & (-513)) | (z9 ? 512 : 0);
            requestLayout();
        }
    }

    public void setNumRows(int i10) {
        if (i10 >= 0) {
            this.mNumRowsRequested = i10;
        } else {
            f.a();
        }
    }

    public void setOnChildLaidOutListener(OnChildLaidOutListener onChildLaidOutListener) {
        this.mChildLaidOutListener = onChildLaidOutListener;
    }

    public void setOnChildSelectedListener(OnChildSelectedListener onChildSelectedListener) {
        this.mChildSelectedListener = onChildSelectedListener;
    }

    public void setOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        if (onChildViewHolderSelectedListener == null) {
            this.mChildViewHolderSelectedListeners = null;
            return;
        }
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList == null) {
            this.mChildViewHolderSelectedListeners = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.mChildViewHolderSelectedListeners.add(onChildViewHolderSelectedListener);
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.mOrientation = i10;
            this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, i10);
            this.mWindowAlignment.setOrientation(i10);
            this.mItemAlignment.setOrientation(i10);
            this.mFlag |= 256;
        }
    }

    public void setPruneChild(boolean z9) {
        int i10 = this.mFlag;
        if (((i10 & 65536) != 0) != z9) {
            this.mFlag = (i10 & (-65537)) | (z9 ? 65536 : 0);
            if (z9) {
                requestLayout();
            }
        }
    }

    public void setRowHeight(int i10) {
        if (i10 >= 0 || i10 == -2) {
            this.mRowSizeSecondaryRequested = i10;
        } else {
            com.google.gson.internal.a.n(a3.a.f(i10, "Invalid row height: "));
        }
    }

    public void setScrollEnabled(boolean z9) {
        int i10;
        int i11 = this.mFlag;
        if (((i11 & 131072) != 0) != z9) {
            int i12 = (i11 & (-131073)) | (z9 ? 131072 : 0);
            this.mFlag = i12;
            if ((i12 & 131072) == 0 || this.mFocusScrollStrategy != 0 || (i10 = this.mFocusPosition) == -1) {
                return;
            }
            scrollToSelection(i10, this.mSubFocusPosition, true, this.mPrimaryScrollExtra);
        }
    }

    public void setSelection(int i10, int i11, boolean z9, int i12) {
        if ((this.mFocusPosition == i10 || i10 == -1) && i11 == this.mSubFocusPosition && i12 == this.mPrimaryScrollExtra) {
            return;
        }
        scrollToSelection(i10, i11, z9, i12);
    }

    public void setSelectionSmooth(int i10) {
        setSelection(i10, 0, true, 0);
    }

    public void setSelectionSmoothWithSub(int i10, int i11) {
        setSelection(i10, i11, true, 0);
    }

    public void setSelectionWithSub(int i10, int i11, int i12) {
        setSelection(i10, i11, false, i12);
    }

    public void setVerticalSpacing(int i10) {
        if (this.mOrientation == 1) {
            this.mVerticalSpacing = i10;
            this.mSpacingPrimary = i10;
        } else {
            this.mVerticalSpacing = i10;
            this.mSpacingSecondary = i10;
        }
    }

    public void setWindowAlignment(int i10) {
        this.mWindowAlignment.mainAxis().setWindowAlignment(i10);
    }

    public void setWindowAlignmentOffset(int i10) {
        this.mWindowAlignment.mainAxis().setWindowAlignmentOffset(i10);
    }

    public void setWindowAlignmentOffsetPercent(float f) {
        this.mWindowAlignment.mainAxis().setWindowAlignmentOffsetPercent(f);
    }

    public void skipSmoothScrollerOnStopInternal() {
        GridLinearSmoothScroller gridLinearSmoothScroller = this.mCurrentSmoothScroller;
        if (gridLinearSmoothScroller != null) {
            gridLinearSmoothScroller.mSkipOnStopInternal = true;
        }
    }

    public void slideIn() {
        int i10 = this.mFlag;
        if ((i10 & 64) != 0) {
            this.mFlag = i10 & (-65);
            int i11 = this.mFocusPosition;
            if (i11 >= 0) {
                scrollToSelection(i11, this.mSubFocusPosition, true, this.mPrimaryScrollExtra);
            } else {
                this.mFlag = i10 & (-193);
                requestLayout();
            }
            int i12 = this.mFlag;
            if ((i12 & 128) != 0) {
                this.mFlag = i12 & (-129);
                if (this.mBaseGridView.getScrollState() != 0 || isSmoothScrolling()) {
                    this.mBaseGridView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: androidx.leanback.widget.GridLayoutManager.3
                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public void onScrollStateChanged(RecyclerView recyclerView, int i13) {
                            if (i13 == 0) {
                                GridLayoutManager.this.mBaseGridView.removeOnScrollListener(this);
                                GridLayoutManager.this.requestLayout();
                            }
                        }
                    });
                } else {
                    requestLayout();
                }
            }
        }
    }

    public void slideOut() {
        int i10 = this.mFlag;
        if ((i10 & 64) != 0) {
            return;
        }
        this.mFlag = i10 | 64;
        if (getChildCount() == 0) {
            return;
        }
        int i11 = this.mOrientation;
        BaseGridView baseGridView = this.mBaseGridView;
        if (i11 == 1) {
            baseGridView.smoothScrollBy(0, getSlideOutDistance(), new AccelerateDecelerateInterpolator());
        } else {
            baseGridView.smoothScrollBy(getSlideOutDistance(), 0, new AccelerateDecelerateInterpolator());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        setSelection(i10, 0, true, 0);
    }

    public int startPositionSmoothScroller(int i10) {
        GridLinearSmoothScroller gridLinearSmoothScroller = new GridLinearSmoothScroller() { // from class: androidx.leanback.widget.GridLayoutManager.4
            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i11) {
                if (getChildCount() == 0) {
                    return null;
                }
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                int position = gridLayoutManager.getPosition(gridLayoutManager.getChildAt(0));
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                int i12 = ((gridLayoutManager2.mFlag & 262144) == 0 ? i11 >= position : i11 <= position) ? 1 : -1;
                return gridLayoutManager2.mOrientation == 0 ? new PointF(i12, 0.0f) : new PointF(0.0f, i12);
            }
        };
        gridLinearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(gridLinearSmoothScroller);
        return gridLinearSmoothScroller.getTargetPosition();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void startSmoothScroll(RecyclerView.SmoothScroller smoothScroller) {
        skipSmoothScrollerOnStopInternal();
        super.startSmoothScroll(smoothScroller);
        if (!smoothScroller.isRunning() || !(smoothScroller instanceof GridLinearSmoothScroller)) {
            this.mCurrentSmoothScroller = null;
            this.mPendingMoveSmoothScroller = null;
            return;
        }
        GridLinearSmoothScroller gridLinearSmoothScroller = (GridLinearSmoothScroller) smoothScroller;
        this.mCurrentSmoothScroller = gridLinearSmoothScroller;
        if (gridLinearSmoothScroller instanceof PendingMoveSmoothScroller) {
            this.mPendingMoveSmoothScroller = (PendingMoveSmoothScroller) gridLinearSmoothScroller;
        } else {
            this.mPendingMoveSmoothScroller = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    public void updatePositionDeltaInPreLayout() {
        if (getChildCount() <= 0) {
            this.mPositionDeltaInPreLayout = 0;
        } else {
            this.mPositionDeltaInPreLayout = this.mGrid.getFirstVisibleIndex() - ((LayoutParams) getChildAt(0).getLayoutParams()).getViewLayoutPosition();
        }
    }

    public void updatePositionToRowMapInPostLayout() {
        Grid.Location location;
        this.mPositionToRowInPostLayout.clear();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            int oldPosition = this.mBaseGridView.getChildViewHolder(getChildAt(i10)).getOldPosition();
            if (oldPosition >= 0 && (location = this.mGrid.getLocation(oldPosition)) != null) {
                this.mPositionToRowInPostLayout.put(oldPosition, location.mRow);
            }
        }
    }

    public void updateScrollLimits() {
        int firstVisibleIndex;
        int lastVisibleIndex;
        int itemCount;
        int itemCount2;
        int iFindRowMax;
        int viewCenter;
        int iFindRowMin;
        int viewCenter2;
        if (this.mState.getItemCount() == 0) {
            return;
        }
        int i10 = this.mFlag & 262144;
        Grid grid = this.mGrid;
        if (i10 == 0) {
            firstVisibleIndex = grid.getLastVisibleIndex();
            itemCount2 = this.mState.getItemCount() - 1;
            lastVisibleIndex = this.mGrid.getFirstVisibleIndex();
            itemCount = 0;
        } else {
            firstVisibleIndex = grid.getFirstVisibleIndex();
            lastVisibleIndex = this.mGrid.getLastVisibleIndex();
            itemCount = this.mState.getItemCount() - 1;
            itemCount2 = 0;
        }
        if (firstVisibleIndex < 0 || lastVisibleIndex < 0) {
            return;
        }
        boolean z9 = firstVisibleIndex == itemCount2;
        boolean z10 = lastVisibleIndex == itemCount;
        if (z9 || !this.mWindowAlignment.mainAxis().isMaxUnknown() || z10 || !this.mWindowAlignment.mainAxis().isMinUnknown()) {
            if (z9) {
                iFindRowMax = this.mGrid.findRowMax(true, sTwoInts);
                View viewFindViewByPosition = findViewByPosition(sTwoInts[1]);
                viewCenter = getViewCenter(viewFindViewByPosition);
                int[] alignMultiple = ((LayoutParams) viewFindViewByPosition.getLayoutParams()).getAlignMultiple();
                if (alignMultiple != null && alignMultiple.length > 0) {
                    viewCenter += alignMultiple[alignMultiple.length - 1] - alignMultiple[0];
                }
            } else {
                iFindRowMax = Integer.MAX_VALUE;
                viewCenter = Integer.MAX_VALUE;
            }
            if (z10) {
                iFindRowMin = this.mGrid.findRowMin(false, sTwoInts);
                viewCenter2 = getViewCenter(findViewByPosition(sTwoInts[1]));
            } else {
                iFindRowMin = Integer.MIN_VALUE;
                viewCenter2 = Integer.MIN_VALUE;
            }
            this.mWindowAlignment.mainAxis().updateMinMax(iFindRowMin, iFindRowMax, viewCenter2, viewCenter);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class LayoutParams extends RecyclerView.LayoutParams {
        private int[] mAlignMultiple;
        private int mAlignX;
        private int mAlignY;
        private ItemAlignmentFacet mAlignmentFacet;
        int mBottomInset;
        int mLeftInset;
        int mRightInset;
        int mTopInset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void calculateItemAlignments(int i10, View view) {
            ItemAlignmentFacet.ItemAlignmentDef[] alignmentDefs = this.mAlignmentFacet.getAlignmentDefs();
            int[] iArr = this.mAlignMultiple;
            if (iArr == null || iArr.length != alignmentDefs.length) {
                this.mAlignMultiple = new int[alignmentDefs.length];
            }
            for (int i11 = 0; i11 < alignmentDefs.length; i11++) {
                this.mAlignMultiple[i11] = ItemAlignmentFacetHelper.getAlignmentPosition(view, alignmentDefs[i11], i10);
            }
            int[] iArr2 = this.mAlignMultiple;
            if (i10 == 0) {
                this.mAlignX = iArr2[0];
            } else {
                this.mAlignY = iArr2[0];
            }
        }

        public int[] getAlignMultiple() {
            return this.mAlignMultiple;
        }

        public int getAlignX() {
            return this.mAlignX;
        }

        public int getAlignY() {
            return this.mAlignY;
        }

        public ItemAlignmentFacet getItemAlignmentFacet() {
            return this.mAlignmentFacet;
        }

        public int getOpticalBottom(View view) {
            return view.getBottom() - this.mBottomInset;
        }

        public int getOpticalBottomInset() {
            return this.mBottomInset;
        }

        public int getOpticalHeight(View view) {
            return (view.getHeight() - this.mTopInset) - this.mBottomInset;
        }

        public int getOpticalLeft(View view) {
            return view.getLeft() + this.mLeftInset;
        }

        public int getOpticalLeftInset() {
            return this.mLeftInset;
        }

        public int getOpticalRight(View view) {
            return view.getRight() - this.mRightInset;
        }

        public int getOpticalRightInset() {
            return this.mRightInset;
        }

        public int getOpticalTop(View view) {
            return view.getTop() + this.mTopInset;
        }

        public int getOpticalTopInset() {
            return this.mTopInset;
        }

        public int getOpticalWidth(View view) {
            return (view.getWidth() - this.mLeftInset) - this.mRightInset;
        }

        public void setAlignX(int i10) {
            this.mAlignX = i10;
        }

        public void setAlignY(int i10) {
            this.mAlignY = i10;
        }

        public void setItemAlignmentFacet(ItemAlignmentFacet itemAlignmentFacet) {
            this.mAlignmentFacet = itemAlignmentFacet;
        }

        public void setOpticalInsets(int i10, int i11, int i12, int i13) {
            this.mLeftInset = i10;
            this.mTopInset = i11;
            this.mRightInset = i12;
            this.mBottomInset = i13;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
        }
    }

    public void setSelection(int i10, int i11) {
        setSelection(i10, 0, false, i11);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @SuppressLint({"BanParcelableUsage"})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.leanback.widget.GridLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        Bundle mChildStates;
        int mIndex;

        public SavedState(Parcel parcel) {
            this.mChildStates = Bundle.EMPTY;
            this.mIndex = parcel.readInt();
            this.mChildStates = parcel.readBundle(GridLayoutManager.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.mIndex);
            parcel.writeBundle(this.mChildStates);
        }

        public SavedState() {
            this.mChildStates = Bundle.EMPTY;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    private void updateChildAlignments() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            updateChildAlignments(getChildAt(i10));
        }
    }

    public GridLayoutManager() {
        this(null);
    }

    public void scrollToView(View view, boolean z9, int i10, int i11) {
        scrollToView(view, view == null ? null : view.findFocus(), z9, i10, i11);
    }

    private void scrollToView(View view, View view2, boolean z9) {
        scrollToView(view, view2, z9, 0, 0);
    }

    public void scrollToView(View view, boolean z9) {
        scrollToView(view, view == null ? null : view.findFocus(), z9);
    }
}
