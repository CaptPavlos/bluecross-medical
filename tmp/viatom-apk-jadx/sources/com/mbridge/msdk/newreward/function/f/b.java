package com.mbridge.msdk.newreward.function.f;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.f.f;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aq;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private final String f4990a = "CN";

    /* renamed from: b, reason: collision with root package name */
    private final String f4991b = "117361";

    /* renamed from: c, reason: collision with root package name */
    private final String f4992c = "92762";

    /* renamed from: d, reason: collision with root package name */
    private final String f4993d = "936dcbdd57fe235fd7cf61c2e93da3c4";
    private CampaignEx e;

    public final void a(CampaignEx campaignEx) {
        this.e = campaignEx;
    }

    public final Map<String, String> b() throws JSONException {
        String str;
        String str2;
        String str3;
        if (this.e == null) {
            return null;
        }
        com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e(a());
        try {
            String strK = com.mbridge.msdk.foundation.controller.c.m().k();
            String campaignUnitId = this.e.getCampaignUnitId();
            String id = this.e.getId();
            String requestIdNotice = this.e.getRequestIdNotice();
            this.e.getRequestId();
            String strA = aq.a(this.e.getendcard_url(), "mof_testuid");
            if (TextUtils.isEmpty(strA)) {
                strA = aq.a(this.e.getendcard_url(), "mof_uid");
            }
            String strR = (TextUtils.isEmpty(strK) || h.a().b(strK) == null) ? "CN" : h.a().b(strK).r();
            String str4 = strA;
            String strA2 = aq.a(this.e.getendcard_url(), "mcc");
            String str5 = strR;
            String strA3 = aq.a(this.e.getendcard_url(), "mnc");
            String strA4 = aq.a(this.e.getendcard_url(), "rv_tid");
            boolean zContains = this.e.getendcard_url().contains("ecid");
            CampaignEx campaignEx = this.e;
            String strA5 = zContains ? aq.a(campaignEx.getendcard_url(), "ecid") : String.valueOf(campaignEx.getEcTemplateId());
            String strA6 = aq.a(this.e.getendcard_url(), "tplgp");
            String strA7 = aq.a(this.e.getendcard_url(), "v_fmd5");
            String strA8 = aq.a(this.e.getendcard_url(), "i_fmd5");
            eVar.a("appid", strK);
            eVar.a("sign", SameMD5.getMD5(strK + com.mbridge.msdk.foundation.controller.c.m().b()));
            String str6 = "";
            if (TextUtils.isEmpty(requestIdNotice)) {
                str = "sign";
                str2 = "";
            } else {
                str = "sign";
                str2 = requestIdNotice;
            }
            eVar.a("r_id", str2);
            eVar.a("e", Arrays.toString(new String[]{id}));
            eVar.a("mof_type", "1");
            eVar.a("h5_type", "1");
            eVar.a("mof", "1");
            eVar.a("country_code", TextUtils.isEmpty(str5) ? "CN" : str5);
            eVar.a("mof_ver", "1");
            eVar.a("parent_exchange", "");
            int adType = this.e.getAdType();
            if (adType == 94) {
                str6 = "rewarded_video";
            } else if (adType == 287) {
                str6 = "interstitial_video";
            }
            eVar.a("parent_ad_type", str6);
            eVar.a("oneId", this.e.getReq_ext_data());
            if (TextUtils.isEmpty(strA5)) {
                eVar.a("parent_template_id", "404");
            } else {
                eVar.a("parent_template_id", strA5);
            }
            if (TextUtils.isEmpty(str4)) {
                eVar.a("uc_parent_unit", campaignUnitId);
            } else {
                eVar.a("parent_unit", campaignUnitId);
            }
            eVar.a("mcn", strA3);
            eVar.a("mcc", strA2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("crt_cid", id);
                jSONObject.put("crt_rid", requestIdNotice);
                jSONObject.put("rv_tid", strA4);
                jSONObject.put("ecid", strA5);
                jSONObject.put("tplgp", strA6);
                jSONObject.put("v_fmd5", strA7);
                jSONObject.put("i_fmd5", strA8);
                jSONObject.put("h5_t", 1);
                jSONObject.put("mof_t", 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            eVar.a("mof_data", jSONObject.toString());
            eVar.a("offer_id", id);
            eVar.a(TypedValues.CycleType.S_WAVE_OFFSET, "0");
            eVar.a("category", "0");
            eVar.a("only_impression", "1");
            eVar.a("ping_mode", "1");
            eVar.a("http_req", "2");
            eVar.a("ad_num", "20");
            eVar.a("tnum", "20");
            if (TextUtils.isEmpty(str4)) {
                str3 = "117361";
                eVar.a(MBridgeConstans.APP_ID, "92762");
                eVar.a(str, SameMD5.getMD5("92762936dcbdd57fe235fd7cf61c2e93da3c4"));
            } else {
                str3 = str4;
            }
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str3);
            f.a(eVar, com.mbridge.msdk.foundation.controller.c.m().c());
            f.a(eVar);
            f.c(eVar);
            f.e(eVar);
            f.f(eVar);
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
        return eVar.a();
    }
}
