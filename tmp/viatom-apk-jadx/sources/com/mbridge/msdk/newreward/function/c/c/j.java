package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends c {

    /* renamed from: c, reason: collision with root package name */
    private final v f4724c;

    public j(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
        this.f4724c = new v(b(), c(), this);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.c
    public final boolean a_() {
        if (c() == null) {
            return false;
        }
        CampaignEx campaignExH = c().h();
        if (campaignExH == null || TextUtils.isEmpty(campaignExH.getendcard_url())) {
            return true;
        }
        ArrayList<Integer> rsIgnoreCheckRule = campaignExH.getRsIgnoreCheckRule();
        if (rsIgnoreCheckRule != null && rsIgnoreCheckRule.size() != 0) {
            try {
                return rsIgnoreCheckRule.contains(2);
            } catch (Exception unused) {
            }
        }
        return false;
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
        return this.f4724c;
    }
}
