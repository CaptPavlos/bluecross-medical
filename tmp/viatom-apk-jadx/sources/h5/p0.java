package h5;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public String f8696a;

    /* renamed from: b, reason: collision with root package name */
    public int f8697b;

    /* renamed from: c, reason: collision with root package name */
    public String f8698c;

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f8699d;

    public static String c(JSONObject jSONObject) throws JSONException {
        jSONObject.getClass();
        String string = null;
        try {
            if (!jSONObject.isNull("errorMsg")) {
                Object obj = jSONObject.get("errorMsg");
                if (obj instanceof JSONArray) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("errorMsg");
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            string = (string == null || string.equals("")) ? jSONArrayOptJSONArray.getString(i10) : String.format("%s\n%s", Arrays.copyOf(new Object[]{string, jSONArrayOptJSONArray.optString(i10)}, 2));
                        }
                        return string;
                    }
                } else if (obj instanceof String) {
                    return (String) obj;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void a(Context context) {
        context.getClass();
        if (this.f8697b == 526) {
            t1.N(context, "is_status_code_526", true);
            t1.O(context, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, "versioncode_526");
            String str = this.f8696a;
            if (str == null || str.length() == 0) {
                return;
            }
            String str2 = this.f8696a;
            str2.getClass();
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.isNull("url_update")) {
                return;
            }
            t1.R(context, "url_526", jSONObject.optString("url_update"));
        }
    }

    public final boolean b() {
        int i10 = this.f8697b;
        return i10 < 200 || i10 >= 300;
    }

    public final void d(String str) {
        this.f8698c = str;
    }
}
