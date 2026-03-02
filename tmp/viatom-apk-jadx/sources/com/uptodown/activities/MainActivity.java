package com.uptodown.activities;

import a3.x;
import a3.z0;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mbridge.msdk.dycreator.baseview.a;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.gcm.MyFirebaseMessagingService;
import com.uptodown.tv.ui.activity.TvMainActivity;
import com.uptodown.views.ScrollableTextView;
import d5.s;
import e5.d1;
import e5.j;
import e5.j0;
import e5.m1;
import e5.n1;
import e5.t1;
import h5.c1;
import h5.e1;
import h5.h;
import h5.k;
import h5.q;
import h5.y0;
import j$.util.concurrent.ConcurrentHashMap;
import j4.d0;
import j4.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.a0;
import l4.b;
import l4.b2;
import l4.g2;
import l4.h2;
import l4.i2;
import l4.l2;
import l4.m;
import l4.m2;
import l4.o2;
import l4.p2;
import l4.q2;
import l4.r2;
import l4.s2;
import l4.t2;
import o7.u;
import r7.i0;
import t1.c;
import t6.l;
import v5.f;
import v5.g;
import v5.n;
import w2.r;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MainActivity extends b2 {
    public static final /* synthetic */ int B0 = 0;
    public final ActivityResultLauncher A0;
    public RelativeLayout L;
    public int M;
    public boolean O;
    public RelativeLayout P;
    public AppBarLayout Q;
    public SwitchCompat R;
    public SwitchCompat S;
    public h T;
    public ViewPager2 U;
    public RelativeLayout V;
    public RelativeLayout W;
    public ProgressBar X;
    public TabLayout Y;
    public n1 Z;

    /* renamed from: j0, reason: collision with root package name */
    public d1 f6640j0;

    /* renamed from: k0, reason: collision with root package name */
    public t1 f6641k0;
    public m1 l0;

    /* renamed from: p0, reason: collision with root package name */
    public FrameLayout f6645p0;

    /* renamed from: q0, reason: collision with root package name */
    public s f6646q0;

    /* renamed from: r0, reason: collision with root package name */
    public FrameLayout f6647r0;

    /* renamed from: s0, reason: collision with root package name */
    public ImageView f6648s0;

    /* renamed from: t0, reason: collision with root package name */
    public ImageView f6649t0;

    /* renamed from: v0, reason: collision with root package name */
    public final ActivityResultLauncher f6651v0;

    /* renamed from: w0, reason: collision with root package name */
    public final ActivityResultLauncher f6652w0;

    /* renamed from: x0, reason: collision with root package name */
    public final ActivityResultLauncher f6653x0;

    /* renamed from: y0, reason: collision with root package name */
    public final ActivityResultLauncher f6654y0;
    public final b z0;
    public final ArrayList N = new ArrayList();

    /* renamed from: m0, reason: collision with root package name */
    public final ArrayList f6642m0 = new ArrayList();

    /* renamed from: n0, reason: collision with root package name */
    public final ArrayList f6643n0 = new ArrayList();

    /* renamed from: o0, reason: collision with root package name */
    public long f6644o0 = -1;

    /* renamed from: u0, reason: collision with root package name */
    public final o2 f6650u0 = new o2(this);

    public MainActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g2(0, this));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f6651v0 = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g2(1, this));
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.f6652w0 = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g2(2, this));
        activityResultLauncherRegisterForActivityResult3.getClass();
        this.f6653x0 = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g2(3, this));
        activityResultLauncherRegisterForActivityResult4.getClass();
        this.f6654y0 = activityResultLauncherRegisterForActivityResult4;
        this.z0 = new b(this, 3);
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g2(4, this));
        activityResultLauncherRegisterForActivityResult5.getClass();
        this.A0 = activityResultLauncherRegisterForActivityResult5;
    }

    public static final boolean w0(MainActivity mainActivity) {
        TextView textView = (TextView) mainActivity.findViewById(R.id.tv_title_auto_update);
        return (textView == null || textView.getVisibility() != 0) && !mainActivity.I0();
    }

    public static final void x0(MainActivity mainActivity, String str) {
        Bundle bundleF = a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        c cVar = mainActivity.f10934v;
        if (cVar != null) {
            cVar.e(bundleF, "tab_clicked");
        }
    }

    public final void A0() throws Resources.NotFoundException {
        int i10 = this.M;
        ArrayList arrayList = this.N;
        String strG = a3.a.g(((h5.m1) arrayList.get(i10)).f8665a, "wizard_step_", "_shown");
        boolean z9 = true;
        z9 = true;
        try {
            SharedPreferences.Editor editorEdit = getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.putBoolean(strG, true);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RelativeLayout relativeLayoutA = ((h5.m1) arrayList.get(this.M)).a();
        l2 l2Var = new l2(z9 ? 1 : 0, this);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_next_out);
        float f = UptodownApp.E;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            l2Var.onAnimationEnd(animationLoadAnimation);
            return;
        }
        float f10 = UptodownApp.E;
        animationLoadAnimation.setAnimationListener(l2Var);
        relativeLayoutA.startAnimation(animationLoadAnimation);
    }

    public final void B0(h hVar, boolean z9) {
        j0 j0Var = new j0();
        Bundle bundle = new Bundle();
        if (hVar != null) {
            bundle.putParcelable("appInfo", hVar);
        }
        j0Var.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        if (((CoordinatorLayout) findViewById(R.id.rl_main_scrollable)) == null) {
            String string = getString(R.string.error_generico);
            string.getClass();
            C(string);
            return;
        }
        try {
            fragmentTransactionBeginTransaction.replace(R.id.rl_main_scrollable, j0Var);
            fragmentTransactionBeginTransaction.addToBackStack(null);
            if (z9) {
                fragmentTransactionBeginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            }
            if (isFinishing() || getSupportFragmentManager().isDestroyed()) {
                return;
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
            String string2 = getString(R.string.error_generico);
            string2.getClass();
            C(string2);
        }
    }

    public final void C0(int i10) {
        TabLayout tabLayout = this.Y;
        tabLayout.getClass();
        if (i10 < tabLayout.getTabCount()) {
            TabLayout tabLayout2 = this.Y;
            tabLayout2.getClass();
            if (tabLayout2.getSelectedTabPosition() != i10) {
                TabLayout tabLayout3 = this.Y;
                tabLayout3.getClass();
                TabLayout.Tab tabAt = tabLayout3.getTabAt(i10);
                if (tabAt != null) {
                    tabAt.select();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.D0():void");
    }

    public final void E0() throws Resources.NotFoundException {
        s sVar;
        FrameLayout frameLayout = this.f6645p0;
        if (frameLayout == null || frameLayout.getChildCount() == 0 || (sVar = this.f6646q0) == null) {
            return;
        }
        sVar.getClass();
        RelativeLayout relativeLayout = sVar.f7327b;
        relativeLayout.getClass();
        l2 l2Var = new l2(2, this);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            l2Var.onAnimationEnd(animationLoadAnimation);
            return;
        }
        float f10 = UptodownApp.E;
        animationLoadAnimation.setAnimationListener(l2Var);
        relativeLayout.startAnimation(animationLoadAnimation);
    }

    public final void F0() {
        AlertDialog alertDialog;
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialog2 = this.f10935w;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        z0 z0VarK = z0.k(getLayoutInflater());
        TextView textView = (TextView) z0VarK.f197c;
        TextView textView2 = (TextView) z0VarK.e;
        TextView textView3 = (TextView) z0VarK.f198d;
        textView3.setTypeface(o4.b.f11720s);
        textView3.setText(getString(R.string.notification_permission_request));
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new m(12, this));
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new m(17, this));
        builder.setView((LinearLayout) z0VarK.f);
        builder.setCancelable(true);
        this.f10935w = builder.create();
        if (isFinishing() || (alertDialog = this.f10935w) == null) {
            return;
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            a3.a.A(window, 0);
        }
        AlertDialog alertDialog3 = this.f10935w;
        alertDialog3.getClass();
        alertDialog3.show();
    }

    public final Fragment G0() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            fragments.getClass();
            return (Fragment) l.i0(fragments);
        }
        ArrayList arrayList = this.f6642m0;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Fragment) l.i0(arrayList);
    }

    public final void H0() throws Resources.NotFoundException {
        FrameLayout frameLayout = this.f6647r0;
        if (frameLayout == null || frameLayout.getChildCount() == 0) {
            return;
        }
        FrameLayout frameLayout2 = this.f6647r0;
        frameLayout2.getClass();
        l2 l2Var = new l2(3, this);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.popup_turbo_out);
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            l2Var.onAnimationEnd(animationLoadAnimation);
            return;
        }
        float f10 = UptodownApp.E;
        animationLoadAnimation.setAnimationListener(l2Var);
        frameLayout2.startAnimation(animationLoadAnimation);
    }

    public final boolean I0() {
        TextView textView = (TextView) findViewById(R.id.tv_msg_status_526);
        return textView != null && textView.getVisibility() == 0;
    }

    public final boolean J0() {
        q qVar;
        SharedPreferences sharedPreferences;
        g gVarL = g.f13148u.l(this);
        gVarL.a();
        String packageName = getPackageName();
        packageName.getClass();
        y0 y0VarM = gVarL.M(packageName);
        File fileG = null;
        q qVarA = y0VarM != null ? y0VarM.a(this) : null;
        if (qVarA != null && qVarA.c()) {
            fileG = qVarA.g();
        }
        gVarL.b();
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences.contains("is_status_code_526") ? sharedPreferences.getBoolean("is_status_code_526", false) : false;
        if (z9) {
            setContentView(R.layout.status_526);
            TextView textView = (TextView) findViewById(R.id.tv_msg_status_526);
            textView.setTypeface(o4.b.f11720s);
            ConcurrentHashMap concurrentHashMap = n.f13169a;
            textView.setText(n.a(getString(R.string.msg_update_app_status_526)));
            TextView textView2 = (TextView) findViewById(R.id.tv_update_status_526);
            textView2.setTypeface(o4.b.f11720s);
            textView2.setOnClickListener(new m(7, this));
            return true;
        }
        if (fileG == null) {
            return false;
        }
        g gVarL2 = g.f13148u.l(this);
        gVarL2.a();
        String packageName2 = getPackageName();
        packageName2.getClass();
        y0 y0VarM2 = gVarL2.M(packageName2);
        gVarL2.b();
        if (y0VarM2 != null && 704 < y0VarM2.f8796c && (qVar = y0VarM2.f8798i) != null && qVar.c()) {
            setContentView(R.layout.dialog_auto_update);
            ((TextView) findViewById(R.id.tv_title_auto_update)).setTypeface(o4.b.f11719r);
            ((TextView) findViewById(R.id.tv_desc_auto_update)).setTypeface(o4.b.f11720s);
            ((TextView) findViewById(R.id.tv_info_auto_update)).setTypeface(o4.b.f11720s);
            TextView textView3 = (TextView) findViewById(R.id.tv_installed_version_auto_update);
            textView3.setTypeface(o4.b.f11720s);
            PackageManager packageManager = getPackageManager();
            packageManager.getClass();
            String packageName3 = getPackageName();
            packageName3.getClass();
            textView3.setText(getString(R.string.autoupdate_installed_version, l5.a.f(packageManager, packageName3, 0).versionName));
            TextView textView4 = (TextView) findViewById(R.id.tv_update_version_auto_update);
            textView4.setTypeface(o4.b.f11719r);
            textView4.setText(getString(R.string.autoupdate_update_version, y0VarM2.f8797d));
            TextView textView5 = (TextView) findViewById(R.id.tv_update_size_auto_update);
            textView5.setTypeface(o4.b.f11720s);
            q qVar2 = y0VarM2.f8798i;
            if (qVar2 != null) {
                textView5.setText(getString(R.string.autoupdate_update_size, l1.b.M(this, qVar2.k())));
            }
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_uptodown_version_details);
            ((TextView) findViewById(R.id.tv_uptodown_version_details_label)).setTypeface(o4.b.f11720s);
            ImageView imageView = (ImageView) findViewById(R.id.iv_uptodown_version_details_label);
            TextView textView6 = (TextView) findViewById(R.id.tv_uptodown_version_details);
            textView6.setTypeface(o4.b.f11720s);
            new r(this, y0VarM2.f8795b, new p2(textView6, this, y0VarM2), LifecycleOwnerKt.getLifecycleScope(this));
            relativeLayout.setOnClickListener(new b5.a(24, textView6, imageView));
            ((TextView) findViewById(R.id.tv_update)).setTypeface(o4.b.f11719r);
            ((RelativeLayout) findViewById(R.id.rl_update)).setOnClickListener(new m(2, this));
            ((TextView) findViewById(R.id.tv_cancel)).setTypeface(o4.b.f11719r);
            ((RelativeLayout) findViewById(R.id.rl_cancel)).setOnClickListener(new m(3, this));
        }
        return true;
    }

    public final RelativeLayout K0() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.wizard_continue, (ViewGroup) this.P, false);
        viewInflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_continue)).setTypeface(o4.b.f11720s);
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_continue)).setTypeface(o4.b.f11719r);
        ((TextView) relativeLayout.findViewById(R.id.tv_continue_to_wizard_continue)).setTypeface(o4.b.f11720s);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_next_wizard_continue);
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new m(29, this));
        return relativeLayout;
    }

    public final RelativeLayout L0(h hVar) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.wizard_deep_link, (ViewGroup) this.P, false);
        viewInflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.iv_header_feature_wizard_deep_link);
        ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.iv_logo_wizard_deep_link);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_header_info_wizard_deep_link);
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ll_options_wizard_welcome);
        d0 d0VarE = y.d().e(hVar.h());
        float f = UptodownApp.E;
        d0VarE.g(k4.c.y(this));
        d0VarE.e(imageView2, null);
        y.d().e(hVar.e()).e(imageView, new p2(relativeLayout2, linearLayout, this, 0));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_name_app_wizard_deep_link);
        textView.setTypeface(o4.b.f11720s);
        int i10 = f.f13145c;
        String string = getString(R.string.wizard_deep_link_download, hVar.f8567b);
        string.getClass();
        Typeface typeface = o4.b.f11719r;
        typeface.getClass();
        Spanned spannedFromHtml = HtmlCompat.fromHtml(string, 0);
        spannedFromHtml.getClass();
        SpannableString spannableString = new SpannableString(spannedFromHtml);
        kotlin.jvm.internal.b bVarD = a0.d((StyleSpan[]) spannableString.getSpans(0, spannableString.length(), StyleSpan.class));
        while (bVarD.hasNext()) {
            StyleSpan styleSpan = (StyleSpan) bVarD.next();
            if (styleSpan.getStyle() == 1) {
                int spanStart = spannableString.getSpanStart(styleSpan);
                int spanEnd = spannableString.getSpanEnd(styleSpan);
                spannableString.removeSpan(styleSpan);
                spannableString.setSpan(new f(typeface, 0), spanStart, spanEnd, 33);
            }
        }
        textView.setText(spannableString);
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_deep_link)).setTypeface(o4.b.f11719r);
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_deep_link)).setTypeface(o4.b.f11720s);
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_deep_link)).setTypeface(o4.b.f11719r);
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_deep_link)).setOnClickListener(new m(4, this));
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_deep_link)).setTypeface(o4.b.f11719r);
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_deep_link)).setOnClickListener(new m(5, this));
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_accept_wizard_deep_link);
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new m(6, this));
        return relativeLayout;
    }

    public final RelativeLayout M0() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.wizard_login, (ViewGroup) this.P, false);
        viewInflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_header_wl);
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(R.id.tv_title_header_wizard)).setTypeface(o4.b.f11719r);
        }
        ((TextView) relativeLayout.findViewById(R.id.tv_title_wl)).setTypeface(o4.b.f11719r);
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_login_google_wl);
        float f = UptodownApp.E;
        ((TextView) relativeLayout.findViewById(R.id.tv_login_google_wl)).setTypeface(o4.b.f11719r);
        relativeLayout3.setOnClickListener(new m(8, this));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_login_email_wl);
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new m(9, this));
        ((TextView) relativeLayout.findViewById(R.id.tv_login_anonymous_wl)).setTypeface(o4.b.f11720s);
        ((TextView) relativeLayout.findViewById(R.id.tv_login_anonymous_wl)).setOnClickListener(new m(10, this));
        return relativeLayout;
    }

    public final RelativeLayout N0() throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.wizard_permissions, (ViewGroup) this.P, false);
        viewInflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_header_wp);
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(R.id.tv_title_header_wizard)).setTypeface(o4.b.f11719r);
        }
        ((TextView) relativeLayout.findViewById(R.id.tv_title_wp)).setTypeface(o4.b.f11719r);
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_notifications_wp);
        if (Build.VERSION.SDK_INT >= 33) {
            ((TextView) relativeLayout.findViewById(R.id.tv_notifications_title_wp)).setTypeface(o4.b.f11719r);
            ((TextView) relativeLayout.findViewById(R.id.tv_notifications_msg_wp)).setTypeface(o4.b.f11720s);
            SwitchCompat switchCompat = (SwitchCompat) relativeLayout.findViewById(R.id.sc_notifications_wp);
            this.S = switchCompat;
            switchCompat.getClass();
            switchCompat.setChecked(ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0);
            SwitchCompat switchCompat2 = this.S;
            switchCompat2.getClass();
            switchCompat2.setClickable(false);
            relativeLayout3.setOnClickListener(new m(19, this));
        } else if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_unknown_sources_wp);
        ((ScrollableTextView) relativeLayout.findViewById(R.id.tv_unknown_sources_title_wp)).setTypeface(o4.b.f11719r);
        ((TextView) relativeLayout.findViewById(R.id.tv_unknown_sources_badge_wp)).setTypeface(o4.b.f11719r);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_unknown_sources_msg_wp);
        textView.setText(getString(R.string.msg_install_from_unknown_source, getString(R.string.app_name)));
        textView.setTypeface(o4.b.f11720s);
        SwitchCompat switchCompat3 = (SwitchCompat) relativeLayout.findViewById(R.id.sc_unknown_sources_wp);
        this.R = switchCompat3;
        switchCompat3.getClass();
        switchCompat3.setChecked(o());
        SwitchCompat switchCompat4 = this.R;
        switchCompat4.getClass();
        switchCompat4.setClickable(false);
        relativeLayout4.setOnClickListener(new m(20, this));
        relativeLayout3.getClass();
        if (relativeLayout3.getVisibility() == 8) {
            relativeLayout.findViewById(R.id.v_unknown_sources_separator).setVisibility(4);
        }
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_next_wp);
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new m(21, this));
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_back_wp);
        textView3.setTypeface(o4.b.f11719r);
        textView3.setOnClickListener(new m(22, this));
        return relativeLayout;
    }

    public final RelativeLayout O0() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.wizard_welcome, (ViewGroup) this.P, false);
        viewInflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_welcome)).setTypeface(o4.b.f11720s);
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_welcome)).setTypeface(o4.b.f11719r);
        ((TextView) relativeLayout.findViewById(R.id.tv_slogan_to_wizard_welcome)).setTypeface(o4.b.f11720s);
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_welcome)).setTypeface(o4.b.f11719r);
        ((RelativeLayout) relativeLayout.findViewById(R.id.rl_terms_wizard_welcome)).setOnClickListener(new m(25, this));
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_welcome)).setTypeface(o4.b.f11719r);
        ((RelativeLayout) relativeLayout.findViewById(R.id.rl_privacy_settings_wizard_welcome)).setOnClickListener(new m(27, this));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_accept_wizard_welcome);
        textView.setTypeface(o4.b.f11719r);
        textView.setEnabled(false);
        textView.setOnClickListener(new m(28, this));
        ProgressBar progressBar = (ProgressBar) relativeLayout.findViewById(R.id.pb_wizard_deep_link);
        if (!this.y) {
            progressBar.setVisibility(0);
            return relativeLayout;
        }
        textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
        textView.setEnabled(true);
        progressBar.setVisibility(8);
        return relativeLayout;
    }

    public final void P0() {
        RelativeLayout relativeLayout;
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate((String) null, 1);
        }
        RelativeLayout relativeLayout2 = this.W;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0 && (relativeLayout = this.W) != null) {
            relativeLayout.setVisibility(8);
        }
        TabLayout tabLayout = this.Y;
        if (tabLayout == null || tabLayout.getSelectedTabPosition() != 3) {
            X0();
        }
    }

    public final void Q0() throws Resources.NotFoundException {
        RelativeLayout relativeLayout = this.P;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            RelativeLayout relativeLayout2 = this.P;
            relativeLayout2.getClass();
            if (relativeLayout2.getChildCount() != 0) {
                return;
            }
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_banner_floating);
        int i10 = 4;
        int i11 = 0;
        w6.c cVar = null;
        if (frameLayout != null) {
            if (704 > getSharedPreferences("SettingsPreferences", 0).getInt("last_changelog_version_shown", 0)) {
                try {
                    SharedPreferences.Editor editorEdit = getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putInt("last_changelog_version_shown", TypedValues.TransitionType.TYPE_AUTO_TRANSITION);
                    editorEdit.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String string = getString(R.string.last_changelog);
                string.getClass();
                if (string.length() > 0) {
                    View viewInflate = LayoutInflater.from(this).inflate(R.layout.changelog_notification_view, (ViewGroup) frameLayout, false);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.tv_subtitle_cd);
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_version_cd);
                    View viewFindViewById = viewInflate.findViewById(R.id.iv_close_cd);
                    if (textView != null) {
                        textView.setTypeface(o4.b.f11720s);
                    }
                    if (textView2 != null) {
                        textView2.setTypeface(o4.b.f11719r);
                    }
                    if (textView2 != null) {
                        textView2.setText(getString(R.string.version_changelog_notification, "7.04"));
                    }
                    View viewFindViewById2 = viewInflate.findViewById(R.id.rl_content_area);
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setOnClickListener(new j(this, string, viewInflate, 15));
                    }
                    if (viewFindViewById != null) {
                        viewFindViewById.setOnClickListener(new e5.s(viewInflate, 27));
                    }
                    frameLayout.addView(viewInflate);
                }
            }
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            e eVar = i0.f12407a;
            d dVar = d.f14116a;
            r7.y.q(lifecycleScope, dVar, null, new m2(this, cVar, i11), 2);
            D0();
            Y0();
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), dVar, null, new m2(this, cVar, i10), 2);
            return;
        }
        if (frameLayout == null) {
            LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this);
            e eVar2 = i0.f12407a;
            d dVar2 = d.f14116a;
            r7.y.q(lifecycleScope2, dVar2, null, new m2(this, cVar, i11), 2);
            D0();
            Y0();
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), dVar2, null, new m2(this, cVar, i10), 2);
        }
    }

    public final void R0() throws Resources.NotFoundException {
        RelativeLayout relativeLayout = this.P;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        RelativeLayout relativeLayout2 = this.P;
        relativeLayout2.getClass();
        if (relativeLayout2.getChildCount() != 0) {
            Iterator it = this.N.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                ((h5.m1) next).a().removeAllViews();
            }
            RelativeLayout relativeLayout3 = this.P;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
            }
            RelativeLayout relativeLayout4 = this.P;
            if (relativeLayout4 != null) {
                relativeLayout4.removeAllViews();
            }
            this.P = null;
            boolean zG = z1.t1.G(4, this);
            boolean zG2 = z1.t1.G(5, this);
            if (zG && zG2) {
                z1.t1.N(this, "wizard_completed", true);
            }
            Q0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S0() throws android.content.res.Resources.NotFoundException {
        /*
            r5 = this;
            r5.R0()
            boolean r0 = r5.J0()
            if (r0 != 0) goto Lbe
            boolean r0 = r5.isFinishing()
            if (r0 != 0) goto Lb5
            android.widget.RelativeLayout r0 = r5.P
            if (r0 == 0) goto Lb5
            java.lang.String r0 = "wizard_completed"
            r1 = 0
            java.lang.String r2 = "SettingsPreferences"
            android.content.SharedPreferences r2 = r5.getSharedPreferences(r2, r1)     // Catch: java.lang.Exception -> L27
            boolean r3 = r2.contains(r0)     // Catch: java.lang.Exception -> L27
            if (r3 == 0) goto L27
            boolean r0 = r2.getBoolean(r0, r1)     // Catch: java.lang.Exception -> L27
            goto L28
        L27:
            r0 = r1
        L28:
            if (r0 != 0) goto Lb5
            android.widget.RelativeLayout r0 = r5.P
            r0.getClass()
            r0.setVisibility(r1)
            android.widget.RelativeLayout r0 = r5.P
            r0.getClass()
            e5.n r1 = new e5.n
            r2 = 9
            r1.<init>(r2)
            r0.setOnClickListener(r1)
            java.util.ArrayList r0 = r5.N
            java.util.Iterator r1 = r0.iterator()
            r1.getClass()
        L4a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L92
            java.lang.Object r2 = r1.next()
            r2.getClass()
            h5.m1 r2 = (h5.m1) r2
            int r3 = r2.f8665a
            r4 = 1
            if (r3 == r4) goto L8b
            r4 = 2
            if (r3 == r4) goto L80
            r4 = 3
            if (r3 == r4) goto L79
            r4 = 4
            if (r3 == r4) goto L72
            r4 = 5
            if (r3 == r4) goto L6b
            goto L4a
        L6b:
            android.widget.RelativeLayout r3 = r5.M0()
            r2.f8666b = r3
            goto L4a
        L72:
            android.widget.RelativeLayout r3 = r5.N0()
            r2.f8666b = r3
            goto L4a
        L79:
            android.widget.RelativeLayout r3 = r5.K0()
            r2.f8666b = r3
            goto L4a
        L80:
            h5.h r3 = r5.T
            if (r3 == 0) goto L4a
            android.widget.RelativeLayout r3 = r5.L0(r3)
            r2.f8666b = r3
            goto L4a
        L8b:
            android.widget.RelativeLayout r3 = r5.O0()
            r2.f8666b = r3
            goto L4a
        L92:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto Lb1
            int r1 = r5.M
            if (r1 < 0) goto Lb1
            int r2 = r0.size()
            if (r1 >= r2) goto Lb1
            int r1 = r5.M
            java.lang.Object r0 = r0.get(r1)
            r0.getClass()
            h5.m1 r0 = (h5.m1) r0
            r5.W0(r0)
            goto Lb8
        Lb1:
            r5.R0()
            goto Lb8
        Lb5:
            r5.R0()
        Lb8:
            r5.T0()
            r5.c1()
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.S0():void");
    }

    public final void T0() throws Resources.NotFoundException {
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.getClass();
            l2 l2Var = new l2(4, this);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            float f = UptodownApp.E;
            boolean z9 = true;
            try {
                SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("animations")) {
                    z9 = sharedPreferences.getBoolean("animations", true);
                }
            } catch (Exception unused) {
            }
            if (!z9) {
                l2Var.onAnimationEnd(animationLoadAnimation);
                return;
            }
            float f10 = UptodownApp.E;
            animationLoadAnimation.setAnimationListener(l2Var);
            relativeLayout.startAnimation(animationLoadAnimation);
        }
    }

    public final void U0() {
        ProgressBar progressBar = this.X;
        if (progressBar == null || progressBar.getVisibility() == 0) {
            return;
        }
        ProgressBar progressBar2 = this.X;
        progressBar2.getClass();
        progressBar2.setVisibility(0);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, d.f14116a, null, new m2(this, null, 3), 2);
        t1 t1Var = this.f6641k0;
        if (t1Var != null) {
            t1Var.c();
        }
        n1 n1Var = this.Z;
        if (n1Var != null) {
            n1Var.g = false;
            n1Var.c();
        }
        d1 d1Var = this.f6640j0;
        if (d1Var != null) {
            d1Var.g = false;
            d1Var.c();
        }
    }

    public final void V0() {
        long jCurrentTimeMillis = (System.currentTimeMillis() - 86400000) + 3600000;
        try {
            SharedPreferences.Editor editorEdit = getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.putLong("getLastTimePendingDialogShown", jCurrentTimeMillis);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // l4.w
    public final void W(h hVar) throws Resources.NotFoundException {
        m0(hVar);
        if (this.P == null || this.M != 0) {
            return;
        }
        ArrayList arrayList = this.N;
        if (arrayList.size() == 1 && ((h5.m1) arrayList.get(this.M)).f8665a == 1 && !I0()) {
            this.T = hVar;
            y0(L0(hVar), 2);
            A0();
        }
    }

    public final void W0(h5.m1 m1Var) {
        String str;
        RelativeLayout relativeLayout = this.P;
        relativeLayout.getClass();
        relativeLayout.removeAllViews();
        RelativeLayout relativeLayout2 = this.P;
        relativeLayout2.getClass();
        relativeLayout2.addView(m1Var.a());
        switch (m1Var.f8665a) {
            case 1:
                str = "welcome";
                break;
            case 2:
                str = "deeplink";
                break;
            case 3:
                str = "continue";
                break;
            case 4:
                str = "permissions";
                break;
            case 5:
                str = "login";
                break;
            case 6:
                str = "kill";
                break;
            default:
                str = "null";
                break;
        }
        Bundle bundleF = a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        c cVar = this.f10934v;
        if (cVar != null) {
            cVar.e(bundleF, "wizard");
        }
    }

    @Override // l4.w
    public final void X() {
        if (this.P == null || this.M != 0) {
            return;
        }
        ArrayList arrayList = this.N;
        if (arrayList.size() == 1 && ((h5.m1) arrayList.get(this.M)).f8665a == 1 && !I0()) {
            TextView textView = (TextView) findViewById(R.id.tv_accept_wizard_welcome);
            if (textView != null) {
                textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
            }
            if (textView != null) {
                textView.setEnabled(true);
            }
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_wizard_deep_link);
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            y0(N0(), 4);
            y0(M0(), 5);
        }
    }

    public final void X0() {
        AppBarLayout appBarLayout = this.Q;
        appBarLayout.getClass();
        appBarLayout.setVisibility(0);
        AppBarLayout appBarLayout2 = this.Q;
        appBarLayout2.getClass();
        appBarLayout2.setExpanded(true, false);
    }

    @Override // l4.w
    public final void Y(long j10) {
        E0();
        H0();
        if (j10 <= 0) {
            b0();
        } else if (this.f6644o0 == -1) {
            this.f6644o0 = j10;
            new c1.l(this, j10, new q2(this), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void Y0() {
        AlertDialog alertDialog;
        SharedPreferences sharedPreferences;
        e1 e1VarH = c1.h(this);
        if (isFinishing() || e1VarH == null || !e1VarH.d()) {
            return;
        }
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences.contains("welcome_popup_shown") ? sharedPreferences.getBoolean("welcome_popup_shown", false) : false;
        if (z9) {
            return;
        }
        AlertDialog alertDialog2 = this.f10935w;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = getLayoutInflater().inflate(R.layout.uptodown_turbo_welcome_popup, (ViewGroup) null, false);
        int i10 = R.id.iv_customization_turbo_welcome_popup;
        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_customization_turbo_welcome_popup)) != null) {
            i10 = R.id.iv_highlighted_comments_turbo_welcome_popup;
            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_highlighted_comments_turbo_welcome_popup)) != null) {
                i10 = R.id.iv_no_ads_turbo_welcome_popup;
                if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_no_ads_turbo_welcome_popup)) != null) {
                    i10 = R.id.ll_content_turbo;
                    if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_content_turbo)) != null) {
                        i10 = R.id.nsv_turbo_welcome_popup;
                        if (((NestedScrollView) ViewBindings.findChildViewById(viewInflate, R.id.nsv_turbo_welcome_popup)) != null) {
                            i10 = R.id.tv_customization_desc_turbo_welcome_popup;
                            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_customization_desc_turbo_welcome_popup);
                            if (textView != null) {
                                i10 = R.id.tv_customization_turbo_welcome_popup;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_customization_turbo_welcome_popup);
                                if (textView2 != null) {
                                    i10 = R.id.tv_desc_turbo_welcome_popup;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_desc_turbo_welcome_popup);
                                    if (textView3 != null) {
                                        i10 = R.id.tv_highlighted_comments_desc_turbo_welcome_popup;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_highlighted_comments_desc_turbo_welcome_popup);
                                        if (textView4 != null) {
                                            i10 = R.id.tv_highlighted_comments_turbo_welcome_popup;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_highlighted_comments_turbo_welcome_popup);
                                            if (textView5 != null) {
                                                i10 = R.id.tv_no_ads_desc_turbo_welcome_popup;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_ads_desc_turbo_welcome_popup);
                                                if (textView6 != null) {
                                                    i10 = R.id.tv_no_ads_turbo_welcome_popup;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_ads_turbo_welcome_popup);
                                                    if (textView7 != null) {
                                                        i10 = R.id.tv_start_turbo_welcome_popup;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_start_turbo_welcome_popup);
                                                        if (textView8 != null) {
                                                            i10 = R.id.tv_title_turbo_welcome_popup;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_turbo_welcome_popup);
                                                            if (textView9 != null) {
                                                                RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                                                                textView9.setTypeface(o4.b.f11719r);
                                                                String string = getString(R.string.uptodown_turbo);
                                                                string.getClass();
                                                                int color = ContextCompat.getColor(this, R.color.turbo_text_gradient_start);
                                                                int color2 = ContextCompat.getColor(this, R.color.turbo_text_gradient_end);
                                                                String string2 = textView9.getText().toString();
                                                                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, textView9.getPaint().measureText(string), textView9.getHeight(), new int[]{color, color2}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                                                                SpannableString spannableString = new SpannableString(string2);
                                                                int iK0 = o7.m.k0(string2, string, 0, false, 6);
                                                                if (iK0 >= 0) {
                                                                    spannableString.setSpan(new v5.b(linearGradient, getResources().getDimension(R.dimen.font_size_26)), iK0, string.length() + iK0, 33);
                                                                }
                                                                textView9.setText(spannableString);
                                                                ConcurrentHashMap concurrentHashMap = n.f13169a;
                                                                Spanned spannedA = n.a(getString(R.string.turbo_welcome_popup_description, getString(R.string.turbo_welcome_popup_manage_subscription)));
                                                                String string3 = getString(R.string.turbo_welcome_popup_manage_subscription);
                                                                string3.getClass();
                                                                SpannableString spannableString2 = new SpannableString(spannedA);
                                                                int iK02 = o7.m.k0(spannedA, string3, 0, false, 6);
                                                                if (iK02 >= 0) {
                                                                    spannableString2.setSpan(new StyleSpan(1), iK02, string3.length() + iK02, 33);
                                                                }
                                                                textView3.setText(spannableString2);
                                                                textView3.setTypeface(o4.b.f11720s);
                                                                textView7.setTypeface(o4.b.f11719r);
                                                                textView6.setTypeface(o4.b.f11720s);
                                                                textView2.setTypeface(o4.b.f11719r);
                                                                textView.setTypeface(o4.b.f11720s);
                                                                textView5.setTypeface(o4.b.f11719r);
                                                                textView4.setTypeface(o4.b.f11720s);
                                                                textView8.setTypeface(o4.b.f11719r);
                                                                textView8.setOnClickListener(new m(15, this));
                                                                builder.setView(relativeLayout);
                                                                builder.setCancelable(true);
                                                                this.f10935w = builder.create();
                                                                if (isFinishing() || (alertDialog = this.f10935w) == null) {
                                                                    return;
                                                                }
                                                                Window window = alertDialog.getWindow();
                                                                if (window != null) {
                                                                    a3.a.A(window, 0);
                                                                }
                                                                AlertDialog alertDialog3 = this.f10935w;
                                                                alertDialog3.getClass();
                                                                alertDialog3.show();
                                                                try {
                                                                    SharedPreferences.Editor editorEdit = getSharedPreferences("SettingsPreferences", 0).edit();
                                                                    editorEdit.putBoolean("welcome_popup_shown", true);
                                                                    editorEdit.apply();
                                                                    return;
                                                                } catch (Exception e) {
                                                                    e.printStackTrace();
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
    }

    public final void Z0() {
        String string = null;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("url_526")) {
                string = sharedPreferences.getString("url_526", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (string == null) {
            string = "https://uptodown-android.uptodown.com/android";
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
    }

    public final void a1(String str) {
        if (G0() instanceof n1) {
            Fragment fragmentG0 = G0();
            fragmentG0.getClass();
            ((n1) fragmentG0).m(str);
        } else if (G0() instanceof d1) {
            Fragment fragmentG02 = G0();
            fragmentG02.getClass();
            ((d1) fragmentG02).m(str);
        } else {
            n1 n1Var = this.Z;
            if (n1Var != null) {
                n1Var.m(str);
            }
        }
    }

    public final void b1(String str) {
        if (G0() instanceof t1) {
            Fragment fragmentG0 = G0();
            fragmentG0.getClass();
            ((t1) fragmentG0).d(str);
        } else {
            t1 t1Var = this.f6641k0;
            if (t1Var != null) {
                t1Var.d(str);
            }
        }
    }

    public final void c1() {
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new m2(this, null, 6), 3);
    }

    public final void d1() {
        ImageView imageView = (ImageView) findViewById(R.id.home_uptodown_turbo);
        e1 e1VarH = c1.h(this);
        if (isFinishing() || e1VarH == null || !e1VarH.d()) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
        c1();
    }

    public final void e1(String str) {
        if (G0() instanceof e5.b2) {
            Fragment fragmentG0 = G0();
            fragmentG0.getClass();
            ((e5.b2) fragmentG0).e(str);
        }
    }

    public final void f1() {
        if (this.P == null || this.M < 0) {
            return;
        }
        ArrayList arrayList = this.N;
        int size = arrayList.size();
        int i10 = this.M;
        if (size > i10 && ((h5.m1) arrayList.get(i10)).f8665a == 4 && o()) {
            if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
                TextView textView = (TextView) findViewById(R.id.tv_next_wp);
                if (textView != null) {
                    textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(this, R.color.text_color_wizard_button));
                }
            }
        }
    }

    public final void g1(k kVar) {
        kVar.getClass();
        int i10 = kVar.f8632a;
        if (i10 == 523) {
            C0(1);
        } else if (i10 == 831) {
            C0(2);
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        String str = kVar.f8633b;
        str.getClass();
        d1 d1Var = new d1(str);
        kVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putInt("id", kVar.f8632a);
        bundle.putString(RewardPlus.NAME, kVar.f8633b);
        bundle.putString("description", kVar.f8634c);
        bundle.putBoolean("isFloating", kVar.f8635d);
        bundle.putInt("parentCategoryId", kVar.f);
        bundle.putInt("isGame", kVar.g);
        bundle.putBoolean("isLeaf", kVar.e);
        d1Var.setArguments(bundle);
        fragmentTransactionBeginTransaction.add(R.id.fl_apps_category_fragment, d1Var);
        fragmentTransactionBeginTransaction.addToBackStack("appsCategory");
        if (isFinishing() || getSupportFragmentManager().isDestroyed()) {
            return;
        }
        try {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void h1(k kVar) {
        kVar.getClass();
        E0();
        H0();
        e5.b2 b2Var = new e5.b2();
        b2Var.f7688c = kVar;
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        if (((CoordinatorLayout) findViewById(R.id.rl_main_scrollable)) == null) {
            String string = getString(R.string.error_generico);
            string.getClass();
            C(string);
            return;
        }
        try {
            float f = UptodownApp.E;
            k4.c.D(fragmentTransactionBeginTransaction, this);
            fragmentTransactionBeginTransaction.add(R.id.rl_main_scrollable, b2Var);
            fragmentTransactionBeginTransaction.addToBackStack(b2Var.f7688c.f8633b);
            if (G0() instanceof e5.b2) {
                fragmentTransactionBeginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            }
            if (isFinishing() || getSupportFragmentManager().isDestroyed()) {
                return;
            }
            try {
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } catch (Exception e) {
                e.printStackTrace();
                String string2 = getString(R.string.error_generico);
                string2.getClass();
                C(string2);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            String string3 = getString(R.string.error_generico);
            string3.getClass();
            C(string3);
        }
    }

    @Override // l4.w
    public final void k0(long j10) throws Resources.NotFoundException {
        String strValueOf = String.valueOf(j10);
        try {
            SharedPreferences.Editor editorEdit = getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.putString("app_id_after_kill", strValueOf);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
        View rootView = getWindow().getDecorView().getRootView();
        int width = rootView.getWidth();
        int height = rootView.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
        rootView.draw(new Canvas(bitmapCreateBitmap));
        float fApplyDimension = TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, rootView.getWidth() / 2, rootView.getHeight() / 2, true);
        int i10 = (int) fApplyDimension;
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight(), config);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = i10;
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmapCreateScaledBitmap, rect, rect, paint);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_wizard);
        this.P = relativeLayout;
        relativeLayout.getClass();
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = this.P;
        relativeLayout2.getClass();
        relativeLayout2.setOnClickListener(new e5.n(9));
        RelativeLayout relativeLayout3 = this.P;
        relativeLayout3.getClass();
        relativeLayout3.removeAllViews();
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.wizard_kill, (ViewGroup) this.P, false);
        viewInflate.getClass();
        RelativeLayout relativeLayout4 = (RelativeLayout) viewInflate;
        ((TextView) relativeLayout4.findViewById(R.id.tv_title_wizard_kill)).setTypeface(o4.b.f11719r);
        TextView textView = (TextView) relativeLayout4.findViewById(R.id.tv_slogan_to_wizard_kill);
        textView.setTypeface(o4.b.f11720s);
        textView.setText(getString(R.string.core_kill_this_app, getString(R.string.app_name)));
        ((TextView) relativeLayout4.findViewById(R.id.tv_slide_wizard_kill)).setTypeface(o4.b.f11719r);
        TextView textView2 = (TextView) relativeLayout4.findViewById(R.id.tv_accept_wizard_kill);
        textView2.setTypeface(o4.b.f11720s);
        textView2.setEnabled(true);
        textView2.setOnClickListener(new i2(5, this));
        h5.m1 m1Var = new h5.m1();
        m1Var.f8665a = 6;
        m1Var.f8666b = relativeLayout4;
        W0(m1Var);
        ImageView imageView = (ImageView) relativeLayout4.findViewById(R.id.iv_tap_screen_kill);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up_tap);
        animationLoadAnimation.setStartOffset(500L);
        animationLoadAnimation.setFillAfter(true);
        ImageView imageView2 = (ImageView) relativeLayout4.findViewById(R.id.iv_screenshot_kill);
        imageView2.setImageBitmap(bitmapCreateBitmap2);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slide_up_out);
        animationLoadAnimation2.setFillAfter(true);
        animationLoadAnimation2.setStartOffset(500L);
        animationLoadAnimation2.setAnimationListener(new t2(imageView, animationLoadAnimation, imageView2));
        imageView.startAnimation(animationLoadAnimation);
        imageView2.startAnimation(animationLoadAnimation2);
    }

    @Override // l4.w
    public final void m0(h hVar) {
        hVar.getClass();
        Fragment fragmentG0 = G0();
        RelativeLayout relativeLayout = this.W;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new e5.n(9));
        }
        RelativeLayout relativeLayout2 = this.W;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        if (!(fragmentG0 instanceof j0)) {
            B0(hVar, false);
        } else if (((j0) fragmentG0).D().f8566a != hVar.f8566a) {
            B0(hVar, true);
        }
        AppBarLayout appBarLayout = this.Q;
        appBarLayout.getClass();
        appBarLayout.setVisibility(8);
    }

    @Override // l4.b2
    public final e1 o0() {
        e1 e1VarH = c1.h(this);
        if ((e1VarH != null ? e1VarH.f8512a : null) == null || !c1.g(this)) {
            return null;
        }
        return e1VarH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [w6.c] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // l4.b2, l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Throwable {
        ViewPager2 viewPager2;
        Bundle extras;
        long j10;
        Bundle extras2;
        Bundle extras3;
        super.onCreate(bundle);
        String string = 0;
        string = 0;
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.main, (ViewGroup) null);
        viewInflate.getClass();
        setContentView(viewInflate);
        float f = UptodownApp.E;
        if (k4.c.m(this)) {
            startActivity(new Intent(this, (Class<?>) TvMainActivity.class));
            finish();
            return;
        }
        this.f6645p0 = (FrameLayout) findViewById(R.id.fl_sign_in_popup);
        this.f6647r0 = (FrameLayout) findViewById(R.id.fl_uptodown_turbo_popup);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_splash);
        this.L = relativeLayout;
        relativeLayout.getClass();
        int i10 = 9;
        relativeLayout.setOnClickListener(new e5.n(i10));
        this.F = (RelativeLayout) findViewById(R.id.app_info_selected_popup);
        int i11 = 8;
        if (UptodownApp.Y) {
            RelativeLayout relativeLayout2 = this.L;
            relativeLayout2.getClass();
            relativeLayout2.setVisibility(8);
        }
        this.P = (RelativeLayout) findViewById(R.id.rl_wizard);
        R();
        this.Q = (AppBarLayout) findViewById(R.id.abl_toolbar);
        ((ImageView) findViewById(R.id.home_uptodown_logo)).setOnClickListener(new m(26, this));
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.rl_main_search_view);
        ((TextView) findViewById(R.id.tv_main_search_view)).setTypeface(o4.b.f11720s);
        int i12 = 6;
        relativeLayout3.setOnClickListener(new i2(i12, this));
        ((ImageView) findViewById(R.id.home_uptodown_turbo)).setOnClickListener(new i2(7, this));
        d1();
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new m2(this, string, 1), 3);
        String strA = z1.t1.A(this, "app_id_after_kill");
        int i13 = 5;
        boolean z9 = false;
        boolean z10 = false;
        if (strA != null) {
            h hVar = new h();
            hVar.f8566a = Long.parseLong(strA);
            m0(hVar);
            z1.t1.R(this, "app_id_after_kill", null);
        } else if (!z1.t1.r(this, "wizard_completed", false)) {
            z1.t1.Q(System.currentTimeMillis(), this, "last_sign_in_request_timestamp");
            RelativeLayout relativeLayout4 = this.P;
            relativeLayout4.getClass();
            relativeLayout4.setVisibility(0);
            RelativeLayout relativeLayout5 = this.P;
            relativeLayout5.getClass();
            relativeLayout5.setOnClickListener(new e5.n(i10));
            if (n()) {
                J();
            } else {
                B();
            }
            if (z1.t1.G(1, this) && z1.t1.r(this, "gdpr_requested", false)) {
                y0(K0(), 3);
                if (!z1.t1.G(4, this)) {
                    y0(N0(), 4);
                }
                if (!z1.t1.G(5, this)) {
                    if (c1.h(this) != null) {
                        z1.t1.N(this, "wizard_step_5_shown", true);
                    } else {
                        y0(M0(), 5);
                    }
                }
            } else {
                y0(O0(), 1);
            }
            this.M = 0;
            Object obj = this.N.get(0);
            obj.getClass();
            W0((h5.m1) obj);
        }
        runOnUiThread(new h2(1, this));
        k4.c.E(this);
        if (!z1.t1.r(this, "is_in_eea_checked", false)) {
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new m2(this, string, 2), 3);
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            intent.getClass();
            if ((intent.getFlags() & 1048576) != 1048576) {
                Uri data = getIntent().getData();
                if (data != null) {
                    String string2 = data.toString();
                    string2.getClass();
                    String strB = x4.d.b(data, this);
                    ActivityResultLauncher activityResultLauncher = this.A0;
                    if (strB != null && u.X(strB, ".apk", false)) {
                        String strC = r0.f.C(strB);
                        if (strC != null) {
                            a0(strC, null);
                        } else {
                            Intent intent2 = new Intent(getApplicationContext(), (Class<?>) InstallerActivity.class);
                            intent2.setData(data);
                            activityResultLauncher.launch(intent2);
                        }
                    } else if (strB != null && (u.X(strB, ".xapk", true) || u.X(strB, ".apks", true) || u.X(strB, ".apkm", true))) {
                        Intent intent3 = new Intent(getApplicationContext(), (Class<?>) InstallerActivity.class);
                        intent3.setData(data);
                        activityResultLauncher.launch(intent3);
                    } else if (u.c0(string2, "https://dw.uptodown.com/dwn/", false)) {
                        q2 q2Var = new q2(this);
                        x xVar = new x(10, z9);
                        xVar.f181b = this;
                        xVar.f182c = string2;
                        xVar.f183d = q2Var;
                        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
                        lifecycleScope.getClass();
                        r7.y.q(lifecycleScope, null, null, new c5.d(xVar, string, z10 ? 1 : 0), 3);
                    } else if (o7.m.d0(string2, "preregister-available", false)) {
                        String queryParameter = data.getQueryParameter("appID");
                        if (queryParameter != null && queryParameter.length() != 0) {
                            try {
                                String queryParameter2 = data.getQueryParameter("appID");
                                queryParameter2.getClass();
                                Y(Long.parseLong(queryParameter2));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (!k4.c.m(this)) {
                        new r(this, v5.c.d(data), this.f6650u0, LifecycleOwnerKt.getLifecycleScope(this));
                    }
                }
                Intent intent4 = getIntent();
                String string3 = (intent4 == null || (extras3 = intent4.getExtras()) == null) ? null : extras3.getString("action");
                if (string3 != null) {
                    int i14 = MyFirebaseMessagingService.f6688i;
                    if (string3.equalsIgnoreCase("notificationApp")) {
                        Intent intent5 = getIntent();
                        String string4 = (intent5 == null || (extras2 = intent5.getExtras()) == null) ? null : extras2.getString("appId");
                        if (string4 != null) {
                            try {
                                j10 = Long.parseLong(string4);
                            } catch (NumberFormatException e3) {
                                e3.printStackTrace();
                                j10 = -1;
                            }
                            if (j10 > 0) {
                                Bundle extras4 = getIntent().getExtras();
                                String string5 = extras4 != null ? extras4.getString("packageName") : null;
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                z1.t1.Q(j10, this, "fcm_app_id");
                                z1.t1.R(this, "fcm_packagename", string5);
                                z1.t1.O(this, -1, "fcm_download_id");
                                z1.t1.Q(jCurrentTimeMillis, this, "fcm_received_timestamp");
                                z1.t1.Q(0L, this, "fcm_shown_timestamp");
                                new c1.l(this, j10, this.f6650u0, LifecycleOwnerKt.getLifecycleScope(this));
                            }
                        }
                    } else if (string3.equalsIgnoreCase("campaign")) {
                        Intent intent6 = getIntent();
                        if (intent6 != null && (extras = intent6.getExtras()) != null) {
                            string = extras.getString("campaign");
                        }
                        if (string != 0 && string.equalsIgnoreCase("BlackFriday")) {
                            l0();
                        }
                    }
                } else {
                    h5.a0 a0VarJ = z1.t1.J(this);
                    if (a0VarJ != null && a0VarJ.e <= 0) {
                        new c1.l(this, a0VarJ.f8460a, this.f6650u0, LifecycleOwnerKt.getLifecycleScope(this));
                    }
                }
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.z0);
        this.D = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g2(i12, this));
        ViewPager2 viewPager22 = (ViewPager2) findViewById(R.id.view_pager);
        this.U = viewPager22;
        if (viewPager22 != null) {
            viewPager22.setOffscreenPageLimit(4);
        }
        ViewPager2 viewPager23 = this.U;
        if (viewPager23 != null) {
            viewPager23.setUserInputEnabled(false);
        }
        this.Y = (TabLayout) findViewById(R.id.tabs);
        this.W = (RelativeLayout) findViewById(R.id.rl_app_detail_open);
        ImageView imageView = (ImageView) findViewById(R.id.iv_avatar_user);
        this.f6648s0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new i2(i11, this));
        }
        this.f6649t0 = (ImageView) findViewById(R.id.iv_badge_user);
        s2 s2Var = new s2(this, getSupportFragmentManager(), getLifecycle());
        ViewPager2 viewPager24 = this.U;
        if (viewPager24 != null) {
            viewPager24.setAdapter(s2Var);
        }
        if (UptodownApp.Y) {
            AppBarLayout appBarLayout = this.Q;
            appBarLayout.getClass();
            appBarLayout.setVisibility(0);
            AppBarLayout appBarLayout2 = this.Q;
            appBarLayout2.getClass();
            appBarLayout2.setExpanded(false, false);
            ViewPager2 viewPager25 = this.U;
            if (viewPager25 != null) {
                viewPager25.setCurrentItem(3, false);
            }
            UptodownApp.Y = false;
        }
        TabLayout tabLayout = this.Y;
        if (tabLayout == null || (viewPager2 = this.U) == null) {
            return;
        }
        new TabLayoutMediator(tabLayout, viewPager2, new g2(i13, this)).attach();
        TabLayout tabLayout2 = this.Y;
        tabLayout2.getClass();
        tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new r2(this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        keyEvent.getClass();
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (J0()) {
            return;
        }
        c1();
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
        RelativeLayout relativeLayout = this.V;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        U0();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(new Bundle());
    }

    @Override // p4.f
    public final void p() throws Resources.NotFoundException {
        SwitchCompat switchCompat = this.S;
        if (switchCompat != null) {
            switchCompat.setChecked(false);
        }
        f1();
    }

    @Override // p4.f
    public final void q() throws Resources.NotFoundException {
        SwitchCompat switchCompat = this.S;
        if (switchCompat != null) {
            switchCompat.setChecked(true);
        }
        f1();
    }

    @Override // l4.b2
    public final void q0() throws Resources.NotFoundException {
        if (this.P != null) {
            ArrayList arrayList = this.N;
            int size = arrayList.size();
            int i10 = this.M;
            if (size > i10 && ((h5.m1) arrayList.get(i10)).f8665a == 5) {
                A0();
                d1();
                return;
            }
        }
        m1 m1Var = this.l0;
        if (m1Var != null) {
            m1Var.onResume();
        }
    }

    @Override // l4.w, p4.f
    public final void u() {
        O();
    }

    @Override // p4.f
    public final void v() {
        O();
    }

    public final void v0() throws Resources.NotFoundException {
        if (!z1.t1.r(this, "gdpr_requested", false)) {
            z1.t1.N(this, "gdpr_requested", true);
            z1.t1.N(this, "gdpr_analytics_allowed", true);
            z1.t1.N(this, "gdpr_crashlytics_allowed", true);
            z1.t1.N(this, "gdpr_tracking_allowed", true);
            float f = UptodownApp.E;
            k4.c.E(this);
            k4.c.j(this);
            this.f10934v = new c(this, 4);
        }
        this.f10934v = new c(this, 4);
        if (z1.t1.r(this, "gdpr_tracking_allowed", false)) {
            A0();
        } else {
            v5.c.a(this.f10935w, this);
        }
    }

    @Override // l4.w, p4.f
    public final void w() {
        J();
    }

    @Override // p4.f
    public final void x() {
        J();
    }

    @Override // p4.f
    public final void y() throws Resources.NotFoundException {
        SwitchCompat switchCompat = this.R;
        if (switchCompat != null) {
            switchCompat.setChecked(o());
        }
        f1();
    }

    public final void y0(RelativeLayout relativeLayout, int i10) {
        h5.m1 m1Var = new h5.m1();
        m1Var.f8665a = i10;
        m1Var.f8666b = relativeLayout;
        this.N.add(m1Var);
    }

    public final void z0() throws Resources.NotFoundException {
        int i10;
        if (this.O) {
            return;
        }
        ArrayList arrayList = this.N;
        if (arrayList.isEmpty() || (i10 = this.M) < 0) {
            return;
        }
        RelativeLayout relativeLayoutA = ((h5.m1) arrayList.get(i10)).a();
        l2 l2Var = new l2(0, this);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_back_out);
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            l2Var.onAnimationEnd(animationLoadAnimation);
            return;
        }
        float f10 = UptodownApp.E;
        animationLoadAnimation.setAnimationListener(l2Var);
        relativeLayoutA.startAnimation(animationLoadAnimation);
    }

    @Override // l4.b2
    public final void n0() {
    }

    @Override // l4.b2
    public final void t0() {
    }

    @Override // l4.b2
    public final void u0() {
    }

    @Override // l4.b2
    public final void r0(e1 e1Var) {
    }

    @Override // l4.b2
    public final void s0(e1 e1Var, String str) {
    }
}
