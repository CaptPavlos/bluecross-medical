package z8;

import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.l5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements k, j, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public c0 f14478a;

    /* renamed from: b, reason: collision with root package name */
    public long f14479b;

    public final void a(i iVar, long j10, long j11) {
        iVar.getClass();
        long j12 = j10;
        l5.k(this.f14479b, j12, j11);
        if (j11 == 0) {
            return;
        }
        iVar.f14479b += j11;
        c0 c0Var = this.f14478a;
        while (true) {
            c0Var.getClass();
            long j13 = c0Var.f14464c - c0Var.f14463b;
            if (j12 < j13) {
                break;
            }
            j12 -= j13;
            c0Var = c0Var.f;
        }
        c0 c0Var2 = c0Var;
        long j14 = j11;
        while (j14 > 0) {
            c0Var2.getClass();
            c0 c0VarC = c0Var2.c();
            int i10 = c0VarC.f14463b + ((int) j12);
            c0VarC.f14463b = i10;
            c0VarC.f14464c = Math.min(i10 + ((int) j14), c0VarC.f14464c);
            c0 c0Var3 = iVar.f14478a;
            if (c0Var3 == null) {
                c0VarC.g = c0VarC;
                c0VarC.f = c0VarC;
                iVar.f14478a = c0VarC;
            } else {
                c0 c0Var4 = c0Var3.g;
                c0Var4.getClass();
                c0Var4.b(c0VarC);
            }
            j14 -= c0VarC.f14464c - c0VarC.f14463b;
            c0Var2 = c0Var2.f;
            j12 = 0;
        }
    }

    public final byte b(long j10) {
        l5.k(this.f14479b, j10, 1L);
        c0 c0Var = this.f14478a;
        c0Var.getClass();
        long j11 = this.f14479b;
        if (j11 - j10 < j10) {
            while (j11 > j10) {
                c0Var = c0Var.g;
                c0Var.getClass();
                j11 -= c0Var.f14464c - c0Var.f14463b;
            }
            return c0Var.f14462a[(int) ((c0Var.f14463b + j10) - j11)];
        }
        long j12 = 0;
        while (true) {
            int i10 = c0Var.f14464c;
            int i11 = c0Var.f14463b;
            long j13 = (i10 - i11) + j12;
            if (j13 > j10) {
                return c0Var.f14462a[(int) ((i11 + j10) - j12)];
            }
            c0Var = c0Var.f;
            c0Var.getClass();
            j12 = j13;
        }
    }

    @Override // z8.f0
    public final void c(i iVar, long j10) {
        c0 c0VarB;
        iVar.getClass();
        if (iVar == this) {
            com.google.gson.internal.a.n("source == this");
            return;
        }
        l5.k(iVar.f14479b, 0L, j10);
        while (j10 > 0) {
            c0 c0Var = iVar.f14478a;
            c0Var.getClass();
            int i10 = c0Var.f14464c;
            c0 c0Var2 = iVar.f14478a;
            c0Var2.getClass();
            long j11 = i10 - c0Var2.f14463b;
            int i11 = 0;
            if (j10 < j11) {
                c0 c0Var3 = this.f14478a;
                c0 c0Var4 = c0Var3 != null ? c0Var3.g : null;
                if (c0Var4 != null && c0Var4.e) {
                    if ((c0Var4.f14464c + j10) - (c0Var4.f14465d ? 0 : c0Var4.f14463b) <= 8192) {
                        c0 c0Var5 = iVar.f14478a;
                        c0Var5.getClass();
                        c0Var5.d(c0Var4, (int) j10);
                        iVar.f14479b -= j10;
                        this.f14479b += j10;
                        return;
                    }
                }
                c0 c0Var6 = iVar.f14478a;
                c0Var6.getClass();
                int i12 = (int) j10;
                if (i12 <= 0 || i12 > c0Var6.f14464c - c0Var6.f14463b) {
                    com.google.gson.internal.a.n("byteCount out of range");
                    return;
                }
                if (i12 >= 1024) {
                    c0VarB = c0Var6.c();
                } else {
                    c0VarB = d0.b();
                    byte[] bArr = c0Var6.f14462a;
                    byte[] bArr2 = c0VarB.f14462a;
                    int i13 = c0Var6.f14463b;
                    t6.j.k0(bArr, 0, i13, bArr2, i13 + i12);
                }
                c0VarB.f14464c = c0VarB.f14463b + i12;
                c0Var6.f14463b += i12;
                c0 c0Var7 = c0Var6.g;
                c0Var7.getClass();
                c0Var7.b(c0VarB);
                iVar.f14478a = c0VarB;
            }
            c0 c0Var8 = iVar.f14478a;
            c0Var8.getClass();
            long j12 = c0Var8.f14464c - c0Var8.f14463b;
            iVar.f14478a = c0Var8.a();
            c0 c0Var9 = this.f14478a;
            if (c0Var9 == null) {
                this.f14478a = c0Var8;
                c0Var8.g = c0Var8;
                c0Var8.f = c0Var8;
            } else {
                c0 c0Var10 = c0Var9.g;
                c0Var10.getClass();
                c0Var10.b(c0Var8);
                c0 c0Var11 = c0Var8.g;
                if (c0Var11 == c0Var8) {
                    androidx.window.layout.c.g("cannot compact");
                    return;
                }
                c0Var11.getClass();
                if (c0Var11.e) {
                    int i14 = c0Var8.f14464c - c0Var8.f14463b;
                    c0 c0Var12 = c0Var8.g;
                    c0Var12.getClass();
                    int i15 = 8192 - c0Var12.f14464c;
                    c0 c0Var13 = c0Var8.g;
                    c0Var13.getClass();
                    if (!c0Var13.f14465d) {
                        c0 c0Var14 = c0Var8.g;
                        c0Var14.getClass();
                        i11 = c0Var14.f14463b;
                    }
                    if (i14 <= i15 + i11) {
                        c0 c0Var15 = c0Var8.g;
                        c0Var15.getClass();
                        c0Var8.d(c0Var15, i14);
                        c0Var8.a();
                        d0.a(c0Var8);
                    }
                }
            }
            iVar.f14479b -= j12;
            this.f14479b += j12;
            j10 -= j12;
        }
    }

    public final Object clone() {
        i iVar = new i();
        if (this.f14479b == 0) {
            return iVar;
        }
        c0 c0Var = this.f14478a;
        c0Var.getClass();
        c0 c0VarC = c0Var.c();
        iVar.f14478a = c0VarC;
        c0VarC.g = c0VarC;
        c0VarC.f = c0VarC;
        for (c0 c0Var2 = c0Var.f; c0Var2 != c0Var; c0Var2 = c0Var2.f) {
            c0 c0Var3 = c0VarC.g;
            c0Var3.getClass();
            c0Var2.getClass();
            c0Var3.b(c0Var2.c());
        }
        iVar.f14479b = this.f14479b;
        return iVar;
    }

    public final long d(l lVar) {
        int i10;
        int i11;
        lVar.getClass();
        c0 c0Var = this.f14478a;
        if (c0Var == null) {
            return -1L;
        }
        long j10 = this.f14479b;
        long j11 = 0;
        if (j10 < 0) {
            while (j10 > 0) {
                c0Var = c0Var.g;
                c0Var.getClass();
                j10 -= c0Var.f14464c - c0Var.f14463b;
            }
            if (lVar.e() == 2) {
                byte bJ = lVar.j(0);
                byte bJ2 = lVar.j(1);
                while (j10 < this.f14479b) {
                    byte[] bArr = c0Var.f14462a;
                    i10 = (int) ((c0Var.f14463b + j11) - j10);
                    int i12 = c0Var.f14464c;
                    while (i10 < i12) {
                        byte b10 = bArr[i10];
                        if (b10 == bJ || b10 == bJ2) {
                            i11 = c0Var.f14463b;
                        } else {
                            i10++;
                        }
                    }
                    j11 = (c0Var.f14464c - c0Var.f14463b) + j10;
                    c0Var = c0Var.f;
                    c0Var.getClass();
                    j10 = j11;
                }
                return -1L;
            }
            byte[] bArrI = lVar.i();
            while (j10 < this.f14479b) {
                byte[] bArr2 = c0Var.f14462a;
                i10 = (int) ((c0Var.f14463b + j11) - j10);
                int i13 = c0Var.f14464c;
                while (i10 < i13) {
                    byte b11 = bArr2[i10];
                    for (byte b12 : bArrI) {
                        if (b11 == b12) {
                            i11 = c0Var.f14463b;
                        }
                    }
                    i10++;
                }
                j11 = (c0Var.f14464c - c0Var.f14463b) + j10;
                c0Var = c0Var.f;
                c0Var.getClass();
                j10 = j11;
            }
            return -1L;
        }
        j10 = 0;
        while (true) {
            long j12 = (c0Var.f14464c - c0Var.f14463b) + j10;
            if (j12 > 0) {
                break;
            }
            c0Var = c0Var.f;
            c0Var.getClass();
            j10 = j12;
        }
        if (lVar.e() == 2) {
            byte bJ3 = lVar.j(0);
            byte bJ4 = lVar.j(1);
            while (j10 < this.f14479b) {
                byte[] bArr3 = c0Var.f14462a;
                i10 = (int) ((c0Var.f14463b + j11) - j10);
                int i14 = c0Var.f14464c;
                while (i10 < i14) {
                    byte b13 = bArr3[i10];
                    if (b13 == bJ3 || b13 == bJ4) {
                        i11 = c0Var.f14463b;
                    } else {
                        i10++;
                    }
                }
                j11 = (c0Var.f14464c - c0Var.f14463b) + j10;
                c0Var = c0Var.f;
                c0Var.getClass();
                j10 = j11;
            }
            return -1L;
        }
        byte[] bArrI2 = lVar.i();
        while (j10 < this.f14479b) {
            byte[] bArr4 = c0Var.f14462a;
            i10 = (int) ((c0Var.f14463b + j11) - j10);
            int i15 = c0Var.f14464c;
            while (i10 < i15) {
                byte b14 = bArr4[i10];
                for (byte b15 : bArrI2) {
                    if (b14 == b15) {
                        i11 = c0Var.f14463b;
                    }
                }
                i10++;
            }
            j11 = (c0Var.f14464c - c0Var.f14463b) + j10;
            c0Var = c0Var.f;
            c0Var.getClass();
            j10 = j11;
        }
        return -1L;
        return (i10 - i11) + j10;
    }

    public final boolean e(long j10, l lVar) {
        lVar.getClass();
        int iE = lVar.e();
        if (j10 >= 0 && iE >= 0 && this.f14479b - j10 >= iE && lVar.e() >= iE) {
            for (int i10 = 0; i10 < iE; i10++) {
                if (b(i10 + j10) == lVar.j(i10)) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        long j10 = this.f14479b;
        i iVar = (i) obj;
        if (j10 != iVar.f14479b) {
            return false;
        }
        if (j10 == 0) {
            return true;
        }
        c0 c0Var = this.f14478a;
        c0Var.getClass();
        c0 c0Var2 = iVar.f14478a;
        c0Var2.getClass();
        int i10 = c0Var.f14463b;
        int i11 = c0Var2.f14463b;
        long j11 = 0;
        while (j11 < this.f14479b) {
            long jMin = Math.min(c0Var.f14464c - i10, c0Var2.f14464c - i11);
            long j12 = 0;
            while (j12 < jMin) {
                int i12 = i10 + 1;
                int i13 = i11 + 1;
                if (c0Var.f14462a[i10] != c0Var2.f14462a[i11]) {
                    return false;
                }
                j12++;
                i10 = i12;
                i11 = i13;
            }
            if (i10 == c0Var.f14464c) {
                c0Var = c0Var.f;
                c0Var.getClass();
                i10 = c0Var.f14463b;
            }
            if (i11 == c0Var2.f14464c) {
                c0Var2 = c0Var2.f;
                c0Var2.getClass();
                i11 = c0Var2.f14463b;
            }
            j11 += jMin;
        }
        return true;
    }

    public final boolean exhausted() {
        return this.f14479b == 0;
    }

    public final l f(int i10) {
        if (i10 == 0) {
            return l.f14487d;
        }
        l5.k(this.f14479b, 0L, i10);
        c0 c0Var = this.f14478a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            c0Var.getClass();
            int i14 = c0Var.f14464c;
            int i15 = c0Var.f14463b;
            if (i14 == i15) {
                p8.u.h("s.limit == s.pos");
                return null;
            }
            i12 += i14 - i15;
            i13++;
            c0Var = c0Var.f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        c0 c0Var2 = this.f14478a;
        int i16 = 0;
        while (i11 < i10) {
            c0Var2.getClass();
            bArr[i16] = c0Var2.f14462a;
            i11 += c0Var2.f14464c - c0Var2.f14463b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = c0Var2.f14463b;
            c0Var2.f14465d = true;
            i16++;
            c0Var2 = c0Var2.f;
        }
        return new e0(bArr, iArr);
    }

    @Override // z8.h0
    public final long g(i iVar, long j10) {
        iVar.getClass();
        if (j10 < 0) {
            f.b(a3.a.h(j10, "byteCount < 0: "));
            return 0L;
        }
        long j11 = this.f14479b;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        iVar.c(this, j10);
        return j10;
    }

    public final c0 h(int i10) {
        if (i10 < 1 || i10 > 8192) {
            com.google.gson.internal.a.n("unexpected capacity");
            return null;
        }
        c0 c0Var = this.f14478a;
        if (c0Var == null) {
            c0 c0VarB = d0.b();
            this.f14478a = c0VarB;
            c0VarB.g = c0VarB;
            c0VarB.f = c0VarB;
            return c0VarB;
        }
        c0 c0Var2 = c0Var.g;
        c0Var2.getClass();
        if (c0Var2.f14464c + i10 <= 8192 && c0Var2.e) {
            return c0Var2;
        }
        c0 c0VarB2 = d0.b();
        c0Var2.b(c0VarB2);
        return c0VarB2;
    }

    public final int hashCode() {
        c0 c0Var = this.f14478a;
        if (c0Var == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = c0Var.f14464c;
            for (int i12 = c0Var.f14463b; i12 < i11; i12++) {
                i10 = (i10 * 31) + c0Var.f14462a[i12];
            }
            c0Var = c0Var.f;
            c0Var.getClass();
        } while (c0Var != this.f14478a);
        return i10;
    }

    public final void i(l lVar) {
        lVar.getClass();
        lVar.s(this, lVar.e());
    }

    public final long indexOf(byte b10, long j10, long j11) {
        c0 c0Var;
        long j12 = 0;
        if (0 > j10 || j10 > j11) {
            throw new IllegalArgumentException(("size=" + this.f14479b + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        long j13 = this.f14479b;
        if (j11 > j13) {
            j11 = j13;
        }
        if (j10 == j11 || (c0Var = this.f14478a) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                c0Var = c0Var.g;
                c0Var.getClass();
                j13 -= c0Var.f14464c - c0Var.f14463b;
            }
            while (j13 < j11) {
                byte[] bArr = c0Var.f14462a;
                int iMin = (int) Math.min(c0Var.f14464c, (c0Var.f14463b + j11) - j13);
                for (int i10 = (int) ((c0Var.f14463b + j10) - j13); i10 < iMin; i10++) {
                    if (bArr[i10] == b10) {
                        return (i10 - c0Var.f14463b) + j13;
                    }
                }
                j13 += c0Var.f14464c - c0Var.f14463b;
                c0Var = c0Var.f;
                c0Var.getClass();
                j10 = j13;
            }
            return -1L;
        }
        while (true) {
            long j14 = (c0Var.f14464c - c0Var.f14463b) + j12;
            if (j14 > j10) {
                break;
            }
            c0Var = c0Var.f;
            c0Var.getClass();
            j12 = j14;
        }
        while (j12 < j11) {
            byte[] bArr2 = c0Var.f14462a;
            int iMin2 = (int) Math.min(c0Var.f14464c, (c0Var.f14463b + j11) - j12);
            for (int i11 = (int) ((c0Var.f14463b + j10) - j12); i11 < iMin2; i11++) {
                if (bArr2[i11] == b10) {
                    return (i11 - c0Var.f14463b) + j12;
                }
            }
            j12 += c0Var.f14464c - c0Var.f14463b;
            c0Var = c0Var.f;
            c0Var.getClass();
            j10 = j12;
        }
        return -1L;
    }

    @Override // z8.k
    public final InputStream inputStream() {
        return new g(this, 0);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final void j(h0 h0Var) {
        h0Var.getClass();
        while (h0Var.g(this, 8192L) != -1) {
        }
    }

    public final void k(int i10) {
        c0 c0VarH = h(1);
        byte[] bArr = c0VarH.f14462a;
        int i11 = c0VarH.f14464c;
        c0VarH.f14464c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.f14479b++;
    }

    public final void l(long j10) {
        boolean z9;
        if (j10 == 0) {
            k(48);
            return;
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                q("-9223372036854775808");
                return;
            }
            z9 = true;
        } else {
            z9 = false;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < 10000000000L ? j10 < C.NANOS_PER_SECOND ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= WorkRequest.MIN_BACKOFF_MILLIS) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z9) {
            i10++;
        }
        c0 c0VarH = h(i10);
        byte[] bArr = c0VarH.f14462a;
        int i11 = c0VarH.f14464c + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = a9.a.f329a[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z9) {
            bArr[i11 - 1] = 45;
        }
        c0VarH.f14464c += i10;
        this.f14479b += i10;
    }

    public final void m(long j10) {
        if (j10 == 0) {
            k(48);
            return;
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        c0 c0VarH = h(i10);
        byte[] bArr = c0VarH.f14462a;
        int i11 = c0VarH.f14464c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = a9.a.f329a[(int) (15 & j10)];
            j10 >>>= 4;
        }
        c0VarH.f14464c += i10;
        this.f14479b += i10;
    }

    public final void n(int i10) {
        c0 c0VarH = h(4);
        byte[] bArr = c0VarH.f14462a;
        int i11 = c0VarH.f14464c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        c0VarH.f14464c = i11 + 4;
        this.f14479b += 4;
    }

    public final void o(int i10) {
        c0 c0VarH = h(2);
        byte[] bArr = c0VarH.f14462a;
        int i11 = c0VarH.f14464c;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        c0VarH.f14464c = i11 + 2;
        this.f14479b += 2;
    }

    @Override // z8.j
    public final OutputStream outputStream() {
        return new h(this, 0);
    }

    public final void p(int i10, int i11, String str) {
        char cCharAt;
        str.getClass();
        if (i10 < 0) {
            f.b(a3.a.f(i10, "beginIndex < 0: "));
            return;
        }
        if (i11 < i10) {
            f.b(androidx.constraintlayout.core.widgets.analyzer.a.u(i11, i10, "endIndex < beginIndex: ", " < "));
            return;
        }
        if (i11 > str.length()) {
            StringBuilder sbR = a3.a.r(i11, "endIndex > string.length: ", " > ");
            sbR.append(str.length());
            throw new IllegalArgumentException(sbR.toString().toString());
        }
        while (i10 < i11) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 128) {
                c0 c0VarH = h(1);
                byte[] bArr = c0VarH.f14462a;
                int i12 = c0VarH.f14464c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= iMin || (cCharAt = str.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt;
                }
                int i14 = c0VarH.f14464c;
                int i15 = (i12 + i10) - i14;
                c0VarH.f14464c = i14 + i15;
                this.f14479b += i15;
            } else {
                if (cCharAt2 < 2048) {
                    c0 c0VarH2 = h(2);
                    byte[] bArr2 = c0VarH2.f14462a;
                    int i16 = c0VarH2.f14464c;
                    bArr2[i16] = (byte) ((cCharAt2 >> 6) | PsExtractor.AUDIO_STREAM);
                    bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    c0VarH2.f14464c = i16 + 2;
                    this.f14479b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    c0 c0VarH3 = h(3);
                    byte[] bArr3 = c0VarH3.f14462a;
                    int i17 = c0VarH3.f14464c;
                    bArr3[i17] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    c0VarH3.f14464c = i17 + 3;
                    this.f14479b += 3;
                } else {
                    int i18 = i10 + 1;
                    char cCharAt3 = i18 < i11 ? str.charAt(i18) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        k(63);
                        i10 = i18;
                    } else {
                        int i19 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        c0 c0VarH4 = h(4);
                        byte[] bArr4 = c0VarH4.f14462a;
                        int i20 = c0VarH4.f14464c;
                        bArr4[i20] = (byte) ((i19 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                        bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                        bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                        c0VarH4.f14464c = i20 + 4;
                        this.f14479b += 4;
                        i10 += 2;
                    }
                }
                i10++;
            }
        }
    }

    public final void q(String str) {
        str.getClass();
        p(0, str.length(), str);
    }

    public final void r(int i10) {
        String str;
        if (i10 < 128) {
            k(i10);
            return;
        }
        if (i10 < 2048) {
            c0 c0VarH = h(2);
            byte[] bArr = c0VarH.f14462a;
            int i11 = c0VarH.f14464c;
            bArr[i11] = (byte) ((i10 >> 6) | PsExtractor.AUDIO_STREAM);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            c0VarH.f14464c = i11 + 2;
            this.f14479b += 2;
            return;
        }
        if (55296 <= i10 && i10 < 57344) {
            k(63);
            return;
        }
        if (i10 < 65536) {
            c0 c0VarH2 = h(3);
            byte[] bArr2 = c0VarH2.f14462a;
            int i12 = c0VarH2.f14464c;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            c0VarH2.f14464c = i12 + 3;
            this.f14479b += 3;
            return;
        }
        if (i10 <= 1114111) {
            c0 c0VarH3 = h(4);
            byte[] bArr3 = c0VarH3.f14462a;
            int i13 = c0VarH3.f14464c;
            bArr3[i13] = (byte) ((i10 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
            bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
            bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
            c0VarH3.f14464c = i13 + 4;
            this.f14479b += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i10 != 0) {
            char[] cArr = a9.b.f330a;
            char[] cArr2 = {cArr[(i10 >> 28) & 15], cArr[(i10 >> 24) & 15], cArr[(i10 >> 20) & 15], cArr[(i10 >> 16) & 15], cArr[(i10 >> 12) & 15], cArr[(i10 >> 8) & 15], cArr[(i10 >> 4) & 15], cArr[i10 & 15]};
            int i14 = 0;
            while (i14 < 8 && cArr2[i14] == '0') {
                i14++;
            }
            t6.e.Companion.getClass();
            t6.b.a(i14, 8, 8);
            str = new String(cArr2, i14, 8 - i14);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public final int read(byte[] bArr, int i10, int i11) {
        l5.k(bArr.length, i10, i11);
        c0 c0Var = this.f14478a;
        if (c0Var == null) {
            return -1;
        }
        int iMin = Math.min(i11, c0Var.f14464c - c0Var.f14463b);
        byte[] bArr2 = c0Var.f14462a;
        int i12 = c0Var.f14463b;
        t6.j.k0(bArr2, i10, i12, bArr, i12 + iMin);
        int i13 = c0Var.f14463b + iMin;
        c0Var.f14463b = i13;
        this.f14479b -= iMin;
        if (i13 == c0Var.f14464c) {
            this.f14478a = c0Var.a();
            d0.a(c0Var);
        }
        return iMin;
    }

    @Override // z8.k
    public final byte readByte() throws EOFException {
        if (this.f14479b == 0) {
            p8.u.q();
            return (byte) 0;
        }
        c0 c0Var = this.f14478a;
        c0Var.getClass();
        int i10 = c0Var.f14463b;
        int i11 = c0Var.f14464c;
        int i12 = i10 + 1;
        byte b10 = c0Var.f14462a[i10];
        this.f14479b--;
        if (i12 != i11) {
            c0Var.f14463b = i12;
            return b10;
        }
        this.f14478a = c0Var.a();
        d0.a(c0Var);
        return b10;
    }

    public final byte[] readByteArray(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            f.b(a3.a.h(j10, "byteCount: "));
            return null;
        }
        if (this.f14479b < j10) {
            p8.u.q();
            return null;
        }
        int i10 = (int) j10;
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int i12 = read(bArr, i11, i10 - i11);
            if (i12 == -1) {
                p8.u.q();
                return null;
            }
            i11 += i12;
        }
        return bArr;
    }

    @Override // z8.k
    public final l readByteString(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            f.b(a3.a.h(j10, "byteCount: "));
            return null;
        }
        if (this.f14479b < j10) {
            p8.u.q();
            return null;
        }
        if (j10 < 4096) {
            return new l(readByteArray(j10));
        }
        l lVarF = f((int) j10);
        skip(j10);
        return lVarF;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r2 = new z8.i();
        r2.l(r7);
        r2.k(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if (r9 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        r2.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: ".concat(r2.readString(r2.f14479b, o7.a.f11749a)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long readDecimalLong() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.i.readDecimalLong():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6 A[EDGE_INSN: B:44:0x00a6->B:38:0x00a6 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    @Override // z8.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f14479b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lad
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            z8.c0 r7 = r15.f14478a
            r7.getClass()
            byte[] r8 = r7.f14462a
            int r9 = r7.f14463b
            int r10 = r7.f14464c
        L17:
            if (r9 >= r10) goto L92
            r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L26
            r12 = 57
            if (r11 > r12) goto L26
            int r12 = r11 + (-48)
            goto L3b
        L26:
            r12 = 97
            if (r11 < r12) goto L31
            r12 = 102(0x66, float:1.43E-43)
            if (r11 > r12) goto L31
            int r12 = r11 + (-87)
            goto L3b
        L31:
            r12 = 65
            if (r11 < r12) goto L6a
            r12 = 70
            if (r11 > r12) goto L6a
            int r12 = r11 + (-55)
        L3b:
            r13 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r13 = r13 & r4
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 != 0) goto L4b
            r11 = 4
            long r4 = r4 << r11
            long r11 = (long) r12
            long r4 = r4 | r11
            int r9 = r9 + 1
            int r1 = r1 + 1
            goto L17
        L4b:
            z8.i r0 = new z8.i
            r0.<init>()
            r0.m(r4)
            r0.k(r11)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            long r2 = r0.f14479b
            java.nio.charset.Charset r4 = o7.a.f11749a
            java.lang.String r0 = r0.readString(r2, r4)
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L6a:
            r6 = 1
            if (r1 == 0) goto L6e
            goto L92
        L6e:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            int r2 = r11 >> 4
            r2 = r2 & 15
            char[] r3 = a9.b.f330a
            char r2 = r3[r2]
            r4 = r11 & 15
            char r3 = r3[r4]
            r4 = 2
            char[] r4 = new char[r4]
            r4[r0] = r2
            r4[r6] = r3
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L92:
            if (r9 != r10) goto L9e
            z8.c0 r8 = r7.a()
            r15.f14478a = r8
            z8.d0.a(r7)
            goto La0
        L9e:
            r7.f14463b = r9
        La0:
            if (r6 != 0) goto La6
            z8.c0 r7 = r15.f14478a
            if (r7 != 0) goto Lc
        La6:
            long r2 = r15.f14479b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f14479b = r2
            return r4
        Lad:
            p8.u.q()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.i.readHexadecimalUnsignedLong():long");
    }

    @Override // z8.k
    public final int readInt() throws EOFException {
        if (this.f14479b < 4) {
            p8.u.q();
            return 0;
        }
        c0 c0Var = this.f14478a;
        c0Var.getClass();
        int i10 = c0Var.f14463b;
        int i11 = c0Var.f14464c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = c0Var.f14462a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        this.f14479b -= 4;
        if (i14 != i11) {
            c0Var.f14463b = i14;
            return i15;
        }
        this.f14478a = c0Var.a();
        d0.a(c0Var);
        return i15;
    }

    @Override // z8.k
    public final short readShort() throws EOFException {
        if (this.f14479b < 2) {
            p8.u.q();
            return (short) 0;
        }
        c0 c0Var = this.f14478a;
        c0Var.getClass();
        int i10 = c0Var.f14463b;
        int i11 = c0Var.f14464c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = c0Var.f14462a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        this.f14479b -= 2;
        if (i14 == i11) {
            this.f14478a = c0Var.a();
            d0.a(c0Var);
        } else {
            c0Var.f14463b = i14;
        }
        return (short) i15;
    }

    public final short readShortLe() throws EOFException {
        short s9 = readShort();
        return (short) (((s9 & 255) << 8) | ((65280 & s9) >>> 8));
    }

    public final String readString(long j10, Charset charset) throws EOFException {
        charset.getClass();
        if (j10 < 0 || j10 > 2147483647L) {
            f.b(a3.a.h(j10, "byteCount: "));
            return null;
        }
        if (this.f14479b < j10) {
            p8.u.q();
            return null;
        }
        if (j10 == 0) {
            return "";
        }
        c0 c0Var = this.f14478a;
        c0Var.getClass();
        int i10 = c0Var.f14463b;
        if (i10 + j10 > c0Var.f14464c) {
            return new String(readByteArray(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(c0Var.f14462a, i10, i11, charset);
        int i12 = c0Var.f14463b + i11;
        c0Var.f14463b = i12;
        this.f14479b -= j10;
        if (i12 == c0Var.f14464c) {
            this.f14478a = c0Var.a();
            d0.a(c0Var);
        }
        return str;
    }

    @Override // z8.k
    public final String readUtf8LineStrict(long j10) throws EOFException {
        if (j10 < 0) {
            f.b(a3.a.h(j10, "limit < 0: "));
            return null;
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j11);
        if (jIndexOf != -1) {
            return a9.a.a(this, jIndexOf);
        }
        if (j11 < this.f14479b && b(j11 - 1) == 13 && b(j11) == 10) {
            return a9.a.a(this, j11);
        }
        i iVar = new i();
        a(iVar, 0L, Math.min(32, this.f14479b));
        p8.u.g(Math.min(this.f14479b, j10), iVar.readByteString(iVar.f14479b).f());
        return null;
    }

    @Override // z8.k
    public final void require(long j10) throws EOFException {
        if (this.f14479b >= j10) {
            return;
        }
        p8.u.q();
    }

    @Override // z8.k
    public final void skip(long j10) throws EOFException {
        while (j10 > 0) {
            c0 c0Var = this.f14478a;
            if (c0Var == null) {
                p8.u.q();
                return;
            }
            int iMin = (int) Math.min(j10, c0Var.f14464c - c0Var.f14463b);
            long j11 = iMin;
            this.f14479b -= j11;
            j10 -= j11;
            int i10 = c0Var.f14463b + iMin;
            c0Var.f14463b = i10;
            if (i10 == c0Var.f14464c) {
                this.f14478a = c0Var.a();
                d0.a(c0Var);
            }
        }
    }

    @Override // z8.h0
    public final j0 timeout() {
        return j0.f14480d;
    }

    public final String toString() {
        long j10 = this.f14479b;
        if (j10 <= 2147483647L) {
            return f((int) j10).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f14479b).toString());
    }

    public final void write(byte[] bArr, int i10, int i11) {
        bArr.getClass();
        long j10 = i11;
        l5.k(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            c0 c0VarH = h(1);
            int iMin = Math.min(i12 - i10, 8192 - c0VarH.f14464c);
            int i13 = i10 + iMin;
            t6.j.k0(bArr, c0VarH.f14464c, i10, c0VarH.f14462a, i13);
            c0VarH.f14464c += iMin;
            i10 = i13;
        }
        this.f14479b += j10;
    }

    @Override // z8.j
    public final /* bridge */ /* synthetic */ j writeByte(int i10) {
        k(i10);
        return this;
    }

    @Override // z8.j
    public final /* bridge */ /* synthetic */ j writeHexadecimalUnsignedLong(long j10) {
        m(j10);
        return this;
    }

    @Override // z8.j
    public final /* bridge */ /* synthetic */ j writeInt(int i10) {
        n(i10);
        return this;
    }

    @Override // z8.j
    public final /* bridge */ /* synthetic */ j writeShort(int i10) {
        o(i10);
        return this;
    }

    @Override // z8.j
    public final /* bridge */ /* synthetic */ j writeUtf8(String str) {
        q(str);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, z8.f0
    public final void close() {
    }

    @Override // z8.j, z8.f0, java.io.Flushable
    public final void flush() {
    }

    @Override // z8.j
    public final j write(byte[] bArr) {
        write(bArr, 0, bArr.length);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            c0 c0VarH = h(1);
            int iMin = Math.min(i10, 8192 - c0VarH.f14464c);
            byteBuffer.get(c0VarH.f14462a, c0VarH.f14464c, iMin);
            i10 -= iMin;
            c0VarH.f14464c += iMin;
        }
        this.f14479b += iRemaining;
        return iRemaining;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        c0 c0Var = this.f14478a;
        if (c0Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), c0Var.f14464c - c0Var.f14463b);
        byteBuffer.put(c0Var.f14462a, c0Var.f14463b, iMin);
        int i10 = c0Var.f14463b + iMin;
        c0Var.f14463b = i10;
        this.f14479b -= iMin;
        if (i10 == c0Var.f14464c) {
            this.f14478a = c0Var.a();
            d0.a(c0Var);
        }
        return iMin;
    }

    @Override // z8.k
    public final String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }
}
