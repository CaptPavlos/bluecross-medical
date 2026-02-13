package com.mbridge.msdk.foundation.same.net.f;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.z;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f3763a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f3764b = "";

    public static void a(e eVar, Context context, boolean z9, com.mbridge.msdk.c.g gVar) {
        if (eVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("dmt", ab.o() + "");
                jSONObject.put("dmf", ab.f());
                jSONObject.put("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
                jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? "1" : "0");
            }
            if (gVar.av() == 1 && !TextUtils.isEmpty(com.mbridge.msdk.foundation.tools.f.d()) && com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("az_aid_info", com.mbridge.msdk.foundation.tools.f.d());
            }
            if (TextUtils.isEmpty(jSONObject.toString())) {
                return;
            }
            if (!jSONObject.equals(f3764b)) {
                f3763a = z.b(jSONObject.toString());
            }
            if (TextUtils.isEmpty(f3763a)) {
                return;
            }
            eVar.a("dvi", f3763a);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonRequestParamsForAddDiff", e.getMessage());
            }
        }
    }

    public static void b(e eVar) {
    }

    public static void c(e eVar) {
    }

    public static void a(e eVar, Context context) {
    }

    public static void a(e eVar) {
    }
}
