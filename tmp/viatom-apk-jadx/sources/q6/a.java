package q6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12280a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12281b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12282c;

    public a(String str, String str2, String str3) {
        this.f12280a = str;
        this.f12281b = str2;
        this.f12282c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12280a.equals(aVar.f12280a) && this.f12281b.equals(aVar.f12281b) && this.f12282c.equals(aVar.f12282c);
    }

    public final int hashCode() {
        return this.f12282c.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(this.f12280a.hashCode() * 31, 31, this.f12281b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GeoIP(country=");
        sb.append(this.f12280a);
        sb.append(", region=");
        sb.append(this.f12281b);
        sb.append(", city=");
        return a3.a.m(sb, this.f12282c, ')');
    }
}
