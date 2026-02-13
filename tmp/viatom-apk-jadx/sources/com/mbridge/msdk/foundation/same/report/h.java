package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import java.io.File;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3864a = "h";

    /* renamed from: b, reason: collision with root package name */
    private final Context f3865b;

    public h(Context context) {
        this.f3865b = context.getApplicationContext();
    }

    public final void a() {
        try {
            if (i.a()) {
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(strK);
                if (gVarB == null) {
                    com.mbridge.msdk.c.h.a();
                    gVarB = com.mbridge.msdk.c.i.a();
                }
                String strC = com.mbridge.msdk.foundation.tools.f.c();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000053");
                jSONObject.put("Appid", strK);
                jSONObject.put("uptips2", gVarB.au());
                jSONObject.put("info_status", com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().h());
                jSONObject.put("iseu", gVarB.M());
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject.put("gaid", strC);
                }
                jSONObject.put("GDPR_area", gVarB.aH());
                jSONObject.put("GDPR_consent", com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().g());
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
                i.b();
            }
        } catch (Throwable th) {
            af.b(f3864a, th.getMessage());
        }
    }

    public final void b(String str, String str2, String str3, String str4, String str5, boolean z9) throws JSONException {
        try {
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (z9) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            }
            jSONObject.put("key", URLEncoder.encode("2000066", "utf-8"));
            jSONObject.put("rid", URLEncoder.encode(str, "utf-8"));
            jSONObject.put("rid_n", URLEncoder.encode(str2, "utf-8"));
            jSONObject.put("cid", URLEncoder.encode(str3, "utf-8"));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, "utf-8"));
            jSONObject.put("err_method", str5);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Exception e) {
            af.b(f3864a, e.getMessage());
        }
    }

    public h(Context context, int i10) {
        this.f3865b = context;
    }

    public final void a(int i10, int i11, String str, String str2, String str3) throws JSONException {
        Context context = this.f3865b;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000058");
            jSONObject.put("appid", com.mbridge.msdk.foundation.controller.c.m().k());
            jSONObject.put("dl_type", String.valueOf(i10));
            jSONObject.put("dl_link_type", String.valueOf(i11));
            jSONObject.put("rid", str);
            jSONObject.put("rid_n", str2);
            jSONObject.put("cid", str3);
            jSONObject.put("tgt_v", ab.u(context));
            jSONObject.put("app_v_n", ab.q(context));
            jSONObject.put("app_v_c", ab.r(context));
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("ReportControllerDiff", e.getMessage());
            }
        }
    }

    public final void a(String str, File file) {
        com.mbridge.msdk.foundation.same.report.d.d.a().c(str);
        if (file != null) {
            try {
                file.delete();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b(f3864a, "reportException", e);
                }
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z9) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z9) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            }
            jSONObject.put("key", URLEncoder.encode("2000065", "utf-8"));
            jSONObject.put("rid", URLEncoder.encode(str, "utf-8"));
            jSONObject.put("rid_n", URLEncoder.encode(str2, "utf-8"));
            jSONObject.put("cid", URLEncoder.encode(str3, "utf-8"));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, "utf-8"));
            jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, URLEncoder.encode(str5, "utf-8"));
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Exception e) {
            af.b(f3864a, e.getMessage());
        }
    }

    public final void a(final com.mbridge.msdk.foundation.entity.l lVar, final Boolean bool) {
        if (lVar != null) {
            if (lVar.b().equals(ShareTarget.METHOD_GET)) {
                com.mbridge.msdk.foundation.same.report.d.d.a().c(lVar.a());
                com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.h.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (h.this.f3865b != null && lVar != null) {
                                com.mbridge.msdk.foundation.db.l.a(com.mbridge.msdk.foundation.db.g.a(h.this.f3865b)).a(lVar.d());
                                if (!bool.booleanValue() || com.mbridge.msdk.foundation.db.l.a(com.mbridge.msdk.foundation.db.g.a(h.this.f3865b)).b() <= 20) {
                                    return;
                                }
                                com.mbridge.msdk.foundation.controller.d.a().b();
                            }
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                af.b(h.f3864a, "reportNetError", e);
                            }
                        }
                    }
                });
            } else if (lVar.b().equals(ShareTarget.METHOD_POST)) {
                com.mbridge.msdk.foundation.same.report.d.d.a().c(lVar.a());
                com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.h.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (h.this.f3865b == null || lVar == null) {
                            return;
                        }
                        try {
                            com.mbridge.msdk.foundation.db.l.a(com.mbridge.msdk.foundation.db.g.a(h.this.f3865b)).a(lVar.a(), lVar.d(), lVar.c());
                            if (!bool.booleanValue() || com.mbridge.msdk.foundation.db.l.a(com.mbridge.msdk.foundation.db.g.a(h.this.f3865b)).a() <= 0) {
                                return;
                            }
                            com.mbridge.msdk.foundation.controller.d.a().b();
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                af.b(h.f3864a, "reportNetError", e);
                            }
                        }
                    }
                });
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5) throws JSONException {
        try {
            int iM = ab.m(this.f3865b);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", URLEncoder.encode("2000071", "utf-8"));
            jSONObject.put("rid", URLEncoder.encode(str, "utf-8"));
            jSONObject.put("rid_n", URLEncoder.encode(str2, "utf-8"));
            jSONObject.put("cid", URLEncoder.encode(str3, "utf-8"));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, "utf-8"));
            jSONObject.put("reason", URLEncoder.encode(str5, "utf-8"));
            jSONObject.put("network_type", URLEncoder.encode(String.valueOf(iM), "utf-8"));
            jSONObject.put("result", URLEncoder.encode("0", "utf-8"));
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Exception e) {
            af.b(f3864a, e.getMessage());
        }
    }

    public final void a(com.mbridge.msdk.foundation.entity.l lVar) {
    }
}
