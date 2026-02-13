package com.google.gson.reflect;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.google.gson.internal.f;
import j$.util.Objects;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class TypeToken<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2599a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f2600b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2601c;

    public TypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == TypeToken.class) {
                Type typeA = f.a(parameterizedType.getActualTypeArguments()[0]);
                if (!Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true")) {
                    a(typeA);
                }
                this.f2600b = typeA;
                this.f2599a = f.g(typeA);
                this.f2601c = typeA.hashCode();
                return;
            }
        } else if (genericSuperclass == TypeToken.class) {
            c.g("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee ".concat("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("type-token-raw")));
            throw null;
        }
        c.g("Must only create direct subclasses of TypeToken");
        throw null;
    }

    public static void a(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            StringBuilder sb = new StringBuilder("TypeToken type argument must not contain a type variable; captured type variable ");
            sb.append(typeVariable.getName());
            sb.append(" declared by ");
            sb.append(typeVariable.getGenericDeclaration());
            String strConcat = "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("typetoken-type-variable");
            sb.append("\nSee ");
            sb.append(strConcat);
            throw new IllegalArgumentException(sb.toString());
        }
        if (type instanceof GenericArrayType) {
            a(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        int i10 = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                a(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i10 < length) {
                a(actualTypeArguments[i10]);
                i10++;
            }
            return;
        }
        if (!(type instanceof WildcardType)) {
            if (type != null) {
                return;
            }
            a.n("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            return;
        }
        WildcardType wildcardType = (WildcardType) type;
        for (Type type2 : wildcardType.getLowerBounds()) {
            a(type2);
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        int length2 = upperBounds.length;
        while (i10 < length2) {
            a(upperBounds[i10]);
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return f.d(this.f2600b, ((TypeToken) obj).f2600b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2601c;
    }

    public final String toString() {
        return f.k(this.f2600b);
    }

    public TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type typeA = f.a(type);
        this.f2600b = typeA;
        this.f2599a = f.g(typeA);
        this.f2601c = typeA.hashCode();
    }
}
