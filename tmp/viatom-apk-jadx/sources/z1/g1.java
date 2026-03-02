package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g1 extends i2 {

    /* renamed from: a, reason: collision with root package name */
    public final List f14224a;

    public g1(List list) {
        this.f14224a = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        return this.f14224a.equals(((g1) ((i2) obj)).f14224a);
    }

    public final int hashCode() {
        return this.f14224a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f14224a + "}";
    }
}
