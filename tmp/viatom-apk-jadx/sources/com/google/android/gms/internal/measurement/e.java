package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements n {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1927a;

    public e(Boolean bool) {
        this.f1927a = bool == null ? false : bool.booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        return Boolean.valueOf(this.f1927a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f1927a == ((e) obj).f1927a;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return Boolean.toString(this.f1927a);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        return Double.valueOf(true != this.f1927a ? 0.0d : 1.0d);
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f1927a).hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n i(String str, w2.r rVar, ArrayList arrayList) {
        boolean zEquals = "toString".equals(str);
        boolean z9 = this.f1927a;
        if (zEquals) {
            return new q(Boolean.toString(z9));
        }
        throw new IllegalArgumentException(Boolean.toString(z9) + "." + str + " is not a function.");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return new e(Boolean.valueOf(this.f1927a));
    }

    public final String toString() {
        return String.valueOf(this.f1927a);
    }
}
