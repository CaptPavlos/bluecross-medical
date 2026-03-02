package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements WildcardType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f2558a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f2559b;

    public e(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            a.n("At most one lower bound is supported");
            throw null;
        }
        if (typeArr.length != 1) {
            a.n("Exactly one upper bound must be specified");
            throw null;
        }
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            f.b(typeArr[0]);
            this.f2559b = null;
            this.f2558a = f.a(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        f.b(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            a.n("When lower bound is specified, upper bound must be Object");
            throw null;
        }
        this.f2559b = f.a(typeArr2[0]);
        this.f2558a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && f.d(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f2559b;
        return type != null ? new Type[]{type} : f.f2560a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f2558a};
    }

    public final int hashCode() {
        Type type = this.f2559b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f2558a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f2559b;
        if (type != null) {
            return "? super " + f.k(type);
        }
        Type type2 = this.f2558a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + f.k(type2);
    }
}
