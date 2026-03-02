package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.ListenableFutureKt;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.UUID;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class WorkProgressUpdater implements ProgressUpdater {
    static final String TAG = Logger.tagWithPrefix("WorkProgressUpdater");
    final TaskExecutor mTaskExecutor;
    final WorkDatabase mWorkDatabase;

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = taskExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$updateProgress$0(UUID uuid, Data data) {
        String string = uuid.toString();
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Updating progress for " + uuid + " (" + data + ")");
        this.mWorkDatabase.beginTransaction();
        try {
            WorkSpec workSpec = this.mWorkDatabase.workSpecDao().getWorkSpec(string);
            if (workSpec == null) {
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            }
            if (workSpec.state == WorkInfo.State.RUNNING) {
                this.mWorkDatabase.workProgressDao().insert(new WorkProgress(string, data));
            } else {
                Logger.get().warning(str, "Ignoring setProgressAsync(...). WorkSpec (" + string + ") is not in a RUNNING state.");
            }
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            return null;
        } catch (Throwable th) {
            try {
                Logger.get().error(TAG, "Error updating Worker progress", th);
                throw th;
            } catch (Throwable th2) {
                this.mWorkDatabase.endTransaction();
                throw th2;
            }
        }
    }

    @Override // androidx.work.ProgressUpdater
    public k1.b updateProgress(Context context, UUID uuid, Data data) {
        return ListenableFutureKt.executeAsync(this.mTaskExecutor.getSerialTaskExecutor(), "updateProgress", new androidx.room.b(this, uuid, data, 2));
    }
}
