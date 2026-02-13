package com.mbridge.msdk.newreward.function.b;

import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.a.a;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f4655a = "RewardCandidateController";

    /* renamed from: b, reason: collision with root package name */
    private final c f4656b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.a.c f4657c;

    public a(String str, boolean z9, c cVar) {
        this.f4656b = cVar;
        try {
            com.mbridge.msdk.newreward.function.a.c cVarA = com.mbridge.msdk.newreward.function.a.a.a.a().a(str, b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str, z9).G());
            this.f4657c = cVarA;
            cVarA.a(cVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private com.mbridge.msdk.newreward.function.a.b a(double d8, String str, com.mbridge.msdk.foundation.same.report.d.c cVar, String str2, e eVar, int i10, int i11, String str3) {
        a aVar;
        com.mbridge.msdk.foundation.same.report.d.c cVar2;
        String str4;
        e eVar2;
        int i12;
        List<com.mbridge.msdk.newreward.function.c.a.b> list;
        int i13;
        List<com.mbridge.msdk.newreward.function.c.a.a> listU;
        com.mbridge.msdk.newreward.function.a.b bVarA = this.f4657c.a();
        try {
            if (bVarA.h() > 0) {
                return bVarA;
            }
            JSONObject jSONObjectA = this.f4657c.a(str);
            try {
                if (jSONObjectA == null) {
                    bVarA.d("setting config not mapping");
                    bVarA.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    return bVarA;
                }
                int iOptInt = jSONObjectA.optInt("max_usage_limit", 10);
                if (jSONObjectA.optInt("max_cache_num", 20) <= 0) {
                    bVarA.d("max cache num error");
                    bVarA.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    return bVarA;
                }
                List<com.mbridge.msdk.newreward.function.c.a.b> listA = this.f4657c.a(iOptInt, i11, str3);
                if (listA == null || listA.size() <= 0) {
                    bVarA.d("no cache");
                    bVarA.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    a(cVar, str2, bVarA, null, jSONObjectA, eVar, 2);
                    return bVarA;
                }
                com.mbridge.msdk.newreward.function.a.b bVar = new com.mbridge.msdk.newreward.function.a.b();
                if (listA.size() == 0) {
                    bVar.d("candidate is null");
                    bVar.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    return bVar;
                }
                for (int i14 = 0; i14 < listA.size(); i14++) {
                    com.mbridge.msdk.newreward.function.c.a.b bVar2 = listA.get(i14);
                    if (bVar2 != null) {
                        bVar.a(bVar2.f());
                    }
                }
                if (listA.size() > 0) {
                    if (listA.size() != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i15 = 0; i15 < listA.size(); i15++) {
                            com.mbridge.msdk.newreward.function.c.a.b bVar3 = listA.get(i15);
                            if (bVar3 != null && (listU = bVar3.u()) != null && listU.size() != 0) {
                                int i16 = 0;
                                boolean z9 = false;
                                while (true) {
                                    if (i16 >= listU.size()) {
                                        break;
                                    }
                                    com.mbridge.msdk.newreward.function.c.a.a aVar2 = listU.get(i16);
                                    boolean zC = ak.c(com.mbridge.msdk.foundation.controller.c.m().c(), aVar2.h().getPackageName());
                                    if (zC) {
                                        bVar.c(bVar3.f());
                                        com.mbridge.msdk.newreward.function.a.c cVar3 = this.f4657c;
                                        if (cVar3 != null) {
                                            cVar3.a(bVar3.g(), bVar3.f(), 2, aVar2.i().s());
                                        }
                                        z9 = zC;
                                    } else {
                                        i16++;
                                        z9 = zC;
                                    }
                                }
                                if (!z9) {
                                    arrayList.add(bVar3);
                                }
                            }
                        }
                        listA = arrayList;
                    }
                    if (listA.size() == 0) {
                        bVar.d("existed");
                        bVar.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    }
                }
                if (listA.size() > 0 && ((listA = a(listA, bVar)) == null || listA.size() == 0)) {
                    bVar.d("not ready");
                    bVar.a(com.mbridge.msdk.foundation.b.c.f3330c);
                }
                if (listA.size() > 0 && ((listA = b(listA, bVar)) == null || listA.size() == 0)) {
                    bVar.d("had in cache");
                    bVar.a(com.mbridge.msdk.foundation.b.c.f3330c);
                }
                ArrayList arrayList2 = null;
                if (listA == null || listA.size() <= 0) {
                    aVar = this;
                    cVar2 = cVar;
                    str4 = str2;
                    eVar2 = eVar;
                    i12 = i10;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    double dOptDouble = jSONObjectA.optDouble("t_disc", 0.8d);
                    double dOptDouble2 = jSONObjectA.optDouble("u_disc", 0.95d);
                    double dOptDouble3 = jSONObjectA.optDouble("max_ecppv_diff", 0.0d);
                    int iOptInt2 = jSONObjectA.optInt("time_interval", 1800);
                    int size = listA.size();
                    double d10 = 0.0d;
                    com.mbridge.msdk.newreward.function.c.a.b bVar4 = null;
                    int i17 = 0;
                    while (i17 < size) {
                        com.mbridge.msdk.newreward.function.c.a.b bVar5 = listA.get(i17);
                        if (bVar5 != null) {
                            list = listA;
                            double dPow = Math.pow(dOptDouble2, bVar5.t()) * bVar5.s() * Math.pow(dOptDouble, (System.currentTimeMillis() - bVar5.I()) / (iOptInt2 * 1000.0d));
                            i13 = iOptInt2;
                            arrayList3.add(new a.C0042a(dPow, bVar5));
                            if (dPow >= d8 - dOptDouble3 && dPow > d10) {
                                d10 = dPow;
                                bVar4 = bVar5;
                            }
                        } else {
                            list = listA;
                            i13 = iOptInt2;
                        }
                        i17++;
                        listA = list;
                        iOptInt2 = i13;
                    }
                    if (bVar4 != null) {
                        bVar.a(bVar4);
                        bVar.a(com.mbridge.msdk.foundation.b.c.f3331d);
                    } else {
                        bVar.d("no match campaign");
                        bVar.a(com.mbridge.msdk.foundation.b.c.f3330c);
                    }
                    arrayList2 = arrayList3;
                    aVar = this;
                    cVar2 = cVar;
                    str4 = str2;
                    i12 = i10;
                    eVar2 = eVar;
                }
                aVar.a(cVar2, str4, bVar, arrayList2, jSONObjectA, eVar2, i12);
                return bVar;
            } catch (Exception unused) {
                bVarA.d("getHighestCampaigns exception");
                bVarA.a(com.mbridge.msdk.foundation.b.c.f3330c);
                return bVarA;
            }
        } catch (Exception unused2) {
        }
    }

    private List<com.mbridge.msdk.newreward.function.c.a.b> b(List<com.mbridge.msdk.newreward.function.c.a.b> list, com.mbridge.msdk.newreward.function.a.b bVar) {
        List<com.mbridge.msdk.newreward.function.c.a.a> listU;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.mbridge.msdk.newreward.function.c.a.b bVar2 = list.get(i10);
            if (bVar2 != null && (listU = bVar2.u()) != null && listU.size() != 0) {
                arrayList.add(bVar2);
            }
        }
        return arrayList;
    }

    public final com.mbridge.msdk.newreward.function.a.b a(com.mbridge.msdk.foundation.same.report.d.c cVar, com.mbridge.msdk.foundation.c.b bVar, e eVar, int i10) {
        String strJ;
        CampaignEx campaignEx;
        String str;
        String requestId;
        int iE;
        String strB;
        com.mbridge.msdk.newreward.function.a.b bVar2 = new com.mbridge.msdk.newreward.function.a.b();
        String str2 = "";
        int iH = 94;
        if (eVar == null) {
            str = "";
            strJ = null;
            campaignEx = null;
        } else {
            try {
                strJ = eVar.J();
                campaignEx = (eVar.D() == null || eVar.D().b() == null || eVar.D().b().E() == null || eVar.D().b().E().size() <= 0) ? null : eVar.D().b().E().get(0);
                if (this.f4657c == null) {
                    str = "";
                } else {
                    iH = eVar.h();
                    String strC = eVar.C();
                    this.f4657c.a(iH);
                    this.f4657c.f(strC);
                    this.f4657c.a(eVar);
                    str = strC;
                }
            } catch (Exception unused) {
                bVar2.d("getCandidateCampaignList result exception");
                bVar2.a(com.mbridge.msdk.foundation.b.c.f3330c);
                return bVar2;
            }
        }
        int i11 = iH;
        if (campaignEx == null) {
            requestId = "";
        } else {
            try {
                requestId = campaignEx.getRequestId();
            } catch (Exception unused2) {
                bVar2.d("getRewardCandidateCampaignList result exception");
                bVar2.a(com.mbridge.msdk.foundation.b.c.f3330c);
                return bVar2;
            }
        }
        if (bVar != null) {
            iE = bVar.e();
            strB = bVar.b();
        } else {
            iE = 0;
            strB = null;
        }
        com.mbridge.msdk.newreward.function.a.c cVar2 = this.f4657c;
        if (cVar2 == null) {
            com.mbridge.msdk.newreward.function.a.b bVar3 = new com.mbridge.msdk.newreward.function.a.b();
            bVar3.d("can not get manager");
            bVar3.a(com.mbridge.msdk.foundation.b.c.f3330c);
            return bVar3;
        }
        com.mbridge.msdk.newreward.function.a.b bVarC = cVar2.c(strJ);
        if (bVarC.h() <= com.mbridge.msdk.foundation.b.c.f3329b) {
            String[] strArrSplit = z.a(strJ.split("_")[3]).split("\\|");
            double d8 = Double.parseDouble(strArrSplit[0]);
            if (strArrSplit.length > 1) {
                str2 = strArrSplit[1];
            }
            bVarC = a(d8, str2, cVar, strJ, eVar, i10, i11, str);
            if (bVarC != null && bVarC.a() != null) {
                this.f4657c.a(bVarC.a().u(), cVar, requestId, iE, strB, i10, d8);
            }
        }
        return bVarC;
    }

    private List<com.mbridge.msdk.newreward.function.c.a.b> a(List<com.mbridge.msdk.newreward.function.c.a.b> list, com.mbridge.msdk.newreward.function.a.b bVar) {
        List<com.mbridge.msdk.newreward.function.c.a.a> listU;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.mbridge.msdk.newreward.function.c.a.b bVar2 = list.get(i10);
            if (bVar2 != null && (listU = bVar2.u()) != null && listU.size() != 0) {
                int i11 = 0;
                boolean z9 = false;
                while (true) {
                    if (i11 >= listU.size()) {
                        break;
                    }
                    com.mbridge.msdk.newreward.function.c.a.a aVar = listU.get(i11);
                    boolean z10 = aVar.i().z();
                    if (z10) {
                        i11++;
                        z9 = z10;
                    } else {
                        bVar.b(bVar2.f());
                        com.mbridge.msdk.newreward.function.a.c cVar = this.f4657c;
                        if (cVar != null) {
                            cVar.a(bVar2.g(), bVar2.f(), 2, aVar.i().s());
                        }
                        z9 = z10;
                    }
                }
                if (z9) {
                    arrayList.add(bVar2);
                }
            }
        }
        return arrayList;
    }

    public final boolean a(String str) {
        JSONObject jSONObjectA;
        try {
            com.mbridge.msdk.newreward.function.a.c cVar = this.f4657c;
            if (cVar != null && (jSONObjectA = cVar.a(cVar.b(str))) != null) {
                return jSONObjectA.optInt("c_cb", 0) == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, com.mbridge.msdk.newreward.function.a.b bVar, List<a.C0042a> list, JSONObject jSONObject, e eVar, int i10) {
        String str2;
        int i11;
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
            if (i10 == 1) {
                str2 = "cb";
            } else if (i10 == 2) {
                str2 = "candidate";
            } else if (i10 != 3) {
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            } else {
                str2 = "track";
            }
            eVar2.a("scene", str2);
            com.mbridge.msdk.newreward.function.a.c cVar2 = this.f4657c;
            if (cVar2 != null) {
                double d8 = cVar2.d(str);
                if (d8 >= 0.0d) {
                    eVar2.a("bp", z.b(d8 + ""));
                }
                eVar2.a("cb_state", a(str) ? "open" : CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                try {
                    com.mbridge.msdk.newreward.function.a.c cVar3 = this.f4657c;
                    JSONObject jSONObjectA = cVar3.a(cVar3.b(str));
                    if (jSONObjectA != null) {
                        eVar2.a("config", jSONObjectA.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bVar != null) {
                if (bVar.h() == com.mbridge.msdk.foundation.b.c.f3331d) {
                    eVar2.a("result", 1);
                } else {
                    eVar2.a("result", 2);
                    eVar2.a("reason", bVar.b());
                }
                eVar2.a("acr", bVar.c());
                eVar2.a("her", bVar.e());
                eVar2.a("nrr", bVar.d());
                eVar2.a("cer", bVar.f());
            } else {
                eVar2.a("result", 2);
                eVar2.a("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int i12 = 0;
                while (i12 < list.size()) {
                    com.mbridge.msdk.newreward.function.c.a.b bVarA = list.get(i12).a();
                    if (bVarA != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        StringBuilder sb = new StringBuilder();
                        i11 = i12;
                        sb.append(bVarA.s());
                        sb.append("");
                        jSONObject2.put("ecppv", z.b(sb.toString()));
                        jSONObject2.put("showCount", bVarA.t());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - bVarA.I());
                        jSONArray.put(jSONObject2);
                    } else {
                        i11 = i12;
                    }
                    i12 = i11 + 1;
                }
                eVar2.a(DataSchemeDataSource.SCHEME_DATA, jSONArray.toString());
            }
            if (cVar != null) {
                cVar.a("m_candidate_data");
                cVar.k("m_candidate_data");
                cVar.a("m_candidate_data", eVar2);
                if (bVar != null && bVar.a() != null && eVar != null) {
                    cVar.b(eVar.D().a());
                }
            }
            c cVar4 = this.f4656b;
            cVar4.a(eVar, f.METRICS_KEY_M_CANDIDATE_DATE, cVar4.a("metrics_data", eVar2));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
