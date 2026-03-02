package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e0 implements g8.x {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f56a;
    private static final e8.e descriptor;

    static {
        e0 e0Var = new e0();
        f56a = e0Var;
        g8.q0 q0Var = new g8.q0("com.google.firebase.sessions.ProcessData", e0Var, 2);
        q0Var.j("pid", false);
        q0Var.j("uuid", false);
        descriptor = q0Var;
    }

    @Override // g8.x
    public final c8.b[] childSerializers() {
        return new c8.b[]{g8.c0.f8244a, g8.b1.f8241a};
    }

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        int iDecodeIntElement;
        String strDecodeStringElement;
        int i10;
        eVar.getClass();
        e8.e eVar2 = descriptor;
        f8.c cVarBeginStructure = eVar.beginStructure(eVar2);
        if (cVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(eVar2, 0);
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(eVar2, 1);
            i10 = 3;
        } else {
            String strDecodeStringElement2 = null;
            boolean z9 = true;
            iDecodeIntElement = 0;
            int i11 = 0;
            while (z9) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(eVar2);
                if (iDecodeElementIndex == -1) {
                    z9 = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = cVarBeginStructure.decodeIntElement(eVar2, 0);
                    i11 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new c8.h(iDecodeElementIndex);
                    }
                    strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(eVar2, 1);
                    i11 |= 2;
                }
            }
            strDecodeStringElement = strDecodeStringElement2;
            i10 = i11;
        }
        cVarBeginStructure.endStructure(eVar2);
        return new g0(i10, iDecodeIntElement, strDecodeStringElement);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return descriptor;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        g0 g0Var = (g0) obj;
        g0Var.getClass();
        e8.e eVar = descriptor;
        f8.d dVarBeginStructure = fVar.beginStructure(eVar);
        dVarBeginStructure.encodeIntElement(eVar, 0, g0Var.f71a);
        dVarBeginStructure.encodeStringElement(eVar, 1, g0Var.f72b);
        dVarBeginStructure.endStructure(eVar);
    }

    @Override // g8.x
    public final c8.b[] typeParametersSerializers() {
        return g8.o0.f8304b;
    }
}
