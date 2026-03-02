package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public int f14292a;

    /* renamed from: b, reason: collision with root package name */
    public String f14293b;

    /* renamed from: c, reason: collision with root package name */
    public int f14294c;

    /* renamed from: d, reason: collision with root package name */
    public long f14295d;
    public long e;
    public boolean f;
    public int g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public String f14296i;

    /* renamed from: j, reason: collision with root package name */
    public byte f14297j;

    public final n0 a() {
        String str;
        String str2;
        String str3;
        if (this.f14297j == 63 && (str = this.f14293b) != null && (str2 = this.h) != null && (str3 = this.f14296i) != null) {
            return new n0(this.f14292a, str, this.f14294c, this.f14295d, this.e, this.f, this.g, str2, str3);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f14297j & 1) == 0) {
            sb.append(" arch");
        }
        if (this.f14293b == null) {
            sb.append(" model");
        }
        if ((this.f14297j & 2) == 0) {
            sb.append(" cores");
        }
        if ((this.f14297j & 4) == 0) {
            sb.append(" ram");
        }
        if ((this.f14297j & 8) == 0) {
            sb.append(" diskSpace");
        }
        if ((this.f14297j & 16) == 0) {
            sb.append(" simulator");
        }
        if ((this.f14297j & 32) == 0) {
            sb.append(" state");
        }
        if (this.h == null) {
            sb.append(" manufacturer");
        }
        if (this.f14296i == null) {
            sb.append(" modelClass");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
