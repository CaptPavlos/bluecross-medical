package com.mbridge.msdk.foundation.same.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.c;
import com.mbridge.msdk.foundation.entity.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, c>> f3627d = null;
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> e = null;
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f = null;

    /* renamed from: n, reason: collision with root package name */
    private static final String f3633n = "b";

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f3624a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f3625b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f3626c = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> g = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f3628i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f3629j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public static Map<String, Long> f3630k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f3631l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f3632m = new HashMap();

    public static String a(String str, String str2) throws JSONException {
        List<com.mbridge.msdk.foundation.same.d.a> list;
        JSONArray jSONArray = new JSONArray();
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> mapD = TextUtils.isEmpty(str2) ? f3628i.containsKey(str) ? f3628i : f3629j.containsKey(str) ? f3629j : g.containsKey(str) ? g : f3632m.containsKey(str) ? f3632m : h.containsKey(str) ? h : f3625b.containsKey(str) ? f3625b : f3631l.containsKey(str) ? f3631l : f3626c.containsKey(str) ? f3626c : null : d(str2);
        if (mapD != null) {
            try {
                if (ap.b(str) && mapD.containsKey(str) && (list = mapD.get(str)) != null && list.size() > 0) {
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", list.get(i10).a());
                        jSONObject.put("1", list.get(i10).c());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static d b(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        d dVar = new d();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = e;
                if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = e.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                    dVar.a(1);
                    dVar.c(concurrentHashMap.get(str2));
                    return dVar;
                }
            } catch (Exception e3) {
                af.a(f3633n, e3.getMessage());
                return dVar;
            }
        }
        return dVar;
    }

    public static void c(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, c>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f3627d) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            f3627d.remove(str);
            return;
        }
        ConcurrentHashMap<String, c> concurrentHashMap2 = f3627d.get(str);
        if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str2)) {
            return;
        }
        concurrentHashMap2.remove(str2);
    }

    private static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> d(String str) {
        str.getClass();
        switch (str) {
            case "banner":
                return f3625b;
            case "native":
                return f3628i;
            case "reward":
                return f3629j;
            case "splash":
                return f3631l;
            case "h5_native":
                return f3626c;
            case "interstitial":
                return h;
            case "interactive":
                return g;
            default:
                return null;
        }
    }

    public static void c(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f.get(str)) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        copyOnWriteArrayList.remove(0);
    }

    public static String b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = f) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = f.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            return copyOnWriteArrayList.get(0);
        }
        return "";
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = e;
            if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str) || (concurrentHashMap = e.get(str2)) == null || !concurrentHashMap.containsKey(str2)) {
                return;
            }
            concurrentHashMap.remove(str2);
        } catch (Exception e3) {
            af.a(f3633n, e3.getMessage());
        }
    }

    public static void a(String str, String str2, int i10) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f == null) {
            f = new ConcurrentHashMap<>();
        }
        try {
            if (f.containsKey(str)) {
                copyOnWriteArrayList = f.get(str);
                copyOnWriteArrayList.add(str2);
            } else {
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                copyOnWriteArrayList2.add(str2);
                f.put(str, copyOnWriteArrayList2);
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
            int size = copyOnWriteArrayList.size() - i10;
            if (size >= 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    copyOnWriteArrayList.remove(i11);
                }
            }
        } catch (Exception e3) {
            af.a(f3633n, e3.getMessage());
        }
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            if (e == null) {
                e = new ConcurrentHashMap<>();
            }
            if (e.containsKey(str)) {
                if (e.get(str) == null) {
                    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                    concurrentHashMap.put(str2, str3);
                    e.put(str, concurrentHashMap);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap2.put(str2, str3);
            e.put(str, concurrentHashMap2);
        } catch (Exception e3) {
            af.a(f3633n, e3.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, long j10, long j11, long j12) {
        if (f3627d == null) {
            f3627d = new ConcurrentHashMap<>();
        }
        try {
            if (f3627d.containsKey(str)) {
                ConcurrentHashMap<String, c> concurrentHashMap = f3627d.get(str);
                if (concurrentHashMap != null) {
                    c cVar = concurrentHashMap.get(str2);
                    if (cVar == null) {
                        c cVar2 = new c();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        cVar2.a(arrayList);
                        cVar2.a(j10);
                        cVar2.b(j11);
                        cVar2.c(j12);
                        concurrentHashMap.put(str2, cVar2);
                        return;
                    }
                    if (cVar.c() != null) {
                        cVar.a(j10);
                        cVar.b(j11);
                        cVar.c(j12);
                        cVar.c().add(str3);
                        return;
                    }
                    return;
                }
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str3);
            ConcurrentHashMap<String, c> concurrentHashMap2 = new ConcurrentHashMap<>();
            c cVar3 = new c();
            cVar3.a(arrayList2);
            cVar3.a(j10);
            cVar3.b(j11);
            cVar3.c(j12);
            concurrentHashMap2.put(str2, cVar3);
            f3627d.put(str, concurrentHashMap2);
        } catch (Throwable th) {
            af.b(f3633n, th.getMessage());
        }
    }

    public static ConcurrentHashMap<String, c> a(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, c>> concurrentHashMap = f3627d;
        if (concurrentHashMap == null) {
            e eVarA = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            if (eVarA != null) {
                eVarA.d(str, "");
                f3627d = new ConcurrentHashMap<>();
                return null;
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return f3627d.get(str);
        }
        return null;
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> mapD = d(str2);
        if (campaignEx == null || mapD == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(campaignEx.getId())) {
                return;
            }
            com.mbridge.msdk.foundation.same.d.a aVar = new com.mbridge.msdk.foundation.same.d.a(campaignEx.getId(), campaignEx.getRequestIdNotice());
            if (mapD.containsKey(str)) {
                List<com.mbridge.msdk.foundation.same.d.a> list = mapD.get(str);
                if (list != null && list.size() == 20) {
                    list.remove(0);
                }
                if (list != null) {
                    list.add(aVar);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            mapD.put(str, arrayList);
        } catch (Throwable th) {
            af.b(f3633n, th.getMessage(), th);
        }
    }
}
