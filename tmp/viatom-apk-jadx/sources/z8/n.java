package z8;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final v f14494a;

    /* renamed from: b, reason: collision with root package name */
    public long f14495b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14496c;

    public n(v vVar, long j10) {
        this.f14494a = vVar;
        this.f14495b = j10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        v vVar = this.f14494a;
        if (this.f14496c) {
            return;
        }
        this.f14496c = true;
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

    @Override // z8.h0
    public final long g(i iVar, long j10) {
        long j11;
        long j12;
        int i10;
        iVar.getClass();
        if (this.f14496c) {
            androidx.window.layout.c.g("closed");
            return 0L;
        }
        v vVar = this.f14494a;
        long j13 = this.f14495b;
        if (j10 < 0) {
            f.b(a3.a.h(j10, "byteCount < 0: "));
            return 0L;
        }
        long j14 = j10 + j13;
        long j15 = j13;
        while (true) {
            if (j15 >= j14) {
                j11 = -1;
                break;
            }
            c0 c0VarH = iVar.h(1);
            byte[] bArr = c0VarH.f14462a;
            int i11 = c0VarH.f14464c;
            j11 = -1;
            int iMin = (int) Math.min(j14 - j15, 8192 - i11);
            synchronized (vVar) {
                bArr.getClass();
                vVar.e.seek(j15);
                i10 = 0;
                while (true) {
                    if (i10 >= iMin) {
                        break;
                    }
                    int i12 = vVar.e.read(bArr, i11, iMin - i10);
                    if (i12 != -1) {
                        i10 += i12;
                    } else if (i10 == 0) {
                        i10 = -1;
                    }
                }
            }
            if (i10 == -1) {
                if (c0VarH.f14463b == c0VarH.f14464c) {
                    iVar.f14478a = c0VarH.a();
                    d0.a(c0VarH);
                }
                if (j13 == j15) {
                    j12 = -1;
                }
            } else {
                c0VarH.f14464c += i10;
                long j16 = i10;
                j15 += j16;
                iVar.f14479b += j16;
            }
        }
        j12 = j15 - j13;
        if (j12 != j11) {
            this.f14495b += j12;
        }
        return j12;
    }

    @Override // z8.h0
    public final j0 timeout() {
        return j0.f14480d;
    }
}
