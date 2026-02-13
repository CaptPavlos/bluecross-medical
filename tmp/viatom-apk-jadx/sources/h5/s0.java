package h5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final t0 f8733a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8734b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8735c;

    public s0(t0 t0Var, int i10, int i11) {
        t0Var.getClass();
        this.f8733a = t0Var;
        this.f8734b = i10;
        this.f8735c = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return kotlin.jvm.internal.l.a(this.f8733a, s0Var.f8733a) && this.f8734b == s0Var.f8734b && this.f8735c == s0Var.f8735c;
    }

    public final int hashCode() {
        return (((this.f8733a.hashCode() * 31) + this.f8734b) * 31) + this.f8735c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ReviewLikeData(review=");
        sb.append(this.f8733a);
        sb.append(", success=");
        sb.append(this.f8734b);
        sb.append(", statusCode=");
        return a3.a.k(sb, this.f8735c, ')');
    }
}
