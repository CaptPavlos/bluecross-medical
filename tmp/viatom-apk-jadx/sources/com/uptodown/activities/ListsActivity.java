package com.uptodown.activities;

import a3.i0;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import b9.p;
import c2.d;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d0.i;
import d5.x;
import e5.b2;
import e5.n;
import h5.k;
import j4.d0;
import java.util.ArrayList;
import k4.c;
import kotlin.jvm.internal.y;
import l4.h1;
import l4.j1;
import l4.k1;
import l4.l1;
import l4.o1;
import l4.p1;
import l4.w;
import o4.b;
import s6.m;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ListsActivity extends w {
    public static final /* synthetic */ int K = 0;
    public final m H = new m(new i0(this, 28));
    public final ViewModelLazy I = new ViewModelLazy(y.a(p1.class), new l1(this, 0), new k1(this), new l1(this, 1));
    public final ActivityResultLauncher J;

    public ListsActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 11));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.J = activityResultLauncherRegisterForActivityResult;
    }

    public final void n0(String str, LinearLayout linearLayout, int i10) throws Resources.NotFoundException {
        str.getClass();
        ImageView imageView = new ImageView(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.icon_size_l);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMargins((int) getResources().getDimension(R.dimen.lists_items_iv_margin), 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setContentDescription(null);
        imageView.setElevation(getResources().getDimension(R.dimen.button_elevation));
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_logo_google));
        imageView.setElevation(-i10);
        d0 d0VarE = j4.y.d().e(str);
        d0VarE.f(R.drawable.shape_bg_placeholder);
        float f = UptodownApp.E;
        d0VarE.g(c.y(this));
        d0VarE.e(imageView, null);
        linearLayout.addView(imageView);
    }

    public final x o0() {
        return (x) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = o0().f7391a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        x xVarO0 = o0();
        if (drawable != null) {
            xVarO0.g.setNavigationIcon(drawable);
            xVarO0.g.setNavigationContentDescription(getString(R.string.back));
        }
        Toolbar toolbar = xVarO0.g;
        d dVar = xVarO0.f7393c;
        TextView textView = (TextView) dVar.h;
        d dVar2 = xVarO0.f7394d;
        TextView textView2 = (TextView) dVar2.h;
        d dVar3 = xVarO0.e;
        TextView textView3 = (TextView) dVar3.h;
        int i10 = 0;
        toolbar.setNavigationOnClickListener(new h1(this, i10));
        xVarO0.h.setTypeface(b.f11719r);
        textView3.setTypeface(b.f11719r);
        ((TextView) dVar3.g).setTypeface(b.f11720s);
        textView3.setText(getString(R.string.my_wishlist));
        textView2.setTypeface(b.f11719r);
        ((TextView) dVar2.g).setTypeface(b.f11720s);
        textView2.setText(getString(R.string.my_recommended_apps));
        textView.setTypeface(b.f11719r);
        ((TextView) dVar.g).setTypeface(b.f11720s);
        textView.setText(getString(R.string.my_preregistrations));
        xVarO0.f.setOnClickListener(new n(7));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = r7.i0.f12407a;
        s7.c cVar = w7.n.f13548a;
        w6.c cVar2 = null;
        r7.y.q(lifecycleScope, cVar, null, new j1(this, cVar2, i10), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new j1(this, cVar2, 1), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new j1(this, cVar2, 2), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new j1(this, cVar2, 3), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        SharedPreferences sharedPreferences;
        super.onResume();
        SharedPreferences sharedPreferences2 = getSharedPreferences("SharedPreferencesUser", 0);
        w6.c cVar = null;
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
        if (string == null && sharedPreferences2.getString("is_turbo", null) == null) {
            return;
        }
        p1 p1VarP0 = p0();
        p1VarP0.getClass();
        r7.y.q(ViewModelKt.getViewModelScope(p1VarP0), null, null, new p(this, p1VarP0, new i(p1VarP0, 26), cVar, 9), 3);
        r7.y.q(ViewModelKt.getViewModelScope(p1VarP0), null, null, new p(this, p1VarP0, new y2.c(p1VarP0, 27), cVar, 10), 3);
        ArrayList arrayList = new ArrayList();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(p1VarP0);
        e eVar = r7.i0.f12407a;
        y7.d dVar = y7.d.f14116a;
        r7.y.q(viewModelScope, dVar, null, new o1(this, p1VarP0, arrayList, (w6.c) null), 2);
        r7.y.q(ViewModelKt.getViewModelScope(p1VarP0), dVar, null, new o1(this, new ArrayList(), p1VarP0, (w6.c) null), 2);
    }

    public final p1 p0() {
        return (p1) this.I.getValue();
    }

    public final String q0(int i10) {
        if (i10 == 1) {
            String string = getString(R.string.apps_count_1);
            string.getClass();
            return string;
        }
        String string2 = getString(R.string.apps_count, String.valueOf(i10));
        string2.getClass();
        return string2;
    }

    public final void r0(k kVar) {
        b2 b2Var = new b2();
        b2Var.f7688c = kVar;
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add(R.id.fl_lists, b2Var, (String) null).addToBackStack(String.valueOf(kVar.f8632a)).commit();
    }
}
