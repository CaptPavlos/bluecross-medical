package com.mbridge.msdk.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c {
    private String A;
    private int D;
    private int E;
    private int I;
    private String K;
    private int N;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f2689b;

    /* renamed from: c, reason: collision with root package name */
    private List<Integer> f2690c;

    /* renamed from: d, reason: collision with root package name */
    private int f2691d;
    private int e;
    private int f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private int f2692i;

    /* renamed from: k, reason: collision with root package name */
    private long f2694k;

    /* renamed from: l, reason: collision with root package name */
    private long f2695l;

    /* renamed from: m, reason: collision with root package name */
    private int f2696m;

    /* renamed from: n, reason: collision with root package name */
    private int f2697n;

    /* renamed from: o, reason: collision with root package name */
    private int f2698o;

    /* renamed from: p, reason: collision with root package name */
    private long f2699p;

    /* renamed from: q, reason: collision with root package name */
    private long f2700q;

    /* renamed from: r, reason: collision with root package name */
    private int f2701r;

    /* renamed from: s, reason: collision with root package name */
    private String f2702s;
    private int t;

    /* renamed from: u, reason: collision with root package name */
    private int f2703u;

    /* renamed from: z, reason: collision with root package name */
    private String f2707z;

    /* renamed from: a, reason: collision with root package name */
    private String f2688a = "";

    /* renamed from: j, reason: collision with root package name */
    private int f2693j = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f2704v = 30;

    /* renamed from: w, reason: collision with root package name */
    private int f2705w = 1;

    /* renamed from: x, reason: collision with root package name */
    private int f2706x = 10;
    private int y = 60;
    private int B = 1;
    private String C = "";
    private int F = 100;
    private int G = 60;
    private int H = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
    private int J = 1;
    private String L = "";
    private String M = "";

    public static k a(JSONObject jSONObject) {
        k kVar;
        k kVar2 = null;
        if (jSONObject != null) {
            try {
                kVar = new k();
            } catch (Exception e) {
                e = e;
            }
            try {
                ((c) kVar).K = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                String strOptString = jSONObject.optString("ab_id");
                ((c) kVar).f2688a = strOptString;
                com.mbridge.msdk.foundation.controller.a.f3352b.put(((c) kVar).K, strOptString);
                ((c) kVar).L = jSONObject.optString("rid");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adSourceList");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                        arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i10)));
                    }
                    ((c) kVar).f2689b = arrayList;
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                        arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray2.optInt(i11)));
                    }
                    ((c) kVar).f2690c = arrayList2;
                }
                ((c) kVar).I = jSONObject.optInt("tpqn");
                ((c) kVar).f = jSONObject.optInt("aqn");
                ((c) kVar).e = jSONObject.optInt("acn");
                ((c) kVar).N = jSONObject.optInt("wt");
                int i12 = 1;
                ((c) kVar).f2705w = jSONObject.optInt("iscasf", 1);
                ((c) kVar).H = jSONObject.optInt("spmxrt", DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
                ((c) kVar).f2699p = jSONObject.optLong("current_time");
                ((c) kVar).B = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET);
                ((c) kVar).f2700q = jSONObject.optLong("dlct", 3600L);
                ((c) kVar).g = jSONObject.optInt("autoplay", 0);
                ((c) kVar).f2701r = jSONObject.optInt("dlnet", 2);
                ((c) kVar).A = jSONObject.optString("no_offer");
                ((c) kVar).f2692i = jSONObject.optInt("cb_type");
                ((c) kVar).f2695l = jSONObject.optLong("clct", 86400L);
                ((c) kVar).f2694k = jSONObject.optLong("clcq", 300L);
                ((c) kVar).F = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                ((c) kVar).f2693j = jSONObject.optInt("cd_rate", 0);
                ((c) kVar).f2697n = jSONObject.optInt("content", 1);
                ((c) kVar).f2703u = jSONObject.optInt("impt", 0);
                ((c) kVar).t = jSONObject.optInt("icon_type", 1);
                ((c) kVar).f2707z = jSONObject.optString("no_ads_url", "");
                ((c) kVar).E = jSONObject.optInt("playclosebtn_tm", -1);
                ((c) kVar).D = jSONObject.optInt("play_ctdown", 0);
                ((c) kVar).f2696m = jSONObject.optInt("close_alert", 0);
                ((c) kVar).f2704v = jSONObject.optInt("intershowlimit", 30);
                ((c) kVar).G = jSONObject.optInt("refreshFq", 60);
                ((c) kVar).h = jSONObject.optInt("closeBtn", 0);
                int iOptInt = jSONObject.optInt("tmorl", 1);
                if (iOptInt <= 2 && iOptInt > 0) {
                    i12 = iOptInt;
                }
                ((c) kVar).J = i12;
                ((c) kVar).C = jSONObject.optString("placementid", "");
                ((c) kVar).f2706x = jSONObject.optInt("ltafemty", 10);
                ((c) kVar).y = jSONObject.optInt("ltorwc", 60);
                ((c) kVar).M = jSONObject.optString("vtag", "");
                return kVar;
            } catch (Exception e3) {
                e = e3;
                kVar2 = kVar;
                e.printStackTrace();
                return kVar2;
            }
        }
        return kVar2;
    }

    public final List<Integer> b() {
        return this.f2689b;
    }

    public final List<Integer> c() {
        return this.f2690c;
    }

    public final int d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public final int f() {
        return this.h;
    }

    public final int g() {
        return this.f2693j;
    }

    public final int h() {
        return this.f2697n;
    }

    public final long i() {
        return this.f2699p;
    }

    public final long j() {
        return this.f2700q;
    }

    public final int k() {
        return this.f2701r;
    }

    public final int l() {
        return this.f2703u;
    }

    public final int m() {
        return this.f2705w;
    }

    public final int n() {
        return this.f2706x;
    }

    public final int o() {
        return this.y;
    }

    public final int p() {
        return this.F;
    }

    public final int q() {
        return this.G;
    }

    public final int r() {
        return this.H;
    }

    public final String s() {
        return this.L;
    }

    public final String t() {
        return this.M;
    }

    public String toString() {
        List<Integer> list = this.f2689b;
        String str = "";
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = this.f2689b.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
        }
        StringBuilder sb = new StringBuilder("offset = ");
        sb.append(this.B);
        sb.append(" unitId = ");
        sb.append(this.K);
        sb.append(" fbPlacementId = ");
        return a3.a.o(sb, this.f2702s, str);
    }

    public final int u() {
        return this.N;
    }

    public final int v() {
        return this.g;
    }

    public final int w() {
        return this.B;
    }

    public final JSONObject x() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> list = this.f2689b;
            if (list != null && list.size() > 0) {
                int size = list.size();
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < size; i10++) {
                    jSONArray.put(list.get(i10));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> list2 = this.f2690c;
            if (list2 != null && list2.size() > 0) {
                int size2 = list2.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i11 = 0; i11 < size2; i11++) {
                    jSONArray2.put(list2.get(i11));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.I);
            jSONObject.put("aqn", this.f);
            jSONObject.put("acn", this.e);
            jSONObject.put("wt", this.N);
            jSONObject.put("current_time", this.f2699p);
            jSONObject.put(TypedValues.CycleType.S_WAVE_OFFSET, this.B);
            jSONObject.put("dlct", this.f2700q);
            jSONObject.put("autoplay", this.g);
            jSONObject.put("dlnet", this.f2701r);
            jSONObject.put("no_offer", this.A);
            jSONObject.put("cb_type", this.f2692i);
            jSONObject.put("clct", this.f2695l);
            jSONObject.put("clcq", this.f2694k);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.F);
            jSONObject.put("content", this.f2697n);
            jSONObject.put("impt", this.f2703u);
            jSONObject.put("icon_type", this.t);
            jSONObject.put("no_ads_url", this.f2707z);
            jSONObject.put("playclosebtn_tm", this.E);
            jSONObject.put("play_ctdown", this.D);
            jSONObject.put("close_alert", this.f2696m);
            jSONObject.put("closeBtn", this.h);
            jSONObject.put("refreshFq", this.G);
            jSONObject.put("countdown", this.f2698o);
            jSONObject.put("allowSkip", this.f2691d);
            jSONObject.put("tmorl", this.J);
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.K);
            jSONObject.put("placementid", this.C);
            jSONObject.put("ltafemty", this.f2706x);
            jSONObject.put("ltorwc", this.y);
            jSONObject.put("vtag", this.M);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final void b(List<Integer> list) {
        this.f2690c = list;
    }

    public final void c(int i10) {
        this.e = i10;
    }

    public final void d(int i10) {
        this.f = i10;
    }

    public final void e(int i10) {
        this.f2693j = i10;
    }

    public final void f(int i10) {
        this.f2697n = i10;
    }

    public final void g(int i10) {
        this.f2698o = i10;
    }

    public final void h(int i10) {
        this.f2701r = i10;
    }

    public final void i(int i10) {
        this.f2703u = i10;
    }

    public final void j(int i10) {
        this.f2706x = i10;
    }

    public final void k(int i10) {
        this.y = i10;
    }

    public final void l(int i10) {
        this.F = i10;
    }

    public final void m(int i10) {
        this.G = i10;
    }

    public final void n(int i10) {
        this.I = i10;
    }

    public final void o(int i10) {
        this.N = i10;
    }

    public final void p(int i10) {
        this.B = i10;
    }

    public final void b(int i10) {
        this.f2691d = i10;
    }

    public final void b(String str) {
        this.K = str;
    }

    public final void a(int i10) {
        this.g = i10;
    }

    public final String a() {
        return this.f2688a;
    }

    public final void a(List<Integer> list) {
        this.f2689b = list;
    }

    public final void a(long j10) {
        this.f2700q = j10;
    }

    public final void a(String str) {
        this.C = str;
    }
}
