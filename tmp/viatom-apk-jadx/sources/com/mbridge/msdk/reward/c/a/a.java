package com.mbridge.msdk.reward.c.a;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.videocommon.d.b;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f5280a;

    private a() {
    }

    public final void a(String str, c cVar) {
        c cVar2;
        List<CampaignEx> listH;
        try {
            if (cVar == null) {
                try {
                    cVar2 = new c();
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            } else {
                cVar2 = cVar;
            }
            com.mbridge.msdk.videocommon.d.a aVarB = b.a().b();
            if (aVarB != null) {
                cVar2.h(aVarB.b());
                cVar2.f(aVarB.c());
            }
            if (cVar != null) {
                try {
                    int iJ = cVar.j();
                    String strI = cVar.i();
                    if (TextUtils.isEmpty(strI) && (listH = cVar.h()) != null && listH.size() > 0 && listH.get(0) != null) {
                        strI = listH.get(0).getCampaignUnitId();
                        iJ = listH.get(0).getAdType();
                        cVar.b(iJ);
                        cVar.d(strI);
                    }
                    com.mbridge.msdk.videocommon.d.c cVarA = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), strI, iJ == 287);
                    if (cVarA != null) {
                        cVar.g(cVarA.l());
                        cVar.n(cVarA.k());
                    }
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        e3.printStackTrace();
                    }
                }
            }
            d.a().a(cVar);
            d.a().a(str, cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e7) {
            if (MBridgeConstans.DEBUG) {
                e7.printStackTrace();
            }
        }
    }

    public static a a() {
        if (f5280a == null) {
            synchronized (a.class) {
                try {
                    if (f5280a == null) {
                        f5280a = new a();
                    }
                } finally {
                }
            }
        }
        return f5280a;
    }
}
