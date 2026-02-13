package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q5 {

    /* renamed from: a, reason: collision with root package name */
    public final h5.d0 f10761a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10762b;

    public q5(h5.d0 d0Var, boolean z9) {
        d0Var.getClass();
        this.f10761a = d0Var;
        this.f10762b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q5)) {
            return false;
        }
        q5 q5Var = (q5) obj;
        return kotlin.jvm.internal.l.a(this.f10761a, q5Var.f10761a) && this.f10762b == q5Var.f10762b;
    }

    public final int hashCode() {
        return (this.f10761a.hashCode() * 31) + (this.f10762b ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OrganizationData(organization=");
        sb.append(this.f10761a);
        sb.append(", moreDataAdded=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f10762b, ')');
    }
}
