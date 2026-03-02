package com.mbridge.msdk.foundation.same.net.e;

import android.net.Uri;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.tracker.o;
import com.mbridge.msdk.tracker.t;
import com.mbridge.msdk.tracker.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    private final String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a, reason: collision with root package name */
    public String f3734a;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private boolean ae;
    private int af;

    /* renamed from: b, reason: collision with root package name */
    public String f3735b;

    /* renamed from: c, reason: collision with root package name */
    public String f3736c;

    /* renamed from: d, reason: collision with root package name */
    public String f3737d;
    public String e;
    public String f;
    public String g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public String f3738i;

    /* renamed from: j, reason: collision with root package name */
    public String f3739j;

    /* renamed from: k, reason: collision with root package name */
    public String f3740k;

    /* renamed from: l, reason: collision with root package name */
    public String f3741l;

    /* renamed from: m, reason: collision with root package name */
    public int f3742m;

    /* renamed from: n, reason: collision with root package name */
    public int f3743n;

    /* renamed from: o, reason: collision with root package name */
    public int f3744o;

    /* renamed from: p, reason: collision with root package name */
    public int f3745p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3746q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3747r;

    /* renamed from: s, reason: collision with root package name */
    public int f3748s;
    public ArrayList<String> t;

    /* renamed from: u, reason: collision with root package name */
    public int f3749u;

    /* renamed from: v, reason: collision with root package name */
    public int f3750v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList<String> f3751w;

    /* renamed from: x, reason: collision with root package name */
    public String f3752x;
    public String y;

    /* renamed from: z, reason: collision with root package name */
    public String f3753z;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f3754a = new d();
    }

    private d() {
        this.P = "RequestUrlUtil";
        this.f3734a = DomainNameUtils.getInstance().DEFAULT_HOST_APPLETS;
        this.f3735b = DomainNameUtils.getInstance().DEFAULT_CDN_SPARE_SETTING_URL;
        this.f3736c = DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS;
        this.f3737d = DomainNameUtils.getInstance().DEFAULT_HOST_API;
        this.e = DomainNameUtils.getInstance().DEFAULT_HOST_MONITOR_DEFAULT;
        this.f = DomainNameUtils.getInstance().DEFAULT_HOST_PRIVACY;
        this.g = DomainNameUtils.getInstance().DEFAULT_HOST_REVENUE_DEFAULT;
        this.h = DomainNameUtils.getInstance().DEFAULT_HOST_SETTING;
        this.f3738i = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_ANALYTICS;
        this.f3739j = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_MONITOR;
        this.f3740k = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_REVENUE;
        this.f3741l = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_SETTING;
        this.f3742m = 9377;
        this.f3743n = 9377;
        this.f3744o = 9988;
        this.f3745p = 9377;
        this.f3746q = false;
        this.f3747r = false;
        this.f3748s = 1;
        this.t = DomainNameUtils.getInstance().SPARE_SETTING_HOST;
        this.f3749u = 0;
        this.f3750v = 0;
        this.f3751w = DomainNameUtils.getInstance().SPARE_TCP_SETTING_HOST;
        this.Q = DomainNameUtils.getInstance().DEFAULT_HB_HOST;
        this.R = "/bid";
        this.f3752x = this.Q + this.R;
        this.S = "/sdk/customid";
        this.y = this.h + this.S;
        this.f3753z = this.f3741l + this.S;
        this.T = "/image";
        this.A = this.f3737d + this.T;
        this.U = "/load";
        this.B = this.Q + this.U;
        this.V = "/mapping";
        this.C = this.h + this.V;
        this.D = this.f3741l + this.V;
        this.W = "";
        this.E = this.g + this.W;
        this.X = "/batchPaidEvent";
        this.F = this.g + this.X;
        this.Y = "/setting";
        this.G = this.h + this.Y;
        this.H = this.f3741l + this.Y;
        this.Z = "/rewardsetting";
        this.I = this.h + this.Z;
        this.J = this.f3741l + this.Z;
        this.aa = "/appwall/setting";
        this.K = this.h + this.aa;
        this.L = this.f3741l + this.aa;
        this.ab = "/openapi/ad/v3";
        this.M = this.f3737d + this.ab;
        this.ac = "/openapi/ad/v4";
        this.N = this.f3737d + this.ac;
        this.ad = "/openapi/ad/v5";
        this.O = this.f3737d + this.ad;
        this.ae = true;
        this.af = 0;
    }

    public static d f() {
        return a.f3754a;
    }

    public final boolean a() {
        try {
            if (this.f3747r) {
                ArrayList<String> arrayList = this.f3751w;
                if (arrayList != null && this.f3750v <= arrayList.size() - 1) {
                    if (!b(this.f3751w.get(this.f3750v))) {
                        this.f3741l = this.f3751w.get(this.f3750v);
                        c();
                    }
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.t;
                if (arrayList2 != null && this.f3749u <= arrayList2.size() - 1) {
                    this.h = this.t.get(this.f3749u);
                    b();
                    return true;
                }
            }
            if (this.f3746q) {
                this.f3749u = 0;
                this.f3750v = 0;
            }
            return false;
        } catch (Throwable th) {
            af.a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    public final void b() {
        this.G = this.h + this.Y;
        this.y = this.h + this.S;
        this.I = this.h + this.Z;
        this.C = this.h + this.V;
        this.K = this.h + this.aa;
    }

    public final void c() {
        this.H = this.f3741l + this.Y;
        this.f3753z = this.f3741l + this.S;
        this.J = this.f3741l + this.Z;
        this.D = this.f3741l + this.V;
        this.L = this.f3741l + this.aa;
    }

    public final int d() {
        return this.af;
    }

    public final void e() {
        HashMap<String, String> mapJ;
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        if (gVarS != null) {
            com.mbridge.msdk.c.a aVarQ = gVarS.q();
            if (aVarQ != null) {
                this.f3740k = aVarQ.f();
                this.f3744o = aVarQ.g();
                this.g = aVarQ.e();
                this.F = this.g + this.X;
            }
            com.mbridge.msdk.c.d dVarF = gVarS.F();
            if (dVarF != null) {
                this.f3739j = dVarF.d();
                this.f3743n = dVarF.e();
                this.e = dVarF.c();
                this.E = this.e + this.W;
                com.mbridge.msdk.c.d dVarF2 = gVarS.F();
                if (dVarF2 != null && dVarF2.a() != 1) {
                    int iA = ah.a().a("monitor", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, ah.a().a("t_r_t", 1));
                    if (iA != 0 && iA != 1) {
                        iA = 0;
                    }
                    t.a().a(com.mbridge.msdk.foundation.controller.c.m().c(), new w.a().a(new com.mbridge.msdk.foundation.same.report.d()).a(new m()).a(iA, iA == 1 ? new o(new l((byte) 2), a.f3754a.f3739j, a.f3754a.f3743n) : new o(new com.mbridge.msdk.tracker.network.toolbox.h(), a.f3754a.E, 0)).e(ah.a().a("t_m_e_t", 604800000)).a(ah.a().a("t_m_e_s", 50)).d(ah.a().a("t_m_r_c", 50)).b(ah.a().a("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(ah.a().a("t_m_r_t_s", 1)).a(), dVarF2.b() * 1000, com.mbridge.msdk.foundation.same.report.c.a());
                }
            }
            this.f3747r = gVarS.aq() == 2;
            this.f3748s = gVarS.aq();
            this.ae = !gVarS.z(2);
            if (gVarS.J() != null && gVarS.J().size() > 0 && (mapJ = gVarS.J()) != null && mapJ.size() > 0) {
                if (mapJ.containsKey("v") && !TextUtils.isEmpty(mapJ.get("v")) && b(mapJ.get("v"))) {
                    this.f3737d = mapJ.get("v");
                    this.M = this.f3737d + this.ab;
                    this.N = this.f3737d + this.ac;
                    this.O = this.f3737d + this.ad;
                    this.A = this.f3737d + this.T;
                }
                if (mapJ.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(mapJ.get(CampaignEx.JSON_KEY_HB)) && b(mapJ.get(CampaignEx.JSON_KEY_HB))) {
                    this.Q = mapJ.get(CampaignEx.JSON_KEY_HB);
                    this.f3752x = this.Q + this.R;
                    this.B = this.Q + this.U;
                }
                if (mapJ.containsKey("lg") && !TextUtils.isEmpty(mapJ.get("lg"))) {
                    String str = mapJ.get("lg");
                    if (b(str)) {
                        this.f3736c = str;
                    } else {
                        this.f3738i = str;
                    }
                }
                if (mapJ.containsKey("lgt") && !TextUtils.isEmpty(mapJ.get("lgt"))) {
                    String str2 = mapJ.get("lgt");
                    if (b(str2)) {
                        String strC = c(str2);
                        if (!TextUtils.isEmpty(strC)) {
                            this.f3738i = strC;
                        }
                    } else {
                        this.f3738i = str2;
                    }
                }
            }
            String strB = gVarS.B();
            if (!TextUtils.isEmpty(strB)) {
                this.h = strB;
                b();
                this.t.add(0, strB);
            }
            String strC2 = gVarS.C();
            if (TextUtils.isEmpty(strC2)) {
                return;
            }
            this.f3741l = strC2;
            c();
            this.f3751w.add(0, strC2);
        }
    }

    public final String a(String str, int i10) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split("_");
                if (strArrSplit.length > 1) {
                    return a(true, strArrSplit[1]);
                }
                return a(true, "");
            }
        } catch (Exception e) {
            af.b("RequestUrlUtil", e.getMessage());
        }
        return i10 % 2 == 0 ? this.O : this.M;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable th) {
            af.b("RequestUrlUtil", th.getMessage());
            return "";
        }
    }

    public final String a(boolean z9, String str) {
        if (!z9) {
            return this.f3752x.replace("{}", "");
        }
        if (!this.B.contains("{}") || TextUtils.isEmpty(str)) {
            return this.B.replace("{}", "");
        }
        return this.B.replace("{}", str + "-");
    }

    public final void a(int i10) {
        this.af = i10;
    }

    public final String a(String str) {
        return a.f3754a.a(str, 1);
    }
}
