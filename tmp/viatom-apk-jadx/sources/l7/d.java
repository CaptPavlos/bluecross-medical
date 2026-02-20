package l7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends b implements a {

    /* renamed from: d, reason: collision with root package name */
    public static final d f11091d = new d(1, 0, 1);

    @Override // l7.b
    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (isEmpty() && ((d) obj).isEmpty()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f11084a == dVar.f11084a && this.f11085b == dVar.f11085b;
    }

    @Override // l7.a
    public final Comparable getEndInclusive() {
        return Integer.valueOf(this.f11085b);
    }

    @Override // l7.a
    public final Comparable getStart() {
        return Integer.valueOf(this.f11084a);
    }

    @Override // l7.b
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f11084a * 31) + this.f11085b;
    }

    @Override // l7.b
    public final boolean isEmpty() {
        return this.f11084a > this.f11085b;
    }

    @Override // l7.b
    public final String toString() {
        return this.f11084a + ".." + this.f11085b;
    }
}
