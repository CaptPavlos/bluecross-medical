package r7;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends s0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final z h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f12457i;

    static {
        Long l10;
        z zVar = new z();
        h = zVar;
        zVar.o(false);
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f12457i = TimeUnit.MILLISECONDS.toNanos(l10.longValue());
    }

    @Override // r7.s0, r7.d0
    public final k0 k(long j10, t1 t1Var, w6.h hVar) {
        long j11 = j10 > 0 ? j10 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j10 : 0L;
        if (j11 >= 4611686018427387903L) {
            return m1.f12414a;
        }
        long jNanoTime = System.nanoTime();
        p0 p0Var = new p0(j11 + jNanoTime, t1Var);
        y(jNanoTime, p0Var);
        return p0Var;
    }

    @Override // r7.s0
    public final void r(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.r(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zW;
        r1.f12434a.set(this);
        try {
            synchronized (this) {
                int i10 = debugStatus;
                if (i10 == 2 || i10 == 3) {
                    if (zW) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jP = p();
                    if (jP == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j10 == Long.MAX_VALUE) {
                            j10 = f12457i + jNanoTime;
                        }
                        long j11 = j10 - jNanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            z();
                            if (w()) {
                                return;
                            }
                            v();
                            return;
                        }
                        if (jP > j11) {
                            jP = j11;
                        }
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (jP > 0) {
                        int i11 = debugStatus;
                        if (i11 == 2 || i11 == 3) {
                            _thread = null;
                            z();
                            if (w()) {
                                return;
                            }
                            v();
                            return;
                        }
                        LockSupport.parkNanos(this, jP);
                    }
                }
            }
        } finally {
            _thread = null;
            z();
            if (!w()) {
                v();
            }
        }
    }

    @Override // r7.s0, r7.n0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // r7.s
    public final String toString() {
        return "DefaultExecutor";
    }

    @Override // r7.s0
    public final Thread v() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(h.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // r7.s0
    public final void x(long j10, q0 q0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void z() {
        int i10 = debugStatus;
        if (i10 == 2 || i10 == 3) {
            debugStatus = 3;
            s0.e.set(this, null);
            s0.f.set(this, null);
            notifyAll();
        }
    }
}
