package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f1987a;

    public i(Iterator it) {
        this.f1987a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1987a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new q((String) this.f1987a.next());
    }
}
