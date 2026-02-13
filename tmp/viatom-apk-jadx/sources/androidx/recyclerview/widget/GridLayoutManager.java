package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.a;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "GridLayoutManager";
    private static final Set<Integer> sSupportedDirectionsForActionScrollInDirection = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS))));
    int[] mCachedBorders;
    int mColumnWithAccessibilityFocus;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    private int mPositionTargetedByScrollInDirection;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    int mRowWithAccessibilityFocus;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean isAccessibilityFocused(@NonNull View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i10) {
            return 1;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class SpanSizeLookup {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        public int getCachedSpanGroupIndex(int i10, int i11) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i10, i11);
            }
            int i12 = this.mSpanGroupIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanGroupIndex = getSpanGroupIndex(i10, i11);
            this.mSpanGroupIndexCache.put(i10, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i10, int i11) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i10, i11);
            }
            int i12 = this.mSpanIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanIndex = getSpanIndex(i10, i11);
            this.mSpanIndexCache.put(i10, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i10, int i11) {
            int spanSize;
            int i12;
            int i13;
            int iFindFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (iFindFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i10)) == -1) {
                spanSize = 0;
                i12 = 0;
                i13 = 0;
            } else {
                i12 = this.mSpanGroupIndexCache.get(iFindFirstKeyLessThan);
                i13 = iFindFirstKeyLessThan + 1;
                spanSize = getSpanSize(iFindFirstKeyLessThan) + getCachedSpanIndex(iFindFirstKeyLessThan, i11);
                if (spanSize == i11) {
                    i12++;
                    spanSize = 0;
                }
            }
            int spanSize2 = getSpanSize(i10);
            while (i13 < i10) {
                int spanSize3 = getSpanSize(i13);
                spanSize += spanSize3;
                if (spanSize == i11) {
                    i12++;
                    spanSize = 0;
                } else if (spanSize > i11) {
                    i12++;
                    spanSize = spanSize3;
                }
                i13++;
            }
            return spanSize + spanSize2 > i11 ? i12 + 1 : i12;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r4 = r4 + r3
                goto L30
            L20:
                r2 = r1
                r4 = r2
            L22:
                if (r2 >= r6) goto L33
                int r3 = r5.getSpanSize(r2)
                int r4 = r4 + r3
                if (r4 != r7) goto L2d
                r4 = r1
                goto L30
            L2d:
                if (r4 <= r7) goto L30
                r4 = r3
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r4
                if (r0 > r7) goto L37
                return r4
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i10);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z9) {
            if (!z9) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z9;
        }

        public void setSpanIndexCacheEnabled(boolean z9) {
            if (!z9) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z9;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i10, i11).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i10, boolean z9) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        if (z9) {
            i13 = 1;
            i12 = i10;
            i11 = 0;
        } else {
            i11 = i10 - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View view = this.mSet[i11];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanSize = spanSize;
            layoutParams.mSpanIndex = i14;
            i14 += spanSize;
            i11 += i13;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    public static int[] calculateItemBorders(int[] iArr, int i10, int i11) {
        int i12;
        if (iArr == null || iArr.length != i10 + 1 || iArr[iArr.length - 1] != i11) {
            iArr = new int[i10 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        if (getChildCount() != 0 && state.getItemCount() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount);
                int iMax = this.mShouldReverseLayout ? Math.max(0, ((this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
                if (zIsSmoothScrollbarEnabled) {
                    return Math.round((iMax * (Math.abs(this.mOrientationHelper.getDecoratedEnd(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (getChildCount() != 0 && state.getItemCount() != 0) {
            ensureLayoutState();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                }
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((decoratedEnd / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i10) {
        boolean z9 = i10 == 1;
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z9) {
            while (spanIndex > 0) {
                int i11 = anchorInfo.mPosition;
                if (i11 <= 0) {
                    return;
                }
                int i12 = i11 - 1;
                anchorInfo.mPosition = i12;
                spanIndex = getSpanIndex(recycler, state, i12);
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i13 = anchorInfo.mPosition;
        while (i13 < itemCount) {
            int i14 = i13 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i14);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i13 = i14;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i13;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    @Nullable
    private View findChildWithAccessibilityFocus() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            Objects.requireNonNull(childAt);
            if (Api21Impl.isAccessibilityFocused(childAt)) {
                return getChildAt(i10);
            }
        }
        return null;
    }

    private int findScrollTargetPositionAbove(int i10, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= 0; i13--) {
            int rowIndex = getRowIndex(i13);
            int columnIndex = getColumnIndex(i13);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if (rowIndex < i10 && getColumnIndices(i13).contains(Integer.valueOf(i11))) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    return i13;
                }
            } else if (rowIndex < i10 && columnIndex == i11) {
                this.mRowWithAccessibilityFocus = ((Integer) Collections.max(getRowIndices(i13))).intValue();
                return i13;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionBelow(int i10, int i11, int i12) {
        for (int i13 = i12 + 1; i13 < getItemCount(); i13++) {
            int rowIndex = getRowIndex(i13);
            int columnIndex = getColumnIndex(i13);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if (rowIndex > i10 && (columnIndex == i11 || getColumnIndices(i13).contains(Integer.valueOf(i11)))) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    return i13;
                }
            } else if (rowIndex > i10 && columnIndex == i11) {
                this.mRowWithAccessibilityFocus = getRowIndex(i13);
                return i13;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionOnTheLeft(int i10, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= 0; i13--) {
            int rowIndex = getRowIndex(i13);
            int columnIndex = getColumnIndex(i13);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if ((rowIndex == i10 && columnIndex < i11) || rowIndex < i10) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                    return i13;
                }
            } else if (getRowIndices(i13).contains(Integer.valueOf(i10)) && columnIndex < i11) {
                this.mColumnWithAccessibilityFocus = columnIndex;
                return i13;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionOnTheRight(int i10, int i11, int i12) {
        for (int i13 = i12 + 1; i13 < getItemCount(); i13++) {
            int rowIndex = getRowIndex(i13);
            int columnIndex = getColumnIndex(i13);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if ((rowIndex == i10 && columnIndex > i11) || rowIndex > i10) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                    return i13;
                }
            } else if (columnIndex > i11 && getRowIndices(i13).contains(Integer.valueOf(i10))) {
                this.mColumnWithAccessibilityFocus = columnIndex;
                return i13;
            }
        }
        return -1;
    }

    private int getColumnIndex(int i10) {
        int i11 = this.mOrientation;
        RecyclerView recyclerView = this.mRecyclerView;
        return i11 == 0 ? getSpanGroupIndex(recyclerView.mRecycler, recyclerView.mState, i10) : getSpanIndex(recyclerView.mRecycler, recyclerView.mState, i10);
    }

    private Set<Integer> getColumnIndices(int i10) {
        return getRowOrColumnIndices(getColumnIndex(i10), i10);
    }

    private int getRowIndex(int i10) {
        int i11 = this.mOrientation;
        RecyclerView recyclerView = this.mRecyclerView;
        return i11 == 1 ? getSpanGroupIndex(recyclerView.mRecycler, recyclerView.mState, i10) : getSpanIndex(recyclerView.mRecycler, recyclerView.mState, i10);
    }

    private Set<Integer> getRowIndices(int i10) {
        return getRowOrColumnIndices(getRowIndex(i10), i10);
    }

    private Set<Integer> getRowOrColumnIndices(int i10, int i11) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.mRecyclerView;
        int spanSize = getSpanSize(recyclerView.mRecycler, recyclerView.mState, i11);
        for (int i12 = i10; i12 < i10 + spanSize; i12++) {
            hashSet.add(Integer.valueOf(i12));
        }
        return hashSet;
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i10, this.mSpanCount);
        }
        int iConvertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i10);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(iConvertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        a.B(i10, "Cannot find span size for pre layout position. ", TAG);
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i10, this.mSpanCount);
        }
        int i11 = this.mPreLayoutSpanIndexCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iConvertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i10);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(iConvertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        a.B(i10, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", TAG);
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i10);
        }
        int i11 = this.mPreLayoutSpanSizeCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iConvertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i10);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(iConvertPreLayoutPositionToPostLayout);
        }
        a.B(i10, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", TAG);
        return 1;
    }

    private void guessMeasurement(float f, int i10) {
        calculateItemBorders(Math.max(Math.round(f * this.mSpanCount), i10));
    }

    private boolean hasAccessibilityFocusChanged(int i10) {
        return (getRowIndices(i10).contains(Integer.valueOf(this.mRowWithAccessibilityFocus)) && getColumnIndices(i10).contains(Integer.valueOf(this.mColumnWithAccessibilityFocus))) ? false : true;
    }

    private void measureChild(View view, int i10, boolean z9) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i11 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i12 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i10, i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec3 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i10, i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec4 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        measureChildWithDecorationsAndMargin(view, childMeasureSpec2, childMeasureSpec, z9);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i10, int i11, boolean z9) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z9 ? shouldReMeasureChild(view, i10, i11, layoutParams) : shouldMeasureChild(view, i10, i11, layoutParams)) {
            view.measure(i10, i11);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int spanSize = this.mSpanCount;
        for (int i10 = 0; i10 < this.mSpanCount && layoutState.hasMore(state) && spanSize > 0; i10++) {
            int i11 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i11, Math.max(0, layoutState.mScrollingOffset));
            spanSize -= this.mSpanSizeLookup.getSpanSize(i11);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(state) : super.computeHorizontalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(state) : super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(state) : super.computeVerticalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(state) : super.computeVerticalScrollRange(state);
    }

    public int findPositionOfFirstItemOnARowBelowForHorizontalGrid(int i10) {
        if (i10 < 0 || this.mOrientation == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap();
        for (int i11 = 0; i11 < getItemCount(); i11++) {
            for (Integer num : getRowIndices(i11)) {
                if (num.intValue() < 0) {
                    return -1;
                }
                if (!treeMap.containsKey(num)) {
                    treeMap.put(num, Integer.valueOf(i11));
                }
            }
        }
        for (Integer num2 : treeMap.keySet()) {
            int iIntValue = num2.intValue();
            if (iIntValue > i10) {
                int iIntValue2 = ((Integer) treeMap.get(num2)).intValue();
                this.mRowWithAccessibilityFocus = iIntValue;
                this.mColumnWithAccessibilityFocus = 0;
                return iIntValue2;
            }
        }
        return -1;
    }

    public int findPositionOfLastItemOnARowAboveForHorizontalGrid(int i10) {
        if (i10 < 0 || this.mOrientation == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        for (int i11 = 0; i11 < getItemCount(); i11++) {
            for (Integer num : getRowIndices(i11)) {
                if (num.intValue() < 0) {
                    return -1;
                }
                treeMap.put(num, Integer.valueOf(i11));
            }
        }
        for (Integer num2 : treeMap.keySet()) {
            int iIntValue = num2.intValue();
            if (iIntValue < i10) {
                int iIntValue2 = ((Integer) treeMap.get(num2)).intValue();
                this.mRowWithAccessibilityFocus = iIntValue;
                this.mColumnWithAccessibilityFocus = getColumnIndex(iIntValue2);
                return iIntValue2;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z9, boolean z10) {
        int i10;
        int childCount;
        int childCount2 = getChildCount();
        int i11 = 1;
        if (z10) {
            childCount = getChildCount() - 1;
            i10 = -1;
            i11 = -1;
        } else {
            i10 = childCount2;
            childCount = 0;
        }
        int itemCount = state.getItemCount();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (childCount != i10) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && getSpanIndex(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            childCount += i11;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i10, int i11) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.mCachedBorders;
        int i12 = this.mSpanCount;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i10;
        int paddingLeft;
        int i11;
        int paddingTop;
        int decoratedMeasurementInOther;
        int childMeasureSpec;
        int childMeasureSpec2;
        View next;
        GridLayoutManager gridLayoutManager = this;
        int modeInOther = gridLayoutManager.mOrientationHelper.getModeInOther();
        boolean z9 = modeInOther != 1073741824;
        int i12 = gridLayoutManager.getChildCount() > 0 ? gridLayoutManager.mCachedBorders[gridLayoutManager.mSpanCount] : 0;
        if (z9) {
            gridLayoutManager.updateMeasurements();
        }
        boolean z10 = layoutState.mItemDirection == 1;
        int spanIndex = gridLayoutManager.mSpanCount;
        if (!z10) {
            spanIndex = gridLayoutManager.getSpanIndex(recycler, state, layoutState.mCurrentPosition) + gridLayoutManager.getSpanSize(recycler, state, layoutState.mCurrentPosition);
        }
        int i13 = 0;
        while (i13 < gridLayoutManager.mSpanCount && layoutState.hasMore(state) && spanIndex > 0) {
            int i14 = layoutState.mCurrentPosition;
            int spanSize = gridLayoutManager.getSpanSize(recycler, state, i14);
            if (spanSize > gridLayoutManager.mSpanCount) {
                com.google.gson.internal.a.n(a3.a.n(a3.a.q(i14, spanSize, "Item at position ", " requires ", " spans but GridLayoutManager has only "), " spans.", gridLayoutManager.mSpanCount));
                return;
            }
            spanIndex -= spanSize;
            if (spanIndex < 0 || (next = layoutState.next(recycler)) == null) {
                break;
            }
            gridLayoutManager.mSet[i13] = next;
            i13++;
        }
        if (i13 == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        gridLayoutManager.assignSpans(recycler, state, i13, z10);
        float f = 0.0f;
        int i15 = 0;
        for (int i16 = 0; i16 < i13; i16++) {
            View view = gridLayoutManager.mSet[i16];
            if (layoutState.mScrapList == null) {
                if (z10) {
                    gridLayoutManager.addView(view);
                } else {
                    gridLayoutManager.addView(view, 0);
                }
            } else if (z10) {
                gridLayoutManager.addDisappearingView(view);
            } else {
                gridLayoutManager.addDisappearingView(view, 0);
            }
            gridLayoutManager.calculateItemDecorationsForChild(view, gridLayoutManager.mDecorInsets);
            gridLayoutManager.measureChild(view, modeInOther, false);
            int decoratedMeasurement = gridLayoutManager.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i15) {
                i15 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther2 = (gridLayoutManager.mOrientationHelper.getDecoratedMeasurementInOther(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).mSpanSize;
            if (decoratedMeasurementInOther2 > f) {
                f = decoratedMeasurementInOther2;
            }
        }
        if (z9) {
            gridLayoutManager.guessMeasurement(f, i12);
            i15 = 0;
            for (int i17 = 0; i17 < i13; i17++) {
                View view2 = gridLayoutManager.mSet[i17];
                gridLayoutManager.measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = gridLayoutManager.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i15) {
                    i15 = decoratedMeasurement2;
                }
            }
        }
        for (int i18 = 0; i18 < i13; i18++) {
            View view3 = gridLayoutManager.mSet[i18];
            if (gridLayoutManager.mOrientationHelper.getDecoratedMeasurement(view3) != i15) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i19 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i20 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int spaceForSpanRange = gridLayoutManager.getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (gridLayoutManager.mOrientation == 1) {
                    childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i20, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15 - i19, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15 - i20, 1073741824);
                    childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i19, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                gridLayoutManager.measureChildWithDecorationsAndMargin(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        layoutChunkResult.mConsumed = i15;
        int i21 = gridLayoutManager.mOrientation;
        int i22 = layoutState.mLayoutDirection;
        if (i21 == 1) {
            i11 = layoutState.mOffset;
            if (i22 == -1) {
                paddingTop = i11 - i15;
                paddingLeft = 0;
            } else {
                paddingTop = i11;
                paddingLeft = 0;
                i11 = i15 + i11;
            }
            i10 = paddingLeft;
        } else {
            int i23 = layoutState.mOffset;
            if (i22 == -1) {
                paddingLeft = i23 - i15;
                i10 = i23;
            } else {
                i10 = i15 + i23;
                paddingLeft = i23;
            }
            i11 = 0;
            paddingTop = 0;
        }
        int decoratedMeasurementInOther3 = i10;
        int i24 = 0;
        while (true) {
            View[] viewArr = gridLayoutManager.mSet;
            if (i24 >= i13) {
                Arrays.fill(viewArr, (Object) null);
                return;
            }
            int i25 = i11;
            View view4 = viewArr[i24];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (gridLayoutManager.mOrientation == 1) {
                if (gridLayoutManager.isLayoutRTL()) {
                    decoratedMeasurementInOther3 = gridLayoutManager.mCachedBorders[gridLayoutManager.mSpanCount - layoutParams2.mSpanIndex] + gridLayoutManager.getPaddingLeft();
                    paddingLeft = decoratedMeasurementInOther3 - gridLayoutManager.mOrientationHelper.getDecoratedMeasurementInOther(view4);
                } else {
                    paddingLeft = gridLayoutManager.getPaddingLeft() + gridLayoutManager.mCachedBorders[layoutParams2.mSpanIndex];
                    decoratedMeasurementInOther3 = gridLayoutManager.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft;
                }
                decoratedMeasurementInOther = i25;
            } else {
                paddingTop = gridLayoutManager.getPaddingTop() + gridLayoutManager.mCachedBorders[layoutParams2.mSpanIndex];
                decoratedMeasurementInOther = gridLayoutManager.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
            }
            gridLayoutManager.layoutDecoratedWithMargins(view4, paddingLeft, paddingTop, decoratedMeasurementInOther3, decoratedMeasurementInOther);
            i11 = decoratedMeasurementInOther;
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable = view4.hasFocusable() | layoutChunkResult.mFocusable;
            i24++;
            gridLayoutManager = this;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i10) {
        super.onAnchorReady(recycler, state, anchorInfo, i10);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i10);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d3, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0110  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
        RecyclerView.Adapter adapter = this.mRecyclerView.mAdapter;
        if (adapter == null || adapter.getItemCount() <= 1) {
            return;
        }
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        View viewFindViewByPosition;
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
        int i10 = this.mPositionTargetedByScrollInDirection;
        if (i10 == -1 || (viewFindViewByPosition = findViewByPosition(i10)) == null) {
            return;
        }
        viewFindViewByPosition.sendAccessibilityEvent(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        this.mPositionTargetedByScrollInDirection = -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean performAccessibilityAction(int i10, @Nullable Bundle bundle) {
        RecyclerView.ViewHolder childViewHolder;
        int iFindScrollTargetPositionOnTheLeft;
        if (i10 != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION.getId() || i10 == -1) {
            if (i10 != 16908343 || bundle == null) {
                return super.performAccessibilityAction(i10, bundle);
            }
            int i11 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_ROW_INT, -1);
            int i12 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_COLUMN_INT, -1);
            if (i11 != -1 && i12 != -1) {
                int itemCount = this.mRecyclerView.mAdapter.getItemCount();
                int i13 = 0;
                while (true) {
                    if (i13 >= itemCount) {
                        i13 = -1;
                        break;
                    }
                    RecyclerView recyclerView = this.mRecyclerView;
                    int spanIndex = getSpanIndex(recyclerView.mRecycler, recyclerView.mState, i13);
                    RecyclerView recyclerView2 = this.mRecyclerView;
                    int spanGroupIndex = getSpanGroupIndex(recyclerView2.mRecycler, recyclerView2.mState, i13);
                    if (this.mOrientation != 1) {
                        if (spanIndex == i11 && spanGroupIndex == i12) {
                            break;
                        }
                        i13++;
                    } else {
                        if (spanIndex == i12 && spanGroupIndex == i11) {
                            break;
                        }
                        i13++;
                    }
                }
                if (i13 > -1) {
                    scrollToPositionWithOffset(i13, 0);
                    return true;
                }
            }
            return false;
        }
        View viewFindChildWithAccessibilityFocus = findChildWithAccessibilityFocus();
        if (viewFindChildWithAccessibilityFocus == null || bundle == null) {
            return false;
        }
        int i14 = bundle.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
        if (!sSupportedDirectionsForActionScrollInDirection.contains(Integer.valueOf(i14)) || (childViewHolder = this.mRecyclerView.getChildViewHolder(viewFindChildWithAccessibilityFocus)) == null) {
            return false;
        }
        int absoluteAdapterPosition = childViewHolder.getAbsoluteAdapterPosition();
        int rowIndex = getRowIndex(absoluteAdapterPosition);
        int columnIndex = getColumnIndex(absoluteAdapterPosition);
        if (rowIndex >= 0 && columnIndex >= 0) {
            if (hasAccessibilityFocusChanged(absoluteAdapterPosition)) {
                this.mRowWithAccessibilityFocus = rowIndex;
                this.mColumnWithAccessibilityFocus = columnIndex;
            }
            int i15 = this.mRowWithAccessibilityFocus;
            if (i15 == -1) {
                i15 = rowIndex;
            }
            int i16 = this.mColumnWithAccessibilityFocus;
            if (i16 != -1) {
                columnIndex = i16;
            }
            if (i14 == 17) {
                iFindScrollTargetPositionOnTheLeft = findScrollTargetPositionOnTheLeft(i15, columnIndex, absoluteAdapterPosition);
            } else if (i14 == 33) {
                iFindScrollTargetPositionOnTheLeft = findScrollTargetPositionAbove(i15, columnIndex, absoluteAdapterPosition);
            } else if (i14 == 66) {
                iFindScrollTargetPositionOnTheLeft = findScrollTargetPositionOnTheRight(i15, columnIndex, absoluteAdapterPosition);
            } else {
                if (i14 != 130) {
                    return false;
                }
                iFindScrollTargetPositionOnTheLeft = findScrollTargetPositionBelow(i15, columnIndex, absoluteAdapterPosition);
            }
            if (iFindScrollTargetPositionOnTheLeft == -1 && this.mOrientation == 0) {
                if (i14 == 17) {
                    iFindScrollTargetPositionOnTheLeft = findPositionOfLastItemOnARowAboveForHorizontalGrid(rowIndex);
                } else if (i14 == 66) {
                    iFindScrollTargetPositionOnTheLeft = findPositionOfFirstItemOnARowBelowForHorizontalGrid(rowIndex);
                }
            }
            if (iFindScrollTargetPositionOnTheLeft != -1) {
                scrollToPosition(iFindScrollTargetPositionOnTheLeft);
                this.mPositionTargetedByScrollInDirection = iFindScrollTargetPositionOnTheLeft;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i10, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i10, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int iChooseSize;
        int iChooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i10, i11);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView.LayoutManager.chooseSize(i11, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            iChooseSize = RecyclerView.LayoutManager.chooseSize(i10, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.LayoutManager.chooseSize(i10, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            iChooseSize2 = RecyclerView.LayoutManager.chooseSize(i11, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setSpanCount(int i10) {
        if (i10 == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i10 < 1) {
            com.google.gson.internal.a.n(a3.a.f(i10, "Span count should be at least 1. Provided "));
            return;
        }
        this.mSpanCount = i10;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z9) {
        if (z9) {
            a2.a.m("GridLayoutManager does not support stack from end. Consider using reverse layout");
        } else {
            super.setStackFromEnd(false);
        }
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z9) {
        this.mUsingSpansToEstimateScrollBarDimensions = z9;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    private void calculateItemBorders(int i10) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i10);
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z9) {
        super(context, i11, z9);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(i10);
    }
}
