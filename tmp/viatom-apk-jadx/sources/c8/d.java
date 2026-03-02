package c8;

import a3.i0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends g8.b {

    /* renamed from: a, reason: collision with root package name */
    public final m7.c f1816a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1817b;

    public d(m7.c cVar) {
        cVar.getClass();
        this.f1816a = cVar;
        this.f1817b = s6.a.c(s6.g.f12690a, new i0(this, 8));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, s6.f] */
    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return (e8.e) this.f1817b.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.f1816a + ')';
    }
}
