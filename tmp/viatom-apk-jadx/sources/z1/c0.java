package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public int f14176a;

    /* renamed from: b, reason: collision with root package name */
    public String f14177b;

    /* renamed from: c, reason: collision with root package name */
    public int f14178c;

    /* renamed from: d, reason: collision with root package name */
    public int f14179d;
    public long e;
    public long f;
    public long g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public List f14180i;

    /* renamed from: j, reason: collision with root package name */
    public byte f14181j;

    public final d0 a() {
        String str;
        if (this.f14181j == 63 && (str = this.f14177b) != null) {
            return new d0(this.f14176a, str, this.f14178c, this.f14179d, this.e, this.f, this.g, this.h, this.f14180i);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f14181j & 1) == 0) {
            sb.append(" pid");
        }
        if (this.f14177b == null) {
            sb.append(" processName");
        }
        if ((this.f14181j & 2) == 0) {
            sb.append(" reasonCode");
        }
        if ((this.f14181j & 4) == 0) {
            sb.append(" importance");
        }
        if ((this.f14181j & 8) == 0) {
            sb.append(" pss");
        }
        if ((this.f14181j & 16) == 0) {
            sb.append(" rss");
        }
        if ((this.f14181j & 32) == 0) {
            sb.append(" timestamp");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
