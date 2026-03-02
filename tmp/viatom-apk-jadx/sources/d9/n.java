package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f7563a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7564b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7565c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7566d;
    public final String e;
    public final String f;
    public final String g;

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        this.f7563a = str;
        this.f7564b = str2;
        this.f7565c = str3;
        this.f7566d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return kotlin.jvm.internal.l.a(this.f7563a, nVar.f7563a) && kotlin.jvm.internal.l.a(this.f7564b, nVar.f7564b) && kotlin.jvm.internal.l.a(this.f7565c, nVar.f7565c) && kotlin.jvm.internal.l.a(this.f7566d, nVar.f7566d) && kotlin.jvm.internal.l.a(this.e, nVar.e) && kotlin.jvm.internal.l.a(this.f, nVar.f) && kotlin.jvm.internal.l.a(this.g, nVar.g);
    }

    public final int hashCode() {
        return this.g.hashCode() + a.a.b(this.f, a.a.b(this.e, a.a.b(this.f7566d, a.a.b(this.f7565c, a.a.b(this.f7564b, this.f7563a.hashCode() * 31)))));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PartnerScreen(title=");
        sb.append(this.f7563a);
        sb.append(", bodyText=");
        sb.append(this.f7564b);
        sb.append(", searchBarHint=");
        sb.append(this.f7565c);
        sb.append(", partnersLabel=");
        sb.append(this.f7566d);
        sb.append(", showAllVendorsMenu=");
        sb.append(this.e);
        sb.append(", showIABVendorsMenu=");
        sb.append(this.f);
        sb.append(", backLabel=");
        return a3.a.m(sb, this.g, ')');
    }
}
