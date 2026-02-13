package h5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8502a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8503b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8504c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8505d;

    public d1(String str, int i10, int i11, int i12) {
        str.getClass();
        this.f8502a = str;
        this.f8503b = i10;
        this.f8504c = i11;
        this.f8505d = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return kotlin.jvm.internal.l.a(this.f8502a, d1Var.f8502a) && this.f8503b == d1Var.f8503b && this.f8504c == d1Var.f8504c && this.f8505d == d1Var.f8505d;
    }

    public final int hashCode() {
        return (((((this.f8502a.hashCode() * 31) + this.f8503b) * 31) + this.f8504c) * 31) + this.f8505d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FollowUserData(userID=");
        sb.append(this.f8502a);
        sb.append(", success=");
        sb.append(this.f8503b);
        sb.append(", statusCode=");
        sb.append(this.f8504c);
        sb.append(", following=");
        return a3.a.k(sb, this.f8505d, ')');
    }
}
