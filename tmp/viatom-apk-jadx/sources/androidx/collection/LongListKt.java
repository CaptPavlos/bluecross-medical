package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LongListKt {
    private static final LongList EmptyLongList = new MutableLongList(0);

    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    public static final LongList longListOf(long... jArr) {
        jArr.getClass();
        MutableLongList mutableLongList = new MutableLongList(jArr.length);
        mutableLongList.plusAssign(jArr);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j10, long j11, long j12) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j10);
        mutableLongList.add(j11);
        mutableLongList.add(j12);
        return mutableLongList;
    }

    public static final LongList longListOf(long j10) {
        return mutableLongListOf(j10);
    }

    public static final LongList longListOf(long j10, long j11) {
        return mutableLongListOf(j10, j11);
    }

    public static final LongList longListOf(long j10, long j11, long j12) {
        return mutableLongListOf(j10, j11, j12);
    }

    public static final LongList longListOf() {
        return EmptyLongList;
    }

    public static final MutableLongList mutableLongListOf(long j10) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j10);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j10, long j11) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j10);
        mutableLongList.add(j11);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    public static final MutableLongList mutableLongListOf(long... jArr) {
        jArr.getClass();
        MutableLongList mutableLongList = new MutableLongList(jArr.length);
        mutableLongList.plusAssign(jArr);
        return mutableLongList;
    }
}
