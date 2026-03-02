package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f118a;

    /* renamed from: b, reason: collision with root package name */
    public final int f119b;

    /* renamed from: c, reason: collision with root package name */
    public final int f120c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f121d;

    public k0(String str, int i10, int i11, boolean z9) {
        this.f118a = str;
        this.f119b = i10;
        this.f120c = i11;
        this.f121d = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f118a.equals(k0Var.f118a) && this.f119b == k0Var.f119b && this.f120c == k0Var.f120c && this.f121d == k0Var.f121d;
    }

    public final int hashCode() {
        return (((((this.f118a.hashCode() * 31) + this.f119b) * 31) + this.f120c) * 31) + (this.f121d ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ProcessDetails(processName=");
        sb.append(this.f118a);
        sb.append(", pid=");
        sb.append(this.f119b);
        sb.append(", importance=");
        sb.append(this.f120c);
        sb.append(", isDefaultProcess=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f121d, ')');
    }
}
