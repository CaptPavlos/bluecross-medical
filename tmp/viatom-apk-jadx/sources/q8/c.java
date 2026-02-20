package q8;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.DesugarCollections;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p4.u;
import p8.c0;
import p8.s;
import z8.h0;
import z8.i;
import z8.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f12289a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f12290b = new String[0];

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f12291c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f12292d;
    public static final TimeZone e;
    public static final u f;
    public static final Pattern g;

    static {
        byte[] bArr = new byte[0];
        f12289a = bArr;
        i iVar = new i();
        iVar.write(bArr, 0, 0);
        long j10 = 0;
        f12291c = new c0(j10, iVar, 0);
        if (j10 < 0 || j10 > j10 || 0 < j10) {
            throw new ArrayIndexOutOfBoundsException();
        }
        l.d("efbbbf");
        l.d("feff");
        l.d("fffe");
        l.d("0000ffff");
        l.d("ffff0000");
        f12292d = Charset.forName(C.UTF8_NAME);
        Charset.forName("ISO-8859-1");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-32BE");
        Charset.forName("UTF-32LE");
        e = DesugarTimeZone.getTimeZone("GMT");
        f = new u(13);
        g = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String b(String str) {
        int i10 = -1;
        int i11 = 0;
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                while (i11 < lowerCase.length()) {
                    char cCharAt = lowerCase.charAt(i11);
                    if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                        return null;
                    }
                    i11++;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressF = (str.startsWith("[") && str.endsWith("]")) ? f(str, 1, str.length() - 1) : f(str, 0, str.length());
        if (inetAddressF == null) {
            return null;
        }
        byte[] address = inetAddressF.getAddress();
        if (address.length != 16) {
            p8.u.h(androidx.constraintlayout.core.widgets.analyzer.a.x("Invalid IPv6 address: '", str, "'"));
            return null;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < address.length) {
            int i14 = i12;
            while (i14 < 16 && address[i14] == 0 && address[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i10 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        i iVar = new i();
        while (i11 < address.length) {
            if (i11 == i10) {
                iVar.k(58);
                i11 += i13;
                if (i11 == 16) {
                    iVar.k(58);
                }
            } else {
                if (i11 > 0) {
                    iVar.k(58);
                }
                iVar.m(((address[i11] & 255) << 8) | (address[i11 + 1] & 255));
                i11 += 2;
            }
        }
        return iVar.readString(iVar.f14479b, o7.a.f11749a);
    }

    public static void c(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static void d(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e3) {
                if (!n(e3)) {
                    throw e3;
                }
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused) {
            }
        }
    }

    public static int e(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 >= 'a' && c10 <= 'f') {
            return c10 - 'W';
        }
        if (c10 < 'A' || c10 > 'F') {
            return -1;
        }
        return c10 - '7';
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c6, code lost:
    
        if (r7 == 16) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c8, code lost:
    
        if (r8 != (-1)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cc, code lost:
    
        r0 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00dc, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00dd, code lost:
    
        p8.u.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e1, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.net.InetAddress f(java.lang.String r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.c.f(java.lang.String, int, int):java.net.InetAddress");
    }

    public static int g(String str, int i10, int i11, char c10) {
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int h(String str, int i10, int i11, String str2) {
        while (i10 < i11) {
            if (str2.indexOf(str.charAt(i10)) != -1) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static boolean i(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String j(s sVar, boolean z9) {
        String str = sVar.f12157d;
        int i10 = sVar.e;
        boolean zContains = str.contains(":");
        String strX = sVar.f12157d;
        if (zContains) {
            strX = androidx.constraintlayout.core.widgets.analyzer.a.x("[", strX, "]");
        }
        if (!z9 && i10 == s.b(sVar.f12154a)) {
            return strX;
        }
        return strX + ":" + i10;
    }

    public static List k(List list) {
        return DesugarCollections.unmodifiableList(new ArrayList(list));
    }

    public static List l(Object... objArr) {
        return DesugarCollections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static String[] m(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i10]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i10++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean n(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean o(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean p(h0 h0Var, int i10) {
        long jNanoTime = System.nanoTime();
        long jC = h0Var.timeout().e() ? h0Var.timeout().c() - jNanoTime : Long.MAX_VALUE;
        h0Var.timeout().d(Math.min(jC, TimeUnit.MILLISECONDS.toNanos(i10)) + jNanoTime);
        try {
            i iVar = new i();
            while (h0Var.g(iVar, 8192L) != -1) {
                iVar.skip(iVar.f14479b);
            }
            if (jC == Long.MAX_VALUE) {
                h0Var.timeout().a();
                return true;
            }
            h0Var.timeout().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                h0Var.timeout().a();
                return false;
            }
            h0Var.timeout().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                h0Var.timeout().a();
            } else {
                h0Var.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static int q(String str, int i10, int i11) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int r(String str, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            char cCharAt = str.charAt(i12);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i12 + 1;
            }
        }
        return i10;
    }
}
