package com.mbridge.msdk.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class k extends f {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f6088a;

    /* renamed from: b, reason: collision with root package name */
    protected CampaignEx f6089b;

    /* renamed from: c, reason: collision with root package name */
    protected List<CampaignEx> f6090c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f6091d;
    protected com.mbridge.msdk.videocommon.download.a e;
    protected com.mbridge.msdk.videocommon.b.c f;
    protected String g;
    protected String h;

    /* renamed from: i, reason: collision with root package name */
    protected com.mbridge.msdk.video.module.a.a f6092i;

    /* renamed from: j, reason: collision with root package name */
    protected int f6093j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6094k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6095l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6096m = false;

    public k(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i10, boolean z9) {
        this.f6091d = false;
        this.f6092i = new f();
        this.f6093j = 1;
        if (!z9 && campaignEx != null && ap.b(str2) && aVar != null && aVar2 != null) {
            this.f6089b = campaignEx;
            this.h = str;
            this.g = str2;
            this.e = aVar;
            this.f = cVar;
            this.f6092i = aVar2;
            this.f6088a = true;
            this.f6093j = i10;
            this.f6091d = false;
            return;
        }
        if (!z9 || campaignEx == null || !ap.b(str2) || aVar2 == null) {
            return;
        }
        this.f6089b = campaignEx;
        this.h = str;
        this.g = str2;
        this.e = aVar;
        this.f = cVar;
        this.f6092i = aVar2;
        this.f6088a = true;
        this.f6093j = i10;
        this.f6091d = true;
    }

    public final void a() {
        if (!this.f6088a || this.f6089b == null) {
            return;
        }
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000061", this.f6089b.getId(), this.f6089b.getRequestId(), this.f6089b.getRequestIdNotice(), this.g, ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
        nVar.d(this.f6089b.isMraid() ? com.mbridge.msdk.foundation.entity.n.f3580a : com.mbridge.msdk.foundation.entity.n.f3581b);
        com.mbridge.msdk.foundation.same.report.g.b(nVar, com.mbridge.msdk.foundation.controller.c.m().c(), this.g);
    }

    public final void b(int i10) {
        CampaignEx campaignEx = this.f6089b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i10 == 1 || i10 == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb.append("&endscreen_type=");
                        sb.append(i10);
                    } else {
                        sb.append("?endscreen_type=");
                        sb.append(i10);
                    }
                    noticeUrl = sb.toString();
                } else if (i10 == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.f6089b.setNoticeUrl(noticeUrl);
            }
        }
    }

    public final void c() {
        try {
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k kVar = k.this;
                        if (kVar.f6088a && kVar.f6089b != null && ap.b(kVar.g)) {
                            com.mbridge.msdk.videocommon.a.a aVarA = com.mbridge.msdk.videocommon.a.a.a();
                            k kVar2 = k.this;
                            aVarA.a(kVar2.f6089b, kVar2.g);
                        }
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        com.mbridge.msdk.videocommon.a.a aVarA2 = com.mbridge.msdk.videocommon.a.a.a();
                        k kVar3 = k.this;
                        aVarA2.c(kVar3.h, kVar3.f6089b.getAdType());
                    } catch (Exception e3) {
                        if (MBridgeConstans.DEBUG) {
                            e3.printStackTrace();
                        }
                    } catch (Throwable th) {
                        af.a("NotifyListener", th.getMessage());
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.a.b().execute(runnable);
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage(), th);
        }
    }

    public final void d() {
        com.mbridge.msdk.videocommon.download.a aVar = this.e;
        if (aVar != null) {
            aVar.f(true);
        }
    }

    public final void e() {
        CampaignEx campaignEx;
        Map<String, Long> map;
        String str;
        try {
            CampaignEx campaignEx2 = this.f6089b;
            if (campaignEx2 != null && campaignEx2.isDynamicView() && this.f6091d && !this.f6089b.isCampaignIsFiltered()) {
                this.f6095l = true;
                return;
            }
            if (!this.f6088a || (campaignEx = this.f6089b) == null || TextUtils.isEmpty(campaignEx.getOnlyImpressionURL()) || (map = com.mbridge.msdk.foundation.same.a.b.f3630k) == null || map.containsKey(this.f6089b.getOnlyImpressionURL()) || this.f6095l) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.b.f3630k.put(this.f6089b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
            String onlyImpressionURL = this.f6089b.getOnlyImpressionURL();
            if (this.f6089b.getSpareOfferFlag() == 1) {
                str = onlyImpressionURL + "&to=1&cbt=" + this.f6089b.getCbt() + "&tmorl=" + this.f6093j;
            } else {
                str = onlyImpressionURL + "&to=0&cbt=" + this.f6089b.getCbt() + "&tmorl=" + this.f6093j;
            }
            String str2 = str;
            if (!this.f6091d || this.f6089b.isCampaignIsFiltered()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f6089b, this.g, str2, false, true, com.mbridge.msdk.click.a.a.h);
                c();
            }
            this.f6095l = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f() {
        try {
            if (!this.f6088a || this.f6094k || TextUtils.isEmpty(this.f6089b.getImpressionURL())) {
                return;
            }
            this.f6094k = true;
            if (this.f6089b.isBidCampaign() && this.f6089b != null) {
                try {
                    HashMap map = new HashMap();
                    List<com.mbridge.msdk.foundation.entity.d> listA = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f6089b.getCampaignUnitId(), this.f6089b.getRequestId());
                    if (listA != null && listA.size() > 0 && listA.get(0) != null) {
                        if (listA.get(0).c() == 1) {
                            map.put("encrypt_p=", "encrypt_p=" + listA.get(0).b());
                            map.put("irlfa=", "irlfa=1");
                            for (Map.Entry entry : map.entrySet()) {
                                String str = (String) entry.getKey();
                                String str2 = (String) entry.getValue();
                                CampaignEx campaignEx = this.f6089b;
                                campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str, str2));
                                CampaignEx campaignEx2 = this.f6089b;
                                campaignEx2.setOnlyImpressionURL(campaignEx2.getOnlyImpressionURL().replaceAll(str, str2));
                            }
                        }
                        af.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f6089b.getRequestId()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String impressionURL = this.f6089b.getImpressionURL();
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f6089b, this.g, this.f6089b.getSpareOfferFlag() == 1 ? impressionURL + "&to=1&cbt=" + this.f6089b.getCbt() + "&tmorl=" + this.f6093j : impressionURL + "&to=0&cbt=" + this.f6089b.getCbt() + "&tmorl=" + this.f6093j, false, true, com.mbridge.msdk.click.a.a.g);
            com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f6089b);
            new Thread(new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(k.this.f6089b.getId());
                    } catch (Throwable th) {
                        af.b("NotifyListener", th.getMessage(), th);
                    }
                }
            }).start();
            if (!this.f6088a || com.mbridge.msdk.foundation.same.a.b.f3629j == null || TextUtils.isEmpty(this.f6089b.getId())) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.b.a(this.g, this.f6089b, "reward");
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage(), th);
        }
    }

    public final void g() {
        CampaignEx campaignEx;
        List<String> pv_urls;
        try {
            if (!this.f6088a || this.f6096m || (campaignEx = this.f6089b) == null) {
                return;
            }
            this.f6096m = true;
            if ((campaignEx.isDynamicView() && this.f6091d && !this.f6089b.isCampaignIsFiltered()) || (pv_urls = this.f6089b.getPv_urls()) == null || pv_urls.size() <= 0) {
                return;
            }
            Iterator<String> it = pv_urls.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f6089b, this.g, it.next(), false, true);
            }
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage());
        }
    }

    public final void h() {
        CampaignEx campaignEx = this.f6089b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getCampaignUnitId()) || this.f6089b.getNativeVideoTracking() == null || this.f6089b.getNativeVideoTracking().o() == null) {
            return;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        CampaignEx campaignEx2 = this.f6089b;
        com.mbridge.msdk.click.a.a(contextC, campaignEx2, campaignEx2.getCampaignUnitId(), this.f6089b.getNativeVideoTracking().o(), false, false);
    }

    public final void a(List<CampaignEx> list) {
        this.f6090c = list;
    }

    @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i10, Object obj) {
        super.a(i10, obj);
        this.f6092i.a(i10, obj);
    }

    public final void a(int i10) {
        if (this.f6089b != null) {
            if (i10 == 1 || i10 == 2) {
                com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f6089b, i10, this.f6093j);
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        this.f6089b = campaignEx;
    }

    public final void a(int i10, String str) {
        if (this.f6089b != null) {
            com.mbridge.msdk.foundation.same.report.g.c(new com.mbridge.msdk.foundation.entity.n("2000062", this.f6089b.getId(), this.f6089b.getRequestId(), this.f6089b.getRequestIdNotice(), this.g, ab.m(com.mbridge.msdk.foundation.controller.c.m().c()), i10, str), com.mbridge.msdk.foundation.controller.c.m().c(), this.g);
        }
    }

    public final void a(String str) {
        try {
            if (this.f6089b != null) {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("url", this.f6089b.getVideoUrlEncode());
                eVar.a("reason", str);
                String noticeUrl = this.f6089b.getNoticeUrl();
                String clickURL = this.f6089b.getClickURL();
                if (TextUtils.isEmpty(noticeUrl)) {
                    if (!TextUtils.isEmpty(clickURL)) {
                        eVar.a("offer_url", clickURL);
                    }
                } else {
                    eVar.a("offer_url", noticeUrl);
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000021", this.f6089b, eVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    k kVar = k.this;
                    if (!kVar.f6088a || kVar.f6089b == null || !ap.b(kVar.g) || com.mbridge.msdk.foundation.controller.c.m().c() == null) {
                        return;
                    }
                    com.mbridge.msdk.foundation.db.i iVarA = com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                    fVar.a(System.currentTimeMillis());
                    fVar.b(k.this.g);
                    fVar.a(k.this.f6089b.getId());
                    iVarA.a(fVar);
                } catch (Throwable th) {
                    af.b("NotifyListener", th.getMessage(), th);
                }
            }
        };
        com.mbridge.msdk.foundation.controller.d.a();
        com.mbridge.msdk.foundation.same.f.a.b().execute(runnable);
    }

    public final void b(String str) {
        List<CampaignEx> list;
        if (this.f6089b == null || (list = this.f6090c) == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("camp_position")) {
                this.f6089b = this.f6090c.get(jSONObject.getInt("camp_position"));
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("NotifyListener", e.getMessage());
            }
        }
    }
}
