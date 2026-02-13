package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBConfiguration;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class i extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3872a = "i";

    public static com.mbridge.msdk.foundation.same.net.f.e a(Context context) {
        String str = "1";
        com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e();
        try {
            eVar.a("platform", "1");
            eVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, URLEncoder.encode(ab.f(context)));
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                eVar.a("os_version", Build.VERSION.RELEASE);
                eVar.a("brand", URLEncoder.encode(ab.x()));
                eVar.a("model", URLEncoder.encode(ab.h()));
                if (com.mbridge.msdk.e.b.a()) {
                    eVar.a("gaid", "");
                } else {
                    eVar.a("gaid", com.mbridge.msdk.foundation.tools.f.c());
                }
                eVar.a("mnc", ab.l(context));
                eVar.a("mcc", ab.k(context));
                int iM = ab.m(context);
                eVar.a("network_type", iM + "");
                eVar.a("network_str", ab.a(context, iM));
                eVar.a("language", URLEncoder.encode(ab.t(context)));
                eVar.a("timezone", URLEncoder.encode(ab.y()));
                eVar.a("ua", URLEncoder.encode(ab.g()));
                eVar.a("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
                if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.b()) {
                    str = "0";
                }
                eVar.a("adid_limit_dev", str);
            }
            eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            eVar.a("app_version_name", URLEncoder.encode(ab.q(context)));
            eVar.a("orientation", URLEncoder.encode(ab.s(context) + ""));
            eVar.a("screen_size", ab.j(context) + "x" + ab.h(context));
            if (com.mbridge.msdk.e.b.a()) {
                com.mbridge.msdk.foundation.same.net.f.f.b(eVar);
            }
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            if (gVarB != null) {
                JSONObject jSONObjectA = j.a(context, gVarB);
                if (!TextUtils.isEmpty(jSONObjectA.toString())) {
                    String strB = z.b(jSONObjectA.toString());
                    if (!TextUtils.isEmpty(strB)) {
                        eVar.a("dvi", strB);
                        return eVar;
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static void b(Context context, CampaignEx campaignEx, String str, String str2) {
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
            jSONObject.put("result", 2);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("insertStr", str2);
            }
            if (campaignEx.getAdType() == 287) {
                jSONObject.put("creative", campaignEx.getendcard_url());
                jSONObject.put("ad_type", 3);
            } else if (campaignEx.getAdType() == 94) {
                jSONObject.put("creative", campaignEx.getendcard_url());
                jSONObject.put("ad_type", 1);
            } else if (campaignEx.getAdType() == 296) {
                jSONObject.put("ad_type", 5);
                jSONObject.put("creative", campaignEx.getCreativeId());
            } else if (campaignEx.getAdType() == 297) {
                jSONObject.put("ad_type", 6);
                jSONObject.put("creative", campaignEx.getCreativeId());
            } else if (campaignEx.getAdType() == 298) {
                jSONObject.put("ad_type", 7);
                jSONObject.put("creative", campaignEx.getCreativeId());
            } else {
                jSONObject.put("creative", campaignEx.getendcard_url());
                jSONObject.put("ad_type", 1);
            }
            jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
            if (campaignEx.isBidCampaign()) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, "1");
            }
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void c() {
        try {
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    String[] list;
                    try {
                        String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO);
                        if (TextUtils.isEmpty(strA)) {
                            return;
                        }
                        File file = new File(strA);
                        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
                            for (String str : list) {
                                File file2 = new File(strA + "/" + str);
                                if (file2.exists()) {
                                    String strB = ad.b(file2);
                                    if (!TextUtils.isEmpty(strB)) {
                                        String[] strArrSplit = strB.split("====");
                                        if (strArrSplit.length > 0) {
                                            new h(com.mbridge.msdk.foundation.controller.c.m().c()).a(strArrSplit[0], file2);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        af.b(i.f3872a, th.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void b() {
        try {
            an.b(com.mbridge.msdk.foundation.controller.c.m().c(), "privateAuthorityTimesTamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void b(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000090");
            jSONObject.put("reason", TextUtils.isEmpty(str) ? "" : str);
            jSONObject.put("result", str);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Exception e) {
            af.b(f3872a, e.getMessage());
        }
    }

    public static JSONObject a(Campaign campaign, int i10, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "adtrack");
            jSONObject.put("action", str);
            jSONObject.put("label", i10);
            if (campaign == null) {
                jSONObject.put("value", "");
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", campaign.getId());
            jSONObject2.put(CampaignEx.JSON_KEY_TITLE, campaign.getAppName());
            jSONObject.put("value", jSONObject2);
            return jSONObject;
        } catch (Exception e) {
            af.b(f3872a, e.getMessage());
            return jSONObject;
        }
    }

    public static boolean a() {
        try {
            return System.currentTimeMillis() - 86400000 > ((Long) an.a(com.mbridge.msdk.foundation.controller.c.m().c(), "privateAuthorityTimesTamp", 0L)).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static JSONObject a(Context context, com.mbridge.msdk.c.g gVar) throws Exception {
        return j.a(context, gVar);
    }

    public static JSONObject a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", str);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            return jSONObject;
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
            return null;
        }
    }

    public static void a(Context context, String str, String str2, int i10, String str3) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000076");
                jSONObject.put("network_type", ab.m(context));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                jSONObject.put("reason", str3);
                jSONObject.put("result", i10);
                jSONObject.put("url", str);
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b(f3872a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i10, String str3, int i11) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000073");
            jSONObject.put("network_type", ab.m(context));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put("reason", str3);
            jSONObject.put("result", i10);
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            if (i11 != -1) {
                jSONObject.put("d_t", i11);
            }
            jSONObject.put("url", str);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i10, int i11, int i12) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000075");
            jSONObject.put("network_type", ab.m(context));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i10);
            jSONObject.put("adtp", campaignEx.getAdType());
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i11);
            if (i12 != -1) {
                jSONObject.put("d_t", i12);
            }
            jSONObject.put("url", str);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i10, int i11) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000074");
            jSONObject.put("network_type", ab.m(context));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i10);
            jSONObject.put("adtp", campaignEx.getAdType());
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            if (i11 != -1) {
                jSONObject.put("d_t", i11);
            }
            jSONObject.put("url", str);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, boolean z9, CampaignEx campaignEx) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000047");
                if (!TextUtils.isEmpty(str2)) {
                    String str3 = com.mbridge.msdk.foundation.controller.a.f3352b.get(str2);
                    if (str3 == null) {
                        str3 = "";
                    }
                    jSONObject.put("u_stid", str3);
                }
                if (campaignEx != null) {
                    jSONObject.put("cid", campaignEx.getId());
                    jSONObject.put("adtp", campaignEx.getAdType());
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                }
                jSONObject.put("st", System.currentTimeMillis());
                jSONObject.put("network_type", ab.m(context));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                jSONObject.put(CampaignEx.JSON_KEY_HB, z9 ? 1 : 0);
                jSONObject.put("reason", str);
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b(f3872a, th.getMessage());
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, boolean z9) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.isEmpty() || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000048");
            jSONObject.put("st", System.currentTimeMillis());
            jSONObject.put("network_type", ab.m(context));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put(CampaignEx.JSON_KEY_HB, z9 ? 1 : 0);
            CampaignEx campaignEx = list.get(0);
            if (campaignEx != null) {
                jSONObject.put("cid", campaignEx.getId());
                jSONObject.put("rid", campaignEx.getRequestId());
                jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            }
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < list.size(); i10++) {
                CampaignEx campaignEx2 = list.get(i10);
                if (i10 < list.size() - 1) {
                    sb.append(campaignEx2.getRtinsType());
                    sb.append(",");
                } else {
                    sb.append(campaignEx2.getRtinsType());
                }
            }
            jSONObject.put(CampaignEx.JSON_KEY_RETARGET_TYPE, sb.toString());
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, boolean z9, String str3, String str4, String str5, String str6) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000104");
                if (!TextUtils.isEmpty(str2)) {
                    String str7 = com.mbridge.msdk.foundation.controller.a.f3352b.get(str2);
                    if (str7 == null) {
                        str7 = "";
                    }
                    jSONObject.put("u_stid", str7);
                }
                jSONObject.put("network_type", ab.m(context));
                jSONObject.put("rid", str3);
                jSONObject.put("rid_n", str4);
                jSONObject.put("cid", str5);
                jSONObject.put("template_id", str6);
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                jSONObject.put(CampaignEx.JSON_KEY_HB, z9 ? 1 : 0);
                jSONObject.put("reason", str);
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b(f3872a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000054");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    jSONObject.put("reason", str2);
                    jSONObject.put("result", 1);
                    jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                    if (campaignEx != null) {
                        jSONObject.put("cid", campaignEx.getId());
                        if (campaignEx.getAdType() == 287) {
                            jSONObject.put("creative", campaignEx.getendcard_url());
                            jSONObject.put("ad_type", 3);
                        } else if (campaignEx.getAdType() == 94) {
                            jSONObject.put("creative", campaignEx.getendcard_url());
                            jSONObject.put("ad_type", 1);
                        } else if (campaignEx.getAdType() == 296) {
                            jSONObject.put("ad_type", 5);
                            jSONObject.put("creative", campaignEx.getCreativeId());
                        } else if (campaignEx.getAdType() == 297) {
                            jSONObject.put("ad_type", 6);
                            jSONObject.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getCreativeId());
                            jSONObject.put(CampaignEx.JSON_KEY_AD_ZIP, campaignEx.getAdZip());
                        } else if (campaignEx.getAdType() == 298) {
                            jSONObject.put("ad_type", 7);
                            jSONObject.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getCreativeId());
                            jSONObject.put(CampaignEx.JSON_KEY_AD_ZIP, campaignEx.getAdZip());
                        } else {
                            jSONObject.put("creative", campaignEx.getendcard_url());
                            jSONObject.put("ad_type", 1);
                        }
                        jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                        if (campaignEx.isBidCampaign()) {
                            jSONObject.put(CampaignEx.JSON_KEY_HB, "1");
                        }
                        jSONObject.put("rid", campaignEx.getRequestId());
                        jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                        jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                    }
                    com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f3872a, th.getMessage());
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i10, int i11, String str2, int i12, int i13, int i14, String str3) {
        com.mbridge.msdk.foundation.same.report.d.c cVar;
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", URLEncoder.encode("2000094", "utf-8"));
            if (campaignEx != null) {
                eVar.a("rid", URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
                eVar.a("rid_n", URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
                eVar.a("cid", URLEncoder.encode(campaignEx.getId(), "utf-8"));
                cVar = com.mbridge.msdk.foundation.same.report.d.d.a().a(campaignEx.getCurrentLocalRid(), "");
            } else {
                cVar = null;
            }
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str, "utf-8"));
            if (i10 == 0) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "0";
                }
                eVar.a("video_prg", str3 + "");
            } else {
                eVar.a("video_prg", i10 + "");
            }
            eVar.a(TypedValues.CycleType.S_WAVE_PHASE, i11 + "");
            eVar.a("feedback_content", URLEncoder.encode(str2, "utf-8"));
            eVar.a("feedback_close", i12 + "");
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i14 + "");
            eVar.a("ad_type", i13 + "");
            eVar.a("network_type", URLEncoder.encode(String.valueOf(ab.m(com.mbridge.msdk.foundation.controller.c.m().c())), "utf-8"));
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            cVar.d(str);
            cVar.b(i13);
            cVar.a("2000094", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000094", cVar);
        } catch (Exception e) {
            af.b(f3872a, e.getMessage());
        }
    }

    public static void a(String str) {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000088");
            jSONObject.put(MRAIDCommunicatorUtil.KEY_STATE, str);
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null || b.a(gVarB, jSONObject.toString())) {
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            }
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i10, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000114");
            jSONObject.put("network_type", ab.m(context));
            jSONObject.put(DomainCampaignEx.KEY_GH_ID, TextUtils.isEmpty(campaignEx.getGhId()) ? "" : campaignEx.getGhId());
            jSONObject.put(DomainCampaignEx.KEY_GH_PATH, TextUtils.isEmpty(campaignEx.getGhPath()) ? "" : campaignEx.getGhPath());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put("result", i10);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("reason", str);
            jSONObject.put("cid", campaignEx.getId());
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }

    public static void a(int i10, String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000080");
            jSONObject.put("ad_type", i10);
            jSONObject.put("url", str);
            jSONObject.put("reason", str2);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Exception e) {
            af.b(f3872a, e.getMessage());
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i10, int i11, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000121");
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i10);
            jSONObject.put("result", i11);
            jSONObject.put("reason", str2);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Exception e) {
            af.b(f3872a, e.getMessage());
        }
    }

    public static void a(String str, int i10, int i11, String str2, int i12, String str3) {
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", URLEncoder.encode("m_water_mark_result", "utf-8"));
            eVar.a("water_mark_result", i11 + "");
            eVar.a("water_mark_error_msg", URLEncoder.encode(str2, "utf-8"));
            eVar.a("render_result", i12 + "");
            eVar.a("water_mark_str", URLEncoder.encode(str3, "utf-8"));
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.b(i10);
            cVar.d(str);
            cVar.a("m_water_mark_result", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("m_water_mark_result", cVar);
        } catch (Throwable th) {
            af.b(f3872a, th.getMessage());
        }
    }
}
