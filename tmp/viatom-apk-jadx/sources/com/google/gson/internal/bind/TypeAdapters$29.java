package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class TypeAdapters$29 implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f2516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f2517b;

    public TypeAdapters$29(Class cls, i iVar) {
        this.f2516a = cls;
        this.f2517b = iVar;
    }

    @Override // com.google.gson.j
    public final i a(com.google.gson.b bVar, TypeToken typeToken) {
        if (typeToken.f2599a == this.f2516a) {
            return this.f2517b;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f2516a.getName() + ",adapter=" + this.f2517b + "]";
    }
}
