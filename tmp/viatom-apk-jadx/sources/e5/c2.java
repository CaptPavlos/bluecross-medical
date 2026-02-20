package e5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c2 {

    /* renamed from: a, reason: collision with root package name */
    public final h5.x0 f7715a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7716b;

    public c2(h5.x0 x0Var, boolean z9) {
        this.f7715a = x0Var;
        this.f7716b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return this.f7715a.equals(c2Var.f7715a) && this.f7716b == c2Var.f7716b;
    }

    public final int hashCode() {
        return (this.f7715a.hashCode() * 31) + (this.f7716b ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TopByCategoryData(topByCategory=");
        sb.append(this.f7715a);
        sb.append(", firstRequest=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f7716b, ')');
    }
}
