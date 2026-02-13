package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class SystemJobScheduler implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("SystemJobScheduler");
    private final Configuration mConfiguration;
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final SystemJobInfoConverter mSystemJobInfoConverter;
    private final WorkDatabase mWorkDatabase;

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        this(context, workDatabase, configuration, JobSchedulerExtKt.getWmJobScheduler(context), new SystemJobInfoConverter(context, configuration.getClock(), configuration.isMarkingJobsAsImportantWhileForeground()));
    }

    public static void cancelAllInAllNamespaces(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            JobSchedulerExtKt.getWmJobScheduler(context).cancelAll();
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null || pendingJobs.isEmpty()) {
            return;
        }
        Iterator<JobInfo> it = pendingJobs.iterator();
        while (it.hasNext()) {
            cancelJobById(jobScheduler, it.next().getId());
        }
    }

    private static void cancelJobById(JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i10)), th);
        }
    }

    private static List<Integer> getPendingJobIds(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : pendingJobs) {
            WorkGenerationalId workGenerationalIdFromJobInfo = getWorkGenerationalIdFromJobInfo(jobInfo);
            if (workGenerationalIdFromJobInfo != null && str.equals(workGenerationalIdFromJobInfo.getWorkSpecId())) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static List<JobInfo> getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> safePendingJobs = JobSchedulerExtKt.getSafePendingJobs(jobScheduler);
        if (safePendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(safePendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : safePendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static WorkGenerationalId getWorkGenerationalIdFromJobInfo(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean reconcileJobs(Context context, WorkDatabase workDatabase) {
        JobScheduler wmJobScheduler = JobSchedulerExtKt.getWmJobScheduler(context);
        List<JobInfo> pendingJobs = getPendingJobs(context, wmJobScheduler);
        List<String> workSpecIds = workDatabase.systemIdInfoDao().getWorkSpecIds();
        boolean z9 = false;
        HashSet hashSet = new HashSet(pendingJobs != null ? pendingJobs.size() : 0);
        if (pendingJobs != null && !pendingJobs.isEmpty()) {
            for (JobInfo jobInfo : pendingJobs) {
                WorkGenerationalId workGenerationalIdFromJobInfo = getWorkGenerationalIdFromJobInfo(jobInfo);
                if (workGenerationalIdFromJobInfo != null) {
                    hashSet.add(workGenerationalIdFromJobInfo.getWorkSpecId());
                } else {
                    cancelJobById(wmJobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator<String> it = workSpecIds.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (!hashSet.contains(it.next())) {
                Logger.get().debug(TAG, "Reconciling jobs");
                z9 = true;
                break;
            }
        }
        if (!z9) {
            return z9;
        }
        workDatabase.beginTransaction();
        try {
            WorkSpecDao workSpecDao = workDatabase.workSpecDao();
            Iterator<String> it2 = workSpecIds.iterator();
            while (it2.hasNext()) {
                workSpecDao.markWorkSpecScheduled(it2.next(), -1L);
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            return z9;
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String str) {
        List<Integer> pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, str);
        if (pendingJobIds == null || pendingJobIds.isEmpty()) {
            return;
        }
        Iterator<Integer> it = pendingJobIds.iterator();
        while (it.hasNext()) {
            cancelJobById(this.mJobScheduler, it.next().intValue());
        }
        this.mWorkDatabase.systemIdInfoDao().removeSystemIdInfo(str);
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(WorkSpec... workSpecArr) {
        List<Integer> pendingJobIds;
        IdGenerator idGenerator = new IdGenerator(this.mWorkDatabase);
        for (WorkSpec workSpec : workSpecArr) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = this.mWorkDatabase.workSpecDao().getWorkSpec(workSpec.id);
                if (workSpec2 == null) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.id + " because it's no longer in the DB");
                    this.mWorkDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo.State.ENQUEUED) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.id + " because it is no longer enqueued");
                    this.mWorkDatabase.setTransactionSuccessful();
                } else {
                    WorkGenerationalId workGenerationalIdGenerationalId = WorkSpecKt.generationalId(workSpec);
                    SystemIdInfo systemIdInfo = this.mWorkDatabase.systemIdInfoDao().getSystemIdInfo(workGenerationalIdGenerationalId);
                    int iNextJobSchedulerIdWithRange = systemIdInfo != null ? systemIdInfo.systemId : idGenerator.nextJobSchedulerIdWithRange(this.mConfiguration.getMinJobSchedulerId(), this.mConfiguration.getMaxJobSchedulerId());
                    if (systemIdInfo == null) {
                        this.mWorkDatabase.systemIdInfoDao().insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(workGenerationalIdGenerationalId, iNextJobSchedulerIdWithRange));
                    }
                    scheduleInternal(workSpec, iNextJobSchedulerIdWithRange);
                    if (Build.VERSION.SDK_INT == 23 && (pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, workSpec.id)) != null) {
                        int iIndexOf = pendingJobIds.indexOf(Integer.valueOf(iNextJobSchedulerIdWithRange));
                        if (iIndexOf >= 0) {
                            pendingJobIds.remove(iIndexOf);
                        }
                        scheduleInternal(workSpec, !pendingJobIds.isEmpty() ? pendingJobIds.get(0).intValue() : idGenerator.nextJobSchedulerIdWithRange(this.mConfiguration.getMinJobSchedulerId(), this.mConfiguration.getMaxJobSchedulerId()));
                    }
                    this.mWorkDatabase.setTransactionSuccessful();
                }
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
    }

    @VisibleForTesting
    public void scheduleInternal(WorkSpec workSpec, int i10) {
        JobInfo jobInfoConvert = this.mSystemJobInfoConverter.convert(workSpec, i10);
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Scheduling work ID " + workSpec.id + "Job ID " + i10);
        try {
            if (this.mJobScheduler.schedule(jobInfoConvert) == 0) {
                Logger.get().warning(str, "Unable to schedule work ID " + workSpec.id);
                if (workSpec.expedited && workSpec.outOfQuotaPolicy == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.expedited = false;
                    Logger.get().debug(str, "Scheduling a non-expedited job (work ID " + workSpec.id + ")");
                    scheduleInternal(workSpec, i10);
                }
            }
        } catch (IllegalStateException e) {
            String strCreateErrorMessage = JobSchedulerExtKt.createErrorMessage(this.mContext, this.mWorkDatabase, this.mConfiguration);
            Logger.get().error(TAG, strCreateErrorMessage);
            IllegalStateException illegalStateException = new IllegalStateException(strCreateErrorMessage, e);
            Consumer<Throwable> schedulingExceptionHandler = this.mConfiguration.getSchedulingExceptionHandler();
            if (schedulingExceptionHandler == null) {
                throw illegalStateException;
            }
            schedulingExceptionHandler.accept(illegalStateException);
        } catch (Throwable th) {
            Logger.get().error(TAG, "Unable to schedule " + workSpec, th);
        }
    }

    @VisibleForTesting
    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.mContext = context;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
        this.mWorkDatabase = workDatabase;
        this.mConfiguration = configuration;
    }
}
