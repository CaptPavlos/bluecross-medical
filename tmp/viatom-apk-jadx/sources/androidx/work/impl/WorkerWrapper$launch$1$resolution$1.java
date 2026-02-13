package androidx.work.impl;

import g7.p;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@y6.e(c = "androidx.work.impl.WorkerWrapper$launch$1$resolution$1", f = "WorkerWrapper.kt", l = {98}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WorkerWrapper$launch$1$resolution$1 extends y6.i implements p {
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$launch$1$resolution$1(WorkerWrapper workerWrapper, w6.c cVar) {
        super(2, cVar);
        this.this$0 = workerWrapper;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new WorkerWrapper$launch$1$resolution$1(this.this$0, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((WorkerWrapper$launch$1$resolution$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                s6.a.e(obj);
                return obj;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        WorkerWrapper workerWrapper = this.this$0;
        this.label = 1;
        Object objRunWorker = workerWrapper.runWorker(this);
        x6.a aVar = x6.a.f13718a;
        return objRunWorker == aVar ? aVar : objRunWorker;
    }
}
