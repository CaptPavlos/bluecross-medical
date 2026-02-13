package f8;

import c8.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface f {
    d beginCollection(e8.e eVar, int i10);

    d beginStructure(e8.e eVar);

    void encodeBoolean(boolean z9);

    void encodeByte(byte b10);

    void encodeChar(char c10);

    void encodeDouble(double d8);

    void encodeFloat(float f);

    f encodeInline(e8.e eVar);

    void encodeInt(int i10);

    void encodeLong(long j10);

    void encodeNotNullMark();

    void encodeNull();

    void encodeSerializableValue(g gVar, Object obj);

    void encodeShort(short s9);

    void encodeString(String str);

    j8.f getSerializersModule();
}
