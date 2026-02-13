package com.mbridge.msdk.newreward.function.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.f.f;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.CustomInfoManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends a {

    /* renamed from: c, reason: collision with root package name */
    private final int f5002c;

    /* renamed from: d, reason: collision with root package name */
    private final String f5003d;
    private final String e;
    private final boolean f;
    private final String g;
    private int h;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f5000a = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private boolean f5004i = false;

    /* renamed from: b, reason: collision with root package name */
    private final Context f5001b = com.mbridge.msdk.foundation.controller.c.m().c();

    public e(int i10, String str, String str2, boolean z9, String str3) {
        this.f5002c = i10;
        this.f5003d = str;
        this.e = str2;
        this.f = z9;
        this.g = str3;
    }

    public final void a(Map<String, String> map) {
        if (this.f5000a == null || map == null || map.isEmpty()) {
            return;
        }
        this.f5000a.putAll(map);
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str) || !com.mbridge.msdk.e.b.a()) {
            return;
        }
        this.f5000a.put("install_ids", str);
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str) && com.mbridge.msdk.e.b.a() && com.mbridge.msdk.e.b.a()) {
            this.f5000a.put("ttc_ids", str);
        }
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5000a.put(com.mbridge.msdk.foundation.same.net.f.e.f, str);
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5000a.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str);
    }

    public final Map<String, String> f() throws JSONException {
        int iT;
        int iU;
        Map<String, String> mapA = a();
        if (mapA != null) {
            this.f5000a.putAll(mapA);
        }
        com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e(this.f5000a);
        if (com.mbridge.msdk.e.b.a()) {
            eVar.a("gp_version", k.d(this.f5001b));
        }
        eVar.a("version_flag", "1");
        if (com.mbridge.msdk.e.b.a()) {
            com.mbridge.msdk.foundation.controller.authoritycontroller.c.c(true);
        }
        eVar.a("misk_spt", String.valueOf(ak.a()));
        String strC = ak.c();
        if (!TextUtils.isEmpty(strC)) {
            eVar.a("misk_spt_det", strC);
        }
        String str = this.e;
        if (str != null) {
            String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str, this.f ? 7 : 8);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            com.mbridge.msdk.c.k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), str);
            if (kVarD != null && !TextUtils.isEmpty(kVarD.a())) {
                eVar.a("u_stid", kVarD.a());
            }
        }
        String strA = com.mbridge.msdk.foundation.same.a.b.a(this.e, "reward");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.e);
        if (!TextUtils.isEmpty(this.f5003d)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f5003d);
        }
        com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.e);
        if (cVarA != null) {
            iT = cVarA.t();
            iU = cVarA.u();
        } else {
            iT = 0;
            iU = 0;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_num", String.valueOf(iT));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "tnum", String.valueOf(this.f5002c != 287 ? iU : 1));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, com.mbridge.msdk.foundation.same.net.f.e.f3759d, strA);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, "1");
        String str2 = com.mbridge.msdk.foundation.same.net.f.e.f;
        String str3 = MBridgeGlobalCommon.SESSION_ID;
        if (str3 == null) {
            str3 = "";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str2, str3);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_type", String.valueOf(this.f5002c));
        if (!TextUtils.isEmpty(this.g)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "token", this.g);
        }
        if (this.f5002c == 287) {
            int i10 = this.h;
            if (i10 == com.mbridge.msdk.foundation.same.a.I || i10 == com.mbridge.msdk.foundation.same.a.H) {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", "1");
            } else {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", "0");
            }
        }
        if (cVarA != null && !TextUtils.isEmpty(cVarA.k())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "u_stid", cVarA.k());
        }
        com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
        if (aVarB != null && !TextUtils.isEmpty(aVarB.b())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "r_stid", aVarB.b());
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "rw_plus", this.f5004i ? "1" : "0");
        String strD = ak.d(this.e);
        if (!TextUtils.isEmpty(strD)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "j", strD);
        }
        f.a(eVar, this.f5001b);
        f.a(eVar);
        f.c(eVar);
        f.e(eVar);
        f.f(eVar);
        return eVar.a();
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.g;
    }

    public final void a(int i10) {
        this.h = i10;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5000a.put(com.mbridge.msdk.foundation.same.net.f.e.e, str);
    }

    public final int b() {
        return this.f5002c;
    }

    public final void a(boolean z9) {
        this.f5004i = z9;
    }

    public final void b(int i10) {
        this.f5000a.put(TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(i10));
    }

    public final String c() {
        return this.f5003d;
    }

    public final void c(int i10) {
        this.f5000a.put("req_type", String.valueOf(i10));
    }
}
