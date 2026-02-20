package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4200a = "b";

    /* renamed from: b, reason: collision with root package name */
    private Context f4201b;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.a.b f4203d;
    private com.mbridge.msdk.mbbanner.common.util.a e;
    private com.mbridge.msdk.mbbanner.common.b.b f;
    private com.mbridge.msdk.mbbanner.common.b.d g;

    /* renamed from: c, reason: collision with root package name */
    private int f4202c = 0;
    private volatile boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    private Timer f4204i = new Timer();

    /* renamed from: j, reason: collision with root package name */
    private volatile List<String> f4205j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f4206k = false;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f4207l = false;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f4208m = false;

    /* renamed from: n, reason: collision with root package name */
    private String f4209n = "";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements com.mbridge.msdk.foundation.same.c.c {

        /* renamed from: a, reason: collision with root package name */
        private b f4221a;

        /* renamed from: b, reason: collision with root package name */
        private String f4222b;

        /* renamed from: c, reason: collision with root package name */
        private CampaignEx f4223c;

        public a(b bVar, String str, CampaignEx campaignEx) {
            this.f4221a = bVar;
            this.f4222b = str;
            this.f4223c = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            String str3;
            if (MBridgeConstans.DEBUG) {
                af.c(b.f4200a, "DownloadImageListener campaign image fail");
            }
            b bVar = this.f4221a;
            if (bVar != null) {
                str3 = str2;
                bVar.a(this.f4222b, 1, str3, false, this.f4223c);
            } else {
                str3 = str2;
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(this.f4222b, this.f4223c.getCurrentLocalRid());
                cVarA.a(this.f4223c);
                cVarA.a(10);
                e eVar = new e();
                cVarA.a(10);
                eVar.a("resource_type", 10);
                eVar.a("result", 3);
                eVar.a("url", str3);
                com.mbridge.msdk.mbbanner.common.d.a.a("m_download_end", cVarA, eVar);
            } catch (Throwable th) {
                af.b(b.f4200a, th.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            String str2;
            if (MBridgeConstans.DEBUG) {
                af.c(b.f4200a, "DownloadImageListener campaign image success");
            }
            b bVar = this.f4221a;
            if (bVar != null) {
                str2 = str;
                bVar.a(this.f4222b, 1, str2, true, this.f4223c);
            } else {
                str2 = str;
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(this.f4222b, this.f4223c.getCurrentLocalRid());
                cVarA.a(this.f4223c);
                cVarA.a(10);
                cVarA.a(10);
                e eVar = new e();
                eVar.a("resource_type", 10);
                eVar.a("result", 1);
                eVar.a("url", str2);
                com.mbridge.msdk.mbbanner.common.d.a.a("m_download_end", cVarA, eVar);
            } catch (Throwable th) {
                af.b(b.f4200a, th.getMessage());
            }
        }
    }

    public b(Context context, com.mbridge.msdk.mbbanner.common.a.b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2, com.mbridge.msdk.mbbanner.common.util.a aVar) {
        this.f4201b = context.getApplicationContext();
        this.f4203d = bVar;
        this.f = bVar2;
        this.e = aVar;
    }

    public static /* synthetic */ void a(b bVar, final String str, String str2, final CampaignUnit campaignUnit) throws Throwable {
        CampaignEx campaignEx;
        b bVar2;
        String str3;
        if (campaignUnit == null) {
            com.mbridge.msdk.foundation.c.b bVar3 = new com.mbridge.msdk.foundation.c.b(880003);
            MBridgeIds mBridgeIds = new MBridgeIds();
            mBridgeIds.setUnitId(str);
            bVar3.a(mBridgeIds);
            bVar3.b(str2);
            bVar.e.a(bVar.f, bVar3);
            bVar.g.a(str);
            return;
        }
        List<CampaignEx> listA = bVar.a(str, campaignUnit);
        new Thread(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.b.4
            @Override // java.lang.Runnable
            public final void run() {
                af.c(b.f4200a, "在单独子线程保存数据库 开始");
                j.a(g.a(b.this.f4201b)).a();
                CampaignUnit campaignUnit2 = campaignUnit;
                if (campaignUnit2 != null && campaignUnit2.getAds() != null && campaignUnit.getAds().size() > 0) {
                    BannerUtils.uisList(b.this.f4201b, campaignUnit.getAds());
                }
                af.c(b.f4200a, "在单独子线程保存数据库 完成");
            }
        }).start();
        int i10 = 0;
        if (listA == null || listA.size() == 0) {
            af.c(f4200a, "tryDownloadOnLoadSuccess 返回的campaign 没有符合下载规则的");
            com.mbridge.msdk.foundation.c.b bVar4 = bVar.f4209n.contains("INSTALLED") ? new com.mbridge.msdk.foundation.c.b(880021, "APP ALREADY INSTALLED") : new com.mbridge.msdk.foundation.c.b(880003);
            MBridgeIds mBridgeIds2 = new MBridgeIds();
            mBridgeIds2.setUnitId(str);
            bVar4.a(mBridgeIds2);
            bVar4.b(str2);
            if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && (campaignEx = campaignUnit.getAds().get(0)) != null) {
                bVar4.a(campaignEx);
            }
            bVar.e.a(bVar.f, bVar4);
            bVar.g.a(str);
            return;
        }
        String str4 = f4200a;
        af.c(str4, "在子线程处理业务逻辑 开始");
        final CampaignEx campaignEx2 = listA.get(0);
        bVar.f4204i.schedule(new TimerTask() { // from class: com.mbridge.msdk.mbbanner.common.c.b.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                if (b.this.h) {
                    return;
                }
                b.this.h = true;
                b.this.a(str, -1, "", false, campaignEx2);
            }
        }, MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
        bVar.f4203d.a(campaignUnit.getSessionId());
        int size = bVar.f4202c;
        try {
            if (listA.size() > 0) {
                size += listA.size();
            }
            if (size > bVar.f4203d.c()) {
                af.c(str4, "saveNextOffset 重置offset为0");
                size = 0;
            }
            af.c(str4, "saveNextOffset 算出 下次的offset是:" + size);
            if (ap.b(str)) {
                bVar.f4203d.a(size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String strTrim = campaignEx2.getBannerUrl().trim();
        if (TextUtils.isEmpty(strTrim)) {
            bVar2 = bVar;
            str3 = str;
            String strTrim2 = campaignEx2.getBannerHtml().trim();
            if (TextUtils.isEmpty(strTrim2)) {
                bVar2.f4207l = true;
                bVar2.f4206k = true;
            } else {
                String strA = bVar2.a(str3, strTrim2, campaignEx2);
                if (listA.size() > 0) {
                    while (i10 < listA.size()) {
                        listA.get(i10).setBannerHtml(strA);
                        listA.get(i10).setHasMBTplMark(strTrim2.contains("<MBTPLMARK>"));
                        i10++;
                    }
                }
            }
        } else {
            if (TextUtils.isEmpty(strTrim)) {
                bVar2 = bVar;
                str3 = str;
            } else {
                bVar2 = bVar;
                str3 = str;
                bVar2.a(str3, 3, strTrim, true, campaignEx2);
            }
            if (listA.size() > 0) {
                while (i10 < listA.size()) {
                    listA.get(i10).setBannerUrl(campaignEx2.getBannerUrl());
                    listA.get(i10).setHasMBTplMark(true);
                    i10++;
                }
            }
        }
        bVar2.a(str3, listA);
    }

    private void a(String str, int i10) {
        if (this.f4208m) {
            return;
        }
        if ((this.f4206k || this.f4207l) && this.f4205j.size() == 0) {
            af.c(f4200a, "在子线程处理业务逻辑 完成");
            this.h = true;
            this.f4208m = true;
            this.f4204i.cancel();
            this.e.a(this.f, str, i10);
            this.g.a(str);
        }
    }

    public final void a(String str, int i10, String str2, boolean z9, CampaignEx campaignEx) {
        if (z9) {
            if (i10 == 1) {
                af.c(f4200a, "downloadResource--> Success Image");
                synchronized (this) {
                    try {
                        this.f4205j.remove(str2);
                        if (this.f4205j.size() == 0) {
                            a(str, i10);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            if (i10 == 2) {
                af.c(f4200a, "downloadResource--> Success banner_html");
                this.f4207l = true;
                a(str, i10);
                return;
            } else {
                if (i10 == 3) {
                    af.c(f4200a, "downloadResource--> Success banner_url");
                    this.f4206k = true;
                    a(str, i10);
                    return;
                }
                return;
            }
        }
        if (i10 == -1) {
            af.b(f4200a, " unitId =" + str + " --> time out!");
        }
        this.f4204i.cancel();
        String str3 = f4200a;
        af.c(str3, "在子线程处理业务逻辑 完成");
        af.c(str3, "downloadResource--> Fail");
        this.h = true;
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880027);
        MBridgeIds mBridgeIds = new MBridgeIds();
        mBridgeIds.setUnitId(str);
        bVar.a(mBridgeIds);
        bVar.b(this.f4203d.d());
        bVar.a(campaignEx);
        this.e.b(this.f, bVar);
        this.g.a(str);
    }

    public final void a(String str, String str2, final com.mbridge.msdk.mbbanner.common.a.a aVar, com.mbridge.msdk.mbbanner.common.b.d dVar) {
        boolean z9;
        try {
            af.c(f4200a, "requestCampaign--> started");
            this.g = dVar;
            com.mbridge.msdk.mbbanner.common.f.a aVar2 = new com.mbridge.msdk.mbbanner.common.f.a() { // from class: com.mbridge.msdk.mbbanner.common.c.b.2
                @Override // com.mbridge.msdk.mbbanner.common.f.a
                public final void a(CampaignUnit campaignUnit) throws Throwable {
                    try {
                        af.c(b.f4200a, "requestCampaign--> Succeed");
                        campaignUnit.setLocalRequestId(aVar.e());
                        b.this.e.a(b.this.f, campaignUnit, this.unitId);
                        b.a(b.this, this.unitId, aVar.e(), campaignUnit);
                    } catch (Exception e) {
                        af.c(b.f4200a, "requestCampaign--> Fail with exception = " + e.getMessage());
                        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880000);
                        bVar.a(new MBridgeIds(this.placementId, this.unitId));
                        bVar.b(aVar.e());
                        bVar.a((campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().isEmpty()) ? null : campaignUnit.getAds().get(0));
                        bVar.a((Throwable) e);
                        b.this.e.a(b.this.f, bVar);
                        b.this.g.a(this.unitId);
                    }
                }

                @Override // com.mbridge.msdk.mbbanner.common.f.a
                public final void a(int i10, String str3) {
                    af.c(b.f4200a, "requestCampaign--> Fail errorCode:" + i10 + " msg:" + str3);
                    com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880003);
                    bVar.a(i10 + "#" + str3);
                    bVar.a(new MBridgeIds(this.placementId, this.unitId));
                    bVar.b(aVar.e());
                    b.this.e.a(b.this.f, bVar);
                    b.this.g.a(this.unitId);
                }
            };
            aVar2.setUnitId(str2);
            aVar2.setPlacementId(str);
            aVar2.setAdType(296);
            com.mbridge.msdk.mbbanner.common.e.a aVar3 = new com.mbridge.msdk.mbbanner.common.e.a(this.f4201b);
            this.f4202c = a(str2);
            com.mbridge.msdk.foundation.same.net.f.e eVarA = com.mbridge.msdk.mbbanner.common.a.c.a(false, this.f4201b, str2, this.f4203d.a(), this.f4202c, aVar);
            String strD = ak.d(str2);
            if (!TextUtils.isEmpty(strD)) {
                eVarA.a("j", strD);
            }
            String strC = aVar.c();
            if (TextUtils.isEmpty(strC)) {
                z9 = false;
            } else {
                aVar2.a(strC);
                z9 = true;
            }
            this.e.a(z9);
            aVar3.choiceV3OrV5BySetting(1, eVarA, aVar2, strC, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        } catch (Exception e) {
            af.b(f4200a, e.getMessage());
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880002);
            bVar.a(new MBridgeIds(str, str2));
            this.e.a(this.f, bVar);
            this.g.a(str2);
        }
    }

    private List<CampaignEx> a(String str, CampaignUnit campaignUnit) {
        final String str2;
        final com.mbridge.msdk.foundation.same.report.d.a.a aVar;
        ArrayList arrayList = new ArrayList();
        if (campaignUnit != null) {
            try {
                if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    af.c(f4200a, "getNeedShowList 总共返回的campaign有：" + ads.size());
                    int i10 = 0;
                    while (i10 < ads.size()) {
                        final CampaignEx campaignEx = ads.get(i10);
                        if (campaignEx == null || campaignEx.getOfferType() == 99 || (TextUtils.isEmpty(campaignEx.getBannerUrl()) && TextUtils.isEmpty(campaignEx.getBannerHtml()) && TextUtils.isEmpty(campaignEx.getImageUrl()))) {
                            str2 = str;
                        } else {
                            if (ak.c(campaignEx)) {
                                campaignEx.setRtinsType(ak.c(this.f4201b, campaignEx.getPackageName()) ? 1 : 2);
                            }
                            if (com.mbridge.msdk.foundation.same.c.a(this.f4201b, campaignEx)) {
                                arrayList.add(campaignEx);
                            } else {
                                ak.a(str, campaignEx, com.mbridge.msdk.foundation.same.a.f3619x);
                                this.f4209n = "APP ALREADY INSTALLED";
                            }
                            final Context context = this.f4201b;
                            try {
                                aVar = null;
                                str2 = str;
                            } catch (Exception e) {
                                e = e;
                                str2 = str;
                            }
                            try {
                                com.mbridge.msdk.foundation.same.c.a(campaignEx, context, null, new c.a() { // from class: com.mbridge.msdk.mbbanner.common.c.b.3
                                    @Override // com.mbridge.msdk.foundation.same.c.a
                                    public final void a(String str3, com.mbridge.msdk.foundation.same.report.d.c cVar) {
                                        if (TextUtils.isEmpty(str3)) {
                                            return;
                                        }
                                        e eVar = new e();
                                        eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                        cVar.a(str3, eVar);
                                        try {
                                            com.mbridge.msdk.foundation.same.report.d.d.a().a(str3, cVar, campaignEx, context, aVar);
                                        } catch (Exception e3) {
                                            af.b("BannerReport", e3.getMessage());
                                        }
                                    }
                                });
                            } catch (Exception e3) {
                                e = e3;
                                af.b(f4200a, e.getMessage());
                                i10++;
                                str = str2;
                            }
                        }
                        i10++;
                        str = str2;
                    }
                    af.c(f4200a, "getNeedShowList 返回有以下带有视频素材的campaign：" + arrayList.size());
                }
            } catch (Exception e7) {
                af.b(f4200a, e7.getMessage());
            }
        }
        return arrayList;
    }

    private void a(String str, List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                this.f4205j.add(campaignEx.getImageUrl());
                com.mbridge.msdk.foundation.same.c.b.a(this.f4201b).a(campaignEx.getImageUrl(), new a(this, str, campaignEx));
                com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(str, campaignEx.getCurrentLocalRid());
                cVarA.a(campaignEx);
                cVarA.a(10);
                e eVar = new e();
                eVar.a("resource_type", 10);
                com.mbridge.msdk.mbbanner.common.d.a.a("m_download_start", cVarA, eVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(java.lang.String r14, java.lang.String r15, com.mbridge.msdk.foundation.entity.CampaignEx r16) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            java.lang.String r1 = ""
            if (r0 != 0) goto Lb4
            r2 = 0
            com.mbridge.msdk.foundation.same.b.c r0 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            java.lang.String r0 = com.mbridge.msdk.foundation.same.b.e.a(r0)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.aq.b(r15)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r3)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            if (r4 == 0) goto L2c
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            goto L2c
        L26:
            r0 = move-exception
            r14 = r0
            goto La2
        L2a:
            r0 = move-exception
            goto L66
        L2c:
            java.lang.String r4 = ".html"
            java.lang.String r3 = r3.concat(r4)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            r4.<init>(r0, r3)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            android.net.Uri r0 = android.net.Uri.parse(r15)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            r0.getPath()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L2a
            byte[] r0 = r15.getBytes()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            r3.write(r0)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            r3.flush()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            java.lang.String r1 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            r3.close()     // Catch: java.lang.Exception -> L55
            goto L74
        L55:
            r0 = move-exception
            java.lang.String r2 = com.mbridge.msdk.mbbanner.common.c.b.f4200a
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
            goto L74
        L60:
            r0 = move-exception
            r14 = r0
            r2 = r3
            goto La2
        L64:
            r0 = move-exception
            r2 = r3
        L66:
            java.lang.String r3 = com.mbridge.msdk.mbbanner.common.c.b.f4200a     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L26
            com.mbridge.msdk.foundation.tools.af.b(r3, r0)     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.lang.Exception -> L55
        L74:
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L97
            boolean r2 = r0.isFile()
            if (r2 == 0) goto L97
            boolean r0 = r0.canRead()
            if (r0 != 0) goto L8c
            goto L97
        L8c:
            r4 = 2
            r6 = 1
            r2 = r13
            r3 = r14
            r5 = r15
            r7 = r16
            r2.a(r3, r4, r5, r6, r7)
            goto La1
        L97:
            r9 = 2
            r11 = 0
            r7 = r13
            r8 = r14
            r10 = r15
            r12 = r16
            r7.a(r8, r9, r10, r11, r12)
        La1:
            return r1
        La2:
            if (r2 == 0) goto Lb3
            r2.close()     // Catch: java.lang.Exception -> La8
            goto Lb3
        La8:
            r0 = move-exception
            r15 = r0
            java.lang.String r0 = com.mbridge.msdk.mbbanner.common.c.b.f4200a
            java.lang.String r15 = r15.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r15)
        Lb3:
            throw r14
        Lb4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.b.a(java.lang.String, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx):java.lang.String");
    }

    private int a(String str) {
        try {
            int iB = this.f4203d.b();
            if (iB > this.f4203d.c()) {
                return 0;
            }
            return iB;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
