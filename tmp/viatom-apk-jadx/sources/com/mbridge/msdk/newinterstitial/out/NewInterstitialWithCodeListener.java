package com.mbridge.msdk.newinterstitial.out;

import com.mbridge.msdk.e.a;
import com.mbridge.msdk.out.MBridgeIds;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class NewInterstitialWithCodeListener implements NewInterstitialListener {
    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onResourceLoadFail(MBridgeIds mBridgeIds, String str) {
        onResourceLoadFailWithCode(mBridgeIds, a.a(3000, str), str);
    }

    public abstract void onResourceLoadFailWithCode(MBridgeIds mBridgeIds, int i10, String str);

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onShowFail(MBridgeIds mBridgeIds, String str) {
        onShowFailWithCode(mBridgeIds, 3900, str);
    }

    public abstract void onShowFailWithCode(MBridgeIds mBridgeIds, int i10, String str);
}
