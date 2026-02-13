package androidx.work;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.work.ListenableWorker;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    @WorkerThread
    public abstract ListenableWorker.Result doWork();

    @WorkerThread
    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for `getForegroundInfo()`");
    }

    @Override // androidx.work.ListenableWorker
    public k1.b getForegroundInfoAsync() {
        Executor backgroundExecutor = getBackgroundExecutor();
        backgroundExecutor.getClass();
        return WorkerKt.future(backgroundExecutor, new e(this, 1));
    }

    @Override // androidx.work.ListenableWorker
    public final k1.b startWork() {
        Executor backgroundExecutor = getBackgroundExecutor();
        backgroundExecutor.getClass();
        return WorkerKt.future(backgroundExecutor, new e(this, 0));
    }
}
