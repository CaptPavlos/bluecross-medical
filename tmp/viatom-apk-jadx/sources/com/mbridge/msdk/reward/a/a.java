package com.mbridge.msdk.reward.a;

import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.foundation.b.a;
import com.mbridge.msdk.foundation.b.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f5027a = "RewardCandidateController";

    /* renamed from: b, reason: collision with root package name */
    private d f5028b;

    public a(String str, boolean z9) {
        try {
            this.f5028b = b.a().a(str, com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), str, z9).G());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, com.mbridge.msdk.foundation.b.c cVar2, List<a.C0025a> list, JSONObject jSONObject, int i10) {
        try {
            e eVar = new e();
            eVar.a("scene", i10 != 1 ? i10 != 2 ? i10 != 3 ? EnvironmentCompat.MEDIA_UNKNOWN : "track" : "candidate" : "cb");
            d dVar = this.f5028b;
            if (dVar != null) {
                double d8 = dVar.d(str);
                if (d8 >= 0.0d) {
                    eVar.a("bp", z.b(d8 + ""));
                }
                eVar.a("cb_state", a(str) ? "open" : CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                try {
                    d dVar2 = this.f5028b;
                    JSONObject jSONObjectA = dVar2.a(dVar2.b(str));
                    if (jSONObjectA != null) {
                        eVar.a("config", jSONObjectA.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cVar2 != null) {
                if (cVar2.g() == com.mbridge.msdk.foundation.b.c.f3331d) {
                    eVar.a("result", 1);
                } else {
                    eVar.a("result", 2);
                    eVar.a("reason", cVar2.b());
                }
                eVar.a("acr", cVar2.c());
                eVar.a("her", cVar2.e());
                eVar.a("nrr", cVar2.d());
                eVar.a("cer", cVar2.f());
            } else {
                eVar.a("result", 2);
                eVar.a("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    com.mbridge.msdk.foundation.b.b bVarA = list.get(i11).a();
                    if (bVarA != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", z.b(bVarA.c() + ""));
                        jSONObject2.put("showCount", bVarA.f());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - bVarA.h());
                        jSONArray.put(jSONObject2);
                    }
                }
                eVar.a(DataSchemeDataSource.SCHEME_DATA, jSONArray.toString());
            }
            if (cVar != null) {
                cVar.a("m_candidate_data");
                cVar.k("m_candidate_data");
                cVar.a("m_candidate_data", eVar);
                if (cVar2 != null && cVar2.a() != null) {
                    cVar.b(cVar2.a());
                }
            }
            com.mbridge.msdk.foundation.same.report.d.d.a().a("m_candidate_data", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final com.mbridge.msdk.foundation.b.c a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar, CampaignEx campaignEx, com.mbridge.msdk.foundation.c.b bVar, int i10, com.mbridge.msdk.reward.adapter.c cVar2) {
        String requestId;
        String strB;
        int i11;
        com.mbridge.msdk.foundation.b.c cVar3 = new com.mbridge.msdk.foundation.b.c();
        String str2 = "";
        if (campaignEx == null) {
            requestId = "";
        } else {
            try {
                try {
                    requestId = campaignEx.getRequestId();
                } catch (Exception unused) {
                    cVar3.d("getCandidateCampaignList result exception");
                    cVar3.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    return cVar3;
                }
            } catch (Exception unused2) {
                cVar3.d("getRewardCandidateCampaignList result exception");
                cVar3.a(com.mbridge.msdk.foundation.b.c.f3330c);
                return cVar3;
            }
        }
        if (bVar != null) {
            int iE = bVar.e();
            strB = bVar.b();
            i11 = iE;
        } else {
            strB = null;
            i11 = 0;
        }
        String str3 = strB;
        d dVar = this.f5028b;
        if (dVar == null) {
            com.mbridge.msdk.foundation.b.c cVar4 = new com.mbridge.msdk.foundation.b.c();
            cVar4.d("can not get manager");
            cVar4.a(com.mbridge.msdk.foundation.b.c.f3330c);
            return cVar4;
        }
        com.mbridge.msdk.foundation.b.c cVarC = dVar.c(str);
        if (cVarC.g() <= com.mbridge.msdk.foundation.b.c.f3329b) {
            String[] strArrSplit = z.a(str.split("_")[3]).split("\\|");
            double d8 = Double.parseDouble(strArrSplit[0]);
            if (strArrSplit.length > 1) {
                str2 = strArrSplit[1];
            }
            cVarC = a(d8, str2, cVar2, cVar, str, i10);
            this.f5028b.a(cVarC.a(), cVar, requestId, i11, str3, i10, d8);
        }
        return cVarC;
    }

    private com.mbridge.msdk.foundation.b.c a(double d8, String str, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.d.c cVar2, String str2, int i10) {
        com.mbridge.msdk.foundation.b.c cVarA = this.f5028b.a();
        try {
            if (cVarA.g() > 0) {
                return cVarA;
            }
            JSONObject jSONObjectA = this.f5028b.a(str);
            try {
                if (jSONObjectA != null) {
                    int iOptInt = jSONObjectA.optInt("max_usage_limit", 10);
                    int iOptInt2 = jSONObjectA.optInt("max_cache_num", 20);
                    if (iOptInt2 > 0) {
                        long j10 = 8640000;
                        long jOptLong = jSONObjectA.optLong("show_interval_time", 8640000L);
                        if (jOptLong != 0) {
                            j10 = jOptLong;
                        }
                        List<com.mbridge.msdk.foundation.b.b> listA = this.f5028b.a(iOptInt, System.currentTimeMillis() - (j10 * 1000));
                        if (listA != null && listA.size() > 0) {
                            return a(listA, jSONObjectA, iOptInt2, d8, cVar, cVar2, str2, true, i10);
                        }
                        cVarA.d("no cache");
                        cVarA.a(com.mbridge.msdk.foundation.b.c.f3330c);
                        a(cVar2, str2, cVarA, (List<a.C0025a>) null, jSONObjectA, 2);
                        return cVarA;
                    }
                    cVarA.d("max cache num error");
                    cVarA.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    return cVarA;
                }
                cVarA.d("setting config not mapping");
                cVarA.a(com.mbridge.msdk.foundation.b.c.f3330c);
                return cVarA;
            } catch (Exception unused) {
                cVarA.d("getHighestCampaigns exception");
                cVarA.a(com.mbridge.msdk.foundation.b.c.f3330c);
                return cVarA;
            }
        } catch (Exception unused2) {
        }
    }

    private com.mbridge.msdk.foundation.b.c a(List<com.mbridge.msdk.foundation.b.b> list, JSONObject jSONObject, int i10, double d8, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.d.c cVar2, String str, boolean z9, int i11) {
        List<com.mbridge.msdk.foundation.b.b> list2;
        int i12;
        int i13;
        List<com.mbridge.msdk.foundation.b.b> listA = list;
        com.mbridge.msdk.foundation.b.c cVar3 = new com.mbridge.msdk.foundation.b.c();
        if (jSONObject == null) {
            cVar3.d("config is null");
            cVar3.a(com.mbridge.msdk.foundation.b.c.f3330c);
            return cVar3;
        }
        if (listA != null && listA.size() != 0) {
            for (int i14 = 0; i14 < listA.size(); i14++) {
                com.mbridge.msdk.foundation.b.b bVar = listA.get(i14);
                if (bVar != null) {
                    cVar3.a(bVar.e());
                }
            }
            if (listA.size() > 0 && ((listA = a(listA, cVar3)) == null || listA.size() == 0)) {
                cVar3.d("existed");
                cVar3.a(com.mbridge.msdk.foundation.b.c.f3330c);
            }
            if (listA.size() > 0 && ((listA = a(listA, cVar, cVar3)) == null || listA.size() == 0)) {
                cVar3.d("not ready");
                cVar3.a(com.mbridge.msdk.foundation.b.c.f3330c);
            }
            ArrayList arrayList = null;
            if (listA != null && listA.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                double dOptDouble = jSONObject.optDouble("t_disc", 0.8d);
                double dOptDouble2 = jSONObject.optDouble("u_disc", 0.95d);
                double dOptDouble3 = jSONObject.optDouble("max_ecppv_diff", 0.0d);
                int iOptInt = jSONObject.optInt("time_interval", 1800);
                int size = listA.size();
                double d10 = 0.0d;
                com.mbridge.msdk.foundation.b.b bVar2 = null;
                int i15 = 0;
                while (i15 < size) {
                    com.mbridge.msdk.foundation.b.b bVar3 = listA.get(i15);
                    if (bVar3 != null) {
                        i13 = i15;
                        list2 = listA;
                        i12 = iOptInt;
                        double dPow = Math.pow(dOptDouble2, bVar3.f()) * Math.pow(dOptDouble, (System.currentTimeMillis() - bVar3.h()) / (iOptInt * 1000.0d)) * bVar3.c();
                        arrayList2.add(new a.C0025a(dPow, bVar3));
                        if (dPow >= d8 - dOptDouble3 && dPow > d10) {
                            d10 = dPow;
                            bVar2 = bVar3;
                        }
                    } else {
                        list2 = listA;
                        i12 = iOptInt;
                        i13 = i15;
                    }
                    i15 = i13 + 1;
                    listA = list2;
                    iOptInt = i12;
                }
                d dVar = this.f5028b;
                if (dVar != null) {
                    dVar.a(arrayList2, i10);
                }
                if (bVar2 != null) {
                    cVar3.a(bVar2.b());
                    cVar3.a(com.mbridge.msdk.foundation.b.c.f3331d);
                } else {
                    cVar3.d("no match campaign");
                    cVar3.a(com.mbridge.msdk.foundation.b.c.f3330c);
                }
                arrayList = arrayList2;
            }
            if (z9) {
                a(cVar2, str, cVar3, arrayList, jSONObject, 2);
            }
            return cVar3;
        }
        cVar3.d("candidate is null");
        cVar3.a(com.mbridge.msdk.foundation.b.c.f3330c);
        return cVar3;
    }

    private List<com.mbridge.msdk.foundation.b.b> a(List<com.mbridge.msdk.foundation.b.b> list, com.mbridge.msdk.foundation.b.c cVar) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListB;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.mbridge.msdk.foundation.b.b bVar = list.get(i10);
            if (bVar != null && (copyOnWriteArrayListB = bVar.b()) != null && copyOnWriteArrayListB.size() != 0) {
                int i11 = 0;
                boolean z9 = false;
                while (true) {
                    if (i11 >= copyOnWriteArrayListB.size()) {
                        break;
                    }
                    CampaignEx campaignEx = copyOnWriteArrayListB.get(i11);
                    boolean zC = ak.c(c.m().c(), campaignEx.getPackageName());
                    if (zC) {
                        cVar.c(bVar.e());
                        d dVar = this.f5028b;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                        z9 = zC;
                    } else {
                        i11++;
                        z9 = zC;
                    }
                }
                if (!z9) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private List<com.mbridge.msdk.foundation.b.b> a(List<com.mbridge.msdk.foundation.b.b> list, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.b.c cVar2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListB;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.mbridge.msdk.foundation.b.b bVar = list.get(i10);
            if (bVar != null && (copyOnWriteArrayListB = bVar.b()) != null && copyOnWriteArrayListB.size() != 0) {
                int i11 = 0;
                boolean zA = false;
                while (true) {
                    if (i11 >= copyOnWriteArrayListB.size()) {
                        break;
                    }
                    CampaignEx campaignEx = copyOnWriteArrayListB.get(i11);
                    if (cVar == null || (zA = cVar.a(copyOnWriteArrayListB, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())))) {
                        i11++;
                    } else {
                        cVar2.b(bVar.e());
                        d dVar = this.f5028b;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                    }
                }
                if (zA) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public final boolean a(String str) {
        JSONObject jSONObjectA;
        try {
            d dVar = this.f5028b;
            if (dVar != null && (jSONObjectA = dVar.a(dVar.b(str))) != null) {
                return jSONObjectA.optInt("c_cb", 0) == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public final void a(String str, String str2, int i10, String str3) {
        d dVar = this.f5028b;
        if (dVar != null) {
            dVar.a(str, str2, i10, str3);
        }
    }

    public final void a(List<CampaignEx> list, String str, com.mbridge.msdk.reward.adapter.c cVar, String str2) {
        try {
            if (this.f5028b == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f5028b.a(com.mbridge.msdk.foundation.b.a.f3315b, 2, list, this.f5028b.a(list, str) > 0, "", "", -1, str2);
            d dVar = this.f5028b;
            JSONObject jSONObjectA = dVar.a(dVar.b(str));
            if (jSONObjectA == null || this.f5028b.d(str) <= 0.0d) {
                return;
            }
            a(this.f5028b.a(jSONObjectA.optInt("max_usage_limit", 10), 0L), jSONObjectA, jSONObjectA.optInt("max_cache_num", 20), -1.0d, cVar, new com.mbridge.msdk.foundation.same.report.d.c(), str, false, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
