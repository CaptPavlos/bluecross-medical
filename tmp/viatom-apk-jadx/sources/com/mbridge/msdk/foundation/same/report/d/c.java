package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements Serializable, Cloneable {
    private int A;
    private CampaignEx B;
    private CopyOnWriteArrayList<CampaignEx> C;

    /* renamed from: a, reason: collision with root package name */
    private boolean f3819a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Map<String, String>> f3820b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Map<String, String>> f3821c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Long> f3822d;
    private com.mbridge.msdk.foundation.c.b e;
    private String f;
    private CopyOnWriteArrayList<CampaignEx> g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private int f3823i;

    /* renamed from: j, reason: collision with root package name */
    private String f3824j;

    /* renamed from: k, reason: collision with root package name */
    private String f3825k;

    /* renamed from: l, reason: collision with root package name */
    private String f3826l;

    /* renamed from: m, reason: collision with root package name */
    private String f3827m;

    /* renamed from: n, reason: collision with root package name */
    private String f3828n;

    /* renamed from: o, reason: collision with root package name */
    private String f3829o;

    /* renamed from: p, reason: collision with root package name */
    private String f3830p;

    /* renamed from: q, reason: collision with root package name */
    private String f3831q;

    /* renamed from: r, reason: collision with root package name */
    private int f3832r;

    /* renamed from: s, reason: collision with root package name */
    private int f3833s;
    private boolean t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3834u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f3835v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3836w;

    /* renamed from: x, reason: collision with root package name */
    private int f3837x;
    private int y;

    /* renamed from: z, reason: collision with root package name */
    private int f3838z;

    public c(boolean z9) {
        this.f3819a = false;
        this.f3820b = new HashMap();
        this.f3821c = new HashMap();
        this.f3822d = new HashMap();
        this.f = "";
        this.g = new CopyOnWriteArrayList<>();
        this.f3832r = -1;
        this.t = false;
        this.f3835v = false;
        this.C = new CopyOnWriteArrayList<>();
        this.f3819a = z9;
    }

    public final void a(CampaignEx campaignEx) {
        this.B = campaignEx;
        if (campaignEx == null) {
            return;
        }
        try {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.C;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                int i10 = 0;
                while (true) {
                    if (i10 >= this.C.size()) {
                        break;
                    }
                    if (this.C.get(i10) != null && this.C.get(i10).getId().equals(campaignEx.getId())) {
                        this.C.set(i10, campaignEx);
                        break;
                    }
                    i10++;
                }
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.g;
            if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.isEmpty()) {
                return;
            }
            for (int i11 = 0; i11 < this.g.size(); i11++) {
                if (this.g.get(i11) != null && this.g.get(i11).getId().equals(campaignEx.getId())) {
                    this.g.set(i11, campaignEx);
                    return;
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    if (!this.C.isEmpty()) {
                        this.C.clear();
                    }
                    this.C.addAll(list);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final String c() {
        return this.f3831q;
    }

    @NonNull
    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final String d() {
        return this.f3830p;
    }

    public final List<CampaignEx> e() {
        return this.g;
    }

    public final String f() {
        return this.f;
    }

    public final CampaignEx g() {
        return this.B;
    }

    public final List<CampaignEx> h() {
        return this.C;
    }

    public final String i() {
        Map<String, String> map;
        boolean zIsEmpty = TextUtils.isEmpty(this.h);
        String str = this.h;
        if (!zIsEmpty) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                String str2 = this.f + this.f3831q;
                Map<String, Map<String, String>> map2 = this.f3820b;
                if (map2 != null && map2.containsKey(str2) && (map = this.f3820b.get(str2)) != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    this.h = map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return this.h;
    }

    public final Map<String, String> j(String str) {
        com.mbridge.msdk.foundation.c.b bVar;
        com.mbridge.msdk.foundation.c.b bVar2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        try {
            this.f3831q = str;
            eVar.a(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(i())) {
                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, i());
            }
            int i10 = this.f3823i;
            if (i10 != 0) {
                eVar.a("adtp", Integer.valueOf(i10));
            }
            if (!TextUtils.isEmpty(this.f3829o)) {
                eVar.a(CampaignEx.JSON_KEY_HB, this.f3829o);
            }
            if (!TextUtils.isEmpty(this.f3824j)) {
                eVar.a("bid_tk", this.f3824j);
            }
            if (!TextUtils.isEmpty(str)) {
                eVar.a("key", str);
            }
            if (Arrays.asList(b.f3811a).contains(str)) {
                eVar.a("from_cache", this.t ? "1" : "2");
            }
            if ("2000047".contains(str) && (bVar2 = this.e) != null) {
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(bVar2.e()));
                eVar.a("reason", bVar2.b());
                if (!TextUtils.isEmpty(bVar2.h())) {
                    eVar.a("reason_d", bVar2.h());
                    eVar.a("type_d", Integer.valueOf(bVar2.g()));
                }
            }
            if ("2000048".contains(str) && (bVar = this.e) != null && !TextUtils.isEmpty(bVar.h())) {
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(bVar.g()));
                eVar.a("reason", bVar.h());
            }
            if (this.f3823i == 296) {
                eVar.a("auto_load", this.f3830p);
                eVar.a("auto_refresh", Integer.valueOf(this.f3837x));
                eVar.a("auto_refresh_interval", Integer.valueOf(this.y));
                eVar.a("content_type", Integer.valueOf(this.f3838z));
                eVar.a("temp_display_type", Integer.valueOf(this.A));
            }
            if ("2000126".equals(this.f3831q)) {
                String str2 = this.f3824j;
                g gVarA = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                String strA = com.mbridge.msdk.foundation.same.net.e.d.f().a(str2, TextUtils.isEmpty(str2) ? gVarA.as() : gVarA.I());
                String strA2 = TextUtils.isEmpty(strA) ? "" : aq.a(strA);
                eVar.a("dns_ty", Integer.valueOf(com.mbridge.msdk.c.e.a().a(strA2)));
                eVar.a("dns_hs", strA2);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar.a();
    }

    public final void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String str2 = this.f + str;
            Map<String, Map<String, String>> map = this.f3820b;
            if (map == null || !map.containsKey(str2)) {
                return;
            }
            this.f3820b.remove(str2);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final long l(String str) {
        Map<String, Long> map;
        try {
            if (!TextUtils.isEmpty(str) && (map = this.f3822d) != null && map.containsKey(str)) {
                Long l10 = this.f3822d.get(str);
                return System.currentTimeMillis() - (l10 != null ? l10.longValue() : 0L);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public final void m(String str) {
        if (this.f3822d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f3822d.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public final int n() {
        return this.f3833s;
    }

    public final com.mbridge.msdk.foundation.c.b o() {
        return this.e;
    }

    public final Map<String, Map<String, String>> p() {
        return this.f3820b;
    }

    public final Map<String, Map<String, String>> q() {
        return this.f3821c;
    }

    public final boolean r() {
        return this.f3834u;
    }

    public final boolean s() {
        return this.f3835v;
    }

    public final String t() {
        return this.f3827m;
    }

    public final void c(String str) {
        this.f = str;
    }

    public final void d(String str) {
        this.h = str;
    }

    public final void e(String str) {
        this.f3824j = str;
    }

    public final void f(String str) {
        this.f3825k = str;
    }

    public final void g(String str) {
        this.f3826l = str;
    }

    public final void h(String str) {
        this.f3828n = str;
    }

    public final void n(String str) {
        this.f3827m = str;
    }

    public final void c(int i10) {
        this.f3833s = i10;
    }

    public final void d(boolean z9) {
        this.f3836w = z9;
    }

    public final void e(int i10) {
        this.y = i10;
    }

    public final void f(int i10) {
        this.f3838z = i10;
    }

    public final void g(int i10) {
        this.A = i10;
    }

    public final void c(boolean z9) {
        this.f3835v = z9;
    }

    public final void d(int i10) {
        this.f3837x = i10;
    }

    public final String m() {
        return this.f3828n;
    }

    public final void b(String str) {
        this.f3830p = str;
    }

    public final int b() {
        return this.f3832r;
    }

    public final void b(int i10) {
        this.f3823i = i10;
    }

    public final void b(boolean z9) {
        this.f3834u = z9;
    }

    public final String k() {
        return this.f3825k;
    }

    public final String l() {
        return this.f3826l;
    }

    public c() {
        this.f3819a = false;
        this.f3820b = new HashMap();
        this.f3821c = new HashMap();
        this.f3822d = new HashMap();
        this.f = "";
        this.g = new CopyOnWriteArrayList<>();
        this.f3832r = -1;
        this.t = false;
        this.f3835v = false;
        this.C = new CopyOnWriteArrayList<>();
    }

    public final void i(String str) {
        this.f3829o = str;
    }

    public final void a(boolean z9) {
        this.t = z9;
    }

    public final void a(int i10) {
        this.f3832r = i10;
    }

    public final void a(String str) {
        this.f3831q = str;
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                if (!this.g.isEmpty()) {
                    this.g.clear();
                }
                this.g.addAll(list);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final boolean a() {
        return this.f3819a;
    }

    public final void a(String str, e eVar) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        try {
            String str2 = this.f + str;
            Map<String, Map<String, String>> map2 = this.f3820b;
            if (map2 != null) {
                if (map2.containsKey(str2) && (map = this.f3820b.get(str2)) != null) {
                    map.putAll(eVar.a());
                } else {
                    this.f3820b.put(str2, eVar.a());
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, e eVar, int i10) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        try {
            String str2 = this.f + "_" + i10 + "_" + str;
            Map<String, Map<String, String>> map2 = this.f3821c;
            if (map2 != null) {
                if (map2.containsKey(str2) && (map = this.f3821c.get(str2)) != null) {
                    map.putAll(eVar.a());
                } else {
                    this.f3821c.put(str2, eVar.a());
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(com.mbridge.msdk.foundation.c.b bVar) {
        this.e = bVar;
    }

    public final int j() {
        return this.f3823i;
    }
}
