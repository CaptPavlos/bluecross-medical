package com.mbridge.msdk.newout;

import android.content.Context;
import com.mbridge.msdk.newreward.b.c;
import com.mbridge.msdk.newreward.b.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBRewardVideoHandler implements IMBRRewardVideoHandler {
    private c controller;
    private String unitId;

    public MBRewardVideoHandler(Context context, String str, String str2) {
        this.controller = null;
        this.controller = new d(94, str, str2, false);
        this.unitId = str2;
    }

    @Override // com.mbridge.msdk.newout.IMBRRewardVideoHandler
    public boolean isReady() {
        return this.controller.a(true);
    }

    @Override // com.mbridge.msdk.newout.IMBRRewardVideoHandler
    public void load() {
        this.controller.a(true, "");
    }

    @Override // com.mbridge.msdk.newout.IMBRRewardVideoHandler
    public void setRewardVideoListener(RewardVideoListener rewardVideoListener) {
        this.controller.a(rewardVideoListener);
    }

    @Override // com.mbridge.msdk.newout.IMBRRewardVideoHandler
    public void show(String str) {
        this.controller.a(str, "", "");
    }

    @Override // com.mbridge.msdk.newout.IMBRRewardVideoHandler
    public void load(String str) {
        this.controller.a(true, str);
    }
}
