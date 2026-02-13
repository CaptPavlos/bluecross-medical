package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class NetworkUnmeteredController extends BaseConstraintController<NetworkState> {
    private final int reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkUnmeteredController(ConstraintTracker<NetworkState> constraintTracker) {
        super(constraintTracker);
        constraintTracker.getClass();
        this.reason = 7;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public int getReason() {
        return this.reason;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec workSpec) {
        workSpec.getClass();
        NetworkType requiredNetworkType = workSpec.constraints.getRequiredNetworkType();
        if (requiredNetworkType != NetworkType.UNMETERED) {
            return Build.VERSION.SDK_INT >= 30 && requiredNetworkType == NetworkType.TEMPORARILY_UNMETERED;
        }
        return true;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public boolean isConstrained(NetworkState networkState) {
        networkState.getClass();
        return !networkState.isConnected() || networkState.isMetered();
    }
}
