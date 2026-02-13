package h5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8562a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8563b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8564c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8565d;

    public g1(long j10, String str, String str2, String str3) {
        this.f8562a = str;
        this.f8563b = str2;
        this.f8564c = j10;
        this.f8565d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return kotlin.jvm.internal.l.a(this.f8562a, g1Var.f8562a) && kotlin.jvm.internal.l.a(this.f8563b, g1Var.f8563b) && this.f8564c == g1Var.f8564c && kotlin.jvm.internal.l.a(this.f8565d, g1Var.f8565d);
    }

    public final int hashCode() {
        String str = this.f8562a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f8563b;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        long j10 = this.f8564c;
        int i10 = (((iHashCode + iHashCode2) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        String str3 = this.f8565d;
        return i10 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserDeviceApp(name=");
        sb.append(this.f8562a);
        sb.append(", packagename=");
        sb.append(this.f8563b);
        sb.append(", lastUpdate=");
        sb.append(this.f8564c);
        sb.append(", icon=");
        return a3.a.m(sb, this.f8565d, ')');
    }
}
