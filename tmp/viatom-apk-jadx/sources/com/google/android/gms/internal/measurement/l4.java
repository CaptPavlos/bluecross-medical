package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l4 extends h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2074c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2075d;

    public l4(d0.i iVar) {
        super("internal.logger");
        this.f2075d = iVar;
        this.f1974b.put("log", new d9(this, false, true));
        this.f1974b.put(NotificationCompat.GROUP_KEY_SILENT, new a6(NotificationCompat.GROUP_KEY_SILENT, 1));
        ((h) this.f1974b.get(NotificationCompat.GROUP_KEY_SILENT)).d("log", new d9(this, true, true));
        this.f1974b.put("unmonitored", new a6("unmonitored", 2));
        ((h) this.f1974b.get("unmonitored")).d("log", new d9(this, false, false));
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n a(w2.r rVar, List list) {
        TreeMap treeMap;
        switch (this.f2074c) {
            case 0:
                a.a.T(list, this.f1973a, 3);
                String strF = ((t) rVar.f13463c).c(rVar, (n) list.get(0)).f();
                n nVar = (n) list.get(1);
                t tVar = (t) rVar.f13463c;
                long jB0 = (long) a.a.b0(tVar.c(rVar, nVar).g().doubleValue());
                n nVarC = tVar.c(rVar, (n) list.get(2));
                HashMap mapD0 = nVarC instanceof k ? a.a.d0((k) nVarC) : new HashMap();
                a3.x xVar = (a3.x) this.f2075d;
                xVar.getClass();
                HashMap map = new HashMap();
                for (String str : mapD0.keySet()) {
                    HashMap map2 = ((b) xVar.f181b).f1885c;
                    map.put(str, b.b(map2.containsKey(str) ? map2.get(str) : null, str, mapD0.get(str)));
                }
                ((ArrayList) xVar.f183d).add(new b(strF, jB0, map));
                break;
            case 1:
                a.a.T(list, "getValue", 2);
                n nVarC2 = ((t) rVar.f13463c).c(rVar, (n) list.get(0));
                n nVarC3 = ((t) rVar.f13463c).c(rVar, (n) list.get(1));
                String strF2 = nVarC2.f();
                a4.f fVar = (a4.f) this.f2075d;
                Map map3 = (Map) ((c1.n1) fVar.f219c).f1356d.get((String) fVar.f218b);
                String str2 = (map3 == null || !map3.containsKey(strF2)) ? null : (String) map3.get(strF2);
                if (str2 != null) {
                    break;
                }
                break;
            case 2:
                break;
            case 3:
                try {
                    break;
                } catch (Exception unused) {
                    return n.f2091a0;
                }
            default:
                a.a.T(list, this.f1973a, 3);
                ((t) rVar.f13463c).c(rVar, (n) list.get(0)).f();
                n nVar2 = (n) list.get(1);
                t tVar2 = (t) rVar.f13463c;
                n nVarC4 = tVar2.c(rVar, nVar2);
                if (nVarC4 instanceof m) {
                    n nVarC5 = tVar2.c(rVar, (n) list.get(2));
                    if (nVarC5 instanceof k) {
                        k kVar = (k) nVarC5;
                        HashMap map4 = kVar.f2020a;
                        if (map4.containsKey(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                            String strF3 = kVar.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY).f();
                            int iA0 = map4.containsKey("priority") ? a.a.a0(kVar.c("priority").g().doubleValue()) : 1000;
                            t tVar3 = (t) this.f2075d;
                            m mVar = (m) nVarC4;
                            tVar3.getClass();
                            if ("create".equals(strF3)) {
                                treeMap = (TreeMap) tVar3.f2166b;
                            } else if (!"edit".equals(strF3)) {
                                androidx.window.layout.c.g("Unknown callback type: ".concat(String.valueOf(strF3)));
                                break;
                            } else {
                                treeMap = (TreeMap) tVar3.f2165a;
                            }
                            if (treeMap.containsKey(Integer.valueOf(iA0))) {
                                iA0 = ((Integer) treeMap.lastKey()).intValue() + 1;
                            }
                            treeMap.put(Integer.valueOf(iA0), mVar);
                            break;
                        } else {
                            com.google.gson.internal.a.n("Undefined rule type");
                            break;
                        }
                    } else {
                        com.google.gson.internal.a.n("Invalid callback params");
                        break;
                    }
                } else {
                    com.google.gson.internal.a.n("Invalid callback type");
                    break;
                }
        }
        return n.f2091a0;
    }

    public l4(c1.l1 l1Var) {
        super("internal.appMetadata");
        this.f2075d = l1Var;
    }

    public l4(t tVar) {
        super("internal.registerCallback");
        this.f2075d = tVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l4(a6 a6Var, a4.f fVar) {
        super("getValue");
        this.f2075d = fVar;
    }

    public l4(a3.x xVar) {
        super("internal.eventLogger");
        this.f2075d = xVar;
    }
}
