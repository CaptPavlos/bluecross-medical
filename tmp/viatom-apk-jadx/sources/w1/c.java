package w1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f13324a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13325b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13326c;

    public c(String str, String str2, String str3) {
        if (str == null) {
            androidx.window.layout.c.k("Null crashlyticsInstallId");
            throw null;
        }
        this.f13324a = str;
        this.f13325b = str2;
        this.f13326c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f13324a.equals(cVar.f13324a)) {
                String str = cVar.f13325b;
                String str2 = this.f13325b;
                if (str2 != null ? str2.equals(str) : str == null) {
                    String str3 = cVar.f13326c;
                    String str4 = this.f13326c;
                    if (str4 != null ? str4.equals(str3) : str3 == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f13324a.hashCode() ^ 1000003) * 1000003;
        String str = this.f13325b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f13326c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallIds{crashlyticsInstallId=");
        sb.append(this.f13324a);
        sb.append(", firebaseInstallationId=");
        sb.append(this.f13325b);
        sb.append(", firebaseAuthenticationToken=");
        return a3.a.o(sb, this.f13326c, "}");
    }
}
