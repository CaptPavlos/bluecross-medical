package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v7 {

    /* renamed from: a, reason: collision with root package name */
    public final int f10917a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10918b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10919c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10920d;
    public final String e;

    public v7(int i10, String str, int i11, String str2, long j10) {
        this.f10917a = i10;
        this.f10918b = i11;
        this.f10919c = str;
        this.f10920d = j10;
        this.e = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v7)) {
            return false;
        }
        v7 v7Var = (v7) obj;
        return this.f10917a == v7Var.f10917a && this.f10918b == v7Var.f10918b && this.f10919c.equals(v7Var.f10919c) && this.f10920d == v7Var.f10920d && kotlin.jvm.internal.l.a(this.e, v7Var.e);
    }

    public final int hashCode() {
        int iO = androidx.constraintlayout.core.widgets.analyzer.a.o(((this.f10917a * 31) + this.f10918b) * 31, 31, this.f10919c);
        long j10 = this.f10920d;
        int i10 = (iO + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        String str = this.e;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SendReplyData(success=");
        sb.append(this.f10917a);
        sb.append(", statusCode=");
        sb.append(this.f10918b);
        sb.append(", text=");
        sb.append(this.f10919c);
        sb.append(", reviewID=");
        sb.append(this.f10920d);
        sb.append(", msg=");
        return a3.a.m(sb, this.e, ')');
    }
}
