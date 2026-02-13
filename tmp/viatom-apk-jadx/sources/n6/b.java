package n6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f11563a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11564b;

    public b(Integer num, a aVar) {
        this.f11563a = num;
        this.f11564b = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11563a.equals(bVar.f11563a) && this.f11564b.equals(bVar.f11564b);
    }

    public final int hashCode() {
        return this.f11564b.hashCode() + (this.f11563a.hashCode() * 31);
    }

    public final String toString() {
        return "GBCPurpose(id=" + this.f11563a + ", banner=" + this.f11564b + ')';
    }
}
