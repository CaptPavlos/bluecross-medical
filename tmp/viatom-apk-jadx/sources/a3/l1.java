package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class l1 implements g8.x {

    /* renamed from: a, reason: collision with root package name */
    public static final l1 f131a;
    private static final e8.e descriptor;

    static {
        l1 l1Var = new l1();
        f131a = l1Var;
        g8.q0 q0Var = new g8.q0("com.google.firebase.sessions.Time", l1Var, 3);
        q0Var.j("ms", false);
        q0Var.j("us", true);
        q0Var.j("seconds", true);
        descriptor = q0Var;
    }

    @Override // g8.x
    public final c8.b[] childSerializers() {
        g8.i0 i0Var = g8.i0.f8275a;
        return new c8.b[]{i0Var, i0Var, i0Var};
    }

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        int i10;
        long jDecodeLongElement;
        long j10;
        long j11;
        eVar.getClass();
        e8.e eVar2 = descriptor;
        f8.c cVarBeginStructure = eVar.beginStructure(eVar2);
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(eVar2, 0);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(eVar2, 1);
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(eVar2, 2);
            i10 = 7;
            j10 = jDecodeLongElement2;
            j11 = jDecodeLongElement3;
        } else {
            long jDecodeLongElement4 = 0;
            boolean z9 = true;
            int i11 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            while (z9) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(eVar2);
                if (iDecodeElementIndex == -1) {
                    z9 = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(eVar2, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(eVar2, 1);
                    i11 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new c8.h(iDecodeElementIndex);
                    }
                    jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(eVar2, 2);
                    i11 |= 4;
                }
            }
            i10 = i11;
            jDecodeLongElement = jDecodeLongElement4;
            j10 = jDecodeLongElement5;
            j11 = jDecodeLongElement6;
        }
        cVarBeginStructure.endStructure(eVar2);
        return new n1(i10, j10, j11, jDecodeLongElement);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return descriptor;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        n1 n1Var = (n1) obj;
        n1Var.getClass();
        e8.e eVar = descriptor;
        f8.d dVarBeginStructure = fVar.beginStructure(eVar);
        long j10 = n1Var.f137a;
        long j11 = n1Var.f139c;
        long j12 = n1Var.f138b;
        dVarBeginStructure.encodeLongElement(eVar, 0, j10);
        if (dVarBeginStructure.shouldEncodeElementDefault(eVar, 1) || j12 != 1000 * j10) {
            dVarBeginStructure.encodeLongElement(eVar, 1, j12);
        }
        if (dVarBeginStructure.shouldEncodeElementDefault(eVar, 2) || j11 != j10 / 1000) {
            dVarBeginStructure.encodeLongElement(eVar, 2, j11);
        }
        dVarBeginStructure.endStructure(eVar);
    }

    @Override // g8.x
    public final c8.b[] typeParametersSerializers() {
        return g8.o0.f8304b;
    }
}
