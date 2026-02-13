package f6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f8071a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8072b;

    public c(String str, String str2) {
        this.f8071a = str;
        this.f8072b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.l.a(this.f8071a, cVar.f8071a) && this.f8072b.equals(cVar.f8072b);
    }

    public final int hashCode() {
        String str = this.f8071a;
        return this.f8072b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "GPPEncodingResult(gppString=" + ((Object) this.f8071a) + ", tcString=" + ((Object) this.f8072b) + ')';
    }
}
