package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final k f128a;

    /* renamed from: b, reason: collision with root package name */
    public final k f129b;

    /* renamed from: c, reason: collision with root package name */
    public final double f130c;

    public l(k kVar, k kVar2, double d8) {
        this.f128a = kVar;
        this.f129b = kVar2;
        this.f130c = d8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f128a == lVar.f128a && this.f129b == lVar.f129b && Double.compare(this.f130c, lVar.f130c) == 0;
    }

    public final int hashCode() {
        int iHashCode = (this.f129b.hashCode() + (this.f128a.hashCode() * 31)) * 31;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f130c);
        return iHashCode + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    public final String toString() {
        return "DataCollectionStatus(performance=" + this.f128a + ", crashlytics=" + this.f129b + ", sessionSamplingRate=" + this.f130c + ')';
    }
}
