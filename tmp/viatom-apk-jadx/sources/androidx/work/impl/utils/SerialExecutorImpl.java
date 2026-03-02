package androidx.work.impl.utils;

import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SerialExecutorImpl implements SerialExecutor {

    @GuardedBy("mLock")
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Task> mTasks = new ArrayDeque<>();
    final Object mLock = new Object();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutorImpl mSerialExecutor;

        public Task(SerialExecutorImpl serialExecutorImpl, Runnable runnable) {
            this.mSerialExecutor = serialExecutorImpl;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mRunnable.run();
                synchronized (this.mSerialExecutor.mLock) {
                    this.mSerialExecutor.scheduleNext();
                }
            } catch (Throwable th) {
                synchronized (this.mSerialExecutor.mLock) {
                    this.mSerialExecutor.scheduleNext();
                    throw th;
                }
            }
        }
    }

    public SerialExecutorImpl(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.mLock) {
            try {
                this.mTasks.add(new Task(this, runnable));
                if (this.mActive == null) {
                    scheduleNext();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    @Override // androidx.work.impl.utils.taskexecutor.SerialExecutor
    public boolean hasPendingTasks() {
        boolean z9;
        synchronized (this.mLock) {
            z9 = !this.mTasks.isEmpty();
        }
        return z9;
    }

    @GuardedBy("mLock")
    public void scheduleNext() {
        Task taskPoll = this.mTasks.poll();
        this.mActive = taskPoll;
        if (taskPoll != null) {
            this.mExecutor.execute(taskPoll);
        }
    }
}
