package t7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f12851a;

    public j(Throwable th) {
        this.f12851a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return kotlin.jvm.internal.l.a(this.f12851a, ((j) obj).f12851a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f12851a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // t7.k
    public final String toString() {
        return "Closed(" + this.f12851a + ')';
    }
}
