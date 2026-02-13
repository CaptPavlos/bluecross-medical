package w1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f13398a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13399b;

    public v(String str, String str2) {
        this.f13398a = str;
        this.f13399b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return kotlin.jvm.internal.l.a(this.f13398a, vVar.f13398a) && kotlin.jvm.internal.l.a(this.f13399b, vVar.f13399b);
    }

    public final int hashCode() {
        String str = this.f13398a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f13399b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FirebaseInstallationId(fid=");
        sb.append(this.f13398a);
        sb.append(", authToken=");
        return a3.a.m(sb, this.f13399b, ')');
    }
}
