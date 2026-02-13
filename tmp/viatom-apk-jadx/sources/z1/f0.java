package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 extends q1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14214a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14215b;

    public f0(String str, String str2) {
        this.f14214a = str;
        this.f14215b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q1)) {
            return false;
        }
        f0 f0Var = (f0) ((q1) obj);
        return this.f14214a.equals(f0Var.f14214a) && this.f14215b.equals(f0Var.f14215b);
    }

    public final int hashCode() {
        return ((this.f14214a.hashCode() ^ 1000003) * 1000003) ^ this.f14215b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CustomAttribute{key=");
        sb.append(this.f14214a);
        sb.append(", value=");
        return a3.a.o(sb, this.f14215b, "}");
    }
}
