package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import k1.b;
import r7.b0;
import r7.i1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CoroutineAdapterKt {
    public static final <T> b asListenableFuture(b0 b0Var, Object obj) {
        b0Var.getClass();
        b future = CallbackToFutureAdapter.getFuture(new a(0, b0Var, obj));
        future.getClass();
        return future;
    }

    public static /* synthetic */ b asListenableFuture$default(b0 b0Var, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(b0Var, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object asListenableFuture$lambda$0(b0 b0Var, Object obj, CallbackToFutureAdapter.Completer completer) {
        b0Var.getClass();
        completer.getClass();
        ((i1) b0Var).s(new CoroutineAdapterKt$asListenableFuture$1$1(completer, b0Var));
        return obj;
    }
}
