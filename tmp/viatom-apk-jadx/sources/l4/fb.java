package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class fb {

    /* renamed from: a, reason: collision with root package name */
    public final int f10407a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10408b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10409c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10410d;

    public fb(long j10, String str, String str2, int i10) {
        this.f10407a = i10;
        this.f10408b = str;
        this.f10409c = j10;
        this.f10410d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fb)) {
            return false;
        }
        fb fbVar = (fb) obj;
        return this.f10407a == fbVar.f10407a && kotlin.jvm.internal.l.a(this.f10408b, fbVar.f10408b) && this.f10409c == fbVar.f10409c && this.f10410d.equals(fbVar.f10410d);
    }

    public final int hashCode() {
        int i10 = this.f10407a * 31;
        String str = this.f10408b;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f10409c;
        return this.f10410d.hashCode() + ((((i10 + iHashCode) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserDeviceRenameActionData(success=");
        sb.append(this.f10407a);
        sb.append(", msg=");
        sb.append(this.f10408b);
        sb.append(", deviceID=");
        sb.append(this.f10409c);
        sb.append(", newName=");
        return a3.a.m(sb, this.f10410d, ')');
    }
}
