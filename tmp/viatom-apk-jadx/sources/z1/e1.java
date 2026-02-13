package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 extends h2 {

    /* renamed from: a, reason: collision with root package name */
    public final g2 f14207a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14208b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14209c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14210d;

    public e1(f1 f1Var, String str, String str2, long j10) {
        this.f14207a = f1Var;
        this.f14208b = str;
        this.f14209c = str2;
        this.f14210d = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h2) {
            e1 e1Var = (e1) ((h2) obj);
            if (this.f14207a.equals(e1Var.f14207a) && this.f14208b.equals(e1Var.f14208b) && this.f14209c.equals(e1Var.f14209c) && this.f14210d == e1Var.f14210d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f14207a.hashCode() ^ 1000003) * 1000003) ^ this.f14208b.hashCode()) * 1000003) ^ this.f14209c.hashCode()) * 1000003;
        long j10 = this.f14210d;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutAssignment{rolloutVariant=");
        sb.append(this.f14207a);
        sb.append(", parameterKey=");
        sb.append(this.f14208b);
        sb.append(", parameterValue=");
        sb.append(this.f14209c);
        sb.append(", templateVersion=");
        return a3.a.l(sb, this.f14210d, "}");
    }
}
