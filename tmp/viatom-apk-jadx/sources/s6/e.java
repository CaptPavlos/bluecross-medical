package s6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final e f12688b = new e();

    /* renamed from: a, reason: collision with root package name */
    public final int f12689a = 131594;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        eVar.getClass();
        return this.f12689a - eVar.f12689a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        e eVar = obj instanceof e ? (e) obj : null;
        return eVar != null && this.f12689a == eVar.f12689a;
    }

    public final int hashCode() {
        return this.f12689a;
    }

    public final String toString() {
        return "2.2.10";
    }
}
