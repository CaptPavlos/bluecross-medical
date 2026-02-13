package com.mbridge.msdk.newreward.function.h;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.i;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {
    public static CampaignEx a(String str, CampaignEx campaignEx) {
        JSONObject jSONObjectCampaignToJsonObject;
        String strValueOf;
        String strValueOf2;
        if (!TextUtils.isEmpty(str)) {
            CampaignEx campaignWithBackData = null;
            if (campaignEx != null) {
                try {
                    jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                } catch (Throwable th) {
                    af.b("HybridCommunicatorUtil", th.getMessage());
                    return campaignEx;
                }
            } else {
                jSONObjectCampaignToJsonObject = null;
            }
            if (jSONObjectCampaignToJsonObject != null) {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_NOTICE_URL);
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = campaignEx.getNoticeUrl();
                }
                String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_CLICK_URL);
                if (TextUtils.isEmpty(strOptString2)) {
                    strOptString2 = campaignEx.getClickURL();
                }
                if (str.contains("notice")) {
                    if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        jSONObjectCampaignToJsonObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                    if (jSONObject.opt("akdlui") == null) {
                        jSONObjectCampaignToJsonObject.put("akdlui", "");
                    }
                } else {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.mbridge.msdk.foundation.same.a.f3606j);
                    if (jSONObjectOptJSONObject != null) {
                        strValueOf = String.valueOf(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), Integer.parseInt(jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.h))));
                        strValueOf2 = String.valueOf(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), Integer.parseInt(jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f3605i))));
                    } else {
                        strValueOf = "-999";
                        strValueOf2 = "-999";
                    }
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        StringBuilder sb = new StringBuilder();
                        while (itKeys.hasNext()) {
                            sb.append("&");
                            String next = itKeys.next();
                            String strOptString3 = jSONObjectOptJSONObject.optString(next);
                            if (com.mbridge.msdk.foundation.same.a.h.equals(next) || com.mbridge.msdk.foundation.same.a.f3605i.equals(next)) {
                                strOptString3 = String.valueOf(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), Integer.parseInt(strOptString3)));
                            }
                            sb.append(next);
                            sb.append("=");
                            sb.append(strOptString3);
                        }
                        strOptString = strOptString + ((Object) sb);
                    }
                    strOptString2 = com.mbridge.msdk.click.c.a(campaignEx.getClickURL(), strValueOf, strValueOf2);
                }
                Iterator<String> itKeys2 = jSONObject.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    jSONObjectCampaignToJsonObject.put(next2, jSONObject.getString(next2));
                }
                if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
                    jSONObjectCampaignToJsonObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, campaignEx.getCampaignUnitId());
                }
                jSONObjectCampaignToJsonObject.put(CampaignEx.JSON_KEY_CLICK_URL, strOptString2);
                jSONObjectCampaignToJsonObject.put(CampaignEx.JSON_KEY_NOTICE_URL, strOptString);
                campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject);
            }
            if (campaignWithBackData != null) {
                return campaignWithBackData;
            }
        }
        return campaignEx;
    }

    public static String a(String str, List<CampaignEx> list, boolean z9, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sdk_info", "MAL_16.8.61,3.0.1");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("isRootTemplateWebView", false);
            jSONObject2.put("playVideoMute", i10);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", new i(com.mbridge.msdk.foundation.controller.c.m().c()).a());
            JSONArray jSONArray = new JSONArray();
            if (list != null && !list.isEmpty()) {
                for (CampaignEx campaignEx : list) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(campaignEx, campaignEx.isReady(), a(campaignEx)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            String strG = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                JSONObject jSONObject3 = new JSONObject(strG);
                String strC = h.a().c(str);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject3.put("ivreward", new JSONObject(strC));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", com.mbridge.msdk.videocommon.d.b.a().b().k());
            jSONObject.put("unitSetting", com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str).E());
            jSONObject.put("rw_plus", z9 ? "1" : "0");
        } catch (Throwable th) {
            af.b("HybridCommunicatorUtil", th.getMessage());
        }
        return jSONObject.toString();
    }

    private static boolean a(CampaignEx campaignEx) {
        g gVarB;
        try {
            String strK = com.mbridge.msdk.foundation.controller.c.m().k();
            long jAd = (TextUtils.isEmpty(strK) || (gVarB = h.a().b(strK)) == null) ? 0L : gVarB.ad() * 1000;
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            long jF = aVarB != null ? aVarB.f() : 0L;
            if (campaignEx != null) {
                return campaignEx.isSpareOffer(jF, jAd);
            }
            return false;
        } catch (Exception e) {
            af.b("HybridCommunicatorUtil", e.getMessage());
            return false;
        }
    }

    public static String a(int i10) {
        String string = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : string;
        } catch (Throwable th) {
            af.b("HybridCommunicatorUtil", th.getMessage());
            return string;
        }
    }

    public static String a(float f, float f10, int i10) {
        int i11;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.h, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), f));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3605i, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), f10));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3609m, i10);
            try {
                i11 = com.mbridge.msdk.foundation.controller.c.m().c().getResources().getConfiguration().orientation;
            } catch (Throwable th) {
                af.b("HybridCommunicatorUtil", th.getMessage());
                i11 = 1;
            }
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3607k, i11);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3608l, ak.d(com.mbridge.msdk.foundation.controller.c.m().c()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f3606j, jSONObject2);
        } catch (Throwable th2) {
            af.b("HybridCommunicatorUtil", th2.getMessage());
        }
        return jSONObject.toString();
    }
}
