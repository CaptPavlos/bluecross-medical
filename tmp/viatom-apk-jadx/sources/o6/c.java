package o6;

import androidx.lifecycle.ViewModel;
import c.h;
import d5.n;
import d9.g;
import d9.k;
import d9.s;
import d9.t;
import f6.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import k8.d;
import k8.f;
import kotlin.jvm.internal.l;
import o8.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f11746a;

    /* renamed from: b, reason: collision with root package name */
    public final i f11747b;

    /* renamed from: c, reason: collision with root package name */
    public final n f11748c;

    public c(m mVar, i iVar, n nVar) {
        this.f11746a = mVar;
        this.f11747b = iVar;
        this.f11748c = nVar;
    }

    public final s a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        n nVar = this.f11748c;
        nVar.i();
        if (((g) nVar.g).Q.length() == 0) {
            t tVar = (t) nVar.f;
            if (tVar == null) {
                l.i("translationsText");
                throw null;
            }
            str = tVar.f7584a.Q;
        } else {
            str = ((g) nVar.g).Q;
        }
        if (((g) nVar.g).A.length() == 0) {
            t tVar2 = (t) nVar.f;
            if (tVar2 == null) {
                l.i("translationsText");
                throw null;
            }
            str2 = tVar2.f7584a.A;
        } else {
            str2 = ((g) nVar.g).A;
        }
        if (((g) nVar.g).f7490c.length() == 0) {
            t tVar3 = (t) nVar.f;
            if (tVar3 == null) {
                l.i("translationsText");
                throw null;
            }
            str3 = tVar3.f7584a.f7490c;
        } else {
            str3 = ((g) nVar.g).f7490c;
        }
        if (((k) nVar.h).f7526b.length() == 0) {
            t tVar4 = (t) nVar.f;
            if (tVar4 == null) {
                l.i("translationsText");
                throw null;
            }
            str4 = tVar4.f7586c.f7526b;
        } else {
            str4 = ((k) nVar.h).f7526b;
        }
        if (((k) nVar.h).f7532l.length() == 0) {
            t tVar5 = (t) nVar.f;
            if (tVar5 == null) {
                l.i("translationsText");
                throw null;
            }
            str5 = tVar5.f7586c.f7532l;
        } else {
            str5 = ((k) nVar.h).f7532l;
        }
        String str6 = str3;
        String str7 = str5;
        return new s(str, str2, str6, str4, str7, nVar.b());
    }

    public final LinkedHashSet b(int i10) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayListC = c(i10);
        arrayListC.addAll(d(i10));
        int size = arrayListC.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayListC.get(i11);
            i11++;
            Boolean bool = ((h) obj).f965b;
            if (bool != null) {
                linkedHashSet.add(bool);
            }
        }
        return linkedHashSet;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList c(int i10) {
        int i11;
        int i12;
        LinkedHashMap linkedHashMap;
        int i13;
        Map map;
        k8.g gVar;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        m mVar = this.f11746a;
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
                k8.c cVar2 = mVar.f8097a;
                if (cVar2 != null && (map = cVar2.f10085i) != null && (gVar = (k8.g) map.get(String.valueOf(i10))) != null && (arrayList = gVar.f10092c) != null && arrayList.contains(Integer.valueOf(((f) entry2.getValue()).f10088a))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int i14 = ((f) entry3.getValue()).f10088a;
                k8.c cVar3 = mVar.f8097a;
                if (cVar3 == null || (linkedHashMap = cVar3.h) == null) {
                    i11 = 0;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        if (((k8.h) entry4.getValue()).f10098k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    Iterator it = linkedHashMap4.entrySet().iterator();
                    i11 = 0;
                    while (it.hasNext()) {
                        Set set = ((k8.h) ((Map.Entry) it.next()).getValue()).f10095d;
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
                        i11 += i13;
                    }
                }
                Iterator it3 = this.f11747b.f11815c.f11810a.iterator();
                while (it3.hasNext()) {
                    ArrayList arrayList3 = ((o8.g) it3.next()).f;
                    if (arrayList3.isEmpty()) {
                        i12 = 0;
                    } else {
                        int size = arrayList3.size();
                        i12 = 0;
                        int i15 = 0;
                        while (i15 < size) {
                            Object obj = arrayList3.get(i15);
                            i15++;
                            if (((Number) obj).intValue() == i14 && (i12 = i12 + 1) < 0) {
                                t6.m.T();
                                throw null;
                            }
                        }
                    }
                    i11 += i12;
                }
                if (i11 > 0) {
                    arrayList2.add(new h((d) entry3.getValue(), mVar.f8110r.get(((f) entry3.getValue()).f10088a), 0, 5, this.f11748c.f().f7566d, Integer.valueOf(i11), 20));
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    public final ArrayList d(int i10) {
        LinkedHashMap linkedHashMap;
        int i11;
        Map map;
        k8.g gVar;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        m mVar = this.f11746a;
        k8.c cVar = mVar.f8097a;
        if (cVar != null) {
            ?? r22 = cVar.g;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : r22.entrySet()) {
                if (mVar.f8109q.contains(((k8.b) entry.getValue()).f10088a)) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                k8.c cVar2 = mVar.f8097a;
                if (cVar2 != null && (map = cVar2.f10085i) != null && (gVar = (k8.g) map.get(String.valueOf(i10))) != null && (arrayList = gVar.f10093d) != null && arrayList.contains(Integer.valueOf(((k8.b) entry2.getValue()).f10088a))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int i12 = ((k8.b) entry3.getValue()).f10088a;
                k8.c cVar3 = mVar.f8097a;
                int i13 = 0;
                if (cVar3 != null && (linkedHashMap = cVar3.h) != null) {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        if (((k8.h) entry4.getValue()).f10098k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    Iterator it = linkedHashMap4.entrySet().iterator();
                    int i14 = 0;
                    while (it.hasNext()) {
                        Set set = ((k8.h) ((Map.Entry) it.next()).getValue()).f10096i;
                        if (set == null || !set.isEmpty()) {
                            Iterator it2 = set.iterator();
                            i11 = 0;
                            while (it2.hasNext()) {
                                if (((Number) it2.next()).intValue() == i12 && (i11 = i11 + 1) < 0) {
                                    t6.m.T();
                                    throw null;
                                }
                            }
                        } else {
                            i11 = 0;
                        }
                        i14 += i11;
                    }
                    i13 = i14;
                }
                if (i13 > 0) {
                    arrayList2.add(new h((d) entry3.getValue(), mVar.f8109q.get(((k8.b) entry3.getValue()).f10088a), 0, 8, this.f11748c.f().f7566d, Integer.valueOf(i13), 20));
                }
            }
        }
        return arrayList2;
    }
}
