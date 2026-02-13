package com.mbridge.msdk.videocommon.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private String f6491a;

    /* renamed from: b, reason: collision with root package name */
    private int f6492b;

    public c(String str, int i10) {
        this.f6491a = str;
        this.f6492b = i10;
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                map.put(jSONObjectOptJSONObject.optString("id"), new c(jSONObjectOptJSONObject.optString(RewardPlus.NAME), jSONObjectOptJSONObject.optInt(RewardPlus.AMOUNT)));
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static c b(String str) {
        c cVarC = null;
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (TextUtils.isEmpty(str)) {
                cVarC = c();
            } else if (aVarB != null && aVarB.j() != null) {
                cVarC = aVarB.j().get(str);
            }
            return cVarC == null ? c() : cVarC;
        } catch (Exception e) {
            e.printStackTrace();
            return cVarC;
        }
    }

    private static c c() {
        return new c("Virtual Item", 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Reward{name='");
        sb.append(this.f6491a);
        sb.append("', amount=");
        return a3.a.k(sb, this.f6492b, '}');
    }

    public final int b() {
        return this.f6492b;
    }

    public final void a(String str) {
        this.f6491a = str;
    }

    public final void a(int i10) {
        this.f6492b = i10;
    }

    public final String a() {
        return this.f6491a;
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strOptString = jSONObject.optString(RewardPlus.NAME);
            int iOptInt = jSONObject.optInt(RewardPlus.AMOUNT);
            jSONObject.optString("id");
            return new c(strOptString, iOptInt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
