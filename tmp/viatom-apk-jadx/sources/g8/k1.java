package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k1 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final k1 f8285a = new k1();

    /* renamed from: b, reason: collision with root package name */
    public static final y f8286b = o0.a("kotlin.ULong", i0.f8275a);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return new s6.r(eVar.decodeInline(f8286b).decodeLong());
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8286b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        fVar.encodeInline(f8286b).encodeLong(((s6.r) obj).f12706a);
    }
}
