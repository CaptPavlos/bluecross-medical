package androidx.concurrent.futures;

import java.util.concurrent.ExecutionException;
import k1.b;
import r7.f;
import s6.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ToContinuation<T> implements Runnable {
    private final f continuation;
    private final b futureToObserve;

    public ToContinuation(b bVar, f fVar) {
        bVar.getClass();
        fVar.getClass();
        this.futureToObserve = bVar;
        this.continuation = fVar;
    }

    public final f getContinuation() {
        return this.continuation;
    }

    public final b getFutureToObserve() {
        return this.futureToObserve;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zIsCancelled = this.futureToObserve.isCancelled();
        f fVar = this.continuation;
        if (zIsCancelled) {
            fVar.n(null);
            return;
        }
        try {
            fVar.resumeWith(AbstractResolvableFuture.getUninterruptibly(this.futureToObserve));
        } catch (ExecutionException e) {
            this.continuation.resumeWith(a.b(ListenableFutureKt.nonNullCause(e)));
        }
    }
}
