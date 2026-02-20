package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 extends y1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14364a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14365b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14366c;

    public u0(String str, String str2, long j10) {
        this.f14364a = str;
        this.f14365b = str2;
        this.f14366c = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y1) {
            u0 u0Var = (u0) ((y1) obj);
            if (this.f14364a.equals(u0Var.f14364a) && this.f14365b.equals(u0Var.f14365b) && this.f14366c == u0Var.f14366c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f14364a.hashCode() ^ 1000003) * 1000003) ^ this.f14365b.hashCode()) * 1000003;
        long j10 = this.f14366c;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Signal{name=");
        sb.append(this.f14364a);
        sb.append(", code=");
        sb.append(this.f14365b);
        sb.append(", address=");
        return a3.a.l(sb, this.f14366c, "}");
    }
}
