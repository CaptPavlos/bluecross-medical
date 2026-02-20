package androidx.datastore.preferences.protobuf;

import a3.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import p8.u;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST = new ProtobufArrayList<>(new Object[0], 0, false);
    private E[] array;
    private int size;

    public ProtobufArrayList() {
        this(new Object[10], 0, true);
    }

    private static <E> E[] createArray(int i10) {
        return (E[]) new Object[i10];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private void ensureIndexInRange(int i10) {
        if (i10 < 0 || i10 >= this.size) {
            u.k(makeOutOfBoundsExceptionMessage(i10));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i10) {
        StringBuilder sbR = a.r(i10, "Index:", ", Size:");
        sbR.append(this.size);
        return sbR.toString();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i10, E e) {
        int i11;
        ensureIsMutable();
        if (i10 < 0 || i10 > (i11 = this.size)) {
            u.k(makeOutOfBoundsExceptionMessage(i10));
            return;
        }
        E[] eArr = this.array;
        if (i11 < eArr.length) {
            System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
        } else {
            E[] eArr2 = (E[]) createArray(((i11 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, eArr2, 0, i10);
            System.arraycopy(this.array, i10, eArr2, i10 + 1, this.size - i10);
            this.array = eArr2;
        }
        this.array[i10] = e;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        ensureIndexInRange(i10);
        return this.array[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int i10) {
        if (i10 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i10), this.size, true);
        }
        f.a();
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i10) {
        ensureIsMutable();
        ensureIndexInRange(i10);
        E[] eArr = this.array;
        E e = eArr[i10];
        if (i10 < this.size - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (r2 - i10) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i10, E e) {
        ensureIsMutable();
        ensureIndexInRange(i10);
        E[] eArr = this.array;
        E e3 = eArr[i10];
        eArr[i10] = e;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] eArr, int i10, boolean z9) {
        super(z9);
        this.array = eArr;
        this.size = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        ensureIsMutable();
        int i10 = this.size;
        E[] eArr = this.array;
        if (i10 == eArr.length) {
            this.array = (E[]) Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i11 = this.size;
        this.size = i11 + 1;
        eArr2[i11] = e;
        ((AbstractList) this).modCount++;
        return true;
    }
}
