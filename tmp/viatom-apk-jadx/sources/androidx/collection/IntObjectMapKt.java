package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class IntObjectMapKt {
    private static final MutableIntObjectMap EmptyIntObjectMap = new MutableIntObjectMap(0);

    public static final <V> IntObjectMap<V> emptyIntObjectMap() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        mutableIntObjectMap.getClass();
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i10, V v6, int i11, V v9, int i12, V v10, int i13, V v11, int i14, V v12) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        mutableIntObjectMap.set(i11, v9);
        mutableIntObjectMap.set(i12, v10);
        mutableIntObjectMap.set(i13, v11);
        mutableIntObjectMap.set(i14, v12);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i10, V v6, int i11, V v9, int i12, V v10, int i13, V v11, int i14, V v12) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        mutableIntObjectMap.set(i11, v9);
        mutableIntObjectMap.set(i12, v10);
        mutableIntObjectMap.set(i13, v11);
        mutableIntObjectMap.set(i14, v12);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i10, V v6) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i10, V v6) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i10, V v6, int i11, V v9) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        mutableIntObjectMap.set(i11, v9);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i10, V v6, int i11, V v9) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        mutableIntObjectMap.set(i11, v9);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i10, V v6, int i11, V v9, int i12, V v10) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        mutableIntObjectMap.set(i11, v9);
        mutableIntObjectMap.set(i12, v10);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i10, V v6, int i11, V v9, int i12, V v10) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        mutableIntObjectMap.set(i11, v9);
        mutableIntObjectMap.set(i12, v10);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i10, V v6, int i11, V v9, int i12, V v10, int i13, V v11) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        mutableIntObjectMap.set(i11, v9);
        mutableIntObjectMap.set(i12, v10);
        mutableIntObjectMap.set(i13, v11);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i10, V v6, int i11, V v9, int i12, V v10, int i13, V v11) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i10, v6);
        mutableIntObjectMap.set(i11, v9);
        mutableIntObjectMap.set(i12, v10);
        mutableIntObjectMap.set(i13, v11);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        mutableIntObjectMap.getClass();
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf() {
        return new MutableIntObjectMap<>(0, 1, null);
    }
}
