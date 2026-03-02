package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final w f8337a = new w();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f8338b = new u0("kotlin.Float", e8.d.g);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return Float.valueOf(eVar.decodeFloat());
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8338b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        fVar.encodeFloat(((Number) obj).floatValue());
    }
}
