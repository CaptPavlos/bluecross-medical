package h1;

import com.google.android.gms.internal.measurement.j4;
import i0.y;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8435a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final j4 f8436b = new j4(2);

    /* renamed from: c, reason: collision with root package name */
    public boolean f8437c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f8438d;
    public Object e;
    public Exception f;

    public final void a(Executor executor, d dVar) {
        this.f8436b.o(new m(executor, dVar));
        p();
    }

    public final void b(Executor executor, e eVar) {
        this.f8436b.o(new m(executor, eVar));
        p();
    }

    public final void c(Executor executor, f fVar) {
        this.f8436b.o(new m(executor, fVar));
        p();
    }

    public final p d(Executor executor, a aVar) {
        p pVar = new p();
        this.f8436b.o(new l(executor, aVar, pVar, 0));
        p();
        return pVar;
    }

    public final p e(Executor executor, a aVar) {
        p pVar = new p();
        this.f8436b.o(new l(executor, aVar, pVar, 1));
        p();
        return pVar;
    }

    public final Exception f() {
        Exception exc;
        synchronized (this.f8435a) {
            exc = this.f;
        }
        return exc;
    }

    public final Object g() {
        Object obj;
        synchronized (this.f8435a) {
            try {
                y.i(this.f8437c, "Task is not yet complete");
                if (this.f8438d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new g(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean h() {
        boolean z9;
        synchronized (this.f8435a) {
            z9 = this.f8437c;
        }
        return z9;
    }

    public final boolean i() {
        boolean z9;
        synchronized (this.f8435a) {
            try {
                z9 = false;
                if (this.f8437c && !this.f8438d && this.f == null) {
                    z9 = true;
                }
            } finally {
            }
        }
        return z9;
    }

    public final p j(Executor executor, h hVar) {
        p pVar = new p();
        this.f8436b.o(new m(executor, hVar, pVar));
        p();
        return pVar;
    }

    public final void k(Exception exc) {
        y.h(exc, "Exception must not be null");
        synchronized (this.f8435a) {
            o();
            this.f8437c = true;
            this.f = exc;
        }
        this.f8436b.q(this);
    }

    public final void l(Object obj) {
        synchronized (this.f8435a) {
            o();
            this.f8437c = true;
            this.e = obj;
        }
        this.f8436b.q(this);
    }

    public final void m() {
        synchronized (this.f8435a) {
            try {
                if (this.f8437c) {
                    return;
                }
                this.f8437c = true;
                this.f8438d = true;
                this.f8436b.q(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean n(Object obj) {
        synchronized (this.f8435a) {
            try {
                if (this.f8437c) {
                    return false;
                }
                this.f8437c = true;
                this.e = obj;
                this.f8436b.q(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        if (this.f8437c) {
            if (!h()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excF = f();
        }
    }

    public final void p() {
        synchronized (this.f8435a) {
            try {
                if (this.f8437c) {
                    this.f8436b.q(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
