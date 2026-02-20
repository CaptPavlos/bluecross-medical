package n5;

import java.util.ArrayList;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11529a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11530b;

    public b(ArrayList arrayList, boolean z9) {
        arrayList.getClass();
        this.f11529a = arrayList;
        this.f11530b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return l.a(this.f11529a, bVar.f11529a) && this.f11530b == bVar.f11530b;
    }

    public final int hashCode() {
        return (this.f11529a.hashCode() * 31) + (this.f11530b ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChildrenResult(categories=");
        sb.append(this.f11529a);
        sb.append(", success=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f11530b, ')');
    }
}
