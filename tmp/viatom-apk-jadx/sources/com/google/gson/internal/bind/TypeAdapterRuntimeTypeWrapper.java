package com.google.gson.internal.bind;

import com.google.gson.i;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends i {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.b f2513a;

    /* renamed from: b, reason: collision with root package name */
    public final i f2514b;

    /* renamed from: c, reason: collision with root package name */
    public final Type f2515c;

    public TypeAdapterRuntimeTypeWrapper(com.google.gson.b bVar, i iVar, Type type) {
        this.f2513a = bVar;
        this.f2514b = iVar;
        this.f2515c = type;
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) {
        return this.f2514b.b(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.Type] */
    @Override // com.google.gson.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(i3.b r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.reflect.Type r0 = r4.f2515c
            if (r6 == 0) goto L11
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 != 0) goto Lc
            boolean r1 = r0 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L11
        Lc:
            java.lang.Class r1 = r6.getClass()
            goto L12
        L11:
            r1 = r0
        L12:
            com.google.gson.i r2 = r4.f2514b
            if (r1 == r0) goto L3d
            com.google.gson.reflect.TypeToken r0 = new com.google.gson.reflect.TypeToken
            r0.<init>(r1)
            com.google.gson.b r1 = r4.f2513a
            com.google.gson.i r0 = r1.c(r0)
            boolean r1 = r0 instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
            if (r1 != 0) goto L26
            goto L3c
        L26:
            r1 = r2
        L27:
            boolean r3 = r1 instanceof com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
            if (r3 == 0) goto L37
            r3 = r1
            com.google.gson.internal.bind.SerializationDelegatingTypeAdapter r3 = (com.google.gson.internal.bind.SerializationDelegatingTypeAdapter) r3
            com.google.gson.i r3 = r3.d()
            if (r3 != r1) goto L35
            goto L37
        L35:
            r1 = r3
            goto L27
        L37:
            boolean r1 = r1 instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
            if (r1 != 0) goto L3c
            goto L3d
        L3c:
            r2 = r0
        L3d:
            r2.c(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.c(i3.b, java.lang.Object):void");
    }
}
