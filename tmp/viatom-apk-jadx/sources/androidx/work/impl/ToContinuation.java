package androidx.work.impl;

import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ToContinuation<T> implements Runnable {
    private final r7.f continuation;
    private final k1.b futureToObserve;

    public ToContinuation(k1.b bVar, r7.f fVar) {
        bVar.getClass();
        fVar.getClass();
        this.futureToObserve = bVar;
        this.continuation = fVar;
    }

    public final r7.f getContinuation() {
        return this.continuation;
    }

    public final k1.b getFutureToObserve() {
        return this.futureToObserve;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zIsCancelled = this.futureToObserve.isCancelled();
        r7.f fVar = this.continuation;
        if (zIsCancelled) {
            fVar.n(null);
            return;
        }
        try {
            fVar.resumeWith(WorkerWrapperKt.getUninterruptibly(this.futureToObserve));
        } catch (ExecutionException e) {
            this.continuation.resumeWith(s6.a.b(WorkerWrapperKt.nonNullCause(e)));
        }
    }
}
