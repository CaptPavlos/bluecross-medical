package s6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final short f12709a;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.l.c(this.f12709a & 65535, ((u) obj).f12709a & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            return this.f12709a == ((u) obj).f12709a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f12709a;
    }

    public final String toString() {
        return String.valueOf(this.f12709a & 65535);
    }
}
