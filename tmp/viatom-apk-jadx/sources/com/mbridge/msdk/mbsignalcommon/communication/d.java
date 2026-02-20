package com.mbridge.msdk.mbsignalcommon.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4374a = "d";

    /* renamed from: b, reason: collision with root package name */
    public static int f4375b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f4376c = 1;

    public static void a(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            final CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject);
            if (campaignWithBackData == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.communication.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        j jVarA = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                        if (jVarA != null) {
                            if (jVarA.b(campaignWithBackData.getId())) {
                                jVarA.a(campaignWithBackData.getId());
                            } else {
                                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                                gVar.a(campaignWithBackData.getId());
                                gVar.b(campaignWithBackData.getFca());
                                gVar.c(campaignWithBackData.getFcb());
                                gVar.a(0);
                                gVar.d(1);
                                gVar.a(System.currentTimeMillis());
                                jVarA.a(gVar);
                            }
                        }
                        d.a(campaignWithBackData.getCampaignUnitId(), campaignWithBackData);
                    } catch (Throwable th) {
                        af.b(d.f4374a, th.getMessage(), th);
                    }
                }
            }).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", f4375b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject3);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e) {
                a(obj, e.getMessage());
                af.a(f4374a, e.getMessage());
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public static String a(float f, float f10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.h, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), f));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3605i, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), f10));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3609m, 0);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3607k, com.mbridge.msdk.foundation.controller.c.m().c().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3608l, ak.d(com.mbridge.msdk.foundation.controller.c.m().c()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f3606j, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            return Base64.encodeToString(string.getBytes(), 2);
        } catch (Throwable unused) {
            af.b(f4374a, "code to string is error");
            return "";
        }
    }

    public static void a(Object obj, String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f4376c);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            af.a(f4374a, e.getMessage());
        }
    }

    public static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (com.mbridge.msdk.foundation.same.a.b.f3625b == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.same.a.b.a(str, campaignEx, "banner");
    }
}
