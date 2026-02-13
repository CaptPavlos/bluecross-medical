package com.uptodown.activities;

import a3.i0;
import a6.c;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import d0.i;
import e5.n;
import e5.s;
import l4.w;
import n4.o;
import o4.b;
import r7.y;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class LanguageSettingsActivity extends w {
    public static final /* synthetic */ int L = 0;
    public o H;
    public final i I = new i((Object) this, 25);
    public final m J = new m(new i0(this, 27));
    public final LifecycleCoroutineScope K = LifecycleOwnerKt.getLifecycleScope(this);

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
    
        if (r7.y.z(r1, r9, r0) != r6) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n0(com.uptodown.activities.LanguageSettingsActivity r8, y6.c r9) {
        /*
            boolean r0 = r9 instanceof l4.e1
            if (r0 == 0) goto L13
            r0 = r9
            l4.e1 r0 = (l4.e1) r0
            int r1 = r0.f10348c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10348c = r1
            goto L18
        L13:
            l4.e1 r0 = new l4.e1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f10346a
            int r1 = r0.f10348c
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L3c
            if (r1 == r4) goto L38
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2e
            s6.a.e(r9)
            goto L76
        L2e:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            return r5
        L34:
            s6.a.e(r9)
            goto L64
        L38:
            s6.a.e(r9)
            goto L52
        L3c:
            s6.a.e(r9)
            y7.e r9 = r7.i0.f12407a
            s7.c r9 = w7.n.f13548a
            l4.f1 r1 = new l4.f1
            r7 = 0
            r1.<init>(r8, r5, r7)
            r0.f10348c = r4
            java.lang.Object r9 = r7.y.z(r1, r9, r0)
            if (r9 != r6) goto L52
            goto L75
        L52:
            y7.e r9 = r7.i0.f12407a
            y7.d r9 = y7.d.f14116a
            l4.f1 r1 = new l4.f1
            r1.<init>(r8, r5, r4)
            r0.f10348c = r3
            java.lang.Object r9 = r7.y.z(r1, r9, r0)
            if (r9 != r6) goto L64
            goto L75
        L64:
            y7.e r9 = r7.i0.f12407a
            s7.c r9 = w7.n.f13548a
            l4.g1 r1 = new l4.g1
            r1.<init>(r8, r5)
            r0.f10348c = r2
            java.lang.Object r8 = r7.y.z(r1, r9, r0)
            if (r8 != r6) goto L76
        L75:
            return r6
        L76:
            s6.w r8 = s6.w.f12711a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.LanguageSettingsActivity.n0(com.uptodown.activities.LanguageSettingsActivity, y6.c):java.lang.Object");
    }

    public final d5.w o0() {
        return (d5.w) this.J.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = o0().f7380a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            o0().f7383d.setNavigationIcon(drawable);
            o0().f7383d.setNavigationContentDescription(getString(R.string.back));
        }
        o0().e.setTypeface(b.f11719r);
        o0().f7383d.setNavigationOnClickListener(new s(this, 10));
        o0().f7381b.setOnClickListener(new n(6));
        o0().f7382c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        o0().f7382c.setItemAnimator(new DefaultItemAnimator());
        y.q(this.K, null, null, new c(this, null, 16), 3);
    }
}
