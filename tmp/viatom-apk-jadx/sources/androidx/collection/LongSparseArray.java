package androidx.collection;

import a3.a;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import t6.j;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray(int i10) {
        if (i10 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i10);
            this.keys = new long[iIdealLongArraySize];
            this.values = new Object[iIdealLongArraySize];
        }
    }

    public void append(long j10, E e) {
        int i10 = this.size;
        if (i10 != 0 && j10 <= this.keys[i10 - 1]) {
            put(j10, e);
            return;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            if (i10 >= jArr.length) {
                Object[] objArr = this.values;
                int i11 = 0;
                for (int i12 = 0; i12 < i10; i12++) {
                    Object obj = objArr[i12];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i12 != i11) {
                            jArr[i11] = jArr[i12];
                            objArr[i11] = obj;
                            objArr[i12] = null;
                        }
                        i11++;
                    }
                }
                this.garbage = false;
                this.size = i11;
            }
        }
        int i13 = this.size;
        if (i13 >= this.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i13 + 1);
            this.keys = Arrays.copyOf(this.keys, iIdealLongArraySize);
            this.values = Arrays.copyOf(this.values, iIdealLongArraySize);
        }
        this.keys[i13] = j10;
        this.values[i13] = e;
        this.size = i13 + 1;
    }

    public void clear() {
        int i10 = this.size;
        Object[] objArr = this.values;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m30clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        LongSparseArray<E> longSparseArray = (LongSparseArray) objClone;
        longSparseArray.keys = (long[]) this.keys.clone();
        longSparseArray.values = (Object[]) this.values.clone();
        return longSparseArray;
    }

    public boolean containsKey(long j10) {
        return indexOfKey(j10) >= 0;
    }

    public boolean containsValue(E e) {
        return indexOfValue(e) >= 0;
    }

    public void delete(long j10) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j10);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[iBinarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public E get(long j10) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j10);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return null;
        }
        return (E) this.values[iBinarySearch];
    }

    public int indexOfKey(long j10) {
        if (this.garbage) {
            int i10 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.garbage = false;
            this.size = i11;
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, j10);
    }

    public int indexOfValue(E e) {
        if (this.garbage) {
            int i10 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.garbage = false;
            this.size = i11;
        }
        int i13 = this.size;
        for (int i14 = 0; i14 < i13; i14++) {
            if (this.values[i14] == e) {
                return i14;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.size)) {
            f.b(a.f(i10, "Expected index to be within 0..size()-1, but was "));
            return 0L;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.garbage = false;
            this.size = i12;
        }
        return this.keys[i10];
    }

    public void put(long j10, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j10);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = e;
            return;
        }
        int i10 = ~iBinarySearch;
        if (i10 < this.size && this.values[i10] == LongSparseArrayKt.DELETED) {
            this.keys[i10] = j10;
            this.values[i10] = e;
            return;
        }
        if (this.garbage) {
            int i11 = this.size;
            long[] jArr = this.keys;
            if (i11 >= jArr.length) {
                Object[] objArr = this.values;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj = objArr[i13];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr[i12] = obj;
                            objArr[i13] = null;
                        }
                        i12++;
                    }
                }
                this.garbage = false;
                this.size = i12;
                i10 = ~ContainerHelpersKt.binarySearch(this.keys, i12, j10);
            }
        }
        int i14 = this.size;
        if (i14 >= this.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i14 + 1);
            this.keys = Arrays.copyOf(this.keys, iIdealLongArraySize);
            this.values = Arrays.copyOf(this.values, iIdealLongArraySize);
        }
        int i15 = this.size;
        if (i15 - i10 != 0) {
            long[] jArr2 = this.keys;
            int i16 = i10 + 1;
            j.m0(jArr2, jArr2, i16, i10, i15);
            Object[] objArr2 = this.values;
            j.i0(i16, i10, this.size, objArr2, objArr2);
        }
        this.keys[i10] = j10;
        this.values[i10] = e;
        this.size++;
    }

    public void putAll(LongSparseArray<? extends E> longSparseArray) {
        longSparseArray.getClass();
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            put(longSparseArray.keyAt(i10), longSparseArray.valueAt(i10));
        }
    }

    public E putIfAbsent(long j10, E e) {
        E e3 = get(j10);
        if (e3 == null) {
            put(j10, e);
        }
        return e3;
    }

    public void remove(long j10) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j10);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[iBinarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public void removeAt(int i10) {
        if (this.values[i10] != LongSparseArrayKt.DELETED) {
            this.values[i10] = LongSparseArrayKt.DELETED;
            this.garbage = true;
        }
    }

    public boolean replace(long j10, E e, E e3) {
        int iIndexOfKey = indexOfKey(j10);
        if (iIndexOfKey < 0 || !l.a(this.values[iIndexOfKey], e)) {
            return false;
        }
        this.values[iIndexOfKey] = e3;
        return true;
    }

    public void setValueAt(int i10, E e) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.size)) {
            f.b(a.f(i10, "Expected index to be within 0..size()-1, but was "));
            return;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.garbage = false;
            this.size = i12;
        }
        this.values[i10] = e;
    }

    public int size() {
        if (this.garbage) {
            int i10 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.garbage = false;
            this.size = i11;
        }
        return this.size;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i11));
            sb.append('=');
            E eValueAt = valueAt(i11);
            if (eValueAt != sb) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.size)) {
            f.b(a.f(i10, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.garbage = false;
            this.size = i12;
        }
        return (E) this.values[i10];
    }

    public E replace(long j10, E e) {
        int iIndexOfKey = indexOfKey(j10);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e3 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e3;
    }

    public LongSparseArray() {
        this(0, 1, null);
    }

    public /* synthetic */ LongSparseArray(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }

    public E get(long j10, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j10);
        return (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) ? e : (E) this.values[iBinarySearch];
    }

    public boolean remove(long j10, E e) {
        int iIndexOfKey = indexOfKey(j10);
        if (iIndexOfKey < 0 || !l.a(e, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }
}
