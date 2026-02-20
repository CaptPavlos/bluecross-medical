package androidx.collection.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LruHashMap<K, V> {
    private final LinkedHashMap<K, V> map;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LruHashMap(LruHashMap<? extends K, V> lruHashMap) {
        this(0, 0.0f, 3, null);
        lruHashMap.getClass();
        for (Map.Entry<? extends K, V> entry : lruHashMap.getEntries()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final V get(K k10) {
        k10.getClass();
        return this.map.get(k10);
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        Set<Map.Entry<K, V>> setEntrySet = this.map.entrySet();
        setEntrySet.getClass();
        return setEntrySet;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final V put(K k10, V v6) {
        k10.getClass();
        v6.getClass();
        return this.map.put(k10, v6);
    }

    public final V remove(K k10) {
        k10.getClass();
        return this.map.remove(k10);
    }

    public LruHashMap(int i10, float f) {
        this.map = new LinkedHashMap<>(i10, f, true);
    }

    public /* synthetic */ LruHashMap(int i10, float f, int i11, g gVar) {
        this((i11 & 1) != 0 ? 16 : i10, (i11 & 2) != 0 ? 0.75f : f);
    }

    public LruHashMap() {
        this(0, 0.0f, 3, null);
    }
}
