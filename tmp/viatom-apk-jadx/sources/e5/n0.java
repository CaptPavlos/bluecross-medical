package e5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7820a;

    public n0(boolean z9) {
        this.f7820a = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n0) && this.f7820a == ((n0) obj).f7820a;
    }

    public final int hashCode() {
        return 38161 + (this.f7820a ? 1231 : 1237);
    }

    public final String toString() {
        return androidx.constraintlayout.core.widgets.analyzer.a.z(new StringBuilder("PreRegisterActionData(succeed=true, isAddPreRegisterAction="), this.f7820a, ')');
    }
}
