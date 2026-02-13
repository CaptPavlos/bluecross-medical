package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final c1 f165a;

    /* renamed from: b, reason: collision with root package name */
    public final c f166b;

    public u0(c1 c1Var, c cVar) {
        this.f165a = c1Var;
        this.f166b = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f165a.equals(u0Var.f165a) && this.f166b.equals(u0Var.f166b);
    }

    public final int hashCode() {
        return this.f166b.hashCode() + ((this.f165a.hashCode() + (n.SESSION_START.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SessionEvent(eventType=" + n.SESSION_START + ", sessionData=" + this.f165a + ", applicationInfo=" + this.f166b + ')';
    }
}
