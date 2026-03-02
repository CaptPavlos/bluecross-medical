package com.mbridge.msdk.videocommon.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.d.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6483a = "com.mbridge.msdk.videocommon.a.a";

    /* renamed from: b, reason: collision with root package name */
    private static a f6484b;

    /* renamed from: c, reason: collision with root package name */
    private e f6485c;

    private a() {
        try {
            Context contextC = c.m().c();
            if (contextC != null) {
                this.f6485c = e.a(g.a(contextC));
            } else {
                af.b(f6483a, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i10, boolean z9, String str2) {
        Exception exc;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = b.a().b();
            long jF = aVarB != null ? aVarB.f() : 0L;
            if (!TextUtils.isEmpty(str)) {
                e eVar = this.f6485c;
                List<CampaignEx> listA = z9 ? eVar.a(str, 0, 0, i10, str2) : eVar.a(str, 0, 0, i10, false);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (listA != null) {
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                    try {
                        for (CampaignEx campaignEx : listA) {
                            if (campaignEx != null && (campaignEx.getReadyState() == 0 || campaignEx.getLoadTimeoutState() == 1)) {
                                long plct = campaignEx.getPlct() * 1000;
                                long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                                if ((plct > 0 && plct >= timestamp) || (plct <= 0 && jF >= timestamp)) {
                                    copyOnWriteArrayList2.add(campaignEx);
                                }
                            }
                        }
                        return copyOnWriteArrayList2;
                    } catch (Exception e) {
                        exc = e;
                        copyOnWriteArrayList = copyOnWriteArrayList2;
                        exc.printStackTrace();
                        return copyOnWriteArrayList;
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            exc = e3;
        }
    }

    public final void b(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMapF;
        try {
            if (TextUtils.isEmpty(str) || (concurrentHashMapF = this.f6485c.f(str)) == null || concurrentHashMapF.size() <= 0) {
                return;
            }
            com.mbridge.msdk.c.g gVarB = h.a().b(c.m().k());
            if (gVarB == null) {
                h.a();
                gVarB = i.a();
            }
            long jAd = gVarB != null ? gVarB.ad() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (com.mbridge.msdk.foundation.entity.c cVar : concurrentHashMapF.values()) {
                if (cVar != null) {
                    long jE = cVar.e();
                    if (jE <= 0) {
                        jE = jAd;
                    }
                    if ((jE * 1000) + cVar.f() < jCurrentTimeMillis && !TextUtils.isEmpty(cVar.a())) {
                        af.b("HBOPTIMIZE", "不在有效期范围内 删除" + cVar.a());
                        c(str, cVar.a());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final List<CampaignEx> c(String str, int i10, boolean z9, String str2) {
        long jAd;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.c.g gVarB = h.a().b(c.m().k());
            if (gVarB != null) {
                jAd = gVarB.ad();
            } else {
                h.a();
                jAd = i.a().ad();
            }
            long j10 = jAd * 1000;
            if (!TextUtils.isEmpty(str)) {
                e eVar = this.f6485c;
                try {
                    List<CampaignEx> listA = z9 ? eVar.a(str, 0, 0, i10, str2) : eVar.a(str, 0, 0, i10, false);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (listA != null) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            for (CampaignEx campaignEx : listA) {
                                if (campaignEx != null && campaignEx.getReadyState() == 0) {
                                    long plctb = campaignEx.getPlctb() * 1000;
                                    long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                                    if ((plctb <= 0 && j10 >= timestamp) || (plctb > 0 && plctb >= timestamp)) {
                                        arrayList2.add(campaignEx);
                                    }
                                }
                            }
                            return arrayList2;
                        } catch (Exception e) {
                            e = e;
                            arrayList = arrayList2;
                            e.printStackTrace();
                            return arrayList;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            return null;
        } catch (Exception e7) {
            e = e7;
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i10) {
        List<CampaignEx> listA;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (listA = this.f6485c.a(str, 0, 0, i10)) == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx campaignEx : listA) {
                    if (campaignEx != null) {
                        copyOnWriteArrayList2.add(campaignEx);
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e) {
                e = e;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                e.printStackTrace();
                return copyOnWriteArrayList;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2, int i10) {
        e eVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || TextUtils.isEmpty(str2) || (eVar = this.f6485c) == null) {
            return;
        }
        eVar.a(str, list, str2, i10);
    }

    public final void a(String str, List<CampaignEx> list) {
        e eVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (eVar = this.f6485c) == null) {
            return;
        }
        eVar.b(str, list);
    }

    public final void a(String str, List<CampaignEx> list, String str2) {
        e eVar;
        try {
            if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (eVar = this.f6485c) == null) {
                return;
            }
            eVar.a(str, list, str2);
        } catch (Exception e) {
            af.b(f6483a, e.getMessage());
        }
    }

    public final void a(String str, String str2) {
        if (this.f6485c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6485c.f(str, str2);
    }

    public final List<CampaignEx> a(String str, int i10, boolean z9) {
        return a(str, i10, z9, "");
    }

    public static a a() {
        if (f6484b == null) {
            synchronized (a.class) {
                try {
                    if (f6484b == null) {
                        f6484b = new a();
                    }
                } finally {
                }
            }
        }
        return f6484b;
    }

    public final List<CampaignEx> b(String str, int i10, boolean z9) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f6485c.a(str, 0, 0, i10, z9);
        } catch (Exception e) {
            af.b(f6483a, e.getLocalizedMessage());
            return null;
        }
    }

    public final synchronized void c(String str, String str2) {
        try {
            this.f6485c.c(str2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list != null) {
            try {
                com.mbridge.msdk.videocommon.d.a aVarB = b.a().b();
                long jF = aVarB != null ? aVarB.f() : 0L;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (list.size() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (CampaignEx campaignEx : list) {
                            if (campaignEx != null) {
                                long plct = campaignEx.getPlct() * 1000;
                                long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                                if ((plct > 0 && plct >= timestamp) || (plct <= 0 && jF >= timestamp)) {
                                    arrayList2.add(campaignEx);
                                }
                            }
                        }
                        return arrayList2;
                    } catch (Exception e) {
                        e = e;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return arrayList;
    }

    public final int b(String str, int i10, boolean z9, String str2) {
        List<CampaignEx> listA;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            e eVar = this.f6485c;
            if (z9) {
                listA = eVar.a(str, 0, 0, i10, str2);
            } else {
                listA = eVar.a(str, 0, 0, i10, false);
            }
            if (listA == null) {
                return 0;
            }
            for (CampaignEx campaignEx : listA) {
                if (campaignEx != null && campaignEx.getReadyState() == 0) {
                    arrayList.add(campaignEx);
                }
            }
            return arrayList.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final synchronized void c(String str, int i10) {
        int iM;
        try {
            try {
                com.mbridge.msdk.c.g gVarB = h.a().b(c.m().k());
                if (gVarB == null) {
                    h.a();
                    gVarB = i.a();
                }
                iM = gVarB.m();
            } catch (Exception e) {
                af.b(f6483a, e.getMessage());
            }
            if (iM == 0) {
                return;
            }
            List<CampaignEx> listB = this.f6485c.b(str, i10, iM == 2);
            if (listB != null && listB.size() > 0) {
                for (CampaignEx campaignEx : listB) {
                    String requestIdNotice = campaignEx.getRequestIdNotice();
                    String id = campaignEx.getId();
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getCampaignUnitId() + "_" + id + "_" + requestIdNotice + "_" + campaignEx.getCMPTEntryUrl());
                }
            }
            this.f6485c.a(str, i10, iM == 2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final List<com.mbridge.msdk.foundation.entity.c> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f6485c.d(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void b(String str, String str2) {
        e eVar = this.f6485c;
        if (eVar != null) {
            eVar.e(str, str2);
        }
    }

    public final void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (campaignEx.isBidCampaign()) {
                    com.mbridge.msdk.foundation.same.a.b.c(str, campaignEx.getRequestId());
                }
                this.f6485c.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(String str, int i10) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.c> listD = this.f6485c.d(str);
            if (listD == null || listD.size() <= 0 || (size = listD.size() - i10) <= 0) {
                return;
            }
            for (int i11 = 0; i11 < size; i11++) {
                c(str, listD.get(i11).a());
                com.mbridge.msdk.foundation.same.a.b.c(str, listD.get(i11).a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getId())) {
                    return;
                }
                this.f6485c.b(campaignEx.getId(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str2) || list == null || list.size() <= 0) {
                return;
            }
            this.f6485c.a(list, str, str2, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final synchronized void a(long j10, String str) {
        try {
            this.f6485c.a(j10, str);
        } catch (Exception e) {
            e.printStackTrace();
            af.b(f6483a, e.getMessage());
        }
    }
}
