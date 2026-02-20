package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z0 extends c2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14397a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14398b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14399c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14400d;

    public z0(String str, int i10, int i11, boolean z9) {
        this.f14397a = str;
        this.f14398b = i10;
        this.f14399c = i11;
        this.f14400d = z9;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c2) {
            z0 z0Var = (z0) ((c2) obj);
            if (this.f14397a.equals(z0Var.f14397a) && this.f14398b == z0Var.f14398b && this.f14399c == z0Var.f14399c && this.f14400d == z0Var.f14400d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f14397a.hashCode() ^ 1000003) * 1000003) ^ this.f14398b) * 1000003) ^ this.f14399c) * 1000003) ^ (this.f14400d ? 1231 : 1237);
    }

    public final String toString() {
        return "ProcessDetails{processName=" + this.f14397a + ", pid=" + this.f14398b + ", importance=" + this.f14399c + ", defaultProcess=" + this.f14400d + "}";
    }
}
