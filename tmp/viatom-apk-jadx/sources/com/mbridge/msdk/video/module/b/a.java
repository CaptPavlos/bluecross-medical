package com.mbridge.msdk.video.module.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.aq;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    public static void a(String str, CampaignEx campaignEx, e eVar) {
        String strA;
        String strA2;
        if (TextUtils.isEmpty(str) || campaignEx == null || eVar == null) {
            return;
        }
        try {
            String mof_template_url = campaignEx.getMof_template_url();
            String strA3 = "";
            if (TextUtils.isEmpty(mof_template_url)) {
                strA = "";
                strA2 = strA;
            } else {
                strA2 = aq.a(mof_template_url, "cltp");
                strA = aq.a(mof_template_url, "xt");
            }
            if (!TextUtils.isEmpty(strA2)) {
                eVar.a("cltp", strA2);
            }
            if (!TextUtils.isEmpty(strA)) {
                eVar.a("xt", strA);
            }
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                String strE = rewardTemplateMode.e();
                if (!TextUtils.isEmpty(strE)) {
                    strA3 = aq.a(strE, "alecfc");
                }
            }
            if (!TextUtils.isEmpty(strA3)) {
                eVar.a("alecfc", strA3);
            }
            d.a().a(str, campaignEx, eVar);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
