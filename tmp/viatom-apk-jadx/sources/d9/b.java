package d9;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f7465a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7466b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7467c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7468d;
    public final String e;
    public final String f;

    public b(String str, String str2, String str3, String str4, String str5, List list) {
        str.getClass();
        list.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        this.f7465a = str;
        this.f7466b = list;
        this.f7467c = str2;
        this.f7468d = str3;
        this.e = str4;
        this.f = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.l.a(this.f7465a, bVar.f7465a) && kotlin.jvm.internal.l.a(this.f7466b, bVar.f7466b) && kotlin.jvm.internal.l.a(this.f7467c, bVar.f7467c) && kotlin.jvm.internal.l.a(this.f7468d, bVar.f7468d) && kotlin.jvm.internal.l.a(this.e, bVar.e) && kotlin.jvm.internal.l.a(this.f, bVar.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + a.a.b(this.e, a.a.b(this.f7468d, a.a.b(this.f7467c, m8.e.a(this.f7465a.hashCode() * 31, this.f7466b))));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CCPAScreen(title=");
        sb.append(this.f7465a);
        sb.append(", body=");
        sb.append(this.f7466b);
        sb.append(", deleteDataLinkText=");
        sb.append(this.f7467c);
        sb.append(", accessDataLinkText=");
        sb.append(this.f7468d);
        sb.append(", privacyPolicyLinkText=");
        sb.append(this.e);
        sb.append(", backLabel=");
        return a3.a.m(sb, this.f, ')');
    }
}
