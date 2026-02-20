package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends p {

    /* renamed from: a, reason: collision with root package name */
    private Activity f6168a;

    /* renamed from: b, reason: collision with root package name */
    private MBridgeContainerView f6169b;

    public o(Activity activity, MBridgeContainerView mBridgeContainerView) {
        this.f6168a = activity;
        this.f6169b = mBridgeContainerView;
    }

    private String a(List<CampaignEx> list, String str, String str2, JSONObject jSONObject) throws JSONException {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            Object camplistToJson = CampaignEx.parseCamplistToJson(list);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("campaignList", camplistToJson);
            try {
                jSONObject2.put("device", new com.mbridge.msdk.foundation.tools.i(com.mbridge.msdk.foundation.controller.c.m().c()).a());
                jSONObject2.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                jSONObject2.put("sdk_info", str2);
                jSONObject2.put("unitSetting", jSONObject);
                if (com.mbridge.msdk.c.h.a() != null) {
                    String strG = com.mbridge.msdk.c.h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (!TextUtils.isEmpty(strG)) {
                        JSONObject jSONObject3 = new JSONObject(strG);
                        try {
                            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                            String string = an.a(contextC, "MBridge_ConfirmTitle" + str, "").toString();
                            String string2 = an.a(contextC, "MBridge_ConfirmContent" + str, "").toString();
                            String string3 = an.a(contextC, "MBridge_CancelText" + str, "").toString();
                            String string4 = an.a(contextC, "MBridge_ConfirmText" + str, "").toString();
                            if (!TextUtils.isEmpty(string)) {
                                jSONObject3.put("confirm_title", string);
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                jSONObject3.put("confirm_description", string2);
                            }
                            if (!TextUtils.isEmpty(string3)) {
                                jSONObject3.put("confirm_t", string3);
                            }
                            if (!TextUtils.isEmpty(string4)) {
                                jSONObject3.put("confirm_c_play", string4);
                            }
                            if (!TextUtils.isEmpty(string4)) {
                                jSONObject3.put("confirm_c_rv", string4);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String strC = com.mbridge.msdk.c.h.a().c(str);
                        if (!TextUtils.isEmpty(strC)) {
                            jSONObject3.put("ivreward", new JSONObject(strC));
                        }
                        jSONObject2.put("appSetting", jSONObject3);
                    }
                }
                return jSONObject2.toString();
            } catch (JSONException e3) {
                throw new RuntimeException(e3);
            }
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.g, com.mbridge.msdk.video.signal.i
    public final void b(String str) {
        super.b(str);
        try {
            if (this.f6168a == null || TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals("landscape")) {
                this.f6168a.setRequestedOrientation(0);
            } else if (str.equals("portrait")) {
                this.f6168a.setRequestedOrientation(1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.g, com.mbridge.msdk.video.signal.i
    public final void c(String str) {
        MBridgeContainerView mBridgeContainerView;
        super.c(str);
        try {
            if (this.f6168a == null || TextUtils.isEmpty(str) || (mBridgeContainerView = this.f6169b) == null) {
                return;
            }
            mBridgeContainerView.handlerPlayableException(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.g, com.mbridge.msdk.video.signal.h
    public final void notifyCloseBtn(int i10) {
        super.notifyCloseBtn(i10);
        MBridgeContainerView mBridgeContainerView = this.f6169b;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.notifyCloseBtn(i10);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.g, com.mbridge.msdk.video.signal.h
    public final void toggleCloseBtn(int i10) {
        super.toggleCloseBtn(i10);
        MBridgeContainerView mBridgeContainerView = this.f6169b;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.toggleCloseBtn(i10);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.g, com.mbridge.msdk.video.signal.i
    public final void a(String str) {
        MBridgeContainerView mBridgeContainerView;
        super.a(str);
        try {
            if (this.f6168a == null || TextUtils.isEmpty(str) || !str.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK) || (mBridgeContainerView = this.f6169b) == null) {
                return;
            }
            mBridgeContainerView.triggerCloseBtn(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.g, com.mbridge.msdk.video.signal.i
    public final String a() {
        if (this.f6169b == null) {
            super.a();
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f6169b.getCampaign());
                String unitID = this.f6169b.getUnitID();
                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a() == null ? null : com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), unitID);
                JSONObject jSONObject = new JSONObject();
                if (cVarA != null) {
                    jSONObject = cVarA.E();
                }
                af.a("JSRewardVideoV1", "getEndScreenInfo success campaign = " + this.f6169b.getCampaign());
                return a(arrayList, unitID, "MAL_16.8.61,3.0.1", jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.a();
    }
}
