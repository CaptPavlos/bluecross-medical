package com.mbridge.msdk.out.reveue;

import android.content.Context;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeRevenueManager {
    public static void track(Context context, MBridgeRevenueParamsEntity mBridgeRevenueParamsEntity) {
        if (c.m().c() == null) {
            c.m().b(context);
        }
        try {
            e eVar = new e();
            eVar.a(RewardPlus.NAME, mBridgeRevenueParamsEntity.getMediationName());
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.a("m_start_ad_rev", eVar);
            d.a().a("m_start_ad_rev", cVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.mbridge.msdk.foundation.same.report.e.a().a(mBridgeRevenueParamsEntity.getReportData());
    }
}
