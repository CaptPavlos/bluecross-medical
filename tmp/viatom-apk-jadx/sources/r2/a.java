package r2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12343a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12344b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12345c;

    public a(String str, long j10, long j11) {
        this.f12343a = str;
        this.f12344b = j10;
        this.f12345c = j11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f12343a.equals(aVar.f12343a) && this.f12344b == aVar.f12344b && this.f12345c == aVar.f12345c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f12343a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f12344b;
        long j11 = this.f12345c;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationTokenResult{token=");
        sb.append(this.f12343a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f12344b);
        sb.append(", tokenCreationTimestamp=");
        return a3.a.l(sb, this.f12345c, "}");
    }
}
