package p8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: n, reason: collision with root package name */
    public static final i f12102n;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12103a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12104b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12105c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12106d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f12107i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f12108j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f12109k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f12110l;

    /* renamed from: m, reason: collision with root package name */
    public String f12111m;

    static {
        h hVar = new h();
        hVar.f12101d = true;
        long j10 = Integer.MAX_VALUE;
        hVar.f12100c = j10 <= 2147483647L ? (int) j10 : Integer.MAX_VALUE;
        f12102n = new i(hVar);
    }

    public i(h hVar) {
        this.f12103a = hVar.f12098a;
        this.f12104b = hVar.f12099b;
        this.f12105c = -1;
        this.f12106d = -1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = hVar.f12100c;
        this.f12107i = -1;
        this.f12108j = hVar.f12101d;
        this.f12109k = false;
        this.f12110l = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p8.i a(p8.r r23) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p8.i.a(p8.r):p8.i");
    }

    public final String toString() {
        String string;
        String str = this.f12111m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f12103a) {
            sb.append("no-cache, ");
        }
        if (this.f12104b) {
            sb.append("no-store, ");
        }
        int i10 = this.f12105c;
        if (i10 != -1) {
            sb.append("max-age=");
            sb.append(i10);
            sb.append(", ");
        }
        int i11 = this.f12106d;
        if (i11 != -1) {
            sb.append("s-maxage=");
            sb.append(i11);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        int i12 = this.h;
        if (i12 != -1) {
            sb.append("max-stale=");
            sb.append(i12);
            sb.append(", ");
        }
        int i13 = this.f12107i;
        if (i13 != -1) {
            sb.append("min-fresh=");
            sb.append(i13);
            sb.append(", ");
        }
        if (this.f12108j) {
            sb.append("only-if-cached, ");
        }
        if (this.f12109k) {
            sb.append("no-transform, ");
        }
        if (this.f12110l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            string = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            string = sb.toString();
        }
        this.f12111m = string;
        return string;
    }

    public i(boolean z9, boolean z10, int i10, int i11, boolean z11, boolean z12, boolean z13, int i12, int i13, boolean z14, boolean z15, boolean z16, String str) {
        this.f12103a = z9;
        this.f12104b = z10;
        this.f12105c = i10;
        this.f12106d = i11;
        this.e = z11;
        this.f = z12;
        this.g = z13;
        this.h = i12;
        this.f12107i = i13;
        this.f12108j = z14;
        this.f12109k = z15;
        this.f12110l = z16;
        this.f12111m = str;
    }
}
