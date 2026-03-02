package androidx.concurrent.futures;

import g7.l;
import k1.b;
import kotlin.jvm.internal.m;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1 extends m implements l {
    final /* synthetic */ b $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(b bVar) {
        super(1);
        this.$this_await$inlined = bVar;
    }

    @Override // g7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return w.f12711a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel(false);
    }
}
