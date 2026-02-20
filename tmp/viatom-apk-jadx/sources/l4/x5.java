package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x5 {

    /* renamed from: a, reason: collision with root package name */
    public final int f10988a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10989b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10990c;

    public x5(int i10, String str, boolean z9) {
        this.f10988a = i10;
        this.f10989b = z9;
        this.f10990c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x5)) {
            return false;
        }
        x5 x5Var = (x5) obj;
        return this.f10988a == x5Var.f10988a && this.f10989b == x5Var.f10989b && kotlin.jvm.internal.l.a(this.f10990c, x5Var.f10990c);
    }

    public final int hashCode() {
        int i10 = ((this.f10988a * 31) + (this.f10989b ? 1231 : 1237)) * 31;
        String str = this.f10990c;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PasswordEditData(success=");
        sb.append(this.f10988a);
        sb.append(", error=");
        sb.append(this.f10989b);
        sb.append(", regErrors=");
        return a3.a.m(sb, this.f10990c, ')');
    }
}
