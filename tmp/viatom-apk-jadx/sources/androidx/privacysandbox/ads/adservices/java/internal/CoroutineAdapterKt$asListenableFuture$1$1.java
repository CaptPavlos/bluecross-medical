package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import g7.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import r7.b0;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CoroutineAdapterKt$asListenableFuture$1$1 extends m implements l {
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    final /* synthetic */ b0 $this_asListenableFuture;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineAdapterKt$asListenableFuture$1$1(CallbackToFutureAdapter.Completer<T> completer, b0 b0Var) {
        super(1);
        this.$completer = completer;
        this.$this_asListenableFuture = b0Var;
    }

    public final void invoke(Throwable th) {
        CallbackToFutureAdapter.Completer<T> completer = this.$completer;
        if (th == null) {
            completer.set(this.$this_asListenableFuture.b());
        } else if (th instanceof CancellationException) {
            completer.setCancelled();
        } else {
            completer.setException(th);
        }
    }

    @Override // g7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return w.f12711a;
    }
}
