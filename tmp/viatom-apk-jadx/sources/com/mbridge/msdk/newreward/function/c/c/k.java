package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends c {

    /* renamed from: c, reason: collision with root package name */
    private final v f4725c;

    public k(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
        this.f4725c = new v(b(), c(), this);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.c
    public final boolean a_() {
        if (c() == null) {
            return false;
        }
        CampaignEx campaignExH = c().h();
        if (campaignExH == null || campaignExH.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignExH.getRewardTemplateMode().e())) {
            return true;
        }
        ArrayList<Integer> rsIgnoreCheckRule = campaignExH.getRsIgnoreCheckRule();
        if (rsIgnoreCheckRule != null && !rsIgnoreCheckRule.isEmpty()) {
            try {
                return rsIgnoreCheckRule.contains(1);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final int b_() {
        return 2;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final String j() {
        CampaignEx campaignExH;
        return (c() == null || (campaignExH = c().h()) == null || campaignExH.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignExH.getRewardTemplateMode().e())) ? "" : campaignExH.getRewardTemplateMode().e();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final q l() {
        return this.f4725c;
    }
}
