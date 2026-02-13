package com.inmobi.cmp;

import a3.x;
import a3.z0;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import b.j;
import b.k;
import b.l;
import b.o;
import b9.s;
import c1.d0;
import c1.y2;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.Regulations;
import com.inmobi.cmp.presentation.components.CmpActivity;
import d0.i;
import d6.b;
import f6.d;
import f6.m;
import i9.a;
import j.g;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r0.f;
import r7.i0;
import r7.t;
import r7.v0;
import r7.w;
import r7.y;
import w2.r;
import w6.c;
import w7.n;
import y7.e;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ChoiceCmp {

    /* renamed from: a, reason: collision with root package name */
    public static ChoiceCmpCallback f2602a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f2603b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f2604c = "";

    /* renamed from: d, reason: collision with root package name */
    public static boolean f2605d;
    public static UUID e;
    public static long f;
    public static o g;
    public static w h;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f2607j;
    public static final ChoiceCmp INSTANCE = new ChoiceCmp();

    /* renamed from: i, reason: collision with root package name */
    public static final k f2606i = new k(t.f12436a);

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f2608k = Pattern.compile("^(p-)?([a-zA-Z0-9_-]{13})$");

    /* JADX WARN: Removed duplicated region for block: B:440:0x0a31  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0aaf  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x0abf  */
    /* JADX WARN: Type inference failed for: r0v103, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v53, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v35, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r11v46, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v50, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r14v25, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r14v29, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v46, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v52, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v56, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object a(w6.c r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.a(w6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (r7.c(r0) == r5) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object access$loadCmpInfo(com.inmobi.cmp.ChoiceCmp r7, w6.c r8) throws java.lang.Throwable {
        /*
            r7.getClass()
            boolean r0 = r8 instanceof b.b
            if (r0 == 0) goto L16
            r0 = r8
            b.b r0 = (b.b) r0
            int r1 = r0.f773c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f773c = r1
            goto L1b
        L16:
            b.b r0 = new b.b
            r0.<init>(r7, r8)
        L1b:
            java.lang.Object r7 = r0.f771a
            int r8 = r0.f773c
            java.lang.String r1 = "viewModel"
            r2 = 2
            r3 = 1
            r4 = 0
            x6.a r5 = x6.a.f13718a
            if (r8 == 0) goto L3a
            if (r8 == r3) goto L36
            if (r8 != r2) goto L30
            s6.a.e(r7)
            goto L6a
        L30:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            return r4
        L36:
            s6.a.e(r7)
            goto L54
        L3a:
            s6.a.e(r7)
            b.o r7 = com.inmobi.cmp.ChoiceCmp.g
            if (r7 == 0) goto L71
            r0.f773c = r3
            y7.e r8 = r7.i0.f12407a
            y7.d r8 = y7.d.f14116a
            b.m r3 = new b.m
            r6 = 0
            r3.<init>(r7, r4, r6)
            java.lang.Object r7 = r7.y.z(r3, r8, r0)
            if (r7 != r5) goto L54
            goto L69
        L54:
            f6.f r7 = (f6.f) r7
            b.o r8 = com.inmobi.cmp.ChoiceCmp.g
            if (r8 == 0) goto L6d
            r7.getClass()
            r8.f817q = r7
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            r0.f773c = r2
            java.lang.Object r7 = r7.c(r0)
            if (r7 != r5) goto L6a
        L69:
            return r5
        L6a:
            s6.w r7 = s6.w.f12711a
            return r7
        L6d:
            kotlin.jvm.internal.l.i(r1)
            throw r4
        L71:
            kotlin.jvm.internal.l.i(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.access$loadCmpInfo(com.inmobi.cmp.ChoiceCmp, w6.c):java.lang.Object");
    }

    public static final /* synthetic */ Object access$loadDefaultValues(ChoiceCmp choiceCmp, c cVar) {
        choiceCmp.getClass();
        return a(cVar);
    }

    public static final Object access$showCMP(ChoiceCmp choiceCmp, c cVar) throws Throwable {
        choiceCmp.getClass();
        if (t1.f14361a && a.f9105a != null) {
            e eVar = i0.f12407a;
            Object objZ = y.z(new j(2, null, 0), n.f13548a.f12716c, cVar);
            if (objZ == x6.a.f13718a) {
                return objZ;
            }
        }
        return s6.w.f12711a;
    }

    public static final void access$startLoadCmpInfo(ChoiceCmp choiceCmp) {
        choiceCmp.getClass();
        w wVarA = h;
        if (wVarA == null) {
            wVarA = y.a(y.c());
        }
        h = wVarA;
        y.q(wVarA, f2606i, null, new l(2, null, 1), 2);
    }

    public static final void forceDisplayUI(Activity activity) {
        activity.getClass();
        ChoiceCmp choiceCmp = INSTANCE;
        if (!choiceCmp.isViewModelAvailable$app_release()) {
            ChoiceCmpCallback choiceCmpCallback = f2602a;
            if (choiceCmpCallback == null) {
                return;
            }
            choiceCmpCallback.onCmpError(ChoiceError.MISSING_INITIALIZATION);
            return;
        }
        o oVar = g;
        if (oVar == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        if (oVar.l()) {
            o oVar2 = g;
            if (oVar2 == null) {
                kotlin.jvm.internal.l.i("viewModel");
                throw null;
            }
            if (!oVar2.f807c.f11814b.S) {
                ChoiceCmpCallback choiceCmpCallback2 = f2602a;
                if (choiceCmpCallback2 != null) {
                    choiceCmpCallback2.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.HIDDEN, "GDPR is disabled for US", Regulations.NA, false, 8, null));
                }
                b.b(null, ChoiceError.GDPR_NA.getMessage(), null, 5);
                return;
            }
        }
        choiceCmp.a(activity, true);
    }

    public static final GDPRData getGDPRData(Set<Integer> set) {
        if (INSTANCE.isViewModelAvailable$app_release()) {
            return new GDPRData(set);
        }
        return null;
    }

    public static /* synthetic */ GDPRData getGDPRData$default(Set set, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            set = null;
        }
        return getGDPRData(set);
    }

    public static final NonIABData getNonIABData(Set<Integer> set) {
        Map<Integer, Boolean> map;
        if (!INSTANCE.isViewModelAvailable$app_release()) {
            return null;
        }
        o oVar = g;
        if (oVar == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        i iVar = oVar.f805a;
        boolean z9 = ((SharedPreferences) iVar.f6781b).getInt("IABTCF_gdprApplies", 0) == 1;
        String strT = iVar.t(34);
        Map<Integer, Boolean> map2 = oVar.f806b.A.getMap();
        if (set == null) {
            map = map2;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, Boolean> entry : map2.entrySet()) {
                if (set.contains(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            map = linkedHashMap;
        }
        return new NonIABData(z9, false, false, strT, map);
    }

    public static /* synthetic */ NonIABData getNonIABData$default(Set set, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            set = null;
        }
        return getNonIABData(set);
    }

    public static final String getSDKVersion() {
        return "2.3.3";
    }

    public static final void setUserSubscriptionStatus(boolean z9) {
        f2607j = false;
        f2605d = z9;
        ChoiceCmp choiceCmp = INSTANCE;
        if (choiceCmp.isViewModelAvailable$app_release() && f.t() && choiceCmp.isViewModelAvailable$app_release()) {
            a();
            if (!t1.f14361a || a.f9105a == null || f2605d) {
                return;
            }
            choiceCmp.a(a.b());
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object, java.util.List] */
    public static final void showCCPAScreen(Activity activity) {
        activity.getClass();
        ChoiceCmp choiceCmp = INSTANCE;
        if (choiceCmp.isViewModelAvailable$app_release()) {
            o oVar = g;
            if (oVar == null) {
                kotlin.jvm.internal.l.i("viewModel");
                throw null;
            }
            if (oVar.l()) {
                o oVar2 = g;
                if (oVar2 == null) {
                    kotlin.jvm.internal.l.i("viewModel");
                    throw null;
                }
                if (oVar2.f807c.f11814b.f11779b.contains("USP")) {
                    o oVar3 = g;
                    if (oVar3 == null) {
                        kotlin.jvm.internal.l.i("viewModel");
                        throw null;
                    }
                    if (oVar3.k()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("EXTRA_ACTION", "ACTION_SHOW_CCPA_SCREEN");
                        choiceCmp.startCMPActivity$app_release(activity, bundle);
                        return;
                    }
                }
                ChoiceCmpCallback choiceCmpCallback = f2602a;
                if (choiceCmpCallback != null) {
                    choiceCmpCallback.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.HIDDEN, "CCPA not applicable", Regulations.NA, false, 8, null));
                }
                b.b(null, ChoiceError.US_PRIVACY_NOT_APPLICABLE.getMessage(), null, 5);
                return;
            }
        }
        ChoiceCmpCallback choiceCmpCallback2 = f2602a;
        if (choiceCmpCallback2 != null) {
            choiceCmpCallback2.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.HIDDEN, "Invalid location for CCPA regulation", Regulations.NA, false, 8, null));
        }
        b.b(null, ChoiceError.INVALID_LOCATION.getMessage(), null, 5);
    }

    public static final void showGBCScreen(Activity activity) {
        activity.getClass();
        ChoiceCmp choiceCmp = INSTANCE;
        if (!choiceCmp.isViewModelAvailable$app_release()) {
            ChoiceCmpCallback choiceCmpCallback = f2602a;
            if (choiceCmpCallback == null) {
                return;
            }
            choiceCmpCallback.onCmpError(ChoiceError.MISSING_INITIALIZATION);
            return;
        }
        if (g.f9878a) {
            Bundle bundle = new Bundle();
            bundle.putString("EXTRA_ACTION", "ACTION_SHOW_GBC_SCREEN");
            choiceCmp.startCMPActivity$app_release(activity, bundle);
        } else {
            ChoiceCmpCallback choiceCmpCallback2 = f2602a;
            if (choiceCmpCallback2 != null) {
                choiceCmpCallback2.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.HIDDEN, "GBC not applicable", Regulations.NA, false, 8, null));
            }
            b.b(null, ChoiceError.GBC_NOT_APPLICABLE.getMessage(), null, 5);
        }
    }

    public static final void showUSRegulationScreen(Activity activity) {
        activity.getClass();
        ChoiceCmp choiceCmp = INSTANCE;
        if (choiceCmp.isViewModelAvailable$app_release()) {
            o oVar = g;
            if (oVar == null) {
                kotlin.jvm.internal.l.i("viewModel");
                throw null;
            }
            if (oVar.l()) {
                o oVar2 = g;
                if (oVar2 == null) {
                    kotlin.jvm.internal.l.i("viewModel");
                    throw null;
                }
                if (!oVar2.o()) {
                    ChoiceCmpCallback choiceCmpCallback = f2602a;
                    if (choiceCmpCallback != null) {
                        choiceCmpCallback.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.HIDDEN, "US regulations not applicable", Regulations.NA, false, 8, null));
                    }
                    b.b(null, ChoiceError.US_PRIVACY_NOT_APPLICABLE.getMessage(), null, 5);
                    return;
                }
                o oVar3 = g;
                if (oVar3 == null) {
                    kotlin.jvm.internal.l.i("viewModel");
                    throw null;
                }
                if (!oVar3.k()) {
                    m8.e.g(a.f());
                }
                Bundle bundle = new Bundle();
                bundle.putString("EXTRA_ACTION", "ACTION_SHOW_US_REGULATION_SCREEN");
                bundle.putBoolean("EXTRA_FORCE", true);
                choiceCmp.startCMPActivity$app_release(activity, bundle);
                return;
            }
        }
        ChoiceCmpCallback choiceCmpCallback2 = f2602a;
        if (choiceCmpCallback2 != null) {
            choiceCmpCallback2.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.HIDDEN, "Invalid location for US regulations", Regulations.NA, false, 8, null));
        }
        b.b(null, ChoiceError.INVALID_LOCATION.getMessage(), null, 5);
    }

    /* JADX WARN: Type inference failed for: r6v9, types: [r7.x, w6.c] */
    public static final void startChoice(Application application, String str, String str2, ChoiceCmpCallback choiceCmpCallback, ChoiceStyle choiceStyle) throws Throwable {
        Throwable th;
        application.getClass();
        str.getClass();
        str2.getClass();
        choiceCmpCallback.getClass();
        choiceStyle.getClass();
        f2602a = choiceCmpCallback;
        f2603b = str;
        ChoiceCmp choiceCmp = INSTANCE;
        choiceCmp.getClass();
        Matcher matcher = f2608k.matcher(str2);
        String strGroup = matcher.matches() ? matcher.group(2) : null;
        if (strGroup == null) {
            ChoiceCmpCallback choiceCmpCallback2 = f2602a;
            if (choiceCmpCallback2 != null) {
                choiceCmpCallback2.onCmpError(ChoiceError.INVALID_PCODE);
            }
            strGroup = null;
        }
        if (strGroup == null) {
            strGroup = null;
        }
        if (strGroup == null) {
            return;
        }
        f2604c = strGroup;
        a.f9105a = application;
        a.f9107c = choiceStyle;
        Integer boldFont = choiceStyle.getBoldFont();
        Typeface font = boldFont == null ? null : ResourcesCompat.getFont(a.b(), boldFont.intValue());
        Integer regularFont = choiceStyle.getRegularFont();
        a.f9108d = new d9.c(font, regularFont == null ? null : ResourcesCompat.getFont(a.b(), regularFont.intValue()));
        if (g == null) {
            i iVarJ = a.j();
            m mVarK = a.k();
            o8.i iVarH = a.h();
            if (a.f9117q == null) {
                a.f9117q = new f9.n(a.b(), a.g(), a.a(), a.j(), a.i(), new i(a.a(), 13));
            }
            f9.n nVar = a.f9117q;
            if (nVar == null) {
                kotlin.jvm.internal.l.i("gvlRepository_");
                throw null;
            }
            if (a.f9118r == null) {
                a.f9118r = new r(a.g(), a.j(), a.i(), new x(a.b(), a.a()), 18);
            }
            r rVar = a.f9118r;
            if (rVar == null) {
                kotlin.jvm.internal.l.i("cmpRepository_");
                throw null;
            }
            if (a.f9120u == null) {
                y2.c cVarG = a.g();
                i iVarJ2 = a.j();
                d0 d0VarI = a.i();
                ChoiceCmpCallback callback = choiceCmp.getCallback();
                if (a.f9116p == null) {
                    th = null;
                    a.f9116p = new d0(12);
                } else {
                    th = null;
                }
                d0 d0Var = a.f9116p;
                if (d0Var == null) {
                    kotlin.jvm.internal.l.i("coreUiLabelsResolver");
                    throw th;
                }
                a.f9120u = new z0(cVarG, iVarJ2, d0VarI, new x(callback, d0Var), choiceCmp.getAppPackageId(), choiceCmp.getPCode());
            } else {
                th = null;
            }
            z0 z0Var = a.f9120u;
            if (z0Var == null) {
                Throwable th2 = th;
                kotlin.jvm.internal.l.i("portalConfigRepository_");
                throw th2;
            }
            d5.n nVarM = a.m();
            if (a.f9122w == null) {
                a.f9122w = new x(a.g(), a.i(), new d0(13), 24);
            }
            x xVar = a.f9122w;
            if (xVar == null) {
                Throwable th3 = th;
                kotlin.jvm.internal.l.i("geoIPRepository_");
                throw th3;
            }
            if (a.f9123x == null) {
                a.f9123x = new r(a.g(), a.j(), a.i(), new i(12), 20);
            }
            r rVar2 = a.f9123x;
            if (rVar2 == null) {
                Throwable th4 = th;
                kotlin.jvm.internal.l.i("googleVendorsRepository_");
                throw th4;
            }
            if (a.A == null) {
                a.A = new z0(a.a(), a.g(), a.j(), a.i(), new g4.b(1), 7);
            }
            z0 z0Var2 = a.A;
            if (z0Var2 == null) {
                Throwable th5 = th;
                kotlin.jvm.internal.l.i("gbcRepository");
                throw th5;
            }
            g = new o(iVarJ, mVarK, iVarH, nVar, rVar, z0Var, nVarM, xVar, rVar2, z0Var2, a.c(), a.d());
            w wVarA = h;
            if (wVarA == null) {
                wVarA = y.a(y.c());
            }
            h = wVarA;
            ?? r6 = th;
            y.q(wVarA, f2606i, r6, new l(2, r6, 1), 2);
        }
        application.registerActivityLifecycleCallbacks(new y2(new o2.e(3)));
        application.registerActivityLifecycleCallbacks(new b.a());
    }

    public static /* synthetic */ void startChoice$default(Application application, String str, String str2, ChoiceCmpCallback choiceCmpCallback, ChoiceStyle choiceStyle, int i10, Object obj) throws Throwable {
        if ((i10 & 16) != 0) {
            choiceStyle = new ChoiceStyle();
        }
        startChoice(application, str, str2, choiceCmpCallback, choiceStyle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r9.h(r0) == r6) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(w6.c r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof b.c
            if (r0 == 0) goto L13
            r0 = r9
            b.c r0 = (b.c) r0
            int r1 = r0.f776c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f776c = r1
            goto L18
        L13:
            b.c r0 = new b.c
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f774a
            int r1 = r0.f776c
            java.lang.String r2 = "viewModel"
            r3 = 2
            r4 = 1
            r5 = 0
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r4) goto L33
            if (r1 != r3) goto L2d
            s6.a.e(r9)
            goto L71
        L2d:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            return r5
        L33:
            s6.a.e(r9)
            goto L51
        L37:
            s6.a.e(r9)
            b.o r9 = com.inmobi.cmp.ChoiceCmp.g
            if (r9 == 0) goto L78
            r0.f776c = r4
            y7.e r1 = r7.i0.f12407a
            y7.d r1 = y7.d.f14116a
            b.m r4 = new b.m
            r7 = 3
            r4.<init>(r9, r5, r7)
            java.lang.Object r9 = r7.y.z(r4, r1, r0)
            if (r9 != r6) goto L51
            goto L70
        L51:
            n6.c r9 = (n6.c) r9
            android.app.Application r1 = i9.a.f9105a
            r9.getClass()
            i9.a.f9111k = r9
            b.o r9 = com.inmobi.cmp.ChoiceCmp.g
            if (r9 == 0) goto L74
            boolean r1 = j.g.f9878a
            boolean r9 = r9.m()
            j.g.f9878a = r9
            com.inmobi.cmp.ChoiceCmp r9 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            r0.f776c = r3
            java.lang.Object r9 = r9.h(r0)
            if (r9 != r6) goto L71
        L70:
            return r6
        L71:
            s6.w r9 = s6.w.f12711a
            return r9
        L74:
            kotlin.jvm.internal.l.i(r2)
            throw r5
        L78:
            kotlin.jvm.internal.l.i(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.b(w6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007b, code lost:
    
        if (r9.g(r0) == r6) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(w6.c r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof b.d
            if (r0 == 0) goto L13
            r0 = r9
            b.d r0 = (b.d) r0
            int r1 = r0.f779c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f779c = r1
            goto L18
        L13:
            b.d r0 = new b.d
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f777a
            int r1 = r0.f779c
            java.lang.String r2 = "viewModel"
            r3 = 2
            r4 = 1
            r5 = 0
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r4) goto L33
            if (r1 != r3) goto L2d
            s6.a.e(r9)
            goto L7e
        L2d:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            return r5
        L33:
            s6.a.e(r9)
            goto L51
        L37:
            s6.a.e(r9)
            b.o r9 = com.inmobi.cmp.ChoiceCmp.g
            if (r9 == 0) goto L85
            r0.f779c = r4
            y7.e r1 = r7.i0.f12407a
            y7.d r1 = y7.d.f14116a
            b.m r4 = new b.m
            r7 = 4
            r4.<init>(r9, r5, r7)
            java.lang.Object r9 = r7.y.z(r4, r1, r0)
            if (r9 != r6) goto L51
            goto L7d
        L51:
            q6.a r9 = (q6.a) r9
            b.o r1 = com.inmobi.cmp.ChoiceCmp.g
            if (r1 == 0) goto L81
            r1.f815o = r9
            android.app.Application r1 = i9.a.f9105a
            if (r9 != 0) goto L5f
            r1 = r5
            goto L61
        L5f:
            java.lang.String r1 = r9.f12281b
        L61:
            java.lang.String r2 = ""
            if (r1 != 0) goto L66
            r1 = r2
        L66:
            i9.a.f9113m = r1
            if (r9 != 0) goto L6b
            goto L6d
        L6b:
            java.lang.String r5 = r9.f12280a
        L6d:
            if (r5 != 0) goto L70
            goto L71
        L70:
            r2 = r5
        L71:
            i9.a.f9114n = r2
            com.inmobi.cmp.ChoiceCmp r9 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            r0.f779c = r3
            java.lang.Object r9 = r9.g(r0)
            if (r9 != r6) goto L7e
        L7d:
            return r6
        L7e:
            s6.w r9 = s6.w.f12711a
            return r9
        L81:
            kotlin.jvm.internal.l.i(r2)
            throw r5
        L85:
            kotlin.jvm.internal.l.i(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.c(w6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02c5, code lost:
    
        if (r13.f(r0) == r6) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(w6.c r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.d(w6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x016c, code lost:
    
        if (r15.d(r0) == r6) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(w6.c r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.e(w6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006f, code lost:
    
        if (a(r0) == r5) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(w6.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof b.g
            if (r0 == 0) goto L13
            r0 = r8
            b.g r0 = (b.g) r0
            int r1 = r0.f788c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f788c = r1
            goto L18
        L13:
            b.g r0 = new b.g
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f786a
            int r1 = r0.f788c
            r2 = 0
            r3 = 2
            r4 = 1
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            s6.a.e(r8)
            goto L72
        L2b:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            return r2
        L31:
            s6.a.e(r8)
            goto L5b
        L35:
            s6.a.e(r8)
            o8.i r8 = i9.a.h()
            m8.e.e = r8
            d0.i r8 = i9.a.j()
            m8.e.f = r8
            b.o r8 = com.inmobi.cmp.ChoiceCmp.g
            if (r8 == 0) goto L75
            r0.f788c = r4
            y7.e r1 = r7.i0.f12407a
            y7.d r1 = y7.d.f14116a
            b.n r4 = new b.n
            r6 = 0
            r4.<init>(r8, r2, r6)
            java.lang.Object r8 = r7.y.z(r4, r1, r0)
            if (r8 != r5) goto L5b
            goto L71
        L5b:
            m8.a r8 = (m8.a) r8
            android.app.Application r1 = i9.a.f9105a
            r8.getClass()
            i9.a.f9112l = r8
            com.inmobi.cmp.ChoiceCmp r8 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            r0.f788c = r3
            r8.getClass()
            java.lang.Object r8 = a(r0)
            if (r8 != r5) goto L72
        L71:
            return r5
        L72:
            s6.w r8 = s6.w.f12711a
            return r8
        L75:
            java.lang.String r8 = "viewModel"
            kotlin.jvm.internal.l.i(r8)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.f(w6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d8, code lost:
    
        if (r1.b(r0) == r6) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(w6.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.g(w6.c):java.lang.Object");
    }

    public final String getAppPackageId() {
        return f2603b;
    }

    public final ChoiceCmpCallback getCallback() {
        return f2602a;
    }

    public final long getConfigFetchTimeStampFromDevice() {
        return f;
    }

    public final UUID getCurrentSessionId() {
        return e;
    }

    public final d getGoogleVendorList$app_release() {
        o oVar = g;
        if (oVar != null) {
            return oVar.f814n;
        }
        kotlin.jvm.internal.l.i("viewModel");
        throw null;
    }

    public final String getPCode() {
        return f2604c;
    }

    public final o8.i getPortalConfig$app_release() {
        if (!isViewModelAvailable$app_release()) {
            return null;
        }
        o oVar = g;
        if (oVar != null) {
            return oVar.f807c;
        }
        kotlin.jvm.internal.l.i("viewModel");
        throw null;
    }

    public final m getTcModel$app_release() {
        if (!isViewModelAvailable$app_release()) {
            return null;
        }
        o oVar = g;
        if (oVar != null) {
            return oVar.f806b;
        }
        kotlin.jvm.internal.l.i("viewModel");
        throw null;
    }

    public final boolean getUserSubscribed() {
        return f2605d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        if (r8.e(r0) == r5) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(w6.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof b.i
            if (r0 == 0) goto L13
            r0 = r8
            b.i r0 = (b.i) r0
            int r1 = r0.f794c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f794c = r1
            goto L18
        L13:
            b.i r0 = new b.i
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f792a
            int r1 = r0.f794c
            r2 = 0
            r3 = 2
            r4 = 1
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            s6.a.e(r8)
            goto L5c
        L2b:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            return r2
        L31:
            s6.a.e(r8)
            goto L4f
        L35:
            s6.a.e(r8)
            b.o r8 = com.inmobi.cmp.ChoiceCmp.g
            if (r8 == 0) goto L5f
            r0.f794c = r4
            y7.e r1 = r7.i0.f12407a
            y7.d r1 = y7.d.f14116a
            b.m r4 = new b.m
            r6 = 6
            r4.<init>(r8, r2, r6)
            java.lang.Object r8 = r7.y.z(r4, r1, r0)
            if (r8 != r5) goto L4f
            goto L5b
        L4f:
            d9.t r8 = (d9.t) r8
            com.inmobi.cmp.ChoiceCmp r8 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            r0.f794c = r3
            java.lang.Object r8 = r8.e(r0)
            if (r8 != r5) goto L5c
        L5b:
            return r5
        L5c:
            s6.w r8 = s6.w.f12711a
            return r8
        L5f:
            java.lang.String r8 = "viewModel"
            kotlin.jvm.internal.l.i(r8)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.h(w6.c):java.lang.Object");
    }

    public final boolean isViewModelAvailable$app_release() {
        o oVar = g;
        return oVar != null && oVar.f813m;
    }

    public final void onAppClosing() {
        o oVar = g;
        if (oVar == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        long j10 = f;
        oVar.f805a.m(79, (System.currentTimeMillis() - j10) + oVar.f807c.h);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.inmobi.cmp.model.PingReturn ping$app_release(boolean r16, com.inmobi.cmp.core.cmpapi.status.CmpStatus r17, com.inmobi.cmp.core.cmpapi.status.DisplayStatus r18) {
        /*
            r15 = this;
            r17.getClass()
            r18.getClass()
            b.o r0 = com.inmobi.cmp.ChoiceCmp.g
            if (r0 == 0) goto La1
            com.inmobi.cmp.model.PingReturn r1 = new com.inmobi.cmp.model.PingReturn
            b.o r0 = com.inmobi.cmp.ChoiceCmp.g
            java.lang.String r2 = "viewModel"
            r3 = 0
            if (r0 == 0) goto L9d
            boolean r0 = r0.g()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            f6.m r4 = r15.getTcModel$app_release()
            if (r4 != 0) goto L23
            r4 = r3
            goto L29
        L23:
            int r4 = r4.f8106n
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L29:
            java.lang.String r7 = java.lang.String.valueOf(r4)
            f6.m r4 = r15.getTcModel$app_release()
            if (r4 != 0) goto L35
            r8 = r3
            goto L3c
        L35:
            int r4 = r4.f8105m
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8 = r4
        L3c:
            b.o r4 = com.inmobi.cmp.ChoiceCmp.g
            if (r4 == 0) goto L99
            int r4 = r4.j()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            b.o r4 = com.inmobi.cmp.ChoiceCmp.g
            if (r4 == 0) goto L95
            f6.m r5 = r4.f806b
            k8.c r5 = r5.f8097a
            if (r5 != 0) goto L54
            r5 = r3
            goto L56
        L54:
            java.lang.Integer r5 = r5.f10083c
        L56:
            if (r5 != 0) goto L5d
            int r4 = r4.i()
            goto L61
        L5d:
            int r4 = r5.intValue()
        L61:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)
            b.o r4 = com.inmobi.cmp.ChoiceCmp.g
            if (r4 == 0) goto L91
            boolean r4 = r4.o()
            if (r4 == 0) goto L7f
            b.o r4 = com.inmobi.cmp.ChoiceCmp.g
            if (r4 == 0) goto L7b
            boolean r2 = r4.l()
            if (r2 == 0) goto L7f
            r2 = 1
            goto L80
        L7b:
            kotlin.jvm.internal.l.i(r2)
            throw r3
        L7f:
            r2 = 0
        L80:
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r2)
            java.lang.String r6 = "2.0"
            r3 = r16
            r4 = r17
            r5 = r18
            r2 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r1
        L91:
            kotlin.jvm.internal.l.i(r2)
            throw r3
        L95:
            kotlin.jvm.internal.l.i(r2)
            throw r3
        L99:
            kotlin.jvm.internal.l.i(r2)
            throw r3
        L9d:
            kotlin.jvm.internal.l.i(r2)
            throw r3
        La1:
            com.inmobi.cmp.ChoiceCmpCallback r0 = com.inmobi.cmp.ChoiceCmp.f2602a
            if (r0 != 0) goto La6
            goto Lab
        La6:
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.MISSING_INITIALIZATION
            r0.onCmpError(r1)
        Lab:
            com.inmobi.cmp.model.PingReturn r2 = new com.inmobi.cmp.model.PingReturn
            com.inmobi.cmp.core.cmpapi.status.CmpStatus r5 = com.inmobi.cmp.core.cmpapi.status.CmpStatus.ERROR
            com.inmobi.cmp.core.cmpapi.status.DisplayStatus r6 = com.inmobi.cmp.core.cmpapi.status.DisplayStatus.HIDDEN
            r13 = 512(0x200, float:7.17E-43)
            r14 = 0
            r3 = 0
            r4 = 0
            java.lang.String r7 = "2.0"
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.ping$app_release(boolean, com.inmobi.cmp.core.cmpapi.status.CmpStatus, com.inmobi.cmp.core.cmpapi.status.DisplayStatus):com.inmobi.cmp.model.PingReturn");
    }

    public final void sendNRVisitEvent$app_release() {
        if (g.f9878a) {
            UUID uuid = s.f936a;
            e eVar = i0.f12407a;
            y.q(v0.f12442a, y7.d.f14116a, null, new b9.r((String) null, b9.d.NR, false, (c) null), 2);
        }
    }

    public final void setAppPackageId(String str) {
        str.getClass();
        f2603b = str;
    }

    public final void setCallback(ChoiceCmpCallback choiceCmpCallback) {
        f2602a = choiceCmpCallback;
    }

    public final void setConfigFetchTimeStampFromDevice(long j10) {
        f = j10;
    }

    public final void setCurrentSessionId(UUID uuid) {
        e = uuid;
    }

    public final void setLoginProcessStart() {
        f2607j = true;
    }

    public final void setPCode(String str) {
        str.getClass();
        f2604c = str;
    }

    public final void setUserSubscribed(boolean z9) {
        f2605d = z9;
    }

    public final void startCMPActivity$app_release(Context context, Bundle bundle) {
        context.getClass();
        bundle.getClass();
        context.startActivity(new Intent(context, (Class<?>) CmpActivity.class).addFlags(268435456).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).putExtras(bundle));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.a(android.content.Context, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r15) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.a(android.content.Context):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r0.t() != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a() {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.a():void");
    }
}
