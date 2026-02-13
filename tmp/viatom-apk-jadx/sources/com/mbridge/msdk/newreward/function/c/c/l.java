package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends a<String> {
    public l(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final int b_() {
        return 5;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final String a() {
        CampaignEx campaignExH;
        return (c() == null || (campaignExH = c().h()) == null || TextUtils.isEmpty(campaignExH.getMraid())) ? "" : campaignExH.getMraid();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final boolean h() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final String j() {
        return "";
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final boolean k() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final q l() {
        return new w(b(), c(), this);
    }
}
