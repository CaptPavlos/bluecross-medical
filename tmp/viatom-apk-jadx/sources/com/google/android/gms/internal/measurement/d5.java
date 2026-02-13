package com.google.android.gms.internal.measurement;

import androidx.work.WorkInfo;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d5 {
    public static final Logger e = Logger.getLogger(d5.class.getName());
    public static final boolean f = a7.e;

    /* renamed from: a, reason: collision with root package name */
    public c6 f1914a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f1915b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1916c;

    /* renamed from: d, reason: collision with root package name */
    public int f1917d;

    public d5(byte[] bArr, int i10) {
        int length = bArr.length;
        if (((length - i10) | i10) < 0) {
            Locale locale = Locale.US;
            com.google.gson.internal.a.n(androidx.constraintlayout.core.widgets.analyzer.a.u(length, i10, "Array range is invalid. Buffer.length=", ", offset=0, length="));
            throw null;
        }
        this.f1915b = bArr;
        this.f1917d = 0;
        this.f1916c = i10;
    }

    public static int a(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    public static int b(String str) {
        int length;
        try {
            length = c7.b(str);
        } catch (b7 unused) {
            length = str.getBytes(u5.f2192a).length;
        }
        return s(length) + length;
    }

    public static int s(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    public final void c(int i10, int i11) throws e5 {
        m((i10 << 3) | i11);
    }

    public final void d(int i10, int i11) throws e5 {
        m(i10 << 3);
        l(i11);
    }

    public final void e(int i10, int i11) throws e5 {
        m(i10 << 3);
        m(i11);
    }

    public final void f(int i10, int i11) throws e5 {
        m((i10 << 3) | 5);
        n(i11);
    }

    public final void g(int i10, long j10) throws e5 {
        m(i10 << 3);
        o(j10);
    }

    public final void h(int i10, long j10) throws e5 {
        m((i10 << 3) | 1);
        p(j10);
    }

    public final void i(int i10, c5 c5Var) throws e5 {
        m((i10 << 3) | 2);
        j(c5Var);
    }

    public final void j(c5 c5Var) throws e5 {
        m(c5Var.d());
        q(c5Var.d(), c5Var.f1902b);
    }

    public final void k(byte b10) throws e5 {
        int i10 = this.f1917d;
        try {
            int i11 = i10 + 1;
            try {
                this.f1915b[i10] = b10;
                this.f1917d = i11;
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                i10 = i11;
                throw new e5(i10, this.f1916c, 1, e);
            }
        } catch (IndexOutOfBoundsException e7) {
            e = e7;
        }
    }

    public final void l(int i10) throws e5 {
        if (i10 >= 0) {
            m(i10);
        } else {
            o(i10);
        }
    }

    public final void m(int i10) throws e5 {
        int i11;
        int i12 = this.f1917d;
        while (true) {
            int i13 = i10 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            byte[] bArr = this.f1915b;
            if (i13 == 0) {
                i11 = i12 + 1;
                bArr[i12] = (byte) i10;
                this.f1917d = i11;
                return;
            } else {
                i11 = i12 + 1;
                try {
                    bArr[i12] = (byte) (i10 | 128);
                    i10 >>>= 7;
                    i12 = i11;
                } catch (IndexOutOfBoundsException e3) {
                    throw new e5(i11, this.f1916c, 1, e3);
                }
            }
            throw new e5(i11, this.f1916c, 1, e3);
        }
    }

    public final void n(int i10) throws e5 {
        int i11 = this.f1917d;
        try {
            byte[] bArr = this.f1915b;
            bArr[i11] = (byte) i10;
            bArr[i11 + 1] = (byte) (i10 >> 8);
            bArr[i11 + 2] = (byte) (i10 >> 16);
            bArr[i11 + 3] = (byte) (i10 >> 24);
            this.f1917d = i11 + 4;
        } catch (IndexOutOfBoundsException e3) {
            throw new e5(i11, this.f1916c, 4, e3);
        }
    }

    public final void o(long j10) throws e5 {
        int i10;
        int i11 = this.f1917d;
        byte[] bArr = this.f1915b;
        int i12 = this.f1916c;
        if (!f || i12 - i11 < 10) {
            while ((j10 & (-128)) != 0) {
                int i13 = i11 + 1;
                try {
                    bArr[i11] = (byte) (((int) j10) | 128);
                    j10 >>>= 7;
                    i11 = i13;
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    i10 = i13;
                    throw new e5(i10, i12, 1, e);
                }
            }
            i10 = i11 + 1;
            try {
                bArr[i11] = (byte) j10;
            } catch (IndexOutOfBoundsException e7) {
                e = e7;
                throw new e5(i10, i12, 1, e);
            }
        } else {
            while ((j10 & (-128)) != 0) {
                a7.f1878c.a(bArr, a7.f + i11, (byte) (((int) j10) | 128));
                j10 >>>= 7;
                i11++;
            }
            i10 = i11 + 1;
            a7.f1878c.a(bArr, a7.f + i11, (byte) j10);
        }
        this.f1917d = i10;
    }

    public final void p(long j10) throws e5 {
        int i10 = this.f1917d;
        try {
            byte[] bArr = this.f1915b;
            bArr[i10] = (byte) j10;
            bArr[i10 + 1] = (byte) (j10 >> 8);
            bArr[i10 + 2] = (byte) (j10 >> 16);
            bArr[i10 + 3] = (byte) (j10 >> 24);
            bArr[i10 + 4] = (byte) (j10 >> 32);
            bArr[i10 + 5] = (byte) (j10 >> 40);
            bArr[i10 + 6] = (byte) (j10 >> 48);
            bArr[i10 + 7] = (byte) (j10 >> 56);
            this.f1917d = i10 + 8;
        } catch (IndexOutOfBoundsException e3) {
            throw new e5(i10, this.f1916c, 8, e3);
        }
    }

    public final void q(int i10, byte[] bArr) throws e5 {
        try {
            System.arraycopy(bArr, 0, this.f1915b, this.f1917d, i10);
            this.f1917d += i10;
        } catch (IndexOutOfBoundsException e3) {
            throw new e5(this.f1917d, this.f1916c, i10, e3);
        }
    }

    public final void r(String str) throws e5 {
        int i10 = this.f1917d;
        try {
            int iS = s(str.length() * 3);
            int iS2 = s(str.length());
            int i11 = this.f1916c;
            byte[] bArr = this.f1915b;
            if (iS2 != iS) {
                m(c7.b(str));
                int i12 = this.f1917d;
                this.f1917d = c7.c(str, bArr, i12, i11 - i12);
            } else {
                int i13 = i10 + iS2;
                this.f1917d = i13;
                int iC = c7.c(str, bArr, i13, i11 - i13);
                this.f1917d = i10;
                m((iC - i10) - iS2);
                this.f1917d = iC;
            }
        } catch (b7 e3) {
            this.f1917d = i10;
            e.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(u5.f2192a);
            try {
                int length = bytes.length;
                m(length);
                q(length, bytes);
            } catch (IndexOutOfBoundsException e7) {
                throw new e5(e7);
            }
        } catch (IndexOutOfBoundsException e10) {
            throw new e5(e10);
        }
    }
}
