package com.google.gson.internal.bind;

import c1.d0;
import com.google.gson.internal.f;
import com.google.gson.internal.m;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import d0.i;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MapTypeAdapterFactory implements j {

    /* renamed from: a, reason: collision with root package name */
    public final i f2493a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class Adapter<K, V> extends com.google.gson.i {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.gson.i f2494a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.gson.i f2495b;

        /* renamed from: c, reason: collision with root package name */
        public final m f2496c;

        public Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, com.google.gson.i iVar, com.google.gson.i iVar2, m mVar) {
            this.f2494a = iVar;
            this.f2495b = iVar2;
            this.f2496c = mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.i
        public final Object b(i3.a aVar) throws IOException {
            int iX = aVar.x();
            if (iX == 9) {
                aVar.t();
                return null;
            }
            Map map = (Map) this.f2496c.d();
            if (iX == 1) {
                aVar.a();
                while (aVar.k()) {
                    aVar.a();
                    Object objB = ((TypeAdapterRuntimeTypeWrapper) this.f2494a).f2514b.b(aVar);
                    if (map.put(objB, ((TypeAdapterRuntimeTypeWrapper) this.f2495b).f2514b.b(aVar)) != null) {
                        throw new com.google.gson.e("duplicate key: " + objB);
                    }
                    aVar.f();
                }
                aVar.f();
                return map;
            }
            aVar.b();
            while (aVar.k()) {
                d0.e.getClass();
                int iE = aVar.g;
                if (iE == 0) {
                    iE = aVar.e();
                }
                if (iE == 13) {
                    aVar.g = 9;
                } else if (iE == 12) {
                    aVar.g = 8;
                } else {
                    if (iE != 14) {
                        throw aVar.F("a name");
                    }
                    aVar.g = 10;
                }
                Object objB2 = ((TypeAdapterRuntimeTypeWrapper) this.f2494a).f2514b.b(aVar);
                if (map.put(objB2, ((TypeAdapterRuntimeTypeWrapper) this.f2495b).f2514b.b(aVar)) != null) {
                    throw new com.google.gson.e("duplicate key: " + objB2);
                }
            }
            aVar.h();
            return map;
        }

        @Override // com.google.gson.i
        public final void c(i3.b bVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                bVar.k();
                return;
            }
            bVar.d();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                bVar.i(String.valueOf(entry.getKey()));
                this.f2495b.c(bVar, entry.getValue());
            }
            bVar.h();
        }
    }

    public MapTypeAdapterFactory(i iVar) {
        this.f2493a = iVar;
    }

    @Override // com.google.gson.j
    public final com.google.gson.i a(com.google.gson.b bVar, TypeToken typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.f2600b;
        Class cls = typeToken.f2599a;
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (Properties.class.isAssignableFrom(cls)) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            Type typeH = f.h(type, cls, Map.class);
            actualTypeArguments = typeH instanceof ParameterizedType ? ((ParameterizedType) typeH).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        Type type3 = actualTypeArguments[1];
        return new Adapter(this, new TypeAdapterRuntimeTypeWrapper(bVar, (type2 == Boolean.TYPE || type2 == Boolean.class) ? e.f2536c : bVar.c(new TypeToken(type2)), type2), new TypeAdapterRuntimeTypeWrapper(bVar, bVar.c(new TypeToken(type3)), type3), this.f2493a.z(typeToken, false));
    }
}
