package c1;

import android.os.Process;
import androidx.work.WorkRequest;
import java.util.concurrent.BlockingQueue;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q1 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1411a;

    /* renamed from: b, reason: collision with root package name */
    public final BlockingQueue f1412b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1413c = false;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r1 f1414d;

    public q1(r1 r1Var, String str, BlockingQueue blockingQueue) {
        this.f1414d = r1Var;
        i0.y.g(blockingQueue);
        this.f1411a = new Object();
        this.f1412b = blockingQueue;
        setName(str);
    }

    public final void a() {
        Object obj = this.f1411a;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public final void b() {
        r1 r1Var = this.f1414d;
        synchronized (r1Var.f1427i) {
            try {
                if (!this.f1413c) {
                    r1Var.f1428j.release();
                    r1Var.f1427i.notifyAll();
                    if (this == r1Var.f1425c) {
                        r1Var.f1425c = null;
                    } else if (this == r1Var.f1426d) {
                        r1Var.f1426d = null;
                    } else {
                        w0 w0Var = r1Var.f1149a.f;
                        u1.m(w0Var);
                        w0Var.f.b("Current scheduler thread is neither worker nor network");
                    }
                    this.f1413c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        boolean z9 = false;
        while (!z9) {
            try {
                this.f1414d.f1428j.acquire();
                z9 = true;
            } catch (InterruptedException e) {
                w0 w0Var = this.f1414d.f1149a.f;
                u1.m(w0Var);
                w0Var.f1540i.c(e, String.valueOf(getName()).concat(" was interrupted"));
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.f1412b;
                p1 p1Var = (p1) blockingQueue.poll();
                if (p1Var != null) {
                    Process.setThreadPriority(true != p1Var.f1400b ? 10 : threadPriority);
                    p1Var.run();
                } else {
                    Object obj = this.f1411a;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.f1414d.getClass();
                            try {
                                obj.wait(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                            } catch (InterruptedException e3) {
                                w0 w0Var2 = this.f1414d.f1149a.f;
                                u1.m(w0Var2);
                                w0Var2.f1540i.c(e3, String.valueOf(getName()).concat(" was interrupted"));
                            }
                        }
                    }
                    synchronized (this.f1414d.f1427i) {
                        if (this.f1412b.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
