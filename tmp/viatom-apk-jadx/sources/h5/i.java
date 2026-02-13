package h5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f8612a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8613b;

    public i(String str, String str2) {
        this.f8612a = str;
        this.f8613b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f8612a.equals(iVar.f8612a) && this.f8613b.equals(iVar.f8613b);
    }

    public final int hashCode() {
        return this.f8613b.hashCode() + (this.f8612a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{packagename='");
        sb.append(this.f8612a);
        sb.append("', installerPackagename='");
        return a3.a.o(sb, this.f8613b, "'}");
    }
}
