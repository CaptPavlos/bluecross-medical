package j$.util;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f9848a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9849b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9850c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f9851d;
    public int e;
    public int f;

    public u1(CharSequence charSequence) {
        Objects.requireNonNull("", "The prefix must not be null");
        Objects.requireNonNull(charSequence, "The delimiter must not be null");
        Objects.requireNonNull("", "The suffix must not be null");
        this.f9848a = "";
        this.f9849b = charSequence.toString();
        this.f9850c = "";
    }

    public static int c(String str, char[] cArr, int i10) {
        int length = str.length();
        str.getChars(0, length, cArr, i10);
        return length;
    }

    public final String toString() {
        String[] strArr = this.f9851d;
        int i10 = this.e;
        String str = this.f9848a;
        int length = str.length();
        String str2 = this.f9850c;
        int length2 = str2.length() + length;
        if (length2 == 0) {
            b();
            return i10 == 0 ? "" : strArr[0];
        }
        char[] cArr = new char[this.f + length2];
        int iC = c(str, cArr, 0);
        if (i10 > 0) {
            int iC2 = c(strArr[0], cArr, iC) + iC;
            for (int i11 = 1; i11 < i10; i11++) {
                int iC3 = c(this.f9849b, cArr, iC2) + iC2;
                iC2 = c(strArr[i11], cArr, iC3) + iC3;
            }
            iC = iC2;
        }
        c(str2, cArr, iC);
        return new String(cArr);
    }

    public final void a(CharSequence charSequence) {
        String strValueOf = String.valueOf(charSequence);
        String[] strArr = this.f9851d;
        if (strArr == null) {
            this.f9851d = new String[8];
        } else {
            int i10 = this.e;
            if (i10 == strArr.length) {
                this.f9851d = (String[]) Arrays.copyOf(strArr, i10 * 2);
            }
            this.f = this.f9849b.length() + this.f;
        }
        this.f = strValueOf.length() + this.f;
        String[] strArr2 = this.f9851d;
        int i11 = this.e;
        this.e = i11 + 1;
        strArr2[i11] = strValueOf;
    }

    public final void b() {
        String[] strArr;
        if (this.e > 1) {
            char[] cArr = new char[this.f];
            int iC = c(this.f9851d[0], cArr, 0);
            int i10 = 1;
            do {
                int iC2 = c(this.f9849b, cArr, iC) + iC;
                iC = c(this.f9851d[i10], cArr, iC2) + iC2;
                strArr = this.f9851d;
                strArr[i10] = null;
                i10++;
            } while (i10 < this.e);
            this.e = 1;
            strArr[0] = new String(cArr);
        }
    }
}
