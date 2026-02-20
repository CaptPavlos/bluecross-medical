package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y6 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11029a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f11030b;

    public y6(ArrayList arrayList, ArrayList arrayList2) {
        arrayList.getClass();
        arrayList2.getClass();
        this.f11029a = arrayList;
        this.f11030b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y6)) {
            return false;
        }
        y6 y6Var = (y6) obj;
        return kotlin.jvm.internal.l.a(this.f11029a, y6Var.f11029a) && kotlin.jvm.internal.l.a(this.f11030b, y6Var.f11030b);
    }

    public final int hashCode() {
        return this.f11030b.hashCode() + (this.f11029a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PublicProfileData(recommendedApps=");
        sb.append(this.f11029a);
        sb.append(", userReviews=");
        return a3.a.p(sb, this.f11030b, ')');
    }
}
