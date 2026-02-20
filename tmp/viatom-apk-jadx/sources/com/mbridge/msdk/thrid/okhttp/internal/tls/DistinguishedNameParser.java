package com.mbridge.msdk.thrid.okhttp.internal.tls;

import com.google.gson.internal.a;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        r1 = r8.beg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        return new java.lang.String(r2, r1, r8.end - r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L6:
            int r0 = r8.pos
            int r1 = r8.length
            char[] r2 = r8.chars
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            int r1 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r1
            r0.<init>(r2, r1, r3)
            return r0
        L19:
            char r1 = r2[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r1 == r6) goto L5a
            if (r1 == r5) goto L4f
            r5 = 92
            if (r1 == r5) goto L3c
            if (r1 == r4) goto L4f
            if (r1 == r3) goto L4f
            int r3 = r8.end
            int r4 = r3 + 1
            r8.end = r4
            r2[r3] = r1
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L3c:
            int r0 = r8.end
            int r1 = r0 + 1
            r8.end = r1
            char r1 = r8.getEscaped()
            r2[r0] = r1
            int r0 = r8.pos
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L4f:
            java.lang.String r0 = new java.lang.String
            int r1 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r1
            r0.<init>(r2, r1, r3)
            return r0
        L5a:
            int r1 = r8.end
            r8.cur = r1
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r1 + 1
            r8.end = r0
            r2[r1] = r6
        L68:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L81
            char[] r2 = r8.chars
            char r7 = r2[r0]
            if (r7 != r6) goto L81
            int r1 = r8.end
            int r7 = r1 + 1
            r8.end = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L68
        L81:
            if (r0 == r1) goto L8d
            char[] r1 = r8.chars
            char r0 = r1[r0]
            if (r0 == r3) goto L8d
            if (r0 == r4) goto L8d
            if (r0 != r5) goto L6
        L8d:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.cur
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.tls.DistinguishedNameParser.escapedAV():java.lang.String");
    }

    private int getByte(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 >= this.length) {
            a.l(this.dn, "Malformed DN: ");
            return 0;
        }
        char[] cArr = this.chars;
        char c10 = cArr[i10];
        if (c10 >= '0' && c10 <= '9') {
            i11 = c10 - '0';
        } else if (c10 >= 'a' && c10 <= 'f') {
            i11 = c10 - 'W';
        } else {
            if (c10 < 'A' || c10 > 'F') {
                a.l(this.dn, "Malformed DN: ");
                return 0;
            }
            i11 = c10 - '7';
        }
        char c11 = cArr[i13];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                a.l(this.dn, "Malformed DN: ");
                return 0;
            }
            i12 = c11 - '7';
        }
        return (i11 << 4) + i12;
    }

    private char getEscaped() {
        int i10 = this.pos + 1;
        this.pos = i10;
        if (i10 == this.length) {
            a.l(this.dn, "Unexpected end of DN: ");
            return (char) 0;
        }
        char c10 = this.chars[i10];
        if (c10 == ' ' || c10 == '%' || c10 == '\\' || c10 == '_' || c10 == '\"' || c10 == '#') {
            return c10;
        }
        switch (c10) {
            case '*':
            case '+':
            case ',':
                return c10;
            default:
                switch (c10) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c10;
                    default:
                        return getUTF8();
                }
        }
    }

    private char getUTF8() {
        int i10;
        int i11;
        int i12 = getByte(this.pos);
        this.pos++;
        if (i12 < 128) {
            return (char) i12;
        }
        if (i12 < 192 || i12 > 247) {
            return '?';
        }
        if (i12 <= 223) {
            i10 = i12 & 31;
            i11 = 1;
        } else if (i12 <= 239) {
            i10 = i12 & 15;
            i11 = 2;
        } else {
            i10 = i12 & 7;
            i11 = 3;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = this.pos;
            int i15 = i14 + 1;
            this.pos = i15;
            if (i15 == this.length || this.chars[i15] != '\\') {
                return '?';
            }
            int i16 = i14 + 2;
            this.pos = i16;
            int i17 = getByte(i16);
            this.pos++;
            if ((i17 & PsExtractor.AUDIO_STREAM) != 128) {
                return '?';
            }
            i10 = (i10 << 6) + (i17 & 63);
        }
        return (char) i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.end = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String hexAV() {
        /*
            r6 = this;
            int r0 = r6.pos
            int r1 = r0 + 4
            int r2 = r6.length
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L88
            r6.beg = r0
            int r0 = r0 + 1
            r6.pos = r0
        L10:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 == r1) goto L54
            char[] r1 = r6.chars
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L54
            r4 = 44
            if (r2 == r4) goto L54
            r4 = 59
            if (r2 != r4) goto L27
            goto L54
        L27:
            r4 = 32
            if (r2 != r4) goto L42
            r6.end = r0
            int r0 = r0 + 1
            r6.pos = r0
        L31:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 >= r1) goto L56
            char[] r1 = r6.chars
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.pos = r0
            goto L31
        L42:
            r4 = 65
            if (r2 < r4) goto L4f
            r4 = 70
            if (r2 > r4) goto L4f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L4f:
            int r0 = r0 + 1
            r6.pos = r0
            goto L10
        L54:
            r6.end = r0
        L56:
            int r0 = r6.end
            int r1 = r6.beg
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L81
            r2 = r0 & 1
            if (r2 == 0) goto L81
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L69:
            if (r4 >= r2) goto L77
            int r5 = r6.getByte(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L69
        L77:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.chars
            int r3 = r6.beg
            r1.<init>(r2, r3, r0)
            return r1
        L81:
            java.lang.String r0 = r6.dn
            com.google.gson.internal.a.l(r0, r3)
        L86:
            r0 = 0
            return r0
        L88:
            java.lang.String r0 = r6.dn
            com.google.gson.internal.a.l(r0, r3)
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.tls.DistinguishedNameParser.hexAV():java.lang.String");
    }

    private String nextAT() {
        int i10;
        int i11;
        int i12;
        int i13;
        char c10;
        int i14;
        int i15;
        char c11;
        char c12;
        while (true) {
            i10 = this.pos;
            i11 = this.length;
            if (i10 >= i11 || this.chars[i10] != ' ') {
                break;
            }
            this.pos = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.beg = i10;
        this.pos = i10 + 1;
        while (true) {
            i12 = this.pos;
            i13 = this.length;
            if (i12 >= i13 || (c12 = this.chars[i12]) == '=' || c12 == ' ') {
                break;
            }
            this.pos = i12 + 1;
        }
        if (i12 >= i13) {
            a.l(this.dn, "Unexpected end of DN: ");
            return null;
        }
        this.end = i12;
        if (this.chars[i12] == ' ') {
            while (true) {
                i14 = this.pos;
                i15 = this.length;
                if (i14 >= i15 || (c11 = this.chars[i14]) == '=' || c11 != ' ') {
                    break;
                }
                this.pos = i14 + 1;
            }
            if (this.chars[i14] != '=' || i14 == i15) {
                a.l(this.dn, "Unexpected end of DN: ");
                return null;
            }
        }
        this.pos++;
        while (true) {
            int i16 = this.pos;
            if (i16 >= this.length || this.chars[i16] != ' ') {
                break;
            }
            this.pos = i16 + 1;
        }
        int i17 = this.end;
        int i18 = this.beg;
        if (i17 - i18 > 4) {
            char[] cArr = this.chars;
            if (cArr[i18 + 3] == '.' && (((c10 = cArr[i18]) == 'O' || c10 == 'o') && ((cArr[i18 + 1] == 'I' || cArr[i18 + 1] == 'i') && (cArr[i18 + 2] == 'D' || cArr[i18 + 2] == 'd')))) {
                this.beg = i18 + 4;
            }
        }
        char[] cArr2 = this.chars;
        int i19 = this.beg;
        return new String(cArr2, i19, i17 - i19);
    }

    private String quotedAV() {
        int i10 = this.pos + 1;
        this.pos = i10;
        this.beg = i10;
        this.end = i10;
        while (true) {
            int i11 = this.pos;
            if (i11 == this.length) {
                a.l(this.dn, "Unexpected end of DN: ");
                return null;
            }
            char[] cArr = this.chars;
            char c10 = cArr[i11];
            if (c10 == '\"') {
                this.pos = i11 + 1;
                while (true) {
                    int i12 = this.pos;
                    if (i12 >= this.length || this.chars[i12] != ' ') {
                        break;
                    }
                    this.pos = i12 + 1;
                }
                char[] cArr2 = this.chars;
                int i13 = this.beg;
                return new String(cArr2, i13, this.end - i13);
            }
            int i14 = this.end;
            if (c10 == '\\') {
                cArr[i14] = getEscaped();
            } else {
                cArr[i14] = c10;
            }
            this.pos++;
            this.end++;
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String strNextAT = nextAT();
        if (strNextAT == null) {
            return null;
        }
        do {
            int i10 = this.pos;
            if (i10 == this.length) {
                return null;
            }
            char c10 = this.chars[i10];
            String strEscapedAV = c10 != '\"' ? c10 != '#' ? (c10 == '+' || c10 == ',' || c10 == ';') ? "" : escapedAV() : hexAV() : quotedAV();
            if (str.equalsIgnoreCase(strNextAT)) {
                return strEscapedAV;
            }
            int i11 = this.pos;
            if (i11 >= this.length) {
                return null;
            }
            char c11 = this.chars[i11];
            if (c11 != ',' && c11 != ';' && c11 != '+') {
                a.l(this.dn, "Malformed DN: ");
                return null;
            }
            this.pos = i11 + 1;
            strNextAT = nextAT();
        } while (strNextAT != null);
        a.l(this.dn, "Malformed DN: ");
        return null;
    }
}
