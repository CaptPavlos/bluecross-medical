package v8;

import j4.c0;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x implements Closeable {
    public static final Logger g = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final z8.j f13287a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13288b;

    /* renamed from: c, reason: collision with root package name */
    public final z8.i f13289c;

    /* renamed from: d, reason: collision with root package name */
    public int f13290d;
    public boolean e;
    public final c0 f;

    public x(z8.a0 a0Var, boolean z9) {
        this.f13287a = a0Var;
        this.f13288b = z9;
        z8.i iVar = new z8.i();
        this.f13289c = iVar;
        this.f = new c0(iVar);
        this.f13290d = 16384;
    }

    public final synchronized void a(h0.a0 a0Var) {
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            int i10 = this.f13290d;
            int i11 = a0Var.f8352b;
            if ((i11 & 32) != 0) {
                i10 = ((int[]) a0Var.f8353c)[5];
            }
            this.f13290d = i10;
            if (((i11 & 2) != 0 ? ((int[]) a0Var.f8353c)[1] : -1) != -1) {
                c0 c0Var = this.f;
                int iMin = Math.min((i11 & 2) != 0 ? ((int[]) a0Var.f8353c)[1] : -1, 16384);
                int i12 = c0Var.f9927d;
                if (i12 != iMin) {
                    if (iMin < i12) {
                        c0Var.f9926c = Math.min(c0Var.f9926c, iMin);
                    }
                    c0Var.f = true;
                    c0Var.f9927d = iMin;
                    int i13 = c0Var.h;
                    if (iMin < i13) {
                        if (iMin == 0) {
                            Arrays.fill((b[]) c0Var.f9928i, (Object) null);
                            c0Var.e = ((b[]) c0Var.f9928i).length - 1;
                            c0Var.g = 0;
                            c0Var.h = 0;
                        } else {
                            c0Var.a(i13 - iMin);
                        }
                    }
                }
            }
            d(0, 0, (byte) 4, (byte) 1);
            this.f13287a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(boolean z9, int i10, z8.i iVar, int i11) {
        if (this.e) {
            throw new IOException("closed");
        }
        d(i10, i11, (byte) 0, z9 ? (byte) 1 : (byte) 0);
        if (i11 > 0) {
            this.f13287a.c(iVar, i11);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.e = true;
        this.f13287a.close();
    }

    public final void d(int i10, int i11, byte b10, byte b11) {
        Level level = Level.FINE;
        Logger logger = g;
        if (logger.isLoggable(level)) {
            logger.fine(e.a(false, i10, i11, b10, b11));
        }
        int i12 = this.f13290d;
        if (i11 > i12) {
            e.b("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
            throw null;
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            e.b("reserved bit set: %s", Integer.valueOf(i10));
            throw null;
        }
        z8.j jVar = this.f13287a;
        jVar.writeByte((i11 >>> 16) & 255);
        jVar.writeByte((i11 >>> 8) & 255);
        jVar.writeByte(i11 & 255);
        jVar.writeByte(b10 & 255);
        jVar.writeByte(b11 & 255);
        jVar.writeInt(i10 & Integer.MAX_VALUE);
    }

    public final synchronized void e(int i10, int i11, byte[] bArr) {
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            if (r1.i.a(i11) == -1) {
                e.b("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            d(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f13287a.writeInt(i10);
            this.f13287a.writeInt(r1.i.a(i11));
            if (bArr.length > 0) {
                this.f13287a.write(bArr);
            }
            this.f13287a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.util.ArrayList r18, int r19, boolean r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v8.x.f(java.util.ArrayList, int, boolean):void");
    }

    public final synchronized void flush() {
        if (this.e) {
            throw new IOException("closed");
        }
        this.f13287a.flush();
    }

    public final synchronized void h(boolean z9, int i10, int i11) {
        if (this.e) {
            throw new IOException("closed");
        }
        d(0, 8, (byte) 6, z9 ? (byte) 1 : (byte) 0);
        this.f13287a.writeInt(i10);
        this.f13287a.writeInt(i11);
        this.f13287a.flush();
    }

    public final synchronized void i(int i10, int i11) {
        if (this.e) {
            throw new IOException("closed");
        }
        if (r1.i.a(i11) == -1) {
            throw new IllegalArgumentException();
        }
        d(i10, 4, (byte) 3, (byte) 0);
        this.f13287a.writeInt(r1.i.a(i11));
        this.f13287a.flush();
    }

    public final synchronized void j(h0.a0 a0Var) {
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            d(0, Integer.bitCount(a0Var.f8352b) * 6, (byte) 4, (byte) 0);
            int i10 = 0;
            while (i10 < 10) {
                boolean z9 = true;
                if (((1 << i10) & a0Var.f8352b) == 0) {
                    z9 = false;
                }
                if (z9) {
                    this.f13287a.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                    this.f13287a.writeInt(((int[]) a0Var.f8353c)[i10]);
                }
                i10++;
            }
            this.f13287a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k(ArrayList arrayList, int i10, boolean z9) {
        if (this.e) {
            throw new IOException("closed");
        }
        f(arrayList, i10, z9);
    }

    public final synchronized void l(int i10, long j10) {
        if (this.e) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > 2147483647L) {
            e.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
            throw null;
        }
        d(i10, 4, (byte) 8, (byte) 0);
        this.f13287a.writeInt((int) j10);
        this.f13287a.flush();
    }
}
