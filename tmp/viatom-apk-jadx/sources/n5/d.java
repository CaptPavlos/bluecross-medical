package n5;

import h5.x0;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final x0 f11533a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11534b;

    public d(x0 x0Var, boolean z9) {
        this.f11533a = x0Var;
        this.f11534b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return l.a(this.f11533a, dVar.f11533a) && this.f11534b == dVar.f11534b;
    }

    public final int hashCode() {
        x0 x0Var = this.f11533a;
        return ((x0Var == null ? 0 : x0Var.hashCode()) * 31) + (this.f11534b ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TopResult(topByCategory=");
        sb.append(this.f11533a);
        sb.append(", success=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f11534b, ')');
    }
}
