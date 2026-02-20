package com.mbridge.msdk.foundation.db.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f3440a = "FrequencyDaoMiddle";

    /* renamed from: b, reason: collision with root package name */
    private static a f3441b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f3442c = "FrequencyDaoMiddle";

    /* renamed from: d, reason: collision with root package name */
    private static JSONArray f3443d = new JSONArray();

    private a() {
        try {
            String str = (String) an.a(c.m().c(), f3442c, f3443d.toString());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            f3443d = new JSONArray(str);
        } catch (Exception e) {
            af.b(f3440a, e.getMessage());
        }
    }

    private void c() {
        try {
            if (f3443d != null) {
                an.b(c.m().c(), f3442c, f3443d.toString());
            }
        } catch (Exception e) {
            af.b(f3440a, e.getMessage());
        }
    }

    public final void a(String str) throws JSONException {
        if (f3443d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < f3443d.length(); i10++) {
                try {
                    JSONObject jSONObject = f3443d.getJSONObject(i10);
                    if (jSONObject != null) {
                        if (jSONObject.optString("id", "").equals(str)) {
                            jSONObject.put("impression_count", jSONObject.optInt("impression_count", 0) + 1);
                            jSONArray.put(jSONObject);
                        } else {
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e) {
                    af.b(f3440a, e.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                f3443d = jSONArray;
            }
            c();
        }
    }

    public final String[] b() {
        ArrayList arrayList = new ArrayList();
        if (f3443d != null) {
            for (int i10 = 0; i10 < f3443d.length(); i10++) {
                try {
                    JSONObject jSONObject = f3443d.getJSONObject(i10);
                    if (jSONObject != null && jSONObject.optInt("fc_a") < jSONObject.optInt("impression_count")) {
                        arrayList.add(jSONObject.optString("id"));
                    }
                } catch (JSONException e) {
                    af.b(f3440a, e.getMessage());
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            strArr[i11] = (String) arrayList.get(i11);
        }
        return strArr;
    }

    public final void a(g gVar) {
        JSONObject jSONObjectA;
        if (gVar == null || (jSONObjectA = a(gVar.a(), gVar.c(), gVar.d(), gVar.f(), gVar.e(), gVar.b())) == null) {
            return;
        }
        if (f3443d == null) {
            f3443d = new JSONArray();
        }
        f3443d.put(jSONObjectA);
        c();
    }

    public static a a() {
        if (f3441b == null) {
            synchronized (a.class) {
                try {
                    if (f3441b == null) {
                        f3441b = new a();
                    }
                } finally {
                }
            }
        }
        return f3441b;
    }

    public final void a(long j10) throws JSONException {
        if (f3443d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < f3443d.length(); i10++) {
                try {
                    JSONObject jSONObject = f3443d.getJSONObject(i10);
                    if (jSONObject != null && jSONObject.optInt(CampaignEx.JSON_KEY_ST_TS) >= j10) {
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    af.b(f3440a, e.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                f3443d = jSONArray;
            }
        }
        c();
    }

    private JSONObject a(String str, int i10, int i11, long j10, int i12, int i13) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e) {
            e = e;
        }
        try {
            jSONObject.put("id", str);
            jSONObject.put("fc_a", i10);
            jSONObject.put("fc_b", i11);
            jSONObject.put(CampaignEx.JSON_KEY_ST_TS, j10);
            jSONObject.put("impression_count", i12);
            jSONObject.put("click_count", i13);
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            jSONObject2 = jSONObject;
            af.b(f3440a, e.getMessage());
            return jSONObject2;
        }
    }
}
