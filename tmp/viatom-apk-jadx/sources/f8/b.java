package f8;

import c8.g;
import g8.j0;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b implements f, d {
    @Override // f8.f
    public d beginCollection(e8.e eVar, int i10) {
        eVar.getClass();
        return beginStructure(eVar);
    }

    @Override // f8.f
    public d beginStructure(e8.e eVar) {
        eVar.getClass();
        return this;
    }

    @Override // f8.f
    public abstract void encodeBoolean(boolean z9);

    @Override // f8.d
    public final void encodeBooleanElement(e8.e eVar, int i10, boolean z9) {
        eVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeBoolean(z9);
        }
    }

    @Override // f8.f
    public abstract void encodeByte(byte b10);

    @Override // f8.d
    public final void encodeByteElement(e8.e eVar, int i10, byte b10) {
        eVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeByte(b10);
        }
    }

    @Override // f8.f
    public abstract void encodeChar(char c10);

    @Override // f8.d
    public final void encodeCharElement(e8.e eVar, int i10, char c10) {
        eVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeChar(c10);
        }
    }

    @Override // f8.f
    public abstract void encodeDouble(double d8);

    @Override // f8.d
    public final void encodeDoubleElement(e8.e eVar, int i10, double d8) {
        eVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeDouble(d8);
        }
    }

    public boolean encodeElement(e8.e eVar, int i10) {
        eVar.getClass();
        return true;
    }

    @Override // f8.f
    public abstract void encodeFloat(float f);

    @Override // f8.d
    public final void encodeFloatElement(e8.e eVar, int i10, float f) {
        eVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeFloat(f);
        }
    }

    @Override // f8.f
    public f encodeInline(e8.e eVar) {
        eVar.getClass();
        return this;
    }

    @Override // f8.d
    public final f encodeInlineElement(e8.e eVar, int i10) {
        eVar.getClass();
        return encodeElement(eVar, i10) ? encodeInline(eVar.h(i10)) : j0.f8281a;
    }

    @Override // f8.f
    public abstract void encodeInt(int i10);

    @Override // f8.d
    public final void encodeIntElement(e8.e eVar, int i10, int i11) {
        eVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeInt(i11);
        }
    }

    @Override // f8.f
    public abstract void encodeLong(long j10);

    @Override // f8.d
    public final void encodeLongElement(e8.e eVar, int i10, long j10) {
        eVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeLong(j10);
        }
    }

    @Override // f8.d
    public <T> void encodeNullableSerializableElement(e8.e eVar, int i10, g gVar, T t) {
        eVar.getClass();
        gVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeNullableSerializableValue(gVar, t);
        }
    }

    public <T> void encodeNullableSerializableValue(g gVar, T t) {
        gVar.getClass();
        if (gVar.getDescriptor().c()) {
            encodeSerializableValue(gVar, t);
        } else if (t == null) {
            encodeNull();
        } else {
            encodeNotNullMark();
            encodeSerializableValue(gVar, t);
        }
    }

    @Override // f8.d
    public <T> void encodeSerializableElement(e8.e eVar, int i10, g gVar, T t) {
        eVar.getClass();
        gVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeSerializableValue(gVar, t);
        }
    }

    @Override // f8.f
    public void encodeSerializableValue(g gVar, Object obj) {
        gVar.getClass();
        gVar.serialize(this, obj);
    }

    @Override // f8.f
    public abstract void encodeShort(short s9);

    @Override // f8.d
    public final void encodeShortElement(e8.e eVar, int i10, short s9) {
        eVar.getClass();
        if (encodeElement(eVar, i10)) {
            encodeShort(s9);
        }
    }

    @Override // f8.f
    public abstract void encodeString(String str);

    @Override // f8.d
    public final void encodeStringElement(e8.e eVar, int i10, String str) {
        eVar.getClass();
        str.getClass();
        if (encodeElement(eVar, i10)) {
            encodeString(str);
        }
    }

    public void encodeValue(Object obj) {
        obj.getClass();
        throw new c8.f("Non-serializable " + y.a(obj.getClass()) + " is not supported by " + y.a(getClass()) + " encoder");
    }

    @Override // f8.d
    public void endStructure(e8.e eVar) {
        eVar.getClass();
    }

    public boolean shouldEncodeElementDefault(e8.e eVar, int i10) {
        eVar.getClass();
        return true;
    }

    @Override // f8.f
    public void encodeNotNullMark() {
    }
}
