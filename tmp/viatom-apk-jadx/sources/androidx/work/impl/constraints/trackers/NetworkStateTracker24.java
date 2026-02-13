package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(24)
/* loaded from: classes.dex */
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {
    private final ConnectivityManager connectivityManager;
    private final NetworkStateTracker24$networkCallback$1 networkCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1] */
    public NetworkStateTracker24(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        context.getClass();
        taskExecutor.getClass();
        Object systemService = getAppContext().getSystemService("connectivity");
        systemService.getClass();
        this.connectivityManager = (ConnectivityManager) systemService;
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                network.getClass();
                networkCapabilities.getClass();
                Logger.get().debug(NetworkStateTrackerKt.TAG, "Network capabilities changed: " + networkCapabilities);
                NetworkStateTracker24 networkStateTracker24 = this.this$0;
                networkStateTracker24.setState(Build.VERSION.SDK_INT >= 28 ? NetworkStateTrackerKt.getActiveNetworkState(networkCapabilities) : NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                network.getClass();
                Logger.get().debug(NetworkStateTrackerKt.TAG, "Network connection lost");
                NetworkStateTracker24 networkStateTracker24 = this.this$0;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
            }
        };
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e);
        } catch (SecurityException e3) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e3);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Unregistering network callback");
            this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
        } catch (IllegalArgumentException e) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e);
        } catch (SecurityException e3) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e3);
        }
    }
}
