package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements Iterable, n, j {

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap f1908a;

    /* renamed from: b, reason: collision with root package name */
    public final TreeMap f1909b;

    public d(List list) {
        this();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                q(i10, (n) list.get(i10));
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return new c(this, this.f1908a.keySet().iterator(), this.f1909b.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n c(String str) {
        n nVar;
        return "length".equals(str) ? new g(Double.valueOf(o())) : (!h(str) || (nVar = (n) this.f1909b.get(str)) == null) ? n.f2091a0 : nVar;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final void d(String str, n nVar) {
        TreeMap treeMap = this.f1909b;
        if (nVar == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, nVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        return Boolean.TRUE;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (o() != dVar.o()) {
            return false;
        }
        TreeMap treeMap = this.f1908a;
        if (treeMap.isEmpty()) {
            return dVar.f1908a.isEmpty();
        }
        for (int iIntValue = ((Integer) treeMap.firstKey()).intValue(); iIntValue <= ((Integer) treeMap.lastKey()).intValue(); iIntValue++) {
            if (!p(iIntValue).equals(dVar.p(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return t(",");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        TreeMap treeMap = this.f1908a;
        return treeMap.size() == 1 ? p(0).g() : treeMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final boolean h(String str) {
        return "length".equals(str) || this.f1909b.containsKey(str);
    }

    public final int hashCode() {
        return this.f1908a.hashCode() * 31;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02dc, code lost:
    
        if (r0.f.S(r7, r2, (com.google.android.gms.internal.measurement.m) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).o() == r7.o()) goto L168;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x07a4  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x080a  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0822  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fe  */
    @Override // com.google.android.gms.internal.measurement.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n i(java.lang.String r37, w2.r r38, java.util.ArrayList r39) {
        /*
            Method dump skipped, instructions count: 2172
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.d.i(java.lang.String, w2.r, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p(this, 2);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        d dVar = new d();
        for (Map.Entry entry : this.f1908a.entrySet()) {
            boolean z9 = entry.getValue() instanceof j;
            TreeMap treeMap = dVar.f1908a;
            if (z9) {
                treeMap.put((Integer) entry.getKey(), (n) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((n) entry.getValue()).l());
            }
        }
        return dVar;
    }

    public final List m() {
        ArrayList arrayList = new ArrayList(o());
        for (int i10 = 0; i10 < o(); i10++) {
            arrayList.add(p(i10));
        }
        return arrayList;
    }

    public final Iterator n() {
        return this.f1908a.keySet().iterator();
    }

    public final int o() {
        TreeMap treeMap = this.f1908a;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    public final n p(int i10) {
        n nVar;
        if (i10 < o()) {
            return (!r(i10) || (nVar = (n) this.f1908a.get(Integer.valueOf(i10))) == null) ? n.f2091a0 : nVar;
        }
        p8.u.k("Attempting to get element outside of current array");
        return null;
    }

    public final void q(int i10, n nVar) {
        if (i10 > 32468) {
            androidx.window.layout.c.g("Array too large");
            return;
        }
        if (i10 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i10);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        TreeMap treeMap = this.f1908a;
        if (nVar == null) {
            treeMap.remove(Integer.valueOf(i10));
        } else {
            treeMap.put(Integer.valueOf(i10), nVar);
        }
    }

    public final boolean r(int i10) {
        if (i10 >= 0) {
            TreeMap treeMap = this.f1908a;
            if (i10 <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i10));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i10);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void s(int i10) {
        TreeMap treeMap = this.f1908a;
        int iIntValue = ((Integer) treeMap.lastKey()).intValue();
        if (i10 > iIntValue || i10 < 0) {
            return;
        }
        treeMap.remove(Integer.valueOf(i10));
        if (i10 == iIntValue) {
            int i11 = i10 - 1;
            Integer numValueOf = Integer.valueOf(i11);
            if (treeMap.containsKey(numValueOf) || i11 < 0) {
                return;
            }
            treeMap.put(numValueOf, n.f2091a0);
            return;
        }
        while (true) {
            i10++;
            if (i10 > ((Integer) treeMap.lastKey()).intValue()) {
                return;
            }
            Integer numValueOf2 = Integer.valueOf(i10);
            n nVar = (n) treeMap.get(numValueOf2);
            if (nVar != null) {
                treeMap.put(Integer.valueOf(i10 - 1), nVar);
                treeMap.remove(numValueOf2);
            }
        }
    }

    public final String t(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.f1908a.isEmpty()) {
            int i10 = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i10 >= o()) {
                    break;
                }
                n nVarP = p(i10);
                sb.append(str2);
                if (!(nVarP instanceof r) && !(nVarP instanceof l)) {
                    sb.append(nVarP.f());
                }
                i10++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public final String toString() {
        return t(",");
    }

    public d() {
        this.f1908a = new TreeMap();
        this.f1909b = new TreeMap();
    }
}
