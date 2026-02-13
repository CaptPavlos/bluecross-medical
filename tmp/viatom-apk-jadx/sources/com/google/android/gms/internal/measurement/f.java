package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements n {

    /* renamed from: a, reason: collision with root package name */
    public final n f1946a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1947b;

    public f(String str) {
        this.f1946a = n.f2091a0;
        this.f1947b = str;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f1947b.equals(fVar.f1947b) && this.f1946a.equals(fVar.f1946a);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        throw new IllegalStateException("Control is not a double");
    }

    public final int hashCode() {
        return this.f1946a.hashCode() + (this.f1947b.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n i(String str, w2.r rVar, ArrayList arrayList) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return new f(this.f1947b, this.f1946a.l());
    }

    public f(String str, n nVar) {
        this.f1946a = nVar;
        this.f1947b = str;
    }
}
