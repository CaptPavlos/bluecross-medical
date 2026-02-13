package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f3982a;

    /* renamed from: b, reason: collision with root package name */
    public int f3983b;

    /* renamed from: c, reason: collision with root package name */
    public String f3984c;

    /* renamed from: d, reason: collision with root package name */
    public String f3985d;
    public String e;
    public String f;
    public String g;
    public String h;

    /* renamed from: j, reason: collision with root package name */
    public String f3987j;

    /* renamed from: k, reason: collision with root package name */
    public String f3988k;

    /* renamed from: m, reason: collision with root package name */
    public int f3990m;

    /* renamed from: n, reason: collision with root package name */
    public String f3991n;

    /* renamed from: o, reason: collision with root package name */
    public String f3992o;

    /* renamed from: p, reason: collision with root package name */
    public String f3993p;

    /* renamed from: r, reason: collision with root package name */
    public String f3995r;

    /* renamed from: s, reason: collision with root package name */
    public String f3996s;
    public String t;

    /* renamed from: v, reason: collision with root package name */
    public String f3998v;

    /* renamed from: q, reason: collision with root package name */
    public String f3994q = "android";

    /* renamed from: i, reason: collision with root package name */
    public String f3986i = ab.m();

    /* renamed from: u, reason: collision with root package name */
    public String f3997u = ab.w();

    /* renamed from: l, reason: collision with root package name */
    public String f3989l = f.c();

    public d(Context context) {
        int iM = ab.m(context);
        this.f3991n = String.valueOf(iM);
        this.f3992o = ab.a(context, iM);
        this.f3987j = ab.g(context);
        this.e = com.mbridge.msdk.foundation.controller.c.m().b();
        this.f3985d = com.mbridge.msdk.foundation.controller.c.m().k();
        this.t = String.valueOf(ak.f(context));
        this.f3996s = String.valueOf(ak.e(context));
        this.f3995r = String.valueOf(ak.d(context));
        this.f3998v = com.mbridge.msdk.foundation.controller.c.m().i().toString();
        this.g = ab.x();
        this.f3990m = ak.a();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f3993p = "landscape";
        } else {
            this.f3993p = "portrait";
        }
        this.f = com.mbridge.msdk.foundation.same.a.V;
        this.h = com.mbridge.msdk.foundation.same.a.g;
        this.f3988k = ab.n();
        this.f3984c = f.d();
        this.f3982a = f.a();
        this.f3983b = com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? 1 : 0;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f3986i);
                jSONObject.put("system_version", this.f3997u);
                jSONObject.put("network_type", this.f3991n);
                jSONObject.put("network_type_str", this.f3992o);
                jSONObject.put("device_ua", this.f3987j);
                jSONObject.put("has_wx", ab.v(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("integrated_wx", ab.z());
                jSONObject.put("opensdk_ver", ab.u() + "");
                jSONObject.put("wx_api_ver", ab.c(com.mbridge.msdk.foundation.controller.c.m().h()) + "");
                jSONObject.put("brand", this.g);
                jSONObject.put("mnc", ab.l(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("mcc", ab.k(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("adid_limit", this.f3982a);
                jSONObject.put("adid_limit_dev", this.f3983b);
            }
            jSONObject.put("plantform", this.f3994q);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f3989l);
                jSONObject.put("az_aid_info", this.f3984c);
            }
            jSONObject.put("appkey", this.e);
            jSONObject.put("appId", this.f3985d);
            jSONObject.put("screen_width", this.t);
            jSONObject.put("screen_height", this.f3996s);
            jSONObject.put("orientation", this.f3993p);
            jSONObject.put("scale", this.f3995r);
            jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, this.f);
            jSONObject.put("c", this.h);
            jSONObject.put("web_env", this.f3998v);
            jSONObject.put("f", this.f3988k);
            jSONObject.put("misk_spt", this.f3990m);
            if (ab.q() != 0) {
                jSONObject.put("tun", ab.q());
            }
            jSONObject.put(com.mbridge.msdk.foundation.same.net.f.e.f3758c, com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().f() + "");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("adid_limit", this.f3982a);
                jSONObject2.put("adid_limit_dev", this.f3983b);
                jSONObject.put("dvi", z.b(jSONObject2.toString()));
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
