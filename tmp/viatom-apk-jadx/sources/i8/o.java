package i8;

import g8.o0;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.y;
import t6.a0;
import t6.b0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class o extends a {
    public final h8.t f;
    public final e8.e g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9077i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(h8.b bVar, h8.t tVar, String str, e8.e eVar) {
        super(bVar, str);
        bVar.getClass();
        this.f = tVar;
        this.g = eVar;
    }

    @Override // i8.a
    public h8.k b(String str) {
        str.getClass();
        return (h8.k) a0.f0(p(), str);
    }

    @Override // i8.a, f8.e
    public final f8.c beginStructure(e8.e eVar) {
        eVar.getClass();
        e8.e eVar2 = this.g;
        if (eVar != eVar2) {
            return super.beginStructure(eVar);
        }
        h8.k kVarC = c();
        String strA = eVar2.a();
        if (kVarC instanceof h8.t) {
            return new o(this.f9061c, (h8.t) kVarC, this.f9062d, eVar2);
        }
        throw l.e("Expected " + y.a(h8.t.class).c() + ", but had " + y.a(kVarC.getClass()).c() + " as the serialized body of " + strA + " at element: " + r(), kVarC.toString(), -1);
    }

    @Override // f8.c
    public int decodeElementIndex(e8.e eVar) {
        eVar.getClass();
        while (this.h < eVar.e()) {
            int i10 = this.h;
            this.h = i10 + 1;
            String strO = o(eVar, i10);
            int i11 = this.h - 1;
            this.f9077i = false;
            if (!p().containsKey(strO)) {
                boolean z9 = (this.f9061c.f8826a.f8835a || eVar.i(i11) || !eVar.h(i11).c()) ? false : true;
                this.f9077i = z9;
                if (z9) {
                }
            }
            this.e.getClass();
            return i11;
        }
        return -1;
    }

    @Override // i8.a, f8.e
    public final boolean decodeNotNullMark() {
        return !this.f9077i && super.decodeNotNullMark();
    }

    @Override // i8.a, f8.c
    public void endStructure(e8.e eVar) {
        Set setT;
        eVar.getClass();
        h8.h hVar = this.e;
        hVar.getClass();
        if (eVar.getKind() instanceof e8.c) {
            return;
        }
        h8.b bVar = this.f9061c;
        l.l(eVar, bVar);
        if (hVar.f8838d) {
            Set setB = o0.b(eVar);
            y2.c cVar = bVar.f8828c;
            cVar.getClass();
            Map map = (Map) ((ConcurrentHashMap) cVar.f13781b).get(eVar);
            Object obj = map != null ? map.get(l.f9075a) : null;
            if (obj == null) {
                obj = null;
            }
            Map map2 = (Map) obj;
            Set setKeySet = map2 != null ? map2.keySet() : null;
            if (setKeySet == null) {
                setKeySet = t6.v.f12810a;
            }
            setT = b0.T(setB, setKeySet);
        } else {
            setT = o0.b(eVar);
        }
        for (String str : p().f8848a.keySet()) {
            if (!setT.contains(str) && !kotlin.jvm.internal.l.a(str, this.f9062d)) {
                String string = p().toString();
                str.getClass();
                StringBuilder sbY = a3.a.y("Encountered an unknown key '", str, "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: ");
                sbY.append((Object) l.k(string, -1));
                throw l.d(-1, sbY.toString());
            }
        }
    }

    @Override // i8.a
    public String n(e8.e eVar, int i10) {
        eVar.getClass();
        h8.b bVar = this.f9061c;
        l.l(eVar, bVar);
        String strF = eVar.f(i10);
        if (this.e.f8838d && !p().f8848a.keySet().contains(strF)) {
            y2.c cVar = bVar.f8828c;
            androidx.work.impl.utils.c cVar2 = new androidx.work.impl.utils.c(7, eVar, bVar);
            cVar.getClass();
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) cVar.f13781b;
            Map map = (Map) concurrentHashMap.get(eVar);
            Object obj = null;
            m mVar = l.f9075a;
            Object objInvoke = map != null ? map.get(mVar) : null;
            if (objInvoke == null) {
                objInvoke = null;
            }
            if (objInvoke == null) {
                objInvoke = cVar2.invoke();
                Object concurrentHashMap2 = concurrentHashMap.get(eVar);
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap(2);
                    concurrentHashMap.put(eVar, concurrentHashMap2);
                }
                ((Map) concurrentHashMap2).put(mVar, objInvoke);
            }
            Map map2 = (Map) objInvoke;
            Iterator it = p().f8848a.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Integer num = (Integer) map2.get((String) next);
                if (num != null && num.intValue() == i10) {
                    obj = next;
                    break;
                }
            }
            String str = (String) obj;
            if (str != null) {
                return str;
            }
        }
        return strF;
    }

    @Override // i8.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public h8.t p() {
        return this.f;
    }

    public /* synthetic */ o(h8.b bVar, h8.t tVar, String str, int i10) {
        this(bVar, tVar, (i10 & 4) != 0 ? null : str, (e8.e) null);
    }
}
