package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c5 implements Iterable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final c5 f1900c = new c5(u5.f2193b);

    /* renamed from: a, reason: collision with root package name */
    public int f1901a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f1902b;

    static {
        int i10 = w4.f2246a;
    }

    public c5(byte[] bArr) {
        bArr.getClass();
        this.f1902b = bArr;
    }

    public static c5 e(int i10, int i11, byte[] bArr) {
        g(i10, i10 + i11, bArr.length);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new c5(bArr2);
    }

    public static int g(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i10);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i11 < i10) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 44 + String.valueOf(i11).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i10);
            sb2.append(", ");
            sb2.append(i11);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i11).length() + 15 + String.valueOf(i12).length());
        sb3.append("End index: ");
        sb3.append(i11);
        sb3.append(" >= ");
        sb3.append(i12);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public byte b(int i10) {
        return this.f1902b[i10];
    }

    public byte c(int i10) {
        return this.f1902b[i10];
    }

    public int d() {
        return this.f1902b.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof c5) && d() == ((c5) obj).d()) {
            if (d() == 0) {
                return true;
            }
            if (!(obj instanceof c5)) {
                return obj.equals(this);
            }
            c5 c5Var = (c5) obj;
            int i10 = this.f1901a;
            int i11 = c5Var.f1901a;
            if (i10 == 0 || i11 == 0 || i10 == i11) {
                int iD = d();
                if (iD > c5Var.d()) {
                    int iD2 = d();
                    StringBuilder sb = new StringBuilder(String.valueOf(iD).length() + 18 + String.valueOf(iD2).length());
                    sb.append("Length too large: ");
                    sb.append(iD);
                    sb.append(iD2);
                    throw new IllegalArgumentException(sb.toString());
                }
                if (iD <= c5Var.d()) {
                    byte[] bArr = c5Var.f1902b;
                    int i12 = 0;
                    int i13 = 0;
                    while (i12 < iD) {
                        if (this.f1902b[i12] == bArr[i13]) {
                            i12++;
                            i13++;
                        }
                    }
                    return true;
                }
                int iD3 = c5Var.d();
                StringBuilder sb2 = new StringBuilder(String.valueOf(iD).length() + 27 + String.valueOf(iD3).length());
                sb2.append("Ran off end of other: 0, ");
                sb2.append(iD);
                sb2.append(", ");
                sb2.append(iD3);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.f1901a;
        if (i10 != 0) {
            return i10;
        }
        int iD = d();
        int i11 = iD;
        for (int i12 = 0; i12 < iD; i12++) {
            i11 = (i11 * 31) + this.f1902b[i12];
        }
        if (i11 == 0) {
            i11 = 1;
        }
        this.f1901a = i11;
        return i11;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new a5(this);
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iD = d();
        if (d() <= 50) {
            strConcat = r0.f.Q(this);
        } else {
            int iG = g(0, 47, d());
            strConcat = r0.f.Q(iG == 0 ? f1900c : new b5(this.f1902b, iG)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iD);
        sb.append(" contents=\"");
        return a3.a.o(sb, strConcat, "\">");
    }
}
