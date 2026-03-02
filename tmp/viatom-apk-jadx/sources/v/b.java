package v;

import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f13092a;

    /* renamed from: b, reason: collision with root package name */
    public final long f13093b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f13094c;

    public b(long j10, long j11, Set set) {
        this.f13092a = j10;
        this.f13093b = j11;
        this.f13094c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f13092a == bVar.f13092a && this.f13093b == bVar.f13093b && this.f13094c.equals(bVar.f13094c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f13092a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f13093b;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f13094c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f13092a + ", maxAllowedDelay=" + this.f13093b + ", flags=" + this.f13094c + "}";
    }
}
