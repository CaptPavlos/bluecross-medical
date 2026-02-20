package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s6 implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f2160a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2161b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r6 f2162c;

    public s6(r6 r6Var, Comparable comparable, Object obj) {
        this.f2162c = r6Var;
        this.f2160a = comparable;
        this.f2161b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f2160a.compareTo(((s6) obj).f2160a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f2160a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f2161b;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f2160a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f2161b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f2160a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f2161b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f2162c.g();
        Object obj2 = this.f2161b;
        this.f2161b = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f2160a);
        String strValueOf2 = String.valueOf(this.f2161b);
        return androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder(strValueOf.length() + 1 + strValueOf2.length()), strValueOf, "=", strValueOf2);
    }
}
