package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class va {

    /* renamed from: a, reason: collision with root package name */
    public final h5.e1 f10927a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10928b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10929c;

    public va(h5.e1 e1Var, ArrayList arrayList, boolean z9) {
        this.f10927a = e1Var;
        this.f10928b = arrayList;
        this.f10929c = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof va)) {
            return false;
        }
        va vaVar = (va) obj;
        return kotlin.jvm.internal.l.a(this.f10927a, vaVar.f10927a) && this.f10928b.equals(vaVar.f10928b) && this.f10929c == vaVar.f10929c;
    }

    public final int hashCode() {
        h5.e1 e1Var = this.f10927a;
        return ((this.f10928b.hashCode() + ((e1Var == null ? 0 : e1Var.hashCode()) * 31)) * 31) + (this.f10929c ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserCommentsData(user=");
        sb.append(this.f10927a);
        sb.append(", reviews=");
        sb.append(this.f10928b);
        sb.append(", userExists=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f10929c, ')');
    }
}
