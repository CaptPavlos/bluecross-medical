package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements ParameterizedType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f2555a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f2556b;

    /* renamed from: c, reason: collision with root package name */
    public final Type[] f2557c;

    public d(Type type, Class cls, Type... typeArr) {
        Objects.requireNonNull(cls);
        if (type == null && !Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
            androidx.window.layout.c.j(cls, "Must specify owner type for ");
            throw null;
        }
        this.f2555a = type == null ? null : f.a(type);
        this.f2556b = f.a(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f2557c = typeArr2;
        int length = typeArr2.length;
        for (int i10 = 0; i10 < length; i10++) {
            Objects.requireNonNull(this.f2557c[i10]);
            f.b(this.f2557c[i10]);
            Type[] typeArr3 = this.f2557c;
            typeArr3[i10] = f.a(typeArr3[i10]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && f.d(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f2557c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f2555a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f2556b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f2557c) ^ this.f2556b.hashCode();
        Type type = this.f2555a;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.f2557c;
        int length = typeArr.length;
        Type type = this.f2556b;
        if (length == 0) {
            return f.k(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(f.k(type));
        sb.append("<");
        sb.append(f.k(typeArr[0]));
        for (int i10 = 1; i10 < length; i10++) {
            sb.append(", ");
            sb.append(f.k(typeArr[i10]));
        }
        sb.append(">");
        return sb.toString();
    }
}
