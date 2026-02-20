package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v0 extends a2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14371a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14372b;

    /* renamed from: c, reason: collision with root package name */
    public final List f14373c;

    public v0(List list, String str, int i10) {
        this.f14371a = str;
        this.f14372b = i10;
        this.f14373c = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a2) {
            v0 v0Var = (v0) ((a2) obj);
            if (this.f14371a.equals(v0Var.f14371a) && this.f14372b == v0Var.f14372b && this.f14373c.equals(v0Var.f14373c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f14371a.hashCode() ^ 1000003) * 1000003) ^ this.f14372b) * 1000003) ^ this.f14373c.hashCode();
    }

    public final String toString() {
        return "Thread{name=" + this.f14371a + ", importance=" + this.f14372b + ", frames=" + this.f14373c + "}";
    }
}
