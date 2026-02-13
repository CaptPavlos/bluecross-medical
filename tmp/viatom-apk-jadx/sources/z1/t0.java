package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t0 extends x1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14357a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14358b;

    /* renamed from: c, reason: collision with root package name */
    public final List f14359c;

    /* renamed from: d, reason: collision with root package name */
    public final x1 f14360d;
    public final int e;

    public t0(String str, String str2, List list, x1 x1Var, int i10) {
        this.f14357a = str;
        this.f14358b = str2;
        this.f14359c = list;
        this.f14360d = x1Var;
        this.e = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x1) {
            t0 t0Var = (t0) ((x1) obj);
            if (this.f14357a.equals(t0Var.f14357a)) {
                String str = t0Var.f14358b;
                String str2 = this.f14358b;
                if (str2 != null ? str2.equals(str) : str == null) {
                    if (this.f14359c.equals(t0Var.f14359c)) {
                        x1 x1Var = t0Var.f14360d;
                        x1 x1Var2 = this.f14360d;
                        if (x1Var2 != null ? x1Var2.equals(x1Var) : x1Var == null) {
                            if (this.e == t0Var.e) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f14357a.hashCode() ^ 1000003) * 1000003;
        String str = this.f14358b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f14359c.hashCode()) * 1000003;
        x1 x1Var = this.f14360d;
        return ((iHashCode2 ^ (x1Var != null ? x1Var.hashCode() : 0)) * 1000003) ^ this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Exception{type=");
        sb.append(this.f14357a);
        sb.append(", reason=");
        sb.append(this.f14358b);
        sb.append(", frames=");
        sb.append(this.f14359c);
        sb.append(", causedBy=");
        sb.append(this.f14360d);
        sb.append(", overflowCount=");
        return a3.a.n(sb, "}", this.e);
    }
}
