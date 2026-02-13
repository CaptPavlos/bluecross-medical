package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends n2 {

    /* renamed from: b, reason: collision with root package name */
    public final String f14161b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14162c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14163d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f14164i;

    /* renamed from: j, reason: collision with root package name */
    public final String f14165j;

    /* renamed from: k, reason: collision with root package name */
    public final m2 f14166k;

    /* renamed from: l, reason: collision with root package name */
    public final s1 f14167l;

    /* renamed from: m, reason: collision with root package name */
    public final p1 f14168m;

    public b0(String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, String str8, m2 m2Var, s1 s1Var, p1 p1Var) {
        this.f14161b = str;
        this.f14162c = str2;
        this.f14163d = i10;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.f14164i = str7;
        this.f14165j = str8;
        this.f14166k = m2Var;
        this.f14167l = s1Var;
        this.f14168m = p1Var;
    }

    public final a0 a() {
        a0 a0Var = new a0();
        a0Var.f14142a = this.f14161b;
        a0Var.f14143b = this.f14162c;
        a0Var.f14144c = this.f14163d;
        a0Var.f14145d = this.e;
        a0Var.e = this.f;
        a0Var.f = this.g;
        a0Var.g = this.h;
        a0Var.h = this.f14164i;
        a0Var.f14146i = this.f14165j;
        a0Var.f14147j = this.f14166k;
        a0Var.f14148k = this.f14167l;
        a0Var.f14149l = this.f14168m;
        a0Var.f14150m = (byte) 1;
        return a0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n2) {
            b0 b0Var = (b0) ((n2) obj);
            if (this.f14161b.equals(b0Var.f14161b) && this.f14162c.equals(b0Var.f14162c) && this.f14163d == b0Var.f14163d && this.e.equals(b0Var.e)) {
                String str = b0Var.f;
                String str2 = this.f;
                if (str2 != null ? str2.equals(str) : str == null) {
                    String str3 = b0Var.g;
                    String str4 = this.g;
                    if (str4 != null ? str4.equals(str3) : str3 == null) {
                        String str5 = b0Var.h;
                        String str6 = this.h;
                        if (str6 != null ? str6.equals(str5) : str5 == null) {
                            if (this.f14164i.equals(b0Var.f14164i) && this.f14165j.equals(b0Var.f14165j)) {
                                m2 m2Var = b0Var.f14166k;
                                m2 m2Var2 = this.f14166k;
                                if (m2Var2 != null ? m2Var2.equals(m2Var) : m2Var == null) {
                                    s1 s1Var = b0Var.f14167l;
                                    s1 s1Var2 = this.f14167l;
                                    if (s1Var2 != null ? s1Var2.equals(s1Var) : s1Var == null) {
                                        p1 p1Var = b0Var.f14168m;
                                        p1 p1Var2 = this.f14168m;
                                        if (p1Var2 != null ? p1Var2.equals(p1Var) : p1Var == null) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f14161b.hashCode() ^ 1000003) * 1000003) ^ this.f14162c.hashCode()) * 1000003) ^ this.f14163d) * 1000003) ^ this.e.hashCode()) * 1000003;
        String str = this.f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f14164i.hashCode()) * 1000003) ^ this.f14165j.hashCode()) * 1000003;
        m2 m2Var = this.f14166k;
        int iHashCode5 = (iHashCode4 ^ (m2Var == null ? 0 : m2Var.hashCode())) * 1000003;
        s1 s1Var = this.f14167l;
        int iHashCode6 = (iHashCode5 ^ (s1Var == null ? 0 : s1Var.hashCode())) * 1000003;
        p1 p1Var = this.f14168m;
        return iHashCode6 ^ (p1Var != null ? p1Var.hashCode() : 0);
    }

    public final String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f14161b + ", gmpAppId=" + this.f14162c + ", platform=" + this.f14163d + ", installationUuid=" + this.e + ", firebaseInstallationId=" + this.f + ", firebaseAuthenticationToken=" + this.g + ", appQualitySessionId=" + this.h + ", buildVersion=" + this.f14164i + ", displayVersion=" + this.f14165j + ", session=" + this.f14166k + ", ndkPayload=" + this.f14167l + ", appExitInfo=" + this.f14168m + "}";
    }
}
