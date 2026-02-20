package androidx.leanback.widget;

import androidx.collection.CircularIntArray;
import androidx.leanback.widget.Grid;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class SingleRow extends Grid {
    private final Grid.Location mTmpLocation = new Grid.Location(0);

    public SingleRow() {
        setNumRows(1);
    }

    @Override // androidx.leanback.widget.Grid
    public final boolean appendVisibleItems(int i10, boolean z9) {
        int edge;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z9 && checkAppendOverLimit(i10)) {
            return false;
        }
        int startIndexForAppend = getStartIndexForAppend();
        boolean z10 = false;
        while (startIndexForAppend < this.mProvider.getCount()) {
            int iCreateItem = this.mProvider.createItem(startIndexForAppend, true, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                edge = this.mReversedFlow ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                this.mFirstVisibleIndex = startIndexForAppend;
                this.mLastVisibleIndex = startIndexForAppend;
            } else {
                boolean z11 = this.mReversedFlow;
                Grid.Provider provider = this.mProvider;
                if (z11) {
                    int i11 = startIndexForAppend - 1;
                    edge = (provider.getEdge(i11) - this.mProvider.getSize(i11)) - this.mSpacing;
                } else {
                    int i12 = startIndexForAppend - 1;
                    edge = provider.getEdge(i12) + this.mProvider.getSize(i12) + this.mSpacing;
                }
                this.mLastVisibleIndex = startIndexForAppend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForAppend, iCreateItem, 0, edge);
            if (z9 || checkAppendOverLimit(i10)) {
                return true;
            }
            startIndexForAppend++;
            z10 = true;
        }
        return z10;
    }

    @Override // androidx.leanback.widget.Grid
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int startIndexForPrepend;
        int i12;
        if (!this.mReversedFlow ? i11 < 0 : i11 > 0) {
            if (getLastVisibleIndex() == this.mProvider.getCount() - 1) {
                return;
            }
            startIndexForPrepend = getStartIndexForAppend();
            int size = this.mProvider.getSize(this.mLastVisibleIndex) + this.mSpacing;
            int edge = this.mProvider.getEdge(this.mLastVisibleIndex);
            if (this.mReversedFlow) {
                size = -size;
            }
            i12 = size + edge;
        } else {
            if (getFirstVisibleIndex() == 0) {
                return;
            }
            startIndexForPrepend = getStartIndexForPrepend();
            int edge2 = this.mProvider.getEdge(this.mFirstVisibleIndex);
            boolean z9 = this.mReversedFlow;
            int i13 = this.mSpacing;
            if (!z9) {
                i13 = -i13;
            }
            i12 = edge2 + i13;
        }
        layoutPrefetchRegistry.addPosition(startIndexForPrepend, Math.abs(i12 - i10));
    }

    @Override // androidx.leanback.widget.Grid
    public final void debugPrint(PrintWriter printWriter) {
        printWriter.print("SingleRow<");
        printWriter.print(this.mFirstVisibleIndex);
        printWriter.print(",");
        printWriter.print(this.mLastVisibleIndex);
        printWriter.print(">");
        printWriter.println();
    }

    @Override // androidx.leanback.widget.Grid
    public final int findRowMax(boolean z9, int i10, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i10;
        }
        boolean z10 = this.mReversedFlow;
        Grid.Provider provider = this.mProvider;
        return z10 ? provider.getEdge(i10) : provider.getEdge(i10) + this.mProvider.getSize(i10);
    }

    @Override // androidx.leanback.widget.Grid
    public final int findRowMin(boolean z9, int i10, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i10;
        }
        boolean z10 = this.mReversedFlow;
        Grid.Provider provider = this.mProvider;
        return z10 ? provider.getEdge(i10) - this.mProvider.getSize(i10) : provider.getEdge(i10);
    }

    @Override // androidx.leanback.widget.Grid
    public final CircularIntArray[] getItemPositionsInRows(int i10, int i11) {
        this.mTmpItemPositionsInRows[0].clear();
        this.mTmpItemPositionsInRows[0].addLast(i10);
        this.mTmpItemPositionsInRows[0].addLast(i11);
        return this.mTmpItemPositionsInRows;
    }

    @Override // androidx.leanback.widget.Grid
    public final Grid.Location getLocation(int i10) {
        return this.mTmpLocation;
    }

    public int getStartIndexForAppend() {
        int i10 = this.mLastVisibleIndex;
        if (i10 >= 0) {
            return i10 + 1;
        }
        int i11 = this.mStartIndex;
        if (i11 != -1) {
            return Math.min(i11, this.mProvider.getCount() - 1);
        }
        return 0;
    }

    public int getStartIndexForPrepend() {
        int i10 = this.mFirstVisibleIndex;
        if (i10 >= 0) {
            return i10 - 1;
        }
        int i11 = this.mStartIndex;
        Grid.Provider provider = this.mProvider;
        return i11 != -1 ? Math.min(i11, provider.getCount() - 1) : provider.getCount() - 1;
    }

    @Override // androidx.leanback.widget.Grid
    public final boolean prependVisibleItems(int i10, boolean z9) {
        int edge;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z9 && checkPrependOverLimit(i10)) {
            return false;
        }
        int minIndex = this.mProvider.getMinIndex();
        boolean z10 = false;
        for (int startIndexForPrepend = getStartIndexForPrepend(); startIndexForPrepend >= minIndex; startIndexForPrepend--) {
            int iCreateItem = this.mProvider.createItem(startIndexForPrepend, false, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                edge = this.mReversedFlow ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                this.mFirstVisibleIndex = startIndexForPrepend;
                this.mLastVisibleIndex = startIndexForPrepend;
            } else {
                boolean z11 = this.mReversedFlow;
                Grid.Provider provider = this.mProvider;
                edge = z11 ? provider.getEdge(startIndexForPrepend + 1) + this.mSpacing + iCreateItem : (provider.getEdge(startIndexForPrepend + 1) - this.mSpacing) - iCreateItem;
                this.mFirstVisibleIndex = startIndexForPrepend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForPrepend, iCreateItem, 0, edge);
            z10 = true;
            if (z9 || checkPrependOverLimit(i10)) {
                break;
            }
        }
        return z10;
    }
}
