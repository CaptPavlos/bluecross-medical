package androidx.datastore.core;

import g7.p;
import r7.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1", f = "MultiProcessCoordinator.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1 extends i implements p {
    int label;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(MultiProcessCoordinator multiProcessCoordinator, c cVar) {
        super(2, cVar);
        this.this$0 = multiProcessCoordinator;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this.this$0, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label == 0) {
            s6.a.e(obj);
            return new Integer(this.this$0.getSharedCounter().getValue());
        }
        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
