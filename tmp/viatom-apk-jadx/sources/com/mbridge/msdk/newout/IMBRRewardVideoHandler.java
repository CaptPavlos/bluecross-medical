package com.mbridge.msdk.newout;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface IMBRRewardVideoHandler {
    boolean isReady();

    void load();

    void load(String str);

    void setRewardVideoListener(RewardVideoListener rewardVideoListener);

    void show(String str);
}
