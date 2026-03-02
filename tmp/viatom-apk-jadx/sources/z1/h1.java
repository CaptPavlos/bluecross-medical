package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    public int f14228a;

    /* renamed from: b, reason: collision with root package name */
    public String f14229b;

    /* renamed from: c, reason: collision with root package name */
    public String f14230c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14231d;
    public byte e;

    public final i1 a() {
        String str;
        String str2;
        if (this.e == 3 && (str = this.f14229b) != null && (str2 = this.f14230c) != null) {
            return new i1(this.f14228a, str, str2, this.f14231d);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.e & 1) == 0) {
            sb.append(" platform");
        }
        if (this.f14229b == null) {
            sb.append(" version");
        }
        if (this.f14230c == null) {
            sb.append(" buildVersion");
        }
        if ((this.e & 2) == 0) {
            sb.append(" jailbroken");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
