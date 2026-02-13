package o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class l extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f11631a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11632b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11633c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11634d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f11635i;

    /* renamed from: j, reason: collision with root package name */
    public final String f11636j;

    /* renamed from: k, reason: collision with root package name */
    public final String f11637k;

    /* renamed from: l, reason: collision with root package name */
    public final String f11638l;

    public l(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f11631a = num;
        this.f11632b = str;
        this.f11633c = str2;
        this.f11634d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.f11635i = str8;
        this.f11636j = str9;
        this.f11637k = str10;
        this.f11638l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f11631a.equals(((l) aVar).f11631a)) {
            return false;
        }
        if (!this.f11632b.equals(((l) aVar).f11632b)) {
            return false;
        }
        if (!this.f11633c.equals(((l) aVar).f11633c)) {
            return false;
        }
        if (!this.f11634d.equals(((l) aVar).f11634d)) {
            return false;
        }
        if (!this.e.equals(((l) aVar).e)) {
            return false;
        }
        if (!this.f.equals(((l) aVar).f)) {
            return false;
        }
        if (!this.g.equals(((l) aVar).g)) {
            return false;
        }
        if (!this.h.equals(((l) aVar).h)) {
            return false;
        }
        if (!this.f11635i.equals(((l) aVar).f11635i)) {
            return false;
        }
        if (!this.f11636j.equals(((l) aVar).f11636j)) {
            return false;
        }
        if (this.f11637k.equals(((l) aVar).f11637k)) {
            return this.f11638l.equals(((l) aVar).f11638l);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((this.f11631a.hashCode() ^ 1000003) * 1000003) ^ this.f11632b.hashCode()) * 1000003) ^ this.f11633c.hashCode()) * 1000003) ^ this.f11634d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.f11635i.hashCode()) * 1000003) ^ this.f11636j.hashCode()) * 1000003) ^ this.f11637k.hashCode()) * 1000003) ^ this.f11638l.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f11631a);
        sb.append(", model=");
        sb.append(this.f11632b);
        sb.append(", hardware=");
        sb.append(this.f11633c);
        sb.append(", device=");
        sb.append(this.f11634d);
        sb.append(", product=");
        sb.append(this.e);
        sb.append(", osBuild=");
        sb.append(this.f);
        sb.append(", manufacturer=");
        sb.append(this.g);
        sb.append(", fingerprint=");
        sb.append(this.h);
        sb.append(", locale=");
        sb.append(this.f11635i);
        sb.append(", country=");
        sb.append(this.f11636j);
        sb.append(", mccMnc=");
        sb.append(this.f11637k);
        sb.append(", applicationBuild=");
        return a3.a.o(sb, this.f11638l, "}");
    }
}
