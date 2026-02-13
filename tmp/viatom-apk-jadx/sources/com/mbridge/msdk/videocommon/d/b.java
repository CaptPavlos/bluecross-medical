package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f6511d;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f6512c = false;
    private CopyOnWriteArrayList<String> e = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f6510b = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public static a f6509a = null;

    private b() {
    }

    private void g(String str, String str2) {
        if (this.f6512c) {
            return;
        }
        this.f6512c = true;
        new com.mbridge.msdk.videocommon.c.a().a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2);
    }

    private void h(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            i.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2, 2, a3.a.i("alert url is exception ,url:", str));
        } else {
            H5DownLoadManager.getInstance().downloadH5Res(new com.mbridge.msdk.foundation.same.report.d.c(true), str, new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.videocommon.d.b.1
                @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
                public final void onFailed(String str3, String str4) {
                    i.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2, 2, str4);
                }

                @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
                public final void onSuccess(String str3, String str4, boolean z9) {
                    i.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2, 1, "");
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.mbridge.msdk.videocommon.d.c a(java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "reward_"
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r1 = "_"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = com.mbridge.msdk.videocommon.d.b.f6510b
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L3c
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r7 = com.mbridge.msdk.videocommon.d.b.f6510b     // Catch: java.lang.Exception -> L2c
            java.lang.Object r7 = r7.get(r0)     // Catch: java.lang.Exception -> L2c
            com.mbridge.msdk.videocommon.d.c r7 = (com.mbridge.msdk.videocommon.d.c) r7     // Catch: java.lang.Exception -> L2c
            boolean r0 = r4.a(r7)     // Catch: java.lang.Exception -> L2d
            goto L2e
        L2c:
            r7 = r2
        L2d:
            r0 = 0
        L2e:
            if (r0 == 0) goto L3b
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.b()
            r4.a(r5, r0, r6, r2)
        L3b:
            return r7
        L3c:
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.String r1 = r1.a(r0)
            com.mbridge.msdk.videocommon.d.c r1 = com.mbridge.msdk.videocommon.d.c.c(r1)
            boolean r3 = r4.a(r1)
            if (r3 == 0) goto L61
            if (r1 != 0) goto L60
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.b()
            r4.a(r5, r0, r6, r2)
            com.mbridge.msdk.videocommon.d.c r5 = r4.b(r7)
            return r5
        L60:
            return r1
        L61:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r5 = com.mbridge.msdk.videocommon.d.b.f6510b
            r5.put(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.a(java.lang.String, java.lang.String, boolean):com.mbridge.msdk.videocommon.d.c");
    }

    public final c b(boolean z9) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.mbridge.msdk.videocommon.b.b(1, 30, null));
            cVar.a((List<com.mbridge.msdk.videocommon.b.b>) arrayList);
            cVar.m(1);
            cVar.l(1);
            cVar.n(1);
            cVar.q(1);
            cVar.o(1);
            cVar.p(1);
            cVar.h(3);
            cVar.i(80);
            cVar.j(100);
            cVar.k(0);
            cVar.g(2);
            cVar.e(-1);
            cVar.x(70);
            cVar.d(2);
            if (z9) {
                cVar.c(5);
            } else {
                cVar.c(-1);
            }
            cVar.b(0);
            cVar.a(0);
            cVar.f(1);
            cVar.r(1);
            cVar.t(3);
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            arrayList2.add(4);
            arrayList2.add(6);
            cVar.a(arrayList2);
            cVar.u(1);
            cVar.v(1);
            cVar.w(60);
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }

    public final a c() {
        a aVar = new a();
        HashMap map = new HashMap(5);
        map.put("1", 1000);
        map.put("9", 1000);
        map.put("8", 1000);
        HashMap map2 = new HashMap(3);
        map2.put("1", new com.mbridge.msdk.videocommon.b.c("Virtual Item", 1));
        aVar.a(map);
        aVar.b(map2);
        aVar.a(43200L);
        aVar.b(5400L);
        aVar.c(3600L);
        aVar.d(3600L);
        aVar.e(5L);
        aVar.a(1);
        return aVar;
    }

    public final void d(String str, String str2) {
        try {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str + "_" + str2);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th) {
            af.b("RewardSettingManager", th.getMessage());
        }
    }

    public final a e() {
        String str = "reward_" + com.mbridge.msdk.foundation.controller.c.m().k();
        if (f6509a == null) {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str);
            if (!TextUtils.isEmpty(strA)) {
                a aVarA = a.a(strA);
                if (aVarA != null) {
                    f6509a = aVarA;
                }
                return aVarA;
            }
        }
        return f6509a;
    }

    public final void f(String str) {
        try {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            jSONObject.put("current_time", System.currentTimeMillis());
            c(str, jSONObject.toString());
        } catch (Throwable th) {
            af.b("RewardSettingManager", th.getMessage());
        }
    }

    public final String g(String str) {
        return com.mbridge.msdk.foundation.a.a.a.a().a(a3.a.i("reward_", str));
    }

    public final String e(String str, String str2) {
        return com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str + "_" + str2);
    }

    public static boolean e(String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String strOptString = jSONArrayOptJSONArray.optJSONObject(0).optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (jSONArrayOptJSONArray.length() > 0) {
                    if (!TextUtils.isEmpty(strOptString)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final c f(String str, String str2) {
        String str3 = "reward_" + str + "_" + str2;
        if (f6510b.containsKey(str3)) {
            return f6510b.get(str3);
        }
        c cVarC = c.c(com.mbridge.msdk.foundation.a.a.a.a().a(str3));
        if (cVarC != null) {
            f6510b.put(str3, cVarC);
        }
        return cVarC;
    }

    public final boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.e.contains(str);
    }

    public final boolean d() {
        return this.f6512c;
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str, false);
        String str2 = c.f6516a;
        if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
            return;
        }
        h(str2, str);
    }

    public final void c(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a(a3.a.i("reward_", str), str2);
        f6509a = a.a(str2);
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.e.add(str);
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2, String str3, com.mbridge.msdk.videocommon.c.c cVar) {
        if (!TextUtils.isEmpty(str3) && !this.e.contains(str3)) {
            a(str3);
            new com.mbridge.msdk.videocommon.c.a().a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2, str3, cVar);
            return;
        }
        af.a("test_reward_unit_setting", "unitID: " + str3 + " is requesting");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.mbridge.msdk.videocommon.d.c a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "reward_"
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r1 = "_"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = com.mbridge.msdk.videocommon.d.b.f6510b
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L3c
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = com.mbridge.msdk.videocommon.d.b.f6510b     // Catch: java.lang.Exception -> L2c
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Exception -> L2c
            com.mbridge.msdk.videocommon.d.c r0 = (com.mbridge.msdk.videocommon.d.c) r0     // Catch: java.lang.Exception -> L2c
            boolean r1 = r4.a(r0)     // Catch: java.lang.Exception -> L2d
            goto L2e
        L2c:
            r0 = r2
        L2d:
            r1 = 0
        L2e:
            if (r1 == 0) goto L3b
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r1 = r1.b()
            r4.a(r5, r1, r6, r2)
        L3b:
            return r0
        L3c:
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.String r1 = r1.a(r0)
            com.mbridge.msdk.videocommon.d.c r1 = com.mbridge.msdk.videocommon.d.c.c(r1)
            boolean r3 = r4.a(r1)
            if (r3 == 0) goto L5a
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.b()
            r4.a(r5, r0, r6, r2)
            return r2
        L5a:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r5 = com.mbridge.msdk.videocommon.d.b.f6510b
            r5.put(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.a(java.lang.String, java.lang.String):com.mbridge.msdk.videocommon.d.c");
    }

    public static b a() {
        if (f6511d == null) {
            synchronized (b.class) {
                try {
                    if (f6511d == null) {
                        f6511d = new b();
                    }
                } finally {
                }
            }
        }
        return f6511d;
    }

    private final boolean a(c cVar) {
        a aVarB = b();
        if (aVarB == null || cVar == null) {
            return true;
        }
        return cVar.x() + aVarB.e() <= System.currentTimeMillis();
    }

    public final void a(String str, String str2, String str3) {
        String str4 = "reward_" + str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        f6510b.put(str4, c.c(str3));
        if (com.mbridge.msdk.e.b.a() || TextUtils.isEmpty(c.f6516a)) {
            return;
        }
        h(c.f6516a, str2);
    }

    public final void a(boolean z9) {
        this.f6512c = z9;
    }

    public final a b() {
        a aVar = f6509a;
        if (aVar != null) {
            return aVar;
        }
        String strA = com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + com.mbridge.msdk.foundation.controller.c.m().k());
        if (!TextUtils.isEmpty(strA)) {
            a aVarA = a.a(strA);
            if (aVarA != null) {
                if (aVarA.i() + aVarA.d() > System.currentTimeMillis()) {
                    return aVarA;
                }
            }
            g(com.mbridge.msdk.foundation.controller.c.m().k(), com.mbridge.msdk.foundation.controller.c.m().b());
            return c();
        }
        g(com.mbridge.msdk.foundation.controller.c.m().k(), com.mbridge.msdk.foundation.controller.c.m().b());
        return c();
    }

    public final void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
            return;
        }
        h(str2, str);
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.e.remove(str);
        } catch (Exception unused) {
        }
    }
}
