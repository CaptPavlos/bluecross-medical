package e6;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import d5.n;
import f6.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k8.f;
import k8.g;
import k8.h;
import kotlin.jvm.internal.l;
import o8.i;
import t6.v;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f7939a;

    /* renamed from: b, reason: collision with root package name */
    public final i f7940b;

    /* renamed from: c, reason: collision with root package name */
    public final f6.d f7941c;

    /* renamed from: d, reason: collision with root package name */
    public final h f7942d;
    public final r e;
    public final n f;
    public final List g;
    public final Object h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f7943i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f7944j;

    /* renamed from: k, reason: collision with root package name */
    public final n6.c f7945k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7946l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedHashSet f7947m;

    /* renamed from: n, reason: collision with root package name */
    public final LinkedHashSet f7948n;

    /* renamed from: o, reason: collision with root package name */
    public final MutableLiveData f7949o;

    public d(m mVar, i iVar, f6.d dVar, h hVar, r rVar, n nVar, ArrayList arrayList, List list, List list2, List list3, n6.c cVar) {
        dVar.getClass();
        arrayList.getClass();
        this.f7939a = mVar;
        this.f7940b = iVar;
        this.f7941c = dVar;
        this.f7942d = hVar;
        this.e = rVar;
        this.f = nVar;
        this.g = arrayList;
        this.h = list;
        this.f7943i = list2;
        this.f7944j = list3;
        this.f7945k = cVar;
        this.f7946l = 2;
        this.f7947m = new LinkedHashSet();
        this.f7948n = new LinkedHashSet();
        this.f7949o = new MutableLiveData();
    }

    public final c.h a(String str, Set set, int i10) {
        h hVar;
        if (str.equals("ALL_VENDORS") && (hVar = this.f7942d) != null && set.contains(Integer.valueOf(i10))) {
            return new c.h(hVar, null, 4, 10, hVar.f10089b, null, 82);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList b() {
        int i10;
        int i11;
        LinkedHashMap linkedHashMap;
        int i12;
        Map map;
        g gVar;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f7939a;
        k8.c cVar = mVar.f8097a;
        if (cVar != null) {
            ?? r32 = cVar.f10084d;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : r32.entrySet()) {
                if (mVar.f8110r.contains(((f) entry.getValue()).f10088a)) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                LinkedHashSet linkedHashSet = this.f7947m;
                if (linkedHashSet == null || linkedHashSet.isEmpty()) {
                    Iterator it = this.f7944j.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        k8.c cVar2 = mVar.f8097a;
                        Collection collection = (cVar2 == null || (map = cVar2.f10085i) == null || (gVar = (g) map.get(String.valueOf(iIntValue))) == null) ? null : gVar.f10092c;
                        if (collection == null) {
                            collection = v.f12810a;
                        }
                        linkedHashSet.addAll(collection);
                    }
                }
                if (!linkedHashSet.contains(Integer.valueOf(((f) entry2.getValue()).f10088a))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int i13 = ((f) entry3.getValue()).f10088a;
                k8.c cVar3 = mVar.f8097a;
                if (cVar3 == null || (linkedHashMap = cVar3.h) == null) {
                    i10 = 0;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        if (((h) entry4.getValue()).f10098k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    Iterator it2 = linkedHashMap4.entrySet().iterator();
                    i10 = 0;
                    while (it2.hasNext()) {
                        Set set = ((h) ((Map.Entry) it2.next()).getValue()).f10095d;
                        if (set == null || !set.isEmpty()) {
                            Iterator it3 = set.iterator();
                            i12 = 0;
                            while (it3.hasNext()) {
                                if (((Number) it3.next()).intValue() == i13 && (i12 = i12 + 1) < 0) {
                                    t6.m.T();
                                    throw null;
                                }
                            }
                        } else {
                            i12 = 0;
                        }
                        i10 += i12;
                    }
                }
                i iVar = this.f7940b;
                Iterator it4 = iVar.f11815c.f11810a.iterator();
                while (it4.hasNext()) {
                    ArrayList arrayList2 = ((o8.g) it4.next()).f;
                    if (arrayList2.isEmpty()) {
                        i11 = 0;
                    } else {
                        int size = arrayList2.size();
                        i11 = 0;
                        int i14 = 0;
                        while (i14 < size) {
                            Object obj = arrayList2.get(i14);
                            i14++;
                            if (((Number) obj).intValue() == i13 && (i11 = i11 + 1) < 0) {
                                t6.m.T();
                                throw null;
                            }
                        }
                    }
                    i10 += i11;
                }
                Iterator it5 = iVar.f11814b.f11792s.iterator();
                while (it5.hasNext()) {
                    if (((Number) it5.next()).intValue() == i13) {
                        i10++;
                    }
                }
                if (i10 > 0) {
                    arrayList.add(new c.h((k8.d) entry3.getValue(), mVar.f8110r.get(((f) entry3.getValue()).f10088a), 0, 5, this.f.f().f7566d, Integer.valueOf(i10), 20));
                }
            }
        }
        arrayList.addAll(c());
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList c() {
        LinkedHashMap linkedHashMap;
        int i10;
        Map map;
        g gVar;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f7939a;
        k8.c cVar = mVar.f8097a;
        if (cVar != null) {
            ?? r32 = cVar.g;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : r32.entrySet()) {
                if (mVar.f8109q.contains(((k8.b) entry.getValue()).f10088a)) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                LinkedHashSet linkedHashSet = this.f7948n;
                if (linkedHashSet == null || linkedHashSet.isEmpty()) {
                    Iterator it = this.f7944j.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        k8.c cVar2 = mVar.f8097a;
                        Collection collection = (cVar2 == null || (map = cVar2.f10085i) == null || (gVar = (g) map.get(String.valueOf(iIntValue))) == null) ? null : gVar.f10093d;
                        if (collection == null) {
                            collection = v.f12810a;
                        }
                        linkedHashSet.addAll(collection);
                    }
                }
                if (!linkedHashSet.contains(Integer.valueOf(((k8.b) entry2.getValue()).f10088a))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int i11 = ((k8.b) entry3.getValue()).f10088a;
                k8.c cVar3 = mVar.f8097a;
                int i12 = 0;
                if (cVar3 != null && (linkedHashMap = cVar3.h) != null) {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        if (((h) entry4.getValue()).f10098k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    Iterator it2 = linkedHashMap4.entrySet().iterator();
                    int i13 = 0;
                    while (it2.hasNext()) {
                        Set set = ((h) ((Map.Entry) it2.next()).getValue()).f10096i;
                        if (set == null || !set.isEmpty()) {
                            Iterator it3 = set.iterator();
                            i10 = 0;
                            while (it3.hasNext()) {
                                if (((Number) it3.next()).intValue() == i11 && (i10 = i10 + 1) < 0) {
                                    t6.m.T();
                                    throw null;
                                }
                            }
                        } else {
                            i10 = 0;
                        }
                        i13 += i10;
                    }
                    i12 = i13;
                }
                Iterator it4 = this.f7940b.f11814b.f11795w.iterator();
                while (it4.hasNext()) {
                    if (((Number) it4.next()).intValue() == i11) {
                        i12++;
                    }
                }
                if (i12 > 0) {
                    arrayList.add(new c.h((k8.d) entry3.getValue(), mVar.f8109q.get(((k8.b) entry3.getValue()).f10088a), 0, 8, this.f.f().f7566d, Integer.valueOf(i12), 20));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r10v23, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v27, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, java.util.Map] */
    public final ArrayList d() {
        int i10;
        LinkedHashMap linkedHashMap;
        int i11;
        int i12;
        LinkedHashMap linkedHashMap2;
        int i13;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f7939a;
        k8.c cVar = mVar.f8097a;
        n nVar = this.f;
        i iVar = this.f7940b;
        if (cVar != null) {
            ?? r32 = cVar.e;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry : r32.entrySet()) {
                if (this.h.contains(Integer.valueOf(((f) entry.getValue()).f10088a)) || iVar.f11814b.f11793u.contains(Integer.valueOf(((f) entry.getValue()).f10088a))) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                int i14 = ((f) entry2.getValue()).f10088a;
                k8.c cVar2 = mVar.f8097a;
                if (cVar2 == null || (linkedHashMap2 = cVar2.h) == null) {
                    i12 = 0;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                        if (((h) entry3.getValue()).f10098k == null) {
                            linkedHashMap4.put(entry3.getKey(), entry3.getValue());
                        }
                    }
                    Iterator it = linkedHashMap4.entrySet().iterator();
                    i12 = 0;
                    while (it.hasNext()) {
                        Set set = ((h) ((Map.Entry) it.next()).getValue()).g;
                        if (set == null || !set.isEmpty()) {
                            Iterator it2 = set.iterator();
                            i13 = 0;
                            while (it2.hasNext()) {
                                if (((Number) it2.next()).intValue() == i14 && (i13 = i13 + 1) < 0) {
                                    t6.m.T();
                                    throw null;
                                }
                            }
                        } else {
                            i13 = 0;
                        }
                        i12 += i13;
                    }
                }
                Iterator it3 = iVar.f11814b.f11793u.iterator();
                while (it3.hasNext()) {
                    if (((Number) it3.next()).intValue() == i14) {
                        i12++;
                    }
                }
                if (i12 > 0) {
                    arrayList.add(new c.h((k8.d) entry2.getValue(), null, 0, 6, nVar.f().f7566d, Integer.valueOf(i12), 22));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        k8.c cVar3 = mVar.f8097a;
        if (cVar3 != null) {
            ?? r82 = cVar3.f;
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            for (Map.Entry entry4 : r82.entrySet()) {
                if (this.f7943i.contains(Integer.valueOf(((k8.b) entry4.getValue()).f10088a)) || iVar.f11814b.f11794v.contains(Integer.valueOf(((k8.b) entry4.getValue()).f10088a))) {
                    linkedHashMap5.put(entry4.getKey(), entry4.getValue());
                }
            }
            for (Map.Entry entry5 : linkedHashMap5.entrySet()) {
                int i15 = ((k8.b) entry5.getValue()).f10088a;
                k8.c cVar4 = mVar.f8097a;
                if (cVar4 == null || (linkedHashMap = cVar4.h) == null) {
                    i10 = 0;
                } else {
                    LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                    for (Map.Entry entry6 : linkedHashMap.entrySet()) {
                        if (((h) entry6.getValue()).f10098k == null) {
                            linkedHashMap6.put(entry6.getKey(), entry6.getValue());
                        }
                    }
                    Iterator it4 = linkedHashMap6.entrySet().iterator();
                    i10 = 0;
                    while (it4.hasNext()) {
                        Set set2 = ((h) ((Map.Entry) it4.next()).getValue()).h;
                        if (set2 == null || !set2.isEmpty()) {
                            Iterator it5 = set2.iterator();
                            i11 = 0;
                            while (it5.hasNext()) {
                                if (((Number) it5.next()).intValue() == i15 && (i11 = i11 + 1) < 0) {
                                    t6.m.T();
                                    throw null;
                                }
                            }
                        } else {
                            i11 = 0;
                        }
                        i10 += i11;
                    }
                }
                Iterator it6 = iVar.f11814b.f11794v.iterator();
                while (it6.hasNext()) {
                    if (((Number) it6.next()).intValue() == i15) {
                        i10++;
                    }
                }
                if (i10 > 0) {
                    arrayList2.add(new c.h((k8.d) entry5.getValue(), null, 0, 7, nVar.f().f7566d, Integer.valueOf(i10), 22));
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object, java.util.List] */
    public final ArrayList e() {
        Map map;
        Map map2;
        g gVar;
        LinkedHashMap linkedHashMap;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f7939a;
        k8.c cVar = mVar.f8097a;
        if (cVar != null && (map = cVar.f10085i) != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f7944j.contains(Integer.valueOf(((g) entry.getValue()).f10088a))) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                ArrayList arrayList2 = ((g) entry2.getValue()).f10092c;
                int size = arrayList2.size();
                boolean z9 = false;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList2.get(i10);
                    i10++;
                    int iIntValue = ((Number) obj).intValue();
                    k8.c cVar2 = mVar.f8097a;
                    if (cVar2 != null && (linkedHashMap = cVar2.h) != null) {
                        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                            if (((h) entry3.getValue()).f10098k == null && ((h) entry3.getValue()).f10095d.contains(Integer.valueOf(iIntValue))) {
                                z9 = true;
                            }
                        }
                    }
                }
                if (z9) {
                    int i11 = ((g) entry2.getValue()).f10088a;
                    String str = ((g) entry2.getValue()).f10089b;
                    int i12 = ((g) entry2.getValue()).f10088a;
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    k8.c cVar3 = mVar.f8097a;
                    if (cVar3 != null && (map2 = cVar3.f10085i) != null && (gVar = (g) map2.get(String.valueOf(i12))) != null) {
                        ArrayList arrayList3 = gVar.f10092c;
                        ArrayList arrayList4 = new ArrayList();
                        int size2 = arrayList3.size();
                        int i13 = 0;
                        while (i13 < size2) {
                            Object obj2 = arrayList3.get(i13);
                            i13++;
                            if (mVar.f8110r.contains(((Number) obj2).intValue())) {
                                arrayList4.add(obj2);
                            }
                        }
                        int size3 = arrayList4.size();
                        int i14 = 0;
                        while (i14 < size3) {
                            Object obj3 = arrayList4.get(i14);
                            i14++;
                            Boolean bool = mVar.f8110r.get(((Number) obj3).intValue());
                            linkedHashSet.add(Boolean.valueOf(bool == null ? false : bool.booleanValue()));
                        }
                        ArrayList arrayList5 = gVar.f10093d;
                        ArrayList arrayList6 = new ArrayList();
                        int size4 = arrayList5.size();
                        int i15 = 0;
                        while (i15 < size4) {
                            Object obj4 = arrayList5.get(i15);
                            i15++;
                            if (mVar.f8109q.contains(((Number) obj4).intValue())) {
                                arrayList6.add(obj4);
                            }
                        }
                        int size5 = arrayList6.size();
                        int i16 = 0;
                        while (i16 < size5) {
                            Object obj5 = arrayList6.get(i16);
                            i16++;
                            Boolean bool2 = mVar.f8109q.get(((Number) obj5).intValue());
                            linkedHashSet.add(Boolean.valueOf(bool2 == null ? false : bool2.booleanValue()));
                        }
                    }
                    Boolean bool3 = Boolean.TRUE;
                    boolean zContains = linkedHashSet.contains(bool3);
                    n nVar = this.f;
                    arrayList.add(new d9.r(str, i11, (zContains && linkedHashSet.contains(Boolean.FALSE)) ? nVar.e().f7544l : linkedHashSet.contains(bool3) ? nVar.e().f7545m : nVar.e().f7543k));
                }
            }
        }
        return arrayList;
    }

    public final void f() {
        String str = this.f7940b.f11814b.I;
        PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
        boolean zA = l.a(str, privacyEncodingMode.getValue());
        r rVar = this.e;
        if (zA) {
            rVar.i(privacyEncodingMode, true, true);
            return;
        }
        PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
        if (l.a(str, privacyEncodingMode2.getValue())) {
            rVar.i(privacyEncodingMode2, true, true);
        } else {
            rVar.i(PrivacyEncodingMode.TCF_AND_GPP, true, true);
        }
    }
}
