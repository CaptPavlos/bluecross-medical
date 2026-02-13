package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u7 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10883a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10884b;

    public u7(ArrayList arrayList, boolean z9) {
        arrayList.getClass();
        this.f10883a = arrayList;
        this.f10884b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u7)) {
            return false;
        }
        u7 u7Var = (u7) obj;
        return kotlin.jvm.internal.l.a(this.f10883a, u7Var.f10883a) && this.f10884b == u7Var.f10884b;
    }

    public final int hashCode() {
        return (this.f10883a.hashCode() * 31) + (this.f10884b ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RepliesData(replies=");
        sb.append(this.f10883a);
        sb.append(", moreDataAdded=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f10884b, ')');
    }
}
