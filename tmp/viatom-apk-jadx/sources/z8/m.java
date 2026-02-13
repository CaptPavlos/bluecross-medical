package z8;

import com.google.android.gms.internal.measurement.l5;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final v f14491a;

    /* renamed from: b, reason: collision with root package name */
    public long f14492b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14493c;

    public m(v vVar) {
        vVar.getClass();
        this.f14491a = vVar;
        this.f14492b = 0L;
    }

    @Override // z8.f0
    public final void c(i iVar, long j10) {
        if (this.f14493c) {
            androidx.window.layout.c.g("closed");
            return;
        }
        v vVar = this.f14491a;
        long j11 = this.f14492b;
        vVar.getClass();
        l5.k(iVar.f14479b, 0L, j10);
        long j12 = j11 + j10;
        while (j11 < j12) {
            c0 c0Var = iVar.f14478a;
            c0Var.getClass();
            int iMin = (int) Math.min(j12 - j11, c0Var.f14464c - c0Var.f14463b);
            byte[] bArr = c0Var.f14462a;
            int i10 = c0Var.f14463b;
            synchronized (vVar) {
                bArr.getClass();
                vVar.e.seek(j11);
                vVar.e.write(bArr, i10, iMin);
            }
            int i11 = c0Var.f14463b + iMin;
            c0Var.f14463b = i11;
            long j13 = iMin;
            j11 += j13;
            iVar.f14479b -= j13;
            if (i11 == c0Var.f14464c) {
                iVar.f14478a = c0Var.a();
                d0.a(c0Var);
            }
        }
        this.f14492b += j10;
    }

    @Override // z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        v vVar = this.f14491a;
        if (this.f14493c) {
            return;
        }
        this.f14493c = true;
        ReentrantLock reentrantLock = vVar.f14515d;
        reentrantLock.lock();
        try {
            int i10 = vVar.f14514c - 1;
            vVar.f14514c = i10;
            if (i10 == 0) {
                if (vVar.f14513b) {
                    synchronized (vVar) {
                        vVar.e.close();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // z8.f0, java.io.Flushable
    public final void flush() {
        if (this.f14493c) {
            androidx.window.layout.c.g("closed");
            return;
        }
        v vVar = this.f14491a;
        synchronized (vVar) {
            vVar.e.getFD().sync();
        }
    }

    @Override // z8.f0
    public final j0 timeout() {
        return j0.f14480d;
    }
}
