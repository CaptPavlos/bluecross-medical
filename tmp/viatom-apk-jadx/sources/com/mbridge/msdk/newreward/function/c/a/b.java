package com.mbridge.msdk.newreward.function.c.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.e;
import com.mbridge.msdk.newreward.function.c.c.i;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.h.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {
    private String A;
    private int B;
    private int C;
    private List<CampaignEx> D;
    private int E;
    private long G;
    private Map<String, Object> H;
    private String I;

    /* renamed from: a, reason: collision with root package name */
    private int f4667a;

    /* renamed from: b, reason: collision with root package name */
    private String f4668b;

    /* renamed from: c, reason: collision with root package name */
    private String f4669c;

    /* renamed from: d, reason: collision with root package name */
    private String f4670d;
    private String e;
    private String f;
    private String g;
    private boolean h;

    /* renamed from: j, reason: collision with root package name */
    private int f4672j;

    /* renamed from: k, reason: collision with root package name */
    private String f4673k;

    /* renamed from: l, reason: collision with root package name */
    private String f4674l;

    /* renamed from: m, reason: collision with root package name */
    private String f4675m;

    /* renamed from: n, reason: collision with root package name */
    private String f4676n;

    /* renamed from: o, reason: collision with root package name */
    private int f4677o;

    /* renamed from: p, reason: collision with root package name */
    private long f4678p;

    /* renamed from: q, reason: collision with root package name */
    private long f4679q;

    /* renamed from: r, reason: collision with root package name */
    private long f4680r;

    /* renamed from: s, reason: collision with root package name */
    private double f4681s;
    private int t;

    /* renamed from: u, reason: collision with root package name */
    private List<a> f4682u;

    /* renamed from: v, reason: collision with root package name */
    private JSONObject f4683v;

    /* renamed from: w, reason: collision with root package name */
    private d<?> f4684w;

    /* renamed from: z, reason: collision with root package name */
    private Context f4686z;

    /* renamed from: i, reason: collision with root package name */
    private long f4671i = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;

    /* renamed from: x, reason: collision with root package name */
    private int f4685x = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
    private int y = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
    private int F = 0;
    private boolean J = false;
    private int K = 0;
    private int L = 0;

    public b(int i10, String str, String str2, String str3) {
        this.f4667a = i10;
        this.f4668b = str;
        this.f4669c = str2;
        this.f4670d = str3;
    }

    public final boolean A() {
        return this.f4678p > System.currentTimeMillis();
    }

    public final String B() {
        return this.A;
    }

    public final int C() {
        return this.C;
    }

    public final int D() {
        return this.B;
    }

    public final List<CampaignEx> E() {
        return this.D;
    }

    public final int F() {
        int i10 = this.E;
        if (i10 <= 0) {
            return 1;
        }
        return i10;
    }

    public final int G() {
        return this.F;
    }

    public final Map<String, Object> H() {
        if (this.H == null) {
            this.H = new HashMap();
        }
        return this.H;
    }

    public final long I() {
        return this.G;
    }

    public final String J() {
        return this.I;
    }

    public final boolean K() {
        return this.J;
    }

    public final int a() {
        return this.K;
    }

    public final int b() {
        return this.L;
    }

    public final int c() {
        return this.f4667a;
    }

    public final String d() {
        return this.f4669c;
    }

    public final String e() {
        return this.f4670d;
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.f;
    }

    public final String h() {
        return this.g;
    }

    public final boolean i() {
        return this.h;
    }

    public final int j() {
        return this.f4672j;
    }

    public final String k() {
        return this.f4673k;
    }

    public final String l() {
        return this.f4674l;
    }

    public final String m() {
        return this.f4675m;
    }

    public final String n() {
        return this.f4676n;
    }

    public final int o() {
        return this.f4677o;
    }

    public final long p() {
        return this.f4678p;
    }

    public final long q() {
        return this.f4679q;
    }

    public final long r() {
        return this.f4680r;
    }

    public final double s() {
        return this.f4681s;
    }

    public final int t() {
        return this.t;
    }

    public final List<a> u() {
        return this.f4682u;
    }

    public final JSONObject v() {
        return this.f4683v;
    }

    public final d<?> w() {
        d<?> dVar = this.f4684w;
        if (dVar != null) {
            return dVar;
        }
        String str = this.A;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f4684w == null) {
            if (c.b(str)) {
                this.f4684w = new e(this, null);
            } else {
                this.f4684w = new i(this, null);
            }
        }
        return this.f4684w;
    }

    public final Context x() {
        return this.f4686z;
    }

    public final boolean y() {
        List<a> list;
        d<?> dVar = this.f4684w;
        if ((dVar == null || dVar.d()) && (list = this.f4682u) != null && !list.isEmpty()) {
            int size = this.f4682u.size();
            Iterator<a> it = this.f4682u.iterator();
            int i10 = 0;
            while (true) {
                boolean z9 = true;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                n nVarD = next.d();
                boolean z10 = nVarD == null || nVarD.d();
                d<?> dVarF = next.f();
                boolean z11 = dVarF == null || dVarF.d();
                d<?> dVarC = next.c();
                if (dVarC != null && !dVarC.d()) {
                    z9 = false;
                }
                if (z10 && z11 && z9) {
                    i10++;
                }
            }
            if (i10 == size) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z() {
        /*
            r10 = this;
            boolean r0 = r10.A()
            boolean r1 = r10.y()
            com.mbridge.msdk.newreward.function.c.c.d<?> r2 = r10.f4684w
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L14
            boolean r2 = r2.d()
            if (r2 == 0) goto L76
        L14:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r2 = r10.f4682u
            if (r2 == 0) goto L76
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L20
            goto L76
        L20:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r2 = r10.f4682u
            int r2 = r2.size()
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f4682u
            java.util.Iterator r5 = r5.iterator()
            r6 = r4
        L2d:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L72
            java.lang.Object r7 = r5.next()
            com.mbridge.msdk.newreward.function.c.a.a r7 = (com.mbridge.msdk.newreward.function.c.a.a) r7
            com.mbridge.msdk.newreward.function.c.c.n r8 = r7.d()
            if (r8 == 0) goto L48
            boolean r8 = r8.e()
            if (r8 == 0) goto L46
            goto L48
        L46:
            r8 = r4
            goto L49
        L48:
            r8 = r3
        L49:
            com.mbridge.msdk.newreward.function.c.c.d r9 = r7.f()
            if (r9 == 0) goto L58
            boolean r9 = r9.e()
            if (r9 == 0) goto L56
            goto L58
        L56:
            r9 = r4
            goto L59
        L58:
            r9 = r3
        L59:
            com.mbridge.msdk.newreward.function.c.c.d r7 = r7.c()
            if (r7 == 0) goto L68
            boolean r7 = r7.e()
            if (r7 == 0) goto L66
            goto L68
        L66:
            r7 = r4
            goto L69
        L68:
            r7 = r3
        L69:
            if (r8 == 0) goto L2d
            if (r9 == 0) goto L2d
            if (r7 == 0) goto L2d
            int r6 = r6 + 1
            goto L2d
        L72:
            if (r6 != r2) goto L76
            r2 = r3
            goto L77
        L76:
            r2 = r4
        L77:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f4682u
            if (r5 == 0) goto La8
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L82
            goto La8
        L82:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f4682u
            int r5 = r5.size()
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r6 = r10.f4682u
            java.util.Iterator r6 = r6.iterator()
            r7 = r4
        L8f:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto La4
            java.lang.Object r8 = r6.next()
            com.mbridge.msdk.newreward.function.c.a.a r8 = (com.mbridge.msdk.newreward.function.c.a.a) r8
            boolean r8 = r8.l()
            if (r8 != 0) goto L8f
            int r7 = r7 + 1
            goto L8f
        La4:
            if (r7 != r5) goto La8
            r5 = r3
            goto La9
        La8:
            r5 = r4
        La9:
            if (r0 == 0) goto Lb2
            if (r1 == 0) goto Lb2
            if (r2 == 0) goto Lb2
            if (r5 == 0) goto Lb2
            return r3
        Lb2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.c.a.b.z():boolean");
    }

    public final void a(int i10) {
        this.K = i10;
    }

    public final void b(int i10) {
        this.L = i10;
    }

    public final void c(String str) {
        this.g = str;
    }

    public final void d(String str) {
        this.f4673k = str;
    }

    public final void e(String str) {
        this.f4674l = str;
    }

    public final void f(String str) {
        this.f4675m = str;
    }

    public final void g(String str) {
        this.f4676n = str;
    }

    public final void h(String str) {
        this.A = str;
    }

    public final void i(int i10) {
        this.B = i10;
    }

    public final void j(int i10) {
        this.E = i10;
    }

    public final void k(int i10) {
        this.F = i10;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final void b(String str) {
        this.f = str;
    }

    public final void c(int i10) {
        this.f4672j = i10;
    }

    public final void d(int i10) {
        this.f4677o = i10;
    }

    public final void e(int i10) {
        this.t = i10;
    }

    public final void f(int i10) {
        this.f4685x = i10;
    }

    public final void g(int i10) {
        this.y = i10;
    }

    public final void h(int i10) {
        this.C = i10;
    }

    public final void i(String str) {
        this.I = str;
    }

    public final void a(boolean z9) {
        this.h = z9;
    }

    public final void b(long j10) {
        this.f4678p = j10;
    }

    public final void c(long j10) {
        this.f4679q = j10;
    }

    public final void d(long j10) {
        this.f4680r = j10;
    }

    public final void e(long j10) {
        this.G = j10;
    }

    public final void a(long j10) {
        this.f4671i = j10;
    }

    public final void b(List<CampaignEx> list) {
        this.D = list;
    }

    public final void a(double d8) {
        this.f4681s = d8;
    }

    public final void b(boolean z9) {
        this.J = z9;
    }

    public final void a(List<a> list) {
        this.f4682u = list;
    }

    public final void a(JSONObject jSONObject) {
        this.f4683v = jSONObject;
    }
}
