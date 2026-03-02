package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f1897a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f1898b;

    public c(d dVar, Iterator it, Iterator it2) {
        this.f1897a = it;
        this.f1898b = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1897a.hasNext()) {
            return true;
        }
        return this.f1898b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.f1897a;
        if (it.hasNext()) {
            return new q(((Integer) it.next()).toString());
        }
        Iterator it2 = this.f1898b;
        if (it2.hasNext()) {
            return new q((String) it2.next());
        }
        com.google.gson.internal.a.b();
        return null;
    }
}
