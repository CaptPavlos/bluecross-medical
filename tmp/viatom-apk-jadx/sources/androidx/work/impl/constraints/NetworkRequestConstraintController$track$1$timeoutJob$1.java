package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import g7.p;
import r7.w;
import r7.y;
import t7.r;
import t7.s;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$timeoutJob$1", f = "WorkConstraintsTracker.kt", l = {151}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NetworkRequestConstraintController$track$1$timeoutJob$1 extends i implements p {
    final /* synthetic */ s $$this$callbackFlow;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1$timeoutJob$1(NetworkRequestConstraintController networkRequestConstraintController, s sVar, w6.c cVar) {
        super(2, cVar);
        this.this$0 = networkRequestConstraintController;
        this.$$this$callbackFlow = sVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new NetworkRequestConstraintController$track$1$timeoutJob$1(this.this$0, this.$$this$callbackFlow, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((NetworkRequestConstraintController$track$1$timeoutJob$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            s6.a.e(obj);
            long j10 = this.this$0.timeoutMs;
            this.label = 1;
            Object objH = y.h(j10, this);
            x6.a aVar = x6.a.f13718a;
            if (objH == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController didn't receive neither onCapabilitiesChanged/onLost callback, sending `ConstraintsNotMet` after " + this.this$0.timeoutMs + " ms");
        ((r) this.$$this$callbackFlow).q(new ConstraintsState.ConstraintsNotMet(7));
        return s6.w.f12711a;
    }
}
