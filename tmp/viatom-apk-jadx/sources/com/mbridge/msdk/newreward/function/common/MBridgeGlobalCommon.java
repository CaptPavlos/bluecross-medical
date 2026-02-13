package com.mbridge.msdk.newreward.function.common;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.video.bt.module.b.h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeGlobalCommon {
    public static String SESSION_ID = "";
    public static Map<String, h> showRewardListenerMap = new HashMap();

    public static String addQueryParameter(String str, String str2, String str3) throws UnsupportedEncodingException {
        if (str != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                String strEncode = URLEncoder.encode(str2, C.UTF8_NAME);
                String strEncode2 = URLEncoder.encode(str3, C.UTF8_NAME);
                StringBuilder sb = new StringBuilder(str);
                if (!str.contains("?")) {
                    sb.append("?");
                } else if (!str.endsWith("&") && !str.endsWith("?")) {
                    sb.append("&");
                }
                sb.append(strEncode);
                sb.append("=");
                sb.append(strEncode2);
                return sb.toString();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("MBridgeGlobalCommon", "addQueryParameter", e);
                }
            }
        }
        return "";
    }

    public static String getIsReadyNotReadyReasonType(b bVar) {
        if (bVar == null) {
            return "8";
        }
        d<?> dVarW = bVar.w();
        if (dVarW != null && !dVarW.d()) {
            return "4";
        }
        if (!bVar.A()) {
            return "10";
        }
        List<a> listU = bVar.u();
        if (listU == null || listU.isEmpty()) {
            return "8";
        }
        for (a aVar : listU) {
            if (aVar != null) {
                n nVarD = aVar.d();
                if (nVarD != null && !nVarD.d()) {
                    return "1";
                }
                d<?> dVarC = aVar.c();
                if (dVarC != null && !dVarC.d()) {
                    return "2";
                }
                d<?> dVarF = aVar.f();
                if (dVarF != null && !dVarF.d()) {
                    return "6";
                }
            }
        }
        return "0";
    }

    public static void handlerCampaigns(String str, b bVar, List<CampaignEx> list, List<a> list2) {
        if (bVar == null || list == null || list2 == null) {
            return;
        }
        for (CampaignEx campaignEx : list) {
            try {
                campaignEx.setRequestId(bVar.f());
                campaignEx.setLocalRequestId(str);
                campaignEx.setCampaignUnitId(bVar.e());
                a aVar = new a(bVar);
                aVar.c(campaignEx.getRequestIdNotice());
                aVar.b(campaignEx.getAppName());
                aVar.a(campaignEx.getId());
                aVar.a(campaignEx);
                list2.add(aVar);
                if (!com.mbridge.msdk.foundation.same.b.a().a("new_bridge_reward_show") && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) && campaignEx.getAdSpaceT() != 2) {
                    String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
                    boolean zI = ak.i(cMPTEntryUrl);
                    bVar.b(!zI);
                    if (!zI) {
                        cMPTEntryUrl = addQueryParameter(cMPTEntryUrl, "dyview", MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE);
                    }
                    campaignEx.setCMPTEntryUrl(cMPTEntryUrl);
                }
                if (TextUtils.isEmpty(bVar.B())) {
                    bVar.h(campaignEx.getCMPTEntryUrl());
                    bVar.h(campaignEx.getMof_tplid());
                }
                long candidateCacheTime = campaignEx.getCandidateCacheTime();
                if (candidateCacheTime > 0) {
                    bVar.b((candidateCacheTime * 1000) + System.currentTimeMillis());
                }
                bVar.j(campaignEx.getVcn());
                bVar.k(campaignEx.getTokenRule());
                CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                if (!com.mbridge.msdk.foundation.same.b.a().a("new_bridge_reward_show")) {
                    if (rewardTemplateMode != null) {
                        bVar.i(rewardTemplateMode.b());
                        String strE = rewardTemplateMode.e();
                        if (!TextUtils.isEmpty(strE) && campaignEx.getAdSpaceT() != 2) {
                            boolean zI2 = ak.i(strE);
                            aVar.a(!zI2);
                            if (!zI2) {
                                strE = addQueryParameter(strE, "dyview", MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE);
                            }
                            rewardTemplateMode.b(strE);
                            campaignEx.setRewardTemplateMode(rewardTemplateMode);
                        }
                    }
                    String str2 = campaignEx.getendcard_url();
                    if (!TextUtils.isEmpty(str2)) {
                        boolean zL = ak.l(str2);
                        boolean zI3 = ak.i(str2);
                        if (!zL && !zI3) {
                            campaignEx.setendcard_url(addQueryParameter(str2, "isplayableec", "0"));
                        }
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("MBridgeGlobalCommon", "handlerCampaigns", e);
                }
            }
        }
        bVar.b(list);
        bVar.a(list2);
    }

    public static void setAlertDialogText(String str, String str2, String str3, String str4, String str5) {
        Context contextC = c.m().c();
        if (!TextUtils.isEmpty(str2)) {
            an.b(contextC, a3.a.i("MBridge_ConfirmTitle", str), str2.trim());
        }
        if (!TextUtils.isEmpty(str3)) {
            an.b(contextC, a3.a.i("MBridge_ConfirmContent", str), str3.trim());
        }
        if (!TextUtils.isEmpty(str5)) {
            an.b(contextC, a3.a.i("MBridge_CancelText", str), str5.trim());
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        an.b(contextC, a3.a.i("MBridge_ConfirmText", str), str4.trim());
    }
}
