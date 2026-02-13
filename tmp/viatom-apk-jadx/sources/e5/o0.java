package e5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7825a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7826b;

    public o0(String str, boolean z9) {
        this.f7825a = str;
        this.f7826b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return kotlin.jvm.internal.l.a(this.f7825a, o0Var.f7825a) && this.f7826b == o0Var.f7826b;
    }

    public final int hashCode() {
        String str = this.f7825a;
        return ((str == null ? 0 : str.hashCode()) * 31) + (this.f7826b ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PreRegisterStatusData(buttonText=");
        sb.append(this.f7825a);
        sb.append(", isPreRegister=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f7826b, ')');
    }
}
