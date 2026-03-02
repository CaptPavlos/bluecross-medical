package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public f1 f14197a;

    /* renamed from: b, reason: collision with root package name */
    public String f14198b;

    /* renamed from: c, reason: collision with root package name */
    public String f14199c;

    /* renamed from: d, reason: collision with root package name */
    public long f14200d;
    public byte e;

    public final e1 a() {
        f1 f1Var;
        String str;
        String str2;
        if (this.e == 1 && (f1Var = this.f14197a) != null && (str = this.f14198b) != null && (str2 = this.f14199c) != null) {
            return new e1(f1Var, str, str2, this.f14200d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f14197a == null) {
            sb.append(" rolloutVariant");
        }
        if (this.f14198b == null) {
            sb.append(" parameterKey");
        }
        if (this.f14199c == null) {
            sb.append(" parameterValue");
        }
        if ((1 & this.e) == 0) {
            sb.append(" templateVersion");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }
}
