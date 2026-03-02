package com.mbridge.msdk.newreward.function.e;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.e.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4969a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4969a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_CAMPAIGN_SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_FAILED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_START.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.METRICS_KEY_M_CANDIDATE_DATE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.METRICS_KEY_M_CANDIDATE_DB.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_IS_READY_CHECK.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4969a[com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_FAIL.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.a.e eVar, Map map, com.mbridge.msdk.newreward.function.command.f fVar) {
        String str;
        String string;
        String str2;
        Object obj;
        Object obj2;
        int iA;
        int iB;
        List<CampaignEx> listE;
        if (eVar == null) {
            return;
        }
        try {
            if (eVar.D() == null || eVar.D().b() == null) {
                str = "2000125";
                string = "";
            } else {
                StringBuilder sb = new StringBuilder();
                str = "2000125";
                sb.append(eVar.D().b().a());
                sb.append("");
                string = sb.toString();
            }
            com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.foundation.same.report.d.d.a().a(eVar.G(), string);
            if (cVarA == null) {
                cVarA = com.mbridge.msdk.foundation.same.report.d.d.a().a(eVar.G(), "");
                if (cVarA != null) {
                    LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.d.c> linkedHashMapB = com.mbridge.msdk.foundation.same.report.d.d.a().b();
                    StringBuilder sb2 = new StringBuilder();
                    str2 = "m_v3_req_retry_end";
                    sb2.append(eVar.G());
                    sb2.append(string);
                    linkedHashMapB.put(sb2.toString(), cVarA);
                } else {
                    str2 = "m_v3_req_retry_end";
                    cVarA = new com.mbridge.msdk.foundation.same.report.d.c();
                    cVarA.c(eVar.G());
                    cVarA.b(eVar.h());
                }
            } else {
                str2 = "m_v3_req_retry_end";
            }
            cVarA.d(eVar.H());
            cVarA.e(eVar.J());
            cVarA.i(eVar.R() ? "1" : "0");
            if (eVar.D() != null) {
                cVarA.b(eVar.D().a());
            }
            if (eVar.x() != null) {
                com.mbridge.msdk.videocommon.d.a aVarA = eVar.x().a();
                if (aVarA != null) {
                    cVarA.h(aVarA.b());
                    cVarA.f(aVarA.c());
                }
                com.mbridge.msdk.videocommon.d.c cVarB = eVar.x().b();
                if (cVarB != null) {
                    cVarA.g(cVarB.l());
                    cVarA.n(cVarB.k());
                }
            }
            if (map == null || !map.containsKey("metrics_data")) {
                obj = null;
                obj2 = null;
            } else {
                obj = map.get("metrics_data");
                obj2 = map.get("resource_type");
            }
            int filterCallBackState = 0;
            switch (AnonymousClass1.f4969a[fVar.ordinal()]) {
                case 1:
                    String str3 = str;
                    cVarA.a(str3);
                    com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar2.a(map);
                    cVarA.a(str3, eVar2);
                    break;
                case 2:
                    cVarA.a("2000126");
                    if (obj instanceof com.mbridge.msdk.newreward.function.c.a.b) {
                        cVarA.b(((com.mbridge.msdk.newreward.function.c.a.b) obj).E());
                    }
                    if (map != null) {
                        map.remove("metrics_data");
                    }
                    com.mbridge.msdk.foundation.same.report.d.e eVar3 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar3.a(map);
                    cVarA.a("2000126", eVar3);
                    break;
                case 3:
                    cVarA.a("2000126");
                    com.mbridge.msdk.foundation.same.report.d.e eVar4 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar4.a(map);
                    cVarA.a("2000126", eVar4);
                    break;
                case 4:
                    cVarA.a("m_v3_req_retry_start");
                    com.mbridge.msdk.foundation.same.report.d.e eVar5 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar5.a(map);
                    cVarA.a("m_v3_req_retry_start", eVar5);
                    break;
                case 5:
                    String str4 = str2;
                    cVarA.a(str4);
                    com.mbridge.msdk.foundation.same.report.d.e eVar6 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar6.a(map);
                    cVarA.a(str4, eVar6);
                    break;
                case 6:
                    cVarA.a("2000127");
                    if (obj instanceof com.mbridge.msdk.newreward.function.c.a.b) {
                        cVarA.b(((com.mbridge.msdk.newreward.function.c.a.b) obj).E());
                    }
                    if (map != null) {
                        map.remove("metrics_data");
                    }
                    com.mbridge.msdk.foundation.same.report.d.e eVar7 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar7.a(map);
                    cVarA.a("2000127", eVar7);
                    break;
                case 7:
                    cVarA.a("2000048");
                    if (obj instanceof com.mbridge.msdk.newreward.function.c.a.b) {
                        cVarA.b(((com.mbridge.msdk.newreward.function.c.a.b) obj).E());
                    }
                    if (map != null) {
                        map.remove("metrics_data");
                    }
                    com.mbridge.msdk.foundation.same.report.d.e eVar8 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar8.a(map);
                    cVarA.a("2000048", eVar8);
                    break;
                case 8:
                    cVarA.a("2000047");
                    if (map != null) {
                        map.remove("metrics_data");
                    }
                    com.mbridge.msdk.foundation.same.report.d.e eVar9 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar9.a(map);
                    cVarA.a("2000047", eVar9);
                    if (obj instanceof com.mbridge.msdk.foundation.c.b) {
                        cVarA.a((com.mbridge.msdk.foundation.c.b) obj);
                        break;
                    }
                    break;
                case 9:
                    com.mbridge.msdk.foundation.same.report.d.e eVar10 = new com.mbridge.msdk.foundation.same.report.d.e();
                    if (eVar.D() == null || eVar.D().b() == null) {
                        iA = 0;
                        iB = 0;
                    } else {
                        com.mbridge.msdk.newreward.function.c.a.b bVarB = eVar.D().b();
                        iA = bVarB.a();
                        iB = bVarB.b();
                        if (bVarB.E() != null && !bVarB.E().isEmpty()) {
                            filterCallBackState = bVarB.E().get(0).getFilterCallBackState();
                        }
                    }
                    eVar10.a("m_load_check", Integer.valueOf(eVar.d() ? 1 : 0));
                    eVar10.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState));
                    eVar10.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA));
                    eVar10.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB));
                    cVarA.a("2000128", eVar10);
                    cVarA.a("2000128");
                    break;
                case 10:
                    cVarA.a("m_download_start");
                    com.mbridge.msdk.foundation.same.report.d.e eVar11 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar11.a(map);
                    if (map != null && (obj2 instanceof Integer)) {
                        filterCallBackState = ((Integer) obj2).intValue();
                    }
                    cVarA.a("m_download_start", eVar11, filterCallBackState);
                    cVarA.a(filterCallBackState);
                    break;
                case 11:
                    cVarA.a("m_download_end");
                    com.mbridge.msdk.foundation.same.report.d.e eVar12 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar12.a(map);
                    if (map != null && (obj2 instanceof Integer)) {
                        filterCallBackState = ((Integer) obj2).intValue();
                    }
                    cVarA.a("m_download_end", eVar12, filterCallBackState);
                    cVarA.a(filterCallBackState);
                    break;
                case 12:
                    cVarA.a("m_candidate_data");
                    cVarA.a("m_candidate_data", (com.mbridge.msdk.foundation.same.report.d.e) (map != null ? map.get("metrics_data") : new com.mbridge.msdk.foundation.same.report.d.e()));
                    break;
                case 13:
                    cVarA.a("m_candidate_db");
                    cVarA.a("m_candidate_db", (com.mbridge.msdk.foundation.same.report.d.e) (map != null ? map.get("metrics_data") : new com.mbridge.msdk.foundation.same.report.d.e()));
                    break;
                case 14:
                    cVarA.a("m_load_check");
                    com.mbridge.msdk.newreward.function.c.a.b bVar = (map == null || !map.containsKey("campaign")) ? null : (com.mbridge.msdk.newreward.function.c.a.b) map.remove("campaign");
                    if (bVar != null && (listE = bVar.E()) != null) {
                        cVarA.b(listE);
                    }
                    com.mbridge.msdk.foundation.same.report.d.e eVar13 = new com.mbridge.msdk.foundation.same.report.d.e();
                    if (map != null) {
                        eVar13.a(map);
                    }
                    cVarA.a("m_load_check", eVar13);
                    break;
                case 15:
                    cVarA.a("m_offer_ready");
                    com.mbridge.msdk.foundation.same.report.d.e eVar14 = new com.mbridge.msdk.foundation.same.report.d.e();
                    if (map != null) {
                        eVar14.a(map);
                    }
                    cVarA.a("m_offer_ready", eVar14);
                    break;
            }
            com.mbridge.msdk.foundation.same.report.d.d.a().a(cVarA);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(cVarA.c(), cVarA, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.a.e eVar, Map<String, String> map, String str) {
        int i10;
        int iB;
        com.mbridge.msdk.newreward.function.c.a.b bVarB;
        try {
            String str2 = "";
            if (eVar.D() != null && eVar.D().b() != null) {
                str2 = eVar.D().b().a() + "";
            }
            com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.foundation.same.report.d.d.a().a(eVar.G(), str2);
            if (cVarA == null) {
                cVarA = new com.mbridge.msdk.foundation.same.report.d.c();
                cVarA.c(eVar.G());
                cVarA.b(eVar.h());
            }
            cVarA.d(eVar.H());
            cVarA.e(eVar.J());
            cVarA.i(eVar.R() ? "1" : "0");
            if (eVar.D() != null) {
                cVarA.b(eVar.D().a());
            }
            if (eVar.x() != null) {
                com.mbridge.msdk.videocommon.d.a aVarA = eVar.x().a();
                if (aVarA != null) {
                    cVarA.h(aVarA.b());
                    cVarA.f(aVarA.c());
                }
                com.mbridge.msdk.videocommon.d.c cVarB = eVar.x().b();
                if (cVarB != null) {
                    cVarA.g(cVarB.l());
                    cVarA.n(cVarB.k());
                }
            }
            cVarA.a(str);
            com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
            if (!TextUtils.isEmpty(str) && str.equals("2000130")) {
                int filterCallBackState = 0;
                if (eVar.D() == null || eVar.D().b() == null || (bVarB = eVar.D().b()) == null) {
                    i10 = 0;
                    iB = 0;
                } else {
                    int iA = bVarB.a();
                    iB = bVarB.b();
                    if (bVarB.E() != null && !bVarB.E().isEmpty()) {
                        filterCallBackState = bVarB.E().get(0).getFilterCallBackState();
                    }
                    i10 = filterCallBackState;
                    filterCallBackState = iA;
                }
                eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(filterCallBackState));
                eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB));
                eVar2.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i10));
            }
            eVar2.a(map);
            cVarA.a(str, eVar2);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(cVarA);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(cVarA.c(), cVarA, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.b.b bVar, Map map, com.mbridge.msdk.newreward.function.command.f fVar) {
        if (bVar == null) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.c(bVar.b());
            cVar.b(bVar.e());
            cVar.d(bVar.c());
            cVar.i(bVar.f() ? "1" : "0");
            if (bVar.g() != null) {
                com.mbridge.msdk.videocommon.d.a aVarA = bVar.g().a();
                if (aVarA != null) {
                    cVar.h(aVarA.b());
                    cVar.f(aVarA.c());
                }
                com.mbridge.msdk.videocommon.d.c cVarB = bVar.g().b();
                if (cVarB != null) {
                    cVar.g(cVarB.l());
                    cVar.n(cVarB.k());
                }
            }
            int i10 = AnonymousClass1.f4969a[fVar.ordinal()];
            if (i10 == 9) {
                cVar.a("2000128");
            } else if (i10 == 15) {
                cVar.a("m_offer_ready");
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                if (map != null) {
                    eVar.a(map);
                }
                cVar.a("m_offer_ready", eVar);
            } else if (i10 == 16) {
                cVar.a("2000131");
                com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar2.a(map);
                cVar.a("2000131", eVar2);
            }
            com.mbridge.msdk.foundation.same.report.d.d.a().a(cVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(cVar.c(), cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
