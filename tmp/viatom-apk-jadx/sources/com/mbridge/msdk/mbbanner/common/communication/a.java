package com.mbridge.msdk.mbbanner.common.communication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.communication.c;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends c {

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f4272b;

    /* renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f4273c;

    /* renamed from: d, reason: collision with root package name */
    private String f4274d;
    private String e;
    private int f;
    private com.mbridge.msdk.mbbanner.common.b.a g;
    private BannerExpandDialog h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4275i = false;

    public a(Context context, String str, String str2) {
        this.f4274d = str;
        this.e = str2;
        this.f4272b = new WeakReference<>(context);
    }

    private static void a(Object obj, JSONObject jSONObject) throws JSONException {
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
            } catch (JSONException e) {
                af.a("BannerSignalCommunicationImpl", e.getMessage());
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
                    } catch (JSONException e3) {
                        af.a("BannerSignalCommunicationImpl", e3.getMessage());
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
                            jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, H5DownLoadManager.getInstance().getResAddress(strOptString) == null ? str : H5DownLoadManager.getInstance().getH5ResAddress(strOptString));
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
                                af.a("BannerSignalCommunicationImpl", "getFileInfo Mraid file " + strOptString);
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
                            af.a("BannerSignalCommunicationImpl", "VideoBean not null");
                            jSONObject8.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                            i10 = length;
                            jSONObject8.put("videoDataLength", mVarA.d());
                            String strE = mVarA.e();
                            if (TextUtils.isEmpty(strE)) {
                                af.a("BannerSignalCommunicationImpl", "VideoPath null");
                                jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str3);
                                jSONObject8.put("path4Web", str3);
                                str = str3;
                            } else {
                                str = str3;
                                af.a("BannerSignalCommunicationImpl", "VideoPath not null");
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
                            af.a("BannerSignalCommunicationImpl", "VideoBean null");
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
        } catch (JSONException e7) {
            af.a("BannerSignalCommunicationImpl", e7.getMessage());
            return;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void b(Object obj, String str) {
        af.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        try {
            List<CampaignEx> list = this.f4273c;
            if (list == null) {
                return;
            }
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.f4273c.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectCampaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject);
                String strOptString = jSONObjectCampaignToJsonObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (!TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                }
                campaignEx = campaignWithBackData;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void c(Object obj, String str) {
        if (obj != null) {
            try {
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                g.a().a(obj, d.a(0));
                com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
                if (aVar != null) {
                    aVar.b(iOptInt);
                }
            } catch (Throwable th) {
                af.b("BannerSignalCommunicationImpl", "readyStatus", th);
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void close() {
        af.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        try {
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLOSE, th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void d(Object obj, String str) {
        af.b("BannerSignalCommunicationImpl", "toggleCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(iOptInt);
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void e(Object obj, String str) {
        af.b("BannerSignalCommunicationImpl", "triggerCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString(MRAIDCommunicatorUtil.KEY_STATE);
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(strOptString);
            }
            g.a().a(obj, d.a(0));
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "triggerCloseBtn", th);
            g.a().a(obj, d.a(-1));
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void expand(String str, boolean z9) {
        Context context;
        String bannerUrl;
        try {
            String str2 = "";
            if (getMraidCampaign() != null) {
                if (TextUtils.isEmpty(getMraidCampaign().getBannerHtml())) {
                    bannerUrl = getMraidCampaign().getBannerUrl();
                } else {
                    bannerUrl = "file:////" + getMraidCampaign().getBannerHtml();
                }
                str2 = bannerUrl;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            bundle.putString("url", str2);
            bundle.putBoolean("shouldUseCustomClose", z9);
            WeakReference<Context> weakReference = this.f4272b;
            if (weakReference != null && (context = weakReference.get()) != null) {
                BannerExpandDialog bannerExpandDialog = this.h;
                if (bannerExpandDialog != null && bannerExpandDialog.isShowing()) {
                    return;
                }
                BannerExpandDialog bannerExpandDialog2 = new BannerExpandDialog(context, bundle, this.g);
                this.h = bannerExpandDialog2;
                bannerExpandDialog2.setCampaignList(this.e, this.f4273c);
                this.h.show();
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(true);
            }
            String str3 = this.e;
            CampaignEx mraidCampaign = getMraidCampaign();
            try {
                JSONObject jSONObject = new JSONObject();
                if (mraidCampaign.isBidCampaign()) {
                    jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
                }
                jSONObject.put("key", "2000070");
                jSONObject.put("rid_n", mraidCampaign.getRequestIdNotice());
                jSONObject.put("rid", mraidCampaign.getRequestId());
                jSONObject.put("cid", mraidCampaign.getId());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str3);
                jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, str);
                jSONObject.put("network_type", String.valueOf(ab.m(com.mbridge.msdk.foundation.controller.c.m().c())));
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            } catch (Exception e) {
                af.b("BannerReport", e.getMessage());
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "expand", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f4273c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f4273c.get(0);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void i(Object obj, String str) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("sendImpressions:", str, "BannerSignalCommunicationImpl");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            final ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                for (CampaignEx campaignEx : this.f4273c) {
                    if (campaignEx.getId().equals(string)) {
                        b.a(this.e, campaignEx, "banner");
                        arrayList.add(string);
                    }
                }
            }
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.communication.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        j jVarA = j.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                        ArrayList arrayList2 = arrayList;
                        int size = arrayList2.size();
                        int i11 = 0;
                        while (i11 < size) {
                            Object obj2 = arrayList2.get(i11);
                            i11++;
                            jVarA.a((String) obj2);
                        }
                    } catch (Exception e) {
                        af.b("BannerSignalCommunicationImpl", e.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void j(Object obj, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.a("BannerSignalCommunicationImpl", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void k(Object obj, String str) throws JSONException {
        af.a("BannerSignalCommunicationImpl", "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
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
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list = this.f4273c;
                    com.mbridge.msdk.click.a.a(contextC, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list2 = this.f4273c;
                    com.mbridge.msdk.click.a.a(contextC2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, d.a(0));
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "reportUrls", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void open(String str) {
        af.b("BannerSignalCommunicationImpl", "open");
        try {
            af.b("BannerSignalCommunicationImpl", str);
            if (this.f4273c.size() > 1) {
                com.mbridge.msdk.foundation.controller.c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(true, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "open", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void useCustomClose(boolean z9) {
        int i10 = z9 ? 2 : 1;
        try {
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(i10);
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "useCustomClose", th);
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f4273c = list;
    }

    public final void a(int i10) {
        this.f = i10;
    }

    public final void a() {
        if (this.g != null) {
            this.g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void a(Object obj, String str) {
        af.b("BannerSignalCommunicationImpl", "BANNER INIT INVOKE");
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.foundation.tools.j jVar = new com.mbridge.msdk.foundation.tools.j(com.mbridge.msdk.foundation.controller.c.m().c());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", jVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f4273c));
            k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.e);
            if (kVarD == null) {
                kVarD = k.d(this.e);
            }
            if (!TextUtils.isEmpty(this.f4274d)) {
                kVarD.a(this.f4274d);
            }
            jSONObject.put("unitSetting", kVarD.x());
            String strG = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("appSetting", new JSONObject(strG));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.f4319a);
            af.b("BannerSignalCommunicationImpl", "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "init", th);
        }
    }

    public final void a(com.mbridge.msdk.mbbanner.common.b.a aVar) {
        if (aVar != null) {
            this.g = aVar;
        }
    }
}
