package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f6576a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f6577b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f6578c;

    /* renamed from: d, reason: collision with root package name */
    private final String f6579d;
    private com.mbridge.msdk.videocommon.d.c e;
    private final int f;
    private final CopyOnWriteArrayList<CampaignEx> g;
    private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.download.a> h;

    public i(List<CampaignEx> list, String str, int i10) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.g = copyOnWriteArrayList;
        this.h = new ConcurrentHashMap<>();
        this.f6578c = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f6579d = str;
        this.f = i10;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    private com.mbridge.msdk.videocommon.download.a c(CampaignEx campaignEx) {
        com.mbridge.msdk.videocommon.download.a aVar;
        com.mbridge.msdk.videocommon.download.a aVar2 = null;
        try {
            aVar = new com.mbridge.msdk.videocommon.download.a(this.f6578c, campaignEx, this.f6579d, f());
        } catch (Exception e) {
            e = e;
        }
        try {
            aVar.a(campaignEx);
            aVar.d(this.f);
            aVar.c(f(campaignEx));
            aVar.b(e());
            aVar.e(d(campaignEx));
            aVar.a((c) null);
            aVar.a(new a(this.f6579d, this.f6577b, this.f6576a));
            return aVar;
        } catch (Exception e3) {
            e = e3;
            aVar2 = aVar;
            if (MBridgeConstans.DEBUG) {
                af.a("RewardVideoRefactorManager", this.f6579d + " createAndStartCampaignDownloadTask error " + e.getMessage());
            }
            return aVar2;
        }
    }

    private int e() {
        com.mbridge.msdk.videocommon.d.c cVarC = c(this.f6579d);
        if (cVarC == null) {
            return 0;
        }
        try {
            return cVarC.s();
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            af.a("RewardVideoRefactorManager", this.f6579d + " getCDRate error " + e.getMessage());
            return 0;
        }
    }

    private int f() {
        if (TextUtils.isEmpty(this.f6579d)) {
            return 1;
        }
        try {
            com.mbridge.msdk.videocommon.d.c cVarC = c(this.f6579d);
            if (cVarC != null) {
                return cVarC.w();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.a("RewardVideoRefactorManager", this.f6579d + " getDlnet error " + e.getMessage());
            }
        }
        return 1;
    }

    private int g() {
        try {
            return c(this.f6579d).r();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            af.a("RewardVideoRefactorManager", this.f6579d + " getRewardReadyRate error:" + th.getMessage());
            return 100;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:203|18)|(2:30|(3:199|32|(2:39|(2:44|(7:55|68|(7:(3:72|(1:76)|80)(2:77|(0)(1:80))|201|83|(1:91)(1:88)|(3:94|217|95)|98|(2:100|(7:109|(1:120)(13:113|114|213|115|(1:117)|128|(3:131|211|132)|144|(1:151)(1:150)|152|(1:154)|155|(10:157|(1:159)|160|161|207|162|163|(2:165|(1:(2:168|(2:170|(1:172)(1:175))(1:176))(1:177))(1:178))(1:179)|215|180)(1:184))|121|(1:128)(1:126)|(3:131|211|132)|144|(6:149|151|152|(0)|155|(0)(0))(0))(6:108|127|128|(0)|144|(0)(0)))(5:127|128|(0)|144|(0)(0)))(1:70)|82|201|83|(5:85|91|(3:94|217|95)|98|(0)(0))(0))(1:(1:49)(8:50|(7:56|57|(3:59|195|60)|82|201|83|(0)(0))(0)|68|(0)(0)|82|201|83|(0)(0))))))(0))(1:29)|81|82|201|83|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0157, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0158, code lost:
    
        r14 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x016f A[Catch: Exception -> 0x0165, TryCatch #11 {Exception -> 0x0165, blocks: (B:95:0x0161, B:98:0x0169, B:100:0x016f, B:103:0x017a, B:106:0x0181, B:109:0x0188, B:111:0x018e, B:113:0x0198), top: B:217:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01cf A[Catch: Exception -> 0x01e6, TryCatch #7 {Exception -> 0x01e6, blocks: (B:138:0x01cb, B:140:0x01cf, B:144:0x01ec, B:152:0x01fc, B:154:0x0201, B:155:0x0204, B:157:0x0208, B:159:0x020e, B:160:0x0213), top: B:209:0x01cb }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0201 A[Catch: Exception -> 0x01e6, TryCatch #7 {Exception -> 0x01e6, blocks: (B:138:0x01cb, B:140:0x01cf, B:144:0x01ec, B:152:0x01fc, B:154:0x0201, B:155:0x0204, B:157:0x0208, B:159:0x020e, B:160:0x0213), top: B:209:0x01cb }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0208 A[Catch: Exception -> 0x01e6, TryCatch #7 {Exception -> 0x01e6, blocks: (B:138:0x01cb, B:140:0x01cf, B:144:0x01ec, B:152:0x01fc, B:154:0x0201, B:155:0x0204, B:157:0x0208, B:159:0x020e, B:160:0x0213), top: B:209:0x01cb }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0 A[Catch: Exception -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0107, blocks: (B:18:0x0075, B:21:0x0085, B:24:0x008d, B:30:0x009e, B:39:0x00c0, B:44:0x00ce, B:46:0x00d8, B:56:0x00ef), top: B:203:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014a A[Catch: Exception -> 0x0157, TRY_LEAVE, TryCatch #3 {Exception -> 0x0157, blocks: (B:83:0x0141, B:85:0x014a), top: B:201:0x0141 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.mbridge.msdk.videocommon.download.a> a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 957
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.i.a(java.util.List, boolean):java.util.List");
    }

    public final void b(String str) {
        com.mbridge.msdk.videocommon.download.a aVarRemove;
        CampaignEx campaignExL;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (this.h.containsKey(str) && (aVarRemove = this.h.remove(str)) != null && (campaignExL = aVarRemove.l()) != null) {
                this.g.remove(campaignExL);
                if (MBridgeConstans.DEBUG) {
                    af.a("RewardVideoRefactorManager", this.f6579d + " removeCampaignDownloadTask campaign name: " + campaignExL.getAppName());
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", this.f6579d + " removeCampaignDownloadTask error:" + e.getMessage());
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> d() {
        try {
            CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(this.h);
            return copyOnWriteArrayList;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.b("RewardVideoRefactorManager", this.f6579d + " getCampaignDownLoadTaskList error:" + e.getMessage());
            return null;
        }
    }

    public i(CampaignEx campaignEx, String str, int i10) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.g = copyOnWriteArrayList;
        this.h = new ConcurrentHashMap<>();
        this.f6578c = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f6579d = str;
        this.f = i10;
        if (campaignEx != null) {
            copyOnWriteArrayList.add(campaignEx);
        }
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 1;
        }
        try {
            return campaignEx.getVideoCtnType();
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 1;
            }
            af.a("RewardVideoRefactorManager", this.f6579d + " getVideoCtnType error " + e.getMessage());
            return 1;
        }
    }

    private boolean e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            af.a("RewardVideoRefactorManager", this.f6579d + " isPlayerAbleAds error:" + th.getMessage());
            return false;
        }
    }

    private int f(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return g();
    }

    private com.mbridge.msdk.videocommon.d.c c(String str) {
        try {
            if (this.e == null) {
                this.e = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str, this.f == 287);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.a("RewardVideoRefactorManager", this.f6579d + " getRewardUnitSetting error " + e.getMessage());
            }
        }
        return this.e;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        private final String f6580a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f6581b;

        /* renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.videocommon.listener.a f6582c;

        public a(String str, ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap, com.mbridge.msdk.videocommon.listener.a aVar) {
            this.f6580a = str;
            this.f6581b = concurrentHashMap;
            this.f6582c = aVar;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f6582c;
            if (aVar != null) {
                try {
                    aVar.a(str);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoRefactorManager", this.f6580a + " videoDownloadListener onDownLoadDone error: " + e.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f6581b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str);
                    } catch (Exception e3) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoRefactorManager", this.f6580a + " videoDownloadListener onDownLoadDone error: " + e3.getMessage());
                        }
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f6582c;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoRefactorManager", this.f6580a + " videoDownloadListener onDownLoadFailed error: " + e.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f6581b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str, str2);
                    } catch (Exception e3) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoRefactorManager", this.f6580a + " videoDownloadListener onDownLoadFailed error: " + e3.getMessage());
                        }
                    }
                }
            }
        }
    }

    public final com.mbridge.msdk.videocommon.download.a b() {
        List<com.mbridge.msdk.videocommon.download.a> listA;
        if (this.g.size() == 0) {
            af.a("RewardVideoRefactorManager", this.f6579d + " isReady campaignExes is null");
            return null;
        }
        try {
            listA = a((List<CampaignEx>) this.g, false);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", this.f6579d + " isReady error", e);
            }
            listA = null;
        }
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        return listA.get(0);
    }

    public final com.mbridge.msdk.videocommon.download.a c() {
        try {
            return b();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.b("RewardVideoRefactorManager", this.f6579d + " getCampaignDownLoadTask error:" + th.getMessage());
            return null;
        }
    }

    private String b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        try {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                return rewardTemplateMode.e();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", this.f6579d + " getVideoTemplateUrl error", e);
            }
        }
        return "";
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.f6577b == null) {
            this.f6577b = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6577b.put(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                this.g.addAll(list);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoRefactorManager", this.f6579d + " update error", e);
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                this.g.add(campaignEx);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoRefactorManager", this.f6579d + " update error", e);
                }
            }
        }
    }

    public final void a() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null) {
                    try {
                        String str = next.getRequestId() + next.getId() + next.getVideoUrlEncode();
                        if (!this.h.containsKey(str)) {
                            a(next, str, (com.mbridge.msdk.videocommon.download.a) null);
                        }
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoRefactorManager", this.f6579d + " handlerCampaignLoadEvent error", e);
                        }
                    }
                }
            }
            return;
        }
        af.a("RewardVideoRefactorManager", this.f6579d + " load campaignExes is null");
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f6576a = aVar;
    }

    private com.mbridge.msdk.videocommon.download.a a(CampaignEx campaignEx, String str, com.mbridge.msdk.videocommon.download.a aVar) {
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.videocommon.download.a aVarC = c(campaignEx);
        aVarC.n();
        this.h.put(str, aVarC);
        return aVarC;
    }

    private boolean a(String str, CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar) {
        if (campaignEx != null && aVar != null) {
            try {
                if (aVar.b()) {
                    af.a("RewardVideoRefactorManager", this.f6579d + " checkEndCardZipOrSourceDownLoad endCard download success");
                    return true;
                }
                if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                    return true;
                }
                if ((campaignEx.isDynamicView() && !ak.l(str)) || ap.a(str)) {
                    return true;
                }
                if ((campaignEx.isMraid() || TextUtils.isEmpty(str) || (campaignEx.getLoadTimeoutState() == 1 && !e(campaignEx)) || ((campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) || ap.b(f.a(str)))) ? true : ap.b(f.b(str))) {
                    return true;
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.a("RewardVideoRefactorManager", this.f6579d + " checkEndCardDownload error " + th.getMessage());
                }
            }
        }
        return false;
    }

    public final com.mbridge.msdk.videocommon.download.a a(String str) {
        if (!TextUtils.isEmpty(str) && this.h.containsKey(str)) {
            return this.h.get(str);
        }
        return null;
    }
}
