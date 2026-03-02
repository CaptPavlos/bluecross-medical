package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f6558a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6559b = false;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, j> f6560c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> f6561d;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> e;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<a>> f;

    private b() {
    }

    public static b getInstance() {
        if (f6558a == null) {
            synchronized (b.class) {
                try {
                    if (f6558a == null) {
                        f6558a = new b();
                    }
                } finally {
                }
            }
        }
        return f6558a;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(int r13, java.lang.String r14, boolean r15, int r16, boolean r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, com.mbridge.msdk.foundation.same.report.d.e r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.b.a(int, java.lang.String, boolean, int, boolean, int, java.util.List, boolean, com.mbridge.msdk.foundation.same.report.d.e):boolean");
    }

    public final int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayListC;
        a value;
        CampaignEx campaignExL;
        ConcurrentHashMap<String, j> concurrentHashMap = this.f6560c;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, j>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                j value2 = it.next().getValue();
                if (value2 != null && (copyOnWriteArrayListC = value2.c()) != null) {
                    int size = copyOnWriteArrayListC.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        Map<String, a> map = copyOnWriteArrayListC.get(i10);
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it2 = map.entrySet().iterator();
                            if (it2.hasNext() && (value = it2.next().getValue()) != null && (campaignExL = value.l()) != null) {
                                String videoUrlEncode = campaignExL.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return value.k();
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public final j c(String str) {
        ConcurrentHashMap<String, j> concurrentHashMap = this.f6560c;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f6560c.get(str);
    }

    public j createUnitCache(Context context, String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, int i10, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (TextUtils.isEmpty(str) || copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        if (!this.f6560c.containsKey(str)) {
            j jVar = new j(context, copyOnWriteArrayList, str, i10);
            if (aVar != null) {
                jVar.a(aVar);
            }
            this.f6560c.put(str, jVar);
            return jVar;
        }
        j jVar2 = this.f6560c.get(str);
        if (jVar2 == null) {
            jVar2 = new j(context, copyOnWriteArrayList, str, i10);
            this.f6560c.put(str, jVar2);
        }
        if (i10 == 94 || i10 == 287) {
            jVar2.a(copyOnWriteArrayList.get(0).getRequestId(), aVar);
        } else {
            jVar2.a(aVar);
        }
        jVar2.a(copyOnWriteArrayList);
        return jVar2;
    }

    public void load(String str) {
        j jVarC = c(str);
        if (jVarC != null) {
            jVarC.a();
        }
    }

    public j createUnitCache(Context context, String str, CampaignEx campaignEx, int i10, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.f6560c.containsKey(str)) {
            j jVar = this.f6560c.get(str);
            if (jVar == null) {
                jVar = new j(context, campaignEx, str, i10);
                this.f6560c.put(str, jVar);
            }
            if (i10 != 94 && i10 != 287) {
                jVar.a(aVar);
            } else {
                jVar.a(campaignEx.getRequestId(), aVar);
            }
            jVar.a(campaignEx);
            return jVar;
        }
        j jVar2 = new j(context, campaignEx, str, i10);
        if (aVar != null) {
            jVar2.a(aVar);
        }
        this.f6560c.put(str, jVar2);
        return jVar2;
    }

    public final void b(String str, CopyOnWriteArrayList<a> copyOnWriteArrayList) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.f;
        if (concurrentHashMap == null) {
            this.f = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap.clear();
        }
        this.f.put(str, copyOnWriteArrayList);
    }

    public final CopyOnWriteArrayList<a> b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f.get(str);
    }

    public final void b(boolean z9) {
        if (z9) {
            if (this.f6559b) {
                return;
            }
        } else {
            this.f6559b = false;
        }
        ConcurrentHashMap<String, j> concurrentHashMap = this.f6560c;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, j>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().a();
            }
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.e;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.e.get(str);
    }

    public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.e;
        if (concurrentHashMap == null) {
            this.e = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap.clear();
        }
        this.e.put(str, copyOnWriteArrayList);
    }

    public final boolean a(int i10, String str, boolean z9) {
        try {
            j jVarC = c(str);
            if (jVarC != null) {
                return jVarC.a(i10, z9) != null;
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean a(int i10, String str, boolean z9, int i11, boolean z10, int i12, List<CampaignEx> list) {
        return a(i10, str, z9, i11, z10, i12, list, false, null);
    }

    public final a a(String str, String str2) {
        j jVarC = c(str);
        if (jVarC != null) {
            return jVarC.a(str2);
        }
        return null;
    }

    public final void a(boolean z9) {
        this.f6559b = z9;
        ConcurrentHashMap<String, j> concurrentHashMap = this.f6560c;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, j>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                j value = it.next().getValue();
                if (value != null) {
                    value.b();
                }
            }
        }
    }

    public final void a() {
        ConcurrentHashMap<String, j> concurrentHashMap = this.f6560c;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, j> entry : concurrentHashMap.entrySet()) {
                j value = entry.getValue();
                String key = entry.getKey();
                try {
                    com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), key);
                    if (cVarA != null) {
                        if (cVarA.w() == 2) {
                            value.b();
                        } else {
                            value.a();
                        }
                    }
                } catch (Exception e) {
                    af.b("DownLoadManager", e.getMessage());
                    try {
                        if (!TextUtils.isEmpty(key)) {
                            k kVarD = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), key);
                            if (kVarD == null) {
                                kVarD = k.e(key);
                            }
                            if (kVarD.k() == 2) {
                                value.b();
                            } else {
                                value.a();
                            }
                        }
                    } catch (Exception e3) {
                        af.b("DownLoadManager", e3.getMessage());
                    }
                }
            }
        }
    }
}
