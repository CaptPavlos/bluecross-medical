package com.mbridge.msdk.reward.d;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.h;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a extends c {
    public abstract void a(int i10, String str, com.mbridge.msdk.foundation.same.report.d.c cVar);

    public abstract void a(CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.reward.d.c
    public final void a(List<h> list, CampaignUnit campaignUnit) {
        a(campaignUnit);
    }

    @Override // com.mbridge.msdk.reward.d.c
    public final void b(int i10, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        a(i10, str, cVar);
    }

    @Override // com.mbridge.msdk.reward.d.c
    public final void a(List<Frame> list) {
    }
}
