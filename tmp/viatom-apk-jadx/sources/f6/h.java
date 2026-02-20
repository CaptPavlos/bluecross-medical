package f6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import t6.t;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public Object f8081a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8082b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f8083c;

    /* renamed from: d, reason: collision with root package name */
    public k8.c f8084d;

    public h(k8.c cVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        t tVar = t.f12808a;
        this.f8081a = tVar;
        this.f8082b = tVar;
        this.f8083c = linkedHashMap;
        this.f8084d = cVar;
    }

    public final void a(int i10, g gVar) throws h6.e {
        i iVar = gVar.f8080b;
        int i11 = gVar.f8079a;
        k8.c cVar = this.f8084d;
        if (cVar != null) {
            k8.h hVar = (k8.h) cVar.h.get(String.valueOf(i10));
            if (hVar == null) {
                return;
            }
            Set set = hVar.f10095d;
            Set set2 = hVar.e;
            Set set3 = hVar.f;
            if (iVar == i.NOT_ALLOWED) {
                if (!set2.contains(Integer.valueOf(i11)) && !set.contains(Integer.valueOf(i11))) {
                    return;
                }
            } else if (!set3.isEmpty()) {
                int iOrdinal = iVar.ordinal();
                if (iOrdinal != 1) {
                    if (iOrdinal != 2 || !set3.contains(Integer.valueOf(i11)) || !set.contains(Integer.valueOf(i11))) {
                        return;
                    }
                } else if (!set3.contains(Integer.valueOf(i11)) || !set2.contains(Integer.valueOf(i11))) {
                    return;
                }
            }
        }
        String strA = gVar.a();
        LinkedHashMap linkedHashMap = this.f8083c;
        if (!linkedHashMap.containsKey(strA)) {
            linkedHashMap.put(strA, new LinkedHashSet());
        }
        Integer numValueOf = Integer.valueOf(i10);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Set) entry.getValue()).contains(numValueOf)) {
                arrayList.add(t1.a((String) entry.getKey()));
            }
        }
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            g gVar2 = (g) obj;
            if (gVar2.f8079a == i11) {
                String strA2 = gVar2.a();
                Set set4 = (Set) linkedHashMap.get(strA2);
                if (set4 != null) {
                    set4.remove(Integer.valueOf(i10));
                    if (set4.isEmpty()) {
                        linkedHashMap.remove(strA2);
                    }
                }
            }
        }
        Set set5 = (Set) linkedHashMap.get(strA);
        if (set5 == null) {
            return;
        }
        set5.add(Integer.valueOf(i10));
    }
}
