package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends d implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2462a = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof c) && ((c) obj).f2462a.equals(this.f2462a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f2462a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f2462a.iterator();
    }
}
