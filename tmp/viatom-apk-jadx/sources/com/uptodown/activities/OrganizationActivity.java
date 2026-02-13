package com.uptodown.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.OrganizationActivity;
import d5.g0;
import e5.s;
import kotlin.jvm.internal.y;
import l4.o5;
import l4.p5;
import l4.r5;
import l4.u4;
import l4.w;
import l4.x2;
import n4.b0;
import o4.b;
import r7.i0;
import s6.m;
import u7.m0;
import w6.c;
import w7.n;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class OrganizationActivity extends w {
    public static final /* synthetic */ int K = 0;
    public final m H = new m(new x2(this, 5));
    public final ViewModelLazy I = new ViewModelLazy(y.a(r5.class), new p5(this, 0), new o5(this), new p5(this, 1));
    public b0 J;

    public final g0 n0() {
        return (g0) this.H.getValue();
    }

    public final r5 o0() {
        return (r5) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        Intent intent = getIntent();
        c cVar = null;
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("organizationID")) {
                m0 m0Var = o0().f10791d;
                Long lValueOf = Long.valueOf(extras.getLong("organizationID"));
                m0Var.getClass();
                m0Var.g(null, lValueOf);
            }
            if (extras.containsKey("organizationName")) {
                m0 m0Var2 = o0().e;
                String string = extras.getString("organizationName");
                string.getClass();
                m0Var2.getClass();
                m0Var2.g(null, string);
            }
        }
        RelativeLayout relativeLayout = n0().f7061a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        final g0 g0VarN0 = n0();
        if (drawable != null) {
            g0VarN0.f7067k.setNavigationIcon(drawable);
            g0VarN0.f7067k.setNavigationContentDescription(getString(R.string.back));
        }
        Toolbar toolbar = g0VarN0.f7067k;
        RecyclerView recyclerView = g0VarN0.f7065i;
        TextView textView = g0VarN0.f7071o;
        toolbar.setNavigationOnClickListener(new s(this, 16));
        textView.setTypeface(b.f11719r);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.setItemAnimator(null);
        if (((CharSequence) o0().e.getValue()).length() > 0) {
            textView.setText((CharSequence) o0().e.getValue());
        }
        g0VarN0.f7066j.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: l4.l5
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                int i10 = OrganizationActivity.K;
                OrganizationActivity organizationActivity = this.f10592a;
                if (organizationActivity.o0().f || organizationActivity.o0().g) {
                    return;
                }
                ScrollView scrollView = g0VarN0.f7066j;
                if (scrollView.getChildAt(scrollView.getChildCount() - 1).getBottom() - (scrollView.getScrollY() + scrollView.getHeight()) > 0 || organizationActivity.o0().f || organizationActivity.o0().g) {
                    return;
                }
                n4.b0 b0Var = organizationActivity.J;
                if (b0Var != null) {
                    b0Var.a(true);
                }
                r5 r5VarO0 = organizationActivity.o0();
                r5VarO0.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(r5VarO0);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new u4(r5VarO0, organizationActivity, null, 5), 2);
            }
        });
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, n.f13548a, null, new a6.c(this, cVar, 21), 2);
        r5 r5VarO0 = o0();
        r5VarO0.getClass();
        r7.y.q(ViewModelKt.getViewModelScope(r5VarO0), d.f14116a, null, new u4(r5VarO0, this, cVar, 4), 2);
    }
}
