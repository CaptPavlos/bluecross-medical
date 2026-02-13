package androidx.work.impl.utils;

import a3.i0;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PruneWorkRunnableKt {
    public static final Operation pruneWork(WorkDatabase workDatabase, Configuration configuration, TaskExecutor taskExecutor) {
        workDatabase.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        Tracer tracer = configuration.getTracer();
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, "PruneWork", serialTaskExecutor, new i0(workDatabase, 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w pruneWork$lambda$0(WorkDatabase workDatabase) {
        workDatabase.workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
        return w.f12711a;
    }
}
