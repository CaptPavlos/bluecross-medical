package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableFutureKt;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import com.google.android.gms.internal.measurement.a4;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkerUpdater {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Operation enqueueUniquelyNamedPeriodic(WorkManagerImpl workManagerImpl, String str, WorkRequest workRequest) {
        workManagerImpl.getClass();
        str.getClass();
        workRequest.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String strConcat = "enqueueUniquePeriodic_".concat(str);
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, strConcat, serialTaskExecutor, new androidx.room.b(workManagerImpl, str, workRequest));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w enqueueUniquelyNamedPeriodic$lambda$6(WorkManagerImpl workManagerImpl, String str, WorkRequest workRequest) {
        WorkSpecDao workSpecDao = workManagerImpl.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workSpecDao.getWorkSpecIdAndStatesForName(str);
        if (workSpecIdAndStatesForName.size() > 1) {
            a2.a.m("Can't apply UPDATE policy to the chains of work.");
            return null;
        }
        WorkSpec.IdAndState idAndState = workSpecIdAndStatesForName.isEmpty() ? null : workSpecIdAndStatesForName.get(0);
        w wVar = w.f12711a;
        if (idAndState == null) {
            enqueueUniquelyNamedPeriodic$lambda$6$lambda$5(workRequest, workManagerImpl, str);
            return wVar;
        }
        WorkSpec workSpec = workSpecDao.getWorkSpec(idAndState.id);
        if (workSpec == null) {
            androidx.window.layout.c.i("WorkSpec with ", idAndState.id, ", that matches a name \"", str, "\", wasn't found");
            return null;
        }
        if (!workSpec.isPeriodic()) {
            a2.a.m("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            return null;
        }
        if (idAndState.state == WorkInfo.State.CANCELLED) {
            workSpecDao.delete(idAndState.id);
            enqueueUniquelyNamedPeriodic$lambda$6$lambda$5(workRequest, workManagerImpl, str);
            return wVar;
        }
        WorkSpec workSpecCopy$default = WorkSpec.copy$default(workRequest.getWorkSpec(), idAndState.id, null, null, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554430, null);
        Processor processor = workManagerImpl.getProcessor();
        processor.getClass();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        Configuration configuration = workManagerImpl.getConfiguration();
        configuration.getClass();
        List<Scheduler> schedulers = workManagerImpl.getSchedulers();
        schedulers.getClass();
        updateWorkImpl(processor, workDatabase, configuration, schedulers, workSpecCopy$default, workRequest.getTags());
        return wVar;
    }

    private static final w enqueueUniquelyNamedPeriodic$lambda$6$lambda$5(WorkRequest workRequest, WorkManagerImpl workManagerImpl, String str) {
        EnqueueRunnable.enqueue(new WorkContinuationImpl(workManagerImpl, str, ExistingWorkPolicy.KEEP, a4.u(workRequest)));
        return w.f12711a;
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor processor, final WorkDatabase workDatabase, Configuration configuration, final List<? extends Scheduler> list, final WorkSpec workSpec, final Set<String> set) {
        final String str = workSpec.id;
        final WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            com.google.gson.internal.a.n(androidx.constraintlayout.core.widgets.analyzer.a.x("Worker with ", str, " doesn't exist"));
            return null;
        }
        if (workSpec2.state.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        }
        if (workSpec2.isPeriodic() ^ workSpec.isPeriodic()) {
            StringBuilder sb = new StringBuilder("Can't update ");
            sb.append(updateWorkImpl$lambda$0(workSpec2));
            sb.append(" Worker to ");
            a2.a.m(a3.a.o(sb, updateWorkImpl$lambda$0(workSpec), " Worker. Update operation must preserve worker's type."));
            return null;
        }
        final boolean zIsEnqueued = processor.isEnqueued(str);
        if (!zIsEnqueued) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Scheduler) it.next()).cancel(str);
            }
        }
        workDatabase.runInTransaction(new Runnable() { // from class: androidx.work.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.updateWorkImpl$lambda$3(workDatabase, workSpec2, workSpec, list, str, set, zIsEnqueued);
            }
        });
        if (!zIsEnqueued) {
            Schedulers.schedule(configuration, workDatabase, list);
        }
        return zIsEnqueued ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    }

    private static final String updateWorkImpl$lambda$0(WorkSpec workSpec) {
        workSpec.getClass();
        return workSpec.isPeriodic() ? "Periodic" : "OneTime";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$3(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z9) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        WorkSpec workSpecCopy$default = WorkSpec.copy$default(workSpec2, null, workSpec.state, null, null, null, null, 0L, 0L, 0L, null, workSpec.runAttemptCount, null, 0L, workSpec.lastEnqueueTime, 0L, 0L, false, null, workSpec.getPeriodCount(), workSpec.getGeneration() + 1, workSpec.getNextScheduleTimeOverride(), workSpec.getNextScheduleTimeOverrideGeneration(), 0, null, null, 29613053, null);
        if (workSpec2.getNextScheduleTimeOverrideGeneration() == 1) {
            workSpecCopy$default.setNextScheduleTimeOverride(workSpec2.getNextScheduleTimeOverride());
            workSpecCopy$default.setNextScheduleTimeOverrideGeneration(workSpecCopy$default.getNextScheduleTimeOverrideGeneration() + 1);
        }
        workSpecDao.updateWorkSpec(EnqueueUtilsKt.wrapWorkSpecIfNeeded(list, workSpecCopy$default));
        workTagDao.deleteByWorkSpecId(str);
        workTagDao.insertTags(str, set);
        if (z9) {
            return;
        }
        workSpecDao.markWorkSpecScheduled(str, -1L);
        workDatabase.workProgressDao().delete(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkManager.UpdateResult updateWorkImpl$lambda$4(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        Processor processor = workManagerImpl.getProcessor();
        processor.getClass();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        Configuration configuration = workManagerImpl.getConfiguration();
        configuration.getClass();
        List<Scheduler> schedulers = workManagerImpl.getSchedulers();
        schedulers.getClass();
        return updateWorkImpl(processor, workDatabase, configuration, schedulers, workRequest.getWorkSpec(), workRequest.getTags());
    }

    public static final k1.b updateWorkImpl(final WorkManagerImpl workManagerImpl, final WorkRequest workRequest) {
        workManagerImpl.getClass();
        workRequest.getClass();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "updateWorkImpl", new g7.a() { // from class: androidx.work.impl.k
            @Override // g7.a
            public final Object invoke() {
                return WorkerUpdater.updateWorkImpl$lambda$4(workManagerImpl, workRequest);
            }
        });
    }
}
