package n5;

import java.util.ArrayList;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11531a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11532b;

    public c(ArrayList arrayList, boolean z9) {
        arrayList.getClass();
        this.f11531a = arrayList;
        this.f11532b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return l.a(this.f11531a, cVar.f11531a) && this.f11532b == cVar.f11532b;
    }

    public final int hashCode() {
        return (this.f11531a.hashCode() * 31) + (this.f11532b ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FeaturedResult(apps=");
        sb.append(this.f11531a);
        sb.append(", success=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f11532b, ')');
    }
}
