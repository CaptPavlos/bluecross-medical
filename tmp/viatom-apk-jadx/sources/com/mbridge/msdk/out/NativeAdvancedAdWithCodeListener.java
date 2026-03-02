package com.mbridge.msdk.out;

import com.mbridge.msdk.e.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class NativeAdvancedAdWithCodeListener implements NativeAdvancedAdListener {
    @Override // com.mbridge.msdk.out.NativeAdvancedAdListener
    public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
        onLoadFailedWithCode(mBridgeIds, a.a(6000, str), str);
    }

    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i10, String str);
}
