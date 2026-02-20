package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class Trackers {
    private final ConstraintTracker<Boolean> batteryChargingTracker;
    private final BatteryNotLowTracker batteryNotLowTracker;
    private final Context context;
    private final ConstraintTracker<NetworkState> networkStateTracker;
    private final ConstraintTracker<Boolean> storageNotLowTracker;

    public /* synthetic */ Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker constraintTracker2, ConstraintTracker constraintTracker3, int i10, g gVar) {
        if ((i10 & 4) != 0) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            constraintTracker = new BatteryChargingTracker(applicationContext, taskExecutor);
        }
        ConstraintTracker constraintTracker4 = constraintTracker;
        if ((i10 & 8) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            applicationContext2.getClass();
            batteryNotLowTracker = new BatteryNotLowTracker(applicationContext2, taskExecutor);
        }
        BatteryNotLowTracker batteryNotLowTracker2 = batteryNotLowTracker;
        if ((i10 & 16) != 0) {
            Context applicationContext3 = context.getApplicationContext();
            applicationContext3.getClass();
            constraintTracker2 = NetworkStateTrackerKt.NetworkStateTracker(applicationContext3, taskExecutor);
        }
        ConstraintTracker constraintTracker5 = constraintTracker2;
        if ((i10 & 32) != 0) {
            Context applicationContext4 = context.getApplicationContext();
            applicationContext4.getClass();
            constraintTracker3 = new StorageNotLowTracker(applicationContext4, taskExecutor);
        }
        this(context, taskExecutor, constraintTracker4, batteryNotLowTracker2, constraintTracker5, constraintTracker3);
    }

    public final ConstraintTracker<Boolean> getBatteryChargingTracker() {
        return this.batteryChargingTracker;
    }

    public final BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.batteryNotLowTracker;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ConstraintTracker<NetworkState> getNetworkStateTracker() {
        return this.networkStateTracker;
    }

    public final ConstraintTracker<Boolean> getStorageNotLowTracker() {
        return this.storageNotLowTracker;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker) {
        this(context, taskExecutor, constraintTracker, null, null, null, 56, null);
        context.getClass();
        taskExecutor.getClass();
        constraintTracker.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker) {
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker, null, null, 48, null);
        context.getClass();
        taskExecutor.getClass();
        constraintTracker.getClass();
        batteryNotLowTracker.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker<NetworkState> constraintTracker2) {
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker, constraintTracker2, null, 32, null);
        context.getClass();
        taskExecutor.getClass();
        constraintTracker.getClass();
        batteryNotLowTracker.getClass();
        constraintTracker2.getClass();
    }

    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker<NetworkState> constraintTracker2, ConstraintTracker<Boolean> constraintTracker3) {
        context.getClass();
        taskExecutor.getClass();
        constraintTracker.getClass();
        batteryNotLowTracker.getClass();
        constraintTracker2.getClass();
        constraintTracker3.getClass();
        this.context = context;
        this.batteryChargingTracker = constraintTracker;
        this.batteryNotLowTracker = batteryNotLowTracker;
        this.networkStateTracker = constraintTracker2;
        this.storageNotLowTracker = constraintTracker3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor) {
        this(context, taskExecutor, null, null, null, null, 60, null);
        context.getClass();
        taskExecutor.getClass();
    }
}
