package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c1 extends f2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14182a;

    public c1(String str) {
        this.f14182a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        return this.f14182a.equals(((c1) ((f2) obj)).f14182a);
    }

    public final int hashCode() {
        return this.f14182a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return a3.a.o(new StringBuilder("Log{content="), this.f14182a, "}");
    }
}
