package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5278a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5279b;

    public c(Context context, String str) {
        this.f5278a = context;
        this.f5279b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA;
        if (this.f5278a == null || TextUtils.isEmpty(this.f5279b)) {
            return;
        }
        try {
            Context context = this.f5278a;
            String str = this.f5279b;
            if (context != null) {
                try {
                    o oVarA = o.a(g.a(context));
                    if (!TextUtils.isEmpty(str) && oVarA != null && oVarA.a() > 0) {
                        List<n> listA = oVarA.a("m_download_end");
                        List<n> listA2 = oVarA.a("2000021");
                        List<n> listA3 = oVarA.a("2000039");
                        List<n> listA4 = oVarA.a("m_download_end");
                        List<n> listA5 = oVarA.a("m_download_end");
                        List<n> listA6 = oVarA.a("2000044");
                        com.mbridge.msdk.foundation.same.report.n.e(listA2);
                        com.mbridge.msdk.foundation.same.report.n.a(listA);
                        com.mbridge.msdk.foundation.same.report.n.c(listA3);
                        com.mbridge.msdk.foundation.same.report.n.b(listA4);
                        com.mbridge.msdk.foundation.same.report.n.f(listA5);
                        com.mbridge.msdk.foundation.same.report.n.d(listA6);
                    }
                } catch (Exception e) {
                    af.b("RewardReport", e.getMessage());
                }
            }
            ad.a();
            ad.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES));
            ad.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML));
            com.mbridge.msdk.videocommon.d.b.a().c(this.f5279b);
            if (ah.a().a("c_d_v_w_i", false) || TextUtils.isEmpty(this.f5279b) || (copyOnWriteArrayListA = com.mbridge.msdk.videocommon.a.a.a().a(this.f5279b, 1)) == null || copyOnWriteArrayListA.size() <= 0) {
                return;
            }
            com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f5278a, this.f5279b, copyOnWriteArrayListA, 94, (com.mbridge.msdk.videocommon.listener.a) null);
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoControllerInitTask", "initRewardVideoController task ", e3);
            }
        }
    }
}
