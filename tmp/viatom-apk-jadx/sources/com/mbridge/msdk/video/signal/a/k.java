package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.a.a;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends l {

    /* renamed from: p, reason: collision with root package name */
    private Activity f6152p;

    /* renamed from: q, reason: collision with root package name */
    private String f6153q;

    /* renamed from: r, reason: collision with root package name */
    private String f6154r;
    private CampaignEx t;

    /* renamed from: u, reason: collision with root package name */
    private List<CampaignEx> f6156u;

    /* renamed from: v, reason: collision with root package name */
    private int f6157v;

    /* renamed from: s, reason: collision with root package name */
    private int f6155s = 0;

    /* renamed from: w, reason: collision with root package name */
    private String f6158w = "";

    /* renamed from: x, reason: collision with root package name */
    private String f6159x = "";
    private boolean y = false;

    /* renamed from: z, reason: collision with root package name */
    private boolean f6160z = false;

    public k(Activity activity, CampaignEx campaignEx, List<CampaignEx> list) {
        this.f6152p = activity;
        this.t = campaignEx;
        this.f6156u = list;
    }

    private JSONObject A() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.d.c cVar = this.f6138k;
        return cVar != null ? cVar.E() : jSONObject;
    }

    private JSONObject B() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
        return aVarB != null ? aVarB.k() : jSONObject;
    }

    private CampaignEx a(String str, CampaignEx campaignEx) throws JSONException {
        String strValueOf;
        String strValueOf2;
        if (TextUtils.isEmpty(str)) {
            return campaignEx;
        }
        if (TextUtils.isEmpty(str) && campaignEx == null) {
            return null;
        }
        if (str.contains("notice")) {
            try {
                JSONObject jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
                try {
                    if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        jSONObjectCampaignToJsonObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                } catch (Exception unused) {
                }
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectCampaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject);
                a(jSONObjectCampaignToJsonObject, campaignWithBackData);
                return campaignWithBackData;
            } catch (JSONException e) {
                e.printStackTrace();
                return campaignEx;
            }
        }
        try {
            JSONObject jSONObjectCampaignToJsonObject2 = CampaignEx.campaignToJsonObject(campaignEx);
            CampaignEx campaignWithBackData2 = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject2);
            if (campaignWithBackData2 == null) {
                campaignWithBackData2 = campaignEx;
            }
            if (!TextUtils.isEmpty(str)) {
                a(jSONObjectCampaignToJsonObject2, campaignWithBackData2);
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(com.mbridge.msdk.foundation.same.a.f3606j);
                if (jSONObjectOptJSONObject != null) {
                    strValueOf = String.valueOf(ak.a(this.f6152p, Integer.valueOf(jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.h)).intValue()));
                    strValueOf2 = String.valueOf(ak.a(this.f6152p, Integer.valueOf(jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f3605i)).intValue()));
                } else {
                    strValueOf = "-999";
                    strValueOf2 = "-999";
                }
                campaignWithBackData2.setClickURL(com.mbridge.msdk.click.c.a(campaignWithBackData2.getClickURL(), strValueOf, strValueOf2));
                String noticeUrl = campaignWithBackData2.getNoticeUrl();
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    StringBuilder sb = new StringBuilder();
                    while (itKeys2.hasNext()) {
                        sb.append("&");
                        String next2 = itKeys2.next();
                        String strOptString = jSONObjectOptJSONObject.optString(next2);
                        if (com.mbridge.msdk.foundation.same.a.h.equals(next2) || com.mbridge.msdk.foundation.same.a.f3605i.equals(next2)) {
                            strOptString = String.valueOf(ak.a(this.f6152p, Integer.valueOf(strOptString).intValue()));
                        }
                        sb.append(next2);
                        sb.append("=");
                        sb.append(strOptString);
                    }
                    campaignWithBackData2.setNoticeUrl(noticeUrl + ((Object) sb));
                }
            }
            return campaignWithBackData2;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return campaignEx;
        } catch (Throwable th) {
            th.printStackTrace();
            return campaignEx;
        }
    }

    private void b(JSONObject jSONObject) throws JSONException {
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            String string = an.a(contextC, "MBridge_ConfirmTitle" + this.f6137j, "").toString();
            String string2 = an.a(contextC, "MBridge_ConfirmContent" + this.f6137j, "").toString();
            String string3 = an.a(contextC, "MBridge_CancelText" + this.f6137j, "").toString();
            String string4 = an.a(contextC, "MBridge_ConfirmText" + this.f6137j, "").toString();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("confirm_title", string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("confirm_description", string2);
            }
            if (!TextUtils.isEmpty(string3)) {
                jSONObject.put("confirm_t", string3);
            }
            if (!TextUtils.isEmpty(string4)) {
                jSONObject.put("confirm_c_play", string4);
            }
            if (TextUtils.isEmpty(string4)) {
                return;
            }
            jSONObject.put("confirm_c_rv", string4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f6137j);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceId", this.f6158w);
            jSONObject2.put("rootViewInstanceId", this.f6159x);
            jSONObject2.put("isRootTemplateWebView", this.y);
            jSONObject.put("sdk_info", "MAL_16.8.61,3.0.1");
            jSONObject2.put("playVideoMute", this.f6141n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<CampaignEx> list = this.f6156u;
            if (list == null || list.size() <= 0) {
                jSONArray.put(CampaignEx.campaignToJsonObject(this.t));
            } else {
                for (CampaignEx campaignEx : this.f6156u) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(campaignEx, campaignEx.isReady(), b(campaignEx)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", A());
            String strG = com.mbridge.msdk.c.h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                JSONObject jSONObject3 = new JSONObject(strG);
                b(jSONObject3);
                String strC = com.mbridge.msdk.c.h.a().c(this.f6137j);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject3.put("ivreward", new JSONObject(strC));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", B());
            if (!TextUtils.isEmpty(this.f6137j)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f6137j);
            }
            jSONObject.put("rw_plus", this.f6160z ? "1" : "0");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f6141n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(CampaignEx.campaignToJsonObject(this.t));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", A());
            String strG = com.mbridge.msdk.c.h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                JSONObject jSONObject3 = new JSONObject(strG);
                b(jSONObject3);
                String strC = com.mbridge.msdk.c.h.a().c(this.f6137j);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject3.put("ivreward", strC);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", B());
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_info", "MAL_16.8.61,3.0.1");
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject v() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(this.f6137j)) {
                return jSONObject;
            }
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f6137j);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            String strG = com.mbridge.msdk.c.h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("appSetting", new JSONObject(strG));
                return jSONObject;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject x() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            com.mbridge.msdk.videocommon.d.c cVar = this.f6138k;
            if (cVar == null) {
                return jSONObject;
            }
            jSONObject.put("unitSetting", cVar.E());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject y() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject z() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f6141n);
            jSONObject2.put("instanceId", this.f6158w);
            jSONObject.put("sdkSetting", jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final String c() {
        this.f6140m.a();
        this.f6132a = true;
        if (TextUtils.isEmpty(this.f6153q)) {
            this.f6153q = s();
        } else {
            this.f6153q = ak.b(this.f6153q, "tun", ab.q() + "");
        }
        return this.f6153q;
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.e
    public final void click(int i10, String str) {
        AppletsModel appletsModel;
        List<CampaignEx> list;
        int iP;
        List<CampaignEx> list2;
        super.click(i10, str);
        CampaignEx campaignEx = this.t;
        if (campaignEx != null && campaignEx.getDynamicTempCode() == 5 && this.t != null && (list2 = this.f6156u) != null && list2.size() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("camp_position")) {
                    this.t = this.f6156u.get(jSONObject.getInt("camp_position"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            if (i10 != 1) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return;
                    }
                    this.f6140m.a(true);
                    return;
                }
                CampaignEx campaignEx2 = this.t;
                if (campaignEx2 == null || campaignEx2.getCbd() <= -2) {
                    com.mbridge.msdk.videocommon.d.c cVar = this.f6138k;
                    iP = cVar != null ? cVar.p() : 1;
                } else {
                    iP = this.t.getCbd();
                }
                if (iP == -1) {
                    a(new a.b(this, this.f6140m));
                }
                this.f6155s = i10;
                click(1, str);
                return;
            }
            if (this.t == null && (list = this.f6156u) != null && list.size() > 0) {
                this.t = this.f6156u.get(0);
            }
            CampaignEx campaignEx3 = this.t;
            if (campaignEx3 == null) {
                return;
            }
            CampaignEx campaignExA = a(str, campaignEx3);
            if (this.f6155s != 3) {
                this.f6155s = i10;
            }
            try {
                int i11 = this.f6155s;
                if (i11 == 3) {
                    campaignExA.setClickTempSource(2);
                    if (campaignExA.getTriggerClickSource() == 0) {
                        campaignExA.setTriggerClickSource(2);
                    }
                } else if (i11 == 1 && campaignExA.getClickTempSource() != 2) {
                    campaignExA.setClickTempSource(1);
                }
            } catch (Exception e3) {
                af.b("DefaultJSCommon", e3.getMessage());
            }
            if (campaignExA != null && (appletsModel = AppletModelManager.getInstance().get(campaignExA)) != null) {
                appletsModel.setUserClick(true);
                AppletModelManager.getInstance().replace(appletsModel, campaignExA);
            }
            a(campaignExA, this.f6152p);
        } catch (Throwable th) {
            af.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void d() {
        super.d();
        try {
            Activity activity = this.f6152p;
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th) {
            af.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void f() {
        super.f();
        a.InterfaceC0069a interfaceC0069a = this.f6140m;
        if (interfaceC0069a != null) {
            interfaceC0069a.b();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final String g(int i10) {
        switch (i10) {
            case 1:
                return u().toString();
            case 2:
                return v().toString();
            case 3:
                return w().toString();
            case 4:
                return x().toString();
            case 5:
                return y().toString();
            case 6:
                return z().toString();
            default:
                return t().toString();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.e
    public final void handlerH5Exception(int i10, String str) {
        super.handlerH5Exception(i10, str);
        try {
            this.f6140m.a(i10, str);
        } catch (Throwable th) {
            af.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final String i() {
        af.a("DefaultJSCommon", "getNotchArea");
        return this.f6154r;
    }

    public final void q() {
        this.f6153q = "";
    }

    public final int r() {
        return this.f6157v;
    }

    public final void i(int i10) {
        this.f6157v = i10;
    }

    public k(Activity activity, CampaignEx campaignEx) {
        this.f6152p = activity;
        this.t = campaignEx;
    }

    public final void d(boolean z9) {
        this.f6160z = z9;
    }

    public final void d(String str) {
        this.f6159x = str;
    }

    public final void c(String str) {
        this.f6158w = str;
    }

    public final void c(boolean z9) {
        this.y = z9;
    }

    private boolean b(CampaignEx campaignEx) {
        com.mbridge.msdk.c.g gVarB;
        try {
            String strK = com.mbridge.msdk.foundation.controller.c.m().k();
            long jAd = (TextUtils.isEmpty(strK) || (gVarB = com.mbridge.msdk.c.h.a().b(strK)) == null) ? 0L : gVarB.ad() * 1000;
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            long jF = aVarB != null ? aVarB.f() : 0L;
            if (campaignEx != null) {
                return campaignEx.isSpareOffer(jF, jAd);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6154r = str;
    }

    public final void a(CampaignEx campaignEx) {
        this.t = campaignEx;
    }

    public final void a(List<CampaignEx> list) {
        this.f6156u = list;
    }

    private void a(JSONObject jSONObject, CampaignEx campaignEx) {
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            campaignEx.setCampaignUnitId(strOptString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void a(int i10, String str) {
        super.a(i10, str);
        if (i10 != 2) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT);
            final String strOptString2 = jSONObject.optString("template", "-1");
            final String strOptString3 = jSONObject.optString(TtmlNode.TAG_LAYOUT, "-1");
            final String strOptString4 = jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f6137j);
            final int iM = ab.m(this.f6152p.getApplication());
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.signal.a.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.foundation.db.o.a(com.mbridge.msdk.foundation.db.g.a(k.this.f6152p.getApplication())).a(new com.mbridge.msdk.foundation.entity.n("2000039", strOptString, strOptString2, strOptString3, strOptString4, k.this.t.getId(), iM, ab.a(k.this.f6152p.getApplication(), iM)));
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.a.b().execute(runnable);
        } catch (Throwable th) {
            af.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void a(Activity activity) {
        this.f6152p = activity;
    }
}
