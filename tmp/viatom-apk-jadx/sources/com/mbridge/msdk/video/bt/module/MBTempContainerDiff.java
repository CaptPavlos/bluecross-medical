package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.util.AttributeSet;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.bt.module.a.b;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBTempContainerDiff extends AbstractJSContainer {
    public MBridgeVideoView mbridgeVideoView;

    public MBTempContainerDiff(Context context) {
        super(context);
    }

    public boolean checkChinaSendToServerDiff(h hVar) {
        return false;
    }

    public boolean checkChinaShowingAlertViewState() {
        return false;
    }

    public MBTempContainerDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setChinaCTACallBack() {
    }

    public void setChinaDestroy() {
    }

    public void setChinaJsCommonContext() {
    }

    public void setChinaCallBackStatus(WindVaneWebView windVaneWebView) {
    }

    public void setChinaBrowserCallBack(b bVar, String str, h hVar, CampaignEx campaignEx) {
    }
}
