package g8;

import com.google.android.gms.internal.measurement.l5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b implements c8.b {
    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        Object objDecodeSerializableElement;
        eVar.getClass();
        c8.d dVar = (c8.d) this;
        e8.e descriptor = dVar.getDescriptor();
        f8.c cVarBeginStructure = eVar.beginStructure(descriptor);
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(dVar.getDescriptor(), 1, l5.u(this, cVarBeginStructure, cVarBeginStructure.decodeStringElement(dVar.getDescriptor(), 0)), null);
        } else {
            Object objDecodeSerializableElement2 = null;
            String strDecodeStringElement = null;
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(dVar.getDescriptor());
                if (iDecodeElementIndex != -1) {
                    if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = cVarBeginStructure.decodeStringElement(dVar.getDescriptor(), iDecodeElementIndex);
                    } else {
                        if (iDecodeElementIndex != 1) {
                            StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                            if (strDecodeStringElement == null) {
                                strDecodeStringElement = "unknown class";
                            }
                            sb.append(strDecodeStringElement);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(iDecodeElementIndex);
                            throw new c8.f(sb.toString());
                        }
                        if (strDecodeStringElement == null) {
                            com.google.gson.internal.a.n("Cannot read polymorphic value before its type token");
                            return null;
                        }
                        objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(dVar.getDescriptor(), iDecodeElementIndex, l5.u(this, cVarBeginStructure, strDecodeStringElement), null);
                    }
                } else {
                    if (objDecodeSerializableElement2 == null) {
                        z8.f.b(a3.a.i("Polymorphic value has not been read for class ", strDecodeStringElement));
                        return null;
                    }
                    objDecodeSerializableElement = objDecodeSerializableElement2;
                }
            }
        }
        cVarBeginStructure.endStructure(descriptor);
        return objDecodeSerializableElement;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        obj.getClass();
        c8.g gVarV = l5.v(this, (f8.b) fVar, obj);
        c8.d dVar = (c8.d) this;
        e8.e descriptor = dVar.getDescriptor();
        f8.d dVarBeginStructure = fVar.beginStructure(descriptor);
        dVarBeginStructure.encodeStringElement(dVar.getDescriptor(), 0, gVarV.getDescriptor().a());
        dVarBeginStructure.encodeSerializableElement(dVar.getDescriptor(), 1, gVarV, obj);
        dVarBeginStructure.endStructure(descriptor);
    }
}
