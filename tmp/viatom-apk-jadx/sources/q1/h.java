package q1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final q f12233a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12234b;

    public h(q qVar, boolean z9) {
        this.f12233a = qVar;
        this.f12234b = z9;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.f12233a.equals(this.f12233a) && hVar.f12234b == this.f12234b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f12233a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f12234b).hashCode();
    }
}
