package com.mbridge.msdk.dycreator.f;

import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements com.mbridge.msdk.dycreator.f.a.a {

    /* renamed from: a, reason: collision with root package name */
    private DyOption f3253a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f3254b;

    public a(DyOption dyOption) {
        this.f3253a = dyOption;
        this.f3254b = dyOption.getCampaignEx();
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public final CampaignEx getBindData() {
        return this.f3254b;
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public final DyOption getEffectData() {
        return this.f3253a;
    }
}
