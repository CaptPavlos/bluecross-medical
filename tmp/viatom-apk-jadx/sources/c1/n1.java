package c1;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.c6;
import com.google.android.gms.internal.measurement.w5;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n1 extends q4 implements f {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayMap f1356d;
    public final ArrayMap e;
    public final ArrayMap f;
    public final ArrayMap g;
    public final ArrayMap h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayMap f1357i;

    /* renamed from: j, reason: collision with root package name */
    public final k1 f1358j;

    /* renamed from: k, reason: collision with root package name */
    public final d0.i f1359k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayMap f1360l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayMap f1361m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayMap f1362n;

    public n1(v4 v4Var) {
        super(v4Var);
        this.f1356d = new ArrayMap();
        this.e = new ArrayMap();
        this.f = new ArrayMap();
        this.g = new ArrayMap();
        this.h = new ArrayMap();
        this.f1360l = new ArrayMap();
        this.f1361m = new ArrayMap();
        this.f1362n = new ArrayMap();
        this.f1357i = new ArrayMap();
        this.f1358j = new k1(this);
        this.f1359k = new d0.i(this, 5);
    }

    public static final ArrayMap q(com.google.android.gms.internal.measurement.g2 g2Var) {
        ArrayMap arrayMap = new ArrayMap();
        for (com.google.android.gms.internal.measurement.k2 k2Var : g2Var.t()) {
            arrayMap.put(k2Var.p(), k2Var.q());
        }
        return arrayMap;
    }

    public static final j2 r(int i10) {
        int i11 = i10 - 1;
        if (i11 == 1) {
            return j2.AD_STORAGE;
        }
        if (i11 == 2) {
            return j2.ANALYTICS_STORAGE;
        }
        if (i11 == 3) {
            return j2.AD_USER_DATA;
        }
        if (i11 != 4) {
            return null;
        }
        return j2.AD_PERSONALIZATION;
    }

    public final boolean A(String str, j2 j2Var) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.b2 b2VarB = B(str);
        if (b2VarB == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.y1 y1Var : b2VarB.p()) {
            if (j2Var == r(y1Var.p())) {
                return y1Var.q() == 2;
            }
        }
        return false;
    }

    public final com.google.android.gms.internal.measurement.b2 B(String str) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.g2 g2VarS = s(str);
        if (g2VarS == null || !g2VarS.B()) {
            return null;
        }
        return g2VarS.C();
    }

    @Override // c1.f
    public final String d(String str, String str2) {
        g();
        m(str);
        Map map = (Map) this.f1356d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final h2 k(String str, j2 j2Var) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.b2 b2VarB = B(str);
        if (b2VarB != null) {
            Iterator it = b2VarB.u().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.google.android.gms.internal.measurement.y1 y1Var = (com.google.android.gms.internal.measurement.y1) it.next();
                if (r(y1Var.p()) == j2Var) {
                    int iQ = y1Var.q() - 1;
                    if (iQ == 1) {
                        return h2.GRANTED;
                    }
                    if (iQ == 2) {
                        return h2.DENIED;
                    }
                }
            }
        }
        return h2.UNINITIALIZED;
    }

    public final boolean l(String str) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.b2 b2VarB = B(str);
        if (b2VarB == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.y1 y1Var : b2VarB.p()) {
            if (y1Var.p() == 3 && y1Var.r() == 3) {
                return true;
            }
        }
        return false;
    }

    public final void m(String str) {
        h();
        g();
        i0.y.d(str);
        ArrayMap arrayMap = this.h;
        if (arrayMap.get(str) == 0) {
            n nVar = this.f1335b.f1520c;
            v4.U(nVar);
            a3.x xVarM0 = nVar.m0(str);
            ArrayMap arrayMap2 = this.f1362n;
            ArrayMap arrayMap3 = this.f1361m;
            ArrayMap arrayMap4 = this.f1360l;
            ArrayMap arrayMap5 = this.f1356d;
            if (xVarM0 != null) {
                com.google.android.gms.internal.measurement.f2 f2Var = (com.google.android.gms.internal.measurement.f2) p(str, (byte[]) xVarM0.f181b).i();
                n(str, f2Var);
                arrayMap5.put(str, q((com.google.android.gms.internal.measurement.g2) f2Var.d()));
                arrayMap.put(str, (com.google.android.gms.internal.measurement.g2) f2Var.d());
                o(str, (com.google.android.gms.internal.measurement.g2) f2Var.d());
                arrayMap4.put(str, ((com.google.android.gms.internal.measurement.g2) f2Var.f2102b).A());
                arrayMap3.put(str, (String) xVarM0.f182c);
                arrayMap2.put(str, (String) xVarM0.f183d);
                return;
            }
            arrayMap5.put(str, null);
            this.f.put(str, null);
            this.e.put(str, null);
            this.g.put(str, null);
            arrayMap.put(str, null);
            arrayMap4.put(str, null);
            arrayMap3.put(str, null);
            arrayMap2.put(str, null);
            this.f1357i.put(str, null);
        }
    }

    public final void n(String str, com.google.android.gms.internal.measurement.f2 f2Var) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = DesugarCollections.unmodifiableList(((com.google.android.gms.internal.measurement.g2) f2Var.f2102b).z()).iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.c2) it.next()).p());
        }
        for (int i10 = 0; i10 < ((com.google.android.gms.internal.measurement.g2) f2Var.f2102b).u(); i10++) {
            com.google.android.gms.internal.measurement.d2 d2Var = (com.google.android.gms.internal.measurement.d2) ((com.google.android.gms.internal.measurement.g2) f2Var.f2102b).v(i10).i();
            boolean zIsEmpty = d2Var.g().isEmpty();
            u1 u1Var = this.f1149a;
            if (zIsEmpty) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1540i.b("EventConfig contained null event name");
            } else {
                String strG = d2Var.g();
                String strG2 = l2.g(d2Var.g(), l2.f1317a, l2.f1319c);
                if (!TextUtils.isEmpty(strG2)) {
                    d2Var.b();
                    ((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).w(strG2);
                    f2Var.b();
                    ((com.google.android.gms.internal.measurement.g2) f2Var.f2102b).H(i10, (com.google.android.gms.internal.measurement.e2) d2Var.d());
                }
                if (((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).q() && ((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).r()) {
                    arrayMap.put(strG, Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).s() && ((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).t()) {
                    arrayMap2.put(d2Var.g(), Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).u()) {
                    if (((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).v() < 2 || ((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).v() > 65535) {
                        w0 w0Var2 = u1Var.f;
                        u1.m(w0Var2);
                        w0Var2.f1540i.d(d2Var.g(), "Invalid sampling rate. Event name, sample rate", Integer.valueOf(((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).v()));
                    } else {
                        arrayMap3.put(d2Var.g(), Integer.valueOf(((com.google.android.gms.internal.measurement.e2) d2Var.f2102b).v()));
                    }
                }
            }
        }
        this.e.put(str, hashSet);
        this.f.put(str, arrayMap);
        this.g.put(str, arrayMap2);
        this.f1357i.put(str, arrayMap3);
    }

    public final void o(String str, com.google.android.gms.internal.measurement.g2 g2Var) {
        int iY = g2Var.y();
        k1 k1Var = this.f1358j;
        if (iY == 0) {
            k1Var.remove(str);
            return;
        }
        u1 u1Var = this.f1149a;
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        w0Var.f1545n.c(Integer.valueOf(g2Var.y()), "EES programs found");
        com.google.android.gms.internal.measurement.w3 w3Var = (com.google.android.gms.internal.measurement.w3) g2Var.x().get(0);
        try {
            com.google.android.gms.internal.measurement.e0 e0Var = new com.google.android.gms.internal.measurement.e0();
            w2.r rVar = e0Var.f1928a;
            ((HashMap) ((c6) rVar.e).f1904a).put("internal.remoteConfig", new l1(this, str, 2));
            ((HashMap) ((c6) rVar.e).f1904a).put("internal.appMetadata", new l1(this, str, 0));
            ((HashMap) ((c6) rVar.e).f1904a).put("internal.logger", new m1(this));
            e0Var.b(w3Var);
            k1Var.put(str, e0Var);
            u1.m(w0Var);
            u0 u0Var = w0Var.f1545n;
            u0Var.d(str, "EES program loaded for appId, activities", Integer.valueOf(w3Var.q().q()));
            for (com.google.android.gms.internal.measurement.v3 v3Var : w3Var.q().p()) {
                u1.m(w0Var);
                u0Var.c(v3Var.p(), "EES program activity");
            }
        } catch (com.google.android.gms.internal.measurement.r0 unused) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.c(str, "Failed to load EES program. appId");
        }
    }

    public final com.google.android.gms.internal.measurement.g2 p(String str, byte[] bArr) {
        u1 u1Var = this.f1149a;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.g2.G();
        }
        try {
            com.google.android.gms.internal.measurement.g2 g2Var = (com.google.android.gms.internal.measurement.g2) ((com.google.android.gms.internal.measurement.f2) a1.T(com.google.android.gms.internal.measurement.g2.F(), bArr)).d();
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1545n.d(g2Var.p() ? Long.valueOf(g2Var.q()) : null, "Parsed config. version, gmp_app_id", g2Var.r() ? g2Var.s() : null);
            return g2Var;
        } catch (w5 e) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f1540i.d(w0.o(str), "Unable to merge remote config. appId", e);
            return com.google.android.gms.internal.measurement.g2.G();
        } catch (RuntimeException e3) {
            w0 w0Var3 = u1Var.f;
            u1.m(w0Var3);
            w0Var3.f1540i.d(w0.o(str), "Unable to merge remote config. appId", e3);
            return com.google.android.gms.internal.measurement.g2.G();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.google.android.gms.internal.measurement.g2 s(String str) {
        h();
        g();
        i0.y.d(str);
        m(str);
        return (com.google.android.gms.internal.measurement.g2) this.h.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String t(String str) {
        g();
        m(str);
        return (String) this.f1360l.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x03f9, code lost:
    
        r3 = java.lang.Integer.valueOf(r6.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0402, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0403, code lost:
    
        r5.put(r0, r3);
        r28 = r0;
        r5.put("property_name", r6.r());
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0415, code lost:
    
        if (r6.v() == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0417, code lost:
    
        r3 = java.lang.Boolean.valueOf(r6.w());
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0420, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0421, code lost:
    
        r5.put("session_scoped", r3);
        r5.put(com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0433, code lost:
    
        if (r9.V().insertWithOnConflict("property_filters", null, r5, 5) != (-1)) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0435, code lost:
    
        r0 = r14.f;
        c1.u1.m(r0);
        r0.f.c(c1.w0.o(r30), "Failed to insert property filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0446, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0448, code lost:
    
        r5 = r23;
        r3 = r26;
        r0 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0450, code lost:
    
        r1 = r14.f;
        c1.u1.m(r1);
        r1.f.d(c1.w0.o(r30), "Error storing property filter. appId", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0460, code lost:
    
        r9.h();
        r9.g();
        i0.y.d(r30);
        r0 = r9.V();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r30, java.lang.String.valueOf(r7)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r30, java.lang.String.valueOf(r7)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0483, code lost:
    
        r1 = r24;
        r3 = r25;
        r0 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0262, code lost:
    
        r0 = r5.r().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x026e, code lost:
    
        if (r0.hasNext() == false) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x027a, code lost:
    
        if (((com.google.android.gms.internal.measurement.w1) r0.next()).p() != false) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x027c, code lost:
    
        r0 = r14.f;
        c1.u1.m(r0);
        r0.f1540i.d(c1.w0.o(r30), "Property filter with no ID. Audience definition ignored. appId, audienceId", java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0291, code lost:
    
        r0 = r5.u().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0299, code lost:
    
        r8 = r0.hasNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x029d, code lost:
    
        r23 = r0;
        r0 = "filter_id";
        r24 = r1;
        r25 = r3;
        r3 = com.mbridge.msdk.MBridgeConstans.APP_ID;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02af, code lost:
    
        if (r8 == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x02b1, code lost:
    
        r8 = (com.google.android.gms.internal.measurement.p1) r23.next();
        r9.h();
        r9.g();
        i0.y.d(r30);
        i0.y.g(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02cb, code lost:
    
        if (r8.r().isEmpty() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02cd, code lost:
    
        r0 = r14.f;
        c1.u1.m(r0);
        r0 = r0.f1540i;
        r3 = c1.w0.o(r30);
        r4 = java.lang.Integer.valueOf(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02e2, code lost:
    
        if (r8.p() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02e4, code lost:
    
        r5 = java.lang.Integer.valueOf(r8.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02ed, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02f2, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02f3, code lost:
    
        r0.e("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r3, r4, java.lang.String.valueOf(r5));
        r27 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02fe, code lost:
    
        r26 = r5;
        r5 = r8.a();
        r27 = r6;
        r6 = new android.content.ContentValues();
        r6.put(com.mbridge.msdk.MBridgeConstans.APP_ID, r30);
        r6.put("audience_id", java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0319, code lost:
    
        if (r8.p() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x031b, code lost:
    
        r1 = java.lang.Integer.valueOf(r8.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0324, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0325, code lost:
    
        r6.put("filter_id", r1);
        r6.put("event_name", r8.r());
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0335, code lost:
    
        if (r8.z() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0337, code lost:
    
        r0 = java.lang.Boolean.valueOf(r8.A());
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0340, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0341, code lost:
    
        r6.put("session_scoped", r0);
        r6.put(com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0353, code lost:
    
        if (r9.V().insertWithOnConflict("event_filters", null, r6, 5) != (-1)) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0355, code lost:
    
        r0 = r14.f;
        c1.u1.m(r0);
        r0.f.c(c1.w0.o(r30), "Failed to insert event filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0365, code lost:
    
        r0 = r23;
        r1 = r24;
        r3 = r25;
        r5 = r26;
        r6 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0371, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0372, code lost:
    
        r1 = r14.f;
        c1.u1.m(r1);
        r1.f.d(c1.w0.o(r30), "Error storing event filter. appId", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0384, code lost:
    
        r27 = r6;
        r5 = r5.r().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0394, code lost:
    
        if (r5.hasNext() == false) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0396, code lost:
    
        r6 = (com.google.android.gms.internal.measurement.w1) r5.next();
        r9.h();
        r9.g();
        i0.y.d(r30);
        i0.y.g(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x03b0, code lost:
    
        if (r6.r().isEmpty() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03b2, code lost:
    
        r0 = r14.f;
        c1.u1.m(r0);
        r0 = r0.f1540i;
        r3 = c1.w0.o(r30);
        r4 = java.lang.Integer.valueOf(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03c7, code lost:
    
        if (r6.p() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03c9, code lost:
    
        r5 = java.lang.Integer.valueOf(r6.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03d2, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x03d3, code lost:
    
        r0.e("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r3, r4, java.lang.String.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x03dc, code lost:
    
        r8 = r6.a();
        r23 = r5;
        r5 = new android.content.ContentValues();
        r5.put(r3, r30);
        r26 = r3;
        r5.put("audience_id", java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x03f7, code lost:
    
        if (r6.p() == false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05ec A[Catch: SQLiteException -> 0x05fd, TRY_LEAVE, TryCatch #8 {SQLiteException -> 0x05fd, blocks: (B:153:0x05d5, B:155:0x05ec), top: B:179:0x05d5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.lang.String r30, java.lang.String r31, java.lang.String r32, byte[] r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n1.u(java.lang.String, java.lang.String, java.lang.String, byte[]):void");
    }

    public final boolean v(String str, String str2) {
        Boolean bool;
        g();
        m(str);
        if ("1".equals(d(str, "measurement.upload.blacklist_internal")) && b5.F(str2)) {
            return true;
        }
        if ("1".equals(d(str, "measurement.upload.blacklist_public")) && b5.f0(str2)) {
            return true;
        }
        Map map = (Map) this.f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean w(String str, String str2) {
        Boolean bool;
        g();
        m(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int x(String str, String str2) {
        Integer num;
        g();
        m(str);
        Map map = (Map) this.f1357i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean y(String str) {
        g();
        m(str);
        ArrayMap arrayMap = this.e;
        if (arrayMap.get(str) != 0) {
            return ((Set) arrayMap.get(str)).contains("os_version") || ((Set) arrayMap.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean z(String str) {
        g();
        m(str);
        ArrayMap arrayMap = this.e;
        return arrayMap.get(str) != 0 && ((Set) arrayMap.get(str)).contains("app_instance_id");
    }

    @Override // c1.q4
    public final void j() {
    }
}
