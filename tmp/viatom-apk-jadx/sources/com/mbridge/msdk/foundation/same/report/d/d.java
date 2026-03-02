package com.mbridge.msdk.foundation.same.report.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.tracker.m;
import com.mbridge.msdk.tracker.network.toolbox.h;
import com.mbridge.msdk.tracker.o;
import com.mbridge.msdk.tracker.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f3839a;

    /* renamed from: b, reason: collision with root package name */
    private volatile m f3840b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, e> f3841c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private LinkedHashMap<String, c> f3842d = new LinkedHashMap<>();
    private Map<String, e> e = new HashMap();

    private d() {
        if (this.f3840b == null) {
            this.f3840b = m.a("metrics_sdk", com.mbridge.msdk.foundation.controller.c.m().c(), d());
        }
        JSONObject jSONObjectA = com.mbridge.msdk.foundation.same.report.c.a();
        if (this.f3840b != null) {
            this.f3840b.a(jSONObjectA);
            this.f3840b.a();
        }
    }

    private w d() {
        try {
            int iA = ah.a().a("metrics", "t_m_e_t", ah.a().a("t_m_e_t", 604800000));
            int iA2 = ah.a().a("metrics", "t_m_e_s", ah.a().a("t_m_e_s", 50));
            int iA3 = ah.a().a("metrics", "t_m_r_c", ah.a().a("t_m_r_c", 50));
            int iA4 = ah.a().a("metrics", "t_m_t", ah.a().a("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS));
            int iA5 = ah.a().a("metrics", "t_m_r_t_s", ah.a().a("t_m_r_t_s", 2));
            int iA6 = ah.a().a("metrics", "t_r_t", ah.a().a("t_r_t", 1));
            if (iA6 != 0 && iA6 != 1) {
                iA6 = 0;
            }
            return new w.a().e(iA).a(iA2).d(iA3).b(iA4).c(iA5).a(new com.mbridge.msdk.foundation.same.report.d()).a(com.mbridge.msdk.foundation.same.report.c.b()).a(new com.mbridge.msdk.foundation.same.report.m()).a(iA6, iA6 == 1 ? new o(new l((byte) 2), com.mbridge.msdk.foundation.same.net.e.d.f().f3738i, com.mbridge.msdk.foundation.same.net.e.d.f().f3742m) : new o(new h(), com.mbridge.msdk.foundation.same.net.e.d.f().f3736c, 0)).a();
        } catch (Exception e) {
            androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("configTrackManager error: "), "EventLibraryReport");
            return null;
        }
    }

    public final void a(String str, c cVar, CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (cVar == null) {
                cVar = new c();
            }
            e eVar = new e();
            eVar.a("st", Long.valueOf(System.currentTimeMillis()));
            if (campaignEx != null) {
                eVar.a("cid", campaignEx.getId());
                eVar.a("lrid", campaignEx.getLocalRequestId());
                eVar.a("rid", campaignEx.getRequestId());
                eVar.a("rid_n", campaignEx.getRequestIdNotice());
                eVar.a("adtp", Integer.valueOf(campaignEx.getAdType()));
                if (!eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
                }
                eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(campaignEx.isBidCampaign() ? 1 : 0));
                eVar.a("bid_tk", campaignEx.getBidToken());
            }
            if (context != null) {
                eVar.a("network_type", Integer.valueOf(ab.m(context)));
            }
            cVar.a(str, eVar);
            b(str, cVar, aVar);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void b(String str, e eVar) {
        try {
            c cVar = new c();
            if (eVar.b(MBridgeConstans.PROPERTIES_UNIT_ID) != null) {
                cVar.d(String.valueOf(eVar.b(MBridgeConstans.PROPERTIES_UNIT_ID)));
            }
            if (eVar.b("lrid") != null && (eVar.b("lrid") instanceof String)) {
                cVar.c(String.valueOf(eVar.b("lrid")));
            }
            cVar.a(str, eVar);
            new f().b(str, c(), cVar, null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void c(String str) {
        try {
            JSONObject jSONObjectA = com.mbridge.msdk.foundation.same.c.a(str);
            if (jSONObjectA != null && jSONObjectA.length() != 0) {
                String strOptString = jSONObjectA.optString("key");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(strOptString);
                eVar.b(0);
                eVar.a(0);
                eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
                eVar.a(jSONObjectA);
                m mVarC = a().c();
                if (mVarC == null || !mVarC.e()) {
                    return;
                }
                mVarC.a(eVar);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("reportByTrackManager error: "), "EventLibraryReport");
            }
        }
    }

    private void b(String str, c cVar, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        try {
            if (Arrays.asList(b.f3813c).contains(str)) {
                cVar.m(str);
            }
            Map<String, e> map = this.e;
            if (map != null && map.containsKey(str)) {
                cVar.a(str, this.e.get(str));
            }
            new f().a(str, c(), cVar, aVar);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final m c() {
        try {
            JSONObject jSONObjectA = com.mbridge.msdk.foundation.same.report.c.a();
            if (this.f3840b == null) {
                this.f3840b = m.a("metrics_sdk", com.mbridge.msdk.foundation.controller.c.m().c(), d());
                if (this.f3840b != null) {
                    this.f3840b.a(jSONObjectA);
                    this.f3840b.a();
                }
            } else {
                this.f3840b.a(jSONObjectA);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return this.f3840b;
    }

    public final LinkedHashMap<String, c> b() {
        return this.f3842d;
    }

    public final void b(String str) {
        b(str, "");
    }

    public final void b(String str, String str2) {
        LinkedHashMap<String, c> linkedHashMap;
        try {
            String str3 = str + str2;
            if (!TextUtils.isEmpty(str3) && (linkedHashMap = this.f3842d) != null && linkedHashMap.containsKey(str3)) {
                this.f3842d.remove(str3);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final c b(c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            return (c) cVar.clone();
        } catch (CloneNotSupportedException e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public final e a(String str) {
        Map<String, e> map;
        e eVar = new e();
        try {
            if (!TextUtils.isEmpty(str) && (map = this.f3841c) != null && map.containsKey(str)) {
                return this.f3841c.get(str);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public final void a(String str, e eVar) {
        Map<String, e> map = this.e;
        if (map != null) {
            map.put(str, eVar);
        }
    }

    public final e a(int i10, int i11, String str, boolean z9, int i12) {
        e eVar = new e();
        try {
            eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(i10));
            eVar.a("adtp", Integer.valueOf(i11));
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            if (z9) {
                eVar.a("auto_load", Integer.valueOf(i12));
                return eVar;
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    public static d a() {
        if (f3839a == null) {
            synchronized (d.class) {
                try {
                    if (f3839a == null) {
                        f3839a = new d();
                    }
                } finally {
                }
            }
        }
        return f3839a;
    }

    public final void a(String str, CampaignEx campaignEx, e eVar) {
        c cVar;
        String localRequestId = "";
        if (campaignEx != null) {
            try {
                localRequestId = campaignEx.getLocalRequestId();
                cVar = this.f3842d.get(localRequestId);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            cVar = null;
        }
        if (cVar != null) {
            if (Arrays.asList(b.h).contains(str)) {
                cVar = b(cVar);
            }
        } else {
            cVar = new c();
        }
        cVar.a(campaignEx);
        cVar.c(localRequestId);
        cVar.a(str, eVar);
        b(str, cVar, null);
    }

    public final void a(String str, CampaignEx campaignEx) {
        String currentLocalRid = "";
        if (campaignEx != null) {
            try {
                currentLocalRid = campaignEx.getCurrentLocalRid();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        c cVar = this.f3842d.get(currentLocalRid);
        if (cVar == null) {
            cVar = new c();
        }
        if (cVar.h() != null && !cVar.h().isEmpty() && campaignEx != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= cVar.h().size()) {
                    break;
                }
                if (cVar.h().get(i10).getId().equals(campaignEx.getId())) {
                    cVar.h().set(i10, campaignEx);
                    break;
                }
                i10++;
            }
        }
        cVar.a(campaignEx);
        cVar.c(currentLocalRid);
        b(str, cVar, null);
    }

    public final void a(String str, List<CampaignEx> list, e eVar) {
        CampaignEx campaignEx;
        String currentLocalRid = "";
        if (list != null) {
            try {
                if (list.size() > 0 && (campaignEx = list.get(0)) != null) {
                    currentLocalRid = campaignEx.getCurrentLocalRid();
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        c cVar = this.f3842d.get(currentLocalRid);
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b(list);
        if (list != null && list.size() > 0) {
            cVar.c(list.get(0).getCurrentLocalRid());
        }
        cVar.a(str, eVar);
        b(str, cVar, null);
    }

    public final void a(String str, c cVar, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        b(str, cVar, aVar);
    }

    public final void a(n nVar, CampaignEx campaignEx) {
        e eVar = new e();
        eVar.a("result", Integer.valueOf(nVar.m()));
        eVar.a("scenes", nVar.b("scenes", ""));
        eVar.a("resource_type", Integer.valueOf(nVar.F()));
        eVar.a("url", nVar.b("url", ""));
        eVar.a("reason", nVar.h());
        eVar.a("mraid_type", Integer.valueOf(nVar.B()));
        a().a(nVar.a(), campaignEx, eVar);
    }

    public final void a(String str, c cVar) {
        try {
            Map<String, e> map = this.e;
            if (map != null && map.containsKey(str) && cVar != null) {
                cVar.a(str, this.e.get(str));
            }
            new f().a(str, c(), cVar, null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            try {
                if (this.f3841c != null) {
                    e eVar = new e();
                    eVar.a("rs_rid", cVar.k());
                    eVar.a("r_stid", cVar.m());
                    eVar.a("rus_rid", cVar.l());
                    eVar.a("u_stid", cVar.t());
                    this.f3841c.put(cVar.i(), eVar);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final c a(String str, String str2) {
        LinkedHashMap<String, c> linkedHashMap;
        try {
            String str3 = str + str2;
            if (!TextUtils.isEmpty(str3) && (linkedHashMap = this.f3842d) != null && linkedHashMap.containsKey(str3)) {
                return this.f3842d.get(str3);
            }
            return null;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() == 0) {
                    return;
                }
                String strOptString = jSONObject.optString("key");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(strOptString);
                eVar.b(0);
                eVar.a(0);
                eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
                eVar.a(jSONObject);
                m mVarC = a().c();
                if (mVarC == null || !mVarC.e()) {
                    return;
                }
                mVarC.a(eVar);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("reportByTrackManager error: "), "EventLibraryReport");
                }
            }
        }
    }
}
