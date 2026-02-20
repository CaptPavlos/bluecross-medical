package v8;

import java.io.InterruptedIOException;
import z8.f0;
import z8.j0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final z8.i f13271a = new z8.i();

    /* renamed from: b, reason: collision with root package name */
    public boolean f13272b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13273c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f13274d;

    public t(w wVar) {
        this.f13274d = wVar;
    }

    public final void a(boolean z9) {
        w wVar;
        long jMin;
        w wVar2;
        synchronized (this.f13274d) {
            this.f13274d.f13285j.h();
            while (true) {
                try {
                    wVar = this.f13274d;
                    if (wVar.f13281b > 0 || this.f13273c || this.f13272b || wVar.f13286k != 0) {
                        break;
                    }
                    try {
                        wVar.wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                } finally {
                    this.f13274d.f13285j.k();
                }
            }
            wVar.f13285j.k();
            this.f13274d.b();
            jMin = Math.min(this.f13274d.f13281b, this.f13271a.f14479b);
            wVar2 = this.f13274d;
            wVar2.f13281b -= jMin;
        }
        wVar2.f13285j.h();
        try {
            w wVar3 = this.f13274d;
            wVar3.f13283d.i(wVar3.f13282c, z9 && jMin == this.f13271a.f14479b, this.f13271a, jMin);
            this.f13274d.f13285j.k();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // z8.f0
    public final void c(z8.i iVar, long j10) {
        z8.i iVar2 = this.f13271a;
        iVar2.c(iVar, j10);
        while (iVar2.f14479b >= 16384) {
            a(false);
        }
    }

    @Override // z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f13274d) {
            try {
                if (this.f13272b) {
                    return;
                }
                w wVar = this.f13274d;
                if (!wVar.h.f13273c) {
                    if (this.f13271a.f14479b > 0) {
                        while (this.f13271a.f14479b > 0) {
                            a(true);
                        }
                    } else {
                        wVar.f13283d.i(wVar.f13282c, true, null, 0L);
                    }
                }
                synchronized (this.f13274d) {
                    this.f13272b = true;
                }
                this.f13274d.f13283d.flush();
                this.f13274d.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // z8.f0, java.io.Flushable
    public final void flush() {
        synchronized (this.f13274d) {
            this.f13274d.b();
        }
        while (this.f13271a.f14479b > 0) {
            a(false);
            this.f13274d.f13283d.flush();
        }
    }

    @Override // z8.f0
    public final j0 timeout() {
        return this.f13274d.f13285j;
    }
}
