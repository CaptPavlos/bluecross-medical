package com.mbridge.msdk.reward.adapter;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ak;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f5209a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5210b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f5211c;

    /* renamed from: d, reason: collision with root package name */
    private final com.mbridge.msdk.videocommon.d.c f5212d;
    private final String e;

    public d(String str, String str2, boolean z9, com.mbridge.msdk.videocommon.d.c cVar, String str3) {
        this.f5209a = str;
        this.f5210b = str2;
        this.f5211c = z9;
        this.f5212d = cVar;
        this.e = str3;
    }

    public final e a(boolean z9, String str, int i10, String str2, String str3, String str4, String str5, boolean z10, int i11) throws JSONException, NoSuchAlgorithmException {
        int iT;
        int iU;
        String strK = com.mbridge.msdk.foundation.controller.c.m().k();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.c.m().k() + com.mbridge.msdk.foundation.controller.c.m().b());
        int i12 = z9 ? 2 : 3;
        com.mbridge.msdk.videocommon.d.c cVar = this.f5212d;
        if (cVar != null) {
            iT = cVar.t();
            iU = this.f5212d.u();
        } else {
            iT = 0;
            iU = 0;
        }
        String strA = com.mbridge.msdk.foundation.same.a.b.a(this.f5210b, "reward");
        int i13 = this.f5211c ? 287 : 94;
        e eVar = new e();
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.APP_ID, strK);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f5210b);
        if (!TextUtils.isEmpty(this.f5209a)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f5209a);
        }
        if (com.mbridge.msdk.e.b.a()) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ttc_ids", str4 == null ? "" : str4);
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "install_ids", str3 == null ? "" : str3);
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "req_type", String.valueOf(i12));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_num", String.valueOf(iT));
        if (this.f5211c) {
            iU = 1;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "tnum", String.valueOf(iU));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, e.f3759d, strA);
        String str6 = e.e;
        if (str == null) {
            str = "";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str6, str);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, String.valueOf(1));
        String str7 = e.f;
        if (str2 == null) {
            str2 = "";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str7, str2);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_type", String.valueOf(i13));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(i10));
        if (!TextUtils.isEmpty(str5)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "token", str5);
        }
        if (this.f5211c) {
            if (i11 == com.mbridge.msdk.foundation.same.a.I || i11 == com.mbridge.msdk.foundation.same.a.H) {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", "1");
            } else {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", "0");
            }
        }
        com.mbridge.msdk.videocommon.d.c cVar2 = this.f5212d;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.k())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "u_stid", this.f5212d.k());
        }
        com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
        if (aVarB != null && !TextUtils.isEmpty(aVarB.b())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "r_stid", aVarB.b());
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "rw_plus", z10 ? "1" : "0");
        String strD = ak.d(this.f5210b);
        if (!TextUtils.isEmpty(strD)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "j", strD);
        }
        String str8 = this.e;
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str8 != null ? str8 : "");
        return eVar;
    }
}
