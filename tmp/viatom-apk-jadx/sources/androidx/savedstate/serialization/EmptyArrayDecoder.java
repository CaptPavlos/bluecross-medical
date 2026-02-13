package androidx.savedstate.serialization;

import e8.e;
import j8.f;
import j8.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class EmptyArrayDecoder extends f8.a {
    public static final EmptyArrayDecoder INSTANCE = new EmptyArrayDecoder();
    private static final f serializersModule = h.f10036a;

    private EmptyArrayDecoder() {
    }

    @Override // f8.c
    public int decodeElementIndex(e eVar) {
        eVar.getClass();
        return -1;
    }

    @Override // f8.c
    public f getSerializersModule() {
        return serializersModule;
    }
}
