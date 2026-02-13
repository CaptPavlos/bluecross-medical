package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h implements n, j {

    /* renamed from: a, reason: collision with root package name */
    public final String f1973a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1974b = new HashMap();

    public h(String str) {
        this.f1973a = str;
    }

    public abstract n a(w2.r rVar, List list);

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return new i(this.f1974b.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n c(String str) {
        HashMap map = this.f1974b;
        return map.containsKey(str) ? (n) map.get(str) : n.f2091a0;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final void d(String str, n nVar) {
        HashMap map = this.f1974b;
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
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        String str = this.f1973a;
        if (str != null) {
            return str.equals(hVar.f1973a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return this.f1973a;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final boolean h(String str) {
        return this.f1974b.containsKey(str);
    }

    public final int hashCode() {
        String str = this.f1973a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n i(String str, w2.r rVar, ArrayList arrayList) {
        return "toString".equals(str) ? new q(this.f1973a) : androidx.constraintlayout.core.widgets.analyzer.a.I(this, new q(str), rVar, arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public n l() {
        return this;
    }
}
