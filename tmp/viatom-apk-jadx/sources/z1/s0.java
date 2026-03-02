package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s0 extends w1 {

    /* renamed from: a, reason: collision with root package name */
    public final long f14349a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14350b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14351c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14352d;

    public s0(long j10, long j11, String str, String str2) {
        this.f14349a = j10;
        this.f14350b = j11;
        this.f14351c = str;
        this.f14352d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w1) {
            s0 s0Var = (s0) ((w1) obj);
            if (this.f14349a == s0Var.f14349a && this.f14350b == s0Var.f14350b && this.f14351c.equals(s0Var.f14351c)) {
                String str = s0Var.f14352d;
                String str2 = this.f14352d;
                if (str2 != null ? str2.equals(str) : str == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f14349a;
        long j11 = this.f14350b;
        int iHashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f14351c.hashCode()) * 1000003;
        String str = this.f14352d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BinaryImage{baseAddress=");
        sb.append(this.f14349a);
        sb.append(", size=");
        sb.append(this.f14350b);
        sb.append(", name=");
        sb.append(this.f14351c);
        sb.append(", uuid=");
        return a3.a.o(sb, this.f14352d, "}");
    }
}
