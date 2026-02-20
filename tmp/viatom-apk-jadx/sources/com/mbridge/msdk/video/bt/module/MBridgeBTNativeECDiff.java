package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.a.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeBTNativeECDiff extends BTBaseView {
    public View ctaView;

    public MBridgeBTNativeECDiff(Context context) {
        super(context);
    }

    public boolean checkChinaProgressBarStatus() {
        return false;
    }

    public MBridgeBTNativeECDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
    }

    public void setChinaCTAData(CampaignEx campaignEx) {
    }

    public void doChinaJumpClick(Context context, k kVar) {
    }
}
