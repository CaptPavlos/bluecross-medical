package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.h;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import s6.w;
import t6.m;
import t6.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CancelWorkRunnable {
    private static final void cancel(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        iterativelyCancelWorkAndDependents(workDatabase, str);
        Processor processor = workManagerImpl.getProcessor();
        processor.getClass();
        processor.stopAndCancelWork(str, 1);
        Iterator<Scheduler> it = workManagerImpl.getSchedulers().iterator();
        while (it.hasNext()) {
            it.next().cancel(str);
        }
    }

    public static final Operation forAll(WorkManagerImpl workManagerImpl) {
        workManagerImpl.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, "CancelAllWork", serialTaskExecutor, new h(workManagerImpl, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w forAll$lambda$7(WorkManagerImpl workManagerImpl) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        workDatabase.runInTransaction(new androidx.browser.trusted.c(9, workDatabase, workManagerImpl));
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forAll$lambda$7$lambda$6(WorkDatabase workDatabase, WorkManagerImpl workManagerImpl) {
        Iterator<String> it = workDatabase.workSpecDao().getAllUnfinishedWork().iterator();
        while (it.hasNext()) {
            cancel(workManagerImpl, it.next());
        }
        new PreferenceUtils(workDatabase).setLastCancelAllTimeMillis(workManagerImpl.getConfiguration().getClock().currentTimeMillis());
    }

    public static final Operation forId(UUID uuid, WorkManagerImpl workManagerImpl) {
        uuid.getClass();
        workManagerImpl.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, "CancelWorkById", serialTaskExecutor, new c(0, workManagerImpl, uuid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w forId$lambda$1(WorkManagerImpl workManagerImpl, UUID uuid) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        workDatabase.runInTransaction(new androidx.browser.trusted.c(8, workManagerImpl, uuid));
        reschedulePendingWorkers(workManagerImpl);
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forId$lambda$1$lambda$0(WorkManagerImpl workManagerImpl, UUID uuid) {
        String string = uuid.toString();
        string.getClass();
        cancel(workManagerImpl, string);
    }

    public static final Operation forName(String str, WorkManagerImpl workManagerImpl) {
        str.getClass();
        workManagerImpl.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String strConcat = "CancelWorkByName_".concat(str);
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, strConcat, serialTaskExecutor, new b(str, workManagerImpl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w forName$lambda$4(String str, WorkManagerImpl workManagerImpl) {
        forNameInline(str, workManagerImpl);
        reschedulePendingWorkers(workManagerImpl);
        return w.f12711a;
    }

    public static final void forNameInline(String str, WorkManagerImpl workManagerImpl) {
        str.getClass();
        workManagerImpl.getClass();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        workDatabase.runInTransaction(new a(workDatabase, str, workManagerImpl, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forNameInline$lambda$5(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithName(str).iterator();
        while (it.hasNext()) {
            cancel(workManagerImpl, it.next());
        }
    }

    public static final Operation forTag(String str, WorkManagerImpl workManagerImpl) {
        str.getClass();
        workManagerImpl.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String strConcat = "CancelWorkByTag_".concat(str);
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, strConcat, serialTaskExecutor, new b(workManagerImpl, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w forTag$lambda$3(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        workDatabase.runInTransaction(new a(workDatabase, str, workManagerImpl, 1));
        reschedulePendingWorkers(workManagerImpl);
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forTag$lambda$3$lambda$2(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithTag(str).iterator();
        while (it.hasNext()) {
            cancel(workManagerImpl, it.next());
        }
    }

    private static final void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        ArrayList arrayListR = m.R(str);
        while (!arrayListR.isEmpty()) {
            String str2 = (String) r.Z(arrayListR);
            WorkInfo.State state = workSpecDao.getState(str2);
            if (state != WorkInfo.State.SUCCEEDED && state != WorkInfo.State.FAILED) {
                workSpecDao.setCancelledState(str2);
            }
            arrayListR.addAll(dependencyDao.getDependentWorkIds(str2));
        }
    }

    private static final void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
