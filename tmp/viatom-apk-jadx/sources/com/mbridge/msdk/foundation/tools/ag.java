package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f3931a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f3932b = new byte[128];

    /* renamed from: c, reason: collision with root package name */
    private static Map<Character, Character> f3933c;

    /* renamed from: d, reason: collision with root package name */
    private static char[] f3934d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f3931a = cArr;
        HashMap map = new HashMap();
        f3933c = map;
        map.put('A', 'v');
        f3933c.put('B', 'S');
        f3933c.put('C', 'o');
        f3933c.put('D', 'a');
        f3933c.put('E', 'j');
        f3933c.put('F', 'c');
        f3933c.put('G', '7');
        f3933c.put('H', 'd');
        f3933c.put('I', 'R');
        f3933c.put('J', 'z');
        f3933c.put('K', 'p');
        f3933c.put('L', 'W');
        f3933c.put('M', 'i');
        f3933c.put('N', 'f');
        f3933c.put('O', 'G');
        f3933c.put('P', 'y');
        f3933c.put('Q', 'N');
        f3933c.put('R', 'x');
        f3933c.put('S', 'Z');
        f3933c.put('T', 'n');
        f3933c.put('U', 'V');
        f3933c.put('V', '5');
        f3933c.put('W', 'k');
        f3933c.put('X', '+');
        f3933c.put('Y', 'D');
        f3933c.put('Z', 'H');
        f3933c.put('a', 'L');
        f3933c.put('b', 'Y');
        f3933c.put('c', 'h');
        f3933c.put('d', 'J');
        f3933c.put('e', '4');
        f3933c.put('f', '6');
        f3933c.put('g', 'l');
        f3933c.put('h', 't');
        f3933c.put('i', '0');
        f3933c.put('j', 'U');
        f3933c.put('k', '3');
        f3933c.put('l', 'Q');
        f3933c.put('m', 'r');
        f3933c.put('n', 'g');
        f3933c.put('o', 'E');
        f3933c.put('p', 'u');
        f3933c.put('q', 'q');
        f3933c.put('r', '8');
        f3933c.put('s', 's');
        f3933c.put('t', 'w');
        f3933c.put('u', '/');
        f3933c.put('v', 'X');
        f3933c.put('w', 'M');
        f3933c.put('x', 'e');
        f3933c.put('y', 'B');
        f3933c.put('z', 'A');
        f3933c.put('0', 'T');
        f3933c.put('1', '2');
        f3933c.put('2', 'F');
        f3933c.put('3', 'b');
        f3933c.put('4', '9');
        f3933c.put('5', 'P');
        f3933c.put('6', '1');
        f3933c.put('7', 'O');
        f3933c.put('8', 'I');
        f3933c.put('9', 'K');
        f3933c.put('+', 'm');
        f3933c.put('/', 'C');
        f3934d = new char[cArr.length];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            char[] cArr2 = f3931a;
            if (i11 >= cArr2.length) {
                break;
            }
            f3934d[i11] = f3933c.get(Character.valueOf(cArr2[i11])).charValue();
            i11++;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr = f3932b;
            if (i12 >= bArr.length) {
                break;
            }
            bArr[i12] = 127;
            i12++;
        }
        while (true) {
            char[] cArr3 = f3934d;
            if (i10 >= cArr3.length) {
                return;
            }
            f3932b[cArr3[i10]] = (byte) i10;
            i10++;
        }
    }

    private static String a(byte[] bArr, int i10, int i11) {
        if (i11 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i11 / 3) << 2) + 4];
            int i12 = 0;
            while (i11 >= 3) {
                int i13 = ((bArr[i10] & 255) << 16) + ((bArr[i10 + 1] & 255) << 8) + (bArr[i10 + 2] & 255);
                char[] cArr2 = f3934d;
                cArr[i12] = cArr2[i13 >> 18];
                cArr[i12 + 1] = cArr2[(i13 >> 12) & 63];
                int i14 = i12 + 3;
                cArr[i12 + 2] = cArr2[(i13 >> 6) & 63];
                i12 += 4;
                cArr[i14] = cArr2[i13 & 63];
                i10 += 3;
                i11 -= 3;
            }
            if (i11 == 1) {
                int i15 = bArr[i10] & 255;
                char[] cArr3 = f3934d;
                cArr[i12] = cArr3[i15 >> 2];
                cArr[i12 + 1] = cArr3[(i15 << 4) & 63];
                int i16 = i12 + 3;
                cArr[i12 + 2] = '=';
                i12 += 4;
                cArr[i16] = '=';
            } else if (i11 == 2) {
                int i17 = ((bArr[i10] & 255) << 8) + (bArr[i10 + 1] & 255);
                char[] cArr4 = f3934d;
                cArr[i12] = cArr4[i17 >> 10];
                cArr[i12 + 1] = cArr4[(i17 >> 4) & 63];
                int i18 = i12 + 3;
                cArr[i12 + 2] = cArr4[(i17 << 2) & 63];
                i12 += 4;
                cArr[i18] = '=';
            }
            return new String(cArr, 0, i12);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, 0, bytes.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:5:0x0009, B:7:0x0019, B:9:0x001d, B:13:0x002c, B:15:0x0032, B:17:0x0037, B:23:0x004c, B:19:0x003d, B:21:0x0044, B:10:0x0023, B:27:0x0055), top: B:31:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] c(java.lang.String r13) {
        /*
            int r0 = r13.length()     // Catch: java.lang.Exception -> L5b
            r1 = 259(0x103, float:3.63E-43)
            if (r0 >= r1) goto L9
            r1 = r0
        L9:
            char[] r1 = new char[r1]     // Catch: java.lang.Exception -> L5b
            int r2 = r0 >> 2
            int r2 = r2 * 3
            int r2 = r2 + 3
            byte[] r3 = new byte[r2]     // Catch: java.lang.Exception -> L5b
            r4 = 0
            r5 = r4
            r6 = r5
            r7 = r6
        L17:
            if (r5 >= r0) goto L52
            int r8 = r5 + 256
            if (r8 > r0) goto L23
            r13.getChars(r5, r8, r1, r7)     // Catch: java.lang.Exception -> L5b
            int r5 = r7 + 256
            goto L29
        L23:
            r13.getChars(r5, r0, r1, r7)     // Catch: java.lang.Exception -> L5b
            int r5 = r0 - r5
            int r5 = r5 + r7
        L29:
            r9 = r7
        L2a:
            if (r7 >= r5) goto L4f
            char r10 = r1[r7]     // Catch: java.lang.Exception -> L5b
            r11 = 61
            if (r10 == r11) goto L3d
            byte[] r11 = com.mbridge.msdk.foundation.tools.ag.f3932b     // Catch: java.lang.Exception -> L5b
            int r12 = r11.length     // Catch: java.lang.Exception -> L5b
            if (r10 >= r12) goto L4c
            r11 = r11[r10]     // Catch: java.lang.Exception -> L5b
            r12 = 127(0x7f, float:1.78E-43)
            if (r11 == r12) goto L4c
        L3d:
            int r11 = r9 + 1
            r1[r9] = r10     // Catch: java.lang.Exception -> L5b
            r9 = 4
            if (r11 != r9) goto L4b
            int r9 = a(r1, r3, r6)     // Catch: java.lang.Exception -> L5b
            int r6 = r6 + r9
            r9 = r4
            goto L4c
        L4b:
            r9 = r11
        L4c:
            int r7 = r7 + 1
            goto L2a
        L4f:
            r5 = r8
            r7 = r9
            goto L17
        L52:
            if (r6 != r2) goto L55
            return r3
        L55:
            byte[] r13 = new byte[r6]     // Catch: java.lang.Exception -> L5b
            java.lang.System.arraycopy(r3, r4, r13, r4, r6)     // Catch: java.lang.Exception -> L5b
            return r13
        L5b:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ag.c(java.lang.String):byte[]");
    }

    public static String a(String str) {
        byte[] bArrC = c(str);
        if (bArrC == null || bArrC.length <= 0) {
            return null;
        }
        return new String(bArrC);
    }

    private static int a(char[] cArr, byte[] bArr, int i10) {
        try {
            char c10 = cArr[3];
            char c11 = c10 == '=' ? (char) 2 : (char) 3;
            char c12 = cArr[2];
            if (c12 == '=') {
                c11 = 1;
            }
            byte[] bArr2 = f3932b;
            byte b10 = bArr2[cArr[0]];
            byte b11 = bArr2[cArr[1]];
            byte b12 = bArr2[c12];
            byte b13 = bArr2[c10];
            if (c11 == 1) {
                bArr[i10] = (byte) (((b11 >> 4) & 3) | ((b10 << 2) & 252));
                return 1;
            }
            if (c11 == 2) {
                bArr[i10] = (byte) ((3 & (b11 >> 4)) | ((b10 << 2) & 252));
                bArr[i10 + 1] = (byte) (((b11 << 4) & PsExtractor.VIDEO_STREAM_MASK) | ((b12 >> 2) & 15));
                return 2;
            }
            if (c11 == 3) {
                bArr[i10] = (byte) (((b10 << 2) & 252) | ((b11 >> 4) & 3));
                bArr[i10 + 1] = (byte) (((b11 << 4) & PsExtractor.VIDEO_STREAM_MASK) | ((b12 >> 2) & 15));
                bArr[i10 + 2] = (byte) (((b12 << 6) & PsExtractor.AUDIO_STREAM) | (b13 & 63));
                return 3;
            }
            throw new RuntimeException("Internal Error");
        } catch (Exception unused) {
            return 0;
        }
    }
}
