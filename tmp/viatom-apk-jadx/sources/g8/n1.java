package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n1 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final n1 f8300a = new n1();

    /* renamed from: b, reason: collision with root package name */
    public static final y f8301b = o0.a("kotlin.UShort", a1.f8238a);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return new s6.u(eVar.decodeInline(f8301b).decodeShort());
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8301b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        fVar.encodeInline(f8301b).encodeShort(((s6.u) obj).f12709a);
    }
}
