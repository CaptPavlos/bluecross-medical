package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class Processor implements ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Configuration mConfiguration;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private Set<String> mCancelledIds = new HashSet();
    private final List<ExecutionListener> mOuterListeners = new ArrayList();
    private PowerManager.WakeLock mForegroundLock = null;
    private final Object mLock = new Object();
    private Map<String, Set<StartStopToken>> mWorkRuns = new HashMap();

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
    }

    private WorkerWrapper cleanUpWorkerUnsafe(String str) {
        WorkerWrapper workerWrapperRemove = this.mForegroundWorkMap.remove(str);
        boolean z9 = workerWrapperRemove != null;
        if (!z9) {
            workerWrapperRemove = this.mEnqueuedWorkMap.remove(str);
        }
        this.mWorkRuns.remove(str);
        if (z9) {
            stopForegroundService();
        }
        return workerWrapperRemove;
    }

    private WorkerWrapper getWorkerWrapperUnsafe(String str) {
        WorkerWrapper workerWrapper = this.mForegroundWorkMap.get(str);
        return workerWrapper == null ? this.mEnqueuedWorkMap.get(str) : workerWrapper;
    }

    private static boolean interrupt(String str, WorkerWrapper workerWrapper, int i10) {
        if (workerWrapper == null) {
            Logger.get().debug(TAG, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.interrupt(i10);
        Logger.get().debug(TAG, "WorkerWrapper interrupted for " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runOnExecuted$2(WorkGenerationalId workGenerationalId, boolean z9) {
        synchronized (this.mLock) {
            try {
                Iterator<ExecutionListener> it = this.mOuterListeners.iterator();
                while (it.hasNext()) {
                    it.next().onExecuted(workGenerationalId, z9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WorkSpec lambda$startWork$0(ArrayList arrayList, String str) throws Exception {
        arrayList.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(str));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startWork$1(k1.b bVar, WorkerWrapper workerWrapper) {
        boolean zBooleanValue;
        try {
            zBooleanValue = ((Boolean) bVar.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            zBooleanValue = true;
        }
        onExecuted(workerWrapper, zBooleanValue);
    }

    private void onExecuted(WorkerWrapper workerWrapper, boolean z9) {
        synchronized (this.mLock) {
            try {
                WorkGenerationalId workGenerationalId = workerWrapper.getWorkGenerationalId();
                String workSpecId = workGenerationalId.getWorkSpecId();
                if (getWorkerWrapperUnsafe(workSpecId) == workerWrapper) {
                    cleanUpWorkerUnsafe(workSpecId);
                }
                Logger.get().debug(TAG, getClass().getSimpleName() + " " + workSpecId + " executed; reschedule = " + z9);
                Iterator<ExecutionListener> it = this.mOuterListeners.iterator();
                while (it.hasNext()) {
                    it.next().onExecuted(workGenerationalId, z9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runOnExecuted(final WorkGenerationalId workGenerationalId, final boolean z9) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new Runnable() { // from class: androidx.work.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f676a.lambda$runOnExecuted$2(workGenerationalId, z9);
            }
        });
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.isEmpty()) {
                    try {
                        this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                    } catch (Throwable th) {
                        Logger.get().error(TAG, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public WorkSpec getRunningWorkSpec(String str) {
        synchronized (this.mLock) {
            try {
                WorkerWrapper workerWrapperUnsafe = getWorkerWrapperUnsafe(str);
                if (workerWrapperUnsafe == null) {
                    return null;
                }
                return workerWrapperUnsafe.getWorkSpec();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hasWork() {
        boolean z9;
        synchronized (this.mLock) {
            try {
                z9 = (this.mEnqueuedWorkMap.isEmpty() && this.mForegroundWorkMap.isEmpty()) ? false : true;
            } finally {
            }
        }
        return z9;
    }

    public boolean isCancelled(String str) {
        boolean zContains;
        synchronized (this.mLock) {
            zContains = this.mCancelledIds.contains(str);
        }
        return zContains;
    }

    public boolean isEnqueued(String str) {
        boolean z9;
        synchronized (this.mLock) {
            z9 = getWorkerWrapperUnsafe(str) != null;
        }
        return z9;
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger.get().info(TAG, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapperRemove = this.mEnqueuedWorkMap.remove(str);
                if (workerWrapperRemove != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                        this.mForegroundLock = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, workerWrapperRemove);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, workerWrapperRemove.getWorkGenerationalId(), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) throws Throwable {
        Throwable th;
        WorkGenerationalId id = startStopToken.getId();
        String workSpecId = id.getWorkSpecId();
        ArrayList arrayList = new ArrayList();
        WorkSpec workSpec = (WorkSpec) this.mWorkDatabase.runInTransaction(new b(this, arrayList, workSpecId, 0));
        if (workSpec == null) {
            Logger.get().warning(TAG, "Didn't find WorkSpec for id " + id);
            runOnExecuted(id, false);
            return false;
        }
        synchronized (this.mLock) {
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    throw th;
                }
                try {
                    if (isEnqueued(workSpecId)) {
                        Set<StartStopToken> set = this.mWorkRuns.get(workSpecId);
                        if (set.iterator().next().getId().getGeneration() == id.getGeneration()) {
                            set.add(startStopToken);
                            Logger.get().debug(TAG, "Work " + id + " is already enqueued for processing");
                        } else {
                            runOnExecuted(id, false);
                        }
                        return false;
                    }
                    if (workSpec.getGeneration() != id.getGeneration()) {
                        runOnExecuted(id, false);
                        return false;
                    }
                    WorkerWrapper workerWrapperBuild = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, workSpec, arrayList).withRuntimeExtras(runtimeExtras).build();
                    k1.b bVarLaunch = workerWrapperBuild.launch();
                    bVarLaunch.addListener(new c(this, bVarLaunch, workerWrapperBuild, 0), this.mWorkTaskExecutor.getMainThreadExecutor());
                    this.mEnqueuedWorkMap.put(workSpecId, workerWrapperBuild);
                    HashSet hashSet = new HashSet();
                    hashSet.add(startStopToken);
                    this.mWorkRuns.put(workSpecId, hashSet);
                    Logger.get().debug(TAG, getClass().getSimpleName() + ": processing " + id);
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public boolean stopAndCancelWork(String str, int i10) {
        WorkerWrapper workerWrapperCleanUpWorkerUnsafe;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Processor cancelling " + str);
            this.mCancelledIds.add(str);
            workerWrapperCleanUpWorkerUnsafe = cleanUpWorkerUnsafe(str);
        }
        return interrupt(str, workerWrapperCleanUpWorkerUnsafe, i10);
    }

    public boolean stopForegroundWork(StartStopToken startStopToken, int i10) {
        WorkerWrapper workerWrapperCleanUpWorkerUnsafe;
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            workerWrapperCleanUpWorkerUnsafe = cleanUpWorkerUnsafe(workSpecId);
        }
        return interrupt(workSpecId, workerWrapperCleanUpWorkerUnsafe, i10);
    }

    public boolean stopWork(StartStopToken startStopToken, int i10) {
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.get(workSpecId) == null) {
                    Set<StartStopToken> set = this.mWorkRuns.get(workSpecId);
                    if (set != null && set.contains(startStopToken)) {
                        return interrupt(workSpecId, cleanUpWorkerUnsafe(workSpecId), i10);
                    }
                    return false;
                }
                Logger.get().debug(TAG, "Ignored stopWork. WorkerWrapper " + workSpecId + " is in foreground");
                return false;
            } finally {
            }
        }
    }

    public boolean startWork(StartStopToken startStopToken) {
        return startWork(startStopToken, null);
    }
}
