package s3;

import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f12531a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f12532b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f12533c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f12534d = Pattern.compile("<(body)( [^>]*?)?/>", 2);
    public static final Pattern e = Pattern.compile("<(html)( [^>]*?)?>", 2);
    public static final Pattern f = Pattern.compile("<(html)( [^>]*?)?/>", 2);
    public static final Pattern g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.lang.String r8, java.lang.StringBuilder r9, java.util.regex.Pattern r10, java.lang.String r11, int[][] r12) {
        /*
            java.util.regex.Matcher r10 = r10.matcher(r8)
            r0 = 0
            r1 = r0
        L6:
            boolean r1 = r10.find(r1)
            if (r1 == 0) goto L44
            int r1 = r10.start()
            int r2 = r10.end()
            r3 = 1
            if (r12 == 0) goto L2a
            int r4 = r12.length
            r5 = r0
        L19:
            if (r5 >= r4) goto L2a
            r6 = r12[r5]
            r7 = r6[r0]
            if (r1 < r7) goto L27
            r6 = r6[r3]
            if (r1 > r6) goto L27
            r1 = r2
            goto L6
        L27:
            int r5 = r5 + 1
            goto L19
        L2a:
            int r12 = r10.end()
            java.lang.String r12 = r8.substring(r0, r12)
            r9.append(r12)
            r9.append(r11)
            int r10 = r10.end()
            java.lang.String r8 = r8.substring(r10)
            r9.append(r8)
            return r3
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.c.a(java.lang.String, java.lang.StringBuilder, java.util.regex.Pattern, java.lang.String, int[][]):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(java.lang.String r8, java.lang.StringBuilder r9, java.util.regex.Pattern r10, java.lang.String r11, int[][] r12) {
        /*
            java.util.regex.Matcher r10 = r10.matcher(r8)
            r0 = 0
            r1 = r0
        L6:
            boolean r1 = r10.find(r1)
            if (r1 == 0) goto L5a
            int r1 = r10.start()
            int r2 = r10.end()
            r3 = 1
            if (r12 == 0) goto L2a
            int r4 = r12.length
            r5 = r0
        L19:
            if (r5 >= r4) goto L2a
            r6 = r12[r5]
            r7 = r6[r0]
            if (r1 < r7) goto L27
            r6 = r6[r3]
            if (r1 > r6) goto L27
            r1 = r2
            goto L6
        L27:
            int r5 = r5 + 1
            goto L19
        L2a:
            int r12 = r10.end()
            int r12 = r12 + (-2)
            java.lang.String r12 = r8.substring(r0, r12)
            r9.append(r12)
            java.lang.String r12 = ">"
            r9.append(r12)
            r9.append(r11)
            java.lang.String r11 = "</"
            r9.append(r11)
            java.lang.String r11 = r10.group(r3)
            r9.append(r11)
            r9.append(r12)
            int r10 = r10.end()
            java.lang.String r8 = r8.substring(r10)
            r9.append(r8)
            return r3
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.c.b(java.lang.String, java.lang.StringBuilder, java.util.regex.Pattern, java.lang.String, int[][]):boolean");
    }
}
