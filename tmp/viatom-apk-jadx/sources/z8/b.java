package z8;

import com.google.android.gms.internal.measurement.l5;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14453a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14454b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14455c;

    public /* synthetic */ b(int i10, Object obj, Object obj2) {
        this.f14453a = i10;
        this.f14454b = obj;
        this.f14455c = obj2;
    }

    @Override // z8.f0
    public final void c(i iVar, long j10) throws IOException {
        switch (this.f14453a) {
            case 0:
                l5.k(iVar.f14479b, 0L, j10);
                long j11 = j10;
                while (true) {
                    long j12 = 0;
                    if (j11 <= 0) {
                        return;
                    }
                    c0 c0Var = iVar.f14478a;
                    c0Var.getClass();
                    while (true) {
                        if (j12 < 65536) {
                            j12 += c0Var.f14464c - c0Var.f14463b;
                            if (j12 >= j11) {
                                j12 = j11;
                            } else {
                                c0Var = c0Var.f;
                                c0Var.getClass();
                            }
                        }
                    }
                    g0 g0Var = (g0) this.f14454b;
                    b bVar = (b) this.f14455c;
                    g0Var.h();
                    try {
                        try {
                            bVar.c(iVar, j12);
                            if (g0Var.i()) {
                                throw g0Var.k(null);
                            }
                            j11 -= j12;
                        } catch (IOException e) {
                            if (!g0Var.i()) {
                                throw e;
                            }
                            throw g0Var.k(e);
                        }
                    } catch (Throwable th) {
                        g0Var.i();
                        throw th;
                    }
                }
            default:
                l5.k(iVar.f14479b, 0L, j10);
                while (j10 > 0) {
                    ((j0) this.f14455c).f();
                    c0 c0Var2 = iVar.f14478a;
                    c0Var2.getClass();
                    int iMin = (int) Math.min(j10, c0Var2.f14464c - c0Var2.f14463b);
                    ((OutputStream) this.f14454b).write(c0Var2.f14462a, c0Var2.f14463b, iMin);
                    int i10 = c0Var2.f14463b + iMin;
                    c0Var2.f14463b = i10;
                    long j13 = iMin;
                    j10 -= j13;
                    iVar.f14479b -= j13;
                    if (i10 == c0Var2.f14464c) {
                        iVar.f14478a = c0Var2.a();
                        d0.a(c0Var2);
                    }
                }
                return;
        }
    }

    @Override // z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f14453a) {
            case 0:
                g0 g0Var = (g0) this.f14454b;
                b bVar = (b) this.f14455c;
                g0Var.h();
                try {
                    bVar.close();
                    if (g0Var.i()) {
                        throw g0Var.k(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!g0Var.i()) {
                        throw e;
                    }
                    throw g0Var.k(e);
                } finally {
                    g0Var.i();
                }
            default:
                ((OutputStream) this.f14454b).close();
                return;
        }
    }

    @Override // z8.f0, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f14453a) {
            case 0:
                g0 g0Var = (g0) this.f14454b;
                b bVar = (b) this.f14455c;
                g0Var.h();
                try {
                    bVar.flush();
                    if (g0Var.i()) {
                        throw g0Var.k(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!g0Var.i()) {
                        throw e;
                    }
                    throw g0Var.k(e);
                } finally {
                    g0Var.i();
                }
            default:
                ((OutputStream) this.f14454b).flush();
                return;
        }
    }

    @Override // z8.f0
    public final j0 timeout() {
        switch (this.f14453a) {
            case 0:
                return (g0) this.f14454b;
            default:
                return (j0) this.f14455c;
        }
    }

    public final String toString() {
        switch (this.f14453a) {
            case 0:
                return "AsyncTimeout.sink(" + ((b) this.f14455c) + ')';
            default:
                return "sink(" + ((OutputStream) this.f14454b) + ')';
        }
    }
}
