package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeRevenueParamsEntityForAdmob extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForAdmob(String str, String str2) throws JSONException {
        super(str, str2);
        setMediationName("Admob");
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setAdType(String str) throws JSONException {
        super.setAdType(str);
    }

    public void setAdmobResponseInfo(String str) throws JSONException {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            setSourceData(str, str);
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("Loaded Adapter Response");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("Credentials");
                if (jSONObjectOptJSONObject2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObjectOptJSONObject2.get(next) + "");
                    }
                    setNetworkInfo(jSONObject);
                }
                setNetworkName(jSONObjectOptJSONObject.optString("Ad Source Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAdmobRevenueInfo(int i10, long j10, String str) throws JSONException {
        setRevenue(j10 + "");
        setPrecision(i10 + "");
        setCurrency(str);
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setDspInfo(String str, String str2) throws JSONException {
        super.setDspInfo(str, str2);
    }
}
