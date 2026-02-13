package p8;

import j$.util.DesugarCollections;
import java.io.EOFException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: j, reason: collision with root package name */
    public static final char[] f12153j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f12154a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12155b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12156c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12157d;
    public final int e;
    public final List f;
    public final List g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f12158i;

    public s(h5.c cVar) {
        this.f12154a = cVar.f8481b;
        String str = cVar.f8482c;
        this.f12155b = h(str, 0, str.length(), false);
        String str2 = cVar.f8483d;
        this.f12156c = h(str2, 0, str2.length(), false);
        this.f12157d = cVar.e;
        int i10 = cVar.f;
        this.e = i10 == -1 ? b(cVar.f8481b) : i10;
        this.f = i((ArrayList) cVar.h, false);
        ArrayList arrayList = (ArrayList) cVar.f8484i;
        this.g = arrayList != null ? i(arrayList, true) : null;
        String str3 = cVar.g;
        this.h = str3 != null ? h(str3, 0, str3.length(), false) : null;
        this.f12158i = cVar.toString();
    }

    public static String a(String str, int i10, int i11, String str2, boolean z9, boolean z10, boolean z11, boolean z12) throws EOFException {
        int iCharCount = i10;
        while (iCharCount < i11) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z12) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z9 || (z10 && !j(str, iCharCount, i11)))) || (iCodePointAt == 43 && z11)))) {
                z8.i iVar = new z8.i();
                iVar.p(i10, iCharCount, str);
                z8.i iVar2 = null;
                while (iCharCount < i11) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z9 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z11) {
                            iVar.q(z9 ? "+" : "%2B");
                        } else if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || ((iCodePointAt2 >= 128 && z12) || str2.indexOf(iCodePointAt2) != -1 || (iCodePointAt2 == 37 && (!z9 || (z10 && !j(str, iCharCount, i11)))))) {
                            if (iVar2 == null) {
                                iVar2 = new z8.i();
                            }
                            iVar2.r(iCodePointAt2);
                            while (!iVar2.exhausted()) {
                                byte b10 = iVar2.readByte();
                                iVar.k(37);
                                char[] cArr = f12153j;
                                iVar.k(cArr[((b10 & 255) >> 4) & 15]);
                                iVar.k(cArr[b10 & 15]);
                            }
                        } else {
                            iVar.r(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                }
                return iVar.readString(iVar.f14479b, o7.a.f11749a);
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i10, i11);
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static void g(StringBuilder sb, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            String str = (String) list.get(i10);
            String str2 = (String) list.get(i10 + 1);
            if (i10 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String h(java.lang.String r8, int r9, int r10, boolean r11) {
        /*
            r0 = r9
        L1:
            if (r0 >= r10) goto L64
            char r1 = r8.charAt(r0)
            r2 = 43
            r3 = 37
            if (r1 == r3) goto L15
            if (r1 != r2) goto L12
            if (r11 == 0) goto L12
            goto L15
        L12:
            int r0 = r0 + 1
            goto L1
        L15:
            z8.i r1 = new z8.i
            r1.<init>()
            r1.p(r9, r0, r8)
        L1d:
            if (r0 >= r10) goto L5b
            int r9 = r8.codePointAt(r0)
            if (r9 != r3) goto L48
            int r4 = r0 + 2
            if (r4 >= r10) goto L48
            int r5 = r0 + 1
            char r5 = r8.charAt(r5)
            int r5 = q8.c.e(r5)
            char r6 = r8.charAt(r4)
            int r6 = q8.c.e(r6)
            r7 = -1
            if (r5 == r7) goto L52
            if (r6 == r7) goto L52
            int r0 = r5 << 4
            int r0 = r0 + r6
            r1.k(r0)
            r0 = r4
            goto L55
        L48:
            if (r9 != r2) goto L52
            if (r11 == 0) goto L52
            r4 = 32
            r1.k(r4)
            goto L55
        L52:
            r1.r(r9)
        L55:
            int r9 = java.lang.Character.charCount(r9)
            int r0 = r0 + r9
            goto L1d
        L5b:
            long r8 = r1.f14479b
            java.nio.charset.Charset r10 = o7.a.f11749a
            java.lang.String r8 = r1.readString(r8, r10)
            return r8
        L64:
            java.lang.String r8 = r8.substring(r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p8.s.h(java.lang.String, int, int, boolean):java.lang.String");
    }

    public static List i(ArrayList arrayList, boolean z9) {
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            String str = (String) arrayList.get(i10);
            arrayList2.add(str != null ? h(str, 0, str.length(), z9) : null);
        }
        return DesugarCollections.unmodifiableList(arrayList2);
    }

    public static boolean j(String str, int i10, int i11) {
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && q8.c.e(str.charAt(i10 + 1)) != -1 && q8.c.e(str.charAt(i12)) != -1;
    }

    public static ArrayList k(String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 <= str.length()) {
            int iIndexOf = str.indexOf(38, i10);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i10);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i10, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i10, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i10 = iIndexOf + 1;
        }
        return arrayList;
    }

    public final String c() {
        if (this.f12156c.isEmpty()) {
            return "";
        }
        int length = this.f12154a.length() + 3;
        String str = this.f12158i;
        return str.substring(str.indexOf(58, length) + 1, str.indexOf(64));
    }

    public final ArrayList d() {
        int length = this.f12154a.length() + 3;
        String str = this.f12158i;
        int iIndexOf = str.indexOf(47, length);
        int iH = q8.c.h(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iH) {
            int i10 = iIndexOf + 1;
            int iG = q8.c.g(str, i10, iH, '/');
            arrayList.add(str.substring(i10, iG));
            iIndexOf = iG;
        }
        return arrayList;
    }

    public final String e() {
        if (this.g == null) {
            return null;
        }
        String str = this.f12158i;
        int iIndexOf = str.indexOf(63) + 1;
        return str.substring(iIndexOf, q8.c.g(str, iIndexOf, str.length(), '#'));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).f12158i.equals(this.f12158i);
    }

    public final String f() {
        if (this.f12155b.isEmpty()) {
            return "";
        }
        int length = this.f12154a.length() + 3;
        String str = this.f12158i;
        return str.substring(length, q8.c.h(str, length, str.length(), ":@"));
    }

    public final int hashCode() {
        return this.f12158i.hashCode();
    }

    public final URI l() {
        h5.c cVar = new h5.c(1);
        ArrayList arrayList = (ArrayList) cVar.h;
        String str = this.f12154a;
        cVar.f8481b = str;
        cVar.f8482c = f();
        cVar.f8483d = c();
        cVar.e = this.f12157d;
        int iB = b(str);
        int i10 = this.e;
        if (i10 == iB) {
            i10 = -1;
        }
        cVar.f = i10;
        arrayList.clear();
        arrayList.addAll(d());
        String strE = e();
        String strSubstring = null;
        cVar.f8484i = strE != null ? k(a(strE, 0, strE.length(), " \"'<>#", true, false, true, true)) : null;
        if (this.h != null) {
            String str2 = this.f12158i;
            strSubstring = str2.substring(str2.indexOf(35) + 1);
        }
        cVar.g = strSubstring;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            String str3 = (String) arrayList.get(i11);
            arrayList.set(i11, a(str3, 0, str3.length(), "[]", true, true, false, true));
        }
        ArrayList arrayList2 = (ArrayList) cVar.f8484i;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                String str4 = (String) ((ArrayList) cVar.f8484i).get(i12);
                if (str4 != null) {
                    ((ArrayList) cVar.f8484i).set(i12, a(str4, 0, str4.length(), "\\^`{|}", true, true, true, true));
                }
            }
        }
        String str5 = cVar.g;
        if (str5 != null) {
            cVar.g = a(str5, 0, str5.length(), " \"#<>\\^`{|}", true, true, false, false);
        }
        String string = cVar.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                com.google.gson.internal.a.j(e);
                return null;
            }
        }
    }

    public final String toString() {
        return this.f12158i;
    }
}
