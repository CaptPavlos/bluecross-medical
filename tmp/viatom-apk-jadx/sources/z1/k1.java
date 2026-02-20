package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k1 {

    /* renamed from: a, reason: collision with root package name */
    public final l1 f14277a;

    /* renamed from: b, reason: collision with root package name */
    public final n1 f14278b;

    /* renamed from: c, reason: collision with root package name */
    public final m1 f14279c;

    public k1(l1 l1Var, n1 n1Var, m1 m1Var) {
        this.f14277a = l1Var;
        this.f14278b = n1Var;
        this.f14279c = m1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k1)) {
            return false;
        }
        k1 k1Var = (k1) obj;
        return this.f14277a.equals(k1Var.f14277a) && this.f14278b.equals(k1Var.f14278b) && this.f14279c.equals(k1Var.f14279c);
    }

    public final int hashCode() {
        return ((((this.f14277a.hashCode() ^ 1000003) * 1000003) ^ this.f14278b.hashCode()) * 1000003) ^ this.f14279c.hashCode();
    }

    public final String toString() {
        return "StaticSessionData{appData=" + this.f14277a + ", osData=" + this.f14278b + ", deviceData=" + this.f14279c + "}";
    }
}
