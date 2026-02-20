package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.DirectExecutor;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkerWrapperKt {
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkerWrapper");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> Object awaitWithin(final k1.b bVar, final ListenableWorker listenableWorker, w6.c cVar) throws Throwable {
        try {
            if (bVar.isDone()) {
                return getUninterruptibly(bVar);
            }
            r7.g gVar = new r7.g(1, r0.f.F(cVar));
            gVar.s();
            bVar.addListener(new ToContinuation(bVar, gVar), DirectExecutor.INSTANCE);
            gVar.u(new g7.l() { // from class: androidx.work.impl.WorkerWrapperKt$awaitWithin$2$1
                public final void invoke(Throwable th) {
                    if (th instanceof WorkerStoppedException) {
                        listenableWorker.stop(((WorkerStoppedException) th).getReason());
                    }
                    bVar.cancel(false);
                }

                @Override // g7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return w.f12711a;
                }
            });
            return gVar.q();
        } catch (ExecutionException e) {
            throw nonNullCause(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <V> V getUninterruptibly(Future<V> future) {
        V v6;
        boolean z9 = false;
        while (true) {
            try {
                v6 = future.get();
                break;
            } catch (InterruptedException unused) {
                z9 = true;
            } catch (Throwable th) {
                if (z9) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z9) {
            Thread.currentThread().interrupt();
        }
        return v6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        cause.getClass();
        return cause;
    }
}
