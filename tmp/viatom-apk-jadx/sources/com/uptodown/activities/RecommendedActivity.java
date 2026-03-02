package com.uptodown.activities;

import a3.o;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.internal.a;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RecommendedActivity;
import d5.o0;
import h5.c1;
import h5.e1;
import java.io.File;
import kotlin.jvm.internal.y;
import l4.a4;
import l4.d7;
import l4.g7;
import l4.i7;
import l4.j7;
import l4.k7;
import l4.l7;
import l4.n5;
import l4.u4;
import n4.d1;
import o4.b;
import r7.i0;
import r7.w;
import s6.m;
import s7.c;
import w7.n;
import x5.f;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class RecommendedActivity extends a4 {
    public static final /* synthetic */ int Z = 0;
    public d1 W;
    public final ActivityResultLauncher Y;
    public final m U = new m(new d7(this, 0));
    public final ViewModelLazy V = new ViewModelLazy(y.a(l7.class), new k7(this, 0), new j7(this), new k7(this, 1));
    public final n5 X = new n5(this, 4);

    public RecommendedActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(19));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.Y = activityResultLauncherRegisterForActivityResult;
    }

    public final o0 B0() {
        return (o0) this.U.getValue();
    }

    public final l7 C0() {
        return (l7) this.V.getValue();
    }

    public final void D0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, n.f13548a, null, new u4(this, str, null, 9), 2);
    }

    @Override // l4.w
    public final void d0() {
        d1 d1Var = this.W;
        if (d1Var != null) {
            d1Var.b();
        }
    }

    @Override // l4.w
    public final void f0(File file) {
        d1 d1Var = this.W;
        if (d1Var != null) {
            d1Var.b();
        }
        d1 d1Var2 = this.W;
        if (d1Var2 != null) {
            d1Var2.a(this, file);
        }
    }

    @Override // l4.w
    public final void g0(File file) {
        file.getClass();
        d1 d1Var = this.W;
        if (d1Var != null) {
            d1Var.a(this, file);
        }
    }

    @Override // l4.w
    public final void h0(File file) {
        d1 d1Var = this.W;
        if (d1Var != null) {
            d1Var.c(this, file);
        }
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = B0().f7268a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        o0 o0VarB0 = B0();
        if (drawable != null) {
            o0VarB0.e.setNavigationIcon(drawable);
            o0VarB0.e.setNavigationContentDescription(getString(R.string.back));
        }
        Toolbar toolbar = o0VarB0.e;
        TextView textView = o0VarB0.f;
        RecyclerView recyclerView = o0VarB0.f7270c;
        final int i10 = 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.e7

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecommendedActivity f10364b;

            {
                this.f10364b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                RecommendedActivity recommendedActivity = this.f10364b;
                switch (i11) {
                    case 0:
                        int i12 = RecommendedActivity.Z;
                        recommendedActivity.finish();
                        break;
                    case 1:
                        int i13 = RecommendedActivity.Z;
                        recommendedActivity.setResult(1);
                        recommendedActivity.finish();
                        break;
                    default:
                        int i14 = RecommendedActivity.Z;
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            RecommendedActivity recommendedActivity2 = this.f10364b;
                            l7 l7VarC0 = recommendedActivity2.C0();
                            l7VarC0.getClass();
                            r7.y.q(ViewModelKt.getViewModelScope(l7VarC0), null, null, new b9.p(l7VarC0, recommendedActivity2, new x4(l7VarC0, 6), (w6.c) null, 14), 3);
                            break;
                        }
                        break;
                }
            }
        });
        o0VarB0.f7272i.setTypeface(b.f11719r);
        final int i11 = 1;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        recyclerView.addItemDecoration(new f(dimension, dimension));
        recyclerView.setItemAnimator(defaultItemAnimator);
        o0VarB0.g.setTypeface(b.f11720s);
        o0VarB0.h.setTypeface(b.f11720s);
        textView.setTypeface(b.f11720s);
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: l4.e7

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecommendedActivity f10364b;

            {
                this.f10364b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                RecommendedActivity recommendedActivity = this.f10364b;
                switch (i112) {
                    case 0:
                        int i12 = RecommendedActivity.Z;
                        recommendedActivity.finish();
                        break;
                    case 1:
                        int i13 = RecommendedActivity.Z;
                        recommendedActivity.setResult(1);
                        recommendedActivity.finish();
                        break;
                    default:
                        int i14 = RecommendedActivity.Z;
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            RecommendedActivity recommendedActivity2 = this.f10364b;
                            l7 l7VarC0 = recommendedActivity2.C0();
                            l7VarC0.getClass();
                            r7.y.q(ViewModelKt.getViewModelScope(l7VarC0), null, null, new b9.p(l7VarC0, recommendedActivity2, new x4(l7VarC0, 6), (w6.c) null, 14), 3);
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 2;
        B0().f7271d.setOnClickListener(new View.OnClickListener(this) { // from class: l4.e7

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecommendedActivity f10364b;

            {
                this.f10364b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                RecommendedActivity recommendedActivity = this.f10364b;
                switch (i112) {
                    case 0:
                        int i122 = RecommendedActivity.Z;
                        recommendedActivity.finish();
                        break;
                    case 1:
                        int i13 = RecommendedActivity.Z;
                        recommendedActivity.setResult(1);
                        recommendedActivity.finish();
                        break;
                    default:
                        int i14 = RecommendedActivity.Z;
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            RecommendedActivity recommendedActivity2 = this.f10364b;
                            l7 l7VarC0 = recommendedActivity2.C0();
                            l7VarC0.getClass();
                            r7.y.q(ViewModelKt.getViewModelScope(l7VarC0), null, null, new b9.p(l7VarC0, recommendedActivity2, new x4(l7VarC0, 6), (w6.c) null, 14), 3);
                            break;
                        }
                        break;
                }
            }
        });
        o0VarB0.f7269b.setOnClickListener(new e5.n(19));
        recyclerView.addOnScrollListener(new g7(linearLayoutManager, this));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        c cVar = n.f13548a;
        w6.c cVar2 = null;
        r7.y.q(lifecycleScope, cVar, null, new i7(this, cVar2, i10), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new i7(this, cVar2, i11), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        String str;
        super.onResume();
        e1 e1VarH = c1.h(this);
        if (e1VarH == null || (str = e1VarH.f8512a) == null || str.length() == 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new androidx.constraintlayout.helper.widget.a(this, 7), 500L);
            return;
        }
        l7 l7VarC0 = C0();
        l7VarC0.getClass();
        w viewModelScope = ViewModelKt.getViewModelScope(l7VarC0);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new o(l7VarC0, this, (w6.c) null, 24), 2);
    }

    @Override // l4.a4
    public final void z0() {
    }
}
