package o7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class u extends t {
    public static String W(byte[] bArr) {
        bArr.getClass();
        return new String(bArr, a.f11749a);
    }

    public static boolean X(String str, String str2, boolean z9) {
        str.getClass();
        return !z9 ? str.endsWith(str2) : str.regionMatches(true, str.length() - str2.length(), str2, 0, str2.length());
    }

    public static boolean Z(String str, String str2, boolean z9) {
        return str == null ? str2 == null : !z9 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static String a0(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        }
        if (i10 == 0) {
            return "";
        }
        if (i10 == 1) {
            return "0";
        }
        char cCharAt = "0".charAt(0);
        char[] cArr = new char[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            cArr[i11] = cCharAt;
        }
        return new String(cArr);
    }

    public static String b0(String str, String str2, String str3, boolean z9) {
        str.getClass();
        str3.getClass();
        int i10 = 0;
        int iH0 = m.h0(str, str2, 0, z9);
        if (iH0 < 0) {
            return str;
        }
        int length = str2.length();
        int i11 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i10, iH0);
            sb.append(str3);
            i10 = iH0 + length;
            if (iH0 >= str.length()) {
                break;
            }
            iH0 = m.h0(str, str2, iH0 + i11, z9);
        } while (iH0 > 0);
        sb.append((CharSequence) str, i10, str.length());
        return sb.toString();
    }

    public static boolean c0(String str, String str2, boolean z9) {
        str.getClass();
        str2.getClass();
        if (!z9) {
            return str.startsWith(str2);
        }
        int length = str2.length();
        return !z9 ? str.regionMatches(0, str2, 0, length) : str.regionMatches(z9, 0, str2, 0, length);
    }
}
