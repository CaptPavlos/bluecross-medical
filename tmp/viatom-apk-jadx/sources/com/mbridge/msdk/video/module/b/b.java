package com.mbridge.msdk.video.module.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.z;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, ArrayList<String>> f6131a = new HashMap<>();

    public static void a(Context context, CampaignEx campaignEx, int i10, int i11, int i12) {
        String str;
        if (i11 == 0 || context == null || campaignEx == null) {
            return;
        }
        try {
            List<Map<Integer, String>> listI = campaignEx.getNativeVideoTracking().i();
            int i13 = ((i10 + 1) * 100) / i11;
            if (listI != null) {
                int i14 = 0;
                int i15 = 0;
                while (i14 < listI.size()) {
                    Map<Integer, String> map = listI.get(i14);
                    if (map != null && map.size() > 0) {
                        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                        int i16 = i14;
                        while (it.hasNext()) {
                            Map.Entry<Integer, String> next = it.next();
                            Integer key = next.getKey();
                            int iIntValue = key.intValue();
                            String value = next.getValue();
                            if (campaignEx.getSpareOfferFlag() == 1) {
                                str = value + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + i12;
                            } else {
                                str = value + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + i12;
                            }
                            if (iIntValue <= i13 && !TextUtils.isEmpty(str)) {
                                String[] strArr = {str};
                                if (i15 < 1) {
                                    i15++;
                                    try {
                                        e eVar = new e();
                                        eVar.a("percent", key);
                                        d.a().a("2000140", campaignEx, eVar);
                                    } catch (Exception unused) {
                                    }
                                }
                                int i17 = i15;
                                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), strArr, false, true);
                                it.remove();
                                listI.remove(i16);
                                i16--;
                                i15 = i17;
                            }
                        }
                        i14 = i16;
                    }
                    i14++;
                }
            }
        } catch (Throwable unused2) {
            af.b("VideoViewReport", "reportPlayPercentageData error");
        }
    }

    public static void b(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().j() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().j(), false, false);
    }

    public static void c(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().k() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().k(), false, false);
    }

    public static void d(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
            return;
        }
        String campaignUnitId = campaignEx.getCampaignUnitId();
        ArrayList<String> arrayList = f6131a.get(campaignUnitId);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            f6131a.put(campaignUnitId, arrayList);
        }
        if (arrayList.contains(campaignEx.getId())) {
            return;
        }
        try {
            d.a().a("2000142", campaignEx);
        } catch (Exception unused) {
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
        arrayList.add(campaignEx.getId());
    }

    public static void e(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().s() == null) {
            return;
        }
        d.a().a("2000143", campaignEx);
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().s(), false, false);
    }

    public static void f(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().m() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().m(), false, false);
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().p() == null) {
            return;
        }
        d.a().a("2000141", campaignEx);
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().p(), false, false);
    }

    public static void a(Context context, CampaignEx campaignEx, int i10, int i11) {
        try {
            String[] strArrR = campaignEx.getNativeVideoTracking().r();
            if (campaignEx.getNativeVideoTracking() == null || strArrR == null) {
                return;
            }
            String[] strArr = new String[strArrR.length];
            for (int i12 = 0; i12 < strArrR.length; i12++) {
                String str = strArrR[i12];
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("endscreen_type", i10);
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    string = z.b(string);
                }
                if (!TextUtils.isEmpty(string)) {
                    str = str + "&value=" + URLEncoder.encode(string);
                }
                strArr[i12] = campaignEx.getSpareOfferFlag() == 1 ? str + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + i11 : str + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + i11;
            }
            try {
                e eVar = new e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i10));
                d.a().a("2000144", campaignEx, eVar);
                d.a().a("2000147", campaignEx, eVar);
            } catch (Exception unused) {
            }
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), strArr, false, true);
        } catch (Throwable unused2) {
            af.b("VideoViewReport", "reportEndcardshowData error");
        }
    }

    public static void a(String str) {
        f6131a.remove(str);
    }

    public static void a(CampaignEx campaignEx, Map<Integer, String> map, String str, int i10) {
        CampaignEx campaignEx2;
        String str2;
        if (campaignEx == null || map == null) {
            return;
        }
        try {
            if (map.size() > 0) {
                Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> next = it.next();
                    Integer key = next.getKey();
                    String value = next.getValue();
                    if (i10 != key.intValue() || TextUtils.isEmpty(value)) {
                        campaignEx2 = campaignEx;
                        str2 = str;
                    } else {
                        campaignEx2 = campaignEx;
                        str2 = str;
                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx2, str2, value, false, false);
                        it.remove();
                    }
                    campaignEx = campaignEx2;
                    str = str2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(CampaignEx campaignEx, String str) {
        CampaignEx campaignEx2;
        String str2;
        if (campaignEx != null) {
            try {
                if (campaignEx.getAdUrlList() == null || campaignEx.getAdUrlList().size() <= 0) {
                    return;
                }
                for (String str3 : campaignEx.getAdUrlList()) {
                    if (TextUtils.isEmpty(str3)) {
                        campaignEx2 = campaignEx;
                        str2 = str;
                    } else {
                        campaignEx2 = campaignEx;
                        str2 = str;
                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx2, str2, str3, false, false);
                    }
                    campaignEx = campaignEx2;
                    str = str2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, String str3) {
        String str4 = "&";
        String str5 = "";
        if (campaignEx == null || cVar == null) {
            return;
        }
        try {
            com.mbridge.msdk.video.module.c.b bVar = new com.mbridge.msdk.video.module.c.b(c.m().c());
            com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e();
            eVar.a("user_id", z.b(str2));
            eVar.a("cb_type", "1");
            eVar.a(CampaignEx.JSON_KEY_REWARD_NAME, cVar.a());
            eVar.a(CampaignEx.JSON_KEY_REWARD_AMOUNT, cVar.b() + "");
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            eVar.a("click_id", campaignEx.getRequestIdNotice());
            if (!TextUtils.isEmpty(str3)) {
                eVar.a("extra", str3);
            }
            bVar.addExtraParams("", eVar);
            String strConcat = campaignEx.getHost() + "/addReward?";
            String strTrim = eVar.b().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                if (!strConcat.endsWith("?") && !strConcat.endsWith("&")) {
                    if (!strConcat.contains("?")) {
                        str4 = "?";
                    }
                    strConcat = strConcat.concat(str4);
                }
                str5 = strConcat + strTrim;
            }
            String str6 = str5;
            af.b("VideoViewReport", "rewardUrl:".concat(str6));
            com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, campaignEx.getCampaignUnitId(), str6, false, false);
        } catch (Throwable th) {
            af.b("VideoViewReport", th.getMessage(), th);
        }
    }
}
