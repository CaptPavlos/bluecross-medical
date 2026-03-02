package com.uptodown.activities;

import android.content.SharedPreferences;
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
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.internal.a;
import com.uptodown.R;
import com.uptodown.activities.WishlistActivity;
import d5.l1;
import java.io.File;
import kotlin.jvm.internal.y;
import l4.a4;
import l4.ic;
import l4.kb;
import l4.lc;
import l4.mc;
import l4.nc;
import l4.pc;
import l4.u4;
import l4.x4;
import n4.d1;
import o4.b;
import r7.i0;
import s6.m;
import w6.c;
import w7.n;
import x5.f;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class WishlistActivity extends a4 {
    public static final /* synthetic */ int Z = 0;
    public d1 W;
    public final ActivityResultLauncher Y;
    public final m U = new m(new ic(this, 0));
    public final ViewModelLazy V = new ViewModelLazy(y.a(pc.class), new nc(this, 0), new mc(this), new nc(this, 1));
    public final x4 X = new x4(this, 13);

    public WishlistActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(20));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.Y = activityResultLauncherRegisterForActivityResult;
    }

    public final l1 B0() {
        return (l1) this.U.getValue();
    }

    public final pc C0() {
        return (pc) this.V.getValue();
    }

    public final void D0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, n.f13548a, null, new u4(this, str, null, 15), 2);
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
        RelativeLayout relativeLayout = B0().f7205a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        l1 l1VarB0 = B0();
        if (drawable != null) {
            l1VarB0.f7208d.setNavigationIcon(drawable);
            l1VarB0.f7208d.setNavigationContentDescription(getString(R.string.back));
        }
        Toolbar toolbar = l1VarB0.f7208d;
        TextView textView = l1VarB0.e;
        RecyclerView recyclerView = l1VarB0.f7207c;
        final int i10 = 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.jc

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WishlistActivity f10537b;

            {
                this.f10537b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                WishlistActivity wishlistActivity = this.f10537b;
                switch (i11) {
                    case 0:
                        int i12 = WishlistActivity.Z;
                        wishlistActivity.finish();
                        break;
                    default:
                        int i13 = WishlistActivity.Z;
                        wishlistActivity.setResult(1);
                        wishlistActivity.finish();
                        break;
                }
            }
        });
        l1VarB0.g.setTypeface(b.f11719r);
        final int i11 = 1;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        B0().f7207c.addItemDecoration(new f(dimension, dimension));
        recyclerView.setItemAnimator(defaultItemAnimator);
        l1VarB0.f.setTypeface(b.f11720s);
        textView.setTypeface(b.f11719r);
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: l4.jc

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WishlistActivity f10537b;

            {
                this.f10537b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                WishlistActivity wishlistActivity = this.f10537b;
                switch (i112) {
                    case 0:
                        int i12 = WishlistActivity.Z;
                        wishlistActivity.finish();
                        break;
                    default:
                        int i13 = WishlistActivity.Z;
                        wishlistActivity.setResult(1);
                        wishlistActivity.finish();
                        break;
                }
            }
        });
        l1VarB0.f7206b.setOnClickListener(new e5.n(26));
        recyclerView.addOnScrollListener(new lc(linearLayoutManager, this));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, n.f13548a, null, new kb(this, (c) null, 3), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        SharedPreferences sharedPreferences;
        super.onResume();
        SharedPreferences sharedPreferences2 = getSharedPreferences("SharedPreferencesUser", 0);
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
        if (string == null && sharedPreferences2.getString("is_turbo", null) == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new androidx.constraintlayout.helper.widget.a(this, 8), 500L);
        } else {
            C0().a(this);
        }
    }

    @Override // l4.a4
    public final void z0() {
    }
}
