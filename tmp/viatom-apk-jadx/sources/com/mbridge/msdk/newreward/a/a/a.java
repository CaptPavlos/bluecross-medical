package com.mbridge.msdk.newreward.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements com.mbridge.msdk.newreward.a.b.b {

    /* renamed from: a, reason: collision with root package name */
    protected c f4511a;

    /* renamed from: b, reason: collision with root package name */
    protected MBridgeIds f4512b;

    /* renamed from: c, reason: collision with root package name */
    protected e f4513c;

    /* renamed from: d, reason: collision with root package name */
    private RewardVideoListener f4514d;

    public a(c cVar) {
        this.f4511a = cVar;
    }

    public final void a(int i10, Object obj) {
        int iB;
        int iA;
        char c10;
        int iB2;
        int filterCallBackState;
        int iA2;
        if (i10 == 1) {
            if (this.f4513c.q() || this.f4513c.s()) {
                return;
            }
            List<CampaignEx> listA = this.f4513c.D() != null ? this.f4513c.D().a() : null;
            if (this.f4513c.D() == null || this.f4513c.D().b() == null) {
                iB = 0;
                iA = 0;
            } else {
                com.mbridge.msdk.newreward.function.c.a.b bVarB = this.f4513c.D().b();
                iA = bVarB.a();
                iB = bVarB.b();
            }
            int filterCallBackState2 = (listA == null || listA.isEmpty()) ? 0 : listA.get(0).getFilterCallBackState();
            c cVar = this.f4511a;
            e eVar = this.f4513c;
            cVar.a(eVar, f.REPORT_LOAD_V3_CAMPAIGN_SUCCESS, cVar.a("metrics_data", obj, "auto_load", Integer.valueOf(eVar.I() ? 2 : 1), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState2), "cache", 2));
            if (this.f4514d != null) {
                this.f4513c.f(true);
                this.f4514d.onLoadSuccess(this.f4512b);
                return;
            }
            return;
        }
        if (i10 != 2) {
            return;
        }
        this.f4513c.c(2);
        if (this.f4513c.s()) {
            return;
        }
        if (this.f4513c.D() == null || this.f4513c.D().b() == null) {
            c10 = 2;
            iB2 = 0;
            filterCallBackState = 0;
            iA2 = 0;
        } else {
            com.mbridge.msdk.newreward.function.c.a.b bVarB2 = this.f4513c.D().b();
            iA2 = bVarB2.a();
            iB2 = bVarB2.b();
            c10 = 2;
            filterCallBackState = (this.f4513c.D().a() == null || this.f4513c.D().a().isEmpty()) ? 0 : this.f4513c.D().a().get(0).getFilterCallBackState();
        }
        c cVar2 = this.f4511a;
        e eVar2 = this.f4513c;
        f fVar = f.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS;
        Integer numValueOf = Integer.valueOf(iA2);
        Integer numValueOf2 = Integer.valueOf(iB2);
        Integer numValueOf3 = Integer.valueOf(filterCallBackState);
        Object[] objArr = new Object[8];
        objArr[0] = "cache";
        objArr[1] = 2;
        objArr[c10] = com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX;
        objArr[3] = numValueOf;
        objArr[4] = com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX;
        objArr[5] = numValueOf2;
        objArr[6] = CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE;
        objArr[7] = numValueOf3;
        cVar2.a(eVar2, fVar, cVar2.a(objArr));
        if (this.f4514d != null) {
            this.f4513c.h(true);
            this.f4514d.onVideoLoadSuccess(this.f4512b);
        }
    }

    public final void a(final com.mbridge.msdk.foundation.c.b bVar) {
        c cVar = this.f4511a;
        cVar.b(cVar.a("adapter_model", this.f4513c, "command_manager", cVar, "scene", 2, "reason", bVar), new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.a.a.2
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar2) {
                a aVar = a.this;
                aVar.a(aVar.f4512b, bVar);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqSuccessful(Object obj) {
                a.this.a(1, obj);
                a.this.a(2, obj);
            }
        });
    }

    public final void a(MBridgeIds mBridgeIds, com.mbridge.msdk.foundation.c.b bVar) {
        int iB;
        int iA;
        int filterCallBackState;
        this.f4513c.c(2);
        if (this.f4513c.s()) {
            return;
        }
        if (this.f4513c.D() == null || this.f4513c.D().b() == null) {
            iB = 0;
            iA = 0;
            filterCallBackState = 0;
        } else {
            com.mbridge.msdk.newreward.function.c.a.b bVarB = this.f4513c.D().b();
            iA = bVarB.a();
            iB = bVarB.b();
            filterCallBackState = (this.f4513c.D().a() == null || this.f4513c.D().a().isEmpty()) ? 0 : this.f4513c.D().a().get(0).getFilterCallBackState();
        }
        c cVar = this.f4511a;
        cVar.a(this.f4513c, f.REPORT_LOAD_FAILED, cVar.a("metrics_data", bVar, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState)));
        if (this.f4514d != null) {
            this.f4513c.h(true);
            RewardVideoListener rewardVideoListener = this.f4514d;
            if (rewardVideoListener != null) {
                rewardVideoListener.onVideoLoadFail(mBridgeIds, bVar.b());
            }
        }
    }

    public final void a(e eVar) {
        eVar.c(1);
        this.f4513c = eVar;
        this.f4514d = eVar.K();
        MBridgeIds mBridgeIds = (MBridgeIds) this.f4511a.a((Object) null, f.CREATE_BIDS);
        this.f4512b = mBridgeIds;
        mBridgeIds.setBidToken(this.f4513c.J());
        c cVar = this.f4511a;
        cVar.c(cVar.a("command_type", f.PRE_HANDLE_LOAD, "command_manager", cVar, "adapter_model", this.f4513c), new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.a.a.1
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                a aVar = a.this;
                aVar.a(aVar.f4512b, bVar);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void reqSuccessful(Object obj) {
                a aVar = a.this;
                c cVar2 = aVar.f4511a;
                cVar2.a(cVar2.a("command_manager", cVar2, "adapter_model", aVar.f4513c), a.this);
            }
        });
    }
}
