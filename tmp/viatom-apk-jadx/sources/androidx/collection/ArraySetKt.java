package androidx.collection;

import a2.a;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.l;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> arraySet2) {
        arraySet.getClass();
        arraySet2.getClass();
        int i10 = arraySet2.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i10);
        if (arraySet.get_size$collection() != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                arraySet.add(arraySet2.valueAt(i11));
            }
        } else if (i10 > 0) {
            j.n0(0, i10, arraySet2.getHashes$collection(), arraySet.getHashes$collection(), 6);
            j.o0(arraySet2.getArray$collection(), arraySet.getArray$collection(), 0, 0, i10, 6);
            if (arraySet.get_size$collection() == 0) {
                arraySet.set_size$collection(i10);
            } else {
                a.e();
            }
        }
    }

    public static final <E> boolean addInternal(ArraySet<E> arraySet, E e) {
        int i10;
        int iIndexOf;
        arraySet.getClass();
        int i11 = arraySet.get_size$collection();
        if (e == null) {
            iIndexOf = indexOfNull(arraySet);
            i10 = 0;
        } else {
            int iHashCode = e.hashCode();
            i10 = iHashCode;
            iIndexOf = indexOf(arraySet, e, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i12 = ~iIndexOf;
        if (i11 >= arraySet.getHashes$collection().length) {
            int i13 = 8;
            if (i11 >= 8) {
                i13 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i13 = 4;
            }
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i13);
            if (i11 != arraySet.get_size$collection()) {
                a.e();
                return false;
            }
            if (arraySet.getHashes$collection().length != 0) {
                j.n0(0, hashes$collection.length, hashes$collection, arraySet.getHashes$collection(), 6);
                j.o0(array$collection, arraySet.getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i12 < i11) {
            int i14 = i12 + 1;
            j.j0(i14, i12, arraySet.getHashes$collection(), arraySet.getHashes$collection(), i11);
            j.i0(i14, i12, i11, arraySet.getArray$collection(), arraySet.getArray$collection());
        }
        if (i11 != arraySet.get_size$collection() || i12 >= arraySet.getHashes$collection().length) {
            a.e();
            return false;
        }
        arraySet.getHashes$collection()[i12] = i10;
        arraySet.getArray$collection()[i12] = e;
        arraySet.set_size$collection(arraySet.get_size$collection() + 1);
        return true;
    }

    public static final <E> void allocArrays(ArraySet<E> arraySet, int i10) {
        arraySet.getClass();
        arraySet.setHashes$collection(new int[i10]);
        arraySet.setArray$collection(new Object[i10]);
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        tArr.getClass();
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        for (T t : tArr) {
            arraySet.add(t);
        }
        return arraySet;
    }

    public static final <E> int binarySearchInternal(ArraySet<E> arraySet, int i10) {
        arraySet.getClass();
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes$collection(), arraySet.get_size$collection(), i10);
        } catch (IndexOutOfBoundsException unused) {
            a.e();
            return 0;
        }
    }

    public static final <E> void clearInternal(ArraySet<E> arraySet) {
        arraySet.getClass();
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() == 0) {
            return;
        }
        a.e();
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        arraySet.getClass();
        collection.getClass();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            if (!arraySet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean containsInternal(ArraySet<E> arraySet, E e) {
        arraySet.getClass();
        return arraySet.indexOf(e) >= 0;
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> arraySet, int i10) {
        arraySet.getClass();
        int i11 = arraySet.get_size$collection();
        if (arraySet.getHashes$collection().length < i10) {
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i10);
            if (arraySet.get_size$collection() > 0) {
                j.n0(0, arraySet.get_size$collection(), hashes$collection, arraySet.getHashes$collection(), 6);
                j.o0(array$collection, arraySet.getArray$collection(), 0, 0, arraySet.get_size$collection(), 6);
            }
        }
        if (arraySet.get_size$collection() == i11) {
            return;
        }
        a.e();
    }

    public static final <E> boolean equalsInternal(ArraySet<E> arraySet, Object obj) {
        arraySet.getClass();
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i10 = arraySet.get_size$collection();
            for (int i11 = 0; i11 < i10; i11++) {
                if (!((Set) obj).contains(arraySet.valueAt(i11))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(ArraySet<E> arraySet) {
        arraySet.getClass();
        int[] hashes$collection = arraySet.getHashes$collection();
        int i10 = arraySet.get_size$collection();
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += hashes$collection[i12];
        }
        return i11;
    }

    public static final <E> int indexOf(ArraySet<E> arraySet, Object obj, int i10) {
        arraySet.getClass();
        int i11 = arraySet.get_size$collection();
        if (i11 == 0) {
            return -1;
        }
        int iBinarySearchInternal = binarySearchInternal(arraySet, i10);
        if (iBinarySearchInternal < 0 || l.a(obj, arraySet.getArray$collection()[iBinarySearchInternal])) {
            return iBinarySearchInternal;
        }
        int i12 = iBinarySearchInternal + 1;
        while (i12 < i11 && arraySet.getHashes$collection()[i12] == i10) {
            if (l.a(obj, arraySet.getArray$collection()[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iBinarySearchInternal - 1; i13 >= 0 && arraySet.getHashes$collection()[i13] == i10; i13--) {
            if (l.a(obj, arraySet.getArray$collection()[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    public static final <E> int indexOfInternal(ArraySet<E> arraySet, Object obj) {
        arraySet.getClass();
        return obj == null ? indexOfNull(arraySet) : indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> int indexOfNull(ArraySet<E> arraySet) {
        arraySet.getClass();
        return indexOf(arraySet, null, 0);
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> arraySet) {
        arraySet.getClass();
        return arraySet.get_size$collection() <= 0;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> arraySet2) {
        arraySet.getClass();
        arraySet2.getClass();
        int i10 = arraySet2.get_size$collection();
        int i11 = arraySet.get_size$collection();
        for (int i12 = 0; i12 < i10; i12++) {
            arraySet.remove(arraySet2.valueAt(i12));
        }
        return i11 != arraySet.get_size$collection();
    }

    public static final <E> E removeAtInternal(ArraySet<E> arraySet, int i10) {
        int i11;
        arraySet.getClass();
        int i12 = arraySet.get_size$collection();
        E e = (E) arraySet.getArray$collection()[i10];
        if (i12 <= 1) {
            arraySet.clear();
            return e;
        }
        int i13 = i12 - 1;
        if (arraySet.getHashes$collection().length <= 8 || arraySet.get_size$collection() >= arraySet.getHashes$collection().length / 3) {
            if (i10 < i13) {
                int i14 = i10 + 1;
                j.j0(i10, i14, arraySet.getHashes$collection(), arraySet.getHashes$collection(), i12);
                j.i0(i10, i14, i12, arraySet.getArray$collection(), arraySet.getArray$collection());
            }
            arraySet.getArray$collection()[i13] = null;
        } else {
            int i15 = arraySet.get_size$collection() > 8 ? arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1) : 8;
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i15);
            if (i10 > 0) {
                j.n0(0, i10, hashes$collection, arraySet.getHashes$collection(), 6);
                i11 = i10;
                j.o0(array$collection, arraySet.getArray$collection(), 0, 0, i11, 6);
            } else {
                i11 = i10;
            }
            if (i11 < i13) {
                int i16 = i11 + 1;
                j.j0(i11, i16, hashes$collection, arraySet.getHashes$collection(), i12);
                j.i0(i11, i16, i12, array$collection, arraySet.getArray$collection());
            }
        }
        if (i12 == arraySet.get_size$collection()) {
            arraySet.set_size$collection(i13);
            return e;
        }
        a.e();
        return null;
    }

    public static final <E> boolean removeInternal(ArraySet<E> arraySet, E e) {
        arraySet.getClass();
        int iIndexOf = arraySet.indexOf(e);
        if (iIndexOf < 0) {
            return false;
        }
        arraySet.removeAt(iIndexOf);
        return true;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        arraySet.getClass();
        collection.getClass();
        boolean z9 = false;
        for (int i10 = arraySet.get_size$collection() - 1; -1 < i10; i10--) {
            if (!t6.l.a0(collection, arraySet.getArray$collection()[i10])) {
                arraySet.removeAt(i10);
                z9 = true;
            }
        }
        return z9;
    }

    public static final <E> String toStringInternal(ArraySet<E> arraySet) {
        arraySet.getClass();
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i10 = arraySet.get_size$collection();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            E eValueAt = arraySet.valueAt(i11);
            if (eValueAt != arraySet) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static final <E> E valueAtInternal(ArraySet<E> arraySet, int i10) {
        arraySet.getClass();
        return (E) arraySet.getArray$collection()[i10];
    }

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, null);
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        arraySet.getClass();
        collection.getClass();
        Iterator<? extends E> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= arraySet.remove(it.next());
        }
        return zRemove;
    }

    public static final <E> boolean addAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        arraySet.getClass();
        collection.getClass();
        arraySet.ensureCapacity(collection.size() + arraySet.get_size$collection());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= arraySet.add(it.next());
        }
        return zAdd;
    }
}
