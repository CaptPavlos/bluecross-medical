package com.mbridge.msdk.reward.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout;
import com.mbridge.msdk.videocommon.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, a> f5030b;

    /* renamed from: a, reason: collision with root package name */
    private final h f5031a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5032c;

    /* renamed from: d, reason: collision with root package name */
    private final String f5033d;
    private final String e;
    private final String f;
    private volatile List<WindVaneWebView> g;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f5053a;

        /* renamed from: b, reason: collision with root package name */
        boolean f5054b;

        /* renamed from: c, reason: collision with root package name */
        int f5055c;

        /* renamed from: d, reason: collision with root package name */
        int f5056d;
        String e;
        String f;
        int g;
        CopyOnWriteArrayList<CampaignEx> h;

        /* renamed from: i, reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f5057i;

        public a(boolean z9, boolean z10, int i10, int i11, String str, String str2, int i12, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f5053a = z9;
            this.f5054b = z10;
            this.f5055c = i10;
            this.f5056d = i11;
            this.e = str;
            this.f = str2;
            this.g = i12;
            this.h = copyOnWriteArrayList;
            this.f5057i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface c {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.c.b bVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class e implements com.mbridge.msdk.foundation.same.c.c {

        /* renamed from: a, reason: collision with root package name */
        private Handler f5083a;

        /* renamed from: b, reason: collision with root package name */
        private int f5084b;

        /* renamed from: c, reason: collision with root package name */
        private String f5085c;

        /* renamed from: d, reason: collision with root package name */
        private String f5086d;
        private String e;
        private CampaignEx f;

        public e(Handler handler, int i10, String str, String str2, String str3, CampaignEx campaignEx) {
            this.f5083a = handler;
            this.f5084b = i10;
            this.f5086d = str;
            this.f5085c = str2;
            this.e = str3;
            this.f = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(final String str, String str2) {
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f5084b == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5085c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f5086d);
            bundle.putString("request_id", this.e);
            messageObtain.setData(bundle);
            this.f5083a.sendMessage(messageObtain);
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (e.this.f != null) {
                        try {
                            o oVarA = o.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                            af.a("RewardCampaignsResourceManager", "campaign is null");
                            n nVar = new n();
                            nVar.a("2000044");
                            nVar.a(ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
                            nVar.e(e.this.f.getId());
                            nVar.p(e.this.f.getImageUrl());
                            nVar.f(e.this.f.getRequestId());
                            nVar.s(e.this.f.getCurrentLocalRid());
                            nVar.g(e.this.f.getRequestIdNotice());
                            nVar.c(e.this.f5085c);
                            nVar.h(str);
                            nVar.a("scenes", "1");
                            oVarA.a(nVar);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                            }
                        }
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.a.b().execute(runnable);
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            ResDownloadCheckManager.getInstance().setImageDownloadDone(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f5084b == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5085c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f5086d);
            bundle.putString("request_id", this.e);
            messageObtain.setData(bundle);
            this.f5083a.sendMessage(messageObtain);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface i {
        void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar);

        void a(String str, String str2, String str3, String str4);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface j {
        void a(String str, String str2, String str3, a.C0071a c0071a, com.mbridge.msdk.foundation.c.b bVar);

        void a(String str, String str2, String str3, String str4, String str5, a.C0071a c0071a);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class m {

        /* renamed from: a, reason: collision with root package name */
        private static final b f5140a = new b();
    }

    private b() {
        this.f5033d = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.e = "down_type";
        this.f = "h3c";
        this.g = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        f5030b = new ConcurrentHashMap<>();
        handlerThread.start();
        this.f5031a = new h(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized String b(int i10) {
        return i10 != 200 ? i10 != 201 ? i10 != 203 ? i10 != 205 ? EnvironmentCompat.MEDIA_UNKNOWN : "tpl" : "temp" : "zip/html" : MimeTypes.BASE_TYPE_VIDEO;
    }

    public final synchronized void a(boolean z9, Handler handler, boolean z10, boolean z11, String str, String str2, String str3, String str4, String str5, int i10, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str6, String str7, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z12) {
        String str8;
        com.mbridge.msdk.video.signal.a.k kVar;
        String str9 = str4;
        synchronized (this) {
            this.f5032c = z12;
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str10 = str9 + "_" + str5;
            this.f5032c = z12;
            if (ak.i(str5)) {
                if (jVar != null) {
                    jVar.a(str10, str3, str9, str, str5, null);
                }
                return;
            }
            try {
                af.a("RewardCampaignsResourceManager", "开始预加载大模板资源");
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000154", campaignEx, eVar);
                a.C0071a c0071a = new a.C0071a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                if (campaignEx != null) {
                    windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
                }
                windVaneWebView.setTempTypeForMetrics(1);
                c0071a.a(windVaneWebView);
                String strA = com.mbridge.msdk.video.bt.a.d.c().a();
                String strA2 = com.mbridge.msdk.video.bt.a.d.c().a();
                c0071a.a(strA2);
                if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                    kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx);
                } else {
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(str9);
                    if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                        for (int i11 = 0; i11 < copyOnWriteArrayList.size(); i11++) {
                            CampaignEx campaignEx2 = copyOnWriteArrayList.get(i11);
                            for (CampaignEx campaignEx3 : copyOnWriteArrayListA) {
                                if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                    campaignEx2.setReady(true);
                                    copyOnWriteArrayList.set(i11, campaignEx2);
                                }
                            }
                        }
                    }
                    kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx, copyOnWriteArrayList);
                }
                kVar.a(i10);
                kVar.a(str7);
                kVar.c(strA2);
                kVar.d(strA);
                kVar.c(true);
                kVar.a(cVar);
                kVar.d(z9);
                com.mbridge.msdk.video.signal.a.k kVar2 = kVar;
                try {
                    str9 = str4;
                    str8 = str;
                    try {
                        windVaneWebView.setWebViewListener(new C0051b(z9, handler, null, z10, z11, i10, str5, str3, str4, str, c0071a, campaignEx, copyOnWriteArrayList, cVar, jVar, z12, jCurrentTimeMillis));
                        windVaneWebView.setObject(kVar2);
                        windVaneWebView.loadUrl(str6);
                        windVaneWebView.setRid(str8);
                        MBridgeBTRootLayout mBridgeBTRootLayout = new MBridgeBTRootLayout(com.mbridge.msdk.foundation.controller.c.m().c());
                        mBridgeBTRootLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        mBridgeBTRootLayout.setInstanceId(strA);
                        mBridgeBTRootLayout.setUnitId(str9);
                        MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().c());
                        mBridgeBTLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        mBridgeBTLayout.setInstanceId(strA2);
                        mBridgeBTLayout.setUnitId(str9);
                        mBridgeBTLayout.setWebView(windVaneWebView);
                        LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(str9, str8);
                        linkedHashMapB.put(strA2, mBridgeBTLayout);
                        linkedHashMapB.put(strA, mBridgeBTRootLayout);
                        mBridgeBTRootLayout.addView(mBridgeBTLayout, new FrameLayout.LayoutParams(-1, -1));
                    } catch (Exception e3) {
                        e = e3;
                        if (jVar != null) {
                            jVar.a(str10, str8, str5, null, b(880008, new MBridgeIds(str3, str9, str8), "", e, campaignEx));
                        }
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    str9 = str4;
                    str8 = str;
                }
            } catch (Exception e10) {
                e = e10;
                str8 = str;
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class d implements H5DownLoadManager.IH5SourceDownloadListener {

        /* renamed from: b, reason: collision with root package name */
        private int f5074b;

        /* renamed from: c, reason: collision with root package name */
        private final String f5075c;

        /* renamed from: d, reason: collision with root package name */
        private final String f5076d;
        private final String e;
        private CampaignEx f;
        private i g;
        private Handler h;

        /* renamed from: i, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f5077i;

        /* renamed from: a, reason: collision with root package name */
        private boolean f5073a = false;

        /* renamed from: j, reason: collision with root package name */
        private final long f5078j = System.currentTimeMillis();

        public d(int i10, String str, String str2, String str3, CampaignEx campaignEx, i iVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f5074b = i10;
            this.f5075c = str;
            this.f5076d = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = iVar;
            this.h = handler;
            this.f5077i = copyOnWriteArrayList;
        }

        private void a(final int i10, final long j10, final String str, final String str2, final String str3) {
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.f == null) {
                        return;
                    }
                    try {
                        n nVar = new n("m_download_end", i10, j10 + "", str, d.this.f.getId(), d.this.f5076d, str2, "2");
                        nVar.f(d.this.f.getRequestId());
                        nVar.s(d.this.f.getCurrentLocalRid());
                        nVar.g(d.this.f.getRequestIdNotice());
                        nVar.e(d.this.f.getId());
                        nVar.c(d.this.f.getAdSpaceT());
                        nVar.a("scenes", "1");
                        nVar.a("url", str);
                        if (d.this.f.getAdType() == 287) {
                            nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
                        } else if (d.this.f.getAdType() == 94) {
                            nVar.d("1");
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            nVar.t(str3);
                        }
                        b.a(nVar, d.this.f);
                        com.mbridge.msdk.foundation.same.report.g.a(nVar, d.this.f5076d, d.this.f);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
            int i10 = this.f5074b;
            if (i10 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5076d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f5075c);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                bundle.putString("message", str2);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i10 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5076d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f5075c);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.f5073a) {
                    a(3, System.currentTimeMillis() - this.f5078j, str, "url download failed", "");
                }
            } else if (i10 == 859) {
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 205;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5076d);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f5075c);
                bundle3.putString("request_id", this.e);
                bundle3.putString("message", str2);
                messageObtain3.setData(bundle3);
                this.h.sendMessage(messageObtain3);
                if (this.g != null) {
                    try {
                        this.g.a(str, this.e, b.b(880006, new MBridgeIds(this.f5075c, this.f5076d, this.e), str2, null, null));
                    } catch (Exception e) {
                        af.b("RewardCampaignsResourceManager", e.getMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onSuccess(String str, String str2, boolean z9) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            int i10 = this.f5074b;
            if (i10 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5076d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f5075c);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i10 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5076d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f5075c);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.f5073a) {
                    a(1, System.currentTimeMillis() - this.f5078j, str, "", str2);
                }
            } else if (i10 == 859) {
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 105;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5076d);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f5075c);
                bundle3.putString("request_id", this.e);
                messageObtain3.setData(bundle3);
                this.h.sendMessage(messageObtain3);
                i iVar = this.g;
                if (iVar != null) {
                    iVar.a(this.f5075c, this.f5076d, this.e, str);
                }
            }
        }

        public final void a(boolean z9) {
            this.f5073a = z9;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class g implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: b, reason: collision with root package name */
        private Context f5094b;

        /* renamed from: c, reason: collision with root package name */
        private String f5095c;

        /* renamed from: d, reason: collision with root package name */
        private String f5096d;
        private String e;
        private CampaignEx f;
        private int g;
        private Handler h;

        /* renamed from: i, reason: collision with root package name */
        private i f5097i;

        /* renamed from: j, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f5098j;

        /* renamed from: a, reason: collision with root package name */
        private boolean f5093a = false;

        /* renamed from: k, reason: collision with root package name */
        private long f5099k = System.currentTimeMillis();

        public g(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i10, Handler handler, i iVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f5094b = context;
            this.f5096d = str;
            this.f5095c = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = i10;
            this.h = handler;
            this.f5097i = iVar;
            this.f5098j = copyOnWriteArrayList;
        }

        private void a(final int i10, final long j10, final String str, final String str2, final String str3) {
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.f == null) {
                        return;
                    }
                    try {
                        n nVar = new n("m_download_end", i10, j10 + "", str, g.this.f.getId(), g.this.f5095c, str2, "1");
                        nVar.f(g.this.f.getRequestId());
                        nVar.s(g.this.f.getCurrentLocalRid());
                        nVar.g(g.this.f.getRequestIdNotice());
                        nVar.e(g.this.f.getId());
                        nVar.c(g.this.f.getAdSpaceT());
                        nVar.t(str3);
                        nVar.a("scenes", "1");
                        if (g.this.f.getAdType() == 287) {
                            nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
                        } else if (g.this.f.getAdType() == 94) {
                            nVar.d("1");
                        }
                        nVar.a("url", str);
                        nVar.e(3);
                        b.a(nVar, g.this.f);
                        com.mbridge.msdk.foundation.same.report.g.a(nVar, g.this.f5095c, g.this.f);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f5099k;
            int i10 = this.g;
            if (i10 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5095c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f5096d);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str2);
                bundle.putString("message", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i10 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5095c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f5096d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str2);
                bundle2.putString("message", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.f5093a) {
                    a(3, jCurrentTimeMillis, str2, "zip download failed", "");
                }
            } else if (i10 == 859) {
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 203;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5095c);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f5096d);
                bundle3.putString("request_id", this.e);
                bundle3.putString("url", str2);
                bundle3.putString("message", str);
                messageObtain3.setData(bundle3);
                this.h.sendMessage(messageObtain3);
                if (this.f5097i != null) {
                    try {
                        this.f5097i.a(str2, this.e, b.b(880006, new MBridgeIds(this.f5096d, this.f5095c, this.e), "", null, null));
                    } catch (Exception e) {
                        af.b("RewardCampaignsResourceManager", e.getMessage());
                    }
                }
                a(3, str2, str, "");
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onSuccess(String str, String str2, boolean z9) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f5099k;
            int i10 = this.g;
            if (i10 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5095c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f5096d);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i10 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5095c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f5096d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.f5093a) {
                    a(1, jCurrentTimeMillis, str, "", str2);
                    return;
                }
                return;
            }
            if (i10 != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 103;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5095c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f5096d);
            bundle3.putString("request_id", this.e);
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            i iVar = this.f5097i;
            if (iVar != null) {
                iVar.a(this.f5096d, this.f5095c, this.e, str);
            }
            if (z9) {
                return;
            }
            a(1, str, "", str2);
        }

        public final void a(boolean z9) {
            this.f5093a = z9;
        }

        private void a(final int i10, final String str, final String str2, final String str3) {
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.f == null || g.this.f5094b == null) {
                        return;
                    }
                    try {
                        n nVar = new n();
                        nVar.a("m_download_end");
                        if (g.this.f5094b != null) {
                            nVar.a(ab.m(g.this.f5094b.getApplicationContext()));
                        }
                        nVar.b(i10);
                        if (g.this.f != null) {
                            nVar.e(g.this.f.getId());
                            nVar.f(g.this.f.getRequestId());
                            nVar.s(g.this.f.getCurrentLocalRid());
                            nVar.g(g.this.f.getRequestIdNotice());
                        }
                        nVar.q(str);
                        nVar.h(str2);
                        nVar.c(g.this.f5095c);
                        if (!TextUtils.isEmpty(str3)) {
                            nVar.t(str3);
                        }
                        nVar.e(2);
                        nVar.a("scenes", "1");
                        nVar.a("url", str);
                        b.a(nVar, g.this.f);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, g.this.f);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                }
            });
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class h extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private Context f5108a;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<String, c> f5109b;

        /* renamed from: c, reason: collision with root package name */
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f5110c;

        public h(Looper looper) {
            super(looper);
            this.f5109b = new ConcurrentHashMap<>();
            this.f5110c = new ConcurrentHashMap<>();
        }

        public final void a(String str, String str2, String str3, c cVar) {
            this.f5109b.put(str2 + "_" + str3, cVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean zA;
            Bundle data = message.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString("request_id");
            String strJ = a3.a.j(string2, "_", string3);
            a aVar = (a) b.f5030b.get(strJ);
            c cVar = this.f5109b.get(strJ);
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f5110c.get(strJ);
            int i10 = message.what;
            switch (i10) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                    break;
                default:
                    switch (i10) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar != null && cVar != null) {
                                String string4 = data.getString("message");
                                if (string4 == null) {
                                    string4 = "";
                                }
                                int i11 = message.what;
                                int i12 = i11 != 200 ? i11 != 201 ? i11 != 203 ? i11 != 205 ? 880024 : 880005 : 880006 : 880007 : 880004;
                                String str = "resource download failed " + b.b(message.what) + " " + string4;
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = aVar.h;
                                CampaignEx campaignEx = (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) ? null : aVar.h.get(0);
                                try {
                                    if (!aVar.f5053a || aVar.f5057i == null) {
                                        CampaignEx campaignEx2 = campaignEx;
                                        if (com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.e, aVar.f5054b, aVar.f5056d, aVar.f5053a, aVar.f5055c, copyOnWriteArrayList)) {
                                            cVar.a(string, string2, string3, aVar.h);
                                        } else {
                                            if (campaignEx2 != null && campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0) {
                                                int i13 = message.what;
                                                if (i13 != 200) {
                                                    if (i13 != 201) {
                                                        if (i13 != 203) {
                                                            if (i13 == 205 && campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                                                break;
                                                            }
                                                        } else if (campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                                                            break;
                                                        }
                                                    } else if (campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                                                        break;
                                                    }
                                                } else if (campaignEx2.getRsIgnoreCheckRule().contains(0)) {
                                                    break;
                                                }
                                            }
                                            cVar.a(aVar.h, b.b(i12, new MBridgeIds(string, string2, string3), str, null, null));
                                        }
                                        this.f5109b.remove(strJ);
                                        b.f5030b.remove(strJ);
                                        this.f5110c.remove(strJ);
                                        break;
                                    } else {
                                        CampaignEx campaignEx3 = campaignEx;
                                        if (aVar.f5055c == 1) {
                                            if (campaignEx3 != null && campaignEx3.getRsIgnoreCheckRule() != null && campaignEx3.getRsIgnoreCheckRule().size() > 0) {
                                                int i14 = message.what;
                                                if (i14 == 200) {
                                                    if (campaignEx3.getRsIgnoreCheckRule().contains(0)) {
                                                        break;
                                                    }
                                                } else if (i14 == 201) {
                                                    if (campaignEx3.getRsIgnoreCheckRule().contains(2)) {
                                                        break;
                                                    }
                                                } else if (i14 == 203) {
                                                    if (campaignEx3.getRsIgnoreCheckRule().contains(1)) {
                                                        break;
                                                    }
                                                } else if (i14 == 205) {
                                                    if (campaignEx3.getRsIgnoreCheckRule().contains(3)) {
                                                        break;
                                                    } else {
                                                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = aVar.h;
                                                        if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                                                            CampaignEx campaignEx4 = aVar.h.get(0);
                                                            if (campaignEx4.getCMPTEntryUrl().equals(campaignEx4.getendcard_url()) && campaignEx3.getRsIgnoreCheckRule().contains(2)) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            cVar.a(aVar.h, b.b(i12, new MBridgeIds(string, string2, string3), str, null, null));
                                            this.f5109b.remove(strJ);
                                            b.f5030b.remove(strJ);
                                            this.f5110c.remove(strJ);
                                            break;
                                        } else {
                                            String string5 = data.getString("url");
                                            int i15 = message.what;
                                            if (i15 == 200) {
                                                if (campaignEx3 != null && campaignEx3.getRsIgnoreCheckRule() != null && campaignEx3.getRsIgnoreCheckRule().size() > 0 && campaignEx3.getRsIgnoreCheckRule().contains(0)) {
                                                    af.c("RewardCampaignsResourceManager", "Is TPL but  video download fail but hit ignoreCheckRule");
                                                    break;
                                                } else {
                                                    for (int i16 = 0; i16 < aVar.f5057i.size(); i16++) {
                                                        if (aVar.f5057i.get(i16).getVideoUrlEncode().equals(string5)) {
                                                            aVar.f5057i.remove(i16);
                                                        }
                                                    }
                                                    b.f5030b.remove(strJ);
                                                    b.f5030b.put(strJ, aVar);
                                                }
                                            } else if (i15 == 201) {
                                                if (campaignEx3 != null && campaignEx3.getRsIgnoreCheckRule() != null && campaignEx3.getRsIgnoreCheckRule().size() > 0 && campaignEx3.getRsIgnoreCheckRule().contains(2)) {
                                                    af.c("RewardCampaignsResourceManager", "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                    break;
                                                } else {
                                                    for (int i17 = 0; i17 < aVar.f5057i.size(); i17++) {
                                                        CampaignEx campaignEx5 = aVar.f5057i.get(i17);
                                                        if (campaignEx5.getRewardTemplateMode() != null && campaignEx5.getRewardTemplateMode().c().equals(string5)) {
                                                            aVar.f5057i.remove(i17);
                                                        }
                                                        if (!TextUtils.isEmpty(campaignEx5.getendcard_url()) && campaignEx5.getendcard_url().equals(string5)) {
                                                            aVar.f5057i.remove(i17);
                                                        }
                                                    }
                                                    b.f5030b.remove(strJ);
                                                    b.f5030b.put(strJ, aVar);
                                                }
                                            } else if (i15 == 203) {
                                                if (campaignEx3 != null && campaignEx3.getRsIgnoreCheckRule() != null && campaignEx3.getRsIgnoreCheckRule().size() > 0 && campaignEx3.getRsIgnoreCheckRule().contains(1)) {
                                                    af.c("RewardCampaignsResourceManager", "Is TPL but download template fail but hit ignoreCheckRule");
                                                    break;
                                                } else {
                                                    for (int i18 = 0; i18 < aVar.f5057i.size(); i18++) {
                                                        CampaignEx campaignEx6 = aVar.f5057i.get(i18);
                                                        if (campaignEx6.getRewardTemplateMode() != null && campaignEx6.getRewardTemplateMode().e().equals(string5)) {
                                                            aVar.f5057i.remove(i18);
                                                        }
                                                    }
                                                    b.f5030b.remove(strJ);
                                                    b.f5030b.put(strJ, aVar);
                                                }
                                            } else if (i15 == 205) {
                                                if (campaignEx3 != null && campaignEx3.getRsIgnoreCheckRule() != null && campaignEx3.getRsIgnoreCheckRule().size() > 0 && campaignEx3.getRsIgnoreCheckRule().contains(3)) {
                                                    af.c("RewardCampaignsResourceManager", "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                    break;
                                                } else {
                                                    aVar.f5057i.clear();
                                                    b.f5030b.remove(strJ);
                                                    b.f5030b.put(strJ, aVar);
                                                }
                                            }
                                            if (com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.e, aVar.f5054b, aVar.f5056d, aVar.f5053a, aVar.f5055c, copyOnWriteArrayList)) {
                                                cVar.a(string, string2, string3, aVar.h);
                                                this.f5109b.remove(strJ);
                                                b.f5030b.remove(strJ);
                                                this.f5110c.remove(strJ);
                                                break;
                                            } else if (aVar.f5057i.size() == 0) {
                                                cVar.a(aVar.h, b.b(i12, new MBridgeIds(string, string2, string3), str, null, null));
                                                this.f5109b.remove(strJ);
                                                b.f5030b.remove(strJ);
                                                this.f5110c.remove(strJ);
                                                break;
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    cVar.a(aVar.h, b.b(i12, new MBridgeIds(string, string2, string3), str, e, null));
                                    return;
                                }
                            }
                            break;
                    }
                    return;
            }
            if (aVar == null || cVar == null) {
                return;
            }
            try {
                zA = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.e, aVar.f5054b, aVar.f5056d, aVar.f5053a, aVar.f5055c, copyOnWriteArrayList);
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                }
                zA = false;
            }
            if (zA) {
                cVar.a(string, string2, string3, aVar.h);
                this.f5109b.remove(strJ);
                b.f5030b.remove(strJ);
                this.f5110c.remove(strJ);
            }
        }

        public final void a(Context context) {
            this.f5108a = context;
        }

        public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f5110c.put(str, copyOnWriteArrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.mbridge.msdk.foundation.c.b b(int i10, MBridgeIds mBridgeIds, String str, Throwable th, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(i10);
        bVar.a(mBridgeIds);
        bVar.a(th);
        bVar.a(str);
        bVar.a(campaignEx);
        return bVar;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class f implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        private Handler f5089a;

        /* renamed from: b, reason: collision with root package name */
        private final String f5090b;

        /* renamed from: c, reason: collision with root package name */
        private final String f5091c;

        /* renamed from: d, reason: collision with root package name */
        private final String f5092d;

        public f(Handler handler, String str, String str2, String str3) {
            this.f5089a = handler;
            this.f5091c = str;
            this.f5090b = str2;
            this.f5092d = str3;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str, String str2) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str2, false);
            Message messageObtain = Message.obtain();
            messageObtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5090b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f5091c);
            bundle.putString("request_id", this.f5092d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            messageObtain.setData(bundle);
            this.f5089a.sendMessage(messageObtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5090b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f5091c);
            bundle.putString("request_id", this.f5092d);
            bundle.putString("url", str);
            messageObtain.setData(bundle);
            this.f5089a.sendMessage(messageObtain);
        }
    }

    public static b a() {
        return m.f5140a;
    }

    public final synchronized void a(final Context context, boolean z9, int i10, boolean z10, final int i11, final String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, c cVar, final i iVar) {
        String str4 = str2 + "_" + str3;
        f5030b.put(str4, new a(z9, z10, i10, copyOnWriteArrayList.size(), str2, str3, i11, copyOnWriteArrayList));
        this.f5031a.a(str, str2, str3, cVar);
        this.f5031a.a(context);
        this.f5031a.a(str4, copyOnWriteArrayList);
        this.f5031a.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.1
            /* JADX WARN: Removed duplicated region for block: B:114:0x028e  */
            /* JADX WARN: Removed duplicated region for block: B:181:0x025f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:193:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x014e  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x01a2  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x0206  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() throws java.security.NoSuchAlgorithmException {
                /*
                    Method dump skipped, instructions count: 910
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.AnonymousClass1.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i10, final CampaignEx campaignEx, String str, String str2) {
        com.mbridge.msdk.foundation.tools.o.a(i10, str, str2, new o.a() { // from class: com.mbridge.msdk.reward.adapter.b.2
            @Override // com.mbridge.msdk.foundation.tools.o.a
            public final void a(String str3, DownloadError downloadError) {
                String message = "";
                if (downloadError != null) {
                    try {
                        if (downloadError.getException() != null) {
                            message = downloadError.getException().getMessage();
                        }
                    } catch (Exception e3) {
                        if (MBridgeConstans.DEBUG) {
                            e3.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                n nVar = new n();
                int i11 = i10;
                if (i11 == 0) {
                    nVar.e(1);
                    nVar.b(3);
                    nVar.a("m_download_end");
                } else if (i11 == 1) {
                    nVar.e(2);
                    nVar.b(3);
                    nVar.a("m_download_end");
                } else if (i11 == 2) {
                    nVar.e(3);
                    nVar.b(3);
                    nVar.a("m_download_end");
                    nVar.d(campaignEx.isMraid() ? n.f3580a : n.f3581b);
                    nVar.o("1");
                }
                b.a(nVar, campaignEx);
                nVar.g(campaignEx.getRequestIdNotice());
                nVar.h(message);
                nVar.a("scenes", "1");
                nVar.a("url", str3);
                com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
            }

            @Override // com.mbridge.msdk.foundation.tools.o.a
            public final void a(String str3, String str4, String str5, String str6, boolean z9) {
                if (z9) {
                    return;
                }
                try {
                    n nVar = new n();
                    int i11 = i10;
                    if (i11 == 0) {
                        nVar.e(1);
                        nVar.b(1);
                        nVar.a("m_download_end");
                    } else if (i11 == 1) {
                        nVar.e(2);
                        nVar.b(1);
                        nVar.a("m_download_end");
                    } else if (i11 == 2) {
                        nVar.e(3);
                        nVar.b(1);
                        nVar.a("m_download_end");
                        nVar.d(campaignEx.isMraid() ? n.f3580a : n.f3581b);
                        nVar.o("1");
                    }
                    nVar.g(campaignEx.getRequestIdNotice());
                    nVar.a("url", str3);
                    nVar.a("scenes", "1");
                    com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardCampaignsResourceManager", e3.getMessage());
                    }
                }
            }
        }, campaignEx);
    }

    public final synchronized void a(final Context context, final CampaignEx campaignEx, final String str, final String str2, final String str3, final i iVar) {
        try {
            this.f5031a.a(context);
            if (campaignEx != null) {
                String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
                if (campaignEx.isDynamicView()) {
                    if (ak.a("dyview", cMPTEntryUrl)) {
                        a(0, campaignEx, campaignEx.getMof_tplid() + "", cMPTEntryUrl);
                    }
                    ResDownloadCheckManager.getInstance().setZipDownloadDone(cMPTEntryUrl, true);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 105;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString("request_id", str3);
                    bundle.putString("url", cMPTEntryUrl);
                    messageObtain.setData(bundle);
                    this.f5031a.sendMessage(messageObtain);
                    if (iVar != null) {
                        iVar.a(str, str2, str3, cMPTEntryUrl);
                    }
                    return;
                }
            }
            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                try {
                    com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.foundation.same.report.d.d.a().a(campaignEx.getCurrentLocalRid(), "");
                    if (cVarA == null) {
                        cVarA = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    com.mbridge.msdk.foundation.same.report.d.c cVar = cVarA;
                    cVar.a(campaignEx);
                    cVar.a(1);
                    cVar.c(a(campaignEx));
                    H5DownLoadManager.getInstance().downloadH5Res(cVar, campaignEx.getCMPTEntryUrl(), new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.reward.adapter.b.3
                        /* JADX WARN: Removed duplicated region for block: B:31:0x0101  */
                        /* JADX WARN: Removed duplicated region for block: B:44:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final void onFailed(java.lang.String r21, java.lang.String r22) {
                            /*
                                Method dump skipped, instructions count: 278
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.AnonymousClass3.onFailed(java.lang.String, java.lang.String):void");
                        }

                        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
                        public final void onSuccess(String str4, String str5, boolean z9) {
                            try {
                                af.a("RewardCampaignsResourceManager", "zip btl template download success");
                                ResDownloadCheckManager.getInstance().setZipDownloadDone(str4, true);
                                Message messageObtain2 = Message.obtain();
                                messageObtain2.what = 105;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle2.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle2.putString("request_id", str3);
                                bundle2.putString("url", str4);
                                messageObtain2.setData(bundle2);
                                b.this.f5031a.sendMessage(messageObtain2);
                                i iVar2 = iVar;
                                if (iVar2 != null) {
                                    iVar2.a(str, str2, str3, str4);
                                }
                                if (z9) {
                                    return;
                                }
                                b.a(b.this, context, 1, campaignEx, str4, "", str2, str5);
                            } catch (Exception e3) {
                                ResDownloadCheckManager.getInstance().setZipDownloadDone(str4, false);
                                Message messageObtain3 = Message.obtain();
                                messageObtain3.what = 205;
                                Bundle bundle3 = new Bundle();
                                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle3.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle3.putString("request_id", str3);
                                bundle3.putString("url", str4);
                                messageObtain3.setData(bundle3);
                                b.this.f5031a.sendMessage(messageObtain3);
                                if (iVar != null) {
                                    try {
                                        iVar.a(str4, str3, b.b(880005, new MBridgeIds(str, str2, str3), "", e3, null));
                                    } catch (Exception e7) {
                                        af.b("RewardCampaignsResourceManager", e7.getMessage());
                                    }
                                }
                                b.a(b.this, context, 3, campaignEx, str4, e3.getLocalizedMessage(), str2, str5);
                                if (MBridgeConstans.DEBUG) {
                                    af.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                                }
                            }
                        }
                    });
                } catch (Exception e3) {
                    af.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(boolean z9, Handler handler, boolean z10, boolean z11, WindVaneWebView windVaneWebView, String str, int i10, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str2, String str3, String str4, String str5, String str6, com.mbridge.msdk.videocommon.d.c cVar, j jVar) {
        String str7;
        String str8;
        a.C0071a c0071a;
        com.mbridge.msdk.video.signal.a.k kVar;
        String str9 = str4;
        synchronized (this) {
            String str10 = str9 + "_" + str;
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
            } catch (Exception e3) {
                e = e3;
                str7 = str5;
                str8 = str10;
            }
            if (ak.i(str)) {
                if (jVar != null) {
                    try {
                        jVar.a(str10, str3, str9, str5, str, null);
                    } catch (Exception e7) {
                        e = e7;
                        str8 = str10;
                    }
                }
                return;
            }
            str8 = str10;
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000154", campaignEx, eVar);
                c0071a = new a.C0071a();
            } catch (Exception e10) {
                e = e10;
            }
            try {
                try {
                    WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                    if (campaignEx != null) {
                        windVaneWebView2.setLocalRequestId(campaignEx.getCurrentLocalRid());
                    }
                    windVaneWebView2.setTempTypeForMetrics(2);
                    try {
                        c0071a.a(windVaneWebView2);
                        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                            kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx, copyOnWriteArrayList);
                        } else {
                            kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx);
                        }
                        com.mbridge.msdk.video.signal.a.k kVar2 = kVar;
                        kVar2.a(i10);
                        kVar2.a(str9);
                        kVar2.a(cVar);
                        kVar2.d(z9);
                        str7 = str5;
                        try {
                            windVaneWebView2.setWebViewListener(new k(handler, null, z10, z11, str7, jVar, windVaneWebView, str, str3, str9, c0071a, campaignEx, copyOnWriteArrayList, jCurrentTimeMillis));
                            windVaneWebView2.setObject(kVar2);
                            windVaneWebView2.loadUrl(str2);
                            windVaneWebView2.setRid(str7);
                        } catch (Exception e11) {
                            e = e11;
                            str9 = str9;
                        }
                    } catch (Exception e12) {
                        e = e12;
                    }
                } catch (Exception e13) {
                    e = e13;
                }
            } catch (Exception unused) {
                if (jVar != null) {
                    c0071a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str9 + "_" + str5 + "_" + str, true);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str9);
                    sb.append("_");
                    sb.append(str);
                    jVar.a(sb.toString(), str3, str9, str5, str, c0071a);
                    return;
                }
                return;
            } catch (Throwable unused2) {
                if (jVar != null) {
                    c0071a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str9 + "_" + str5 + "_" + str, true);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str9);
                    sb2.append("_");
                    sb2.append(str);
                    jVar.a(sb2.toString(), str3, str9, str5, str, c0071a);
                    return;
                }
                return;
            }
            str7 = str5;
            if (MBridgeConstans.DEBUG) {
                af.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
            }
            if (jVar != null) {
                jVar.a(str8, str7, str, null, b(880009, new MBridgeIds(str3, str9, str7), "", e, campaignEx));
            }
        }
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAabEntity() != null) {
                    return campaignEx.getAabEntity().h3c;
                }
            } catch (Throwable th) {
                af.b("RewardCampaignsResourceManager", th.getMessage());
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.d.c a(CampaignEx campaignEx, int i10) {
        com.mbridge.msdk.foundation.same.report.d.c cVarA = campaignEx != null ? com.mbridge.msdk.foundation.same.report.d.d.a().a(campaignEx.getCurrentLocalRid(), "") : null;
        if (cVarA == null) {
            cVarA = new com.mbridge.msdk.foundation.same.report.d.c();
        }
        cVarA.a(campaignEx);
        cVarA.c(a(campaignEx));
        cVarA.a(i10);
        return cVarA;
    }

    public static /* synthetic */ void a(b bVar, Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, i iVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        if (TextUtils.isEmpty(str4) || campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.d.c cVarA = bVar.a(campaignEx, 3);
        if (str4.contains(".zip") && str4.contains(ResourceManager.KEY_MD5FILENAME)) {
            boolean zIsEmpty = TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str4));
            try {
                g gVar = new g(context, str, str2, str3, campaignEx, 497, bVar.f5031a, iVar, copyOnWriteArrayList);
                gVar.a(zIsEmpty);
                H5DownLoadManager.getInstance().downloadH5Res(cVarA, str4, gVar);
                return;
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean zIsEmpty2 = TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str4));
        try {
            d dVar = new d(497, str, str2, str3, campaignEx, iVar, bVar.f5031a, copyOnWriteArrayList);
            dVar.a(zIsEmpty2);
            H5DownLoadManager.getInstance().downloadH5Res(cVarA, str4, dVar);
        } catch (Exception e7) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardCampaignsResourceManager", e7.getLocalizedMessage());
            }
        }
    }

    public static /* synthetic */ void a(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignEx.getCampaignUnitId());
            if (cVarA != null) {
                nVar.v(cVarA.l());
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB != null) {
                nVar.u(aVarB.c());
            }
        } catch (Exception e3) {
            af.b("RewardCampaignsResourceManager", e3.getMessage());
        }
    }

    public static /* synthetic */ void a(b bVar, final Context context, final int i10, final CampaignEx campaignEx, final String str, final String str2, final String str3, final String str4) {
        com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.4
            @Override // java.lang.Runnable
            public final void run() {
                if (campaignEx == null || context == null) {
                    return;
                }
                try {
                    n nVar = new n();
                    nVar.a("m_download_end");
                    Context context2 = context;
                    if (context2 != null) {
                        nVar.a(ab.m(context2.getApplicationContext()));
                    }
                    nVar.b(i10);
                    CampaignEx campaignEx2 = campaignEx;
                    if (campaignEx2 != null) {
                        nVar.e(campaignEx2.getId());
                        nVar.f(campaignEx.getRequestId());
                        nVar.s(campaignEx.getCurrentLocalRid());
                        nVar.g(campaignEx.getRequestIdNotice());
                    }
                    nVar.a("url", str);
                    nVar.q(str);
                    nVar.h(str2);
                    nVar.c(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        nVar.t(str4);
                    }
                    nVar.e(1);
                    nVar.a("scenes", "1");
                    com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                    }
                }
            }
        });
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class k extends com.mbridge.msdk.mbsignalcommon.b.b {

        /* renamed from: a, reason: collision with root package name */
        private Handler f5111a;

        /* renamed from: b, reason: collision with root package name */
        private Runnable f5112b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f5113c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f5114d;
        private String e;
        private final j f;
        private final WindVaneWebView g;
        private final String h;

        /* renamed from: i, reason: collision with root package name */
        private final String f5115i;

        /* renamed from: j, reason: collision with root package name */
        private final String f5116j;

        /* renamed from: k, reason: collision with root package name */
        private final a.C0071a f5117k;

        /* renamed from: l, reason: collision with root package name */
        private final CampaignEx f5118l;

        /* renamed from: m, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f5119m;

        /* renamed from: n, reason: collision with root package name */
        private long f5120n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f5121o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f5122p;

        /* renamed from: q, reason: collision with root package name */
        private final Runnable f5123q;

        /* renamed from: r, reason: collision with root package name */
        private final Runnable f5124r;

        public k(Handler handler, Runnable runnable, boolean z9, boolean z10, final String str, final j jVar, WindVaneWebView windVaneWebView, final String str2, final String str3, final String str4, final a.C0071a c0071a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, long j10) {
            this.f5111a = handler;
            this.f5112b = runnable;
            this.f5113c = z9;
            this.f5114d = z10;
            this.e = str;
            this.f = jVar;
            this.g = windVaneWebView;
            this.h = str2;
            this.f5115i = str4;
            this.f5116j = str3;
            this.f5117k = c0071a;
            this.f5118l = campaignEx;
            this.f5119m = copyOnWriteArrayList;
            this.f5120n = j10;
            Runnable runnable2 = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView windVaneWebViewA;
                    a.C0071a c0071a2;
                    if (jVar != null && (c0071a2 = c0071a) != null) {
                        c0071a2.a(true);
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str4 + "_" + str + "_" + str2, true);
                        j jVar2 = jVar;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append("_");
                        sb.append(str2);
                        jVar2.a(sb.toString(), str3, str4, str, str2, c0071a);
                    }
                    a.C0071a c0071a3 = c0071a;
                    if (c0071a3 == null || (windVaneWebViewA = c0071a3.a()) == null) {
                        return;
                    }
                    try {
                        windVaneWebViewA.release();
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("WindVaneWebView", e.getMessage());
                        }
                    }
                }
            };
            this.f5124r = runnable2;
            this.f5123q = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView windVaneWebViewA;
                    a.C0071a c0071a2;
                    if (jVar != null && (c0071a2 = c0071a) != null) {
                        c0071a2.a(true);
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str4 + "_" + str + "_" + str2, true);
                        j jVar2 = jVar;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append("_");
                        sb.append(str2);
                        jVar2.a(sb.toString(), str3, str4, str, str2, c0071a);
                    }
                    a.C0071a c0071a3 = c0071a;
                    if (c0071a3 == null || (windVaneWebViewA = c0071a3.a()) == null) {
                        return;
                    }
                    try {
                        windVaneWebViewA.release();
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("WindVaneWebView", e.getMessage());
                        }
                    }
                }
            };
            if (handler != null) {
                handler.postDelayed(runnable2, 5000L);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i10) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i10);
            Handler handler2 = this.f5111a;
            if (handler2 != null && (runnable2 = this.f5123q) != null) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.f5111a;
            if (handler3 != null && (runnable = this.f5124r) != null) {
                handler3.removeCallbacks(runnable);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                eVar.a("result", Integer.valueOf(i10));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.f5118l, eVar);
            } catch (Throwable th) {
                af.b("WindVaneWebView", th.getMessage());
            }
            if (this.f5122p) {
                return;
            }
            String str = this.f5115i + "_" + this.h;
            if (i10 == 1) {
                Runnable runnable3 = this.f5112b;
                if (runnable3 != null && (handler = this.f5111a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f5115i + "_" + this.e + "_" + this.h, true);
                a.C0071a c0071a = this.f5117k;
                if (c0071a != null) {
                    c0071a.a(true);
                }
                boolean z9 = this.f5113c;
                boolean z10 = this.f5114d;
                if (z9) {
                    CampaignEx campaignEx = this.f5118l;
                    if (z10) {
                        com.mbridge.msdk.videocommon.a.a(287, campaignEx.getRequestIdNotice(), this.f5117k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(287, campaignEx.getRequestIdNotice(), this.f5117k);
                    }
                } else {
                    CampaignEx campaignEx2 = this.f5118l;
                    if (z10) {
                        com.mbridge.msdk.videocommon.a.a(94, campaignEx2.getRequestIdNotice(), this.f5117k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, campaignEx2.getRequestIdNotice(), this.f5117k);
                    }
                }
                j jVar = this.f;
                if (jVar != null) {
                    jVar.a(str, this.f5116j, this.f5115i, this.e, this.h, this.f5117k);
                }
            } else if (this.f != null) {
                this.f.a(str, this.e, this.h, this.f5117k, b.b(880009, new MBridgeIds(this.f5116j, this.f5115i, this.e), a3.a.f(i10, "readyState:"), null, this.f5118l));
            }
            this.f5122p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i10, String str, String str2) {
            super.a(webView, i10, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f5115i + "_" + this.e + "_" + this.h, false);
            Handler handler = this.f5111a;
            if (handler != null) {
                if (this.f5123q != null) {
                    handler.removeCallbacks(this.f5124r);
                }
                Runnable runnable = this.f5123q;
                if (runnable != null) {
                    this.f5111a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.f5115i + "_" + this.h;
                a.C0071a c0071a = this.f5117k;
                if (c0071a != null) {
                    c0071a.a(false);
                }
                if (this.f != null) {
                    this.f.a(str3, this.e, str2, this.f5117k, b.b(880009, new MBridgeIds(this.f5116j, this.f5115i, this.e), i10 + "#" + str, null, this.f5118l));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f5115i + "_" + this.e + "_" + this.h, false);
            Handler handler = this.f5111a;
            if (handler != null) {
                if (this.f5123q != null) {
                    handler.removeCallbacks(this.f5124r);
                }
                Runnable runnable = this.f5123q;
                if (runnable != null) {
                    this.f5111a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.f5115i + "_" + this.h;
                a.C0071a c0071a = this.f5117k;
                if (c0071a != null) {
                    c0071a.a(false);
                }
                if (this.f != null) {
                    MBridgeIds mBridgeIds = new MBridgeIds(this.f5116j, this.f5115i, this.e);
                    StringBuilder sb = new StringBuilder("onReceivedSslError:");
                    sb.append(sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError()));
                    this.f.a(str, this.e, this.h, this.f5117k, b.b(880009, mBridgeIds, sb.toString(), null, this.f5118l));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.f5111a;
            if (handler2 != null && (runnable2 = this.f5124r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.f5121o) {
                return;
            }
            if (!str.contains("wfr=1")) {
                String str2 = this.f5115i + "_" + this.h;
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f5115i + "_" + this.e + "_" + this.h, true);
                Runnable runnable3 = this.f5112b;
                if (runnable3 != null && (handler = this.f5111a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                a.C0071a c0071a = this.f5117k;
                if (c0071a != null) {
                    c0071a.a(true);
                }
                boolean z9 = this.f5113c;
                CampaignEx campaignEx = this.f5118l;
                if (z9) {
                    boolean zIsBidCampaign = campaignEx.isBidCampaign();
                    CampaignEx campaignEx2 = this.f5118l;
                    if (zIsBidCampaign) {
                        com.mbridge.msdk.videocommon.a.a(287, campaignEx2.getRequestIdNotice(), this.f5117k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(287, campaignEx2.getRequestIdNotice(), this.f5117k);
                    }
                } else {
                    boolean zIsBidCampaign2 = campaignEx.isBidCampaign();
                    CampaignEx campaignEx3 = this.f5118l;
                    if (zIsBidCampaign2) {
                        com.mbridge.msdk.videocommon.a.a(94, campaignEx3.getRequestIdNotice(), this.f5117k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, campaignEx3.getRequestIdNotice(), this.f5117k);
                    }
                }
                j jVar = this.f;
                if (jVar != null) {
                    jVar.a(str2, this.f5116j, this.f5115i, this.e, this.h, this.f5117k);
                }
            } else {
                Handler handler3 = this.f5111a;
                if (handler3 != null && (runnable = this.f5123q) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.f5121o = true;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class l extends com.mbridge.msdk.mbsignalcommon.b.b {

        /* renamed from: a, reason: collision with root package name */
        private String f5133a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f5134b;

        /* renamed from: c, reason: collision with root package name */
        private final WindVaneWebView f5135c;

        /* renamed from: d, reason: collision with root package name */
        private final String f5136d;
        private final String e;
        private final a.C0071a f;
        private final CampaignEx g;
        private boolean h;

        /* renamed from: i, reason: collision with root package name */
        private String f5137i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f5138j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f5139k;

        public l(String str, boolean z9, WindVaneWebView windVaneWebView, String str2, String str3, a.C0071a c0071a, CampaignEx campaignEx, boolean z10, String str4) {
            this.f5134b = z9;
            this.f5135c = windVaneWebView;
            this.f5136d = str2;
            this.e = str3;
            this.f = c0071a;
            this.g = campaignEx;
            this.f5133a = str;
            this.h = z10;
            this.f5137i = str4;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i10) throws JSONException {
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                eVar.a("result", Integer.valueOf(i10));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.g, eVar);
            } catch (Throwable th) {
                af.b("WindVaneWebView", th.getMessage());
            }
            if (this.f5139k) {
                return;
            }
            if (this.f5135c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f5133a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i10);
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "");
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f5135c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
            String str = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.f5136d;
            if (i10 == 1) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.f5137i + "_" + this.f5136d, true);
                a.C0071a c0071a = this.f;
                if (c0071a != null) {
                    c0071a.a(true);
                }
                boolean z9 = this.f5134b;
                CampaignEx campaignEx = this.g;
                if (z9) {
                    boolean zIsBidCampaign = campaignEx.isBidCampaign();
                    a.C0071a c0071a2 = this.f;
                    if (zIsBidCampaign) {
                        com.mbridge.msdk.videocommon.a.a(str, c0071a2, false, this.h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, c0071a2, false, this.h);
                    }
                } else {
                    boolean zIsBidCampaign2 = campaignEx.isBidCampaign();
                    a.C0071a c0071a3 = this.f;
                    if (zIsBidCampaign2) {
                        com.mbridge.msdk.videocommon.a.a(str, c0071a3, false, this.h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, c0071a3, false, this.h);
                    }
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.f5137i + "_" + this.f5136d, false);
                a.C0071a c0071a4 = this.f;
                if (c0071a4 != null) {
                    c0071a4.a(false);
                }
            }
            this.f5139k = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i10, String str, String str2) throws JSONException {
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.f5137i + "_" + this.f5136d, false);
            a.C0071a c0071a = this.f;
            if (c0071a != null) {
                c0071a.a(false);
            }
            if (this.f5135c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f5133a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f5135c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) throws JSONException {
            if (this.f5138j) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.f5135c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f5133a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "");
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f5135c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("WindVaneWebView", e.getLocalizedMessage());
                        }
                    }
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.f5137i + "_" + this.f5136d, true);
                a.C0071a c0071a = this.f;
                if (c0071a != null) {
                    c0071a.a(true);
                }
                String str2 = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.f5136d;
                boolean z9 = this.f5134b;
                CampaignEx campaignEx = this.g;
                if (z9) {
                    if (campaignEx.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(287, this.g.getRequestIdNotice(), this.f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                    }
                } else if (campaignEx.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.g.getRequestIdNotice(), this.f);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.f5138j = true;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.reward.adapter.b$b, reason: collision with other inner class name */
    public static class C0051b extends com.mbridge.msdk.mbsignalcommon.b.a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f5058a;

        /* renamed from: b, reason: collision with root package name */
        private final Runnable f5059b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f5060c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f5061d;
        private int e;
        private String f;
        private String g;
        private String h;

        /* renamed from: i, reason: collision with root package name */
        private String f5062i;

        /* renamed from: j, reason: collision with root package name */
        private a.C0071a f5063j;

        /* renamed from: k, reason: collision with root package name */
        private CampaignEx f5064k;

        /* renamed from: l, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f5065l;

        /* renamed from: m, reason: collision with root package name */
        private com.mbridge.msdk.videocommon.d.c f5066m;

        /* renamed from: n, reason: collision with root package name */
        private final j f5067n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f5068o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f5069p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f5070q;

        /* renamed from: r, reason: collision with root package name */
        private int f5071r = 0;

        /* renamed from: s, reason: collision with root package name */
        private boolean f5072s;
        private long t;

        public C0051b(boolean z9, Handler handler, Runnable runnable, boolean z10, boolean z11, int i10, String str, String str2, String str3, String str4, a.C0071a c0071a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z12, long j10) {
            this.f5058a = handler;
            this.f5059b = runnable;
            this.f5060c = z10;
            this.f5061d = z11;
            this.e = i10;
            this.f = str;
            this.h = str2;
            this.g = str3;
            this.f5062i = str4;
            this.f5063j = c0071a;
            this.f5064k = campaignEx;
            this.f5065l = copyOnWriteArrayList;
            this.f5066m = cVar;
            this.f5067n = jVar;
            this.f5068o = z12;
            this.f5072s = z9;
            this.t = j10;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a
        public final void a(Object obj, String str) {
            if (obj != null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    final String strOptString = new JSONObject(str).optString("id");
                    com.mbridge.msdk.video.bt.a.d.c().a(obj, strOptString);
                    final String strC = com.mbridge.msdk.video.bt.a.d.c().c(strOptString);
                    final CampaignEx campaignExA = com.mbridge.msdk.video.bt.a.d.c().a(strOptString);
                    final com.mbridge.msdk.videocommon.d.c cVarB = com.mbridge.msdk.video.bt.a.d.c().b(strOptString);
                    final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(campaignExA);
                    final WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
                    if (windVaneWebView != null) {
                        final b bVar = m.f5140a;
                        final boolean z9 = this.f5072s;
                        int i10 = this.f5071r == 0 ? 3 : 6;
                        if (campaignExA == null || cVarB == null || campaignExA.getRewardTemplateMode() == null || TextUtils.isEmpty(strC)) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("id", strOptString);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("result", 2);
                                jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "data is null");
                                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                }
                            }
                        } else if (TextUtils.isEmpty(campaignExA.getRewardTemplateMode().e())) {
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("id", strOptString);
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("result", 1);
                                jSONObject4.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "data is null");
                                jSONObject3.put(DataSchemeDataSource.SCHEME_DATA, jSONObject4);
                                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                            } catch (Exception e3) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                                }
                            }
                        } else if (TextUtils.isEmpty(campaignExA.getRewardTemplateMode().e()) || !campaignExA.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    WindVaneWebView windVaneWebView2;
                                    com.mbridge.msdk.video.signal.a.k kVar;
                                    boolean z10 = z9;
                                    WindVaneWebView windVaneWebView3 = windVaneWebView;
                                    String strE = campaignExA.getRewardTemplateMode().e();
                                    CampaignEx campaignEx = campaignExA;
                                    CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
                                    String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(campaignExA.getRewardTemplateMode().e());
                                    String str2 = strC;
                                    com.mbridge.msdk.videocommon.d.c cVar = cVarB;
                                    String str3 = strOptString;
                                    boolean z11 = b.this.f5032c;
                                    try {
                                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000154", campaignEx, eVar);
                                        a.C0071a c0071a = new a.C0071a();
                                        WindVaneWebView windVaneWebView4 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                                        if (campaignEx != null) {
                                            windVaneWebView4.setLocalRequestId(campaignEx.getCurrentLocalRid());
                                        }
                                        windVaneWebView4.setTempTypeForMetrics(2);
                                        c0071a.a(windVaneWebView4);
                                        String requestId = "";
                                        if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                                            windVaneWebView2 = windVaneWebView3;
                                            kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx);
                                            if (campaignEx != null) {
                                                requestId = campaignEx.getRequestId();
                                            }
                                        } else {
                                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(str2);
                                            if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                                                for (int i11 = 0; i11 < copyOnWriteArrayList2.size(); i11++) {
                                                    CampaignEx campaignEx2 = (CampaignEx) copyOnWriteArrayList2.get(i11);
                                                    for (CampaignEx campaignEx3 : copyOnWriteArrayListA) {
                                                        WindVaneWebView windVaneWebView5 = windVaneWebView3;
                                                        if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                                            campaignEx2.setReady(true);
                                                            copyOnWriteArrayList2.set(i11, campaignEx2);
                                                        }
                                                        windVaneWebView3 = windVaneWebView5;
                                                    }
                                                }
                                            }
                                            windVaneWebView2 = windVaneWebView3;
                                            kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx, copyOnWriteArrayList2);
                                            requestId = ((CampaignEx) copyOnWriteArrayList2.get(0)).getRequestId();
                                        }
                                        kVar.a(0);
                                        kVar.a(str2);
                                        kVar.c(str3);
                                        kVar.a(cVar);
                                        kVar.d(z10);
                                        windVaneWebView4.setWebViewListener(new l(str3, false, windVaneWebView2, strE, str2, c0071a, campaignEx, z11, requestId));
                                        windVaneWebView4.setObject(kVar);
                                        windVaneWebView4.loadUrl(h5ResAddress);
                                        windVaneWebView4.setRid(requestId);
                                    } catch (Exception e7) {
                                        if (MBridgeConstans.DEBUG) {
                                            af.b("RewardCampaignsResourceManager", e7.getLocalizedMessage());
                                        }
                                    }
                                }
                            }, i10 * 1000);
                        } else {
                            af.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                        }
                        this.f5071r++;
                    }
                } catch (Throwable th) {
                    af.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a
        public final void a(WebView webView, String str, String str2, int i10, int i11) {
            boolean z9 = true;
            if (i10 == 1) {
                try {
                    com.mbridge.msdk.reward.b.a aVar = new com.mbridge.msdk.reward.b.a();
                    aVar.b(false);
                    if (i11 != 2) {
                        z9 = false;
                    }
                    aVar.a(z9);
                    aVar.b(str, str2);
                    aVar.a(new com.mbridge.msdk.video.bt.module.b.a(null));
                    aVar.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, i11, str2, true, 1));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RVWindVaneWebView", e.getMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i10) {
            Runnable runnable;
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                eVar.a("result", Integer.valueOf(i10));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.f5064k, eVar);
            } catch (Throwable th) {
                af.b("RVWindVaneWebView", th.getMessage());
            }
            if (this.f5070q) {
                return;
            }
            String str = this.g + "_" + this.f;
            if (i10 == 1) {
                boolean z9 = this.f5068o;
                String str2 = this.g;
                if (z9) {
                    StringBuilder sbW = a3.a.w(str2, "_");
                    sbW.append(this.f5062i);
                    com.mbridge.msdk.videocommon.a.e(sbW.toString());
                } else {
                    StringBuilder sbW2 = a3.a.w(str2, "_");
                    sbW2.append(this.f5062i);
                    com.mbridge.msdk.videocommon.a.d(sbW2.toString());
                }
                com.mbridge.msdk.videocommon.a.a(this.g + "_" + this.f5062i + "_" + this.f, this.f5063j, true, this.f5068o);
                Handler handler = this.f5058a;
                if (handler != null && (runnable = this.f5059b) != null) {
                    handler.removeCallbacks(runnable);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.f5062i + "_" + this.f, true);
                a.C0071a c0071a = this.f5063j;
                if (c0071a != null) {
                    c0071a.a(true);
                }
                j jVar = this.f5067n;
                if (jVar != null) {
                    jVar.a(str, this.h, this.g, this.f5062i, this.f, this.f5063j);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.f5062i + "_" + this.f, false);
                a.C0071a c0071a2 = this.f5063j;
                if (c0071a2 != null) {
                    c0071a2.a(false);
                }
                if (this.f5067n != null) {
                    this.f5067n.a(str, this.f5062i, this.f, this.f5063j, b.b(880008, new MBridgeIds(this.h, this.g, this.f5062i), a3.a.f(i10, "readyState:"), null, this.f5064k));
                }
            }
            this.f5070q = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (this.f5069p) {
                return;
            }
            String str2 = this.g + "_" + this.f;
            if (!str.contains("wfr=1")) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.f5062i + "_" + this.f, true);
                Handler handler = this.f5058a;
                if (handler != null && (runnable = this.f5059b) != null) {
                    handler.removeCallbacks(runnable);
                }
                a.C0071a c0071a = this.f5063j;
                if (c0071a != null) {
                    c0071a.a(true);
                }
                j jVar = this.f5067n;
                if (jVar != null) {
                    jVar.a(str2, this.h, this.g, this.f5062i, this.f, this.f5063j);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.f5069p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i10, String str, String str2) {
            super.a(webView, i10, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.f5062i + "_" + this.f, false);
            if (this.f5067n != null) {
                String str3 = this.g + "_" + this.f;
                a.C0071a c0071a = this.f5063j;
                if (c0071a != null) {
                    c0071a.a(false);
                }
                this.f5067n.a(str3, this.f5062i, this.f, this.f5063j, b.b(880008, new MBridgeIds(this.h, this.g, this.f5062i), "onReceivedError： " + i10 + "  " + str, null, this.f5064k));
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView) {
            if (webView != null) {
                try {
                    try {
                        LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.g, this.f5062i);
                        if (linkedHashMapB != null && !linkedHashMapB.isEmpty()) {
                            for (View view : linkedHashMapB.values()) {
                                if (view instanceof MBridgeBTContainer) {
                                    ((MBridgeBTContainer) view).addNativeCloseButtonWhenWebViewCrash();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        af.b("OperateViews", th.getMessage());
                    }
                } catch (Throwable th2) {
                    af.b("RVWindVaneWebView", th2.getMessage());
                }
            }
        }
    }
}
