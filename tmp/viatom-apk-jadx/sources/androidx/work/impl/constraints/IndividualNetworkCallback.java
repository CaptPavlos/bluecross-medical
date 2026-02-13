package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.IndividualNetworkCallback;
import g7.l;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.u;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(28)
/* loaded from: classes.dex */
final class IndividualNetworkCallback extends ConnectivityManager.NetworkCallback {
    public static final Companion Companion = new Companion(null);
    private final l onConstraintState;

    private IndividualNetworkCallback(l lVar) {
        this.onConstraintState = lVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        network.getClass();
        networkCapabilities.getClass();
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        this.onConstraintState.invoke(ConstraintsState.ConstraintsMet.INSTANCE);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        network.getClass();
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onLost callback");
        this.onConstraintState.invoke(new ConstraintsState.ConstraintsNotMet(7));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final w addCallback$lambda$0(u uVar, ConnectivityManager connectivityManager, IndividualNetworkCallback individualNetworkCallback) {
            if (uVar.f10135a) {
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController unregister callback");
                connectivityManager.unregisterNetworkCallback(individualNetworkCallback);
            }
            return w.f12711a;
        }

        public final g7.a addCallback(final ConnectivityManager connectivityManager, NetworkRequest networkRequest, l lVar) {
            connectivityManager.getClass();
            networkRequest.getClass();
            lVar.getClass();
            final IndividualNetworkCallback individualNetworkCallback = new IndividualNetworkCallback(lVar, null);
            final u uVar = new u();
            try {
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController register callback");
                connectivityManager.registerNetworkCallback(networkRequest, individualNetworkCallback);
                uVar.f10135a = true;
            } catch (RuntimeException e) {
                if (!o7.u.X(e.getClass().getName(), "TooManyRequestsException", false)) {
                    throw e;
                }
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController couldn't register callback", e);
                lVar.invoke(new ConstraintsState.ConstraintsNotMet(7));
            }
            return new g7.a() { // from class: androidx.work.impl.constraints.a
                @Override // g7.a
                public final Object invoke() {
                    return IndividualNetworkCallback.Companion.addCallback$lambda$0(uVar, connectivityManager, individualNetworkCallback);
                }
            };
        }

        private Companion() {
        }
    }

    public /* synthetic */ IndividualNetworkCallback(l lVar, g gVar) {
        this(lVar);
    }
}
