package j$.time.format;

import j$.util.stream.y6;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Map f9245a;

    public void b(y6 y6Var) {
        ((EnumMap) this.f9245a).put((EnumMap) y6Var, (y6) 1);
    }

    public r(int i10, Map map) {
        switch (i10) {
            case 1:
                this.f9245a = map;
                break;
            default:
                this.f9245a = map;
                HashMap map2 = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    HashMap map3 = new HashMap();
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        String str = (String) entry2.getValue();
                        String str2 = (String) entry2.getValue();
                        Long l10 = (Long) entry2.getKey();
                        q qVar = b.f9213b;
                        map3.put(str, new AbstractMap.SimpleImmutableEntry(str2, l10));
                    }
                    ArrayList arrayList2 = new ArrayList(map3.values());
                    Collections.sort(arrayList2, b.f9213b);
                    map2.put((v) entry.getKey(), arrayList2);
                    arrayList.addAll(arrayList2);
                    map2.put(null, arrayList);
                }
                Collections.sort(arrayList, b.f9213b);
                break;
        }
    }

    public String a(long j10, v vVar) {
        Map map = (Map) this.f9245a.get(vVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j10));
        }
        return null;
    }
}
