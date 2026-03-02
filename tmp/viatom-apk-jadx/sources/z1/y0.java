package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public String f14391a;

    /* renamed from: b, reason: collision with root package name */
    public int f14392b;

    /* renamed from: c, reason: collision with root package name */
    public int f14393c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14394d;
    public byte e;

    public final z0 a() {
        String str;
        if (this.e == 7 && (str = this.f14391a) != null) {
            return new z0(str, this.f14392b, this.f14393c, this.f14394d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f14391a == null) {
            sb.append(" processName");
        }
        if ((this.e & 1) == 0) {
            sb.append(" pid");
        }
        if ((this.e & 2) == 0) {
            sb.append(" importance");
        }
        if ((this.e & 4) == 0) {
            sb.append(" defaultProcess");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
