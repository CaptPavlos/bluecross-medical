package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class gb {

    /* renamed from: a, reason: collision with root package name */
    public final int f10439a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10440b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10441c;

    public gb(int i10, String str, String str2) {
        this.f10439a = i10;
        this.f10440b = str;
        this.f10441c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gb)) {
            return false;
        }
        gb gbVar = (gb) obj;
        return this.f10439a == gbVar.f10439a && kotlin.jvm.internal.l.a(this.f10440b, gbVar.f10440b) && kotlin.jvm.internal.l.a(this.f10441c, gbVar.f10441c);
    }

    public final int hashCode() {
        int i10 = this.f10439a * 31;
        String str = this.f10440b;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f10441c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserDeviceUnlinkActionData(success=");
        sb.append(this.f10439a);
        sb.append(", msg=");
        sb.append(this.f10440b);
        sb.append(", identifier=");
        return a3.a.m(sb, this.f10441c, ')');
    }
}
