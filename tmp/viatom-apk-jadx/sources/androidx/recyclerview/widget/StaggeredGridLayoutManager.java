package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.widgets.analyzer.a;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private int mFullSizeSpec;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;

    @NonNull
    private final LayoutState mLayoutState;
    private int mOrientation;
    private SavedState mPendingSavedState;
    private int[] mPrefetchDistances;

    @NonNull
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;

    @NonNull
    OrientationHelper mSecondaryOrientation;
    private int mSizePerSpan;
    Span[] mSpans;
    private int mSpanCount = -1;
    boolean mReverseLayout = false;
    boolean mShouldReverseLayout = false;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    LazySpanLookup mLazySpanLookup = new LazySpanLookup();
    private int mGapStrategy = 2;
    private final Rect mTmpRect = new Rect();
    private final AnchorInfo mAnchorInfo = new AnchorInfo();
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mSmoothScrollbarEnabled = true;
    private final Runnable mCheckForGapsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        for (int i10 = this.mSpanCount - 1; i10 >= 0; i10--) {
            this.mSpans[i10].appendToSpan(view);
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        SavedState savedState = this.mPendingSavedState;
        int i10 = savedState.mSpanOffsetsSize;
        if (i10 > 0) {
            if (i10 == this.mSpanCount) {
                for (int i11 = 0; i11 < this.mSpanCount; i11++) {
                    this.mSpans[i11].clear();
                    SavedState savedState2 = this.mPendingSavedState;
                    int endAfterPadding = savedState2.mSpanOffsets[i11];
                    if (endAfterPadding != Integer.MIN_VALUE) {
                        boolean z9 = savedState2.mAnchorLayoutFromEnd;
                        OrientationHelper orientationHelper = this.mPrimaryOrientation;
                        endAfterPadding += z9 ? orientationHelper.getEndAfterPadding() : orientationHelper.getStartAfterPadding();
                    }
                    this.mSpans[i11].setLine(endAfterPadding);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.mPendingSavedState;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.mPendingSavedState;
        int i12 = savedState5.mAnchorPosition;
        if (i12 != -1) {
            this.mPendingScrollPosition = i12;
            anchorInfo.mLayoutFromEnd = savedState5.mAnchorLayoutFromEnd;
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
            lazySpanLookup.mData = savedState5.mSpanLookup;
            lazySpanLookup.mFullSpanItems = savedState5.mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (layoutParams.mFullSpan) {
                appendViewToAllSpans(view);
                return;
            } else {
                layoutParams.mSpan.appendToSpan(view);
                return;
            }
        }
        if (layoutParams.mFullSpan) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.prependToSpan(view);
        }
    }

    private int calculateScrollDirectionForPosition(int i10) {
        if (getChildCount() == 0) {
            return this.mShouldReverseLayout ? 1 : -1;
        }
        return (i10 < getFirstChildPosition()) != this.mShouldReverseLayout ? -1 : 1;
    }

    private boolean checkSpanForGap(Span span) {
        boolean z9;
        if (this.mShouldReverseLayout) {
            if (span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
                z9 = span.getLayoutParams((View) a.t(span.mViews, 1)).mFullSpan;
                return !z9;
            }
            return false;
        }
        if (span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
            z9 = span.getLayoutParams(span.mViews.get(0)).mFullSpan;
            return !z9;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            fullSpanItem.mGapPerSpan[i11] = i10 - this.mSpans[i11].getEndLine(i10);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            fullSpanItem.mGapPerSpan[i11] = this.mSpans[i11].getStartLine(i10) - i10;
        }
        return fullSpanItem;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    private int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        Span nextSpan;
        int minStart;
        int decoratedMeasurement;
        int startAfterPadding;
        int decoratedMeasurement2;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        StaggeredGridLayoutManager staggeredGridLayoutManager2 = this;
        ?? r82 = 0;
        staggeredGridLayoutManager2.mRemainingSpans.set(0, staggeredGridLayoutManager2.mSpanCount, true);
        int i10 = staggeredGridLayoutManager2.mLayoutState.mInfinite ? layoutState.mLayoutDirection == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : layoutState.mLayoutDirection == 1 ? layoutState.mEndLine + layoutState.mAvailable : layoutState.mStartLine - layoutState.mAvailable;
        staggeredGridLayoutManager2.updateAllRemainingSpans(layoutState.mLayoutDirection, i10);
        boolean z9 = staggeredGridLayoutManager2.mShouldReverseLayout;
        OrientationHelper orientationHelper = staggeredGridLayoutManager2.mPrimaryOrientation;
        int endAfterPadding = z9 ? orientationHelper.getEndAfterPadding() : orientationHelper.getStartAfterPadding();
        boolean z10 = false;
        StaggeredGridLayoutManager staggeredGridLayoutManager3 = staggeredGridLayoutManager2;
        while (layoutState.hasMore(state) && (staggeredGridLayoutManager3.mLayoutState.mInfinite || !staggeredGridLayoutManager3.mRemainingSpans.isEmpty())) {
            View next = layoutState.next(recycler);
            LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int span = staggeredGridLayoutManager3.mLazySpanLookup.getSpan(viewLayoutPosition);
            boolean z11 = span == -1 ? true : r82;
            if (z11) {
                nextSpan = layoutParams.mFullSpan ? staggeredGridLayoutManager3.mSpans[r82] : staggeredGridLayoutManager3.getNextSpan(layoutState);
                staggeredGridLayoutManager3.mLazySpanLookup.setSpan(viewLayoutPosition, nextSpan);
            } else {
                nextSpan = staggeredGridLayoutManager3.mSpans[span];
            }
            Span span2 = nextSpan;
            layoutParams.mSpan = span2;
            if (layoutState.mLayoutDirection == 1) {
                staggeredGridLayoutManager3.addView(next);
            } else {
                staggeredGridLayoutManager3.addView(next, r82);
            }
            staggeredGridLayoutManager3.measureChildWithDecorationsAndMargin(next, layoutParams, r82);
            int i11 = layoutState.mLayoutDirection;
            boolean z12 = layoutParams.mFullSpan;
            if (i11 == 1) {
                decoratedMeasurement = z12 ? staggeredGridLayoutManager3.getMaxEnd(endAfterPadding) : span2.getEndLine(endAfterPadding);
                minStart = staggeredGridLayoutManager3.mPrimaryOrientation.getDecoratedMeasurement(next) + decoratedMeasurement;
                if (z11 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem fullSpanItemCreateFullSpanItemFromEnd = staggeredGridLayoutManager3.createFullSpanItemFromEnd(decoratedMeasurement);
                    fullSpanItemCreateFullSpanItemFromEnd.mGapDir = -1;
                    fullSpanItemCreateFullSpanItemFromEnd.mPosition = viewLayoutPosition;
                    staggeredGridLayoutManager3.mLazySpanLookup.addFullSpanItem(fullSpanItemCreateFullSpanItemFromEnd);
                }
            } else {
                minStart = z12 ? staggeredGridLayoutManager3.getMinStart(endAfterPadding) : span2.getStartLine(endAfterPadding);
                decoratedMeasurement = minStart - staggeredGridLayoutManager3.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (z11 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem fullSpanItemCreateFullSpanItemFromStart = staggeredGridLayoutManager3.createFullSpanItemFromStart(minStart);
                    fullSpanItemCreateFullSpanItemFromStart.mGapDir = 1;
                    fullSpanItemCreateFullSpanItemFromStart.mPosition = viewLayoutPosition;
                    staggeredGridLayoutManager3.mLazySpanLookup.addFullSpanItem(fullSpanItemCreateFullSpanItemFromStart);
                }
            }
            if (layoutParams.mFullSpan && layoutState.mItemDirection == -1) {
                if (z11) {
                    staggeredGridLayoutManager3.mLaidOutInvalidFullSpan = true;
                } else {
                    if (!(layoutState.mLayoutDirection == 1 ? staggeredGridLayoutManager3.areAllEndsEqual() : staggeredGridLayoutManager3.areAllStartsEqual())) {
                        LazySpanLookup.FullSpanItem fullSpanItem = staggeredGridLayoutManager3.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        staggeredGridLayoutManager3.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            staggeredGridLayoutManager3.attachViewToSpans(next, layoutParams, layoutState);
            if (staggeredGridLayoutManager3.isLayoutRTL() && staggeredGridLayoutManager3.mOrientation == 1) {
                boolean z13 = layoutParams.mFullSpan;
                OrientationHelper orientationHelper2 = staggeredGridLayoutManager3.mSecondaryOrientation;
                decoratedMeasurement2 = z13 ? orientationHelper2.getEndAfterPadding() : orientationHelper2.getEndAfterPadding() - (((staggeredGridLayoutManager3.mSpanCount - 1) - span2.mIndex) * staggeredGridLayoutManager3.mSizePerSpan);
                startAfterPadding = decoratedMeasurement2 - staggeredGridLayoutManager3.mSecondaryOrientation.getDecoratedMeasurement(next);
            } else {
                startAfterPadding = layoutParams.mFullSpan ? staggeredGridLayoutManager3.mSecondaryOrientation.getStartAfterPadding() : staggeredGridLayoutManager3.mSecondaryOrientation.getStartAfterPadding() + (span2.mIndex * staggeredGridLayoutManager3.mSizePerSpan);
                decoratedMeasurement2 = staggeredGridLayoutManager3.mSecondaryOrientation.getDecoratedMeasurement(next) + startAfterPadding;
            }
            int i12 = decoratedMeasurement2;
            int i13 = startAfterPadding;
            if (staggeredGridLayoutManager3.mOrientation == 1) {
                staggeredGridLayoutManager3.layoutDecoratedWithMargins(next, i13, decoratedMeasurement, i12, minStart);
                staggeredGridLayoutManager = this;
            } else {
                staggeredGridLayoutManager3.layoutDecoratedWithMargins(next, decoratedMeasurement, i13, minStart, i12);
                staggeredGridLayoutManager = staggeredGridLayoutManager3;
            }
            boolean z14 = layoutParams.mFullSpan;
            LayoutState layoutState2 = staggeredGridLayoutManager.mLayoutState;
            if (z14) {
                staggeredGridLayoutManager.updateAllRemainingSpans(layoutState2.mLayoutDirection, i10);
            } else {
                staggeredGridLayoutManager.updateRemainingSpans(span2, layoutState2.mLayoutDirection, i10);
            }
            staggeredGridLayoutManager.recycle(recycler, staggeredGridLayoutManager.mLayoutState);
            if (staggeredGridLayoutManager.mLayoutState.mStopInFocusable && next.hasFocusable()) {
                boolean z15 = layoutParams.mFullSpan;
                BitSet bitSet = staggeredGridLayoutManager.mRemainingSpans;
                if (z15) {
                    bitSet.clear();
                } else {
                    bitSet.set(span2.mIndex, false);
                }
            }
            z10 = true;
            r82 = 0;
            staggeredGridLayoutManager3 = staggeredGridLayoutManager;
        }
        if (!z10) {
            staggeredGridLayoutManager3.recycle(recycler, staggeredGridLayoutManager3.mLayoutState);
        }
        int i14 = staggeredGridLayoutManager3.mLayoutState.mLayoutDirection;
        OrientationHelper orientationHelper3 = staggeredGridLayoutManager3.mPrimaryOrientation;
        int startAfterPadding2 = i14 == -1 ? staggeredGridLayoutManager3.mPrimaryOrientation.getStartAfterPadding() - staggeredGridLayoutManager3.getMinStart(orientationHelper3.getStartAfterPadding()) : staggeredGridLayoutManager3.getMaxEnd(orientationHelper3.getEndAfterPadding()) - staggeredGridLayoutManager3.mPrimaryOrientation.getEndAfterPadding();
        if (startAfterPadding2 > 0) {
            return Math.min(layoutState.mAvailable, startAfterPadding2);
        }
        return 0;
    }

    private int findFirstReferenceChildPosition(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            int position = getPosition(getChildAt(i11));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z9) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i10 = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (!z9 || i10 <= 0) {
                return;
            }
            this.mPrimaryOrientation.offsetChildren(i10);
        }
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z9) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int iScrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (!z9 || iScrollBy <= 0) {
                return;
            }
            this.mPrimaryOrientation.offsetChildren(-iScrollBy);
        }
    }

    private int getMaxEnd(int i10) {
        int endLine = this.mSpans[0].getEndLine(i10);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            int endLine2 = this.mSpans[i11].getEndLine(i10);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMaxStart(int i10) {
        int startLine = this.mSpans[0].getStartLine(i10);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            int startLine2 = this.mSpans[i11].getStartLine(i10);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinEnd(int i10) {
        int endLine = this.mSpans[0].getEndLine(i10);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            int endLine2 = this.mSpans[i11].getEndLine(i10);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinStart(int i10) {
        int startLine = this.mSpans[0].getStartLine(i10);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            int startLine2 = this.mSpans[i11].getStartLine(i10);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private Span getNextSpan(LayoutState layoutState) {
        int i10;
        int i11;
        int i12;
        boolean zPreferLastSpan = preferLastSpan(layoutState.mLayoutDirection);
        int i13 = this.mSpanCount;
        if (zPreferLastSpan) {
            i11 = i13 - 1;
            i12 = -1;
            i10 = -1;
        } else {
            i10 = i13;
            i11 = 0;
            i12 = 1;
        }
        int i14 = layoutState.mLayoutDirection;
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        Span span = null;
        if (i14 == 1) {
            int startAfterPadding = orientationHelper.getStartAfterPadding();
            int i15 = Integer.MAX_VALUE;
            while (i11 != i10) {
                Span span2 = this.mSpans[i11];
                int endLine = span2.getEndLine(startAfterPadding);
                if (endLine < i15) {
                    span = span2;
                    i15 = endLine;
                }
                i11 += i12;
            }
            return span;
        }
        int endAfterPadding = orientationHelper.getEndAfterPadding();
        int i16 = Integer.MIN_VALUE;
        while (i11 != i10) {
            Span span3 = this.mSpans[i11];
            int startLine = span3.getStartLine(endAfterPadding);
            if (startLine > i16) {
                span = span3;
                i16 = startLine;
            }
            i11 += i12;
        }
        return span;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleUpdate(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.mShouldReverseLayout
            if (r0 == 0) goto L9
            int r0 = r6.getLastChildPosition()
            goto Ld
        L9:
            int r0 = r6.getFirstChildPosition()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.mLazySpanLookup
            r4.invalidateAfter(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForRemoval(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.mLazySpanLookup
            r7.offsetForAddition(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForRemoval(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForAddition(r7, r8)
        L42:
            if (r2 > r0) goto L45
            goto L57
        L45:
            boolean r7 = r6.mShouldReverseLayout
            if (r7 == 0) goto L4e
            int r7 = r6.getFirstChildPosition()
            goto L52
        L4e:
            int r7 = r6.getLastChildPosition()
        L52:
            if (r3 > r7) goto L57
            r6.requestLayout()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.handleUpdate(int, int, int):void");
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean z9) {
        boolean z10 = layoutParams.mFullSpan;
        int i10 = this.mOrientation;
        if (z10) {
            if (i10 != 1) {
                measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.mFullSizeSpec, z9);
                return;
            }
            measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z9);
            return;
        }
        if (i10 != 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z9);
            return;
        }
        measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z9);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    private boolean preferLastSpan(int i10) {
        if (this.mOrientation == 0) {
            return (i10 == -1) != this.mShouldReverseLayout;
        }
        return ((i10 == -1) == this.mShouldReverseLayout) == isLayoutRTL();
    }

    private void prependViewToAllSpans(View view) {
        for (int i10 = this.mSpanCount - 1; i10 >= 0; i10--) {
            this.mSpans[i10].prependToSpan(view);
        }
    }

    private void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.mRecycle || layoutState.mInfinite) {
            return;
        }
        int i10 = layoutState.mAvailable;
        int i11 = layoutState.mLayoutDirection;
        if (i10 == 0) {
            if (i11 == -1) {
                recycleFromEnd(recycler, layoutState.mEndLine);
                return;
            } else {
                recycleFromStart(recycler, layoutState.mStartLine);
                return;
            }
        }
        if (i11 != -1) {
            int minEnd = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
            int iMin = layoutState.mStartLine;
            if (minEnd >= 0) {
                iMin += Math.min(minEnd, layoutState.mAvailable);
            }
            recycleFromStart(recycler, iMin);
            return;
        }
        int i12 = layoutState.mStartLine;
        int maxStart = i12 - getMaxStart(i12);
        int iMin2 = layoutState.mEndLine;
        if (maxStart >= 0) {
            iMin2 -= Math.min(maxStart, layoutState.mAvailable);
        }
        recycleFromEnd(recycler, iMin2);
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) < i10 || this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) < i10) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.mFullSpan) {
                for (int i11 = 0; i11 < this.mSpanCount; i11++) {
                    if (this.mSpans[i11].mViews.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                    this.mSpans[i12].popEnd();
                }
            } else if (layoutParams.mSpan.mViews.size() == 1) {
                return;
            } else {
                layoutParams.mSpan.popEnd();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i10) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > i10 || this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) > i10) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.mFullSpan) {
                for (int i11 = 0; i11 < this.mSpanCount; i11++) {
                    if (this.mSpans[i11].mViews.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                    this.mSpans[i12].popStart();
                }
            } else if (layoutParams.mSpan.mViews.size() == 1) {
                return;
            } else {
                layoutParams.mSpan.popStart();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            float decoratedMeasurement = this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= fMax) {
                if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.mSpanCount;
                }
                fMax = Math.max(fMax, decoratedMeasurement);
            }
        }
        int i11 = this.mSizePerSpan;
        int iRound = Math.round(fMax * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.mSecondaryOrientation.getTotalSpace());
        }
        updateMeasureSpecs(iRound);
        if (this.mSizePerSpan == i11) {
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.mFullSpan) {
                if (isLayoutRTL() && this.mOrientation == 1) {
                    int i13 = this.mSpanCount;
                    int i14 = layoutParams.mSpan.mIndex;
                    childAt2.offsetLeftAndRight(((-((i13 - 1) - i14)) * this.mSizePerSpan) - ((-((i13 - 1) - i14)) * i11));
                } else {
                    int i15 = layoutParams.mSpan.mIndex;
                    int i16 = this.mSizePerSpan * i15;
                    int i17 = i15 * i11;
                    if (this.mOrientation == 1) {
                        childAt2.offsetLeftAndRight(i16 - i17);
                    } else {
                        childAt2.offsetTopAndBottom(i16 - i17);
                    }
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private void setLayoutStateDirection(int i10) {
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i10;
        layoutState.mItemDirection = this.mShouldReverseLayout != (i10 == -1) ? -1 : 1;
    }

    private void updateAllRemainingSpans(int i10, int i11) {
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            if (!this.mSpans[i12].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i12], i10, i11);
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        anchorInfo.mPosition = this.mLastLayoutFromEnd ? findLastReferenceChildPosition(state.getItemCount()) : findFirstReferenceChildPosition(state.getItemCount());
        anchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }

    private void updateLayoutState(int i10, RecyclerView.State state) {
        int totalSpace;
        int totalSpace2;
        int targetScrollPosition;
        LayoutState layoutState = this.mLayoutState;
        boolean z9 = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = i10;
        if (!isSmoothScrolling() || (targetScrollPosition = state.getTargetScrollPosition()) == -1) {
            totalSpace = 0;
            totalSpace2 = 0;
        } else {
            boolean z10 = this.mShouldReverseLayout;
            boolean z11 = targetScrollPosition < i10;
            OrientationHelper orientationHelper = this.mPrimaryOrientation;
            if (z10 == z11) {
                totalSpace = orientationHelper.getTotalSpace();
                totalSpace2 = 0;
            } else {
                totalSpace2 = orientationHelper.getTotalSpace();
                totalSpace = 0;
            }
        }
        boolean clipToPadding = getClipToPadding();
        LayoutState layoutState2 = this.mLayoutState;
        if (clipToPadding) {
            layoutState2.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - totalSpace2;
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + totalSpace;
        } else {
            layoutState2.mEndLine = this.mPrimaryOrientation.getEnd() + totalSpace;
            this.mLayoutState.mStartLine = -totalSpace2;
        }
        LayoutState layoutState3 = this.mLayoutState;
        layoutState3.mStopInFocusable = false;
        layoutState3.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
            z9 = true;
        }
        layoutState3.mInfinite = z9;
    }

    private void updateRemainingSpans(Span span, int i10, int i11) {
        int deletedSize = span.getDeletedSize();
        if (i10 == -1) {
            if (span.getStartLine() + deletedSize <= i11) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
        } else if (span.getEndLine() - deletedSize >= i11) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    private int updateSpecWithExtra(int i10, int i11, int i12) {
        int mode;
        return (!(i11 == 0 && i12 == 0) && ((mode = View.MeasureSpec.getMode(i10)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    public boolean areAllEndsEqual() {
        int endLine = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.mSpanCount; i10++) {
            if (this.mSpans[i10].getEndLine(Integer.MIN_VALUE) != endLine) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllStartsEqual() {
        int startLine = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.mSpanCount; i10++) {
            if (this.mSpans[i10].getStartLine(Integer.MIN_VALUE) != startLine) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean checkForGaps() {
        int firstChildPosition;
        int lastChildPosition;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            firstChildPosition = getLastChildPosition();
            lastChildPosition = getFirstChildPosition();
        } else {
            firstChildPosition = getFirstChildPosition();
            lastChildPosition = getLastChildPosition();
        }
        if (firstChildPosition == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.mLaidOutInvalidFullSpan) {
            return false;
        }
        int i10 = this.mShouldReverseLayout ? -1 : 1;
        int i11 = lastChildPosition + 1;
        LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, i11, i10, true);
        if (firstFullSpanItemInRange == null) {
            this.mLaidOutInvalidFullSpan = false;
            this.mLazySpanLookup.forceInvalidateAfter(i11);
            return false;
        }
        LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, firstFullSpanItemInRange.mPosition, i10 * (-1), true);
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (firstFullSpanItemInRange2 == null) {
            lazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
        } else {
            lazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int endLine;
        int startLine;
        if (this.mOrientation != 0) {
            i10 = i11;
        }
        if (getChildCount() == 0 || i10 == 0) {
            return;
        }
        prepareLayoutStateForDelta(i10, state);
        int[] iArr = this.mPrefetchDistances;
        if (iArr == null || iArr.length < this.mSpanCount) {
            this.mPrefetchDistances = new int[this.mSpanCount];
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.mSpanCount; i13++) {
            LayoutState layoutState = this.mLayoutState;
            if (layoutState.mItemDirection == -1) {
                endLine = layoutState.mStartLine;
                startLine = this.mSpans[i13].getStartLine(endLine);
            } else {
                endLine = this.mSpans[i13].getEndLine(layoutState.mEndLine);
                startLine = this.mLayoutState.mEndLine;
            }
            int i14 = endLine - startLine;
            if (i14 >= 0) {
                this.mPrefetchDistances[i12] = i14;
                i12++;
            }
        }
        Arrays.sort(this.mPrefetchDistances, 0, i12);
        for (int i15 = 0; i15 < i12 && this.mLayoutState.hasMore(state); i15++) {
            layoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[i15]);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mCurrentPosition += layoutState2.mItemDirection;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i10) {
        int iCalculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i10);
        PointF pointF = new PointF();
        if (iCalculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = iCalculateScrollDirectionForPosition;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = iCalculateScrollDirectionForPosition;
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        int i10 = this.mSpanCount;
        if (iArr == null) {
            iArr = new int[i10];
        } else if (iArr.length < i10) {
            androidx.core.view.accessibility.a.e(this.mSpanCount, iArr.length, ", array size:", "Provided int[]'s size must be more than or equal to span count. Expected:");
            return null;
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public View findFirstVisibleItemClosestToEnd(boolean z9) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z9) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View findFirstVisibleItemClosestToStart(boolean z9) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z9) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public int findFirstVisibleItemPositionInt() {
        View viewFindFirstVisibleItemClosestToEnd = this.mShouldReverseLayout ? findFirstVisibleItemClosestToEnd(true) : findFirstVisibleItemClosestToStart(true);
        if (viewFindFirstVisibleItemClosestToEnd == null) {
            return -1;
        }
        return getPosition(viewFindFirstVisibleItemClosestToEnd);
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        int i10 = this.mSpanCount;
        if (iArr == null) {
            iArr = new int[i10];
        } else if (iArr.length < i10) {
            androidx.core.view.accessibility.a.e(this.mSpanCount, iArr.length, ", array size:", "Provided int[]'s size must be more than or equal to span count. Expected:");
            return null;
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        int i10 = this.mSpanCount;
        if (iArr == null) {
            iArr = new int[i10];
        } else if (iArr.length < i10) {
            androidx.core.view.accessibility.a.e(this.mSpanCount, iArr.length, ", array size:", "Provided int[]'s size must be more than or equal to span count. Expected:");
            return null;
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        int i10 = this.mSpanCount;
        if (iArr == null) {
            iArr = new int[i10];
        } else if (iArr.length < i10) {
            androidx.core.view.accessibility.a.e(this.mSpanCount, iArr.length, ", array size:", "Provided int[]'s size must be more than or equal to span count. Expected:");
            return null;
        }
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            iArr[i11] = this.mSpans[i11].findLastVisibleItemPosition();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return Math.min(this.mSpanCount, state.getItemCount());
        }
        return -1;
    }

    public int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return Math.min(this.mSpanCount, state.getItemCount());
        }
        return -1;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View hasGapsToFix() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.mSpanCount
            r2.<init>(r3)
            int r3 = r12.mSpanCount
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.mOrientation
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.mShouldReverseLayout
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La2
            android.view.View r7 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.mSpan
            int r9 = r9.mIndex
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.mSpan
            boolean r9 = r12.checkSpanForGap(r9)
            if (r9 == 0) goto L4b
            goto L9f
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.mSpan
            int r9 = r9.mIndex
            r2.clear(r9)
        L52:
            boolean r9 = r8.mFullSpan
            if (r9 == 0) goto L57
            goto La0
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La0
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.mShouldReverseLayout
            androidx.recyclerview.widget.OrientationHelper r11 = r12.mPrimaryOrientation
            if (r10 == 0) goto L75
            int r10 = r11.getDecoratedEnd(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.mPrimaryOrientation
            int r11 = r11.getDecoratedEnd(r9)
            if (r10 >= r11) goto L72
            goto L9f
        L72:
            if (r10 != r11) goto La0
            goto L84
        L75:
            int r10 = r11.getDecoratedStart(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.mPrimaryOrientation
            int r11 = r11.getDecoratedStart(r9)
            if (r10 <= r11) goto L82
            goto L9f
        L82:
            if (r10 != r11) goto La0
        L84:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r8 = r8.mSpan
            int r8 = r8.mIndex
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.mSpan
            int r9 = r9.mIndex
            int r8 = r8 - r9
            if (r8 >= 0) goto L97
            r8 = r5
            goto L98
        L97:
            r8 = r4
        L98:
            if (r3 >= 0) goto L9c
            r9 = r5
            goto L9d
        L9c:
            r9 = r4
        L9d:
            if (r8 == r9) goto La0
        L9f:
            return r7
        La0:
            int r1 = r1 + r6
            goto L2c
        La2:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.hasGapsToFix():android.view.View");
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isLayoutReversed() {
        return this.mReverseLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i10) {
        super.offsetChildrenHorizontal(i10);
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            this.mSpans[i11].onOffset(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i10) {
        super.offsetChildrenVertical(i10);
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            this.mSpans[i11].onOffset(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2) {
        this.mLazySpanLookup.clear();
        for (int i10 = 0; i10 < this.mSpanCount; i10++) {
            this.mSpans[i10].clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i10 = 0; i10 < this.mSpanCount; i10++) {
            this.mSpans[i10].clear();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public View onFocusSearchFailed(View view, int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View viewFindContainingItemView;
        View focusableViewAfter;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10);
        if (iConvertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewFindContainingItemView.getLayoutParams();
        boolean z9 = layoutParams.mFullSpan;
        Span span = layoutParams.mSpan;
        int lastChildPosition = iConvertFocusDirectionToLayoutDirection == 1 ? getLastChildPosition() : getFirstChildPosition();
        updateLayoutState(lastChildPosition, state);
        setLayoutStateDirection(iConvertFocusDirectionToLayoutDirection);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = layoutState.mItemDirection + lastChildPosition;
        layoutState.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * MAX_SCROLL_FACTOR);
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = true;
        layoutState2.mRecycle = false;
        fill(recycler, layoutState2, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z9 && (focusableViewAfter = span.getFocusableViewAfter(lastChildPosition, iConvertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != viewFindContainingItemView) {
            return focusableViewAfter;
        }
        if (preferLastSpan(iConvertFocusDirectionToLayoutDirection)) {
            for (int i11 = this.mSpanCount - 1; i11 >= 0; i11--) {
                View focusableViewAfter2 = this.mSpans[i11].getFocusableViewAfter(lastChildPosition, iConvertFocusDirectionToLayoutDirection);
                if (focusableViewAfter2 != null && focusableViewAfter2 != viewFindContainingItemView) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                View focusableViewAfter3 = this.mSpans[i12].getFocusableViewAfter(lastChildPosition, iConvertFocusDirectionToLayoutDirection);
                if (focusableViewAfter3 != null && focusableViewAfter3 != viewFindContainingItemView) {
                    return focusableViewAfter3;
                }
            }
        }
        boolean z10 = (this.mReverseLayout ^ true) == (iConvertFocusDirectionToLayoutDirection == -1);
        if (!z9) {
            View viewFindViewByPosition = findViewByPosition(z10 ? span.findFirstPartiallyVisibleItemPosition() : span.findLastPartiallyVisibleItemPosition());
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (preferLastSpan(iConvertFocusDirectionToLayoutDirection)) {
            for (int i13 = this.mSpanCount - 1; i13 >= 0; i13--) {
                if (i13 != span.mIndex) {
                    Span[] spanArr = this.mSpans;
                    View viewFindViewByPosition2 = findViewByPosition(z10 ? spanArr[i13].findFirstPartiallyVisibleItemPosition() : spanArr[i13].findLastPartiallyVisibleItemPosition());
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.mSpanCount; i14++) {
                Span[] spanArr2 = this.mSpans;
                View viewFindViewByPosition3 = findViewByPosition(z10 ? spanArr2[i14].findFirstPartiallyVisibleItemPosition() : spanArr2[i14].findLastPartiallyVisibleItemPosition());
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewFindFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View viewFindFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (viewFindFirstVisibleItemClosestToStart == null || viewFindFirstVisibleItemClosestToEnd == null) {
                return;
            }
            int position = getPosition(viewFindFirstVisibleItemClosestToStart);
            int position2 = getPosition(viewFindFirstVisibleItemClosestToEnd);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.mFullSpan ? this.mSpanCount : 1, -1, -1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.mFullSpan ? this.mSpanCount : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        handleUpdate(i10, i11, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        handleUpdate(i10, i11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        handleUpdate(i10, i11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        handleUpdate(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchorPositionInfo();
                this.mPendingSavedState.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int startLine;
        int startAfterPadding;
        int[] iArr;
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.mData) == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.mFullSpanItems;
        }
        if (getChildCount() <= 0) {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
            return savedState;
        }
        savedState.mAnchorPosition = this.mLastLayoutFromEnd ? getLastChildPosition() : getFirstChildPosition();
        savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
        int i10 = this.mSpanCount;
        savedState.mSpanOffsetsSize = i10;
        savedState.mSpanOffsets = new int[i10];
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            boolean z9 = this.mLastLayoutFromEnd;
            Span[] spanArr = this.mSpans;
            if (z9) {
                startLine = spanArr[i11].getEndLine(Integer.MIN_VALUE);
                if (startLine != Integer.MIN_VALUE) {
                    startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                    startLine -= startAfterPadding;
                }
            } else {
                startLine = spanArr[i11].getStartLine(Integer.MIN_VALUE);
                if (startLine != Integer.MIN_VALUE) {
                    startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                    startLine -= startAfterPadding;
                }
            }
            savedState.mSpanOffsets[i11] = startLine;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i10) {
        if (i10 == 0) {
            checkForGaps();
        }
    }

    public void prepareLayoutStateForDelta(int i10, RecyclerView.State state) {
        int firstChildPosition;
        int i11;
        if (i10 > 0) {
            firstChildPosition = getLastChildPosition();
            i11 = 1;
        } else {
            firstChildPosition = getFirstChildPosition();
            i11 = -1;
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(firstChildPosition, state);
        setLayoutStateDirection(i11);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = firstChildPosition + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(i10);
    }

    public int scrollBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i10, state);
        int iFill = fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.mAvailable >= iFill) {
            i10 = i10 < 0 ? -iFill : iFill;
        }
        this.mPrimaryOrientation.offsetChildren(-i10);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mAvailable = 0;
        recycle(recycler, layoutState);
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i10, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mAnchorPosition != i10) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i10, int i11) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = i11;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i10, recycler, state);
    }

    public void setGapStrategy(int i10) {
        assertNotInLayoutOrScroll(null);
        if (i10 == this.mGapStrategy) {
            return;
        }
        if (i10 != 0 && i10 != 2) {
            com.google.gson.internal.a.n("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        } else {
            this.mGapStrategy = i10;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int iChooseSize;
        int iChooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView.LayoutManager.chooseSize(i11, rect.height() + paddingBottom, getMinimumHeight());
            iChooseSize = RecyclerView.LayoutManager.chooseSize(i10, (this.mSizePerSpan * this.mSpanCount) + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.LayoutManager.chooseSize(i10, rect.width() + paddingRight, getMinimumWidth());
            iChooseSize2 = RecyclerView.LayoutManager.chooseSize(i11, (this.mSizePerSpan * this.mSpanCount) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            com.google.gson.internal.a.n("invalid orientation.");
            return;
        }
        assertNotInLayoutOrScroll(null);
        if (i10 == this.mOrientation) {
            return;
        }
        this.mOrientation = i10;
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = orientationHelper;
        requestLayout();
    }

    public void setReverseLayout(boolean z9) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mReverseLayout != z9) {
            savedState.mReverseLayout = z9;
        }
        this.mReverseLayout = z9;
        requestLayout();
    }

    public void setSpanCount(int i10) {
        assertNotInLayoutOrScroll(null);
        if (i10 != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i10;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (int i11 = 0; i11 < this.mSpanCount; i11++) {
                this.mSpans[i11] = new Span(i11);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i10;
        if (!state.isPreLayout() && (i10 = this.mPendingScrollPosition) != -1) {
            if (i10 >= 0 && i10 < state.getItemCount()) {
                SavedState savedState = this.mPendingSavedState;
                if (savedState == null || savedState.mAnchorPosition == -1 || savedState.mSpanOffsetsSize < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (viewFindViewByPosition != null) {
                        anchorInfo.mPosition = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            boolean z9 = anchorInfo.mLayoutFromEnd;
                            OrientationHelper orientationHelper = this.mPrimaryOrientation;
                            if (z9) {
                                anchorInfo.mOffset = (orientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(viewFindViewByPosition);
                            } else {
                                anchorInfo.mOffset = (orientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.mPrimaryOrientation.getDecoratedMeasurement(viewFindViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                            boolean z10 = anchorInfo.mLayoutFromEnd;
                            OrientationHelper orientationHelper2 = this.mPrimaryOrientation;
                            anchorInfo.mOffset = z10 ? orientationHelper2.getEndAfterPadding() : orientationHelper2.getStartAfterPadding();
                            return true;
                        }
                        int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(viewFindViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                        if (decoratedStart < 0) {
                            anchorInfo.mOffset = -decoratedStart;
                            return true;
                        }
                        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(viewFindViewByPosition);
                        if (endAfterPadding < 0) {
                            anchorInfo.mOffset = endAfterPadding;
                            return true;
                        }
                        anchorInfo.mOffset = Integer.MIN_VALUE;
                    } else {
                        int i11 = this.mPendingScrollPosition;
                        anchorInfo.mPosition = i11;
                        int i12 = this.mPendingScrollPositionOffset;
                        if (i12 == Integer.MIN_VALUE) {
                            anchorInfo.mLayoutFromEnd = calculateScrollDirectionForPosition(i11) == 1;
                            anchorInfo.assignCoordinateFromPadding();
                        } else {
                            anchorInfo.assignCoordinateFromPadding(i12);
                        }
                        anchorInfo.mInvalidateOffsets = true;
                    }
                } else {
                    anchorInfo.mOffset = Integer.MIN_VALUE;
                    anchorInfo.mPosition = this.mPendingScrollPosition;
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    public void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (updateAnchorFromPendingData(state, anchorInfo) || updateAnchorFromChildren(state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        anchorInfo.mPosition = 0;
    }

    public void updateMeasureSpecs(int i10) {
        this.mSizePerSpan = i10 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i10, this.mSecondaryOrientation.getMode());
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            Span span = this.mSpan;
            if (span == null) {
                return -1;
            }
            return span.mIndex;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean z9) {
            this.mFullSpan = z9;
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
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        final int mIndex;
        ArrayList<View> mViews = new ArrayList<>();
        int mCachedStart = Integer.MIN_VALUE;
        int mCachedEnd = Integer.MIN_VALUE;
        int mDeletedSize = 0;

        public Span(int i10) {
            this.mIndex = i10;
        }

        public void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view) + this.mDeletedSize;
            }
        }

        public void cacheReferenceLineAndClear(boolean z9, int i10) {
            int endLine = z9 ? getEndLine(Integer.MIN_VALUE) : getStartLine(Integer.MIN_VALUE);
            clear();
            if (endLine == Integer.MIN_VALUE) {
                return;
            }
            if (!z9 || endLine >= StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) {
                if (z9 || endLine <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()) {
                    if (i10 != Integer.MIN_VALUE) {
                        endLine += i10;
                    }
                    this.mCachedEnd = endLine;
                    this.mCachedStart = endLine;
                }
            }
        }

        public void calculateCachedEnd() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = (View) a.t(this.mViews, 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
                this.mCachedEnd += fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        public void calculateCachedStart() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.mViews.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
                this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        public void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            boolean z9 = StaggeredGridLayoutManager.this.mReverseLayout;
            ArrayList<View> arrayList = this.mViews;
            return z9 ? findOneVisibleChild(arrayList.size() - 1, -1, true) : findOneVisibleChild(0, arrayList.size(), true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            boolean z9 = StaggeredGridLayoutManager.this.mReverseLayout;
            ArrayList<View> arrayList = this.mViews;
            return z9 ? findOnePartiallyVisibleChild(arrayList.size() - 1, -1, true) : findOnePartiallyVisibleChild(0, arrayList.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? findOneVisibleChild(r1.size() - 1, -1, false) : findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            boolean z9 = StaggeredGridLayoutManager.this.mReverseLayout;
            ArrayList<View> arrayList = this.mViews;
            return z9 ? findOneVisibleChild(0, arrayList.size(), true) : findOneVisibleChild(arrayList.size() - 1, -1, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            boolean z9 = StaggeredGridLayoutManager.this.mReverseLayout;
            ArrayList<View> arrayList = this.mViews;
            return z9 ? findOnePartiallyVisibleChild(0, arrayList.size(), true) : findOnePartiallyVisibleChild(arrayList.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? findOneVisibleChild(0, this.mViews.size(), false) : findOneVisibleChild(r1.size() - 1, -1, false);
        }

        public int findOnePartiallyOrCompletelyVisibleChild(int i10, int i11, boolean z9, boolean z10, boolean z11) {
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            int i12 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = this.mViews.get(i10);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z12 = false;
                boolean z13 = !z11 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
                if (!z11 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z12 = true;
                }
                if (z13 && z12) {
                    if (z9 && z10) {
                        if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z10) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i10 += i12;
            }
            return -1;
        }

        public int findOnePartiallyVisibleChild(int i10, int i11, boolean z9) {
            return findOnePartiallyOrCompletelyVisibleChild(i10, i11, false, false, z9);
        }

        public int findOneVisibleChild(int i10, int i11, boolean z9) {
            return findOnePartiallyOrCompletelyVisibleChild(i10, i11, z9, true, false);
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        public int getEndLine(int i10) {
            int i11 = this.mCachedEnd;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.mViews.size() == 0) {
                return i10;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public View getFocusableViewAfter(int i10, int i11) {
            ArrayList<View> arrayList = this.mViews;
            View view = null;
            if (i11 != -1) {
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    View view2 = this.mViews.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = arrayList.size();
            int i12 = 0;
            while (i12 < size2) {
                View view3 = this.mViews.get(i12);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) <= i10) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) >= i10) || !view3.hasFocusable()) {
                    break;
                }
                i12++;
                view = view3;
            }
            return view;
        }

        public LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public int getStartLine(int i10) {
            int i11 = this.mCachedStart;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.mViews.size() == 0) {
                return i10;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        public void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        public void onOffset(int i10) {
            int i11 = this.mCachedStart;
            if (i11 != Integer.MIN_VALUE) {
                this.mCachedStart = i11 + i10;
            }
            int i12 = this.mCachedEnd;
            if (i12 != Integer.MIN_VALUE) {
                this.mCachedEnd = i12 + i10;
            }
        }

        public void popEnd() {
            int size = this.mViews.size();
            View viewRemove = this.mViews.remove(size - 1);
            LayoutParams layoutParams = getLayoutParams(viewRemove);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(viewRemove);
            }
            if (size == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        public void popStart() {
            View viewRemove = this.mViews.remove(0);
            LayoutParams layoutParams = getLayoutParams(viewRemove);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(viewRemove);
            }
            this.mCachedStart = Integer.MIN_VALUE;
        }

        public void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(0, view);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view) + this.mDeletedSize;
            }
        }

        public void setLine(int i10) {
            this.mCachedStart = i10;
            this.mCachedEnd = i10;
        }

        public int getEndLine() {
            int i10 = this.mCachedEnd;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public int getStartLine() {
            int i10 = this.mCachedStart;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public void assignCoordinateFromPadding(int i10) {
            boolean z9 = this.mLayoutFromEnd;
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            if (z9) {
                this.mOffset = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding() - i10;
            } else {
                this.mOffset = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding() + i10;
            }
        }

        public void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void saveSpanReferenceLines(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr == null || iArr.length < length) {
                this.mSpanReferenceLines = new int[StaggeredGridLayoutManager.this.mSpans.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.mSpanReferenceLines[i10] = spanArr[i10].getStartLine(Integer.MIN_VALUE);
            }
        }

        public void assignCoordinateFromPadding() {
            int startAfterPadding;
            boolean z9 = this.mLayoutFromEnd;
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            if (z9) {
                startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
            } else {
                startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
            }
            this.mOffset = startAfterPadding;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        private int invalidateFullSpansAfter(int i10) {
            if (this.mFullSpanItems == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i10);
            if (fullSpanItem != null) {
                this.mFullSpanItems.remove(fullSpanItem);
            }
            int size = this.mFullSpanItems.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (this.mFullSpanItems.get(i11).mPosition >= i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i11);
            this.mFullSpanItems.remove(i11);
            return fullSpanItem2.mPosition;
        }

        private void offsetFullSpansForAddition(int i10, int i11) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                int i12 = fullSpanItem.mPosition;
                if (i12 >= i10) {
                    fullSpanItem.mPosition = i12 + i11;
                }
            }
        }

        private void offsetFullSpansForRemoval(int i10, int i11) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                int i13 = fullSpanItem.mPosition;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.mFullSpanItems.remove(size);
                    } else {
                        fullSpanItem.mPosition = i13 - i11;
                    }
                }
            }
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            int i10 = 0;
            while (true) {
                List<FullSpanItem> list = this.mFullSpanItems;
                if (i10 >= size) {
                    list.add(fullSpanItem);
                    return;
                }
                FullSpanItem fullSpanItem2 = list.get(i10);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i10);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i10, fullSpanItem);
                    return;
                }
                i10++;
            }
        }

        public void clear() {
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mFullSpanItems = null;
        }

        public void ensureSize(int i10) {
            int[] iArr = this.mData;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.mData = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[sizeForPosition(i10)];
                this.mData = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.mData;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int forceInvalidateAfter(int i10) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.mFullSpanItems.get(size).mPosition >= i10) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i10);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i10, int i11, int i12, boolean z9) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(i13);
                int i14 = fullSpanItem.mPosition;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.mGapDir == i12 || (z9 && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i10) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public int getSpan(int i10) {
            int[] iArr = this.mData;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        public int invalidateAfter(int i10) {
            int[] iArr = this.mData;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int iInvalidateFullSpansAfter = invalidateFullSpansAfter(i10);
            int[] iArr2 = this.mData;
            if (iInvalidateFullSpansAfter == -1) {
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.mData.length;
            }
            int iMin = Math.min(iInvalidateFullSpansAfter + 1, iArr2.length);
            Arrays.fill(this.mData, i10, iMin, -1);
            return iMin;
        }

        public void offsetForAddition(int i10, int i11) {
            int[] iArr = this.mData;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            ensureSize(i12);
            int[] iArr2 = this.mData;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.mData, i10, i12, -1);
            offsetFullSpansForAddition(i10, i11);
        }

        public void offsetForRemoval(int i10, int i11) {
            int[] iArr = this.mData;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            ensureSize(i12);
            int[] iArr2 = this.mData;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.mData;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            offsetFullSpansForRemoval(i10, i11);
        }

        public void setSpan(int i10, Span span) {
            ensureSize(i10);
            this.mData[i10] = span.mIndex;
        }

        public int sizeForPosition(int i10) {
            int length = this.mData.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            };
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() == 1;
                int i10 = parcel.readInt();
                if (i10 > 0) {
                    int[] iArr = new int[i10];
                    this.mGapPerSpan = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int getGapForSpan(int i10) {
                int[] iArr = this.mGapPerSpan;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.mGapPerSpan);
                }
            }

            public FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i10, int i11) {
        this.mOrientation = i11;
        setSpanCount(i10);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
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
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int i10 = parcel.readInt();
            this.mSpanOffsetsSize = i10;
            if (i10 > 0) {
                int[] iArr = new int[i10];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int i11 = parcel.readInt();
            this.mSpanLookupSize = i11;
            if (i11 > 0) {
                int[] iArr2 = new int[i11];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        public SavedState() {
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, int i10, int i11, boolean z9) {
        boolean zShouldMeasureChild;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.mTmpRect;
        int iUpdateSpecWithExtra = updateSpecWithExtra(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.mTmpRect;
        int iUpdateSpecWithExtra2 = updateSpecWithExtra(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z9) {
            zShouldMeasureChild = shouldReMeasureChild(view, iUpdateSpecWithExtra, iUpdateSpecWithExtra2, layoutParams);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, iUpdateSpecWithExtra, iUpdateSpecWithExtra2, layoutParams);
        }
        if (zShouldMeasureChild) {
            view.measure(iUpdateSpecWithExtra, iUpdateSpecWithExtra2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }
}
