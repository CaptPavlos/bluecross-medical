package com.mbridge.msdk.newreward.function.g;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    public static c a() throws JSONException {
        c cVar = new c();
        String string = MBridgeSharedPreferenceModel.getInstance().getString(MBridgeConstans.SP_DYNAMIC_METRICS_REPORT, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                int iOptInt = jSONObject.optInt("version", -1);
                if (iOptInt != -1) {
                    String strOptString = jSONObject.optString(RewardPlus.NAME, "");
                    JSONArray jSONArray = jSONObject.getJSONArray("report");
                    d[] dVarArr = new d[jSONArray.length()];
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                            if (jSONObject2 != null) {
                                String strOptString2 = jSONObject2.optString("key", "");
                                String strOptString3 = jSONObject2.optString("classname", "");
                                String strOptString4 = jSONObject2.optString("method", "");
                                if (!TextUtils.isEmpty(strOptString2)) {
                                    dVarArr[i10] = new d(strOptString3, strOptString4, strOptString2);
                                }
                            }
                        } catch (JSONException e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                    cVar.a(strOptString);
                    cVar.a(iOptInt);
                    cVar.a(dVarArr);
                }
            } catch (JSONException e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
        return cVar;
    }
}
