package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends w6.a {

    /* renamed from: b, reason: collision with root package name */
    public static final t f12440b = new t();

    /* renamed from: a, reason: collision with root package name */
    public final String f12441a;

    public v() {
        super(f12440b);
        this.f12441a = "Room Invalidation Tracker Refresh";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && kotlin.jvm.internal.l.a(this.f12441a, ((v) obj).f12441a);
    }

    public final int hashCode() {
        return this.f12441a.hashCode();
    }

    public final String toString() {
        return a3.a.m(new StringBuilder("CoroutineName("), this.f12441a, ')');
    }
}
