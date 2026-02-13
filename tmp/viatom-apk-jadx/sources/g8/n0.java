package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n0 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8299a = s6.a.c(s6.g.f12690a, new androidx.lifecycle.k(this));

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        int iDecodeElementIndex;
        eVar.getClass();
        e8.e descriptor = getDescriptor();
        f8.c cVarBeginStructure = eVar.beginStructure(descriptor);
        if (!cVarBeginStructure.decodeSequentially() && (iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor())) != -1) {
            throw new c8.f(a3.a.f(iDecodeElementIndex, "Unexpected index "));
        }
        cVarBeginStructure.endStructure(descriptor);
        return s6.w.f12711a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, s6.f] */
    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return (e8.e) this.f8299a.getValue();
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        obj.getClass();
        fVar.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }
}
