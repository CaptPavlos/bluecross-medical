package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat(int i10) {
        if (i10 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10);
            this.keys = new int[iIdealIntArraySize];
            this.values = new Object[iIdealIntArraySize];
        }
    }

    public void append(int i10, E e) {
        int i11 = this.size;
        if (i11 != 0 && i10 <= this.keys[i11 - 1]) {
            put(i10, e);
            return;
        }
        if (this.garbage && i11 >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
        }
        int i12 = this.size;
        if (i12 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i12 + 1);
            this.keys = Arrays.copyOf(this.keys, iIdealIntArraySize);
            this.values = Arrays.copyOf(this.values, iIdealIntArraySize);
        }
        this.keys[i12] = i10;
        this.values[i12] = e;
        this.size = i12 + 1;
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
    public SparseArrayCompat<E> m31clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) objClone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public boolean containsKey(int i10) {
        return indexOfKey(i10) >= 0;
    }

    public boolean containsValue(E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i10 = this.size;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                i11 = -1;
                break;
            }
            if (this.values[i11] == e) {
                break;
            }
            i11++;
        }
        return i11 >= 0;
    }

    public void delete(int i10) {
        remove(i10);
    }

    public E get(int i10) {
        return (E) SparseArrayCompatKt.commonGet(this, i10);
    }

    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public int indexOfKey(int i10) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, i10);
    }

    public int indexOfValue(E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.values[i11] == e) {
                return i11;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int i10) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[i10];
    }

    public void put(int i10, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i10);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = e;
            return;
        }
        int i11 = ~iBinarySearch;
        if (i11 < this.size && this.values[i11] == SparseArrayCompatKt.DELETED) {
            this.keys[i11] = i10;
            this.values[i11] = e;
            return;
        }
        if (this.garbage && this.size >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
            i11 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i10);
        }
        int i12 = this.size;
        if (i12 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i12 + 1);
            this.keys = Arrays.copyOf(this.keys, iIdealIntArraySize);
            this.values = Arrays.copyOf(this.values, iIdealIntArraySize);
        }
        int i13 = this.size;
        if (i13 - i11 != 0) {
            int[] iArr = this.keys;
            int i14 = i11 + 1;
            j.j0(i14, i11, iArr, iArr, i13);
            Object[] objArr = this.values;
            j.i0(i14, i11, this.size, objArr, objArr);
        }
        this.keys[i11] = i10;
        this.values[i11] = e;
        this.size++;
    }

    public void putAll(SparseArrayCompat<? extends E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        int size = sparseArrayCompat.size();
        for (int i10 = 0; i10 < size; i10++) {
            int iKeyAt = sparseArrayCompat.keyAt(i10);
            E eValueAt = sparseArrayCompat.valueAt(i10);
            int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, iKeyAt);
            if (iBinarySearch >= 0) {
                this.values[iBinarySearch] = eValueAt;
            } else {
                int i11 = ~iBinarySearch;
                if (i11 >= this.size || this.values[i11] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.gc(this);
                        i11 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, iKeyAt);
                    }
                    int i12 = this.size;
                    if (i12 >= this.keys.length) {
                        int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i12 + 1);
                        this.keys = Arrays.copyOf(this.keys, iIdealIntArraySize);
                        this.values = Arrays.copyOf(this.values, iIdealIntArraySize);
                    }
                    int i13 = this.size;
                    if (i13 - i11 != 0) {
                        int[] iArr = this.keys;
                        int i14 = i11 + 1;
                        j.j0(i14, i11, iArr, iArr, i13);
                        Object[] objArr = this.values;
                        j.i0(i14, i11, this.size, objArr, objArr);
                    }
                    this.keys[i11] = iKeyAt;
                    this.values[i11] = eValueAt;
                    this.size++;
                } else {
                    this.keys[i11] = iKeyAt;
                    this.values[i11] = eValueAt;
                }
            }
        }
    }

    public E putIfAbsent(int i10, E e) {
        E e3 = (E) SparseArrayCompatKt.commonGet(this, i10);
        if (e3 == null) {
            int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i10);
            if (iBinarySearch >= 0) {
                this.values[iBinarySearch] = e;
                return e3;
            }
            int i11 = ~iBinarySearch;
            if (i11 < this.size && this.values[i11] == SparseArrayCompatKt.DELETED) {
                this.keys[i11] = i10;
                this.values[i11] = e;
                return e3;
            }
            if (this.garbage && this.size >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
                i11 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i10);
            }
            int i12 = this.size;
            if (i12 >= this.keys.length) {
                int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i12 + 1);
                this.keys = Arrays.copyOf(this.keys, iIdealIntArraySize);
                this.values = Arrays.copyOf(this.values, iIdealIntArraySize);
            }
            int i13 = this.size;
            if (i13 - i11 != 0) {
                int[] iArr = this.keys;
                int i14 = i11 + 1;
                j.j0(i14, i11, iArr, iArr, i13);
                Object[] objArr = this.values;
                j.i0(i14, i11, this.size, objArr, objArr);
            }
            this.keys[i11] = i10;
            this.values[i11] = e;
            this.size++;
        }
        return e3;
    }

    public boolean remove(int i10, Object obj) {
        int iIndexOfKey = indexOfKey(i10);
        if (iIndexOfKey < 0 || !l.a(obj, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public void removeAt(int i10) {
        if (this.values[i10] != SparseArrayCompatKt.DELETED) {
            this.values[i10] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAtRange(int i10, int i11) {
        int iMin = Math.min(i11, i10 + i11);
        while (i10 < iMin) {
            removeAt(i10);
            i10++;
        }
    }

    public boolean replace(int i10, E e, E e3) {
        int iIndexOfKey = indexOfKey(i10);
        if (iIndexOfKey < 0 || !l.a(this.values[iIndexOfKey], e)) {
            return false;
        }
        this.values[iIndexOfKey] = e3;
        return true;
    }

    public void setValueAt(int i10, E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        this.values[i10] = e;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
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
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i10) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return (E) this.values[i10];
    }

    public E get(int i10, E e) {
        return (E) SparseArrayCompatKt.commonGet(this, i10, e);
    }

    public void remove(int i10) {
        SparseArrayCompatKt.commonRemove(this, i10);
    }

    public E replace(int i10, E e) {
        int iIndexOfKey = indexOfKey(i10);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e3 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e3;
    }

    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public /* synthetic */ SparseArrayCompat(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }
}
