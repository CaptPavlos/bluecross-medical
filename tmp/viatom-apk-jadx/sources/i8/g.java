package i8;

import com.google.android.gms.internal.measurement.l5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends f8.a {

    /* renamed from: a, reason: collision with root package name */
    public final a6.f f9071a;

    /* renamed from: b, reason: collision with root package name */
    public final j8.f f9072b;

    public g(a6.f fVar, h8.b bVar) {
        bVar.getClass();
        this.f9071a = fVar;
        this.f9072b = bVar.f8827b;
    }

    @Override // f8.a, f8.e
    public final byte decodeByte() {
        s6.n nVar;
        a6.f fVar = this.f9071a;
        String strM = fVar.m();
        try {
            strM.getClass();
            s6.p pVarL = l5.L(strM);
            if (pVarL != null) {
                int i10 = pVarL.f12704a;
                nVar = Integer.compare(Integer.MIN_VALUE ^ i10, -2147483393) > 0 ? null : new s6.n((byte) i10);
            }
            if (nVar != null) {
                return nVar.f12702a;
            }
            o7.t.T(strM);
            throw null;
        } catch (IllegalArgumentException unused) {
            a6.f.o(fVar, "Failed to parse type 'UByte' for input '" + strM + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // f8.c
    public final int decodeElementIndex(e8.e eVar) {
        eVar.getClass();
        throw new IllegalStateException("unsupported");
    }

    @Override // f8.a, f8.e
    public final int decodeInt() {
        a6.f fVar = this.f9071a;
        String strM = fVar.m();
        try {
            strM.getClass();
            s6.p pVarL = l5.L(strM);
            if (pVarL != null) {
                return pVarL.f12704a;
            }
            o7.t.T(strM);
            throw null;
        } catch (IllegalArgumentException unused) {
            a6.f.o(fVar, "Failed to parse type 'UInt' for input '" + strM + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // f8.a, f8.e
    public final long decodeLong() {
        a6.f fVar = this.f9071a;
        String strM = fVar.m();
        try {
            strM.getClass();
            s6.r rVarM = l5.M(strM);
            if (rVarM != null) {
                return rVarM.f12706a;
            }
            o7.t.T(strM);
            throw null;
        } catch (IllegalArgumentException unused) {
            a6.f.o(fVar, "Failed to parse type 'ULong' for input '" + strM + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // f8.a, f8.e
    public final short decodeShort() {
        s6.u uVar;
        a6.f fVar = this.f9071a;
        String strM = fVar.m();
        try {
            strM.getClass();
            s6.p pVarL = l5.L(strM);
            if (pVarL != null) {
                int i10 = pVarL.f12704a;
                uVar = Integer.compare(Integer.MIN_VALUE ^ i10, -2147418113) > 0 ? null : new s6.u((short) i10);
            }
            if (uVar != null) {
                return uVar.f12709a;
            }
            o7.t.T(strM);
            throw null;
        } catch (IllegalArgumentException unused) {
            a6.f.o(fVar, "Failed to parse type 'UShort' for input '" + strM + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // f8.c
    public final j8.f getSerializersModule() {
        return this.f9072b;
    }
}
