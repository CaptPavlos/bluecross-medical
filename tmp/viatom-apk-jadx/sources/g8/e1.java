package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final e1 f8258a = new e1();

    /* renamed from: b, reason: collision with root package name */
    public static final y f8259b = o0.a("kotlin.UByte", j.f8279a);

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return new s6.n(eVar.decodeInline(f8259b).decodeByte());
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8259b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        fVar.encodeInline(f8259b).encodeByte(((s6.n) obj).f12702a);
    }
}
