package com.uptodown.activities;

import a3.i0;
import a6.c;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import d0.i;
import d5.d;
import e5.n;
import e5.s;
import h5.f;
import j$.util.concurrent.ConcurrentHashMap;
import l4.w;
import o4.b;
import r7.y;
import s6.m;
import x4.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class AppFilesActivity extends w {
    public static final /* synthetic */ int L = 0;
    public f J;
    public final LifecycleCoroutineScope H = LifecycleOwnerKt.getLifecycleScope(this);
    public final m I = new m(new i0(this, 17));
    public final i K = new i((Object) this, 22);

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
    
        if (r7.y.z(r3, r10, r0) != r6) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n0(com.uptodown.activities.AppFilesActivity r9, y6.c r10) {
        /*
            boolean r0 = r10 instanceof l4.d
            if (r0 == 0) goto L13
            r0 = r10
            l4.d r0 = (l4.d) r0
            int r1 = r0.f10312d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10312d = r1
            goto L18
        L13:
            l4.d r0 = new l4.d
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f10310b
            int r1 = r0.f10312d
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L40
            if (r1 == r4) goto L3a
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2e
            s6.a.e(r10)
            goto L85
        L2e:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            return r5
        L34:
            java.util.ArrayList r1 = r0.f10309a
            s6.a.e(r10)
            goto L71
        L3a:
            java.util.ArrayList r1 = r0.f10309a
            s6.a.e(r10)
            goto L5b
        L40:
            java.util.ArrayList r10 = androidx.constraintlayout.core.widgets.analyzer.a.A(r10)
            y7.e r1 = r7.i0.f12407a
            s7.c r1 = w7.n.f13548a
            a6.n r7 = new a6.n
            r8 = 17
            r7.<init>(r9, r5, r8)
            r0.f10309a = r10
            r0.f10312d = r4
            java.lang.Object r1 = r7.y.z(r7, r1, r0)
            if (r1 != r6) goto L5a
            goto L84
        L5a:
            r1 = r10
        L5b:
            y7.e r10 = r7.i0.f12407a
            y7.d r10 = y7.d.f14116a
            a6.j r4 = new a6.j
            r7 = 20
            r4.<init>(r9, r1, r5, r7)
            r0.f10309a = r1
            r0.f10312d = r3
            java.lang.Object r10 = r7.y.z(r4, r10, r0)
            if (r10 != r6) goto L71
            goto L84
        L71:
            y7.e r10 = r7.i0.f12407a
            s7.c r10 = w7.n.f13548a
            l4.e r3 = new l4.e
            r3.<init>(r9, r1, r5)
            r0.f10309a = r5
            r0.f10312d = r2
            java.lang.Object r9 = r7.y.z(r3, r10, r0)
            if (r9 != r6) goto L85
        L84:
            return r6
        L85:
            s6.w r9 = s6.w.f12711a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppFilesActivity.n0(com.uptodown.activities.AppFilesActivity, y6.c):java.lang.Object");
    }

    public final d o0() {
        return (d) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        try {
            RelativeLayout relativeLayout = o0().f6958a;
            relativeLayout.getClass();
            setContentView(relativeLayout);
            Intent intent = getIntent();
            if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("appInstalled")) {
                this.J = (f) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInstalled", f.class) : extras.getParcelable("appInstalled"));
            }
            d dVarO0 = o0();
            TextView textView = dVarO0.f6962i;
            RecyclerView recyclerView = dVarO0.f6961d;
            Toolbar toolbar = dVarO0.e;
            textView.setTypeface(b.f11719r);
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription(getString(R.string.back));
            }
            toolbar.setNavigationOnClickListener(new s(this, 5));
            dVarO0.h.setTypeface(b.f11720s);
            dVarO0.f6960c.setOnClickListener(new n(1));
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new j((int) getResources().getDimension(R.dimen.margin_m)));
            if (this.J != null) {
                p0();
                y.q(this.H, null, null, new c(this, null, 13), 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void p0() {
        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
        f fVar = this.J;
        fVar.getClass();
        o0().f6959b.setImageDrawable(v5.n.c(this, fVar.f8526c));
        TextView textView = o0().f;
        f fVar2 = this.J;
        fVar2.getClass();
        textView.setText(fVar2.f8525b);
        o0().f.setTypeface(b.f11719r);
        TextView textView2 = o0().g;
        f fVar3 = this.J;
        fVar3.getClass();
        textView2.setText(fVar3.e);
        o0().g.setTypeface(b.f11720s);
    }
}
