package androidx.collection;

import a2.a;
import androidx.collection.internal.ContainerHelpersKt;
import h7.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.g;
import t6.j;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, b {
    private int _size;
    private Object[] array;
    private int[] hashes;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int i10) {
            return ArraySet.this.valueAt(i10);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int i10) {
            ArraySet.this.removeAt(i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(E[] eArr) {
        this(0);
        if (eArr != null) {
            kotlin.jvm.internal.b bVar = new kotlin.jvm.internal.b(eArr);
            while (bVar.hasNext()) {
                add(bVar.next());
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i10;
        int iIndexOf;
        int i11 = get_size$collection();
        if (e == null) {
            iIndexOf = ArraySetKt.indexOfNull(this);
            i10 = 0;
        } else {
            int iHashCode = e.hashCode();
            i10 = iHashCode;
            iIndexOf = ArraySetKt.indexOf(this, e, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i12 = ~iIndexOf;
        if (i11 >= getHashes$collection().length) {
            int i13 = 8;
            if (i11 >= 8) {
                i13 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i13 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i13);
            if (i11 != get_size$collection()) {
                a.e();
                return false;
            }
            if (getHashes$collection().length != 0) {
                j.n0(0, hashes$collection.length, hashes$collection, getHashes$collection(), 6);
                j.o0(array$collection, getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i12 < i11) {
            int i14 = i12 + 1;
            j.j0(i14, i12, getHashes$collection(), getHashes$collection(), i11);
            j.i0(i14, i12, i11, getArray$collection(), getArray$collection());
        }
        if (i11 != get_size$collection() || i12 >= getHashes$collection().length) {
            a.e();
            return false;
        }
        getHashes$collection()[i12] = i10;
        getArray$collection()[i12] = e;
        set_size$collection(get_size$collection() + 1);
        return true;
    }

    public final void addAll(ArraySet<? extends E> arraySet) {
        arraySet.getClass();
        int i10 = arraySet.get_size$collection();
        ensureCapacity(get_size$collection() + i10);
        if (get_size$collection() != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                add(arraySet.valueAt(i11));
            }
        } else if (i10 > 0) {
            j.n0(0, i10, arraySet.getHashes$collection(), getHashes$collection(), 6);
            j.o0(arraySet.getArray$collection(), getArray$collection(), 0, 0, i10, 6);
            if (get_size$collection() == 0) {
                set_size$collection(i10);
            } else {
                a.e();
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() == 0) {
            return;
        }
        a.e();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        collection.getClass();
        Iterator<? extends Object> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int i10) {
        int i11 = get_size$collection();
        if (getHashes$collection().length < i10) {
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i10);
            if (get_size$collection() > 0) {
                j.n0(0, get_size$collection(), hashes$collection, getHashes$collection(), 6);
                j.o0(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6);
            }
        }
        if (get_size$collection() == i11) {
            return;
        }
        a.e();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i10 = get_size$collection();
            for (int i11 = 0; i11 < i10; i11++) {
                if (!((Set) obj).contains(valueAt(i11))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes$collection = getHashes$collection();
        int i10 = get_size$collection();
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += hashes$collection[i12];
        }
        return i11;
    }

    public final int indexOf(Object obj) {
        return obj == null ? ArraySetKt.indexOfNull(this) : ArraySetKt.indexOf(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return get_size$collection() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(ArraySet<? extends E> arraySet) {
        arraySet.getClass();
        int i10 = arraySet.get_size$collection();
        int i11 = get_size$collection();
        for (int i12 = 0; i12 < i10; i12++) {
            remove(arraySet.valueAt(i12));
        }
        return i11 != get_size$collection();
    }

    public final E removeAt(int i10) {
        int i11;
        int i12 = get_size$collection();
        E e = (E) getArray$collection()[i10];
        if (i12 <= 1) {
            clear();
            return e;
        }
        int i13 = i12 - 1;
        if (getHashes$collection().length <= 8 || get_size$collection() >= getHashes$collection().length / 3) {
            if (i10 < i13) {
                int i14 = i10 + 1;
                j.j0(i10, i14, getHashes$collection(), getHashes$collection(), i12);
                j.i0(i10, i14, i12, getArray$collection(), getArray$collection());
            }
            getArray$collection()[i13] = null;
        } else {
            int i15 = get_size$collection() > 8 ? get_size$collection() + (get_size$collection() >> 1) : 8;
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i15);
            if (i10 > 0) {
                j.n0(0, i10, hashes$collection, getHashes$collection(), 6);
                i11 = i10;
                j.o0(array$collection, getArray$collection(), 0, 0, i11, 6);
            } else {
                i11 = i10;
            }
            if (i11 < i13) {
                int i16 = i11 + 1;
                j.j0(i11, i16, hashes$collection, getHashes$collection(), i12);
                j.i0(i11, i16, i12, array$collection, getArray$collection());
            }
        }
        if (i12 == get_size$collection()) {
            set_size$collection(i13);
            return e;
        }
        a.e();
        return null;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        collection.getClass();
        boolean z9 = false;
        for (int i10 = get_size$collection() - 1; -1 < i10; i10--) {
            if (!l.a0(collection, getArray$collection()[i10])) {
                removeAt(i10);
                z9 = true;
            }
        }
        return z9;
    }

    public final void setArray$collection(Object[] objArr) {
        objArr.getClass();
        this.array = objArr;
    }

    public final void setHashes$collection(int[] iArr) {
        iArr.getClass();
        this.hashes = iArr;
    }

    public final void set_size$collection(int i10) {
        this._size = i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        tArr.getClass();
        T[] tArr2 = (T[]) ArraySetJvmUtil.resizeForToArray(tArr, this._size);
        j.i0(0, 0, this._size, this.array, tArr2);
        return tArr2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i10 = get_size$collection();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            E eValueAt = valueAt(i11);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final E valueAt(int i10) {
        return (E) getArray$collection()[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return j.p0(this.array, 0, this._size);
    }

    public ArraySet(int i10) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i10 > 0) {
            ArraySetKt.allocArrays(this, i10);
        }
    }

    public /* synthetic */ ArraySet(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    public ArraySet(ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        collection.getClass();
        Iterator<? extends Object> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    public ArraySet() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        collection.getClass();
        ensureCapacity(collection.size() + get_size$collection());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }
}
