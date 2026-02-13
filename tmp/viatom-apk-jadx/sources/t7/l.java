package t7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final k f12852b = new k();

    /* renamed from: a, reason: collision with root package name */
    public final Object f12853a;

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return kotlin.jvm.internal.l.a(this.f12853a, ((l) obj).f12853a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f12853a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f12853a;
        if (obj instanceof j) {
            return ((j) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
