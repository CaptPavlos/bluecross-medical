package e5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7830a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7831b;

    public p0(boolean z9, int i10) {
        this.f7830a = z9;
        this.f7831b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return this.f7830a == p0Var.f7830a && this.f7831b == p0Var.f7831b;
    }

    public final int hashCode() {
        return ((this.f7830a ? 1231 : 1237) * 31) + this.f7831b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SendReviewActionData(succeed=");
        sb.append(this.f7830a);
        sb.append(", statusCode=");
        return a3.a.k(sb, this.f7831b, ')');
    }
}
