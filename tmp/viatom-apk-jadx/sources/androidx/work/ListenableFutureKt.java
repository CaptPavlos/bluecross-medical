package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import g7.p;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import r7.a1;
import r7.t;
import r7.x;
import r7.y;
import w6.h;
import w6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ListenableFutureKt {
    public static final <V> k1.b executeAsync(Executor executor, String str, g7.a aVar) {
        executor.getClass();
        str.getClass();
        aVar.getClass();
        k1.b future = CallbackToFutureAdapter.getFuture(new androidx.transition.a(executor, str, aVar, 1));
        future.getClass();
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object executeAsync$lambda$4(Executor executor, String str, g7.a aVar, CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new a(atomicBoolean, 0), DirectExecutor.INSTANCE);
        executor.execute(new b(atomicBoolean, completer, aVar, 0));
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAsync$lambda$4$lambda$3(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, g7.a aVar) {
        if (atomicBoolean.get()) {
            return;
        }
        try {
            completer.set(aVar.invoke());
        } catch (Throwable th) {
            completer.setException(th);
        }
    }

    public static final <T> k1.b launchFuture(h hVar, x xVar, p pVar) {
        hVar.getClass();
        xVar.getClass();
        pVar.getClass();
        k1.b future = CallbackToFutureAdapter.getFuture(new androidx.transition.a(hVar, xVar, pVar, 2));
        future.getClass();
        return future;
    }

    public static /* synthetic */ k1.b launchFuture$default(h hVar, x xVar, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hVar = i.f13523a;
        }
        if ((i10 & 2) != 0) {
            xVar = x.f12445a;
        }
        return launchFuture(hVar, xVar, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object launchFuture$lambda$1(h hVar, x xVar, p pVar, CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        completer.addCancellationListener(new androidx.constraintlayout.helper.widget.a((a1) hVar.get(t.f12437b), 2), DirectExecutor.INSTANCE);
        return y.q(y.a(hVar), null, xVar, new ListenableFutureKt$launchFuture$1$2(pVar, completer, null), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchFuture$lambda$1$lambda$0(a1 a1Var) {
        if (a1Var != null) {
            a1Var.a(null);
        }
    }
}
