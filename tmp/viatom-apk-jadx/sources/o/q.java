package o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class q extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f11644a;

    public q(Integer num) {
        this.f11644a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        Integer num = this.f11644a;
        q qVar = (q) ((c0) obj);
        return num == null ? qVar.f11644a == null : num.equals(qVar.f11644a);
    }

    public final int hashCode() {
        Integer num = this.f11644a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f11644a + "}";
    }
}
