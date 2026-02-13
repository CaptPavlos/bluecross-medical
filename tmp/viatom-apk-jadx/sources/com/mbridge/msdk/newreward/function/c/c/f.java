package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends b {

    /* renamed from: b, reason: collision with root package name */
    private final t f4722b;

    public f(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
        this.f4722b = new t(b(), c(), this);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final int b_() {
        return 4;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final String j() {
        CampaignEx campaignExH;
        return (c() == null || (campaignExH = c().h()) == null || TextUtils.isEmpty(campaignExH.getendcard_url())) ? "" : campaignExH.getendcard_url();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final q l() {
        return this.f4722b;
    }
}
