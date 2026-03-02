package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x0 extends z1 {

    /* renamed from: a, reason: collision with root package name */
    public final long f14383a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14384b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14385c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14386d;
    public final int e;

    public x0(long j10, String str, String str2, long j11, int i10) {
        this.f14383a = j10;
        this.f14384b = str;
        this.f14385c = str2;
        this.f14386d = j11;
        this.e = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z1) {
            x0 x0Var = (x0) ((z1) obj);
            if (this.f14383a == x0Var.f14383a && this.f14384b.equals(x0Var.f14384b)) {
                String str = x0Var.f14385c;
                String str2 = this.f14385c;
                if (str2 != null ? str2.equals(str) : str == null) {
                    if (this.f14386d == x0Var.f14386d && this.e == x0Var.e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f14383a;
        int iHashCode = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f14384b.hashCode()) * 1000003;
        String str = this.f14385c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j11 = this.f14386d;
        return ((iHashCode2 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Frame{pc=");
        sb.append(this.f14383a);
        sb.append(", symbol=");
        sb.append(this.f14384b);
        sb.append(", file=");
        sb.append(this.f14385c);
        sb.append(", offset=");
        sb.append(this.f14386d);
        sb.append(", importance=");
        return a3.a.n(sb, "}", this.e);
    }
}
