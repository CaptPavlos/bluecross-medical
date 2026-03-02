package o8;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11817a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f11818b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11819c;

    public j(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.f11817a = arrayList;
        this.f11818b = arrayList2;
        this.f11819c = arrayList3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f11817a.equals(jVar.f11817a) && this.f11818b.equals(jVar.f11818b) && this.f11819c.equals(jVar.f11819c);
    }

    public final int hashCode() {
        return this.f11819c.hashCode() + ((this.f11818b.hashCode() + (this.f11817a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PremiumProperties(vendorBlacklist=");
        sb.append(this.f11817a);
        sb.append(", vendorWhitelist=");
        sb.append(this.f11818b);
        sb.append(", googleWhitelist=");
        return a3.a.p(sb, this.f11819c, ')');
    }
}
