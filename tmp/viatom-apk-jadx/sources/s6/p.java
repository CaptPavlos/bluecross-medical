package s6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f12704a;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.l.c(this.f12704a ^ Integer.MIN_VALUE, ((p) obj).f12704a ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f12704a == ((p) obj).f12704a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f12704a;
    }

    public final String toString() {
        return String.valueOf(this.f12704a & 4294967295L);
    }
}
