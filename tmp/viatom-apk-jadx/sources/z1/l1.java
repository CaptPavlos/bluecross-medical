package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14284a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14285b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14286c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14287d;
    public final int e;
    public final t1.c f;

    public l1(String str, String str2, String str3, String str4, int i10, t1.c cVar) {
        if (str == null) {
            androidx.window.layout.c.k("Null appIdentifier");
            throw null;
        }
        this.f14284a = str;
        if (str2 == null) {
            androidx.window.layout.c.k("Null versionCode");
            throw null;
        }
        this.f14285b = str2;
        if (str3 == null) {
            androidx.window.layout.c.k("Null versionName");
            throw null;
        }
        this.f14286c = str3;
        if (str4 == null) {
            androidx.window.layout.c.k("Null installUuid");
            throw null;
        }
        this.f14287d = str4;
        this.e = i10;
        this.f = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.f14284a.equals(l1Var.f14284a) && this.f14285b.equals(l1Var.f14285b) && this.f14286c.equals(l1Var.f14286c) && this.f14287d.equals(l1Var.f14287d) && this.e == l1Var.e && this.f.equals(l1Var.f);
    }

    public final int hashCode() {
        return ((((((((((this.f14284a.hashCode() ^ 1000003) * 1000003) ^ this.f14285b.hashCode()) * 1000003) ^ this.f14286c.hashCode()) * 1000003) ^ this.f14287d.hashCode()) * 1000003) ^ this.e) * 1000003) ^ this.f.hashCode();
    }

    public final String toString() {
        return "AppData{appIdentifier=" + this.f14284a + ", versionCode=" + this.f14285b + ", versionName=" + this.f14286c + ", installUuid=" + this.f14287d + ", deliveryMechanism=" + this.e + ", developmentPlatformProvider=" + this.f + "}";
    }
}
