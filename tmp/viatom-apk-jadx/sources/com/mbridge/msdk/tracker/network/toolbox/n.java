package com.mbridge.msdk.tracker.network.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.tracker.network.v;
import com.mbridge.msdk.tracker.network.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {
    public static v a(com.mbridge.msdk.tracker.network.n nVar, x xVar, int i10, com.mbridge.msdk.tracker.network.b bVar) {
        if (nVar == null) {
            nVar = new b(new h());
        }
        if (xVar == null) {
            xVar = new com.mbridge.msdk.tracker.network.g(new Handler(Looper.getMainLooper()));
        }
        if (i10 <= 0) {
            i10 = 4;
        }
        if (bVar == null) {
            bVar = new j();
        }
        return new v(nVar, xVar, i10, bVar);
    }
}
