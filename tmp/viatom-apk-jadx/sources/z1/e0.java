package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 extends o1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14204a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14205b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14206c;

    public e0(String str, String str2, String str3) {
        this.f14204a = str;
        this.f14205b = str2;
        this.f14206c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o1) {
            e0 e0Var = (e0) ((o1) obj);
            if (this.f14204a.equals(e0Var.f14204a) && this.f14205b.equals(e0Var.f14205b) && this.f14206c.equals(e0Var.f14206c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f14204a.hashCode() ^ 1000003) * 1000003) ^ this.f14205b.hashCode()) * 1000003) ^ this.f14206c.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BuildIdMappingForArch{arch=");
        sb.append(this.f14204a);
        sb.append(", libraryName=");
        sb.append(this.f14205b);
        sb.append(", buildId=");
        return a3.a.o(sb, this.f14206c, "}");
    }
}
