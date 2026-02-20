package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i1 extends k2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f14247a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14248b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14249c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14250d;

    public i1(int i10, String str, String str2, boolean z9) {
        this.f14247a = i10;
        this.f14248b = str;
        this.f14249c = str2;
        this.f14250d = z9;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k2) {
            i1 i1Var = (i1) ((k2) obj);
            if (this.f14247a == i1Var.f14247a && this.f14248b.equals(i1Var.f14248b) && this.f14249c.equals(i1Var.f14249c) && this.f14250d == i1Var.f14250d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f14247a ^ 1000003) * 1000003) ^ this.f14248b.hashCode()) * 1000003) ^ this.f14249c.hashCode()) * 1000003) ^ (this.f14250d ? 1231 : 1237);
    }

    public final String toString() {
        return "OperatingSystem{platform=" + this.f14247a + ", version=" + this.f14248b + ", buildVersion=" + this.f14249c + ", jailbroken=" + this.f14250d + "}";
    }
}
