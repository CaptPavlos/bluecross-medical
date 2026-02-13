package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f7512a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7513b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7514c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7515d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final e f7516i;

    /* renamed from: j, reason: collision with root package name */
    public final a f7517j;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, e eVar, a aVar) {
        str.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str8.getClass();
        this.f7512a = str;
        this.f7513b = str2;
        this.f7514c = str3;
        this.f7515d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.f7516i = eVar;
        this.f7517j = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.l.a(this.f7512a, iVar.f7512a) && this.f7513b.equals(iVar.f7513b) && kotlin.jvm.internal.l.a(this.f7514c, iVar.f7514c) && kotlin.jvm.internal.l.a(this.f7515d, iVar.f7515d) && kotlin.jvm.internal.l.a(this.e, iVar.e) && kotlin.jvm.internal.l.a(this.f, iVar.f) && this.g.equals(iVar.g) && kotlin.jvm.internal.l.a(this.h, iVar.h) && this.f7516i.equals(iVar.f7516i) && this.f7517j.equals(iVar.f7517j);
    }

    public final int hashCode() {
        return this.f7517j.hashCode() + ((this.f7516i.hashCode() + a.a.b(this.h, androidx.constraintlayout.core.widgets.analyzer.a.o(a.a.b(this.f, a.a.b(this.e, a.a.b(this.f7515d, a.a.b(this.f7514c, androidx.constraintlayout.core.widgets.analyzer.a.o(this.f7512a.hashCode() * 31, 31, this.f7513b))))), 31, this.g))) * 31);
    }

    public final String toString() {
        return "InitScreen(title=" + this.f7512a + ", body=" + this.f7513b + ", settings=" + this.f7514c + ", accept=" + this.f7515d + ", reject=" + this.e + ", consentLink=" + this.f + ", privacyPolicyLink=" + this.g + ", privacyPolicyLinkText=" + this.h + ", consentOrPayUILabels=" + this.f7516i + ", advancedUILabels=" + this.f7517j + ')';
    }
}
