package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f7518a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7519b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7520c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7521d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f7522i;

    /* renamed from: j, reason: collision with root package name */
    public final String f7523j;

    /* renamed from: k, reason: collision with root package name */
    public final String f7524k;

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        str10.getClass();
        str11.getClass();
        this.f7518a = str;
        this.f7519b = str2;
        this.f7520c = str3;
        this.f7521d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.f7522i = str9;
        this.f7523j = str10;
        this.f7524k = str11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.l.a(this.f7518a, jVar.f7518a) && kotlin.jvm.internal.l.a(this.f7519b, jVar.f7519b) && kotlin.jvm.internal.l.a(this.f7520c, jVar.f7520c) && kotlin.jvm.internal.l.a(this.f7521d, jVar.f7521d) && kotlin.jvm.internal.l.a(this.e, jVar.e) && kotlin.jvm.internal.l.a(this.f, jVar.f) && kotlin.jvm.internal.l.a(this.g, jVar.g) && kotlin.jvm.internal.l.a(this.h, jVar.h) && kotlin.jvm.internal.l.a(this.f7522i, jVar.f7522i) && kotlin.jvm.internal.l.a(this.f7523j, jVar.f7523j) && kotlin.jvm.internal.l.a(this.f7524k, jVar.f7524k);
    }

    public final int hashCode() {
        return this.f7524k.hashCode() + a.a.b(this.f7523j, a.a.b(this.f7522i, a.a.b(this.h, a.a.b(this.g, a.a.b(this.f, a.a.b(this.e, a.a.b(this.f7521d, a.a.b(this.f7520c, a.a.b(this.f7519b, this.f7518a.hashCode() * 31)))))))));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LegInterestScreen(title=");
        sb.append(this.f7518a);
        sb.append(", body=");
        sb.append(this.f7519b);
        sb.append(", objected=");
        sb.append(this.f7520c);
        sb.append(", accept=");
        sb.append(this.f7521d);
        sb.append(", objectAllButton=");
        sb.append(this.e);
        sb.append(", searchBarHint=");
        sb.append(this.f);
        sb.append(", purposesLabel=");
        sb.append(this.g);
        sb.append(", partnersLabel=");
        sb.append(this.h);
        sb.append(", showAllVendorsMenu=");
        sb.append(this.f7522i);
        sb.append(", showIABVendorsMenu=");
        sb.append(this.f7523j);
        sb.append(", backLabel=");
        return a3.a.m(sb, this.f7524k, ')');
    }
}
