package com.mbridge.msdk.video.signal.communication;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BaseVideoCommunication extends AbsFeedBackForH5 implements IVideoCommunication {

    /* renamed from: a, reason: collision with root package name */
    protected IJSFactory f6173a;
    private FastKV e = null;

    private void a(Object obj, String str) throws JSONException {
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Exception e) {
            af.a("JS-Video-Brigde", e.getMessage());
        }
    }

    private String b(int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            af.b("JS-Video-Brigde", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void appendSubView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().i(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("appendSubView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void appendViewTo(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().j(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("appendViewTo error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void bringViewToFront(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().m(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("bringViewToFront error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void broadcast(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().J(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("broadcast error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void cai(Object obj, String str) throws JSONException {
        af.a("JS-Video-Brigde", "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String strOptString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(strOptString)) {
                    com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "packageName is empty");
                }
                int i10 = ak.c(c.m().c(), strOptString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.d.f4375b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i10);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, e.getMessage());
                    af.a("JS-Video-Brigde", e.getMessage());
                }
            } catch (Throwable th) {
                com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "exception: " + th.getLocalizedMessage());
                af.b("JS-Video-Brigde", "cai", th);
            }
        } catch (JSONException e3) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "exception: " + e3.getLocalizedMessage());
            af.b("JS-Video-Brigde", "cai", e3);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void clearAllCache(Object obj, String str) {
        com.mbridge.msdk.foundation.controller.d.a();
        if (this.e == null) {
            try {
                this.e = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.e = null;
            }
        }
        FastKV fastKV = this.e;
        if (fastKV != null) {
            try {
                try {
                    fastKV.clear();
                } catch (Throwable th) {
                    com.mbridge.msdk.dycreator.baseview.a.u("getAllCache error ", "JS-Video-Brigde", th);
                    return;
                }
            } catch (Exception unused2) {
            }
            if (obj != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            return;
        }
        try {
            c.m().c().getSharedPreferences("MBridgeH5CacheSP", 0).edit().clear().apply();
            if (obj != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 0);
                jSONObject2.put("message", "Success");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (Throwable th2) {
            com.mbridge.msdk.dycreator.baseview.a.u("getAllCache error ", "JS-Video-Brigde", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void click(Object obj, String str) {
        String strOptString;
        int iOptInt;
        k kVar;
        af.c("JS-Video-Brigde", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                iOptInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                strOptString = jSONObject.optString("pt");
            } catch (JSONException e) {
                strOptString = "";
                e.printStackTrace();
                iOptInt = 1;
            }
            IJSFactory iJSFactory = this.f6173a;
            if (iJSFactory != null) {
                iJSFactory.getJSCommon().click(iOptInt, strOptString);
                return;
            }
            if (obj != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (!(aVar.f4406b.getObject() instanceof k) || (kVar = (k) aVar.f4406b.getObject()) == null) {
                    return;
                }
                kVar.click(iOptInt, strOptString);
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "click error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeAd(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().I(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("closeAd error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeVideoOperte(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
            int iOptInt2 = jSONObject.optInt("view_visible");
            af.c("JS-Video-Brigde", "closeVideoOperte,close:" + iOptInt + ",viewVisible:" + iOptInt2);
            this.f6173a.getJSVideoModule().closeVideoOperate(iOptInt, iOptInt2);
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "closeOperte error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeWeb(Object obj, String str) {
        af.b("JS-Video-Brigde", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY + str);
        try {
            if (TextUtils.isEmpty(str) || this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(NotificationCompat.CATEGORY_STATUS);
            this.f6173a.getJSContainerModule().hideAlertWebview();
            this.f6173a.getJSVideoModule().hideAlertView(iOptInt);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "closeWeb", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createNativeEC(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().O(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("createNativeEC error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createPlayerView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().c(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("createPlayerView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createSubPlayTemplateView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().d(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("createSubPlayTemplateView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("createView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createWebview(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("createWebview error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void destroyComponent(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().e(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("destroyComponent error ", "JS-Video-Brigde", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f0 A[Catch: all -> 0x00f4, TRY_ENTER, TryCatch #0 {all -> 0x00f4, blocks: (B:34:0x00dd, B:37:0x00f0, B:42:0x00fd, B:40:0x00f6), top: B:47:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f6 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:34:0x00dd, B:37:0x00f0, B:42:0x00fd, B:40:0x00f6), top: B:47:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd A[Catch: all -> 0x00f4, TRY_LEAVE, TryCatch #0 {all -> 0x00f4, blocks: (B:34:0x00dd, B:37:0x00f0, B:42:0x00fd, B:40:0x00f6), top: B:47:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v15, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v8, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v8, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getAllCache(java.lang.Object r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.getAllCache(java.lang.Object, java.lang.String):void");
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getAppSetting(Object obj, String str) {
        JSONObject jSONObject;
        try {
            String strOptString = new JSONObject(str).optString("appid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get App Setting error, because must give a appId.");
            } else {
                String strG = h.a().g(strOptString);
                if (TextUtils.isEmpty(strG)) {
                    h.a();
                    jSONObject = new JSONObject(i.a().aM());
                } else {
                    jSONObject = new JSONObject(strG);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get App Setting error, plz try again later.");
                }
            }
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getAppSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getComponentOptions(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().f(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("getComponentOptions error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getCurrentProgress(Object obj, String str) {
        try {
            IJSFactory iJSFactory = this.f6173a;
            if (iJSFactory != null) {
                String currentProgress = iJSFactory.getJSVideoModule().getCurrentProgress();
                af.c("JS-Video-Brigde", "getCurrentProgress:" + currentProgress);
                if (!TextUtils.isEmpty(currentProgress)) {
                    currentProgress = Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                g.a().a(obj, currentProgress);
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getCurrentProgress error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getCutout(Object obj, String str) {
        try {
            String strI = this.f6173a.getJSCommon().i();
            af.b("JS-Video-Brigde", strI);
            if (obj != null && !TextUtils.isEmpty(strI)) {
                g.a().a(obj, Base64.encodeToString(strI.getBytes(), 2));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "No notch data, plz try again later.");
            g.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getCutout error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getEncryptPrice(Object obj, String str) {
        String str2;
        try {
            String str3 = "not replaced";
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int i10 = 1;
            if (TextUtils.isEmpty(str)) {
                str2 = "params is null";
            } else {
                JSONObject jSONObject3 = new JSONObject(str);
                String strOptString = jSONObject3.optString("unitid", "");
                String strOptString2 = jSONObject3.optString("requestId", "");
                if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                    str2 = "params parsing exception";
                } else {
                    com.mbridge.msdk.foundation.entity.d dVarB = b.b(strOptString, strOptString2);
                    if (dVarB != null && dVarB.c() == 1) {
                        str3 = "success";
                        jSONObject2.put("encrypt_p", dVarB.b());
                        jSONObject2.put(com.mbridge.msdk.foundation.entity.b.KEY_IRLFA, 1);
                        i10 = 0;
                    }
                    str2 = str3;
                }
            }
            jSONObject.put("code", i10);
            jSONObject.put("message", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getEncryptPrice error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getFileInfo(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().N(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getFileInfo error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getRewardSetting(Object obj, String str) {
        try {
            JSONObject jSONObjectK = com.mbridge.msdk.videocommon.d.b.a().b().k();
            JSONObject jSONObject = new JSONObject();
            if (obj == null || jSONObjectK == null) {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Get Reward Setting error, plz try again later.");
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObjectK);
            }
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getRewardSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getRewardUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("appid", "");
            String strOptString2 = jSONObject.optString("unitid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get reward unit Setting error, because must give appId and unitId.");
            } else {
                JSONObject jSONObjectE = com.mbridge.msdk.videocommon.d.b.a().a(strOptString, strOptString2).E();
                if (obj == null || jSONObjectE == null) {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get Reward Unit Setting error, plz try again later.");
                } else {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObjectE);
                }
            }
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getRewardUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getSDKInfo(Object obj, String str) {
        af.c("JS-Video-Brigde", "getSDKInfo");
        try {
            if (TextUtils.isEmpty(str)) {
                g.a().b(obj, "params is null");
                return;
            }
            JSONArray jSONArray = new JSONObject(str).getJSONArray(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            JSONObject jSONObject = new JSONObject();
            int i10 = 0;
            if (this.f6173a != null) {
                while (i10 < jSONArray.length()) {
                    int i11 = jSONArray.getInt(i10);
                    jSONObject.put(a(i11), this.f6173a.getJSCommon().g(i11));
                    i10++;
                }
            } else if (obj != null) {
                while (i10 < jSONArray.length()) {
                    int i12 = jSONArray.getInt(i10);
                    com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                    if (aVar.f4406b.getObject() instanceof k) {
                        jSONObject.put(a(i12), ((k) aVar.f4406b.getObject()).g(i12));
                    }
                    i10++;
                }
            }
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getSDKInfo error", th);
            g.a().b(obj, "exception");
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "Get Unit Setting error, RV/IV can not support this method.");
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "getUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void handleNativeObject(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("handleNativeObject error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void handlerH5Exception(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            af.c("JS-Video-Brigde", "handlerH5Exception,params:" + str);
            this.f6173a.getJSCommon().handlerH5Exception(jSONObject.optInt("code", -999), jSONObject.optString("message", "h5 error"));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "handlerH5Exception", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void hideView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().n(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("hideView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void increaseOfferFrequence(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().M(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("increaseOfferFrequence error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void init(Object obj, String str) {
        af.c("JS-Video-Brigde", "init");
        try {
            IJSFactory iJSFactory = this.f6173a;
            int i10 = 1;
            if (iJSFactory != null) {
                String strC = iJSFactory.getJSCommon().c();
                if (!TextUtils.isEmpty(strC)) {
                    strC = Base64.encodeToString(strC.getBytes(), 2);
                }
                g.a().a(obj, strC);
                this.f6173a.getJSCommon().b(true);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("showTransparent");
                int iOptInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                int iOptInt3 = jSONObject.optInt("closeType");
                int iOptInt4 = jSONObject.optInt("orientationType");
                int iOptInt5 = jSONObject.optInt("webfront");
                int iOptInt6 = jSONObject.optInt("showAlertRole");
                this.f6173a.getJSCommon().a(iOptInt == 1);
                this.f6173a.getJSCommon().b(iOptInt2);
                this.f6173a.getJSCommon().c(iOptInt3);
                this.f6173a.getJSCommon().d(iOptInt4);
                this.f6173a.getJSCommon().e(iOptInt5);
                com.mbridge.msdk.video.signal.d jSCommon = this.f6173a.getJSCommon();
                if (iOptInt6 != 0) {
                    i10 = iOptInt6;
                }
                jSCommon.h(i10);
                return;
            }
            if (obj != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.f4406b.getObject() instanceof k) {
                    k kVar = (k) aVar.f4406b.getObject();
                    String strC2 = kVar.c();
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int iOptInt7 = jSONObject2.optInt("showTransparent");
                        int iOptInt8 = jSONObject2.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                        int iOptInt9 = jSONObject2.optInt("closeType");
                        int iOptInt10 = jSONObject2.optInt("orientationType");
                        int iOptInt11 = jSONObject2.optInt("webfront");
                        int iOptInt12 = jSONObject2.optInt("showAlertRole");
                        kVar.a(iOptInt7 == 1);
                        kVar.b(iOptInt8);
                        kVar.c(iOptInt9);
                        kVar.d(iOptInt10);
                        kVar.e(iOptInt11);
                        if (iOptInt12 != 0) {
                            i10 = iOptInt12;
                        }
                        kVar.h(i10);
                        af.c("JS-Video-Brigde", "init jsCommon.setIsShowingTransparent = " + iOptInt7);
                    }
                    g.a().a(obj, Base64.encodeToString(strC2.getBytes(), 2));
                }
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "init error", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof IJSFactory) {
            this.f6173a = (IJSFactory) obj;
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void insertViewAbove(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().a(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("insertViewAbove error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void insertViewBelow(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("insertViewBelow error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void isSystemResume(Object obj, String str) {
        try {
            if (this.f6173a != null) {
                af.c("JS-Video-Brigde", "isSystemResume,params:" + str);
                g.a().a(obj, b(this.f6173a.getActivityProxy().h()));
            }
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "isSystemResume", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        af.b("JS-Video-Brigde", "ivRewardAdsWithoutVideo ： params" + str);
        try {
            if (TextUtils.isEmpty(str) || this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6173a.getJSContainerModule().ivRewardAdsWithoutVideo(str);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "ivRewardAdsWithoutVideo", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void loadads(Object obj, String str) {
        String str2;
        String str3;
        int i10;
        int iOptInt;
        af.c("JS-Video-Brigde", "loadads");
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = "";
                str3 = str2;
                i10 = 1;
                iOptInt = 1;
            } else {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString(MBridgeConstans.PLACEMENT_ID);
                String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                int iOptInt2 = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                if (iOptInt2 > 2) {
                    iOptInt2 = 1;
                }
                str2 = strOptString;
                iOptInt = jSONObject.optInt("adtype", 1);
                str3 = strOptString2;
                i10 = iOptInt2;
            }
            if (TextUtils.isEmpty(str3)) {
                g.a().a(obj, b(1));
                return;
            }
            if (obj != null) {
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
                if ((windVaneWebView != null) && windVaneWebView.getWebViewListener() != null) {
                    ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(windVaneWebView, str2, str3, i10, iOptInt);
                }
            }
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "loadads error", th);
            g.a().a(obj, b(1));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void loadingResourceStatus(Object obj, String str) throws JSONException {
        a(obj, str);
        if (obj != null) {
            try {
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().c(windVaneWebView, iOptInt);
            } catch (Throwable th) {
                com.mbridge.msdk.dycreator.baseview.a.u("loadingResourceStatus error ", "JS-Video-Brigde", th);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            af.c("JS-Video-Brigde", "notifyCloseBtn,result:" + iOptInt);
            this.f6173a.getJSVideoModule().notifyCloseBtn(iOptInt);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyAppendSubView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().k(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("appendSubView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyAppendViewTo(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().l(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("appendViewTo error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyInsertViewAbove(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().s(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("insertViewAbove error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyInsertViewBelow(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str), false);
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("insertViewBelow error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void openURL(Object obj, String str) {
        af.b("JS-Video-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.d(this.f4422b, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.f(this.f4422b, strOptString);
            }
        } catch (JSONException e) {
            af.b("JS-Video-Brigde", e.getMessage());
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playVideoFinishOperate(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str) || this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            af.c("JS-Video-Brigde", "playVideoFinishOperate,type: " + iOptInt);
            this.f6173a.getJSCommon().f(iOptInt);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "playVideoFinishOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerGetMuteState(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().E(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerGetMuteState error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerMute(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().C(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerMute error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerPause(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().y(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerPause error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerPlay(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().x(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerPlay error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerResume(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().z(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerResume error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerSetRenderType(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().G(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerSetRenderType error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerSetSource(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().F(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerSetSource error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerStop(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().A(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerStop error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerUnmute(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().D(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerUnmute error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerUpdateFrame(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().B(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("playerUpdateFrame error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void preloadSubPlayTemplateView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            if (this.f6173a != null) {
                d.c().H(obj, new JSONObject(str));
                return;
            }
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
            if (windVaneWebView != null) {
                if (windVaneWebView.getWebViewListener() == null) {
                    af.a("JS-Video-Brigde", "preloadSubPlayTemplateView: failed");
                } else {
                    ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj, str);
                    af.a("JS-Video-Brigde", "preloadSubPlayTemplateView: RVWebViewListener");
                }
            }
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("preloadSubPlayTemplateView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void progressBarOperate(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6173a.getJSVideoModule().progressBarOperate(new JSONObject(str).optInt("view_visible"));
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void progressOperate(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("progress");
            int iOptInt2 = jSONObject.optInt("view_visible");
            af.c("JS-Video-Brigde", "progressOperate,progress:" + iOptInt + ",viewVisible:" + iOptInt2);
            this.f6173a.getJSVideoModule().progressOperate(iOptInt, iOptInt2);
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reactDeveloper(Object obj, String str) {
        af.a("JS-Video-Brigde", "reactDeveloper");
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                g.a().b(obj, b(1));
            } else {
                this.f6173a.getJSBTModule().reactDeveloper(obj, str);
            }
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("reactDeveloper error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.f4406b.getObject() instanceof k) {
                    ((k) aVar.f4406b.getObject()).i(iOptInt);
                }
                WindVaneWebView windVaneWebView = aVar.f4406b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, iOptInt);
            } catch (Throwable th) {
                af.b("JS-Video-Brigde", "readyStatus", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void removeCacheItem(java.lang.Object r11, java.lang.String r12) {
        /*
            r10 = this;
            com.mbridge.msdk.foundation.controller.d.a()
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.e
            java.lang.String r1 = "MBridgeH5CacheSP"
            if (r0 != 0) goto L1e
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch: java.lang.Exception -> L1b
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch: java.lang.Exception -> L1b
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.a(r2)     // Catch: java.lang.Exception -> L1b
            r0.<init>(r2, r1)     // Catch: java.lang.Exception -> L1b
            com.mbridge.msdk.foundation.tools.FastKV r0 = r0.build()     // Catch: java.lang.Exception -> L1b
            r10.e = r0     // Catch: java.lang.Exception -> L1b
            goto L1e
        L1b:
            r0 = 0
            r10.e = r0
        L1e:
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.e
            java.lang.String r2 = "Delete Error, reason is : "
            java.lang.String r3 = "Delete Success"
            java.lang.String r4 = "key"
            java.lang.String r5 = "removeCacheItem error "
            java.lang.String r6 = "JS-Video-Brigde"
            r7 = 1
            r8 = 0
            java.lang.String r9 = ""
            if (r0 == 0) goto L71
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L4b
            if (r0 != 0) goto L4d
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4b
            r0.<init>(r12)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r12 = r0.getString(r4)     // Catch: java.lang.Throwable -> L4b
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L4b
            if (r0 != 0) goto L4f
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.e     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4f
            r0.remove(r12)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4f
            goto L4f
        L4b:
            r12 = move-exception
            goto L51
        L4d:
            r7 = r8
            r3 = r9
        L4f:
            r8 = r7
            goto Lbe
        L51:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.b(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r3 = r0.toString()
            goto Lbe
        L71:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Throwable -> L9e
            android.content.Context r0 = r0.c()     // Catch: java.lang.Throwable -> L9e
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r8)     // Catch: java.lang.Throwable -> L9e
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L9e
            if (r1 != 0) goto L4d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L9e
            r1.<init>(r12)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r12 = r1.getString(r4)     // Catch: java.lang.Throwable -> L9e
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L9e
            if (r1 != 0) goto L4f
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch: java.lang.Throwable -> L9e
            android.content.SharedPreferences$Editor r12 = r0.remove(r12)     // Catch: java.lang.Throwable -> L9e
            r12.apply()     // Catch: java.lang.Throwable -> L9e
            goto L4f
        L9e:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.b(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r3 = r0.toString()
        Lbe:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lfc
            r12.<init>()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = "code"
            r1 = r8 ^ 1
            r12.put(r0, r1)     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = "message"
            r12.put(r0, r3)     // Catch: java.lang.Throwable -> Lfc
            r0 = 2
            if (r11 == 0) goto Le8
            if (r8 == 0) goto Le8
            com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Lfc
            byte[] r12 = r12.getBytes()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r12 = android.util.Base64.encodeToString(r12, r0)     // Catch: java.lang.Throwable -> Lfc
            r1.a(r11, r12)     // Catch: java.lang.Throwable -> Lfc
            goto Lff
        Le8:
            com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Lfc
            byte[] r12 = r12.getBytes()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r12 = android.util.Base64.encodeToString(r12, r0)     // Catch: java.lang.Throwable -> Lfc
            r1.b(r11, r12)     // Catch: java.lang.Throwable -> Lfc
            goto Lff
        Lfc:
            com.mbridge.msdk.foundation.tools.af.b(r6, r5)
        Lff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.removeCacheItem(java.lang.Object, java.lang.String):void");
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void removeFromSuperView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().h(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("removeFromSuperView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reportUrls(Object obj, String str) {
        af.a("JS-Video-Brigde", "reportUrls");
        try {
            if (TextUtils.isEmpty(str)) {
                g.a().b(obj, b(1));
                return;
            }
            IJSFactory iJSFactory = this.f6173a;
            if (iJSFactory == null || iJSFactory.getJSBTModule() == null) {
                d.c().b(obj, str);
            } else if (this.f6173a.getJSBTModule() instanceof j) {
                this.f6173a.getJSBTModule().reportUrls(obj, str);
            } else {
                d.c().b(obj, str);
            }
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("reportUrls error ", "JS-Video-Brigde", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCacheItem(java.lang.Object r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.setCacheItem(java.lang.Object, java.lang.String):void");
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setScaleFitXY(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("fitxy");
            af.c("JS-Video-Brigde", "setScaleFitXY,type:" + iOptInt);
            this.f6173a.getJSVideoModule().setScaleFitXY(iOptInt);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setSubPlayTemplateInfo(Object obj, String str) throws JSONException {
        af.b("JS-Video-Brigde", "setSubPlayTemplateInfo : " + str);
        a(obj, str);
        try {
            d.c().K(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("setSubPlayTemplateInfo error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewAlpha(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().q(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("setViewAlpha error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewBgColor(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().p(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("setViewBgColor error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewRect(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().g(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("setViewRect error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewScale(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().r(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("setViewScale error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showAlertView(Object obj, String str) {
        af.c("JS-Video-Brigde", "showAlertView");
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6173a.getJSVideoModule().showIVRewardAlertView(str);
            g.a().a(obj, "showAlertView", "");
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showAlertView", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showVideoClickView(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            af.c("JS-Video-Brigde", "showVideoClickView,type:" + iOptInt);
            this.f6173a.getJSContainerModule().showVideoClickView(iOptInt);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showVideoLocation(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("margin_top", 0);
            int iOptInt2 = jSONObject.optInt("margin_left", 0);
            int iOptInt3 = jSONObject.optInt("view_width", 0);
            int iOptInt4 = jSONObject.optInt("view_height", 0);
            int iOptInt5 = jSONObject.optInt("radius", 0);
            int iOptInt6 = jSONObject.optInt("border_top", 0);
            int iOptInt7 = jSONObject.optInt("border_left", 0);
            int iOptInt8 = jSONObject.optInt("border_width", 0);
            int iOptInt9 = jSONObject.optInt("border_height", 0);
            af.c("JS-Video-Brigde", "showVideoLocation,margin_top:" + iOptInt + ",marginLeft:" + iOptInt2 + ",viewWidth:" + iOptInt3 + ",viewHeight:" + iOptInt4 + ",radius:" + iOptInt5 + ",borderTop: " + iOptInt6 + ",borderLeft: " + iOptInt7 + ",borderWidth: " + iOptInt8 + ",borderHeight: " + iOptInt9);
            this.f6173a.getJSVideoModule().showVideoLocation(iOptInt, iOptInt2, iOptInt3, iOptInt4, iOptInt5, iOptInt6, iOptInt7, iOptInt8, iOptInt9);
            this.f6173a.getJSCommon().f();
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "showVideoLocation error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showView(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().o(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("showView error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void soundOperate(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
            int iOptInt2 = jSONObject.optInt("view_visible");
            String strOptString = jSONObject.optString("pt", "");
            af.c("JS-Video-Brigde", "soundOperate,mute:" + iOptInt + ",viewVisible:" + iOptInt2 + ",pt:" + strOptString);
            boolean zIsEmpty = TextUtils.isEmpty(strOptString);
            IJSFactory iJSFactory = this.f6173a;
            if (zIsEmpty) {
                iJSFactory.getJSVideoModule().soundOperate(iOptInt, iOptInt2);
            } else {
                iJSFactory.getJSVideoModule().soundOperate(iOptInt, iOptInt2, strOptString);
            }
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "soundOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void statistics(Object obj, String str) {
        af.c("JS-Video-Brigde", "statistics,params:" + str);
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f6173a.getJSCommon().a(jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), jSONObject.optString(DataSchemeDataSource.SCHEME_DATA));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "statistics error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            af.c("JS-Video-Brigde", "toggleCloseBtn,result:" + iOptInt);
            int i10 = 2;
            if (iOptInt != 1) {
                i10 = iOptInt == 2 ? 1 : 0;
            }
            this.f6173a.getJSVideoModule().closeVideoOperate(0, i10);
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void triggerCloseBtn(Object obj, String str) {
        af.c("JS-Video-Brigde", "triggerCloseBtn");
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str) || !new JSONObject(str).optString(MRAIDCommunicatorUtil.KEY_STATE).equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                return;
            }
            this.f6173a.getJSVideoModule().closeVideoOperate(1, -1);
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "triggerCloseBtn error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void videoOperate(Object obj, String str) {
        try {
            if (this.f6173a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("pause_or_resume");
            af.c("JS-Video-Brigde", "videoOperate,pauseOrResume:" + iOptInt);
            this.f6173a.getJSVideoModule().videoOperate(iOptInt);
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            af.b("JS-Video-Brigde", "videoOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewFireEvent(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().L(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("setSubPlayTemplateInfo error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewGoBack(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().v(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("webviewGoBack error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewGoForward(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().w(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("webviewGoForward error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewLoad(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().t(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("webviewLoad error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewReload(Object obj, String str) throws JSONException {
        a(obj, str);
        try {
            d.c().u(obj, new JSONObject(str));
        } catch (Throwable th) {
            com.mbridge.msdk.dycreator.baseview.a.u("webviewReload error ", "JS-Video-Brigde", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reportData(Object obj, String str) {
    }

    private String a(int i10) {
        switch (i10) {
            case 1:
                return "sdk_info";
            case 2:
                return MBridgeConstans.PROPERTIES_UNIT_ID;
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return "device";
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }
}
