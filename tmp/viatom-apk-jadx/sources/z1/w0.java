package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    public long f14377a;

    /* renamed from: b, reason: collision with root package name */
    public String f14378b;

    /* renamed from: c, reason: collision with root package name */
    public String f14379c;

    /* renamed from: d, reason: collision with root package name */
    public long f14380d;
    public int e;
    public byte f;

    public final x0 a() {
        String str;
        if (this.f == 7 && (str = this.f14378b) != null) {
            return new x0(this.f14377a, str, this.f14379c, this.f14380d, this.e);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f & 1) == 0) {
            sb.append(" pc");
        }
        if (this.f14378b == null) {
            sb.append(" symbol");
        }
        if ((this.f & 2) == 0) {
            sb.append(" offset");
        }
        if ((this.f & 4) == 0) {
            sb.append(" importance");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
