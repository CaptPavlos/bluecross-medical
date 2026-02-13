package t6;

import com.google.android.gms.internal.measurement.l5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a0 extends l5 {
    public static Object f0(Map map, Object obj) {
        map.getClass();
        if (map instanceof z) {
            return ((z) map).b();
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        a2.a.i(obj, "Key ", " is missing in the map.");
        return null;
    }

    public static HashMap g0(s6.i... iVarArr) {
        HashMap map = new HashMap(h0(iVarArr.length));
        j0(map, iVarArr);
        return map;
    }

    public static int h0(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map i0(s6.i... iVarArr) {
        if (iVarArr.length <= 0) {
            return u.f12809a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h0(iVarArr.length));
        j0(linkedHashMap, iVarArr);
        return linkedHashMap;
    }

    public static final void j0(HashMap map, s6.i[] iVarArr) {
        for (s6.i iVar : iVarArr) {
            map.put(iVar.f12693a, iVar.f12694b);
        }
    }

    public static Map k0(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return u.f12809a;
        }
        int i10 = 0;
        if (size == 1) {
            s6.i iVar = (s6.i) arrayList.get(0);
            iVar.getClass();
            Map mapSingletonMap = Collections.singletonMap(iVar.f12693a, iVar.f12694b);
            mapSingletonMap.getClass();
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h0(arrayList.size()));
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            s6.i iVar2 = (s6.i) obj;
            linkedHashMap.put(iVar2.f12693a, iVar2.f12694b);
        }
        return linkedHashMap;
    }

    public static Map l0(Map map) {
        map.getClass();
        int size = map.size();
        if (size == 0) {
            return u.f12809a;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }
}
