package s6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final byte f12702a;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.l.c(this.f12702a & 255, ((n) obj).f12702a & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f12702a == ((n) obj).f12702a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f12702a;
    }

    public final String toString() {
        return String.valueOf(this.f12702a & 255);
    }
}
