package w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a {
    public static final a f = new a(200, 10000, 81920, 10485760, 604800000);

    /* renamed from: a, reason: collision with root package name */
    public final long f13296a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13297b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13298c;

    /* renamed from: d, reason: collision with root package name */
    public final long f13299d;
    public final int e;

    public a(int i10, int i11, int i12, long j10, long j11) {
        this.f13296a = j10;
        this.f13297b = i10;
        this.f13298c = i11;
        this.f13299d = j11;
        this.e = i12;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f13296a == aVar.f13296a && this.f13297b == aVar.f13297b && this.f13298c == aVar.f13298c && this.f13299d == aVar.f13299d && this.e == aVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f13296a;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f13297b) * 1000003) ^ this.f13298c) * 1000003;
        long j11 = this.f13299d;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.f13296a);
        sb.append(", loadBatchSize=");
        sb.append(this.f13297b);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.f13298c);
        sb.append(", eventCleanUpAge=");
        sb.append(this.f13299d);
        sb.append(", maxBlobByteSizePerRow=");
        return a3.a.n(sb, "}", this.e);
    }
}
