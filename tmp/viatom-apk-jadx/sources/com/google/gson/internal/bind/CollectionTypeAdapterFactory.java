package com.google.gson.internal.bind;

import com.google.gson.internal.f;
import com.google.gson.internal.m;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import d0.i;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class CollectionTypeAdapterFactory implements j {

    /* renamed from: a, reason: collision with root package name */
    public final i f2479a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Adapter<E> extends com.google.gson.i {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.gson.i f2480a;

        /* renamed from: b, reason: collision with root package name */
        public final m f2481b;

        public Adapter(com.google.gson.i iVar, m mVar) {
            this.f2480a = iVar;
            this.f2481b = mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.i
        public final Object b(i3.a aVar) throws IOException {
            if (aVar.x() == 9) {
                aVar.t();
                return null;
            }
            Collection collection = (Collection) this.f2481b.d();
            aVar.a();
            while (aVar.k()) {
                collection.add(((TypeAdapterRuntimeTypeWrapper) this.f2480a).f2514b.b(aVar));
            }
            aVar.f();
            return collection;
        }

        @Override // com.google.gson.i
        public final void c(i3.b bVar, Object obj) throws IOException {
            Collection collection = (Collection) obj;
            if (collection == null) {
                bVar.k();
                return;
            }
            bVar.b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f2480a.c(bVar, it.next());
            }
            bVar.f();
        }
    }

    public CollectionTypeAdapterFactory(i iVar) {
        this.f2479a = iVar;
    }

    @Override // com.google.gson.j
    public final com.google.gson.i a(com.google.gson.b bVar, TypeToken typeToken) {
        Type type = typeToken.f2600b;
        Class cls = typeToken.f2599a;
        if (!Collection.class.isAssignableFrom(cls)) {
            return null;
        }
        Type typeH = f.h(type, cls, Collection.class);
        Class cls2 = typeH instanceof ParameterizedType ? ((ParameterizedType) typeH).getActualTypeArguments()[0] : Object.class;
        return new Adapter(new TypeAdapterRuntimeTypeWrapper(bVar, bVar.c(new TypeToken(cls2)), cls2), this.f2479a.z(typeToken, false));
    }
}
