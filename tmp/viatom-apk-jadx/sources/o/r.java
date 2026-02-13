package o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class r extends d0 {

    /* renamed from: a, reason: collision with root package name */
    public final q f11645a;

    public r(q qVar) {
        this.f11645a = qVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        return this.f11645a.equals(((r) ((d0) obj)).f11645a);
    }

    public final int hashCode() {
        return this.f11645a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f11645a + "}";
    }
}
