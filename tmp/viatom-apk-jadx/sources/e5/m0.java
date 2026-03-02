package e5;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7813a;

    /* renamed from: b, reason: collision with root package name */
    public final h5.t0 f7814b;

    public m0(ArrayList arrayList, h5.t0 t0Var) {
        this.f7813a = arrayList;
        this.f7814b = t0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return this.f7813a.equals(m0Var.f7813a) && kotlin.jvm.internal.l.a(this.f7814b, m0Var.f7814b);
    }

    public final int hashCode() {
        int iHashCode = this.f7813a.hashCode() * 31;
        h5.t0 t0Var = this.f7814b;
        return iHashCode + (t0Var == null ? 0 : t0Var.hashCode());
    }

    public final String toString() {
        return "AppReviewsData(appReviews=" + this.f7813a + ", appMyReview=" + this.f7814b + ')';
    }
}
