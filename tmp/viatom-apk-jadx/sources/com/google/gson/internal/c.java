package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements GenericArrayType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f2554a;

    public c(Type type) {
        Objects.requireNonNull(type);
        this.f2554a = f.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && f.d(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f2554a;
    }

    public final int hashCode() {
        return this.f2554a.hashCode();
    }

    public final String toString() {
        return f.k(this.f2554a) + "[]";
    }
}
