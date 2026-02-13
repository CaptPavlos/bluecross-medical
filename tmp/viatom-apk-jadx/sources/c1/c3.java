package c1;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.j8;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import j$.util.Comparator$CC;
import j$.util.Objects;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c3 extends h0 {

    /* renamed from: c, reason: collision with root package name */
    public y2 f1076c;

    /* renamed from: d, reason: collision with root package name */
    public a4.f f1077d;
    public final CopyOnWriteArraySet e;
    public boolean f;
    public final AtomicReference g;
    public final Object h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1078i;

    /* renamed from: j, reason: collision with root package name */
    public int f1079j;

    /* renamed from: k, reason: collision with root package name */
    public p2 f1080k;

    /* renamed from: l, reason: collision with root package name */
    public p2 f1081l;

    /* renamed from: m, reason: collision with root package name */
    public PriorityQueue f1082m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1083n;

    /* renamed from: o, reason: collision with root package name */
    public k2 f1084o;

    /* renamed from: p, reason: collision with root package name */
    public final AtomicLong f1085p;

    /* renamed from: q, reason: collision with root package name */
    public long f1086q;

    /* renamed from: r, reason: collision with root package name */
    public final t1 f1087r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1088s;
    public p2 t;

    /* renamed from: u, reason: collision with root package name */
    public b3 f1089u;

    /* renamed from: v, reason: collision with root package name */
    public p2 f1090v;

    /* renamed from: w, reason: collision with root package name */
    public final y2.c f1091w;

    public c3(u1 u1Var) {
        super(u1Var);
        this.e = new CopyOnWriteArraySet();
        this.h = new Object();
        this.f1078i = false;
        this.f1079j = 1;
        this.f1088s = true;
        this.f1091w = new y2.c(this, 6);
        this.g = new AtomicReference();
        this.f1084o = k2.f1301c;
        this.f1086q = -1L;
        this.f1085p = new AtomicLong(0L);
        this.f1087r = new t1(u1Var);
    }

    public final void A(Bundle bundle, int i10, long j10) {
        Boolean bool;
        String string;
        h2 h2Var;
        h();
        k2 k2Var = k2.f1301c;
        j2[] j2VarArr = i2.STORAGE.f1273a;
        int length = j2VarArr.length;
        int i11 = 0;
        while (true) {
            bool = null;
            if (i11 >= length) {
                string = null;
                break;
            }
            String str = j2VarArr[i11].f1290a;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if ((string.equals("granted") ? Boolean.TRUE : string.equals("denied") ? Boolean.FALSE : null) == null) {
                    break;
                }
            }
            i11++;
        }
        u1 u1Var = this.f1149a;
        if (string != null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1542k.c(string, "Ignoring invalid consent setting");
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f1542k.b("Valid consent values are 'granted', 'denied'");
        }
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        boolean zM = r1Var.m();
        k2 k2VarB = k2.b(i10, bundle);
        Iterator it = k2VarB.f1302a.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            h2Var = h2.UNINITIALIZED;
            if (!zHasNext) {
                break;
            } else if (((h2) it.next()) != h2Var) {
                C(k2VarB, zM);
                break;
            }
        }
        p pVarC = p.c(i10, bundle);
        Iterator it2 = pVarC.e.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (((h2) it2.next()) != h2Var) {
                B(pVarC, zM);
                break;
            }
        }
        if (bundle != null) {
            int iOrdinal = k2.d(bundle.getString("ad_personalization")).ordinal();
            if (iOrdinal == 2) {
                bool = Boolean.FALSE;
            } else if (iOrdinal == 3) {
                bool = Boolean.TRUE;
            }
        }
        if (bool != null) {
            String str2 = i10 == -30 ? "tcf" : MBridgeConstans.DYNAMIC_VIEW_WX_APP;
            if (zM) {
                r(j10, bool.toString(), str2, "allow_personalized_ads");
            } else {
                q(str2, "allow_personalized_ads", bool.toString(), false, j10);
            }
        }
    }

    public final void B(p pVar, boolean z9) {
        k1.a aVar = new k1.a(this, pVar, 7, false);
        if (z9) {
            g();
            aVar.run();
        } else {
            r1 r1Var = this.f1149a.g;
            u1.m(r1Var);
            r1Var.p(aVar);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:70:0x010c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final void C(c1.k2 r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.c3.C(c1.k2, boolean):void");
    }

    public final void D() {
        j8.a();
        u1 u1Var = this.f1149a;
        g gVar = u1Var.f1478d;
        r1 r1Var = u1Var.g;
        w0 w0Var = u1Var.f;
        if (gVar.q(null, f0.R0)) {
            u1.m(r1Var);
            if (r1Var.m()) {
                u1.m(w0Var);
                w0Var.f.b("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (o2.e.c()) {
                u1.m(w0Var);
                w0Var.f.b("Cannot get trigger URIs from main thread");
                return;
            }
            h();
            u1.m(w0Var);
            w0Var.f1545n.b("Getting trigger URIs (FE)");
            AtomicReference atomicReference = new AtomicReference();
            u1.m(r1Var);
            r1Var.q(atomicReference, WorkRequest.MIN_BACKOFF_MILLIS, "get trigger URIs", new v2(this, atomicReference, 5, false));
            final List list = (List) atomicReference.get();
            if (list == null) {
                u1.m(w0Var);
                w0Var.h.b("Timed out waiting for get trigger URIs");
            } else {
                u1.m(r1Var);
                r1Var.p(new Runnable() { // from class: c1.z2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c3 c3Var = this.f1624a;
                        c3Var.g();
                        if (Build.VERSION.SDK_INT < 30) {
                            return;
                        }
                        h1 h1Var = c3Var.f1149a.e;
                        u1.k(h1Var);
                        SparseArray sparseArrayM = h1Var.m();
                        for (k4 k4Var : list) {
                            int i10 = k4Var.f1310c;
                            if (!sparseArrayM.contains(i10) || ((Long) sparseArrayM.get(i10)).longValue() < k4Var.f1309b) {
                                c3Var.E().add(k4Var);
                            }
                        }
                        c3Var.F();
                    }
                });
            }
        }
    }

    public final PriorityQueue E() {
        if (this.f1082m == null) {
            this.f1082m = new PriorityQueue(Comparator$CC.comparing(a3.f1009a, a9.i.f348b));
        }
        return this.f1082m;
    }

    public final void F() {
        k4 k4Var;
        g();
        this.f1083n = false;
        if (E().isEmpty() || this.f1078i || (k4Var = (k4) E().poll()) == null) {
            return;
        }
        u1 u1Var = this.f1149a;
        b5 b5Var = u1Var.f1479i;
        u1.k(b5Var);
        if (b5Var.f == null) {
            b5Var.f = MeasurementManagerFutures.from(b5Var.f1149a.f1475a);
        }
        MeasurementManagerFutures measurementManagerFutures = b5Var.f;
        if (measurementManagerFutures != null) {
            this.f1078i = true;
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            u0 u0Var = w0Var.f1545n;
            String str = k4Var.f1308a;
            u0Var.c(str, "Registering trigger URI");
            k1.b bVarRegisterTriggerAsync = measurementManagerFutures.registerTriggerAsync(Uri.parse(str));
            if (bVarRegisterTriggerAsync != null) {
                bVarRegisterTriggerAsync.addListener(new k1.a(0, bVarRegisterTriggerAsync, new a4.f(4, this, k4Var)), new q2(this, 0));
            } else {
                this.f1078i = false;
                E().add(k4Var);
            }
        }
    }

    @Override // c1.h0
    public final boolean j() {
        return false;
    }

    public final void k(k2 k2Var) {
        g();
        boolean z9 = (k2Var.i(j2.ANALYTICS_STORAGE) && k2Var.i(j2.AD_STORAGE)) || this.f1149a.p().p();
        u1 u1Var = this.f1149a;
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        r1Var.g();
        if (z9 != u1Var.f1494z) {
            r1 r1Var2 = u1Var.g;
            u1.m(r1Var2);
            r1Var2.g();
            u1Var.f1494z = z9;
            h1 h1Var = this.f1149a.e;
            u1.k(h1Var);
            h1Var.g();
            Boolean boolValueOf = h1Var.k().contains("measurement_enabled_from_api") ? Boolean.valueOf(h1Var.k().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z9 || boolValueOf == null || boolValueOf.booleanValue()) {
                x(Boolean.valueOf(z9), false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r4 > 500) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
    
        if (r6 > 500) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(java.lang.String r13, java.lang.String r14, android.os.Bundle r15, boolean r16, boolean r17, long r18) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.c3.l(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void m() {
        w0 w0Var;
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        h4 h4Var;
        h4 h4Var2;
        c3 c3Var;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        String str2;
        com.google.android.gms.internal.measurement.t4 t4Var;
        j1.n nVarA;
        g();
        u1 u1Var = this.f1149a;
        w0 w0Var2 = u1Var.f;
        n0.a aVar = u1Var.f1481k;
        u1.m(w0Var2);
        w0Var2.f1544m.b("Handle tcf update.");
        h1 h1Var = u1Var.e;
        u1.k(h1Var);
        SharedPreferences sharedPreferencesL = h1Var.l();
        HashMap map = new HashMap();
        e0 e0Var = f0.f1156a1;
        int i21 = 2;
        int i22 = 1;
        if (((Boolean) e0Var.a(null)).booleanValue()) {
            j1.i iVar = j4.f1295a;
            com.google.android.gms.internal.measurement.s4 s4Var = com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            w0Var = w0Var2;
            i4 i4Var = i4.f1278a;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(s4Var, i4Var);
            com.google.android.gms.internal.measurement.s4 s4Var2 = com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            i4 i4Var2 = i4.f1279b;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(s4Var2, i4Var2);
            com.google.android.gms.internal.measurement.s4 s4Var3 = com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry3 = new AbstractMap.SimpleImmutableEntry(s4Var3, i4Var);
            com.google.android.gms.internal.measurement.s4 s4Var4 = com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry4 = new AbstractMap.SimpleImmutableEntry(s4Var4, i4Var);
            com.google.android.gms.internal.measurement.s4 s4Var5 = com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
            List listAsList = Arrays.asList(simpleImmutableEntry, simpleImmutableEntry2, simpleImmutableEntry3, simpleImmutableEntry4, new AbstractMap.SimpleImmutableEntry(s4Var5, i4Var2), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, i4Var2), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, i4Var2));
            a6.o oVar = new a6.o(listAsList instanceof Collection ? listAsList.size() : 4);
            oVar.g(listAsList);
            j1.n nVarA2 = oVar.a();
            int i23 = j1.g.f9893c;
            j1.p pVar = new j1.p("CH");
            char[] cArr = new char[5];
            boolean zContains = sharedPreferencesL.contains("IABTCF_TCString");
            try {
                i14 = sharedPreferencesL.getInt("IABTCF_CmpSdkID", -1);
            } catch (ClassCastException unused) {
                i14 = -1;
            }
            try {
                i15 = sharedPreferencesL.getInt("IABTCF_PolicyVersion", -1);
            } catch (ClassCastException unused2) {
                i15 = -1;
            }
            try {
                i16 = sharedPreferencesL.getInt("IABTCF_gdprApplies", -1);
            } catch (ClassCastException unused3) {
                i16 = -1;
            }
            int i24 = i15;
            try {
                i17 = sharedPreferencesL.getInt("IABTCF_PurposeOneTreatment", -1);
            } catch (ClassCastException unused4) {
                i17 = -1;
            }
            try {
                i18 = sharedPreferencesL.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
            } catch (ClassCastException unused5) {
                i18 = -1;
            }
            String strA = j4.a(sharedPreferencesL, "IABTCF_PublisherCC");
            int i25 = i14;
            a6.o oVar2 = new a6.o(4);
            j1.l lVar = nVarA2.f9891b;
            if (lVar == null) {
                str2 = strA;
                i19 = i17;
                i20 = i18;
                j1.l lVar2 = new j1.l(nVarA2, new j1.m(nVarA2.e, 0, nVarA2.f));
                nVarA2.f9891b = lVar2;
                lVar = lVar2;
            } else {
                i19 = i17;
                i20 = i18;
                str2 = strA;
            }
            j1.q qVarM = lVar.iterator();
            while (true) {
                boolean zHasNext = qVarM.hasNext();
                t4Var = com.google.android.gms.internal.measurement.t4.PURPOSE_RESTRICTION_UNDEFINED;
                if (!zHasNext) {
                    break;
                }
                com.google.android.gms.internal.measurement.s4 s4Var6 = (com.google.android.gms.internal.measurement.s4) qVarM.next();
                int iA = s4Var6.a();
                j1.q qVar = qVarM;
                j1.n nVar = nVarA2;
                StringBuilder sb = new StringBuilder(String.valueOf(iA).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(iA);
                String strA2 = j4.a(sharedPreferencesL, sb.toString());
                if (!TextUtils.isEmpty(strA2) && strA2.length() >= 755) {
                    int iDigit = Character.digit(strA2.charAt(754), 10);
                    com.google.android.gms.internal.measurement.t4 t4Var2 = com.google.android.gms.internal.measurement.t4.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    if (iDigit < 0 || iDigit > com.google.android.gms.internal.measurement.t4.values().length || iDigit == 0) {
                        t4Var = t4Var2;
                    } else if (iDigit == i22) {
                        t4Var = com.google.android.gms.internal.measurement.t4.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    } else if (iDigit == i21) {
                        t4Var = com.google.android.gms.internal.measurement.t4.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                    }
                }
                oVar2.e(s4Var6, t4Var);
                qVarM = qVar;
                nVarA2 = nVar;
                i21 = 2;
                i22 = 1;
            }
            j1.n nVar2 = nVarA2;
            j1.n nVarA3 = oVar2.a();
            String strA3 = j4.a(sharedPreferencesL, "IABTCF_PurposeConsents");
            String strA4 = j4.a(sharedPreferencesL, "IABTCF_VendorConsents");
            boolean z9 = !TextUtils.isEmpty(strA4) && strA4.length() >= 755 && strA4.charAt(754) == '1';
            String strA5 = j4.a(sharedPreferencesL, "IABTCF_PurposeLegitimateInterests");
            String strA6 = j4.a(sharedPreferencesL, "IABTCF_VendorLegitimateInterests");
            boolean z10 = !TextUtils.isEmpty(strA6) && strA6.length() >= 755 && strA6.charAt(754) == '1';
            cArr[0] = '2';
            if (zContains) {
                com.google.android.gms.internal.measurement.t4 t4Var3 = (com.google.android.gms.internal.measurement.t4) nVarA3.get(s4Var);
                com.google.android.gms.internal.measurement.t4 t4Var4 = (com.google.android.gms.internal.measurement.t4) nVarA3.get(s4Var3);
                com.google.android.gms.internal.measurement.t4 t4Var5 = (com.google.android.gms.internal.measurement.t4) nVarA3.get(s4Var4);
                com.google.android.gms.internal.measurement.t4 t4Var6 = (com.google.android.gms.internal.measurement.t4) nVarA3.get(s4Var5);
                a6.o oVar3 = new a6.o(4);
                oVar3.e("Version", "2");
                boolean z11 = z9;
                oVar3.e("VendorConsent", true != z9 ? "0" : "1");
                boolean z12 = z10;
                oVar3.e("VendorLegitimateInterest", true != z10 ? "0" : "1");
                oVar3.e("gdprApplies", i16 != 1 ? "0" : "1");
                int i26 = i20;
                oVar3.e("EnableAdvertiserConsentMode", i26 != 1 ? "0" : "1");
                oVar3.e("PolicyVersion", String.valueOf(i24));
                oVar3.e("CmpSdkID", String.valueOf(i25));
                int i27 = i19;
                oVar3.e("PurposeOneTreatment", i27 != 1 ? "0" : "1");
                String str3 = str2;
                oVar3.e("PublisherCC", str3);
                oVar3.e("PublisherRestrictions1", String.valueOf(t4Var3 != null ? t4Var3.a() : t4Var.a()));
                oVar3.e("PublisherRestrictions3", String.valueOf(t4Var4 != null ? t4Var4.a() : t4Var.a()));
                oVar3.e("PublisherRestrictions4", String.valueOf(t4Var5 != null ? t4Var5.a() : t4Var.a()));
                oVar3.e("PublisherRestrictions7", String.valueOf(t4Var6 != null ? t4Var6.a() : t4Var.a()));
                oVar3.g(j1.n.a(4, new Object[]{"Purpose1", j4.d(s4Var, strA3, strA5), "Purpose3", j4.d(s4Var3, strA3, strA5), "Purpose4", j4.d(s4Var4, strA3, strA5), "Purpose7", j4.d(s4Var5, strA3, strA5)}, null).entrySet());
                int i28 = i16;
                oVar3.g(j1.n.a(5, new Object[]{"AuthorizePurpose1", true != j4.b(s4Var, nVar2, nVarA3, pVar, cArr, i26, i28, i27, str3, strA3, strA5, z11, z12) ? "0" : "1", "AuthorizePurpose3", true != j4.b(s4Var3, nVar2, nVarA3, pVar, cArr, i26, i28, i27, str3, strA3, strA5, z11, z12) ? "0" : "1", "AuthorizePurpose4", true != j4.b(s4Var4, nVar2, nVarA3, pVar, cArr, i26, i28, i27, str3, strA3, strA5, z11, z12) ? "0" : "1", "AuthorizePurpose7", true != j4.b(s4Var5, nVar2, nVarA3, pVar, cArr, i26, i28, i27, str3, strA3, strA5, z11, z12) ? "0" : "1", "PurposeDiagnostics", new String(cArr)}, null).entrySet());
                nVarA = oVar3.a();
            } else {
                nVarA = j1.n.g;
            }
            h4Var = new h4(nVarA);
            str = "";
        } else {
            w0Var = w0Var2;
            String strA7 = j4.a(sharedPreferencesL, "IABTCF_VendorConsents");
            str = "";
            if (!str.equals(strA7) && strA7.length() > 754) {
                map.put("GoogleConsent", String.valueOf(strA7.charAt(754)));
            }
            try {
                i10 = sharedPreferencesL.getInt("IABTCF_gdprApplies", -1);
            } catch (ClassCastException unused6) {
                i10 = -1;
            }
            if (i10 != -1) {
                map.put("gdprApplies", String.valueOf(i10));
            }
            try {
                i11 = sharedPreferencesL.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
            } catch (ClassCastException unused7) {
                i11 = -1;
            }
            if (i11 != -1) {
                map.put("EnableAdvertiserConsentMode", String.valueOf(i11));
            }
            try {
                i12 = sharedPreferencesL.getInt("IABTCF_PolicyVersion", -1);
            } catch (ClassCastException unused8) {
                i12 = -1;
            }
            if (i12 != -1) {
                map.put("PolicyVersion", String.valueOf(i12));
            }
            String strA8 = j4.a(sharedPreferencesL, "IABTCF_PurposeConsents");
            if (!str.equals(strA8)) {
                map.put("PurposeConsents", strA8);
            }
            try {
                i13 = sharedPreferencesL.getInt("IABTCF_CmpSdkID", -1);
            } catch (ClassCastException unused9) {
                i13 = -1;
            }
            if (i13 != -1) {
                map.put("CmpSdkID", String.valueOf(i13));
            }
            h4Var = new h4(map);
        }
        u1.m(w0Var);
        w0 w0Var3 = w0Var;
        u0 u0Var = w0Var3.f1545n;
        u0Var.c(h4Var, "Tcf preferences read");
        if (!u1Var.f1478d.q(null, e0Var)) {
            if (h1Var.o(h4Var)) {
                Bundle bundleB = h4Var.b();
                u1.m(w0Var3);
                u0Var.c(bundleB, "Consent generated from Tcf");
                if (bundleB != Bundle.EMPTY) {
                    aVar.getClass();
                    A(bundleB, -30, System.currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", h4Var.c());
                n("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        h1Var.g();
        String string = h1Var.k().getString("stored_tcf_param", str);
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            h4Var2 = new h4(map2);
        } else {
            for (String str4 : string.split(";")) {
                String[] strArrSplit = str4.split("=");
                if (strArrSplit.length >= 2 && j4.f1295a.contains(strArrSplit[0])) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            h4Var2 = new h4(map2);
        }
        if (h1Var.o(h4Var)) {
            Bundle bundleB2 = h4Var.b();
            u1.m(w0Var3);
            u0Var.c(bundleB2, "Consent generated from Tcf");
            if (bundleB2 != Bundle.EMPTY) {
                aVar.getClass();
                c3Var = this;
                c3Var.A(bundleB2, -30, System.currentTimeMillis());
            } else {
                c3Var = this;
            }
            Bundle bundle2 = new Bundle();
            HashMap map3 = h4Var2.f1266a;
            String str5 = (map3.isEmpty() || ((String) map3.get("Version")) != null) ? "0" : "1";
            Bundle bundleB3 = h4Var.b();
            Bundle bundleB4 = h4Var2.b();
            bundle2.putString("_tcfm", str5.concat((bundleB3.size() == bundleB4.size() && Objects.equals(bundleB3.getString("ad_storage"), bundleB4.getString("ad_storage")) && Objects.equals(bundleB3.getString("ad_personalization"), bundleB4.getString("ad_personalization")) && Objects.equals(bundleB3.getString("ad_user_data"), bundleB4.getString("ad_user_data"))) ? "0" : "1"));
            String str6 = (String) h4Var.f1266a.get("PurposeDiagnostics");
            if (TextUtils.isEmpty(str6)) {
                str6 = "200000";
            }
            bundle2.putString("_tcfd2", str6);
            bundle2.putString("_tcfd", h4Var.c());
            c3Var.n("auto", "_tcf", bundle2);
        }
    }

    public final void n(String str, String str2, Bundle bundle) {
        g();
        this.f1149a.f1481k.getClass();
        o(System.currentTimeMillis(), bundle, str, str2);
    }

    public final void o(long j10, Bundle bundle, String str, String str2) {
        g();
        boolean z9 = true;
        if (this.f1077d != null && !b5.F(str2)) {
            z9 = false;
        }
        p(str, str2, j10, bundle, true, z9, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fb  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(java.lang.String r32, java.lang.String r33, long r34, android.os.Bundle r36, boolean r37, boolean r38, boolean r39) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.c3.p(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(java.lang.String r12, java.lang.String r13, java.lang.Object r14, boolean r15, long r16) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.c3.q(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(long r20, java.lang.Object r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.c3.r(long, java.lang.Object, java.lang.String, java.lang.String):void");
    }

    public final void s() {
        g();
        h();
        u1 u1Var = this.f1149a;
        if (u1Var.h()) {
            g gVar = u1Var.f1478d;
            gVar.f1149a.getClass();
            Boolean boolS = gVar.s("google_analytics_deferred_deep_link_enabled");
            if (boolS != null && boolS.booleanValue()) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1544m.b("Deferred Deep Link feature enabled.");
                r1 r1Var = u1Var.g;
                u1.m(r1Var);
                r1Var.p(new o2(this, 2));
            }
            x3 x3VarP = u1Var.p();
            x3VarP.g();
            x3VarP.h();
            d5 d5VarW = x3VarP.w(true);
            x3VarP.s();
            u1 u1Var2 = x3VarP.f1149a;
            u1Var2.f1478d.q(null, f0.f1161c1);
            u1Var2.o().n(3, new byte[0]);
            x3VarP.u(new s3(x3VarP, d5VarW, 1));
            this.f1088s = false;
            h1 h1Var = u1Var.e;
            u1.k(h1Var);
            h1Var.g();
            String string = h1Var.k().getString("previous_os_version", null);
            h1Var.f1149a.q().i();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = h1Var.k().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            u1Var.q().i();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            n("auto", "_ou", bundle);
        }
    }

    public final void t(Bundle bundle, long j10) {
        i0.y.g(bundle);
        Bundle bundle2 = new Bundle(bundle);
        boolean zIsEmpty = TextUtils.isEmpty(bundle2.getString(MBridgeConstans.APP_ID));
        u1 u1Var = this.f1149a;
        if (!zIsEmpty) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1540i.b("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(MBridgeConstans.APP_ID);
        l2.e(bundle2, MBridgeConstans.APP_ID, String.class, null);
        l2.e(bundle2, TtmlNode.ATTR_TTS_ORIGIN, String.class, null);
        l2.e(bundle2, RewardPlus.NAME, String.class, null);
        l2.e(bundle2, "value", Object.class, null);
        l2.e(bundle2, "trigger_event_name", String.class, null);
        l2.e(bundle2, "trigger_timeout", Long.class, 0L);
        l2.e(bundle2, "timed_out_event_name", String.class, null);
        l2.e(bundle2, "timed_out_event_params", Bundle.class, null);
        l2.e(bundle2, "triggered_event_name", String.class, null);
        l2.e(bundle2, "triggered_event_params", Bundle.class, null);
        l2.e(bundle2, "time_to_live", Long.class, 0L);
        l2.e(bundle2, "expired_event_name", String.class, null);
        l2.e(bundle2, "expired_event_params", Bundle.class, null);
        i0.y.d(bundle2.getString(RewardPlus.NAME));
        i0.y.d(bundle2.getString(TtmlNode.ATTR_TTS_ORIGIN));
        i0.y.g(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j10);
        String string = bundle2.getString(RewardPlus.NAME);
        Object obj = bundle2.get("value");
        b5 b5Var = u1Var.f1479i;
        q0 q0Var = u1Var.f1480j;
        w0 w0Var2 = u1Var.f;
        u1.k(b5Var);
        if (b5Var.m0(string) != 0) {
            u1.m(w0Var2);
            w0Var2.f.c(q0Var.c(string), "Invalid conditional user property name");
            return;
        }
        u1.k(b5Var);
        if (b5Var.t(obj, string) != 0) {
            u1.m(w0Var2);
            w0Var2.f.d(q0Var.c(string), "Invalid conditional user property value", obj);
            return;
        }
        Object objU = b5Var.u(obj, string);
        if (objU == null) {
            u1.m(w0Var2);
            w0Var2.f.d(q0Var.c(string), "Unable to normalize conditional user property value", obj);
            return;
        }
        l2.c(bundle2, objU);
        long j11 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j11 > 15552000000L || j11 < 1)) {
            u1.m(w0Var2);
            w0Var2.f.d(q0Var.c(string), "Invalid conditional user property timeout", Long.valueOf(j11));
            return;
        }
        long j12 = bundle2.getLong("time_to_live");
        if (j12 > 15552000000L || j12 < 1) {
            u1.m(w0Var2);
            w0Var2.f.d(q0Var.c(string), "Invalid conditional user property time to live", Long.valueOf(j12));
        } else {
            r1 r1Var = u1Var.g;
            u1.m(r1Var);
            r1Var.p(new w2(this, bundle2, 0));
        }
    }

    public final void u(String str, String str2, Bundle bundle) {
        u1 u1Var = this.f1149a;
        u1Var.f1481k.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        i0.y.d(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(RewardPlus.NAME, str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        r1Var.p(new w2(this, bundle2, 1));
    }

    public final String v() {
        u1 u1Var = this.f1149a;
        try {
            return l2.b(u1Var.f1475a, u1Var.f1486p);
        } catch (IllegalStateException e) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.c(e, "getGoogleAppId failed with exception");
            return null;
        }
    }

    public final void w(k2 k2Var, long j10, boolean z9) {
        int i10 = k2Var.f1303b;
        g();
        h();
        u1 u1Var = this.f1149a;
        h1 h1Var = u1Var.e;
        w0 w0Var = u1Var.f;
        u1.k(h1Var);
        k2 k2VarN = h1Var.n();
        if (j10 <= this.f1086q && k2.l(k2VarN.f1303b, i10)) {
            u1.m(w0Var);
            w0Var.f1543l.c(k2Var, "Dropped out-of-date consent setting, proposed settings");
            return;
        }
        h1 h1Var2 = u1Var.e;
        u1.k(h1Var2);
        h1Var2.g();
        if (!k2.l(i10, h1Var2.k().getInt("consent_source", 100))) {
            u1.m(w0Var);
            w0Var.f1543l.c(Integer.valueOf(i10), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = h1Var2.k().edit();
        editorEdit.putString("consent_settings", k2Var.g());
        editorEdit.putInt("consent_source", i10);
        editorEdit.apply();
        u1.m(w0Var);
        w0Var.f1545n.c(k2Var, "Setting storage consent(FE)");
        this.f1086q = j10;
        if (u1Var.p().q()) {
            x3 x3VarP = u1Var.p();
            x3VarP.g();
            x3VarP.h();
            x3VarP.u(new v3(x3VarP, 2));
        } else {
            x3 x3VarP2 = u1Var.p();
            x3VarP2.g();
            x3VarP2.h();
            if (x3VarP2.p()) {
                x3VarP2.u(new s3(x3VarP2, x3VarP2.w(false)));
            }
        }
        if (z9) {
            u1Var.p().k(new AtomicReference());
        }
    }

    public final void x(Boolean bool, boolean z9) {
        g();
        h();
        u1 u1Var = this.f1149a;
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        w0Var.f1544m.c(bool, "Setting app measurement enabled (FE)");
        h1 h1Var = u1Var.e;
        u1.k(h1Var);
        h1Var.g();
        SharedPreferences.Editor editorEdit = h1Var.k().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
        if (z9) {
            h1Var.g();
            SharedPreferences.Editor editorEdit2 = h1Var.k().edit();
            if (bool != null) {
                editorEdit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit2.remove("measurement_enabled_from_api");
            }
            editorEdit2.apply();
        }
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        r1Var.g();
        if (u1Var.f1494z || !(bool == null || bool.booleanValue())) {
            y();
        }
    }

    public final void y() {
        g();
        u1 u1Var = this.f1149a;
        h1 h1Var = u1Var.e;
        w0 w0Var = u1Var.f;
        n0.a aVar = u1Var.f1481k;
        u1.k(h1Var);
        String strN = h1Var.f1250m.n();
        if (strN != null) {
            if ("unset".equals(strN)) {
                aVar.getClass();
                r(System.currentTimeMillis(), null, MBridgeConstans.DYNAMIC_VIEW_WX_APP, "_npa");
            } else {
                Long lValueOf = Long.valueOf(true != "true".equals(strN) ? 0L : 1L);
                aVar.getClass();
                r(System.currentTimeMillis(), lValueOf, MBridgeConstans.DYNAMIC_VIEW_WX_APP, "_npa");
            }
        }
        if (!u1Var.d() || !this.f1088s) {
            u1.m(w0Var);
            w0Var.f1544m.b("Updating Scion state (FE)");
            x3 x3VarP = u1Var.p();
            x3VarP.g();
            x3VarP.h();
            x3VarP.u(new s3(x3VarP, x3VarP.w(true), 3));
            return;
        }
        u1.m(w0Var);
        w0Var.f1544m.b("Recording app launch after enabling measurement for the first time (FE)");
        s();
        g4 g4Var = u1Var.h;
        u1.l(g4Var);
        g4Var.e.C();
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        r1Var.p(new o2(this, 1));
    }

    public final void z() {
        u1 u1Var = this.f1149a;
        if (!(u1Var.f1475a.getApplicationContext() instanceof Application) || this.f1076c == null) {
            return;
        }
        ((Application) u1Var.f1475a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f1076c);
    }
}
