package androidx.collection;

import h7.a;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class MapEntry<K, V> implements Map.Entry<K, V>, a {
    private final K key;
    private final V value;

    public MapEntry(K k10, V v6) {
        this.key = k10;
        this.value = v6;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
