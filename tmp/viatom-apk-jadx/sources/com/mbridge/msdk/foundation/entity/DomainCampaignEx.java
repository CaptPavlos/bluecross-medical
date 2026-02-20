package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DomainCampaignEx extends Campaign implements NoProGuard, Serializable {
    private static final String JSON_KEY_AD_TRACKING_DLE = "D+S8+FxXJFPsYFc3+F5/Hv==";
    private static final String JSON_KEY_AD_TRACKING_DLS = "D+S8+FxXJFPsYFc3+bfTD+zT";
    private static final String JSON_KEY_AD_TRACKING_I = "D+S8+FQ/hbxtY7M=";
    public static final String KEY_BIND_ID = "bind_id";
    public static final String KEY_GH_ID = "gh_id";
    public static final String KEY_GH_PATH = "gh_path";
    private static String TAG = "DomainCampaignEx";
    private String bindId;
    private String ghId;
    private String ghPath;

    public static JSONObject object2TrackingStr(JSONObject jSONObject, j jVar) {
        if (jSONObject == null || jVar == null) {
            return null;
        }
        try {
            if (jVar.u() != null) {
                jSONObject.put(z.a(JSON_KEY_AD_TRACKING_DLS), CampaignEx.processNativeVideoTrackingArray2Json(jVar.u()));
            }
            if (jVar.v() != null) {
                jSONObject.put(z.a(JSON_KEY_AD_TRACKING_DLE), CampaignEx.processNativeVideoTrackingArray2Json(jVar.v()));
            }
            if (jVar.w() != null) {
                jSONObject.put(z.a(JSON_KEY_AD_TRACKING_I), CampaignEx.processNativeVideoTrackingArray2Json(jVar.w()));
                return jSONObject;
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("DomainCampaignEx", e.getMessage(), e);
            }
        }
        return jSONObject;
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, CampaignEx campaignEx) {
        String strOptString = jSONObject.optString(KEY_GH_ID);
        if (!TextUtils.isEmpty(strOptString)) {
            campaignEx.setGhId(strOptString);
            String strOptString2 = jSONObject.optString(KEY_GH_PATH);
            if (!TextUtils.isEmpty(strOptString2)) {
                campaignEx.setGhPath(z.a(strOptString2));
            }
            campaignEx.setBindId(jSONObject.optString(KEY_BIND_ID));
        }
        return campaignEx;
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject, CampaignEx campaignEx) {
        String strOptString = jSONObject.optString(KEY_GH_ID);
        if (!TextUtils.isEmpty(strOptString)) {
            campaignEx.setGhId(strOptString);
            String strOptString2 = jSONObject.optString(KEY_GH_PATH);
            if (!TextUtils.isEmpty(strOptString2)) {
                campaignEx.setGhPath(z.a(strOptString2));
            }
            campaignEx.setBindId(jSONObject.optString(KEY_BIND_ID));
        }
        return campaignEx;
    }

    public static String replaceValueByKey(CampaignUnit campaignUnit, CampaignEx campaignEx, String str) {
        if (campaignUnit != null && !TextUtils.isEmpty(str) && campaignEx != null) {
            try {
                HashMap<String, String> rks = campaignUnit.getRks();
                if (rks != null) {
                    rks.entrySet().iterator();
                    for (Map.Entry<String, String> entry : rks.entrySet()) {
                        String key = entry.getKey();
                        str = str.replaceAll("\\{" + key + "\\}", entry.getValue());
                    }
                }
                HashMap<String, String> aks = campaignEx.getAks();
                if (aks != null) {
                    aks.entrySet().iterator();
                    for (Map.Entry<String, String> entry2 : aks.entrySet()) {
                        String key2 = entry2.getKey();
                        str = str.replaceAll("\\{" + key2 + "\\}", entry2.getValue());
                    }
                }
                HashMap<String, String> epMap = campaignUnit.getEpMap();
                if (epMap != null) {
                    for (Map.Entry<String, String> entry3 : epMap.entrySet()) {
                        String key3 = entry3.getKey();
                        str = str.replaceAll("\\{" + key3 + "\\}", entry3.getValue());
                    }
                }
                return str.replaceAll("\\{c\\}", URLEncoder.encode(campaignUnit.assembCParams(), "utf-8"));
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DomainCampaignEx", th.getMessage(), th);
                }
            }
        }
        return str;
    }

    public static j trackingStr2Object(JSONObject jSONObject, j jVar) {
        if (jSONObject == null || jVar == null) {
            return null;
        }
        try {
            jVar.t(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(z.a(JSON_KEY_AD_TRACKING_DLS))));
            jVar.u(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(z.a(JSON_KEY_AD_TRACKING_DLE))));
            jVar.v(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(z.a(JSON_KEY_AD_TRACKING_I))));
            return jVar;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("DomainCampaignEx", e.getMessage(), e);
            }
            return jVar;
        }
    }

    @Deprecated
    public String getBindId() {
        return this.bindId;
    }

    public String getGhId() {
        return this.ghId;
    }

    public String getGhPath() {
        return this.ghPath;
    }

    public boolean needShowIDialog(CampaignEx campaignEx) {
        return false;
    }

    public void setBindId(String str) {
        this.bindId = str;
    }

    public void setGhId(String str) {
        this.ghId = str;
    }

    public void setGhPath(String str) {
        this.ghPath = str;
    }

    public static JSONObject campaignToJsonObject(JSONObject jSONObject, CampaignEx campaignEx) throws JSONException {
        return jSONObject;
    }
}
