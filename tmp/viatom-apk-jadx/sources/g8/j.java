package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final j f8279a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f8280b = new u0("kotlin.Byte", e8.d.f7960d);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return Byte.valueOf(eVar.decodeByte());
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8280b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        fVar.encodeByte(((Number) obj).byteValue());
    }
}
