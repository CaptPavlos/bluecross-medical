package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a9 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10225a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10226b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10227c;

    public a9(ArrayList arrayList, boolean z9, boolean z10) {
        this.f10225a = arrayList;
        this.f10226b = z9;
        this.f10227c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a9)) {
            return false;
        }
        a9 a9Var = (a9) obj;
        return this.f10225a.equals(a9Var.f10225a) && this.f10226b == a9Var.f10226b && this.f10227c == a9Var.f10227c;
    }

    public final int hashCode() {
        return (((this.f10225a.hashCode() * 31) + (this.f10226b ? 1231 : 1237)) * 31) + (this.f10227c ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SearchData(searchResults=");
        sb.append(this.f10225a);
        sb.append(", firstRequest=");
        sb.append(this.f10226b);
        sb.append(", hasMoreResults=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f10227c, ')');
    }
}
