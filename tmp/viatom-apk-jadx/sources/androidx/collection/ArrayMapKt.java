package androidx.collection;

import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ArrayMapKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> ArrayMap<K, V> arrayMapOf(i... iVarArr) {
        iVarArr.getClass();
        ArrayMap<K, V> arrayMap = (ArrayMap<K, V>) new ArrayMap(iVarArr.length);
        for (i iVar : iVarArr) {
            arrayMap.put(iVar.f12693a, iVar.f12694b);
        }
        return arrayMap;
    }

    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }
}
