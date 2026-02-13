package s2;

import r1.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f12518a;

    /* renamed from: b, reason: collision with root package name */
    public int f12519b;

    /* renamed from: c, reason: collision with root package name */
    public String f12520c;

    /* renamed from: d, reason: collision with root package name */
    public String f12521d;
    public long e;
    public long f;
    public String g;
    public byte h;

    public final b a() {
        if (this.h == 3 && this.f12519b != 0) {
            return new b(this.f12518a, this.f12519b, this.f12520c, this.f12521d, this.e, this.f, this.g);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f12519b == 0) {
            sb.append(" registrationStatus");
        }
        if ((this.h & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((this.h & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        androidx.window.layout.c.g(i.e(sb, "Missing required properties:"));
        return null;
    }
}
