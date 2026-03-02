package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n1 {
    public static final m1 Companion = new m1();

    /* renamed from: a, reason: collision with root package name */
    public final long f137a;

    /* renamed from: b, reason: collision with root package name */
    public final long f138b;

    /* renamed from: c, reason: collision with root package name */
    public final long f139c;

    public /* synthetic */ n1(int i10, long j10, long j11, long j12) {
        if (1 != (i10 & 1)) {
            g8.o0.e(l1.f131a.getDescriptor(), i10, 1);
            throw null;
        }
        this.f137a = j10;
        this.f138b = (i10 & 2) == 0 ? 1000 * j10 : j11;
        if ((i10 & 4) == 0) {
            this.f139c = j10 / 1000;
        } else {
            this.f139c = j12;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n1) && this.f137a == ((n1) obj).f137a;
    }

    public final int hashCode() {
        long j10 = this.f137a;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public final String toString() {
        return "Time(ms=" + this.f137a + ')';
    }

    public n1(long j10) {
        this.f137a = j10;
        long j11 = 1000;
        this.f138b = j10 * j11;
        this.f139c = j10 / j11;
    }
}
