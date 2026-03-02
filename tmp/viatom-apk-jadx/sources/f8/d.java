package f8;

import c8.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface d {
    void encodeBooleanElement(e8.e eVar, int i10, boolean z9);

    void encodeByteElement(e8.e eVar, int i10, byte b10);

    void encodeCharElement(e8.e eVar, int i10, char c10);

    void encodeDoubleElement(e8.e eVar, int i10, double d8);

    void encodeFloatElement(e8.e eVar, int i10, float f);

    f encodeInlineElement(e8.e eVar, int i10);

    void encodeIntElement(e8.e eVar, int i10, int i11);

    void encodeLongElement(e8.e eVar, int i10, long j10);

    void encodeNullableSerializableElement(e8.e eVar, int i10, g gVar, Object obj);

    void encodeSerializableElement(e8.e eVar, int i10, g gVar, Object obj);

    void encodeShortElement(e8.e eVar, int i10, short s9);

    void encodeStringElement(e8.e eVar, int i10, String str);

    void endStructure(e8.e eVar);

    boolean shouldEncodeElementDefault(e8.e eVar, int i10);
}
