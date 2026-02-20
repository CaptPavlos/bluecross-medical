package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2720a = "h";

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f2721b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile g f2722c;

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, k> f2723d = new HashMap<>();

    private h() {
    }

    public static void a(Context context, String str) {
        FastKV fastKVBuild;
        com.mbridge.msdk.foundation.controller.d.a();
        Map<String, Object> all = null;
        try {
            fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
        } catch (Exception unused) {
            fastKVBuild = null;
        }
        if (fastKVBuild == null) {
            try {
                Map<String, ?> all2 = context.getSharedPreferences("mbridge", 0).getAll();
                for (String str2 : all2.keySet()) {
                    if (str2.startsWith(str + "_")) {
                        f2723d.put(str2, k.g((String) all2.get(str2)));
                    }
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            all = fastKVBuild.getAll();
        } catch (Exception unused2) {
        }
        if (all != null) {
            try {
                for (String str3 : all.keySet()) {
                    if (str3.startsWith(str + "_")) {
                        f2723d.put(str3, k.g((String) all.get(str3)));
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private k i(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.c.m().k();
        }
        String strJ = a3.a.j(str, "_", str2);
        if (f2723d.containsKey(strJ)) {
            return f2723d.get(strJ);
        }
        k kVarG = null;
        try {
            kVarG = k.g(com.mbridge.msdk.foundation.a.a.a.a().a(strJ));
            f2723d.put(strJ, kVarG);
            return kVarG;
        } catch (Exception e) {
            e.printStackTrace();
            return kVarG;
        }
    }

    public final g b(String str) {
        if (f2722c == null) {
            try {
                String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str);
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject = new JSONObject(strA);
                    if (jSONObject.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        jSONObject.remove(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                    }
                    if (jSONObject.has("c")) {
                        jSONObject.remove("c");
                    }
                    f2722c = g.e(jSONObject.toString());
                    if (f2722c != null) {
                        f2722c.aL();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f2722c;
    }

    public final String c(String str) {
        return com.mbridge.msdk.foundation.a.a.a.a().a("ivreward_" + str);
    }

    public final boolean d(String str) {
        g gVarB = b(str);
        if (gVarB != null) {
            long jH = gVarB.H() * 1000;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jD = gVarB.D() + jH;
            if (jD > jCurrentTimeMillis) {
                String str2 = f2720a;
                StringBuilder sbX = a3.a.x("app setting nexttime is not ready  [settingNextRequestTime= ", " currentTime = ", jD);
                sbX.append(jCurrentTimeMillis);
                sbX.append("]");
                af.c(str2, sbX.toString());
                return false;
            }
        }
        af.c(f2720a, "app setting timeout or not exists");
        return true;
    }

    public final boolean e(String str, String str2) {
        g gVarB = b(str2);
        if (d(str2) && a(str2, 1, str)) {
            new j().b(com.mbridge.msdk.foundation.controller.c.m().c(), str2, com.mbridge.msdk.foundation.controller.c.m().b());
        }
        k kVarD = d(str2, str);
        if (gVarB != null && kVarD != null) {
            long jAt = gVarB.at() * 1000;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jI = kVarD.i() + jAt;
            if (jI > jCurrentTimeMillis) {
                String str3 = f2720a;
                StringBuilder sbX = a3.a.x("unit setting  nexttime is not ready  [settingNextRequestTime= ", " currentTime = ", jI);
                sbX.append(jCurrentTimeMillis);
                sbX.append("]");
                af.c(str3, sbX.toString());
                return false;
            }
        }
        af.c(f2720a, "unit setting timeout or not exists");
        return true;
    }

    public final void f(String str) {
        try {
            String strG = g(str);
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strG);
            jSONObject.put("current_time", System.currentTimeMillis());
            g(str, jSONObject.toString());
        } catch (Throwable th) {
            af.b(f2720a, th.getMessage());
        }
    }

    public final void g(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a(str, str2);
        f2722c = g.e(str2);
        if (f2722c != null) {
            f2722c.aL();
        }
        v.a().a(f2722c.b());
    }

    public final void h(String str, String str2) {
        try {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str + "_" + str2);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th) {
            af.b(f2720a, th.getMessage());
        }
    }

    public final k c(String str, String str2) {
        k kVarD = d(str, str2);
        return kVarD == null ? k.y() : kVarD;
    }

    public final String g(String str) {
        if (str == null) {
            return "";
        }
        try {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str);
            return strA == null ? "" : strA;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public final void f(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a("ivreward_" + str, str2);
    }

    public final k d(String str, String str2) {
        k kVarI = i(str, str2);
        if (kVarI != null && kVarI.v() == 0) {
            kVarI.a(1);
        }
        return kVarI;
    }

    public final k b(String str, String str2) {
        return i(str, str2);
    }

    public final void e(String str) {
        com.mbridge.msdk.foundation.a.a.a.a().c("ivreward_" + str);
    }

    public static h a() {
        if (f2721b == null) {
            synchronized (h.class) {
                try {
                    if (f2721b == null) {
                        f2721b = new h();
                    }
                } finally {
                }
            }
        }
        return f2721b;
    }

    public final g a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return i.a();
            }
            g gVarB = b(str);
            return gVarB == null ? i.a() : gVarB;
        } catch (Exception unused) {
            return i.a();
        }
    }

    public final boolean a(String str, int i10, String str2) {
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            String str3 = str + "_" + i10 + "_" + str2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j10 = 0;
            long jLongValue = ((Long) an.a(contextC, str3, 0L)).longValue();
            g gVarB = b(str);
            if (gVarB == null) {
                a();
                gVarB = i.a();
            } else {
                j10 = jLongValue;
            }
            if ((gVarB.ao() * 1000) + j10 > jCurrentTimeMillis) {
                return false;
            }
            an.b(contextC, str3, Long.valueOf(jCurrentTimeMillis));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject.length() == 0) {
            return jSONObject2;
        }
        if (jSONObject2 != null && jSONObject2.length() != 0) {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if ("unitSetting".equals(next) && jSONObject.has("unitSetting")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("unitSetting");
                    jSONArray.put(0, a((JSONObject) jSONArray.get(0), (JSONObject) jSONObject2.getJSONArray("unitSetting").get(0)));
                    jSONObject.put(next, jSONArray);
                } else {
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            }
        }
        return jSONObject;
    }

    public final void a(String str, String str2, String str3) {
        String strJ = a3.a.j(str, "_", str2);
        com.mbridge.msdk.foundation.a.a.a.a().a(strJ, str3);
        f2723d.put(strJ, k.g(str3));
    }

    public final k a(String str, String str2) {
        k kVarI = i(str, str2);
        return kVarI == null ? k.y() : kVarI;
    }
}
