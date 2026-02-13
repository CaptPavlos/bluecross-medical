package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(28)
/* loaded from: classes.dex */
public final class NetworkRequest28 {
    public static final NetworkRequest28 INSTANCE = new NetworkRequest28();

    private NetworkRequest28() {
    }

    public static final NetworkRequest createNetworkRequest(int[] iArr, int[] iArr2) {
        iArr.getClass();
        iArr2.getClass();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i10 : iArr) {
            try {
                builder.addCapability(i10);
            } catch (IllegalArgumentException e) {
                Logger.get().warning(NetworkRequestCompat.Companion.getTAG(), "Ignoring adding capability '" + i10 + '\'', e);
            }
        }
        for (int i11 : NetworkRequestCompatKt.defaultCapabilities) {
            if (!j.f0(iArr, i11)) {
                try {
                    builder.removeCapability(i11);
                } catch (IllegalArgumentException e3) {
                    Logger.get().warning(NetworkRequestCompat.Companion.getTAG(), "Ignoring removing default capability '" + i11 + '\'', e3);
                }
            }
        }
        for (int i12 : iArr2) {
            builder.addTransportType(i12);
        }
        NetworkRequest networkRequestBuild = builder.build();
        networkRequestBuild.getClass();
        return networkRequestBuild;
    }

    public final NetworkRequestCompat createNetworkRequestCompat$work_runtime_release(int[] iArr, int[] iArr2) {
        iArr.getClass();
        iArr2.getClass();
        return new NetworkRequestCompat(createNetworkRequest(iArr, iArr2));
    }

    public final boolean hasCapability$work_runtime_release(NetworkRequest networkRequest, int i10) {
        networkRequest.getClass();
        return networkRequest.hasCapability(i10);
    }

    public final boolean hasTransport$work_runtime_release(NetworkRequest networkRequest, int i10) {
        networkRequest.getClass();
        return networkRequest.hasTransport(i10);
    }
}
