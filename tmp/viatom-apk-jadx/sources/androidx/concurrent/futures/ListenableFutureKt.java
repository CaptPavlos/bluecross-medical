package androidx.concurrent.futures;

import java.util.concurrent.ExecutionException;
import k1.b;
import kotlin.jvm.internal.l;
import r0.f;
import r7.g;
import s6.d;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ListenableFutureKt {
    public static final <T> Object await(b bVar, c cVar) {
        try {
            if (bVar.isDone()) {
                return AbstractResolvableFuture.getUninterruptibly(bVar);
            }
            g gVar = new g(1, f.F(cVar));
            bVar.addListener(new ToContinuation(bVar, gVar), DirectExecutor.INSTANCE);
            gVar.u(new ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(bVar));
            return gVar.q();
        } catch (ExecutionException e) {
            throw nonNullCause(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        if (cause != null) {
            return cause;
        }
        d dVar = new d();
        l.e(dVar, l.class.getName());
        throw dVar;
    }
}
