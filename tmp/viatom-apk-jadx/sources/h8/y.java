package h8;

import com.google.android.gms.internal.measurement.l5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final y f8854a = new y();

    /* renamed from: b, reason: collision with root package name */
    public static final e8.f f8855b = a.a.k("kotlinx.serialization.json.JsonPrimitive", e8.d.f7963k, new e8.e[0]);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        k kVarA = l5.g(eVar).a();
        if (kVarA instanceof x) {
            return (x) kVarA;
        }
        throw i8.l.e("Unexpected JSON element, expected JsonPrimitive, had " + kotlin.jvm.internal.y.a(kVarA.getClass()), kVarA.toString(), -1);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8855b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        x xVar = (x) obj;
        xVar.getClass();
        l5.e(fVar);
        if (xVar instanceof q) {
            fVar.encodeSerializableValue(r.f8846a, q.INSTANCE);
        } else {
            fVar.encodeSerializableValue(o.f8844a, (n) xVar);
        }
    }
}
