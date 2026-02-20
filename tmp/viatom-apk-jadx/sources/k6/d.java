package k6;

import androidx.constraintlayout.widget.R;
import androidx.lifecycle.ViewModel;
import d5.n;
import f6.e;
import f6.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import k8.h;
import o8.g;
import o8.i;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final n f10071a;

    /* renamed from: b, reason: collision with root package name */
    public final m f10072b;

    /* renamed from: c, reason: collision with root package name */
    public final i f10073c;

    /* renamed from: d, reason: collision with root package name */
    public final f6.d f10074d;
    public final h e;
    public final Object f;
    public final Object g;
    public final Object h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f10075i;

    /* renamed from: j, reason: collision with root package name */
    public int f10076j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10077k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10078l;

    public d(n nVar, m mVar, i iVar, f6.d dVar, h hVar, List list, List list2, List list3, List list4) {
        dVar.getClass();
        this.f10071a = nVar;
        this.f10072b = mVar;
        this.f10073c = iVar;
        this.f10074d = dVar;
        this.e = hVar;
        this.f = list;
        this.g = list2;
        this.h = list3;
        this.f10075i = list4;
        this.f10076j = 1;
        this.f10078l = 3;
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
        m mVar = this.f10072b;
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
            setU0 = l.u0(this.f10075i);
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

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f10074d.f8073a.entrySet()) {
            m mVar = this.f10072b;
            if (mVar.B.get(((e) entry.getValue()).f8074a) != null) {
                e eVar = (e) entry.getValue();
                arrayList.add(new c.h(new h(eVar.f8074a, eVar.f8075b, null, null, null, null, null, null, null, eVar.f8076c, null, 0, null, null, null, null, null, 914940), mVar.B.get(((e) entry.getValue()).f8074a), 0, 3, null, null, R.styleable.ConstraintSet_pathMotionArc));
            }
        }
        return arrayList;
    }

    public final ArrayList c(String str) {
        ArrayList arrayListE;
        boolean z9;
        c.h hVar;
        str.getClass();
        int iC = c.i.c(this.f10076j);
        int i10 = 0;
        if (iC == 0) {
            arrayListE = e();
            arrayListE.addAll(d());
            arrayListE.addAll(b());
            h hVar2 = this.e;
            if (hVar2 == null) {
                hVar = null;
            } else {
                Set set = hVar2.f10095d;
                if (set == null) {
                    z9 = true;
                    hVar = new c.h(hVar2, Boolean.valueOf(z9), 0, 4, null, null, R.styleable.ConstraintSet_pathMotionArc);
                } else {
                    Iterator it = l.u0(set).iterator();
                    while (it.hasNext()) {
                        if (!kotlin.jvm.internal.l.a(this.f10072b.f8113v.get(((Number) it.next()).intValue()), Boolean.TRUE)) {
                            z9 = false;
                            break;
                        }
                    }
                    z9 = true;
                    hVar = new c.h(hVar2, Boolean.valueOf(z9), 0, 4, null, null, R.styleable.ConstraintSet_pathMotionArc);
                }
            }
            if (hVar != null) {
                arrayListE.add(0, hVar);
            }
        } else if (iC == 1) {
            arrayListE = d();
        } else if (iC == 2) {
            arrayListE = e();
        } else {
            if (iC != 3) {
                androidx.window.layout.c.b();
                return null;
            }
            arrayListE = b();
        }
        arrayListE.add(0, new c.h(null, null, 3, 0, this.f10071a.f().f7566d, null, 91));
        ArrayList arrayList = new ArrayList();
        int size = arrayListE.size();
        while (i10 < size) {
            Object obj = arrayListE.get(i10);
            i10++;
            if (o7.m.d0(((c.h) obj).f964a.f10089b, str, true)) {
                arrayList.add(obj);
            }
        }
        return new ArrayList(arrayList);
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, java.util.List] */
    public final ArrayList d() {
        LinkedHashMap linkedHashMap;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f10072b;
        k8.c cVar = mVar.f8097a;
        if (cVar != null && (linkedHashMap = cVar.h) != null) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (mVar.f8116z.get(((h) entry.getValue()).f10088a) != null) {
                    Set set = ((h) entry.getValue()).f10095d;
                    ?? r6 = this.f10073c.f11814b.h;
                    if (set == null || !set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            if (r6.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                                arrayList.add(new c.h((k8.d) entry.getValue(), mVar.f8116z.get(((h) entry.getValue()).f10088a), 0, 0, null, null, 124));
                                break;
                            }
                        }
                    }
                    arrayList.add(new c.h((k8.d) entry.getValue(), null, 0, 0, null, null, 124));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.f10073c.f11815c.f11810a) {
            m mVar = this.f10072b;
            if (mVar.A.get(gVar.f11806a) != null) {
                arrayList.add(new c.h(gVar.a(), mVar.A.get(gVar.f11806a), 0, 2, null, null, R.styleable.ConstraintSet_pathMotionArc));
            }
        }
        return arrayList;
    }
}
