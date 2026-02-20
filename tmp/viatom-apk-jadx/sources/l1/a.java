package l1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f10164a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10165b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10166c;

    public a(long j10, long j11, long j12) {
        this.f10164a = j10;
        this.f10165b = j11;
        this.f10166c = j12;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f10164a == aVar.f10164a && this.f10165b == aVar.f10165b && this.f10166c == aVar.f10166c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f10164a;
        long j11 = this.f10165b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f10166c;
        return i10 ^ ((int) ((j12 >>> 32) ^ j12));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StartupTime{epochMillis=");
        sb.append(this.f10164a);
        sb.append(", elapsedRealtime=");
        sb.append(this.f10165b);
        sb.append(", uptimeMillis=");
        return a3.a.l(sb, this.f10166c, "}");
    }
}
