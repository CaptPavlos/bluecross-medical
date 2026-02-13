package d9;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f7525a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7526b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7527c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7528d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f7529i;

    /* renamed from: j, reason: collision with root package name */
    public final String f7530j;

    /* renamed from: k, reason: collision with root package name */
    public final String f7531k;

    /* renamed from: l, reason: collision with root package name */
    public final String f7532l;

    /* renamed from: m, reason: collision with root package name */
    public final String f7533m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f7534n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f7535o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f7536p;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List list, List list2, List list3) {
        this.f7525a = str;
        this.f7526b = str2;
        this.f7527c = str3;
        this.f7528d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.f7529i = str9;
        this.f7530j = str10;
        this.f7531k = str11;
        this.f7532l = str12;
        this.f7533m = str13;
        this.f7534n = list;
        this.f7535o = list2;
        this.f7536p = list3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.l.a(this.f7525a, kVar.f7525a) && kotlin.jvm.internal.l.a(this.f7526b, kVar.f7526b) && kotlin.jvm.internal.l.a(this.f7527c, kVar.f7527c) && kotlin.jvm.internal.l.a(this.f7528d, kVar.f7528d) && kotlin.jvm.internal.l.a(this.e, kVar.e) && kotlin.jvm.internal.l.a(this.f, kVar.f) && kotlin.jvm.internal.l.a(this.g, kVar.g) && kotlin.jvm.internal.l.a(this.h, kVar.h) && kotlin.jvm.internal.l.a(this.f7529i, kVar.f7529i) && kotlin.jvm.internal.l.a(this.f7530j, kVar.f7530j) && kotlin.jvm.internal.l.a(this.f7531k, kVar.f7531k) && kotlin.jvm.internal.l.a(this.f7532l, kVar.f7532l) && kotlin.jvm.internal.l.a(this.f7533m, kVar.f7533m) && kotlin.jvm.internal.l.a(this.f7534n, kVar.f7534n) && kotlin.jvm.internal.l.a(this.f7535o, kVar.f7535o) && kotlin.jvm.internal.l.a(this.f7536p, kVar.f7536p);
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object, java.util.List] */
    public final int hashCode() {
        return this.f7536p.hashCode() + m8.e.a(m8.e.a(a.a.b(this.f7533m, a.a.b(this.f7532l, a.a.b(this.f7531k, a.a.b(this.f7530j, a.a.b(this.f7529i, a.a.b(this.h, a.a.b(this.g, a.a.b(this.f, a.a.b(this.e, a.a.b(this.f7528d, a.a.b(this.f7527c, a.a.b(this.f7526b, this.f7525a.hashCode() * 31)))))))))))), this.f7534n), this.f7535o);
    }

    public final String toString() {
        return "MobileUiLabels(doneLabel=" + this.f7525a + ", searchLabel=" + this.f7526b + ", cancelLabel=" + this.f7527c + ", showVendorsLabel=" + this.f7528d + ", showIabLabel=" + this.e + ", consentLabel=" + this.f + ", flexPurposesLabel=" + this.g + ", cookieAccessBodyText=" + this.h + ", noneLabel=" + this.f7529i + ", someLabel=" + this.f7530j + ", allLabel=" + this.f7531k + ", closeLabel=" + this.f7532l + ", allVendorsLabel=" + this.f7533m + ", summaryScreenBodyRejectService=" + this.f7534n + ", summaryScreenBodyTextReject=" + this.f7535o + ", summaryScreenBodyTextRejectNew=" + this.f7536p + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ k() {
        t6.t tVar = t6.t.f12808a;
        this("", "", "", "", "", "", "", "", "", "", "", "", "", tVar, tVar, tVar);
    }
}
