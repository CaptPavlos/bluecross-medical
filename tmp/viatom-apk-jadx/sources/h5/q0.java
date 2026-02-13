package h5;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.UptodownApp;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8717a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8718b;

    /* renamed from: c, reason: collision with root package name */
    public long f8719c;

    public q0(String str, String str2) {
        this.f8717a = str;
        this.f8718b = str2;
        this.f8719c = System.currentTimeMillis();
    }

    public static String b(String str, String str2, long j10) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j10);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.w("FirebaseMessaging", "Failed to encode token: " + e);
            return null;
        }
    }

    public static q0 d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new q0(str, null, 0L);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new q0(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(CampaignEx.JSON_KEY_TIMESTAMP));
        } catch (JSONException e) {
            Log.w("FirebaseMessaging", "Failed to parse token: " + e);
            return null;
        }
    }

    public boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f8719c;
        float f = UptodownApp.E;
        String str = this.f8717a;
        return jCurrentTimeMillis < ((long) ((str.equalsIgnoreCase("new_releases") || str.equalsIgnoreCase("last_updates")) ? 600000 : 1800000));
    }

    public p0 c() {
        p0 p0Var = new p0();
        String str = this.f8718b;
        p0Var.f8696a = str;
        p0Var.f8697b = 200;
        p0Var.f8699d = new JSONObject(str);
        return p0Var;
    }

    public q0(String str, String str2, long j10) {
        this.f8717a = str;
        this.f8718b = str2;
        this.f8719c = j10;
    }
}
