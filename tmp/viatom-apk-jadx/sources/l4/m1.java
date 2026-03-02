package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10616a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10617b;

    public m1(ArrayList arrayList, int i10) {
        this.f10616a = arrayList;
        this.f10617b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return this.f10616a.equals(m1Var.f10616a) && this.f10617b == m1Var.f10617b;
    }

    public final int hashCode() {
        return (this.f10616a.hashCode() * 31) + this.f10617b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserListData(list=");
        sb.append(this.f10616a);
        sb.append(", appsCount=");
        return a3.a.k(sb, this.f10617b, ')');
    }
}
