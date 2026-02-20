package u4;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public File f12898a;

    /* renamed from: b, reason: collision with root package name */
    public String f12899b;

    /* renamed from: c, reason: collision with root package name */
    public String f12900c;

    /* renamed from: d, reason: collision with root package name */
    public String f12901d;
    public long e;
    public String f;

    public final void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        try {
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                this.f12899b = jSONObject.getString(RewardPlus.NAME);
            }
            if (!jSONObject.isNull("sha256")) {
                this.f12900c = jSONObject.getString("sha256");
            }
            if (!jSONObject.isNull(RewardPlus.ICON)) {
                this.f12901d = jSONObject.getString(RewardPlus.ICON);
            }
            if (!jSONObject.isNull("size")) {
                this.e = jSONObject.getLong("size");
            }
            if (jSONObject.isNull("senderDeviceName")) {
                return;
            }
            this.f = jSONObject.getString("senderDeviceName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
