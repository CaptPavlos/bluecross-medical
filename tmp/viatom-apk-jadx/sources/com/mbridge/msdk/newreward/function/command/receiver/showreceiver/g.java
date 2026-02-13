package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements com.mbridge.msdk.newreward.function.command.receiver.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f4890a = "RedirectReceiver";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.g$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4891a;

        static {
            int[] iArr = new int[RedirectType.values().length];
            f4891a = iArr;
            try {
                iArr[RedirectType.NOTICE_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4891a[RedirectType.CLICK_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4891a[RedirectType.IMPRESSION_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4891a[RedirectType.ONLY_IMPRESSION_URL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4891a[RedirectType.PV_URL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_CLICK_URL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_EC_SHOW_URL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_CLOSE_URL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_MUTE_URL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_UN_MUTE_URL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_IMPRESSION_URL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_ERROR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_PLAY_PERCENTAGE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_PAUSE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4891a[RedirectType.AD_TRACKING_RESUME.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4891a[RedirectType.AD_URL_LIST.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4891a[RedirectType.ADV_IMP_LIST.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4891a[RedirectType.ADD_REWARD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) throws JSONException {
        List<String> pv_urls;
        String[] strArrL;
        String[] strArrR;
        String[] strArrS;
        String[] strArrJ;
        String[] strArrK;
        String[] strArrP;
        String[] strArrO;
        String[] strArrM;
        String[] strArrN;
        Map map = (Map) obj;
        RedirectModel redirectModel = (RedirectModel) map.get("campaign_redirect");
        if (redirectModel == null) {
            return;
        }
        CampaignEx campaignEx = redirectModel.getCampaignEx();
        com.mbridge.msdk.newreward.function.e.f settingModel = redirectModel.getSettingModel();
        switch (AnonymousClass1.f4891a[redirectModel.getRedirectType().ordinal()]) {
            case 1:
                String noticeUrl = campaignEx.getNoticeUrl();
                Object obj2 = map.get("click_scenario");
                int iIntValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 1;
                try {
                    if (!TextUtils.isEmpty(noticeUrl)) {
                        noticeUrl = noticeUrl.contains(com.mbridge.msdk.foundation.same.a.f3609m) ? noticeUrl.replace(com.mbridge.msdk.foundation.same.a.f3609m + "=" + Uri.parse(noticeUrl).getQueryParameter(com.mbridge.msdk.foundation.same.a.f3609m), com.mbridge.msdk.foundation.same.a.f3609m + "=" + iIntValue) : noticeUrl + "&" + com.mbridge.msdk.foundation.same.a.f3609m + "=" + iIntValue;
                    }
                } catch (Throwable th) {
                    af.b("RedirectReceiver", th.getMessage());
                }
                String str = noticeUrl;
                if (!TextUtils.isEmpty(str)) {
                    com.mbridge.msdk.click.a.a(redirectModel.getContext(), campaignEx, redirectModel.getUnitId(), str, true, false, 3);
                    break;
                }
                break;
            case 2:
                new com.mbridge.msdk.click.a(redirectModel.getContext(), redirectModel.getUnitId()).a(com.mbridge.msdk.newreward.function.h.b.a(a(redirectModel).toString(), campaignEx));
                break;
            case 3:
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), a(campaignEx.getImpressionURL(), campaignEx, settingModel), false, true, com.mbridge.msdk.click.a.a.g);
                break;
            case 4:
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), a(campaignEx.getOnlyImpressionURL(), campaignEx, settingModel), false, true, com.mbridge.msdk.click.a.a.h);
                break;
            case 5:
                if (campaignEx != null && campaignEx.getPv_urls() != null && (pv_urls = campaignEx.getPv_urls()) != null && !pv_urls.isEmpty()) {
                    Iterator<String> it = pv_urls.iterator();
                    while (it.hasNext()) {
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), it.next(), false, true);
                    }
                    break;
                }
                break;
            case 6:
                if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (strArrL = campaignEx.getNativeVideoTracking().l()) != null && strArrL.length > 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArrL, true, false);
                    break;
                }
                break;
            case 7:
                if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (strArrR = campaignEx.getNativeVideoTracking().r()) != null && strArrR.length > 0) {
                    try {
                        String[] strArr = new String[strArrR.length];
                        for (int i10 = 0; i10 < strArrR.length; i10++) {
                            String strA = a(strArrR[i10], campaignEx, settingModel);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("endscreen_type", redirectModel.getEndScreenType());
                            String string = jSONObject.toString();
                            if (!TextUtils.isEmpty(string)) {
                                string = z.b(string);
                            }
                            if (!TextUtils.isEmpty(string)) {
                                strA = strA + "&value=" + URLEncoder.encode(string);
                            }
                            strArr[i10] = strA;
                        }
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArr, false, true);
                        break;
                    } catch (Exception e) {
                        af.b("RedirectReceiver", e.getMessage());
                        return;
                    }
                }
                break;
            case 8:
                if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (strArrS = campaignEx.getNativeVideoTracking().s()) != null && strArrS.length > 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArrS, false, false);
                    break;
                }
                break;
            case 9:
                if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (strArrJ = campaignEx.getNativeVideoTracking().j()) != null && strArrJ.length > 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArrJ, false, false);
                    break;
                }
                break;
            case 10:
                if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (strArrK = campaignEx.getNativeVideoTracking().k()) != null && strArrK.length > 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArrK, false, false);
                    break;
                }
                break;
            case 11:
                if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (strArrP = campaignEx.getNativeVideoTracking().p()) != null && strArrP.length > 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArrP, false, true);
                    break;
                }
                break;
            case 12:
                if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (strArrO = campaignEx.getNativeVideoTracking().o()) != null && strArrO.length > 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArrO, false, true);
                    break;
                }
                break;
            case 13:
                try {
                    int percentRate = redirectModel.getPercentRate();
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null) {
                        ArrayList arrayList = new ArrayList();
                        List<Map<Integer, String>> listI = campaignEx.getNativeVideoTracking().i();
                        if (!listI.isEmpty()) {
                            Iterator<Map<Integer, String>> it2 = listI.iterator();
                            while (it2.hasNext()) {
                                for (Map.Entry<Integer, String> entry : it2.next().entrySet()) {
                                    if (entry.getKey().intValue() == percentRate) {
                                        arrayList.add(a(entry.getValue(), campaignEx, settingModel));
                                    }
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
                            if (strArr2.length > 0) {
                                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArr2, false, false);
                                break;
                            }
                        }
                    }
                } catch (Exception e3) {
                    af.b("RedirectReceiver", e3.getMessage());
                    return;
                }
                break;
            case 14:
                if (campaignEx != null) {
                    try {
                        if (campaignEx.getNativeVideoTracking() != null && (strArrM = campaignEx.getNativeVideoTracking().m()) != null && strArrM.length > 0) {
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArrM, false, false);
                            break;
                        }
                    } catch (Exception e7) {
                        if (MBridgeConstans.DEBUG) {
                            e7.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                break;
            case 15:
                if (campaignEx != null) {
                    try {
                        if (campaignEx.getNativeVideoTracking() != null && (strArrN = campaignEx.getNativeVideoTracking().n()) != null && strArrN.length > 0) {
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, redirectModel.getUnitId(), strArrN, false, false);
                            break;
                        }
                    } catch (Exception e10) {
                        if (MBridgeConstans.DEBUG) {
                            e10.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                break;
            case 16:
                if (campaignEx != null) {
                    try {
                        if (campaignEx.getAdUrlList() != null && !campaignEx.getAdUrlList().isEmpty()) {
                            for (String str2 : campaignEx.getAdUrlList()) {
                                if (!TextUtils.isEmpty(str2)) {
                                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, campaignEx.getCampaignUnitId(), str2, false, false);
                                }
                            }
                            break;
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        return;
                    }
                }
                break;
            case 17:
                if (campaignEx != null) {
                    try {
                        if (campaignEx.getAdvImpList() != null && !campaignEx.getAdvImpList().isEmpty()) {
                            Iterator<Map.Entry<Integer, String>> it3 = campaignEx.getAdvImpList().entrySet().iterator();
                            while (it3.hasNext()) {
                                Map.Entry<Integer, String> next = it3.next();
                                Integer key = next.getKey();
                                String value = next.getValue();
                                if (redirectModel.getCurrPercentAge() == key.intValue() && !TextUtils.isEmpty(value)) {
                                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, campaignEx.getCampaignUnitId(), value, false, false);
                                    it3.remove();
                                }
                            }
                            break;
                        }
                    } catch (Exception e12) {
                        e12.printStackTrace();
                        return;
                    }
                }
                break;
            case 18:
                if (campaignEx != null) {
                    try {
                        com.mbridge.msdk.videocommon.b.c reward = redirectModel.getReward();
                        if (reward != null) {
                            com.mbridge.msdk.video.module.c.b bVar = new com.mbridge.msdk.video.module.c.b(com.mbridge.msdk.foundation.controller.c.m().c());
                            com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e();
                            com.mbridge.msdk.newreward.a.f devExtraData = redirectModel.getDevExtraData();
                            String str3 = "";
                            if (devExtraData == null) {
                                eVar.a("user_id", z.b(""));
                            } else {
                                if (!TextUtils.isEmpty(devExtraData.b())) {
                                    eVar.a("extra", devExtraData.b());
                                }
                                eVar.a("user_id", z.b(devExtraData.a()));
                            }
                            eVar.a("cb_type", "1");
                            eVar.a(CampaignEx.JSON_KEY_REWARD_NAME, reward.a());
                            eVar.a(CampaignEx.JSON_KEY_REWARD_AMOUNT, reward.b() + "");
                            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, redirectModel.getUnitId());
                            eVar.a("click_id", campaignEx.getRequestIdNotice());
                            bVar.addExtraParams("", eVar);
                            String strConcat = campaignEx.getHost() + "/addReward?";
                            String strTrim = eVar.b().trim();
                            if (!TextUtils.isEmpty(strTrim)) {
                                if (!strConcat.endsWith("?") && !strConcat.endsWith("&")) {
                                    strConcat = strConcat.concat(strConcat.contains("?") ? "&" : "?");
                                }
                                str3 = strConcat + strTrim;
                            }
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, campaignEx.getCampaignUnitId(), str3, false, false);
                            break;
                        }
                    } catch (Throwable th2) {
                        af.b("RedirectReceiver", th2.getMessage());
                        return;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(java.lang.String r4, com.mbridge.msdk.foundation.entity.CampaignEx r5, com.mbridge.msdk.newreward.function.e.f r6) {
        /*
            r3 = this;
            r0 = 1
            if (r6 == 0) goto L14
            com.mbridge.msdk.videocommon.d.c r1 = r6.b()     // Catch: java.lang.Exception -> L12
            if (r1 == 0) goto L14
            com.mbridge.msdk.videocommon.d.c r6 = r6.b()     // Catch: java.lang.Exception -> L12
            int r6 = r6.y()     // Catch: java.lang.Exception -> L12
            goto L15
        L12:
            r5 = move-exception
            goto L5b
        L14:
            r6 = r0
        L15:
            int r1 = r5.getSpareOfferFlag()     // Catch: java.lang.Exception -> L12
            java.lang.String r2 = "&tmorl="
            if (r1 != r0) goto L3c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L12
            r0.<init>()     // Catch: java.lang.Exception -> L12
            r0.append(r4)     // Catch: java.lang.Exception -> L12
            java.lang.String r1 = "&to=1&cbt="
            r0.append(r1)     // Catch: java.lang.Exception -> L12
            int r5 = r5.getCbt()     // Catch: java.lang.Exception -> L12
            r0.append(r5)     // Catch: java.lang.Exception -> L12
            r0.append(r2)     // Catch: java.lang.Exception -> L12
            r0.append(r6)     // Catch: java.lang.Exception -> L12
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Exception -> L12
            return r4
        L3c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L12
            r0.<init>()     // Catch: java.lang.Exception -> L12
            r0.append(r4)     // Catch: java.lang.Exception -> L12
            java.lang.String r1 = "&to=0&cbt="
            r0.append(r1)     // Catch: java.lang.Exception -> L12
            int r5 = r5.getCbt()     // Catch: java.lang.Exception -> L12
            r0.append(r5)     // Catch: java.lang.Exception -> L12
            r0.append(r2)     // Catch: java.lang.Exception -> L12
            r0.append(r6)     // Catch: java.lang.Exception -> L12
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Exception -> L12
            return r4
        L5b:
            java.lang.String r6 = "RedirectReceiver"
            java.lang.String r5 = r5.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r6, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.g.a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.newreward.function.e.f):java.lang.String");
    }

    private JSONObject a(RedirectModel redirectModel) throws JSONException {
        int i10;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.h, redirectModel.getxInScreen());
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3605i, redirectModel.getyInScreen());
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3609m, redirectModel.getClickSenario());
            try {
                i10 = com.mbridge.msdk.foundation.controller.c.m().c().getResources().getConfiguration().orientation;
            } catch (Exception e) {
                e.printStackTrace();
                i10 = 1;
            }
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3607k, i10);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3608l, ak.d(com.mbridge.msdk.foundation.controller.c.m().c()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f3606j, jSONObject2);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }
}
