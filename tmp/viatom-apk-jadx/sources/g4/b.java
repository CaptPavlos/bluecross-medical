package g4;

import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import kotlin.jvm.internal.l;
import n6.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8229a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f8230b;

    public b(JSONObject jSONObject) {
        this.f8229a = 0;
        this.f8230b = jSONObject;
    }

    public Object a(String str) {
        switch (this.f8229a) {
            case 1:
                str.getClass();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f8230b = jSONObject;
                    return new c(jSONObject.optString("language"), c(), d());
                } catch (JSONException unused) {
                    ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                    if (callback != null) {
                        callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
                    }
                    return new c();
                }
            default:
                str.getClass();
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    this.f8230b = jSONObject2;
                    return new m8.a(10, jSONObject2.optString("jurisdiction"), b());
                } catch (JSONException unused2) {
                    ChoiceCmpCallback callback2 = ChoiceCmp.INSTANCE.getCallback();
                    if (callback2 != null) {
                        callback2.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
                    }
                    return new m8.a(15, null, null);
                }
        }
    }

    public ArrayList b() {
        String str;
        n6.a aVar;
        JSONArray jSONArray;
        JSONObject jSONObject = this.f8230b;
        String str2 = null;
        if (jSONObject == null) {
            l.i("json");
            throw null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("purposes");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                Integer numValueOf = Integer.valueOf(jSONObjectOptJSONObject.optInt("id"));
                Boolean boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("defaultValue"));
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("consentBanner");
                if (jSONObjectOptJSONObject2 == null) {
                    aVar = new n6.a(str2, str2, 15);
                    str = str2;
                } else {
                    str = str2;
                    String strOptString = jSONObjectOptJSONObject2.optString(CampaignEx.JSON_KEY_TITLE);
                    strOptString.getClass();
                    String strOptString2 = jSONObjectOptJSONObject2.optString("description");
                    strOptString2.getClass();
                    aVar = new n6.a(strOptString, strOptString2, 10);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("purposes");
                n6.a aVar2 = aVar;
                ArrayList arrayList2 = new ArrayList();
                if (jSONArrayOptJSONArray2 == null) {
                    jSONArray = jSONArrayOptJSONArray;
                } else {
                    int length2 = jSONArrayOptJSONArray2.length();
                    jSONArray = jSONArrayOptJSONArray;
                    int i12 = 0;
                    while (i12 < length2) {
                        int i13 = i12 + 1;
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i12);
                        arrayList2.add(new m8.c(Integer.valueOf(jSONObjectOptJSONObject3.optInt("id")), Integer.valueOf(jSONObjectOptJSONObject3.optInt("order")), jSONObjectOptJSONObject3.optString(CampaignEx.JSON_KEY_TITLE), jSONObjectOptJSONObject3.optString("description"), l1.b.d("nationalIds", jSONObjectOptJSONObject3)));
                        i12 = i13;
                        jSONArrayOptJSONArray2 = jSONArrayOptJSONArray2;
                    }
                }
                arrayList.add(new m8.b(numValueOf, boolValueOf, aVar2, arrayList2, jSONObjectOptJSONObject.optBoolean("noticeOnly")));
                i10 = i11;
                str2 = str;
                jSONArrayOptJSONArray = jSONArray;
            }
        }
        return arrayList;
    }

    public n6.a c() throws JSONException {
        JSONObject jSONObject = this.f8230b;
        if (jSONObject == null) {
            l.i("json");
            throw null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("banner");
        String strOptString = jSONObject2.optString(CampaignEx.JSON_KEY_TITLE);
        strOptString.getClass();
        String strOptString2 = jSONObject2.optString("sectionTitle");
        strOptString2.getClass();
        String strOptString3 = jSONObject2.optString("description");
        strOptString3.getClass();
        String strOptString4 = jSONObject2.optString("confirm");
        strOptString4.getClass();
        return new n6.a(strOptString, strOptString2, strOptString3, strOptString4);
    }

    public ArrayList d() throws JSONException {
        JSONObject jSONObject = this.f8230b;
        if (jSONObject == null) {
            l.i("json");
            throw null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("purposes");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                Integer numValueOf = Integer.valueOf(jSONObject2.optInt("id"));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("banner");
                jSONObject3.getClass();
                String strOptString = jSONObject3.optString(CampaignEx.JSON_KEY_TITLE);
                strOptString.getClass();
                arrayList.add(new n6.b(numValueOf, new n6.a(strOptString, null, 14)));
                i10 = i11;
            }
        }
        return arrayList;
    }

    public String toString() {
        switch (this.f8229a) {
            case 0:
                String string = this.f8230b.toString();
                string.getClass();
                return string;
            default:
                return super.toString();
        }
    }

    public /* synthetic */ b(int i10) {
        this.f8229a = i10;
    }
}
