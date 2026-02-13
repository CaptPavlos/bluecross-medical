package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import g7.p;
import java.util.concurrent.CancellationException;
import r7.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@y6.e(c = "androidx.work.ListenableFutureKt$launchFuture$1$2", f = "ListenableFuture.kt", l = {42}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ListenableFutureKt$launchFuture$1$2 extends i implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$launchFuture$1$2(p pVar, CallbackToFutureAdapter.Completer<T> completer, w6.c cVar) {
        super(2, cVar);
        this.$block = pVar;
        this.$completer = completer;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        ListenableFutureKt$launchFuture$1$2 listenableFutureKt$launchFuture$1$2 = new ListenableFutureKt$launchFuture$1$2(this.$block, this.$completer, cVar);
        listenableFutureKt$launchFuture$1$2.L$0 = obj;
        return listenableFutureKt$launchFuture$1$2;
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((ListenableFutureKt$launchFuture$1$2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        try {
            if (i10 == 0) {
                s6.a.e(obj);
                w wVar = (w) this.L$0;
                p pVar = this.$block;
                this.label = 1;
                obj = pVar.invoke(wVar, this);
                x6.a aVar = x6.a.f13718a;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            this.$completer.set(obj);
        } catch (CancellationException unused) {
            this.$completer.setCancelled();
        } catch (Throwable th) {
            this.$completer.setException(th);
        }
        return s6.w.f12711a;
    }
}
