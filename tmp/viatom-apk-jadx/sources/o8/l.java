package o8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f11823a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11824b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11825c;

    public l(String str, String str2, String str3) {
        this.f11823a = str;
        this.f11824b = str2;
        this.f11825c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return kotlin.jvm.internal.l.a(this.f11823a, lVar.f11823a) && kotlin.jvm.internal.l.a(this.f11824b, lVar.f11824b) && kotlin.jvm.internal.l.a(this.f11825c, lVar.f11825c);
    }

    public final int hashCode() {
        String str = this.f11823a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f11824b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11825c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "TranslationUrls(common=" + ((Object) this.f11823a) + ", theme=" + ((Object) this.f11824b) + ", all=" + ((Object) this.f11825c) + ')';
    }
}
