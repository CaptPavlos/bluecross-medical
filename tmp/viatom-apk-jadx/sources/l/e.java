package l;

import androidx.constraintlayout.widget.R;
import androidx.lifecycle.ViewModel;
import d5.n;
import d9.j;
import d9.k;
import d9.t;
import f6.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import k8.f;
import o8.g;
import o8.h;
import o8.i;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class e extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f10156a;

    /* renamed from: b, reason: collision with root package name */
    public final i f10157b;

    /* renamed from: c, reason: collision with root package name */
    public final h f10158c;

    /* renamed from: d, reason: collision with root package name */
    public final n f10159d;
    public final k8.h e;
    public final Object f;
    public final Object g;
    public final Object h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f10160i;

    /* renamed from: j, reason: collision with root package name */
    public int f10161j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10162k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10163l;

    public e(m mVar, i iVar, h hVar, n nVar, k8.h hVar2, List list, List list2, List list3, List list4) {
        hVar.getClass();
        this.f10156a = mVar;
        this.f10157b = iVar;
        this.f10158c = hVar;
        this.f10159d = nVar;
        this.e = hVar2;
        this.f = list;
        this.g = list2;
        this.h = list3;
        this.f10160i = list4;
        this.f10161j = 1;
        this.f10163l = 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Iterable, java.lang.Object] */
    public final String a(Set set, int i10) {
        Set setU0;
        k8.d dVar;
        set.getClass();
        Map map = null;
        map = null;
        map = null;
        map = null;
        map = null;
        if (i10 == 0) {
            throw null;
        }
        int iC = c.i.c(i10);
        m mVar = this.f10156a;
        if (iC == 0) {
            setU0 = l.u0(this.f);
            k8.c cVar = mVar.f8097a;
            if (cVar != null) {
                map = cVar.f10084d;
            }
        } else if (iC == 1) {
            setU0 = l.u0(this.g);
            k8.c cVar2 = mVar.f8097a;
            if (cVar2 != null) {
                map = cVar2.e;
            }
        } else if (iC == 2) {
            setU0 = l.u0(this.h);
            k8.c cVar3 = mVar.f8097a;
            if (cVar3 != null) {
                map = cVar3.f;
            }
        } else if (iC == 3) {
            setU0 = l.u0(this.f10160i);
            k8.c cVar4 = mVar.f8097a;
            if (cVar4 != null) {
                map = cVar4.g;
            }
        } else {
            if (iC != 4) {
                androidx.window.layout.c.b();
                return null;
            }
            setU0 = l.u0(set);
            k8.c cVar5 = mVar.f8097a;
            if (cVar5 != null) {
                map = cVar5.f10086j;
            }
        }
        TreeSet treeSet = new TreeSet();
        l.p0(set, treeSet);
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (setU0.contains((Integer) next)) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        String string = "";
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            Integer num = (Integer) obj;
            if (map != null && (dVar = (k8.d) map.get(String.valueOf(num))) != null) {
                StringBuilder sbV = a3.a.v(string);
                sbV.append(String.format("• %s.", Arrays.copyOf(new Object[]{dVar.f10089b}, 1)));
                sbV.append('\n');
                string = sbV.toString();
            }
        }
        return string;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList b(String str) {
        ArrayList arrayListF;
        c.h hVar;
        boolean z9;
        Set set;
        int i10;
        int i11;
        k8.c cVar;
        LinkedHashMap linkedHashMap;
        int i12;
        int i13;
        int i14;
        Set set2;
        str.getClass();
        int iC = c.i.c(this.f10161j);
        int i15 = 2;
        k8.h hVar2 = this.e;
        m mVar = this.f10156a;
        int i16 = 0;
        if (iC != 0) {
            arrayListF = iC != 1 ? iC != 2 ? new ArrayList() : f() : d();
        } else {
            arrayListF = f();
            arrayListF.addAll(d());
            if ((hVar2 == null ? null : hVar2.e) == null || hVar2.e.isEmpty()) {
                hVar = null;
            } else {
                k8.h hVar3 = this.e;
                if (hVar3 == null || (set = hVar3.e) == null) {
                    z9 = true;
                    hVar = new c.h(hVar3, Boolean.valueOf(z9), 0, 4, null, null, R.styleable.ConstraintSet_pathMotionArc);
                } else {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        if (!kotlin.jvm.internal.l.a(mVar.f8114w.get(((Number) it.next()).intValue()), Boolean.TRUE)) {
                            z9 = false;
                            break;
                        }
                    }
                    z9 = true;
                    hVar = new c.h(hVar3, Boolean.valueOf(z9), 0, 4, null, null, R.styleable.ConstraintSet_pathMotionArc);
                }
            }
            if (hVar != null) {
                arrayListF.add(0, hVar);
            }
        }
        arrayListF.add(0, new c.h(null, null, 3, 0, e().h, null, 91));
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new c.h(null, null, 3, 0, e().g, null, 91));
        LinkedHashMap linkedHashMapG = g();
        if (linkedHashMapG == null) {
            i11 = 0;
            i10 = 5;
        } else {
            for (Map.Entry entry : linkedHashMapG.entrySet()) {
                int i17 = ((f) entry.getValue()).f10088a;
                int i18 = this.f10161j;
                if (!(i18 == 1 || i18 == i15) || (cVar = mVar.f8097a) == null || (linkedHashMap = cVar.h) == null) {
                    i12 = i16;
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        if (((k8.h) entry2.getValue()).f10098k == null) {
                            linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    Iterator it2 = linkedHashMap2.entrySet().iterator();
                    i12 = i16;
                    while (it2.hasNext()) {
                        Set set3 = ((k8.h) ((Map.Entry) it2.next()).getValue()).e;
                        if (set3 == null || !set3.isEmpty()) {
                            Iterator it3 = set3.iterator();
                            i13 = i16;
                            while (it3.hasNext()) {
                                if (((Number) it3.next()).intValue() == i17 && (i13 = i13 + 1) < 0) {
                                    t6.m.T();
                                    throw null;
                                }
                            }
                        } else {
                            i13 = i16;
                        }
                        i12 += i13;
                    }
                }
                int i19 = this.f10161j;
                if (i19 == 1 || i19 == 3) {
                    Iterator it4 = this.f10157b.f11815c.f11810a.iterator();
                    while (it4.hasNext()) {
                        ArrayList arrayList2 = ((g) it4.next()).g;
                        if (arrayList2.isEmpty()) {
                            i14 = i16;
                        } else {
                            int size = arrayList2.size();
                            int i20 = i16;
                            i14 = i20;
                            while (i20 < size) {
                                Object obj = arrayList2.get(i20);
                                i20++;
                                if (((Number) obj).intValue() == i17 && (i14 = i14 + 1) < 0) {
                                    t6.m.T();
                                    throw null;
                                }
                            }
                        }
                        i12 += i14;
                        i16 = 0;
                    }
                }
                if (this.f10161j == 1 && hVar2 != null && (set2 = hVar2.e) != null && set2.contains(Integer.valueOf(i17))) {
                    i12++;
                }
                if (i12 > 0) {
                    arrayList.add(new c.h((k8.d) entry.getValue(), mVar.f8111s.get(((f) entry.getValue()).f10088a), 0, 5, this.f10159d.f().f7566d, Integer.valueOf(i12), 4));
                }
                i15 = 2;
                i16 = 0;
            }
            i10 = 5;
            i11 = i16;
        }
        arrayListF.addAll(i11, arrayList);
        if (str.length() <= 0) {
            return arrayListF;
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayListF.size();
        int i21 = i11;
        while (i21 < size2) {
            Object obj2 = arrayListF.get(i21);
            i21++;
            c.h hVar4 = (c.h) obj2;
            if (hVar4.f967d != i10 && o7.m.d0(hVar4.f964a.f10089b, str, true)) {
                arrayList3.add(obj2);
            }
        }
        return new ArrayList(arrayList3);
    }

    public final LinkedHashSet c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayListB = b("");
        int size = arrayListB.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListB.get(i10);
            i10++;
            Boolean bool = ((c.h) obj).f965b;
            if (bool != null) {
                linkedHashSet.add(bool);
            }
        }
        return linkedHashSet;
    }

    public final ArrayList d() {
        LinkedHashMap linkedHashMap;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f10156a;
        k8.c cVar = mVar.f8097a;
        if (cVar != null && (linkedHashMap = cVar.h) != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((k8.h) entry.getValue()).f10098k == null) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                if (!((k8.h) entry2.getValue()).e.isEmpty()) {
                    arrayList.add(new c.h((k8.d) entry2.getValue(), mVar.C.get(((k8.h) entry2.getValue()).f10088a), 0, 0, null, null, 124));
                }
            }
        }
        return arrayList;
    }

    public final j e() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        n nVar = this.f10159d;
        nVar.i();
        if (((d9.g) nVar.g).f7501r.length() == 0) {
            t tVar = (t) nVar.f;
            if (tVar == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str = tVar.f7584a.f7501r;
        } else {
            str = ((d9.g) nVar.g).f7501r;
        }
        if (((d9.g) nVar.g).G.length() == 0) {
            t tVar2 = (t) nVar.f;
            if (tVar2 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str2 = tVar2.f7584a.G;
        } else {
            str2 = ((d9.g) nVar.g).G;
        }
        if (((d9.g) nVar.g).K.length() == 0) {
            t tVar3 = (t) nVar.f;
            if (tVar3 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str3 = tVar3.f7584a.K;
        } else {
            str3 = ((d9.g) nVar.g).K;
        }
        if (((d9.g) nVar.g).L.length() == 0) {
            t tVar4 = (t) nVar.f;
            if (tVar4 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str4 = tVar4.f7584a.L;
        } else {
            str4 = ((d9.g) nVar.g).L;
        }
        if (((d9.g) nVar.g).M.length() == 0) {
            t tVar5 = (t) nVar.f;
            if (tVar5 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str5 = tVar5.f7584a.M;
        } else {
            str5 = ((d9.g) nVar.g).M;
        }
        if (((k) nVar.h).f7526b.length() == 0) {
            t tVar6 = (t) nVar.f;
            if (tVar6 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str6 = tVar6.f7586c.f7526b;
        } else {
            str6 = ((k) nVar.h).f7526b;
        }
        if (((d9.g) nVar.g).Q.length() == 0) {
            t tVar7 = (t) nVar.f;
            if (tVar7 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str7 = tVar7.f7584a.Q;
        } else {
            str7 = ((d9.g) nVar.g).Q;
        }
        if (((d9.g) nVar.g).f7500q.length() == 0) {
            t tVar8 = (t) nVar.f;
            if (tVar8 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str8 = tVar8.f7584a.f7500q;
        } else {
            str8 = ((d9.g) nVar.g).f7500q;
        }
        if (((k) nVar.h).f7528d.length() == 0) {
            t tVar9 = (t) nVar.f;
            if (tVar9 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str9 = tVar9.f7586c.f7528d;
        } else {
            str9 = ((k) nVar.h).f7528d;
        }
        if (((k) nVar.h).e.length() == 0) {
            t tVar10 = (t) nVar.f;
            if (tVar10 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str10 = tVar10.f7586c.e;
        } else {
            str10 = ((k) nVar.h).e;
        }
        String str11 = str8;
        String str12 = str10;
        return new j(str, str2, str3, str4, str5, str6, str7, str11, str9, str12, nVar.b());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList f() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.f10158c.f11810a) {
            if (!gVar.g.isEmpty()) {
                arrayList.add(new c.h(gVar.a(), this.f10156a.D.get(gVar.f11806a), 0, 2, null, null, R.styleable.ConstraintSet_pathMotionArc));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Map] */
    public final LinkedHashMap g() {
        m mVar = this.f10156a;
        k8.c cVar = mVar.f8097a;
        if (cVar == null) {
            return null;
        }
        ?? r12 = cVar.f10084d;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : r12.entrySet()) {
            if (mVar.f8111s.contains(((f) entry.getValue()).f10088a)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (mVar.h.equals("DE")) {
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((f) entry2.getValue()).f10088a != 1) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap2;
    }
}
