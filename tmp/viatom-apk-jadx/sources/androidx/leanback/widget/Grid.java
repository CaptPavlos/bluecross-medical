package androidx.leanback.widget;

import android.util.SparseIntArray;
import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;
import java.util.Arrays;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
abstract class Grid {
    static final int START_DEFAULT = -1;
    protected int mNumRows;
    protected Provider mProvider;
    protected boolean mReversedFlow;
    protected int mSpacing;
    protected CircularIntArray[] mTmpItemPositionsInRows;
    Object[] mTmpItem = new Object[1];
    protected int mFirstVisibleIndex = -1;
    protected int mLastVisibleIndex = -1;
    protected int mStartIndex = -1;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Location {
        int mRow;

        public Location(int i10) {
            this.mRow = i10;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Provider {
        void addItem(Object obj, int i10, int i11, int i12, int i13);

        int createItem(int i10, boolean z9, Object[] objArr, boolean z10);

        int getCount();

        int getEdge(int i10);

        int getMinIndex();

        int getSize(int i10);

        void removeItem(int i10);
    }

    public static Grid createGrid(int i10) {
        if (i10 == 1) {
            return new SingleRow();
        }
        StaggeredGridDefault staggeredGridDefault = new StaggeredGridDefault();
        staggeredGridDefault.setNumRows(i10);
        return staggeredGridDefault;
    }

    private void resetVisibleIndexIfEmpty() {
        if (this.mLastVisibleIndex < this.mFirstVisibleIndex) {
            resetVisibleIndex();
        }
    }

    public boolean appendOneColumnVisibleItems() {
        return appendVisibleItems(this.mReversedFlow ? Integer.MAX_VALUE : Integer.MIN_VALUE, true);
    }

    public final void appendVisibleItems(int i10) {
        appendVisibleItems(i10, false);
    }

    public abstract boolean appendVisibleItems(int i10, boolean z9);

    public final boolean checkAppendOverLimit(int i10) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        return this.mReversedFlow ? findRowMin(true, null) <= i10 + this.mSpacing : findRowMax(false, null) >= i10 - this.mSpacing;
    }

    public final boolean checkPrependOverLimit(int i10) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        return this.mReversedFlow ? findRowMax(false, null) >= i10 - this.mSpacing : findRowMin(true, null) <= i10 + this.mSpacing;
    }

    public abstract void debugPrint(PrintWriter printWriter);

    public void fillDisappearingItems(int[] iArr, int i10, SparseIntArray sparseIntArray) {
        int lastVisibleIndex = getLastVisibleIndex();
        int iBinarySearch = lastVisibleIndex >= 0 ? Arrays.binarySearch(iArr, 0, i10, lastVisibleIndex) : 0;
        if (iBinarySearch < 0) {
            boolean z9 = this.mReversedFlow;
            Provider provider = this.mProvider;
            int edge = z9 ? (provider.getEdge(lastVisibleIndex) - this.mProvider.getSize(lastVisibleIndex)) - this.mSpacing : provider.getEdge(lastVisibleIndex) + this.mProvider.getSize(lastVisibleIndex) + this.mSpacing;
            for (int i11 = (-iBinarySearch) - 1; i11 < i10; i11++) {
                int i12 = iArr[i11];
                int i13 = sparseIntArray.get(i12);
                int i14 = i13 < 0 ? 0 : i13;
                int iCreateItem = this.mProvider.createItem(i12, true, this.mTmpItem, true);
                this.mProvider.addItem(this.mTmpItem[0], i12, iCreateItem, i14, edge);
                boolean z10 = this.mReversedFlow;
                int i15 = this.mSpacing;
                edge = z10 ? (edge - iCreateItem) - i15 : edge + iCreateItem + i15;
            }
        }
        int firstVisibleIndex = getFirstVisibleIndex();
        int iBinarySearch2 = firstVisibleIndex >= 0 ? Arrays.binarySearch(iArr, 0, i10, firstVisibleIndex) : 0;
        if (iBinarySearch2 < 0) {
            int i16 = (-iBinarySearch2) - 2;
            boolean z11 = this.mReversedFlow;
            Provider provider2 = this.mProvider;
            int edge2 = z11 ? provider2.getEdge(firstVisibleIndex) : provider2.getEdge(firstVisibleIndex);
            while (i16 >= 0) {
                int i17 = iArr[i16];
                int i18 = sparseIntArray.get(i17);
                int i19 = i18 < 0 ? 0 : i18;
                int iCreateItem2 = this.mProvider.createItem(i17, false, this.mTmpItem, true);
                boolean z12 = this.mReversedFlow;
                int i20 = this.mSpacing;
                int i21 = z12 ? edge2 + i20 + iCreateItem2 : (edge2 - i20) - iCreateItem2;
                this.mProvider.addItem(this.mTmpItem[0], i17, iCreateItem2, i19, i21);
                i16--;
                edge2 = i21;
            }
        }
    }

