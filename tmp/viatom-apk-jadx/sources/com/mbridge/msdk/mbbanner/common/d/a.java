package com.mbridge.msdk.mbbanner.common.d;

import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    public static void a(String str, c cVar, e eVar) {
        List<CampaignEx> listH;
        try {
            try {
                String strI = cVar.i();
                if (TextUtils.isEmpty(strI) && (listH = cVar.h()) != null && !listH.isEmpty() && listH.get(0) != null) {
                    strI = listH.get(0).getCampaignUnitId();
                    cVar.b(listH.get(0).getAdType());
                    cVar.d(strI);
                }
                k kVarC = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), strI);
                if (kVarC != null) {
                    e eVar2 = eVar == null ? new e() : eVar;
                    eVar2.a("us_rid", kVarC.s());
                    HashMap<String, String> map = com.mbridge.msdk.foundation.controller.a.f3352b;
                    if (map != null) {
                        String str2 = map.get(strI);
                        if (!TextUtils.isEmpty(str2)) {
                            eVar2.a("u_stid", str2);
                        }
                    } else {
                        eVar2.a("u_stid", kVarC.a());
                    }
                }
            } catch (Exception e) {
                af.b("BannerReport", e.getMessage());
            }
            if (eVar != null) {
                cVar.a(str, eVar);
            }
            d.a().a(str, cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e3) {
            af.b("BannerReport", e3.getMessage());
        }
    }

    public static c a(String str, String str2) {
        c cVar = new c();
        try {
            LinkedHashMap<String, c> linkedHashMapB = d.a().b();
            if (linkedHashMapB != null && !linkedHashMapB.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = linkedHashMapB.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, c> next = it.next();
                    if (next != null && next.getValue().s()) {
                        it.remove();
                    }
                }
            }
            cVar = d.a().a(str2, "");
            if (cVar == null) {
                c cVar2 = new c();
                try {
                    d.a().b().put(str2, cVar2);
                    cVar2.d(true);
                    cVar = cVar2;
                } catch (Exception e) {
                    e = e;
                    cVar = cVar2;
                    af.b("BannerReport", e.getMessage());
                    return cVar;
                }
            }
            cVar.b(296);
            cVar.c(str2);
            cVar.d(str);
            return cVar;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static String a(String str) {
        String md5 = SameMD5.getMD5(ak.d());
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split("_");
                if (strArrSplit.length < 3) {
                    return "";
                }
                String str2 = strArrSplit[2];
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
            return md5;
        } catch (Exception e) {
            af.b("BannerReport", e.getMessage());
            return "";
        }
    }
}
