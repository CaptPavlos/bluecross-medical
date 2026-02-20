package h0;

import com.google.android.gms.internal.measurement.a4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p implements i0.d, j8.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8393a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8394b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public Object f8395c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public Object f8396d = new HashMap();
    public Object e = new HashMap();
    public Object f = new HashMap();

    public j8.d a() {
        return new j8.d((HashMap) this.f8394b, (HashMap) this.f8395c, (HashMap) this.f8396d, (HashMap) this.e, (HashMap) this.f, this.f8393a);
    }

    @Override // i0.d
    public void b(f0.b bVar) {
        ((e) this.f).f8371m.post(new k1.a(this, bVar, 17, false));
    }

    public void c(m7.c cVar, g7.l lVar, boolean z9) {
        HashMap map = (HashMap) this.f;
        g7.l lVar2 = (g7.l) map.get(cVar);
        if (lVar2 == null || lVar2.equals(lVar) || z9) {
            map.put(cVar, lVar);
        } else {
            androidx.window.layout.c.h("Default deserializers provider for ", cVar, " is already registered: ", lVar2);
        }
    }

    public void d(m7.c cVar, g7.l lVar, boolean z9) {
        HashMap map = (HashMap) this.f8396d;
        g7.l lVar2 = (g7.l) map.get(cVar);
        if (lVar2 == null || lVar2.equals(lVar) || z9) {
            map.put(cVar, lVar);
        } else {
            androidx.window.layout.c.h("Default serializers provider for ", cVar, " is already registered: ", lVar2);
        }
    }

    @Override // j8.g
    public void e(m7.c cVar, a3.q qVar) {
        cVar.getClass();
        g(cVar, new j8.b(qVar), false);
    }

    public void f(m7.c cVar, m7.c cVar2, c8.b bVar, boolean z9) {
        Object next;
        String strA = bVar.getDescriptor().a();
        HashMap map = (HashMap) this.f8395c;
        Object map2 = map.get(cVar);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(cVar, map2);
        }
        Map map3 = (Map) map2;
        c8.b bVar2 = (c8.b) map3.get(cVar2);
        HashMap map4 = (HashMap) this.e;
        Object map5 = map4.get(cVar);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(cVar, map5);
        }
        Map map6 = (Map) map5;
        if (z9) {
            if (bVar2 != null) {
                map6.remove(bVar2.getDescriptor().a());
            }
            map3.put(cVar2, bVar);
            map6.put(strA, bVar);
            return;
        }
        if (bVar2 != null) {
            if (!bVar2.equals(bVar)) {
                throw new j8.e("Serializer for " + cVar2 + " already registered in the scope of " + cVar);
            }
        }
        c8.b bVar3 = (c8.b) map6.get(strA);
        if (bVar3 == null) {
            map3.put(cVar2, bVar);
            map6.put(strA, bVar);
            return;
        }
        Object obj = map.get(cVar);
        obj.getClass();
        Set setEntrySet = ((Map) obj).entrySet();
        setEntrySet.getClass();
        Iterator it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Map.Entry) next).getValue() == bVar3) {
                    break;
                }
            }
        }
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + cVar + "' have the same serial name '" + strA + "': '" + cVar2 + "' and '" + ((Map.Entry) next) + '\'');
    }

    public void g(m7.c cVar, j8.c cVar2, boolean z9) {
        j8.c cVar3;
        HashMap map = (HashMap) this.f8394b;
        cVar.getClass();
        if (!z9 && (cVar3 = (j8.c) map.get(cVar)) != null && !cVar3.equals(cVar2)) {
            throw new j8.e("Contextual serializer or serializer provider for " + cVar + " already registered in this module");
        }
        map.put(cVar, cVar2);
        if (a4.q(cVar).isInterface()) {
            this.f8393a = true;
        }
    }

    public void h(f0.b bVar) {
        n nVar = (n) ((e) this.f).f8368j.get((a) this.f8395c);
        if (nVar != null) {
            nVar.p(bVar);
        }
    }

    @Override // j8.g
    public void j(m7.c cVar, g7.l lVar) {
        c(cVar, lVar, false);
    }

    @Override // j8.g
    public void p(m7.c cVar, c8.b bVar) {
        bVar.getClass();
        g(cVar, new j8.a(bVar), false);
    }

    @Override // j8.g
    public void s(m7.c cVar, g7.l lVar) {
        d(cVar, lVar, false);
    }

    @Override // j8.g
    public void t(m7.c cVar, m7.c cVar2, c8.b bVar) {
        f(cVar, cVar2, bVar, false);
    }
}
