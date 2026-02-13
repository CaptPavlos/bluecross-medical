package o;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class t extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f11651a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11652b;

    /* renamed from: c, reason: collision with root package name */
    public final n f11653c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f11654d;
    public final String e;
    public final ArrayList f;

    public t(long j10, long j11, n nVar, Integer num, String str, ArrayList arrayList) {
        j0 j0Var = j0.f11626a;
        this.f11651a = j10;
        this.f11652b = j11;
        this.f11653c = nVar;
        this.f11654d = num;
        this.e = str;
        this.f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        t tVar = (t) ((f0) obj);
        if (this.f11651a != tVar.f11651a || this.f11652b != tVar.f11652b || !this.f11653c.equals(tVar.f11653c)) {
            return false;
        }
        Integer num = tVar.f11654d;
        Integer num2 = this.f11654d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str = tVar.e;
        String str2 = this.e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (!this.f.equals(tVar.f)) {
            return false;
        }
        Object obj2 = j0.f11626a;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        long j10 = this.f11651a;
        long j11 = this.f11652b;
        int iHashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f11653c.hashCode()) * 1000003;
        Integer num = this.f11654d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        return ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f.hashCode()) * 1000003) ^ j0.f11626a.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f11651a + ", requestUptimeMs=" + this.f11652b + ", clientInfo=" + this.f11653c + ", logSource=" + this.f11654d + ", logSourceName=" + this.e + ", logEvents=" + this.f + ", qosTier=" + j0.f11626a + "}";
    }
}
