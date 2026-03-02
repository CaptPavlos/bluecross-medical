package a6;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.PreRegisterWorker;
import h5.g0;
import java.io.Serializable;
import kotlin.jvm.internal.w;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class f implements g, j4.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f255a;

    /* renamed from: b, reason: collision with root package name */
    public int f256b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f257c;

    /* renamed from: d, reason: collision with root package name */
    public Serializable f258d;
    public final Object e;
    public final Object f;

    public f(String str) {
        this.f255a = 2;
        str.getClass();
        o oVar = new o();
        oVar.f278c = new Object[8];
        int[] iArr = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            iArr[i10] = -1;
        }
        oVar.f279d = iArr;
        oVar.f277b = -1;
        this.f257c = oVar;
        this.e = new StringBuilder();
        this.f = str;
    }

    public static /* synthetic */ void o(f fVar, String str, int i10, String str2, int i11) {
        if ((i11 & 2) != 0) {
            i10 = fVar.f256b;
        }
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        fVar.n(i10, str, str2);
        throw null;
    }

    public int a(CharSequence charSequence, int i10) {
        int i11 = i10 + 4;
        if (i11 < charSequence.length()) {
            ((StringBuilder) this.e).append((char) (r(charSequence, i10 + 3) + (r(charSequence, i10) << 12) + (r(charSequence, i10 + 1) << 8) + (r(charSequence, i10 + 2) << 4)));
            return i11;
        }
        this.f256b = i10;
        if (i11 < charSequence.length()) {
            return a(charSequence, this.f256b);
        }
        o(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    @Override // a6.g
    public void b(long j10) {
        ((w) this.f257c).f10137a = j10;
    }

    public boolean c() {
        int i10 = this.f256b;
        if (i10 == -1) {
            return false;
        }
        String str = (String) this.f;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f256b = i10;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i10++;
        }
        this.f256b = i10;
        return false;
    }

    @Override // a6.g
    public void d(long j10) {
        ((w) this.f258d).f10137a = j10;
    }

    @Override // a6.g
    public void e() {
        Bundle bundleF = com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
        DownloadApkWorker downloadApkWorker = (DownloadApkWorker) this.e;
        downloadApkWorker.n(bundleF, downloadApkWorker.f6741c, (h5.r) ((h5.q) this.f).f8716v.get(this.f256b));
    }

    public void f(int i10, String str) {
        String str2 = (String) this.f;
        if (str2.length() - i10 < str.length()) {
            o(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) != (str2.charAt(i10 + i11) | ' ')) {
                o(this, "Expected valid boolean literal prefix, but had '" + m() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.f256b = str.length() + i10;
    }

    public String g() {
        String string;
        StringBuilder sb = (StringBuilder) this.e;
        String str = (String) this.f;
        j('\"');
        int i10 = this.f256b;
        int iJ0 = o7.m.j0(str, '\"', i10, 4);
        if (iJ0 == -1) {
            m();
            q((byte) 1, false);
            throw null;
        }
        int i11 = i10;
        while (i11 < iJ0) {
            if (str.charAt(i11) == '\\') {
                int iV = this.f256b;
                char cCharAt = str.charAt(i11);
                boolean z9 = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        sb.append((CharSequence) str, iV, i11);
                        int iV2 = v(i11 + 1);
                        if (iV2 == -1) {
                            o(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int iA = iV2 + 1;
                        char cCharAt2 = str.charAt(iV2);
                        if (cCharAt2 == 'u') {
                            iA = a(str, iA);
                        } else {
                            char c10 = cCharAt2 < 'u' ? i8.d.f9067a[cCharAt2] : (char) 0;
                            if (c10 == 0) {
                                o(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            sb.append(c10);
                        }
                        iV = v(iA);
                        if (iV == -1) {
                            o(this, "Unexpected EOF", iV, null, 4);
                            throw null;
                        }
                    } else {
                        i11++;
                        if (i11 >= str.length()) {
                            sb.append((CharSequence) str, iV, i11);
                            iV = v(i11);
                            if (iV == -1) {
                                o(this, "Unexpected EOF", iV, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            cCharAt = str.charAt(i11);
                        }
                    }
                    i11 = iV;
                    z9 = true;
                    cCharAt = str.charAt(i11);
                }
                if (z9) {
                    sb.append((CharSequence) str, iV, i11);
                    String string2 = sb.toString();
                    sb.setLength(0);
                    string = string2;
                } else {
                    string = str.subSequence(iV, i11).toString();
                }
                this.f256b = i11 + 1;
                return string;
            }
            i11++;
        }
        this.f256b = iJ0 + 1;
        return str.substring(i10, iJ0);
    }

    public byte h() {
        String str = (String) this.f;
        int i10 = this.f256b;
        while (i10 != -1 && i10 < str.length()) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f256b = i11;
                return i8.l.g(cCharAt);
            }
            i10 = i11;
        }
        this.f256b = str.length();
        return (byte) 10;
    }

    public byte i(byte b10) {
        byte bH = h();
        if (bH == b10) {
            return bH;
        }
        q(b10, true);
        throw null;
    }

    public void j(char c10) {
        int i10 = this.f256b;
        if (i10 == -1) {
            y(c10);
            throw null;
        }
        String str = (String) this.f;
        while (i10 < str.length()) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f256b = i11;
                if (cCharAt == c10) {
                    return;
                }
                y(c10);
                throw null;
            }
            i10 = i11;
        }
        this.f256b = -1;
        y(c10);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0182, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0183, code lost:
    
        androidx.window.layout.c.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0188, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0189, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x018a, code lost:
    
        if (r14 == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x018c, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0191, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0194, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0195, code lost:
    
        o(r21, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x019a, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x019b, code lost:
    
        o(r21, "Expected numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a0, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e9, code lost:
    
        o(r21, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0101, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0104, code lost:
    
        if (r12 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0106, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0108, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0109, code lost:
    
        if (r1 == r12) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x010b, code lost:
    
        if (r14 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x010f, code lost:
    
        if (r1 == (r12 - 1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0116, code lost:
    
        if (r20 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0118, code lost:
    
        if (r3 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0120, code lost:
    
        if (r2.charAt(r12) != '\"') goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0122, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0125, code lost:
    
        o(r21, "Expected closing quotation mark", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012d, code lost:
    
        o(r21, "EOF", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0132, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0133, code lost:
    
        r21.f256b = r12;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0137, code lost:
    
        if (r13 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0139, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013c, code lost:
    
        if (r11 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x013e, code lost:
    
        r3 = java.lang.Math.pow(10.0d, -r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0146, code lost:
    
        if (r11 != true) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0148, code lost:
    
        r3 = java.lang.Math.pow(10.0d, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x014d, code lost:
    
        r1 = r1 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0152, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0158, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0160, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0162, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0164, code lost:
    
        o(r21, "Can't convert " + r1 + " to Long", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x017c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x017d, code lost:
    
        o(r21, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long k() {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.f.k():long");
    }

    public String l() {
        String str = (String) this.f258d;
        if (str == null) {
            return g();
        }
        str.getClass();
        this.f258d = null;
        return str;
    }

    public String m() {
        String string;
        StringBuilder sb = (StringBuilder) this.e;
        String str = (String) this.f;
        String str2 = (String) this.f258d;
        if (str2 != null) {
            str2.getClass();
            this.f258d = null;
            return str2;
        }
        int iW = w();
        if (iW >= str.length() || iW == -1) {
            o(this, "EOF", iW, null, 4);
            throw null;
        }
        byte bG = i8.l.g(str.charAt(iW));
        if (bG == 1) {
            return l();
        }
        if (bG != 0) {
            o(this, "Expected beginning of the string, but got " + str.charAt(iW), 0, null, 6);
            throw null;
        }
        boolean z9 = false;
        while (i8.l.g(str.charAt(iW)) == 0) {
            iW++;
            if (iW >= str.length()) {
                sb.append((CharSequence) str, this.f256b, iW);
                int iV = v(iW);
                if (iV == -1) {
                    this.f256b = iW;
                    sb.append((CharSequence) str, 0, 0);
                    String string2 = sb.toString();
                    sb.setLength(0);
                    return string2;
                }
                iW = iV;
                z9 = true;
            }
        }
        int i10 = this.f256b;
        if (z9) {
            sb.append((CharSequence) str, i10, iW);
            String string3 = sb.toString();
            sb.setLength(0);
            string = string3;
        } else {
            string = str.subSequence(i10, iW).toString();
        }
        this.f256b = iW;
        return string;
    }

    public void n(int i10, String str, String str2) {
        str2.getClass();
        String strConcat = str2.length() == 0 ? "" : "\n".concat(str2);
        StringBuilder sbW = a3.a.w(str, " at path: ");
        sbW.append(((o) this.f257c).c());
        sbW.append(strConcat);
        throw i8.l.e(sbW.toString(), (String) this.f, i10);
    }

    @Override // j4.g
    public void onSuccess() {
        y7.e eVar = i0.f12407a;
        w7.c cVarA = y.a(y7.d.f14116a);
        PreRegisterWorker preRegisterWorker = (PreRegisterWorker) this.f257c;
        String str = (String) this.f258d;
        g0 g0Var = (g0) this.e;
        y.q(cVarA, null, null, new r(this.f256b, preRegisterWorker, (h5.h) this.f, g0Var, str, null), 3);
    }

    @Override // j4.g
    public void p(Exception exc) {
        v5.i.e(((PreRegisterWorker) this.f257c).f6748a, (h5.h) this.f, this.f256b, null, (g0) this.e);
    }

    public void q(byte b10, boolean z9) {
        String str = (String) this.f;
        String strP = i8.l.p(b10);
        int i10 = this.f256b;
        int i11 = z9 ? i10 - 1 : i10;
        o(this, "Expected " + strP + ", but had '" + ((i10 == str.length() || i11 < 0) ? "EOF" : String.valueOf(str.charAt(i11))) + "' instead", i11, null, 4);
        throw null;
    }

    public int r(CharSequence charSequence, int i10) {
        char cCharAt = charSequence.charAt(i10);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        o(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public String s(String str) {
        str.getClass();
        int i10 = this.f256b;
        try {
            if (h() == 6 && kotlin.jvm.internal.l.a(u(), str)) {
                this.f258d = null;
                if (h() == 5) {
                    return u();
                }
            }
            return null;
        } finally {
            this.f256b = i10;
            this.f258d = null;
        }
    }

    public byte t() {
        String str = (String) this.f;
        int i10 = this.f256b;
        while (true) {
            int iV = v(i10);
            if (iV == -1) {
                this.f256b = iV;
                return (byte) 10;
            }
            char cCharAt = str.charAt(iV);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.f256b = iV;
                return i8.l.g(cCharAt);
            }
            i10 = iV + 1;
        }
    }

    public String toString() {
        switch (this.f255a) {
            case 2:
                StringBuilder sb = new StringBuilder("JsonReader(source='");
                sb.append(this.f);
                sb.append("', currentPosition=");
                return a3.a.k(sb, this.f256b, ')');
            default:
                return super.toString();
        }
    }

    public String u() {
        if (t() != 1) {
            return null;
        }
        String strL = l();
        this.f258d = strL;
        return strL;
    }

    public int v(int i10) {
        if (i10 < ((String) this.f).length()) {
            return i10;
        }
        return -1;
    }

    public int w() {
        char cCharAt;
        int i10 = this.f256b;
        if (i10 == -1) {
            return i10;
        }
        String str = (String) this.f;
        while (i10 < str.length() && ((cCharAt = str.charAt(i10)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i10++;
        }
        this.f256b = i10;
        return i10;
    }

    public boolean x() {
        int iW = w();
        String str = (String) this.f;
        if (iW >= str.length() || iW == -1 || str.charAt(iW) != ',') {
            return false;
        }
        this.f256b++;
        return true;
    }

    public void y(char c10) {
        int i10 = this.f256b;
        if (i10 > 0 && c10 == '\"') {
            try {
                this.f256b = i10 - 1;
                String strM = m();
                this.f256b = i10;
                if (kotlin.jvm.internal.l.a(strM, "null")) {
                    n(this.f256b - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.f256b = i10;
                throw th;
            }
        }
        q(i8.l.g(c10), true);
        throw null;
    }

    public /* synthetic */ f(Object obj, Serializable serializable, Object obj2, Parcelable parcelable, int i10, int i11) {
        this.f255a = i11;
        this.f257c = obj;
        this.f258d = serializable;
        this.e = obj2;
        this.f = parcelable;
        this.f256b = i10;
    }
}
