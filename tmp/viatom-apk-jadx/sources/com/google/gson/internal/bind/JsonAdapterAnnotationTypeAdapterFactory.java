package com.google.gson.internal.bind;

import com.google.gson.internal.f;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import d0.i;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements j {

    /* renamed from: c, reason: collision with root package name */
    public static final j f2489c;

    /* renamed from: a, reason: collision with root package name */
    public final i f2490a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2491b = new ConcurrentHashMap();

    static {
        int i10 = 0;
        f2489c = new DummyTypeAdapterFactory(i10);
        new DummyTypeAdapterFactory(i10);
    }

    public JsonAdapterAnnotationTypeAdapterFactory(i iVar) {
        this.f2490a = iVar;
    }

    @Override // com.google.gson.j
    public final com.google.gson.i a(com.google.gson.b bVar, TypeToken typeToken) {
        f3.a aVar = (f3.a) typeToken.f2599a.getAnnotation(f3.a.class);
        if (aVar == null) {
            return null;
        }
        return b(this.f2490a, bVar, typeToken, aVar, true);
    }

    public final com.google.gson.i b(i iVar, com.google.gson.b bVar, TypeToken typeToken, f3.a aVar, boolean z9) {
        com.google.gson.i iVarA;
        Object objD = iVar.z(new TypeToken(aVar.value()), true).d();
        boolean zNullSafe = aVar.nullSafe();
        if (objD instanceof com.google.gson.i) {
            iVarA = (com.google.gson.i) objD;
        } else {
            if (!(objD instanceof j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objD.getClass().getName() + " as a @JsonAdapter for " + f.k(typeToken.f2600b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            j jVar = (j) objD;
            if (z9) {
                j jVar2 = (j) this.f2491b.putIfAbsent(typeToken.f2599a, jVar);
                if (jVar2 != null) {
                    jVar = jVar2;
                }
            }
            iVarA = jVar.a(bVar, typeToken);
        }
        return (iVarA == null || !zNullSafe) ? iVarA : iVarA.a();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class DummyTypeAdapterFactory implements j {
        private DummyTypeAdapterFactory() {
        }

        @Override // com.google.gson.j
        public final com.google.gson.i a(com.google.gson.b bVar, TypeToken typeToken) {
            throw new AssertionError("Factory should not be used");
        }

        public /* synthetic */ DummyTypeAdapterFactory(int i10) {
            this();
        }
    }
}
