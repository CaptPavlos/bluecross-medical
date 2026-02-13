package com.uptodown.activities;

import a.a;
import a3.i0;
import android.app.Activity;
import androidx.lifecycle.LifecycleOwnerKt;
import c1.l;
import com.google.android.gms.internal.measurement.l5;
import d5.e;
import h5.f;
import h5.h;
import java.util.ArrayList;
import l4.a4;
import l4.g;
import o4.b;
import o7.u;
import r7.y;
import s6.m;
import y2.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class AppInstalledDetailsActivity extends a4 {
    public static final /* synthetic */ int Y = 0;
    public final m U = new m(new i0(this, 18));
    public f V;
    public h W;
    public ArrayList X;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r7.y.z(r1, r7, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object B0(com.uptodown.activities.AppInstalledDetailsActivity r6, y6.c r7) {
        /*
            boolean r0 = r7 instanceof l4.i
            if (r0 == 0) goto L13
            r0 = r7
            l4.i r0 = (l4.i) r0
            int r1 = r0.f10479c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10479c = r1
            goto L18
        L13:
            l4.i r0 = new l4.i
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f10477a
            int r1 = r0.f10479c
            r2 = 0
            r3 = 2
            r4 = 1
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            s6.a.e(r7)
            goto L5c
        L2b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            return r2
        L31:
            s6.a.e(r7)
            goto L4a
        L35:
            s6.a.e(r7)
            y7.e r7 = r7.i0.f12407a
            y7.d r7 = y7.d.f14116a
            l4.h r1 = new l4.h
            r1.<init>(r6, r2, r4)
            r0.f10479c = r4
            java.lang.Object r7 = r7.y.z(r1, r7, r0)
            if (r7 != r5) goto L4a
            goto L5b
        L4a:
            y7.e r7 = r7.i0.f12407a
            s7.c r7 = w7.n.f13548a
            l4.h r1 = new l4.h
            r1.<init>(r6, r2, r3)
            r0.f10479c = r3
            java.lang.Object r6 = r7.y.z(r1, r7, r0)
            if (r6 != r5) goto L5c
        L5b:
            return r5
        L5c:
            s6.w r6 = s6.w.f12711a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.B0(com.uptodown.activities.AppInstalledDetailsActivity, y6.c):java.lang.Object");
    }

    public static final void C0(AppInstalledDetailsActivity appInstalledDetailsActivity) {
        a.x(appInstalledDetailsActivity.F0().f6991j, appInstalledDetailsActivity.F0().f6987b);
        appInstalledDetailsActivity.F0().g.setVisibility(8);
        appInstalledDetailsActivity.F0().f6994k0.setVisibility(8);
        appInstalledDetailsActivity.F0().t.setVisibility(8);
        appInstalledDetailsActivity.F0().f7001o0.setVisibility(0);
    }

    public static final void D0(AppInstalledDetailsActivity appInstalledDetailsActivity, String str) {
        a.x(appInstalledDetailsActivity.F0().f6991j, appInstalledDetailsActivity.F0().f6987b);
        appInstalledDetailsActivity.F0().M.setVisibility(0);
        appInstalledDetailsActivity.F0().f7001o0.setVisibility(0);
        appInstalledDetailsActivity.F0().g.setVisibility(8);
        appInstalledDetailsActivity.F0().B.setVisibility(8);
        l5.E(appInstalledDetailsActivity.F0().f6994k0);
        appInstalledDetailsActivity.F0().f6994k0.setVisibility(0);
        appInstalledDetailsActivity.F0().f6994k0.setOnClickListener(new b5.a(20, appInstalledDetailsActivity, str));
    }

    public final void E0() {
        if (this.W == null) {
            f fVar = this.V;
            fVar.getClass();
            if (fVar.f8541w > 0) {
                f fVar2 = this.V;
                fVar2.getClass();
                new l(this, fVar2.f8541w, new c(this, 22), LifecycleOwnerKt.getLifecycleScope(this));
            }
        }
    }

    public final e F0() {
        return (e) this.U.getValue();
    }

    public final void G0() {
        a.P(F0().f6991j, F0().f6987b);
        F0().f6991j.setIndeterminate(true);
        F0().g.setVisibility(0);
        F0().f7001o0.setVisibility(0);
        F0().M.setVisibility(8);
        F0().f6994k0.setVisibility(8);
        F0().B.setVisibility(8);
        F0().t.setVisibility(0);
    }

    public final void H0() {
        a.P(F0().f6991j, F0().f6987b);
        F0().g.setVisibility(0);
        F0().f7001o0.setVisibility(8);
        F0().M.setVisibility(0);
        F0().B.setOnClickListener(new l4.f(this, 1));
        F0().f6994k0.setVisibility(8);
        F0().B.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0248  */
    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 1738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.onCreate(android.os.Bundle):void");
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.V != null) {
            Activity activity = b.g;
            u4.a aVarA = r0.f.A();
            w6.c cVar = null;
            String str = aVarA != null ? aVarA.f12891a : null;
            f fVar = this.V;
            fVar.getClass();
            if (!u.Z(str, fVar.f8526c, true)) {
                y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g(this, cVar, 3), 3);
            } else {
                F0().f6991j.setIndeterminate(true);
                a.P(F0().f6991j, F0().f6987b);
            }
        }
    }

    @Override // l4.a4
    public final void z0() {
    }
}
