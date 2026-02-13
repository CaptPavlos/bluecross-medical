package o8;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f11806a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11807b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11808c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11809d;
    public final String e;
    public final ArrayList f;
    public final ArrayList g;

    public g(int i10, String str, String str2, String str3, String str4, ArrayList arrayList, ArrayList arrayList2) {
        this.f11806a = i10;
        this.f11807b = str;
        this.f11808c = str2;
        this.f11809d = str3;
        this.e = str4;
        this.f = arrayList;
        this.g = arrayList2;
    }

    public final k8.h a() {
        return new k8.h(this.f11806a, this.f11808c, this.f11809d, t6.l.t0(this.f), t6.l.t0(this.g), null, null, null, null, this.e, null, 0, null, null, null, null, null, 914912);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f11806a == gVar.f11806a && this.f11807b.equals(gVar.f11807b) && this.f11808c.equals(gVar.f11808c) && this.f11809d.equals(gVar.f11809d) && this.e.equals(gVar.e) && this.f.equals(gVar.f) && this.g.equals(gVar.g);
    }

    public final int hashCode() {
        return this.g.hashCode() + ((this.f.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(this.f11806a * 31, 31, this.f11807b), 31, this.f11808c), 31, this.f11809d), 31, this.e)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NonIABVendor(vendorId=");
        sb.append(this.f11806a);
        sb.append(", pCode=");
        sb.append(this.f11807b);
        sb.append(", name=");
        sb.append(this.f11808c);
        sb.append(", description=");
        sb.append(this.f11809d);
        sb.append(", privacyPolicyUrl=");
        sb.append(this.e);
        sb.append(", nonIabPurposeConsentIds=");
        sb.append(this.f);
        sb.append(", nonIabPurposeLegitimateInterestIds=");
        return a3.a.p(sb, this.g, ')');
    }
}
