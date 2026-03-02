package com.mbridge.msdk.newreward.a;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.File;
import org.json.JSONArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {
    private String A;
    private String B;
    private int D;
    private long E;
    private MBridgeIds O;
    private f P;
    private com.mbridge.msdk.newreward.function.g.c Q;
    private t3.b Z;

    /* renamed from: a, reason: collision with root package name */
    public b f4604a;
    private t3.a aa;
    private u3.b ab;
    private boolean ac;
    private HandlerThread af;
    private RewardVideoListener ag;

    /* renamed from: b, reason: collision with root package name */
    int f4605b;

    /* renamed from: c, reason: collision with root package name */
    private String f4606c;

    /* renamed from: d, reason: collision with root package name */
    private CampaignEx f4607d;
    private boolean e;
    private int f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private int f4608i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4612m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4613n;

    /* renamed from: p, reason: collision with root package name */
    private long f4615p;

    /* renamed from: q, reason: collision with root package name */
    private long f4616q;

    /* renamed from: u, reason: collision with root package name */
    private String f4619u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f4620v;

    /* renamed from: x, reason: collision with root package name */
    private String f4622x;
    private String y;

    /* renamed from: z, reason: collision with root package name */
    private int f4623z;

    /* renamed from: j, reason: collision with root package name */
    private int f4609j = com.mbridge.msdk.foundation.same.a.F;

    /* renamed from: k, reason: collision with root package name */
    private int f4610k = 2;

    /* renamed from: l, reason: collision with root package name */
    private int f4611l = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4614o = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f4617r = false;

    /* renamed from: s, reason: collision with root package name */
    private int f4618s = 0;
    private int t = 0;

    /* renamed from: w, reason: collision with root package name */
    private boolean f4621w = false;
    private String C = "";
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private com.mbridge.msdk.newreward.function.e.a I = new com.mbridge.msdk.newreward.function.e.a();
    private com.mbridge.msdk.newreward.function.e.e J = new com.mbridge.msdk.newreward.function.e.e();
    private com.mbridge.msdk.newreward.function.e.f K = new com.mbridge.msdk.newreward.function.e.f();
    private com.mbridge.msdk.newreward.function.e.c L = new com.mbridge.msdk.newreward.function.e.c();
    private com.mbridge.msdk.newreward.function.e.d M = new com.mbridge.msdk.newreward.function.e.d();
    private int N = 25000;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;
    private int ad = 0;
    private JSONArray ae = new JSONArray();

    public e(boolean z9, int i10, String str, String str2, boolean z10) {
        this.e = z9;
        this.f4623z = i10;
        this.f4622x = str;
        this.y = str2;
        this.f4613n = z10;
    }

    public final int A() {
        return this.f4605b;
    }

    public final String B() {
        return this.A;
    }

    public final String C() {
        return this.B;
    }

    public final com.mbridge.msdk.newreward.function.e.a D() {
        return this.I;
    }

    public final com.mbridge.msdk.newreward.function.e.d E() {
        return this.M;
    }

    public final com.mbridge.msdk.newreward.function.e.e F() {
        return this.J;
    }

    public final String G() {
        return this.f4606c;
    }

    public final String H() {
        return this.y;
    }

    public final boolean I() {
        return this.e;
    }

    public final String J() {
        return this.f4622x;
    }

    public final RewardVideoListener K() {
        return this.ag;
    }

    public final int L() {
        return this.g;
    }

    public final int M() {
        return this.e ? 2 : 3;
    }

    public final int N() {
        return this.f;
    }

    public final int O() {
        return this.f4610k;
    }

    public final int P() {
        int i10 = this.N;
        if (i10 <= 0) {
            return 25000;
        }
        return i10;
    }

    public final int Q() {
        return this.f4611l;
    }

    public final boolean R() {
        return this.f4613n;
    }

    public final MBridgeIds S() {
        return this.O;
    }

    public final long T() {
        com.mbridge.msdk.newreward.function.e.a aVar = this.I;
        if (aVar != null && aVar.b() != null && this.I.b().p() > 0) {
            return this.I.b().p();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.mbridge.msdk.videocommon.d.a aVarA = this.K.a();
        return (aVarA == null ? 3600000L : aVarA.f()) + jCurrentTimeMillis;
    }

    public final CampaignEx U() {
        return this.f4607d;
    }

    public final String V() {
        CampaignEx campaignEx = this.f4607d;
        return campaignEx == null ? "" : campaignEx.getRequestIdNotice();
    }

    public final f W() {
        return this.P;
    }

    public final boolean X() {
        return this.R;
    }

    public final boolean Y() {
        return this.S;
    }

    public final boolean Z() {
        return this.U;
    }

    public final void a(String str) {
        if (this.ae == null) {
            this.ae = new JSONArray();
        }
        this.ae.put(str);
    }

    public final boolean aa() {
        return this.V;
    }

    public final boolean ab() {
        return this.W;
    }

    public final boolean ac() {
        return this.X;
    }

    public final t3.b ad() {
        return this.Z;
    }

    public final t3.a ae() {
        return this.aa;
    }

    public final u3.b af() {
        return this.ab;
    }

    public final boolean ag() {
        return this.Y;
    }

    public final boolean ah() {
        return this.T;
    }

    public final String ai() {
        CampaignEx campaignEx = this.f4607d;
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return "904";
        }
        String strE = this.f4607d.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return "904";
        }
        if (this.f4607d.getAdSpaceT() == 2) {
            return "HALF_TEMPLATE";
        }
        return (!com.mbridge.msdk.newreward.function.h.c.b(strE) && this.ac) ? "WEB_TEMPLATE" : String.valueOf(this.f4607d.getRewardTemplateMode().f());
    }

    public final String aj() {
        CampaignEx campaignEx = this.f4607d;
        if (campaignEx == null) {
            return "404";
        }
        boolean z9 = this.f4607d.isMraid() || !com.mbridge.msdk.newreward.function.h.c.b(campaignEx.getendcard_url());
        long ecTemplateId = this.f4607d.getEcTemplateId();
        if (ecTemplateId == 0) {
            ecTemplateId = 404;
        }
        return z9 ? this.ac ? "WEB_EC" : String.valueOf(ecTemplateId) : String.valueOf(ecTemplateId);
    }

    public final boolean ak() {
        CampaignEx campaignEx = this.f4607d;
        return campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2;
    }

    public final String al() {
        CampaignEx campaignEx = this.f4607d;
        if (campaignEx == null) {
            return "ONLY_PLAYABLE";
        }
        return ((campaignEx.getPlayable_ads_without_video() == 2) && (this.f4607d.getAdSpaceT() == 2)) ? "HALF_END_CARD" : this.ac ? "ONLY_PLAYABLE" : "404";
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int am() {
        /*
            r5 = this;
            r0 = 0
            com.mbridge.msdk.newreward.function.e.a r1 = r5.I     // Catch: java.lang.Exception -> L34
            if (r1 == 0) goto L37
            java.util.List r1 = r1.a()     // Catch: java.lang.Exception -> L34
            if (r1 == 0) goto L37
            com.mbridge.msdk.newreward.function.e.a r1 = r5.I     // Catch: java.lang.Exception -> L34
            java.util.List r1 = r1.a()     // Catch: java.lang.Exception -> L34
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L34
            if (r1 != 0) goto L37
            com.mbridge.msdk.newreward.function.e.a r1 = r5.I     // Catch: java.lang.Exception -> L34
            java.util.List r1 = r1.a()     // Catch: java.lang.Exception -> L34
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Exception -> L34
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch: java.lang.Exception -> L34
            if (r1 == 0) goto L37
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r1.getRewardTemplateMode()     // Catch: java.lang.Exception -> L34
            if (r2 == 0) goto L37
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r1.getRewardTemplateMode()     // Catch: java.lang.Exception -> L34
            int r1 = r1.b()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r1 = move-exception
            r2 = r0
            goto L53
        L37:
            r1 = r0
        L38:
            if (r1 != 0) goto L5b
            com.mbridge.msdk.newreward.function.e.f r2 = r5.K     // Catch: java.lang.Exception -> L4f
            if (r2 == 0) goto L5b
            com.mbridge.msdk.videocommon.d.c r2 = r2.b()     // Catch: java.lang.Exception -> L4f
            if (r2 == 0) goto L5b
            com.mbridge.msdk.newreward.function.e.f r2 = r5.K     // Catch: java.lang.Exception -> L4f
            com.mbridge.msdk.videocommon.d.c r2 = r2.b()     // Catch: java.lang.Exception -> L4f
            int r1 = r2.c()     // Catch: java.lang.Exception -> L4f
            goto L5b
        L4f:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L53:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L5a
            r1.printStackTrace()
        L5a:
            r1 = r2
        L5b:
            r2 = 1
            if (r1 == r2) goto L63
            r2 = 2
            if (r1 == r2) goto L64
            r0 = -1
            goto L64
        L63:
            r0 = r2
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.e.am():int");
    }

    public final String b() {
        JSONArray jSONArray = this.ae;
        return jSONArray == null ? "" : jSONArray.toString();
    }

    public final com.mbridge.msdk.newreward.function.g.c c() {
        return this.Q;
    }

    public final boolean d() {
        return this.H;
    }

    public final boolean e() {
        return this.G;
    }

    public final boolean f() {
        return this.F;
    }

    public final File g(String str) {
        for (com.mbridge.msdk.newreward.function.c.a.a aVar : this.I.b().u()) {
            if (aVar.g().equals(str)) {
                return aVar.d().g();
            }
        }
        return null;
    }

    public final int h() {
        return this.f4623z;
    }

    public final String i() {
        return this.C;
    }

    public final boolean j() {
        return this.f4620v;
    }

    public final String k() {
        return this.f4619u;
    }

    public final void l() {
        this.f4618s++;
    }

    public final void m() {
        this.t++;
    }

    public final boolean n() {
        return this.f4617r;
    }

    public final long o() {
        return this.f4616q;
    }

    public final long p() {
        return this.f4615p;
    }

    public final boolean q() {
        return this.f4614o;
    }

    public final boolean r() {
        return this.f4612m;
    }

    public final boolean s() {
        return this.f4621w;
    }

    public final int t() {
        return this.g;
    }

    public final int u() {
        return this.h;
    }

    public final int v() {
        return this.f4608i;
    }

    public final int w() {
        return this.f4609j;
    }

    public final com.mbridge.msdk.newreward.function.e.f x() {
        return this.K;
    }

    public final int y() {
        return this.D;
    }

    public final com.mbridge.msdk.newreward.function.e.c z() {
        return this.L;
    }

    public final void c(boolean z9) {
        this.F = z9;
    }

    public final void d(boolean z9) {
        this.f4620v = z9;
    }

    public final void e(boolean z9) {
        this.f4617r = z9;
    }

    public final void f(boolean z9) {
        this.f4614o = z9;
    }

    public final void h(boolean z9) {
        this.f4621w = z9;
    }

    public final void i(boolean z9) {
        this.R = z9;
    }

    public final void j(boolean z9) {
        this.S = z9;
    }

    public final void k(boolean z9) {
        this.U = z9;
    }

    public final void n(boolean z9) {
        this.X = z9;
    }

    public final void o(boolean z9) {
        this.Y = z9;
    }

    public final void p(boolean z9) {
        this.ac = z9;
    }

    public final void q(boolean z9) {
        this.T = z9;
    }

    public final void c(String str) {
        this.f4619u = str;
    }

    public final void d(int i10) {
        this.f4605b = i10;
    }

    public final void e(String str) {
        this.B = str;
    }

    public final void f(String str) {
        this.f4606c = str;
    }

    public final void c(long j10) {
        this.f4615p = j10;
    }

    public final void d(String str) {
        this.A = str;
    }

    public final void e(int i10) {
        this.f4610k = i10;
    }

    public final void f(int i10) {
        this.N = i10;
    }

    public final void c(int i10) {
        this.D = i10;
    }

    public final void l(boolean z9) {
        this.V = z9;
    }

    public final void m(boolean z9) {
        this.W = z9;
    }

    public final void b(boolean z9) {
        this.G = z9;
    }

    public final void b(String str) {
        this.C = str;
    }

    public final void b(long j10) {
        this.f4616q = j10;
    }

    public final void b(int i10) {
        this.f4609j = i10;
    }

    public final void a(HandlerThread handlerThread) {
        this.af = handlerThread;
    }

    public final HandlerThread a() {
        return this.af;
    }

    public final void a(com.mbridge.msdk.newreward.function.g.c cVar) {
        this.Q = cVar;
    }

    public final void a(boolean z9) {
        this.H = z9;
    }

    public final void a(long j10) {
        this.E = j10;
    }

    public final void a(int i10) {
        this.f = i10;
    }

    public final void a(com.mbridge.msdk.newreward.function.e.f fVar) {
        this.K = fVar;
    }

    public final void a(com.mbridge.msdk.newreward.function.e.a aVar) {
        this.I = aVar;
    }

    public final void a(RewardVideoListener rewardVideoListener) {
        this.ag = rewardVideoListener;
    }

    public final void a(MBridgeIds mBridgeIds) {
        this.O = mBridgeIds;
    }

    public final void a(f fVar) {
        this.P = fVar;
    }

    public final void a(CampaignEx campaignEx) {
        this.f4607d = campaignEx;
    }

    public final void a(t3.b bVar) {
        this.Z = bVar;
    }

    public final void a(t3.a aVar) {
        this.aa = aVar;
    }

    public final void a(u3.b bVar) {
        this.ab = bVar;
    }

    public final void a(int i10, int i11, int i12) {
        this.g = i10;
        this.h = i11;
        this.f4608i = i12;
    }

    public final void g(boolean z9) {
        this.f4612m = z9;
    }

    public final void g(int i10) {
        this.f4611l = i10;
    }

    public final long g() {
        return this.E;
    }
}
