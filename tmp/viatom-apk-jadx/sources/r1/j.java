package r1;

import i0.y;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements Executor {
    public static final Logger f = Logger.getLogger(j.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Executor f12336a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f12337b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public int f12338c = 1;

    /* renamed from: d, reason: collision with root package name */
    public long f12339d = 0;
    public final k1.a e = new k1.a(this);

    public j(Executor executor) {
        y.g(executor);
        this.f12336a = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        y.g(runnable);
        synchronized (this.f12337b) {
            int i10 = this.f12338c;
            if (i10 != 4 && i10 != 3) {
                long j10 = this.f12339d;
                o0.b bVar = new o0.b(2, runnable);
                this.f12337b.add(bVar);
                this.f12338c = 2;
                try {
                    this.f12336a.execute(this.e);
                    if (this.f12338c != 2) {
                        return;
                    }
                    synchronized (this.f12337b) {
                        try {
                            if (this.f12339d == j10 && this.f12338c == 2) {
                                this.f12338c = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.f12337b) {
                        try {
                            int i11 = this.f12338c;
                            boolean z9 = true;
                            if ((i11 != 1 && i11 != 2) || !this.f12337b.removeLastOccurrence(bVar)) {
                                z9 = false;
                            }
                            if (!(e instanceof RejectedExecutionException) || z9) {
                                throw e;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.f12337b.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f12336a + "}";
    }
}
