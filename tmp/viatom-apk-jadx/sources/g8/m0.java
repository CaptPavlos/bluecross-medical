package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public final c8.b f8294a;

    /* renamed from: b, reason: collision with root package name */
    public final w0 f8295b;

    public m0(c8.b bVar) {
        bVar.getClass();
        this.f8294a = bVar;
        this.f8295b = new w0(bVar.getDescriptor());
    }

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return eVar.decodeNotNullMark() ? eVar.decodeSerializableValue(this.f8294a) : eVar.decodeNull();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && m0.class == obj.getClass() && kotlin.jvm.internal.l.a(this.f8294a, ((m0) obj).f8294a);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return this.f8295b;
    }

    public final int hashCode() {
        return this.f8294a.hashCode();
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        if (obj == null) {
            fVar.encodeNull();
        } else {
            fVar.encodeNotNullMark();
            fVar.encodeSerializableValue(this.f8294a, obj);
        }
    }
}
