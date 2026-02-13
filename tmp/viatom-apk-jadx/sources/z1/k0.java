package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k0 extends u1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14273a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14274b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14275c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14276d;
    public final String e;
    public final String f;

    public k0(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f14273a = str;
        this.f14274b = str2;
        this.f14275c = str3;
        this.f14276d = str4;
        this.e = str5;
        this.f = str6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u1) {
            k0 k0Var = (k0) ((u1) obj);
            if (this.f14273a.equals(k0Var.f14273a) && this.f14274b.equals(k0Var.f14274b)) {
                String str = k0Var.f14275c;
                String str2 = this.f14275c;
                if (str2 != null ? str2.equals(str) : str == null) {
                    String str3 = k0Var.f14276d;
                    String str4 = this.f14276d;
                    if (str4 != null ? str4.equals(str3) : str3 == null) {
                        String str5 = k0Var.e;
                        String str6 = this.e;
                        if (str6 != null ? str6.equals(str5) : str5 == null) {
                            String str7 = k0Var.f;
                            String str8 = this.f;
                            if (str8 != null ? str8.equals(str7) : str7 == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f14273a.hashCode() ^ 1000003) * 1000003) ^ this.f14274b.hashCode()) * 1000003;
        String str = this.f14275c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f14276d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{identifier=");
        sb.append(this.f14273a);
        sb.append(", version=");
        sb.append(this.f14274b);
        sb.append(", displayVersion=");
        sb.append(this.f14275c);
        sb.append(", organization=null, installationUuid=");
        sb.append(this.f14276d);
        sb.append(", developmentPlatform=");
        sb.append(this.e);
        sb.append(", developmentPlatformVersion=");
        return a3.a.o(sb, this.f, "}");
    }
}
