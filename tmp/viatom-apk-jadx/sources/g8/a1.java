package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final a1 f8238a = new a1();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f8239b = new u0("kotlin.Short", e8.d.f7962j);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return Short.valueOf(eVar.decodeShort());
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8239b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        fVar.encodeShort(((Number) obj).shortValue());
    }
}
