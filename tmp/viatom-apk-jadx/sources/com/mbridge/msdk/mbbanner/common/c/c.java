package com.mbridge.msdk.mbbanner.common.c;

import com.mbridge.msdk.c.k;
import com.mbridge.msdk.out.MBBannerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends d {
    public c(MBBannerView mBBannerView, com.mbridge.msdk.mbbanner.common.b.c cVar, String str, String str2, boolean z9, k kVar) {
        super(mBBannerView, cVar, str, str2, z9, kVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    @Override // com.mbridge.msdk.mbbanner.common.c.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignEx r8, boolean r9, java.lang.String r10) {
        /*
            r7 = this;
            boolean r0 = r7.f4228d
            if (r0 != 0) goto L6
            goto Lae
        L6:
            com.mbridge.msdk.click.a r0 = r7.f
            if (r0 != 0) goto L1b
            com.mbridge.msdk.click.a r0 = new com.mbridge.msdk.click.a
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r1 = r1.c()
            java.lang.String r2 = r7.e
            r0.<init>(r1, r2)
            r7.f = r0
        L1b:
            com.mbridge.msdk.click.a r0 = r7.f
            com.mbridge.msdk.mbbanner.common.c.c$1 r1 = new com.mbridge.msdk.mbbanner.common.c.c$1
            r1.<init>()
            r0.a(r1)
            java.lang.String r0 = r7.e
            r8.setCampaignUnitId(r0)
            com.mbridge.msdk.click.a r0 = r7.f
            r0.a(r8)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.f4226b
            boolean r0 = r0.isReportClick()
            if (r0 != 0) goto L68
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.f4226b
            r1 = 1
            r0.setReportClick(r1)
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r1 = r0.c()
            com.mbridge.msdk.foundation.entity.j r0 = r8.getNativeVideoTracking()
            if (r0 == 0) goto L68
            com.mbridge.msdk.foundation.entity.j r0 = r8.getNativeVideoTracking()
            java.lang.String[] r0 = r0.l()
            if (r0 == 0) goto L68
            java.lang.String r3 = r8.getCampaignUnitId()
            com.mbridge.msdk.foundation.entity.j r0 = r8.getNativeVideoTracking()
            java.lang.String[] r4 = r0.l()
            r5 = 0
            r6 = 0
            r2 = r8
            com.mbridge.msdk.click.a.a(r1, r2, r3, r4, r5, r6)
            goto L69
        L68:
            r2 = r8
        L69:
            com.mbridge.msdk.mbbanner.common.b.c r8 = r7.f4225a
            if (r8 == 0) goto L70
            r8.a()
        L70:
            if (r9 == 0) goto Lae
            boolean r8 = android.text.TextUtils.isEmpty(r10)
            if (r8 != 0) goto Lae
            java.lang.String r4 = r7.e
            boolean r8 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Exception -> La3
            if (r8 != 0) goto Lae
            com.mbridge.msdk.foundation.same.report.h r0 = new com.mbridge.msdk.foundation.same.report.h     // Catch: java.lang.Exception -> La3
            com.mbridge.msdk.foundation.controller.c r8 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> La3
            android.content.Context r8 = r8.c()     // Catch: java.lang.Exception -> La3
            r0.<init>(r8)     // Catch: java.lang.Exception -> La3
            java.lang.String r1 = r2.getRequestId()     // Catch: java.lang.Exception -> La3
            r8 = r2
            java.lang.String r2 = r8.getRequestIdNotice()     // Catch: java.lang.Exception -> La3
            java.lang.String r3 = r8.getId()     // Catch: java.lang.Exception -> La3
            boolean r6 = r8.isBidCampaign()     // Catch: java.lang.Exception -> La3
            r5 = r10
            r0.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> La3
            return
        La3:
            r0 = move-exception
            r8 = r0
            java.lang.String r9 = "BannerReport"
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r9, r8)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.c.a(com.mbridge.msdk.foundation.entity.CampaignEx, boolean, java.lang.String):void");
    }
}
