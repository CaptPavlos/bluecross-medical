package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class IntListKt {
    private static final IntList EmptyIntList = new MutableIntList(0);

    public static final IntList emptyIntList() {
        return EmptyIntList;
    }

    public static final IntList intListOf(int... iArr) {
        iArr.getClass();
        MutableIntList mutableIntList = new MutableIntList(iArr.length);
        mutableIntList.plusAssign(iArr);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf(int i10, int i11, int i12) {
        MutableIntList mutableIntList = new MutableIntList(3);
        mutableIntList.add(i10);
        mutableIntList.add(i11);
        mutableIntList.add(i12);
        return mutableIntList;
    }

    public static final IntList intListOf(int i10) {
        return mutableIntListOf(i10);
    }

    public static final IntList intListOf(int i10, int i11) {
        return mutableIntListOf(i10, i11);
    }

    public static final IntList intListOf(int i10, int i11, int i12) {
        return mutableIntListOf(i10, i11, i12);
    }

    public static final IntList intListOf() {
        return EmptyIntList;
    }

    public static final MutableIntList mutableIntListOf(int i10) {
        MutableIntList mutableIntList = new MutableIntList(1);
        mutableIntList.add(i10);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf(int i10, int i11) {
        MutableIntList mutableIntList = new MutableIntList(2);
        mutableIntList.add(i10);
        mutableIntList.add(i11);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf() {
        return new MutableIntList(0, 1, null);
    }

    public static final MutableIntList mutableIntListOf(int... iArr) {
        iArr.getClass();
        MutableIntList mutableIntList = new MutableIntList(iArr.length);
        mutableIntList.plusAssign(iArr);
        return mutableIntList;
    }
}
