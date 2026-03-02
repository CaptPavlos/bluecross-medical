package t2;

import c.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f12759a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12760b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12761c;

    public b(int i10, long j10, String str) {
        this.f12759a = str;
        this.f12760b = j10;
        this.f12761c = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = bVar.f12759a;
        String str2 = this.f12759a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f12760b != bVar.f12760b) {
            return false;
        }
        int i10 = bVar.f12761c;
        int i11 = this.f12761c;
        return i11 == 0 ? i10 == 0 : i.a(i11, i10);
    }

    public final int hashCode() {
        String str = this.f12759a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f12760b;
        int i10 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        int i11 = this.f12761c;
        return (i11 != 0 ? i.c(i11) : 0) ^ i10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{token=");
        sb.append(this.f12759a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f12760b);
        sb.append(", responseCode=");
        int i10 = this.f12761c;
        sb.append(i10 != 1 ? i10 != 2 ? i10 != 3 ? "null" : "AUTH_ERROR" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
