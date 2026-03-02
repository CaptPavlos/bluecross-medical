package o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class n extends y {

    /* renamed from: a, reason: collision with root package name */
    public final l f11640a;

    public n(l lVar) {
        this.f11640a = lVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        Object obj2 = x.f11658a;
        if (obj2.equals(obj2)) {
            return this.f11640a.equals(((n) yVar).f11640a);
        }
        return false;
    }

    public final int hashCode() {
        return ((x.f11658a.hashCode() ^ 1000003) * 1000003) ^ this.f11640a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + x.f11658a + ", androidClientInfo=" + this.f11640a + "}";
    }
}
