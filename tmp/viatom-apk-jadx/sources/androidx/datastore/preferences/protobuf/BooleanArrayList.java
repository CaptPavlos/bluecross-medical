package androidx.datastore.preferences.protobuf;

import a3.a;
import androidx.datastore.preferences.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import p8.u;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList(new boolean[0], 0, false);
    private boolean[] array;
    private int size;

    public BooleanArrayList() {
        this(new boolean[10], 0, true);
    }

    private void addBoolean(int i10, boolean z9) {
        int i11;
        ensureIsMutable();
        if (i10 < 0 || i10 > (i11 = this.size)) {
            u.k(makeOutOfBoundsExceptionMessage(i10));
            return;
        }
        boolean[] zArr = this.array;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.array, i10, zArr2, i10 + 1, this.size - i10);
            this.array = zArr2;
        }
        this.array[i10] = z9;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
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

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i10 = booleanArrayList.size;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.size;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        boolean[] zArr = this.array;
        if (i12 > zArr.length) {
            this.array = Arrays.copyOf(zArr, i12);
        }
        System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
        this.size = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i10 = 0; i10 < this.size; i10++) {
            if (this.array[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int i10) {
        return Boolean.valueOf(getBoolean(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.BooleanList
    public boolean getBoolean(int i10) {
        ensureIndexInRange(i10);
        return this.array[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashBoolean = 1;
        for (int i10 = 0; i10 < this.size; i10++) {
            iHashBoolean = (iHashBoolean * 31) + Internal.hashBoolean(this.array[i10]);
        }
        return iHashBoolean;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.array[i10] == zBooleanValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity, reason: merged with bridge method [inline-methods] */
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int i10) {
        if (i10 >= this.size) {
            return new BooleanArrayList(Arrays.copyOf(this.array, i10), this.size, true);
        }
        f.a();
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean remove(int i10) {
        ensureIsMutable();
        ensureIndexInRange(i10);
        boolean[] zArr = this.array;
        boolean z9 = zArr[i10];
        if (i10 < this.size - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (r2 - i10) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z9);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        ensureIsMutable();
        if (i11 < i10) {
            u.k("toIndex < fromIndex");
            return;
        }
        boolean[] zArr = this.array;
        System.arraycopy(zArr, i11, zArr, i10, this.size - i11);
        this.size -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean set(int i10, Boolean bool) {
        return Boolean.valueOf(setBoolean(i10, bool.booleanValue()));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.BooleanList
    public boolean setBoolean(int i10, boolean z9) {
        ensureIsMutable();
        ensureIndexInRange(i10);
        boolean[] zArr = this.array;
        boolean z10 = zArr[i10];
        zArr[i10] = z9;
        return z10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private BooleanArrayList(boolean[] zArr, int i10, boolean z9) {
        super(z9);
        this.array = zArr;
        this.size = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i10, Boolean bool) {
        addBoolean(i10, bool.booleanValue());
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.BooleanList
    public void addBoolean(boolean z9) {
        ensureIsMutable();
        int i10 = this.size;
        boolean[] zArr = this.array;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[((i10 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i11 = this.size;
        this.size = i11 + 1;
        zArr3[i11] = z9;
    }
}
