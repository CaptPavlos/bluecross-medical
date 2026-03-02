package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    public final int f10232a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10233b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10234c;

    public ac(int i10, String str, boolean z9) {
        this.f10232a = i10;
        this.f10233b = z9;
        this.f10234c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        return this.f10232a == acVar.f10232a && this.f10233b == acVar.f10233b && kotlin.jvm.internal.l.a(this.f10234c, acVar.f10234c);
    }

    public final int hashCode() {
        int i10 = ((this.f10232a * 31) + (this.f10233b ? 1231 : 1237)) * 31;
        String str = this.f10234c;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UsernameEditData(success=");
        sb.append(this.f10232a);
        sb.append(", error=");
        sb.append(this.f10233b);
        sb.append(", regErrors=");
        return a3.a.m(sb, this.f10234c, ')');
    }
}
