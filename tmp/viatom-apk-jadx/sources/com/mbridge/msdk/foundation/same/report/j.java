package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ab;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {
    public static JSONObject a(Context context, com.mbridge.msdk.c.g gVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String strL = ab.l();
            if (!TextUtils.isEmpty(strL)) {
                jSONObject.put("manufacturer", strL);
            }
            int iK = ab.k();
            if (iK != -1) {
                jSONObject.put("sdkint", iK);
            }
            String strN = ab.n(context);
            if (!TextUtils.isEmpty(strN)) {
                jSONObject.put("is24H", strN);
            }
            String strP = ab.p();
            if (!TextUtils.isEmpty(strP)) {
                jSONObject.put("totalram", strP);
            }
            String strO = ab.o(context);
            if (!TextUtils.isEmpty(strO)) {
                jSONObject.put("totalmemory", strO);
            }
            jSONObject.put("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
            jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? "1" : "0");
        }
        if (gVar.av() == 1 && !TextUtils.isEmpty(com.mbridge.msdk.foundation.tools.f.d()) && com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", com.mbridge.msdk.foundation.tools.f.d());
        }
        return jSONObject;
    }
}
