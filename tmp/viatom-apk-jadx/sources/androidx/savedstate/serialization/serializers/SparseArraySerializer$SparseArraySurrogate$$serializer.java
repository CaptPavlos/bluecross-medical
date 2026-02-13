package androidx.savedstate.serialization.serializers;

import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import c8.b;
import c8.h;
import e8.e;
import f8.c;
import g8.d;
import g8.q0;
import g8.x;
import java.util.List;
import s6.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public /* synthetic */ class SparseArraySerializer$SparseArraySurrogate$$serializer<T> implements x {
    private final e descriptor;
    private final /* synthetic */ b typeSerial0;

    private SparseArraySerializer$SparseArraySurrogate$$serializer() {
        q0 q0Var = new q0("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", this, 2);
        q0Var.j("keys", false);
        q0Var.j("values", false);
        this.descriptor = q0Var;
    }

    private final /* synthetic */ b getTypeSerial0() {
        return this.typeSerial0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g8.x
    public final b[] childSerializers() {
        return new b[]{SparseArraySerializer.SparseArraySurrogate.$childSerializers[0].getValue(), new d(this.typeSerial0)};
    }

    @Override // c8.a
    public final SparseArraySerializer.SparseArraySurrogate<T> deserialize(f8.e eVar) {
        List list;
        List list2;
        int i10;
        eVar.getClass();
        e eVar2 = this.descriptor;
        c cVarBeginStructure = eVar.beginStructure(eVar2);
        f[] fVarArr = SparseArraySerializer.SparseArraySurrogate.$childSerializers;
        if (cVarBeginStructure.decodeSequentially()) {
            list = (List) cVarBeginStructure.decodeSerializableElement(eVar2, 0, (c8.a) fVarArr[0].getValue(), null);
            list2 = (List) cVarBeginStructure.decodeSerializableElement(eVar2, 1, new d(this.typeSerial0), null);
            i10 = 3;
        } else {
            boolean z9 = true;
            int i11 = 0;
            List list3 = null;
            List list4 = null;
            while (z9) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(eVar2);
                if (iDecodeElementIndex == -1) {
                    z9 = false;
                } else if (iDecodeElementIndex == 0) {
                    list3 = (List) cVarBeginStructure.decodeSerializableElement(eVar2, 0, (c8.a) fVarArr[0].getValue(), list3);
                    i11 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new h(iDecodeElementIndex);
                    }
                    list4 = (List) cVarBeginStructure.decodeSerializableElement(eVar2, 1, new d(this.typeSerial0), list4);
                    i11 |= 2;
                }
            }
            list = list3;
            list2 = list4;
            i10 = i11;
        }
        cVarBeginStructure.endStructure(eVar2);
        return new SparseArraySerializer.SparseArraySurrogate<>(i10, list, list2, null);
    }

    @Override // c8.g, c8.a
    public final e getDescriptor() {
        return this.descriptor;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, SparseArraySerializer.SparseArraySurrogate<T> sparseArraySurrogate) {
        fVar.getClass();
        sparseArraySurrogate.getClass();
        e eVar = this.descriptor;
        f8.d dVarBeginStructure = fVar.beginStructure(eVar);
        SparseArraySerializer.SparseArraySurrogate.write$Self$savedstate_release(sparseArraySurrogate, dVarBeginStructure, eVar, this.typeSerial0);
        dVarBeginStructure.endStructure(eVar);
    }

    @Override // g8.x
    public final b[] typeParametersSerializers() {
        return new b[]{this.typeSerial0};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SparseArraySerializer$SparseArraySurrogate$$serializer(b bVar) {
        this();
        bVar.getClass();
        this.typeSerial0 = bVar;
    }
}
