package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q implements Iterable, n {

    /* renamed from: a, reason: collision with root package name */
    public final String f2137a;

    public q(String str) {
        if (str != null) {
            this.f2137a = str;
        } else {
            com.google.gson.internal.a.n("StringValue cannot be null.");
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return new p(this, 0);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        return Boolean.valueOf(!this.f2137a.isEmpty());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f2137a.equals(((q) obj).f2137a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return this.f2137a;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        String str = this.f2137a;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final int hashCode() {
        return this.f2137a.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02e4 A[PHI: r8
      0x02e4: PHI (r8v6 boolean) = (r8v12 boolean), (r8v13 boolean), (r8v16 boolean) binds: [B:100:0x02d0, B:101:0x02d2, B:103:0x02e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ee A[LOOP:0: B:108:0x02ec->B:109:0x02ee, LOOP_END] */
    @Override // com.google.android.gms.internal.measurement.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n i(java.lang.String r29, w2.r r30, java.util.ArrayList r31) {
        /*
            Method dump skipped, instructions count: 1606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.q.i(java.lang.String, w2.r, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p(this, 1);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return new q(this.f2137a);
    }

    public final String toString() {
        String str = this.f2137a;
        return androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder(str.length() + 2), "\"", str, "\"");
    }
}
