package com.mbridge.msdk.newreward.function.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f4948a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4949b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4950c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f4951d;
    private Handler g;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.c f4952i;

    /* renamed from: l, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.d f4955l;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f4953j = false;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f4954k = false;
    private final int e = ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_CHECK_INTERVAL, 120000);
    private final long h = ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_TOKEN_VALIDITY_PERIOD, 1800000);
    private final boolean f = ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_CHECK_OPTIMIZED, false);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f4966a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<b> f4967b;

        /* renamed from: c, reason: collision with root package name */
        private final long f4968c;

        public a(Handler handler, b bVar, long j10) {
            this.f4966a = handler;
            this.f4967b = new WeakReference<>(bVar);
            this.f4968c = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar = this.f4967b.get();
            if (bVar != null) {
                try {
                    b.a(bVar);
                } catch (Exception e) {
                    af.a("LoadCheckController", "startCheckTask error: " + e.getMessage());
                }
            }
            Handler handler = this.f4966a;
            if (handler != null) {
                handler.postDelayed(this, this.f4968c);
            }
        }
    }

    public b(int i10, String str, String str2, boolean z9) {
        this.f4948a = i10;
        this.f4949b = str;
        this.f4950c = str2;
        this.f4951d = z9;
    }

    public static /* synthetic */ void a(b bVar, List list) {
        Iterator it = list.iterator();
        final com.mbridge.msdk.newreward.function.c.a.b bVar2 = null;
        final com.mbridge.msdk.newreward.function.c.a.b bVar3 = null;
        while (it.hasNext()) {
            com.mbridge.msdk.newreward.function.c.a.b bVar4 = (com.mbridge.msdk.newreward.function.c.a.b) it.next();
            if (bVar4.i()) {
                long jI = bVar4.I();
                if (jI == 0) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
                } else if (TextUtils.isEmpty(bVar4.h())) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
                } else if (System.currentTimeMillis() - jI > bVar.h && bVar4.u() == null) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
                } else if (bVar4.s() <= 0.0d && bVar4.G() != 1) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
                } else if (bVar3 == null || bVar4.s() > bVar3.s()) {
                    bVar3 = bVar4;
                }
            } else if (bVar4.I() == 0) {
                com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
            } else if (bVar4.E() == null || bVar4.E().size() == 0) {
                com.mbridge.msdk.newreward.function.d.c.a().b().b(bVar4.c(), bVar4.d(), bVar4.e(), bVar4.g(), 8);
            } else if (bVar3 == null || bVar4.I() > bVar3.I()) {
                bVar3 = bVar4;
            }
        }
        if (list.size() != 0 && !bVar.f4954k) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.mbridge.msdk.newreward.function.c.a.b bVar5 = (com.mbridge.msdk.newreward.function.c.a.b) it2.next();
                if (bVar5 != bVar3 && bVar5.u() != null && (bVar2 == null || bVar5.I() > bVar2.I())) {
                    bVar2 = bVar5;
                }
            }
        }
        if (!bVar.f4954k && bVar2 != null) {
            bVar.f4954k = true;
            final com.mbridge.msdk.newreward.a.e eVarA = bVar.a(bVar2);
            try {
                com.mbridge.msdk.newreward.function.command.c cVar = bVar.f4952i;
                cVar.a(eVarA, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK, cVar.a("check_type", "download_start_resource", "campaign", bVar2));
            } catch (Exception e) {
                androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("handlerAnthonyNeedDownloadCampaign error: "), "LoadCheckController");
            }
            bVar.a(eVarA, bVar2, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.e.b.3
                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar6) {
                    b.this.f4954k = false;
                    try {
                        b.this.f4952i.a(eVarA, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK, b.this.f4952i.a("check_type", "download_failed", "campaign", bVar2));
                    } catch (Exception e3) {
                        androidx.constraintlayout.core.widgets.analyzer.a.D(e3, new StringBuilder("handlerAnthonyNeedDownloadCampaign error: "), "LoadCheckController");
                    }
                }

                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void reqSuccessful(Object obj) {
                    b.this.f4954k = false;
                    try {
                        b.this.f4952i.a(eVarA, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK, b.this.f4952i.a("check_type", "download_success", "campaign", bVar2));
                    } catch (Exception e3) {
                        androidx.constraintlayout.core.widgets.analyzer.a.D(e3, new StringBuilder("handlerAnthonyNeedDownloadCampaign error: "), "LoadCheckController");
                    }
                }
            });
        }
        if (bVar3 == null) {
            bVar.f4953j = false;
            return;
        }
        List<CampaignEx> listE = bVar3.E();
        final com.mbridge.msdk.newreward.a.e eVarA2 = bVar.a(bVar3);
        com.mbridge.msdk.newreward.function.command.c cVar2 = bVar.f4952i;
        if (listE != null) {
            try {
                cVar2.a(eVarA2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK, cVar2.a("check_type", "check_start_resource"));
            } catch (Exception e3) {
                androidx.constraintlayout.core.widgets.analyzer.a.D(e3, new StringBuilder("handlerLoadFailedCampaigns error: "), "LoadCheckController");
            }
            bVar.a(eVarA2, bVar3, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.e.b.2
                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar6) {
                    b.a(b.this, eVarA2, bVar3);
                }

                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void reqSuccessful(Object obj) {
                    b.a(b.this, bVar3, eVarA2);
                }
            });
            return;
        }
        try {
            cVar2.a(eVarA2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK, cVar2.a("check_type", "check_start_campaign"));
        } catch (Exception e7) {
            androidx.constraintlayout.core.widgets.analyzer.a.D(e7, new StringBuilder("handlerLoadFailedCampaigns error: "), "LoadCheckController");
        }
        com.mbridge.msdk.newreward.function.command.c cVar3 = bVar.f4952i;
        cVar3.a(cVar3.a("command_manager", cVar3, "adapter_model", eVarA2), new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.e.b.4
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar6) {
                b.a(b.this, eVarA2, bVar3);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqSuccessful(Object obj) {
                b.a(b.this, bVar3, eVarA2);
            }
        });
    }

    public final void a(com.mbridge.msdk.newreward.function.command.c cVar, com.mbridge.msdk.newreward.a.d dVar) {
        if (cVar != null && dVar != null) {
            if (!this.f) {
                a();
                return;
            }
            this.f4955l = dVar;
            this.f4952i = cVar;
            HandlerThread handlerThread = new HandlerThread("load_check_controller");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.g = handler;
            handler.postDelayed(new a(handler, this, this.e), this.e);
            return;
        }
        a();
    }

    private void a() {
        com.mbridge.msdk.newreward.function.d.c.a().b().b(this.f4948a, this.f4949b, this.f4950c);
    }

    private void a(com.mbridge.msdk.newreward.a.e eVar, com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        eVar.F().a(bVar, bVar2);
    }

    @NonNull
    private com.mbridge.msdk.newreward.a.e a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        com.mbridge.msdk.newreward.a.e eVar = new com.mbridge.msdk.newreward.a.e(false, this.f4948a, bVar.h(), this.f4950c, bVar.i());
        eVar.f(bVar.g());
        eVar.f(30000);
        eVar.g(MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
        eVar.e(this.f4949b);
        eVar.a(true);
        eVar.b(false);
        eVar.c(false);
        return eVar;
    }

    public static /* synthetic */ void a(b bVar) {
        if (bVar.f4955l.a() != null) {
            Iterator<com.mbridge.msdk.newreward.a.e> it = bVar.f4955l.a().iterator();
            while (it.hasNext()) {
                if (it.next().y() == 1) {
                    return;
                }
            }
        }
        if (bVar.f4953j) {
            return;
        }
        bVar.f4953j = true;
        com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.f4948a, bVar.f4949b, bVar.f4950c, bVar.f4951d, new com.mbridge.msdk.newreward.function.d.b() { // from class: com.mbridge.msdk.newreward.function.e.b.1
            @Override // com.mbridge.msdk.newreward.function.d.b
            public final void a() {
                b.a(b.this, (com.mbridge.msdk.newreward.a.e) null, (com.mbridge.msdk.newreward.function.c.a.b) null);
            }

            @Override // com.mbridge.msdk.newreward.function.d.b
            public final void a(List<com.mbridge.msdk.newreward.function.c.a.b> list) {
                b.a(b.this, list);
            }
        });
    }

    public static /* synthetic */ void a(b bVar, com.mbridge.msdk.newreward.a.e eVar, com.mbridge.msdk.newreward.function.c.a.b bVar2) {
        Map mapA;
        bVar.f4953j = false;
        if (eVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.command.c cVar = bVar.f4952i;
        try {
            if (bVar2 == null) {
                mapA = cVar.a("check_type", "check_failed");
            } else {
                mapA = cVar.a("check_type", "check_failed", "campaign", bVar2);
            }
            bVar.f4952i.a(eVar, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK, mapA);
        } catch (Exception e) {
            androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("reportLoadCheckFailed error: "), "LoadCheckController");
        }
    }

    public static /* synthetic */ void a(b bVar, com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.a.e eVar) {
        bVar.f4953j = false;
        if (eVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.command.c cVar = bVar.f4952i;
        cVar.a(eVar, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK, cVar.a("check_type", "check_success", "campaign", bVar2));
        eVar.h(true);
        if (!bVar2.i() || bVar2.s() <= 0.0d) {
            bVar.f4955l.a(eVar);
        }
    }
}
