package o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class v extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f11656a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f11657b;

    public v(h0 h0Var, g0 g0Var) {
        this.f11656a = h0Var;
        this.f11657b = g0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            h0 h0Var = this.f11656a;
            if (h0Var != null ? h0Var.equals(((v) i0Var).f11656a) : ((v) i0Var).f11656a == null) {
                g0 g0Var = this.f11657b;
                if (g0Var != null ? g0Var.equals(((v) i0Var).f11657b) : ((v) i0Var).f11657b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        h0 h0Var = this.f11656a;
        int iHashCode = ((h0Var == null ? 0 : h0Var.hashCode()) ^ 1000003) * 1000003;
        g0 g0Var = this.f11657b;
        return (g0Var != null ? g0Var.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f11656a + ", mobileSubtype=" + this.f11657b + "}";
    }
}
