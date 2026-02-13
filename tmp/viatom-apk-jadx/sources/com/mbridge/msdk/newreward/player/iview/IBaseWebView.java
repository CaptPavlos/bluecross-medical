package com.mbridge.msdk.newreward.player.iview;

import android.widget.ImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface IBaseWebView extends IBaseView {
    ImageView getPrivacyButton();

    MBWebView getWebView();

    void hideCTAView();

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000134", reportType = "1")
    void onCloseViewClick(int i10);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000135", reportType = "1")
    void onDestroyWebContent(int i10);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000133", reportType = "1")
    boolean onWebViewShow(int i10);

    void setNativeCloseButtonVisibility(int i10);

    void showCTAView(String str, CampaignEx campaignEx);

    void showMRAIDExpandView(String str, int i10);

    void showMiniCard();
}
