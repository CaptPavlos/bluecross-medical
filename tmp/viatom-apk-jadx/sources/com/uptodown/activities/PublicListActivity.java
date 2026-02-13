package com.uptodown.activities;

import a3.o;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import d5.m0;
import e5.s;
import h5.e1;
import kotlin.jvm.internal.y;
import l4.a4;
import l4.j6;
import l4.k6;
import l4.l6;
import l4.m6;
import l4.u4;
import l4.x2;
import l4.x4;
import n4.d1;
import o4.b;
import r7.i0;
import r7.w;
import s6.m;
import w6.c;
import w7.n;
import x5.f;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PublicListActivity extends a4 {
    public static final /* synthetic */ int Y = 0;
    public d1 W;
    public final m U = new m(new x2(this, 8));
    public final ViewModelLazy V = new ViewModelLazy(y.a(m6.class), new l6(this, 0), new k6(this), new l6(this, 1));
    public final x4 X = new x4(this, 3);

    public final m0 B0() {
        return (m0) this.U.getValue();
    }

    public final m6 C0() {
        return (m6) this.V.getValue();
    }

    public final void D0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, n.f13548a, null, new u4(this, str, null, 8), 2);
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        super.onCreate(bundle);
        c cVar = null;
        e1 e1Var = (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user")) ? null : (e1) extras.getParcelable("user");
        if (e1Var != null && (str = e1Var.f8512a) != null && str.length() != 0) {
            RelativeLayout relativeLayout = B0().f7217a;
            relativeLayout.getClass();
            setContentView(relativeLayout);
            B0().f7220d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
            B0().f7220d.setNavigationContentDescription(getString(R.string.back));
            B0().f7220d.setNavigationOnClickListener(new s(this, 17));
            B0().f.setTypeface(b.f11719r);
            B0().e.setTypeface(b.f11720s);
            B0().f.setText(getString(R.string.user_recommended_apps, e1Var.f8515d));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
            B0().f7219c.setLayoutManager(linearLayoutManager);
            B0().f7219c.setItemAnimator(new DefaultItemAnimator());
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
            defaultItemAnimator.setSupportsChangeAnimations(false);
            int dimension = (int) getResources().getDimension(R.dimen.margin_m);
            B0().f7219c.addItemDecoration(new f(dimension, dimension));
            B0().f7219c.setItemAnimator(defaultItemAnimator);
            B0().f7219c.addOnScrollListener(new j6(linearLayoutManager, this));
            u7.m0 m0Var = C0().f10628c;
            String str2 = e1Var.f8512a;
            str2.getClass();
            m0Var.getClass();
            m0Var.g(null, str2);
            m6 m6VarC0 = C0();
            m6VarC0.getClass();
            w viewModelScope = ViewModelKt.getViewModelScope(m6VarC0);
            e eVar = i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new o(m6VarC0, this, cVar, 23), 2);
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar2 = i0.f12407a;
        r7.y.q(lifecycleScope, n.f13548a, null, new a6.c(this, cVar, 25), 2);
    }

    @Override // l4.a4
    public final void z0() {
    }
}
