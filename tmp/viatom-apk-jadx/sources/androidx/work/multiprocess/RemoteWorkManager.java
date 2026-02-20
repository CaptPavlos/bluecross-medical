package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.window.layout.c;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import k1.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class RemoteWorkManager {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final long DEFAULT_SESSION_TIMEOUT_MILLIS = 600000;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final long MAX_SESSION_TIMEOUT_MILLIS = 1200000;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteWorkManager() {
    }

    public static RemoteWorkManager getInstance(Context context) {
        RemoteWorkManager remoteWorkManager = WorkManagerImpl.getInstance(context).getRemoteWorkManager();
        if (remoteWorkManager != null) {
            return remoteWorkManager;
        }
        c.g("Unable to initialize RemoteWorkManager");
        return null;
    }

    public final RemoteWorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return beginUniqueWork(str, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public final RemoteWorkContinuation beginWith(OneTimeWorkRequest oneTimeWorkRequest) {
        return beginWith(Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation beginWith(List<OneTimeWorkRequest> list);

    public abstract b cancelAllWork();

    public abstract b cancelAllWorkByTag(String str);

    public abstract b cancelUniqueWork(String str);

    public abstract b cancelWorkById(UUID uuid);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract b enqueue(WorkContinuation workContinuation);

    public abstract b enqueue(WorkRequest workRequest);

    public abstract b enqueue(List<WorkRequest> list);

    public abstract b enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest);

    public final b enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return enqueueUniqueWork(str, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract b enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public abstract b getWorkInfos(WorkQuery workQuery);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract b setForegroundAsync(String str, ForegroundInfo foregroundInfo);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract b setProgress(UUID uuid, Data data);
}
