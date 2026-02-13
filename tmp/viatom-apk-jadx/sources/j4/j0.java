package j4;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9982a = 0;

    public /* synthetic */ j0(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        ReentrantLock reentrantLock;
        switch (this.f9982a) {
            case 0:
                Process.setThreadPriority(10);
                super.run();
                return;
            case 1:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
        }
        while (true) {
            try {
                reentrantLock = z8.d.h;
                reentrantLock.lock();
            } catch (InterruptedException unused2) {
            }
            try {
                z8.d dVarK = l1.b.k();
                if (dVarK == z8.d.f14469l) {
                    z8.d.f14469l = null;
                    reentrantLock.unlock();
                    return;
                } else {
                    reentrantLock.unlock();
                    if (dVarK != null) {
                        dVarK.j();
                    }
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public /* synthetic */ j0(String str) {
        super(str);
    }

    public /* synthetic */ j0(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
