package f6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f8079a;

    /* renamed from: b, reason: collision with root package name */
    public final i f8080b;

    public g(int i10, i iVar) {
        iVar.getClass();
        this.f8079a = i10;
        this.f8080b = iVar;
    }

    public final String a() throws h6.e {
        int i10 = this.f8079a;
        if (i10 <= 0) {
            throw new h6.e(kotlin.jvm.internal.l.g(": TCModelError, cannot hash invalid PurposeRestriction", "f.k"));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i10);
        sb.append('-');
        sb.append(this.f8080b.f8088a);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f8079a == gVar.f8079a && this.f8080b == gVar.f8080b;
    }

    public final int hashCode() {
        return this.f8080b.hashCode() + (this.f8079a * 31);
    }

    public final String toString() {
        return "PurposeRestriction(purposeId=" + this.f8079a + ", restrictionType=" + this.f8080b + ')';
    }
}
