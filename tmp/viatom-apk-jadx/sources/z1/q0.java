package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public final r0 f14333a;

    /* renamed from: b, reason: collision with root package name */
    public final List f14334b;

    /* renamed from: c, reason: collision with root package name */
    public final List f14335c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f14336d;
    public final c2 e;
    public final List f;
    public final int g;

    public q0(r0 r0Var, List list, List list2, Boolean bool, c2 c2Var, List list3, int i10) {
        this.f14333a = r0Var;
        this.f14334b = list;
        this.f14335c = list2;
        this.f14336d = bool;
        this.e = c2Var;
        this.f = list3;
        this.g = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        q0 q0Var = (q0) ((d2) obj);
        if (!this.f14333a.equals(q0Var.f14333a)) {
            return false;
        }
        List list = q0Var.f14334b;
        List list2 = this.f14334b;
        if (list2 == null) {
            if (list != null) {
                return false;
            }
        } else if (!list2.equals(list)) {
            return false;
        }
        List list3 = q0Var.f14335c;
        List list4 = this.f14335c;
        if (list4 == null) {
            if (list3 != null) {
                return false;
            }
        } else if (!list4.equals(list3)) {
            return false;
        }
        Boolean bool = q0Var.f14336d;
        Boolean bool2 = this.f14336d;
        if (bool2 == null) {
            if (bool != null) {
                return false;
            }
        } else if (!bool2.equals(bool)) {
            return false;
        }
        c2 c2Var = q0Var.e;
        c2 c2Var2 = this.e;
        if (c2Var2 == null) {
            if (c2Var != null) {
                return false;
            }
        } else if (!c2Var2.equals(c2Var)) {
            return false;
        }
        List list5 = q0Var.f;
        List list6 = this.f;
        if (list6 == null) {
            if (list5 != null) {
                return false;
            }
        } else if (!list6.equals(list5)) {
            return false;
        }
        return this.g == q0Var.g;
    }

    public final int hashCode() {
        int iHashCode = (this.f14333a.hashCode() ^ 1000003) * 1000003;
        List list = this.f14334b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f14335c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f14336d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        c2 c2Var = this.e;
        int iHashCode5 = (iHashCode4 ^ (c2Var == null ? 0 : c2Var.hashCode())) * 1000003;
        List list3 = this.f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{execution=");
        sb.append(this.f14333a);
        sb.append(", customAttributes=");
        sb.append(this.f14334b);
        sb.append(", internalKeys=");
        sb.append(this.f14335c);
        sb.append(", background=");
        sb.append(this.f14336d);
        sb.append(", currentProcessDetails=");
        sb.append(this.e);
        sb.append(", appProcessDetails=");
        sb.append(this.f);
        sb.append(", uiOrientation=");
        return a3.a.n(sb, "}", this.g);
    }
}
