package e5;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7800a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7801b;

    public k0(ArrayList arrayList, ArrayList arrayList2) {
        this.f7800a = arrayList;
        this.f7801b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f7800a.equals(k0Var.f7800a) && this.f7801b.equals(k0Var.f7801b);
    }

    public final int hashCode() {
        return this.f7801b.hashCode() + (this.f7800a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AppMediaData(appScreenshot=");
        sb.append(this.f7800a);
        sb.append(", appVideos=");
        return a3.a.p(sb, this.f7801b, ')');
    }
}
