package com.mbridge.msdk.video.module.a.a;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d extends k {
    public d(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i10, boolean z9) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i10, z9);
    }

    @Override // com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i10, Object obj) {
        super.a(i10, obj);
        if (this.f6088a) {
            try {
                CampaignEx campaignEx = this.f6089b;
                if (campaignEx != null && campaignEx.getDynamicTempCode() == 5) {
                    b(obj.toString());
                }
            } catch (Exception unused) {
            }
            if (i10 != 105 && i10 != 106 && i10 != 113) {
                if (i10 == 122) {
                    a();
                    return;
                }
                switch (i10) {
                    case 109:
                        b(2);
                        a(2);
                        break;
                    case 110:
                        b(1);
                        a(1);
                        break;
                    case 111:
                        a(1);
                        break;
                }
            }
            com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c(), this.f6089b);
            if (i10 != 105) {
                String noticeUrl = this.f6089b.getNoticeUrl();
                if (!TextUtils.isEmpty(noticeUrl)) {
                    if (noticeUrl.contains(com.mbridge.msdk.foundation.same.a.f3609m)) {
                        noticeUrl = noticeUrl.replace(androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder(), com.mbridge.msdk.foundation.same.a.f3609m, "=", Uri.parse(noticeUrl).getQueryParameter(com.mbridge.msdk.foundation.same.a.f3609m)), com.mbridge.msdk.foundation.same.a.f3609m + "=2");
                    } else {
                        noticeUrl = a3.a.o(a3.a.w(noticeUrl, "&"), com.mbridge.msdk.foundation.same.a.f3609m, "=2");
                    }
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f6089b, this.g, noticeUrl, true, false, com.mbridge.msdk.click.a.a.f2768i);
            }
        }
    }
}
