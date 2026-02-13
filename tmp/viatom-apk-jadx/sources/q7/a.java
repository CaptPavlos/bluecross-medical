package q7;

import java.io.Serializable;
import l1.b;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final a f12283c = new a(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f12284a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12285b;

    public a(long j10, long j11) {
        this.f12284a = j10;
        this.f12285b = j11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a aVar = (a) obj;
        aVar.getClass();
        long j10 = aVar.f12284a;
        long j11 = this.f12284a;
        if (j11 != j10) {
            return Long.compare(j11 ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
        }
        return Long.compare(this.f12285b ^ Long.MIN_VALUE, aVar.f12285b ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12284a == aVar.f12284a && this.f12285b == aVar.f12285b;
    }

    public final int hashCode() {
        long j10 = this.f12284a ^ this.f12285b;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public final String toString() {
        byte[] bArr = new byte[36];
        b.A(this.f12284a, bArr, 0, 0, 4);
        bArr[8] = 45;
        b.A(this.f12284a, bArr, 9, 4, 6);
        bArr[13] = 45;
        b.A(this.f12284a, bArr, 14, 6, 8);
        bArr[18] = 45;
        b.A(this.f12285b, bArr, 19, 0, 2);
        bArr[23] = 45;
        b.A(this.f12285b, bArr, 24, 2, 8);
        return u.W(bArr);
    }
}
