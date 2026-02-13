package androidx.core.util;

import android.util.SparseIntArray;
import g7.p;
import t6.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i10) {
        return sparseIntArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i10) {
        return sparseIntArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i10) {
        return sparseIntArray.indexOfValue(i10) >= 0;
    }

    public static final void forEach(SparseIntArray sparseIntArray, p pVar) {
        int size = sparseIntArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.invoke(Integer.valueOf(sparseIntArray.keyAt(i10)), Integer.valueOf(sparseIntArray.valueAt(i10)));
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i10, int i11) {
        return sparseIntArray.get(i10, i11);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i10, g7.a aVar) {
        int iIndexOfKey = sparseIntArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : ((Number) aVar.invoke()).intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        return sparseIntArray.size() != 0;
    }

    public static final x keyIterator(final SparseIntArray sparseIntArray) {
        return new x() { // from class: androidx.core.util.SparseIntArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // t6.x
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseIntArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray2.size() + sparseIntArray.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i10), sparseIntArray2.valueAt(i10));
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i10, int i11) {
        int iIndexOfKey = sparseIntArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || i11 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i10, int i11) {
        sparseIntArray.put(i10, i11);
    }

    public static final x valueIterator(final SparseIntArray sparseIntArray) {
        return new x() { // from class: androidx.core.util.SparseIntArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // t6.x
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseIntArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
