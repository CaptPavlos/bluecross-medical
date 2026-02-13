package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public String f14142a;

    /* renamed from: b, reason: collision with root package name */
    public String f14143b;

    /* renamed from: c, reason: collision with root package name */
    public int f14144c;

    /* renamed from: d, reason: collision with root package name */
    public String f14145d;
    public String e;
    public String f;
    public String g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public String f14146i;

    /* renamed from: j, reason: collision with root package name */
    public m2 f14147j;

    /* renamed from: k, reason: collision with root package name */
    public s1 f14148k;

    /* renamed from: l, reason: collision with root package name */
    public p1 f14149l;

    /* renamed from: m, reason: collision with root package name */
    public byte f14150m;

    public final b0 a() {
        if (this.f14150m == 1 && this.f14142a != null && this.f14143b != null && this.f14145d != null && this.h != null && this.f14146i != null) {
            return new b0(this.f14142a, this.f14143b, this.f14144c, this.f14145d, this.e, this.f, this.g, this.h, this.f14146i, this.f14147j, this.f14148k, this.f14149l);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f14142a == null) {
            sb.append(" sdkVersion");
        }
        if (this.f14143b == null) {
            sb.append(" gmpAppId");
        }
        if ((1 & this.f14150m) == 0) {
            sb.append(" platform");
        }
        if (this.f14145d == null) {
            sb.append(" installationUuid");
        }
        if (this.h == null) {
            sb.append(" buildVersion");
        }
        if (this.f14146i == null) {
            sb.append(" displayVersion");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
