package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n0 extends v1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f14306a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14307b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14308c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14309d;
    public final long e;
    public final boolean f;
    public final int g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f14310i;

    public n0(int i10, String str, int i11, long j10, long j11, boolean z9, int i12, String str2, String str3) {
        this.f14306a = i10;
        this.f14307b = str;
        this.f14308c = i11;
        this.f14309d = j10;
        this.e = j11;
        this.f = z9;
        this.g = i12;
        this.h = str2;
        this.f14310i = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v1) {
            n0 n0Var = (n0) ((v1) obj);
            if (this.f14306a == n0Var.f14306a && this.f14307b.equals(n0Var.f14307b) && this.f14308c == n0Var.f14308c && this.f14309d == n0Var.f14309d && this.e == n0Var.e && this.f == n0Var.f && this.g == n0Var.g && this.h.equals(n0Var.h) && this.f14310i.equals(n0Var.f14310i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f14306a ^ 1000003) * 1000003) ^ this.f14307b.hashCode()) * 1000003) ^ this.f14308c) * 1000003;
        long j10 = this.f14309d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.g) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.f14310i.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{arch=");
        sb.append(this.f14306a);
        sb.append(", model=");
        sb.append(this.f14307b);
        sb.append(", cores=");
        sb.append(this.f14308c);
        sb.append(", ram=");
        sb.append(this.f14309d);
        sb.append(", diskSpace=");
        sb.append(this.e);
        sb.append(", simulator=");
        sb.append(this.f);
        sb.append(", state=");
        sb.append(this.g);
        sb.append(", manufacturer=");
        sb.append(this.h);
        sb.append(", modelClass=");
        return a3.a.o(sb, this.f14310i, "}");
    }
}
