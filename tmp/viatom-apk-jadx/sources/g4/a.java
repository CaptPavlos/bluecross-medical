package g4;

import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import d9.h;
import java.util.ArrayList;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f8228a;

    public a(Context context) throws JSONException {
        context.getClass();
        JSONObject jSONObject = new JSONObject();
        this.f8228a = jSONObject;
        b(0, "autoplay");
        b(0, CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        b(0, "controls");
        b(1, "enablejsapi");
        b(0, "fs");
        String str = "https://" + context.getPackageName();
        try {
            jSONObject.put(TtmlNode.ATTR_TTS_ORIGIN, str);
            b(0, "rel");
            b(3, "iv_load_policy");
            b(0, "cc_load_policy");
        } catch (JSONException unused) {
            a2.a.j("Illegal JSON value origin: ".concat(str));
            throw null;
        }
    }

    public ArrayList a() throws JSONException {
        JSONObject jSONObject = this.f8228a;
        if (jSONObject == null) {
            l.i("json");
            throw null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("disclosures");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
            String strOptString = jSONObject2.optString("identifier");
            strOptString.getClass();
            String strOptString2 = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            strOptString2.getClass();
            int iOptInt = jSONObject2.optInt("maxAgeSeconds");
            String strOptString3 = jSONObject2.optString("domain");
            strOptString3.getClass();
            arrayList.add(new h(strOptString, strOptString2, iOptInt, strOptString3, l1.b.d("purposes", jSONObject2)));
            i10 = i11;
        }
        return arrayList;
    }

    public void b(int i10, String str) throws JSONException {
        try {
            this.f8228a.put(str, i10);
        } catch (JSONException unused) {
            throw new RuntimeException("Illegal JSON value " + str + ": " + i10);
        }
    }
}
