package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 extends g2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14216a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14217b;

    public f1(String str, String str2) {
        this.f14216a = str;
        this.f14217b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g2) {
            f1 f1Var = (f1) ((g2) obj);
            if (this.f14216a.equals(f1Var.f14216a) && this.f14217b.equals(f1Var.f14217b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f14216a.hashCode() ^ 1000003) * 1000003) ^ this.f14217b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutVariant{rolloutId=");
        sb.append(this.f14216a);
        sb.append(", variantId=");
        return a3.a.o(sb, this.f14217b, "}");
    }
}
