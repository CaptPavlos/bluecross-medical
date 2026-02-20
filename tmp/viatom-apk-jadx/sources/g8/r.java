package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final r f8321a = new r();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f8322b = new u0("kotlin.Double", e8.d.f);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return Double.valueOf(eVar.decodeDouble());
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8322b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        fVar.encodeDouble(((Number) obj).doubleValue());
    }
}
