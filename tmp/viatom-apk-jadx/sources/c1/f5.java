package c1;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.v7;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f5 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1222a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1223b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.n3 f1224c;

    /* renamed from: d, reason: collision with root package name */
    public final BitSet f1225d;
    public final BitSet e;
    public final ArrayMap f;
    public final ArrayMap g;
    public final /* synthetic */ c h;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ f5(c cVar, String str, com.google.android.gms.internal.measurement.n3 n3Var, BitSet bitSet, BitSet bitSet2, ArrayMap arrayMap, ArrayMap arrayMap2) {
        this.h = cVar;
        this.f1222a = str;
        this.f1225d = bitSet;
        this.e = bitSet2;
        this.f = arrayMap;
        this.g = new ArrayMap();
        for (K k10 : arrayMap2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) arrayMap2.get(k10));
            this.g.put(k10, arrayList);
        }
        this.f1223b = false;
        this.f1224c = n3Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(b bVar) {
        int iQ;
        boolean z9;
        boolean zV;
        switch (bVar.g) {
            case 0:
                iQ = ((com.google.android.gms.internal.measurement.p1) bVar.f1014i).q();
                break;
            default:
                iQ = ((com.google.android.gms.internal.measurement.w1) bVar.f1014i).q();
                break;
        }
        if (bVar.f1012c != null) {
            this.e.set(iQ, true);
        }
        Boolean bool = bVar.f1013d;
        if (bool != null) {
            this.f1225d.set(iQ, bool.booleanValue());
        }
        if (bVar.e != null) {
            Integer numValueOf = Integer.valueOf(iQ);
            ArrayMap arrayMap = this.f;
            Long l10 = (Long) arrayMap.get(numValueOf);
            long jLongValue = bVar.e.longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                arrayMap.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (bVar.f != null) {
            Integer numValueOf2 = Integer.valueOf(iQ);
            ArrayMap arrayMap2 = this.g;
            List arrayList = (List) arrayMap2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayMap2.put(numValueOf2, arrayList);
            }
            switch (bVar.g) {
                case 0:
                    z9 = false;
                    break;
                default:
                    z9 = true;
                    break;
            }
            if (z9) {
                arrayList.clear();
            }
            v7.a();
            u1 u1Var = this.h.f1149a;
            g gVar = u1Var.f1478d;
            e0 e0Var = f0.G0;
            String str = this.f1222a;
            if (gVar.q(str, e0Var)) {
                switch (bVar.g) {
                    case 0:
                        zV = ((com.google.android.gms.internal.measurement.p1) bVar.f1014i).v();
                        break;
                    default:
                        zV = false;
                        break;
                }
                if (zV) {
                    arrayList.clear();
                }
            }
            v7.a();
            boolean zQ = u1Var.f1478d.q(str, e0Var);
            Long l11 = bVar.f;
            if (!zQ) {
                arrayList.add(Long.valueOf(l11.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(l11.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public final com.google.android.gms.internal.measurement.u2 b(int i10) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.t2 t2VarW = com.google.android.gms.internal.measurement.u2.w();
        t2VarW.b();
        ((com.google.android.gms.internal.measurement.u2) t2VarW.f2102b).x(i10);
        t2VarW.b();
        ((com.google.android.gms.internal.measurement.u2) t2VarW.f2102b).A(this.f1223b);
        com.google.android.gms.internal.measurement.n3 n3Var = this.f1224c;
        if (n3Var != null) {
            t2VarW.b();
            ((com.google.android.gms.internal.measurement.u2) t2VarW.f2102b).z(n3Var);
        }
        com.google.android.gms.internal.measurement.m3 m3VarX = com.google.android.gms.internal.measurement.n3.x();
        ArrayList arrayListO = a1.O(this.f1225d);
        m3VarX.b();
        ((com.google.android.gms.internal.measurement.n3) m3VarX.f2102b).B(arrayListO);
        ArrayList arrayListO2 = a1.O(this.e);
        m3VarX.b();
        ((com.google.android.gms.internal.measurement.n3) m3VarX.f2102b).z(arrayListO2);
        ArrayMap arrayMap = this.f;
        if (arrayMap == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(arrayMap.size());
            for (Integer num : arrayMap.keySet()) {
                int iIntValue = num.intValue();
                Long l10 = (Long) arrayMap.get(num);
                if (l10 != null) {
                    com.google.android.gms.internal.measurement.z2 z2VarT = com.google.android.gms.internal.measurement.a3.t();
                    z2VarT.b();
                    ((com.google.android.gms.internal.measurement.a3) z2VarT.f2102b).u(iIntValue);
                    long jLongValue = l10.longValue();
                    z2VarT.b();
                    ((com.google.android.gms.internal.measurement.a3) z2VarT.f2102b).v(jLongValue);
                    arrayList2.add((com.google.android.gms.internal.measurement.a3) z2VarT.d());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            m3VarX.b();
            ((com.google.android.gms.internal.measurement.n3) m3VarX.f2102b).D(arrayList);
        }
        ArrayMap arrayMap2 = this.g;
        if (arrayMap2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(arrayMap2.size());
            for (Integer num2 : arrayMap2.keySet()) {
                com.google.android.gms.internal.measurement.o3 o3VarU = com.google.android.gms.internal.measurement.p3.u();
                int iIntValue2 = num2.intValue();
                o3VarU.b();
                ((com.google.android.gms.internal.measurement.p3) o3VarU.f2102b).v(iIntValue2);
                List list2 = (List) arrayMap2.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    o3VarU.b();
                    ((com.google.android.gms.internal.measurement.p3) o3VarU.f2102b).w(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.p3) o3VarU.d());
            }
            list = arrayList3;
        }
        m3VarX.b();
        ((com.google.android.gms.internal.measurement.n3) m3VarX.f2102b).F(list);
        t2VarW.b();
        ((com.google.android.gms.internal.measurement.u2) t2VarW.f2102b).y((com.google.android.gms.internal.measurement.n3) m3VarX.d());
        return (com.google.android.gms.internal.measurement.u2) t2VarW.d();
    }

    public /* synthetic */ f5(c cVar, String str) {
        this.h = cVar;
        this.f1222a = str;
        this.f1223b = true;
        this.f1225d = new BitSet();
        this.e = new BitSet();
        this.f = new ArrayMap();
        this.g = new ArrayMap();
    }
}
