package com.mbridge.msdk.foundation.same;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class a {
        public abstract void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar);
    }

    public static void a(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.d.c cVar, a aVar) {
        int i10;
        if (campaignEx == null || aVar == null) {
            return;
        }
        if (cVar == null) {
            try {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        boolean zC = ak.c(campaignEx);
        int iD = ak.d(context, campaignEx.getPackageName());
        if (context != null) {
            try {
                i10 = f.c(context) ? 1 : 2;
            } catch (Exception e3) {
                af.b("SameCommon", e3.getMessage());
            }
        } else {
            i10 = 0;
        }
        e eVar = new e();
        eVar.a("cid", campaignEx.getId());
        eVar.a(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
        eVar.a(CampaignEx.JSON_KEY_RETARGET_OFFER, Integer.valueOf(campaignEx.getRetarget_offer()));
        eVar.a("ind", Integer.valueOf(iD));
        eVar.a("stage", 1);
        eVar.a(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, 0);
        eVar.a("per", Integer.valueOf(i10));
        if (zC) {
            if (iD != 1) {
                cVar.a("m_campaign_filtered", eVar);
                aVar.a("m_campaign_filtered", cVar);
            }
            cVar.a("m_campaign_ind_retarget", eVar);
            aVar.a("m_campaign_ind_retarget", cVar);
            return;
        }
        if (iD == 1) {
            cVar.a("m_campaign_filtered", eVar);
            aVar.a("m_campaign_filtered", cVar);
        }
        cVar.a("m_campaign_ind_unretarget", eVar);
        aVar.a("m_campaign_ind_unretarget", cVar);
    }

    public static int b(Context context, CampaignEx campaignEx) {
        if (context == null || campaignEx == null) {
            return 2;
        }
        boolean zC = ak.c(context, campaignEx.getPackageName());
        boolean zC2 = ak.c(campaignEx);
        if (campaignEx.getWtick() == 1) {
            return 3;
        }
        if (zC2 && zC) {
            return 3;
        }
        if (zC2 || zC) {
            return campaignEx.getFilterCallBackState();
        }
        return 3;
    }

    public static String a(List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null && campaignEx.getCreativeId() != 0) {
                arrayList.add(campaignEx);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            try {
                CampaignEx campaignEx2 = (CampaignEx) arrayList.get(i10);
                if (campaignEx2 != null) {
                    long creativeId = campaignEx2.getCreativeId();
                    if (i10 == arrayList.size() - 1) {
                        sb.append(creativeId);
                    } else {
                        sb.append(creativeId);
                        sb.append(",");
                    }
                }
            } catch (Exception e) {
                af.b("SameCommon", "getCreativeID", e);
            }
        }
        return sb.toString();
    }

    public static boolean a(Context context, CampaignEx campaignEx) {
        if (context == null || campaignEx == null) {
            return false;
        }
        return ak.c(campaignEx) || campaignEx.getWtick() == 1 || !ak.c(context, campaignEx.getPackageName());
    }

    public static long a(long j10, long j11) {
        return j10 >= 0 ? j10 : j11;
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                String str3 = "";
                if (strArrSplit.length == 2) {
                    String str4 = strArrSplit[0];
                    if (!TextUtils.isEmpty(str4)) {
                        String str5 = strArrSplit[1];
                        if (str5 != null) {
                            str3 = str5;
                        }
                        jSONObject.put(str4, str3);
                    }
                } else if (strArrSplit.length == 1) {
                    String str6 = strArrSplit[0];
                    if (!TextUtils.isEmpty(str6)) {
                        jSONObject.put(str6, "");
                    }
                }
            }
            return jSONObject;
        } catch (Exception e) {
            af.a("SameCommon", "coverReportMessage", e);
            return null;
        } catch (Throwable th) {
            af.a("SameCommon", "coverReportMessage", th);
            return null;
        }
    }
}
