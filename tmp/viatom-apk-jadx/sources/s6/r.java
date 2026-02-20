package s6;

import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final long f12706a;

    public /* synthetic */ r(long j10) {
        this.f12706a = j10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.l.d(this.f12706a ^ Long.MIN_VALUE, ((r) obj).f12706a ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f12706a == ((r) obj).f12706a;
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f12706a;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public final String toString() {
        long j10 = this.f12706a;
        if (j10 >= 0) {
            t1.k(10);
            String string = Long.toString(j10, 10);
            string.getClass();
            return string;
        }
        long j11 = 10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        t1.k(10);
        String string2 = Long.toString(j12, 10);
        string2.getClass();
        t1.k(10);
        String string3 = Long.toString(j13, 10);
        string3.getClass();
        return string2.concat(string3);
    }
}
