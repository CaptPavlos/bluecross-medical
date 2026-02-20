package c1;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n0 extends h0 {

    /* renamed from: c, reason: collision with root package name */
    public String f1345c;

    /* renamed from: d, reason: collision with root package name */
    public String f1346d;
    public int e;
    public String f;
    public String g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public final long f1347i;

    /* renamed from: j, reason: collision with root package name */
    public final long f1348j;

    /* renamed from: k, reason: collision with root package name */
    public List f1349k;

    /* renamed from: l, reason: collision with root package name */
    public String f1350l;

    /* renamed from: m, reason: collision with root package name */
    public int f1351m;

    /* renamed from: n, reason: collision with root package name */
    public String f1352n;

    /* renamed from: o, reason: collision with root package name */
    public String f1353o;

    /* renamed from: p, reason: collision with root package name */
    public long f1354p;

    /* renamed from: q, reason: collision with root package name */
    public String f1355q;

    public n0(u1 u1Var, long j10, long j11) {
        super(u1Var);
        this.f1354p = 0L;
        this.f1355q = null;
        this.f1347i = j10;
        this.f1348j = j11;
    }

    @Override // c1.h0
    public final boolean j() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0253 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024d  */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.d5 k(java.lang.String r45) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.security.NoSuchAlgorithmException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n0.k(java.lang.String):c1.d5");
    }

    public final void l() {
        String str;
        g();
        u1 u1Var = this.f1149a;
        h1 h1Var = u1Var.e;
        w0 w0Var = u1Var.f;
        u1.k(h1Var);
        if (h1Var.n().i(j2.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            b5 b5Var = u1Var.f1479i;
            u1.k(b5Var);
            b5Var.e0().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            u1.m(w0Var);
            w0Var.f1544m.b("Analytics Storage consent is not granted");
            str = null;
        }
        u1.m(w0Var);
        w0Var.f1544m.b("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.f1353o = str;
        u1Var.f1481k.getClass();
        this.f1354p = System.currentTimeMillis();
    }

    public final String m() {
        h();
        i0.y.g(this.f1345c);
        return this.f1345c;
    }

    public final String n() {
        g();
        h();
        i0.y.g(this.f1352n);
        return this.f1352n;
    }
}
