package o8;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11810a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11811b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11812c;

    public h(List list, String str, String str2) {
        this.f11810a = list;
        this.f11811b = str;
        this.f11812c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f11810a.equals(hVar.f11810a) && this.f11811b.equals(hVar.f11811b) && this.f11812c.equals(hVar.f11812c);
    }

    public final int hashCode() {
        return this.f11812c.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(this.f11810a.hashCode() * 31, 31, this.f11811b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NonIabVendorsInfo(nonIabVendorList=");
        sb.append(this.f11810a);
        sb.append(", updateAt=");
        sb.append(this.f11811b);
        sb.append(", nonIabVendorsHash=");
        return a3.a.m(sb, this.f11812c, ')');
    }
}
