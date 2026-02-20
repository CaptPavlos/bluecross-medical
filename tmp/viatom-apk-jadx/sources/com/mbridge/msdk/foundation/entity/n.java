package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.tools.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static int f3580a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f3581b;
    private String A;
    private String B;
    private String C;
    private String D;
    private int E;
    private String F;
    private String G;
    private String I;
    private String J;
    private String K;
    private int L;
    private long M;
    private String N;
    private int O;

    /* renamed from: d, reason: collision with root package name */
    private String f3583d;
    private int e;
    private int g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private String f3584i;

    /* renamed from: j, reason: collision with root package name */
    private String f3585j;

    /* renamed from: k, reason: collision with root package name */
    private String f3586k;

    /* renamed from: l, reason: collision with root package name */
    private String f3587l;

    /* renamed from: m, reason: collision with root package name */
    private String f3588m;

    /* renamed from: n, reason: collision with root package name */
    private String f3589n;

    /* renamed from: o, reason: collision with root package name */
    private String f3590o;

    /* renamed from: p, reason: collision with root package name */
    private String f3591p;

    /* renamed from: q, reason: collision with root package name */
    private String f3592q;

    /* renamed from: r, reason: collision with root package name */
    private int f3593r;

    /* renamed from: s, reason: collision with root package name */
    private String f3594s;
    private String t;

    /* renamed from: u, reason: collision with root package name */
    private String f3595u;

    /* renamed from: w, reason: collision with root package name */
    private int f3597w;

    /* renamed from: x, reason: collision with root package name */
    private String f3598x;
    private String y;

    /* renamed from: z, reason: collision with root package name */
    private String f3599z;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f3582c = null;
    private int f = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f3596v = 0;
    private int H = 0;

    public n(Context context, CampaignEx campaignEx, int i10, String str, long j10, int i11) {
        if (i11 == 1 || i11 == 287 || i11 == 94) {
            this.f3594s = "m_download_end";
        } else if (i11 == 95) {
            this.f3594s = "2000025";
        }
        int iM = ab.m(context);
        this.f3597w = iM;
        this.f3598x = ab.a(context, iM);
        this.L = campaignEx.getVideoLength();
        this.A = campaignEx.getRequestId();
        this.B = campaignEx.getRequestIdNotice();
        if (!TextUtils.isEmpty(this.y)) {
            try {
                this.y = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.E = i10;
        this.f3586k = str;
        this.M = j10 == 0 ? campaignEx.getVideoSize() : j10;
    }

    public final int A() {
        return this.O;
    }

    public final int B() {
        return this.f3596v;
    }

    public final int C() {
        return this.g;
    }

    public final String D() {
        return this.I;
    }

    public final String E() {
        return this.f3589n;
    }

    public final int F() {
        return this.H;
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f3582c == null) {
            this.f3582c = new HashMap();
        }
        try {
            this.f3582c.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public final String b(String str, String str2) {
        Map<String, String> map;
        if (!TextUtils.isEmpty(str) && (map = this.f3582c) != null) {
            try {
                String str3 = map.get(str);
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
            } catch (Exception unused) {
            }
        }
        return str2;
    }

    public final String c() {
        return this.K;
    }

    public final String d() {
        return this.f3583d;
    }

    public final String e() {
        return this.h;
    }

    public final String f() {
        return this.A;
    }

    public final String g() {
        return this.B;
    }

    public final String h() {
        return TextUtils.isEmpty(this.f3599z) ? "" : this.f3599z;
    }

    public final void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3584i = URLEncoder.encode(str);
    }

    public final String j() {
        return this.f3585j;
    }

    public final int k() {
        return this.f3597w;
    }

    public final String l() {
        return this.f3598x;
    }

    public final void m(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.N = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f3588m = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final long o() {
        return this.M;
    }

    public final void p(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f3592q = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void q(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.I = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public final String r() {
        return this.y;
    }

    public final String s() {
        return this.f3588m;
    }

    public final String t() {
        return this.f3587l;
    }

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("RewardReportData [key=");
        sb.append(this.f3594s);
        sb.append(", networkType=");
        sb.append(this.f3597w);
        sb.append(", isCompleteView=");
        sb.append(this.f3593r);
        sb.append(", watchedMillis=");
        sb.append(this.O);
        sb.append(", videoLength=");
        sb.append(this.L);
        sb.append(", offerUrl=");
        sb.append(this.y);
        sb.append(", reason=");
        sb.append(this.f3599z);
        sb.append(", result=");
        sb.append(this.E);
        sb.append(", duration=");
        sb.append(this.f3586k);
        sb.append(", videoSize=");
        return a3.a.l(sb, this.M, "]");
    }

    public final int u() {
        return this.e;
    }

    public final String v() {
        return this.f3590o;
    }

    public final String w() {
        return this.J;
    }

    public final String x() {
        return this.t;
    }

    public final String y() {
        return this.f3592q;
    }

    public final int z() {
        return this.f3593r;
    }

    public final void c(String str) {
        this.K = str;
    }

    public final void d(String str) {
        this.f3583d = str;
    }

    public final void e(String str) {
        this.h = str;
    }

    public final void f(String str) {
        this.A = str;
    }

    public final void g(String str) {
        this.B = str;
    }

    public final void j(String str) {
        this.f3585j = str;
    }

    public final void k(String str) {
        this.f3598x = str;
    }

    public final void l(String str) {
        this.f3586k = str;
    }

    public final void o(String str) {
        this.f3587l = str;
    }

    public final void r(String str) {
        this.f3589n = str;
    }

    public final void s(String str) {
        this.f3595u = str;
    }

    public final void t(String str) {
        this.D = str;
    }

    public final void u(String str) {
        this.F = str;
    }

    public final void v(String str) {
        this.G = str;
    }

    public final void c(int i10) {
        this.e = i10;
    }

    public final void d(int i10) {
        this.f3596v = i10;
    }

    public final void e(int i10) {
        this.H = i10;
    }

    public final String i() {
        return this.f3584i;
    }

    public final void h(String str) {
        this.f3599z = str;
    }

    public final int m() {
        return this.E;
    }

    public final String n() {
        return this.f3586k;
    }

    public final int p() {
        return this.L;
    }

    public final String q() {
        return this.N;
    }

    public final void b(String str) {
        this.C = str;
    }

    public final void b(int i10) {
        this.E = i10;
    }

    public final String b() {
        return this.C;
    }

    public final void a(String str) {
        this.f3594s = str;
    }

    public final void a(int i10) {
        this.f3597w = i10;
    }

    public final String a() {
        return this.f3594s;
    }

    public n() {
    }

    public n(String str, int i10, String str2, String str3, String str4) {
        this.f3594s = str;
        this.f3598x = str4;
        this.f3597w = i10;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.y = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.f3599z = str3;
    }

    public n(String str, int i10, int i11, String str2, int i12, String str3, int i13, String str4) {
        this.f3594s = str;
        this.f3597w = i10;
        this.f3598x = str4;
        this.L = i11;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.y = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.E = i12;
        this.f3586k = str3;
        this.M = i13;
    }

    public n(String str, int i10, int i11, int i12, int i13, String str2, String str3, int i14, String str4, int i15, String str5) {
        this.f3594s = str;
        this.f3597w = i10;
        this.f3598x = str5;
        this.f3593r = i11;
        this.O = i12;
        this.L = i13;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.y = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.f3599z = str3;
        this.E = i14;
        this.f3586k = str4;
        this.M = i15;
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, int i10, String str7) {
        this.f3594s = str;
        this.f3590o = str2;
        this.J = str3;
        this.t = str4;
        this.K = str5;
        this.h = str6;
        this.f3597w = i10;
        this.f3598x = str7;
    }

    public n(String str) {
        this.f3591p = str;
    }

    public n(String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f3594s = str;
        this.E = i10;
        this.f3586k = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.f3588m = URLEncoder.encode(str3, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.h = str4;
        this.K = str5;
        this.f3599z = str6;
        this.f3587l = str7;
        if (Integer.valueOf(str2).intValue() > com.mbridge.msdk.foundation.same.a.L) {
            this.E = 2;
        }
    }

    public n(String str, String str2, String str3, String str4, String str5, int i10) {
        this.f3594s = str;
        this.h = str2;
        this.A = str3;
        this.B = str4;
        this.K = str5;
        this.f3597w = i10;
    }

    public n(String str, String str2, String str3, String str4, String str5, int i10, int i11, String str6) {
        this.f3594s = str;
        this.h = str2;
        this.A = str3;
        this.B = str4;
        this.K = str5;
        this.f3597w = i10;
        this.f3599z = str6;
        this.g = i11;
    }
}
