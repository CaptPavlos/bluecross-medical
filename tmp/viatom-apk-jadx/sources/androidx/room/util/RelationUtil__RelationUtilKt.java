package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import g7.l;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class RelationUtil__RelationUtilKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(LongSparseArray<V> longSparseArray, boolean z9, l lVar) {
        longSparseArray.getClass();
        lVar.getClass();
        LongSparseArray<? extends V> longSparseArray2 = new LongSparseArray<>(999);
        int size = longSparseArray.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (z9) {
                longSparseArray2.put(longSparseArray.keyAt(i10), longSparseArray.valueAt(i10));
            } else {
                longSparseArray2.put(longSparseArray.keyAt(i10), null);
            }
            i10++;
            i11++;
            if (i11 == 999) {
                lVar.invoke(longSparseArray2);
                if (!z9) {
                    longSparseArray.putAll(longSparseArray2);
                }
                longSparseArray2.clear();
                i11 = 0;
            }
        }
        if (i11 > 0) {
            lVar.invoke(longSparseArray2);
            if (z9) {
                return;
            }
            longSparseArray.putAll(longSparseArray2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(Map<K, V> map, boolean z9, l lVar) {
        int i10;
        map.getClass();
        lVar.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        loop0: while (true) {
            i10 = 0;
            for (K k10 : map.keySet()) {
                if (z9) {
                    linkedHashMap.put(k10, map.get(k10));
                } else {
                    linkedHashMap.put(k10, null);
                }
                i10++;
                if (i10 == 999) {
                    lVar.invoke(linkedHashMap);
                    if (!z9) {
                        map.putAll(linkedHashMap);
                    }
                    linkedHashMap.clear();
                }
            }
            break loop0;
        }
        if (i10 > 0) {
            lVar.invoke(linkedHashMap);
            if (z9) {
                return;
            }
            map.putAll(linkedHashMap);
        }
    }
}
