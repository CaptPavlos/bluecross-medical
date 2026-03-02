package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class IntSetKt {
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);
    private static final int[] EmptyIntArray = new int[0];

    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final int hash(int i10) {
        int i11 = i10 * ScatterMapKt.MurmurHashC1;
        return i11 ^ (i11 << 16);
    }

    public static final IntSet intSetOf(int... iArr) {
        iArr.getClass();
        MutableIntSet mutableIntSet = new MutableIntSet(iArr.length);
        mutableIntSet.plusAssign(iArr);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i10, int i11, int i12) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i10);
        mutableIntSet.plusAssign(i11);
        mutableIntSet.plusAssign(i12);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int i10) {
        return mutableIntSetOf(i10);
    }

    public static final IntSet intSetOf(int i10, int i11) {
        return mutableIntSetOf(i10, i11);
    }

    public static final IntSet intSetOf(int i10, int i11, int i12) {
        return mutableIntSetOf(i10, i11, i12);
    }

    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i10) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i10);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i10, int i11) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i10);
        mutableIntSet.plusAssign(i11);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    public static final MutableIntSet mutableIntSetOf(int... iArr) {
        iArr.getClass();
        MutableIntSet mutableIntSet = new MutableIntSet(iArr.length);
        mutableIntSet.plusAssign(iArr);
        return mutableIntSet;
    }
}
