package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b1 extends e2 {

    /* renamed from: a, reason: collision with root package name */
    public final Double f14169a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14170b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14171c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14172d;
    public final long e;
    public final long f;

    public b1(Double d8, int i10, boolean z9, int i11, long j10, long j11) {
        this.f14169a = d8;
        this.f14170b = i10;
        this.f14171c = z9;
        this.f14172d = i11;
        this.e = j10;
        this.f = j11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e2) {
            e2 e2Var = (e2) obj;
            Double d8 = this.f14169a;
            if (d8 != null ? d8.equals(((b1) e2Var).f14169a) : ((b1) e2Var).f14169a == null) {
                b1 b1Var = (b1) e2Var;
                if (this.f14170b == b1Var.f14170b && this.f14171c == b1Var.f14171c && this.f14172d == b1Var.f14172d && this.e == b1Var.e && this.f == b1Var.f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Double d8 = this.f14169a;
        int iHashCode = ((((((((d8 == null ? 0 : d8.hashCode()) ^ 1000003) * 1000003) ^ this.f14170b) * 1000003) ^ (this.f14171c ? 1231 : 1237)) * 1000003) ^ this.f14172d) * 1000003;
        long j10 = this.e;
        long j11 = this.f;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{batteryLevel=");
        sb.append(this.f14169a);
        sb.append(", batteryVelocity=");
        sb.append(this.f14170b);
        sb.append(", proximityOn=");
        sb.append(this.f14171c);
        sb.append(", orientation=");
        sb.append(this.f14172d);
        sb.append(", ramUsed=");
        sb.append(this.e);
        sb.append(", diskUsed=");
        return a3.a.l(sb, this.f, "}");
    }
}
