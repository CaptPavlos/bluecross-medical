package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import g7.p;
import h7.a;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import t6.j;
import t6.y;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    private static final Object DELETED = new Object();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00731<T> implements Iterator<T>, a {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C00731(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
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
            LongSparseArray<T> longSparseArray = this.$this_valueIterator;
            int i10 = this.index;
            this.index = i10 + 1;
            return longSparseArray.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    public static final <E> void commonAppend(LongSparseArray<E> longSparseArray, long j10, E e) {
        longSparseArray.getClass();
        int i10 = longSparseArray.size;
        if (i10 != 0 && j10 <= longSparseArray.keys[i10 - 1]) {
            longSparseArray.put(j10, e);
            return;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            if (i10 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i11 = 0;
                for (int i12 = 0; i12 < i10; i12++) {
                    Object obj = objArr[i12];
                    if (obj != DELETED) {
                        if (i12 != i11) {
                            jArr[i11] = jArr[i12];
                            objArr[i11] = obj;
                            objArr[i12] = null;
                        }
                        i11++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i11;
            }
        }
        int i13 = longSparseArray.size;
        if (i13 >= longSparseArray.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i13 + 1);
            longSparseArray.keys = Arrays.copyOf(longSparseArray.keys, iIdealLongArraySize);
            longSparseArray.values = Arrays.copyOf(longSparseArray.values, iIdealLongArraySize);
        }
        longSparseArray.keys[i13] = j10;
        longSparseArray.values[i13] = e;
        longSparseArray.size = i13 + 1;
    }

    public static final <E> void commonClear(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        int i10 = longSparseArray.size;
        Object[] objArr = longSparseArray.values;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        longSparseArray.size = 0;
        longSparseArray.garbage = false;
    }

    public static final <E> boolean commonContainsKey(LongSparseArray<E> longSparseArray, long j10) {
        longSparseArray.getClass();
        return longSparseArray.indexOfKey(j10) >= 0;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> longSparseArray, E e) {
        longSparseArray.getClass();
        return longSparseArray.indexOfValue(e) >= 0;
    }

    public static final <E> void commonGc(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        int i10 = longSparseArray.size;
        long[] jArr = longSparseArray.keys;
        Object[] objArr = longSparseArray.values;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != DELETED) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        longSparseArray.garbage = false;
        longSparseArray.size = i11;
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j10) {
        longSparseArray.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j10);
        if (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) {
            return null;
        }
        return (E) longSparseArray.values[iBinarySearch];
    }

    public static final <T extends E, E> T commonGetInternal(LongSparseArray<E> longSparseArray, long j10, T t) {
        longSparseArray.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j10);
        return (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) ? t : (T) longSparseArray.values[iBinarySearch];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> longSparseArray, long j10) {
        longSparseArray.getClass();
        if (longSparseArray.garbage) {
            int i10 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != DELETED) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i11;
        }
        return ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j10);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> longSparseArray, E e) {
        longSparseArray.getClass();
        if (longSparseArray.garbage) {
            int i10 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != DELETED) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i11;
        }
        int i13 = longSparseArray.size;
        for (int i14 = 0; i14 < i13; i14++) {
            if (longSparseArray.values[i14] == e) {
                return i14;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        return longSparseArray.size() == 0;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> longSparseArray, int i10) {
        int i11;
        longSparseArray.getClass();
        if (i10 < 0 || i10 >= (i11 = longSparseArray.size)) {
            f.b(a3.a.f(i10, "Expected index to be within 0..size()-1, but was "));
            return 0L;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != DELETED) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i12;
        }
        return longSparseArray.keys[i10];
    }

    public static final <E> void commonPut(LongSparseArray<E> longSparseArray, long j10, E e) {
        longSparseArray.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j10);
        if (iBinarySearch >= 0) {
            longSparseArray.values[iBinarySearch] = e;
            return;
        }
        int i10 = ~iBinarySearch;
        if (i10 < longSparseArray.size && longSparseArray.values[i10] == DELETED) {
            longSparseArray.keys[i10] = j10;
            longSparseArray.values[i10] = e;
            return;
        }
        if (longSparseArray.garbage) {
            int i11 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            if (i11 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj = objArr[i13];
                    if (obj != DELETED) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr[i12] = obj;
                            objArr[i13] = null;
                        }
                        i12++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i12;
                i10 = ~ContainerHelpersKt.binarySearch(longSparseArray.keys, i12, j10);
            }
        }
        int i14 = longSparseArray.size;
        if (i14 >= longSparseArray.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i14 + 1);
            longSparseArray.keys = Arrays.copyOf(longSparseArray.keys, iIdealLongArraySize);
            longSparseArray.values = Arrays.copyOf(longSparseArray.values, iIdealLongArraySize);
        }
        int i15 = longSparseArray.size;
        if (i15 - i10 != 0) {
            long[] jArr2 = longSparseArray.keys;
            int i16 = i10 + 1;
            j.m0(jArr2, jArr2, i16, i10, i15);
            Object[] objArr2 = longSparseArray.values;
            j.i0(i16, i10, longSparseArray.size, objArr2, objArr2);
        }
        longSparseArray.keys[i10] = j10;
        longSparseArray.values[i10] = e;
        longSparseArray.size++;
    }

    public static final <E> void commonPutAll(LongSparseArray<E> longSparseArray, LongSparseArray<? extends E> longSparseArray2) {
        longSparseArray.getClass();
        longSparseArray2.getClass();
        int size = longSparseArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            longSparseArray.put(longSparseArray2.keyAt(i10), longSparseArray2.valueAt(i10));
        }
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> longSparseArray, long j10, E e) {
        longSparseArray.getClass();
        E e3 = longSparseArray.get(j10);
        if (e3 == null) {
            longSparseArray.put(j10, e);
        }
        return e3;
    }

    public static final <E> void commonRemove(LongSparseArray<E> longSparseArray, long j10) {
        longSparseArray.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j10);
        if (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) {
            return;
        }
        longSparseArray.values[iBinarySearch] = DELETED;
        longSparseArray.garbage = true;
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> longSparseArray, int i10) {
        longSparseArray.getClass();
        if (longSparseArray.values[i10] != DELETED) {
            longSparseArray.values[i10] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> longSparseArray, long j10, E e, E e3) {
        longSparseArray.getClass();
        int iIndexOfKey = longSparseArray.indexOfKey(j10);
        if (iIndexOfKey < 0 || !l.a(longSparseArray.values[iIndexOfKey], e)) {
            return false;
        }
        longSparseArray.values[iIndexOfKey] = e3;
        return true;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> longSparseArray, int i10, E e) {
        int i11;
        longSparseArray.getClass();
        if (i10 < 0 || i10 >= (i11 = longSparseArray.size)) {
            f.b(a3.a.f(i10, "Expected index to be within 0..size()-1, but was "));
            return;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != DELETED) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i12;
        }
        longSparseArray.values[i10] = e;
    }

    public static final <E> int commonSize(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        if (longSparseArray.garbage) {
            int i10 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != DELETED) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i11;
        }
        return longSparseArray.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        if (longSparseArray.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(longSparseArray.size * 28);
        sb.append('{');
        int i10 = longSparseArray.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            sb.append(longSparseArray.keyAt(i11));
            sb.append('=');
            E eValueAt = longSparseArray.valueAt(i11);
            if (eValueAt != sb) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static final <E> E commonValueAt(LongSparseArray<E> longSparseArray, int i10) {
        int i11;
        longSparseArray.getClass();
        if (i10 < 0 || i10 >= (i11 = longSparseArray.size)) {
            f.b(a3.a.f(i10, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != DELETED) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i12;
        }
        return (E) longSparseArray.values[i10];
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j10) {
        longSparseArray.getClass();
        return longSparseArray.containsKey(j10);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p pVar) {
        longSparseArray.getClass();
        pVar.getClass();
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i10)), longSparseArray.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j10, T t) {
        longSparseArray.getClass();
        return longSparseArray.get(j10, t);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j10, g7.a aVar) {
        longSparseArray.getClass();
        aVar.getClass();
        T t = longSparseArray.get(j10);
        return t == null ? (T) aVar.invoke() : t;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        longSparseArray.getClass();
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        longSparseArray.getClass();
        return !longSparseArray.isEmpty();
    }

    public static final <T> y keyIterator(final LongSparseArray<T> longSparseArray) {
        longSparseArray.getClass();
        return new y() { // from class: androidx.collection.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // t6.y
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return longSparseArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        longSparseArray.getClass();
        longSparseArray2.getClass();
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        longSparseArray3.putAll(longSparseArray);
        longSparseArray3.putAll(longSparseArray2);
        return longSparseArray3;
    }

    public static final /* synthetic */ boolean remove(LongSparseArray longSparseArray, long j10, Object obj) {
        longSparseArray.getClass();
        return longSparseArray.remove(j10, obj);
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j10, T t) {
        longSparseArray.getClass();
        longSparseArray.put(j10, t);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        longSparseArray.getClass();
        return new C00731(longSparseArray);
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray longSparseArray) {
    }

    public static final <E> E commonReplace(LongSparseArray<E> longSparseArray, long j10, E e) {
        longSparseArray.getClass();
        int iIndexOfKey = longSparseArray.indexOfKey(j10);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = longSparseArray.values;
        E e3 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e3;
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j10, E e) {
        longSparseArray.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j10);
        return (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) ? e : (E) longSparseArray.values[iBinarySearch];
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> longSparseArray, long j10, E e) {
        longSparseArray.getClass();
        int iIndexOfKey = longSparseArray.indexOfKey(j10);
        if (iIndexOfKey < 0 || !l.a(e, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }
}
