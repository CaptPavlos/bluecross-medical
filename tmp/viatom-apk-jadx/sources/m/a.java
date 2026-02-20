package m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11149a;

    /* renamed from: b, reason: collision with root package name */
    public final d f11150b;

    /* renamed from: c, reason: collision with root package name */
    public final b f11151c;

    public a(Object obj, d dVar, b bVar) {
        this.f11149a = obj;
        this.f11150b = dVar;
        this.f11151c = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f11149a.equals(aVar.f11149a) || !this.f11150b.equals(aVar.f11150b)) {
            return false;
        }
        b bVar = aVar.f11151c;
        b bVar2 = this.f11151c;
        return bVar2 == null ? bVar == null : bVar2.equals(bVar);
    }

    public final int hashCode() {
        int iHashCode = ((((1000003 * 1000003) ^ this.f11149a.hashCode()) * 1000003) ^ this.f11150b.hashCode()) * 1000003;
        b bVar = this.f11151c;
        return (iHashCode ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f11149a + ", priority=" + this.f11150b + ", productData=" + this.f11151c + ", eventContext=null}";
    }
}
