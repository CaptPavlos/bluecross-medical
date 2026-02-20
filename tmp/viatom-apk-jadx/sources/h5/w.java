package h5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public String f8781a;

    /* renamed from: b, reason: collision with root package name */
    public long f8782b;

    /* renamed from: c, reason: collision with root package name */
    public String f8783c;

    public final String a() {
        String str = this.f8783c;
        if (str == null) {
            return null;
        }
        str.getClass();
        return str.substring(o7.m.m0("/", str, 6) + 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{sha256='");
        sb.append(this.f8781a);
        sb.append("', size=");
        sb.append(this.f8782b);
        sb.append(", absolutePath='");
        return a3.a.o(sb, this.f8783c, "'}");
    }
}
