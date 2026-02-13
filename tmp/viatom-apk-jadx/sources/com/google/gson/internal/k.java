package com.google.gson.internal;

import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public k f2569a;

    /* renamed from: b, reason: collision with root package name */
    public k f2570b;

    /* renamed from: c, reason: collision with root package name */
    public k f2571c;

    /* renamed from: d, reason: collision with root package name */
    public k f2572d;
    public k e;
    public final Object f;
    public final boolean g;
    public Object h;

    /* renamed from: i, reason: collision with root package name */
    public int f2573i;

    public k(boolean z9, k kVar, Object obj, k kVar2, k kVar3) {
        this.f2569a = kVar;
        this.f = obj;
        this.g = z9;
        this.f2573i = 1;
        this.f2572d = kVar2;
        this.e = kVar3;
        kVar3.f2572d = this;
        kVar2.e = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.h;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.h;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.g) {
            androidx.window.layout.c.k("value == null");
            return null;
        }
        Object obj2 = this.h;
        this.h = obj;
        return obj2;
    }

    public final String toString() {
        return this.f + "=" + this.h;
    }

    public k(boolean z9) {
        this.f = null;
        this.g = z9;
        this.e = this;
        this.f2572d = this;
    }
}
