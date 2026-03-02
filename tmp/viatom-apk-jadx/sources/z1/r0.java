package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r0 extends b2 {

    /* renamed from: a, reason: collision with root package name */
    public final List f14341a;

    /* renamed from: b, reason: collision with root package name */
    public final x1 f14342b;

    /* renamed from: c, reason: collision with root package name */
    public final p1 f14343c;

    /* renamed from: d, reason: collision with root package name */
    public final u0 f14344d;
    public final List e;

    public r0(List list, t0 t0Var, p1 p1Var, u0 u0Var, List list2) {
        this.f14341a = list;
        this.f14342b = t0Var;
        this.f14343c = p1Var;
        this.f14344d = u0Var;
        this.e = list2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        List list = this.f14341a;
        if (list == null) {
            if (((r0) b2Var).f14341a != null) {
                return false;
            }
        } else if (!list.equals(((r0) b2Var).f14341a)) {
            return false;
        }
        x1 x1Var = this.f14342b;
        if (x1Var == null) {
            if (((r0) b2Var).f14342b != null) {
                return false;
            }
        } else if (!x1Var.equals(((r0) b2Var).f14342b)) {
            return false;
        }
        p1 p1Var = this.f14343c;
        if (p1Var == null) {
            if (((r0) b2Var).f14343c != null) {
                return false;
            }
        } else if (!p1Var.equals(((r0) b2Var).f14343c)) {
            return false;
        }
        r0 r0Var = (r0) b2Var;
        return this.f14344d.equals(r0Var.f14344d) && this.e.equals(r0Var.e);
    }

    public final int hashCode() {
        List list = this.f14341a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        x1 x1Var = this.f14342b;
        int iHashCode2 = (iHashCode ^ (x1Var == null ? 0 : x1Var.hashCode())) * 1000003;
        p1 p1Var = this.f14343c;
        return (((((p1Var != null ? p1Var.hashCode() : 0) ^ iHashCode2) * 1000003) ^ this.f14344d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public final String toString() {
        return "Execution{threads=" + this.f14341a + ", exception=" + this.f14342b + ", appExitInfo=" + this.f14343c + ", signal=" + this.f14344d + ", binaries=" + this.e + "}";
    }
}
