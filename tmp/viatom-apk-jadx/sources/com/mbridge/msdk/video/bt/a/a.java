package com.mbridge.msdk.video.bt.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.b;
import com.mbridge.msdk.video.bt.module.BTBaseView;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC;
import com.mbridge.msdk.video.bt.module.MBridgeBTVideoView;
import com.mbridge.msdk.video.bt.module.MBridgeBTWebView;
import com.mbridge.msdk.video.signal.a.k;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, LinkedHashMap<String, View>> f5536a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static LinkedHashMap<String, String> f5537b = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static LinkedHashMap<String, CampaignEx> f5538c = new LinkedHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static LinkedHashMap<String, com.mbridge.msdk.videocommon.d.c> f5539d = new LinkedHashMap<>();
    private static LinkedHashMap<String, String> e = new LinkedHashMap<>();
    private static LinkedHashMap<String, Integer> f = new LinkedHashMap<>();
    private static LinkedHashMap<String, Activity> g = new LinkedHashMap<>();
    private static volatile int h = 10000;

    /* renamed from: i, reason: collision with root package name */
    private static int f5540i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static int f5541j = 1;

    /* renamed from: k, reason: collision with root package name */
    private static String f5542k = "";

    /* renamed from: l, reason: collision with root package name */
    private static int f5543l;

    /* renamed from: m, reason: collision with root package name */
    private static int f5544m;

    /* renamed from: n, reason: collision with root package name */
    private static int f5545n;

    /* renamed from: o, reason: collision with root package name */
    private static int f5546o;

    /* renamed from: p, reason: collision with root package name */
    private static int f5547p;

    public final void A(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                af.a("OperateViews", "playerStop failed instanceId not exit instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).stop();
                a(obj, strOptString2);
                af.a("OperateViews", "playerStop success");
            } else {
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerStop failed instanceId is not player instanceId = " + strOptString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("playerStop failed: "), "OperateViews");
        }
    }

    public final void B(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void C(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "playerMute failed: instanceId is not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerMute failed: instanceId is not player");
            } else if (((MBridgeBTVideoView) view).playMute()) {
                a(obj, strOptString2);
                af.a("OperateViews", "playerMute success");
            } else {
                c(obj, "set mute failed");
                af.a("OperateViews", "playerMute failed set mute failed");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("playerMute failed: "), "OperateViews");
        }
    }

    public final void D(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                af.a("OperateViews", "playerUnmute failed: instanceId not exit");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerUnmute failed: instanceId is not player");
            } else if (!((MBridgeBTVideoView) view).playUnMute()) {
                a(obj, "set unmute failed");
                af.a("OperateViews", "playerUnmute failed: set unmute failed");
            } else {
                a(obj, strOptString2);
                a(obj, "onUnmute", strOptString2);
                af.a("OperateViews", "playerUnmute successed");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("playerUnmute failed: "), "OperateViews");
        }
    }

    public final void E(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "playerGetMuteState failed instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerGetMuteState failed instanceId is not player");
                return;
            }
            int mute = ((MBridgeBTVideoView) view).getMute();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f5540i);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", strOptString2);
            jSONObject3.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, mute);
            jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject3);
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            af.a("OperateViews", "playerGetMuteState successed mute = " + mute);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("playerGetMuteState failed: "), "OperateViews");
        }
    }

    public final void F(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void G(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            } else {
                c(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void H(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBTempContainer)) {
                c(obj, "view not exist");
            } else {
                ((MBTempContainer) view).preload();
                a(obj, strOptString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("preloadSubPlayTemplateView failed: "), "OperateViews");
        }
    }

    public final void I(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (linkedHashMapB.size() <= 0) {
                c(obj, "unitId or instanceId not exist");
                af.a("OperateViews", "closeAd failed: unitId or instanceId not exist unitId = " + strOptString);
                return;
            }
            MBridgeBTContainer mBridgeBTContainer = null;
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTContainer) {
                    mBridgeBTContainer = (MBridgeBTContainer) view;
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onDestory();
                } else if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).getInstanceId();
                    b unused = b.a.f5559a;
                    ((MBridgeBTVideoView) view).onDestory();
                } else if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onDestroy();
                }
            }
            if (mBridgeBTContainer == null) {
                c(obj, "not found MBridgeBTContainer");
                af.a("OperateViews", "closeAd successed");
                return;
            }
            mBridgeBTContainer.onAdClose();
            f5536a.remove(linkedHashMapB);
            linkedHashMapB.clear();
            f5536a.remove(strOptString + "_" + strH);
            a(obj, strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("closeAd failed: "), "OperateViews");
        }
    }

    public final void J(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("eventName");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                c(obj, "unitId not exist");
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).broadcast(strOptString2, jSONObjectOptJSONObject);
                }
                if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).broadcast(strOptString2, jSONObjectOptJSONObject);
                }
            }
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("broadcast failed: "), "OperateViews");
        }
    }

    public final void K(Object obj, JSONObject jSONObject) throws JSONException {
        String str;
        com.mbridge.msdk.videocommon.b.c cVar;
        String strOptString;
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString3 = jSONObject.optString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            String strOptString4 = jSONObjectOptJSONObject.optString("userId");
            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("expired");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward");
            String strOptString5 = jSONObjectOptJSONObject.optString("extra");
            if (jSONObjectOptJSONObject2 != null) {
                str = "setSubPlayTemplateInfo failed: unitId not exist instanceId = ";
                cVar = new com.mbridge.msdk.videocommon.b.c(jSONObjectOptJSONObject2.optString(RewardPlus.NAME), jSONObjectOptJSONObject2.optInt(RewardPlus.AMOUNT));
                strOptString = jSONObjectOptJSONObject2.optString("id");
            } else {
                str = "setSubPlayTemplateInfo failed: unitId not exist instanceId = ";
                cVar = null;
                strOptString = "";
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString2, rid);
            if (linkedHashMapB.size() <= 0 || !e.containsKey(strOptString3)) {
                c(obj, "unitId not exist");
                af.a("OperateViews", str + strOptString3);
                return;
            }
            View view = linkedHashMapB.get(strOptString3);
            if (!(view instanceof MBTempContainer)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "setSubPlayTemplateInfo failed: instanceId not exist instanceId = " + strOptString3);
                return;
            }
            MBTempContainer mBTempContainer = (MBTempContainer) view;
            mBTempContainer.setReward(cVar);
            mBTempContainer.setUserId(strOptString4);
            mBTempContainer.setRewardId(strOptString);
            mBTempContainer.setCampaignExpired(zOptBoolean);
            if (!TextUtils.isEmpty(strOptString5)) {
                mBTempContainer.setDeveloperExtraData(strOptString5);
            }
            a(obj, strOptString3);
            af.a("OperateViews", "setSubPlayTemplateInfo success instanceId = " + strOptString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("setSubPlayTemplateInfo failed: "), "OperateViews");
        }
    }

    public final void L(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            String strOptString3 = jSONObjectOptJSONObject.optString("eventName");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("eventData");
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
            if (linkedHashMapB.size() <= 0) {
                c(obj, "unitId not exist");
                af.a("OperateViews", "webviewFireEvent failed: unitId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (childAt instanceof WindVaneWebView) {
                        g.a().a((WebView) childAt, strOptString3, Base64.encodeToString(jSONObjectOptJSONObject2.toString().getBytes(), 2));
                        a(obj, strOptString2);
                        af.a("OperateViews", "webviewFireEvent instanceId = " + strOptString2);
                        return;
                    }
                }
            }
            c(obj, "instanceId not exist");
            af.a("OperateViews", "webviewFireEvent failed: instanceId not exist instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("webviewFireEvent failed: "), "OperateViews");
        }
    }

    public final void M(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            final CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject);
            if (campaignWithBackData == null) {
                c(obj, "data camapign is empty");
            } else {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.video.bt.a.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            j jVarA = j.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
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
                            a.a(a.this, campaignWithBackData.getCampaignUnitId(), campaignWithBackData);
                        } catch (Throwable th) {
                            af.b("OperateViews", th.getMessage(), th);
                        }
                    }
                }).start();
                a(obj, "");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void N(Object obj, JSONObject jSONObject) throws JSONException {
        String str;
        int i10;
        boolean z9;
        String str2;
        File file;
        String str3 = "";
        JSONObject jSONObject2 = new JSONObject();
        int i11 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e3) {
                af.a("OperateViews", e3.getMessage());
                return;
            }
        }
        try {
            try {
                jSONObject2.put("code", 0);
                jSONObject2.put("message", "");
                JSONArray jSONArray = jSONObject.getJSONArray("resource");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject2.put("message", "resource is null");
                        g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    } catch (JSONException e7) {
                        af.a("OperateViews", e7.getMessage());
                        return;
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                int i12 = 0;
                while (i12 < length) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i12);
                    String strOptString = jSONObject3.optString("ref", str3);
                    int i13 = jSONObject3.getInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    JSONObject jSONObject4 = new JSONObject();
                    JSONArray jSONArray3 = jSONArray;
                    if (i13 != i11 || TextUtils.isEmpty(strOptString)) {
                        str = str3;
                        i10 = length;
                        z9 = false;
                        if (i13 == 2 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                            jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, H5DownLoadManager.getInstance().getH5ResAddress(strOptString) == null ? str : H5DownLoadManager.getInstance().getH5ResAddress(strOptString));
                            jSONObject4.put(strOptString, jSONObject5);
                            jSONArray2.put(jSONObject4);
                        } else if (i13 == 3 && !TextUtils.isEmpty(strOptString)) {
                            try {
                                file = new File(strOptString);
                            } catch (Throwable th) {
                                if (MBridgeConstans.DEBUG) {
                                    th.printStackTrace();
                                }
                            }
                            if (file.exists() && file.isFile() && file.canRead()) {
                                af.a("OperateViews", "getFileInfo Mraid file " + strOptString);
                                str2 = "file:////" + strOptString;
                            } else {
                                str2 = str;
                            }
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
                            jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str2);
                            jSONObject4.put(strOptString, jSONObject6);
                            jSONArray2.put(jSONObject4);
                        } else if (i13 == 4 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 4);
                            jSONObject7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, aj.a(strOptString) == null ? str : aj.a(strOptString));
                            jSONObject4.put(strOptString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        }
                    } else {
                        JSONObject jSONObject8 = new JSONObject();
                        m mVarA = n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(strOptString);
                        if (mVarA != null) {
                            af.a("OperateViews", "VideoBean not null");
                            jSONObject8.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                            i10 = length;
                            jSONObject8.put("videoDataLength", mVarA.d());
                            String strE = mVarA.e();
                            if (TextUtils.isEmpty(strE)) {
                                af.a("OperateViews", "VideoPath null");
                                jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str3);
                                jSONObject8.put("path4Web", str3);
                                str = str3;
                            } else {
                                str = str3;
                                af.a("OperateViews", "VideoPath not null");
                                jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, strE);
                                jSONObject8.put("path4Web", strE);
                            }
                            if (mVarA.b() == 5) {
                                jSONObject8.put("downloaded", 1);
                                z9 = false;
                            } else {
                                z9 = false;
                                jSONObject8.put("downloaded", 0);
                            }
                            jSONObject4.put(strOptString, jSONObject8);
                            jSONArray2.put(jSONObject4);
                        } else {
                            str = str3;
                            i10 = length;
                            z9 = false;
                            af.a("OperateViews", "VideoBean null");
                        }
                    }
                    i12++;
                    jSONArray = jSONArray3;
                    length = i10;
                    str3 = str;
                    i11 = 1;
                }
                jSONObject2.put("resource", jSONArray2);
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (Throwable th2) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", th2.getLocalizedMessage());
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            jSONObject2.put("code", 1);
            jSONObject2.put("message", th2.getLocalizedMessage());
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            return;
        } catch (JSONException e10) {
            af.a("OperateViews", e10.getMessage());
            return;
        }
    }

    public final void O(Object obj, JSONObject jSONObject) throws JSONException {
        af.a("OperateViews", "createNativeEC:" + jSONObject);
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String rid = "";
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (campaignWithBackData != null && !TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                    rid = campaignWithBackData.getRequestId();
                }
                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.c.a(jSONObjectOptJSONObject.optJSONObject("unitSetting"));
                if (cVarA != null) {
                    cVarA.a(strOptString);
                }
                MBridgeBTNativeEC mBridgeBTNativeEC = new MBridgeBTNativeEC(com.mbridge.msdk.foundation.controller.c.m().c());
                mBridgeBTNativeEC.setCampaign(campaignWithBackData);
                k kVar = new k(null, campaignWithBackData);
                kVar.a(strOptString);
                mBridgeBTNativeEC.setJSCommon(kVar);
                mBridgeBTNativeEC.setUnitId(strOptString);
                mBridgeBTNativeEC.setRewardUnitSetting(cVarA);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
                if (windVaneWebView != null) {
                    rid = windVaneWebView.getRid();
                    mBridgeBTNativeEC.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strA = a();
                f5537b.put(strA, rid);
                mBridgeBTNativeEC.setInstanceId(strA);
                linkedHashMapB.put(strA, mBridgeBTNativeEC);
                mBridgeBTNativeEC.preLoadData();
                if (campaignWithBackData == null) {
                    c(obj, "campaign is null");
                    af.a("OperateViews", "createNativeEC failed");
                    return;
                } else {
                    a(obj, strA);
                    af.a("OperateViews", "createNativeEC instanceId = " + strA);
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("createNativeEC failed："), "OperateViews");
        }
    }

    public final void a(Object obj, JSONObject jSONObject, boolean z9) throws JSONException {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + strOptString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                iOptInt = jSONObjectOptJSONObject2.optInt("width");
                iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt = ((BTBaseView) view).getViewWidth();
                iOptInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                iOptInt = 0;
                rect = null;
                iOptInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt, iOptInt2);
            if (z9) {
                at.a(view);
            }
            viewGroup.addView(view, iIndexOfChild + 1, layoutParamsA);
            a(obj, strOptString2);
            a(obj, "onInsertViewAbove", strOptString2);
            af.a("OperateViews", "insertViewAbove instanceId = " + strOptString2 + " brotherId = " + strOptString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("insertViewAbove failed: "), "OperateViews");
        }
    }

    public final void b(Object obj, JSONObject jSONObject, boolean z9) throws JSONException {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "insertViewBelow failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "insertViewBelow failed: view not exist instanceId = " + strOptString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                iOptInt = jSONObjectOptJSONObject2.optInt("width");
                iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt = ((BTBaseView) view).getViewWidth();
                iOptInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                rect = null;
                iOptInt = 0;
                iOptInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt, iOptInt2);
            if (z9) {
                at.a(view);
            }
            int i10 = iIndexOfChild - 1;
            viewGroup.addView(view, i10 > -1 ? i10 : 0, layoutParamsA);
            a(obj, strOptString2);
            a(obj, "onInsertViewBelow", strOptString2);
            af.a("OperateViews", "insertViewBelow instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("insertViewBelow failed: "), "OperateViews");
        }
    }

    public final void c(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String rid = "";
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (campaignWithBackData != null && !TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                    rid = campaignWithBackData.getRequestId();
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("show_time", 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("show_mute", 0);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("show_close", 0);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("orientation", 1);
                int iOptInt5 = jSONObjectOptJSONObject.optInt("show_pgb", 0);
                MBridgeBTVideoView mBridgeBTVideoView = new MBridgeBTVideoView(com.mbridge.msdk.foundation.controller.c.m().c());
                try {
                    k kVar = (k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b.getObject();
                    mBridgeBTVideoView.setAdEvents(kVar.l());
                    mBridgeBTVideoView.setAdSession(kVar.j());
                    mBridgeBTVideoView.setVideoEvents(kVar.k());
                } catch (Exception e3) {
                    af.b("OperateViews", e3.getMessage());
                }
                mBridgeBTVideoView.setCampaign(campaignWithBackData);
                mBridgeBTVideoView.setUnitId(strOptString);
                mBridgeBTVideoView.setShowMute(iOptInt2);
                mBridgeBTVideoView.setShowTime(iOptInt);
                mBridgeBTVideoView.setShowClose(iOptInt3);
                mBridgeBTVideoView.setOrientation(iOptInt4);
                mBridgeBTVideoView.setProgressBarState(iOptInt5);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
                if (windVaneWebView != null) {
                    rid = windVaneWebView.getRid();
                    mBridgeBTVideoView.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strA = a();
                f5537b.put(strA, rid);
                mBridgeBTVideoView.setInstanceId(strA);
                linkedHashMapB.put(strA, mBridgeBTVideoView);
                mBridgeBTVideoView.preLoadData();
                if (campaignWithBackData == null) {
                    c(obj, "campaign is null");
                    af.a("OperateViews", "createPlayerView failed");
                } else {
                    a(obj, strA);
                    af.a("OperateViews", "createPlayerView instanceId = " + strA);
                }
                b unused = b.a.f5559a;
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("createPlayerView failed："), "OperateViews");
        }
    }

    public final void d(Object obj, JSONObject jSONObject) throws JSONException {
        String str;
        WindVaneWebView windVaneWebView;
        String str2 = "OperateViews";
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                int iOptInt = jSONObjectOptJSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                String rid = "";
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (campaignWithBackData != null && !TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                    rid = campaignWithBackData.getRequestId();
                }
                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.c.a(jSONObjectOptJSONObject.optJSONObject("unitSetting"));
                if (cVarA != null) {
                    cVarA.a(strOptString);
                }
                String strOptString2 = jSONObjectOptJSONObject.optString("userId");
                if (TextUtils.isEmpty(rid) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                    rid = windVaneWebView.getRid();
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strA = a();
                f5537b.put(strA, rid);
                MBTempContainer mBTempContainer = new MBTempContainer(com.mbridge.msdk.foundation.controller.c.m().c());
                try {
                    k kVar = (k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b.getObject();
                    mBTempContainer.setAdEvents(kVar.l());
                    mBTempContainer.setAdSession(kVar.j());
                    mBTempContainer.setVideoEvents(kVar.k());
                } catch (Exception e3) {
                    af.b("OperateViews", e3.getMessage());
                }
                mBTempContainer.setInstanceId(strA);
                mBTempContainer.setUnitId(strOptString);
                mBTempContainer.setCampaign(campaignWithBackData);
                mBTempContainer.setRewardUnitSetting(cVarA);
                mBTempContainer.setBigOffer(true);
                if (!TextUtils.isEmpty(strOptString2)) {
                    mBTempContainer.setUserId(strOptString2);
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward");
                if (jSONObjectOptJSONObject2 != null) {
                    try {
                        String strOptString3 = jSONObjectOptJSONObject2.optString("id");
                        str = "OperateViews";
                        try {
                            com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(jSONObjectOptJSONObject2.optString(RewardPlus.NAME), jSONObjectOptJSONObject2.optInt(RewardPlus.AMOUNT));
                            if (!TextUtils.isEmpty(strOptString3)) {
                                mBTempContainer.setRewardId(strOptString3);
                            }
                            if (!TextUtils.isEmpty(cVar.a())) {
                                mBTempContainer.setReward(cVar);
                            }
                        } catch (Throwable th) {
                            th = th;
                            str2 = str;
                            c(obj, th.getMessage());
                            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("createSubPlayTemplateView failed："), str2);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c(obj, th.getMessage());
                        com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("createSubPlayTemplateView failed："), str2);
                        return;
                    }
                } else {
                    str = "OperateViews";
                }
                String strOptString4 = jSONObjectOptJSONObject.optString("extra");
                if (!TextUtils.isEmpty(strOptString4)) {
                    mBTempContainer.setDeveloperExtraData(strOptString4);
                }
                mBTempContainer.setMute(iOptInt);
                linkedHashMapB.put(strA, mBTempContainer);
                e.put(strA, strOptString);
                f5538c.put(strA, campaignWithBackData);
                f5539d.put(strA, cVarA);
                a(obj, strA);
                af.a(str, "createSubPlayTemplateView instanceId = " + strA);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void e(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) != null && !TextUtils.isEmpty(strOptString)) {
                String strH = h(strOptString2);
                if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                    strH = windVaneWebView.getRid();
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (linkedHashMapB == null || !linkedHashMapB.containsKey(strOptString2)) {
                    c(obj, "unitId or instanceId not exist");
                    af.a("OperateViews", "destroyComponent failed");
                    return;
                }
                View view = linkedHashMapB.get(strOptString2);
                linkedHashMapB.remove(strOptString2);
                if (view != null && view.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) view;
                        if (viewGroup2.getChildCount() > 0) {
                            int childCount = viewGroup2.getChildCount();
                            for (int i10 = 0; i10 < childCount; i10++) {
                                View childAt = viewGroup2.getChildAt(i10);
                                if (childAt instanceof MBridgeBTWebView) {
                                    linkedHashMapB.remove(((MBridgeBTWebView) childAt).getInstanceId());
                                    ((MBridgeBTWebView) childAt).onDestory();
                                } else if (childAt instanceof MBridgeBTVideoView) {
                                    linkedHashMapB.remove(((MBridgeBTVideoView) childAt).getInstanceId());
                                    ((MBridgeBTVideoView) childAt).onDestory();
                                } else if (childAt instanceof MBTempContainer) {
                                    linkedHashMapB.remove(((MBTempContainer) childAt).getInstanceId());
                                    ((MBTempContainer) childAt).onDestroy();
                                }
                            }
                        }
                    }
                }
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onDestroy();
                }
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onDestory();
                }
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onDestory();
                }
                a(obj, strOptString2);
                a(obj, "onComponentDestroy", strOptString2);
                af.a("OperateViews", "destroyComponent instanceId = " + strOptString2);
                return;
            }
            c(obj, "unidId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            af.a("OperateViews", "destroyComponent failed");
        }
    }

    public final void f(String str) {
        if (e.containsKey(str)) {
            e.remove(str);
        }
        if (f5539d.containsKey(str)) {
            f5539d.remove(str);
        }
        if (f5538c.containsKey(str)) {
            f5538c.remove(str);
        }
        if (f5537b.containsKey(str)) {
            f5537b.remove(str);
        }
    }

    public final void g(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            if (jSONObjectOptJSONObject2 == null) {
                c(obj, "rect not exist");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            Rect rect = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
            int iOptInt = jSONObjectOptJSONObject2.optInt("width");
            int iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "setViewRect failed: instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view is null");
                af.a("OperateViews", "setViewRect failed: view is null");
                return;
            }
            if (view.getParent() != null) {
                view.setLayoutParams(a(view.getLayoutParams(), rect, iOptInt, iOptInt2));
                view.requestLayout();
            } else {
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).setRect(rect);
                    ((MBridgeBTWebView) view).setLayout(iOptInt, iOptInt2);
                }
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).setRect(rect);
                    ((MBridgeBTVideoView) view).setLayout(iOptInt, iOptInt2);
                }
            }
            a(obj, strOptString2);
            a(obj, "onViewRectChanged", strOptString2);
            af.a("OperateViews", "setViewRect instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("setViewRect failed: "), "OperateViews");
        }
    }

    public final void h(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "params not enough");
                af.a("OperateViews", "removeFromSuperView failed: params not enough instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                af.a("OperateViews", "removeFromSuperView failed: view is null instanceId = " + strOptString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                af.a("OperateViews", "removeFromSuperView failed: parent is null instanceId = " + strOptString2);
                return;
            }
            viewGroup.removeView(view);
            a(obj, strOptString2);
            a(obj, "onRemoveFromView", strOptString2);
            af.a("OperateViews", "removeFromSuperView instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("removeFromSuperView failed: "), "OperateViews");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d6, code lost:
    
        com.mbridge.msdk.foundation.tools.at.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d9, code lost:
    
        r0 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r9;
        r6 = (com.mbridge.msdk.video.signal.a.k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) r18).f4406b.getObject();
        r0.setAdEvents(r6.l());
        r0.setAdSession(r6.j());
        r0.setVideoEvents(r6.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00fd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fe, code lost:
    
        com.mbridge.msdk.foundation.tools.af.b("OperateViews", r0.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.Object r18, org.json.JSONObject r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.a.i(java.lang.Object, org.json.JSONObject):void");
    }

    public final void j(Object obj, JSONObject jSONObject) throws JSONException {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String strOptString3 = jSONObjectOptJSONObject.optString("id");
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                    c(obj, "instanceId is not exist");
                    af.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString3);
                View view = linkedHashMapB.get(strOptString2);
                at.a(view);
                if (viewGroup != null && view != null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        Iterator<View> it = linkedHashMapB.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                at.a(view);
                                ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, jSONObjectOptJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (jSONObjectOptJSONObject2 != null) {
                            Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                            iOptInt = jSONObjectOptJSONObject2.optInt("width");
                            iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            iOptInt = ((BTBaseView) view).getViewWidth();
                            iOptInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            iOptInt = 0;
                            rect = null;
                            iOptInt2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt, iOptInt2);
                        at.a(view);
                        viewGroup.addView(view, layoutParamsA);
                    }
                    a(obj, strOptString2);
                    a(obj, "onAppendViewTo", strOptString2);
                    af.a("OperateViews", "appendViewTo parentId = " + strOptString3 + " childId = " + strOptString2);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("appendViewTo failed: "), "OperateViews");
        }
    }

    public final void k(Object obj, JSONObject jSONObject) throws JSONException {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("id");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString3) || !linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId is not exist");
                af.a("OperateViews", "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString2);
            View view = linkedHashMapB.get(strOptString3);
            if (viewGroup != null && view != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                if (view instanceof MBTempContainer) {
                    af.b("OperateViews", "OperateViews setNotchString = ".concat(String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(f5543l), Integer.valueOf(f5544m), Integer.valueOf(f5545n), Integer.valueOf(f5546o), Integer.valueOf(f5547p))));
                    ((MBTempContainer) view).setNotchPadding(f5543l, f5544m, f5545n, f5546o, f5547p);
                    Iterator<View> it = linkedHashMapB.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        View next = it.next();
                        if (next instanceof MBridgeBTContainer) {
                            at.a(view);
                            ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, jSONObjectOptJSONObject2);
                            break;
                        }
                    }
                } else {
                    if (jSONObjectOptJSONObject2 != null) {
                        Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                        iOptInt = jSONObjectOptJSONObject2.optInt("width");
                        iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                        rect = rect2;
                    } else if (view instanceof BTBaseView) {
                        rect = ((BTBaseView) view).getRect();
                        iOptInt = ((BTBaseView) view).getViewWidth();
                        iOptInt2 = ((BTBaseView) view).getViewHeight();
                    } else {
                        rect = null;
                        iOptInt2 = 0;
                        iOptInt = 0;
                    }
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    viewGroup.addView(view, a(layoutParams, rect, iOptInt, iOptInt2));
                }
                a(obj, strOptString2);
                a(obj, "onAppendView", strOptString2);
                af.a("OperateViews", "appendSubView parentId = " + strOptString2 + " childId = " + strOptString3);
                return;
            }
            c(obj, "view is not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("appendSubView failed: "), "OperateViews");
        }
    }

    public final void l(Object obj, JSONObject jSONObject) throws JSONException {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String strOptString3 = jSONObjectOptJSONObject.optString("id");
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                    c(obj, "instanceId is not exist");
                    af.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString3);
                View view = linkedHashMapB.get(strOptString2);
                if (viewGroup != null && view != null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        Iterator<View> it = linkedHashMapB.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                at.a(view);
                                ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, jSONObjectOptJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (jSONObjectOptJSONObject2 != null) {
                            Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                            iOptInt = jSONObjectOptJSONObject2.optInt("width");
                            iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            iOptInt = ((BTBaseView) view).getViewWidth();
                            iOptInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            iOptInt = 0;
                            rect = null;
                            iOptInt2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        viewGroup.addView(view, a(layoutParams, rect, iOptInt, iOptInt2));
                    }
                    a(obj, strOptString2);
                    a(obj, "onAppendViewTo", strOptString2);
                    af.a("OperateViews", "appendViewTo parentId = " + strOptString3 + " childId = " + strOptString2);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("appendViewTo failed: "), "OperateViews");
        }
    }

    public final void m(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId is not exist");
                af.a("OperateViews", "bringViewToFront failed: instanceId is not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                af.a("OperateViews", "bringViewToFront failed: view is null");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                af.a("OperateViews", "bringViewToFront failed: parent is null");
                return;
            }
            viewGroup.bringChildToFront(view);
            a(obj, strOptString2);
            a(obj, "onBringViewToFront", strOptString2);
            af.a("OperateViews", "bringViewToFront instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("bringViewToFront failed: "), "OperateViews");
        }
    }

    public final void n(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "hideView failed: instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "hideView failed: view not exist");
                return;
            }
            view.setVisibility(8);
            a(obj, strOptString2);
            a(obj, "onHideView", strOptString2);
            af.a("OperateViews", "hideView instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("hideView failed: + "), "OperateViews");
        }
    }

    public final void o(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "showView failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "showView failed: view not exist instanceId = " + strOptString2);
                return;
            }
            view.setVisibility(0);
            a(obj, strOptString2);
            a(obj, "onShowView", strOptString2);
            af.a("OperateViews", "showView instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("showView failed: "), "OperateViews");
        }
    }

    public final void p(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("color");
            if (TextUtils.isEmpty(strOptString3)) {
                c(obj, "color is not exist");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "setViewBgColor failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "setViewBgColor failed: view not exist instanceId = " + strOptString2);
                return;
            }
            a(obj, strOptString2);
            view.setBackgroundColor(Color.parseColor(strOptString3));
            a(obj, "onViewBgColorChanged", strOptString2);
            af.a("OperateViews", "setViewBgColor instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("setViewBgColor failed: "), "OperateViews");
        }
    }

    public final void q(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double dOptDouble = jSONObjectOptJSONObject.optDouble("alpha", 1.0d);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "setViewAlpha failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "setViewAlpha failed: view not exist instanceId = " + strOptString2);
                return;
            }
            view.setAlpha((float) dOptDouble);
            a(obj, strOptString2);
            a(obj, "onViewAlphaChanged", strOptString2);
            af.a("OperateViews", "setViewAlpha instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("setViewAlpha failed: "), "OperateViews");
        }
    }

    public final void r(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double dOptDouble = jSONObjectOptJSONObject.optDouble("vertical", 1.0d);
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble("horizon", 1.0d);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "setViewScale failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "setViewScale failed: view not exist instanceId = " + strOptString2);
                return;
            }
            view.setScaleX((float) dOptDouble2);
            view.setScaleY((float) dOptDouble);
            a(obj, strOptString2);
            a(obj, "onViewScaleChanged", strOptString2);
            af.a("OperateViews", "setViewScale instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("setViewScale failed: "), "OperateViews");
        }
    }

    public final void s(Object obj, JSONObject jSONObject) throws JSONException {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                af.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + strOptString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                iOptInt = jSONObjectOptJSONObject2.optInt("width");
                iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt = ((BTBaseView) view).getViewWidth();
                iOptInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                iOptInt = 0;
                rect = null;
                iOptInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, iIndexOfChild + 1, a(layoutParams, rect, iOptInt, iOptInt2));
            a(obj, strOptString2);
            a(obj, "onInsertViewAbove", strOptString2);
            af.a("OperateViews", "insertViewAbove instanceId = " + strOptString2 + " brotherId = " + strOptString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("insertViewAbove failed: "), "OperateViews");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(Object obj, JSONObject jSONObject) throws JSONException {
        String str;
        Object obj2;
        String str2;
        int iOptInt;
        Rect rect;
        Object obj3;
        int i10;
        WindVaneWebView windVaneWebView;
        Object obj4 = obj;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj4).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject == null) {
                c(obj4, "data is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("content");
            if (jSONObjectOptJSONObject2 == null) {
                c(obj4, "content is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject2.optString("fileURL");
            String strOptString4 = jSONObjectOptJSONObject2.optString("filePath");
            String strOptString5 = jSONObjectOptJSONObject2.optString("html");
            if (TextUtils.isEmpty(strOptString3) && TextUtils.isEmpty(strOptString4) && TextUtils.isEmpty(strOptString5)) {
                c(obj4, "url is empty");
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("campaigns");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int length = jSONArrayOptJSONArray.length();
                int i11 = 0;
                while (i11 < length) {
                    JSONArray jSONArray = jSONArrayOptJSONArray;
                    CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONArrayOptJSONArray.getJSONObject(i11));
                    if (campaignWithBackData != null) {
                        campaignWithBackData.setCampaignUnitId(strOptString);
                        arrayList.add(campaignWithBackData);
                    }
                    i11++;
                    jSONArrayOptJSONArray = jSONArray;
                }
            }
            String strOptString6 = jSONObjectOptJSONObject2.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.c.a(jSONObjectOptJSONObject2.optJSONObject("unitSetting"));
            if (cVarA != null) {
                cVarA.a(strOptString6);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (jSONObjectOptJSONObject3 != null) {
                try {
                    str2 = "OperateViews";
                    try {
                        Rect rect3 = new Rect(jSONObjectOptJSONObject3.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject3.optInt("top", -999), jSONObjectOptJSONObject3.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject3.optInt("bottom", -999));
                        int iOptInt2 = jSONObjectOptJSONObject3.optInt("width");
                        iOptInt = jSONObjectOptJSONObject3.optInt("height");
                        rect = rect3;
                        i10 = iOptInt2;
                    } catch (Throwable th) {
                        th = th;
                        obj3 = obj;
                        str = str2;
                        obj2 = obj3;
                        c(obj2, th.getMessage());
                        com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("webviewLoad failed: "), str);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = "OperateViews";
                    obj3 = obj;
                    str = str2;
                    obj2 = obj3;
                    c(obj2, th.getMessage());
                    com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("webviewLoad failed: "), str);
                }
            } else {
                str2 = "OperateViews";
                iOptInt = 0;
                i10 = 0;
                rect = rect2;
            }
            int iOptInt3 = jSONObjectOptJSONObject2.optInt("refreshCache", 0);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            try {
                if (!linkedHashMapB.containsKey(strOptString2)) {
                    c(obj, "instanceId not exist");
                    af.a(str2, "webviewLoad failed: instanceId not exist instanceId = " + strOptString2);
                    return;
                }
                View view = linkedHashMapB.get(strOptString2);
                if (!(view instanceof MBridgeBTWebView)) {
                    c(obj, "view not exist");
                    af.a(str2, "webviewLoad failed: view not exist instanceId = " + strOptString2);
                    return;
                }
                MBridgeBTWebView mBridgeBTWebView = (MBridgeBTWebView) view;
                mBridgeBTWebView.setHtml(strOptString5);
                mBridgeBTWebView.setFilePath(strOptString4);
                mBridgeBTWebView.setFileURL(strOptString3);
                mBridgeBTWebView.setRect(rect);
                mBridgeBTWebView.setLayout(i10, iOptInt);
                mBridgeBTWebView.setCampaigns(arrayList);
                mBridgeBTWebView.setRewardUnitSetting(cVarA);
                mBridgeBTWebView.webviewLoad(iOptInt3);
                Object obj5 = obj;
                try {
                    a(obj5, strOptString2);
                    af.a(str2, "webviewLoad instanceId = " + strOptString2);
                } catch (Throwable th3) {
                    th = th3;
                    obj3 = obj5;
                    str = str2;
                    obj2 = obj3;
                    c(obj2, th.getMessage());
                    com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("webviewLoad failed: "), str);
                }
            } catch (Throwable th4) {
                th = th4;
                obj2 = i10;
                str = rect;
                c(obj2, th.getMessage());
                com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("webviewLoad failed: "), str);
            }
        } catch (Throwable th5) {
            th = th5;
            str = "OperateViews";
            obj2 = obj4;
        }
    }

    public final void u(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "webviewReload failed instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTWebView)) {
                c(obj, "view not exist");
                af.a("OperateViews", "webviewReload failed view not exist instanceId = " + strOptString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewReload()) {
                a(obj, strOptString2);
                af.a("OperateViews", "webviewReload instanceId = " + strOptString2);
                return;
            }
            c(obj, "reload failed");
            af.a("OperateViews", "webviewReload failed reload failed instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("webviewReload failed: "), "OperateViews");
        }
    }

    public final void v(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "webviewGoBack failed instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTWebView)) {
                c(obj, "view not exist");
                af.a("OperateViews", "webviewGoBack failed view not exist instanceId = " + strOptString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewGoBack()) {
                a(obj, strOptString2);
                af.a("OperateViews", "webviewGoBack instanceId = " + strOptString2);
                return;
            }
            c(obj, "webviewGoBack failed");
            af.a("OperateViews", "webviewGoBack failed instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("webviewGoBack failed: "), "OperateViews");
        }
    }

    public final void w(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                af.a("OperateViews", "webviewGoForward failed instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTWebView)) {
                c(obj, "view not exist");
                af.a("OperateViews", "webviewGoForward failed view not exist instanceId = " + strOptString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewGoForward()) {
                a(obj, strOptString2);
                af.a("OperateViews", "webviewGoForward instanceId = " + strOptString2);
                return;
            }
            c(obj, "webviewGoForward failed");
            af.a("OperateViews", "webviewGoForward failed instanceId = " + strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("webviewGoForward failed: "), "OperateViews");
        }
    }

    public final void x(Object obj, JSONObject jSONObject) throws JSONException {
        MBridgeBTContainer mBridgeBTContainer;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                af.a("OperateViews", "playerPlay failed instanceId not exit instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerPlay failed instanceId is not player instanceId = " + strOptString2);
                return;
            }
            MBridgeBTVideoView mBridgeBTVideoView = (MBridgeBTVideoView) view;
            LinkedHashMap<String, View> linkedHashMapB2 = b(strOptString, strH);
            if (linkedHashMapB2.size() > 0) {
                for (View view2 : linkedHashMapB2.values()) {
                    if (view2 instanceof MBridgeBTContainer) {
                        mBridgeBTContainer = (MBridgeBTContainer) view2;
                        break;
                    }
                }
                mBridgeBTContainer = null;
            } else {
                mBridgeBTContainer = null;
            }
            if (mBridgeBTContainer != null) {
                mBridgeBTVideoView.setAdEvents(mBridgeBTContainer.getAdEvents());
                mBridgeBTVideoView.setAdSession(mBridgeBTContainer.getAdSession());
                mBridgeBTVideoView.setVideoEvents(mBridgeBTContainer.getVideoEvents());
            }
            mBridgeBTVideoView.play();
            a(obj, strOptString2);
            af.a("OperateViews", "playerPlay success");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("playerPlay failed: "), "OperateViews");
        }
    }

    public final void y(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                af.a("OperateViews", "playerPause failed instanceId not exit instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).pause();
                a(obj, strOptString2);
                af.a("OperateViews", "playerPause success");
            } else {
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerPause failed instanceId is not player instanceId = " + strOptString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("playerPause failed: "), "OperateViews");
        }
    }

    public final void z(Object obj, JSONObject jSONObject) throws JSONException {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                af.a("OperateViews", "playerResume failed instanceId not exit instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).resume();
                a(obj, strOptString2);
                af.a("OperateViews", "playerResume success");
            } else {
                c(obj, "instanceId is not player");
                af.a("OperateViews", "playerResume failed instanceId is not player instanceId = " + strOptString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("playerResume failed: "), "OperateViews");
        }
    }

    public final void f(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString = jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            } else {
                a(obj, strOptString);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    private String h(String str) {
        if (f5537b.containsKey(str)) {
            return f5537b.get(str);
        }
        return "";
    }

    public final void g(String str) {
        if (f.containsKey(str)) {
            f.remove(str);
        }
    }

    private void c(Object obj, String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f5541j);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e3) {
            af.a("OperateViews", e3.getMessage());
        }
    }

    public final String c(String str) {
        if (e.containsKey(str)) {
            return e.get(str);
        }
        return "";
    }

    public final int e(String str) {
        if (f.containsKey(str)) {
            return f.get(str).intValue();
        }
        return 2;
    }

    public final com.mbridge.msdk.videocommon.d.c b(String str) {
        if (f5539d.containsKey(str)) {
            return f5539d.get(str);
        }
        return null;
    }

    public final synchronized LinkedHashMap<String, View> b(String str, String str2) {
        if (f5536a.containsKey(str + "_" + str2)) {
            return f5536a.get(str + "_" + str2);
        }
        LinkedHashMap<String, View> linkedHashMap = new LinkedHashMap<>();
        f5536a.put(str + "_" + str2, linkedHashMap);
        return linkedHashMap;
    }

    public final CampaignEx a(String str) {
        if (f5538c.containsKey(str)) {
            return f5538c.get(str);
        }
        return null;
    }

    public final void a(String str, String str2) {
        f5537b.put(str, str2);
    }

    public final void a(String str, Activity activity) {
        g.put(str, activity);
    }

    public final void b(Object obj, JSONObject jSONObject) throws JSONException {
        final Object obj2;
        Throwable th;
        final int i10;
        final int iOptInt;
        try {
            final String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            try {
                if (TextUtils.isEmpty(strOptString)) {
                    c(obj, "unitId is empty");
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("delay", 0);
                final String strOptString2 = jSONObjectOptJSONObject.optString("fileURL");
                final String strOptString3 = jSONObjectOptJSONObject.optString("filePath");
                final String strOptString4 = jSONObjectOptJSONObject.optString("html");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                Rect rect = new Rect(-999, -999, -999, -999);
                if (jSONObjectOptJSONObject2 != null) {
                    rect = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                    int iOptInt3 = jSONObjectOptJSONObject2.optInt("width");
                    iOptInt = jSONObjectOptJSONObject2.optInt("height");
                    i10 = iOptInt3;
                } else {
                    i10 = 0;
                    iOptInt = 0;
                }
                final Rect rect2 = rect;
                obj2 = obj;
                try {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.bt.a.a.2
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException {
                            String rid;
                            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj2).f4406b;
                            if (windVaneWebView != null) {
                                rid = windVaneWebView.getRid();
                            } else {
                                rid = "";
                                windVaneWebView = null;
                            }
                            LinkedHashMap<String, View> linkedHashMapB = a.this.b(strOptString, rid);
                            String strA = a.this.a();
                            a.f5537b.put(strA, rid);
                            MBridgeBTWebView mBridgeBTWebView = new MBridgeBTWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                            linkedHashMapB.put(strA, mBridgeBTWebView);
                            mBridgeBTWebView.setInstanceId(strA);
                            mBridgeBTWebView.setUnitId(strOptString);
                            mBridgeBTWebView.setFileURL(strOptString2);
                            mBridgeBTWebView.setFilePath(strOptString3);
                            mBridgeBTWebView.setHtml(strOptString4);
                            mBridgeBTWebView.setRect(rect2);
                            mBridgeBTWebView.setWebViewRid(rid);
                            mBridgeBTWebView.setCreateWebView(windVaneWebView);
                            int i11 = i10;
                            if (i11 > 0 || iOptInt > 0) {
                                mBridgeBTWebView.setLayout(i11, iOptInt);
                            }
                            mBridgeBTWebView.preload();
                            a.this.a(obj2, strA);
                            af.a("OperateViews", "createWebview instanceId = " + strA);
                        }
                    }, iOptInt2);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    c(obj2, th.getMessage());
                    com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("createWebview failed："), "OperateViews");
                }
            } catch (Throwable th3) {
                th = th3;
                obj2 = obj;
                c(obj2, th.getMessage());
                com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("createWebview failed："), "OperateViews");
            }
        } catch (Throwable th4) {
            th = th4;
            obj2 = obj;
        }
    }

    public final void a(String str, int i10) {
        f.put(str, Integer.valueOf(i10));
    }

    public final void a(WebView webView, String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f5541j);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(webView, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e3) {
            af.a("OperateViews", e3.getMessage());
        }
    }

    public final void a(Object obj, String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f5540i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e3) {
            c(obj, e3.getMessage());
            af.a("OperateViews", e3.getMessage());
        }
    }

    public final void d(String str) {
        g.remove(str);
    }

    private void a(Object obj, String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f5540i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e3) {
            c(obj, e3.getMessage());
            af.a("OperateViews", e3.getMessage());
        }
    }

    public final void b(Object obj, String str) {
        af.a("OperateViews", "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                int iOptInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                String strA = ak.a(jSONObject.optString("url"), "&tun=", ab.q() + "");
                int iOptInt2 = jSONObject.optInt("report");
                if (iOptInt2 == 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), (CampaignEx) null, "", strA, false, iOptInt != 0);
                } else {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), (CampaignEx) null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(obj, "");
        } catch (Throwable th2) {
            th = th2;
            af.b("OperateViews", "reportUrls", th);
        }
    }

    public final void a(WebView webView, String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f5540i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e3) {
            a(webView, e3.getMessage());
            af.a("OperateViews", e3.getMessage());
        }
    }

    public final void a(Object obj, JSONObject jSONObject) throws JSONException {
        final Object obj2;
        Throwable th;
        final int i10;
        final int iOptInt;
        try {
            final String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            try {
                if (TextUtils.isEmpty(strOptString)) {
                    c(obj, "unitId is empty");
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("delay", 0);
                jSONObjectOptJSONObject.optString("fileURL");
                jSONObjectOptJSONObject.optString("filePath");
                jSONObjectOptJSONObject.optString("html");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                Rect rect = new Rect(-999, -999, -999, -999);
                if (jSONObjectOptJSONObject2 != null) {
                    rect = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                    int iOptInt3 = jSONObjectOptJSONObject2.optInt("width");
                    iOptInt = jSONObjectOptJSONObject2.optInt("height");
                    i10 = iOptInt3;
                } else {
                    i10 = 0;
                    iOptInt = 0;
                }
                final Rect rect2 = rect;
                obj2 = obj;
                try {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.bt.a.a.1
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException {
                            String rid;
                            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj2).f4406b;
                            if (windVaneWebView != null) {
                                rid = windVaneWebView.getRid();
                            } else {
                                rid = "";
                                windVaneWebView = null;
                            }
                            LinkedHashMap<String, View> linkedHashMapB = a.this.b(strOptString, rid);
                            String strA = a.this.a();
                            a.f5537b.put(strA, rid);
                            MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().c());
                            linkedHashMapB.put(strA, mBridgeBTLayout);
                            mBridgeBTLayout.setInstanceId(strA);
                            mBridgeBTLayout.setUnitId(strOptString);
                            mBridgeBTLayout.setWebView(windVaneWebView);
                            mBridgeBTLayout.setRect(rect2);
                            int i11 = i10;
                            if (i11 > 0 || iOptInt > 0) {
                                mBridgeBTLayout.setLayout(i11, iOptInt);
                            }
                            a.this.a(obj2, strA);
                            af.a("OperateViews", "create view instanceId = " + strA);
                        }
                    }, iOptInt2);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    c(obj2, th.getMessage());
                    com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("create view failed："), "OperateViews");
                }
            } catch (Throwable th3) {
                th = th3;
                obj2 = obj;
                c(obj2, th.getMessage());
                com.mbridge.msdk.dycreator.baseview.a.v(th, new StringBuilder("create view failed："), "OperateViews");
            }
        } catch (Throwable th4) {
            th = th4;
            obj2 = obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.LinearLayout$LayoutParams] */
    private ViewGroup.LayoutParams a(ViewGroup.LayoutParams layoutParams, Rect rect, int i10, int i11) {
        if (rect == null) {
            rect = new Rect(-999, -999, -999, -999);
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC != null) {
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                int i12 = rect.left;
                if (i12 != -999) {
                    layoutParams2.leftMargin = ak.a(contextC, i12);
                }
                int i13 = rect.top;
                if (i13 != -999) {
                    layoutParams2.topMargin = ak.a(contextC, i13);
                }
                int i14 = rect.right;
                if (i14 != -999) {
                    layoutParams2.rightMargin = ak.a(contextC, i14);
                }
                int i15 = rect.bottom;
                if (i15 != -999) {
                    layoutParams2.bottomMargin = ak.a(contextC, i15);
                }
                if (i10 > 0) {
                    layoutParams2.width = ak.a(contextC, i10);
                }
                if (i11 > 0) {
                    layoutParams2.height = ak.a(contextC, i11);
                }
                return layoutParams2;
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                int i16 = rect.left;
                if (i16 != -999) {
                    layoutParams3.leftMargin = ak.a(contextC, i16);
                }
                int i17 = rect.top;
                if (i17 != -999) {
                    layoutParams3.topMargin = ak.a(contextC, i17);
                }
                int i18 = rect.right;
                if (i18 != -999) {
                    layoutParams3.rightMargin = ak.a(contextC, i18);
                }
                int i19 = rect.bottom;
                if (i19 != -999) {
                    layoutParams3.bottomMargin = ak.a(contextC, i19);
                }
                if (i10 > 0) {
                    layoutParams3.width = ak.a(contextC, i10);
                }
                if (i11 > 0) {
                    layoutParams3.height = ak.a(contextC, i11);
                }
                return layoutParams3;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
                int i20 = rect.left;
                if (i20 != -999) {
                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = ak.a(contextC, i20);
                }
                int i21 = rect.top;
                if (i21 != -999) {
                    ((LinearLayout.LayoutParams) layoutParams).topMargin = ak.a(contextC, i21);
                }
                int i22 = rect.right;
                if (i22 != -999) {
                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = ak.a(contextC, i22);
                }
                int i23 = rect.bottom;
                if (i23 != -999) {
                    ((LinearLayout.LayoutParams) layoutParams).bottomMargin = ak.a(contextC, i23);
                }
                if (i10 > 0) {
                    ((LinearLayout.LayoutParams) layoutParams).width = ak.a(contextC, i10);
                }
                if (i11 > 0) {
                    ((LinearLayout.LayoutParams) layoutParams).height = ak.a(contextC, i11);
                }
            }
        }
        return layoutParams;
    }

    public final String a() {
        h++;
        return String.valueOf(h);
    }

    public final void a(int i10, int i11, int i12, int i13, int i14) {
        af.a("OperateViews", "OperateViews setNotchString = ".concat(String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14))));
        f5542k = s.a(i10, i11, i12, i13, i14);
        f5543l = i10;
        f5544m = i11;
        f5545n = i12;
        f5546o = i13;
        f5547p = i14;
    }

    public static /* synthetic */ void a(a aVar, String str, CampaignEx campaignEx) {
        if (com.mbridge.msdk.foundation.same.a.b.f3629j == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.same.a.b.a(str, campaignEx, "reward");
    }
}
