package i3;

import c1.d0;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final StringReader f8969a;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public int f8973i;

    /* renamed from: j, reason: collision with root package name */
    public String f8974j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f8975k;

    /* renamed from: m, reason: collision with root package name */
    public String[] f8977m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f8978n;

    /* renamed from: o, reason: collision with root package name */
    public int f8979o = 2;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f8970b = new char[1024];

    /* renamed from: c, reason: collision with root package name */
    public int f8971c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f8972d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f8976l = 1;

    static {
        d0.e = new d0(18);
    }

    public a(StringReader stringReader) {
        int[] iArr = new int[32];
        this.f8975k = iArr;
        iArr[0] = 6;
        this.f8977m = new String[32];
        this.f8978n = new int[32];
        this.f8969a = stringReader;
    }

    public final void A(char c10) throws c {
        do {
            int i10 = this.f8971c;
            int i11 = this.f8972d;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = this.f8970b[i10];
                if (c11 == c10) {
                    this.f8971c = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.f8971c = i12;
                    z();
                    i10 = this.f8971c;
                    i11 = this.f8972d;
                } else {
                    if (c11 == '\n') {
                        this.e++;
                        this.f = i12;
                    }
                    i10 = i12;
                }
            }
            this.f8971c = i10;
        } while (i(1));
        E("Unterminated string");
        throw null;
    }

    public final void B() {
        char c10;
        do {
            if (this.f8971c >= this.f8972d && !i(1)) {
                return;
            }
            int i10 = this.f8971c;
            int i11 = i10 + 1;
            this.f8971c = i11;
            c10 = this.f8970b[i10];
            if (c10 == '\n') {
                this.e++;
                this.f = i11;
                return;
            }
        } while (c10 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
    
        d();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C() throws i3.c {
        /*
            r3 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r3.f8971c
            int r1 = r1 + r0
            int r2 = r3.f8972d
            if (r1 >= r2) goto L4f
            char[] r2 = r3.f8970b
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L49
            r2 = 10
            if (r1 == r2) goto L49
            r2 = 12
            if (r1 == r2) goto L49
            r2 = 13
            if (r1 == r2) goto L49
            r2 = 32
            if (r1 == r2) goto L49
            r2 = 35
            if (r1 == r2) goto L46
            r2 = 44
            if (r1 == r2) goto L49
            r2 = 47
            if (r1 == r2) goto L46
            r2 = 61
            if (r1 == r2) goto L46
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L49
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L49
            r2 = 58
            if (r1 == r2) goto L49
            r2 = 59
            if (r1 == r2) goto L46
            switch(r1) {
                case 91: goto L49;
                case 92: goto L46;
                case 93: goto L49;
                default: goto L43;
            }
        L43:
            int r0 = r0 + 1
            goto L1
        L46:
            r3.d()
        L49:
            int r1 = r3.f8971c
            int r1 = r1 + r0
            r3.f8971c = r1
            return
        L4f:
            r3.f8971c = r1
            r0 = 1
            boolean r0 = r3.i(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.C():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void D() throws IOException {
        int i10 = 0;
        do {
            int iE = this.g;
            if (iE == 0) {
                iE = e();
            }
            switch (iE) {
                case 1:
                    y(3);
                    i10++;
                    this.g = 0;
                    break;
                case 2:
                    if (i10 == 0) {
                        this.f8977m[this.f8976l - 1] = null;
                    }
                    this.f8976l--;
                    i10--;
                    this.g = 0;
                    break;
                case 3:
                    y(1);
                    i10++;
                    this.g = 0;
                    break;
                case 4:
                    this.f8976l--;
                    i10--;
                    this.g = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.g = 0;
                    break;
                case 8:
                    A('\'');
                    this.g = 0;
                    break;
                case 9:
                    A('\"');
                    this.g = 0;
                    break;
                case 10:
                    C();
                    this.g = 0;
                    break;
                case 12:
                    A('\'');
                    if (i10 == 0) {
                        this.f8977m[this.f8976l - 1] = "<skipped>";
                    }
                    this.g = 0;
                    break;
                case 13:
                    A('\"');
                    if (i10 == 0) {
                        this.f8977m[this.f8976l - 1] = "<skipped>";
                    }
                    this.g = 0;
                    break;
                case 14:
                    C();
                    if (i10 == 0) {
                        this.f8977m[this.f8976l - 1] = "<skipped>";
                    }
                    this.g = 0;
                    break;
                case 16:
                    this.f8971c += this.f8973i;
                    this.g = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i10 > 0);
        int[] iArr = this.f8978n;
        int i11 = this.f8976l - 1;
        iArr[i11] = iArr[i11] + 1;
    }

    public final void E(String str) throws c {
        StringBuilder sbV = a3.a.v(str);
        sbV.append(m());
        sbV.append("\nSee ");
        sbV.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
        throw new c(sbV.toString());
    }

    public final IllegalStateException F(String str) {
        String str2 = x() == 9 ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbY = a3.a.y("Expected ", str, " but was ");
        sbY.append(com.mbridge.msdk.dycreator.baseview.a.y(x()));
        sbY.append(m());
        sbY.append("\nSee ");
        sbY.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(sbY.toString());
    }

    public final void a() throws IOException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 3) {
            throw F("BEGIN_ARRAY");
        }
        y(1);
        this.f8978n[this.f8976l - 1] = 0;
        this.g = 0;
    }

    public final void b() throws IOException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 1) {
            throw F("BEGIN_OBJECT");
        }
        y(3);
        this.g = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.g = 0;
        this.f8975k[0] = 8;
        this.f8976l = 1;
        this.f8969a.close();
    }

    public final void d() throws c {
        if (this.f8979o == 1) {
            return;
        }
        E("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x01a5, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0214, code lost:
    
        if (l(r12) != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0217, code lost:
    
        if (r5 != 2) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0219, code lost:
    
        if (r10 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x021f, code lost:
    
        if (r1 != Long.MIN_VALUE) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0221, code lost:
    
        if (r17 == 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0224, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0228, code lost:
    
        if (r1 != 0) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x022a, code lost:
    
        if (r17 != 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x022c, code lost:
    
        if (r17 == 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x022f, code lost:
    
        r1 = -r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0230, code lost:
    
        r24.h = r1;
        r24.f8971c += r7;
        r9 = 15;
        r24.g = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x023c, code lost:
    
        if (r5 == r13) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x023f, code lost:
    
        if (r5 == 4) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0242, code lost:
    
        if (r5 != 7) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0244, code lost:
    
        r24.f8973i = r7;
        r9 = 16;
        r24.g = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x026c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 787
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.e():int");
    }

    public final void f() throws IOException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 4) {
            throw F("END_ARRAY");
        }
        int i10 = this.f8976l;
        this.f8976l = i10 - 1;
        int[] iArr = this.f8978n;
        int i11 = i10 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.g = 0;
    }

    public final void h() throws IOException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 2) {
            throw F("END_OBJECT");
        }
        int i10 = this.f8976l;
        int i11 = i10 - 1;
        this.f8976l = i11;
        this.f8977m[i11] = null;
        int[] iArr = this.f8978n;
        int i12 = i10 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.g = 0;
    }

    public final boolean i(int i10) throws IOException {
        int i11;
        int i12;
        int i13 = this.f;
        int i14 = this.f8971c;
        this.f = i13 - i14;
        int i15 = this.f8972d;
        char[] cArr = this.f8970b;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f8972d = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f8972d = 0;
        }
        this.f8971c = 0;
        do {
            int i17 = this.f8972d;
            int i18 = this.f8969a.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.f8972d + i18;
            this.f8972d = i11;
            if (this.e == 0 && (i12 = this.f) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f8971c++;
                this.f = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    public final String j(boolean z9) {
        StringBuilder sb = new StringBuilder("$");
        int i10 = 0;
        while (true) {
            int i11 = this.f8976l;
            if (i10 >= i11) {
                return sb.toString();
            }
            int i12 = this.f8975k[i10];
            switch (i12) {
                case 1:
                case 2:
                    int i13 = this.f8978n[i10];
                    if (z9 && i13 > 0 && i10 == i11 - 1) {
                        i13--;
                    }
                    sb.append('[');
                    sb.append(i13);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.f8977m[i10];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    u.h(a3.a.f(i12, "Unknown scope value: "));
                    return null;
            }
            i10++;
        }
    }

    public final boolean k() throws IOException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        return (iE == 2 || iE == 4 || iE == 17) ? false : true;
    }

    public final boolean l(char c10) throws c {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        d();
        return false;
    }

    public final String m() {
        StringBuilder sbQ = a3.a.q(this.e + 1, (this.f8971c - this.f) + 1, " at line ", " column ", " path ");
        sbQ.append(j(false));
        return sbQ.toString();
    }

    public final boolean n() throws IOException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 5) {
            this.g = 0;
            int[] iArr = this.f8978n;
            int i10 = this.f8976l - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iE != 6) {
            throw F("a boolean");
        }
        this.g = 0;
        int[] iArr2 = this.f8978n;
        int i11 = this.f8976l - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return false;
    }

    public final double o() throws IOException, NumberFormatException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.g = 0;
            int[] iArr = this.f8978n;
            int i10 = this.f8976l - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.h;
        }
        if (iE == 16) {
            this.f8974j = new String(this.f8970b, this.f8971c, this.f8973i);
            this.f8971c += this.f8973i;
        } else if (iE == 8 || iE == 9) {
            this.f8974j = u(iE == 8 ? '\'' : '\"');
        } else if (iE == 10) {
            this.f8974j = w();
        } else if (iE != 11) {
            throw F("a double");
        }
        this.g = 11;
        double d8 = Double.parseDouble(this.f8974j);
        if (this.f8979o != 1 && (Double.isNaN(d8) || Double.isInfinite(d8))) {
            E("JSON forbids NaN and infinities: " + d8);
            throw null;
        }
        this.f8974j = null;
        this.g = 0;
        int[] iArr2 = this.f8978n;
        int i11 = this.f8976l - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return d8;
    }

    public final int p() throws IOException, NumberFormatException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            long j10 = this.h;
            int i10 = (int) j10;
            if (j10 == i10) {
                this.g = 0;
                int[] iArr = this.f8978n;
                int i11 = this.f8976l - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
            throw new NumberFormatException("Expected an int but was " + this.h + m());
        }
        if (iE == 16) {
            this.f8974j = new String(this.f8970b, this.f8971c, this.f8973i);
            this.f8971c += this.f8973i;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw F("an int");
            }
            if (iE == 10) {
                this.f8974j = w();
            } else {
                this.f8974j = u(iE == 8 ? '\'' : '\"');
            }
            try {
                int i12 = Integer.parseInt(this.f8974j);
                this.g = 0;
                int[] iArr2 = this.f8978n;
                int i13 = this.f8976l - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        }
        this.g = 11;
        double d8 = Double.parseDouble(this.f8974j);
        int i14 = (int) d8;
        if (i14 == d8) {
            this.f8974j = null;
            this.g = 0;
            int[] iArr3 = this.f8978n;
            int i15 = this.f8976l - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        }
        throw new NumberFormatException("Expected an int but was " + this.f8974j + m());
    }

    public final long q() throws IOException, NumberFormatException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.g = 0;
            int[] iArr = this.f8978n;
            int i10 = this.f8976l - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.h;
        }
        if (iE == 16) {
            this.f8974j = new String(this.f8970b, this.f8971c, this.f8973i);
            this.f8971c += this.f8973i;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw F("a long");
            }
            if (iE == 10) {
                this.f8974j = w();
            } else {
                this.f8974j = u(iE == 8 ? '\'' : '\"');
            }
            try {
                long j10 = Long.parseLong(this.f8974j);
                this.g = 0;
                int[] iArr2 = this.f8978n;
                int i11 = this.f8976l - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.g = 11;
        double d8 = Double.parseDouble(this.f8974j);
        long j11 = (long) d8;
        if (j11 == d8) {
            this.f8974j = null;
            this.g = 0;
            int[] iArr3 = this.f8978n;
            int i12 = this.f8976l - 1;
            iArr3[i12] = iArr3[i12] + 1;
            return j11;
        }
        throw new NumberFormatException("Expected a long but was " + this.f8974j + m());
    }

    public final String r() throws IOException {
        String strU;
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 14) {
            strU = w();
        } else if (iE == 12) {
            strU = u('\'');
        } else {
            if (iE != 13) {
                throw F("a name");
            }
            strU = u('\"');
        }
        this.g = 0;
        this.f8977m[this.f8976l - 1] = strU;
        return strU;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int s(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.s(boolean):int");
    }

    public final void t() throws IOException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 7) {
            throw F("null");
        }
        this.g = 0;
        int[] iArr = this.f8978n;
        int i10 = this.f8976l - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    public final String toString() {
        return a.class.getSimpleName().concat(m());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r11.f8971c = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r11.f8971c = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String u(char r12) throws i3.c {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.f8971c
            int r3 = r11.f8972d
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r11.f8970b
            if (r2 >= r4) goto L6b
            int r8 = r2 + 1
            char r2 = r7[r2]
            int r9 = r11.f8979o
            r10 = 3
            if (r9 != r10) goto L23
            r9 = 32
            if (r2 < r9) goto L1d
            goto L23
        L1d:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.E(r12)
            throw r0
        L23:
            if (r2 != r12) goto L39
            r11.f8971c = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L31
            java.lang.String r12 = new java.lang.String
            r12.<init>(r7, r3, r8)
            return r12
        L31:
            r1.append(r7, r3, r8)
            java.lang.String r12 = r1.toString()
            return r12
        L39:
            r9 = 92
            if (r2 != r9) goto L5e
            r11.f8971c = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L4f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L4f:
            r1.append(r7, r3, r2)
            char r2 = r11.z()
            r1.append(r2)
            int r2 = r11.f8971c
            int r3 = r11.f8972d
            goto L6
        L5e:
            r5 = 10
            if (r2 != r5) goto L69
            int r2 = r11.e
            int r2 = r2 + r6
            r11.e = r2
            r11.f = r8
        L69:
            r2 = r8
            goto L8
        L6b:
            if (r1 != 0) goto L7b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r11.f8971c = r2
            boolean r2 = r11.i(r6)
            if (r2 == 0) goto L8a
            goto L2
        L8a:
            java.lang.String r12 = "Unterminated string"
            r11.E(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.u(char):java.lang.String");
    }

    public final String v() {
        String str;
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 10) {
            str = w();
        } else if (iE == 8) {
            str = u('\'');
        } else if (iE == 9) {
            str = u('\"');
        } else if (iE == 11) {
            str = this.f8974j;
            this.f8974j = null;
        } else if (iE == 15) {
            str = Long.toString(this.h);
        } else {
            if (iE != 16) {
                throw F("a string");
            }
            str = new String(this.f8970b, this.f8971c, this.f8973i);
            this.f8971c += this.f8973i;
        }
        this.g = 0;
        int[] iArr = this.f8978n;
        int i10 = this.f8976l - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        d();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String w() throws i3.c {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f8971c
            int r3 = r3 + r2
            int r4 = r6.f8972d
            char[] r5 = r6.f8970b
            if (r3 >= r4) goto L4c
            char r3 = r5[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r6.d()
            goto L58
        L4c:
            int r3 = r5.length
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r6.i(r3)
            if (r3 == 0) goto L58
            goto L3
        L58:
            r1 = r2
            goto L78
        L5a:
            if (r0 != 0) goto L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L67:
            int r3 = r6.f8971c
            r0.append(r5, r3, r2)
            int r3 = r6.f8971c
            int r3 = r3 + r2
            r6.f8971c = r3
            r2 = 1
            boolean r2 = r6.i(r2)
            if (r2 != 0) goto L2
        L78:
            int r2 = r6.f8971c
            if (r0 != 0) goto L82
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r2, r1)
            goto L89
        L82:
            r0.append(r5, r2, r1)
            java.lang.String r0 = r0.toString()
        L89:
            int r2 = r6.f8971c
            int r2 = r2 + r1
            r6.f8971c = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.w():java.lang.String");
    }

    public final int x() throws IOException {
        int iE = this.g;
        if (iE == 0) {
            iE = e();
        }
        switch (iE) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                u.m();
                return 0;
        }
    }

    public final void y(int i10) throws c {
        int i11 = this.f8976l;
        if (i11 - 1 >= 255) {
            throw new c("Nesting limit 255 reached".concat(m()));
        }
        int[] iArr = this.f8975k;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f8975k = Arrays.copyOf(iArr, i12);
            this.f8978n = Arrays.copyOf(this.f8978n, i12);
            this.f8977m = (String[]) Arrays.copyOf(this.f8977m, i12);
        }
        int[] iArr2 = this.f8975k;
        int i13 = this.f8976l;
        this.f8976l = i13 + 1;
        iArr2[i13] = i10;
    }

    public final char z() throws c {
        int i10;
        if (this.f8971c == this.f8972d && !i(1)) {
            E("Unterminated escape sequence");
            throw null;
        }
        int i11 = this.f8971c;
        int i12 = i11 + 1;
        this.f8971c = i12;
        char[] cArr = this.f8970b;
        char c10 = cArr[i11];
        if (c10 != '\n') {
            if (c10 != '\"') {
                if (c10 != '\'') {
                    if (c10 != '/' && c10 != '\\') {
                        if (c10 == 'b') {
                            return '\b';
                        }
                        if (c10 == 'f') {
                            return '\f';
                        }
                        if (c10 == 'n') {
                            return '\n';
                        }
                        if (c10 == 'r') {
                            return '\r';
                        }
                        if (c10 == 't') {
                            return '\t';
                        }
                        if (c10 != 'u') {
                            E("Invalid escape sequence");
                            throw null;
                        }
                        if (i11 + 5 > this.f8972d && !i(4)) {
                            E("Unterminated escape sequence");
                            throw null;
                        }
                        int i13 = this.f8971c;
                        int i14 = i13 + 4;
                        int i15 = 0;
                        while (i13 < i14) {
                            char c11 = cArr[i13];
                            int i16 = i15 << 4;
                            if (c11 >= '0' && c11 <= '9') {
                                i10 = c11 - '0';
                            } else if (c11 >= 'a' && c11 <= 'f') {
                                i10 = c11 - 'W';
                            } else {
                                if (c11 < 'A' || c11 > 'F') {
                                    E("Malformed Unicode escape \\u".concat(new String(cArr, this.f8971c, 4)));
                                    throw null;
                                }
                                i10 = c11 - '7';
                            }
                            i15 = i10 + i16;
                            i13++;
                        }
                        this.f8971c += 4;
                        return (char) i15;
                    }
                }
            }
            return c10;
        }
        if (this.f8979o == 3) {
            E("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.e++;
        this.f = i12;
        if (this.f8979o == 3) {
            E("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c10;
    }
}
