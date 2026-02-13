package com.uptodown.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import d5.n0;
import h5.c1;
import h5.e1;
import j4.d0;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.x;
import kotlin.jvm.internal.y;
import l4.c7;
import l4.n6;
import l4.o6;
import l4.p6;
import l4.s6;
import l4.v6;
import l4.w;
import l4.w6;
import l4.x2;
import l4.x6;
import l4.z6;
import o4.b;
import r7.i0;
import s6.m;
import w6.c;
import w7.n;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PublicProfileActivity extends w {
    public static final /* synthetic */ int K = 0;
    public final m H = new m(new x2(this, 9));
    public final ViewModelLazy I = new ViewModelLazy(y.a(c7.class), new x6(this, 0), new w6(this), new x6(this, 1));
    public final ActivityResultLauncher J;

    public PublicProfileActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 17));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.J = activityResultLauncherRegisterForActivityResult;
    }

    public final n0 n0() {
        return (n0) this.H.getValue();
    }

    public final c7 o0() {
        return (c7) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        x xVar = new x();
        if (getIntent() != null && (extras = getIntent().getExtras()) != null && extras.containsKey("user")) {
            xVar.f10138a = extras.getParcelable("user");
        }
        Object obj = xVar.f10138a;
        int i10 = 1;
        int i11 = 0;
        int i12 = 2;
        c cVar = null;
        if (obj != null) {
            e1 e1Var = (e1) obj;
            RelativeLayout relativeLayout = n0().f7245a;
            relativeLayout.getClass();
            setContentView(relativeLayout);
            n0().f7252l.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.vector_arrow_left_white));
            n0().f7252l.setNavigationContentDescription(getString(R.string.back));
            n0().f7252l.setNavigationOnClickListener(new n6(this, i11));
            n0().f7251k.getViewTreeObserver().addOnScrollChangedListener(new o6(this, i11));
            n0().t.setTypeface(b.f11719r);
            n0().f7260u.setTypeface(b.f11720s);
            n0().f7253m.setTypeface(b.f11719r);
            n0().f7255o.setTypeface(b.f11719r);
            n0().f7258r.setTypeface(b.f11720s);
            n0().f7259s.setTypeface(b.f11719r);
            n0().f7261v.setTypeface(b.f11720s);
            n0().f7262w.setTypeface(b.f11719r);
            n0().f7256p.setTypeface(b.f11720s);
            n0().f7257q.setTypeface(b.f11719r);
            ((TextView) n0().f7249i.h).setTypeface(b.f11719r);
            ((TextView) n0().f7249i.f).setTypeface(b.f11719r);
            ((TextView) n0().f7249i.g).setTypeface(b.f11720s);
            ((TextView) n0().f7263x.h).setTypeface(b.f11719r);
            ((TextView) n0().f7263x.f).setTypeface(b.f11719r);
            ((TextView) n0().f7263x.g).setTypeface(b.f11720s);
            ((TextView) n0().f7250j.h).setTypeface(b.f11719r);
            ((TextView) n0().f7250j.f).setTypeface(b.f11719r);
            ((TextView) n0().f7250j.g).setTypeface(b.f11720s);
            q0(e1Var);
            ((RecyclerView) n0().f7249i.e).setLayoutManager(new LinearLayoutManager(this, 0, false));
            ((RecyclerView) n0().f7249i.e).setItemAnimator(null);
            ((RecyclerView) n0().f7250j.e).setLayoutManager(new LinearLayoutManager(this, 0, false));
            n0().e.setOnClickListener(new p6(this, e1Var, i11));
            n0().f.setOnClickListener(new p6(this, e1Var, i10));
            n0().g.setOnClickListener(new p6(this, e1Var, i12));
            e1 e1VarH = c1.h(this);
            if (l.a(e1Var.f8512a, e1VarH != null ? e1VarH.f8512a : null)) {
                ((RecyclerView) n0().f7263x.e).setLayoutManager(new LinearLayoutManager(this, 0, false));
                ((RecyclerView) n0().f7263x.e).setItemAnimator(null);
                ((TextView) n0().f7263x.h).setText(getString(R.string.my_wishlist));
                ((TextView) n0().f7263x.h).setText(getString(R.string.my_wishlist));
                ((TextView) n0().f7249i.h).setText(getString(R.string.my_recommended_apps));
                ((TextView) n0().f7250j.g).setText(getString(R.string.my_profile_no_review));
                ((TextView) n0().f7250j.h).setText(getString(R.string.public_profile_my_reviews));
                n0().f7253m.setVisibility(0);
                n0().f7253m.setOnClickListener(new p6(e1VarH, this));
                n0().f7247c.setOnClickListener(new p6(this, e1Var, 4));
                n0().f7254n.setTypeface(b.f11719r);
                n0().f7254n.setVisibility(0);
                n0().f7254n.setOnClickListener(new n6(this, i10));
                n0().f7255o.setVisibility(8);
            } else {
                n0().f7253m.setVisibility(8);
                n0().f7255o.setVisibility(0);
                n0().f7255o.setOnClickListener(new p6(this, e1Var, 5));
                ((TextView) n0().f7249i.h).setText(getString(R.string.recommended_apps));
                ((TextView) n0().f7250j.h).setText(getString(R.string.public_profile_activity_reviews_any_user_title));
            }
            c7 c7VarO0 = o0();
            String strValueOf = String.valueOf(((e1) xVar.f10138a).f8512a);
            e1 e1Var2 = (e1) xVar.f10138a;
            int i13 = e1Var2.f8516i;
            int i14 = e1Var2.f8517j;
            c7VarO0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(c7VarO0);
            e eVar = i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new z6(c7VarO0, i14, this, strValueOf, i13, null), 2);
        }
        e1 e1VarH2 = c1.h(this);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar2 = i0.f12407a;
        s7.c cVar2 = n.f13548a;
        r7.y.q(lifecycleScope, cVar2, null, new s6(this, xVar, e1VarH2, cVar, 0), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new s6(this, xVar, e1VarH2, cVar, 1), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new v6(this, cVar, i11), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new v6(this, cVar, i10), 2);
    }

    public final void p0(int i10, String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) FollowListActivity.class);
        intent.putExtra(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i10);
        intent.putExtra("username", str);
        intent.putExtra("userID", str2);
        float f = UptodownApp.E;
        startActivity(intent, k4.c.a(this));
    }

    public final void q0(e1 e1Var) {
        int i10 = UsernameTextView.f6728j;
        l1.b.j(n0().t, e1Var.d(), e1Var.f);
        n0().t.setText(e1Var.f8515d);
        n0().f7260u.setText(e1Var.f8519l);
        String str = e1Var.g;
        if (str != null && str.length() != 0 && n0().f7246b.getDrawable() == null) {
            d0 d0VarE = j4.y.d().e(e1Var.g);
            d0VarE.f9931c = true;
            d0VarE.e(n0().f7246b, null);
        }
        String strA = e1Var.a();
        if (strA != null && strA.length() != 0) {
            j4.y yVarD = j4.y.d();
            String str2 = e1Var.f8514c;
            d0 d0VarE2 = yVarD.e(str2 != null ? a3.a.o(a3.a.v(str2), UptodownApp.G, ":webp") : null);
            float f = UptodownApp.E;
            d0VarE2.g(k4.c.z(this));
            d0VarE2.e(n0().f7247c, null);
            n0().f7247c.setBackground(ContextCompat.getDrawable(this, R.drawable.shadow_user_icon));
        }
        if (e1Var.d()) {
            ImageView imageView = n0().f7247c;
            int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
            imageView.setPadding(dimension, dimension, dimension, dimension);
            n0().f7248d.setVisibility(0);
        }
        n0().f7259s.setText(v5.c.c(e1Var.f8518k));
        n0().f7262w.setText(String.valueOf(e1Var.h));
    }
}
