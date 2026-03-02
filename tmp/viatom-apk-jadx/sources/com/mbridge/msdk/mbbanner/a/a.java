package com.mbridge.msdk.mbbanner.a;

import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.as;
import com.mbridge.msdk.mbbanner.common.c.c;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.List;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f4156a = "BannerController";

    /* renamed from: b, reason: collision with root package name */
    private String f4157b;

    /* renamed from: c, reason: collision with root package name */
    private String f4158c;

    /* renamed from: d, reason: collision with root package name */
    private String f4159d;
    private MBridgeIds e;
    private boolean f;
    private int g;
    private MBBannerView h;

    /* renamed from: i, reason: collision with root package name */
    private int f4160i;

    /* renamed from: j, reason: collision with root package name */
    private int f4161j;

    /* renamed from: k, reason: collision with root package name */
    private int f4162k;

    /* renamed from: m, reason: collision with root package name */
    private BannerAdListener f4164m;

    /* renamed from: n, reason: collision with root package name */
    private CampaignUnit f4165n;

    /* renamed from: o, reason: collision with root package name */
    private c f4166o;

    /* renamed from: p, reason: collision with root package name */
    private k f4167p;

    /* renamed from: q, reason: collision with root package name */
    private j f4168q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f4169r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f4170s;
    private boolean t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f4171u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f4172v;

    /* renamed from: l, reason: collision with root package name */
    private int f4163l = -1;

    /* renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.c f4173w = new com.mbridge.msdk.mbbanner.common.b.c() { // from class: com.mbridge.msdk.mbbanner.a.a.1
        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void a(CampaignEx campaignEx) {
            a.this.d();
            if (a.this.f4164m != null) {
                a.this.f4164m.onLogImpression(a.this.e);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(a.this.f4157b, campaignEx.getLocalRequestId());
                cVarA.a(campaignEx);
                cVarA.i(campaignEx.isBidCampaign() ? "1" : "2");
                int i10 = 1;
                cVarA.g(a.this.f4166o != null ? a.this.f4166o.b() : 1);
                if (a.this.f4162k != 0) {
                    i10 = 2;
                }
                cVarA.d(i10);
                cVarA.e(a.this.f4162k);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000128", cVarA, null);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000130", cVarA, null);
            } catch (Exception e) {
                af.b(a.f4156a, e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void b() {
            if (a.this.f4164m != null) {
                a.this.f4164m.onLeaveApp(a.this.e);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void c() {
            if (a.this.f4164m != null) {
                a.this.f4164m.showFullScreen(a.this.e);
                a.this.f4172v = true;
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, a.this.f4158c, a.this.f4157b, null, null);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void d() {
            if (a.this.f4164m != null) {
                a.this.f4164m.closeFullScreen(a.this.e);
                a.this.f4172v = false;
                com.mbridge.msdk.mbbanner.common.c.a.a().a(3, a.this.f4158c, a.this.f4157b, new com.mbridge.msdk.mbbanner.common.a.a(a.this.f4161j + "x" + a.this.f4160i, a.this.f4162k * 1000), a.this.f4174x);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void e() {
            if (a.this.f4164m != null) {
                a.this.f4164m.onCloseBanner(a.this.e);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void a(List<CampaignEx> list) {
            af.b(a.f4156a, "onShowSuccessed:");
            if (a.this.f4164m != null) {
                a.this.f4164m.onLoadSuccessed(a.this.e);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(a.this.f4157b, list.get(0).getLocalRequestId());
                cVarA.b(list);
                cVarA.g(1);
                cVarA.f(TextUtils.isEmpty(list.get(0).getBannerUrl()) ? 2 : 1);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000048", cVarA, null);
            } catch (Exception e) {
                af.b(a.f4156a, e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void a(b bVar) {
            a.this.a(bVar);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void a() {
            if (a.this.f4164m != null) {
                a.this.f4164m.onClick(a.this.e);
            }
        }
    };

    /* renamed from: x, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.b f4174x = new com.mbridge.msdk.mbbanner.common.b.b() { // from class: com.mbridge.msdk.mbbanner.a.a.2
        @Override // com.mbridge.msdk.mbbanner.common.b.b
        public final void a(b bVar) {
            a.a(a.this, 2, bVar);
            a.this.a(bVar.f(), bVar);
            a.this.d();
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.b
        public final void b(b bVar) {
            a.this.a(bVar.f(), bVar);
            a.this.d();
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.b
        public final void a(String str, CampaignUnit campaignUnit, boolean z9) {
            a.this.f4165n = campaignUnit;
            a.a(a.this, 1, (b) null);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.b
        public final void a(String str, int i10, boolean z9) throws JSONException {
            if (a.this.h != null) {
                a.this.f4171u = true;
                a.this.i();
            }
        }
    };

    public a(MBBannerView mBBannerView, BannerSize bannerSize, String str, String str2) {
        this.h = mBBannerView;
        if (bannerSize != null) {
            this.f4160i = bannerSize.getHeight();
            this.f4161j = bannerSize.getWidth();
        }
        this.f4157b = str2;
        str = TextUtils.isEmpty(str) ? "" : str;
        this.f4158c = str;
        this.e = new MBridgeIds(str, this.f4157b);
        String strK = com.mbridge.msdk.foundation.controller.c.m().k();
        String strB = com.mbridge.msdk.foundation.controller.c.m().b();
        if (this.f4168q == null) {
            this.f4168q = new j();
        }
        this.f4168q.a(com.mbridge.msdk.foundation.controller.c.m().c(), strK, strB, this.f4157b);
        h();
    }

    private void h() {
        k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f4157b);
        this.f4167p = kVarD;
        if (kVarD == null) {
            this.f4167p = k.d(this.f4157b);
        }
        if (this.f4163l == -1) {
            this.f4162k = b(this.f4167p.q());
        }
        if (this.g == 0) {
            boolean z9 = this.f4167p.f() == 1;
            this.f = z9;
            c cVar = this.f4166o;
            if (cVar != null) {
                cVar.a(z9);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() throws JSONException {
        if (this.t || !this.f4171u) {
            return;
        }
        MBBannerView mBBannerView = this.h;
        if (this.f4165n != null) {
            if (this.f4166o == null) {
                this.f4166o = new c(mBBannerView, this.f4173w, this.f4158c, this.f4157b, this.f, this.f4167p);
            }
            this.f4166o.a(this.f4159d);
            this.f4166o.b(this.f4169r);
            this.f4166o.c(this.f4170s);
            this.f4166o.a(this.f, this.g);
            this.f4166o.a(this.f4165n);
        } else {
            a(new b(880043));
        }
        this.f4171u = false;
    }

    private void j() {
        MBBannerView mBBannerView = this.h;
        if (mBBannerView != null) {
            if (!this.f4169r || !this.f4170s || this.f4172v || as.a(mBBannerView, 1)) {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, this.f4158c, this.f4157b, null, null);
            } else {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(3, this.f4158c, this.f4157b, new com.mbridge.msdk.mbbanner.common.a.a(this.f4161j + "x" + this.f4160i, this.f4162k * 1000), this.f4174x);
            }
            if (this.f4169r) {
                return;
            }
            com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f4158c, this.f4157b, null, null);
            com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f4157b);
        }
    }

    private void k() throws JSONException {
        j();
        c cVar = this.f4166o;
        if (cVar != null) {
            cVar.b(this.f4169r);
            this.f4166o.c(this.f4170s);
        }
    }

    public final void a(String str, String str2) {
        boolean zA;
        if (this.f4160i < 1 || this.f4161j < 1) {
            a(str2, new b(880037));
            return;
        }
        try {
            zA = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.c.m().c());
        } catch (Exception e) {
            af.b(f4156a, e.getMessage());
            zA = false;
        }
        if (!zA) {
            a(str2, new b(880029));
            return;
        }
        this.f4159d = str2;
        com.mbridge.msdk.mbbanner.common.a.a aVar = new com.mbridge.msdk.mbbanner.common.a.a(this.f4161j + "x" + this.f4160i, this.f4162k * 1000);
        aVar.a(str);
        aVar.b(this.f4158c);
        aVar.c(str2);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f4158c, this.f4157b, aVar, this.f4174x);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(1, this.f4158c, this.f4157b, aVar, this.f4174x);
    }

    public final String b() {
        CampaignUnit campaignUnit = this.f4165n;
        return campaignUnit != null ? com.mbridge.msdk.foundation.same.c.a(campaignUnit.getAds()) : "";
    }

    public final void c() {
        this.t = true;
        if (this.f4164m != null) {
            this.f4164m = null;
        }
        if (this.f4174x != null) {
            this.f4174x = null;
        }
        if (this.f4173w != null) {
            this.f4173w = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f4158c, this.f4157b, null, null);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f4157b);
        com.mbridge.msdk.mbbanner.common.c.a.a().b();
        c cVar = this.f4166o;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        if (this.t) {
            return;
        }
        j();
        h();
        com.mbridge.msdk.mbbanner.common.a.a aVar = new com.mbridge.msdk.mbbanner.common.a.a(this.f4161j + "x" + this.f4160i, this.f4162k * 1000);
        aVar.b(this.f4158c);
        aVar.a(true);
        aVar.c(com.mbridge.msdk.mbbanner.common.d.a.a(""));
        com.mbridge.msdk.mbbanner.common.c.a.a().b(this.f4158c, this.f4157b, aVar, this.f4174x);
    }

    public final void e() {
        com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f4158c, this.f4157b, new com.mbridge.msdk.mbbanner.common.a.a(this.f4161j + "x" + this.f4160i, this.f4162k * 1000), this.f4174x);
    }

    public final void f() {
        com.mbridge.msdk.mbbanner.common.c.a.a().a(3, this.f4158c, this.f4157b, new com.mbridge.msdk.mbbanner.common.a.a(this.f4161j + "x" + this.f4160i, this.f4162k * 1000), this.f4174x);
    }

    private int b(int i10) {
        if (i10 > 0) {
            if (i10 < 10) {
                return 10;
            }
            if (i10 > 180) {
                return SubsamplingScaleImageView.ORIENTATION_180;
            }
        }
        return i10;
    }

    public final void b(boolean z9) {
        this.f4169r = z9;
        k();
        i();
    }

    public final void c(boolean z9) {
        this.f4170s = z9;
        k();
    }

    public final String a() {
        CampaignUnit campaignUnit = this.f4165n;
        if (campaignUnit != null && campaignUnit.getRequestId() != null) {
            return this.f4165n.getRequestId();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, b bVar) {
        CampaignUnit campaignUnit;
        String strB = "";
        if (bVar != null) {
            try {
                strB = bVar.b();
                if (TextUtils.isEmpty(str)) {
                    str = bVar.f();
                }
            } catch (Throwable th) {
                af.b(f4156a, th.getMessage());
            }
        }
        if (TextUtils.isEmpty(str) && (campaignUnit = this.f4165n) != null) {
            str = campaignUnit.getLocalRequestId();
        }
        com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(this.f4157b, str);
        CampaignUnit campaignUnit2 = this.f4165n;
        cVarA.b(campaignUnit2 != null ? campaignUnit2.getAds() : null);
        cVarA.a(bVar);
        CampaignUnit campaignUnit3 = this.f4165n;
        if (campaignUnit3 != null && !campaignUnit3.getAds().isEmpty()) {
            cVarA.f(TextUtils.isEmpty(this.f4165n.getAds().get(0).getBannerUrl()) ? 1 : 2);
        }
        cVarA.c(true);
        com.mbridge.msdk.mbbanner.common.d.a.a("2000047", cVarA, null);
        BannerAdListener bannerAdListener = this.f4164m;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.e, strB);
        }
    }

    public final void a(BannerSize bannerSize) {
        if (bannerSize != null) {
            this.f4160i = bannerSize.getHeight();
            this.f4161j = bannerSize.getWidth();
        }
    }

    public final void a(int i10) {
        int iB = b(i10);
        this.f4163l = iB;
        this.f4162k = iB;
    }

    public final void a(boolean z9) {
        this.f = z9;
        this.g = z9 ? 1 : 2;
    }

    public final void a(BannerAdListener bannerAdListener) {
        this.f4164m = bannerAdListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        a(this.f4159d, bVar);
        d();
    }

    public final void a(int i10, int i11, int i12, int i13) {
        c cVar = this.f4166o;
        if (cVar != null) {
            cVar.a(i10, i11, i12, i13);
        }
    }

    public static /* synthetic */ void a(a aVar, int i10, b bVar) {
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(aVar.f4157b, bVar == null ? aVar.f4165n.getLocalRequestId() : bVar.f());
            e eVar = new e();
            eVar.a("result", Integer.valueOf(i10));
            CampaignUnit campaignUnit = aVar.f4165n;
            if (campaignUnit != null && !campaignUnit.getAds().isEmpty()) {
                CampaignEx campaignEx = aVar.f4165n.getAds().get(0);
                if (campaignEx != null) {
                    cVarA.f(TextUtils.isEmpty(campaignEx.getBannerUrl()) ? 2 : 1);
                }
                cVarA.b(aVar.f4165n.getAds());
            }
            if (bVar != null) {
                cVarA.a(bVar);
            }
            com.mbridge.msdk.mbbanner.common.d.a.a("2000126", cVarA, eVar);
        } catch (Exception e) {
            af.b(f4156a, e.getMessage());
        }
    }
}
