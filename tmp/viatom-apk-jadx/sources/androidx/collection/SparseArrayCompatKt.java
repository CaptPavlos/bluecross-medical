package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SparseArrayCompatKt {
    private static final Object DELETED = new Object();

    public static final <E> void commonAppend(SparseArrayCompat<E> sparseArrayCompat, int i10, E e) {
        sparseArrayCompat.getClass();
        int i11 = sparseArrayCompat.size;
        if (i11 != 0 && i10 <= sparseArrayCompat.keys[i11 - 1]) {
            sparseArrayCompat.put(i10, e);
            return;
        }
        if (sparseArrayCompat.garbage && i11 >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
        }
        int i12 = sparseArrayCompat.size;
        if (i12 >= sparseArrayCompat.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i12 + 1);
            sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
            sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
        }
        sparseArrayCompat.keys[i12] = i10;
        sparseArrayCompat.values[i12] = e;
        sparseArrayCompat.size = i12 + 1;
    }

    public static final <E> void commonClear(SparseArrayCompat<E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        int i10 = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(SparseArrayCompat<E> sparseArrayCompat, int i10) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.indexOfKey(i10) >= 0;
    }

    public static final <E> boolean commonContainsValue(SparseArrayCompat<E> sparseArrayCompat, E e) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i10 = sparseArrayCompat.size;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                i11 = -1;
                break;
            }
            if (sparseArrayCompat.values[i11] == e) {
                break;
            }
            i11++;
        }
        return i11 >= 0;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i10) {
        E e;
        sparseArrayCompat.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
        if (iBinarySearch < 0 || (e = (E) sparseArrayCompat.values[iBinarySearch]) == DELETED) {
            return null;
        }
        return e;
    }

    public static final <E> int commonIndexOfKey(SparseArrayCompat<E> sparseArrayCompat, int i10) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
    }

    public static final <E> int commonIndexOfValue(SparseArrayCompat<E> sparseArrayCompat, E e) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i10 = sparseArrayCompat.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (sparseArrayCompat.values[i11] == e) {
                return i11;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(SparseArrayCompat<E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.size() == 0;
    }

    public static final <E> int commonKeyAt(SparseArrayCompat<E> sparseArrayCompat, int i10) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i10];
    }

    public static final <E> void commonPut(SparseArrayCompat<E> sparseArrayCompat, int i10, E e) {
        sparseArrayCompat.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
        if (iBinarySearch >= 0) {
            sparseArrayCompat.values[iBinarySearch] = e;
            return;
        }
        int i11 = ~iBinarySearch;
        if (i11 < sparseArrayCompat.size && sparseArrayCompat.values[i11] == DELETED) {
            sparseArrayCompat.keys[i11] = i10;
            sparseArrayCompat.values[i11] = e;
            return;
        }
        if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
            i11 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
        }
        int i12 = sparseArrayCompat.size;
        if (i12 >= sparseArrayCompat.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i12 + 1);
            sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
            sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
        }
        int i13 = sparseArrayCompat.size;
        if (i13 - i11 != 0) {
            int[] iArr = sparseArrayCompat.keys;
            int i14 = i11 + 1;
            j.j0(i14, i11, iArr, iArr, i13);
            Object[] objArr = sparseArrayCompat.values;
            j.i0(i14, i11, sparseArrayCompat.size, objArr, objArr);
        }
        sparseArrayCompat.keys[i11] = i10;
        sparseArrayCompat.values[i11] = e;
        sparseArrayCompat.size++;
    }

    public static final <E> void commonPutAll(SparseArrayCompat<E> sparseArrayCompat, SparseArrayCompat<? extends E> sparseArrayCompat2) {
        sparseArrayCompat.getClass();
        sparseArrayCompat2.getClass();
        int size = sparseArrayCompat2.size();
        for (int i10 = 0; i10 < size; i10++) {
            int iKeyAt = sparseArrayCompat2.keyAt(i10);
            E eValueAt = sparseArrayCompat2.valueAt(i10);
            int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, iKeyAt);
            if (iBinarySearch >= 0) {
                sparseArrayCompat.values[iBinarySearch] = eValueAt;
            } else {
                int i11 = ~iBinarySearch;
                if (i11 >= sparseArrayCompat.size || sparseArrayCompat.values[i11] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i11 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, iKeyAt);
                    }
                    int i12 = sparseArrayCompat.size;
                    if (i12 >= sparseArrayCompat.keys.length) {
                        int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i12 + 1);
                        sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
                        sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
                    }
                    int i13 = sparseArrayCompat.size;
                    if (i13 - i11 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i14 = i11 + 1;
                        j.j0(i14, i11, iArr, iArr, i13);
                        Object[] objArr = sparseArrayCompat.values;
                        j.i0(i14, i11, sparseArrayCompat.size, objArr, objArr);
                    }
                    sparseArrayCompat.keys[i11] = iKeyAt;
                    sparseArrayCompat.values[i11] = eValueAt;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i11] = iKeyAt;
                    sparseArrayCompat.values[i11] = eValueAt;
                }
            }
        }
    }

    public static final <E> E commonPutIfAbsent(SparseArrayCompat<E> sparseArrayCompat, int i10, E e) {
        sparseArrayCompat.getClass();
        E e3 = (E) commonGet(sparseArrayCompat, i10);
        if (e3 == null) {
            int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
            if (iBinarySearch >= 0) {
                sparseArrayCompat.values[iBinarySearch] = e;
                return e3;
            }
            int i11 = ~iBinarySearch;
            if (i11 < sparseArrayCompat.size && sparseArrayCompat.values[i11] == DELETED) {
                sparseArrayCompat.keys[i11] = i10;
                sparseArrayCompat.values[i11] = e;
                return e3;
            }
            if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
                i11 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
            }
            int i12 = sparseArrayCompat.size;
            if (i12 >= sparseArrayCompat.keys.length) {
                int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i12 + 1);
                sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
                sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
            }
            int i13 = sparseArrayCompat.size;
            if (i13 - i11 != 0) {
                int[] iArr = sparseArrayCompat.keys;
                int i14 = i11 + 1;
                j.j0(i14, i11, iArr, iArr, i13);
                Object[] objArr = sparseArrayCompat.values;
                j.i0(i14, i11, sparseArrayCompat.size, objArr, objArr);
            }
            sparseArrayCompat.keys[i11] = i10;
            sparseArrayCompat.values[i11] = e;
            sparseArrayCompat.size++;
        }
        return e3;
    }

    public static final <E> void commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i10) {
        sparseArrayCompat.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
        if (iBinarySearch >= 0) {
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[iBinarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[iBinarySearch] = obj2;
                sparseArrayCompat.garbage = true;
            }
        }
    }

    public static final <E> void commonRemoveAt(SparseArrayCompat<E> sparseArrayCompat, int i10) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.values[i10] != DELETED) {
            sparseArrayCompat.values[i10] = DELETED;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(SparseArrayCompat<E> sparseArrayCompat, int i10, int i11) {
        sparseArrayCompat.getClass();
        int iMin = Math.min(i11, i10 + i11);
        while (i10 < iMin) {
            sparseArrayCompat.removeAt(i10);
            i10++;
        }
    }

    public static final <E> boolean commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i10, E e, E e3) {
        sparseArrayCompat.getClass();
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i10);
        if (iIndexOfKey < 0 || !l.a(sparseArrayCompat.values[iIndexOfKey], e)) {
            return false;
        }
        sparseArrayCompat.values[iIndexOfKey] = e3;
        return true;
    }

    public static final <E> void commonSetValueAt(SparseArrayCompat<E> sparseArrayCompat, int i10, E e) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i10] = e;
    }

    public static final <E> int commonSize(SparseArrayCompat<E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    public static final <E> String commonToString(SparseArrayCompat<E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i10 = sparseArrayCompat.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i11));
            sb.append('=');
            E eValueAt = sparseArrayCompat.valueAt(i11);
            if (eValueAt != sparseArrayCompat) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static final <E> E commonValueAt(SparseArrayCompat<E> sparseArrayCompat, int i10) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return (E) sparseArrayCompat.values[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i10 = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != DELETED) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i11;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> sparseArrayCompat, int i10, T t) {
        T t9;
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
        return (iBinarySearch < 0 || (t9 = (T) sparseArrayCompat.values[iBinarySearch]) == DELETED) ? t : t9;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i10, E e) {
        E e3;
        sparseArrayCompat.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i10);
        return (iBinarySearch < 0 || (e3 = (E) sparseArrayCompat.values[iBinarySearch]) == DELETED) ? e : e3;
    }

    public static final <E> boolean commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i10, Object obj) {
        sparseArrayCompat.getClass();
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i10);
        if (iIndexOfKey < 0 || !l.a(obj, sparseArrayCompat.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(iIndexOfKey);
        return true;
    }

    public static final <E> E commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i10, E e) {
        sparseArrayCompat.getClass();
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i10);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = sparseArrayCompat.values;
        E e3 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e3;
    }
}
