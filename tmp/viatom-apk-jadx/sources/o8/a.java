package o8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11774a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11775b;

    public a(boolean z9, boolean z10) {
        this.f11774a = z9;
        this.f11775b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11774a == aVar.f11774a && this.f11775b == aVar.f11775b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z9 = this.f11774a;
        int i10 = z9;
        if (z9 != 0) {
            i10 = 1;
        }
        int i11 = i10 * 31;
        boolean z10 = this.f11775b;
        return i11 + (z10 ? 1 : z10 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActionButtonSettings(action1Enabled=");
        sb.append(this.f11774a);
        sb.append(", action2Enabled=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f11775b, ')');
    }
}
