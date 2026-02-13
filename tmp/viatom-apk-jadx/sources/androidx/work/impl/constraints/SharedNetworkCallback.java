package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import g7.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(30)
/* loaded from: classes.dex */
final class SharedNetworkCallback extends ConnectivityManager.NetworkCallback {

    @GuardedBy("requestsLock")
    private static NetworkCapabilities cachedCapabilities;

    @GuardedBy("requestsLock")
    private static boolean capabilitiesInitialized;
    public static final SharedNetworkCallback INSTANCE = new SharedNetworkCallback();
    private static final Object requestsLock = new Object();

    @GuardedBy("requestsLock")
    private static final Map<l, NetworkRequest> requests = new LinkedHashMap();

    private SharedNetworkCallback() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w addCallback$lambda$6(l lVar, ConnectivityManager connectivityManager) {
        synchronized (requestsLock) {
            Map<l, NetworkRequest> map = requests;
            map.remove(lVar);
            if (map.isEmpty()) {
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController unregister shared callback");
                connectivityManager.unregisterNetworkCallback(INSTANCE);
                cachedCapabilities = null;
                capabilitiesInitialized = false;
            }
        }
        return w.f12711a;
    }

    public final g7.a addCallback(final ConnectivityManager connectivityManager, NetworkRequest networkRequest, final l lVar) {
        connectivityManager.getClass();
        networkRequest.getClass();
        lVar.getClass();
        synchronized (requestsLock) {
            try {
                Map<l, NetworkRequest> map = requests;
                boolean zIsEmpty = map.isEmpty();
                map.put(lVar, networkRequest);
                if (zIsEmpty) {
                    Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController register shared callback");
                    connectivityManager.registerDefaultNetworkCallback(INSTANCE);
                }
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController send initial capabilities");
                lVar.invoke(networkRequest.canBeSatisfiedBy(INSTANCE.getCurrentNetworkCapabilities(connectivityManager)) ? ConstraintsState.ConstraintsMet.INSTANCE : new ConstraintsState.ConstraintsNotMet(7));
            } catch (Throwable th) {
                throw th;
            }
        }
        return new g7.a() { // from class: androidx.work.impl.constraints.d
            @Override // g7.a
            public final Object invoke() {
                return SharedNetworkCallback.addCallback$lambda$6(lVar, connectivityManager);
            }
        };
    }

    public final NetworkCapabilities getCachedCapabilities() {
        return cachedCapabilities;
    }

    public final boolean getCapabilitiesInitialized() {
        return capabilitiesInitialized;
    }

    public final NetworkCapabilities getCurrentNetworkCapabilities(ConnectivityManager connectivityManager) {
        connectivityManager.getClass();
        if (capabilitiesInitialized) {
            return cachedCapabilities;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        cachedCapabilities = networkCapabilities;
        capabilitiesInitialized = true;
        return networkCapabilities;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        network.getClass();
        networkCapabilities.getClass();
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        synchronized (requestsLock) {
            try {
                cachedCapabilities = networkCapabilities;
                Iterator<T> it = requests.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    ((l) entry.getKey()).invoke(((NetworkRequest) entry.getValue()).canBeSatisfiedBy(networkCapabilities) ? ConstraintsState.ConstraintsMet.INSTANCE : new ConstraintsState.ConstraintsNotMet(7));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        network.getClass();
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onLost callback");
        synchronized (requestsLock) {
            cachedCapabilities = null;
            Iterator<T> it = requests.keySet().iterator();
            while (it.hasNext()) {
                ((l) it.next()).invoke(new ConstraintsState.ConstraintsNotMet(7));
            }
        }
    }

    public final void setCachedCapabilities(NetworkCapabilities networkCapabilities) {
        cachedCapabilities = networkCapabilities;
    }

    public final void setCapabilitiesInitialized(boolean z9) {
        capabilitiesInitialized = z9;
    }
}
