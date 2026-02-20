package z8;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14512a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14513b;

    /* renamed from: c, reason: collision with root package name */
    public int f14514c;

    /* renamed from: d, reason: collision with root package name */
    public final ReentrantLock f14515d = new ReentrantLock();
    public final RandomAccessFile e;

    public v(boolean z9, RandomAccessFile randomAccessFile) {
        this.f14512a = z9;
        this.e = randomAccessFile;
    }

    public static m a(v vVar) {
        if (!vVar.f14512a) {
            androidx.window.layout.c.g("file handle is read-only");
            return null;
        }
        ReentrantLock reentrantLock = vVar.f14515d;
        reentrantLock.lock();
        try {
            if (vVar.f14513b) {
                throw new IllegalStateException("closed");
            }
            vVar.f14514c++;
            reentrantLock.unlock();
            return new m(vVar);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final n b(long j10) {
        ReentrantLock reentrantLock = this.f14515d;
        reentrantLock.lock();
        try {
            if (this.f14513b) {
                throw new IllegalStateException("closed");
            }
            this.f14514c++;
            reentrantLock.unlock();
            return new n(this, j10);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f14515d;
        reentrantLock.lock();
        try {
            if (this.f14513b) {
                return;
            }
            this.f14513b = true;
            if (this.f14514c != 0) {
                return;
            }
            synchronized (this) {
                this.e.close();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.f14512a) {
            androidx.window.layout.c.g("file handle is read-only");
            return;
        }
        ReentrantLock reentrantLock = this.f14515d;
        reentrantLock.lock();
        try {
            if (this.f14513b) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                this.e.getFD().sync();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long size() {
        long length;
        ReentrantLock reentrantLock = this.f14515d;
        reentrantLock.lock();
        try {
            if (this.f14513b) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                length = this.e.length();
            }
            return length;
        } finally {
            reentrantLock.unlock();
        }
    }
}
