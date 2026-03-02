package o;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class m extends w {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11639a;

    public m(ArrayList arrayList) {
        this.f11639a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        return this.f11639a.equals(((m) ((w) obj)).f11639a);
    }

    public final int hashCode() {
        return this.f11639a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f11639a + "}";
    }
}
