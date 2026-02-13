package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public long f14317a;

    /* renamed from: b, reason: collision with root package name */
    public String f14318b;

    /* renamed from: c, reason: collision with root package name */
    public d2 f14319c;

    /* renamed from: d, reason: collision with root package name */
    public e2 f14320d;
    public f2 e;
    public i2 f;
    public byte g;

    public final p0 a() {
        String str;
        d2 d2Var;
        e2 e2Var;
        if (this.g == 1 && (str = this.f14318b) != null && (d2Var = this.f14319c) != null && (e2Var = this.f14320d) != null) {
            return new p0(this.f14317a, str, d2Var, e2Var, this.e, this.f);
        }
        StringBuilder sb = new StringBuilder();
        if ((1 & this.g) == 0) {
            sb.append(" timestamp");
        }
        if (this.f14318b == null) {
            sb.append(" type");
        }
        if (this.f14319c == null) {
            sb.append(" app");
        }
        if (this.f14320d == null) {
            sb.append(" device");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
