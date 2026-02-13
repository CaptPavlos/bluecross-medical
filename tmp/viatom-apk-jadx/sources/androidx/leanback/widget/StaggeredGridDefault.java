package androidx.leanback.widget;

import androidx.leanback.widget.Grid;
import androidx.leanback.widget.StaggeredGrid;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class StaggeredGridDefault extends StaggeredGrid {
    private int findRowEdgeLimitSearchIndex(boolean z9) {
        boolean z10 = false;
        if (z9) {
            for (int i10 = this.mLastVisibleIndex; i10 >= this.mFirstVisibleIndex; i10--) {
                int i11 = getLocation(i10).mRow;
                if (i11 == 0) {
                    z10 = true;
                } else if (z10 && i11 == this.mNumRows - 1) {
                    return i10;
                }
            }
            return -1;
        }
        for (int i12 = this.mFirstVisibleIndex; i12 <= this.mLastVisibleIndex; i12++) {
            int i13 = getLocation(i12).mRow;
            if (i13 == this.mNumRows - 1) {
                z10 = true;
            } else if (z10 && i13 == 0) {
                return i12;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x012a, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c5 A[PHI: r9 r11
      0x00c5: PHI (r9v19 int) = (r9v11 int), (r9v4 int) binds: [B:78:0x00e3, B:66:0x00c3] A[DONT_GENERATE, DONT_INLINE]
      0x00c5: PHI (r11v9 int) = (r11v2 int), (r11v11 int) binds: [B:78:0x00e3, B:66:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fd A[LOOP:2: B:85:0x00fd->B:101:0x011f, LOOP_START, PHI: r6 r9 r10
      0x00fd: PHI (r6v12 int) = (r6v6 int), (r6v16 int) binds: [B:84:0x00fb, B:101:0x011f] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r9v15 int) = (r9v13 int), (r9v16 int) binds: [B:84:0x00fb, B:101:0x011f] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r10v5 int) = (r10v3 int), (r10v7 int) binds: [B:84:0x00fb, B:101:0x011f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.leanback.widget.StaggeredGrid
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean appendVisibleItemsWithoutCache(int r15, boolean r16) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGridDefault.appendVisibleItemsWithoutCache(int, boolean):boolean");
    }

    @Override // androidx.leanback.widget.Grid
    public int findRowMax(boolean z9, int i10, int[] iArr) {
        int i11;
        int edge = this.mProvider.getEdge(i10);
        StaggeredGrid.Location location = getLocation(i10);
        int i12 = location.mRow;
        if (this.mReversedFlow) {
            i11 = i12;
            int i13 = i11;
            int i14 = 1;
            int i15 = edge;
            for (int i16 = i10 + 1; i14 < this.mNumRows && i16 <= this.mLastVisibleIndex; i16++) {
                StaggeredGrid.Location location2 = getLocation(i16);
                i15 += location2.mOffset;
                int i17 = location2.mRow;
                if (i17 != i13) {
                    i14++;
                    if (!z9 ? i15 >= edge : i15 <= edge) {
                        i13 = i17;
                    } else {
                        edge = i15;
                        i10 = i16;
                        i11 = i17;
                        i13 = i11;
                    }
                }
            }
        } else {
            int i18 = 1;
            int i19 = i12;
            StaggeredGrid.Location location3 = location;
            int i20 = edge;
            edge = this.mProvider.getSize(i10) + edge;
            i11 = i19;
            for (int i21 = i10 - 1; i18 < this.mNumRows && i21 >= this.mFirstVisibleIndex; i21--) {
                i20 -= location3.mOffset;
                location3 = getLocation(i21);
                int i22 = location3.mRow;
                if (i22 != i19) {
                    i18++;
                    int size = this.mProvider.getSize(i21) + i20;
                    if (!z9 ? size >= edge : size <= edge) {
                        i19 = i22;
                    } else {
                        edge = size;
                        i10 = i21;
                        i11 = i22;
                        i19 = i11;
                    }
                }
            }
        }
        if (iArr != null) {
            iArr[0] = i11;
            iArr[1] = i10;
        }
        return edge;
    }

    @Override // androidx.leanback.widget.Grid
    public int findRowMin(boolean z9, int i10, int[] iArr) {
        int size;
        int edge = this.mProvider.getEdge(i10);
        StaggeredGrid.Location location = getLocation(i10);
        int i11 = location.mRow;
        if (this.mReversedFlow) {
            int i12 = 1;
            size = edge - this.mProvider.getSize(i10);
            int i13 = i11;
            for (int i14 = i10 - 1; i12 < this.mNumRows && i14 >= this.mFirstVisibleIndex; i14--) {
                edge -= location.mOffset;
                location = getLocation(i14);
                int i15 = location.mRow;
                if (i15 != i13) {
                    i12++;
                    int size2 = edge - this.mProvider.getSize(i14);
                    if (!z9 ? size2 >= size : size2 <= size) {
                        i13 = i15;
                    } else {
                        size = size2;
                        i10 = i14;
                        i11 = i15;
                        i13 = i11;
                    }
                }
            }
        } else {
            int i16 = i11;
            int i17 = i16;
            int i18 = 1;
            int i19 = edge;
            for (int i20 = i10 + 1; i18 < this.mNumRows && i20 <= this.mLastVisibleIndex; i20++) {
                StaggeredGrid.Location location2 = getLocation(i20);
                i19 += location2.mOffset;
                int i21 = location2.mRow;
                if (i21 != i17) {
                    i18++;
                    if (!z9 ? i19 >= edge : i19 <= edge) {
                        i17 = i21;
                    } else {
                        edge = i19;
                        i10 = i20;
                        i16 = i21;
                        i17 = i16;
                    }
                }
            }
            size = edge;
            i11 = i16;
        }
        if (iArr != null) {
            iArr[0] = i11;
            iArr[1] = i10;
        }
        return size;
    }

    public int getRowMax(int i10) {
        int i11;
        StaggeredGrid.Location location;
        int i12 = this.mFirstVisibleIndex;
        if (i12 < 0) {
            return Integer.MIN_VALUE;
        }
        boolean z9 = this.mReversedFlow;
        Grid.Provider provider = this.mProvider;
        if (z9) {
            int edge = provider.getEdge(i12);
            if (getLocation(this.mFirstVisibleIndex).mRow == i10) {
                return edge;
            }
            int i13 = this.mFirstVisibleIndex;
            do {
                i13++;
                if (i13 <= getLastIndex()) {
                    location = getLocation(i13);
                    edge += location.mOffset;
                }
            } while (location.mRow != i10);
            return edge;
        }
        int edge2 = provider.getEdge(this.mLastVisibleIndex);
        StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
        if (location2.mRow == i10) {
            i11 = location2.mSize;
        } else {
            int i14 = this.mLastVisibleIndex;
            do {
                i14--;
                if (i14 >= getFirstIndex()) {
                    edge2 -= location2.mOffset;
                    location2 = getLocation(i14);
                }
            } while (location2.mRow != i10);
            i11 = location2.mSize;
        }
        return edge2 + i11;
        return Integer.MIN_VALUE;
    }

    public int getRowMin(int i10) {
        StaggeredGrid.Location location;
        int i11;
        int i12 = this.mFirstVisibleIndex;
        if (i12 < 0) {
            return Integer.MAX_VALUE;
        }
        boolean z9 = this.mReversedFlow;
        Grid.Provider provider = this.mProvider;
        if (!z9) {
            int edge = provider.getEdge(i12);
            if (getLocation(this.mFirstVisibleIndex).mRow == i10) {
                return edge;
            }
            int i13 = this.mFirstVisibleIndex;
            do {
                i13++;
                if (i13 <= getLastIndex()) {
                    location = getLocation(i13);
                    edge += location.mOffset;
                }
            } while (location.mRow != i10);
            return edge;
        }
        int edge2 = provider.getEdge(this.mLastVisibleIndex);
        StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
        if (location2.mRow == i10) {
            i11 = location2.mSize;
        } else {
            int i14 = this.mLastVisibleIndex;
            do {
                i14--;
                if (i14 >= getFirstIndex()) {
                    edge2 -= location2.mOffset;
                    location2 = getLocation(i14);
                }
            } while (location2.mRow != i10);
            i11 = location2.mSize;
        }
        return edge2 - i11;
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0125, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3 A[PHI: r8 r10
      0x00c3: PHI (r8v19 int) = (r8v11 int), (r8v4 int) binds: [B:75:0x00e0, B:63:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r10v8 int) = (r10v1 int), (r10v10 int) binds: [B:75:0x00e0, B:63:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f8 A[LOOP:2: B:83:0x00f8->B:99:0x011a, LOOP_START, PHI: r5 r8 r9
      0x00f8: PHI (r5v12 int) = (r5v6 int), (r5v17 int) binds: [B:82:0x00f6, B:99:0x011a] A[DONT_GENERATE, DONT_INLINE]
      0x00f8: PHI (r8v15 int) = (r8v13 int), (r8v16 int) binds: [B:82:0x00f6, B:99:0x011a] A[DONT_GENERATE, DONT_INLINE]
      0x00f8: PHI (r9v4 int) = (r9v2 int), (r9v6 int) binds: [B:82:0x00f6, B:99:0x011a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.leanback.widget.StaggeredGrid
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean prependVisibleItemsWithoutCache(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGridDefault.prependVisibleItemsWithoutCache(int, boolean):boolean");
    }
}
