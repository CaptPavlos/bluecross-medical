package o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class o extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f11641a;

    public o(r rVar) {
        z zVar = z.f11660a;
        this.f11641a = rVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        if (!this.f11641a.equals(((o) ((a0) obj)).f11641a)) {
            return false;
        }
        Object obj2 = z.f11660a;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return ((this.f11641a.hashCode() ^ 1000003) * 1000003) ^ z.f11660a.hashCode();
    }

    public final String toString() {
        return "ComplianceData{privacyContext=" + this.f11641a + ", productIdOrigin=" + z.f11660a + "}";
    }
}
