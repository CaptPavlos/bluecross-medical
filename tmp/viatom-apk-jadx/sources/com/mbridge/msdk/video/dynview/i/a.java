package com.mbridge.msdk.video.dynview.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    public static String a(Context context, int i10) {
        String str = i10 == 1 ? "_por" : "_land";
        String strT = ab.t(context);
        return strT.startsWith("zh") ? (strT.contains("TW") || strT.contains("HK")) ? "mbridge_reward_two_title_zh_trad" : "mbridge_reward_two_title_zh" : strT.startsWith("ja") ? "mbridge_reward_two_title_japan".concat(str) : strT.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR) ? "mbridge_reward_two_title_germany".concat(str) : strT.startsWith("ko") ? "mbridge_reward_two_title_korea".concat(str) : strT.startsWith("fr") ? "mbridge_reward_two_title_france".concat(str) : strT.startsWith("ar") ? "mbridge_reward_two_title_arabia".concat(str) : strT.startsWith("ru") ? "mbridge_reward_two_title_russian".concat(str) : "mbridge_reward_two_title_en".concat(str);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter("alecfc");
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (queryParameter.equals("1")) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter;
                }
            }
            return "";
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static int a(CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return 100;
        }
        int iF = campaignEx.getRewardTemplateMode().f();
        if (iF != 302 && iF != 802 && iF != 902) {
            if (iF != 904) {
                return 100;
            }
            if (!a(campaignEx.getRewardTemplateMode().e())) {
                return -1;
            }
        }
        return -3;
    }
}
