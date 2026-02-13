package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements com.mbridge.msdk.newreward.function.command.receiver.e {
    public final Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null) {
            return null;
        }
        com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
        long jLongValue = ((Long) map.get("last_response_empty_time")).longValue();
        if (eVar == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(eVar.J()) && eVar.x() != null && eVar.x().b() != null) {
            if (System.currentTimeMillis() - jLongValue < eVar.x().b().a() * 1000) {
                map2.put("error_code", "-1");
                map2.put(NotificationCompat.CATEGORY_MESSAGE, "EXCEPTION_RETURN_EMPTY");
                return map2;
            }
        }
        com.mbridge.msdk.foundation.same.net.d dVarA = com.mbridge.msdk.foundation.same.net.e.c.a().a(eVar.B(), eVar.H(), eVar.C(), eVar.J(), eVar.h() + "");
        if (dVarA != null) {
            try {
                JSONObject jSONObject = new JSONObject(dVarA.f3709c.toString());
                jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                map2.put("error_code", jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) + "");
                map2.put(NotificationCompat.CATEGORY_MESSAGE, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
                return map2;
            } catch (JSONException e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return map2;
    }
}
