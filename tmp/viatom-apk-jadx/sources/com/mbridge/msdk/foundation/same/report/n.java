package com.mbridge.msdk.foundation.same.report;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {
    public static void a(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (com.mbridge.msdk.foundation.entity.n nVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (nVar.b() != null) {
                    jSONObject.put("resource_type", nVar.b());
                }
                if (nVar.i() != null) {
                    jSONObject.put("creative", nVar.i());
                }
                jSONObject.put("key", nVar.a());
                jSONObject.put("result", nVar.m());
                jSONObject.put(TypedValues.TransitionType.S_DURATION, nVar.n());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, nVar.o());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, nVar.p());
                jSONObject.put("reason", nVar.h());
                jSONObject.put("cid", nVar.e());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, nVar.q());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("offer_url", nVar.r());
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", nVar.k());
                    jSONObject.put("network_str", nVar.l());
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void b(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (com.mbridge.msdk.foundation.entity.n nVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("result", nVar.m());
                jSONObject.put(TypedValues.TransitionType.S_DURATION, nVar.n());
                jSONObject.put(CampaignEx.ENDCARD_URL, nVar.s());
                jSONObject.put("cid", nVar.e());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("reason", nVar.h());
                jSONObject.put("ad_type", nVar.d());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, nVar.t());
                jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, nVar.u());
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void c(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                for (com.mbridge.msdk.foundation.entity.n nVar : list) {
                    if (nVar != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("key", nVar.a());
                            jSONObject.put(NotificationCompat.CATEGORY_EVENT, ak.a(nVar.v()));
                            jSONObject.put("template", ak.a(nVar.w()));
                            jSONObject.put(TtmlNode.TAG_LAYOUT, ak.a(nVar.x()));
                            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, ak.a(nVar.c()));
                            jSONObject.put("cid", ak.a(nVar.e()));
                            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                                jSONObject.put("network_str", nVar.l());
                                jSONObject.put("network_type", nVar.k());
                            }
                            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
                        } catch (Exception e) {
                            af.b("VideoDataReport", e.getMessage());
                        }
                    }
                }
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void d(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                for (com.mbridge.msdk.foundation.entity.n nVar : list) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", nVar.a());
                    jSONObject.put("cid", nVar.e());
                    jSONObject.put(CampaignEx.JSON_KEY_IMAGE_URL, nVar.y());
                    jSONObject.put("reason", nVar.h());
                    jSONObject.put("rid", nVar.f());
                    jSONObject.put("rid_n", nVar.g());
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                        jSONObject.put("network_type", nVar.k());
                    }
                    com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void e(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                for (com.mbridge.msdk.foundation.entity.n nVar : list) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", nVar.a());
                    jSONObject.put("reason", nVar.h());
                    jSONObject.put("cid", nVar.e());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, nVar.q());
                    jSONObject.put("rid", nVar.f());
                    jSONObject.put("rid_n", nVar.g());
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                    jSONObject.put("offer_url", nVar.r());
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                        jSONObject.put("network_type", nVar.k());
                        jSONObject.put("network_str", nVar.l());
                    }
                    com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static String f(List<com.mbridge.msdk.foundation.entity.n> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.isEmpty()) {
                return null;
            }
            for (com.mbridge.msdk.foundation.entity.n nVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put("template_url", nVar.D());
                jSONObject.put("reason", nVar.h());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("result", nVar.m());
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", nVar.k());
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            }
            return null;
        } catch (Throwable th) {
            af.b("VideoDataReport", th.getMessage());
            return null;
        }
    }

    public static void b(com.mbridge.msdk.foundation.entity.n nVar) throws JSONException {
        if (nVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, ak.a(nVar.E()));
                jSONObject.put("template_url", ak.a(nVar.D()));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, ak.a(nVar.c()));
                jSONObject.put("cid", ak.a(nVar.e()));
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_str", nVar.l());
                    jSONObject.put("network_type", nVar.k());
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Exception e) {
                af.b("VideoDataReport", e.getMessage());
            }
        }
    }

    public static String a(com.mbridge.msdk.foundation.entity.n nVar) throws JSONException {
        if (nVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, ak.a(nVar.v()));
                jSONObject.put("template", ak.a(nVar.w()));
                jSONObject.put(TtmlNode.TAG_LAYOUT, ak.a(nVar.x()));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, ak.a(nVar.c()));
                jSONObject.put("cid", ak.a(nVar.e()));
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_str", nVar.l());
                    jSONObject.put("network_type", nVar.k());
                }
                return jSONObject.toString();
            } catch (Exception e) {
                af.b("VideoDataReport", e.getMessage());
                return "";
            }
        }
        return "";
    }
}
