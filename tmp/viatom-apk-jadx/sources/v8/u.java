package v8;

import java.io.IOException;
import java.io.InterruptedIOException;
import z8.h0;
import z8.j0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final z8.i f13275a = new z8.i();

    /* renamed from: b, reason: collision with root package name */
    public final z8.i f13276b = new z8.i();

    /* renamed from: c, reason: collision with root package name */
    public final long f13277c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13278d;
    public boolean e;
    public final /* synthetic */ w f;

    public u(w wVar, long j10) {
        this.f = wVar;
        this.f13277c = j10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f) {
            this.f13278d = true;
            z8.i iVar = this.f13276b;
            iVar.skip(iVar.f14479b);
            this.f.notifyAll();
        }
        this.f.a();
    }

    @Override // z8.h0
    public final long g(z8.i iVar, long j10) {
        if (j10 < 0) {
            com.google.gson.internal.a.n(a3.a.h(j10, "byteCount < 0: "));
            return 0L;
        }
        synchronized (this.f) {
            try {
                w wVar = this.f;
                wVar.f13284i.h();
                while (this.f13276b.f14479b == 0 && !this.e && !this.f13278d && wVar.f13286k == 0) {
                    try {
                        try {
                            wVar.wait();
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        wVar.f13284i.k();
                        throw th;
                    }
                }
                wVar.f13284i.k();
                if (this.f13278d) {
                    throw new IOException("stream closed");
                }
                int i10 = this.f.f13286k;
                if (i10 != 0) {
                    throw new a0(i10);
                }
                z8.i iVar2 = this.f13276b;
                long j11 = iVar2.f14479b;
                if (j11 == 0) {
                    return -1L;
                }
                long jG = iVar2.g(iVar, Math.min(j10, j11));
                w wVar2 = this.f;
                long j12 = wVar2.f13280a + jG;
                wVar2.f13280a = j12;
                if (j12 >= wVar2.f13283d.f13257n.c() / 2) {
                    w wVar3 = this.f;
                    wVar3.f13283d.k(wVar3.f13282c, wVar3.f13280a);
                    this.f.f13280a = 0L;
                }
                synchronized (this.f.f13283d) {
                    try {
                        q qVar = this.f.f13283d;
                        long j13 = qVar.f13255l + jG;
                        qVar.f13255l = j13;
                        if (j13 >= qVar.f13257n.c() / 2) {
                            q qVar2 = this.f.f13283d;
                            qVar2.k(0, qVar2.f13255l);
                            this.f.f13283d.f13255l = 0L;
                        }
                    } finally {
                    }
                }
                return jG;
            } finally {
            }
        }
    }

    @Override // z8.h0
    public final j0 timeout() {
        return this.f.f13284i;
    }
}
