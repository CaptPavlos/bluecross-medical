package h5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final m0 f8647a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8648b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8649c;

    public l0(m0 m0Var, int i10, int i11) {
        m0Var.getClass();
        this.f8647a = m0Var;
        this.f8648b = i10;
        this.f8649c = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return kotlin.jvm.internal.l.a(this.f8647a, l0Var.f8647a) && this.f8648b == l0Var.f8648b && this.f8649c == l0Var.f8649c;
    }

    public final int hashCode() {
        return (((this.f8647a.hashCode() * 31) + this.f8648b) * 31) + this.f8649c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ReplyLikeData(reply=");
        sb.append(this.f8647a);
        sb.append(", success=");
        sb.append(this.f8648b);
        sb.append(", statusCode=");
        return a3.a.k(sb, this.f8649c, ')');
    }
}
