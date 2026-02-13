package com.mbridge.msdk.newinterstitial.out;

import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface NewInterstitialListener {
    void onAdClicked(MBridgeIds mBridgeIds);

    void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo);

    void onAdCloseWithNIReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo);

    void onAdShow(MBridgeIds mBridgeIds);

    void onEndcardShow(MBridgeIds mBridgeIds);

    void onLoadCampaignSuccess(MBridgeIds mBridgeIds);

    void onResourceLoadFail(MBridgeIds mBridgeIds, String str);

    void onResourceLoadSuccess(MBridgeIds mBridgeIds);

    void onShowFail(MBridgeIds mBridgeIds, String str);

    void onVideoComplete(MBridgeIds mBridgeIds);
}
