package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f10316a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10317b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10318c;

    public d2(int i10, String str, String str2) {
        this.f10316a = i10;
        this.f10317b = str;
        this.f10318c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return this.f10316a == d2Var.f10316a && kotlin.jvm.internal.l.a(this.f10317b, d2Var.f10317b) && kotlin.jvm.internal.l.a(this.f10318c, d2Var.f10318c);
    }

    public final int hashCode() {
        int i10 = this.f10316a * 31;
        String str = this.f10317b;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f10318c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SignUpData(success=");
        sb.append(this.f10316a);
        sb.append(", signUpMessage=");
        sb.append(this.f10317b);
        sb.append(", regErrors=");
        return a3.a.m(sb, this.f10318c, ')');
    }
}
