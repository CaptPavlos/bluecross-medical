package com.mbridge.msdk.newreward.function.e;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.b.i;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public List<Integer> f4970a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.a.b f4971b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.a.b f4972c;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.newreward.a.e f4973a;

        /* renamed from: b, reason: collision with root package name */
        private d f4974b;

        /* renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.newreward.a.b.b f4975c;

        /* renamed from: d, reason: collision with root package name */
        private int f4976d;

        public a(com.mbridge.msdk.newreward.a.e eVar, d dVar, com.mbridge.msdk.newreward.a.b.b bVar, int i10) {
            this.f4973a = eVar;
            this.f4974b = dVar;
            this.f4975c = bVar;
            this.f4976d = i10;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f4975c;
            if (bVar2 == null) {
                return;
            }
            try {
                bVar2.reqFailed(bVar);
            } catch (Exception e) {
                af.b("MoreOfferCampaignModel", "reqFailed: ", e);
            }
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqSuccessful(Object obj) {
            try {
                com.mbridge.msdk.newreward.function.c.a.b bVar = (com.mbridge.msdk.newreward.function.c.a.b) obj;
                bVar.b(this.f4973a.G());
                int iQ = (int) (this.f4973a.Q() * 1.2d);
                bVar.f(iQ);
                bVar.g(iQ);
                bVar.b(Math.max(this.f4973a.T(), bVar.p()));
                int i10 = this.f4976d;
                if (i10 == 1) {
                    this.f4974b.a(bVar);
                } else if (i10 == 2) {
                    this.f4974b.b(bVar);
                }
                if (!TextUtils.isEmpty(bVar.k())) {
                    MBridgeGlobalCommon.SESSION_ID = bVar.k();
                }
                com.mbridge.msdk.newreward.a.b.b bVar2 = this.f4975c;
                if (bVar2 == null) {
                    return;
                }
                bVar2.reqSuccessful(obj);
            } catch (Exception e) {
                af.b("MoreOfferCampaignModel", "reqSuccessful: ", e);
                com.mbridge.msdk.newreward.a.b.b bVar3 = this.f4975c;
                if (bVar3 != null) {
                    bVar3.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e.getMessage()));
                }
            }
        }
    }

    public final void a(int i10, com.mbridge.msdk.newreward.a.e eVar, CampaignEx campaignEx, com.mbridge.msdk.newreward.function.f.a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (campaignEx == null) {
            if (bVar != null) {
                bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, "more_offer MainCampaign is null"));
                return;
            }
            return;
        }
        try {
            try {
                new i(eVar).a(aVar, new a(eVar, this, bVar, i10));
            } catch (IOException e) {
                if (bVar != null) {
                    bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e.getMessage()));
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }

    public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        this.f4972c = bVar;
    }

    public final com.mbridge.msdk.newreward.function.c.a.b b() {
        return this.f4972c;
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        this.f4971b = bVar;
    }

    public final com.mbridge.msdk.newreward.function.c.a.b a() {
        return this.f4971b;
    }
}
