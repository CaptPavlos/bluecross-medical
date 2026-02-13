package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.f;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ArrayTypeAdapter<E> extends i {

    /* renamed from: c, reason: collision with root package name */
    public static final j f2476c = new j() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            Type type = typeToken.f2600b;
            boolean z9 = type instanceof GenericArrayType;
            if (!z9 && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type genericComponentType = z9 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
            return new ArrayTypeAdapter(bVar, bVar.c(new TypeToken(genericComponentType)), f.g(genericComponentType));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Class f2477a;

    /* renamed from: b, reason: collision with root package name */
    public final i f2478b;

    public ArrayTypeAdapter(com.google.gson.b bVar, i iVar, Class cls) {
        this.f2478b = new TypeAdapterRuntimeTypeWrapper(bVar, iVar, cls);
        this.f2477a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (aVar.x() == 9) {
            aVar.t();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.k()) {
            arrayList.add(((TypeAdapterRuntimeTypeWrapper) this.f2478b).f2514b.b(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        Class cls = this.f2477a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(objNewInstance, i10, arrayList.get(i10));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            bVar.k();
            return;
        }
        bVar.b();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f2478b.c(bVar, Array.get(obj, i10));
        }
        bVar.f();
    }
}
