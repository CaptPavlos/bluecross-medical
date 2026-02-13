package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f7580a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7581b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7582c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7583d;
    public final String e;
    public final String f;

    public s(String str, String str2, String str3, String str4, String str5, String str6) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        this.f7580a = str;
        this.f7581b = str2;
        this.f7582c = str3;
        this.f7583d = str4;
        this.e = str5;
        this.f = str6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.l.a(this.f7580a, sVar.f7580a) && kotlin.jvm.internal.l.a(this.f7581b, sVar.f7581b) && kotlin.jvm.internal.l.a(this.f7582c, sVar.f7582c) && kotlin.jvm.internal.l.a(this.f7583d, sVar.f7583d) && kotlin.jvm.internal.l.a(this.e, sVar.e) && kotlin.jvm.internal.l.a(this.f, sVar.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + a.a.b(this.e, a.a.b(this.f7583d, a.a.b(this.f7582c, a.a.b(this.f7581b, this.f7580a.hashCode() * 31))));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StacksScreen(title=");
        sb.append(this.f7580a);
        sb.append(", legalDescriptionTextLabel=");
        sb.append(this.f7581b);
        sb.append(", agreeToAllButton=");
        sb.append(this.f7582c);
        sb.append(", searchBarHint=");
        sb.append(this.f7583d);
        sb.append(", closeLabel=");
        sb.append(this.e);
        sb.append(", backLabel=");
        return a3.a.m(sb, this.f, ')');
    }
}
