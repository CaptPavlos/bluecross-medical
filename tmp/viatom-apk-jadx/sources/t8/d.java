package t8;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import p8.b0;
import p8.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f12865a = 0;

    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static long a(b0 b0Var) {
        String strA = b0Var.f.a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean b(b0 b0Var) {
        if (b0Var.f12063a.f12206b.equals("HEAD")) {
            return false;
        }
        int i10 = b0Var.f12065c;
        return (((i10 >= 100 && i10 < 200) || i10 == 204 || i10 == 304) && a(b0Var) == -1 && !"chunked".equalsIgnoreCase(b0Var.b("Transfer-Encoding"))) ? false : true;
    }

    public static int c(String str, int i10) throws NumberFormatException {
        try {
            long j10 = Long.parseLong(str);
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j10 < 0) {
                return 0;
            }
            return (int) j10;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01b3, code lost:
    
        r19 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01b5, code lost:
    
        r0 = r36.f12157d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b9, code lost:
    
        if (r15 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bb, code lost:
    
        r15 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c1, code lost:
    
        if (r0.equals(r15) == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01c8, code lost:
    
        if (r0.endsWith(r15) == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01db, code lost:
    
        if (r0.charAt((r0.length() - r15.length()) - 1) != '.') goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01e7, code lost:
    
        if (q8.c.g.matcher(r0).matches() != false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01f1, code lost:
    
        if (r0.length() == r15.length()) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01f3, code lost:
    
        r3 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.h;
        r3.getClass();
        r6 = java.net.IDN.toUnicode(r15).split("\\.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0208, code lost:
    
        if (r3.f11826a.get() != false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0212, code lost:
    
        if (r3.f11826a.compareAndSet(false, true) == false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0214, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x023c, code lost:
    
        r3.f11827b.await();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0186, code lost:
    
        r17 = r2;
        r34 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x018c, code lost:
    
        if (r20 != Long.MIN_VALUE) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x018e, code lost:
    
        r19 = Long.MIN_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0193, code lost:
    
        if (r20 == (-1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x019c, code lost:
    
        if (r20 > 9223372036854775L) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x019e, code lost:
    
        r29 = r20 * 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a2, code lost:
    
        r29 = r10 + r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01a6, code lost:
    
        if (r29 < r10) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01aa, code lost:
    
        if (r29 <= com.mbridge.msdk.thrid.okhttp.internal.http.HttpDate.MAX_DATE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ad, code lost:
    
        r19 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01b0, code lost:
    
        r19 = 253402300799999L;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x021a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0309 A[LOOP:9: B:194:0x0306->B:196:0x0309, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0242 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(p8.b r35, p8.s r36, p8.r r37) throws java.lang.InterruptedException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.d.d(p8.b, p8.s, p8.r):void");
    }

    public static int e(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    public static Set f(r rVar) {
        Set treeSet = Collections.EMPTY_SET;
        int iD = rVar.d();
        for (int i10 = 0; i10 < iD; i10++) {
            if ("Vary".equalsIgnoreCase(rVar.b(i10))) {
                String strE = rVar.e(i10);
                if (treeSet.isEmpty()) {
                    treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strE.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
    }
}
