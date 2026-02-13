package com.mbridge.msdk.video.bt.a;

import android.text.TextUtils;
import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.bt.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    int f5560a;

    /* renamed from: b, reason: collision with root package name */
    int f5561b;

    /* renamed from: c, reason: collision with root package name */
    private String f5562c;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static c f5563a = new c();
    }

    private c() {
        this.f5562c = "handlerNativeResult";
        this.f5560a = 0;
        this.f5561b = 1;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String strOptString = jSONObject.optString("uniqueIdentifier");
                    String strOptString2 = jSONObject.optString(RewardPlus.NAME);
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("parameters");
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                        int iOptInt = 0;
                        if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.toString())) {
                            iOptInt = jSONObjectOptJSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 0);
                        }
                        a(this.f5560a, "receivedMessage", obj);
                        if (strOptString.equalsIgnoreCase("reporter")) {
                            com.mbridge.msdk.mbsignalcommon.a.a.a().a(obj, strOptString2, jSONArrayOptJSONArray, iOptInt);
                            return;
                        } else {
                            if (strOptString.equalsIgnoreCase("MediaPlayer")) {
                                b unused = b.a.f5559a;
                                return;
                            }
                            return;
                        }
                    }
                    a(this.f5561b, "module or method is null", obj);
                    return;
                }
            } catch (Exception e) {
                af.a("HandlerH5MessageManager", e.getMessage());
                a(this.f5561b, e.getMessage(), obj);
                return;
            } catch (Throwable th) {
                af.a("HandlerH5MessageManager", th.getMessage());
                a(this.f5561b, th.getMessage(), obj);
                return;
            }
        }
        a(this.f5561b, "params is null", obj);
    }

    public static c a() {
        return a.f5563a;
    }

    private void a(int i10, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            af.a("HandlerH5MessageManager", e.getMessage());
        } catch (Throwable th) {
            af.a("HandlerH5MessageManager", th.getMessage());
        }
    }
}
