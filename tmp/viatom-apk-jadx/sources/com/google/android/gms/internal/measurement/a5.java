package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a5 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f1872a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f1873b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c5 f1874c;

    public a5(c5 c5Var) {
        this.f1874c = c5Var;
        this.f1873b = c5Var.d();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1872a < this.f1873b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i10 = this.f1872a;
        if (i10 < this.f1873b) {
            this.f1872a = i10 + 1;
            return Byte.valueOf(this.f1874c.c(i10));
        }
        com.google.gson.internal.a.b();
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
