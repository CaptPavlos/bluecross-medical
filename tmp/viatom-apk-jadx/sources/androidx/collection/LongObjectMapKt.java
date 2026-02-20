package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LongObjectMapKt {
    private static final MutableLongObjectMap EmptyLongObjectMap = new MutableLongObjectMap(0);

    public static final <V> LongObjectMap<V> emptyLongObjectMap() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        mutableLongObjectMap.getClass();
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j10, V v6, long j11, V v9, long j12, V v10, long j13, V v11, long j14, V v12) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        mutableLongObjectMap.set(j11, v9);
        mutableLongObjectMap.set(j12, v10);
        mutableLongObjectMap.set(j13, v11);
        mutableLongObjectMap.set(j14, v12);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j10, V v6, long j11, V v9, long j12, V v10, long j13, V v11, long j14, V v12) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        mutableLongObjectMap.set(j11, v9);
        mutableLongObjectMap.set(j12, v10);
        mutableLongObjectMap.set(j13, v11);
        mutableLongObjectMap.set(j14, v12);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j10, V v6) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j10, V v6) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j10, V v6, long j11, V v9) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        mutableLongObjectMap.set(j11, v9);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j10, V v6, long j11, V v9) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        mutableLongObjectMap.set(j11, v9);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j10, V v6, long j11, V v9, long j12, V v10) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        mutableLongObjectMap.set(j11, v9);
        mutableLongObjectMap.set(j12, v10);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j10, V v6, long j11, V v9, long j12, V v10) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        mutableLongObjectMap.set(j11, v9);
        mutableLongObjectMap.set(j12, v10);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j10, V v6, long j11, V v9, long j12, V v10, long j13, V v11) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        mutableLongObjectMap.set(j11, v9);
        mutableLongObjectMap.set(j12, v10);
        mutableLongObjectMap.set(j13, v11);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j10, V v6, long j11, V v9, long j12, V v10, long j13, V v11) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j10, v6);
        mutableLongObjectMap.set(j11, v9);
        mutableLongObjectMap.set(j12, v10);
        mutableLongObjectMap.set(j13, v11);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        mutableLongObjectMap.getClass();
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf() {
        return new MutableLongObjectMap<>(0, 1, null);
    }
}
