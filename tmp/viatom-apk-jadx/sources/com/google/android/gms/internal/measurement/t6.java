package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t6 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f2182a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2183b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f2184c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r6 f2185d;

    public /* synthetic */ t6(r6 r6Var) {
        Objects.requireNonNull(r6Var);
        this.f2185d = r6Var;
        this.f2182a = -1;
    }

    public final Iterator a() {
        if (this.f2184c == null) {
            this.f2184c = this.f2185d.f2146c.entrySet().iterator();
        }
        return this.f2184c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10 = this.f2182a + 1;
        r6 r6Var = this.f2185d;
        if (i10 >= r6Var.f2145b) {
            return !r6Var.f2146c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f2183b = true;
        int i10 = this.f2182a + 1;
        this.f2182a = i10;
        r6 r6Var = this.f2185d;
        return i10 < r6Var.f2145b ? (s6) r6Var.f2144a[i10] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f2183b) {
            androidx.window.layout.c.g("remove() was called before next()");
            return;
        }
        this.f2183b = false;
        r6 r6Var = this.f2185d;
        r6Var.g();
        int i10 = this.f2182a;
        if (i10 >= r6Var.f2145b) {
            a().remove();
        } else {
            this.f2182a = i10 - 1;
            r6Var.e(i10);
        }
    }
}
