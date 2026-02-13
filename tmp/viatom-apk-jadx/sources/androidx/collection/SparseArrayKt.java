package androidx.collection;

import g7.p;
import h7.a;
import java.util.Iterator;
import t6.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00741<T> implements Iterator<T>, a {
        final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
        private int index;

        public C00741(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArrayCompat<T> sparseArrayCompat = this.$this_valueIterator;
            int i10 = this.index;
            this.index = i10 + 1;
            return sparseArrayCompat.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i10) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.containsKey(i10);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, p pVar) {
        sparseArrayCompat.getClass();
        pVar.getClass();
        int size = sparseArrayCompat.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i10)), sparseArrayCompat.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i10, T t) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.get(i10, t);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i10, g7.a aVar) {
        sparseArrayCompat.getClass();
        aVar.getClass();
        T t = sparseArrayCompat.get(i10);
        return t == null ? (T) aVar.invoke() : t;
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> x keyIterator(final SparseArrayCompat<T> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return new x() { // from class: androidx.collection.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            @Override // t6.x
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseArrayCompat2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        sparseArrayCompat.getClass();
        sparseArrayCompat2.getClass();
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat2.size() + sparseArrayCompat.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    public static final /* synthetic */ boolean remove(SparseArrayCompat sparseArrayCompat, int i10, Object obj) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.remove(i10, obj);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i10, T t) {
        sparseArrayCompat.getClass();
        sparseArrayCompat.put(i10, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return new C00741(sparseArrayCompat);
    }
}
