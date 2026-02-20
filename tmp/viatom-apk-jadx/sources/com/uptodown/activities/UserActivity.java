package com.uptodown.activities;

import a3.a;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import c5.b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import d5.a1;
import h5.c1;
import h5.e1;
import j4.d0;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import l4.aa;
import l4.ea;
import l4.ga;
import l4.ha;
import l4.ia;
import l4.ob;
import l4.sb;
import l4.tb;
import l4.w;
import l4.x2;
import l4.z9;
import r7.i0;
import s6.m;
import s7.c;
import w7.n;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UserActivity extends w {
    public static final /* synthetic */ int Q = 0;
    public final m H = new m(new x2(this, 16));
    public final ViewModelLazy I = new ViewModelLazy(y.a(tb.class), new ha(this, 0), new ga(this), new ha(this, 1));
    public final ViewModelLazy J = new ViewModelLazy(y.a(ob.class), new ha(this, 2), new ia(this), new ha(this, 3));
    public String K;
    public final ActivityResultLauncher L;
    public final ActivityResultLauncher M;
    public final ActivityResultLauncher N;
    public final ActivityResultLauncher O;
    public final ActivityResultLauncher P;

    public UserActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new aa(this, 1));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.L = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new aa(this, 2));
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.M = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new aa(this, 3));
        activityResultLauncherRegisterForActivityResult3.getClass();
        this.N = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new aa(this, 4));
        activityResultLauncherRegisterForActivityResult4.getClass();
        this.O = activityResultLauncherRegisterForActivityResult4;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new aa(this, 5));
        activityResultLauncherRegisterForActivityResult5.getClass();
        this.P = activityResultLauncherRegisterForActivityResult5;
    }

    public final void n0(Context context) {
        tb tbVarP0 = p0();
        tbVarP0.getClass();
        context.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(tbVarP0);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new b(1, context, null), 2);
        o0().f6849c.setImageResource(R.drawable.vector_user_login);
        ImageView imageView = o0().f6849c;
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        imageView.setPadding(dimension, dimension, dimension, dimension);
        o0().f6849c.setForeground(null);
        o0().f6849c.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_user_avatar_bg));
        o0().K.setText(getString(R.string.sign_in_sign_up));
        int i10 = UsernameTextView.f6728j;
        l1.b.K(o0().K);
        o0().K.setTextColor(ContextCompat.getColor(this, R.color.text_terciary));
        o0().I.setText(getString(R.string.subscribe_to_uptodown_turbo));
        o0().D.setVisibility(8);
        o0().f6863v.setVisibility(8);
        o0().f6855m.setVisibility(8);
        this.K = null;
        o0().f6848b.setVisibility(8);
    }

    public final a1 o0() {
        return (a1) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = o0().f6847a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            o0().f6860r.setNavigationIcon(drawable);
            o0().f6860r.setNavigationContentDescription(getString(R.string.back));
        }
        int i10 = 0;
        o0().f6860r.setNavigationOnClickListener(new z9(this, i10));
        o0().f6860r.inflateMenu(R.menu.toolbar_menu_user);
        o0().f6860r.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable));
        o0().f6860r.setOnMenuItemClickListener(new aa(this, i10));
        o0().G.setTypeface(o4.b.f11719r);
        o0().K.setTypeface(o4.b.f11719r);
        o0().D.setTypeface(o4.b.f11719r);
        o0().f6864w.setTypeface(o4.b.f11719r);
        o0().J.setTypeface(o4.b.f11719r);
        o0().A.setTypeface(o4.b.f11719r);
        o0().f6861s.setTypeface(o4.b.f11719r);
        o0().f6866z.setTypeface(o4.b.f11719r);
        o0().B.setTypeface(o4.b.f11719r);
        o0().t.setTypeface(o4.b.f11719r);
        o0().F.setTypeface(o4.b.f11719r);
        o0().f6862u.setTypeface(o4.b.f11719r);
        o0().C.setTypeface(o4.b.f11719r);
        o0().I.setTypeface(o4.b.f11719r);
        o0().f6855m.setVisibility(8);
        o0().H.setTypeface(o4.b.f11720s);
        o0().f6865x.setTypeface(o4.b.f11720s);
        o0().E.setTypeface(o4.b.f11720s);
        o0().y.setTypeface(o4.b.f11720s);
        o0().L.setTypeface(o4.b.f11720s);
        o0().f6863v.setTypeface(o4.b.f11720s);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        c cVar = n.f13548a;
        w6.c cVar2 = null;
        int i11 = 1;
        int i12 = 2;
        r7.y.q(lifecycleScope, cVar, null, new ea(this, cVar2, i11), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new ea(this, cVar2, i12), 2);
        int i13 = 3;
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new ea(this, cVar2, i13), 2);
        tb tbVarP0 = p0();
        tbVarP0.getClass();
        r7.y.q(ViewModelKt.getViewModelScope(tbVarP0), d.f14116a, null, new sb(this, tbVarP0, cVar2, i10), 2);
        o0().f6849c.setOnClickListener(new z9(this, i11));
        o0().f6859q.setOnClickListener(new z9(this, i12));
        o0().D.setOnClickListener(new z9(this, i13));
        o0().f6858p.setOnClickListener(new z9(this, 4));
        o0().f.setOnClickListener(new z9(this, 5));
        o0().f6857o.setOnClickListener(new z9(this, 6));
        o0().f6852j.setOnClickListener(new z9(this, 7));
        o0().f6851i.setOnClickListener(new z9(this, 8));
        o0().f6850d.setOnClickListener(new z9(this, 9));
        o0().e.setOnClickListener(new z9(this, 10));
        o0().f6854l.setOnClickListener(new z9(this, 11));
        o0().f6856n.setOnClickListener(new z9(this, 12));
        o0().g.setOnClickListener(new z9(this, 13));
        o0().h.setOnClickListener(new z9(this, 14));
        o0().f6853k.setOnClickListener(new z9(this, 15));
        o0().L.setOnClickListener(new z9(this, 16));
        o0().f6863v.setOnClickListener(new z9(this, 17));
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new ea(this, cVar2, i10), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        tb tbVarP0 = p0();
        tbVarP0.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(tbVarP0);
        e eVar = i0.f12407a;
        d dVar = d.f14116a;
        w6.c cVar = null;
        r7.y.q(viewModelScope, dVar, null, new sb(this, tbVarP0, cVar, 0), 2);
        Menu menu = o0().f6860r.getMenu();
        MenuItem menuItemFindItem = menu != null ? menu.findItem(R.id.action_dark_mode) : null;
        if ((getResources().getConfiguration().uiMode & 48) == 16) {
            if (menuItemFindItem != null) {
                menuItemFindItem.setIcon(ContextCompat.getDrawable(this, R.drawable.vector_moon));
            }
        } else if (menuItemFindItem != null) {
            menuItemFindItem.setIcon(ContextCompat.getDrawable(this, R.drawable.vector_sun));
        }
        e1 e1VarH = c1.h(this);
        if ((e1VarH != null ? e1VarH.f8512a : null) == null || !c1.g(this)) {
            n0(this);
            return;
        }
        if (e1VarH.a() != null) {
            j4.y yVarD = j4.y.d();
            String str = e1VarH.f8514c;
            d0 d0VarE = yVarD.e(str != null ? a.o(a.v(str), UptodownApp.G, ":webp") : null);
            float f = UptodownApp.E;
            d0VarE.g(k4.c.y(this));
            d0VarE.e(o0().f6849c, null);
            o0().f6849c.setBackground(ContextCompat.getDrawable(this, R.drawable.shadow_user_icon));
        } else {
            o0().f6849c.setImageResource(R.drawable.vector_user_profile);
        }
        o0().f6849c.setPadding(0, 0, 0, 0);
        o0().K.setText(e1VarH.f8515d);
        if (!e1VarH.d() || l.a(e1VarH.f, "type0")) {
            int i10 = UsernameTextView.f6728j;
            l1.b.K(o0().K);
        } else {
            int i11 = UsernameTextView.f6728j;
            l1.b.j(o0().K, e1VarH.d(), e1VarH.f);
        }
        if (e1VarH.d()) {
            o0().f6848b.setVisibility(0);
            ImageView imageView = o0().f6849c;
            int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
            imageView.setPadding(dimension, dimension, dimension, dimension);
            o0().I.setText(getString(R.string.turbo_welcome_popup_manage_subscription));
        } else {
            o0().I.setText(getString(R.string.subscribe_to_uptodown_turbo));
        }
        o0().f6863v.setVisibility(0);
        if (!e1VarH.d()) {
            o0().f6855m.setVisibility(8);
        } else if (this.K == null) {
            tb tbVarP02 = p0();
            tbVarP02.getClass();
            r7.y.q(ViewModelKt.getViewModelScope(tbVarP02), dVar, null, new sb(this, tbVarP02, cVar, 1), 2);
        } else {
            o0().f6855m.setVisibility(0);
        }
        o0().D.setVisibility(0);
        float f10 = UptodownApp.E;
        k4.c.B(this);
        k4.c.A(this);
    }

    public final tb p0() {
        return (tb) this.I.getValue();
    }

    public final void q0() {
        Intent intent = new Intent(this, (Class<?>) LoginActivity.class);
        float f = UptodownApp.E;
        this.L.launch(intent, k4.c.b(this));
    }
}
