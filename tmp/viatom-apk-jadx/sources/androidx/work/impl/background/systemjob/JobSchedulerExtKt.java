package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import java.util.List;
import t6.j;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class JobSchedulerExtKt {
    private static final String TAG;
    public static final String WORKMANAGER_NAMESPACE = "androidx.work.systemjobscheduler";

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("SystemJobScheduler");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
    }

    public static final String createErrorMessage(Context context, WorkDatabase workDatabase, Configuration configuration) {
        String str;
        context.getClass();
        workDatabase.getClass();
        configuration.getClass();
        int i10 = Build.VERSION.SDK_INT;
        int i11 = i10 >= 31 ? 150 : 100;
        int size = workDatabase.workSpecDao().getScheduledWork().size();
        String strH0 = "<faulty JobScheduler failed to getPendingJobs>";
        if (i10 >= 34) {
            JobScheduler wmJobScheduler = getWmJobScheduler(context);
            List<JobInfo> safePendingJobs = getSafePendingJobs(wmJobScheduler);
            if (safePendingJobs != null) {
                List<JobInfo> pendingJobs = SystemJobScheduler.getPendingJobs(context, wmJobScheduler);
                int size2 = pendingJobs != null ? safePendingJobs.size() - pendingJobs.size() : 0;
                String str2 = null;
                if (size2 == 0) {
                    str = null;
                } else {
                    str = size2 + " of which are not owned by WorkManager";
                }
                Object systemService = context.getSystemService("jobscheduler");
                systemService.getClass();
                List<JobInfo> pendingJobs2 = SystemJobScheduler.getPendingJobs(context, (JobScheduler) systemService);
                int size3 = pendingJobs2 != null ? pendingJobs2.size() : 0;
                if (size3 != 0) {
                    str2 = size3 + " from WorkManager in the default namespace";
                }
                strH0 = l.h0(j.t0(new String[]{safePendingJobs.size() + " jobs in \"androidx.work.systemjobscheduler\" namespace", str, str2}), ",\n", null, null, null, 62);
            }
        } else {
            List<JobInfo> pendingJobs3 = SystemJobScheduler.getPendingJobs(context, getWmJobScheduler(context));
            if (pendingJobs3 != null) {
                strH0 = pendingJobs3.size() + " jobs from WorkManager";
            }
        }
        return "JobScheduler " + i11 + " job limit exceeded.\nIn JobScheduler there are " + strH0 + ".\nThere are " + size + " jobs tracked by WorkManager's database;\nthe Configuration limit is " + configuration.getMaxSchedulerLimit() + '.';
    }

    public static final List<JobInfo> getSafePendingJobs(JobScheduler jobScheduler) {
        jobScheduler.getClass();
        try {
            return JobScheduler21.INSTANCE.getAllPendingJobs(jobScheduler);
        } catch (Throwable th) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            return null;
        }
    }

    public static final JobScheduler getWmJobScheduler(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("jobscheduler");
        systemService.getClass();
        JobScheduler jobScheduler = (JobScheduler) systemService;
        return Build.VERSION.SDK_INT >= 34 ? JobScheduler34.INSTANCE.forNamespace(jobScheduler) : jobScheduler;
    }
}
