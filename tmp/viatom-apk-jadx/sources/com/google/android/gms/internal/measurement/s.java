package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2152a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2153b;

    public s(int i10) {
        this.f2153b = i10;
    }

    public static m c(w2.r rVar, List list) {
        w wVar = w.ADD;
        a.a.V(list, "FN", 2);
        n nVarC = ((t) rVar.f13463c).c(rVar, (n) list.get(0));
        n nVarC2 = ((t) rVar.f13463c).c(rVar, (n) list.get(1));
        if (!(nVarC2 instanceof d)) {
            com.google.gson.internal.a.n(a3.a.i("FN requires an ArrayValue of parameter names found ", nVarC2.getClass().getCanonicalName()));
            return null;
        }
        List listM = ((d) nVarC2).m();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new m(nVarC.f(), (ArrayList) listM, arrayList, rVar);
    }

    public static boolean d(n nVar, n nVar2) {
        if (nVar instanceof j) {
            nVar = new q(nVar.f());
        }
        if (nVar2 instanceof j) {
            nVar2 = new q(nVar2.f());
        }
        if ((nVar instanceof q) && (nVar2 instanceof q)) {
            return ((q) nVar).f2137a.compareTo(((q) nVar2).f2137a) < 0;
        }
        double dDoubleValue = nVar.g().doubleValue();
        double dDoubleValue2 = nVar2.g().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || ((dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    public static n e(v vVar, n nVar, n nVar2) {
        if (nVar instanceof Iterable) {
            return g(vVar, ((Iterable) nVar).iterator(), nVar2);
        }
        com.google.gson.internal.a.n("Non-iterable type in for...of loop.");
        return null;
    }

    public static boolean f(n nVar, n nVar2) {
        if (nVar.getClass().equals(nVar2.getClass())) {
            if ((nVar instanceof r) || (nVar instanceof l)) {
                return true;
            }
            return nVar instanceof g ? (Double.isNaN(nVar.g().doubleValue()) || Double.isNaN(nVar2.g().doubleValue()) || nVar.g().doubleValue() != nVar2.g().doubleValue()) ? false : true : nVar instanceof q ? nVar.f().equals(nVar2.f()) : nVar instanceof e ? nVar.e().equals(nVar2.e()) : nVar == nVar2;
        }
        if (((nVar instanceof r) || (nVar instanceof l)) && ((nVar2 instanceof r) || (nVar2 instanceof l))) {
            return true;
        }
        boolean z9 = nVar instanceof g;
        if (z9 && (nVar2 instanceof q)) {
            return f(nVar, new g(nVar2.g()));
        }
        boolean z10 = nVar instanceof q;
        if (z10 && (nVar2 instanceof g)) {
            return f(new g(nVar.g()), nVar2);
        }
        if (nVar instanceof e) {
            return f(new g(nVar.g()), nVar2);
        }
        if (nVar2 instanceof e) {
            return f(nVar, new g(nVar2.g()));
        }
        if ((z10 || z9) && (nVar2 instanceof j)) {
            return f(nVar, new q(nVar2.f()));
        }
        if ((nVar instanceof j) && ((nVar2 instanceof q) || (nVar2 instanceof g))) {
            return f(new q(nVar.f()), nVar2);
        }
        return false;
    }

    public static n g(v vVar, Iterator it, n nVar) {
        w2.r rVarN;
        if (it != null) {
            while (it.hasNext()) {
                n nVar2 = (n) it.next();
                switch (vVar.f2197a) {
                    case 0:
                        rVarN = vVar.f2198b.N();
                        String str = vVar.f2199c;
                        rVarN.Q(str, nVar2);
                        ((HashMap) rVarN.e).put(str, Boolean.TRUE);
                        break;
                    case 1:
                        rVarN = vVar.f2198b.N();
                        rVarN.Q(vVar.f2199c, nVar2);
                        break;
                    default:
                        rVarN = vVar.f2198b;
                        rVarN.Q(vVar.f2199c, nVar2);
                        break;
                }
                n nVarL = rVarN.L((d) nVar);
                if (nVarL instanceof f) {
                    f fVar = (f) nVarL;
                    String str2 = fVar.f1947b;
                    if ("break".equals(str2)) {
                        return n.f2091a0;
                    }
                    if ("return".equals(str2)) {
                        return fVar;
                    }
                }
            }
        }
        return n.f2091a0;
    }

    public static boolean h(n nVar, n nVar2) {
        if (nVar instanceof j) {
            nVar = new q(nVar.f());
        }
        if (nVar2 instanceof j) {
            nVar2 = new q(nVar2.f());
        }
        return (((nVar instanceof q) && (nVar2 instanceof q)) || !(Double.isNaN(nVar.g().doubleValue()) || Double.isNaN(nVar2.g().doubleValue()))) && !d(nVar2, nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0baf  */
    /* JADX WARN: Removed duplicated region for block: B:563:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v101, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r12v104, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r12v320 */
    /* JADX WARN: Type inference failed for: r12v325 */
    /* JADX WARN: Type inference failed for: r12v344, types: [com.google.android.gms.internal.measurement.d] */
    /* JADX WARN: Type inference failed for: r12v351, types: [com.google.android.gms.internal.measurement.k] */
    /* JADX WARN: Type inference failed for: r12v386 */
    /* JADX WARN: Type inference failed for: r12v387 */
    /* JADX WARN: Type inference failed for: r13v0, types: [w2.r] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n a(java.lang.String r12, w2.r r13, java.util.ArrayList r14) {
        /*
            Method dump skipped, instructions count: 3810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.s.a(java.lang.String, w2.r, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    public final void b(String str) {
        if (!this.f2152a.contains(a.a.Y(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
    }
}
