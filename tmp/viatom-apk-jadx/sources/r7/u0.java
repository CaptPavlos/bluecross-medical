package r7;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 extends t0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f12438a;

    public u0(Executor executor) {
        this.f12438a = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f12438a;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // r7.s
    public final void dispatch(w6.h hVar, Runnable runnable) {
        try {
            this.f12438a.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            a1 a1Var = (a1) hVar.get(t.f12437b);
            if (a1Var != null) {
                a1Var.a(cancellationException);
            }
            y7.e eVar = i0.f12407a;
            y7.d.f14116a.dispatch(hVar, runnable);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u0) && ((u0) obj).f12438a == this.f12438a;
    }

    @Override // r7.d0
    public final void f(long j10, g gVar) {
        Executor executor = this.f12438a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            r5.a aVar = new r5.a(this, gVar, 1, false);
            w6.h hVar = gVar.e;
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(aVar, j10, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                a1 a1Var = (a1) hVar.get(t.f12437b);
                if (a1Var != null) {
                    a1Var.a(cancellationException);
                }
            }
        }
        if (scheduledFutureSchedule != null) {
            gVar.v(new e(scheduledFutureSchedule, 0));
        } else {
            z.h.f(j10, gVar);
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f12438a);
    }

    @Override // r7.d0
    public final k0 k(long j10, t1 t1Var, w6.h hVar) {
        Executor executor = this.f12438a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(t1Var, j10, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                a1 a1Var = (a1) hVar.get(t.f12437b);
                if (a1Var != null) {
                    a1Var.a(cancellationException);
                }
            }
        }
        return scheduledFutureSchedule != null ? new j0(scheduledFutureSchedule) : z.h.k(j10, t1Var, hVar);
    }

    @Override // r7.t0
    public final Executor l() {
        return this.f12438a;
    }

    @Override // r7.s
    public final String toString() {
        return this.f12438a.toString();
    }
}
