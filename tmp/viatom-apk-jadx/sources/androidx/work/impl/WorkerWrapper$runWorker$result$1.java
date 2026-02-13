package androidx.work.impl;

import android.content.Context;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WorkForegroundKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.android.material.card.MaterialCardViewHelper;
import g7.p;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@y6.e(c = "androidx.work.impl.WorkerWrapper$runWorker$result$1", f = "WorkerWrapper.kt", l = {MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION, 311}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WorkerWrapper$runWorker$result$1 extends y6.i implements p {
    final /* synthetic */ ForegroundUpdater $foregroundUpdater;
    final /* synthetic */ ListenableWorker $worker;
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$result$1(WorkerWrapper workerWrapper, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, w6.c cVar) {
        super(2, cVar);
        this.this$0 = workerWrapper;
        this.$worker = listenableWorker;
        this.$foregroundUpdater = foregroundUpdater;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new WorkerWrapper$runWorker$result$1(this.this$0, this.$worker, this.$foregroundUpdater, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, w6.c cVar) {
        return ((WorkerWrapper$runWorker$result$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        WorkerWrapper$runWorker$result$1 workerWrapper$runWorker$result$1;
        int i10 = this.label;
        x6.a aVar = x6.a.f13718a;
        if (i10 == 0) {
            s6.a.e(obj);
            Context context = this.this$0.appContext;
            WorkSpec workSpec = this.this$0.getWorkSpec();
            ListenableWorker listenableWorker = this.$worker;
            ForegroundUpdater foregroundUpdater = this.$foregroundUpdater;
            TaskExecutor taskExecutor = this.this$0.workTaskExecutor;
            this.label = 1;
            workerWrapper$runWorker$result$1 = this;
            if (WorkForegroundKt.workForeground(context, workSpec, listenableWorker, foregroundUpdater, taskExecutor, workerWrapper$runWorker$result$1) != aVar) {
            }
        }
        if (i10 != 1) {
            if (i10 == 2) {
                s6.a.e(obj);
                return obj;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        workerWrapper$runWorker$result$1 = this;
        String str = WorkerWrapperKt.TAG;
        WorkerWrapper workerWrapper = workerWrapper$runWorker$result$1.this$0;
        Logger.get().debug(str, "Starting work for " + workerWrapper.getWorkSpec().workerClassName);
        k1.b bVarStartWork = workerWrapper$runWorker$result$1.$worker.startWork();
        bVarStartWork.getClass();
        ListenableWorker listenableWorker2 = workerWrapper$runWorker$result$1.$worker;
        workerWrapper$runWorker$result$1.label = 2;
        Object objAwaitWithin = WorkerWrapperKt.awaitWithin(bVarStartWork, listenableWorker2, this);
        return objAwaitWithin == aVar ? aVar : objAwaitWithin;
    }
}
