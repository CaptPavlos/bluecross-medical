package androidx.collection;

import h7.c;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class MutableMapEntry<K, V> implements Map.Entry<K, V>, c {
    private final int index;
    private final Object[] keys;
    private final Object[] values;

    public MutableMapEntry(Object[] objArr, Object[] objArr2, int i10) {
        objArr.getClass();
        objArr2.getClass();
        this.keys = objArr;
        this.values = objArr2;
        this.index = i10;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return (K) this.keys[this.index];
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return (V) this.values[this.index];
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v6) {
        Object[] objArr = this.values;
        int i10 = this.index;
        V v9 = (V) objArr[i10];
        objArr[i10] = v6;
        return v9;
    }

    public static /* synthetic */ void getKey$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }
}
