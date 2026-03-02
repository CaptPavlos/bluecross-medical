package z8;

import java.io.IOException;
import java.io.InputStream;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14459a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14460b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14461c;

    public c(InputStream inputStream, j0 j0Var) {
        inputStream.getClass();
        this.f14460b = inputStream;
        this.f14461c = j0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f14459a) {
            case 0:
                g0 g0Var = (g0) this.f14460b;
                c cVar = (c) this.f14461c;
                g0Var.h();
                try {
                    cVar.close();
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
                ((InputStream) this.f14460b).close();
                return;
        }
    }

    @Override // z8.h0
    public final long g(i iVar, long j10) throws IOException {
        int i10 = this.f14459a;
        iVar.getClass();
        switch (i10) {
            case 0:
                g0 g0Var = (g0) this.f14460b;
                c cVar = (c) this.f14461c;
                g0Var.h();
                try {
                    long jG = cVar.g(iVar, j10);
                    if (g0Var.i()) {
                        throw g0Var.k(null);
                    }
                    return jG;
                } catch (IOException e) {
                    if (g0Var.i()) {
                        throw g0Var.k(e);
                    }
                    throw e;
                } finally {
                    g0Var.i();
                }
            default:
                if (j10 == 0) {
                    return 0L;
                }
                if (j10 < 0) {
                    f.b(a3.a.h(j10, "byteCount < 0: "));
                    return 0L;
                }
                try {
                    ((j0) this.f14461c).f();
                    c0 c0VarH = iVar.h(1);
                    int i11 = ((InputStream) this.f14460b).read(c0VarH.f14462a, c0VarH.f14464c, (int) Math.min(j10, 8192 - c0VarH.f14464c));
                    if (i11 == -1) {
                        if (c0VarH.f14463b == c0VarH.f14464c) {
                            iVar.f14478a = c0VarH.a();
                            d0.a(c0VarH);
                        }
                        return -1L;
                    }
                    c0VarH.f14464c += i11;
                    long j11 = i11;
                    iVar.f14479b += j11;
                    return j11;
                } catch (AssertionError e3) {
                    if (t1.D(e3)) {
                        throw new IOException(e3);
                    }
                    throw e3;
                }
        }
    }

    @Override // z8.h0
    public final j0 timeout() {
        switch (this.f14459a) {
            case 0:
                return (g0) this.f14460b;
            default:
                return (j0) this.f14461c;
        }
    }

    public final String toString() {
        switch (this.f14459a) {
            case 0:
                return "AsyncTimeout.source(" + ((c) this.f14461c) + ')';
            default:
                return "source(" + ((InputStream) this.f14460b) + ')';
        }
    }

    public c(g0 g0Var, c cVar) {
        this.f14460b = g0Var;
        this.f14461c = cVar;
    }
}
