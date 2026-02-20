package com.google.gson.internal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends Number {

    /* renamed from: a, reason: collision with root package name */
    public final String f2562a;

    public h(String str) {
        this.f2562a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f2562a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f2562a.equals(((h) obj).f2562a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f2562a);
    }

    public final int hashCode() {
        return this.f2562a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f2562a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return f.i(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f2562a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return f.i(str).longValue();
        }
    }

    public final String toString() {
        return this.f2562a;
    }
}
