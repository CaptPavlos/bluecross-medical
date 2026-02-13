package androidx.work.impl.utils;

import android.net.NetworkRequest;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class NetworkRequestCompatKt {
    private static final int[] defaultCapabilities = {13, 15, 14};

    @RequiresApi(28)
    public static final int[] getCapabilitiesCompat(NetworkRequest networkRequest) {
        networkRequest.getClass();
        if (Build.VERSION.SDK_INT >= 31) {
            return NetworkRequest31.INSTANCE.capabilities(networkRequest);
        }
        int[] iArr = {17, 5, 2, 10, 29, 19, 3, 32, 7, 4, 12, 36, 23, 0, 33, 20, 11, 13, 18, 21, 15, 35, 34, 8, 1, 25, 14, 16, 6, 9};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 30; i10++) {
            int i11 = iArr[i10];
            if (NetworkRequest28.INSTANCE.hasCapability$work_runtime_release(networkRequest, i11)) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        return l.q0(arrayList);
    }

    @RequiresApi(28)
    public static final int[] getTransportTypesCompat(NetworkRequest networkRequest) {
        networkRequest.getClass();
        if (Build.VERSION.SDK_INT >= 31) {
            return NetworkRequest31.INSTANCE.transportTypes(networkRequest);
        }
        int[] iArr = {2, 0, 3, 6, 10, 9, 8, 4, 1, 5};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = iArr[i10];
            if (NetworkRequest28.INSTANCE.hasTransport$work_runtime_release(networkRequest, i11)) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        return l.q0(arrayList);
    }
}
