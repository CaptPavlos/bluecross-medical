package androidx.room;

import g7.p;
import r7.w;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.TriggerBasedInvalidationTracker$refreshInvalidationAsync$3", f = "InvalidationTracker.kt", l = {389}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$refreshInvalidationAsync$3 extends i implements p {
    final /* synthetic */ g7.a $onRefreshCompleted;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, g7.a aVar, w6.c cVar) {
        super(2, cVar);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$onRefreshCompleted = aVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this.this$0, this.$onRefreshCompleted, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((TriggerBasedInvalidationTracker$refreshInvalidationAsync$3) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        try {
            if (i10 == 0) {
                s6.a.e(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
                this.label = 1;
                obj = triggerBasedInvalidationTracker.notifyInvalidation(this);
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
            this.$onRefreshCompleted.invoke();
            return s6.w.f12711a;
        } catch (Throwable th) {
            this.$onRefreshCompleted.invoke();
            throw th;
        }
    }
}
