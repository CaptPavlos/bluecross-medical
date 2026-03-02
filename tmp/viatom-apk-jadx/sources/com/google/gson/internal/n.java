package com.google.gson.internal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n implements CharSequence {

    /* renamed from: a, reason: collision with root package name */
    public char[] f2579a;

    /* renamed from: b, reason: collision with root package name */
    public String f2580b;

    @Override // java.lang.CharSequence
    public final char charAt(int i10) {
        return this.f2579a[i10];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f2579a.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i10, int i11) {
        return new String(this.f2579a, i10, i11 - i10);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.f2580b == null) {
            this.f2580b = new String(this.f2579a);
        }
        return this.f2580b;
    }
}
