package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.signal.a.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class MBridgeBTWebViewDiff extends BTBaseView implements i, b {
    public k jsCommon;
    public WindVaneWebView webView;

    public MBridgeBTWebViewDiff(Context context) {
        super(context);
    }

    public void open(String str) {
        try {
            String clickURL = this.f5568b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.f5568b.setClickURL(str);
                reportOpen(str);
            }
            a aVar = new a(getContext(), this.f5569c);
            aVar.a(this);
            aVar.a(this.f5568b);
            this.f5568b.setClickURL(clickURL);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage());
        }
    }

    public void reportOpen(String str) {
        try {
            CampaignEx mraidCampaign = getMraidCampaign();
            if (mraidCampaign != null) {
                new h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.f5569c, str, this.f5568b.isBidCampaign());
            }
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public MBridgeBTWebViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setChinaAlertInstallState(k kVar) {
    }
}
