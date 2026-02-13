package com.mbridge.msdk.video.dynview.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.out.Campaign;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5722a = "com.mbridge.msdk.video.dynview.f.a";

    public static void a(CampaignUnit campaignUnit, int i10, int i11, String str) {
        int i12;
        String impressionURL;
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0 || campaignUnit.getAds().get(i10) == null) {
            return;
        }
        if (i11 == 0 && campaignUnit.getAds().get(i10).mMoreOfferImpShow) {
            return;
        }
        String strA = aq.a(campaignUnit.getAds().get(i10).getendcard_url(), "mof_testuid");
        if (TextUtils.isEmpty(strA)) {
            strA = aq.a(campaignUnit.getAds().get(i10).getendcard_url(), "mof_uid");
        }
        String str2 = TextUtils.isEmpty(strA) ? str : strA;
        if (i11 == 0) {
            i12 = com.mbridge.msdk.click.a.a.g;
            impressionURL = campaignUnit.getAds().get(i10).getImpressionURL();
        } else if (i11 != 1) {
            impressionURL = "";
            i12 = 0;
        } else {
            i12 = com.mbridge.msdk.click.a.a.h;
            impressionURL = campaignUnit.getAds().get(i10).getOnlyImpressionURL();
        }
        String str3 = impressionURL;
        int i13 = i12;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        com.mbridge.msdk.click.a.a(c.m().c(), campaignUnit.getAds().get(i10), str2, str3, false, true, i13);
    }

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000091");
                jSONObject.put("network_type", ab.m(context));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                    jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                    jSONObject.put("c", com.mbridge.msdk.foundation.same.a.g);
                }
                jSONObject.put(CampaignEx.JSON_KEY_HB, 0);
                jSONObject.put("rid_n", str3);
                jSONObject.put("reason", str);
                if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                    jSONObject.put("dyview", ak.b(campaignEx.getRewardTemplateMode().e()));
                }
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b(f5722a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, View view) {
        Context context2;
        CampaignEx campaignEx2;
        if (context == null || campaignEx == null) {
            return;
        }
        if (campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
            context2 = context;
            campaignEx2 = campaignEx;
        } else {
            context2 = context;
            campaignEx2 = campaignEx;
            com.mbridge.msdk.click.a.a(context2, campaignEx2, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
        }
        com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(context2, str);
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup) view;
            aVar.a(new i() { // from class: com.mbridge.msdk.video.dynview.f.a.1
                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onFinishRedirection(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    aj.a(campaign, viewGroup);
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onRedirectionFailed(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    aj.a(campaign, viewGroup);
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onStartRedirection(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    aj.b(campaign, viewGroup);
                }
            });
        }
        aVar.a(campaignEx2);
    }
}
