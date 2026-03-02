package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h1 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final h1 f8272a = new h1();

    /* renamed from: b, reason: collision with root package name */
    public static final y f8273b = o0.a("kotlin.UInt", c0.f8244a);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return new s6.p(eVar.decodeInline(f8273b).decodeInt());
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8273b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        fVar.encodeInline(f8273b).encodeInt(((s6.p) obj).f12704a);
    }
}
