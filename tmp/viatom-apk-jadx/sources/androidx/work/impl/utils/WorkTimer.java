package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");
    final RunnableScheduler mRunnableScheduler;
    final Map<WorkGenerationalId, WorkTimerRunnable> mTimerMap = new HashMap();
    final Map<WorkGenerationalId, TimeLimitExceededListener> mListeners = new HashMap();
    final Object mLock = new Object();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(WorkGenerationalId workGenerationalId);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final WorkGenerationalId mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        public WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = workGenerationalId;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.mWorkTimer.mLock) {
                try {
                    if (this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId) != null) {
                        TimeLimitExceededListener timeLimitExceededListenerRemove = this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);
                        if (timeLimitExceededListenerRemove != null) {
                            timeLimitExceededListenerRemove.onTimeLimitExceeded(this.mWorkGenerationalId);
                        }
                    } else {
                        Logger.get().debug(TAG, "Timer with " + this.mWorkGenerationalId + " is already marked as complete.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public WorkTimer(RunnableScheduler runnableScheduler) {
        this.mRunnableScheduler = runnableScheduler;
    }

    @VisibleForTesting
    public Map<WorkGenerationalId, TimeLimitExceededListener> getListeners() {
        Map<WorkGenerationalId, TimeLimitExceededListener> map;
        synchronized (this.mLock) {
            map = this.mListeners;
        }
        return map;
    }

    @VisibleForTesting
    public Map<WorkGenerationalId, WorkTimerRunnable> getTimerMap() {
        Map<WorkGenerationalId, WorkTimerRunnable> map;
        synchronized (this.mLock) {
            map = this.mTimerMap;
        }
        return map;
    }

    public void startTimer(WorkGenerationalId workGenerationalId, long j10, TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Starting timer for " + workGenerationalId);
            stopTimer(workGenerationalId);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, workGenerationalId);
            this.mTimerMap.put(workGenerationalId, workTimerRunnable);
            this.mListeners.put(workGenerationalId, timeLimitExceededListener);
            this.mRunnableScheduler.scheduleWithDelay(j10, workTimerRunnable);
        }
    }

    public void stopTimer(WorkGenerationalId workGenerationalId) {
        synchronized (this.mLock) {
            try {
                if (this.mTimerMap.remove(workGenerationalId) != null) {
                    Logger.get().debug(TAG, "Stopping timer for " + workGenerationalId);
                    this.mListeners.remove(workGenerationalId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
