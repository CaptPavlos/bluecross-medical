package com.mbridge.msdk.foundation.same.net.f;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {
    public static void a(e eVar, Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            eVar.a("withGP", ab.v() + "");
            eVar.a("has_wx", ab.v(context) + "");
            eVar.a("integrated_wx", ab.z() + "");
            eVar.a("opensdk_ver", ab.u() + "");
            eVar.a("wx_api_ver", ab.c(com.mbridge.msdk.foundation.controller.c.m().h()) + "");
            eVar.a("mnc", ab.l(com.mbridge.msdk.foundation.controller.c.m().c()));
            eVar.a("mcc", ab.k(com.mbridge.msdk.foundation.controller.c.m().c()));
            String strI = ab.i();
            if (!TextUtils.isEmpty(strI)) {
                eVar.a("hardware", strI);
            }
            com.mbridge.msdk.foundation.controller.authoritycontroller.c.j();
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DNT, 0) == 1) {
                eVar.a("dnt", "1");
            }
            eVar.a(e.f3758c, com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().f() + "");
            eVar.a("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
            eVar.a("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? "1" : "0");
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
            eVar.a(e.f3756a, ai.b() + "");
            eVar.a(e.f3757b, ai.a() + "");
            eVar.a(e.g, ab.n());
        }
        eVar.a("pkg_source", ab.a(ab.f(context), context));
        if (com.mbridge.msdk.foundation.controller.c.m().i() != null) {
            eVar.a("web_env", com.mbridge.msdk.foundation.controller.c.m().i().toString());
        }
        eVar.a("http_req", "2");
        g.a(eVar, context);
        a(eVar, true);
        g(eVar);
        b(eVar);
        com.mbridge.msdk.c.g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(com.mbridge.msdk.c.h.a());
        if (gVarS == null) {
            com.mbridge.msdk.c.h.a();
            gVarS = com.mbridge.msdk.c.i.a();
        }
        if (gVarS.K() == 1) {
            eVar.a("gdpr_consent", com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().g() + "");
        } else if (gVarS.aH()) {
            eVar.a("gdpr_consent", com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().g() + "");
        }
        String strI2 = com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().i();
        if (!TextUtils.isEmpty(strI2)) {
            eVar.a("tc_string", strI2);
        }
        h(eVar);
        i(eVar);
        g.a(eVar);
    }

    public static void b(e eVar) {
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                eVar.a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                com.mbridge.msdk.foundation.same.a.g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                return;
            }
            eVar.a("c", com.mbridge.msdk.foundation.same.a.g);
        } catch (Exception e) {
            af.b("CommonRequestParamsForAdd", e.getMessage());
        }
    }

    public static void c(e eVar) {
        eVar.a("dyview_type", com.mbridge.msdk.foundation.same.a.f3618w);
    }

    public static void d(e eVar) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            eVar.a("withGP", ab.v() + "");
            eVar.a("has_wx", ab.v(com.mbridge.msdk.foundation.controller.c.m().c()) + "");
            eVar.a("integrated_wx", ab.z() + "");
            eVar.a("opensdk_ver", ab.u() + "");
            eVar.a("wx_api_ver", ab.c(com.mbridge.msdk.foundation.controller.c.m().h()) + "");
            eVar.a("mnc", ab.l(com.mbridge.msdk.foundation.controller.c.m().c()));
            eVar.a("mcc", ab.k(com.mbridge.msdk.foundation.controller.c.m().c()));
            String strI = ab.i();
            if (!TextUtils.isEmpty(strI)) {
                eVar.a("hardware", strI);
            }
            eVar.a("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
            eVar.a("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? "1" : "0");
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
            eVar.a(e.g, ab.n());
        }
        g.b(eVar);
        a(eVar, false);
        g(eVar);
        b(eVar);
        h(eVar);
        i(eVar);
    }

    public static void e(e eVar) {
        if (ab.q() == 0) {
            return;
        }
        eVar.a("tun", ab.q() + "");
    }

    public static void f(e eVar) {
        if (eVar != null) {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                eVar.a("model");
                eVar.a("brand");
                eVar.a("screen_size");
                eVar.a("sub_ip");
                eVar.a("network_type");
                eVar.a("useragent");
                eVar.a("ua");
                eVar.a("language");
                eVar.a("network_str");
                eVar.a("os_version");
                eVar.a("country_code");
                eVar.a("cronet_env");
                eVar.a("adid_limit");
                eVar.a("adid_limit_dev");
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                eVar.a(e.f3756a);
                eVar.a(e.f3757b);
                eVar.a("power_rate");
                eVar.a("charging");
                eVar.a("timezone");
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                eVar.a("gaid");
                eVar.a("gaid2");
                eVar.a("az_aid_info");
            }
            g.c(eVar);
        }
    }

    private static void g(e eVar) {
        int iT = ab.t();
        if (iT != -1) {
            eVar.a("unknown_source", iT + "");
        }
    }

    private static void h(e eVar) {
        String strE = com.mbridge.msdk.foundation.tools.f.e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        eVar.a("az_aid_info", strE);
    }

    private static void i(e eVar) {
        String str = com.mbridge.msdk.e.c.f3308a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        eVar.a("cronet_env", str);
    }

    public static void a(e eVar) {
        eVar.a("api_version", com.mbridge.msdk.foundation.same.a.f3604d);
    }

    private static void a(e eVar, boolean z9) {
        com.mbridge.msdk.c.g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(com.mbridge.msdk.c.h.a());
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (gVarS != null) {
            if (!TextUtils.isEmpty(gVarS.d()) && z9) {
                eVar.a("a_stid", gVarS.d());
            }
            try {
                g.a(eVar, contextC, z9, gVarS);
            } catch (Exception e) {
                af.b("CommonRequestParamsForAdd", e.getMessage());
            }
        }
    }
}
