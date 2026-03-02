package h8;

import com.google.android.gms.internal.measurement.l5;
import g8.k1;
import g8.u0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final o f8844a = new o();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f8845b = a.a.a("kotlinx.serialization.json.JsonLiteral", e8.d.f7963k);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        k kVarA = l5.g(eVar).a();
        if (kVarA instanceof n) {
            return (n) kVarA;
        }
        throw i8.l.e("Unexpected JSON element, expected JsonLiteral, had " + kotlin.jvm.internal.y.a(kVarA.getClass()), kVarA.toString(), -1);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8845b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        n nVar = (n) obj;
        nVar.getClass();
        String str = nVar.f8843b;
        l5.e(fVar);
        if (nVar.f8842a) {
            fVar.encodeString(str);
            return;
        }
        Long lV = o7.t.V(str);
        if (lV != null) {
            fVar.encodeLong(lV.longValue());
            return;
        }
        s6.r rVarM = l5.M(str);
        if (rVarM != null) {
            fVar.encodeInline(k1.f8286b).encodeLong(rVarM.f12706a);
            return;
        }
        Boolean bool = null;
        Double dValueOf = o7.s.S(str) ? Double.valueOf(Double.parseDouble(str)) : null;
        if (dValueOf != null) {
            fVar.encodeDouble(dValueOf.doubleValue());
            return;
        }
        if (str.equals("true")) {
            bool = Boolean.TRUE;
        } else if (str.equals("false")) {
            bool = Boolean.FALSE;
        }
        if (bool != null) {
            fVar.encodeBoolean(bool.booleanValue());
        } else {
            fVar.encodeString(str);
        }
    }
}
