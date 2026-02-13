package com.mbridge.msdk.newreward.function.f;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.out.MBConfiguration;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f4989a;

    public final Map<String, String> a() {
        if (f4989a == null) {
            com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e();
            eVar.a("platform", "1");
            eVar.a("os_version", Build.VERSION.RELEASE);
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            eVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, ab.f(contextC));
            eVar.a("app_version_name", ab.q(contextC));
            eVar.a("app_version_code", ab.r(contextC) + "");
            eVar.a("orientation", ab.s(contextC) + "");
            eVar.a("model", ab.h());
            eVar.a("brand", ab.x());
            eVar.a("gaid2", f.b());
            eVar.a("gaid", "");
            int iM = ab.m(contextC);
            eVar.a("network_type", iM + "");
            eVar.a("network_str", ab.a(contextC, iM));
            eVar.a("language", ab.t(contextC));
            eVar.a("timezone", ab.y());
            eVar.a("useragent", ab.g());
            eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            eVar.a("screen_size", ab.j(contextC) + "x" + ab.h(contextC));
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().k());
            eVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.a().b() + "");
            eVar.a("open", com.mbridge.msdk.foundation.same.a.S);
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
                eVar.a("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                eVar.a("re_domain", "1");
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strL = com.mbridge.msdk.foundation.controller.c.m().l();
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "sign", strL);
            eVar.a(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis + "");
            if (com.mbridge.msdk.e.b.a()) {
                eVar.a("st", SameMD5.getMD5(strL + jCurrentTimeMillis));
            } else {
                eVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + strL));
            }
            f4989a = eVar.a();
        }
        Map<String, String> map = f4989a;
        if (map != null) {
            String strA = Aa.a();
            map.put("channel", strA != null ? strA : "");
        }
        return f4989a;
    }
}
