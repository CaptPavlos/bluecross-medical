package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f6501a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.videocommon.b.c> f6502b;

    /* renamed from: c, reason: collision with root package name */
    private long f6503c;

    /* renamed from: d, reason: collision with root package name */
    private long f6504d;
    private long e;
    private long f;
    private long g;
    private long h;

    /* renamed from: j, reason: collision with root package name */
    private String f6506j;

    /* renamed from: i, reason: collision with root package name */
    private int f6505i = 0;

    /* renamed from: k, reason: collision with root package name */
    private String f6507k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f6508l = "";

    public static a a(String str) {
        a aVar;
        a aVar2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                aVar = new a();
            } catch (Exception e) {
                e = e;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("caplist");
                aVar.f6506j = jSONObject.optString("ab_id", "");
                aVar.f6508l = jSONObject.optString("rid", "");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    HashMap map = new HashMap();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys != null && itKeys.hasNext()) {
                        String next = itKeys.next();
                        int iOptInt = jSONObjectOptJSONObject.optInt(next, 1000);
                        if (!TextUtils.isEmpty(next)) {
                            if (TextUtils.isEmpty(next) || iOptInt != 0) {
                                map.put(next, Integer.valueOf(iOptInt));
                            } else {
                                map.put(next, 1000);
                            }
                        }
                    }
                    aVar.f6501a = map;
                }
                aVar.f6502b = com.mbridge.msdk.videocommon.b.c.a(jSONObject.optJSONArray("reward"));
                aVar.f6503c = jSONObject.optLong("getpf", 43200L);
                aVar.f6504d = jSONObject.optLong("ruct", 5400L);
                aVar.e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600L);
                aVar.f = jSONObject.optLong("dlct", 3600L);
                aVar.g = jSONObject.optLong("vcct", 5L);
                aVar.h = jSONObject.optLong("current_time");
                aVar.f6507k = jSONObject.optString("vtag", "");
                return aVar;
            } catch (Exception e3) {
                e = e3;
                aVar2 = aVar;
                e.printStackTrace();
                return aVar2;
            }
        }
        return aVar2;
    }

    public final String b() {
        return this.f6506j;
    }

    public final String c() {
        return this.f6508l;
    }

    public final long d() {
        return this.f6503c * 1000;
    }

    public final long e() {
        return this.f6504d * 1000;
    }

    public final long f() {
        return this.e * 1000;
    }

    public final long g() {
        return this.f;
    }

    public final long h() {
        return this.g;
    }

    public final long i() {
        return this.h;
    }

    public final Map<String, com.mbridge.msdk.videocommon.b.c> j() {
        return this.f6502b;
    }

    public final JSONObject k() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.f6501a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.f6501a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, com.mbridge.msdk.videocommon.b.c> map2 = this.f6502b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, com.mbridge.msdk.videocommon.b.c> entry2 : this.f6502b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        com.mbridge.msdk.videocommon.b.c value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put(RewardPlus.NAME, value.a());
                            jSONObject3.put(RewardPlus.AMOUNT, value.b());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.f6503c);
            jSONObject.put("ruct", this.f6504d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.e);
            jSONObject.put("dlct", this.f);
            jSONObject.put("vcct", this.g);
            jSONObject.put("current_time", this.h);
            jSONObject.put("vtag", this.f6507k);
            jSONObject.put("isDefault", this.f6505i);
            return jSONObject;
        } catch (Exception e7) {
            e7.printStackTrace();
            return jSONObject;
        }
    }

    public final void b(long j10) {
        this.f6504d = j10;
    }

    public final void c(long j10) {
        this.e = j10;
    }

    public final void b(Map<String, com.mbridge.msdk.videocommon.b.c> map) {
        this.f6502b = map;
    }

    public final void d(long j10) {
        this.f = j10;
    }

    public final void e(long j10) {
        this.g = j10;
    }

    public final void a(long j10) {
        this.f6503c = j10;
    }

    public final void a(Map<String, Integer> map) {
        this.f6501a = map;
    }

    public final void a(int i10) {
        this.f6505i = i10;
    }

    public final String a() {
        return this.f6507k;
    }
}
