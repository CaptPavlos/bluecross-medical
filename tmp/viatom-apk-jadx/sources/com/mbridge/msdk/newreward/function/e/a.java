package com.mbridge.msdk.newreward.function.e;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.a.b f4942a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f4943b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.e.a$a, reason: collision with other inner class name */
    public static final class C0047a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.e f4945a;

        /* renamed from: b, reason: collision with root package name */
        private final a f4946b;

        /* renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4947c;

        public C0047a(com.mbridge.msdk.newreward.a.e eVar, a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f4945a = eVar;
            this.f4946b = aVar;
            this.f4947c = bVar;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f4947c;
            if (bVar2 == null) {
                return;
            }
            try {
                bVar2.reqFailed(bVar);
            } catch (Exception e) {
                af.b("CampaignModel", "reqFailed: ", e);
            }
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqSuccessful(Object obj) {
            try {
                com.mbridge.msdk.newreward.function.c.a.b bVar = (com.mbridge.msdk.newreward.function.c.a.b) obj;
                bVar.b(this.f4945a.G());
                int iQ = (int) (this.f4945a.Q() * 1.2d);
                bVar.f(iQ);
                bVar.g(iQ);
                bVar.b(Math.max(this.f4945a.T(), bVar.p()));
                if (bVar.b() == 0) {
                    this.f4946b.a(bVar);
                    com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar);
                }
                if (!TextUtils.isEmpty(bVar.k())) {
                    MBridgeGlobalCommon.SESSION_ID = bVar.k();
                }
                MBridgeSharedPreferenceModel.getInstance().putInteger("vcn_" + bVar.e(), bVar.F());
                com.mbridge.msdk.newreward.a.b.b bVar2 = this.f4947c;
                if (bVar2 == null) {
                    return;
                }
                bVar2.reqSuccessful(obj);
            } catch (Exception e) {
                af.b("CampaignModel", "reqSuccessful: ", e);
                com.mbridge.msdk.newreward.a.b.b bVar3 = this.f4947c;
                if (bVar3 != null) {
                    bVar3.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e.getMessage()));
                }
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, boolean z9) throws MBridgeError {
        boolean z10;
        if (bVar == null || bVar.u() == null) {
            throw new MBridgeError(880003, "Need show campaign list is NULL!");
        }
        for (com.mbridge.msdk.newreward.function.c.a.a aVar : bVar.u()) {
            CampaignEx campaignExH = aVar.h();
            if (campaignExH != null && campaignExH.getOfferType() != 99) {
                if (a(aVar)) {
                    z10 = (ap.a(campaignExH.getendcard_url()) && TextUtils.isEmpty(campaignExH.getMraid())) ? false : true;
                    if (aVar.f() == null && aVar.e() == null) {
                        throw new MBridgeError(880003, "playable offer endcard or mraid is null");
                    }
                } else {
                    z10 = !ap.a(campaignExH.getVideoUrlEncode());
                    if (aVar.d() == null) {
                        throw new MBridgeError(880003, "No video campaign");
                    }
                }
                if (z10) {
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    if (com.mbridge.msdk.e.b.a() && ak.c(campaignExH)) {
                        campaignExH.setRtinsType(ak.c(contextC, campaignExH.getPackageName()) ? 1 : 2);
                    }
                    try {
                        com.mbridge.msdk.newreward.a.e eVar = this.f4943b;
                        String str = "";
                        if (eVar != null && eVar.D() != null && this.f4943b.D().f4942a != null) {
                            str = this.f4943b.D().f4942a.a() + "";
                        }
                        com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.foundation.same.report.d.d.a().a(campaignExH.getLocalRequestId(), str);
                        if (cVarA == null) {
                            cVarA = new com.mbridge.msdk.foundation.same.report.d.c();
                            cVarA.c(campaignExH.getLocalRequestId());
                            cVarA.b(campaignExH.getAdType());
                            cVarA.d(campaignExH.getCampaignUnitId());
                            cVarA.i(campaignExH.isBidCampaign() ? "1" : "0");
                        }
                        cVarA.a(campaignExH);
                        com.mbridge.msdk.newreward.a.e eVar2 = this.f4943b;
                        if (eVar2 != null && eVar2.x() != null) {
                            com.mbridge.msdk.videocommon.d.a aVarA = this.f4943b.x().a();
                            if (aVarA != null) {
                                cVarA.h(aVarA.b());
                                cVarA.f(aVarA.c());
                            }
                            com.mbridge.msdk.videocommon.d.c cVarB = this.f4943b.x().b();
                            if (cVarB != null) {
                                cVarA.g(cVarB.l());
                                cVarA.n(cVarB.k());
                            }
                        }
                        com.mbridge.msdk.foundation.same.c.a(campaignExH, com.mbridge.msdk.foundation.controller.c.m().c(), cVarA, new c.a() { // from class: com.mbridge.msdk.newreward.function.e.a.1
                            @Override // com.mbridge.msdk.foundation.same.c.a
                            public final void a(String str2, com.mbridge.msdk.foundation.same.report.d.c cVar) {
                                com.mbridge.msdk.foundation.same.report.d.d.a().a(str2, cVar);
                            }
                        });
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (z9) {
                        continue;
                    } else {
                        if (com.mbridge.msdk.foundation.same.c.b(contextC, campaignExH) == 0) {
                            aVar.b(true);
                            ak.a(bVar.e(), campaignExH, com.mbridge.msdk.foundation.same.a.f3619x);
                            this.f4943b.a(campaignExH.getId());
                            throw new MBridgeError(880021, "APP ALREADY INSTALLED");
                        }
                        if (com.mbridge.msdk.foundation.same.c.b(contextC, campaignExH) == 1) {
                            aVar.b(false);
                            if (bVar.a() > 0) {
                                ak.a(bVar.e(), campaignExH, com.mbridge.msdk.foundation.same.a.f3619x);
                                this.f4943b.a(campaignExH.getId());
                                throw new MBridgeError(880021, "FILTER BUT CALLBACK SUCCEED");
                            }
                        } else if (com.mbridge.msdk.foundation.same.c.b(contextC, campaignExH) == 2) {
                            aVar.b(false);
                            ak.a(bVar.e(), campaignExH, com.mbridge.msdk.foundation.same.a.f3619x);
                            throw new MBridgeError(880003, "campaign is exception");
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        if (bVar == null || bVar.u() == null) {
            return;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        j jVarA = j.a(g.a(contextC));
        Iterator<com.mbridge.msdk.newreward.function.c.a.a> it = bVar.u().iterator();
        while (it.hasNext()) {
            CampaignEx campaignExH = it.next().h();
            if (campaignExH != null) {
                if (!com.mbridge.msdk.e.b.a()) {
                    a(jVarA, campaignExH);
                } else if (!ak.c(contextC, campaignExH.getPackageName())) {
                    a(jVarA, campaignExH);
                }
            }
        }
    }

    public final boolean c() {
        com.mbridge.msdk.newreward.function.c.a.b bVar = this.f4942a;
        return bVar != null && bVar.z();
    }

    public final com.mbridge.msdk.newreward.function.c.a.b b() {
        return this.f4942a;
    }

    public final List<CampaignEx> a() {
        com.mbridge.msdk.newreward.function.c.a.b bVar = this.f4942a;
        if (bVar == null) {
            return null;
        }
        return bVar.E();
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        this.f4942a = bVar;
    }

    public final void a(com.mbridge.msdk.newreward.a.e eVar, com.mbridge.msdk.newreward.function.f.a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        this.f4943b = eVar;
        try {
            new com.mbridge.msdk.newreward.a.b.c(eVar).a(aVar, new C0047a(eVar, this, bVar));
        } catch (IOException e) {
            if (bVar != null) {
                bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e.getMessage()));
            }
        }
    }

    private boolean a(com.mbridge.msdk.newreward.function.c.a.a aVar) {
        CampaignEx campaignExH;
        if (aVar != null && (campaignExH = aVar.h()) != null) {
            try {
                if (campaignExH.getPlayable_ads_without_video() == 2) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void a(j jVar, CampaignEx campaignEx) {
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
}
