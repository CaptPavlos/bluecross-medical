package d3;

import g8.c0;
import g8.i0;
import g8.o0;
import g8.q0;
import g8.r;
import g8.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements x {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6814a;
    private static final e8.e descriptor;

    static {
        e eVar = new e();
        f6814a = eVar;
        q0 q0Var = new q0("com.google.firebase.sessions.settings.SessionConfigs", eVar, 5);
        q0Var.j("sessionsEnabled", false);
        q0Var.j("sessionSamplingRate", false);
        q0Var.j("sessionTimeoutSeconds", false);
        q0Var.j("cacheDurationSeconds", false);
        q0Var.j("cacheUpdatedTimeSeconds", false);
        descriptor = q0Var;
    }

    @Override // g8.x
    public final c8.b[] childSerializers() {
        c8.b bVarB = l1.b.B(g8.g.f8264a);
        c8.b bVarB2 = l1.b.B(r.f8321a);
        c0 c0Var = c0.f8244a;
        return new c8.b[]{bVarB, bVarB2, l1.b.B(c0Var), l1.b.B(c0Var), l1.b.B(i0.f8275a)};
    }

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        int i10;
        Boolean bool;
        Double d8;
        Integer num;
        Integer num2;
        Long l10;
        eVar.getClass();
        e8.e eVar2 = descriptor;
        f8.c cVarBeginStructure = eVar.beginStructure(eVar2);
        Boolean bool2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            Boolean bool3 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 0, g8.g.f8264a, null);
            Double d10 = (Double) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 1, r.f8321a, null);
            c0 c0Var = c0.f8244a;
            Integer num3 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 2, c0Var, null);
            bool = bool3;
            num2 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 3, c0Var, null);
            l10 = (Long) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 4, i0.f8275a, null);
            num = num3;
            d8 = d10;
            i10 = 31;
        } else {
            boolean z9 = true;
            int i11 = 0;
            Double d11 = null;
            Integer num4 = null;
            Integer num5 = null;
            Long l11 = null;
            while (z9) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(eVar2);
                if (iDecodeElementIndex == -1) {
                    z9 = false;
                } else if (iDecodeElementIndex == 0) {
                    bool2 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 0, g8.g.f8264a, bool2);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    d11 = (Double) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 1, r.f8321a, d11);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    num4 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 2, c0.f8244a, num4);
                    i11 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    num5 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 3, c0.f8244a, num5);
                    i11 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new c8.h(iDecodeElementIndex);
                    }
                    l11 = (Long) cVarBeginStructure.decodeNullableSerializableElement(eVar2, 4, i0.f8275a, l11);
                    i11 |= 16;
                }
            }
            i10 = i11;
            bool = bool2;
            d8 = d11;
            num = num4;
            num2 = num5;
            l10 = l11;
        }
        cVarBeginStructure.endStructure(eVar2);
        return new g(i10, bool, d8, num, num2, l10);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return descriptor;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        g gVar = (g) obj;
        gVar.getClass();
        e8.e eVar = descriptor;
        f8.d dVarBeginStructure = fVar.beginStructure(eVar);
        dVarBeginStructure.encodeNullableSerializableElement(eVar, 0, g8.g.f8264a, gVar.f6815a);
        dVarBeginStructure.encodeNullableSerializableElement(eVar, 1, r.f8321a, gVar.f6816b);
        c0 c0Var = c0.f8244a;
        dVarBeginStructure.encodeNullableSerializableElement(eVar, 2, c0Var, gVar.f6817c);
        dVarBeginStructure.encodeNullableSerializableElement(eVar, 3, c0Var, gVar.f6818d);
        dVarBeginStructure.encodeNullableSerializableElement(eVar, 4, i0.f8275a, gVar.e);
        dVarBeginStructure.endStructure(eVar);
    }

    @Override // g8.x
    public final c8.b[] typeParametersSerializers() {
        return o0.f8304b;
    }
}
