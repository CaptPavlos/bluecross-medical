package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends l2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14268a;

    public j1(String str) {
        this.f14268a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        return this.f14268a.equals(((j1) ((l2) obj)).f14268a);
    }

    public final int hashCode() {
        return this.f14268a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return a3.a.o(new StringBuilder("User{identifier="), this.f14268a, "}");
    }
}
