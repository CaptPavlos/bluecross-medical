package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5678a = "com.mbridge.msdk.video.bt.module.b.f";

    public static void a(Context context, List<CampaignEx> list, String str, String str2) {
        if (context == null || list == null) {
            return;
        }
        try {
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000054");
                jSONObject.put("network_type", ab.m(context));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < list.size(); i10++) {
                    arrayList.add(list.get(i10).getId());
                }
                jSONObject.put("cid", arrayList);
                jSONObject.put("reason", str2);
                jSONObject.put("result", 1);
                jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                if (list.get(0) != null) {
                    CampaignEx campaignEx = list.get(0);
                    jSONObject.put("ad_type", campaignEx.getAdType());
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    jSONObject.put("templateshowtype", campaignEx.getMof_tplid());
                    jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            }
        } catch (Throwable th) {
            af.b(f5678a, th.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, int i10) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000054");
            jSONObject.put("network_type", ab.m(context));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put("reason", "");
            jSONObject.put("templateshowtype", i10 + " offer show success");
            jSONObject.put("result", 2);
            jSONObject.put("ad_type", campaignEx.getAdType() == 287 ? 3 : 1);
            String str2 = campaignEx.getendcard_url();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("creative", URLEncoder.encode(str2, C.UTF8_NAME));
            }
            jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f5678a, th.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i10) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000054");
                jSONObject.put("network_type", ab.m(context));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                jSONObject.put("cid", campaignEx.getId());
                jSONObject.put("reason", str2);
                jSONObject.put("templateshowtype", i10);
                jSONObject.put("result", 1);
                String str3 = campaignEx.getendcard_url();
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("creative", URLEncoder.encode(str3, C.UTF8_NAME));
                }
                jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                jSONObject.put("ad_type", campaignEx.getAdType() == 287 ? 3 : 1);
                jSONObject.put("rid", campaignEx.getRequestId());
                jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            }
        } catch (Throwable th) {
            af.b(f5678a, th.getMessage());
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.isEmpty() || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000054");
            jSONObject.put("network_type", ab.m(context));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                arrayList.add(list.get(i10).getId());
            }
            jSONObject.put("cid", arrayList);
            jSONObject.put("result", 2);
            if (list.get(0) != null) {
                CampaignEx campaignEx = list.get(0);
                jSONObject.put("reason", "");
                jSONObject.put("templateshowtype", "two offer ec show success");
                jSONObject.put("ad_type", campaignEx.getAdType());
                jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                jSONObject.put("rid", campaignEx.getRequestId());
                jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
            }
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f5678a, th.getMessage());
        }
    }

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                o oVarA = o.a(com.mbridge.msdk.foundation.db.g.a(context));
                if (TextUtils.isEmpty(str) || oVarA == null || oVarA.a() <= 0) {
                    return;
                }
                List<n> listA = oVarA.a("m_download_end");
                List<n> listA2 = oVarA.a("2000021");
                List<n> listA3 = oVarA.a("2000039");
                List<n> listA4 = oVarA.a("m_download_end");
                List<n> listA5 = oVarA.a("m_download_end");
                List<n> listA6 = oVarA.a("2000044");
                com.mbridge.msdk.foundation.same.report.n.e(listA2);
                com.mbridge.msdk.foundation.same.report.n.a(listA);
                com.mbridge.msdk.foundation.same.report.n.c(listA3);
                com.mbridge.msdk.foundation.same.report.n.b(listA4);
                com.mbridge.msdk.foundation.same.report.n.f(listA5);
                com.mbridge.msdk.foundation.same.report.n.d(listA6);
            } catch (Exception e) {
                af.b(f5678a, e.getMessage());
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i10) {
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            if (contextC == null || campaignEx == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000115");
            jSONObject.put("network_type", ab.m(contextC));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put("play_cur_time", i10);
            jSONObject.put("reason", "close ad in advance " + campaignEx.getMof_tplid());
            jSONObject.put("result", 1);
            jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
            jSONObject.put("ad_type", campaignEx.getAdType());
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f5678a, th.getMessage());
        }
    }
}
