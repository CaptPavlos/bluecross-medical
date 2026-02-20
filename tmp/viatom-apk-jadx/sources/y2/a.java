package y2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13775a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13776b;

    public a(String str, String str2) {
        this.f13775a = str;
        if (str2 != null) {
            this.f13776b = str2;
        } else {
            androidx.window.layout.c.k("Null version");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f13775a.equals(aVar.f13775a) && this.f13776b.equals(aVar.f13776b);
    }

    public final int hashCode() {
        return ((this.f13775a.hashCode() ^ 1000003) * 1000003) ^ this.f13776b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.f13775a);
        sb.append(", version=");
        return a3.a.o(sb, this.f13776b, "}");
    }
}
