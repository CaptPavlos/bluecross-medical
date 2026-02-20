package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {
    private static g H;

    /* renamed from: a, reason: collision with root package name */
    public static String f6516a;
    private int F;
    private int I;
    private JSONArray W;
    private JSONObject X;

    /* renamed from: b, reason: collision with root package name */
    private String f6517b;

    /* renamed from: c, reason: collision with root package name */
    private String f6518c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.b.b> f6519d;
    private long e;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<Integer> f6531u;
    private int f = -1;
    private int g = 0;
    private int h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f6520i = 1;

    /* renamed from: j, reason: collision with root package name */
    private int f6521j = 1;

    /* renamed from: k, reason: collision with root package name */
    private int f6522k = 1;

    /* renamed from: l, reason: collision with root package name */
    private int f6523l = 1;

    /* renamed from: m, reason: collision with root package name */
    private int f6524m = 5;

    /* renamed from: n, reason: collision with root package name */
    private int f6525n = 1;

    /* renamed from: o, reason: collision with root package name */
    private int f6526o = 3;

    /* renamed from: p, reason: collision with root package name */
    private int f6527p = 80;

    /* renamed from: q, reason: collision with root package name */
    private int f6528q = 100;

    /* renamed from: r, reason: collision with root package name */
    private int f6529r = 0;

    /* renamed from: s, reason: collision with root package name */
    private double f6530s = 1.0d;
    private int t = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f6532v = 3;

    /* renamed from: w, reason: collision with root package name */
    private int f6533w = 1;

    /* renamed from: x, reason: collision with root package name */
    private int f6534x = 100;
    private int y = 60;

    /* renamed from: z, reason: collision with root package name */
    private int f6535z = 0;
    private int A = 70;
    private int B = 0;
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private int G = 20;
    private int J = 0;
    private int K = 1;
    private String L = "";
    private int M = 1;
    private String N = "";
    private int O = 1;
    private String P = "Virtual Item";
    private String Q = "";
    private String R = "";
    private int S = 0;
    private int T = 1;
    private int U = 60;
    private String V = "";

    public static c a(JSONObject jSONObject) {
        c cVar;
        c cVar2 = null;
        if (jSONObject != null) {
            try {
                cVar = new c();
            } catch (Exception e) {
                e = e;
            }
            try {
                cVar.f6519d = com.mbridge.msdk.videocommon.b.b.a(jSONObject.optJSONArray("adSourceList"));
                cVar.f6520i = jSONObject.optInt("callbackType");
                int iOptInt = jSONObject.optInt("aqn", 1);
                if (iOptInt <= 0) {
                    iOptInt = 1;
                }
                cVar.f6521j = iOptInt;
                int iOptInt2 = jSONObject.optInt("acn", 1);
                if (iOptInt2 < 0) {
                    iOptInt2 = 1;
                }
                cVar.f6522k = iOptInt2;
                cVar.f6523l = jSONObject.optInt("vcn", 5);
                cVar.f6524m = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET, 5);
                cVar.f6525n = jSONObject.optInt("dlnet", 1);
                cVar.I = jSONObject.optInt("endscreen_type", 2);
                cVar.f6526o = jSONObject.optInt("tv_start", 3);
                cVar.f6527p = jSONObject.optInt("tv_end", 80);
                cVar.f6528q = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                cVar.e = jSONObject.optLong("current_time");
                cVar.f6535z = jSONObject.optInt("orientation", 0);
                cVar.B = jSONObject.optInt("daily_play_cap", 0);
                cVar.C = jSONObject.optInt("video_skip_time", -1);
                cVar.D = jSONObject.optInt("video_skip_result", 2);
                cVar.E = jSONObject.optInt("video_interactive_type", -1);
                cVar.F = jSONObject.optInt("close_button_delay", 1);
                cVar.f = jSONObject.optInt("playclosebtn_tm", -1);
                cVar.g = jSONObject.optInt("play_ctdown", 0);
                cVar.h = jSONObject.optInt("close_alert", 0);
                cVar.G = jSONObject.optInt("rdrct", 20);
                cVar.t = jSONObject.optInt("rfpv", -1);
                cVar.f6530s = jSONObject.optDouble("vdcmp", 1.0d);
                cVar.A = jSONObject.optInt("load_global_timeout", 70);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                try {
                    if (jSONArrayOptJSONArray != null) {
                        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                            arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i10)));
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    cVar.f6531u = arrayList;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                cVar.f6532v = jSONObject.optInt("atl_dyt", 3);
                int iOptInt3 = jSONObject.optInt("tmorl", 1);
                if (iOptInt3 > 2 || iOptInt3 <= 0) {
                    iOptInt3 = 1;
                }
                cVar.f6533w = iOptInt3;
                cVar.f6518c = jSONObject.optString("placementid");
                cVar.f6534x = jSONObject.optInt("ltafemty", 10);
                cVar.y = jSONObject.optInt("ltorwc", 60);
                cVar.d(jSONObject.optString("ab_id"));
                cVar.R = jSONObject.optString("rid", "");
                cVar.J = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                cVar.K = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                cVar.L = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                cVar.y(jSONObject.optInt(RewardPlus.AMOUNT, 1));
                cVar.N = jSONObject.optString(RewardPlus.ICON, "");
                cVar.O = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                cVar.e(jSONObject.optString(RewardPlus.NAME, "Virtual Item"));
                cVar.T = jSONObject.optInt("video_error_rule", 1);
                cVar.U = jSONObject.optInt("loadtmo", 60);
                cVar.V = jSONObject.optString("vtag", "");
                cVar.W = jSONObject.optJSONArray("local_cache_info");
                try {
                    String strOptString = jSONObject.optString(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY);
                    if (!TextUtils.isEmpty(strOptString)) {
                        String strA = z.a(strOptString);
                        if (!TextUtils.isEmpty(strA)) {
                            cVar.X = new JSONObject(strA);
                        }
                    }
                } catch (Exception unused) {
                }
                return cVar;
            } catch (Exception e7) {
                e = e7;
                cVar2 = cVar;
                e.printStackTrace();
                return cVar2;
            }
        }
        return cVar2;
    }

    public static c c(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (H == null) {
            H = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("vtag", "");
                String strOptString2 = jSONObject.optString("rid", "");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unitSetting");
                if (jSONArrayOptJSONArray != null && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) != null) {
                    String strOptString3 = jSONObjectOptJSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                    if (!TextUtils.isEmpty(strOptString3)) {
                        c cVar2 = new c();
                        try {
                            cVar2.V = strOptString;
                            cVar2.R = strOptString2;
                            List<com.mbridge.msdk.videocommon.b.b> listA = com.mbridge.msdk.videocommon.b.b.a(jSONObjectOptJSONObject.optJSONArray("adSourceList"));
                            cVar2.f6517b = strOptString3;
                            cVar2.f6519d = listA;
                            cVar2.f6520i = jSONObjectOptJSONObject.optInt("callbackType");
                            int iOptInt = jSONObjectOptJSONObject.optInt("aqn", 1);
                            if (iOptInt <= 0) {
                                iOptInt = 1;
                            }
                            cVar2.f6521j = iOptInt;
                            int iOptInt2 = jSONObjectOptJSONObject.optInt("acn", 1);
                            if (iOptInt2 < 0) {
                                iOptInt2 = 1;
                            }
                            cVar2.f6522k = iOptInt2;
                            cVar2.f6523l = jSONObjectOptJSONObject.optInt("vcn", 5);
                            cVar2.f6524m = jSONObjectOptJSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET, 5);
                            cVar2.f6525n = jSONObjectOptJSONObject.optInt("dlnet", 1);
                            cVar2.I = jSONObjectOptJSONObject.optInt("endscreen_type", 2);
                            cVar2.f6526o = jSONObjectOptJSONObject.optInt("tv_start", 3);
                            cVar2.f6527p = jSONObjectOptJSONObject.optInt("tv_end", 80);
                            cVar2.f6528q = jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                            cVar2.f6529r = jSONObjectOptJSONObject.optInt("cd_rate", 0);
                            cVar2.e = jSONObject.optLong("current_time");
                            cVar2.f6535z = jSONObjectOptJSONObject.optInt("orientation", 0);
                            cVar2.B = jSONObjectOptJSONObject.optInt("daily_play_cap", 0);
                            cVar2.C = jSONObjectOptJSONObject.optInt("video_skip_time", -1);
                            cVar2.D = jSONObjectOptJSONObject.optInt("video_skip_result", 2);
                            cVar2.E = jSONObjectOptJSONObject.optInt("video_interactive_type", -1);
                            cVar2.F = jSONObjectOptJSONObject.optInt("close_button_delay", 1);
                            cVar2.f = jSONObjectOptJSONObject.optInt("playclosebtn_tm", -1);
                            cVar2.g = jSONObjectOptJSONObject.optInt("play_ctdown", 0);
                            cVar2.h = jSONObjectOptJSONObject.optInt("close_alert", 0);
                            cVar2.G = jSONObjectOptJSONObject.optInt("rdrct", 20);
                            cVar2.A = jSONObjectOptJSONObject.optInt("load_global_timeout", 70);
                            cVar2.t = jSONObjectOptJSONObject.optInt("rfpv", -1);
                            cVar2.f6530s = jSONObjectOptJSONObject.optDouble("vdcmp", 1.0d);
                            f6516a = jSONObjectOptJSONObject.optString("atzu");
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("atl_type");
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            try {
                                if (jSONArrayOptJSONArray2 != null) {
                                    for (int i10 = 0; i10 < jSONArrayOptJSONArray2.length(); i10++) {
                                        arrayList.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i10)));
                                    }
                                } else {
                                    arrayList.add(4);
                                    arrayList.add(6);
                                }
                                cVar2.f6531u = arrayList;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            int iOptInt3 = jSONObjectOptJSONObject.optInt("atl_dyt", 0);
                            cVar2.f6532v = iOptInt3 > 0 ? iOptInt3 : 3;
                            int iOptInt4 = jSONObjectOptJSONObject.optInt("tmorl", 1);
                            if (iOptInt4 > 2 || iOptInt4 <= 0) {
                                iOptInt4 = 1;
                            }
                            cVar2.f6533w = iOptInt4;
                            cVar2.f6518c = jSONObjectOptJSONObject.optString("placementid");
                            cVar2.f6534x = jSONObjectOptJSONObject.optInt("ltafemty", 10);
                            cVar2.y = jSONObjectOptJSONObject.optInt("ltorwc", 60);
                            cVar2.d(jSONObjectOptJSONObject.optString("ab_id"));
                            cVar2.J = jSONObjectOptJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                            cVar2.K = jSONObjectOptJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                            cVar2.L = jSONObjectOptJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                            cVar2.y(jSONObjectOptJSONObject.optInt(RewardPlus.AMOUNT, 1));
                            cVar2.N = jSONObjectOptJSONObject.optString(RewardPlus.ICON, "");
                            cVar2.O = jSONObjectOptJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                            cVar2.e(jSONObjectOptJSONObject.optString(RewardPlus.NAME, "Virtual Item"));
                            cVar2.T = jSONObjectOptJSONObject.optInt("video_error_rule", 1);
                            cVar2.U = jSONObjectOptJSONObject.optInt("loadtmo", 60);
                            cVar2.W = jSONObjectOptJSONObject.optJSONArray("local_cache_info");
                            try {
                                String strOptString4 = jSONObjectOptJSONObject.optString(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY);
                                if (!TextUtils.isEmpty(strOptString4)) {
                                    String strA = z.a(strOptString4);
                                    if (!TextUtils.isEmpty(strA)) {
                                        cVar2.X = new JSONObject(strA);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            return cVar2;
                        } catch (Exception e3) {
                            e = e3;
                            cVar = cVar2;
                            e.printStackTrace();
                            return cVar;
                        }
                    }
                }
            } catch (Exception e7) {
                e = e7;
            }
        }
        return cVar;
    }

    private void d(String str) {
        this.Q = str;
        com.mbridge.msdk.foundation.controller.a.f3352b.put(this.f6517b, str);
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.P = this.L;
        } else {
            this.P = str;
        }
    }

    private void y(int i10) {
        if (i10 <= 0) {
            this.M = 1;
        } else {
            this.M = i10;
        }
    }

    public final int A() {
        return this.f6532v;
    }

    public final Queue<Integer> B() {
        LinkedList linkedList;
        Exception e;
        try {
            List<com.mbridge.msdk.videocommon.b.b> list = this.f6519d;
            if (list == null || list.size() <= 0) {
                return null;
            }
            linkedList = new LinkedList();
            for (int i10 = 0; i10 < this.f6519d.size(); i10++) {
                try {
                    linkedList.add(Integer.valueOf(this.f6519d.get(i10).b()));
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    return linkedList;
                }
            }
            return linkedList;
        } catch (Exception e7) {
            linkedList = null;
            e = e7;
        }
    }

    public final int C() {
        return this.T;
    }

    public final int D() {
        return this.U;
    }

    public final JSONObject E() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f6517b);
            jSONObject.put("callbackType", this.f6520i);
            List<com.mbridge.msdk.videocommon.b.b> list = this.f6519d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.mbridge.msdk.videocommon.b.b bVar : this.f6519d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.f6521j);
            jSONObject.put("acn", this.f6522k);
            jSONObject.put("vcn", this.f6523l);
            jSONObject.put(TypedValues.CycleType.S_WAVE_OFFSET, this.f6524m);
            jSONObject.put("dlnet", this.f6525n);
            jSONObject.put("tv_start", this.f6526o);
            jSONObject.put("tv_end", this.f6527p);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f6528q);
            jSONObject.put("endscreen_type", this.I);
            jSONObject.put("daily_play_cap", this.B);
            jSONObject.put("video_skip_time", this.C);
            jSONObject.put("video_skip_result", this.D);
            jSONObject.put("video_interactive_type", this.E);
            jSONObject.put("orientation", this.f6535z);
            jSONObject.put("close_button_delay", this.F);
            jSONObject.put("playclosebtn_tm", this.f);
            jSONObject.put("play_ctdown", this.g);
            jSONObject.put("close_alert", this.h);
            jSONObject.put("rfpv", this.t);
            jSONObject.put("vdcmp", this.f6530s);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.f6531u;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    ArrayList<Integer> arrayList2 = this.f6531u;
                    int size = arrayList2.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Integer num = arrayList2.get(i10);
                        i10++;
                        jSONArray2.put(num);
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.f6532v);
            jSONObject.put("tmorl", this.f6533w);
            jSONObject.put("placementid", this.f6518c);
            jSONObject.put("ltafemty", this.f6534x);
            jSONObject.put("ltorwc", this.y);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.J);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.K);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.L);
            jSONObject.put(RewardPlus.AMOUNT, this.M);
            jSONObject.put(RewardPlus.ICON, this.N);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.O);
            jSONObject.put(RewardPlus.NAME, this.P);
            jSONObject.put("isDefault", this.S);
            jSONObject.put("video_error_rule", this.T);
            jSONObject.put("loadtmo", this.U);
            jSONObject.put("vtag", this.V);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final int F() {
        return this.A;
    }

    public final JSONArray G() {
        return this.W;
    }

    public final int b() {
        return this.y;
    }

    public final int f() {
        return this.D;
    }

    public final int g() {
        return this.E;
    }

    public final int h() {
        return this.f;
    }

    public final int i() {
        return this.h;
    }

    public final String j() {
        return this.V;
    }

    public final String k() {
        return this.Q;
    }

    public final String l() {
        return this.R;
    }

    public final int m() {
        return this.M;
    }

    public final String n() {
        return this.P;
    }

    public final int o() {
        return this.G;
    }

    public final int p() {
        return this.F;
    }

    public final int q() {
        return this.I;
    }

    public final int r() {
        return this.f6528q;
    }

    public final boolean s(int i10) {
        ArrayList<Integer> arrayList = this.f6531u;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.f6531u.contains(Integer.valueOf(i10));
    }

    public final int t() {
        return this.f6521j;
    }

    public final int u() {
        return this.f6522k;
    }

    public final int v() {
        return this.f6524m;
    }

    public final int w() {
        return this.f6525n;
    }

    public final long x() {
        return this.e;
    }

    public final String z() {
        return this.f6518c;
    }

    public final void b(int i10) {
        this.B = i10;
    }

    public final void f(int i10) {
        this.F = i10;
    }

    public final void g(int i10) {
        this.I = i10;
    }

    public final void h(int i10) {
        this.f6526o = i10;
    }

    public final void i(int i10) {
        this.f6527p = i10;
    }

    public final void j(int i10) {
        this.f6528q = i10;
    }

    public final void k(int i10) {
        this.f6529r = i10;
    }

    public final void l(int i10) {
        this.f6521j = i10;
    }

    public final void m(int i10) {
        this.f6522k = i10;
    }

    public final void n(int i10) {
        this.f6523l = i10;
    }

    public final void o(int i10) {
        this.f6524m = i10;
    }

    public final void p(int i10) {
        this.f6525n = i10;
    }

    public final void q(int i10) {
        this.f6520i = i10;
    }

    public final void r(int i10) {
        this.f6533w = i10;
    }

    public final void t(int i10) {
        this.f6532v = i10;
    }

    public final void u(int i10) {
        this.S = i10;
    }

    public final void v(int i10) {
        this.T = i10;
    }

    public final void w(int i10) {
        this.U = i10;
    }

    public final void x(int i10) {
        this.A = i10;
    }

    public final void b(String str) {
        this.f6518c = str;
    }

    public final int y() {
        return this.f6533w;
    }

    public final void d(int i10) {
        this.D = i10;
    }

    public final int d() {
        return this.B;
    }

    public final void e(int i10) {
        this.E = i10;
    }

    public final int e() {
        return this.C;
    }

    public final int s() {
        return this.f6529r;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.f6531u = arrayList;
    }

    public final void a(int i10) {
        this.f6535z = i10;
    }

    public final void a(String str) {
        this.f6517b = str;
    }

    public final void a(List<com.mbridge.msdk.videocommon.b.b> list) {
        this.f6519d = list;
    }

    public final int a() {
        return this.f6534x;
    }

    public final void c(int i10) {
        this.C = i10;
    }

    public final int c() {
        return this.f6535z;
    }
}
