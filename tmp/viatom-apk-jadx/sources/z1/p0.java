package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p0 extends j2 {

    /* renamed from: a, reason: collision with root package name */
    public final long f14325a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14326b;

    /* renamed from: c, reason: collision with root package name */
    public final d2 f14327c;

    /* renamed from: d, reason: collision with root package name */
    public final e2 f14328d;
    public final f2 e;
    public final i2 f;

    public p0(long j10, String str, d2 d2Var, e2 e2Var, f2 f2Var, i2 i2Var) {
        this.f14325a = j10;
        this.f14326b = str;
        this.f14327c = d2Var;
        this.f14328d = e2Var;
        this.e = f2Var;
        this.f = i2Var;
    }

    public final o0 a() {
        o0 o0Var = new o0();
        o0Var.f14317a = this.f14325a;
        o0Var.f14318b = this.f14326b;
        o0Var.f14319c = this.f14327c;
        o0Var.f14320d = this.f14328d;
        o0Var.e = this.e;
        o0Var.f = this.f;
        o0Var.g = (byte) 1;
        return o0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j2) {
            p0 p0Var = (p0) ((j2) obj);
            if (this.f14325a == p0Var.f14325a && this.f14326b.equals(p0Var.f14326b) && this.f14327c.equals(p0Var.f14327c) && this.f14328d.equals(p0Var.f14328d)) {
                f2 f2Var = p0Var.e;
                f2 f2Var2 = this.e;
                if (f2Var2 != null ? f2Var2.equals(f2Var) : f2Var == null) {
                    i2 i2Var = p0Var.f;
                    i2 i2Var2 = this.f;
                    if (i2Var2 != null ? i2Var2.equals(i2Var) : i2Var == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f14325a;
        int iHashCode = (((((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f14326b.hashCode()) * 1000003) ^ this.f14327c.hashCode()) * 1000003) ^ this.f14328d.hashCode()) * 1000003;
        f2 f2Var = this.e;
        int iHashCode2 = (iHashCode ^ (f2Var == null ? 0 : f2Var.hashCode())) * 1000003;
        i2 i2Var = this.f;
        return iHashCode2 ^ (i2Var != null ? i2Var.hashCode() : 0);
    }

    public final String toString() {
        return "Event{timestamp=" + this.f14325a + ", type=" + this.f14326b + ", app=" + this.f14327c + ", device=" + this.f14328d + ", log=" + this.e + ", rollouts=" + this.f + "}";
    }
}
