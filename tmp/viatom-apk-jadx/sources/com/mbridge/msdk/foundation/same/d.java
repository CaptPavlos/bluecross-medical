package com.mbridge.msdk.foundation.same;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f3676a = new LinkedList();

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.equals(str2, com.mbridge.msdk.foundation.same.net.e.d.f().f3736c) || TextUtils.equals(str2, com.mbridge.msdk.foundation.same.net.e.d.f().F) || (!TextUtils.equals(str, "download_video") && !TextUtils.equals(str, "download_image") && !TextUtils.equals(str, "download_template") && !TextUtils.equals(str, "") && !TextUtils.equals(str, "download_other") && !TextUtils.equals(str, "download_html") && !TextUtils.equals(str, "applets_model") && !TextUtils.equals(str, "campaign") && !TextUtils.equals(str, "bid_request") && !TextUtils.equals(str, "more_offer") && !TextUtils.equals(str, "mraid_js") && !TextUtils.equals(str, "om_sdk") && !TextUtils.equals(str, "roas") && !TextUtils.equals(str, "web_env_check_js") && !TextUtils.equals(str, "setting")) || !ah.a().a("request_track", true)) ? false : true;
    }

    public static int a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return -1;
        }
        try {
            if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                return ak.b(campaignEx.getMof_template_url());
            }
            return ak.b(str);
        } catch (Exception e) {
            af.b("SameTools", e.getMessage());
            return -1;
        }
    }

    public static String a(DownloadRequest<?> downloadRequest) {
        if (downloadRequest == null) {
            return "un_known";
        }
        String str = downloadRequest.get("download_scene", "");
        return TextUtils.isEmpty(str) ? "un_known" : str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String[] strArrSplit = str.split(";");
            if (strArrSplit.length > 0) {
                return strArrSplit[0].trim();
            }
            return str.trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(String str, File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        List<String> list = f3676a;
                        if (list.contains(str)) {
                            list.add(str);
                            System.gc();
                        } else {
                            ad.a(com.mbridge.msdk.a.b.c(s3.a.a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, ad.b(file))).getBytes(), file);
                            list.add(str);
                            System.gc();
                        }
                        Runtime.getRuntime().gc();
                    } catch (Throwable th) {
                        try {
                            af.b("SameTools", th.getMessage());
                            f3676a.add(str);
                            System.gc();
                            Runtime.getRuntime().gc();
                        } catch (Throwable th2) {
                            try {
                                f3676a.add(str);
                                System.gc();
                                Runtime.getRuntime().gc();
                            } catch (Throwable unused) {
                            }
                            throw th2;
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
