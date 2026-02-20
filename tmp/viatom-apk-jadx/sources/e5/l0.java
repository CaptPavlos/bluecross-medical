package e5;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7807a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7808b;

    public l0(ArrayList arrayList, ArrayList arrayList2) {
        this.f7807a = arrayList;
        this.f7808b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return kotlin.jvm.internal.l.a(this.f7807a, l0Var.f7807a) && kotlin.jvm.internal.l.a(this.f7808b, l0Var.f7808b);
    }

    public final int hashCode() {
        ArrayList arrayList = this.f7807a;
        int iHashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        ArrayList arrayList2 = this.f7808b;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AppRelatedCategoriesData(appTopByCategories=");
        sb.append(this.f7807a);
        sb.append(", appCategories=");
        return a3.a.p(sb, this.f7808b, ')');
    }
}
