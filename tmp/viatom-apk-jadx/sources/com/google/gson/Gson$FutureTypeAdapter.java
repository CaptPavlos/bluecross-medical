package com.google.gson;

import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class Gson$FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name */
    public i f2446a = null;

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) {
        i iVar = this.f2446a;
        if (iVar != null) {
            return iVar.b(aVar);
        }
        androidx.window.layout.c.g("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) {
        i iVar = this.f2446a;
        if (iVar != null) {
            iVar.c(bVar, obj);
        } else {
            androidx.window.layout.c.g("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public final i d() {
        i iVar = this.f2446a;
        if (iVar != null) {
            return iVar;
        }
        androidx.window.layout.c.g("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }
}
