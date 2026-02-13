package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z4 extends k {

    /* renamed from: b, reason: collision with root package name */
    public final a3.x f2280b;

    public z4(a3.x xVar) {
        this.f2280b = xVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.measurement.k, com.google.android.gms.internal.measurement.n
    public final n i(String str, w2.r rVar, ArrayList arrayList) {
        int iHashCode = str.hashCode();
        a3.x xVar = this.f2280b;
        switch (iHashCode) {
            case 21624207:
                if (str.equals("getEventName")) {
                    a.a.T(arrayList, "getEventName", 0);
                    return new q(((b) xVar.f182c).f1883a);
                }
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    a.a.T(arrayList, "getTimestamp", 0);
                    return new g(Double.valueOf(((b) xVar.f182c).f1884b));
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    a.a.T(arrayList, "getParamValue", 1);
                    String strF = ((t) rVar.f13463c).c(rVar, (n) arrayList.get(0)).f();
                    HashMap map = ((b) xVar.f182c).f1885c;
                    return a4.J(map.containsKey(strF) ? map.get(strF) : null);
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    a.a.T(arrayList, "getParams", 0);
                    HashMap map2 = ((b) xVar.f182c).f1885c;
                    k kVar = new k();
                    for (String str2 : map2.keySet()) {
                        kVar.d(str2, a4.J(map2.get(str2)));
                    }
                    return kVar;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    a.a.T(arrayList, "setParamValue", 2);
                    String strF2 = ((t) rVar.f13463c).c(rVar, (n) arrayList.get(0)).f();
                    n nVarC = ((t) rVar.f13463c).c(rVar, (n) arrayList.get(1));
                    b bVar = (b) xVar.f182c;
                    Object objC0 = a.a.c0(nVarC);
                    HashMap map3 = bVar.f1885c;
                    if (objC0 == null) {
                        map3.remove(strF2);
                        return nVarC;
                    }
                    map3.put(strF2, b.b(map3.get(strF2), strF2, objC0));
                    return nVarC;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    a.a.T(arrayList, "setEventName", 1);
                    n nVarC2 = ((t) rVar.f13463c).c(rVar, (n) arrayList.get(0));
                    if (n.f2091a0.equals(nVarC2) || n.f2092b0.equals(nVarC2)) {
                        com.google.gson.internal.a.n("Illegal event name");
                        return null;
                    }
                    ((b) xVar.f182c).f1883a = nVarC2.f();
                    return new q(nVarC2.f());
                }
                break;
        }
        return super.i(str, rVar, arrayList);
    }
}
