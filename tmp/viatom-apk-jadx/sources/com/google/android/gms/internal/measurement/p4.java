package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class p4 implements y1.k {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2128a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2129b;

    public /* synthetic */ p4(Object obj) {
        this.f2129b = obj;
        this.f2128a = true;
    }

    @Override // y1.k
    public void a(y1.j jVar, int i10) {
        StringBuilder sb = (StringBuilder) this.f2129b;
        if (this.f2128a) {
            this.f2128a = false;
        } else {
            sb.append(", ");
        }
        sb.append(i10);
    }

    public void b() {
        this.f2128a = false;
    }

    public void c(byte b10) {
        ((h0.a0) this.f2129b).j(String.valueOf(b10));
    }

    public void d(char c10) {
        h0.a0 a0Var = (h0.a0) this.f2129b;
        a0Var.b(a0Var.f8352b, 1);
        char[] cArr = (char[]) a0Var.f8353c;
        int i10 = a0Var.f8352b;
        a0Var.f8352b = i10 + 1;
        cArr[i10] = c10;
    }

    public void e(int i10) {
        ((h0.a0) this.f2129b).j(String.valueOf(i10));
    }

    public void f(long j10) {
        ((h0.a0) this.f2129b).j(String.valueOf(j10));
    }

    public void g(short s9) {
        ((h0.a0) this.f2129b).j(String.valueOf(s9));
    }

    public void h(String str) {
        byte b10;
        str.getClass();
        h0.a0 a0Var = (h0.a0) this.f2129b;
        a0Var.b(a0Var.f8352b, str.length() + 2);
        char[] cArr = (char[]) a0Var.f8353c;
        int i10 = a0Var.f8352b;
        int i11 = i10 + 1;
        cArr[i10] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i11);
        int i12 = length + i11;
        int i13 = i11;
        while (i13 < i12) {
            char c10 = cArr[i13];
            byte[] bArr = i8.w.f9100b;
            if (c10 < bArr.length && bArr[c10] != 0) {
                int length2 = str.length();
                for (int i14 = i13 - i11; i14 < length2; i14++) {
                    a0Var.b(i13, 2);
                    char cCharAt = str.charAt(i14);
                    byte[] bArr2 = i8.w.f9100b;
                    if (cCharAt >= bArr2.length || (b10 = bArr2[cCharAt]) == 0) {
                        int i15 = i13 + 1;
                        ((char[]) a0Var.f8353c)[i13] = cCharAt;
                        i13 = i15;
                    } else {
                        if (b10 == 1) {
                            String str2 = i8.w.f9099a[cCharAt];
                            str2.getClass();
                            a0Var.b(i13, str2.length());
                            str2.getChars(0, str2.length(), (char[]) a0Var.f8353c, i13);
                            int length3 = str2.length() + i13;
                            a0Var.f8352b = length3;
                            i13 = length3;
                        } else {
                            char[] cArr2 = (char[]) a0Var.f8353c;
                            cArr2[i13] = '\\';
                            cArr2[i13 + 1] = (char) b10;
                            i13 += 2;
                            a0Var.f8352b = i13;
                        }
                    }
                }
                a0Var.b(i13, 1);
                ((char[]) a0Var.f8353c)[i13] = '\"';
                a0Var.f8352b = i13 + 1;
                return;
            }
            i13++;
        }
        cArr[i12] = '\"';
        a0Var.f8352b = i12 + 1;
    }

    public o4 k(long j10, String str) {
        Long lValueOf = Long.valueOf(j10);
        Object obj = o4.g;
        return new o4(this, str, lValueOf, 0);
    }

    public o4 l(String str, boolean z9) {
        Boolean boolValueOf = Boolean.valueOf(z9);
        Object obj = o4.g;
        return new o4(this, str, boolValueOf, 1);
    }

    public o4 m(String str, String str2) {
        Object obj = o4.g;
        return new o4(this, str, str2, 3);
    }

    public p4(Uri uri, boolean z9, boolean z10) {
        this.f2129b = uri;
        this.f2128a = z9;
    }

    public void i() {
    }

    public void j() {
    }
}
