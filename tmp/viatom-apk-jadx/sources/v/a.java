package v;

import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final t3.h f13090a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13091b;

    public a(t3.h hVar, HashMap map) {
        this.f13090a = hVar;
        this.f13091b = map;
    }

    public final long a(m.d dVar, long j10, int i10) {
        long jN = j10 - this.f13090a.n();
        b bVar = (b) this.f13091b.get(dVar);
        long j11 = bVar.f13092a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i10 - 1) * j11 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j11 > 1 ? j11 : 2L) * r12))), jN), bVar.f13093b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f13090a.equals(aVar.f13090a) && this.f13091b.equals(aVar.f13091b);
    }

    public final int hashCode() {
        return ((this.f13090a.hashCode() ^ 1000003) * 1000003) ^ this.f13091b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f13090a + ", values=" + this.f13091b + "}";
    }
}
