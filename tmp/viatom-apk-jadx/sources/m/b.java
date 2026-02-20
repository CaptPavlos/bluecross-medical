package m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f11152a;

    public b(Integer num) {
        this.f11152a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return this.f11152a.equals(((b) obj).f11152a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11152a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ProductData{productId=" + this.f11152a + "}";
    }
}
