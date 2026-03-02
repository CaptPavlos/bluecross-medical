package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f3863a = new Handler(Looper.getMainLooper());

    public static void a(com.mbridge.msdk.foundation.entity.n nVar, String str, CampaignEx campaignEx) {
        int adType;
        if (nVar != null) {
            nVar.j(com.mbridge.msdk.foundation.tools.f.c());
            if (campaignEx != null && ((adType = campaignEx.getAdType()) == 94 || adType == 287)) {
                com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("result", nVar.m());
                jSONObject.put(TypedValues.TransitionType.S_DURATION, nVar.n());
                jSONObject.put("cid", nVar.e());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("reason", nVar.h());
                jSONObject.put("ad_type", nVar.d());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("mraid_type", nVar.B());
                jSONObject.put("devid", nVar.j());
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, nVar.t());
                if (nVar.b() != null) {
                    jSONObject.put("resource_type", nVar.b());
                }
                if (!TextUtils.isEmpty(nVar.s())) {
                    jSONObject.put(CampaignEx.ENDCARD_URL, nVar.s());
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void b(com.mbridge.msdk.foundation.entity.n nVar, String str, CampaignEx campaignEx) {
        if (nVar != null) {
            nVar.a("2000059");
            nVar.c(str);
            nVar.a(ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
            nVar.j(com.mbridge.msdk.foundation.tools.f.c());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("result", nVar.m());
                jSONObject.put(TypedValues.TransitionType.S_DURATION, nVar.n());
                jSONObject.put("cid", nVar.e());
                jSONObject.put("reason", nVar.h());
                jSONObject.put("ad_type", nVar.d());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("devid", nVar.j());
                jSONObject.put("mraid_type", nVar.B());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put("rid", nVar.f());
                if (!TextUtils.isEmpty(nVar.s())) {
                    jSONObject.put(CampaignEx.ENDCARD_URL, nVar.s());
                }
                if (!TextUtils.isEmpty(nVar.t())) {
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, nVar.t());
                }
                if (nVar.b() != null) {
                    jSONObject.put("resource_type", nVar.b());
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void c(com.mbridge.msdk.foundation.entity.n nVar, Context context, String str) {
        if (nVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("reason", nVar.h());
                jSONObject.put("case", nVar.C());
                jSONObject.put("network_type", nVar.k());
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void d(com.mbridge.msdk.foundation.entity.n nVar, Context context, String str) {
        if (nVar != null) {
            nVar.a("2000060");
            nVar.c(str);
            nVar.a(ab.m(context));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("mraid_type", nVar.B());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put("rid", nVar.f());
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str, String str2, String str3) {
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("m_download_end", !TextUtils.isEmpty(campaignEx.getMraid()) ? 1 : 3, "0", "", campaignEx.getId(), str2, str, String.valueOf(campaignEx.getKeyIaRst()));
        nVar.e(campaignEx.getId());
        nVar.f(campaignEx.getRequestId());
        nVar.s(campaignEx.getCurrentLocalRid());
        nVar.g(campaignEx.getRequestIdNotice());
        nVar.c(campaignEx.getAdSpaceT());
        nVar.d(str3);
        nVar.e(7);
        nVar.a(ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
        nVar.d(campaignEx.isMraid() ? com.mbridge.msdk.foundation.entity.n.f3580a : com.mbridge.msdk.foundation.entity.n.f3581b);
        com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
    }

    public static void b(com.mbridge.msdk.foundation.entity.n nVar, Context context, String str) {
        if (nVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("mraid_type", nVar.B());
                jSONObject.put("platform", "1");
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }

    public static void a(com.mbridge.msdk.foundation.entity.n nVar, Context context, String str) {
        if (nVar != null) {
            nVar.a("2000063");
            nVar.c(str);
            nVar.a(ab.m(context));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", nVar.a());
                jSONObject.put("cid", nVar.e());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, nVar.c());
                jSONObject.put("network_type", nVar.k());
                jSONObject.put("rid", nVar.f());
                jSONObject.put("rid_n", nVar.g());
                jSONObject.put("reason", nVar.h());
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("VideoDataReport", th.getMessage());
            }
        }
    }
}
