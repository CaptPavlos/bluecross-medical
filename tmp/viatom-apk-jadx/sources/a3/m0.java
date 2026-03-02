package a3;

import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class m0 implements g8.x {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f133a;
    private static final e8.e descriptor;

    static {
        m0 m0Var = new m0();
        f133a = m0Var;
        g8.q0 q0Var = new g8.q0("com.google.firebase.sessions.SessionData", m0Var, 3);
        q0Var.j("sessionDetails", false);
        q0Var.j("backgroundTime", true);
        q0Var.j("processDataMap", true);
        descriptor = q0Var;
    }

    @Override // g8.x
    public final c8.b[] childSerializers() {
        return new c8.b[]{r0.f158a, l1.b.B(l1.f131a), l1.b.B(o0.f144d[2])};
    }

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        int i10;
        t0 t0Var;
        n1 n1Var;
        Map map;
        eVar.getClass();
        e8.e eVar2 = descriptor;
        f8.c cVarBeginStructure = eVar.beginStructure(eVar2);
        c8.b[] bVarArr = o0.f144d;
        t0 t0Var2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            t0Var = (t0) cVarBeginStructure.decodeSerializableElement(eVar2, 0, r0.f158a, null);
            n1Var = (n1) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 1, l1.f131a, null);
            map = (Map) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 2, bVarArr[2], null);
            i10 = 7;
        } else {
            boolean z9 = true;
            int i11 = 0;
            n1 n1Var2 = null;
            Map map2 = null;
            while (z9) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(eVar2);
                if (iDecodeElementIndex == -1) {
                    z9 = false;
                } else if (iDecodeElementIndex == 0) {
                    t0Var2 = (t0) cVarBeginStructure.decodeSerializableElement(eVar2, 0, r0.f158a, t0Var2);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    n1Var2 = (n1) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 1, l1.f131a, n1Var2);
                    i11 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new c8.h(iDecodeElementIndex);
                    }
                    map2 = (Map) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 2, bVarArr[2], map2);
                    i11 |= 4;
                }
            }
            i10 = i11;
            t0Var = t0Var2;
            n1Var = n1Var2;
            map = map2;
        }
        cVarBeginStructure.endStructure(eVar2);
        return new o0(i10, t0Var, n1Var, map);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return descriptor;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        o0 o0Var = (o0) obj;
        o0Var.getClass();
        e8.e eVar = descriptor;
        f8.d dVarBeginStructure = fVar.beginStructure(eVar);
        c8.b[] bVarArr = o0.f144d;
        r0 r0Var = r0.f158a;
        t0 t0Var = o0Var.f145a;
        Map map = o0Var.f147c;
        n1 n1Var = o0Var.f146b;
        dVarBeginStructure.encodeSerializableElement(eVar, 0, r0Var, t0Var);
        if (dVarBeginStructure.shouldEncodeElementDefault(eVar, 1) || n1Var != null) {
            dVarBeginStructure.encodeNullableSerializableElement(eVar, 1, l1.f131a, n1Var);
        }
        if (dVarBeginStructure.shouldEncodeElementDefault(eVar, 2) || map != null) {
            dVarBeginStructure.encodeNullableSerializableElement(eVar, 2, bVarArr[2], map);
        }
        dVarBeginStructure.endStructure(eVar);
    }

    @Override // g8.x
    public final c8.b[] typeParametersSerializers() {
        return g8.o0.f8304b;
    }
}
