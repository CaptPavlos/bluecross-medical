package c1;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u1 implements g2 {
    public static volatile u1 E;
    public int A;
    public int B;
    public final long D;

    /* renamed from: a, reason: collision with root package name */
    public final Context f1475a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1476b;

    /* renamed from: c, reason: collision with root package name */
    public final o2.e f1477c;

    /* renamed from: d, reason: collision with root package name */
    public final g f1478d;
    public final h1 e;
    public final w0 f;
    public final r1 g;
    public final g4 h;

    /* renamed from: i, reason: collision with root package name */
    public final b5 f1479i;

    /* renamed from: j, reason: collision with root package name */
    public final q0 f1480j;

    /* renamed from: k, reason: collision with root package name */
    public final n0.a f1481k;

    /* renamed from: l, reason: collision with root package name */
    public final n3 f1482l;

    /* renamed from: m, reason: collision with root package name */
    public final c3 f1483m;

    /* renamed from: n, reason: collision with root package name */
    public final z f1484n;

    /* renamed from: o, reason: collision with root package name */
    public final g3 f1485o;

    /* renamed from: p, reason: collision with root package name */
    public final String f1486p;

    /* renamed from: q, reason: collision with root package name */
    public p0 f1487q;

    /* renamed from: r, reason: collision with root package name */
    public x3 f1488r;

    /* renamed from: s, reason: collision with root package name */
    public q f1489s;
    public n0 t;

    /* renamed from: u, reason: collision with root package name */
    public h3 f1490u;

    /* renamed from: w, reason: collision with root package name */
    public Boolean f1492w;

    /* renamed from: x, reason: collision with root package name */
    public long f1493x;
    public volatile Boolean y;

    /* renamed from: z, reason: collision with root package name */
    public volatile boolean f1494z;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1491v = false;
    public final AtomicInteger C = new AtomicInteger(0);

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        throw r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public u1(c1.n2 r11) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.u1.<init>(c1.n2):void");
    }

    public static final void j(c0 c0Var) {
        if (c0Var != null) {
            return;
        }
        androidx.window.layout.c.g("Component not created");
    }

    public static final void k(e2 e2Var) {
        if (e2Var != null) {
            return;
        }
        androidx.window.layout.c.g("Component not created");
    }

    public static final void l(h0 h0Var) {
        if (h0Var == null) {
            androidx.window.layout.c.g("Component not created");
        } else {
            if (h0Var.f1242b) {
                return;
            }
            androidx.window.layout.c.g("Component not initialized: ".concat(String.valueOf(h0Var.getClass())));
        }
    }

    public static final void m(f2 f2Var) {
        if (f2Var == null) {
            androidx.window.layout.c.g("Component not created");
        } else {
            if (f2Var.f1213b) {
                return;
            }
            androidx.window.layout.c.g("Component not initialized: ".concat(String.valueOf(f2Var.getClass())));
        }
    }

    public static u1 s(Context context, com.google.android.gms.internal.measurement.v0 v0Var, Long l10) {
        Bundle bundle;
        if (v0Var != null) {
            Bundle bundle2 = v0Var.f2203d;
            v0Var = new com.google.android.gms.internal.measurement.v0(v0Var.f2200a, v0Var.f2201b, v0Var.f2202c, bundle2, null);
        }
        i0.y.g(context);
        i0.y.g(context.getApplicationContext());
        if (E == null) {
            synchronized (u1.class) {
                try {
                    if (E == null) {
                        E = new u1(new n2(context, v0Var, l10));
                    }
                } finally {
                }
            }
        } else if (v0Var != null && (bundle = v0Var.f2203d) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            i0.y.g(E);
            E.y = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        i0.y.g(E);
        return E;
    }

    @Override // c1.g2
    public final w0 a() {
        w0 w0Var = this.f;
        m(w0Var);
        return w0Var;
    }

    @Override // c1.g2
    public final r1 b() {
        r1 r1Var = this.g;
        m(r1Var);
        return r1Var;
    }

    @Override // c1.g2
    public final o2.e c() {
        return this.f1477c;
    }

    public final boolean d() {
        return g() == 0;
    }

    @Override // c1.g2
    public final Context e() {
        return this.f1475a;
    }

    @Override // c1.g2
    public final n0.a f() {
        return this.f1481k;
    }

    public final int g() {
        r1 r1Var = this.g;
        m(r1Var);
        r1Var.g();
        g gVar = this.f1478d;
        if (gVar.t()) {
            return 1;
        }
        m(r1Var);
        r1Var.g();
        if (!this.f1494z) {
            return 8;
        }
        h1 h1Var = this.e;
        k(h1Var);
        h1Var.g();
        Boolean boolValueOf = h1Var.k().contains("measurement_enabled") ? Boolean.valueOf(h1Var.k().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        o2.e eVar = gVar.f1149a.f1477c;
        Boolean boolS = gVar.s("firebase_analytics_collection_enabled");
        return boolS != null ? boolS.booleanValue() ? 0 : 4 : (this.y == null || this.y.booleanValue()) ? 0 : 7;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h() {
        /*
            r6 = this;
            boolean r0 = r6.f1491v
            if (r0 == 0) goto L96
            c1.r1 r0 = r6.g
            m(r0)
            r0.g()
            java.lang.Boolean r0 = r6.f1492w
            n0.a r1 = r6.f1481k
            if (r0 == 0) goto L34
            long r2 = r6.f1493x
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L34
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L8f
            r1.getClass()
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6.f1493x
            long r2 = r2 - r4
            long r2 = java.lang.Math.abs(r2)
            r4 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L8f
        L34:
            r1.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            r6.f1493x = r0
            c1.b5 r0 = r6.f1479i
            k(r0)
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r1 = r0.E(r1)
            r2 = 0
            if (r1 == 0) goto L75
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r0.E(r1)
            if (r1 == 0) goto L75
            android.content.Context r1 = r6.f1475a
            p0.b r3 = p0.c.a(r1)
            boolean r3 = r3.c()
            r4 = 1
            if (r3 != 0) goto L74
            c1.g r3 = r6.f1478d
            boolean r3 = r3.j()
            if (r3 != 0) goto L74
            boolean r3 = c1.b5.X(r1)
            if (r3 == 0) goto L75
            boolean r1 = c1.b5.z(r1)
            if (r1 == 0) goto L75
        L74:
            r2 = r4
        L75:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r6.f1492w = r1
            if (r2 == 0) goto L8f
            c1.n0 r1 = r6.r()
            java.lang.String r1 = r1.n()
            boolean r0 = r0.k(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.f1492w = r0
        L8f:
            java.lang.Boolean r0 = r6.f1492w
            boolean r0 = r0.booleanValue()
            return r0
        L96:
            java.lang.String r0 = "AppMeasurement is not initialized"
            androidx.window.layout.c.g(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.u1.h():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r20, java.lang.Throwable r21, byte[] r22) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.u1.i(int, java.lang.Throwable, byte[]):void");
    }

    public final q0 n() {
        return this.f1480j;
    }

    public final p0 o() {
        l(this.f1487q);
        return this.f1487q;
    }

    public final x3 p() {
        l(this.f1488r);
        return this.f1488r;
    }

    public final q q() {
        m(this.f1489s);
        return this.f1489s;
    }

    public final n0 r() {
        l(this.t);
        return this.t;
    }
}
