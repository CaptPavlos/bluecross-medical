package y1;

import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f13750a;

    /* renamed from: b, reason: collision with root package name */
    public final long f13751b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f13752c;

    public c(String str, long j10, Map map) {
        map.getClass();
        this.f13750a = str;
        this.f13751b = j10;
        this.f13752c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f13750a.equals(cVar.f13750a) && this.f13751b == cVar.f13751b && kotlin.jvm.internal.l.a(this.f13752c, cVar.f13752c);
    }

    public final int hashCode() {
        int iHashCode = this.f13750a.hashCode() * 31;
        long j10 = this.f13751b;
        return this.f13752c.hashCode() + ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31);
    }

    public final String toString() {
        return "EventMetadata(sessionId=" + this.f13750a + ", timestamp=" + this.f13751b + ", additionalCustomKeys=" + this.f13752c + ')';
    }
}
