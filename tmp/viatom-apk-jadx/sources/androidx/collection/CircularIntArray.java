package androidx.collection;

import com.google.gson.internal.a;
import kotlin.jvm.internal.g;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray(int i10) {
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
        this.elements = new int[i10];
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i10 = this.head;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 < 0) {
            a2.a.j("Max array capacity exceeded");
            return;
        }
        int[] iArr2 = new int[i12];
        j.j0(0, i10, iArr, iArr2, length);
        j.j0(i11, 0, this.elements, iArr2, this.head);
        this.elements = iArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i12 - 1;
    }

    public final void addFirst(int i10) {
        int i11 = (this.head - 1) & this.capacityBitmask;
        this.head = i11;
        this.elements[i11] = i10;
        if (i11 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int i10) {
        int[] iArr = this.elements;
        int i11 = this.tail;
        iArr[i11] = i10;
        int i12 = this.capacityBitmask & (i11 + 1);
        this.tail = i12;
        if (i12 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int get(int i10) {
        if (i10 < 0 || i10 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.elements[this.capacityBitmask & (this.head + i10)];
    }

    public final int getFirst() {
        int i10 = this.head;
        if (i10 != this.tail) {
            return this.elements[i10];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i10 = this.head;
        int i11 = this.tail;
        if (i10 != i11) {
            return this.elements[(i11 - 1) & this.capacityBitmask];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final int popFirst() {
        int i10 = this.head;
        if (i10 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = this.elements[i10];
        this.head = (i10 + 1) & this.capacityBitmask;
        return i11;
    }

    public final int popLast() {
        int i10 = this.head;
        int i11 = this.tail;
        if (i10 == i11) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.capacityBitmask & (i11 - 1);
        int i13 = this.elements[i12];
        this.tail = i12;
        return i13;
    }

    public final void removeFromEnd(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.tail = this.capacityBitmask & (this.tail - i10);
    }

    public final void removeFromStart(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.head = this.capacityBitmask & (this.head + i10);
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularIntArray() {
        this(0, 1, null);
    }

    public /* synthetic */ CircularIntArray(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 8 : i10);
    }
}
