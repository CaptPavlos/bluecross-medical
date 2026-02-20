package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends k {
    public h(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i10, boolean z9) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i10, z9);
    }

    @Override // com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i10, Object obj) {
        if (i10 == 100) {
            g();
            f();
            e();
            a(2);
        } else if (i10 == 109) {
            b(2);
        } else if (i10 == 122) {
            a();
        } else if (i10 != 129) {
            String str = "";
            if (i10 == 118) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(3, str);
            } else if (i10 == 119) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(4, str);
            }
        } else {
            CampaignEx campaignEx = this.f6089b;
            if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2) {
                g();
                f();
                e();
                a(1);
            }
        }
        super.a(i10, obj);
    }
}
