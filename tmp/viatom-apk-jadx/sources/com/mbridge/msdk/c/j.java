package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2724a = "j";

    private void a(Context context, String str, String str2, String str3, com.mbridge.msdk.foundation.same.net.f.d dVar) {
        if (context == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e();
        eVar.a(MBridgeConstans.APP_ID, str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        try {
            String strAy = h.a().a(str).ay();
            if (TextUtils.isEmpty(strAy)) {
                strAy = "";
            }
            eVar.a("vtag", strAy);
        } catch (Throwable th) {
            af.b(f2724a, th.getMessage());
        }
        if (com.mbridge.msdk.foundation.same.net.e.d.f().f3746q) {
            eVar.a("st_net", com.mbridge.msdk.foundation.same.net.e.d.f().f3748s + "");
        }
        eVar.a("only_p_info", str3);
        com.mbridge.msdk.c.a.c cVar = new com.mbridge.msdk.c.a.c(context);
        String strConcat = com.mbridge.msdk.foundation.same.net.e.d.f().G;
        try {
            if (com.mbridge.msdk.foundation.same.net.e.d.f().f3747r && com.mbridge.msdk.foundation.same.net.e.d.f().f3746q && com.mbridge.msdk.foundation.same.net.e.d.f().f3750v < com.mbridge.msdk.foundation.same.net.e.d.f().f3751w.size()) {
                String str4 = com.mbridge.msdk.foundation.same.net.e.d.f().f3751w.get(com.mbridge.msdk.foundation.same.net.e.d.f().f3750v);
                if (!TextUtils.isEmpty(str4) && (str4.startsWith("http") || str4.startsWith("https"))) {
                    strConcat = str4.concat("/setting");
                }
            }
        } catch (Throwable th2) {
            af.b(f2724a, th2.getMessage());
        }
        cVar.get(1, strConcat, eVar, dVar, "setting", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
    }

    private String b() {
        String str = com.mbridge.msdk.foundation.same.net.e.d.f().f3747r ? com.mbridge.msdk.foundation.same.net.e.d.f().H : com.mbridge.msdk.foundation.same.net.e.d.f().G;
        try {
            if (com.mbridge.msdk.foundation.same.net.e.d.f().f3747r && com.mbridge.msdk.foundation.same.net.e.d.f().f3746q && com.mbridge.msdk.foundation.same.net.e.d.f().f3750v < com.mbridge.msdk.foundation.same.net.e.d.f().f3751w.size()) {
                String str2 = com.mbridge.msdk.foundation.same.net.e.d.f().f3751w.get(com.mbridge.msdk.foundation.same.net.e.d.f().f3750v);
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.startsWith("http")) {
                        if (str2.startsWith("https")) {
                        }
                    }
                    return str2.concat("/setting");
                }
            }
            return str;
        } catch (Throwable th) {
            af.b(f2724a, th.getMessage());
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Context context, final String str, final String str2) {
        if (com.mbridge.msdk.foundation.same.net.e.d.f().a()) {
            b(context, str, str2);
            return;
        }
        try {
            if (com.mbridge.msdk.foundation.same.net.e.d.f().f3746q) {
                return;
            }
            com.mbridge.msdk.foundation.same.net.e.d.f().f3746q = true;
            if (System.currentTimeMillis() >= com.mbridge.msdk.foundation.a.a.a.a().b("mkey_spare_host_ts").longValue() + 86400000) {
                String strA = com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host");
                if (!TextUtils.isEmpty(strA)) {
                    for (String str3 : strA.split("\n")) {
                        if (!TextUtils.isEmpty(str3.trim()) && !com.mbridge.msdk.foundation.same.net.e.d.f().t.contains(str3.trim())) {
                            com.mbridge.msdk.foundation.same.net.e.d.f().t.add(str3.trim());
                            com.mbridge.msdk.foundation.same.net.e.d.f().f3751w.add(str3.trim());
                        }
                    }
                    c(context, str, str2);
                    return;
                }
            }
            new com.mbridge.msdk.foundation.same.net.f.c(context.getApplicationContext()).get(0, com.mbridge.msdk.foundation.same.net.e.d.f().f3735b, new com.mbridge.msdk.foundation.same.net.f.e(), new com.mbridge.msdk.foundation.same.net.b.a() { // from class: com.mbridge.msdk.c.j.3
                @Override // com.mbridge.msdk.foundation.same.net.b.a
                public final void a(String str4) {
                    com.mbridge.msdk.foundation.same.net.e.d.f().f3746q = false;
                    androidx.constraintlayout.core.widgets.analyzer.a.E("fetch CNDSettingHost failed, errorCode = ", str4, j.f2724a);
                }

                @Override // com.mbridge.msdk.foundation.same.net.b.a
                public final void b(String str4) {
                    af.a(j.f2724a, "fetch CNDSettingHost success, content = " + str4);
                    if (TextUtils.isEmpty(str4)) {
                        return;
                    }
                    com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts", System.currentTimeMillis());
                    com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host", str4);
                    for (String str5 : str4.split("\n")) {
                        if (!TextUtils.isEmpty(str5.trim()) && !com.mbridge.msdk.foundation.same.net.e.d.f().t.contains(str5.trim())) {
                            com.mbridge.msdk.foundation.same.net.e.d.f().t.add(str5.trim());
                            com.mbridge.msdk.foundation.same.net.e.d.f().f3751w.add(str5.trim());
                        }
                    }
                    j.this.c(context, str, str2);
                }
            }, "setting", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        } catch (Throwable th) {
            com.mbridge.msdk.foundation.same.net.e.d.f().f3746q = false;
            af.b(f2724a, th.getMessage());
        }
    }

    public final void b(final Context context, final String str, final String str2) {
        if (context == null) {
            return;
        }
        a(context, str, str2, "0", new com.mbridge.msdk.foundation.same.net.f.d() { // from class: com.mbridge.msdk.c.j.2
            @Override // com.mbridge.msdk.foundation.same.net.f.d
            public final void a(JSONObject jSONObject) throws JSONException {
                try {
                    j.this.a(1, 0, "");
                } catch (Throwable th) {
                    af.b(j.f2724a, th.getMessage());
                }
                try {
                    if (ak.a(jSONObject)) {
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String strG = h.a().g(str);
                            if (!TextUtils.isEmpty(strG)) {
                                try {
                                    jSONObject = h.a().a(new JSONObject(strG), jSONObject);
                                } catch (Exception e) {
                                    af.b(j.f2724a, e.getMessage());
                                }
                            }
                        }
                        jSONObject.put("current_time", System.currentTimeMillis());
                        if (com.mbridge.msdk.foundation.same.net.e.d.f().f3747r) {
                            if (TextUtils.isEmpty(jSONObject.optString("hst_st_t"))) {
                                jSONObject.put("hst_st_t", com.mbridge.msdk.foundation.same.net.e.d.f().f3741l);
                            }
                        } else if (TextUtils.isEmpty(jSONObject.optString("hst_st"))) {
                            jSONObject.put("hst_st", com.mbridge.msdk.foundation.same.net.e.d.f().h);
                        }
                        h.a().g(str, jSONObject.toString());
                        com.mbridge.msdk.foundation.same.net.e.d.f().e();
                        try {
                            if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                                com.mbridge.msdk.c.b.a.a().a(context, jSONObject.optString("mraid_js"));
                            }
                        } catch (Exception e3) {
                            af.b(j.f2724a, e3.getMessage());
                        }
                        if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                            com.mbridge.msdk.c.b.b.a().a(context, jSONObject.optString("web_env_url"));
                        }
                        j.a(j.this, context, str);
                    } else {
                        h.a().f(str);
                    }
                    j.a(j.this);
                } catch (Exception e7) {
                    af.b(j.f2724a, e7.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.f.d
            public final void a(String str3) {
                try {
                    j.this.a(2, 0, str3);
                } catch (Throwable th) {
                    af.b(j.f2724a, th.getMessage());
                }
                if (!com.mbridge.msdk.foundation.same.net.e.d.f().f3747r) {
                    com.mbridge.msdk.foundation.same.net.e.d.f().f3749u++;
                } else {
                    com.mbridge.msdk.foundation.same.net.e.d.f().f3750v++;
                }
                j.this.c(context, str, str2);
                j.a(j.this);
                af.b(j.f2724a, "get app setting error" + str3);
            }
        });
        a(3, 0, "");
    }

    public final void a(Context context, String str, String str2) {
        a(context, str, str2, "1", new com.mbridge.msdk.foundation.same.net.f.d() { // from class: com.mbridge.msdk.c.j.1
            @Override // com.mbridge.msdk.foundation.same.net.f.d
            public final void a(JSONObject jSONObject) {
                if (jSONObject == null || !jSONObject.has(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I)) {
                    return;
                }
                try {
                    v.a().a(jSONObject.getString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I));
                } catch (Exception e) {
                    af.b(j.f2724a, e.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.f.d
            public final void a(String str3) {
            }
        });
    }

    public final void a(Context context, final String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = com.mbridge.msdk.foundation.controller.c.m().k();
            str2 = com.mbridge.msdk.foundation.controller.c.m().b();
        }
        if (h.a().e(str3, str) && h.a().a(str, 2, str3)) {
            com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e();
            String str4 = "[" + str3 + "]";
            eVar.a("unit_ids", str4);
            eVar.a(MBridgeConstans.APP_ID, str);
            eVar.a("sign", SameMD5.getMD5(str + str2));
            try {
                String strT = h.a().c(str, str4).t();
                if (TextUtils.isEmpty(strT)) {
                    strT = "";
                }
                eVar.a("vtag", strT);
            } catch (Throwable th) {
                af.b(f2724a, th.getMessage());
            }
            com.mbridge.msdk.foundation.same.net.f.d dVar = new com.mbridge.msdk.foundation.same.net.f.d() { // from class: com.mbridge.msdk.c.j.4
                @Override // com.mbridge.msdk.foundation.same.net.f.d
                public final void a(JSONObject jSONObject) throws JSONException {
                    try {
                        if (ak.a(jSONObject)) {
                            String strOptString = jSONObject.optString("vtag", "");
                            String strOptString2 = jSONObject.optString("rid", "");
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unitSetting");
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                                if (jSONObject.optInt("vtag_status", 0) == 1) {
                                    h.a();
                                    String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str + "_" + str3);
                                    if (!TextUtils.isEmpty(strA)) {
                                        try {
                                            jSONObjectOptJSONObject = h.a().a(new JSONObject(strA), jSONObjectOptJSONObject);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                jSONObjectOptJSONObject.put("current_time", System.currentTimeMillis());
                                jSONObjectOptJSONObject.put("vtag", strOptString);
                                jSONObjectOptJSONObject.put("rid", strOptString2);
                                h.a().a(str, str3, jSONObjectOptJSONObject.toString());
                            }
                        } else {
                            h.a().h(str, str3);
                        }
                        j.this.a(1, 1, "");
                    } catch (Exception e3) {
                        af.b(j.f2724a, e3.getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.net.f.d
                public final void a(String str5) {
                    j.this.a(2, 1, "");
                }
            };
            dVar.setUnitId(str3);
            new com.mbridge.msdk.c.a.c(context).get(1, com.mbridge.msdk.foundation.same.net.e.d.f().G, eVar, dVar, "setting", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            a(3, 1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, int i11, String str) {
        String strB;
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", "2000112");
            eVar.a("st_net", Integer.valueOf(com.mbridge.msdk.foundation.same.net.e.d.f().f3748s));
            eVar.a("result", Integer.valueOf(i10));
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i11));
            if (i11 == 0) {
                strB = b();
            } else {
                strB = com.mbridge.msdk.foundation.same.net.e.d.f().f3747r ? com.mbridge.msdk.foundation.same.net.e.d.f().H : com.mbridge.msdk.foundation.same.net.e.d.f().G;
            }
            eVar.a("url", strB);
            eVar.a("reason", str);
            cVar.a("2000112", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000112", cVar);
        } catch (Throwable th) {
            af.b(f2724a, th.getMessage());
        }
    }

    public static /* synthetic */ void a(j jVar, Context context, String str) {
        g gVarB;
        h hVarA = h.a();
        if (hVarA != null && (gVarB = hVarA.b(str)) != null) {
            MBridgeConstans.OMID_JS_SERVICE_URL = gVarB.X();
            MBridgeConstans.OMID_JS_H5_URL = gVarB.W();
        }
        com.mbridge.msdk.a.b.a(context);
        com.mbridge.msdk.a.b.b(context);
    }

    public static /* synthetic */ void a(j jVar) {
        try {
            new com.mbridge.msdk.foundation.same.report.h(com.mbridge.msdk.foundation.controller.c.m().c()).a();
        } catch (Throwable th) {
            af.b(f2724a, th.getMessage());
        }
    }
}
