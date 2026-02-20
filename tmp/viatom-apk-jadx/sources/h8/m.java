package h8;

import com.google.android.gms.internal.measurement.l5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final m f8840a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final e8.f f8841b = a.a.j("kotlinx.serialization.json.JsonElement", e8.c.f7958d, new e8.e[0], new a3.q(24));

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return l5.g(eVar).a();
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8841b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        k kVar = (k) obj;
        kVar.getClass();
        l5.e(fVar);
        if (kVar instanceof x) {
            fVar.encodeSerializableValue(y.f8854a, kVar);
            return;
        }
        if (kVar instanceof t) {
            fVar.encodeSerializableValue(v.f8852a, kVar);
        } else if (kVar instanceof d) {
            fVar.encodeSerializableValue(f.f8833a, kVar);
        } else {
            androidx.window.layout.c.b();
        }
    }
}
