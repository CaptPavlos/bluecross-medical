package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public String f14238a;

    /* renamed from: b, reason: collision with root package name */
    public String f14239b;

    /* renamed from: c, reason: collision with root package name */
    public String f14240c;

    /* renamed from: d, reason: collision with root package name */
    public long f14241d;
    public Long e;
    public boolean f;
    public u1 g;
    public l2 h;

    /* renamed from: i, reason: collision with root package name */
    public k2 f14242i;

    /* renamed from: j, reason: collision with root package name */
    public v1 f14243j;

    /* renamed from: k, reason: collision with root package name */
    public List f14244k;

    /* renamed from: l, reason: collision with root package name */
    public int f14245l;

    /* renamed from: m, reason: collision with root package name */
    public byte f14246m;

    public final j0 a() {
        String str;
        String str2;
        u1 u1Var;
        if (this.f14246m == 7 && (str = this.f14238a) != null && (str2 = this.f14239b) != null && (u1Var = this.g) != null) {
            return new j0(str, str2, this.f14240c, this.f14241d, this.e, this.f, u1Var, this.h, this.f14242i, this.f14243j, this.f14244k, this.f14245l);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f14238a == null) {
            sb.append(" generator");
        }
        if (this.f14239b == null) {
            sb.append(" identifier");
        }
        if ((this.f14246m & 1) == 0) {
            sb.append(" startedAt");
        }
        if ((this.f14246m & 2) == 0) {
            sb.append(" crashed");
        }
        if (this.g == null) {
            sb.append(" app");
        }
        if ((this.f14246m & 4) == 0) {
            sb.append(" generatorType");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