    public abstract int findRowMax(boolean z9, int i10, int[] iArr);

    public final int findRowMax(boolean z9, int[] iArr) {
        return findRowMax(z9, this.mReversedFlow ? this.mFirstVisibleIndex : this.mLastVisibleIndex, iArr);
    }

    public abstract int findRowMin(boolean z9, int i10, int[] iArr);

    public final int findRowMin(boolean z9, int[] iArr) {
        return findRowMin(z9, this.mReversedFlow ? this.mLastVisibleIndex : this.mFirstVisibleIndex, iArr);
    }

    public final int getFirstVisibleIndex() {
        return this.mFirstVisibleIndex;
    }

    public final CircularIntArray[] getItemPositionsInRows() {
        return getItemPositionsInRows(getFirstVisibleIndex(), getLastVisibleIndex());
    }

    public abstract CircularIntArray[] getItemPositionsInRows(int i10, int i11);

    public final int getLastVisibleIndex() {
        return this.mLastVisibleIndex;
    }

    public abstract Location getLocation(int i10);

    public int getNumRows() {
        return this.mNumRows;
    }

    public final int getRowIndex(int i10) {
        Location location = getLocation(i10);
        if (location == null) {
            return -1;
        }
        return location.mRow;
    }

    public void invalidateItemsAfter(int i10) {
        int i11;
        if (i10 >= 0 && (i11 = this.mLastVisibleIndex) >= 0) {
            if (i11 >= i10) {
                this.mLastVisibleIndex = i10 - 1;
            }
            resetVisibleIndexIfEmpty();
            if (getFirstVisibleIndex() < 0) {
                setStart(i10);
            }
        }
    }

    public boolean isReversedFlow() {
        return this.mReversedFlow;
    }

    public final boolean prependOneColumnVisibleItems() {
        return prependVisibleItems(this.mReversedFlow ? Integer.MIN_VALUE : Integer.MAX_VALUE, true);
    }

    public final void prependVisibleItems(int i10) {
        prependVisibleItems(i10, false);
    }

    public abstract boolean prependVisibleItems(int i10, boolean z9);

    public void removeInvisibleItemsAtEnd(int i10, int i11) {
        while (true) {
            int i12 = this.mLastVisibleIndex;
            if (i12 >= this.mFirstVisibleIndex && i12 > i10) {
                boolean z9 = this.mReversedFlow;
                Provider provider = this.mProvider;
                if (!z9) {
                    if (provider.getEdge(i12) < i11) {
                        break;
                    }
                    this.mProvider.removeItem(this.mLastVisibleIndex);
                    this.mLastVisibleIndex--;
                } else {
                    if (provider.getEdge(i12) > i11) {
                        break;
                    }
                    this.mProvider.removeItem(this.mLastVisibleIndex);
                    this.mLastVisibleIndex--;
                }
            } else {
                break;
            }
        }
        resetVisibleIndexIfEmpty();
    }

    public void removeInvisibleItemsAtFront(int i10, int i11) {
        while (true) {
            int i12 = this.mLastVisibleIndex;
            int i13 = this.mFirstVisibleIndex;
            if (i12 >= i13 && i13 < i10) {
                int size = this.mProvider.getSize(i13);
                boolean z9 = this.mReversedFlow;
                Provider provider = this.mProvider;
                if (!z9) {
                    if (provider.getEdge(this.mFirstVisibleIndex) + size > i11) {
                        break;
                    }
                    this.mProvider.removeItem(this.mFirstVisibleIndex);
                    this.mFirstVisibleIndex++;
                } else {
                    if (provider.getEdge(this.mFirstVisibleIndex) - size < i11) {
                        break;
                    }
                    this.mProvider.removeItem(this.mFirstVisibleIndex);
                    this.mFirstVisibleIndex++;
                }
            } else {
                break;
            }
        }
        resetVisibleIndexIfEmpty();
    }

    public void resetVisibleIndex() {
        this.mLastVisibleIndex = -1;
        this.mFirstVisibleIndex = -1;
    }

    public void setNumRows(int i10) {
        if (i10 <= 0) {
            f.a();
            return;
        }
        if (this.mNumRows == i10) {
            return;
        }
        this.mNumRows = i10;
        this.mTmpItemPositionsInRows = new CircularIntArray[i10];
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            this.mTmpItemPositionsInRows[i11] = new CircularIntArray();
        }
    }

    public void setProvider(Provider provider) {
        this.mProvider = provider;
    }

    public final void setReversedFlow(boolean z9) {
        this.mReversedFlow = z9;
    }

    public final void setSpacing(int i10) {
        this.mSpacing = i10;
    }

    public void setStart(int i10) {
        this.mStartIndex = i10;
    }

    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }
}
