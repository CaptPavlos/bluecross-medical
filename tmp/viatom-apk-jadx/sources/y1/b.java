package y1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends n {

    /* renamed from: b, reason: collision with root package name */
    public final String f13747b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13748c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13749d;
    public final String e;
    public final long f;

    public b(String str, String str2, String str3, String str4, long j10) {
        if (str == null) {
            androidx.window.layout.c.k("Null rolloutId");
            throw null;
        }
        this.f13747b = str;
        if (str2 == null) {
            androidx.window.layout.c.k("Null parameterKey");
            throw null;
        }
        this.f13748c = str2;
        this.f13749d = str3;
        if (str4 == null) {
            androidx.window.layout.c.k("Null variantId");
            throw null;
        }
        this.e = str4;
        this.f = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        b bVar = (b) ((n) obj);
        return this.f13747b.equals(bVar.f13747b) && this.f13748c.equals(bVar.f13748c) && this.f13749d.equals(bVar.f13749d) && this.e.equals(bVar.e) && this.f == bVar.f;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f13747b.hashCode() ^ 1000003) * 1000003) ^ this.f13748c.hashCode()) * 1000003) ^ this.f13749d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        long j10 = this.f;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutAssignment{rolloutId=");
        sb.append(this.f13747b);
        sb.append(", parameterKey=");
        sb.append(this.f13748c);
        sb.append(", parameterValue=");
        sb.append(this.f13749d);
        sb.append(", variantId=");
        sb.append(this.e);
        sb.append(", templateVersion=");
        return a3.a.l(sb, this.f, "}");
    }
}
