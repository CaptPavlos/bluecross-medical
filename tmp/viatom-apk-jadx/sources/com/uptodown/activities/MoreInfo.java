package com.uptodown.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import d5.u;
import d5.z;
import e5.b2;
import e5.s;
import h5.e0;
import h5.h;
import h5.k;
import java.util.ArrayList;
import l4.w;
import l4.x2;
import o4.b;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MoreInfo extends w {
    public static final /* synthetic */ int P = 0;
    public b2 J;
    public h K;
    public ArrayList L;
    public ArrayList M;
    public ArrayList N;
    public final LifecycleCoroutineScope H = LifecycleOwnerKt.getLifecycleScope(this);
    public final m I = new m(new x2(this, 0));
    public final int O = 2;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        if (r7.y.z(r3, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n0(com.uptodown.activities.MoreInfo r7, y6.c r8) {
        /*
            boolean r0 = r8 instanceof l4.d3
            if (r0 == 0) goto L13
            r0 = r8
            l4.d3 r0 = (l4.d3) r0
            int r1 = r0.f10322d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10322d = r1
            goto L18
        L13:
            l4.d3 r0 = new l4.d3
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f10320b
            int r1 = r0.f10322d
            r2 = 2
            r3 = 1
            r4 = 0
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            s6.a.e(r8)
            goto L67
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            return r4
        L31:
            kotlin.jvm.internal.x r1 = r0.f10319a
            s6.a.e(r8)
            goto L53
        L37:
            s6.a.e(r8)
            kotlin.jvm.internal.x r1 = new kotlin.jvm.internal.x
            r1.<init>()
            y7.e r8 = r7.i0.f12407a
            y7.d r8 = y7.d.f14116a
            l4.e3 r6 = new l4.e3
            r6.<init>(r7, r1, r4)
            r0.f10319a = r1
            r0.f10322d = r3
            java.lang.Object r8 = r7.y.z(r6, r8, r0)
            if (r8 != r5) goto L53
            goto L66
        L53:
            y7.e r8 = r7.i0.f12407a
            s7.c r8 = w7.n.f13548a
            l4.e3 r3 = new l4.e3
            r3.<init>(r1, r7, r4)
            r0.f10319a = r4
            r0.f10322d = r2
            java.lang.Object r7 = r7.y.z(r3, r8, r0)
            if (r7 != r5) goto L67
        L66:
            return r5
        L67:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.n0(com.uptodown.activities.MoreInfo, y6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
    
        if (r7.y.z(r3, r9, r0) != r6) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object o0(com.uptodown.activities.MoreInfo r8, y6.c r9) {
        /*
            boolean r0 = r9 instanceof l4.f3
            if (r0 == 0) goto L13
            r0 = r9
            l4.f3 r0 = (l4.f3) r0
            int r1 = r0.f10389d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10389d = r1
            goto L18
        L13:
            l4.f3 r0 = new l4.f3
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f10387b
            int r1 = r0.f10389d
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L40
            if (r1 == r4) goto L3a
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2e
            s6.a.e(r9)
            goto L85
        L2e:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            return r5
        L34:
            kotlin.jvm.internal.v r1 = r0.f10386a
            s6.a.e(r9)
            goto L71
        L3a:
            kotlin.jvm.internal.v r1 = r0.f10386a
            s6.a.e(r9)
            goto L5d
        L40:
            s6.a.e(r9)
            kotlin.jvm.internal.v r9 = new kotlin.jvm.internal.v
            r9.<init>()
            y7.e r1 = r7.i0.f12407a
            s7.c r1 = w7.n.f13548a
            l4.b3 r7 = new l4.b3
            r7.<init>(r8, r5, r4)
            r0.f10386a = r9
            r0.f10389d = r4
            java.lang.Object r1 = r7.y.z(r7, r1, r0)
            if (r1 != r6) goto L5c
            goto L84
        L5c:
            r1 = r9
        L5d:
            y7.e r9 = r7.i0.f12407a
            y7.d r9 = y7.d.f14116a
            l4.g3 r4 = new l4.g3
            r4.<init>(r8, r1, r5)
            r0.f10386a = r1
            r0.f10389d = r3
            java.lang.Object r9 = r7.y.z(r4, r9, r0)
            if (r9 != r6) goto L71
            goto L84
        L71:
            y7.e r9 = r7.i0.f12407a
            s7.c r9 = w7.n.f13548a
            l4.g3 r3 = new l4.g3
            r3.<init>(r1, r8, r5)
            r0.f10386a = r5
            r0.f10389d = r2
            java.lang.Object r8 = r7.y.z(r3, r9, r0)
            if (r8 != r6) goto L85
        L84:
            return r6
        L85:
            s6.w r8 = s6.w.f12711a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.o0(com.uptodown.activities.MoreInfo, y6.c):java.lang.Object");
    }

    public static final void p0(MoreInfo moreInfo, ArrayList arrayList, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        arrayList.getClass();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = ((e0) arrayList.get(i10)).f8510a;
            if (str != null && str.length() != 0) {
                u uVarA = u.a(LayoutInflater.from(moreInfo.getApplicationContext()));
                View view = uVarA.f7365b;
                TextView textView = uVarA.f7366c;
                view.setLayoutParams(layoutParams);
                textView.setTypeface(b.f11720s);
                textView.setText(((e0) arrayList.get(i10)).f8510a);
                textView.setOnClickListener(new s(uVarA, 12));
                linearLayout.addView(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0281  */
    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r19) {
        /*
            Method dump skipped, instructions count: 2054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.onCreate(android.os.Bundle):void");
    }

    public final z q0() {
        return (z) this.I.getValue();
    }

    public final void r0(k kVar) {
        kVar.getClass();
        b2 b2Var = new b2();
        b2Var.f7688c = kVar;
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add(q0().t.getId(), b2Var, (String) null).addToBackStack(String.valueOf(kVar.f8632a)).commit();
        this.J = b2Var;
    }
}
