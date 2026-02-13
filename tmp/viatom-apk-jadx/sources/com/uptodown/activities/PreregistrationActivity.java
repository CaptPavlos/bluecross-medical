package com.uptodown.activities;

import a6.c;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b9.r;
import com.uptodown.R;
import d5.l0;
import e5.b2;
import e5.n;
import h5.k;
import kotlin.jvm.internal.y;
import l4.d6;
import l4.e6;
import l4.f6;
import l4.g6;
import l4.i6;
import l4.w;
import l4.x4;
import n4.d0;
import o4.b;
import r7.i0;
import s6.m;
import x5.f;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PreregistrationActivity extends w {
    public static final /* synthetic */ int M = 0;
    public d0 J;
    public final ActivityResultLauncher L;
    public final ViewModelLazy H = new ViewModelLazy(y.a(i6.class), new g6(this, 0), new f6(this), new g6(this, 1));
    public final m I = new m(new d6(this, 0));
    public final x4 K = new x4(this, 2);

    public PreregistrationActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 16));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.L = activityResultLauncherRegisterForActivityResult;
    }

    public final l0 n0() {
        return (l0) this.I.getValue();
    }

    public final void o0(k kVar) {
        b2 b2Var = new b2();
        b2Var.f7688c = kVar;
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add(n0().f7202b.getId(), b2Var, (String) null).addToBackStack(String.valueOf(kVar.f8632a)).commit();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7201a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        l0 l0VarN0 = n0();
        if (drawable != null) {
            l0VarN0.e.setNavigationIcon(drawable);
            l0VarN0.e.setNavigationContentDescription(getString(R.string.back));
        }
        Toolbar toolbar = l0VarN0.e;
        RecyclerView recyclerView = l0VarN0.f7204d;
        TextView textView = l0VarN0.f;
        toolbar.setNavigationOnClickListener(new e6(this, 0));
        l0VarN0.h.setTypeface(b.f11719r);
        textView.setTypeface(b.f11719r);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        n0().f7204d.addItemDecoration(new f(dimension, dimension));
        l0VarN0.g.setTypeface(b.f11720s);
        l0VarN0.f7203c.setOnClickListener(new n(18));
        textView.setOnClickListener(new e6(this, 1));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new c(this, null, 24), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        i6 i6Var = (i6) this.H.getValue();
        i6Var.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(i6Var);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new r(i6Var, false, this, (w6.c) null), 2);
    }
}
