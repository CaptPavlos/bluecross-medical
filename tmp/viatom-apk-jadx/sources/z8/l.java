package z8;

import com.google.android.gms.internal.measurement.l5;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class l implements Serializable, Comparable {

    /* renamed from: d, reason: collision with root package name */
    public static final l f14487d = new l(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f14488a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f14489b;

    /* renamed from: c, reason: collision with root package name */
    public transient String f14490c;

    public l(byte[] bArr) {
        bArr.getClass();
        this.f14488a = bArr;
    }

    public static final l c(String str) {
        int i10;
        char cCharAt;
        str.getClass();
        byte[] bArr = a.f14449a;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i11 = (int) ((length * 6) / 8);
        byte[] bArrCopyOf = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i12 < length) {
                char cCharAt2 = str.charAt(i12);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    i10 = cCharAt2 - 'A';
                } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i10 = cCharAt2 - 'G';
                } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                    i10 = cCharAt2 + 4;
                } else if (cCharAt2 != '+' && cCharAt2 != '-') {
                    if (cCharAt2 != '/' && cCharAt2 != '_') {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            break;
                        }
                        i12++;
                    } else {
                        i10 = 63;
                    }
                } else {
                    i10 = 62;
                }
                i14 = (i14 << 6) | i10;
                i13++;
                if (i13 % 4 == 0) {
                    bArrCopyOf[i15] = (byte) (i14 >> 16);
                    int i16 = i15 + 2;
                    bArrCopyOf[i15 + 1] = (byte) (i14 >> 8);
                    i15 += 3;
                    bArrCopyOf[i16] = (byte) i14;
                }
                i12++;
            } else {
                int i17 = i13 % 4;
                if (i17 != 1) {
                    if (i17 == 2) {
                        bArrCopyOf[i15] = (byte) ((i14 << 12) >> 16);
                        i15++;
                    } else if (i17 == 3) {
                        int i18 = i14 << 6;
                        int i19 = i15 + 1;
                        bArrCopyOf[i15] = (byte) (i18 >> 16);
                        i15 += 2;
                        bArrCopyOf[i19] = (byte) (i18 >> 8);
                    }
                    if (i15 != i11) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i15);
                    }
                }
            }
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new l(bArrCopyOf);
        }
        return null;
    }

    public static final void d(String str) {
        if (str.length() % 2 != 0) {
            f.b("Unexpected hex string: ".concat(str));
            return;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (a9.b.a(str.charAt(i11 + 1)) + (a9.b.a(str.charAt(i11)) << 4));
        }
        new l(bArr);
    }

    public static int h(l lVar, l lVar2) {
        lVar.getClass();
        lVar2.getClass();
        return lVar.g(lVar2.i(), 0);
    }

    public static int l(l lVar, l lVar2) {
        lVar.getClass();
        lVar2.getClass();
        return lVar.k(lVar2.i());
    }

    public static /* synthetic */ l p(l lVar, int i10, int i11, int i12) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = -1234567890;
        }
        return lVar.o(i10, i11);
    }

    public String a() {
        byte[] bArr = a.f14449a;
        byte[] bArr2 = this.f14488a;
        bArr2.getClass();
        bArr.getClass();
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length = bArr2.length - (bArr2.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr2[i10];
            int i12 = i10 + 2;
            byte b11 = bArr2[i10 + 1];
            i10 += 3;
            byte b12 = bArr2[i12];
            bArr3[i11] = bArr[(b10 & 255) >> 2];
            bArr3[i11 + 1] = bArr[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i13 = i11 + 3;
            bArr3[i11 + 2] = bArr[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 += 4;
            bArr3[i13] = bArr[b12 & 63];
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b13 = bArr2[i10];
            bArr3[i11] = bArr[(b13 & 255) >> 2];
            bArr3[i11 + 1] = bArr[(b13 & 3) << 4];
            bArr3[i11 + 2] = 61;
            bArr3[i11 + 3] = 61;
        } else if (length2 == 2) {
            int i14 = i10 + 1;
            byte b14 = bArr2[i10];
            byte b15 = bArr2[i14];
            bArr3[i11] = bArr[(b14 & 255) >> 2];
            bArr3[i11 + 1] = bArr[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr3[i11 + 2] = bArr[(b15 & 15) << 2];
            bArr3[i11 + 3] = 61;
        }
        return new String(bArr3, o7.a.f11749a);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(l lVar) {
        lVar.getClass();
        int iE = e();
        int iE2 = lVar.e();
        int iMin = Math.min(iE, iE2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iJ = j(i10) & 255;
            int iJ2 = lVar.j(i10) & 255;
            if (iJ != iJ2) {
                return iJ < iJ2 ? -1 : 1;
            }
        }
        if (iE == iE2) {
            return 0;
        }
        return iE < iE2 ? -1 : 1;
    }

    public int e() {
        return this.f14488a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            int iE = lVar.e();
            byte[] bArr = this.f14488a;
            if (iE == bArr.length && lVar.n(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        byte[] bArr = this.f14488a;
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = a9.b.f330a;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public int g(byte[] bArr, int i10) {
        bArr.getClass();
        byte[] bArr2 = this.f14488a;
        int length = bArr2.length - bArr.length;
        int iMax = Math.max(i10, 0);
        if (iMax > length) {
            return -1;
        }
        while (!l5.f(bArr2, iMax, bArr, 0, bArr.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public int hashCode() {
        int i10 = this.f14489b;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = Arrays.hashCode(this.f14488a);
        this.f14489b = iHashCode;
        return iHashCode;
    }

    public byte[] i() {
        return this.f14488a;
    }

    public byte j(int i10) {
        return this.f14488a[i10];
    }

    public int k(byte[] bArr) {
        bArr.getClass();
        int iE = e();
        byte[] bArr2 = this.f14488a;
        for (int iMin = Math.min(iE, bArr2.length - bArr.length); -1 < iMin; iMin--) {
            if (l5.f(bArr2, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean m(int i10, l lVar, int i11) {
        lVar.getClass();
        return lVar.n(0, this.f14488a, i10, i11);
    }

    public boolean n(int i10, byte[] bArr, int i11, int i12) {
        bArr.getClass();
        if (i10 < 0) {
            return false;
        }
        byte[] bArr2 = this.f14488a;
        return i10 <= bArr2.length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && l5.f(bArr2, i10, bArr, i11, i12);
    }

    public l o(int i10, int i11) {
        if (i11 == -1234567890) {
            i11 = e();
        }
        if (i10 < 0) {
            com.google.gson.internal.a.n("beginIndex < 0");
            return null;
        }
        byte[] bArr = this.f14488a;
        if (i11 > bArr.length) {
            f.b(a3.a.k(new StringBuilder("endIndex > length("), bArr.length, ')'));
            return null;
        }
        if (i11 - i10 < 0) {
            com.google.gson.internal.a.n("endIndex < beginIndex");
            return null;
        }
        if (i10 == 0 && i11 == bArr.length) {
            return this;
        }
        a.a.m(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        bArrCopyOfRange.getClass();
        return new l(bArrCopyOfRange);
    }

    public l q() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f14488a;
            if (i10 >= bArr.length) {
                return this;
            }
            byte b10 = bArr[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                bArrCopyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b11 = bArrCopyOf[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i11] = (byte) (b11 + 32);
                    }
                }
                return new l(bArrCopyOf);
            }
            i10++;
        }
    }

    public final String r() {
        String str = this.f14490c;
        if (str != null) {
            return str;
        }
        byte[] bArrI = i();
        bArrI.getClass();
        String str2 = new String(bArrI, o7.a.f11749a);
        this.f14490c = str2;
        return str2;
    }

    public void s(i iVar, int i10) {
        iVar.write(this.f14488a, 0, i10);
    }

    public String toString() {
        l lVar;
        byte b10;
        int i10;
        byte[] bArr = this.f14488a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        loop0: while (true) {
            if (i11 >= length) {
                break;
            }
            byte b11 = bArr[i11];
            if (b11 >= 0) {
                int i14 = i13 + 1;
                if (i13 == 64) {
                    break;
                }
                if ((b11 != 10 && b11 != 13 && ((b11 >= 0 && b11 < 32) || (127 <= b11 && b11 < 160))) || b11 == 65533) {
                    break;
                }
                i12 += b11 < 65536 ? 1 : 2;
                i11++;
                while (true) {
                    i13 = i14;
                    if (i11 < length && (b10 = bArr[i11]) >= 0) {
                        i11++;
                        i14 = i13 + 1;
                        if (i13 == 64) {
                            break loop0;
                        }
                        if ((b10 != 10 && b10 != 13 && ((b10 >= 0 && b10 < 32) || (127 <= b10 && b10 < 160))) || b10 == 65533) {
                            break loop0;
                        }
                        i12 += b10 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b11 >> 5) == -2) {
                int i15 = i11 + 1;
                if (length > i15) {
                    byte b12 = bArr[i15];
                    if ((b12 & 192) == 128) {
                        int i16 = (b12 ^ 3968) ^ (b11 << 6);
                        if (i16 >= 128) {
                            i10 = i13 + 1;
                            if (i13 == 64) {
                                break;
                            }
                            if ((i16 != 10 && i16 != 13 && ((i16 >= 0 && i16 < 32) || (127 <= i16 && i16 < 160))) || i16 == 65533) {
                                break;
                            }
                            i12 += i16 < 65536 ? 1 : 2;
                            i11 += 2;
                            i13 = i10;
                        } else if (i13 != 64) {
                            break;
                        }
                    } else if (i13 != 64) {
                        break;
                    }
                } else if (i13 != 64) {
                    break;
                }
            } else if ((b11 >> 4) == -2) {
                int i17 = i11 + 2;
                if (length > i17) {
                    byte b13 = bArr[i11 + 1];
                    if ((b13 & 192) == 128) {
                        byte b14 = bArr[i17];
                        if ((b14 & 192) == 128) {
                            int i18 = ((b14 ^ (-123008)) ^ (b13 << 6)) ^ (b11 << 12);
                            if (i18 < 2048) {
                                if (i13 != 64) {
                                    break;
                                }
                            } else if (55296 > i18 || i18 >= 57344) {
                                i10 = i13 + 1;
                                if (i13 == 64) {
                                    break;
                                }
                                if ((i18 != 10 && i18 != 13 && ((i18 >= 0 && i18 < 32) || (127 <= i18 && i18 < 160))) || i18 == 65533) {
                                    break;
                                }
                                i12 += i18 < 65536 ? 1 : 2;
                                i11 += 3;
                                i13 = i10;
                            } else if (i13 != 64) {
                                break;
                            }
                        } else if (i13 != 64) {
                            break;
                        }
                    } else if (i13 != 64) {
                        break;
                    }
                } else if (i13 != 64) {
                    break;
                }
            } else if ((b11 >> 3) == -2) {
                int i19 = i11 + 3;
                if (length > i19) {
                    byte b15 = bArr[i11 + 1];
                    if ((b15 & 192) == 128) {
                        byte b16 = bArr[i11 + 2];
                        if ((b16 & 192) == 128) {
                            byte b17 = bArr[i19];
                            if ((b17 & 192) == 128) {
                                int i20 = (((b17 ^ 3678080) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b11 << 18);
                                if (i20 > 1114111) {
                                    if (i13 != 64) {
                                        break;
                                    }
                                } else if (55296 > i20 || i20 >= 57344) {
                                    if (i20 >= 65536) {
                                        i10 = i13 + 1;
                                        if (i13 == 64) {
                                            break;
                                        }
                                        if ((i20 != 10 && i20 != 13 && ((i20 >= 0 && i20 < 32) || (127 <= i20 && i20 < 160))) || i20 == 65533) {
                                            break;
                                        }
                                        i12 += i20 < 65536 ? 1 : 2;
                                        i11 += 4;
                                        i13 = i10;
                                    } else if (i13 != 64) {
                                        break;
                                    }
                                } else if (i13 != 64) {
                                    break;
                                }
                            } else if (i13 != 64) {
                                break;
                            }
                        } else if (i13 != 64) {
                            break;
                        }
                    } else if (i13 != 64) {
                        break;
                    }
                } else if (i13 != 64) {
                    break;
                }
            } else if (i13 != 64) {
                break;
            }
        }
        i12 = -1;
        if (i12 != -1) {
            String strR = r();
            String strB0 = o7.u.b0(o7.u.b0(o7.u.b0(strR.substring(0, i12), "\\", "\\\\", false), "\n", "\\n", false), "\r", "\\r", false);
            if (i12 >= strR.length()) {
                return "[text=" + strB0 + ']';
            }
            return "[size=" + bArr.length + " text=" + strB0 + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + f() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 > bArr.length) {
            f.b(a3.a.k(new StringBuilder("endIndex > length("), bArr.length, ')'));
            return null;
        }
        if (64 == bArr.length) {
            lVar = this;
        } else {
            a.a.m(64, bArr.length);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 64);
            bArrCopyOfRange.getClass();
            lVar = new l(bArrCopyOfRange);
        }
        sb.append(lVar.f());
        sb.append("…]");
        return sb.toString();
    }
}
