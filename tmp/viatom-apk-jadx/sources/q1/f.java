package q1;

import android.util.Log;
import c1.d0;
import com.google.android.gms.internal.measurement.a4;
import com.google.firebase.components.ComponentRegistrar;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements b, i2.a {
    public static final e h = new e(0);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f12226a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12227b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f12228c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f12229d;
    public final k e;
    public final AtomicReference f;
    public final d0 g;

    public f(ArrayList arrayList, ArrayList arrayList2, d0 d0Var) {
        r1.k kVar = r1.k.f12340a;
        this.f12226a = new HashMap();
        this.f12227b = new HashMap();
        this.f12228c = new HashMap();
        this.f12229d = new HashSet();
        this.f = new AtomicReference();
        k kVar2 = new k();
        this.e = kVar2;
        this.g = d0Var;
        ArrayList arrayList3 = new ArrayList();
        int i10 = 2;
        int i11 = 0;
        arrayList3.add(a.c(kVar2, k.class, n2.c.class, n2.b.class));
        arrayList3.add(a.c(this, i2.a.class, new Class[0]));
        int size = arrayList2.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList2.get(i12);
            i12++;
            a aVar = (a) obj;
            if (aVar != null) {
                arrayList3.add(aVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i13 = 0;
        while (i13 < size2) {
            Object obj2 = arrayList.get(i13);
            i13++;
            arrayList4.add(obj2);
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((q2.b) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.g.t(componentRegistrar));
                        it.remove();
                    }
                } catch (l e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                Object[] array = ((a) it2.next()).f12220b.toArray();
                int length = array.length;
                int i14 = 0;
                while (true) {
                    if (i14 < length) {
                        Object obj3 = array[i14];
                        if (obj3.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f12229d.contains(obj3.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f12229d.add(obj3.toString());
                        }
                        i14++;
                    }
                }
            }
            if (this.f12226a.isEmpty()) {
                a.a.w(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f12226a.keySet());
                arrayList6.addAll(arrayList3);
                a.a.w(arrayList6);
            }
            int size3 = arrayList3.size();
            int i15 = 0;
            while (i15 < size3) {
                Object obj4 = arrayList3.get(i15);
                i15++;
                a aVar2 = (a) obj4;
                this.f12226a.put(aVar2, new m(new l1.c(i10, this, aVar2)));
            }
            arrayList5.addAll(i(arrayList3));
            arrayList5.addAll(j());
            h();
        }
        int size4 = arrayList5.size();
        while (i11 < size4) {
            Object obj5 = arrayList5.get(i11);
            i11++;
            ((Runnable) obj5).run();
        }
        Boolean bool = (Boolean) this.f.get();
        if (bool != null) {
            g(this.f12226a, bool.booleanValue());
        }
    }

    @Override // q1.b
    public final Object a(Class cls) {
        return f(q.a(cls));
    }

    @Override // q1.b
    public final o b(q qVar) {
        q2.b bVarD = d(qVar);
        return bVarD == null ? new o(o.f12246c, o.f12247d) : bVarD instanceof o ? (o) bVarD : new o(null, bVarD);
    }

    @Override // q1.b
    public final q2.b c(Class cls) {
        return d(q.a(cls));
    }

    @Override // q1.b
    public final synchronized q2.b d(q qVar) {
        a4.i(qVar, "Null interface requested.");
        return (q2.b) this.f12227b.get(qVar);
    }

    @Override // q1.b
    public final Set e(q qVar) {
        q2.b bVar;
        synchronized (this) {
            bVar = (n) this.f12228c.get(qVar);
            if (bVar == null) {
                bVar = h;
            }
        }
        return (Set) bVar.get();
    }

    @Override // q1.b
    public final Object f(q qVar) {
        q2.b bVarD = d(qVar);
        if (bVarD == null) {
            return null;
        }
        return bVarD.get();
    }

    public final void g(HashMap map, boolean z9) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            a aVar = (a) entry.getKey();
            q2.b bVar = (q2.b) entry.getValue();
            int i10 = aVar.f12222d;
            if (i10 == 1 || (i10 == 2 && z9)) {
                bVar.get();
            }
        }
        k kVar = this.e;
        synchronized (kVar) {
            try {
                arrayDeque = kVar.f12239b;
                if (arrayDeque != null) {
                    kVar.f12239b = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                com.google.gson.internal.a.k();
            }
        }
    }

    public final void h() {
        HashMap map = this.f12227b;
        HashMap map2 = this.f12228c;
        for (a aVar : this.f12226a.keySet()) {
            for (i iVar : aVar.f12221c) {
                boolean z9 = iVar.f12236b == 2;
                q qVar = iVar.f12235a;
                if (z9 && !map2.containsKey(qVar)) {
                    Set set = Collections.EMPTY_SET;
                    n nVar = new n();
                    nVar.f12245b = null;
                    nVar.f12244a = Collections.newSetFromMap(new ConcurrentHashMap());
                    nVar.f12244a.addAll(set);
                    map2.put(qVar, nVar);
                } else if (map.containsKey(qVar)) {
                    continue;
                } else {
                    int i10 = iVar.f12236b;
                    if (i10 == 1) {
                        throw new j("Unsatisfied dependency for component " + aVar + ": " + qVar);
                    }
                    if (i10 != 2) {
                        map.put(qVar, new o(o.f12246c, o.f12247d));
                    }
                }
            }
        }
    }

    public final ArrayList i(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            a aVar = (a) obj;
            if (aVar.e == 0) {
                q2.b bVar = (q2.b) this.f12226a.get(aVar);
                for (q qVar : aVar.f12220b) {
                    HashMap map = this.f12227b;
                    if (map.containsKey(qVar)) {
                        arrayList2.add(new androidx.browser.trusted.c(18, (o) ((q2.b) map.get(qVar)), bVar));
                    } else {
                        map.put(qVar, bVar);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList j() {
        HashMap map = this.f12228c;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : this.f12226a.entrySet()) {
            a aVar = (a) entry.getKey();
            if (aVar.e != 0) {
                q2.b bVar = (q2.b) entry.getValue();
                for (q qVar : aVar.f12220b) {
                    if (!map2.containsKey(qVar)) {
                        map2.put(qVar, new HashSet());
                    }
                    ((Set) map2.get(qVar)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (map.containsKey(entry2.getKey())) {
                n nVar = (n) map.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new androidx.browser.trusted.c(19, nVar, (q2.b) it.next()));
                }
            } else {
                q qVar2 = (q) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                n nVar2 = new n();
                nVar2.f12245b = null;
                nVar2.f12244a = Collections.newSetFromMap(new ConcurrentHashMap());
                nVar2.f12244a.addAll(set);
                map.put(qVar2, nVar2);
            }
        }
        return arrayList;
    }
}
