package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import g7.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class RelationUtil__RelationUtil_androidKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchArrayMap(ArrayMap<K, V> arrayMap, boolean z9, l lVar) {
        arrayMap.getClass();
        lVar.getClass();
        ArrayMap arrayMap2 = new ArrayMap(999);
        int size = arrayMap.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (z9) {
                arrayMap2.put(arrayMap.keyAt(i10), arrayMap.valueAt(i10));
            } else {
                arrayMap2.put(arrayMap.keyAt(i10), null);
            }
            i10++;
            i11++;
            if (i11 == 999) {
                lVar.invoke(arrayMap2);
                if (!z9) {
                    arrayMap.putAll((Map) arrayMap2);
                }
                arrayMap2.clear();
                i11 = 0;
            }
        }
        if (i11 > 0) {
            lVar.invoke(arrayMap2);
            if (z9) {
                return;
            }
            arrayMap.putAll((Map) arrayMap2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> map, boolean z9, l lVar) {
        int i10;
        map.getClass();
        lVar.getClass();
        HashMap map2 = new HashMap(999);
        loop0: while (true) {
            i10 = 0;
            for (K k10 : map.keySet()) {
                k10.getClass();
                if (z9) {
                    map2.put(k10, map.get(k10));
                } else {
                    map2.put(k10, null);
                }
                i10++;
                if (i10 == 999) {
                    lVar.invoke(map2);
                    if (!z9) {
                        map.putAll(map2);
                    }
                    map2.clear();
                }
            }
            break loop0;
        }
        if (i10 > 0) {
            lVar.invoke(map2);
            if (z9) {
                return;
            }
            map.putAll(map2);
        }
    }
}
