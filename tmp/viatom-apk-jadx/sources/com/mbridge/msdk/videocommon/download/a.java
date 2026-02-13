package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements Serializable {
    private int A;
    private File B;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private k H;
    private com.mbridge.msdk.videocommon.d.c I;
    private k J;

    /* renamed from: b, reason: collision with root package name */
    private int f6537b;

    /* renamed from: c, reason: collision with root package name */
    private int f6538c;
    private volatile int e;
    private com.mbridge.msdk.videocommon.listener.a g;
    private com.mbridge.msdk.videocommon.listener.a h;

    /* renamed from: i, reason: collision with root package name */
    private CampaignEx f6540i;

    /* renamed from: j, reason: collision with root package name */
    private String f6541j;

    /* renamed from: k, reason: collision with root package name */
    private Context f6542k;

    /* renamed from: l, reason: collision with root package name */
    private long f6543l;

    /* renamed from: m, reason: collision with root package name */
    private String f6544m;

    /* renamed from: n, reason: collision with root package name */
    private String f6545n;

    /* renamed from: o, reason: collision with root package name */
    private long f6546o;

    /* renamed from: p, reason: collision with root package name */
    private String f6547p;

    /* renamed from: r, reason: collision with root package name */
    private long f6549r;

    /* renamed from: u, reason: collision with root package name */
    private n f6551u;

    /* renamed from: w, reason: collision with root package name */
    private String f6553w;

    /* renamed from: x, reason: collision with root package name */
    private DownloadRequest f6554x;
    private int y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f6555z;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6536a = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6539d = false;
    private CopyOnWriteArrayList<c> f = new CopyOnWriteArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    private boolean f6548q = false;

    /* renamed from: s, reason: collision with root package name */
    private int f6550s = 100;
    private boolean t = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f6552v = false;
    private int C = 1;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private OnDownloadStateListener R = new OnDownloadStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.1
        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            String str;
            try {
                af.b("CampaignDownLoadTask", "onDownloadComplete callback : " + a.this.f6546o + "    " + a.this.f6543l);
                if (a.this.f6551u == null) {
                    a.this.f6551u = n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                }
                a.this.f6551u.a(a.this.f6544m, a.this.f6546o, 5);
                if (downloadMessage != null) {
                    try {
                        str = (String) downloadMessage.getExtra("responseHeaders");
                    } catch (Throwable th) {
                        af.b("CampaignDownLoadTask", th.getMessage());
                    }
                } else {
                    str = "";
                }
                a aVar = a.this;
                aVar.a(aVar.f6546o, true, str);
                a.this.f6551u.a(a.this.f6544m, a.this.f6546o, 5);
                a aVar2 = a.this;
                aVar2.a(aVar2.f6546o, true, "");
                a.a(a.this, 1, true, "");
            } catch (Exception e) {
                af.b("CampaignDownLoadTask", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (a.this.f6554x == null || a.this.f6554x.getStatus() == DownloadStatus.CANCELLED) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("cache", a.this.f6554x.get("cache", "2"));
            a aVar = a.this;
            aVar.a(aVar.f6540i, eVar);
            String message = (downloadError == null || downloadError.getException() == null) ? "Video Download Error" : downloadError.getException().getMessage();
            a.this.v();
            a.this.a(3, message, "");
            a.this.a(message);
            a aVar2 = a.this;
            a.a(aVar2, 3, aVar2.f6555z, message);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            a.this.e = 1;
            if (a.this.f6551u == null) {
                a.this.f6551u = n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            }
            a.this.f6551u.a(a.this.f6540i, a.this.f6543l, a.this.f6547p, a.this.e);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onCancelDownload(DownloadMessage downloadMessage) {
        }
    };
    private OnProgressStateListener S = new OnProgressStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.2
        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("cache", a.this.f6554x.get("cache", "2"));
                a aVar = a.this;
                aVar.a(aVar.f6540i, eVar);
                a.this.f6546o = downloadProgress.getCurrent();
                a.this.f6543l = downloadProgress.getTotal();
                a.this.y = downloadProgress.getCurrentDownloadRate();
                if (a.this.f6550s != 100 && downloadProgress.getCurrentDownloadRate() >= a.this.f6550s) {
                    af.b("CampaignDownLoadTask", "Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate = " + a.this.f6550s + " " + a.this.f6538c);
                    if (a.this.f6539d) {
                        return;
                    }
                    a.this.f6539d = true;
                    if (!a.this.f6555z) {
                        a.a(a.this, 1, true, "");
                        a.this.a(downloadProgress.getCurrent(), false, "");
                    }
                    if (a.this.f6554x == null || a.this.C != 2 || a.this.f6555z) {
                        return;
                    }
                    a.this.f6554x.cancel(downloadMessage);
                }
            } catch (Exception e) {
                af.b("CampaignDownLoadTask", e.getMessage());
            }
        }
    };

    public a(Context context, CampaignEx campaignEx, String str, int i10) throws IOException {
        File file;
        File file2;
        this.f6537b = 1;
        this.e = 0;
        this.f6546o = 0L;
        int iB = 100;
        this.G = false;
        if (context == null && campaignEx == null) {
            return;
        }
        com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarA != null) {
            this.G = gVarA.aG();
        }
        this.D = com.mbridge.msdk.foundation.same.a.f3616u;
        this.E = com.mbridge.msdk.foundation.same.a.f3617v;
        this.F = com.mbridge.msdk.foundation.same.a.t;
        this.f6549r = System.currentTimeMillis();
        this.f6542k = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f6540i = campaignEx;
        this.f6541j = str;
        this.f6537b = i10;
        if (campaignEx != null) {
            this.f6544m = campaignEx.getVideoUrlEncode();
        }
        this.f6553w = ad.c(this.f6544m);
        this.f6545n = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC) + File.separator;
        this.f6547p = this.f6545n + this.f6553w;
        af.c("CampaignDownLoadTask", this.f6540i.getAppName() + " videoLocalPath:" + this.f6547p + " videoUrl: " + this.f6540i.getVideoUrlEncode() + " " + this.f6550s);
        try {
            if (TextUtils.isEmpty(this.f6544m)) {
                return;
            }
            if (TextUtils.isEmpty(this.f6545n)) {
                file = null;
            } else {
                file = new File(this.f6545n);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            if (file != null && file.exists() && ((file2 = this.B) == null || !file2.exists())) {
                File file3 = new File(file + "/.nomedia");
                this.B = file3;
                if (!file3.exists()) {
                    this.B.createNewFile();
                }
            }
            n nVarA = n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            m mVarA = nVarA.a(this.f6544m, "");
            if (mVarA != null) {
                this.f6546o = mVarA.c();
                if (this.e != 2) {
                    this.e = mVarA.b();
                }
                if (this.e == 1) {
                    this.e = 2;
                }
                this.f6543l = mVarA.d();
                if (mVarA.a() > 0) {
                    this.f6549r = mVarA.a();
                }
                if (this.e == 5) {
                    if (Objects.exists(new File(this.f6545n + this.f6553w), this.f6545n, this.f6553w)) {
                        this.f6547p = this.f6545n + this.f6553w;
                    } else {
                        u();
                    }
                } else if (this.e != 0) {
                    this.f6547p = this.f6545n + this.f6553w;
                }
            } else {
                nVarA.a(this.f6544m, this.f6549r);
            }
            try {
                long j10 = this.f6543l;
                if (j10 > 0 && this.f6546o * 100 >= j10 * b(this.f6540i) && (b(this.f6540i) == 100 || this.e == 5)) {
                    com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar.a("cache", 1);
                    a(this.f6540i, eVar);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            String str2 = this.f6544m;
            if (TextUtils.isEmpty(str2)) {
                this.h.a("VideoUrl is NULL, Please check it.", "");
                return;
            }
            if (this.e == 1) {
                af.a("CampaignDownLoadTask", "Run : Task is RUNNING, Will return.");
                return;
            }
            if (this.e == 5 && Utils.getDownloadRate(this.f6543l, this.f6546o) >= this.f6550s) {
                af.a("CampaignDownLoadTask", "Run : Video Done, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar = this.g;
                if (aVar != null) {
                    aVar.a(this.f6544m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
                if (aVar2 != null) {
                    aVar2.a(this.f6544m);
                }
                try {
                    File file4 = new File(this.f6547p);
                    if (Objects.exists(file4, this.f6545n, this.f6553w) && file4.isFile()) {
                        file4.setLastModified(System.currentTimeMillis());
                    }
                } catch (Exception e3) {
                    af.b("CampaignDownLoadTask", e3.getMessage());
                }
                com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar2.a("cache", 1);
                a(this.f6540i, eVar2);
                return;
            }
            if (this.f6537b == 3) {
                af.a("CampaignDownLoadTask", "Run : Dlnet is 3, Will callback.");
                a(0L, false, "");
                com.mbridge.msdk.foundation.same.report.d.e eVar3 = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar3.a("cache", 1);
                a(this.f6540i, eVar3);
                return;
            }
            try {
                iB = b(this.f6540i);
            } catch (Exception unused) {
            }
            c(iB);
            if (iB == 0) {
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.g;
                if (aVar3 != null) {
                    aVar3.a(this.f6544m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar4 = this.h;
                if (aVar4 != null) {
                    aVar4.a(this.f6544m);
                }
            }
            DownloadMessage downloadMessage = new DownloadMessage(this.f6540i, str2, this.f6553w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            downloadMessage.setUseCronetDownload(e(this.f6540i));
            downloadMessage.addExtra("resource_type", 4);
            this.f6554x = a(downloadMessage, this.R, this.S, "1");
        } catch (Exception e7) {
            af.c("CampaignDownLoadTask", e7.getMessage());
        }
    }

    private void a(long j10, int i10) {
        this.f6546o = j10;
        int i11 = this.f6550s;
        if (100 * j10 >= i11 * this.f6543l && !this.t && i10 != 4) {
            if (i11 == 100 && i10 != 5) {
                this.e = 5;
                return;
            }
            this.t = true;
            af.b("CampaignDownLoadTask", "UpdateListener : state: " + i10 + " progress : " + j10);
            String strQ = q();
            boolean zIsEmpty = TextUtils.isEmpty(strQ);
            com.mbridge.msdk.videocommon.listener.a aVar = this.g;
            if (zIsEmpty) {
                if (aVar != null) {
                    aVar.a(this.f6544m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
                if (aVar2 != null) {
                    aVar2.a(this.f6544m);
                }
            } else {
                if (aVar != null) {
                    aVar.a(a3.a.i("file is not effective ", strQ), this.f6544m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.h;
                if (aVar3 != null) {
                    aVar3.a(a3.a.i("file is not effective ", strQ), this.f6544m);
                }
            }
        }
        if (!this.f6536a && j10 > 0) {
            this.f6536a = true;
            if (this.f6551u == null) {
                this.f6551u = n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            }
            this.f6551u.a(this.f6544m, j10, this.e);
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList != null) {
            Iterator<c> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    next.a(j10, i10);
                }
            }
        }
    }

    private int b(CampaignEx campaignEx) {
        int iC;
        if (campaignEx == null) {
            return 100;
        }
        if (campaignEx.getReady_rate() != -1) {
            iC = campaignEx.getReady_rate();
            com.mbridge.msdk.dycreator.baseview.a.m(iC, "ready_rate(campaign): ", "CampaignDownLoadTask");
        } else {
            iC = c(campaignEx);
            com.mbridge.msdk.dycreator.baseview.a.m(iC, "ready_rate(reward_unit_setting): ", "CampaignDownLoadTask");
        }
        try {
            return Math.max(iC, 0);
        } catch (Exception unused) {
            return 100;
        }
    }

    private int c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 100;
        }
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.H == null) {
                    this.H = com.mbridge.msdk.c.h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f6541j);
                }
                return this.H.p();
            }
            if (campaignEx.getAdType() == 42) {
                if (this.J == null) {
                    this.J = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f6541j);
                }
                return d((CampaignEx) null);
            }
            if (this.I == null) {
                this.I = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f6541j, false);
            }
            return this.I.r();
        } catch (Throwable th) {
            af.b("CampaignDownLoadTask", th.getMessage(), th);
            return 100;
        }
    }

    private int d(CampaignEx campaignEx) {
        try {
            k kVar = this.J;
            if (kVar != null) {
                return kVar.p();
            }
            return 100;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            af.b("CampaignDownLoadTask", e.getMessage());
            return 100;
        }
    }

    private int e(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAabEntity() != null) {
                    return campaignEx.getAabEntity().h3c;
                }
            } catch (Throwable th) {
                af.b("CampaignDownLoadTask", th.getMessage());
            }
        }
        return 0;
    }

    private void u() {
        if (this.f6551u == null) {
            this.f6551u = n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        try {
            try {
                this.f6551u.b(this.f6544m);
                if (!ah.a().a("r_d_v_b_l", true)) {
                    File file = new File(this.f6547p);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                }
            } catch (Throwable unused) {
                af.b("CampaignDownLoadTask", "del DB or file failed");
            }
        } finally {
            this.e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            String str = com.mbridge.msdk.reward.b.a.f5213b;
            com.mbridge.msdk.reward.b.a.class.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(com.mbridge.msdk.reward.b.a.class.newInstance(), this.f6541j, this.f6540i);
            Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.controller.NativeController");
            cls.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(cls.newInstance(), this.f6541j, this.f6540i);
        } catch (Exception e) {
            af.b("CampaignDownLoadTask", e.getMessage());
        }
    }

    public final void n() {
        af.b("CampaignDownLoadTask", "startForLoadRefactor()");
        try {
            if (TextUtils.isEmpty(this.f6544m)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.g;
                if (aVar != null) {
                    aVar.a(this.f6544m);
                    return;
                }
                return;
            }
            if (this.f6544m != null) {
                af.b("CampaignDownLoadTask", new URL(this.f6544m).getPath());
            }
            if (this.f6537b == 3) {
                af.b("CampaignDownLoadTask", "startForLoadRefactor: Dlnet is 3, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.g;
                if (aVar2 != null) {
                    aVar2.a(this.f6544m);
                    return;
                }
                return;
            }
            if (this.f6550s == 0 && this.C == 2) {
                af.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.g;
                if (aVar3 != null) {
                    aVar3.a(this.f6544m);
                    return;
                }
                return;
            }
            try {
                if (this.e == 5 && Utils.getDownloadRate(this.f6543l, this.f6546o) >= this.f6550s) {
                    if (Objects.exists(new File(this.f6545n + this.f6553w), this.f6545n, this.f6553w)) {
                        this.f6547p = this.f6545n + this.f6553w;
                        com.mbridge.msdk.videocommon.listener.a aVar4 = this.g;
                        if (aVar4 != null) {
                            aVar4.a(this.f6544m);
                            return;
                        }
                        return;
                    }
                }
            } catch (Exception e) {
                androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("startForLoadRefactor: "), "CampaignDownLoadTask");
            }
            DownloadRequest downloadRequest = this.f6554x;
            if (downloadRequest != null) {
                downloadRequest.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar5 = this.g;
            if (aVar5 != null) {
                aVar5.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void o() {
        af.b("CampaignDownLoadTask", "start()");
        try {
            if (TextUtils.isEmpty(this.f6544m)) {
                return;
            }
            if (this.f6544m != null) {
                af.b("CampaignDownLoadTask", new URL(this.f6544m).getPath());
            }
            if (this.f6550s == 0 && this.C == 2) {
                af.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                return;
            }
            DownloadRequest downloadRequest = this.f6554x;
            if (downloadRequest != null) {
                downloadRequest.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void p() {
        if (this.Q) {
            return;
        }
        try {
            this.f6555z = true;
            if (this.C == 1) {
                af.b("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.C);
            } else {
                if (this.f6537b == 3) {
                    af.b("CampaignDownLoadTask", "Can not call resume(), because dlnet = " + this.f6537b);
                    return;
                }
                af.b("CampaignDownLoadTask", "resume()");
                this.O = false;
                this.P = false;
                DownloadMessage downloadMessage = new DownloadMessage(new Object(), this.f6544m, this.f6553w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                downloadMessage.setUseCronetDownload(e(this.f6540i));
                DownloadRequest<?> downloadRequestA = a(downloadMessage, this.R, this.S, "2");
                this.f6554x = downloadRequestA;
                downloadRequestA.start();
            }
        } catch (Exception e) {
            af.b("CampaignDownLoadTask", e.getMessage());
        }
    }

    public final String q() {
        String message = "";
        if (this.f6537b == 3) {
            return "";
        }
        String str = this.f6545n + this.f6553w;
        File file = new File(str);
        try {
            if (!Objects.exists(file, this.f6545n, this.f6553w)) {
                message = "file is not exist ";
            } else if (!file.isFile()) {
                message = "file is not file ";
            } else if (!file.canRead()) {
                message = "file can not read ";
            } else if (file.length() > 0) {
                this.f6547p = str;
            } else {
                message = "file length is 0 ";
            }
        } catch (Throwable th) {
            af.b("CampaignDownLoadTask", th.getMessage());
            message = th.getMessage();
        }
        if (this.e == 5 && !TextUtils.isEmpty(message)) {
            u();
        }
        return message;
    }

    public final void r() {
        if (this.f != null) {
            this.f = null;
        }
    }

    public final void s() {
        try {
            u();
            CampaignEx campaignEx = this.f6540i;
            if (campaignEx == null || campaignEx.getPlayable_ads_without_video() != 2) {
                com.mbridge.msdk.videocommon.a.a aVarA = com.mbridge.msdk.videocommon.a.a.a();
                if (aVarA != null) {
                    aVarA.a(this.f6540i);
                }
            }
        } catch (Exception unused) {
            af.b("CampaignDownLoadTask", "del file is failed");
        } finally {
            this.e = 0;
        }
    }

    public final String t() {
        if (this.Q) {
            try {
                File file = new File(this.f6547p);
                return (file.exists() && file.isFile()) ? this.f6547p : this.f6544m;
            } catch (Exception e) {
                af.b("CampaignDownLoadTask", e.getMessage());
                return this.f6544m;
            }
        }
        try {
            File file2 = new File(this.f6547p);
            if (Objects.exists(file2, this.f6545n, this.f6553w) && file2.isFile()) {
                return this.f6547p;
            }
        } catch (Exception e3) {
            af.b("CampaignDownLoadTask", e3.getMessage());
        }
        return this.f6544m;
    }

    public final boolean f() {
        return this.f6552v;
    }

    public final long g() {
        return this.f6549r;
    }

    public final String h() {
        return this.f6547p;
    }

    public final long j() {
        return this.f6543l;
    }

    public final int k() {
        return this.e;
    }

    public final CampaignEx l() {
        return this.f6540i;
    }

    public final long m() {
        return this.f6546o;
    }

    public final void f(boolean z9) {
        this.f6548q = z9;
    }

    public final boolean i() {
        return this.Q;
    }

    public final void d(boolean z9) {
        this.N = z9;
    }

    public final boolean d() {
        return this.N;
    }

    public final String e() {
        return this.f6544m;
    }

    public final void d(int i10) {
        this.A = i10;
    }

    public final void e(boolean z9) {
        this.f6552v = z9;
    }

    public final void e(int i10) {
        this.C = i10;
    }

    public final void d(String str) {
        this.f6544m = str;
    }

    public final void b(boolean z9) {
        this.L = z9;
    }

    public final boolean b() {
        return this.L;
    }

    public final void b(int i10) {
        this.f6538c = i10;
    }

    public final void b(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        v();
        a(2, str, "");
        this.e = 4;
    }

    public final void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.h = aVar;
    }

    public final void c(boolean z9) {
        this.M = z9;
    }

    public final boolean c() {
        return this.M;
    }

    public final void c(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "set ready rate: ", "CampaignDownLoadTask");
        this.f6550s = i10;
    }

    public final void c(String str) {
        this.f6547p = str;
    }

    public final void a(boolean z9) {
        this.K = z9;
    }

    public final boolean a() {
        return this.K;
    }

    public final void a(int i10) {
        this.f6537b = i10;
    }

    public final void a(int i10, int i11) {
        this.e = i10;
        if (this.f6551u == null) {
            this.f6551u = n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        this.f6551u.a(this.f6544m, i11, i10);
    }

    public final void a(CampaignEx campaignEx) {
        this.f6540i = campaignEx;
    }

    private DownloadRequest<?> a(DownloadMessage downloadMessage, OnDownloadStateListener onDownloadStateListener, OnProgressStateListener onProgressStateListener, String str) {
        return MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(this.D).withConnectTimeout(this.F).withWriteTimeout(this.E).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f6545n).withDownloadStateListener(onDownloadStateListener).withProgressStateListener(onProgressStateListener).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("do_us_fi_re", Boolean.toString(this.G)).with("download_scene", "download_video").with(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.f6550s)).with("scenes", str).build();
    }

    public final void a(long j10, boolean z9, String str) {
        n nVar;
        af.b("CampaignDownLoadTask", "setStateToDone 下载完成  ： mProgressSize" + this.f6546o + "  progressSize " + j10 + "  " + this.y + "%   FileSize : " + this.f6543l + "  " + this.f6540i.getAppName());
        if (this.f6550s == 100 && this.f6537b != 3 && j10 != this.f6543l && !z9) {
            File file = new File(this.f6547p);
            long length = Objects.exists(file, this.f6545n, this.f6553w) ? file.length() : 0L;
            StringBuilder sbX = a3.a.x("progressSize = ", " fileSize = ", j10);
            sbX.append(this.f6543l);
            sbX.append(" ");
            sbX.append(z9);
            sbX.append(" absFileSize = ");
            sbX.append(length);
            af.b("CampaignDownLoadTask", sbX.toString());
            a("File size is not match witch download size.");
            return;
        }
        this.e = 5;
        if (j10 == this.f6543l) {
            a(1, "", str);
        }
        long j11 = this.f6543l;
        if (j11 != 0 && (nVar = this.f6551u) != null) {
            nVar.b(this.f6544m, j11);
        }
        this.f6536a = false;
        a(j10, this.e);
    }

    public final void a(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.g;
        if (aVar != null) {
            aVar.a(str, this.f6544m);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a(str, this.f6544m);
        }
        af.b("CampaignDownLoadTask", "Video download stop : " + str);
        if (this.e == 4 || this.e == 2 || this.e == 5) {
            return;
        }
        this.e = 4;
        CampaignEx campaignEx = this.f6540i;
        if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && this.f6540i.getRsIgnoreCheckRule().size() > 0 && this.f6540i.getRsIgnoreCheckRule().contains(0)) {
            af.c("CampaignDownLoadTask", "Is not check video download status");
        } else {
            a(this.f6546o, this.e);
        }
    }

    public final void a(c cVar) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(cVar);
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, String str, String str2) {
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n(this.f6542k, this.f6540i, i10, Long.toString(this.f6549r != 0 ? System.currentTimeMillis() - this.f6549r : 0L), this.f6543l, this.A);
        nVar.e(this.f6540i.getId());
        nVar.m(this.f6540i.getVideoUrlEncode());
        nVar.h(str);
        nVar.f(this.f6540i.getRequestId());
        nVar.s(this.f6540i.getCurrentLocalRid());
        nVar.g(this.f6540i.getRequestIdNotice());
        nVar.c(this.f6541j);
        nVar.t(str2);
        nVar.a(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.f6550s));
        nVar.a("url", this.f6540i.getVideoUrlEncode());
        nVar.e(4);
        DownloadRequest downloadRequest = this.f6554x;
        if (downloadRequest != null) {
            nVar.a("scenes", downloadRequest.get("scenes", ""));
            nVar.a("resumed_breakpoint", this.f6554x.get("resumed_breakpoint", ""));
        }
        int i11 = this.A;
        if (i11 == 94 || i11 == 287) {
            return;
        }
        o.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.d.e eVar) {
        if (this.O || campaignEx == null || eVar == null) {
            return;
        }
        this.O = true;
        try {
            eVar.a("resource_type", 4);
            DownloadRequest downloadRequest = this.f6554x;
            if (downloadRequest != null) {
                eVar.a("scenes", downloadRequest.get("scenes", "1"));
                eVar.a("resumed_breakpoint", this.f6554x.get("resumed_breakpoint", "2"));
            } else {
                eVar.a("scenes", "1");
                eVar.a("resumed_breakpoint", "1");
            }
            eVar.a("url", campaignEx.getVideoUrlEncode());
            eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(this.f6550s));
            com.mbridge.msdk.foundation.same.report.d.d.a().a("m_download_start", campaignEx, eVar);
        } catch (Exception e) {
            af.b("CampaignDownLoadTask", e.getMessage());
        }
    }

    public static /* synthetic */ void a(a aVar, int i10, boolean z9, String str) {
        if (aVar.P) {
            return;
        }
        try {
            aVar.P = true;
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            DownloadRequest downloadRequest = aVar.f6554x;
            if (downloadRequest != null) {
                eVar.a("scenes", downloadRequest.get("scenes", ""));
                eVar.a("url", aVar.f6544m);
                eVar.a("resumed_breakpoint", aVar.f6554x.get("resumed_breakpoint", ""));
                eVar.a("h3c", "");
            }
            eVar.a("resource_type", 4);
            eVar.a("file_size", Long.valueOf(aVar.f6543l));
            eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(aVar.f6550s));
            eVar.a("result", Integer.valueOf(i10));
            eVar.a("reason", str);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("m_download_end", aVar.f6540i, eVar);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
