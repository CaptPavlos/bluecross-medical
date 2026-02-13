package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class TypeAdapters$30 implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f2518a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f2519b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f2520c;

    public TypeAdapters$30(Class cls, Class cls2, i iVar) {
        this.f2518a = cls;
        this.f2519b = cls2;
        this.f2520c = iVar;
    }

    @Override // com.google.gson.j
    public final i a(com.google.gson.b bVar, TypeToken typeToken) {
        Class cls = typeToken.f2599a;
        if (cls == this.f2518a || cls == this.f2519b) {
            return this.f2520c;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f2519b.getName() + "+" + this.f2518a.getName() + ",adapter=" + this.f2520c + "]";
    }
}
