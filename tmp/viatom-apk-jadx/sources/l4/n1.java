package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10645a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10646b;

    public n1(ArrayList arrayList, int i10) {
        this.f10645a = arrayList;
        this.f10646b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return this.f10645a.equals(n1Var.f10645a) && this.f10646b == n1Var.f10646b;
    }

    public final int hashCode() {
        return (this.f10645a.hashCode() * 31) + this.f10646b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserPreregisterListData(list=");
        sb.append(this.f10645a);
        sb.append(", appsCount=");
        return a3.a.k(sb, this.f10646b, ')');
    }
}
