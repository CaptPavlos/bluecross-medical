package f8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface c {
    boolean decodeBooleanElement(e8.e eVar, int i10);

    byte decodeByteElement(e8.e eVar, int i10);

    char decodeCharElement(e8.e eVar, int i10);

    int decodeCollectionSize(e8.e eVar);

    double decodeDoubleElement(e8.e eVar, int i10);

    int decodeElementIndex(e8.e eVar);

    float decodeFloatElement(e8.e eVar, int i10);

    e decodeInlineElement(e8.e eVar, int i10);

    int decodeIntElement(e8.e eVar, int i10);

    long decodeLongElement(e8.e eVar, int i10);

    Object decodeNullableSerializableElement(e8.e eVar, int i10, c8.a aVar, Object obj);

    boolean decodeSequentially();

    Object decodeSerializableElement(e8.e eVar, int i10, c8.a aVar, Object obj);

    short decodeShortElement(e8.e eVar, int i10);

    String decodeStringElement(e8.e eVar, int i10);

    void endStructure(e8.e eVar);

    j8.f getSerializersModule();
}
