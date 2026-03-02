package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f10279a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10280b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10281c;

    public c2(int i10, String str, String str2) {
        this.f10279a = i10;
        this.f10280b = str;
        this.f10281c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return this.f10279a == c2Var.f10279a && kotlin.jvm.internal.l.a(this.f10280b, c2Var.f10280b) && kotlin.jvm.internal.l.a(this.f10281c, c2Var.f10281c);
    }

    public final int hashCode() {
        int i10 = this.f10279a * 31;
        String str = this.f10280b;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f10281c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LoginData(loginResult=");
        sb.append(this.f10279a);
        sb.append(", loginMessage=");
        sb.append(this.f10280b);
        sb.append(", regErrors=");
        return a3.a.m(sb, this.f10281c, ')');
    }
}
