package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i8 {

    /* renamed from: a, reason: collision with root package name */
    public final int f10498a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10499b;

    public i8(int i10, int i11) {
        this.f10498a = i10;
        this.f10499b = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i8)) {
            return false;
        }
        i8 i8Var = (i8) obj;
        return this.f10498a == i8Var.f10498a && this.f10499b == i8Var.f10499b;
    }

    public final int hashCode() {
        return (this.f10498a * 31) + this.f10499b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SendReviewData(success=");
        sb.append(this.f10498a);
        sb.append(", statusCode=");
        return a3.a.k(sb, this.f10499b, ')');
    }
}
