package w6;

import e5.u0;
import g7.p;
import java.io.Serializable;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements h, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final h f13520a;

    /* renamed from: b, reason: collision with root package name */
    public final f f13521b;

    public b(f fVar, h hVar) {
        hVar.getClass();
        fVar.getClass();
        this.f13520a = hVar;
        this.f13521b = fVar;
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int i10 = 2;
            b bVar2 = bVar;
            int i11 = 2;
            while (true) {
                h hVar = bVar2.f13520a;
                bVar2 = hVar instanceof b ? (b) hVar : null;
                if (bVar2 == null) {
                    break;
                }
                i11++;
            }
            b bVar3 = this;
            while (true) {
                h hVar2 = bVar3.f13520a;
                bVar3 = hVar2 instanceof b ? (b) hVar2 : null;
                if (bVar3 == null) {
                    break;
                }
                i10++;
            }
            if (i11 == i10) {
                b bVar4 = this;
                while (true) {
                    f fVar = bVar4.f13521b;
                    if (!l.a(bVar.get(fVar.getKey()), fVar)) {
                        zA = false;
                        break;
                    }
                    h hVar3 = bVar4.f13520a;
                    if (!(hVar3 instanceof b)) {
                        hVar3.getClass();
                        f fVar2 = (f) hVar3;
                        zA = l.a(bVar.get(fVar2.getKey()), fVar2);
                        break;
                    }
                    bVar4 = (b) hVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // w6.h
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(this.f13520a.fold(obj, pVar), this.f13521b);
    }

    @Override // w6.h
    public final f get(g gVar) {
        gVar.getClass();
        b bVar = this;
        while (true) {
            f fVar = bVar.f13521b.get(gVar);
            if (fVar != null) {
                return fVar;
            }
            h hVar = bVar.f13520a;
            if (!(hVar instanceof b)) {
                return hVar.get(gVar);
            }
            bVar = (b) hVar;
        }
    }

    public final int hashCode() {
        return this.f13521b.hashCode() + this.f13520a.hashCode();
    }

    @Override // w6.h
    public final h minusKey(g gVar) {
        gVar.getClass();
        f fVar = this.f13521b;
        f fVar2 = fVar.get(gVar);
        h hVar = this.f13520a;
        if (fVar2 != null) {
            return hVar;
        }
        h hVarMinusKey = hVar.minusKey(gVar);
        return hVarMinusKey == hVar ? this : hVarMinusKey == i.f13523a ? fVar : new b(fVar, hVarMinusKey);
    }

    @Override // w6.h
    public final h plus(h hVar) {
        hVar.getClass();
        return hVar == i.f13523a ? this : (h) hVar.fold(this, new u0(13));
    }

    public final String toString() {
        return a3.a.m(new StringBuilder("["), (String) fold("", new u0(12)), ']');
    }
}
