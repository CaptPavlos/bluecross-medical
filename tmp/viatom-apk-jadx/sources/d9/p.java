package d9;

import java.util.ArrayList;
import java.util.RandomAccess;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f7569a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7570b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7571c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f7572d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f7573i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f7574j;

    public p(String str, String str2, String str3, ArrayList arrayList, String str4, String str5, String str6, String str7, String str8, ArrayList arrayList2, int i10) {
        str = (i10 & 1) != 0 ? "" : str;
        str2 = (i10 & 2) != 0 ? "" : str2;
        str3 = (i10 & 4) != 0 ? "" : str3;
        RandomAccess randomAccess = (i10 & 8) != 0 ? t6.t.f12808a : arrayList;
        str4 = (i10 & 16) != 0 ? "" : str4;
        str5 = (i10 & 32) != 0 ? "" : str5;
        str6 = (i10 & 64) != 0 ? "" : str6;
        str7 = (i10 & 128) != 0 ? "" : str7;
        str8 = (i10 & 256) != 0 ? "" : str8;
        arrayList2 = (i10 & 512) != 0 ? new ArrayList() : arrayList2;
        this.f7569a = str;
        this.f7570b = str2;
        this.f7571c = str3;
        this.f7572d = randomAccess;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.f7573i = str8;
        this.f7574j = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return kotlin.jvm.internal.l.a(this.f7569a, pVar.f7569a) && kotlin.jvm.internal.l.a(this.f7570b, pVar.f7570b) && kotlin.jvm.internal.l.a(this.f7571c, pVar.f7571c) && kotlin.jvm.internal.l.a(this.f7572d, pVar.f7572d) && kotlin.jvm.internal.l.a(this.e, pVar.e) && kotlin.jvm.internal.l.a(this.f, pVar.f) && kotlin.jvm.internal.l.a(this.g, pVar.g) && kotlin.jvm.internal.l.a(this.h, pVar.h) && kotlin.jvm.internal.l.a(this.f7573i, pVar.f7573i) && kotlin.jvm.internal.l.a(this.f7574j, pVar.f7574j);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.List] */
    public final int hashCode() {
        return this.f7574j.hashCode() + a.a.b(this.f7573i, a.a.b(this.h, a.a.b(this.g, a.a.b(this.f, a.a.b(this.e, m8.e.a(a.a.b(this.f7571c, a.a.b(this.f7570b, this.f7569a.hashCode() * 31)), this.f7572d))))));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PremiumUiLabels(linksTitle=");
        sb.append(this.f7569a);
        sb.append(", nonIabVendorsLabel=");
        sb.append(this.f7570b);
        sb.append(", uspDnsTitle=");
        sb.append(this.f7571c);
        sb.append(", uspDnsText=");
        sb.append(this.f7572d);
        sb.append(", uspDoNotSellToggleText=");
        sb.append(this.e);
        sb.append(", uspPrivacyPolicyLinkText=");
        sb.append(this.f);
        sb.append(", uspDeleteDataLinkText=");
        sb.append(this.g);
        sb.append(", uspAccessDataLinkText=");
        sb.append(this.h);
        sb.append(", uspAcceptButton=");
        sb.append(this.f7573i);
        sb.append(", initScreenCustomLinks=");
        return a3.a.p(sb, this.f7574j, ')');
    }
}
