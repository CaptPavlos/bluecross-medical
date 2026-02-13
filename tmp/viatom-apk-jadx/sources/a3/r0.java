package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class r0 implements g8.x {

    /* renamed from: a, reason: collision with root package name */
    public static final r0 f158a;
    private static final e8.e descriptor;

    static {
        r0 r0Var = new r0();
        f158a = r0Var;
        g8.q0 q0Var = new g8.q0("com.google.firebase.sessions.SessionDetails", r0Var, 4);
        q0Var.j("sessionId", false);
        q0Var.j("firstSessionId", false);
        q0Var.j("sessionIndex", false);
        q0Var.j("sessionStartTimestampUs", false);
        descriptor = q0Var;
    }

    @Override // g8.x
    public final c8.b[] childSerializers() {
        g8.b1 b1Var = g8.b1.f8241a;
        return new c8.b[]{b1Var, b1Var, g8.c0.f8244a, g8.i0.f8275a};
    }

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        String strDecodeStringElement;
        int i10;
        int iDecodeIntElement;
        String str;
        long jDecodeLongElement;
        eVar.getClass();
        e8.e eVar2 = descriptor;
        f8.c cVarBeginStructure = eVar.beginStructure(eVar2);
        if (cVarBeginStructure.decodeSequentially()) {
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(eVar2, 0);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(eVar2, 1);
            i10 = 15;
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(eVar2, 2);
            str = strDecodeStringElement2;
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(eVar2, 3);
        } else {
            strDecodeStringElement = null;
            String strDecodeStringElement3 = null;
            boolean z9 = true;
            long jDecodeLongElement2 = 0;
            int i11 = 0;
            int iDecodeIntElement2 = 0;
            while (z9) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(eVar2);
                if (iDecodeElementIndex == -1) {
                    z9 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(eVar2, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(eVar2, 1);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(eVar2, 2);
                    i11 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new c8.h(iDecodeElementIndex);
                    }
                    jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(eVar2, 3);
                    i11 |= 8;
                }
            }
            i10 = i11;
            iDecodeIntElement = iDecodeIntElement2;
            str = strDecodeStringElement3;
            jDecodeLongElement = jDecodeLongElement2;
        }
        String str2 = strDecodeStringElement;
        cVarBeginStructure.endStructure(eVar2);
        return new t0(i10, str2, iDecodeIntElement, str, jDecodeLongElement);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return descriptor;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        t0 t0Var = (t0) obj;
        t0Var.getClass();
        e8.e eVar = descriptor;
        f8.d dVarBeginStructure = fVar.beginStructure(eVar);
        dVarBeginStructure.encodeStringElement(eVar, 0, t0Var.f161a);
        dVarBeginStructure.encodeStringElement(eVar, 1, t0Var.f162b);
        dVarBeginStructure.encodeIntElement(eVar, 2, t0Var.f163c);
        dVarBeginStructure.encodeLongElement(eVar, 3, t0Var.f164d);
        dVarBeginStructure.endStructure(eVar);
    }

    @Override // g8.x
    public final c8.b[] typeParametersSerializers() {
        return g8.o0.f8304b;
    }
}
