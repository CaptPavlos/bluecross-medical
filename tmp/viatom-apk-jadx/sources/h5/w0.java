package h5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    public long f8784a;

    /* renamed from: b, reason: collision with root package name */
    public int f8785b;

    /* renamed from: c, reason: collision with root package name */
    public int f8786c;

    /* renamed from: d, reason: collision with root package name */
    public String f8787d;
    public String e;
    public String f;
    public String g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.f8784a == w0Var.f8784a && this.f8785b == w0Var.f8785b && this.f8786c == w0Var.f8786c && kotlin.jvm.internal.l.a(this.f8787d, w0Var.f8787d) && kotlin.jvm.internal.l.a(this.e, w0Var.e) && kotlin.jvm.internal.l.a(this.f, w0Var.f) && kotlin.jvm.internal.l.a(this.g, w0Var.g);
    }

    public final int hashCode() {
        long j10 = this.f8784a;
        int i10 = ((((((int) (j10 ^ (j10 >>> 32))) * 31) + this.f8785b) * 31) + this.f8786c) * 31;
        String str = this.f8787d;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.g;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FloatingCategoryTopExtraData(lastUpdate=");
        sb.append(this.f8784a);
        sb.append(", totalApps=");
        sb.append(this.f8785b);
        sb.append(", editorID=");
        sb.append(this.f8786c);
        sb.append(", editorName=");
        sb.append(this.f8787d);
        sb.append(", editorAvatar=");
        sb.append(this.e);
        sb.append(", editorJobTitle=");
        sb.append(this.f);
        sb.append(", url=");
        return a3.a.m(sb, this.g, ')');
    }
}
