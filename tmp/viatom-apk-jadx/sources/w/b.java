package w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f13300a;

    /* renamed from: b, reason: collision with root package name */
    public final p.i f13301b;

    /* renamed from: c, reason: collision with root package name */
    public final p.h f13302c;

    public b(long j10, p.i iVar, p.h hVar) {
        this.f13300a = j10;
        this.f13301b = iVar;
        this.f13302c = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13300a == bVar.f13300a && this.f13301b.equals(bVar.f13301b) && this.f13302c.equals(bVar.f13302c);
    }

    public final int hashCode() {
        long j10 = this.f13300a;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f13301b.hashCode()) * 1000003) ^ this.f13302c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f13300a + ", transportContext=" + this.f13301b + ", event=" + this.f13302c + "}";
    }
}
