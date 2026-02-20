package com.google.gson;

import com.google.gson.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends d {

    /* renamed from: a, reason: collision with root package name */
    public final l f2464a = new l(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof g) && ((g) obj).f2464a.equals(this.f2464a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f2464a.hashCode();
    }
}
