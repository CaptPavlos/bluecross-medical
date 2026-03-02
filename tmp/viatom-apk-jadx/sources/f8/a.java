package f8;

import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements e, c {
    public static /* synthetic */ Object decodeSerializableValue$default(a aVar, c8.a aVar2, Object obj, int i10, Object obj2) {
        if (obj2 != null) {
            a2.a.m("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
            return null;
        }
        if ((i10 & 2) != 0) {
            obj = null;
        }
        return aVar.decodeSerializableValue(aVar2, obj);
    }

    @Override // f8.e
    public c beginStructure(e8.e eVar) {
        eVar.getClass();
        return this;
    }

    @Override // f8.e
    public boolean decodeBoolean() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Boolean) objDecodeValue).booleanValue();
    }

    @Override // f8.c
    public final boolean decodeBooleanElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeBoolean();
    }

    @Override // f8.e
    public byte decodeByte() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Byte) objDecodeValue).byteValue();
    }

    @Override // f8.c
    public final byte decodeByteElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeByte();
    }

    @Override // f8.e
    public char decodeChar() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Character) objDecodeValue).charValue();
    }

    @Override // f8.c
    public final char decodeCharElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeChar();
    }

    @Override // f8.c
    public int decodeCollectionSize(e8.e eVar) {
        eVar.getClass();
        return -1;
    }

    @Override // f8.e
    public double decodeDouble() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Double) objDecodeValue).doubleValue();
    }

    @Override // f8.c
    public final double decodeDoubleElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeDouble();
    }

    public int decodeEnum(e8.e eVar) {
        eVar.getClass();
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Integer) objDecodeValue).intValue();
    }

    @Override // f8.e
    public float decodeFloat() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Float) objDecodeValue).floatValue();
    }

    @Override // f8.c
    public final float decodeFloatElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeFloat();
    }

    @Override // f8.e
    public e decodeInline(e8.e eVar) {
        eVar.getClass();
        return this;
    }

    @Override // f8.c
    public e decodeInlineElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeInline(eVar.h(i10));
    }

    @Override // f8.e
    public int decodeInt() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Integer) objDecodeValue).intValue();
    }

    @Override // f8.c
    public final int decodeIntElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeInt();
    }

    @Override // f8.e
    public long decodeLong() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Long) objDecodeValue).longValue();
    }

    @Override // f8.c
    public final long decodeLongElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeLong();
    }

    @Override // f8.e
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // f8.e
    public Void decodeNull() {
        return null;
    }

    @Override // f8.c
    public final <T> T decodeNullableSerializableElement(e8.e eVar, int i10, c8.a aVar, T t) {
        eVar.getClass();
        aVar.getClass();
        return (aVar.getDescriptor().c() || decodeNotNullMark()) ? (T) decodeSerializableValue(aVar, t) : (T) decodeNull();
    }

    public <T> T decodeNullableSerializableValue(c8.a aVar) {
        aVar.getClass();
        return (aVar.getDescriptor().c() || decodeNotNullMark()) ? (T) decodeSerializableValue(aVar) : (T) decodeNull();
    }

    @Override // f8.c
    public boolean decodeSequentially() {
        return false;
    }

    @Override // f8.c
    public <T> T decodeSerializableElement(e8.e eVar, int i10, c8.a aVar, T t) {
        eVar.getClass();
        aVar.getClass();
        return (T) decodeSerializableValue(aVar, t);
    }

    @Override // f8.e
    public <T> T decodeSerializableValue(c8.a aVar) {
        aVar.getClass();
        return (T) aVar.deserialize(this);
    }

    @Override // f8.e
    public short decodeShort() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Short) objDecodeValue).shortValue();
    }

    @Override // f8.c
    public final short decodeShortElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeShort();
    }

    @Override // f8.e
    public String decodeString() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return (String) objDecodeValue;
    }

    @Override // f8.c
    public final String decodeStringElement(e8.e eVar, int i10) {
        eVar.getClass();
        return decodeString();
    }

    public Object decodeValue() {
        throw new c8.f(y.a(getClass()) + " can't retrieve untyped values");
    }

    @Override // f8.c
    public void endStructure(e8.e eVar) {
        eVar.getClass();
    }

    public <T> T decodeSerializableValue(c8.a aVar, T t) {
        aVar.getClass();
        return (T) decodeSerializableValue(aVar);
    }
}
