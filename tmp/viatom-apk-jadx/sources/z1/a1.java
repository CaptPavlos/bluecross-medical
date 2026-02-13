package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public Double f14151a;

    /* renamed from: b, reason: collision with root package name */
    public int f14152b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14153c;

    /* renamed from: d, reason: collision with root package name */
    public int f14154d;
    public long e;
    public long f;
    public byte g;

    public final b1 a() {
        if (this.g == 31) {
            return new b1(this.f14151a, this.f14152b, this.f14153c, this.f14154d, this.e, this.f);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.g & 1) == 0) {
            sb.append(" batteryVelocity");
        }
        if ((this.g & 2) == 0) {
            sb.append(" proximityOn");
        }
        if ((this.g & 4) == 0) {
            sb.append(" orientation");
        }
        if ((this.g & 8) == 0) {
            sb.append(" ramUsed");
        }
        if ((this.g & 16) == 0) {
            sb.append(" diskUsed");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
