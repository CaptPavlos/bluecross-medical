package c1;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r1 extends f2 {

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicLong f1424k = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c, reason: collision with root package name */
    public q1 f1425c;

    /* renamed from: d, reason: collision with root package name */
    public q1 f1426d;
    public final PriorityBlockingQueue e;
    public final LinkedBlockingQueue f;
    public final o1 g;
    public final o1 h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f1427i;

    /* renamed from: j, reason: collision with root package name */
    public final Semaphore f1428j;

    public r1(u1 u1Var) {
        super(u1Var);
        this.f1427i = new Object();
        this.f1428j = new Semaphore(2);
        this.e = new PriorityBlockingQueue();
        this.f = new LinkedBlockingQueue();
        this.g = new o1(this, "Thread death: Uncaught exception on worker thread");
        this.h = new o1(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // c1.e2
    public final void g() {
        if (Thread.currentThread() == this.f1425c) {
            return;
        }
        androidx.window.layout.c.g("Call expected from worker thread");
    }

    @Override // c1.f2
    public final boolean h() {
        return false;
    }

    public final void k() {
        if (Thread.currentThread() == this.f1426d) {
            return;
        }
        androidx.window.layout.c.g("Call expected from network thread");
    }

    public final void l() {
        if (Thread.currentThread() != this.f1425c) {
            return;
        }
        androidx.window.layout.c.g("Call not expected from worker thread");
    }

    public final boolean m() {
        return Thread.currentThread() == this.f1425c;
    }

    public final p1 n(Callable callable) {
        i();
        p1 p1Var = new p1(this, callable, false);
        if (Thread.currentThread() != this.f1425c) {
            t(p1Var);
            return p1Var;
        }
        if (!this.e.isEmpty()) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.b("Callable skipped the worker queue.");
        }
        p1Var.run();
        return p1Var;
    }

    public final p1 o(Callable callable) {
        i();
        p1 p1Var = new p1(this, callable, true);
        if (Thread.currentThread() == this.f1425c) {
            p1Var.run();
            return p1Var;
        }
        t(p1Var);
        return p1Var;
    }

    public final void p(Runnable runnable) {
        i();
        i0.y.g(runnable);
        t(new p1(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object q(AtomicReference atomicReference, long j10, String str, Runnable runnable) {
        synchronized (atomicReference) {
            r1 r1Var = this.f1149a.g;
            u1.m(r1Var);
            r1Var.p(runnable);
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                w0 w0Var = this.f1149a.f;
                u1.m(w0Var);
                u0 u0Var = w0Var.f1540i;
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                u0Var.b(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            w0 w0Var2 = this.f1149a.f;
            u1.m(w0Var2);
            w0Var2.f1540i.b("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void r(Runnable runnable) {
        i();
        t(new p1(this, runnable, true, "Task exception on worker thread"));
    }

    public final void s(Runnable runnable) {
        i();
        p1 p1Var = new p1(this, runnable, false, "Task exception on network thread");
        synchronized (this.f1427i) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = this.f;
                linkedBlockingQueue.add(p1Var);
                q1 q1Var = this.f1426d;
                if (q1Var == null) {
                    q1 q1Var2 = new q1(this, "Measurement Network", linkedBlockingQueue);
                    this.f1426d = q1Var2;
                    q1Var2.setUncaughtExceptionHandler(this.h);
                    this.f1426d.start();
                } else {
                    q1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(p1 p1Var) {
        synchronized (this.f1427i) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.e;
                priorityBlockingQueue.add(p1Var);
                q1 q1Var = this.f1425c;
                if (q1Var == null) {
                    q1 q1Var2 = new q1(this, "Measurement Worker", priorityBlockingQueue);
                    this.f1425c = q1Var2;
                    q1Var2.setUncaughtExceptionHandler(this.g);
                    this.f1425c.start();
                } else {
                    q1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
