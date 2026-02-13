package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements com.mbridge.msdk.tracker.network.c {
    @Override // com.mbridge.msdk.tracker.network.c
    public final String a(u<?> uVar) {
        String strK = uVar.k();
        int i10 = uVar.i();
        if (i10 == 0) {
            return strK;
        }
        return Integer.toString(i10) + '-' + strK;
    }
}
