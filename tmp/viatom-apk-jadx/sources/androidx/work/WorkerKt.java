package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> k1.b future(Executor executor, g7.a aVar) {
        k1.b future = CallbackToFutureAdapter.getFuture(new androidx.privacysandbox.ads.adservices.java.internal.a(1, executor, aVar));
        future.getClass();
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w future$lambda$2(Executor executor, g7.a aVar, CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new a(atomicBoolean, 1), DirectExecutor.INSTANCE);
        executor.execute(new b(atomicBoolean, completer, aVar, 1));
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void future$lambda$2$lambda$1(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, g7.a aVar) {
        if (atomicBoolean.get()) {
            return;
        }
        try {
            completer.set(aVar.invoke());
        } catch (Throwable th) {
            completer.setException(th);
        }
    }
}
