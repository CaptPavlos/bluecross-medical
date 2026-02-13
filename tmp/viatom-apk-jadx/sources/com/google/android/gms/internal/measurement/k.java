package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class k implements n, j {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2020a = new HashMap();

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return new i(this.f2020a.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n c(String str) {
        HashMap map = this.f2020a;
        return map.containsKey(str) ? (n) map.get(str) : n.f2091a0;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final void d(String str, n nVar) {
        HashMap map = this.f2020a;
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        return Boolean.TRUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return this.f2020a.equals(((k) obj).f2020a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return "[object Object]";
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final boolean h(String str) {
        return this.f2020a.containsKey(str);
    }

    public final int hashCode() {
        return this.f2020a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public n i(String str, w2.r rVar, ArrayList arrayList) {
        return "toString".equals(str) ? new q(toString()) : androidx.constraintlayout.core.widgets.analyzer.a.I(this, new q(str), rVar, arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        k kVar = new k();
        for (Map.Entry entry : this.f2020a.entrySet()) {
            boolean z9 = entry.getValue() instanceof j;
            HashMap map = kVar.f2020a;
            if (z9) {
                map.put((String) entry.getKey(), (n) entry.getValue());
            } else {
                map.put((String) entry.getKey(), ((n) entry.getValue()).l());
            }
        }
        return kVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        HashMap map = this.f2020a;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(String.format("%s: %s,", str, map.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
