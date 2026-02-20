package com.uptodown.activities;

import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import d5.c1;
import e5.s;
import h5.e1;
import kotlin.jvm.internal.y;
import l4.qa;
import l4.sa;
import l4.ta;
import l4.u4;
import l4.ua;
import l4.w;
import l4.wa;
import l4.x2;
import l4.x4;
import n4.a1;
import o4.b;
import r7.i0;
import s6.m;
import w6.c;
import w7.n;
import x5.i;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UserCommentsActivity extends w {
    public static final /* synthetic */ int L = 0;
    public a1 J;
    public final m H = new m(new x2(this, 18));
    public final ViewModelLazy I = new ViewModelLazy(y.a(wa.class), new ua(this, 0), new ta(this), new ua(this, 1));
    public final x4 K = new x4(this, 11);

    public final c1 n0() {
        return (c1) this.H.getValue();
    }

    public final wa o0() {
        return (wa) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f6954a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        c cVar = null;
        ((e1) o0().e.getValue()).f8512a = (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("userID")) ? null : extras.getString("userID");
        n0().f6957d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        n0().f6957d.setNavigationContentDescription(getString(R.string.back));
        n0().f6957d.setNavigationOnClickListener(new s(this, 19));
        n0().f.setTypeface(b.f11719r);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        int i10 = 1;
        int i11 = 0;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        n0().f6956c.addItemDecoration(new i(dimension, dimension, dimension, dimension));
        n0().f6956c.setLayoutManager(linearLayoutManager);
        n0().f6956c.setItemAnimator(null);
        n0().f6956c.addOnScrollListener(new qa(linearLayoutManager, this));
        String str = ((e1) o0().e.getValue()).f8512a;
        if (str != null && str.length() != 0) {
            wa waVarO0 = o0();
            waVarO0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(waVarO0);
            e eVar = i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new u4(waVarO0, this, cVar, 12), 2);
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar2 = i0.f12407a;
        s7.c cVar2 = n.f13548a;
        r7.y.q(lifecycleScope, cVar2, null, new sa(this, cVar, i11), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new sa(this, cVar, i10), 2);
    }
}
