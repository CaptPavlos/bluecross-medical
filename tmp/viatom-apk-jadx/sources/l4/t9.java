package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t9 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10853a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10854b;

    public t9(boolean z9, boolean z10) {
        this.f10853a = z9;
        this.f10854b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t9)) {
            return false;
        }
        t9 t9Var = (t9) obj;
        return this.f10853a == t9Var.f10853a && this.f10854b == t9Var.f10854b;
    }

    public final int hashCode() {
        return ((this.f10853a ? 1231 : 1237) * 31) + (this.f10854b ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DownloadAllButtonData(hasUpdates=");
        sb.append(this.f10853a);
        sb.append(", allCompleted=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f10854b, ')');
    }
}
