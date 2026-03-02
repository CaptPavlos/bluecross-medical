package b9;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public long f886a;

    /* renamed from: c, reason: collision with root package name */
    public String f888c;
    public String g;

    /* renamed from: b, reason: collision with root package name */
    public int f887b = 4;

    /* renamed from: d, reason: collision with root package name */
    public String f889d = "";
    public String e = "";
    public String f = "";

    public long a() {
        return this.f886a;
    }

    public void b(long j10) {
        this.f886a = j10;
    }

    public final void c(JSONObject jSONObject) throws JSONException {
        String str;
        jSONObject.putOpt("clientTimestamp", Long.valueOf(a()));
        if (this.f887b != 5) {
            jSONObject.putOpt("sessionId", this.f888c);
        }
        jSONObject.putOpt("domain", this.f889d);
        jSONObject.putOpt("cmpVersion", "2.3.3");
        jSONObject.putOpt("cmpPlatform", "android");
        jSONObject.putOpt("deviceType", this.f);
        jSONObject.putOpt("country", this.e);
        jSONObject.putOpt("siteUuid", this.g);
        switch (this.f887b) {
            case 1:
                str = "init";
                break;
            case 2:
                str = NotificationCompat.CATEGORY_NAVIGATION;
                break;
            case 3:
                str = "done";
                break;
            case 4:
                str = "none";
                break;
            case 5:
                str = "visit";
                break;
            case 6:
                str = CampaignEx.JSON_NATIVE_VIDEO_CLICK;
                break;
            default:
                throw null;
        }
        jSONObject.putOpt("operationType", str);
    }

    public abstract String d();
}
