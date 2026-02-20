package v5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends m {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13168a;

    public l(Object obj) {
        this.f13168a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && kotlin.jvm.internal.l.a(this.f13168a, ((l) obj).f13168a);
    }

    public final int hashCode() {
        Object obj = this.f13168a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "Success(data=" + this.f13168a + ')';
    }
}
