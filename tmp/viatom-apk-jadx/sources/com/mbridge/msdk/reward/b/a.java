package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.b.a;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.f;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static String f5213b = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f5214d = null;
    public static String e = "";
    private int A;
    private int B;
    private int C;
    private boolean H;
    private Queue<Integer> P;
    private String Q;
    private CopyOnWriteArrayList<CampaignEx> Z;

    /* renamed from: a, reason: collision with root package name */
    b f5215a;
    private List<CampaignEx> aa;

    /* renamed from: l, reason: collision with root package name */
    private Context f5220l;

    /* renamed from: m, reason: collision with root package name */
    private com.mbridge.msdk.reward.adapter.c f5221m;

    /* renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f5222n;

    /* renamed from: o, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.a f5223o;

    /* renamed from: p, reason: collision with root package name */
    private volatile InterVideoOutListener f5224p;

    /* renamed from: q, reason: collision with root package name */
    private volatile c f5225q;

    /* renamed from: r, reason: collision with root package name */
    private String f5226r;

    /* renamed from: s, reason: collision with root package name */
    private String f5227s;
    private MBridgeIds t;

    /* renamed from: u, reason: collision with root package name */
    private String f5228u;

    /* renamed from: v, reason: collision with root package name */
    private volatile String f5229v;

    /* renamed from: w, reason: collision with root package name */
    private String f5230w;
    private static ConcurrentHashMap<String, Integer> N = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> O = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, d> f = new ConcurrentHashMap<>();

    /* renamed from: x, reason: collision with root package name */
    private int f5231x = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f5232z = 2;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean I = false;
    private ArrayList<Integer> J = new ArrayList<>(7);
    private boolean K = false;
    private final Object L = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f5216c = false;
    private List<CampaignEx> M = new ArrayList();
    private g R = null;
    private volatile boolean S = true;
    private volatile boolean T = false;
    private volatile boolean U = false;
    private volatile boolean V = false;
    private volatile boolean W = false;
    private volatile boolean X = false;
    private volatile boolean Y = false;
    volatile boolean g = false;
    volatile boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    volatile boolean f5217i = false;

    /* renamed from: j, reason: collision with root package name */
    volatile boolean f5218j = false;

    /* renamed from: k, reason: collision with root package name */
    volatile boolean f5219k = false;
    private Handler y = new com.mbridge.msdk.reward.b.b(this);

    private void a(boolean z9, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        String str2 = str;
        com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
        if (this.f5225q != null) {
            if (!this.E) {
                this.Y = c(this.f5227s, cVar2.f());
                if (!this.Y) {
                    if (!s()) {
                        this.Y = false;
                        com.mbridge.msdk.reward.adapter.c cVar3 = this.f5221m;
                        if (cVar3 != null) {
                            cVar3.a(this.Z);
                        }
                        this.f5225q.a(this.E);
                        a(this.P, z9, str2, cVar2);
                        return;
                    }
                    if (z9) {
                        if (this.f5225q != null) {
                            String strA = com.mbridge.msdk.foundation.c.a.a(880019, "");
                            cVar2.a(com.mbridge.msdk.foundation.c.a.b(880019, ""));
                            cVar2.c(true);
                            c.a(this.f5225q, strA, cVar2);
                            return;
                        }
                        return;
                    }
                    this.Y = false;
                    com.mbridge.msdk.reward.adapter.c cVar4 = this.f5221m;
                    if (cVar4 != null) {
                        cVar4.a(this.Z);
                    }
                    this.f5225q.a(this.E);
                    a(this.P, z9, str2, cVar2);
                    return;
                }
                if (s()) {
                    af.a("RewardVideoController", "非BID，本地存在可用的缓存，超过上限");
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.Z;
                    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                        Iterator<CampaignEx> it = this.Z.iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.videocommon.a.a.a().a(it.next(), this.f5227s);
                        }
                    }
                    com.mbridge.msdk.reward.adapter.c cVar5 = this.f5221m;
                    if (cVar5 != null) {
                        cVar5.a(this.Z);
                    }
                    if (!z9) {
                        this.Y = false;
                        this.f5225q.a(this.E);
                        a(this.P, z9, str2, cVar2);
                        return;
                    } else {
                        if (this.f5225q != null) {
                            String strA2 = com.mbridge.msdk.foundation.c.a.a(880019, "");
                            cVar2.a(com.mbridge.msdk.foundation.c.a.b(880019, ""));
                            cVar2.c(true);
                            c.a(this.f5225q, strA2, cVar2);
                            return;
                        }
                        return;
                    }
                }
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.Z;
                if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                    return;
                }
                try {
                    e eVar = new e();
                    eVar.a("cache", 1);
                    cVar2.a("2000127", eVar);
                    cVar2.a("2000048", eVar);
                    cVar2.a(copyOnWriteArrayList2);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", e3.getMessage());
                    }
                }
                c.a(this.f5225q, this.f5229v, this.f5227s, cVar2);
                CampaignEx campaignEx = copyOnWriteArrayList2.get(0);
                this.f5225q.a(this.E);
                com.mbridge.msdk.reward.adapter.c cVar6 = this.f5221m;
                if (cVar6 == null || !cVar6.a(copyOnWriteArrayList2, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                    a(copyOnWriteArrayList2, this.f5221m);
                } else {
                    a(copyOnWriteArrayList2);
                    this.f5225q.b(this.f5229v, this.f5227s, cVar2);
                }
                if (this.S) {
                    com.mbridge.msdk.reward.adapter.c cVar7 = this.f5221m;
                    if (cVar7 != null) {
                        cVar7.a(this.Z);
                    }
                    a(this.P, z9, str2, cVar2);
                    return;
                }
                return;
            }
            List<CampaignEx> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.f5227s, 1, this.E, "");
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = null;
            if (listA == null || listA.size() <= 0) {
                if (s()) {
                    com.mbridge.msdk.videocommon.a.a.a().a(this.f5227s, str2);
                    if (!z9 || this.f5225q == null) {
                        return;
                    }
                    String strA3 = com.mbridge.msdk.foundation.c.a.a(880019, "");
                    com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880019, "");
                    if (cVar2 != null) {
                        cVar2.a(bVarB);
                        cVar2.c(true);
                    }
                    c.a(this.f5225q, strA3, cVar2);
                    return;
                }
                try {
                    com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(this.f5227s, this.D);
                    com.mbridge.msdk.foundation.b.c cVar8 = new com.mbridge.msdk.foundation.b.c();
                    try {
                        if (aVar.a(str2)) {
                            if (this.f5221m == null) {
                                com.mbridge.msdk.reward.adapter.c cVar9 = new com.mbridge.msdk.reward.adapter.c(this.f5220l, this.f5229v, this.f5227s);
                                this.f5221m = cVar9;
                                cVar9.b(this.D);
                                this.f5221m.c(this.E);
                                if (this.D) {
                                    this.f5221m.a(this.A, this.B, this.C);
                                }
                                this.f5221m.a(this.f5232z);
                                this.f5221m.a(this.f5222n);
                            }
                            cVar8 = aVar.a(str2, cVar2, (CampaignEx) null, new com.mbridge.msdk.foundation.c.b(880038), 1, this.f5221m);
                            if (cVar8 != null && cVar8.g() == com.mbridge.msdk.foundation.b.c.f3331d && cVar8.a() != null && cVar8.a().size() > 0 && this.f5221m != null) {
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA2 = cVar8.a();
                                if (listA != null) {
                                    ArrayList arrayList = new ArrayList();
                                    Iterator<CampaignEx> it2 = listA.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        CampaignEx next = it2.next();
                                        if (next != null) {
                                            String requestId = next.getRequestId();
                                            if (!TextUtils.isEmpty(requestId)) {
                                                for (int i10 = 0; i10 < copyOnWriteArrayListA2.size(); i10++) {
                                                    CampaignEx campaignEx2 = copyOnWriteArrayListA2.get(i10);
                                                    if (campaignEx2 != null) {
                                                        if (requestId.equals(campaignEx2.getRequestId())) {
                                                            break;
                                                        } else if (i10 == copyOnWriteArrayListA2.size() - 1) {
                                                            arrayList.add(next);
                                                        }
                                                    }
                                                }
                                                if (copyOnWriteArrayListA2.size() == 0) {
                                                    arrayList.add(next);
                                                }
                                            }
                                        }
                                    }
                                    this.f5221m.a(arrayList);
                                }
                                this.f5221m.a(cVar8.a(), false, true);
                                copyOnWriteArrayListA = new CopyOnWriteArrayList<>(cVar8.a());
                            }
                        } else {
                            copyOnWriteArrayListA = a(str2, listA);
                            if (copyOnWriteArrayListA.size() > 0) {
                                com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str2, copyOnWriteArrayListA);
                            }
                            cVar8.d("cb is closed 2");
                            cVar8.a(com.mbridge.msdk.foundation.b.c.f3330c);
                        }
                        try {
                            aVar.a(cVar, str2, cVar8, (List<a.C0025a>) null, (JSONObject) null, 1);
                            cVar2 = cVar;
                            str2 = str2;
                            if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                                a(copyOnWriteArrayListA, str2, cVar2);
                                if (this.f5221m != null && !aVar.a(str2)) {
                                    this.f5221m.a(copyOnWriteArrayListA);
                                }
                            }
                        } catch (Exception e7) {
                            e = e7;
                            cVar2 = cVar;
                            str2 = str2;
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardVideoController", e.getMessage());
                            }
                            this.Y = false;
                            this.f5225q.a(this.E);
                            a(this.P, z9, str2, cVar2);
                            return;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        cVar2 = cVar;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
                this.Y = false;
                this.f5225q.a(this.E);
                a(this.P, z9, str2, cVar2);
                return;
            }
            if (s()) {
                com.mbridge.msdk.videocommon.a.a.a().a(this.f5227s, str2);
                if (!z9 || this.f5225q == null) {
                    return;
                }
                String strA4 = com.mbridge.msdk.foundation.c.a.a(880019, "");
                com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880019, "");
                if (cVar2 != null) {
                    cVar2.a(bVarB2);
                    cVar2.c(true);
                }
                c.a(this.f5225q, strA4, cVar2);
                return;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
            if (listA.size() > 0 && !TextUtils.isEmpty(str2)) {
                for (CampaignEx campaignEx3 : listA) {
                    if (campaignEx3 != null && str2.equals(campaignEx3.getBidToken())) {
                        copyOnWriteArrayList3.add(campaignEx3);
                    }
                }
            }
            if (copyOnWriteArrayList3.size() > 0) {
                a(copyOnWriteArrayList3, str2, cVar2);
                return;
            }
            try {
                com.mbridge.msdk.reward.a.a aVar2 = new com.mbridge.msdk.reward.a.a(this.f5227s, this.D);
                com.mbridge.msdk.foundation.b.c cVar10 = new com.mbridge.msdk.foundation.b.c();
                try {
                    if (aVar2.a(str2)) {
                        if (this.f5221m == null) {
                            com.mbridge.msdk.reward.adapter.c cVar11 = new com.mbridge.msdk.reward.adapter.c(this.f5220l, this.f5229v, this.f5227s);
                            this.f5221m = cVar11;
                            cVar11.b(this.D);
                            this.f5221m.c(this.E);
                            if (this.D) {
                                this.f5221m.a(this.A, this.B, this.C);
                            }
                            this.f5221m.a(this.f5232z);
                            this.f5221m.a(this.f5222n);
                        }
                        cVar10 = aVar2.a(str2, cVar2, (CampaignEx) null, new com.mbridge.msdk.foundation.c.b(880038), 1, this.f5221m);
                        if (cVar10 != null && cVar10.g() == com.mbridge.msdk.foundation.b.c.f3331d && cVar10.a() != null && cVar10.a().size() > 0 && this.f5221m != null) {
                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA3 = cVar10.a();
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<CampaignEx> it3 = listA.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                CampaignEx next2 = it3.next();
                                if (next2 != null) {
                                    String requestId2 = next2.getRequestId();
                                    if (!TextUtils.isEmpty(requestId2)) {
                                        for (int i11 = 0; i11 < copyOnWriteArrayListA3.size(); i11++) {
                                            CampaignEx campaignEx4 = copyOnWriteArrayListA3.get(i11);
                                            if (campaignEx4 != null) {
                                                if (requestId2.equals(campaignEx4.getRequestId())) {
                                                    break;
                                                } else if (i11 == copyOnWriteArrayListA3.size() - 1) {
                                                    arrayList2.add(next2);
                                                }
                                            }
                                        }
                                        if (copyOnWriteArrayListA3.size() == 0) {
                                            arrayList2.add(next2);
                                        }
                                    }
                                }
                            }
                            this.f5221m.a(arrayList2);
                            this.f5221m.a(cVar10.a(), false, true);
                            copyOnWriteArrayListA = new CopyOnWriteArrayList<>(cVar10.a());
                        }
                    } else {
                        copyOnWriteArrayListA = a(str2, listA);
                        if (copyOnWriteArrayListA.size() > 0) {
                            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str2, copyOnWriteArrayListA);
                        }
                        cVar10.d("cb is closed");
                        cVar10.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    }
                    try {
                        aVar2.a(cVar, str2, cVar10, (List<a.C0025a>) null, (JSONObject) null, 1);
                        cVar2 = cVar;
                        str2 = str2;
                        if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                            a(copyOnWriteArrayListA, str2, cVar2);
                            if (this.f5221m != null && !aVar2.a(str2)) {
                                this.f5221m.a(copyOnWriteArrayListA);
                            }
                        }
                    } catch (Exception e12) {
                        e = e12;
                        cVar2 = cVar;
                        str2 = str2;
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e.getMessage());
                        }
                        this.Y = false;
                        this.f5225q.a(this.E);
                        a(this.P, z9, str2, cVar2);
                    }
                } catch (Exception e13) {
                    e = e13;
                    cVar2 = cVar;
                }
            } catch (Exception e14) {
                e = e14;
            }
            this.Y = false;
            this.f5225q.a(this.E);
            a(this.P, z9, str2, cVar2);
        }
    }

    private com.mbridge.msdk.foundation.same.report.d.c b(boolean z9, String str, e eVar) {
        List<String> listE;
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        try {
            if (z9) {
                try {
                    com.mbridge.msdk.foundation.db.e eVarA = com.mbridge.msdk.foundation.db.e.a(g.a(this.f5220l));
                    if (eVarA != null && (listE = eVarA.e(this.f5227s)) != null && listE.size() > 0) {
                        Iterator<String> it = listE.iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.foundation.same.report.d.d.a().b(it.next());
                        }
                    }
                    LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.d.c> linkedHashMapB = com.mbridge.msdk.foundation.same.report.d.d.a().b();
                    if (linkedHashMapB != null && linkedHashMapB.size() > 0) {
                        Iterator<Map.Entry<String, com.mbridge.msdk.foundation.same.report.d.c>> it2 = linkedHashMapB.entrySet().iterator();
                        while (it2.hasNext()) {
                            Map.Entry<String, com.mbridge.msdk.foundation.same.report.d.c> next = it2.next();
                            if (next != null && next.getValue().s()) {
                                it2.remove();
                            }
                        }
                    }
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        e3.printStackTrace();
                    }
                }
            }
            String md5 = TextUtils.isEmpty(str) ? SameMD5.getMD5(ak.d()) : a(str);
            cVar = com.mbridge.msdk.foundation.same.report.d.d.a().a(md5, "");
            if (cVar == null) {
                com.mbridge.msdk.foundation.same.report.d.c cVar2 = new com.mbridge.msdk.foundation.same.report.d.c();
                try {
                    com.mbridge.msdk.foundation.same.report.d.d.a().b().put(md5, cVar2);
                    cVar2.d(true);
                    cVar = cVar2;
                } catch (Exception e7) {
                    e = e7;
                    cVar = cVar2;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", e.getMessage());
                    }
                    return cVar;
                }
            }
            cVar.c(md5);
            cVar.d(this.f5227s);
            if (eVar != null) {
                if (eVar.a("adtp")) {
                    cVar.b(Integer.parseInt((String) eVar.b("adtp")));
                }
                if (eVar.a(CampaignEx.JSON_KEY_HB)) {
                    String str2 = (String) eVar.b(CampaignEx.JSON_KEY_HB);
                    cVar.i(str2);
                    if (str2.equals("1")) {
                        cVar.e(str);
                    }
                }
            }
            cVar.b(z9 ? "2" : "1");
            if (z9) {
                com.mbridge.msdk.reward.c.a.a.a().a("2000123", cVar);
            }
        } catch (Exception e10) {
            e = e10;
        }
        return cVar;
    }

    private boolean c(String str, String str2) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar = this.f5221m;
            if (cVar == null || !str.equals(cVar.a())) {
                com.mbridge.msdk.reward.adapter.c cVar2 = new com.mbridge.msdk.reward.adapter.c(this.f5220l, this.f5229v, str);
                this.f5221m = cVar2;
                cVar2.b(this.D);
                this.f5221m.c(this.E);
            }
            this.f5221m.a(this.f5232z);
            this.f5221m.a(this.f5222n);
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e3.getMessage());
            }
        }
        List<CampaignEx> listA = com.mbridge.msdk.videocommon.a.a.a().a(str, 1, this.E);
        this.aa = com.mbridge.msdk.videocommon.a.a.a().b(str, 1, this.E);
        if (listA == null || listA.size() <= 0) {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.Z;
            if (copyOnWriteArrayList == null) {
                return false;
            }
            copyOnWriteArrayList.clear();
            return false;
        }
        com.mbridge.msdk.videocommon.a.a.a().a(str, listA, str2);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.Z;
        if (copyOnWriteArrayList2 == null) {
            this.Z = new CopyOnWriteArrayList<>();
        } else {
            copyOnWriteArrayList2.clear();
        }
        for (CampaignEx campaignEx : listA) {
            campaignEx.setLocalRequestId(str2);
            this.Z.add(campaignEx);
        }
        a(this.Z);
        return true;
    }

    private boolean e(boolean z9) {
        if (z9) {
            d("is_ready_start", "");
        }
        if (this.f5221m == null) {
            r();
        }
        List<com.mbridge.msdk.foundation.entity.c> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.f5227s);
        if (listA == null || listA.size() <= 0) {
            if (z9) {
                d("is_ready_ctir_false", "no effective campaign list");
            }
            return false;
        }
        String strB = com.mbridge.msdk.foundation.same.a.b.b(this.f5227s);
        boolean zA = TextUtils.isEmpty(strB) ? false : a(listA, strB);
        if (z9) {
            d("is_ready_ctir_" + zA, "");
        }
        if (!zA) {
            for (com.mbridge.msdk.foundation.entity.c cVar : listA) {
                if (cVar != null) {
                    this.f5221m.a(cVar.a());
                    this.f5221m.f5144d = cVar.d();
                    if (this.f5221m.d(z9)) {
                        return true;
                    }
                }
            }
        }
        return zA;
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.c.m().c() == null) {
            return;
        }
        i iVarA = i.a(g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        f fVar = new f();
        fVar.a(System.currentTimeMillis());
        fVar.b(str);
        fVar.a(campaignEx.getId());
        iVarA.a(fVar);
    }

    private void p() {
        com.mbridge.msdk.foundation.db.e.a(g.a(this.f5220l)).a(this.f5227s);
    }

    private void q() {
        try {
            List<CampaignEx> listB = com.mbridge.msdk.foundation.db.e.a(g.a(this.f5220l)).b(this.f5227s);
            if (listB == null || listB.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : listB) {
                if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                } else {
                    com.mbridge.msdk.videocommon.a.b(this.f5227s + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl());
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        com.mbridge.msdk.videocommon.a.b(this.f5227s + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e3.getMessage());
            }
        }
    }

    private void r() {
        com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(this.f5220l, this.f5229v, this.f5227s);
        this.f5221m = cVar;
        cVar.b(this.D);
        this.f5221m.c(this.E);
        if (this.D) {
            this.f5221m.a(this.A, this.B, this.C);
        }
        this.f5221m.a(this.f5222n);
    }

    private boolean s() {
        try {
            if (this.R == null) {
                this.R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
            h hVarA = h.a(this.R);
            if (this.f5222n == null) {
                this.f5222n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f5227s, this.D);
            }
            int iD = this.f5222n.d();
            if (hVarA != null) {
                return hVarA.a(this.f5227s, iD);
            }
            return false;
        } catch (Throwable unused) {
            af.b("RewardVideoController", "cap check error");
            return false;
        }
    }

    public final boolean d(boolean z9) {
        try {
            if (s()) {
                if (!z9) {
                    return false;
                }
                d("is_ready_start", "over cap check error");
                return false;
            }
            if (this.E) {
                try {
                    return e(z9);
                } catch (Exception e3) {
                    if (!MBridgeConstans.DEBUG) {
                        return false;
                    }
                    af.b("RewardVideoController", e3.getMessage());
                    return false;
                }
            }
            if (this.f5221m == null) {
                r();
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f5221m;
            if (cVar != null) {
                return cVar.b();
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            af.b("RewardVideoController", th.getMessage());
            return false;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.reward.b.a$a, reason: collision with other inner class name */
    public class RunnableC0058a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.reward.adapter.c f5263b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5264c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f5265d;
        private boolean e = false;
        private int f;
        private String g;
        private com.mbridge.msdk.foundation.same.report.d.c h;

        public RunnableC0058a(com.mbridge.msdk.reward.adapter.c cVar, int i10, boolean z9, String str, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            this.f5263b = cVar;
            this.f5264c = i10;
            this.f5265d = z9;
            if (cVar != null) {
                cVar.e(false);
            }
            this.g = str;
            this.h = cVar2;
        }

        public final void a() {
            this.e = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.e) {
                return;
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f5263b;
            if (cVar != null) {
                cVar.e(true);
            }
            af.b("RewardVideoController", "adSource=" + this.f5264c + " CommonCancelTimeTask mIsDevCall：" + this.f5265d);
            a.this.a(com.mbridge.msdk.foundation.c.a.b(880023, "v3 is timeout"), this.h);
        }

        public final void a(int i10) {
            this.f = i10;
        }
    }

    public final List<CampaignEx> f() {
        return this.aa;
    }

    public final com.mbridge.msdk.reward.adapter.c g() {
        return this.f5221m;
    }

    public final boolean h() {
        return this.H;
    }

    public final String i() {
        return this.f5227s;
    }

    public final String j() {
        return this.f5229v;
    }

    public final c k() {
        return this.f5225q;
    }

    public final InterVideoOutListener l() {
        return this.f5224p;
    }

    public final boolean m() {
        return this.E;
    }

    public final MBridgeIds n() {
        return this.t;
    }

    public final boolean o() {
        return this.D;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class b implements com.mbridge.msdk.reward.adapter.a {

        /* renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.reward.adapter.c f5267b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5268c;

        /* renamed from: d, reason: collision with root package name */
        private RunnableC0058a f5269d;

        public b(com.mbridge.msdk.reward.adapter.c cVar, boolean z9) {
            this.f5267b = cVar;
            this.f5268c = z9;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            RunnableC0058a runnableC0058a = this.f5269d;
            if (runnableC0058a != null) {
                runnableC0058a.a();
                a.this.y.removeCallbacks(this.f5269d);
            }
            a.this.a(list);
            if (a.this.f5225q != null) {
                a.this.f5225q.a(a.this.f5229v, a.this.f5227s, cVar);
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            RunnableC0058a runnableC0058a = this.f5269d;
            if (runnableC0058a != null) {
                runnableC0058a.a();
                a.this.y.removeCallbacks(this.f5269d);
            }
            if (a.this.f5225q != null) {
                c.b(a.this.f5225q, a.this.f5229v, a.this.f5227s, cVar);
            }
        }

        public final void a(RunnableC0058a runnableC0058a) {
            this.f5269d = runnableC0058a;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            RunnableC0058a runnableC0058a = this.f5269d;
            if (runnableC0058a != null) {
                runnableC0058a.a();
                a.this.y.removeCallbacks(this.f5269d);
            }
            com.mbridge.msdk.reward.adapter.c cVar2 = this.f5267b;
            if (cVar2 != null) {
                cVar2.a((com.mbridge.msdk.reward.adapter.a) null);
                this.f5267b = null;
            }
            a.this.a(list);
            if (a.this.f5225q != null) {
                a.this.f5225q.a(bVar, cVar);
            }
        }
    }

    public final String d() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f5221m;
        if (cVar != null) {
            return cVar.f();
        }
        return "";
    }

    private void d(String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.d(this.f5227s);
            cVar.b(this.D ? 287 : 94);
            e eVar = new e();
            eVar.a("event_name", str);
            eVar.a("reason", str2);
            cVar.a("m_temp_is_ready_check", eVar);
            com.mbridge.msdk.reward.c.a.a.a().a("m_temp_is_ready_check", cVar);
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.reward.b.a$4, reason: invalid class name */
    public class AnonymousClass4 implements b.i {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.c f5252a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f5253b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f5254c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f5255d;
        final /* synthetic */ boolean e;
        final /* synthetic */ int f;

        public AnonymousClass4(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar, boolean z9, int i10) {
            this.f5253b = campaignEx;
            this.f5254c = copyOnWriteArrayList;
            this.f5255d = cVar;
            this.e = z9;
            this.f = i10;
            this.f5252a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
            String unitId;
            if (bVar != null) {
                unitId = bVar.d().getUnitId();
                bVar.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
            } else {
                unitId = "";
            }
            a aVar = a.this;
            a.a(aVar, unitId, aVar.aa);
            if (this.f5252a == null) {
                this.f5252a = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            this.f5252a.a(bVar);
            this.f5252a.b(this.f5254c);
            a.this.h = false;
            if (a.this.f5225q == null || a.this.f5218j) {
                return;
            }
            a.this.f5218j = true;
            c.a(a.this.f5225q, bVar, this.f5252a);
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(final String str, final String str2, final String str3, String str4) {
            a.this.h = true;
            if (!a.this.g || a.this.f5217i || a.this.y == null) {
                return;
            }
            a.this.f5217i = true;
            a.this.y.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.reward.adapter.b bVarA = com.mbridge.msdk.reward.adapter.b.a();
                    boolean z9 = a.this.I;
                    Handler handler = a.this.y;
                    boolean z10 = a.this.D;
                    boolean z11 = a.this.E;
                    String str5 = str3;
                    String requestIdNotice = AnonymousClass4.this.f5253b.getRequestIdNotice();
                    String str6 = str;
                    String str7 = str2;
                    String cMPTEntryUrl = AnonymousClass4.this.f5253b.getCMPTEntryUrl();
                    int i10 = a.this.f5232z;
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    bVarA.a(z9, handler, z10, z11, str5, requestIdNotice, str6, str7, cMPTEntryUrl, i10, anonymousClass4.f5253b, anonymousClass4.f5254c, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass4.this.f5253b.getCMPTEntryUrl()), str2, a.this.f5222n, new b.j() { // from class: com.mbridge.msdk.reward.b.a.4.1.1
                        @Override // com.mbridge.msdk.reward.adapter.b.j
                        public final void a(String str8, String str9, String str10, String str11, String str12, a.C0071a c0071a) {
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            com.mbridge.msdk.reward.adapter.c cVar = anonymousClass42.f5255d;
                            if (cVar != null && cVar.a(anonymousClass42.f5254c, anonymousClass42.e, anonymousClass42.f)) {
                                if (a.this.f5225q == null || a.this.f5219k) {
                                    return;
                                }
                                a.this.f5219k = true;
                                af.a("RewardVideoController", "Cache onVideoLoadSuccess");
                                AnonymousClass4 anonymousClass43 = AnonymousClass4.this;
                                a.this.a(anonymousClass43.f5254c);
                                AnonymousClass4 anonymousClass44 = AnonymousClass4.this;
                                com.mbridge.msdk.foundation.same.report.d.c cVar2 = anonymousClass44.f5252a;
                                if (cVar2 != null) {
                                    cVar2.b(anonymousClass44.f5254c);
                                }
                                a.this.f5225q.b(str9, str10, AnonymousClass4.this.f5252a);
                                return;
                            }
                            a aVar = a.this;
                            a.a(aVar, str10, aVar.aa);
                            if (a.this.f5225q == null || a.this.f5218j) {
                                return;
                            }
                            a.this.f5218j = true;
                            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                            AnonymousClass4 anonymousClass45 = AnonymousClass4.this;
                            if (anonymousClass45.f5252a == null) {
                                anonymousClass45.f5252a = new com.mbridge.msdk.foundation.same.report.d.c();
                            }
                            AnonymousClass4 anonymousClass46 = AnonymousClass4.this;
                            anonymousClass46.f5252a.b(anonymousClass46.f5254c);
                            AnonymousClass4.this.f5252a.a(bVarB);
                            c.a(a.this.f5225q, bVarB, AnonymousClass4.this.f5252a);
                        }

                        @Override // com.mbridge.msdk.reward.adapter.b.j
                        public final void a(String str8, String str9, String str10, a.C0071a c0071a, com.mbridge.msdk.foundation.c.b bVar) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a aVar = a.this;
                            a.a(aVar, str2, aVar.aa);
                            if (a.this.f5225q == null || a.this.f5218j) {
                                return;
                            }
                            a.this.f5218j = true;
                            if (bVar != null) {
                                bVar.a("errorCode: 3303 errorMessage: tpl temp preload failed");
                            }
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            if (anonymousClass42.f5252a == null) {
                                anonymousClass42.f5252a = new com.mbridge.msdk.foundation.same.report.d.c();
                            }
                            AnonymousClass4 anonymousClass43 = AnonymousClass4.this;
                            anonymousClass43.f5252a.b(anonymousClass43.f5254c);
                            AnonymousClass4.this.f5252a.a(bVar);
                            c.a(a.this.f5225q, bVar, AnonymousClass4.this.f5252a);
                        }
                    }, true);
                }
            });
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.Z;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class c {

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<InterVideoOutListener> f5271b;

        /* renamed from: c, reason: collision with root package name */
        private volatile AtomicInteger f5272c;

        /* renamed from: d, reason: collision with root package name */
        private Handler f5273d;
        private String e;
        private boolean f;

        private c(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.f5271b = new WeakReference<>(interVideoOutListener);
            this.f5272c = new AtomicInteger(0);
            this.f5273d = handler;
            this.e = str;
        }

        public final void a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            String strB;
            com.mbridge.msdk.foundation.same.report.d.c cVar2;
            if (bVar == null || cVar == null) {
                strB = "";
            } else {
                strB = bVar.b();
                cVar.a(bVar);
            }
            if (a.this.f5221m != null) {
                a.this.f5221m.a(a.this.f5215a);
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListE = a.this.f5221m.e();
                CampaignEx campaignEx = (a.this.M == null || a.this.M.size() == 0) ? null : (CampaignEx) a.this.M.get(0);
                if (campaignEx == null) {
                    campaignEx = (copyOnWriteArrayListE == null || copyOnWriteArrayListE.size() == 0) ? null : copyOnWriteArrayListE.get(0);
                }
                CampaignEx campaignEx2 = campaignEx;
                if (a.this.E && ((campaignEx2 == null || TextUtils.isEmpty(campaignEx2.getNLRid())) && (copyOnWriteArrayListE == null || copyOnWriteArrayListE.size() == 0))) {
                    cVar2 = cVar;
                    if (a.this.f5221m.a(campaignEx2, true, bVar, 2, cVar2)) {
                        return;
                    }
                } else {
                    cVar2 = cVar;
                }
                a.this.f5221m.a((com.mbridge.msdk.reward.adapter.a) null);
            } else {
                cVar2 = cVar;
            }
            Handler handler = this.f5273d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f5271b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f5272c.get() == 2 || this.f5273d == null) {
                return;
            }
            a.this.W = true;
            if (!a.this.Y || strB.contains("resource load timeout")) {
                a.this.X = true;
            }
            if (a.this.V) {
                this.f5272c.set(2);
            }
            if (a.this.W && a.this.X && !a.this.V) {
                this.f5272c.set(2);
                a.a(a.this, "2000047", cVar2, interVideoOutListener);
                if (interVideoOutListener != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = strB;
                    messageObtain.what = 16;
                    if (cVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", cVar2.f());
                        messageObtain.setData(bundle);
                    }
                    this.f5273d.sendMessage(messageObtain);
                }
            }
        }

        public final void b(String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            Handler handler = this.f5273d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f5271b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f5272c.get() == 2 || this.f5273d == null) {
                return;
            }
            if (this.f5272c.get() == 1) {
                this.f5272c.set(3);
            }
            if (a.this.V) {
                return;
            }
            a.this.V = true;
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            cVar.a(true);
            cVar.b(a.this.M);
            a.a(a.this, "2000048", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putSerializable("metrics_data_lrid", cVar.f());
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 9;
                this.f5273d.sendMessage(messageObtain);
            }
            if (a.this.W) {
                this.f5272c.set(2);
            }
        }

        public static /* synthetic */ void b(c cVar, String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f5271b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if ((cVar.f5272c.get() != 1 && cVar.f5272c.get() != 3) || cVar.f5273d == null || a.this.U) {
                return;
            }
            a.this.U = true;
            a.a(a.this, "2000127", cVar2, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
                if (cVar2 != null) {
                    bundle.putString("metrics_data_lrid", cVar2.f());
                }
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 17;
                cVar.f5273d.sendMessage(messageObtain);
                if (ah.a().a("l_s_i_l_v_s", false)) {
                    cVar.a(str, str2, cVar2);
                }
            }
        }

        public final void a(String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            Handler handler = this.f5273d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f5271b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f5272c.get() == 2 || this.f5273d == null) {
                return;
            }
            this.f5272c.set(2);
            if (a.this.V) {
                return;
            }
            a.this.V = true;
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            cVar.b(a.this.M);
            a.a(a.this, "2000048", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putString("metrics_data_lrid", cVar.f());
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 9;
                this.f5273d.sendMessage(messageObtain);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f5271b;
            a.a(a.this, "2000047", cVar, weakReference != null ? weakReference.get() : null);
            if (this.f5273d != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 18;
                if (cVar != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", cVar.f());
                    messageObtain.setData(bundle);
                }
                this.f5273d.sendMessage(messageObtain);
            }
        }

        public final void a(boolean z9) {
            this.f = z9;
        }

        public static /* synthetic */ int a(c cVar) {
            return cVar.f5272c.get();
        }

        public static /* synthetic */ void a(c cVar, int i10) {
            cVar.f5272c.set(i10);
        }

        public static /* synthetic */ void a(c cVar, String str, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            cVar.f5272c.set(2);
            cVar.a(str, cVar2);
        }

        public static /* synthetic */ void a(c cVar, String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f5271b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (cVar.f5273d == null || a.this.U) {
                return;
            }
            a.this.U = true;
            a.a(a.this, "2000127", cVar2, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, true);
                if (cVar2 != null) {
                    bundle.putString("metrics_data_lrid", cVar2.f());
                }
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 17;
                cVar.f5273d.sendMessage(messageObtain);
                if (ah.a().a("l_s_i_l_v_s", false)) {
                    cVar.b(str, str2, cVar2);
                }
            }
        }

        public static /* synthetic */ void a(c cVar, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            String strB;
            WeakReference<InterVideoOutListener> weakReference = cVar.f5271b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (cVar.f5272c.get() == 2 || cVar.f5273d == null) {
                return;
            }
            a.this.X = true;
            if (bVar != null) {
                strB = bVar.b();
            } else {
                strB = "";
            }
            if (strB.contains("resource load timeout")) {
                a.this.W = true;
            }
            if (a.this.X && a.this.W && !a.this.V) {
                cVar.f5272c.set(2);
                if (interVideoOutListener != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = strB;
                    messageObtain.what = 16;
                    if (cVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", cVar2.f());
                        messageObtain.setData(bundle);
                    }
                    cVar.f5273d.sendMessage(messageObtain);
                }
                if (cVar2 == null) {
                    cVar2 = new com.mbridge.msdk.foundation.same.report.d.c();
                }
                cVar2.a(true);
                a.a(a.this, "2000047", cVar2, interVideoOutListener);
            }
        }
    }

    public final void c(boolean z9) {
        this.I = z9;
    }

    public final void c() {
        try {
            String str = "";
            MBridgeIds mBridgeIds = this.t;
            if (mBridgeIds != null) {
                if (!this.K) {
                    mBridgeIds.setBidToken("");
                    return;
                }
                String strA = a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                ConcurrentHashMap<String, String> concurrentHashMap = O;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(strA) && !TextUtils.isEmpty(O.get(strA))) {
                    str = O.get(strA);
                }
                this.t.setBidToken(str);
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class d extends com.mbridge.msdk.video.bt.module.b.b {

        /* renamed from: d, reason: collision with root package name */
        private a f5275d;
        private Handler e;
        private int f;

        private d(a aVar, Handler handler) {
            this.f = 0;
            this.f5275d = aVar;
            this.e = handler;
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
            a aVar = a.this;
            aVar.f5216c = false;
            try {
                com.mbridge.msdk.reward.a.a aVar2 = new com.mbridge.msdk.reward.a.a(aVar.f5227s, a.this.D);
                a aVar3 = this.f5275d;
                aVar2.a(cVar.f(), (aVar3 == null || aVar3.f5221m == null) ? "" : this.f5275d.f5221m.f5143c, 3, a.f5213b);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e.getMessage());
                }
            }
            try {
                a aVar4 = this.f5275d;
                if (aVar4 != null) {
                    aVar4.K = true;
                    if (this.f5275d.f5221m != null) {
                        this.f5275d.f5221m.f5143c = "";
                    }
                    final a aVar5 = this.f5275d;
                    com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (a.this.R == null) {
                                    a.this.R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
                                }
                                h hVarA = h.a(a.this.R);
                                if (hVarA != null) {
                                    hVarA.a(a.this.f5227s);
                                }
                            } catch (Throwable unused) {
                                af.b("RewardVideoController", "can't find DailyPlayCapDao");
                            }
                        }
                    });
                    if (a.this.E) {
                        a.this.c();
                    }
                    a aVar6 = a.this;
                    aVar6.a("2000130", cVar, aVar6.f5224p, "");
                    this.f5667b = true;
                    if (this.f5275d.f5224p != null) {
                        this.f5275d.f5224p.onAdShow(a.this.t);
                        this.f = 2;
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", th.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void b(String str, String str2) {
            try {
                a aVar = this.f5275d;
                if (aVar == null || aVar.f5224p == null) {
                    return;
                }
                try {
                    this.f5275d.f5224p.onEndcardShow(a.this.t);
                    com.mbridge.msdk.foundation.d.b.a().a(str2 + "_2", 2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", e.getMessage());
                    }
                }
                this.f = 6;
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e3.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z9, com.mbridge.msdk.videocommon.b.c cVar2) {
            try {
                a aVar = this.f5275d;
                if (aVar != null && aVar.f5224p != null) {
                    if (cVar2 == null) {
                        cVar2 = com.mbridge.msdk.videocommon.b.c.b(this.f5275d.f5230w);
                    }
                    if (a.this.E) {
                        a.this.c();
                        a.this.b();
                        com.mbridge.msdk.foundation.same.a.b.d(a.this.f5227s, a.this.a());
                    }
                    this.f5275d.f5224p.onAdClose(a.this.t, new RewardInfo(z9, cVar2.a(), String.valueOf(cVar2.b())));
                    this.f = 7;
                    this.f5275d.K = false;
                    a.this.J.clear();
                    this.f5275d = null;
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000152", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
            try {
                a aVar = a.this;
                aVar.f5216c = false;
                if (this.f5275d != null) {
                    if (aVar.E) {
                        a.this.c();
                    }
                    this.f5275d.K = false;
                    a.this.a("2000131", cVar, this.f5275d.f5224p, str);
                    this.f5668c = true;
                    if (this.f5275d.f5224p != null) {
                        try {
                            this.f5275d.f5224p.onShowFail(cVar, a.this.t, str);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardVideoController", e.getMessage());
                            }
                        }
                        this.f = 4;
                    }
                }
            } catch (Exception e3) {
                this.f = 0;
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e3.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z9, String str, String str2) {
            try {
                a aVar = this.f5275d;
                if (aVar == null || aVar.f5224p == null) {
                    return;
                }
                if (a.this.E) {
                    a.this.c();
                }
                this.f5275d.K = false;
                try {
                    this.f5275d.f5224p.onVideoAdClicked(z9, a.this.t);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", e.getMessage());
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e3.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(String str, String str2) {
            try {
                a aVar = this.f5275d;
                if (aVar == null || aVar.f5224p == null) {
                    return;
                }
                try {
                    this.f5275d.f5224p.onVideoComplete(a.this.t);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", e.getMessage());
                    }
                }
                this.f = 5;
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e3.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z9, int i10) {
            try {
                a aVar = this.f5275d;
                if (aVar != null && aVar.f5224p != null) {
                    try {
                        this.f5275d.f5224p.onAdCloseWithIVReward(a.this.t, new RewardInfo(z9, i10));
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e.getMessage());
                        }
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e3.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(int i10, String str, String str2) {
            this.f = i10;
            a aVar = this.f5275d;
            if (aVar == null || aVar.E || this.f5275d.D || this.f5275d.f5222n == null || !this.f5275d.f5222n.s(this.f) || this.f5275d.f5225q == null || c.a(this.f5275d.f5225q) == 1 || c.a(this.f5275d.f5225q) == 3 || a.this.J.contains(Integer.valueOf(this.f))) {
                return;
            }
            a.this.J.add(Integer.valueOf(this.f));
            int iA = this.f5275d.f5222n.A() * 1000;
            if (this.f == 4) {
                iA = 3000;
            }
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1001001);
                this.e.sendEmptyMessageDelayed(1001001, iA);
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (d.this.f5275d != null) {
                            d.this.f5275d.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, a.this.D ? 287 : 94, a.this.f5227s, true, 1));
                        }
                    }
                }, iA);
            }
        }
    }

    public final void b(boolean z9) {
        this.E = z9;
    }

    public final void b() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!this.K || (concurrentHashMap = O) == null || concurrentHashMap.containsKey(a())) {
            return;
        }
        O.remove(a());
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.reward.b.a$2, reason: invalid class name */
    public class AnonymousClass2 implements b.c {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.c f5234a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f5235b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5236c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f5237d;
        final /* synthetic */ int e;

        public AnonymousClass2(CampaignEx campaignEx, boolean z9, com.mbridge.msdk.reward.adapter.c cVar, int i10) {
            this.f5235b = campaignEx;
            this.f5236c = z9;
            this.f5237d = cVar;
            this.e = i10;
            this.f5234a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(final String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            a.this.g = true;
            if (this.f5236c) {
                if (!a.this.h || a.this.f5217i || a.this.y == null) {
                    return;
                }
                a.this.f5217i = true;
                a.this.y.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.mbridge.msdk.reward.adapter.b.a().a(a.this.I, a.this.y, a.this.D, a.this.E, str3, AnonymousClass2.this.f5235b.getRequestIdNotice(), str, str2, AnonymousClass2.this.f5235b.getCMPTEntryUrl(), a.this.f5232z, AnonymousClass2.this.f5235b, copyOnWriteArrayList, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass2.this.f5235b.getCMPTEntryUrl()), str2, a.this.f5222n, new b.j() { // from class: com.mbridge.msdk.reward.b.a.2.2.1
                            @Override // com.mbridge.msdk.reward.adapter.b.j
                            public final void a(String str4, String str5, String str6, String str7, String str8, a.C0071a c0071a) {
                                RunnableC00562 runnableC00562 = RunnableC00562.this;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                com.mbridge.msdk.reward.adapter.c cVar = anonymousClass2.f5237d;
                                if (cVar != null && cVar.a(copyOnWriteArrayList, anonymousClass2.f5236c, anonymousClass2.e)) {
                                    if (a.this.f5225q == null || a.this.f5219k) {
                                        return;
                                    }
                                    a.this.f5219k = true;
                                    af.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                    RunnableC00562 runnableC005622 = RunnableC00562.this;
                                    a.this.a(copyOnWriteArrayList);
                                    RunnableC00562 runnableC005623 = RunnableC00562.this;
                                    com.mbridge.msdk.foundation.same.report.d.c cVar2 = AnonymousClass2.this.f5234a;
                                    if (cVar2 != null) {
                                        cVar2.b(copyOnWriteArrayList);
                                    }
                                    a.this.f5225q.b(str5, str6, AnonymousClass2.this.f5234a);
                                    return;
                                }
                                a aVar = a.this;
                                a.a(aVar, str6, aVar.aa);
                                if (a.this.f5225q == null || a.this.f5218j) {
                                    return;
                                }
                                a.this.f5218j = true;
                                com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                if (anonymousClass22.f5234a == null) {
                                    anonymousClass22.f5234a = new com.mbridge.msdk.foundation.same.report.d.c();
                                }
                                AnonymousClass2.this.f5234a.a(bVarB);
                                RunnableC00562 runnableC005624 = RunnableC00562.this;
                                AnonymousClass2.this.f5234a.b(copyOnWriteArrayList);
                                c.a(a.this.f5225q, bVarB, AnonymousClass2.this.f5234a);
                            }

                            @Override // com.mbridge.msdk.reward.adapter.b.j
                            public final void a(String str4, String str5, String str6, a.C0071a c0071a, com.mbridge.msdk.foundation.c.b bVar) {
                                RunnableC00562 runnableC00562 = RunnableC00562.this;
                                a aVar = a.this;
                                a.a(aVar, str2, aVar.aa);
                                if (a.this.f5225q == null || a.this.f5218j) {
                                    return;
                                }
                                a.this.f5218j = true;
                                if (bVar != null) {
                                    bVar.a("errorCode: 3302 errorMessage: tpl preload failed");
                                }
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                if (anonymousClass2.f5234a == null) {
                                    anonymousClass2.f5234a = new com.mbridge.msdk.foundation.same.report.d.c();
                                }
                                RunnableC00562 runnableC005622 = RunnableC00562.this;
                                AnonymousClass2.this.f5234a.b(copyOnWriteArrayList);
                                AnonymousClass2.this.f5234a.a(bVar);
                                c.a(a.this.f5225q, bVar, AnonymousClass2.this.f5234a);
                            }
                        }, true);
                    }
                });
                return;
            }
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                final CampaignEx next = it.next();
                if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a.this.y == null) {
                    com.mbridge.msdk.reward.adapter.c cVar = this.f5237d;
                    if (cVar == null || !cVar.a(copyOnWriteArrayList, this.f5236c, this.e)) {
                        a aVar = a.this;
                        a.a(aVar, str2, aVar.aa);
                        if (a.this.f5225q != null && !a.this.f5218j) {
                            a.this.f5218j = true;
                            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                            if (this.f5234a == null) {
                                this.f5234a = new com.mbridge.msdk.foundation.same.report.d.c();
                            }
                            this.f5234a.b(a.this.Z);
                            this.f5234a.a(bVarB);
                            c.a(a.this.f5225q, bVarB, this.f5234a);
                        }
                    } else if (a.this.f5225q != null && !a.this.f5219k) {
                        a.this.f5219k = true;
                        af.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                        a.this.a(copyOnWriteArrayList);
                        com.mbridge.msdk.foundation.same.report.d.c cVar2 = this.f5234a;
                        if (cVar2 != null) {
                            cVar2.b(copyOnWriteArrayList);
                        }
                        a.this.f5225q.b(str, str2, this.f5234a);
                    }
                } else {
                    a.this.y.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b.a().a(a.this.I, a.this.y, a.this.D, a.this.E, null, next.getRewardTemplateMode().e(), a.this.f5232z, AnonymousClass2.this.f5235b, copyOnWriteArrayList, H5DownLoadManager.getInstance().getH5ResAddress(next.getRewardTemplateMode().e()), str, str2, str3, next.getRequestIdNotice(), a.this.f5222n, new b.j() { // from class: com.mbridge.msdk.reward.b.a.2.1.1
                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str4, String str5, String str6, String str7, String str8, a.C0071a c0071a) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    com.mbridge.msdk.reward.adapter.c cVar3 = anonymousClass2.f5237d;
                                    if (cVar3 != null && cVar3.a(copyOnWriteArrayList, anonymousClass2.f5236c, anonymousClass2.e)) {
                                        if (a.this.f5225q == null || a.this.f5219k) {
                                            return;
                                        }
                                        a.this.f5219k = true;
                                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                        a.this.a(copyOnWriteArrayList);
                                        a.this.f5225q.b(str5, str6, AnonymousClass2.this.f5234a);
                                        return;
                                    }
                                    a aVar2 = a.this;
                                    a.a(aVar2, str6, aVar2.aa);
                                    if (a.this.f5225q == null || a.this.f5218j) {
                                        return;
                                    }
                                    a.this.f5218j = true;
                                    com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    if (anonymousClass22.f5234a == null) {
                                        anonymousClass22.f5234a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                    AnonymousClass2.this.f5234a.b(copyOnWriteArrayList);
                                    AnonymousClass2.this.f5234a.a(bVarB2);
                                    c.a(a.this.f5225q, bVarB2, AnonymousClass2.this.f5234a);
                                }

                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str4, String str5, String str6, a.C0071a c0071a, com.mbridge.msdk.foundation.c.b bVar) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    a aVar2 = a.this;
                                    a.a(aVar2, str2, aVar2.aa);
                                    if (a.this.f5225q == null || a.this.f5218j) {
                                        return;
                                    }
                                    a.this.f5218j = true;
                                    bVar.a("errorCode: 3301 errorMessage: temp preload failed");
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (anonymousClass2.f5234a == null) {
                                        anonymousClass2.f5234a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    anonymousClass22.f5234a.b(a.this.Z);
                                    AnonymousClass2.this.f5234a.a(bVar);
                                    c.a(a.this.f5225q, bVar, AnonymousClass2.this.f5234a);
                                }
                            });
                        }
                    });
                }
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.c.b bVar) {
            a.this.g = false;
            a aVar = a.this;
            a.a(aVar, aVar.f5227s, a.this.aa);
            if (a.this.f5225q == null || a.this.f5218j) {
                return;
            }
            a.this.f5218j = true;
            if (this.f5234a == null) {
                this.f5234a = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            this.f5234a.b(copyOnWriteArrayList);
            if (bVar != null) {
                bVar.a("errorCode: 3201 errorMessage: campaign resource download failed");
            }
            this.f5234a.a(bVar);
            c.a(a.this.f5225q, bVar, this.f5234a);
        }
    }

    public final void b(String str, String str2) {
        try {
            this.f5220l = com.mbridge.msdk.foundation.controller.c.m().c();
            this.f5227s = str2;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.f5229v = str;
            this.t = new MBridgeIds(this.f5229v, this.f5227s);
            this.f5223o = com.mbridge.msdk.videocommon.d.b.a().b();
            com.mbridge.msdk.foundation.same.f.a.b().execute(new com.mbridge.msdk.reward.b.c(this.f5220l, this.f5227s));
            if (this.R == null) {
                this.R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
        } catch (Throwable th) {
            af.b("RewardVideoController", th.getMessage(), th);
        }
    }

    private void b(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f5225q != null) {
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880035, "");
            if (cVar != null) {
                cVar.a(bVarB);
                cVar.c(true);
            }
            c.a(this.f5225q, "bidToken is empty", cVar);
        }
    }

    public final void a(boolean z9) {
        this.D = z9;
        if (z9) {
            this.f5232z = com.mbridge.msdk.foundation.same.a.X;
        } else {
            this.f5232z = com.mbridge.msdk.foundation.same.a.W;
        }
    }

    public final void a(int i10) {
        this.f5232z = i10;
    }

    public final String a() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f5221m;
        if (cVar != null) {
            return cVar.a(this.K);
        }
        return "";
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            an.b(this.f5220l, "MBridge_ConfirmTitle" + this.f5227s, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            an.b(this.f5220l, "MBridge_ConfirmContent" + this.f5227s, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            an.b(this.f5220l, "MBridge_CancelText" + this.f5227s, str4.trim());
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        an.b(this.f5220l, "MBridge_ConfirmText" + this.f5227s, str3.trim());
    }

    public final void a(int i10, int i11, int i12) {
        this.A = i10;
        this.B = i11;
        if (i11 == com.mbridge.msdk.foundation.same.a.K) {
            this.C = i12 < 0 ? 5 : i12;
        }
        if (i11 == com.mbridge.msdk.foundation.same.a.J) {
            this.C = i12 < 0 ? 80 : i12;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i10 == com.mbridge.msdk.foundation.same.a.H ? 0 : 1);
            jSONObject.put("ivRewardPlayValueMode", i11 == com.mbridge.msdk.foundation.same.a.J ? 0 : 1);
            jSONObject.put("ivRewardPlayValue", i12);
            com.mbridge.msdk.c.h.a().f(this.f5227s, jSONObject.toString());
        } catch (Exception unused) {
            af.b("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    public static void a(String str, int i10) {
        try {
            if (N == null || !ap.b(str)) {
                return;
            }
            N.put(str, Integer.valueOf(i10));
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e3.getMessage());
            }
        }
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (concurrentHashMap = O) == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        O.put(str, str2);
    }

    public final void a(InterVideoOutListener interVideoOutListener) {
        this.f5224p = interVideoOutListener;
        this.f5225q = new c(interVideoOutListener, this.y, this.f5227s);
    }

    public final void a(boolean z9, e eVar) {
        a(z9, "", eVar);
    }

    public final void a(boolean z9, String str, e eVar) {
        a aVar;
        com.mbridge.msdk.foundation.same.report.d.c cVarB = b(z9, str, eVar);
        if (this.f5225q == null) {
            aVar = this;
            aVar.f5225q = new c(null, this.y, this.f5227s);
        } else {
            aVar = this;
        }
        if (aVar.f5225q != null && c.a(aVar.f5225q) == 1) {
            a(z9, cVarB);
            return;
        }
        if (aVar.f5225q != null && c.a(aVar.f5225q) == 3) {
            aVar.S = false;
        } else {
            aVar.S = true;
            if (aVar.f5225q != null) {
                c.a(aVar.f5225q, 1);
            }
        }
        aVar.H = z9;
        aVar.y.removeMessages(1001001);
        aVar.V = false;
        aVar.U = false;
        aVar.W = false;
        aVar.X = false;
        q();
        p();
        com.mbridge.msdk.reward.adapter.b.a();
        try {
            if (TextUtils.isEmpty(str)) {
                if (aVar.D) {
                    com.mbridge.msdk.d.b.getInstance().addInterstitialList(aVar.f5229v, aVar.f5227s);
                } else {
                    com.mbridge.msdk.d.b.getInstance().addRewardList(aVar.f5229v, aVar.f5227s);
                }
            }
            if (aVar.E && TextUtils.isEmpty(str)) {
                b(cVarB);
                return;
            }
            if (com.mbridge.msdk.system.a.map == null) {
                a(cVarB);
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), aVar.f5227s);
            aVar.f5222n = cVarA;
            if (cVarA == null) {
                aVar.Q = com.mbridge.msdk.foundation.controller.c.m().k();
                com.mbridge.msdk.videocommon.d.b.a().a(aVar.Q, com.mbridge.msdk.foundation.controller.c.m().b(), aVar.f5227s, new com.mbridge.msdk.videocommon.c.c() { // from class: com.mbridge.msdk.reward.b.a.1
                    @Override // com.mbridge.msdk.videocommon.c.c
                    public final void a(String str2) {
                    }

                    @Override // com.mbridge.msdk.videocommon.c.c
                    public final void b(String str2) {
                    }
                });
                aVar.f5222n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), aVar.f5227s, aVar.D);
            }
            if (!TextUtils.isEmpty(aVar.f5229v)) {
                aVar.f5222n.b(aVar.f5229v);
            }
            int iF = aVar.f5222n.F() * 1000;
            if (aVar.y != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1001002;
                if (cVarB != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", cVarB.f());
                    messageObtain.setData(bundle);
                }
                aVar.y.sendMessageDelayed(messageObtain, iF);
            }
            aVar.P = aVar.f5222n.B();
            try {
                a(z9, str, cVarB);
            } catch (Exception e3) {
                if (aVar.f5225q != null) {
                    com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880020, "load exception");
                    if (cVarB != null) {
                        cVarB.a(bVarB);
                        cVarB.c(true);
                    }
                    aVar.f5225q.a(bVarB, cVarB);
                }
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e3.getMessage());
                }
            }
        } catch (Exception e7) {
            if (aVar.f5225q != null) {
                com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880001, "");
                if (cVarB != null) {
                    cVarB.a(bVarB2);
                    cVarB.c(true);
                }
                aVar.f5225q.a(bVarB2, cVarB);
            }
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e7.getMessage());
            }
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f5225q != null) {
            String strA = com.mbridge.msdk.foundation.c.a.a(880001, "");
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880001, "");
            if (cVar != null) {
                cVar.a(bVarB);
                cVar.c(true);
            }
            c.a(this.f5225q, strA, cVar);
        }
    }

    private void a(boolean z9, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (!this.H) {
            if (z9) {
                this.H = z9;
            }
        } else if (z9) {
            String strA = com.mbridge.msdk.foundation.c.a.a(880016, "errorCode: 3501 errorMessage: current unit is loading");
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880016, "errorCode: 3501 errorMessage: current unit is loading");
            if (cVar != null) {
                cVar.a(bVarB);
                cVar.c(true);
            }
            this.f5225q.a(strA, cVar);
        }
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        try {
            e eVar = new e();
            eVar.a("cache", 1);
            cVar.a("2000127", eVar);
            cVar.a("2000048", eVar);
            cVar.a(copyOnWriteArrayList);
        } catch (Exception e3) {
            af.b("RewardVideoController", e3.getMessage());
        }
        this.Y = true;
        this.f5225q.a(this.E);
        c.a(this.f5225q, this.f5229v, this.f5227s, cVar);
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        a(campaignEx.getRequestId(), str);
        com.mbridge.msdk.reward.adapter.c cVar2 = this.f5221m;
        if (cVar2 != null && cVar2.a(copyOnWriteArrayList, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
            a(copyOnWriteArrayList);
            this.f5225q.b(this.f5229v, this.f5227s, cVar);
        } else {
            a(copyOnWriteArrayList, this.f5221m);
        }
    }

    private CopyOnWriteArrayList<CampaignEx> a(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int vcn = 1;
                    for (CampaignEx campaignEx : list) {
                        if (campaignEx != null) {
                            if (campaignEx.getVcn() > vcn) {
                                vcn = campaignEx.getVcn();
                            }
                            if (campaignEx.getTokenRule() == 1) {
                                String requestId = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        List list2 = (List) linkedHashMap.get(requestId);
                                        if (list2 != null) {
                                            list2.add(campaignEx);
                                        }
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(campaignEx);
                                        linkedHashMap.put(requestId, arrayList);
                                    }
                                }
                            } else {
                                String requestId2 = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        List list3 = (List) linkedHashMap2.get(requestId2);
                                        if (list3 != null) {
                                            list3.add(campaignEx);
                                        }
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(campaignEx);
                                        linkedHashMap2.put(requestId2, arrayList2);
                                    }
                                }
                            }
                        }
                    }
                    if (linkedHashMap2.size() + linkedHashMap.size() >= vcn && linkedHashMap.size() > 0 && linkedHashMap.entrySet() != null && linkedHashMap.entrySet().iterator() != null && linkedHashMap.entrySet().iterator().next() != null && ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() != null) {
                        copyOnWriteArrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.a.b.a(this.f5227s, str, vcn);
                        return copyOnWriteArrayList;
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e3.getMessage());
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar) {
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        boolean zIsEmpty = TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        boolean z9 = !zIsEmpty;
        int nscpt = campaignEx.getNscpt();
        this.g = false;
        this.h = false;
        this.f5217i = false;
        this.f5218j = false;
        this.f5219k = false;
        com.mbridge.msdk.reward.adapter.b.a().a(this.f5220l, z9, nscpt, this.E, this.D ? 287 : 94, this.f5229v, this.f5227s, campaignEx.getRequestId(), copyOnWriteArrayList, new AnonymousClass2(campaignEx, z9, cVar, nscpt), new b.i(campaignEx, copyOnWriteArrayList, z9, nscpt) { // from class: com.mbridge.msdk.reward.b.a.3

            /* renamed from: a, reason: collision with root package name */
            com.mbridge.msdk.foundation.same.report.d.c f5248a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CampaignEx f5249b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f5250c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f5251d;
            final /* synthetic */ int e;

            {
                this.f5249b = campaignEx;
                this.f5250c = copyOnWriteArrayList;
                this.f5251d = z9;
                this.e = nscpt;
                this.f5248a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(campaignEx.getLocalRequestId());
            }

            @Override // com.mbridge.msdk.reward.adapter.b.i
            public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
                String unitId = bVar == null ? "" : bVar.d().getUnitId();
                a aVar = a.this;
                a.a(aVar, unitId, aVar.aa);
                if (bVar != null) {
                    bVar.a("errorCode: 3202 errorMessage: temp resource download failed");
                }
                if (this.f5248a == null) {
                    this.f5248a = new com.mbridge.msdk.foundation.same.report.d.c();
                }
                this.f5248a.b(this.f5250c);
                this.f5248a.a(bVar);
                if (!this.f5251d && a.this.f5225q != null) {
                    if (a.this.f5218j) {
                        return;
                    }
                    a.this.f5218j = true;
                    c.a(a.this.f5225q, bVar, this.f5248a);
                    return;
                }
                if (this.e != 1 || a.this.f5218j || a.this.f5225q == null) {
                    return;
                }
                a.this.f5218j = true;
                c.a(a.this.f5225q, bVar, this.f5248a);
            }

            @Override // com.mbridge.msdk.reward.adapter.b.i
            public final void a(String str, String str2, String str3, String str4) {
            }
        });
        if (zIsEmpty) {
            return;
        }
        com.mbridge.msdk.reward.adapter.b.a().a(this.f5220l, campaignEx, this.f5229v, this.f5227s, campaignEx.getRequestId(), new AnonymousClass4(campaignEx, copyOnWriteArrayList, cVar, z9, nscpt));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.util.Queue<java.lang.Integer> r12, boolean r13, java.lang.String r14, com.mbridge.msdk.foundation.same.report.d.c r15) {
        /*
            r11 = this;
            java.lang.String r1 = "RewardVideoController"
            r2 = 1
            r3 = 880020(0xd6d94, float:1.23317E-39)
            java.lang.String r4 = "load mv api error:"
            if (r12 == 0) goto L23
            int r0 = r12.size()     // Catch: java.lang.Exception -> L1e
            if (r0 <= 0) goto L23
            java.lang.Object r12 = r12.poll()     // Catch: java.lang.Exception -> L1e
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch: java.lang.Exception -> L1e
            if (r12 == 0) goto L23
            int r12 = r12.intValue()     // Catch: java.lang.Exception -> L1e
        L1c:
            r7 = r12
            goto L26
        L1e:
            r0 = move-exception
            r12 = r0
            r5 = r11
            r10 = r15
            goto L60
        L23:
            r12 = 25
            goto L1c
        L26:
            r6 = 1
            r5 = r11
            r8 = r13
            r9 = r14
            r10 = r15
            r5.a(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L2f
            goto L8a
        L2f:
            r0 = move-exception
            r12 = r0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4e
            r13.<init>(r4)     // Catch: java.lang.Exception -> L4e
            java.lang.String r14 = r12.getMessage()     // Catch: java.lang.Exception -> L4e
            r13.append(r14)     // Catch: java.lang.Exception -> L4e
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Exception -> L4e
            com.mbridge.msdk.foundation.c.b r13 = com.mbridge.msdk.foundation.c.a.b(r3, r13)     // Catch: java.lang.Exception -> L4e
            if (r10 == 0) goto L51
            r10.a(r13)     // Catch: java.lang.Exception -> L4e
            r10.c(r2)     // Catch: java.lang.Exception -> L4e
            goto L51
        L4e:
            r0 = move-exception
            r12 = r0
            goto L60
        L51:
            r11.a(r13, r10)     // Catch: java.lang.Exception -> L4e
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Exception -> L4e
            if (r13 == 0) goto L8a
            java.lang.String r12 = r12.getMessage()     // Catch: java.lang.Exception -> L4e
            com.mbridge.msdk.foundation.tools.af.b(r1, r12)     // Catch: java.lang.Exception -> L4e
            goto L8a
        L60:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r4)
            java.lang.String r14 = r12.getMessage()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.mbridge.msdk.foundation.c.b r13 = com.mbridge.msdk.foundation.c.a.b(r3, r13)
            if (r10 == 0) goto L7c
            r10.a(r13)
            r10.c(r2)
        L7c:
            r11.a(r13, r10)
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L8a
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r12)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.util.Queue, boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f5225q != null) {
            this.X = true;
            this.f5225q.a(bVar, cVar);
        }
    }

    private void a(int i10, int i11, boolean z9, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar2 = this.f5221m;
            if (cVar2 == null || !this.f5227s.equals(cVar2.a())) {
                com.mbridge.msdk.reward.adapter.c cVar3 = new com.mbridge.msdk.reward.adapter.c(this.f5220l, this.f5229v, this.f5227s);
                this.f5221m = cVar3;
                cVar3.b(this.D);
                this.f5221m.c(this.E);
            }
            if (this.D) {
                this.f5221m.a(this.A, this.B, this.C);
            }
            this.f5221m.a(this.f5232z);
            this.f5221m.a(this.f5222n);
            RunnableC0058a runnableC0058a = new RunnableC0058a(this.f5221m, i10, z9, str, cVar);
            runnableC0058a.a(i11);
            b bVar = new b(this.f5221m, z9);
            this.f5215a = bVar;
            bVar.a(runnableC0058a);
            this.f5221m.a(this.f5215a);
            this.f5221m.a(i10, i11, z9, str, this.I, cVar);
            this.y.postDelayed(runnableC0058a, i11 * 1000);
        } catch (Exception e3) {
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880020, e3.getMessage());
            if (cVar != null) {
                cVar.a(bVarB);
                cVar.c(true);
            }
            a(bVarB, cVar);
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e3.getMessage());
            }
        }
    }

    private void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        com.mbridge.msdk.videocommon.d.c cVar2;
        com.mbridge.msdk.videocommon.d.c cVar3;
        boolean zB;
        boolean zC;
        try {
            if (this.f5221m == null) {
                r();
            }
            if (this.f5221m != null) {
                af.b("RewardVideoController", "controller 819");
                if (this.E) {
                    zB = e(false);
                } else {
                    zB = this.f5221m.b();
                }
                if (zB) {
                    af.c("RewardVideoController", "invoke adapter show isReady");
                    d dVar = new d(this, this.y);
                    f.put(this.f5227s, dVar);
                    this.f5221m.a(dVar, str, this.f5226r, this.f5232z, this.f5228u, cVar);
                    this.f5216c = false;
                    return;
                }
                boolean z9 = this.E;
                com.mbridge.msdk.reward.adapter.c cVar4 = this.f5221m;
                if (z9) {
                    if (cVar4 == null) {
                        r();
                    }
                    List<com.mbridge.msdk.foundation.entity.c> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.f5227s);
                    if (listA == null || listA.size() <= 0) {
                        zC = false;
                    } else {
                        for (com.mbridge.msdk.foundation.entity.c cVar5 : listA) {
                            if (cVar5 != null) {
                                this.f5221m.a(cVar5.a());
                                this.f5221m.f5144d = cVar5.d();
                                if (this.f5221m.c()) {
                                    zC = true;
                                    break;
                                }
                                com.mbridge.msdk.videocommon.a.a.a().c(this.f5227s, cVar5.a());
                            }
                        }
                        zC = false;
                    }
                } else {
                    zC = cVar4.c();
                }
                if (zC) {
                    af.c("RewardVideoController", "invoke adapter show isSpareOfferReady");
                    d dVar2 = new d(this, this.y);
                    f.put(this.f5227s, dVar2);
                    this.f5221m.a(dVar2, str, this.f5226r, this.f5232z, this.f5228u, cVar);
                    this.f5216c = false;
                    return;
                }
            }
            this.f5216c = false;
            a("2000131", cVar, this.f5224p, "can't show because load is failed");
            if (this.f5224p != null) {
                try {
                    this.f5224p.onShowFail(cVar, this.t, "can't show because load is failed");
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", e3.getMessage());
                    }
                }
            }
            if (this.D || this.E || (cVar3 = this.f5222n) == null || !cVar3.s(4) || this.f5225q == null || c.a(this.f5225q) == 1 || c.a(this.f5225q) == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, this.f5227s, true, 1));
        } catch (Exception e7) {
            this.f5216c = false;
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e7.getLocalizedMessage());
            }
            a("2000131", cVar, this.f5224p, "show exception");
            if (this.f5224p != null) {
                try {
                    this.f5224p.onShowFail(cVar, this.t, "show exception");
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", e7.getMessage());
                    }
                }
            }
            if (this.D || this.E || (cVar2 = this.f5222n) == null || !cVar2.s(4) || this.f5225q == null || c.a(this.f5225q) == 1 || c.a(this.f5225q) == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, this.f5227s, true, 1));
        }
    }

    private boolean a(List<com.mbridge.msdk.foundation.entity.c> list, String str) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.c cVar : list) {
            if (cVar != null && str.equals(cVar.b())) {
                this.f5221m.a(cVar.a());
                this.f5221m.f5144d = cVar.d();
                if (this.f5221m.b()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r12, java.lang.String r13, java.lang.String r14, com.mbridge.msdk.foundation.same.report.d.e r15) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.same.report.d.e):void");
    }

    private com.mbridge.msdk.foundation.same.report.d.c a(e eVar) {
        CampaignEx campaignEx;
        try {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f5227s);
            String currentLocalRid = "";
            if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0 && (campaignEx = copyOnWriteArrayListA.get(0)) != null) {
                currentLocalRid = campaignEx.getCurrentLocalRid();
            }
            cVar = TextUtils.isEmpty(currentLocalRid) ? null : com.mbridge.msdk.foundation.same.report.d.d.a().b().get(currentLocalRid);
            if (cVar != null) {
                cVar.b(copyOnWriteArrayListA);
                cVar.a("2000128", eVar);
                cVar.c(currentLocalRid);
                cVar.d(this.f5227s);
                com.mbridge.msdk.reward.c.a.a.a().a("2000128", cVar);
                return cVar;
            }
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            try {
                cVar.d(this.f5227s);
                eVar.a("metrics_data_reason", "未获取到待展示的campaign信息 本地new metricsData");
                cVar.a("2000128", eVar);
                if (TextUtils.isEmpty(currentLocalRid)) {
                    cVar.c(SameMD5.getMD5(ak.d()));
                } else {
                    cVar.c(currentLocalRid);
                    cVar.b(copyOnWriteArrayListA);
                    com.mbridge.msdk.foundation.same.report.d.d.a().b().put(currentLocalRid, cVar);
                }
                com.mbridge.msdk.reward.c.a.a.a().a("2000128", cVar);
                return cVar;
            } catch (Exception e3) {
                e = e3;
                cVar = cVar;
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e.getMessage());
                }
                return cVar;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public final void a(List<CampaignEx> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.M = list;
    }

    private String a(String str) {
        String md5 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                md5 = SameMD5.getMD5(ak.d());
            }
            String[] strArrSplit = str.split("_");
            if (strArrSplit != null && strArrSplit.length >= 3) {
                md5 = strArrSplit[2];
            }
            return TextUtils.isEmpty(md5) ? SameMD5.getMD5(ak.d()) : md5;
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
            return md5;
        }
    }

    public final com.mbridge.msdk.foundation.same.report.d.c a(Message message) {
        com.mbridge.msdk.foundation.same.report.d.c cVarA = null;
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    cVarA = com.mbridge.msdk.foundation.same.report.d.d.a().a(data.getString("metrics_data_lrid"), "");
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
        return cVarA == null ? new com.mbridge.msdk.foundation.same.report.d.c() : cVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar, InterVideoOutListener interVideoOutListener, String str2) {
        if (cVar == null) {
            try {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar.b(this.M);
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                    return;
                }
                return;
            }
        }
        e eVar = new e();
        if (!TextUtils.isEmpty(str2)) {
            eVar.a("reason", str2);
        }
        if (interVideoOutListener != null) {
            eVar.a("listener_state", 1);
        } else {
            eVar.a("listener_state", 2);
        }
        cVar.a(str, eVar);
        com.mbridge.msdk.reward.c.a.a.a().a(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.mbridge.msdk.foundation.same.report.d.c a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6, com.mbridge.msdk.foundation.same.report.d.c r7) {
        /*
            r5 = this;
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.mbridge.msdk.foundation.same.report.d.c r1 = new com.mbridge.msdk.foundation.same.report.d.c
            r1.<init>()
            java.lang.String r2 = ""
            if (r6 == 0) goto L3c
            int r3 = r6.size()     // Catch: java.lang.Exception -> L30
            if (r3 <= 0) goto L3c
            r3 = 0
            java.lang.Object r4 = r6.get(r3)     // Catch: java.lang.Exception -> L30
            if (r4 == 0) goto L32
            java.lang.Object r2 = r6.get(r3)     // Catch: java.lang.Exception -> L30
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = r2.getLocalRequestId()     // Catch: java.lang.Exception -> L30
            java.lang.Object r3 = r6.get(r3)     // Catch: java.lang.Exception -> L30
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch: java.lang.Exception -> L30
            java.lang.String r3 = r3.getNLRid()     // Catch: java.lang.Exception -> L30
            goto L33
        L30:
            r6 = move-exception
            goto L9d
        L32:
            r3 = r2
        L33:
            r1.c(r2)     // Catch: java.lang.Exception -> L30
            r1.b(r6)     // Catch: java.lang.Exception -> L30
            r6 = r2
            r2 = r3
            goto L3d
        L3c:
            r6 = r2
        L3d:
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L30
            if (r2 == 0) goto L44
            return r7
        L44:
            com.mbridge.msdk.foundation.same.report.d.e r7 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch: java.lang.Exception -> L30
            r7.<init>()     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = "cache"
            r7.a(r2, r0)     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = "hb"
            r7.a(r2, r0)     // Catch: java.lang.Exception -> L30
            java.lang.String r0 = "auto_load"
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L30
            r7.a(r0, r2)     // Catch: java.lang.Exception -> L30
            java.lang.String r0 = "2000127"
            r1.a(r0, r7)     // Catch: java.lang.Exception -> L30
            java.lang.String r0 = "2000048"
            r1.a(r0, r7)     // Catch: java.lang.Exception -> L30
            boolean r7 = r5.D     // Catch: java.lang.Exception -> L30
            if (r7 == 0) goto L6e
            r7 = 287(0x11f, float:4.02E-43)
            goto L70
        L6e:
            r7 = 94
        L70:
            r1.b(r7)     // Catch: java.lang.Exception -> L30
            java.lang.String r7 = "1"
            r1.i(r7)     // Catch: java.lang.Exception -> L30
            java.lang.String r7 = "2"
            r1.b(r7)     // Catch: java.lang.Exception -> L30
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L30
            if (r7 != 0) goto La4
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch: java.lang.Exception -> L30
            java.util.LinkedHashMap r7 = r7.b()     // Catch: java.lang.Exception -> L30
            boolean r7 = r7.containsKey(r6)     // Catch: java.lang.Exception -> L30
            if (r7 != 0) goto La4
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch: java.lang.Exception -> L30
            java.util.LinkedHashMap r7 = r7.b()     // Catch: java.lang.Exception -> L30
            r7.put(r6, r1)     // Catch: java.lang.Exception -> L30
            return r1
        L9d:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto La4
            r6.printStackTrace()
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.util.List, com.mbridge.msdk.foundation.same.report.d.c):com.mbridge.msdk.foundation.same.report.d.c");
    }

    public static /* synthetic */ void a(a aVar, String str, List list) {
        if (list != null) {
            try {
                if (list.size() <= 0 || aVar.V) {
                    return;
                }
                com.mbridge.msdk.foundation.db.e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a((List<CampaignEx>) list, str);
            } catch (Throwable th) {
                af.b("RewardVideoController", th.getMessage());
            }
        }
    }

    public static /* synthetic */ void a(a aVar, String str, com.mbridge.msdk.foundation.same.report.d.c cVar, InterVideoOutListener interVideoOutListener) {
        if (aVar.H) {
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar.b(aVar.M);
            }
            try {
                e eVar = new e();
                if (interVideoOutListener != null) {
                    eVar.a("listener_state", 1);
                } else {
                    eVar.a("listener_state", 2);
                }
                cVar.a(str, eVar);
                com.mbridge.msdk.reward.c.a.a.a().a(str, cVar);
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
