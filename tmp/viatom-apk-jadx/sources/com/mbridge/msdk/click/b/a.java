package com.mbridge.msdk.click.b;

import android.content.Context;
import android.webkit.URLUtil;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.io.File;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f2791a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f2792b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static int f2793c = 1500;

    /* renamed from: d, reason: collision with root package name */
    private static String f2794d = "2000109";
    private static String e = "DspFilterUtils";

    public static boolean a(CampaignEx campaignEx, String str, int i10) {
        if (campaignEx != null && campaignEx.getTpOffer() == 1) {
            z = campaignEx.getFac() != 0;
            try {
                Context contextC = c.m().c();
                if (contextC != null) {
                    if (URLUtil.isFileUrl(str)) {
                        File file = new File(str.replace("file:////", "").replace("file:///", "").replace("file://", ""));
                        if (file.exists()) {
                            str = ad.b(file);
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", f2794d);
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i10);
                    jSONObject.put("html", str);
                    jSONObject.put("network_type", ab.m(contextC));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    jSONObject.put("cid", campaignEx.getId());
                    if (campaignEx.isBidCampaign()) {
                        jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
                    }
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(e, th.getMessage());
            }
        }
        return z;
    }
}
