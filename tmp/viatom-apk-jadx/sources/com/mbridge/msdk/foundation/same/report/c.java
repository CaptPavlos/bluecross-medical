package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3797a = "c";

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            jSONObject.remove("model");
            jSONObject.remove("brand");
            jSONObject.remove("screen_size");
            jSONObject.remove("sub_ip");
            jSONObject.remove("network_type");
            jSONObject.remove("useragent");
            jSONObject.remove("ua");
            jSONObject.remove("language");
            jSONObject.remove("network_str");
            jSONObject.remove("mnc");
            jSONObject.remove("mcc");
            jSONObject.remove("os_version");
            jSONObject.remove("gp_version");
            jSONObject.remove("country_code");
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
            jSONObject.remove(com.mbridge.msdk.foundation.same.net.f.e.f3756a);
            jSONObject.remove(com.mbridge.msdk.foundation.same.net.f.e.f3757b);
            jSONObject.remove("power_rate");
            jSONObject.remove("charging");
            jSONObject.remove("timezone");
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return;
        }
        jSONObject.remove("gaid");
        jSONObject.remove("gaid2");
        jSONObject.remove("oaid");
        jSONObject.remove("az_aid_info");
    }

    public static com.mbridge.msdk.tracker.f b() {
        return new com.mbridge.msdk.tracker.f() { // from class: com.mbridge.msdk.foundation.same.report.c.1
            @Override // com.mbridge.msdk.tracker.f
            public final boolean a(com.mbridge.msdk.tracker.e eVar) throws Exception {
                return c.a(eVar);
            }
        };
    }

    public static com.mbridge.msdk.tracker.h c() {
        return new com.mbridge.msdk.tracker.h() { // from class: com.mbridge.msdk.foundation.same.report.c.2
            @Override // com.mbridge.msdk.tracker.h
            public final JSONObject a(com.mbridge.msdk.tracker.e eVar) throws JSONException {
                if (eVar == null) {
                    return null;
                }
                JSONObject jSONObjectD = eVar.d();
                if (jSONObjectD == null) {
                    jSONObjectD = new JSONObject();
                }
                try {
                    jSONObjectD.put("key", eVar.a());
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    int iM = ab.m(contextC);
                    if (!jSONObjectD.has("network_type")) {
                        jSONObjectD.put("network_type", iM);
                        jSONObjectD.put("network_str", ab.a(contextC, iM));
                    }
                    if (!jSONObjectD.has("st")) {
                        jSONObjectD.put("st", System.currentTimeMillis());
                    }
                    String strOptString = jSONObjectD.optString(MBridgeConstans.PROPERTIES_UNIT_ID, "");
                    if (!TextUtils.isEmpty(strOptString)) {
                        String str = com.mbridge.msdk.foundation.controller.a.f3352b.get(strOptString);
                        jSONObjectD.put("u_stid", str != null ? str : "");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && !jSONObjectD.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        jSONObjectD.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g) && !jSONObjectD.has("c")) {
                        jSONObjectD.put("c", com.mbridge.msdk.foundation.same.a.g);
                    }
                    return jSONObjectD;
                } catch (Exception e) {
                    af.b(c.f3797a, e.getMessage());
                    return jSONObjectD;
                }
            }
        };
    }

    public static JSONObject a() {
        return a.a();
    }

    public static /* synthetic */ boolean a(com.mbridge.msdk.tracker.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        String strA = eVar.a();
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        com.mbridge.msdk.c.g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(com.mbridge.msdk.c.h.a());
        if (gVarS == null) {
            return true;
        }
        return b.a(gVarS, strA);
    }
}
