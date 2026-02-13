package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.browser.trusted.c;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class ConstraintTracker<T> {
    private final Context appContext;
    private T currentState;
    private final LinkedHashSet<ConstraintListener<T>> listeners;
    private final Object lock;
    private final TaskExecutor taskExecutor;

    public ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        context.getClass();
        taskExecutor.getClass();
        this.taskExecutor = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.appContext = applicationContext;
        this.lock = new Object();
        this.listeners = new LinkedHashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _set_state_$lambda$4$lambda$3(List list, ConstraintTracker constraintTracker) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).onConstraintChanged(constraintTracker.currentState);
        }
    }

    public final void addListener(ConstraintListener<T> constraintListener) {
        constraintListener.getClass();
        synchronized (this.lock) {
            try {
                if (this.listeners.add(constraintListener)) {
                    if (this.listeners.size() == 1) {
                        this.currentState = readSystemState();
                        Logger.get().debug(ConstraintTrackerKt.TAG, getClass().getSimpleName() + ": initial state = " + this.currentState);
                        startTracking();
                    }
                    constraintListener.onConstraintChanged(this.currentState);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final T getState() {
        T t = this.currentState;
        return t == null ? readSystemState() : t;
    }

    public abstract T readSystemState();

    public final void removeListener(ConstraintListener<T> constraintListener) {
        constraintListener.getClass();
        synchronized (this.lock) {
            if (this.listeners.remove(constraintListener) && this.listeners.isEmpty()) {
                stopTracking();
            }
        }
    }

    public final void setState(T t) {
        synchronized (this.lock) {
            T t9 = this.currentState;
            if (t9 == null || !t9.equals(t)) {
                this.currentState = t;
                this.taskExecutor.getMainThreadExecutor().execute(new c(7, l.r0(this.listeners), this));
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
