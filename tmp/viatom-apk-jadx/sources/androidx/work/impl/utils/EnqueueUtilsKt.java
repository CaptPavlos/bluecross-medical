package androidx.work.impl.utils;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.l;
import t6.m;
import t6.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class EnqueueUtilsKt {
    public static final String ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME";
    public static final String ARGUMENT_SERVICE_CLASS_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME";
    public static final String ARGUMENT_SERVICE_PACKAGE_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME";
    public static final String REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker";

    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl workContinuationImpl) {
        int i10;
        workDatabase.getClass();
        configuration.getClass();
        workContinuationImpl.getClass();
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        ArrayList arrayListR = m.R(workContinuationImpl);
        int i11 = 0;
        while (!arrayListR.isEmpty()) {
            WorkContinuationImpl workContinuationImpl2 = (WorkContinuationImpl) r.Z(arrayListR);
            List<? extends WorkRequest> work = workContinuationImpl2.getWork();
            work.getClass();
            List<? extends WorkRequest> list = work;
            if ((list instanceof Collection) && list.isEmpty()) {
                i10 = 0;
            } else {
                Iterator<T> it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    if (((WorkRequest) it.next()).getWorkSpec().constraints.hasContentUriTriggers() && (i10 = i10 + 1) < 0) {
                        m.T();
                        throw null;
                    }
                }
            }
            i11 += i10;
            List<WorkContinuationImpl> parents = workContinuationImpl2.getParents();
            if (parents != null) {
                arrayListR.addAll(parents);
            }
        }
        if (i11 == 0) {
            return;
        }
        int iCountNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
        int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
        if (iCountNonFinishedContentUriTriggerWorkers + i11 <= contentUriTriggerWorkersLimit) {
            return;
        }
        com.google.gson.internal.a.n(a3.a.n(a3.a.q(contentUriTriggerWorkersLimit, iCountNonFinishedContentUriTriggerWorkers, "Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ", ";\nalready enqueued count: ", ";\ncurrent enqueue operation count: "), ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.", i11));
    }

    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec) throws IOException {
        workSpec.getClass();
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (l.a(str, ConstraintTrackingWorker.class.getName()) || !(constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow())) {
            return workSpec;
        }
        return WorkSpec.copy$default(workSpec, null, null, ConstraintTrackingWorker.class.getName(), null, new Data.Builder().putAll(workSpec.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build(), null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554411, null);
    }

    @VisibleForTesting
    public static final WorkSpec tryDelegateRemoteListenableWorker(WorkSpec workSpec) {
        workSpec.getClass();
        boolean zHasKeyWithValueOfType = workSpec.input.hasKeyWithValueOfType(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, String.class);
        boolean zHasKeyWithValueOfType2 = workSpec.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_PACKAGE_NAME, String.class);
        boolean zHasKeyWithValueOfType3 = workSpec.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_CLASS_NAME, String.class);
        if (zHasKeyWithValueOfType || !zHasKeyWithValueOfType2 || !zHasKeyWithValueOfType3) {
            return workSpec;
        }
        return WorkSpec.copy$default(workSpec, null, null, REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME, null, new Data.Builder().putAll(workSpec.input).putString(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, workSpec.workerClassName).build(), null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554411, null);
    }

    public static final WorkSpec wrapWorkSpecIfNeeded(List<? extends Scheduler> list, WorkSpec workSpec) {
        list.getClass();
        workSpec.getClass();
        WorkSpec workSpecTryDelegateRemoteListenableWorker = tryDelegateRemoteListenableWorker(workSpec);
        return Build.VERSION.SDK_INT <= 25 ? tryDelegateConstrainedWorkSpec(workSpecTryDelegateRemoteListenableWorker) : workSpecTryDelegateRemoteListenableWorker;
    }
}
