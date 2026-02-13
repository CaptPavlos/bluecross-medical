package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends s1 {

    /* renamed from: a, reason: collision with root package name */
    public final List f14222a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14223b;

    public g0(String str, List list) {
        this.f14222a = list;
        this.f14223b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s1)) {
            return false;
        }
        g0 g0Var = (g0) ((s1) obj);
        if (!this.f14222a.equals(g0Var.f14222a)) {
            return false;
        }
        String str = g0Var.f14223b;
        String str2 = this.f14223b;
        return str2 == null ? str == null : str2.equals(str);
    }

    public final int hashCode() {
        int iHashCode = (this.f14222a.hashCode() ^ 1000003) * 1000003;
        String str = this.f14223b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FilesPayload{files=");
        sb.append(this.f14222a);
        sb.append(", orgId=");
        return a3.a.o(sb, this.f14223b, "}");
    }
}
