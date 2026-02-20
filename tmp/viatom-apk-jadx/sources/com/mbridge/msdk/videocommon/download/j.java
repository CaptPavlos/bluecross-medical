package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.videocommon.download.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {
    private com.mbridge.msdk.videocommon.listener.a e;
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> g;

    /* renamed from: j, reason: collision with root package name */
    private Context f6588j;

    /* renamed from: l, reason: collision with root package name */
    private String f6590l;

    /* renamed from: m, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f6591m;

    /* renamed from: o, reason: collision with root package name */
    private int f6593o;

    /* renamed from: p, reason: collision with root package name */
    private i f6594p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6595q;

    /* renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f6585c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private boolean f6586d = true;
    private String f = "";
    private c h = new c() { // from class: com.mbridge.msdk.videocommon.download.j.1
        @Override // com.mbridge.msdk.videocommon.download.c
        public final void a(long j10, int i10) {
            if (i10 == 5 || i10 == 4) {
                j.this.f6586d = true;
                j.this.a();
            }
            if (i10 == 2) {
                j.this.f6586d = true;
            }
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private CopyOnWriteArrayList<Map<String, a>> f6587i = new CopyOnWriteArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private long f6589k = 3600;

    /* renamed from: n, reason: collision with root package name */
    private int f6592n = 1;

    /* renamed from: a, reason: collision with root package name */
    k f6583a = null;

    /* renamed from: b, reason: collision with root package name */
    k f6584b = null;

    public j(Context context, List<CampaignEx> list, String str, int i10) {
        this.f6593o = 1;
        try {
            boolean zA = h.a.f6575a.a(i10);
            this.f6595q = zA;
            if (zA) {
                this.f6590l = str;
                this.f6593o = i10;
                this.f6594p = new i(list, str, i10);
                return;
            }
        } catch (Exception unused) {
            this.f6594p = null;
            this.f6595q = false;
        }
        this.f6588j = com.mbridge.msdk.foundation.controller.c.m().c();
        List<CampaignEx> list2 = this.f6585c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.f6590l = str;
        this.f6593o = i10;
        b(this.f6585c);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:85|86|116|91|(1:93)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01d4, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0202, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0204, code lost:
    
        com.mbridge.msdk.foundation.tools.af.b("UnitCacheCtroller", r4.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x020e, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0213, code lost:
    
        throw r12;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r12) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.j.b(java.util.List):void");
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private void d() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((this.f6595q && this.f6594p != null) || ah.a().a("u_n_c_e_d", true) || (copyOnWriteArrayList = this.f6587i) == null) {
            return;
        }
        try {
            synchronized (copyOnWriteArrayList) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i10 = 0;
                    while (i10 < this.f6587i.size()) {
                        Map<String, a> map = this.f6587i.get(i10);
                        Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            a value = it.next().getValue();
                            if (value != null) {
                                if (jCurrentTimeMillis - value.g() > this.f6589k * 1000 && value.k() == 1) {
                                    value.b(MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT);
                                    value.a(this.f6592n);
                                    value.s();
                                    this.f6587i.remove(map);
                                    i10--;
                                }
                                if (value.k() != 1 && value.k() != 5 && value.k() != 0) {
                                    value.s();
                                    this.f6587i.remove(map);
                                    i10--;
                                }
                            }
                        }
                        i10++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private int e(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f6584b == null) {
                    this.f6584b = com.mbridge.msdk.c.h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f6590l);
                }
                return this.f6584b.p();
            }
            if (campaignEx.getAdType() == 42) {
                return d(null);
            }
            if (this.f6591m == null) {
                this.f6591m = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f6590l, false);
            }
            return this.f6591m.r();
        } catch (Throwable th) {
            af.b("UnitCacheCtroller", th.getMessage(), th);
            return 100;
        }
    }

    private void f(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("cache", 1);
                eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(b(campaignEx)));
                if (b(campaignEx) == 100) {
                    eVar.a("resumed_breakpoint", "2");
                } else {
                    eVar.a("resumed_breakpoint", "1");
                }
                eVar.a("resource_type", 4);
                eVar.a("scenes", "1");
                eVar.a("url", campaignEx.getVideoUrlEncode());
                com.mbridge.msdk.foundation.same.report.d.d.a().a("m_download_start", campaignEx, eVar);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0160 A[Catch: all -> 0x0035, Exception -> 0x00de, TRY_ENTER, TryCatch #0 {Exception -> 0x00de, blocks: (B:44:0x00b6, B:45:0x00c0, B:47:0x00c6, B:57:0x00ea, B:60:0x00f2, B:63:0x00f9, B:65:0x0109, B:66:0x0111, B:90:0x0160, B:92:0x0172, B:98:0x0183, B:100:0x0189, B:102:0x01a0, B:106:0x01aa, B:113:0x01b5, B:115:0x01c2, B:117:0x01cc, B:119:0x01d9, B:126:0x0200, B:128:0x0206, B:130:0x020c, B:134:0x0219, B:142:0x022f, B:144:0x023a, B:147:0x0245, B:149:0x0249, B:151:0x0253, B:155:0x025b, B:158:0x0265, B:160:0x026f, B:70:0x011e, B:72:0x0124, B:74:0x012e, B:77:0x013c, B:79:0x0142, B:81:0x0148, B:82:0x014c, B:86:0x0154, B:168:0x0291), top: B:178:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0183 A[Catch: all -> 0x0035, Exception -> 0x00de, TRY_ENTER, TryCatch #0 {Exception -> 0x00de, blocks: (B:44:0x00b6, B:45:0x00c0, B:47:0x00c6, B:57:0x00ea, B:60:0x00f2, B:63:0x00f9, B:65:0x0109, B:66:0x0111, B:90:0x0160, B:92:0x0172, B:98:0x0183, B:100:0x0189, B:102:0x01a0, B:106:0x01aa, B:113:0x01b5, B:115:0x01c2, B:117:0x01cc, B:119:0x01d9, B:126:0x0200, B:128:0x0206, B:130:0x020c, B:134:0x0219, B:142:0x022f, B:144:0x023a, B:147:0x0245, B:149:0x0249, B:151:0x0253, B:155:0x025b, B:158:0x0265, B:160:0x026f, B:70:0x011e, B:72:0x0124, B:74:0x012e, B:77:0x013c, B:79:0x0142, B:81:0x0148, B:82:0x014c, B:86:0x0154, B:168:0x0291), top: B:178:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.mbridge.msdk.videocommon.download.a a(int r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.j.a(int, boolean):com.mbridge.msdk.videocommon.download.a");
    }

    public final CopyOnWriteArrayList<Map<String, a>> c() {
        i iVar;
        if (this.f6595q && (iVar = this.f6594p) != null) {
            return iVar.d();
        }
        return this.f6587i;
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f6587i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i10 = 0;
                    while (i10 < this.f6587i.size()) {
                        try {
                            Map<String, a> map = this.f6587i.get(i10);
                            Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                a value = it.next().getValue();
                                if (value != null && value.l() != null && value.f()) {
                                    value.r();
                                    this.f6587i.remove(map);
                                    i10--;
                                }
                            }
                            i10++;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable unused) {
                af.b("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    public j(Context context, CampaignEx campaignEx, String str, int i10) {
        this.f6593o = 1;
        try {
            boolean zA = h.a.f6575a.a(i10);
            this.f6595q = zA;
            if (zA) {
                this.f6590l = str;
                this.f6593o = i10;
                this.f6594p = new i(campaignEx, str, i10);
                return;
            }
        } catch (Exception unused) {
            this.f6594p = null;
            this.f6595q = false;
        }
        this.f6588j = com.mbridge.msdk.foundation.controller.c.m().c();
        List<CampaignEx> list = this.f6585c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        this.f6590l = str;
        this.f6593o = i10;
        b(this.f6585c);
    }

    private int d(CampaignEx campaignEx) {
        try {
            k kVar = this.f6583a;
            if (kVar != null) {
                return kVar.p();
            }
            return 100;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            af.b("UnitCacheCtroller", e.getMessage());
            return 100;
        }
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return e(campaignEx);
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !c(campaignEx)) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
            return ap.b(H5DownLoadManager.getInstance().getH5ResAddress(str)) || ap.b(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str));
        }
        af.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
        return true;
    }

    public final a b(int i10, boolean z9) {
        i iVar;
        if (this.f6595q && (iVar = this.f6594p) != null) {
            return iVar.c();
        }
        try {
            return a(i10, z9);
        } catch (Throwable th) {
            af.b("UnitCacheCtroller", th.getMessage(), th);
            return null;
        }
    }

    public final void b() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((!this.f6595q || this.f6594p == null) && (copyOnWriteArrayList = this.f6587i) != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    try {
                        Iterator<Map<String, a>> it = this.f6587i.iterator();
                        while (it.hasNext()) {
                            Map<String, a> next = it.next();
                            if (next != null) {
                                Iterator<Map.Entry<String, a>> it2 = next.entrySet().iterator();
                                while (it2.hasNext()) {
                                    a value = it2.next().getValue();
                                    if (value != null && value.k() == 1) {
                                        value.b("playing and stop download");
                                        value.s();
                                        this.f6587i.remove(next);
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    af.b("UnitCacheCtroller", th2.getMessage());
                }
            }
        }
    }

    public final void b(String str) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        i iVar;
        if (this.f6595q && (iVar = this.f6594p) != null) {
            iVar.b(str);
            return;
        }
        try {
            synchronized (this.f6587i) {
                try {
                    if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.f6587i) != null && copyOnWriteArrayList.size() > 0) {
                        Iterator<Map<String, a>> it = this.f6587i.iterator();
                        while (it.hasNext()) {
                            Map<String, a> next = it.next();
                            if (next != null) {
                                for (Map.Entry<String, a> entry : next.entrySet()) {
                                    if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                        this.f6587i.remove(next);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("UnitCacheCtroller", e.getMessage());
            }
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        i iVar;
        if (this.f6595q && (iVar = this.f6594p) != null) {
            iVar.a(aVar);
        } else {
            this.e = aVar;
        }
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        i iVar;
        if (this.f6595q && (iVar = this.f6594p) != null) {
            iVar.a(str, aVar);
            return;
        }
        if (this.g == null) {
            this.g = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.g.put(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        i iVar;
        if (this.f6595q && (iVar = this.f6594p) != null) {
            iVar.a(list);
            return;
        }
        List<CampaignEx> list2 = this.f6585c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        b(this.f6585c);
    }

    public final void a(CampaignEx campaignEx) {
        i iVar;
        if (this.f6595q && (iVar = this.f6594p) != null) {
            iVar.a(campaignEx);
            return;
        }
        List<CampaignEx> list = this.f6585c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        b(this.f6585c);
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x024c A[PHI: r6
      0x024c: PHI (r6v34 java.lang.String) = (r6v31 java.lang.String), (r6v31 java.lang.String), (r6v32 java.lang.String) binds: [B:142:0x0227, B:147:0x0234, B:153:0x024a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0254 A[Catch: all -> 0x01ff, Exception -> 0x021f, TryCatch #1 {Exception -> 0x021f, blocks: (B:143:0x0229, B:146:0x0232, B:148:0x0236, B:150:0x0240, B:152:0x0246, B:158:0x0254, B:160:0x025e, B:162:0x0264, B:138:0x0212), top: B:186:0x0229 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0290 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.mbridge.msdk.videocommon.download.a> a(java.lang.String r26, int r27, boolean r28, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r29, boolean r30, com.mbridge.msdk.foundation.same.report.d.e r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 675
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.j.a(java.lang.String, int, boolean, java.util.List, boolean, com.mbridge.msdk.foundation.same.report.d.e):java.util.List");
    }

    public final boolean a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            CampaignEx campaignEx = list.get(i10);
            if (campaignEx == null || !a(new a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str, this.f6592n), b(campaignEx), false) || !a(campaignEx.getendcard_url(), campaignEx)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(a aVar, int i10) {
        long jM = aVar.m();
        long j10 = aVar.j();
        if (TextUtils.isEmpty(aVar.e())) {
            af.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i10 == 0) {
            if (aVar.l() != null && !TextUtils.isEmpty(aVar.l().getVideoUrlEncode())) {
                return true;
            }
        } else if (j10 > 0 && jM * 100 >= j10 * i10) {
            if (i10 != 100 || aVar.k() == 5) {
                return true;
            }
            aVar.s();
            return false;
        }
        return false;
    }

    private static boolean a(a aVar, int i10, boolean z9) {
        long jM = aVar.m();
        long j10 = aVar.j();
        if (TextUtils.isEmpty(aVar.e())) {
            af.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx campaignExL = aVar.l();
        if (campaignExL != null) {
            if (campaignExL.getRsIgnoreCheckRule() != null && campaignExL.getRsIgnoreCheckRule().size() > 0 && campaignExL.getRsIgnoreCheckRule().contains(0)) {
                af.c("UnitCacheCtroller", "Is not check video download status");
                return true;
            }
            if (campaignExL.getIsTimeoutCheckVideoStatus() == 1 && campaignExL.getVideoCheckType() == 1) {
                return true;
            }
            if (z9 && campaignExL.getVideoCheckType() == 1) {
                if (i10 == 0) {
                    return true;
                }
                if ((j10 != 0 || jM != 0) && jM >= (i10 / 100) * j10) {
                    campaignExL.setIsTimeoutCheckVideoStatus(1);
                    return true;
                }
            }
        }
        return a(aVar, i10);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
            if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                return (campaignEx.isDynamicView() && !ak.l(str)) || ap.a(str) || b(str, campaignEx);
            }
            af.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } catch (Throwable th) {
            af.b("UnitCacheCtroller", th.getMessage(), th);
            return false;
        }
    }

    private boolean a(int i10, CampaignEx campaignEx, String str) {
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
            af.c("UnitCacheCtroller", "Is not check template download status");
            return true;
        }
        if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0) {
            af.a("UnitCacheCtroller", "check template 下载情况：" + H5DownLoadManager.getInstance().getH5ResAddress(str));
            if (H5DownLoadManager.getInstance().getH5ResAddress(str) == null) {
                return false;
            }
        }
        return true;
    }

    public final a a(String str) {
        i iVar;
        if (this.f6595q && (iVar = this.f6594p) != null) {
            return iVar.a(str);
        }
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f6587i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                try {
                    Iterator<Map<String, a>> it = this.f6587i.iterator();
                    while (it.hasNext()) {
                        Map<String, a> next = it.next();
                        if (next != null && next.containsKey(str)) {
                            return next.get(str);
                        }
                    }
                } catch (Throwable unused) {
                    af.b("UnitCacheCtroller", "failed to get campaignTast by cid");
                }
                return null;
            } finally {
            }
        }
    }

    private boolean a(CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map<String, a> next = it.next();
                if (next != null) {
                    Iterator<Map.Entry<String, a>> it2 = next.entrySet().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().getValue().k() == 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00df A[Catch: all -> 0x0022, TryCatch #2 {all -> 0x0022, blocks: (B:11:0x0016, B:13:0x001f, B:16:0x0025, B:17:0x002b, B:19:0x0031, B:22:0x003a, B:23:0x0042, B:25:0x0048, B:28:0x0058, B:31:0x005f, B:33:0x0065, B:34:0x0067, B:37:0x0073, B:38:0x0083, B:40:0x0094, B:42:0x0098, B:43:0x00a0, B:44:0x00a4, B:50:0x00b9, B:52:0x00bd, B:53:0x00d1, B:55:0x00d5, B:57:0x00db, B:59:0x00df, B:61:0x00e3, B:62:0x00f7, B:64:0x00fb, B:76:0x0129, B:78:0x012e, B:80:0x0134, B:84:0x016b, B:85:0x016f, B:87:0x0174, B:91:0x017c, B:94:0x0181, B:96:0x0185, B:97:0x018e, B:99:0x0192, B:103:0x019c, B:104:0x01a0, B:107:0x01ac, B:110:0x01b1, B:112:0x01b5, B:116:0x01c3, B:120:0x01cc, B:122:0x01d7, B:124:0x01db, B:127:0x01df, B:130:0x01e5, B:136:0x01f8, B:142:0x0208, B:141:0x0205, B:65:0x0100, B:67:0x0104, B:71:0x0119, B:72:0x011f, B:74:0x0123, B:143:0x020d), top: B:152:0x0016, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.j.a():void");
    }
}
