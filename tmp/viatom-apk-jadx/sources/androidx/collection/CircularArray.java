package androidx.collection;

import com.google.gson.internal.a;
import kotlin.jvm.internal.g;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CircularArray<E> {
    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;

    public CircularArray(int i10) {
        if (i10 < 1) {
            a.n("capacity must be >= 1");
            throw null;
        }
        if (i10 > 1073741824) {
            a.n("capacity must be <= 2^30");
            throw null;
        }
        i10 = Integer.bitCount(i10) != 1 ? Integer.highestOneBit(i10 - 1) << 1 : i10;
        this.capacityBitmask = i10 - 1;
        this.elements = (E[]) new Object[i10];
    }

    private final void doubleCapacity() {
        E[] eArr = this.elements;
        int length = eArr.length;
        int i10 = this.head;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 < 0) {
            a2.a.j("Max array capacity exceeded");
            return;
        }
        E[] eArr2 = (E[]) new Object[i12];
        j.i0(0, i10, length, eArr, eArr2);
        j.i0(i11, 0, this.head, this.elements, eArr2);
        this.elements = eArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i12 - 1;
    }

    public final void addFirst(E e) {
        int i10 = (this.head - 1) & this.capacityBitmask;
        this.head = i10;
        this.elements[i10] = e;
        if (i10 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e) {
        E[] eArr = this.elements;
        int i10 = this.tail;
        eArr[i10] = e;
        int i11 = this.capacityBitmask & (i10 + 1);
        this.tail = i11;
        if (i11 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int i10) {
        if (i10 < 0 || i10 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[this.capacityBitmask & (this.head + i10)];
        e.getClass();
        return e;
    }

    public final E getFirst() {
        int i10 = this.head;
        if (i10 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[i10];
        e.getClass();
        return e;
    }

    public final E getLast() {
        int i10 = this.head;
        int i11 = this.tail;
        if (i10 == i11) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[(i11 - 1) & this.capacityBitmask];
        e.getClass();
        return e;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final E popFirst() {
        int i10 = this.head;
        if (i10 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.elements;
        E e = eArr[i10];
        eArr[i10] = null;
        this.head = (i10 + 1) & this.capacityBitmask;
        return e;
    }

    public final E popLast() {
        int i10 = this.head;
        int i11 = this.tail;
        if (i10 == i11) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.capacityBitmask & (i11 - 1);
        E[] eArr = this.elements;
        E e = eArr[i12];
        eArr[i12] = null;
        this.tail = i12;
        return e;
    }

    public final void removeFromEnd(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = this.tail;
        int i12 = i10 < i11 ? i11 - i10 : 0;
        for (int i13 = i12; i13 < i11; i13++) {
            this.elements[i13] = null;
        }
        int i14 = this.tail;
        int i15 = i14 - i12;
        int i16 = i10 - i15;
        this.tail = i14 - i15;
        if (i16 > 0) {
            int length = this.elements.length;
            this.tail = length;
            int i17 = length - i16;
            for (int i18 = i17; i18 < length; i18++) {
                this.elements[i18] = null;
            }
            this.tail = i17;
        }
    }

    public final void removeFromStart(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.elements.length;
        int i11 = this.head;
        if (i10 < length - i11) {
            length = i11 + i10;
        }
        while (i11 < length) {
            this.elements[i11] = null;
            i11++;
        }
        int i12 = this.head;
        int i13 = length - i12;
        int i14 = i10 - i13;
        this.head = this.capacityBitmask & (i12 + i13);
        if (i14 > 0) {
            for (int i15 = 0; i15 < i14; i15++) {
                this.elements[i15] = null;
            }
            this.head = i14;
        }
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularArray() {
        this(0, 1, null);
    }

    public /* synthetic */ CircularArray(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 8 : i10);
    }
}
