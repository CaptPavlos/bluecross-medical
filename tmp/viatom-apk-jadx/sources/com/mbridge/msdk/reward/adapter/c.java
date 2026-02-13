package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.b.a;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {
    private boolean A;
    private String C;
    private int D;
    private int E;
    private int F;
    private CampaignUnit G;
    private CopyOnWriteArrayList<CampaignEx> H;
    private String K;
    private a L;
    private List<CampaignEx> S;
    private CopyOnWriteArrayList<CampaignEx> T;
    private List<CampaignEx> U;

    /* renamed from: k, reason: collision with root package name */
    private Context f5147k;

    /* renamed from: l, reason: collision with root package name */
    private String f5148l;

    /* renamed from: m, reason: collision with root package name */
    private String f5149m;

    /* renamed from: n, reason: collision with root package name */
    private int f5150n;

    /* renamed from: o, reason: collision with root package name */
    private int f5151o;

    /* renamed from: p, reason: collision with root package name */
    private int f5152p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5153q;

    /* renamed from: r, reason: collision with root package name */
    private String f5154r;

    /* renamed from: s, reason: collision with root package name */
    private h f5155s;
    private volatile com.mbridge.msdk.reward.adapter.a t;

    /* renamed from: u, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f5156u;

    /* renamed from: z, reason: collision with root package name */
    private boolean f5160z;

    /* renamed from: v, reason: collision with root package name */
    private boolean f5157v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5158w = false;

    /* renamed from: a, reason: collision with root package name */
    public Object f5141a = new Object();

    /* renamed from: x, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f5159x = new CopyOnWriteArrayList<>();
    private int y = 2;
    private String B = "";
    private boolean I = false;
    private long J = 0;
    private boolean M = false;
    private boolean N = false;

    /* renamed from: b, reason: collision with root package name */
    public String f5142b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f5143c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f5144d = "";
    private Handler O = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.reward.adapter.c.1
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:110:0x02ec  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x02ee  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void handleMessage(android.os.Message r18) {
            /*
                Method dump skipped, instructions count: 1340
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    private boolean P = false;
    private long Q = 0;
    volatile boolean e = false;
    volatile boolean f = false;
    volatile boolean g = false;
    volatile boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    volatile boolean f5145i = false;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f5146j = false;
    private String R = "";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private String f5204b;

        /* renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.c f5205c;

        public a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            this.f5204b = str;
            this.f5205c = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (c.this.M) {
                    return;
                }
                c.this.N = true;
                if (c.this.O != null) {
                    Message messageObtainMessage = c.this.O.obtainMessage();
                    messageObtainMessage.obj = this.f5204b;
                    messageObtainMessage.what = 2;
                    if (this.f5205c != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", this.f5205c.f());
                        messageObtainMessage.setData(bundle);
                    }
                    c.this.O.sendMessage(messageObtainMessage);
                }
            } catch (Exception e) {
                af.b("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private String f5207b;

        /* renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.c f5208c;

        public b(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            this.f5207b = str;
            this.f5208c = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.mbridge.msdk.e.b.a()) {
                    c cVar = c.this;
                    String unused = cVar.f5148l;
                    Context unused2 = c.this.f5147k;
                    cVar.C = "";
                }
                c cVar2 = c.this;
                cVar2.f5154r = ak.a(cVar2.f5147k, c.this.f5148l);
                if (c.this.N) {
                    return;
                }
                if (c.this.L != null && c.this.O != null) {
                    c.this.O.removeCallbacks(c.this.L);
                }
                c.this.M = true;
                if (c.this.O != null) {
                    Message messageObtainMessage = c.this.O.obtainMessage();
                    messageObtainMessage.obj = this.f5207b;
                    messageObtainMessage.what = 1;
                    if (this.f5208c != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", this.f5208c.f());
                        messageObtainMessage.setData(bundle);
                    }
                    c.this.O.sendMessage(messageObtainMessage);
                }
                if (TextUtils.isEmpty(c.this.f5154r)) {
                    return;
                }
                af.b("RewardMVVideoAdapter", "excludeId : " + c.this.f5154r);
            } catch (Exception e) {
                af.b("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    public c(Context context, String str, String str2) {
        try {
            this.f5147k = context.getApplicationContext();
            this.f5148l = str2;
            this.f5149m = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d6 A[Catch: all -> 0x001a, Exception -> 0x001d, TryCatch #4 {Exception -> 0x001d, blocks: (B:8:0x0012, B:10:0x0016, B:16:0x0022, B:18:0x0028, B:20:0x0032, B:22:0x003f, B:24:0x0049, B:25:0x004e, B:27:0x0054, B:28:0x0065, B:30:0x006b, B:31:0x0073, B:33:0x0078, B:37:0x0083, B:39:0x008f, B:41:0x009d, B:75:0x0156, B:77:0x0165, B:79:0x016b, B:81:0x0171, B:83:0x017a, B:84:0x017d, B:74:0x0153, B:45:0x00aa, B:48:0x00b5, B:85:0x017e, B:87:0x0186, B:89:0x018c, B:91:0x0196, B:96:0x01ab, B:97:0x01b0, B:99:0x01b6, B:101:0x01bc, B:105:0x01cb, B:106:0x01ce, B:108:0x01d6, B:113:0x01f1, B:115:0x01f5, B:109:0x01da, B:94:0x01a1), top: B:145:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01da A[Catch: all -> 0x001a, Exception -> 0x001d, TRY_LEAVE, TryCatch #4 {Exception -> 0x001d, blocks: (B:8:0x0012, B:10:0x0016, B:16:0x0022, B:18:0x0028, B:20:0x0032, B:22:0x003f, B:24:0x0049, B:25:0x004e, B:27:0x0054, B:28:0x0065, B:30:0x006b, B:31:0x0073, B:33:0x0078, B:37:0x0083, B:39:0x008f, B:41:0x009d, B:75:0x0156, B:77:0x0165, B:79:0x016b, B:81:0x0171, B:83:0x017a, B:84:0x017d, B:74:0x0153, B:45:0x00aa, B:48:0x00b5, B:85:0x017e, B:87:0x0186, B:89:0x018c, B:91:0x0196, B:96:0x01ab, B:97:0x01b0, B:99:0x01b6, B:101:0x01bc, B:105:0x01cb, B:106:0x01ce, B:108:0x01d6, B:113:0x01f1, B:115:0x01f5, B:109:0x01da, B:94:0x01a1), top: B:145:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0207 A[PHI: r13
      0x0207: PHI (r13v4 'e' java.io.IOException) = (r13v7 'e' java.io.IOException), (r13v8 'e' java.io.IOException) binds: [B:130:0x021b, B:122:0x0205] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017e A[Catch: all -> 0x001a, Exception -> 0x001d, PHI: r2
      0x017e: PHI (r2v10 java.io.FileOutputStream) = (r2v9 java.io.FileOutputStream), (r2v14 java.io.FileOutputStream) binds: [B:38:0x008d, B:80:0x016f] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {Exception -> 0x001d, blocks: (B:8:0x0012, B:10:0x0016, B:16:0x0022, B:18:0x0028, B:20:0x0032, B:22:0x003f, B:24:0x0049, B:25:0x004e, B:27:0x0054, B:28:0x0065, B:30:0x006b, B:31:0x0073, B:33:0x0078, B:37:0x0083, B:39:0x008f, B:41:0x009d, B:75:0x0156, B:77:0x0165, B:79:0x016b, B:81:0x0171, B:83:0x017a, B:84:0x017d, B:74:0x0153, B:45:0x00aa, B:48:0x00b5, B:85:0x017e, B:87:0x0186, B:89:0x018c, B:91:0x0196, B:96:0x01ab, B:97:0x01b0, B:99:0x01b6, B:101:0x01bc, B:105:0x01cb, B:106:0x01ce, B:108:0x01d6, B:113:0x01f1, B:115:0x01f5, B:109:0x01da, B:94:0x01a1), top: B:145:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> a(com.mbridge.msdk.foundation.entity.CampaignUnit r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(com.mbridge.msdk.foundation.entity.CampaignUnit):java.util.concurrent.CopyOnWriteArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.O != null) {
            if (TextUtils.isEmpty(str)) {
                str = "load fail exception";
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = str;
            if (cVar != null) {
                cVar.c(true);
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.f());
                messageObtain.setData(bundle);
            }
            boolean zContains = str.contains("exception");
            Handler handler = this.O;
            if (zContains) {
                handler.sendMessageAtFrontOfQueue(messageObtain);
            } else {
                handler.sendMessage(messageObtain);
            }
        }
    }

    private com.mbridge.msdk.foundation.same.report.d.c c(List<CampaignEx> list) {
        String localRequestId;
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        localRequestId = "";
        if (list != null) {
            try {
                if (list.size() > 0) {
                    localRequestId = list.get(0) != null ? list.get(0).getLocalRequestId() : "";
                    cVar.c(localRequestId);
                    cVar.b(list);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        e eVar = new e();
        eVar.a("cache", 1);
        eVar.a(CampaignEx.JSON_KEY_HB, 1);
        eVar.a("auto_load", 2);
        cVar.a("2000127", eVar);
        cVar.a("2000048", eVar);
        cVar.b(this.f5160z ? 287 : 94);
        cVar.i("1");
        cVar.b("2");
        if (!TextUtils.isEmpty(localRequestId) && !com.mbridge.msdk.foundation.same.report.d.d.a().b().containsKey(localRequestId)) {
            com.mbridge.msdk.foundation.same.report.d.d.a().b().put(localRequestId, cVar);
            return cVar;
        }
        return cVar;
    }

    private void i() {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            try {
                g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (gVarB == null) {
                    com.mbridge.msdk.c.h.a();
                    gVarB = i.a();
                }
                com.mbridge.msdk.videocommon.a.a.a().a(gVarB.ad() * 1000, this.f5148l);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            if (ap.b(this.f5148l)) {
                com.mbridge.msdk.reward.b.a.a(this.f5148l, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String k() {
        try {
            return ap.b(com.mbridge.msdk.reward.b.a.f5214d) ? com.mbridge.msdk.reward.b.a.f5214d : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void l() {
        try {
            Map<String, Long> map = com.mbridge.msdk.foundation.same.a.b.f3630k;
            if (map == null || map.size() <= 0) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.b.f3630k.clear();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void m() {
        try {
            com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(this.f5147k)).a(this.f5148l);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final boolean d(boolean z9) {
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.a.a.a().a(this.f5148l, 1, this.A, this.B);
        if (copyOnWriteArrayListA == null || copyOnWriteArrayListA.size() <= 0) {
            af.a("RewardVideoController", "database has not can use data");
            if (z9) {
                e eVar = new e();
                eVar.a("event_name", "is_ready_cse");
                eVar.a("reason", "no effective campaign list");
            }
            return false;
        }
        CampaignEx campaignEx = copyOnWriteArrayListA.get(0);
        int iB = com.mbridge.msdk.videocommon.a.a.a().b(this.f5148l, 1, this.A, this.B);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || copyOnWriteArrayListA.size() >= iB) {
            return a(copyOnWriteArrayListA, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt(), z9);
        }
        if (z9) {
            e eVar2 = new e();
            eVar2.a("event_name", "is_ready_cltr");
            eVar2.a("reason", "nscpt error");
            a(cVar, eVar2, copyOnWriteArrayListA);
        }
        return false;
    }

    public final void f(boolean z9) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        if (z9 || (copyOnWriteArrayList = this.H) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.f5148l, this.H);
    }

    public final void g(boolean z9) {
        if (z9) {
            List<CampaignEx> list = this.U;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : this.U) {
                if (campaignEx != null) {
                    campaignEx.setLoadTimeoutState(0);
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f5148l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e(), false);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.f5148l, this.U, "load_timeout", 0);
            return;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.H;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<CampaignEx> it = this.H.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (next != null) {
                next.setLoadTimeoutState(0);
                if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f5148l + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), false);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.f5148l, this.H, "load_timeout", 0);
    }

    public final boolean h(boolean z9) {
        if (z9) {
            List<CampaignEx> list = this.U;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (CampaignEx campaignEx : this.U) {
                if (campaignEx != null) {
                    campaignEx.setLoadTimeoutState(1);
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f5148l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e(), true);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.f5148l, this.U, "load_timeout", 1);
            return true;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.H;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        Iterator<CampaignEx> it = this.H.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (next != null) {
                next.setLoadTimeoutState(1);
                if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f5148l + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), true);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.f5148l, this.H, "load_timeout", 1);
        return true;
    }

    public final void e(boolean z9) {
        this.P = z9;
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.T;
    }

    public final String f() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.H;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            return com.mbridge.msdk.foundation.same.c.a(this.H);
        }
        return com.mbridge.msdk.foundation.same.c.a(this.U);
    }

    public final void b(boolean z9) {
        this.f5160z = z9;
    }

    public final boolean b() {
        return d(false);
    }

    private void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.f5150n += list.size();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        com.mbridge.msdk.videocommon.d.c cVar = this.f5156u;
        if (cVar == null || this.f5150n > cVar.v()) {
            this.f5150n = 0;
        }
        if (ap.b(this.f5148l)) {
            com.mbridge.msdk.reward.b.a.a(this.f5148l, this.f5150n);
        }
    }

    private void b(String str) {
        if (ap.b(str)) {
            com.mbridge.msdk.reward.b.a.f5214d = str;
        }
    }

    private boolean b(CampaignEx campaignEx) {
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

    private void b(String str, boolean z9, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        com.mbridge.msdk.foundation.same.f.a.f().execute(new b(str, cVar));
        if (this.O != null) {
            a aVar = new a(str, cVar);
            this.L = aVar;
            this.O.postDelayed(aVar, 90000L);
            return;
        }
        a(str, z9, cVar);
    }

    public static /* synthetic */ void b(c cVar, CampaignUnit campaignUnit) throws Throwable {
        cVar.G = campaignUnit;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = cVar.a(campaignUnit);
        new com.mbridge.msdk.reward.a.a(cVar.f5148l, cVar.f5160z).a(copyOnWriteArrayListA, cVar.K, cVar, cVar.f5148l);
        cVar.a(copyOnWriteArrayListA, true, false);
    }

    public final CopyOnWriteArrayList<CampaignEx> d() {
        return this.H;
    }

    public final void c(boolean z9) {
        this.A = z9;
    }

    public final boolean c() {
        List<CampaignEx> listC = com.mbridge.msdk.videocommon.a.a.a().c(this.f5148l, 1, this.A, this.B);
        if (listC != null && listC.size() > 0) {
            CampaignEx campaignEx = listC.get(0);
            int iB = com.mbridge.msdk.videocommon.a.a.a().b(this.f5148l, 1, this.A, this.B);
            if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || listC.size() >= iB) {
                return a(listC, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
            }
            return false;
        }
        af.a("test_isReay_db", "database has not can use data");
        return false;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.reward.adapter.c$5, reason: invalid class name */
    public class AnonymousClass5 implements b.i {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.c f5191a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f5192b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5193c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f5194d;

        public AnonymousClass5(CampaignEx campaignEx, boolean z9, int i10) {
            this.f5192b = campaignEx;
            this.f5193c = z9;
            this.f5194d = i10;
            this.f5191a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
            af.a("RewardMVVideoAdapter", "大模板业务，大模板下载失败");
            if (this.f5192b.getRsIgnoreCheckRule() != null && this.f5192b.getRsIgnoreCheckRule().size() > 0) {
                if (this.f5192b.getRsIgnoreCheckRule().contains(3)) {
                    af.c("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                    return;
                } else if (this.f5192b.getCMPTEntryUrl().equals(this.f5192b.getendcard_url()) && this.f5192b.getRsIgnoreCheckRule().contains(2)) {
                    af.c("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                    return;
                }
            }
            c cVar = c.this;
            c.a(cVar, cVar.f5148l, c.this.S, c.this.A, str2);
            c.this.f = false;
            if (c.this.O != null) {
                c.this.O.removeMessages(5);
            }
            if (c.this.t == null || c.this.f5145i) {
                return;
            }
            c.this.f5145i = true;
            if (bVar != null) {
                bVar.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
            }
            if (this.f5191a == null) {
                this.f5191a = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            this.f5191a.b(c.this.H);
            this.f5191a.a(bVar);
            c.this.t.a(c.this.S, bVar, this.f5191a);
            af.a("RewardMVVideoAdapter", "大模板业务，大模板下载失败 onVideoLoadFail");
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(final String str, final String str2, final String str3, String str4) {
            af.a("RewardMVVideoAdapter", "大模板业务，大模板下载成功");
            c.this.f = true;
            if (!c.this.e || c.this.g || c.this.O == null) {
                return;
            }
            synchronized (c.this.f5141a) {
                try {
                    if (c.this.g) {
                        return;
                    }
                    c.this.g = true;
                    c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b bVar = b.m.f5140a;
                            boolean z9 = c.this.I;
                            Handler handler = c.this.O;
                            boolean z10 = c.this.f5160z;
                            boolean z11 = c.this.A;
                            String str5 = str3;
                            String requestIdNotice = AnonymousClass5.this.f5192b.getRequestIdNotice();
                            String str6 = str;
                            String str7 = str2;
                            String cMPTEntryUrl = AnonymousClass5.this.f5192b.getCMPTEntryUrl();
                            int i10 = c.this.y;
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            bVar.a(z9, handler, z10, z11, str5, requestIdNotice, str6, str7, cMPTEntryUrl, i10, anonymousClass5.f5192b, c.this.H, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass5.this.f5192b.getCMPTEntryUrl()), str2, c.this.f5156u, new b.j() { // from class: com.mbridge.msdk.reward.adapter.c.5.1.1
                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str8, String str9, String str10, String str11, String str12, a.C0071a c0071a) {
                                    androidx.constraintlayout.core.widgets.analyzer.a.E("模板加载成功 requestId ", str11, "HBOPTIMIZE");
                                    c cVar = c.this;
                                    CopyOnWriteArrayList copyOnWriteArrayList = cVar.H;
                                    AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                    boolean zA = cVar.a(copyOnWriteArrayList, anonymousClass52.f5193c, anonymousClass52.f5194d);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (zA) {
                                        c cVar2 = c.this;
                                        c.a(cVar2, cVar2.f5148l, c.this.S, c.this.U, c.this.A);
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        if (c.this.t == null || c.this.h) {
                                            return;
                                        }
                                        c.this.h = true;
                                        AnonymousClass5 anonymousClass53 = AnonymousClass5.this;
                                        com.mbridge.msdk.foundation.same.report.d.c cVar3 = anonymousClass53.f5191a;
                                        if (cVar3 != null) {
                                            cVar3.b(c.this.H);
                                        }
                                        c.this.t.a(c.this.H, AnonymousClass5.this.f5191a);
                                        return;
                                    }
                                    c cVar4 = c.this;
                                    c.a(cVar4, str10, cVar4.S, c.this.A, str3);
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    if (c.this.t == null || c.this.f5145i) {
                                        return;
                                    }
                                    c.this.f5145i = true;
                                    com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880008, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                    AnonymousClass5 anonymousClass54 = AnonymousClass5.this;
                                    if (anonymousClass54.f5191a == null) {
                                        anonymousClass54.f5191a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    AnonymousClass5 anonymousClass55 = AnonymousClass5.this;
                                    anonymousClass55.f5191a.b(c.this.H);
                                    AnonymousClass5.this.f5191a.a(bVarB);
                                    c.this.t.a(c.this.S, bVarB, AnonymousClass5.this.f5191a);
                                    af.a("RewardMVVideoAdapter", "大模板业务，大模板预加载成功 isReady false  onVideoLoadFail");
                                }

                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str8, String str9, String str10, a.C0071a c0071a, com.mbridge.msdk.foundation.c.b bVar2) {
                                    af.a("RewardMVVideoAdapter", "大模板业务，大模板预加载失败");
                                    af.b("HBOPTIMIZE", "模板加载失败 requestId " + str9);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    c cVar = c.this;
                                    c.a(cVar, str2, cVar.S, c.this.A, str9);
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    if (c.this.t == null || c.this.f5145i) {
                                        return;
                                    }
                                    c.this.f5145i = true;
                                    AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                    if (anonymousClass52.f5191a == null) {
                                        anonymousClass52.f5191a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    AnonymousClass5 anonymousClass53 = AnonymousClass5.this;
                                    anonymousClass53.f5191a.b(c.this.H);
                                    AnonymousClass5.this.f5191a.a(bVar2);
                                    c.this.t.a(c.this.S, bVar2, AnonymousClass5.this.f5191a);
                                    af.a("RewardMVVideoAdapter", "大模板业务，大模板预加载失败 onVideoLoadFail");
                                }
                            }, false);
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.reward.adapter.c$4, reason: invalid class name */
    public class AnonymousClass4 implements b.i {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.c f5181a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f5182b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5183c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f5184d;

        public AnonymousClass4(CampaignEx campaignEx, boolean z9, int i10) {
            this.f5182b = campaignEx;
            this.f5183c = z9;
            this.f5184d = i10;
            this.f5181a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, final String str2, final com.mbridge.msdk.foundation.c.b bVar) {
            af.a("RewardMVVideoAdapter", "template 下载失败： ");
            if (bVar != null) {
                bVar.a("errorCode: 3202 errorMessage: temp resource download failed");
            }
            if (!this.f5183c && c.this.t != null && c.this.O != null) {
                af.a("RewardMVVideoAdapter", "播放模板下载失败，非大模板");
                if (this.f5182b.getRsIgnoreCheckRule() == null || this.f5182b.getRsIgnoreCheckRule().size() <= 0 || !this.f5182b.getRsIgnoreCheckRule().contains(1)) {
                    c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c cVar = c.this;
                            c.a(cVar, cVar.f5148l, c.this.S, c.this.A, str2);
                            if (c.this.O != null) {
                                c.this.O.removeMessages(5);
                            }
                            if (c.this.f5145i || c.this.t == null) {
                                return;
                            }
                            c.this.f5145i = true;
                            com.mbridge.msdk.foundation.c.b bVar2 = bVar;
                            if (bVar2 != null) {
                                bVar2.a("errorCode: 3202 errorMessage: temp resource download failed");
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (anonymousClass4.f5181a == null) {
                                anonymousClass4.f5181a = new com.mbridge.msdk.foundation.same.report.d.c();
                            }
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            anonymousClass42.f5181a.b(c.this.H);
                            AnonymousClass4.this.f5181a.a(bVar);
                            c.this.t.a(c.this.S, bVar, AnonymousClass4.this.f5181a);
                            af.a("RewardMVVideoAdapter", "播放模板下载失败，非大模板 onVideoLoadFail");
                        }
                    });
                    return;
                } else {
                    af.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                    return;
                }
            }
            if (this.f5184d == 1) {
                if (this.f5182b.getRsIgnoreCheckRule() != null && this.f5182b.getRsIgnoreCheckRule().size() > 0) {
                    if (this.f5182b.getRsIgnoreCheckRule().contains(3)) {
                        af.c("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                        return;
                    } else if (this.f5182b.getCMPTEntryUrl().equals(this.f5182b.getendcard_url()) && this.f5182b.getRsIgnoreCheckRule().contains(2)) {
                        af.c("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                        return;
                    }
                }
                if (c.this.t == null || c.this.O == null) {
                    return;
                }
                c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.4.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c cVar = c.this;
                        c.a(cVar, cVar.f5148l, c.this.S, c.this.A, str2);
                        if (c.this.O != null) {
                            c.this.O.removeMessages(5);
                        }
                        if (c.this.f5145i || c.this.t == null) {
                            return;
                        }
                        c.this.f5145i = true;
                        com.mbridge.msdk.foundation.c.b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                        }
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        if (anonymousClass4.f5181a == null) {
                            anonymousClass4.f5181a = new com.mbridge.msdk.foundation.same.report.d.c();
                        }
                        AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                        anonymousClass42.f5181a.b(c.this.H);
                        AnonymousClass4.this.f5181a.a(bVar);
                        c.this.t.a(c.this.S, bVar, AnonymousClass4.this.f5181a);
                        af.a("RewardMVVideoAdapter", "播放模板下载失败，大模板，nscpt 1 onVideoLoadFail");
                    }
                });
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, String str2, String str3, String str4) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g() {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.c()
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a(r0)
            java.lang.String r1 = r4.f5148l
            java.lang.String r2 = r4.f5143c
            java.util.List r0 = r0.a(r1, r2)
            if (r0 == 0) goto La8
            int r1 = r0.size()
            java.lang.String r2 = r4.f5148l
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.b.b(r2)
            if (r1 != 0) goto L24
            goto La8
        L24:
            r3 = 1
            if (r1 != r3) goto L45
            r1 = 0
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L70
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Exception -> L43
            com.mbridge.msdk.foundation.entity.d r3 = (com.mbridge.msdk.foundation.entity.d) r3     // Catch: java.lang.Exception -> L43
            java.lang.String r3 = r3.d()     // Catch: java.lang.Exception -> L43
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L43
            com.mbridge.msdk.foundation.entity.d r0 = (com.mbridge.msdk.foundation.entity.d) r0     // Catch: java.lang.Exception -> L43
            java.lang.String r0 = r0.b()     // Catch: java.lang.Exception -> L43
            goto L73
        L43:
            r0 = move-exception
            goto L9f
        L45:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L43
            if (r1 != 0) goto L70
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L43
        L4f:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> L43
            if (r1 == 0) goto L70
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> L43
            com.mbridge.msdk.foundation.entity.d r1 = (com.mbridge.msdk.foundation.entity.d) r1     // Catch: java.lang.Exception -> L43
            if (r1 == 0) goto L4f
            java.lang.String r3 = r1.a()     // Catch: java.lang.Exception -> L43
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L4f
            java.lang.String r3 = r1.d()     // Catch: java.lang.Exception -> L43
            java.lang.String r0 = r1.b()     // Catch: java.lang.Exception -> L43
            goto L73
        L70:
            java.lang.String r3 = ""
            r0 = r3
        L73:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L43
            if (r1 != 0) goto La8
            java.lang.String r1 = r4.f5143c     // Catch: java.lang.Exception -> L43
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Exception -> L43
            if (r1 == 0) goto La8
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L43
            android.content.Context r1 = r1.c()     // Catch: java.lang.Exception -> L43
            com.mbridge.msdk.foundation.db.b r1 = com.mbridge.msdk.foundation.db.b.a(r1)     // Catch: java.lang.Exception -> L43
            java.lang.String r3 = r4.f5148l     // Catch: java.lang.Exception -> L43
            r1.b(r2, r3)     // Catch: java.lang.Exception -> L43
            java.lang.String r1 = r4.f5148l     // Catch: java.lang.Exception -> L43
            java.lang.String r2 = r4.f5143c     // Catch: java.lang.Exception -> L43
            com.mbridge.msdk.foundation.same.a.b.a(r1, r2, r0)     // Catch: java.lang.Exception -> L43
            java.lang.String r0 = r4.f5148l     // Catch: java.lang.Exception -> L43
            com.mbridge.msdk.foundation.same.a.b.c(r0)     // Catch: java.lang.Exception -> L43
            return
        L9f:
            java.lang.String r1 = "RewardMVVideoAdapter"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.a(r1, r0)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.g():void");
    }

    private String h() {
        int I;
        g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        if (TextUtils.isEmpty(this.K)) {
            I = gVarA.as();
        } else {
            I = gVarA.I();
        }
        return com.mbridge.msdk.foundation.same.net.e.d.f().a(this.K, I);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.reward.adapter.c$3, reason: invalid class name */
    public class AnonymousClass3 implements b.c {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.c f5164a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f5165b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5166c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f5167d;

        public AnonymousClass3(CampaignEx campaignEx, boolean z9, int i10) {
            this.f5165b = campaignEx;
            this.f5166c = z9;
            this.f5167d = i10;
            this.f5164a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            final String str4;
            final String str5;
            final String str6;
            final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2;
            c.this.e = true;
            if (this.f5166c) {
                if (!c.this.f || c.this.g || c.this.O == null) {
                    return;
                }
                synchronized (c.this.f5141a) {
                    try {
                        if (c.this.g) {
                            return;
                        }
                        c.this.g = true;
                        c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.mbridge.msdk.reward.adapter.b bVar = b.m.f5140a;
                                boolean z9 = c.this.I;
                                Handler handler = c.this.O;
                                boolean z10 = c.this.f5160z;
                                boolean z11 = c.this.A;
                                String str7 = str3;
                                String requestIdNotice = AnonymousClass3.this.f5165b.getRequestIdNotice();
                                String str8 = c.this.f5149m;
                                String str9 = str2;
                                String cMPTEntryUrl = AnonymousClass3.this.f5165b.getCMPTEntryUrl();
                                int i10 = c.this.y;
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                bVar.a(z9, handler, z10, z11, str7, requestIdNotice, str8, str9, cMPTEntryUrl, i10, anonymousClass3.f5165b, c.this.H, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass3.this.f5165b.getCMPTEntryUrl()), str2, c.this.f5156u, new b.j() { // from class: com.mbridge.msdk.reward.adapter.c.3.2.1
                                    @Override // com.mbridge.msdk.reward.adapter.b.j
                                    public final void a(String str10, String str11, String str12, String str13, String str14, a.C0071a c0071a) {
                                        c cVar = c.this;
                                        CopyOnWriteArrayList copyOnWriteArrayList3 = cVar.H;
                                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                        boolean zA = cVar.a(copyOnWriteArrayList3, anonymousClass32.f5166c, anonymousClass32.f5167d);
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        if (zA) {
                                            c cVar2 = c.this;
                                            String str15 = cVar2.f5148l;
                                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                            c.a(cVar2, str15, copyOnWriteArrayList, c.this.U, c.this.A);
                                            if (c.this.O != null) {
                                                c.this.O.removeMessages(5);
                                            }
                                            if (c.this.t == null || c.this.h) {
                                                return;
                                            }
                                            c.this.h = true;
                                            AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                            com.mbridge.msdk.foundation.same.report.d.c cVar3 = anonymousClass33.f5164a;
                                            if (cVar3 != null) {
                                                cVar3.b(c.this.H);
                                            }
                                            c.this.t.a(c.this.H, AnonymousClass3.this.f5164a);
                                            return;
                                        }
                                        c cVar4 = c.this;
                                        c.a(cVar4, str12, cVar4.S, c.this.A, str13);
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        if (c.this.t == null || c.this.f5145i) {
                                            return;
                                        }
                                        c.this.f5145i = true;
                                        com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                        AnonymousClass3 anonymousClass34 = AnonymousClass3.this;
                                        if (anonymousClass34.f5164a == null) {
                                            anonymousClass34.f5164a = new com.mbridge.msdk.foundation.same.report.d.c();
                                        }
                                        AnonymousClass3 anonymousClass35 = AnonymousClass3.this;
                                        anonymousClass35.f5164a.b(c.this.H);
                                        AnonymousClass3.this.f5164a.a(bVarB);
                                        c.this.t.a(c.this.S, bVarB, AnonymousClass3.this.f5164a);
                                        af.a("RewardMVVideoAdapter", "Campaign 下载成功： 大模板预加载成功,isReady false onVideoLoadFail");
                                    }

                                    @Override // com.mbridge.msdk.reward.adapter.b.j
                                    public final void a(String str10, String str11, String str12, a.C0071a c0071a, com.mbridge.msdk.foundation.c.b bVar2) {
                                        if (bVar2 != null) {
                                            bVar2.a("his_reason", "errorCode: 3303 errorMessage: tpl temp preload failed");
                                        }
                                        if (AnonymousClass3.this.f5165b.getRsIgnoreCheckRule() != null && AnonymousClass3.this.f5165b.getRsIgnoreCheckRule().size() > 0 && AnonymousClass3.this.f5165b.getRsIgnoreCheckRule().contains(3)) {
                                            af.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                            return;
                                        }
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        c cVar = c.this;
                                        c.a(cVar, str2, cVar.S, c.this.A, str11);
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        if (c.this.t == null || c.this.f5145i) {
                                            return;
                                        }
                                        c.this.f5145i = true;
                                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                        if (anonymousClass32.f5164a == null) {
                                            anonymousClass32.f5164a = new com.mbridge.msdk.foundation.same.report.d.c();
                                        }
                                        AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                        anonymousClass33.f5164a.b(c.this.H);
                                        AnonymousClass3.this.f5164a.a(bVar2);
                                        c.this.t.a(c.this.S, bVar2, AnonymousClass3.this.f5164a);
                                        af.a("RewardMVVideoAdapter", "Campaign 下载成功： 大模板预加载失败 onVideoLoadFail");
                                    }
                                }, false);
                            }
                        });
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                final CampaignEx next = it.next();
                if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || c.this.O == null) {
                    str4 = str;
                    str5 = str2;
                    str6 = str3;
                    copyOnWriteArrayList2 = copyOnWriteArrayList;
                    c cVar = c.this;
                    boolean zA = cVar.a(cVar.H, this.f5166c, this.f5167d);
                    c cVar2 = c.this;
                    if (zA) {
                        c.a(cVar2, cVar2.f5148l, copyOnWriteArrayList2, c.this.U, c.this.A);
                        if (c.this.O != null) {
                            c.this.O.removeMessages(5);
                        }
                        if (c.this.t != null && !c.this.h) {
                            c.this.h = true;
                            com.mbridge.msdk.foundation.same.report.d.c cVar3 = this.f5164a;
                            if (cVar3 != null) {
                                cVar3.b(c.this.H);
                            }
                            c.this.t.a(c.this.H, this.f5164a);
                        }
                    } else {
                        c.a(cVar2, str5, cVar2.S, c.this.A, str6);
                        if (c.this.O != null) {
                            c.this.O.removeMessages(5);
                        }
                        if (c.this.t != null && !c.this.f5145i) {
                            c.this.f5145i = true;
                            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                            if (this.f5164a == null) {
                                this.f5164a = new com.mbridge.msdk.foundation.same.report.d.c();
                            }
                            this.f5164a.b(c.this.H);
                            this.f5164a.a(bVarB);
                            c.this.t.a(c.this.H, bVarB, this.f5164a);
                            af.a("RewardMVVideoAdapter", "Campaign 下载成功： 非大模板，不存在播放模板,isReay false onVideoLoadFail");
                        }
                    }
                } else {
                    str4 = str;
                    str5 = str2;
                    str6 = str3;
                    copyOnWriteArrayList2 = copyOnWriteArrayList;
                    c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b bVar = b.m.f5140a;
                            boolean z9 = c.this.I;
                            Handler handler = c.this.O;
                            boolean z10 = c.this.f5160z;
                            boolean z11 = c.this.A;
                            String strE = next.getRewardTemplateMode().e();
                            int i10 = c.this.y;
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            bVar.a(z9, handler, z10, z11, null, strE, i10, anonymousClass3.f5165b, c.this.H, H5DownLoadManager.getInstance().getH5ResAddress(next.getRewardTemplateMode().e()), str4, str5, str6, next.getRequestIdNotice(), c.this.f5156u, new b.j() { // from class: com.mbridge.msdk.reward.adapter.c.3.1.1
                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str7, String str8, String str9, String str10, String str11, a.C0071a c0071a) {
                                    c cVar4 = c.this;
                                    CopyOnWriteArrayList copyOnWriteArrayList3 = cVar4.H;
                                    AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                    boolean zA2 = cVar4.a(copyOnWriteArrayList3, anonymousClass32.f5166c, anonymousClass32.f5167d);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (zA2) {
                                        c cVar5 = c.this;
                                        String str12 = cVar5.f5148l;
                                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                        c.a(cVar5, str12, copyOnWriteArrayList2, c.this.U, c.this.A);
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        if (c.this.t == null || c.this.h) {
                                            return;
                                        }
                                        c.this.h = true;
                                        AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                        com.mbridge.msdk.foundation.same.report.d.c cVar6 = anonymousClass33.f5164a;
                                        if (cVar6 != null) {
                                            cVar6.b(c.this.H);
                                        }
                                        c.this.t.a(c.this.H, AnonymousClass3.this.f5164a);
                                        return;
                                    }
                                    c cVar7 = c.this;
                                    c.a(cVar7, str9, cVar7.S, c.this.A, str10);
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    if (c.this.t == null || c.this.f5145i) {
                                        return;
                                    }
                                    c.this.f5145i = true;
                                    com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                    AnonymousClass3 anonymousClass34 = AnonymousClass3.this;
                                    if (anonymousClass34.f5164a == null) {
                                        anonymousClass34.f5164a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    AnonymousClass3 anonymousClass35 = AnonymousClass3.this;
                                    anonymousClass35.f5164a.b(c.this.H);
                                    AnonymousClass3.this.f5164a.a(bVarB2);
                                    c.this.t.a(c.this.H, bVarB2, AnonymousClass3.this.f5164a);
                                    af.a("RewardMVVideoAdapter", "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay false onVideoLoadFail");
                                }

                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str7, String str8, String str9, a.C0071a c0071a, com.mbridge.msdk.foundation.c.b bVar2) {
                                    if (bVar2 != null) {
                                        bVar2.a("his_reason", "preload template failed is tpl :" + AnonymousClass3.this.f5166c);
                                    }
                                    if (AnonymousClass3.this.f5165b.getRsIgnoreCheckRule() != null && AnonymousClass3.this.f5165b.getRsIgnoreCheckRule().size() > 0 && AnonymousClass3.this.f5165b.getRsIgnoreCheckRule().contains(1)) {
                                        af.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    c cVar4 = c.this;
                                    c.a(cVar4, str5, cVar4.S, c.this.A, str8);
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    if (c.this.t == null || c.this.f5145i) {
                                        return;
                                    }
                                    c.this.f5145i = true;
                                    AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                    if (anonymousClass32.f5164a == null) {
                                        anonymousClass32.f5164a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                    anonymousClass33.f5164a.b(c.this.H);
                                    AnonymousClass3.this.f5164a.a(bVar2);
                                    c.this.t.a(c.this.S, bVar2, AnonymousClass3.this.f5164a);
                                    af.a("RewardMVVideoAdapter", "Campaign 下载失败： 非大模板，播放模板预加载失败 onVideoLoadFail");
                                }
                            });
                        }
                    });
                }
                str = str4;
                str2 = str5;
                str3 = str6;
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, final com.mbridge.msdk.foundation.c.b bVar) {
            c.this.e = false;
            if (c.this.t == null || c.this.O == null) {
                return;
            }
            c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.3
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = c.this;
                    c.a(cVar, cVar.f5148l, copyOnWriteArrayList, c.this.A, "");
                    if (c.this.O != null) {
                        c.this.O.removeMessages(5);
                    }
                    if (c.this.f5145i || c.this.t == null) {
                        return;
                    }
                    c.this.f5145i = true;
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    if (anonymousClass3.f5164a == null) {
                        anonymousClass3.f5164a = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                    anonymousClass32.f5164a.b(c.this.H);
                    com.mbridge.msdk.foundation.c.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a("errorCode: 3201 errorMessage: campaign resource download failed");
                    }
                    AnonymousClass3.this.f5164a.a(bVar);
                    c.this.t.a(copyOnWriteArrayList, bVar, AnonymousClass3.this.f5164a);
                    af.a("RewardMVVideoAdapter", "Campaign 下载失败：onVideoLoadFail");
                }
            });
        }
    }

    public final String a(boolean z9) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA;
        CampaignEx campaignEx;
        if (z9) {
            if (TextUtils.isEmpty(this.f5143c) && (copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f5148l)) != null && copyOnWriteArrayListA.size() > 0 && (campaignEx = copyOnWriteArrayListA.get(0)) != null) {
                this.f5143c = campaignEx.getRequestId();
            }
            return this.f5143c;
        }
        return this.f5142b;
    }

    public final void a(String str) {
        this.B = str;
    }

    public final void a(int i10) {
        this.y = i10;
    }

    public final String a() {
        return this.f5148l;
    }

    public final boolean a(CampaignEx campaignEx, boolean z9, com.mbridge.msdk.foundation.c.b bVar, int i10, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        c cVar2;
        com.mbridge.msdk.foundation.same.report.d.c cVar3;
        com.mbridge.msdk.foundation.b.c cVar4;
        com.mbridge.msdk.foundation.b.c cVar5 = new com.mbridge.msdk.foundation.b.c();
        com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(this.f5148l, this.f5160z);
        boolean z10 = false;
        if (aVar.a(this.K)) {
            return false;
        }
        if (!this.f5146j) {
            this.f5146j = true;
            cVar5 = aVar.a(this.K, cVar, campaignEx, bVar, i10, this);
            cVar3 = cVar;
            cVar2 = this;
            if (cVar5 != null && cVar5.g() > com.mbridge.msdk.foundation.b.c.f3328a) {
                if (cVar5.a() != null && cVar5.a().size() > 0) {
                    a(cVar5.a(), true, true);
                } else if (cVar5.g() == com.mbridge.msdk.foundation.b.c.f3330c && bVar != null) {
                    bVar.a(com.mbridge.msdk.foundation.c.a.b(880038));
                    bVar.c(cVar5.b());
                }
            }
            cVar4 = cVar5;
            aVar.a(cVar3, cVar2.K, cVar4, (List<a.C0025a>) null, (JSONObject) null, 3);
            return z10;
        }
        cVar2 = this;
        cVar3 = cVar;
        cVar5.d("isCandidate:false");
        cVar5.a(com.mbridge.msdk.foundation.b.c.f3330c);
        cVar4 = cVar5;
        z10 = true;
        aVar.a(cVar3, cVar2.K, cVar4, (List<a.C0025a>) null, (JSONObject) null, 3);
        return z10;
    }

    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        try {
            this.f5156u = cVar;
            if (cVar == null || cVar.D() * 1000 == com.mbridge.msdk.foundation.same.a.L) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.L = this.f5156u.D() * 1000;
        } catch (Throwable th) {
            af.b("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    private boolean a(List<CampaignEx> list, boolean z9, int i10, boolean z10) {
        return a(list, z9, i10, false, z10);
    }

    public final boolean a(List<CampaignEx> list, boolean z9, int i10) {
        return a(list, z9, i10, false, false);
    }

    public final boolean a(List<CampaignEx> list, boolean z9) {
        if (list == null || list.size() <= 0) {
            af.a("RewardVideoController", "数据为空");
        } else {
            CampaignEx campaignEx = list.get(0);
            if (campaignEx == null) {
                return false;
            }
            com.mbridge.msdk.videocommon.download.b bVar = com.mbridge.msdk.videocommon.download.b.getInstance();
            String str = this.f5148l;
            j jVarC = bVar.c(str);
            if (jVarC == null) {
                jVarC = bVar.createUnitCache(com.mbridge.msdk.foundation.controller.c.m().c(), str, (CopyOnWriteArrayList<CampaignEx>) list, 94, (com.mbridge.msdk.videocommon.listener.a) null);
            }
            if (jVarC != null ? jVarC.a(list, str) : false) {
                if (z9) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            af.c("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        }
                        if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            af.c("RewardMVVideoAdapter", "Is not check big template ENDCARD download status");
                            return true;
                        }
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f5148l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        af.a("RewardVideoController", "大模板业务，开始检查大模板预加载情况，大模板预加载成功");
                        return true;
                    }
                } else {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        af.c("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    }
                    if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        af.a("RewardVideoController", "非大模板 没有 template");
                        return true;
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f5148l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                        af.a("RewardVideoController", "非大模板业务，存在播放模板，播放模板预加载成功");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean a(List<CampaignEx> list, boolean z9, int i10, boolean z10, boolean z11) throws Throwable {
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        e eVar = new e();
        if (list != null && list.size() > 0) {
            CampaignEx campaignEx = list.get(0);
            boolean zA = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, this.f5148l, this.A, list.size(), z9, i10, list, z10, eVar);
            eVar.a("event_name", "is_ready_crwtpl_" + zA);
            if (z11) {
                a(cVar, eVar, list);
            }
            if (zA) {
                if (z9) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            af.c("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        }
                        if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            af.c("RewardMVVideoAdapter", "Is not check big template of ENDCARD download status");
                            return true;
                        }
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f5148l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        return true;
                    }
                    if (z11) {
                        eVar.a("event_name", "is_ready_crwtpl_" + zA);
                        eVar.a("reason", "h5 big template checkPreLoadState error");
                        a(cVar, eVar, list);
                    }
                } else {
                    if (campaignEx != null && campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        af.c("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    }
                    if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        return true;
                    }
                    String str = this.f5148l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e();
                    if (z11) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str, true);
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(str)) {
                        return true;
                    }
                    if (z11) {
                        eVar.a("event_name", "is_ready_crwtpl_" + zA);
                        eVar.a("reason", "h5 template checkPreLoadState error");
                        a(cVar, eVar, list);
                    }
                }
            }
        } else {
            eVar.a("event_name", "is_ready_crwtpl_empty");
            eVar.a("reason", "campaign list is empty error");
        }
        a(cVar, eVar, list);
        return false;
    }

    public final void a(h hVar, String str, String str2, int i10, String str3, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        try {
            this.f5155s = hVar;
            if (this.f5147k != null && !ap.a(this.f5148l)) {
                Intent intent = new Intent(this.f5147k, (Class<?>) MBRewardVideoActivity.class);
                intent.putExtra(MBRewardVideoActivity.INTENT_UNITID, this.f5148l);
                intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.f5149m);
                intent.putExtra(MBRewardVideoActivity.INTENT_REWARD, str);
                intent.putExtra(MBRewardVideoActivity.INTENT_MUTE, i10);
                intent.putExtra(MBRewardVideoActivity.INTENT_ISIV, this.f5160z);
                intent.putExtra(MBRewardVideoActivity.INTENT_ISBID, this.A);
                intent.putExtra(MBRewardVideoActivity.INTENT_EXTRADATA, str3);
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f5148l);
                boolean z9 = false;
                if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                    CampaignEx campaignEx = copyOnWriteArrayListA.get(0);
                    if (campaignEx != null) {
                        this.f5143c = campaignEx.getRequestId();
                    }
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                        z9 = true;
                    }
                    g();
                } else {
                    h hVar2 = this.f5155s;
                    if (hVar2 != null) {
                        hVar2.a(cVar, "load failed");
                        return;
                    }
                }
                intent.putExtra(MBRewardVideoActivity.INTENT_ISBIG_OFFER, z9);
                if (this.f5160z) {
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_MODETYPE, this.D);
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUETYPE, this.E);
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUE, this.F);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra(MBRewardVideoActivity.INTENT_USERID, str2);
                }
                RewardUnitCacheManager.getInstance().add(this.f5149m, this.f5148l, this.f5156u);
                try {
                    if (com.mbridge.msdk.foundation.controller.c.m() != null && com.mbridge.msdk.foundation.controller.c.m().e() != null) {
                        ((Activity) com.mbridge.msdk.foundation.controller.c.m().e()).startActivity(intent);
                        return;
                    }
                } catch (Throwable th) {
                    af.b("RewardMVVideoAdapter", th.getMessage());
                }
                intent.addFlags(268435456);
                this.f5147k.startActivity(intent);
                return;
            }
            h hVar3 = this.f5155s;
            if (hVar3 != null) {
                hVar3.a(cVar, "context or unitid is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            h hVar4 = this.f5155s;
            if (hVar4 != null) {
                hVar4.a(cVar, "show failed, exception is " + e.getMessage());
            }
        }
    }

    public final void a(int i10, int i11, boolean z9, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        a(i10, i11, z9, "", this.I, cVar);
    }

    public final void a(int i10, int i11, boolean z9, String str, boolean z10, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        CampaignEx campaignEx;
        this.f5151o = i10;
        this.f5152p = i11;
        this.f5153q = z9;
        this.K = str;
        this.I = z10;
        boolean zA = false;
        this.f5146j = false;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.H;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && (campaignEx = this.H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
            this.H.clear();
        }
        List<CampaignEx> list = this.S;
        if (list != null) {
            list.clear();
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.T;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
        this.e = false;
        this.f = false;
        synchronized (this.f5141a) {
            try {
                if (this.g) {
                    this.g = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5145i = false;
        this.h = false;
        try {
            zA = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(this.f5147k);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardMVVideoAdapter", e.getMessage());
            }
        }
        if (!zA) {
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is WebView is not available");
            if (cVar != null) {
                cVar.a(bVarB);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is WebView is not available", cVar);
            return;
        }
        if (this.f5147k == null) {
            com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null");
            if (cVar != null) {
                cVar.a(bVarB2);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null", cVar);
            return;
        }
        if (ap.a(this.f5148l)) {
            com.mbridge.msdk.foundation.c.b bVarB3 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null");
            if (cVar != null) {
                cVar.a(bVarB3);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null", cVar);
            return;
        }
        if (this.f5156u == null) {
            com.mbridge.msdk.foundation.c.b bVarB4 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null");
            if (cVar != null) {
                cVar.a(bVarB4);
            }
            b("RewardUnitSetting is null", cVar);
            return;
        }
        l();
        m();
        af.c("RewardMVVideoAdapter", "load 开始清除过期数据");
        i();
        b(str, z10, cVar);
    }

    private void a(String str, boolean z9, final com.mbridge.msdk.foundation.same.report.d.c cVar) {
        boolean zB;
        try {
            if (this.f5147k == null) {
                com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null");
                if (cVar != null) {
                    cVar.a(bVarB);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null", cVar);
                return;
            }
            if (ap.a(this.f5148l)) {
                com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null");
                if (cVar != null) {
                    cVar.a(bVarB2);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null", cVar);
                return;
            }
            if (this.f5156u == null) {
                com.mbridge.msdk.foundation.c.b bVarB3 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null");
                if (cVar != null) {
                    cVar.a(bVarB3);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null", cVar);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (System.currentTimeMillis() - this.J < this.f5156u.a() * 1000) {
                    com.mbridge.msdk.foundation.c.b bVarB4 = com.mbridge.msdk.foundation.c.a.b(880018, "errorCode: 3507 errorMessage: data load failed, errorMsg is EXCEPTION_RETURN_EMPTY");
                    if (cVar != null) {
                        cVar.a(bVarB4);
                        cVar.c(true);
                    }
                    b("errorCode: 3507 errorMessage: data load failed, errorMsg is EXCEPTION_RETURN_EMPTY", cVar);
                    return;
                }
            }
            String strF = "";
            if (cVar != null) {
                strF = cVar.f();
            }
            com.mbridge.msdk.foundation.same.net.f.e eVarA = new d(this.f5149m, this.f5148l, this.f5160z, this.f5156u, strF).a(this.f5153q, this.f5154r, this.f5150n, k(), "", this.C, str, z9, this.D);
            if (eVarA == null) {
                com.mbridge.msdk.foundation.c.b bVarB5 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Load param is null");
                if (cVar != null) {
                    cVar.a(bVarB5);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is Load param is null", cVar);
                return;
            }
            this.Q = System.currentTimeMillis();
            com.mbridge.msdk.reward.d.b bVar = new com.mbridge.msdk.reward.d.b(this.f5147k);
            com.mbridge.msdk.reward.d.a aVar = new com.mbridge.msdk.reward.d.a() { // from class: com.mbridge.msdk.reward.adapter.c.2
                @Override // com.mbridge.msdk.reward.d.a
                public final void a(CampaignUnit campaignUnit) throws Throwable {
                    CampaignEx campaignEx;
                    try {
                        c.a(c.this, campaignUnit);
                        c.b(c.this, campaignUnit);
                        if (campaignUnit != null) {
                            c.this.f5142b = campaignUnit.getRequestId();
                        }
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                        if (c.this.H != null && c.this.H.size() > 0 && (campaignEx = (CampaignEx) c.this.H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                            c.this.H.clear();
                        }
                        if (c.this.S != null) {
                            c.this.S.clear();
                        }
                        c.this.e = false;
                        c.this.f = false;
                        synchronized (c.this.f5141a) {
                            try {
                                if (c.this.g) {
                                    c.this.g = false;
                                }
                                c.this.f5145i = false;
                                c.this.h = false;
                                c.this.b("exception after load success", cVar);
                                c.this.j();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }

                @Override // com.mbridge.msdk.reward.d.a
                public final void a(int i10, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
                    CampaignEx campaignEx;
                    if (i10 == -1) {
                        c.this.J = System.currentTimeMillis();
                    }
                    if (c.this.H != null && c.this.H.size() > 0 && (campaignEx = (CampaignEx) c.this.H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                        c.this.H.clear();
                    }
                    if (c.this.S != null) {
                        c.this.S.clear();
                    }
                    c.this.e = false;
                    c.this.f = false;
                    synchronized (c.this.f5141a) {
                        try {
                            if (c.this.g) {
                                c.this.g = false;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    c.a(c.this, cVar2, i10);
                    c.this.f5145i = false;
                    c.this.h = false;
                    if (!c.this.P) {
                        c.this.a(i10, str2, cVar2);
                    }
                    c.this.j();
                }
            };
            aVar.a(str);
            aVar.setUnitId(this.f5148l);
            aVar.setPlacementId(this.f5149m);
            aVar.setAdType(this.f5160z ? 287 : 94);
            aVar.a(cVar);
            try {
                zB = com.mbridge.msdk.videocommon.download.h.a().b(this.f5160z ? 287 : 94);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardMVVideoAdapter", "isRewardVideoRefactorForCampaignRequest exception " + e.getMessage());
                }
                zB = false;
            }
            boolean z10 = zB;
            try {
                if (com.mbridge.msdk.foundation.same.net.e.c.a().a(eVarA) == null) {
                    e eVar = new e();
                    eVar.a("hst", h());
                    cVar.a("2000125", eVar);
                    com.mbridge.msdk.reward.c.a.a.a().a("2000125", cVar);
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
            if (z10) {
                com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_c", com.mbridge.msdk.foundation.same.a.f3612p);
                com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_r", com.mbridge.msdk.foundation.same.a.f3613q);
                com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_w", com.mbridge.msdk.foundation.same.a.f3613q);
                com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_r_c", com.mbridge.msdk.foundation.same.a.f3614r);
                bVar.getCampaign(1, str, eVarA, aVar, com.mbridge.msdk.foundation.same.c.a(this.f5152p * 1000, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS));
                return;
            }
            String str2 = com.mbridge.msdk.foundation.same.a.f3601a;
            try {
                g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                if (gVarA != null) {
                    gVarA.f();
                    gVarA.h();
                    gVarA.e();
                    gVarA.g();
                }
            } catch (Exception e7) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardMVVideoAdapter", e7.getMessage());
                }
            }
            bVar.choiceV3OrV5BySetting(1, eVarA, aVar, str, com.mbridge.msdk.foundation.same.c.a(this.f5152p * 1000, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS));
        } catch (Exception e10) {
            e10.printStackTrace();
            b("Load exception", cVar);
            j();
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.O != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.f());
                messageObtain.setData(bundle);
            }
            this.O.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.O != null) {
            if (TextUtils.isEmpty(str)) {
                str = "load fail exception";
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = str;
            messageObtain.arg1 = i10;
            if (cVar != null) {
                cVar.c(true);
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.f());
                messageObtain.setData(bundle);
            }
            boolean zContains = str.contains("exception");
            Handler handler = this.O;
            if (zContains) {
                handler.sendMessageAtFrontOfQueue(messageObtain);
            } else {
                handler.sendMessage(messageObtain);
            }
        }
    }

    private void a(com.mbridge.msdk.foundation.db.j jVar, CampaignEx campaignEx) {
        if (jVar == null || jVar.b(campaignEx.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
        gVar.a(campaignEx.getId());
        gVar.b(campaignEx.getFca());
        gVar.c(campaignEx.getFcb());
        gVar.a(0);
        gVar.d(0);
        gVar.a(System.currentTimeMillis());
        jVar.a(gVar);
    }

    private void a(String str, String str2, List<CampaignEx> list) {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().a(str, str2, list);
        }
    }

    public final void a(com.mbridge.msdk.reward.adapter.a aVar) {
        this.t = aVar;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, boolean z9, boolean z10) {
        com.mbridge.msdk.foundation.same.report.d.c metricsData;
        try {
            if (z10) {
                this.S = copyOnWriteArrayList;
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
                this.T = copyOnWriteArrayList2;
                metricsData = c(copyOnWriteArrayList2);
            } else {
                metricsData = this.G.getMetricsData();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardMVVideoAdapter", e.getMessage());
            }
            metricsData = null;
        }
        a(this.G, copyOnWriteArrayList);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            af.c("RewardMVVideoAdapter", "onload load fail, callback campaign have not video");
            if (TextUtils.isEmpty(this.R)) {
                this.R = "APP ALREADY INSTALLED";
            }
            a(this.R.contains("INSTALL") ? 880021 : 880003, this.R, metricsData);
            return;
        }
        af.c("RewardMVVideoAdapter", "onload load success size:" + copyOnWriteArrayList.size());
        if (z9) {
            e eVar = new e();
            if (z10) {
                eVar.a("cache", 1);
            } else {
                eVar.a("cache", 2);
            }
            if (metricsData != null) {
                metricsData.a("2000127", eVar);
                metricsData.a("2000048", eVar);
            }
            a(metricsData);
        }
        CampaignUnit campaignUnit = this.G;
        if (campaignUnit != null) {
            b(campaignUnit.getSessionId());
        }
        b(copyOnWriteArrayList);
        if (copyOnWriteArrayList.size() > 0) {
            af.c("RewardMVVideoAdapter", "#######onload 把广告存在本地 size:" + copyOnWriteArrayList.size());
            a(this.f5149m, this.f5148l, copyOnWriteArrayList);
        }
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        this.H = copyOnWriteArrayList;
        a(campaignEx);
    }

    private void a(CampaignEx campaignEx) {
        boolean zIsEmpty = TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        boolean z9 = !zIsEmpty;
        int nscpt = campaignEx.getNscpt();
        this.e = false;
        this.f = false;
        synchronized (this.f5141a) {
            try {
                if (this.g) {
                    this.g = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5145i = false;
        this.h = false;
        if (this.A) {
            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getBidToken(), campaignEx.getCampaignUnitId(), campaignEx.getEncryptPrice());
        }
        b.m.f5140a.a(this.f5147k, z9, nscpt, this.A, this.f5160z ? 287 : 94, this.f5149m, this.f5148l, campaignEx.getRequestId(), this.H, new AnonymousClass3(campaignEx, z9, nscpt), new AnonymousClass4(campaignEx, z9, nscpt));
        if (zIsEmpty) {
            return;
        }
        b.m.f5140a.a(this.f5147k, campaignEx, this.f5149m, this.f5148l, campaignEx.getRequestId(), new AnonymousClass5(campaignEx, z9, nscpt));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r11, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r12, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            if (r12 == 0) goto L32
            int r1 = r12.size()     // Catch: java.lang.Exception -> L2e
            if (r1 <= 0) goto L32
            r1 = 0
            java.lang.Object r1 = r12.get(r1)     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch: java.lang.Exception -> L2e
            if (r1 == 0) goto L32
            java.lang.String r2 = r1.getRequestId()     // Catch: java.lang.Exception -> L2e
            int r3 = r1.getVcn()     // Catch: java.lang.Exception -> L2e
            java.lang.String r4 = r1.getBidToken()     // Catch: java.lang.Exception -> L2e
            java.lang.String r5 = r1.getNLRid()     // Catch: java.lang.Exception -> L2e
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L2e
            if (r5 == 0) goto L35
            java.lang.String r0 = r1.getLocalRequestId()     // Catch: java.lang.Exception -> L2e
            goto L35
        L2e:
            r0 = move-exception
            r11 = r0
            goto Lc8
        L32:
            r3 = 1
            r2 = r0
            r4 = r2
        L35:
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()     // Catch: java.lang.Exception -> L2e
            if (r1 == 0) goto L49
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()     // Catch: java.lang.Exception -> L2e
            r1.b(r11, r0)     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch: java.lang.Exception -> L2e
            r0.b(r11)     // Catch: java.lang.Exception -> L2e
        L49:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L56
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch: java.lang.Exception -> L2e
            r0.b(r11, r3)     // Catch: java.lang.Exception -> L2e
        L56:
            if (r12 == 0) goto L8f
            int r0 = r12.size()     // Catch: java.lang.Exception -> L2e
            if (r0 <= 0) goto L8f
            com.mbridge.msdk.reward.b.a.a(r2, r4)     // Catch: java.lang.Exception -> L2e
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Exception -> L2e
        L65:
            boolean r0 = r12.hasNext()     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L8f
            java.lang.Object r0 = r12.next()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L65
            java.lang.String r1 = r0.getCampaignUnitId()     // Catch: java.lang.Exception -> L2e
            java.lang.String r2 = r0.getRequestId()     // Catch: java.lang.Exception -> L2e
            java.lang.String r3 = r0.getId()     // Catch: java.lang.Exception -> L2e
            long r4 = r0.getPlct()     // Catch: java.lang.Exception -> L2e
            long r6 = r0.getPlctb()     // Catch: java.lang.Exception -> L2e
            long r8 = r0.getTimestamp()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.same.a.b.a(r1, r2, r3, r4, r6, r8)     // Catch: java.lang.Exception -> L2e
            goto L65
        L8f:
            if (r13 == 0) goto Lb5
            int r12 = r13.size()     // Catch: java.lang.Exception -> L2e
            if (r12 <= 0) goto Lb5
            java.util.Iterator r12 = r13.iterator()     // Catch: java.lang.Exception -> L2e
        L9b:
            boolean r13 = r12.hasNext()     // Catch: java.lang.Exception -> L2e
            if (r13 == 0) goto Lb5
            java.lang.Object r13 = r12.next()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch: java.lang.Exception -> L2e
            if (r13 == 0) goto L9b
            java.lang.String r0 = r13.getCampaignUnitId()     // Catch: java.lang.Exception -> L2e
            java.lang.String r13 = r13.getRequestId()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.same.a.b.c(r0, r13)     // Catch: java.lang.Exception -> L2e
            goto L9b
        Lb5:
            com.mbridge.msdk.foundation.same.a.b.c(r11)     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.controller.c r11 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L2e
            android.content.Context r11 = r11.c()     // Catch: java.lang.Exception -> L2e
            com.mbridge.msdk.foundation.db.b r11 = com.mbridge.msdk.foundation.db.b.a(r11)     // Catch: java.lang.Exception -> L2e
            r11.a()     // Catch: java.lang.Exception -> L2e
            return
        Lc8:
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r12 == 0) goto Lcf
            r11.printStackTrace()
        Lcf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(java.lang.String, java.util.List, java.util.List):void");
    }

    private void a(final CampaignUnit campaignUnit, List<CampaignEx> list) {
        com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.7
            @Override // java.lang.Runnable
            public final void run() {
                com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(c.this.f5147k)).a();
                CampaignUnit campaignUnit2 = campaignUnit;
                if (campaignUnit2 == null || campaignUnit2.getAds() == null || campaignUnit.getAds().size() <= 0) {
                    return;
                }
                c.a(c.this, campaignUnit.getAds());
            }
        });
    }

    public final void a(List<CampaignEx> list) {
        this.U = list;
    }

    public final void a(int i10, int i11, int i12) {
        this.D = i10;
        this.E = i11;
        this.F = i12;
    }

    public final void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f5156u != null && TextUtils.isEmpty(str)) {
            int iB = this.f5156u.b() * 1000;
            List<CampaignEx> list = this.U;
            if (list != null && list.size() > 0) {
                if (System.currentTimeMillis() - this.U.get(0).getTimestamp() < iB) {
                    b("hit ltorwc", cVar);
                    return;
                }
            }
        }
        a(str, this.I, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.d.c a(Message message) {
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    return com.mbridge.msdk.foundation.same.report.d.d.a().a(data.getString("metrics_data_lrid"), "");
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return cVar;
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.c cVar, e eVar, List<CampaignEx> list) {
        if (cVar != null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        cVar.b(list);
                        CampaignEx campaignEx = list.get(0);
                        if (campaignEx != null) {
                            cVar.c(campaignEx.getLocalRequestId());
                        }
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            cVar.d(this.f5148l);
            cVar.b(this.f5160z ? 287 : 94);
            if (eVar != null) {
                cVar.a("m_temp_is_ready_check", eVar);
            }
            com.mbridge.msdk.reward.c.a.a.a().a("m_temp_is_ready_check", cVar);
        }
    }

    public static /* synthetic */ void a(c cVar, String str, List list, List list2, boolean z9) {
        com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2, z9);
        if (list2 != null && list2.size() > 0) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                CampaignEx campaignEx = (CampaignEx) it.next();
                if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    StringBuilder sbW = a3.a.w(str, "_");
                    sbW.append(campaignEx.getId());
                    sbW.append("_");
                    sbW.append(campaignEx.getRequestId());
                    sbW.append("_");
                    sbW.append(campaignEx.getRewardTemplateMode().e());
                    com.mbridge.msdk.videocommon.a.b(sbW.toString());
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                }
            }
        }
        if (z9) {
            cVar.a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2);
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            CampaignEx campaignEx2 = (CampaignEx) list.get(0);
            com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(str, cVar.f5160z);
            if (campaignEx2 == null || !TextUtils.isEmpty(campaignEx2.getNLRid())) {
                return;
            }
            aVar.a(campaignEx2.getLocalRequestId(), campaignEx2.getRequestId(), 1, campaignEx2.getEcppv());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void a(c cVar, String str, List list, boolean z9, String str2) {
        CampaignEx campaignEx;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && ((campaignEx = (CampaignEx) list.get(0)) == null || TextUtils.isEmpty(campaignEx.getEcppv()) || TextUtils.isEmpty(str2))) {
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (List<CampaignEx>) list, z9);
        } else {
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (CampaignEx) null, z9, str2);
        }
    }

    public static /* synthetic */ void a(c cVar, CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.c metricsData = campaignUnit.getMetricsData();
            if (metricsData != null) {
                e eVar = new e();
                eVar.a("result", 1);
                eVar.a("timeout", Integer.valueOf(cVar.f5152p));
                eVar.a("hst", cVar.h());
                metricsData.b(campaignUnit.getAds());
                metricsData.a("2000126", eVar);
                campaignUnit.setLocalRequestId(metricsData.f());
                com.mbridge.msdk.reward.c.a.a.a().a("2000126", metricsData);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[Catch: Exception -> 0x00a2, TryCatch #0 {Exception -> 0x00a2, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x0021, B:16:0x002c, B:18:0x004a, B:20:0x0052, B:22:0x0056, B:25:0x005f, B:27:0x0078, B:26:0x006d, B:28:0x008e, B:15:0x0027), top: B:35:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(com.mbridge.msdk.reward.adapter.c r5, com.mbridge.msdk.foundation.same.report.d.c r6, int r7) {
        /*
            java.lang.String r0 = "2000126"
            if (r6 == 0) goto Laa
            boolean r1 = r6.r()     // Catch: java.lang.Exception -> La2
            if (r1 != 0) goto Laa
            com.mbridge.msdk.foundation.same.report.d.e r1 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch: java.lang.Exception -> La2
            r1.<init>()     // Catch: java.lang.Exception -> La2
            r2 = 3
            java.lang.String r3 = "result"
            if (r7 == r2) goto L27
            r2 = 880023(0xd6d97, float:1.233175E-39)
            if (r7 == r2) goto L27
            r2 = 880041(0xd6da9, float:1.2332E-39)
            if (r7 == r2) goto L27
            switch(r7) {
                case 10: goto L27;
                case 11: goto L27;
                case 12: goto L27;
                default: goto L21;
            }
        L21:
            java.lang.String r7 = "1"
            r1.a(r3, r7)     // Catch: java.lang.Exception -> La2
            goto L2c
        L27:
            java.lang.String r7 = "2"
            r1.a(r3, r7)     // Catch: java.lang.Exception -> La2
        L2c:
            java.lang.String r7 = "timeout"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La2
            r2.<init>()     // Catch: java.lang.Exception -> La2
            int r3 = r5.f5152p     // Catch: java.lang.Exception -> La2
            r2.append(r3)     // Catch: java.lang.Exception -> La2
            java.lang.String r3 = ""
            r2.append(r3)     // Catch: java.lang.Exception -> La2
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> La2
            r1.a(r7, r2)     // Catch: java.lang.Exception -> La2
            com.mbridge.msdk.foundation.c.b r7 = r6.o()     // Catch: java.lang.Exception -> La2
            if (r7 == 0) goto L8e
            java.lang.String r2 = "campaign_request_error"
            java.lang.Object r2 = r7.a(r2)     // Catch: java.lang.Exception -> La2
            if (r2 == 0) goto L8e
            boolean r3 = r2 instanceof com.mbridge.msdk.foundation.same.net.a.a     // Catch: java.lang.Exception -> La2
            if (r3 == 0) goto L8e
            r3 = r2
            com.mbridge.msdk.foundation.same.net.a.a r3 = (com.mbridge.msdk.foundation.same.net.a.a) r3     // Catch: java.lang.Exception -> La2
            com.mbridge.msdk.foundation.same.net.d.a r3 = r3.f3704c     // Catch: java.lang.Exception -> La2
            java.lang.String r4 = "code"
            if (r3 == 0) goto L6d
            com.mbridge.msdk.foundation.same.net.a.a r2 = (com.mbridge.msdk.foundation.same.net.a.a) r2     // Catch: java.lang.Exception -> La2
            com.mbridge.msdk.foundation.same.net.d.a r2 = r2.f3704c     // Catch: java.lang.Exception -> La2
            int r2 = r2.f3713d     // Catch: java.lang.Exception -> La2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La2
            r1.a(r4, r2)     // Catch: java.lang.Exception -> La2
            goto L78
        L6d:
            int r2 = r7.a()     // Catch: java.lang.Exception -> La2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La2
            r1.a(r4, r2)     // Catch: java.lang.Exception -> La2
        L78:
            java.lang.String r2 = "reason"
            java.lang.String r3 = r7.b()     // Catch: java.lang.Exception -> La2
            r1.a(r2, r3)     // Catch: java.lang.Exception -> La2
            java.lang.String r2 = "err_desc"
            java.lang.String r7 = r7.l()     // Catch: java.lang.Exception -> La2
            r1.a(r2, r7)     // Catch: java.lang.Exception -> La2
            r7 = 0
            r6.a(r7)     // Catch: java.lang.Exception -> La2
        L8e:
            java.lang.String r7 = "hst"
            java.lang.String r5 = r5.h()     // Catch: java.lang.Exception -> La2
            r1.a(r7, r5)     // Catch: java.lang.Exception -> La2
            r6.a(r0, r1)     // Catch: java.lang.Exception -> La2
            com.mbridge.msdk.reward.c.a.a r5 = com.mbridge.msdk.reward.c.a.a.a()     // Catch: java.lang.Exception -> La2
            r5.a(r0, r6)     // Catch: java.lang.Exception -> La2
            return
        La2:
            r5 = move-exception
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r6 == 0) goto Laa
            r5.printStackTrace()
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(com.mbridge.msdk.reward.adapter.c, com.mbridge.msdk.foundation.same.report.d.c, int):void");
    }

    public static /* synthetic */ void a(c cVar, List list) {
        if (cVar.f5147k == null || list == null || list.size() == 0) {
            return;
        }
        com.mbridge.msdk.foundation.db.j jVarA = com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(cVar.f5147k));
        for (int i10 = 0; i10 < list.size(); i10++) {
            CampaignEx campaignEx = (CampaignEx) list.get(i10);
            if (campaignEx != null) {
                if (com.mbridge.msdk.e.b.a()) {
                    if (!ak.c(cVar.f5147k, campaignEx.getPackageName())) {
                        cVar.a(jVarA, campaignEx);
                    }
                } else {
                    cVar.a(jVarA, campaignEx);
                }
            }
        }
    }
}
