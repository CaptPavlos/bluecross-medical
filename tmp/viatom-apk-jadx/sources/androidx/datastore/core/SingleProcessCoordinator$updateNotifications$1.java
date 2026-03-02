package androidx.datastore.core;

import g7.p;
import s6.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.SingleProcessCoordinator$updateNotifications$1", f = "SingleProcessCoordinator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SingleProcessCoordinator$updateNotifications$1 extends i implements p {
    int label;

    public SingleProcessCoordinator$updateNotifications$1(c cVar) {
        super(2, cVar);
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new SingleProcessCoordinator$updateNotifications$1(cVar);
    }

    @Override // g7.p
    public final Object invoke(u7.i iVar, c cVar) {
        return ((SingleProcessCoordinator$updateNotifications$1) create(iVar, cVar)).invokeSuspend(w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label == 0) {
            s6.a.e(obj);
            return w.f12711a;
        }
        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
