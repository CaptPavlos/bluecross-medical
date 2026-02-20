package e5;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBindings;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import c1.w4;
import com.google.android.gms.internal.measurement.l5;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.mbridge.msdk.newinterstitial.out.MBNewInterstitialHandler;
import com.mbridge.msdk.out.MBBannerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.util.views.MaxHeightRecyclerView;
import com.uptodown.util.views.UsernameTextView;
import com.uptodown.views.FullWidthImageView;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import com.uptodown.workers.GenerateQueueWorker;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import l4.l9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public h5.h f7784a;

    /* renamed from: b, reason: collision with root package name */
    public d5.b f7785b;

    /* renamed from: d, reason: collision with root package name */
    public t1.c f7787d;
    public AlertDialog e;
    public ArrayList f;
    public Menu g;
    public n4.t0 h;

    /* renamed from: i, reason: collision with root package name */
    public n4.t0 f7788i;

    /* renamed from: n, reason: collision with root package name */
    public final ActivityResultLauncher f7793n;

    /* renamed from: o, reason: collision with root package name */
    public final ActivityResultLauncher f7794o;

    /* renamed from: c, reason: collision with root package name */
    public final s6.f f7786c = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.y.a(c1.class), new a9.f(new a9.f(this, 1), 2), null);

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f7789j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final double f7790k = 0.9d;

    /* renamed from: l, reason: collision with root package name */
    public final w f7791l = new w(this, 1);

    /* renamed from: m, reason: collision with root package name */
    public final w f7792m = new w(this, 0);

    public j0() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h(this, 0));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f7793n = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h(this, 1));
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.f7794o = activityResultLauncherRegisterForActivityResult2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
    
        if (r7.y.z(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(e5.j0 r7, y6.c r8) {
        /*
            boolean r0 = r8 instanceof e5.x
            if (r0 == 0) goto L13
            r0 = r8
            e5.x r0 = (e5.x) r0
            int r1 = r0.f7899c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7899c = r1
            goto L18
        L13:
            e5.x r0 = new e5.x
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f7897a
            int r1 = r0.f7899c
            r2 = 0
            r3 = 2
            r4 = 1
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            s6.a.e(r8)
            goto L5d
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            return r2
        L31:
            s6.a.e(r8)
            goto L4b
        L35:
            s6.a.e(r8)
            y7.e r8 = r7.i0.f12407a
            y7.d r8 = y7.d.f14116a
            e5.y r1 = new e5.y
            r6 = 0
            r1.<init>(r7, r2, r6)
            r0.f7899c = r4
            java.lang.Object r8 = r7.y.z(r1, r8, r0)
            if (r8 != r5) goto L4b
            goto L5c
        L4b:
            y7.e r8 = r7.i0.f12407a
            s7.c r8 = w7.n.f13548a
            e5.y r1 = new e5.y
            r1.<init>(r7, r2, r4)
            r0.f7899c = r3
            java.lang.Object r7 = r7.y.z(r1, r8, r0)
            if (r7 != r5) goto L5d
        L5c:
            return r5
        L5d:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.j0.a(e5.j0, y6.c):java.lang.Object");
    }

    public static final void b(j0 j0Var) {
        if (j0Var.getContext() != null) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(j0Var);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(lifecycleScope, w7.n.f13548a, null, new b0(j0Var, null, 3), 2);
            c1 c1VarG = j0Var.G();
            Context contextRequireContext = j0Var.requireContext();
            contextRequireContext.getClass();
            long j10 = j0Var.D().f8566a;
            c1VarG.getClass();
            r7.y.q(ViewModelKt.getViewModelScope(c1VarG), y7.d.f14116a, null, new r0(2, j10, contextRequireContext, c1VarG, null), 2);
        }
    }

    public static final void c(j0 j0Var, int i10) {
        if (j0Var.D().f8599y0) {
            return;
        }
        j0Var.D().f8599y0 = true;
        Bundle bundle = new Bundle();
        bundle.putString("appId", String.valueOf(j0Var.D().f8566a));
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "noCompatibleFile");
        bundle.putInt("installed", i10);
        t1.c cVar = j0Var.f7787d;
        if (cVar != null) {
            cVar.e(bundle, "app_details");
        }
    }

    public static final void d(j0 j0Var, h5.h hVar) {
        if (j0Var.getActivity() != null && (j0Var.getActivity() instanceof MainActivity)) {
            FragmentActivity activity = j0Var.getActivity();
            activity.getClass();
            ((MainActivity) activity).Y(hVar.f8566a);
        } else {
            if (j0Var.getActivity() == null || !(j0Var.getActivity() instanceof AppDetailActivity)) {
                return;
            }
            FragmentActivity activity2 = j0Var.getActivity();
            activity2.getClass();
            ((AppDetailActivity) activity2).Y(hVar.f8566a);
        }
    }

    public static final void e(j0 j0Var, ArrayList arrayList, boolean z9) {
        if (j0Var.getContext() == null || arrayList == null || arrayList.isEmpty()) {
            d5.b bVar = j0Var.f7785b;
            bVar.getClass();
            bVar.M.setVisibility(8);
            return;
        }
        n4.t0 t0Var = new n4.t0(new w(j0Var, 7), new c0(j0Var, 7), z9 ? 25 : 20);
        j0Var.h = t0Var;
        t0Var.a(arrayList);
        d5.b bVar2 = j0Var.f7785b;
        bVar2.getClass();
        bVar2.S.setAdapter(j0Var.h);
        d5.b bVar3 = j0Var.f7785b;
        bVar3.getClass();
        bVar3.S.setNestedScrollingEnabled(false);
        d5.b bVar4 = j0Var.f7785b;
        bVar4.getClass();
        bVar4.S.setItemAnimator(null);
        d5.b bVar5 = j0Var.f7785b;
        bVar5.getClass();
        bVar5.S.setLayoutManager(new LinearLayoutManager(j0Var.getContext(), 0, false));
        d5.b bVar6 = j0Var.f7785b;
        bVar6.getClass();
        bVar6.M.setVisibility(0);
    }

    public static final void f(j0 j0Var, View view, Context context) {
        ViewTreeObserver viewTreeObserver;
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9 || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnPreDrawListener(new h0(view, j0Var));
    }

    public static final void i(j0 j0Var, int i10, String str) {
        Menu menu = j0Var.g;
        if (menu != null) {
            menu.findItem(i10).setTitle(str);
        }
    }

    public static final void j(j0 j0Var, String str) {
        j0Var.J();
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        bVar.J.t.setText(str);
        d5.b bVar2 = j0Var.f7785b;
        bVar2.getClass();
        bVar2.C.f7153n.setText(str);
    }

    public static final void k(j0 j0Var) {
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        bVar.J.f.setVisibility(0);
        d5.b bVar2 = j0Var.f7785b;
        bVar2.getClass();
        bVar2.J.f6917d.setVisibility(8);
        d5.b bVar3 = j0Var.f7785b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.G.f7054i).setVisibility(0);
        d5.b bVar4 = j0Var.f7785b;
        bVar4.getClass();
        bVar4.G.f.setVisibility(0);
        d5.b bVar5 = j0Var.f7785b;
        bVar5.getClass();
        bVar5.G.f7052c.setVisibility(8);
        d5.b bVar6 = j0Var.f7785b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.G.f7055j).setVisibility(8);
        d5.b bVar7 = j0Var.f7785b;
        bVar7.getClass();
        bVar7.G.h.setVisibility(8);
        d5.b bVar8 = j0Var.f7785b;
        bVar8.getClass();
        bVar8.C.f7148i.setVisibility(0);
        d5.b bVar9 = j0Var.f7785b;
        bVar9.getClass();
        bVar9.C.f7155p.setVisibility(8);
        d5.b bVar10 = j0Var.f7785b;
        bVar10.getClass();
        bVar10.C.h.setVisibility(8);
        d5.b bVar11 = j0Var.f7785b;
        bVar11.getClass();
        bVar11.C.g.setVisibility(8);
        d5.b bVar12 = j0Var.f7785b;
        bVar12.getClass();
        bVar12.C.f7151l.setVisibility(8);
        Context contextRequireContext = j0Var.requireContext();
        contextRequireContext.getClass();
        if (h5.c1.h(contextRequireContext) == null) {
            d5.b bVar13 = j0Var.f7785b;
            bVar13.getClass();
            TextView textView = bVar13.G.f;
            String string = j0Var.getString(R.string.pre_registration_title);
            string.getClass();
            textView.setText(string);
            l5.E(textView);
            d5.b bVar14 = j0Var.f7785b;
            bVar14.getClass();
            ((RelativeLayout) bVar14.G.f7054i).setBackground(ContextCompat.getDrawable(j0Var.requireContext(), R.drawable.ripple_blue_primary_button));
            d5.b bVar15 = j0Var.f7785b;
            bVar15.getClass();
            bVar15.C.f7156q.setText(j0Var.getString(R.string.pre_registration_title));
            d5.b bVar16 = j0Var.f7785b;
            bVar16.getClass();
            bVar16.C.f7147d.setVisibility(0);
            d5.b bVar17 = j0Var.f7785b;
            bVar17.getClass();
            TextView textView2 = bVar17.G.f;
            int i10 = 1;
            textView2.setOnClickListener(new k(j0Var, textView2, i10));
            d5.b bVar18 = j0Var.f7785b;
            bVar18.getClass();
            RelativeLayout relativeLayout = bVar18.C.f7148i;
            relativeLayout.setOnClickListener(new k(j0Var, relativeLayout, i10));
        } else {
            j0Var.t();
        }
        d5.b bVar19 = j0Var.f7785b;
        bVar19.getClass();
        bVar19.J.f.setVisibility(0);
        d5.b bVar20 = j0Var.f7785b;
        bVar20.getClass();
        bVar20.J.f6917d.setVisibility(8);
        d5.b bVar21 = j0Var.f7785b;
        bVar21.getClass();
        bVar21.J.f6924o.setVisibility(8);
        d5.b bVar22 = j0Var.f7785b;
        bVar22.getClass();
        ((ImageView) bVar22.G.f7059n).setVisibility(8);
        d5.b bVar23 = j0Var.f7785b;
        bVar23.getClass();
        bVar23.f6887r.setVisibility(8);
        j0Var.I(R.id.action_antivirus_report);
        j0Var.I(R.id.action_uninstall);
    }

    public static final void l(j0 j0Var, int i10) {
        j0Var.J();
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        bVar.J.t.setText(j0Var.getString(R.string.unzipping_status, Integer.valueOf(i10)));
        d5.b bVar2 = j0Var.f7785b;
        bVar2.getClass();
        bVar2.C.f7153n.setText(j0Var.getString(R.string.unzipping_status, Integer.valueOf(i10)));
    }

    public static final void m(j0 j0Var, h5.y0 y0Var) {
        j0Var.r0();
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        ProgressBar progressBar = bVar.J.f6918i;
        d5.b bVar2 = j0Var.f7785b;
        bVar2.getClass();
        a.a.P(progressBar, bVar2.J.f6915b);
        u7.m0 m0Var = j0Var.G().I;
        m0Var.getClass();
        m0Var.g(null, 5);
        Context contextRequireContext = j0Var.requireContext();
        contextRequireContext.getClass();
        h5.q qVarA = y0Var.a(contextRequireContext);
        d5.b bVar3 = j0Var.f7785b;
        if (qVarA == null) {
            bVar3.getClass();
            bVar3.J.f6918i.setIndeterminate(true);
            d5.b bVar4 = j0Var.f7785b;
            bVar4.getClass();
            bVar4.C.e.setIndeterminate(true);
            return;
        }
        bVar3.getClass();
        bVar3.J.f.setVisibility(8);
        d5.b bVar5 = j0Var.f7785b;
        bVar5.getClass();
        bVar5.J.f6917d.setVisibility(0);
        d5.b bVar6 = j0Var.f7785b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.G.f7055j).setVisibility(8);
        d5.b bVar7 = j0Var.f7785b;
        bVar7.getClass();
        TextView textView = bVar7.G.f;
        String string = j0Var.getString(R.string.option_button_cancel);
        string.getClass();
        textView.setText(string);
        l5.F(textView);
        d5.b bVar8 = j0Var.f7785b;
        bVar8.getClass();
        ((RelativeLayout) bVar8.G.f7054i).setBackground(ContextCompat.getDrawable(j0Var.requireContext(), R.drawable.ripple_open_button));
        d5.b bVar9 = j0Var.f7785b;
        bVar9.getClass();
        bVar9.G.f.setOnClickListener(new e(j0Var, 4));
        boolean z9 = DownloadWorker.f;
        d5.b bVar10 = j0Var.f7785b;
        if (z9) {
            bVar10.getClass();
            TextView textView2 = bVar10.G.h;
            String string2 = j0Var.getString(R.string.updates_button_resume);
            string2.getClass();
            textView2.setText(string2);
            l5.E(textView2);
        } else {
            bVar10.getClass();
            TextView textView3 = bVar10.G.h;
            String string3 = j0Var.getString(R.string.action_pause);
            string3.getClass();
            textView3.setText(string3);
            l5.F(textView3);
        }
        int i10 = qVarA.i();
        d5.b bVar11 = j0Var.f7785b;
        if (i10 > 0) {
            bVar11.getClass();
            bVar11.J.f6918i.setIndeterminate(false);
            d5.b bVar12 = j0Var.f7785b;
            bVar12.getClass();
            bVar12.J.f6918i.setProgress(qVarA.i());
            d5.b bVar13 = j0Var.f7785b;
            bVar13.getClass();
            bVar13.C.e.setIndeterminate(false);
        } else {
            bVar11.getClass();
            bVar11.J.f6918i.setIndeterminate(true);
            d5.b bVar14 = j0Var.f7785b;
            bVar14.getClass();
            bVar14.C.e.setIndeterminate(true);
        }
        d5.b bVar15 = j0Var.f7785b;
        bVar15.getClass();
        TextView textView4 = bVar15.J.t;
        Integer numValueOf = Integer.valueOf(qVarA.i());
        long jK = qVarA.k();
        Context contextRequireContext2 = j0Var.requireContext();
        contextRequireContext2.getClass();
        textView4.setText(j0Var.getString(R.string.percent_of_total_size, numValueOf, l1.b.M(contextRequireContext2, jK)));
        d5.b bVar16 = j0Var.f7785b;
        bVar16.getClass();
        bVar16.C.f7145b.setVisibility(0);
        d5.b bVar17 = j0Var.f7785b;
        bVar17.getClass();
        TextView textView5 = bVar17.C.f7153n;
        long jK2 = (qVarA.k() * qVarA.i()) / 100;
        Context contextRequireContext3 = j0Var.requireContext();
        contextRequireContext3.getClass();
        textView5.setText(l1.b.M(contextRequireContext3, jK2));
        d5.b bVar18 = j0Var.f7785b;
        bVar18.getClass();
        bVar18.C.e.setProgress(qVarA.i());
        d5.b bVar19 = j0Var.f7785b;
        bVar19.getClass();
        bVar19.C.f7150k.setVisibility(8);
        d5.b bVar20 = j0Var.f7785b;
        bVar20.getClass();
        bVar20.C.f7152m.setVisibility(0);
        d5.b bVar21 = j0Var.f7785b;
        bVar21.getClass();
        bVar21.C.f7152m.setText(qVarA.i() + j0Var.getString(R.string.percent));
        d5.b bVar22 = j0Var.f7785b;
        bVar22.getClass();
        TextView textView6 = bVar22.C.f7154o;
        long jK3 = qVarA.k();
        Context contextRequireContext4 = j0Var.requireContext();
        contextRequireContext4.getClass();
        textView6.setText(String.format("/%s", Arrays.copyOf(new Object[]{l1.b.M(contextRequireContext4, jK3)}, 1)));
    }

    public static final void n(j0 j0Var, h5.h hVar) {
        if ((j0Var.getActivity() instanceof MainActivity) || (j0Var.getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = j0Var.getActivity();
            activity.getClass();
            ((l4.w) activity).i0(hVar, new androidx.work.impl.utils.c(3, hVar, j0Var));
        }
    }

    public static final void o(j0 j0Var, h5.t0 t0Var, int i10) {
        int dimension = (int) j0Var.getResources().getDimension(R.dimen.margin_m);
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        if (bVar.f6889s.getChildCount() > i10) {
            d5.b bVar2 = j0Var.f7785b;
            bVar2.getClass();
            bVar2.f6889s.removeViewAt(i10);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, dimension, 0, 0);
        boolean zB = t0Var.b();
        d5.b bVar3 = j0Var.f7785b;
        if (zB) {
            bVar3.getClass();
            LinearLayout linearLayout = bVar3.f6889s;
            Context contextRequireContext = j0Var.requireContext();
            contextRequireContext.getClass();
            linearLayout.addView(j0Var.Y(layoutParams, t0Var, contextRequireContext), i10);
            return;
        }
        bVar3.getClass();
        LinearLayout linearLayout2 = bVar3.f6889s;
        Context contextRequireContext2 = j0Var.requireContext();
        contextRequireContext2.getClass();
        linearLayout2.addView(j0Var.X(layoutParams, t0Var, contextRequireContext2), i10);
    }

    public final void A() {
        SharedPreferences sharedPreferences;
        long j10;
        CharSequence charSequence;
        ArrayList arrayList;
        if (getContext() != null) {
            boolean z9 = false;
            int i10 = 1;
            if (G().C.getValue() != null && G().D.getValue() != null) {
                float f = UptodownApp.E;
                Object value = G().C.getValue();
                value.getClass();
                ArrayList arrayListC = k4.c.c((h5.f) value);
                if (arrayListC != null && arrayListC.size() <= 1) {
                    synchronized (UptodownApp.f6638p0) {
                        arrayList = UptodownApp.f6639q0;
                    }
                    if (arrayList.size() <= 1) {
                        Context contextRequireContext = requireContext();
                        contextRequireContext.getClass();
                        Object value2 = G().D.getValue();
                        value2.getClass();
                        String str = ((h5.y0) value2).f8795b;
                        if (!k4.c.o(contextRequireContext, "GenerateQueueWorker")) {
                            WorkManager.Companion.getInstance(contextRequireContext).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", false).putString("packagename", str).build()).build());
                        }
                    }
                }
                if (DownloadWorker.f) {
                    y(new androidx.lifecycle.k(9));
                    return;
                }
                return;
            }
            if (getActivity() == null || !(getActivity() instanceof l4.w)) {
                return;
            }
            float f10 = UptodownApp.E;
            h5.h hVarD = D();
            FragmentActivity activity = getActivity();
            activity.getClass();
            int iT = k4.c.t(hVarD, (l4.w) activity);
            if (iT < 0) {
                Context contextRequireContext2 = requireContext();
                contextRequireContext2.getClass();
                c0(contextRequireContext2);
                return;
            }
            if (D().m() && (charSequence = (CharSequence) G().Y.getValue()) != null && charSequence.length() != 0) {
                long j11 = D().f8566a;
                Object value3 = G().Y.getValue();
                value3.getClass();
                String str2 = (String) value3;
                Context contextRequireContext3 = requireContext();
                contextRequireContext3.getClass();
                v5.g gVarL = v5.g.f13148u.l(contextRequireContext3);
                gVarL.a();
                if (gVarL.E(j11) == null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appId", Long.valueOf(j11));
                    contentValues.put("categoryFrom", str2);
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.insert("download_promoted", null, contentValues);
                }
                gVarL.b();
            }
            Context contextRequireContext4 = requireContext();
            contextRequireContext4.getClass();
            h5.e1 e1VarH = h5.c1.h(contextRequireContext4);
            boolean z10 = e1VarH != null && e1VarH.d();
            if (getContext() != null) {
                h5.h hVarD2 = D();
                if (hVarD2.C == 1 && hVarD2.G0 == 1 && !z10) {
                    Context contextRequireContext5 = requireContext();
                    contextRequireContext5.getClass();
                    SharedPreferences sharedPreferences2 = contextRequireContext5.getSharedPreferences("SettingsPreferences", 0);
                    try {
                        try {
                            j10 = sharedPreferences2.getLong("mintegral_interstitial_last_shown", 0L);
                        } catch (ClassCastException unused) {
                            j10 = 0;
                        }
                    } catch (ClassCastException unused2) {
                        long j12 = sharedPreferences2.getInt("mintegral_interstitial_last_shown", -1);
                        try {
                            SharedPreferences.Editor editorEdit = contextRequireContext5.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putLong("mintegral_interstitial_last_shown", j12);
                            editorEdit.apply();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        j10 = j12;
                    }
                    if (j10 == 0 || System.currentTimeMillis() - j10 >= 86400000) {
                        MBNewInterstitialHandler mBNewInterstitialHandler = new MBNewInterstitialHandler(requireContext(), "1525209", "3361225");
                        mBNewInterstitialHandler.setInterstitialVideoListener(new a4.f(this, mBNewInterstitialHandler, 19, z9));
                        mBNewInterstitialHandler.playVideoMute(1);
                        mBNewInterstitialHandler.load();
                    }
                }
            }
            float f11 = UptodownApp.E;
            String str3 = D().f8595w;
            h5.l lVar = UptodownApp.Z;
            if (lVar != null && o7.u.Z(r0.f.C(lVar.a()), str3, true)) {
                h5.l lVar2 = UptodownApp.Z;
                lVar2.getClass();
                lVar2.f8646c = iT;
                t3.h hVar = v5.g.f13148u;
                Context contextRequireContext6 = requireContext();
                contextRequireContext6.getClass();
                v5.g gVarL2 = hVar.l(contextRequireContext6);
                h5.q qVarZ = gVarL2.z(iT);
                if (qVarZ != null) {
                    qVarZ.f8713r = 1;
                    gVarL2.d0(qVarZ);
                }
                gVarL2.b();
            }
            String str4 = D().f8595w;
            str4.getClass();
            long j13 = D().f8566a;
            if (getContext() != null && iT >= 0) {
                Context contextRequireContext7 = requireContext();
                contextRequireContext7.getClass();
                h5.a0 a0VarJ = z1.t1.J(contextRequireContext7);
                if (a0VarJ != null && a0VarJ.f8462c == -1 && kotlin.jvm.internal.l.a(a0VarJ.f8461b, str4) && a0VarJ.f8460a == j13) {
                    Context contextRequireContext8 = requireContext();
                    contextRequireContext8.getClass();
                    a0VarJ.f8462c = iT;
                    a0VarJ.a(contextRequireContext8);
                }
            }
            Context contextRequireContext9 = requireContext();
            contextRequireContext9.getClass();
            float f12 = UptodownApp.E;
            if (k4.c.o(contextRequireContext9, "downloadApkWorker")) {
                d5.b bVar = this.f7785b;
                bVar.getClass();
                TextView textView = bVar.G.f;
                String string = getString(R.string.option_button_cancel);
                string.getClass();
                textView.setText(string);
                l5.F(textView);
                d5.b bVar2 = this.f7785b;
                bVar2.getClass();
                ((RelativeLayout) bVar2.G.f7054i).setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.ripple_open_button));
                d5.b bVar3 = this.f7785b;
                bVar3.getClass();
                bVar3.G.f.setOnClickListener(new e(this, i10));
                d5.b bVar4 = this.f7785b;
                bVar4.getClass();
                bVar4.C.f7145b.setVisibility(0);
                Context contextRequireContext10 = requireContext();
                contextRequireContext10.getClass();
                try {
                    sharedPreferences = contextRequireContext10.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception unused3) {
                }
                boolean z11 = sharedPreferences.contains("floating_download_queue_active") ? sharedPreferences.getBoolean("floating_download_queue_active", true) : true;
                if (!z11) {
                    FragmentActivity activity2 = getActivity();
                    activity2.getClass();
                    String string2 = getString(R.string.msg_added_to_downlads_queue);
                    string2.getClass();
                    ((l4.w) activity2).C(String.format(string2, Arrays.copyOf(new Object[]{D().f8567b}, 1)));
                }
            } else {
                WorkManager.Companion.getInstance(contextRequireContext9).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", iT).build()).build());
            }
            if (DownloadWorker.f) {
                y(new androidx.lifecycle.k(10));
            }
        }
    }

    public final void B() {
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b0(this, null, 2), 3);
    }

    public final void C() {
        if (getContext() == null || UptodownApp.P <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UptodownApp.P);
        d5.b bVar = this.f7785b;
        bVar.getClass();
        ((FullWidthImageView) bVar.I.f219c).setLayoutParams(layoutParams);
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        bVar2.f6869c.setScrimVisibleHeightTrigger((int) (UptodownApp.P * 0.4d));
    }

    public final h5.h D() {
        h5.h hVar = this.f7784a;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.l.i("appInfo");
        throw null;
    }

    public final void E() {
        if (D().f8566a > 0) {
            W();
            r();
        } else {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            new c1.l(contextRequireContext, ((Number) G().G.getValue()).longValue(), new c0(this, 1), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final long F() {
        try {
            String str = D().g;
            if (str != null && str.length() != 0) {
                String str2 = D().g;
                str2.getClass();
                return Long.parseLong(str2);
            }
            return 0L;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public final c1 G() {
        return (c1) this.f7786c.getValue();
    }

    public final boolean H() {
        File externalFilesDir;
        FragmentActivity activity = getActivity();
        activity.getClass();
        if (((l4.w) activity).n() && getContext() != null) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            w4 w4Var = new w4(contextRequireContext, 3, false);
            if (w4Var.D()) {
                File[] externalFilesDirs = contextRequireContext.getExternalFilesDirs(null);
                if (externalFilesDirs.length > 1) {
                    externalFilesDir = externalFilesDirs[1];
                } else {
                    externalFilesDir = contextRequireContext.getExternalFilesDir(null);
                    w4Var.P();
                    w4Var.O();
                }
            } else {
                externalFilesDir = contextRequireContext.getExternalFilesDir(null);
            }
            File file = new File(externalFilesDir, "Apps");
            if (!file.exists()) {
                file.mkdirs();
            }
            requireContext().getClass();
            if (r0.f.E(r0, file) < F() * 2.25d) {
                return false;
            }
        }
        return true;
    }

    public final void I(int i10) {
        Menu menu = this.g;
        if (menu != null) {
            menu.findItem(i10).setVisible(false);
        }
    }

    public final void J() {
        r0();
        d5.b bVar = this.f7785b;
        bVar.getClass();
        ProgressBar progressBar = bVar.J.f6918i;
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        a.a.P(progressBar, bVar2.J.f6915b);
        com.mbridge.msdk.dycreator.baseview.a.o(-1, G().I, null);
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.G.f7055j).setVisibility(8);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        bVar4.G.h.setVisibility(8);
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        ((RelativeLayout) bVar5.G.f7054i).setVisibility(8);
        d5.b bVar6 = this.f7785b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.G.f7056k).setVisibility(0);
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        bVar7.J.f6918i.setIndeterminate(true);
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        bVar8.J.t.setText(getString(R.string.status_download_update_pending));
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        bVar9.C.f7151l.setVisibility(8);
        d5.b bVar10 = this.f7785b;
        bVar10.getClass();
        bVar10.C.f7145b.setVisibility(4);
        d5.b bVar11 = this.f7785b;
        bVar11.getClass();
        bVar11.C.f7154o.setText("");
        d5.b bVar12 = this.f7785b;
        bVar12.getClass();
        bVar12.C.e.setIndeterminate(true);
        d5.b bVar13 = this.f7785b;
        bVar13.getClass();
        bVar13.C.f7152m.setText("");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x06b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(final androidx.fragment.app.FragmentActivity r17) {
        /*
            Method dump skipped, instructions count: 2311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.j0.K(androidx.fragment.app.FragmentActivity):void");
    }

    public final boolean L(h5.y0 y0Var) {
        if (y0Var != null) {
            float f = UptodownApp.E;
            return k4.c.k(y0Var);
        }
        String str = D().f8595w;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = D().f8595w;
        str2.getClass();
        h5.q qVar = DownloadWorker.f6738d;
        return qVar != null && kotlin.jvm.internal.l.a(qVar.f8701b, str2);
    }

    public final void M(File file) {
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        int i10 = l4.w.G;
        ((l4.w) activity).T(file, null);
    }

    public final void N(File file) {
        boolean zO;
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        boolean z9 = false;
        try {
            SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("show_installation_details")) {
                z9 = sharedPreferences.getBoolean("show_installation_details", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            M(file);
            return;
        }
        w wVar = new w(this, 3);
        if (getActivity() instanceof MainActivity) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            zO = ((MainActivity) activity).o();
        } else if (getActivity() instanceof AppDetailActivity) {
            FragmentActivity activity2 = getActivity();
            activity2.getClass();
            zO = ((AppDetailActivity) activity2).o();
        } else {
            zO = true;
        }
        String name = file.getName();
        name.getClass();
        if (!o7.u.X(name, ".xapk", true) && !o7.u.X(name, ".apks", true) && !o7.u.X(name, ".apkm", true)) {
            float f = UptodownApp.E;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            fragmentActivityRequireActivity.getClass();
            k4.c.p(fragmentActivityRequireActivity, file, D().T);
            return;
        }
        Context contextRequireContext2 = requireContext();
        contextRequireContext2.getClass();
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        new c1.g1(contextRequireContext2, absolutePath, wVar, zO);
    }

    public final void O(h5.t0 t0Var) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        w6.c cVar = null;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a3.o(this, t0Var, cVar, 8), 2);
        c1 c1VarG = G();
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        c1VarG.getClass();
        r7.y.q(ViewModelKt.getViewModelScope(c1VarG), y7.d.f14116a, null, new b9.p(c1VarG, t0Var, contextRequireContext, cVar, 4), 2);
    }

    public final void P(String str) {
        Bundle bundleF = com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        bundleF.putString("packagename", D().f8595w);
        if (D().f8566a >= 0) {
            bundleF.putString("appId", String.valueOf(D().f8566a));
        }
        if (D().A >= 0) {
            bundleF.putString("fileId", String.valueOf(D().A));
        }
        float f = UptodownApp.E;
        String str2 = D().f8595w;
        h5.l lVar = UptodownApp.Z;
        if (lVar == null || !o7.u.Z(r0.f.C(lVar.a()), str2, true)) {
            bundleF.putInt("deeplink", 0);
        } else {
            bundleF.putInt("deeplink", 1);
        }
        t1.c cVar = this.f7787d;
        if (cVar != null) {
            cVar.e(bundleF, "warning");
        }
    }

    public final void Q() {
        String str;
        if (getActivity() == null || requireActivity().isFinishing() || (str = D().f8595w) == null || str.length() == 0 || o7.u.Z(D().f8595w, requireActivity().getPackageName(), true)) {
            return;
        }
        PackageManager packageManager = requireActivity().getPackageManager();
        String str2 = D().f8595w;
        str2.getClass();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str2);
        if (launchIntentForPackage != null) {
            startActivity(launchIntentForPackage);
        }
    }

    public final void R(h5.k kVar) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            ((MainActivity) activity).h1(kVar);
        } else {
            if (getActivity() == null || !(getActivity() instanceof AppDetailActivity)) {
                return;
            }
            FragmentActivity activity2 = getActivity();
            activity2.getClass();
            ((AppDetailActivity) activity2).o0(kVar);
        }
    }

    public final void S() {
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        Intent intent = new Intent(requireActivity(), (Class<?>) LoginActivity.class);
        float f = UptodownApp.E;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        this.f7793n.launch(intent, k4.c.b(fragmentActivityRequireActivity));
    }

    public final void T() {
        if (requireActivity().isFinishing()) {
            return;
        }
        Intent intent = new Intent(requireActivity(), (Class<?>) ReviewsActivity.class);
        intent.putExtra("appInfo", D());
        intent.putExtra("myReview", (Parcelable) G().f7711v.getValue());
        float f = UptodownApp.E;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
    }

    public final void U(h5.t0 t0Var) {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            c5.x xVar = new c5.x(contextRequireContext, LifecycleOwnerKt.getLifecycleScope(this));
            String str = t0Var.f8740b;
            str.getClass();
            xVar.a(str, new c0(this, 4));
        }
    }

    public final void V() {
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        if (D().Q == null) {
            u7.m0 m0Var = G().T;
            Boolean bool = Boolean.TRUE;
            m0Var.getClass();
            m0Var.g(null, bool);
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b0(this, null, 12), 3);
            return;
        }
        Intent intent = new Intent(requireActivity(), (Class<?>) VirusTotalReport.class);
        intent.putExtra("appInfo", D());
        intent.putExtra("appReportVT", D().Q);
        float f = UptodownApp.E;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W() {
        /*
            Method dump skipped, instructions count: 2259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.j0.W():void");
    }

    public final RelativeLayout X(LinearLayout.LayoutParams layoutParams, h5.t0 t0Var, Context context) {
        int i10;
        CharSequence charSequenceV0;
        d5.q0 q0VarA = d5.q0.a(getLayoutInflater().inflate(R.layout.review, (ViewGroup) null, false));
        TextView textView = q0VarA.f7305o;
        LinearLayout linearLayout = q0VarA.f7301k;
        ImageView imageView = q0VarA.f7297c;
        TextView textView2 = q0VarA.f7307q;
        TextView textView3 = q0VarA.f7304n;
        LinearLayout linearLayout2 = q0VarA.f7302l;
        ImageView imageView2 = q0VarA.f7298d;
        TextView textView4 = q0VarA.f7306p;
        TextView textView5 = q0VarA.f7303m;
        UsernameTextView usernameTextView = q0VarA.f7309s;
        RelativeLayout relativeLayout = q0VarA.f7295a;
        relativeLayout.setLayoutParams(layoutParams);
        q0VarA.f.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        ImageView imageView3 = q0VarA.g;
        imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        ImageView imageView4 = q0VarA.h;
        imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        ImageView imageView5 = q0VarA.f7299i;
        imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        ImageView imageView6 = q0VarA.f7300j;
        imageView6.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        if (t0Var.g >= 2) {
            i10 = R.drawable.vector_star_on;
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        } else {
            i10 = R.drawable.vector_star_on;
        }
        if (t0Var.g >= 3) {
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, i10));
        }
        int i11 = 4;
        if (t0Var.g >= 4) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, i10));
        }
        int i12 = 5;
        if (t0Var.g == 5) {
            imageView6.setImageDrawable(ContextCompat.getDrawable(context, i10));
        }
        usernameTextView.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        String strE = h5.c1.e(t0Var.f8742d);
        if (strE == null || strE.length() == 0) {
            charSequenceV0 = null;
        } else {
            j4.d0 d0VarE = j4.y.d().e(h5.c1.e(t0Var.f8742d));
            float f = UptodownApp.E;
            d0VarE.g(k4.c.y(context));
            charSequenceV0 = null;
            d0VarE.e(imageView, null);
        }
        String str = t0Var.f8740b;
        if (str != null && str.length() != 0) {
            imageView.setOnClickListener(new i(this, t0Var, i11));
            usernameTextView.setOnClickListener(new i(this, t0Var, i12));
        }
        String str2 = t0Var.f8741c;
        if (str2 != null && str2.length() != 0) {
            usernameTextView.setText(t0Var.f8741c);
            int i13 = UsernameTextView.f6728j;
            l1.b.j(usernameTextView, t0Var.b(), t0Var.f8748n);
        }
        String str3 = t0Var.f8743i;
        if (str3 != null && str3.length() != 0) {
            textView3.setText(t0Var.f8743i);
        }
        int i14 = t0Var.h;
        if (i14 > 0) {
            textView2.setText(String.valueOf(i14));
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        h5.e1 e1VarH = h5.c1.h(contextRequireContext);
        int i15 = 1;
        if (kotlin.jvm.internal.l.a(e1VarH != null ? e1VarH.f8512a : charSequenceV0, t0Var.f8740b)) {
            imageView2.setVisibility(8);
        } else {
            com.mbridge.msdk.dycreator.baseview.a.r(this, t0Var.f8749o == 1 ? R.drawable.vector_following : R.drawable.vector_follow, imageView2);
            imageView2.setOnClickListener(new i(this, t0Var, 6));
        }
        String str4 = t0Var.f;
        if (str4 == null || str4.length() == 0) {
            textView5.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout.setVisibility(8);
        } else {
            textView4.setFocusable(true);
            Spanned spannedA = t0Var.a();
            if (spannedA != null) {
                charSequenceV0 = o7.m.v0(spannedA);
            }
            textView5.setText(charSequenceV0);
            textView5.getViewTreeObserver().addOnPreDrawListener(new g0(q0VarA, 0));
            q0VarA.f7308r.setOnClickListener(new b5.a(11, q0VarA, this));
            linearLayout2.setOnClickListener(new i(this, t0Var, 7));
            linearLayout2.setFocusable(true);
            textView.setTypeface(o4.b.f11720s);
            textView.setText(String.valueOf(t0Var.f8744j));
            if (v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
                com.mbridge.msdk.dycreator.baseview.a.r(this, R.drawable.vector_heart_red, q0VarA.e);
            }
            linearLayout.setOnClickListener(new j(this, q0VarA, t0Var, i15));
        }
        textView4.setFocusable(true);
        return relativeLayout;
    }

    public final RelativeLayout Y(LinearLayout.LayoutParams layoutParams, h5.t0 t0Var, Context context) {
        int i10;
        CharSequence charSequenceV0;
        int i11;
        d5.s0 s0VarA = d5.s0.a(getLayoutInflater().inflate(R.layout.review_turbo, (ViewGroup) null, false));
        ImageView imageView = s0VarA.f7336k;
        LinearLayout linearLayout = s0VarA.f7337l;
        TextView textView = s0VarA.f7341p;
        TextView textView2 = s0VarA.f7343r;
        TextView textView3 = s0VarA.f7340o;
        LinearLayout linearLayout2 = s0VarA.f7338m;
        ImageView imageView2 = s0VarA.f7333d;
        ImageView imageView3 = s0VarA.f7332c;
        TextView textView4 = s0VarA.f7342q;
        TextView textView5 = s0VarA.f7339n;
        UsernameTextView usernameTextView = s0VarA.t;
        RelativeLayout relativeLayout = s0VarA.f7330a;
        relativeLayout.setLayoutParams(layoutParams);
        s0VarA.f.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on_turbo));
        ImageView imageView4 = s0VarA.g;
        imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off_turbo));
        ImageView imageView5 = s0VarA.h;
        imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off_turbo));
        ImageView imageView6 = s0VarA.f7334i;
        imageView6.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off_turbo));
        ImageView imageView7 = s0VarA.f7335j;
        imageView7.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off_turbo));
        if (t0Var.g >= 2) {
            i10 = R.drawable.vector_star_on_turbo;
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on_turbo));
        } else {
            i10 = R.drawable.vector_star_on_turbo;
        }
        int i12 = 3;
        if (t0Var.g >= 3) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, i10));
        }
        if (t0Var.g >= 4) {
            imageView6.setImageDrawable(ContextCompat.getDrawable(context, i10));
        }
        int i13 = 5;
        if (t0Var.g == 5) {
            imageView7.setImageDrawable(ContextCompat.getDrawable(context, i10));
        }
        usernameTextView.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        if (h5.c1.e(t0Var.f8742d) != null) {
            j4.d0 d0VarE = j4.y.d().e(h5.c1.e(t0Var.f8742d));
            float f = UptodownApp.E;
            d0VarE.g(k4.c.y(context));
            charSequenceV0 = null;
            d0VarE.e(imageView3, null);
        } else {
            charSequenceV0 = null;
        }
        String str = t0Var.f8740b;
        int i14 = 1;
        if (str != null && str.length() != 0) {
            imageView3.setOnClickListener(new i(this, t0Var, 0));
            usernameTextView.setOnClickListener(new i(this, t0Var, i14));
        }
        String str2 = t0Var.f8741c;
        if (str2 != null) {
            usernameTextView.setText(str2);
            int i15 = UsernameTextView.f6728j;
            l1.b.j(usernameTextView, t0Var.b(), t0Var.f8748n);
        }
        String str3 = t0Var.f8743i;
        if (str3 != null) {
            textView3.setText(str3);
        }
        int i16 = t0Var.h;
        if (i16 > 0) {
            textView2.setText(String.valueOf(i16));
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        h5.e1 e1VarH = h5.c1.h(contextRequireContext);
        if (kotlin.jvm.internal.l.a(e1VarH != null ? e1VarH.f8512a : charSequenceV0, t0Var.f8740b)) {
            imageView2.setVisibility(8);
        } else {
            com.mbridge.msdk.dycreator.baseview.a.r(this, t0Var.f8749o == 1 ? R.drawable.vector_following : R.drawable.vector_follow, imageView2);
            imageView2.setOnClickListener(new i(this, t0Var, 2));
        }
        if (t0Var.f != null) {
            textView4.setFocusable(true);
            Spanned spannedA = t0Var.a();
            if (spannedA != null) {
                charSequenceV0 = o7.m.v0(spannedA);
            }
            textView5.setText(charSequenceV0);
            textView5.getViewTreeObserver().addOnPreDrawListener(new g0(s0VarA, i14));
            s0VarA.f7344s.setOnClickListener(new b5.a(9, s0VarA, this));
            linearLayout2.setOnClickListener(new i(this, t0Var, i12));
            linearLayout2.setFocusable(true);
            textView.setTypeface(o4.b.f11720s);
            textView.setText(String.valueOf(t0Var.f8744j));
            if (v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
                com.mbridge.msdk.dycreator.baseview.a.r(this, R.drawable.vector_heart_red, s0VarA.e);
            }
            i11 = 0;
            linearLayout.setOnClickListener(new j(this, s0VarA, t0Var, i11));
        } else {
            i11 = 0;
            textView5.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new e(this, i13));
        imageView.setVisibility(i11);
        int dimension = (int) imageView3.getContext().getResources().getDimension(R.dimen.border_radius_xs);
        imageView3.setForeground(ContextCompat.getDrawable(imageView3.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
        imageView3.setPadding(dimension, dimension, dimension, dimension);
        textView4.setFocusable(true);
        return relativeLayout;
    }

    public final void Z(String str) {
        int iIntValue = ((Number) G().S.getValue()).intValue();
        if (1 > iIntValue || iIntValue >= 6) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            String string = getString(R.string.error_review_no_valoration);
            string.getClass();
            ((l4.w) activity).C(string);
            return;
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new b0(this, null, 15), 2);
        c1 c1VarG = G();
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        int iIntValue2 = ((Number) G().S.getValue()).intValue();
        long j10 = D().f8566a;
        c1VarG.getClass();
        str.getClass();
        r7.y.q(ViewModelKt.getViewModelScope(c1VarG), y7.d.f14116a, null, new a1(contextRequireContext, str, iIntValue2, j10, c1VarG, null), 2);
    }

    public final void a0() {
        d5.b bVar = this.f7785b;
        bVar.getClass();
        if (bVar.f6870d.getChildCount() == 0) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            c0(contextRequireContext);
            View viewInflate = getLayoutInflater().inflate(R.layout.checking_compatibility, (ViewGroup) null, false);
            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_checking_device);
            if (textView == null) {
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.tv_checking_device)));
                return;
            }
            textView.setTypeface(o4.b.f11720s);
            d5.b bVar2 = this.f7785b;
            bVar2.getClass();
            bVar2.f6870d.addView((LinearLayout) viewInflate);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new l(this, 0), 5000L);
    }

    public final void b0(String str) {
        d5.b bVar = this.f7785b;
        bVar.getClass();
        bVar.J.f.setVisibility(0);
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        bVar2.J.f6917d.setVisibility(8);
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        bVar3.G.f7053d.setVisibility(0);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        ((RelativeLayout) bVar4.G.f7054i).setVisibility(8);
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        ((RelativeLayout) bVar5.G.f7055j).setVisibility(8);
        d5.b bVar6 = this.f7785b;
        bVar6.getClass();
        bVar6.G.h.setVisibility(8);
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        bVar7.C.f.setVisibility(0);
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        bVar8.C.f7155p.setVisibility(8);
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        bVar9.C.g.setVisibility(8);
        d5.b bVar10 = this.f7785b;
        bVar10.getClass();
        bVar10.C.f7151l.setVisibility(8);
        com.mbridge.msdk.dycreator.baseview.a.o(-1, G().I, null);
        d5.b bVar11 = this.f7785b;
        bVar11.getClass();
        ((ImageView) bVar11.G.f7059n).setVisibility(8);
        d5.b bVar12 = this.f7785b;
        bVar12.getClass();
        bVar12.J.f6917d.setVisibility(8);
        d5.b bVar13 = this.f7785b;
        bVar13.getClass();
        bVar13.G.e.setText(str);
        d5.b bVar14 = this.f7785b;
        bVar14.getClass();
        bVar14.C.f7149j.setText(str);
        d5.b bVar15 = this.f7785b;
        bVar15.getClass();
        bVar15.C.f7155p.setOnClickListener(null);
        d5.b bVar16 = this.f7785b;
        bVar16.getClass();
        bVar16.C.f.setOnClickListener(new e(this, 26));
        d5.b bVar17 = this.f7785b;
        bVar17.getClass();
        bVar17.G.f7053d.setOnClickListener(new e(this, 27));
    }

    public final void c0(Context context) {
        String string;
        SharedPreferences sharedPreferences;
        q0();
        d5.b bVar = this.f7785b;
        bVar.getClass();
        ProgressBar progressBar = bVar.J.f6918i;
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        a.a.x(progressBar, bVar2.J.f6915b);
        com.mbridge.msdk.dycreator.baseview.a.o(-1, G().I, null);
        try {
            sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences.contains("install_apk_as_root_system") ? sharedPreferences.getBoolean("install_apk_as_root_system", false) : false;
        if (z9) {
            string = context.getString(R.string.option_button_install);
            string.getClass();
        } else {
            String str = D().W;
            if (str == null || str.length() == 0) {
                string = context.getString(R.string.option_button_install);
                string.getClass();
            } else {
                HashMap map = D().f8590t0;
                String str2 = map != null ? (String) map.get("try") : null;
                if (str2 == null || str2.length() == 0) {
                    string = context.getString(R.string.option_button_install);
                    string.getClass();
                } else {
                    string = str2;
                }
            }
        }
        if (((Boolean) G().U.getValue()).booleanValue() && D().k()) {
            d5.b bVar3 = this.f7785b;
            bVar3.getClass();
            bVar3.G.f7052c.setVisibility(0);
            d5.b bVar4 = this.f7785b;
            bVar4.getClass();
            ((ImageView) bVar4.G.f7057l).setVisibility(0);
        } else {
            d5.b bVar5 = this.f7785b;
            bVar5.getClass();
            bVar5.G.f7052c.setVisibility(8);
            d5.b bVar6 = this.f7785b;
            bVar6.getClass();
            ((ImageView) bVar6.G.f7057l).setVisibility(8);
        }
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        ((RelativeLayout) bVar7.G.f7055j).setVisibility(8);
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        bVar8.J.f.setVisibility(0);
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        bVar9.J.f6917d.setVisibility(8);
        d5.b bVar10 = this.f7785b;
        bVar10.getClass();
        TextView textView = bVar10.G.f;
        textView.setText(string);
        l5.E(textView);
        d5.b bVar11 = this.f7785b;
        bVar11.getClass();
        ((RelativeLayout) bVar11.G.f7054i).setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.ripple_blue_primary_button));
        d5.b bVar12 = this.f7785b;
        bVar12.getClass();
        bVar12.G.f.setOnClickListener(new e(this, 29));
        d5.b bVar13 = this.f7785b;
        bVar13.getClass();
        bVar13.C.f7145b.setVisibility(4);
        d5.b bVar14 = this.f7785b;
        bVar14.getClass();
        TextView textView2 = bVar14.C.f7155p;
        textView2.setText(string);
        l5.E(textView2);
        if (G().C.getValue() == null) {
            I(R.id.action_uninstall);
            I(R.id.action_app_installed_details);
        }
    }

    public final void d0(h5.q qVar) {
        r0();
        d5.b bVar = this.f7785b;
        bVar.getClass();
        ProgressBar progressBar = bVar.J.f6918i;
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        a.a.P(progressBar, bVar2.J.f6915b);
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        TextView textView = bVar3.G.f;
        String string = getString(R.string.option_button_cancel);
        string.getClass();
        textView.setText(string);
        l5.F(textView);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        ((RelativeLayout) bVar4.G.f7054i).setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.ripple_open_button));
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        ((RelativeLayout) bVar5.G.f7055j).setVisibility(8);
        d5.b bVar6 = this.f7785b;
        bVar6.getClass();
        bVar6.C.f7146c.setVisibility(8);
        com.mbridge.msdk.dycreator.baseview.a.o(5, G().I, null);
        if (qVar == null && getContext() != null) {
            t3.h hVar = v5.g.f13148u;
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            v5.g gVarL = hVar.l(contextRequireContext);
            gVarL.a();
            String str = D().f8595w;
            str.getClass();
            h5.q qVarB = gVarL.B(D().B, str);
            gVarL.b();
            qVar = qVarB;
        }
        d5.b bVar7 = this.f7785b;
        int i10 = 1;
        if (qVar == null) {
            bVar7.getClass();
            bVar7.J.f6918i.setIndeterminate(true);
            d5.b bVar8 = this.f7785b;
            bVar8.getClass();
            bVar8.C.e.setIndeterminate(true);
            return;
        }
        bVar7.getClass();
        bVar7.G.f.setOnClickListener(new r(this, i10));
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        bVar9.C.f7145b.setVisibility(0);
        boolean zL = L(null);
        d5.b bVar10 = this.f7785b;
        if (zL) {
            bVar10.getClass();
            TextView textView2 = bVar10.G.h;
            String string2 = getString(R.string.action_pause);
            string2.getClass();
            textView2.setText(string2);
            l5.F(textView2);
            String strValueOf = String.valueOf(qVar.i());
            if (isAdded() && getContext() != null) {
                StringBuilder sbV = a3.a.v(strValueOf);
                sbV.append(requireContext().getString(R.string.percent));
                strValueOf = sbV.toString();
            }
            d5.b bVar11 = this.f7785b;
            bVar11.getClass();
            bVar11.J.f6918i.setIndeterminate(false);
            d5.b bVar12 = this.f7785b;
            bVar12.getClass();
            bVar12.J.f6918i.setProgress(qVar.i());
            if (qVar.k() > 0) {
                d5.b bVar13 = this.f7785b;
                bVar13.getClass();
                TextView textView3 = bVar13.J.t;
                Integer numValueOf = Integer.valueOf(qVar.i());
                long jK = qVar.k();
                Context contextRequireContext2 = requireContext();
                contextRequireContext2.getClass();
                textView3.setText(getString(R.string.percent_of_total_size, numValueOf, l1.b.M(contextRequireContext2, jK)));
            }
            d5.b bVar14 = this.f7785b;
            bVar14.getClass();
            bVar14.C.e.setIndeterminate(false);
            d5.b bVar15 = this.f7785b;
            bVar15.getClass();
            bVar15.C.f7152m.setVisibility(0);
            d5.b bVar16 = this.f7785b;
            bVar16.getClass();
            bVar16.C.f7150k.setVisibility(8);
            d5.b bVar17 = this.f7785b;
            bVar17.getClass();
            bVar17.C.f7152m.setText(strValueOf);
            d5.b bVar18 = this.f7785b;
            bVar18.getClass();
            TextView textView4 = bVar18.C.f7153n;
            long j10 = qVar.j();
            Context contextRequireContext3 = requireContext();
            contextRequireContext3.getClass();
            textView4.setText(l1.b.M(contextRequireContext3, j10));
            d5.b bVar19 = this.f7785b;
            bVar19.getClass();
            bVar19.C.e.setProgress(qVar.i());
        } else {
            bVar10.getClass();
            bVar10.J.t.setText(getString(R.string.status_download_update_pending));
            d5.b bVar20 = this.f7785b;
            bVar20.getClass();
            bVar20.J.f6918i.setIndeterminate(true);
            d5.b bVar21 = this.f7785b;
            bVar21.getClass();
            bVar21.C.e.setIndeterminate(true);
            d5.b bVar22 = this.f7785b;
            bVar22.getClass();
            bVar22.C.f7150k.setVisibility(0);
            d5.b bVar23 = this.f7785b;
            bVar23.getClass();
            bVar23.C.f7152m.setVisibility(8);
        }
        d5.b bVar24 = this.f7785b;
        bVar24.getClass();
        TextView textView5 = bVar24.C.f7154o;
        long jK2 = qVar.k();
        Context contextRequireContext4 = requireContext();
        contextRequireContext4.getClass();
        textView5.setText(String.format("/%s", Arrays.copyOf(new Object[]{l1.b.M(contextRequireContext4, jK2)}, 1)));
    }

    public final void e0() {
        File externalFilesDir;
        boolean zE;
        boolean zIsEmpty;
        boolean z9;
        boolean zD;
        SharedPreferences sharedPreferences;
        String str;
        File externalFilesDir2;
        w6.c cVar = null;
        d0(null);
        u7.m0 m0Var = G().I;
        int i10 = 5;
        m0Var.getClass();
        m0Var.g(null, 5);
        long jF = F();
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        int i11 = 0;
        w4 w4Var = new w4(contextRequireContext, 3, false);
        int i12 = 1;
        if (w4Var.D()) {
            File[] externalFilesDirs = contextRequireContext.getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalFilesDir = externalFilesDirs[1];
            } else {
                externalFilesDir = contextRequireContext.getExternalFilesDir(null);
                w4Var.P();
                w4Var.O();
            }
        } else {
            externalFilesDir = contextRequireContext.getExternalFilesDir(null);
        }
        File file = new File(externalFilesDir, "Apps");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.exists() && !file.mkdirs()) {
            String string = getString(R.string.error_cant_create_dir);
            string.getClass();
            x(string);
            return;
        }
        if (!H()) {
            Context contextRequireContext2 = requireContext();
            contextRequireContext2.getClass();
            g0(contextRequireContext2, null);
            Context contextRequireContext3 = requireContext();
            contextRequireContext3.getClass();
            w4 w4Var2 = new w4(contextRequireContext3, 3, false);
            if (w4Var2.D()) {
                File[] externalFilesDirs2 = contextRequireContext3.getExternalFilesDirs(null);
                if (externalFilesDirs2.length > 1) {
                    externalFilesDir2 = externalFilesDirs2[1];
                } else {
                    externalFilesDir2 = contextRequireContext3.getExternalFilesDir(null);
                    w4Var2.P();
                    w4Var2.O();
                }
            } else {
                externalFilesDir2 = contextRequireContext3.getExternalFilesDir(null);
            }
            File file2 = new File(externalFilesDir2, "Apps");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            Context contextRequireContext4 = requireContext();
            contextRequireContext4.getClass();
            long jE = r0.f.E(contextRequireContext4, file2);
            long totalSpace = file2.getTotalSpace();
            Context contextRequireContext5 = requireContext();
            contextRequireContext5.getClass();
            String strM = l1.b.M(contextRequireContext5, (long) (F() * 2.25d));
            long j10 = ((totalSpace - jE) * 100) / totalSpace;
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            View viewInflate = getLayoutInflater().inflate(R.layout.warning_not_space_available_dialog, (ViewGroup) null, false);
            int i13 = R.id.pb_not_storage;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(viewInflate, R.id.pb_not_storage);
            if (progressBar != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                int i14 = R.id.tv_no_storage_action;
                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_storage_action);
                if (textView != null) {
                    i14 = R.id.tv_not_storage;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_not_storage);
                    if (textView2 != null) {
                        i14 = R.id.tv_not_storage_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_not_storage_text);
                        if (textView3 != null) {
                            i14 = R.id.tv_not_storage_title;
                            if (((TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_not_storage_title)) != null) {
                                textView2.setTypeface(o4.b.f11720s);
                                progressBar.setProgress((int) j10);
                                textView3.setTypeface(o4.b.f11720s);
                                textView3.setText(getString(R.string.no_storage_text, strM));
                                textView.setTypeface(o4.b.f11719r);
                                textView.setOnClickListener(new r(this, i10));
                                builder.setView(linearLayout);
                                l0(builder);
                                return;
                            }
                        }
                    }
                }
                i13 = i14;
            }
            androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i13)));
            return;
        }
        d5.b bVar = this.f7785b;
        bVar.getClass();
        bVar.J.t.setVisibility(0);
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        bVar2.J.t.setText(getString(R.string.status_download_update_pending));
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        bVar3.J.f6918i.setProgress(0);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        bVar4.C.f7150k.setVisibility(0);
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        bVar5.C.f7152m.setVisibility(8);
        d5.b bVar6 = this.f7785b;
        bVar6.getClass();
        bVar6.C.f7153n.setText(R.string.zero_mb);
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        TextView textView4 = bVar7.C.f7154o;
        Context contextRequireContext6 = requireContext();
        contextRequireContext6.getClass();
        textView4.setText(String.format("/%s", Arrays.copyOf(new Object[]{l1.b.M(contextRequireContext6, jF), requireContext()}, 2)));
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        bVar8.C.e.setProgress(0);
        AlertDialog alertDialog = this.e;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        AlertDialog alertDialogA = v5.c.a(alertDialog, fragmentActivityRequireActivity);
        this.e = alertDialogA;
        if (alertDialogA == null) {
            if (D().j()) {
                h5.q qVar = new h5.q();
                qVar.a(D());
                if (D().m() && (str = D().f8594v0) != null && str.length() != 0) {
                    long j11 = D().f8566a;
                    String str2 = D().f8594v0;
                    str2.getClass();
                    Context contextRequireContext7 = requireContext();
                    contextRequireContext7.getClass();
                    v5.g gVarL = v5.g.f13148u.l(contextRequireContext7);
                    gVarL.a();
                    if (gVarL.E(j11) == null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appId", Long.valueOf(j11));
                        contentValues.put("categoryFrom", str2);
                        SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                        sQLiteDatabase.getClass();
                        sQLiteDatabase.insert("download_promoted", null, contentValues);
                    }
                    gVarL.b();
                }
                h5.p pVar = new h5.p();
                Context contextRequireContext8 = requireContext();
                contextRequireContext8.getClass();
                pVar.g(contextRequireContext8);
                Context contextRequireContext9 = requireContext();
                contextRequireContext9.getClass();
                try {
                    sharedPreferences = contextRequireContext9.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception unused) {
                }
                boolean z10 = sharedPreferences.contains("show_warning_download_incompatible") ? sharedPreferences.getBoolean("show_warning_download_incompatible", true) : true;
                if (z10) {
                    z9 = qVar.f8707l <= pVar.h;
                    zD = pVar.d(qVar);
                    zE = pVar.e(qVar);
                    if (D().L != null) {
                        ArrayList arrayList = D().L;
                        arrayList.getClass();
                        Context contextRequireContext10 = requireContext();
                        contextRequireContext10.getClass();
                        zIsEmpty = h5.p.c(arrayList, contextRequireContext10).isEmpty();
                    } else {
                        zIsEmpty = true;
                    }
                } else {
                    zE = true;
                    zIsEmpty = true;
                    z9 = true;
                    zD = true;
                }
                if (z9 && zD && zE && zIsEmpty) {
                    if (getActivity() != null && !requireActivity().isFinishing()) {
                        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
                        fragmentActivityRequireActivity2.getClass();
                        h5.e1 e1VarH = h5.c1.h(fragmentActivityRequireActivity2);
                        if (e1VarH == null || !e1VarH.d()) {
                            A();
                        } else if (D().Q == null) {
                            r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b0(this, cVar, i12), 3);
                        } else {
                            h5.o0 o0Var = D().Q;
                            o0Var.getClass();
                            if (o0Var.f8677c > 0) {
                                FragmentActivity activity = getActivity();
                                activity.getClass();
                                ((l4.w) activity).P(D(), new u(this, i11), new u(this, i12));
                            } else {
                                A();
                            }
                        }
                    }
                } else if (!z9) {
                    P("sdk");
                    String string2 = getString(R.string.msg_warning_incompatible_sdk);
                    string2.getClass();
                    w(string2);
                } else if (!zD) {
                    P("abi");
                    String string3 = getString(R.string.msg_warning_incompatible_abi);
                    string3.getClass();
                    w(string3);
                } else if (zE) {
                    P("required_feature");
                    String string4 = getString(R.string.msg_warning_incompatible_required_features);
                    string4.getClass();
                    w(string4);
                } else {
                    P("density");
                    String string5 = getString(R.string.msg_warning_incompatible_density);
                    string5.getClass();
                    w(string5);
                }
            } else {
                P("no_file_id");
                String string6 = getString(R.string.msg_app_no_compatible_files);
                string6.getClass();
                x(string6);
            }
            d0(null);
        }
    }

    public final void f0() {
        q0();
        d5.b bVar = this.f7785b;
        bVar.getClass();
        ProgressBar progressBar = bVar.J.f6918i;
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        a.a.x(progressBar, bVar2.J.f6915b);
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        bVar3.J.f.setVisibility(0);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        bVar4.J.f6917d.setVisibility(8);
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        bVar5.G.f7052c.setVisibility(8);
        d5.b bVar6 = this.f7785b;
        bVar6.getClass();
        bVar6.G.f.setOnClickListener(new r(this, 14));
        com.mbridge.msdk.dycreator.baseview.a.o(3, G().I, null);
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        TextView textView = bVar7.G.f;
        String string = getString(R.string.option_button_install);
        string.getClass();
        textView.setText(string);
        l5.E(textView);
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        ((RelativeLayout) bVar8.G.f7054i).setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.ripple_blue_primary_button));
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        TextView textView2 = bVar9.C.f7155p;
        String string2 = getString(R.string.option_button_install);
        string2.getClass();
        textView2.setText(string2);
        l5.E(textView2);
        I(R.id.action_app_installed_details);
        I(R.id.action_uninstall);
    }

    public final void g0(Context context, h5.q qVar) {
        File externalFilesDir;
        long totalSpace;
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        w4 w4Var = new w4(contextRequireContext, 3, false);
        if (w4Var.D()) {
            File[] externalFilesDirs = contextRequireContext.getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalFilesDir = externalFilesDirs[1];
            } else {
                externalFilesDir = contextRequireContext.getExternalFilesDir(null);
                w4Var.P();
                w4Var.O();
            }
        } else {
            externalFilesDir = contextRequireContext.getExternalFilesDir(null);
        }
        File file = new File(externalFilesDir, "Apps");
        if (!file.exists()) {
            file.mkdirs();
        }
        Context contextRequireContext2 = requireContext();
        contextRequireContext2.getClass();
        long jE = r0.f.E(contextRequireContext2, file);
        try {
            totalSpace = file.getTotalSpace();
        } catch (SecurityException unused) {
            totalSpace = 0;
        }
        if (totalSpace > 0) {
            Context contextRequireContext3 = requireContext();
            contextRequireContext3.getClass();
            String strM = l1.b.M(contextRequireContext3, ((long) (F() * 2.25d)) - jE);
            long j10 = ((totalSpace - jE) * 100) / totalSpace;
            d5.b bVar = this.f7785b;
            bVar.getClass();
            ((TextView) bVar.K0.f7136d).setTypeface(o4.b.f11720s);
            d5.b bVar2 = this.f7785b;
            bVar2.getClass();
            ((ProgressBar) bVar2.K0.g).setProgress((int) j10);
            d5.b bVar3 = this.f7785b;
            bVar3.getClass();
            ((TextView) bVar3.K0.e).setTypeface(o4.b.f11720s);
            d5.b bVar4 = this.f7785b;
            bVar4.getClass();
            ((TextView) bVar4.K0.e).setText(context.getString(R.string.no_storage_text, strM));
            d5.b bVar5 = this.f7785b;
            bVar5.getClass();
            ((TextView) bVar5.K0.f7135c).setTypeface(o4.b.f11719r);
            d5.b bVar6 = this.f7785b;
            bVar6.getClass();
            ((TextView) bVar6.K0.f7135c).setOnClickListener(new r(this, 22));
            d5.b bVar7 = this.f7785b;
            bVar7.getClass();
            ((RelativeLayout) bVar7.K0.f7134b).setVisibility(0);
        }
        if (qVar == null || !qVar.c()) {
            c0(context);
        } else {
            f0();
        }
    }

    public final void h0(Context context) {
        String string;
        d5.b bVar = this.f7785b;
        bVar.getClass();
        bVar.J.f.setVisibility(0);
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        bVar2.J.f6917d.setVisibility(8);
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.G.f7054i).setVisibility(8);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        bVar4.G.f.setVisibility(8);
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        bVar5.G.f7052c.setVisibility(8);
        d5.b bVar6 = this.f7785b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.G.f7055j).setVisibility(0);
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        bVar7.G.h.setVisibility(8);
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        bVar8.C.f7155p.setVisibility(8);
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        bVar9.C.g.setVisibility(8);
        d5.b bVar10 = this.f7785b;
        bVar10.getClass();
        bVar10.C.f7151l.setVisibility(0);
        d5.b bVar11 = this.f7785b;
        bVar11.getClass();
        ProgressBar progressBar = bVar11.J.f6918i;
        d5.b bVar12 = this.f7785b;
        bVar12.getClass();
        a.a.x(progressBar, bVar12.J.f6915b);
        u7.m0 m0Var = G().I;
        m0Var.getClass();
        m0Var.g(null, 0);
        h5.k kVar = D().f8597x;
        if (kVar == null || kVar.g != 1) {
            string = context.getString(R.string.open);
            string.getClass();
        } else {
            string = context.getString(R.string.app_detail_play_button);
            string.getClass();
        }
        d5.b bVar13 = this.f7785b;
        bVar13.getClass();
        bVar13.C.f7151l.setText(string);
        d5.b bVar14 = this.f7785b;
        bVar14.getClass();
        bVar14.G.g.setText(string);
        m0(R.id.action_uninstall);
        m0(R.id.action_app_installed_details);
        String str = D().f8595w;
        if (str == null || str.length() == 0 || !o7.u.Z(requireActivity().getPackageName(), D().f8595w, true)) {
            return;
        }
        d5.b bVar15 = this.f7785b;
        bVar15.getClass();
        ((ImageView) bVar15.G.f7058m).setVisibility(8);
        d5.b bVar16 = this.f7785b;
        bVar16.getClass();
        ((RelativeLayout) bVar16.G.f7055j).setVisibility(8);
        d5.b bVar17 = this.f7785b;
        bVar17.getClass();
        ((ImageView) bVar17.G.f7059n).setVisibility(8);
        d5.b bVar18 = this.f7785b;
        bVar18.getClass();
        ((ImageView) bVar18.G.f7060o).setVisibility(8);
        d5.b bVar19 = this.f7785b;
        bVar19.getClass();
        bVar19.C.f7151l.setVisibility(8);
        if (704 < D().f8569d) {
            h5.y0 y0Var = (h5.y0) G().D.getValue();
            h5.q qVarA = y0Var != null ? y0Var.a(context) : null;
            if (qVarA == null && D().A > 0) {
                v5.g gVarL = v5.g.f13148u.l(context);
                gVarL.a();
                h5.q qVarY = gVarL.y(String.valueOf(D().A));
                gVarL.b();
                qVarA = qVarY;
            }
            if (qVarA != null && qVarA.c()) {
                j0();
                return;
            }
            u7.m0 m0Var2 = G().D;
            String packageName = requireActivity().getPackageName();
            packageName.getClass();
            h5.y0 y0Var2 = new h5.y0(packageName);
            m0Var2.getClass();
            m0Var2.g(null, y0Var2);
            c0(context);
        }
    }

    public final void i0(h5.q qVar) {
        d0(qVar);
        d5.b bVar = this.f7785b;
        bVar.getClass();
        TextView textView = bVar.G.f;
        String string = getString(R.string.option_button_cancel);
        string.getClass();
        textView.setText(string);
        l5.F(textView);
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        ((RelativeLayout) bVar2.G.f7054i).setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.ripple_open_button));
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        TextView textView2 = bVar3.G.h;
        String string2 = getString(R.string.updates_button_resume);
        string2.getClass();
        textView2.setText(string2);
        l5.E(textView2);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        bVar4.C.f7145b.setVisibility(8);
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        bVar5.C.f7146c.setVisibility(0);
    }

    public final void j0() {
        q0();
        d5.b bVar = this.f7785b;
        bVar.getClass();
        ProgressBar progressBar = bVar.J.f6918i;
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        a.a.x(progressBar, bVar2.J.f6915b);
        if (((Boolean) G().U.getValue()).booleanValue() && D().k()) {
            d5.b bVar3 = this.f7785b;
            bVar3.getClass();
            bVar3.G.f7052c.setVisibility(0);
            d5.b bVar4 = this.f7785b;
            bVar4.getClass();
            ((ImageView) bVar4.G.f7057l).setVisibility(0);
        } else {
            d5.b bVar5 = this.f7785b;
            bVar5.getClass();
            bVar5.G.f7052c.setVisibility(8);
            d5.b bVar6 = this.f7785b;
            bVar6.getClass();
            ((ImageView) bVar6.G.f7057l).setVisibility(8);
        }
        com.mbridge.msdk.dycreator.baseview.a.o(2, G().I, null);
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        TextView textView = bVar7.G.f;
        String string = getString(R.string.updates_button_update_app);
        string.getClass();
        textView.setText(string);
        l5.E(textView);
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        ((RelativeLayout) bVar8.G.f7054i).setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.ripple_blue_primary_button));
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        bVar9.G.f.setOnClickListener(new e(this, 0));
        d5.b bVar10 = this.f7785b;
        bVar10.getClass();
        bVar10.C.f7155p.setText(getString(R.string.updates_button_update_app));
        d5.b bVar11 = this.f7785b;
        bVar11.getClass();
        TextView textView2 = bVar11.C.f7155p;
        String string2 = getString(R.string.updates_button_update_app);
        string2.getClass();
        textView2.setText(string2);
        l5.E(textView2);
        m0(R.id.action_app_installed_details);
    }

    public final void k0(Rect rect) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        if (getContext() == null || kotlin.jvm.internal.l.a(D().f8595w, requireContext().getPackageName())) {
            return;
        }
        d5.b bVar = this.f7785b;
        bVar.getClass();
        if (bVar.G.f7051b.getLocalVisibleRect(rect) && !((Boolean) G().L.getValue()).booleanValue()) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            d5.b bVar2 = this.f7785b;
            bVar2.getClass();
            RelativeLayout relativeLayout = bVar2.B;
            float f = UptodownApp.E;
            try {
                sharedPreferences2 = contextRequireContext.getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception unused) {
            }
            boolean z9 = sharedPreferences2.contains("animations") ? sharedPreferences2.getBoolean("animations", true) : true;
            if (z9) {
                float f10 = UptodownApp.E;
                relativeLayout.startAnimation(AnimationUtils.loadAnimation(contextRequireContext, R.anim.slide_out_bottom));
                relativeLayout.setVisibility(8);
            } else {
                relativeLayout.setVisibility(8);
            }
            u7.m0 m0Var = G().L;
            Boolean boolValueOf = Boolean.valueOf(!((Boolean) G().L.getValue()).booleanValue());
            m0Var.getClass();
            m0Var.g(null, boolValueOf);
            return;
        }
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        if (bVar3.G.f7051b.getLocalVisibleRect(rect) || !((Boolean) G().L.getValue()).booleanValue()) {
            return;
        }
        Context contextRequireContext2 = requireContext();
        contextRequireContext2.getClass();
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        RelativeLayout relativeLayout2 = bVar4.B;
        float f11 = UptodownApp.E;
        try {
            sharedPreferences = contextRequireContext2.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused2) {
        }
        boolean z10 = sharedPreferences.contains("animations") ? sharedPreferences.getBoolean("animations", true) : true;
        if (z10) {
            float f12 = UptodownApp.E;
            relativeLayout2.startAnimation(AnimationUtils.loadAnimation(contextRequireContext2, R.anim.slide_in_bottom));
            relativeLayout2.setVisibility(0);
        } else {
            relativeLayout2.setVisibility(0);
        }
        u7.m0 m0Var2 = G().L;
        Boolean boolValueOf2 = Boolean.valueOf(!((Boolean) G().L.getValue()).booleanValue());
        m0Var2.getClass();
        m0Var2.g(null, boolValueOf2);
    }

    public final void l0(AlertDialog.Builder builder) {
        FragmentActivity activity = getActivity();
        activity.getClass();
        if (((l4.w) activity).f10935w != null) {
            FragmentActivity activity2 = getActivity();
            activity2.getClass();
            AlertDialog alertDialog = ((l4.w) activity2).f10935w;
            alertDialog.getClass();
            if (alertDialog.isShowing()) {
                return;
            }
        }
        FragmentActivity activity3 = getActivity();
        activity3.getClass();
        ((l4.w) activity3).f10935w = builder.create();
        if (getActivity() == null || !isAdded() || requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity4 = getActivity();
        activity4.getClass();
        if (((l4.w) activity4).f10935w != null) {
            FragmentActivity activity5 = getActivity();
            activity5.getClass();
            AlertDialog alertDialog2 = ((l4.w) activity5).f10935w;
            alertDialog2.getClass();
            Window window = alertDialog2.getWindow();
            if (window != null) {
                a3.a.A(window, 0);
            }
            FragmentActivity activity6 = getActivity();
            activity6.getClass();
            AlertDialog alertDialog3 = ((l4.w) activity6).f10935w;
            alertDialog3.getClass();
            alertDialog3.show();
        }
    }

    public final void m0(int i10) {
        Menu menu = this.g;
        if (menu != null) {
            menu.findItem(i10).setVisible(true);
        }
    }

    public final void n0(ArrayList arrayList) {
        final int i10 = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.remote_install_devices_popup, (ViewGroup) null, false);
        int i11 = R.id.iv_close_remote_install_devices;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_close_remote_install_devices);
        if (imageView != null) {
            i11 = R.id.rl_remote_install_devices;
            if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_remote_install_devices)) != null) {
                i11 = R.id.rlp_remote_install_devices;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rlp_remote_install_devices);
                if (relativeLayout != null) {
                    i11 = R.id.rv_remote_install_devices;
                    MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_remote_install_devices);
                    if (maxHeightRecyclerView != null) {
                        i11 = R.id.tv_remote_install_devices;
                        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_remote_install_devices);
                        if (textView != null) {
                            i11 = R.id.tv_title_remote_install_devices;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_remote_install_devices);
                            if (textView2 != null) {
                                i11 = R.id.v_background_remote_install_devices;
                                View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.v_background_remote_install_devices);
                                if (viewFindChildViewById != null) {
                                    RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate;
                                    final a3.x xVar = new a3.x(relativeLayout2, imageView, relativeLayout, maxHeightRecyclerView, textView, textView2, viewFindChildViewById);
                                    d5.b bVar = this.f7785b;
                                    bVar.getClass();
                                    bVar.e.addView(relativeLayout2);
                                    d5.b bVar2 = this.f7785b;
                                    bVar2.getClass();
                                    bVar2.e.setVisibility(0);
                                    textView2.setTypeface(o4.b.f11719r);
                                    textView.setTypeface(o4.b.f11719r);
                                    kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
                                    ArrayList arrayList2 = new ArrayList();
                                    n4.e1 e1Var = new n4.e1(arrayList, new a3.x(arrayList, arrayList2, uVar, 22));
                                    boolean z9 = true;
                                    z9 = true;
                                    maxHeightRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
                                    maxHeightRecyclerView.setItemAnimator(null);
                                    maxHeightRecyclerView.setAdapter(e1Var);
                                    textView.setOnClickListener(new f(arrayList, this, arrayList2, uVar, xVar));
                                    imageView.setOnClickListener(new View.OnClickListener(this) { // from class: e5.g

                                        /* renamed from: b, reason: collision with root package name */
                                        public final /* synthetic */ j0 f7753b;

                                        {
                                            this.f7753b = this;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) throws Resources.NotFoundException {
                                            switch (i10) {
                                                case 0:
                                                    this.f7753b.u(xVar);
                                                    break;
                                                default:
                                                    this.f7753b.u(xVar);
                                                    break;
                                            }
                                        }
                                    });
                                    final int i12 = z9 ? 1 : 0;
                                    viewFindChildViewById.setOnClickListener(new View.OnClickListener(this) { // from class: e5.g

                                        /* renamed from: b, reason: collision with root package name */
                                        public final /* synthetic */ j0 f7753b;

                                        {
                                            this.f7753b = this;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) throws Resources.NotFoundException {
                                            switch (i12) {
                                                case 0:
                                                    this.f7753b.u(xVar);
                                                    break;
                                                default:
                                                    this.f7753b.u(xVar);
                                                    break;
                                            }
                                        }
                                    });
                                    FragmentActivity fragmentActivityRequireActivity = requireActivity();
                                    fragmentActivityRequireActivity.getClass();
                                    new w4(fragmentActivityRequireActivity, 5, false).E(viewFindChildViewById, 1.0f);
                                    FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
                                    fragmentActivityRequireActivity2.getClass();
                                    float f = UptodownApp.E;
                                    try {
                                        SharedPreferences sharedPreferences = fragmentActivityRequireActivity2.getSharedPreferences("SettingsPreferences", 0);
                                        if (sharedPreferences.contains("animations")) {
                                            z9 = sharedPreferences.getBoolean("animations", true);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    if (!z9) {
                                        relativeLayout.setVisibility(0);
                                        return;
                                    }
                                    float f10 = UptodownApp.E;
                                    relativeLayout.startAnimation(AnimationUtils.loadAnimation(fragmentActivityRequireActivity2, R.anim.slide_in_bottom));
                                    relativeLayout.setVisibility(0);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
    }

    public final void o0() {
        if (getContext() != null) {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            customTabsIntentBuild.getClass();
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            String strA = l5.A(contextRequireContext);
            if (o7.m.d0(strA, ".uptodown.com/", false)) {
                strA = (o7.m.d0(strA, "?", false) ? strA.concat("&") : strA.concat("?")).concat("userAgent=uptodownandroid");
            }
            customTabsIntentBuild.intent.setData(Uri.parse(strA));
            Intent intent = customTabsIntentBuild.intent;
            float f = UptodownApp.E;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            fragmentActivityRequireActivity.getClass();
            this.f7794o.launch(intent, k4.c.b(fragmentActivityRequireActivity));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r10) {
        /*
            r9 = this;
            super.onCreate(r10)
            e5.c1 r10 = r9.G()
            u7.m0 r10 = r10.N
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r10.getClass()
            r5 = 0
            r10.g(r5, r0)
            t1.c r10 = new t1.c
            androidx.fragment.app.FragmentActivity r0 = r9.requireActivity()
            r7 = 4
            r10.<init>(r0, r7)
            r9.f7787d = r10
            e4.e r10 = com.uptodown.UptodownApp.T
            if (r10 == 0) goto L27
            i4.g r10 = (i4.g) r10
            r10.e()
        L27:
            e4.e r10 = com.uptodown.UptodownApp.U
            if (r10 == 0) goto L30
            i4.g r10 = (i4.g) r10
            r10.e()
        L30:
            android.os.Bundle r10 = r9.getArguments()
            if (r10 == 0) goto L6a
            e5.c1 r0 = r9.G()
            u7.m0 r0 = r0.G
            java.lang.String r1 = "appId"
            long r1 = r10.getLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.getClass()
            r0.g(r5, r1)
            java.lang.String r0 = "appInfo"
            boolean r1 = r10.containsKey(r0)
            if (r1 == 0) goto L6a
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 34
            if (r1 < r2) goto L63
            java.lang.Class<h5.h> r1 = h5.h.class
            java.lang.Object r10 = r10.getParcelable(r0, r1)
            android.os.Parcelable r10 = (android.os.Parcelable) r10
            goto L67
        L63:
            android.os.Parcelable r10 = r10.getParcelable(r0)
        L67:
            h5.h r10 = (h5.h) r10
            goto L6b
        L6a:
            r10 = r5
        L6b:
            r0 = 2
            if (r10 == 0) goto L94
            r9.f7784a = r10
            e5.c1 r4 = r9.G()
            android.content.Context r2 = r9.requireContext()
            r2.getClass()
            h5.h r3 = r9.D()
            r4.getClass()
            r7.w r10 = androidx.lifecycle.ViewModelKt.getViewModelScope(r4)
            y7.e r1 = r7.i0.f12407a
            y7.d r8 = y7.d.f14116a
            c5.m r1 = new c5.m
            r6 = 2
            r1.<init>(r2, r3, r4, r5, r6)
            r7.y.q(r10, r8, r5, r1, r0)
            goto Lc3
        L94:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto Lc3
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            boolean r10 = r10 instanceof com.uptodown.activities.MainActivity
            if (r10 == 0) goto Laf
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            r10.getClass()
            com.uptodown.activities.MainActivity r10 = (com.uptodown.activities.MainActivity) r10
            r10.P0()
            goto Lc3
        Laf:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            boolean r10 = r10 instanceof com.uptodown.activities.AppDetailActivity
            if (r10 == 0) goto Lc3
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            r10.getClass()
            com.uptodown.activities.AppDetailActivity r10 = (com.uptodown.activities.AppDetailActivity) r10
            r10.finish()
        Lc3:
            h5.h r10 = r9.D()
            boolean r10 = r10.l()
            if (r10 == 0) goto Ldd
            androidx.lifecycle.LifecycleCoroutineScope r10 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r9)
            y7.e r1 = r7.i0.f12407a
            s7.c r1 = w7.n.f13548a
            e5.b0 r2 = new e5.b0
            r2.<init>(r9, r5, r7)
            r7.y.q(r10, r1, r5, r2, r0)
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.j0.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        if (getActivity() == null) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        View viewInflate = layoutInflater.inflate(R.layout.app_detail, viewGroup, false);
        int i10 = R.id.app_bar_layout_app_details;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(viewInflate, R.id.app_bar_layout_app_details);
        if (appBarLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
            i10 = R.id.ctl_app_details;
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(viewInflate, R.id.ctl_app_details);
            if (collapsingToolbarLayout != null) {
                i10 = R.id.fl_checking_compatibility_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(viewInflate, R.id.fl_checking_compatibility_container);
                if (frameLayout != null) {
                    i10 = R.id.fl_remote_install_devices_popup;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(viewInflate, R.id.fl_remote_install_devices_popup);
                    if (frameLayout2 != null) {
                        i10 = R.id.iv_about_app_detail;
                        if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_about_app_detail)) != null) {
                            i10 = R.id.iv_editor_avatar_app_detail;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_editor_avatar_app_detail);
                            if (imageView != null) {
                                i10 = R.id.iv_more_reviews;
                                if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_more_reviews)) != null) {
                                    i10 = R.id.iv_more_similars_app_detail;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_more_similars_app_detail);
                                    if (imageView2 != null) {
                                        i10 = R.id.iv_recommended_app_detail;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_recommended_app_detail);
                                        if (imageView3 != null) {
                                            i10 = R.id.iv_responsibilities_notes;
                                            if (((ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_responsibilities_notes)) != null) {
                                                i10 = R.id.iv_wishlist_app_detail;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_wishlist_app_detail);
                                                if (imageView4 != null) {
                                                    i10 = R.id.ll_app_detail;
                                                    if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_app_detail)) != null) {
                                                        i10 = R.id.ll_box_external_download_info_app_detail;
                                                        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.ll_box_external_download_info_app_detail);
                                                        if (viewFindChildViewById != null) {
                                                            LinearLayout linearLayout = (LinearLayout) viewFindChildViewById;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(viewFindChildViewById, R.id.tv_external_download_box);
                                                            if (textView == null) {
                                                                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById.getResources().getResourceName(R.id.tv_external_download_box)));
                                                                return null;
                                                            }
                                                            d5.u uVar = new d5.u(linearLayout, textView, 0);
                                                            i10 = R.id.ll_container_promoted_apps;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_container_promoted_apps);
                                                            if (linearLayout2 != null) {
                                                                i10 = R.id.ll_dmca_app_detail;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_dmca_app_detail);
                                                                if (linearLayout3 != null) {
                                                                    i10 = R.id.ll_floating_categories_app_detail;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_floating_categories_app_detail);
                                                                    if (linearLayout4 != null) {
                                                                        i10 = R.id.ll_floating_categories_box_app_detail;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_floating_categories_box_app_detail);
                                                                        if (linearLayout5 != null) {
                                                                            i10 = R.id.ll_more_info_packagename_app_detail;
                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_more_info_packagename_app_detail);
                                                                            if (linearLayout6 != null) {
                                                                                i10 = R.id.ll_more_info_pegi_app_detail;
                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_more_info_pegi_app_detail);
                                                                                if (linearLayout7 != null) {
                                                                                    i10 = R.id.ll_more_info_size_app_detail;
                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_more_info_size_app_detail);
                                                                                    if (linearLayout8 != null) {
                                                                                        i10 = R.id.ll_old_versions_app_detail;
                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_old_versions_app_detail);
                                                                                        if (linearLayout9 != null) {
                                                                                            i10 = R.id.ll_review_list_container;
                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_review_list_container);
                                                                                            if (linearLayout10 != null) {
                                                                                                i10 = R.id.ll_reviews_app_detail;
                                                                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(viewInflate, R.id.ll_reviews_app_detail);
                                                                                                if (viewFindChildViewById2 != null) {
                                                                                                    LinearLayout linearLayout11 = (LinearLayout) viewFindChildViewById2;
                                                                                                    int i11 = R.id.ll_reviews_counter_chart;
                                                                                                    if (((LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.ll_reviews_counter_chart)) != null) {
                                                                                                        i11 = R.id.star1_graphical_value_app_detail;
                                                                                                        View viewFindChildViewById3 = ViewBindings.findChildViewById(viewFindChildViewById2, R.id.star1_graphical_value_app_detail);
                                                                                                        if (viewFindChildViewById3 != null) {
                                                                                                            i11 = R.id.star2_graphical_value_app_detail;
                                                                                                            View viewFindChildViewById4 = ViewBindings.findChildViewById(viewFindChildViewById2, R.id.star2_graphical_value_app_detail);
                                                                                                            if (viewFindChildViewById4 != null) {
                                                                                                                i11 = R.id.star3_graphical_value_app_detail;
                                                                                                                View viewFindChildViewById5 = ViewBindings.findChildViewById(viewFindChildViewById2, R.id.star3_graphical_value_app_detail);
                                                                                                                if (viewFindChildViewById5 != null) {
                                                                                                                    i11 = R.id.star4_graphical_value_app_detail;
                                                                                                                    View viewFindChildViewById6 = ViewBindings.findChildViewById(viewFindChildViewById2, R.id.star4_graphical_value_app_detail);
                                                                                                                    if (viewFindChildViewById6 != null) {
                                                                                                                        i11 = R.id.star5_graphical_value_app_detail;
                                                                                                                        View viewFindChildViewById7 = ViewBindings.findChildViewById(viewFindChildViewById2, R.id.star5_graphical_value_app_detail);
                                                                                                                        if (viewFindChildViewById7 != null) {
                                                                                                                            i11 = R.id.star5_graphical_value_app_detail_background;
                                                                                                                            View viewFindChildViewById8 = ViewBindings.findChildViewById(viewFindChildViewById2, R.id.star5_graphical_value_app_detail_background);
                                                                                                                            if (viewFindChildViewById8 != null) {
                                                                                                                                i11 = R.id.tv_chart_1_value;
                                                                                                                                if (((TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_chart_1_value)) != null) {
                                                                                                                                    i11 = R.id.tv_chart_2_value;
                                                                                                                                    if (((TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_chart_2_value)) != null) {
                                                                                                                                        i11 = R.id.tv_chart_3_value;
                                                                                                                                        if (((TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_chart_3_value)) != null) {
                                                                                                                                            i11 = R.id.tv_chart_4_value;
                                                                                                                                            if (((TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_chart_4_value)) != null) {
                                                                                                                                                i11 = R.id.tv_chart_5_value;
                                                                                                                                                if (((TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_chart_5_value)) != null) {
                                                                                                                                                    i11 = R.id.tv_review_rating_app_detail;
                                                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_review_rating_app_detail);
                                                                                                                                                    if (textView2 != null) {
                                                                                                                                                        i11 = R.id.tv_reviews_count_app_detail;
                                                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_reviews_count_app_detail);
                                                                                                                                                        if (textView3 != null) {
                                                                                                                                                            i11 = R.id.tv_reviews_title_app_detail;
                                                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_reviews_title_app_detail);
                                                                                                                                                            if (textView4 != null) {
                                                                                                                                                                d5.h hVar = new d5.h(linearLayout11, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, textView2, textView3, textView4);
                                                                                                                                                                i10 = R.id.ll_similars_label_app_detail;
                                                                                                                                                                LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_similars_label_app_detail);
                                                                                                                                                                if (linearLayout12 != null) {
                                                                                                                                                                    i10 = R.id.ll_user_says_app_details;
                                                                                                                                                                    LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_user_says_app_details);
                                                                                                                                                                    if (linearLayout13 != null) {
                                                                                                                                                                        i10 = R.id.ll_user_says_msg_app_details;
                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_user_says_msg_app_details);
                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                            i10 = R.id.ll_user_valoration_app_detail;
                                                                                                                                                                            View viewFindChildViewById9 = ViewBindings.findChildViewById(viewInflate, R.id.ll_user_valoration_app_detail);
                                                                                                                                                                            if (viewFindChildViewById9 != null) {
                                                                                                                                                                                int i12 = R.id.iv_star1_valoration;
                                                                                                                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.iv_star1_valoration);
                                                                                                                                                                                if (imageView5 != null) {
                                                                                                                                                                                    i12 = R.id.iv_star2_valoration;
                                                                                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.iv_star2_valoration);
                                                                                                                                                                                    if (imageView6 != null) {
                                                                                                                                                                                        i12 = R.id.iv_star3_valoration;
                                                                                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.iv_star3_valoration);
                                                                                                                                                                                        if (imageView7 != null) {
                                                                                                                                                                                            i12 = R.id.iv_star4_valoration;
                                                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.iv_star4_valoration);
                                                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                                                i12 = R.id.iv_star5_valoration;
                                                                                                                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.iv_star5_valoration);
                                                                                                                                                                                                if (imageView9 != null) {
                                                                                                                                                                                                    i12 = R.id.iv_user_valoration;
                                                                                                                                                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.iv_user_valoration);
                                                                                                                                                                                                    if (imageView10 != null) {
                                                                                                                                                                                                        i12 = R.id.ll_your_valoration;
                                                                                                                                                                                                        LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.ll_your_valoration);
                                                                                                                                                                                                        if (linearLayout15 != null) {
                                                                                                                                                                                                            i12 = R.id.tv_write_review_app_detail;
                                                                                                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.tv_write_review_app_detail);
                                                                                                                                                                                                            if (textView5 != null) {
                                                                                                                                                                                                                i12 = R.id.tv_your_valoration;
                                                                                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById9, R.id.tv_your_valoration);
                                                                                                                                                                                                                if (textView6 != null) {
                                                                                                                                                                                                                    d5.h hVar2 = new d5.h((LinearLayout) viewFindChildViewById9, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, linearLayout15, textView5, textView6);
                                                                                                                                                                                                                    i10 = R.id.mb_banner_view;
                                                                                                                                                                                                                    MBBannerView mBBannerView = (MBBannerView) ViewBindings.findChildViewById(viewInflate, R.id.mb_banner_view);
                                                                                                                                                                                                                    if (mBBannerView != null) {
                                                                                                                                                                                                                        i10 = R.id.rl_automatic_download_perk_app_detail;
                                                                                                                                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_automatic_download_perk_app_detail);
                                                                                                                                                                                                                        if (relativeLayout != null) {
                                                                                                                                                                                                                            i10 = R.id.rl_bottom_box_button_app_detail;
                                                                                                                                                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_bottom_box_button_app_detail);
                                                                                                                                                                                                                            if (relativeLayout2 != null) {
                                                                                                                                                                                                                                i10 = R.id.rl_bottom_box_download_button_app_detail;
                                                                                                                                                                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_bottom_box_download_button_app_detail);
                                                                                                                                                                                                                                if (relativeLayout3 != null) {
                                                                                                                                                                                                                                    i10 = R.id.rl_bottom_download_button_app_detail;
                                                                                                                                                                                                                                    View viewFindChildViewById10 = ViewBindings.findChildViewById(viewInflate, R.id.rl_bottom_download_button_app_detail);
                                                                                                                                                                                                                                    if (viewFindChildViewById10 != null) {
                                                                                                                                                                                                                                        int i13 = R.id.iv_cancel_downloading;
                                                                                                                                                                                                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.iv_cancel_downloading);
                                                                                                                                                                                                                                        if (imageView11 != null) {
                                                                                                                                                                                                                                            i13 = R.id.iv_deactivated;
                                                                                                                                                                                                                                            if (((ImageView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.iv_deactivated)) != null) {
                                                                                                                                                                                                                                                i13 = R.id.iv_resume_downloading;
                                                                                                                                                                                                                                                ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.iv_resume_downloading);
                                                                                                                                                                                                                                                if (imageView12 != null) {
                                                                                                                                                                                                                                                    i13 = R.id.iv_status_pre_register;
                                                                                                                                                                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.iv_status_pre_register);
                                                                                                                                                                                                                                                    if (imageView13 != null) {
                                                                                                                                                                                                                                                        i13 = R.id.pb_download_button;
                                                                                                                                                                                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.pb_download_button);
                                                                                                                                                                                                                                                        if (progressBar != null) {
                                                                                                                                                                                                                                                            i13 = R.id.rl_deactivated;
                                                                                                                                                                                                                                                            LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.rl_deactivated);
                                                                                                                                                                                                                                                            if (linearLayout16 != null) {
                                                                                                                                                                                                                                                                i13 = R.id.rl_status_downloading;
                                                                                                                                                                                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.rl_status_downloading);
                                                                                                                                                                                                                                                                if (relativeLayout4 != null) {
                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.rl_status_loading);
                                                                                                                                                                                                                                                                    if (relativeLayout5 != null) {
                                                                                                                                                                                                                                                                        i13 = R.id.rl_status_pre_register;
                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.rl_status_pre_register);
                                                                                                                                                                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                                                                                                                                                                            i13 = R.id.tv_deactivated;
                                                                                                                                                                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.tv_deactivated);
                                                                                                                                                                                                                                                                            if (textView7 != null) {
                                                                                                                                                                                                                                                                                i13 = R.id.tv_enqueue_download;
                                                                                                                                                                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.tv_enqueue_download);
                                                                                                                                                                                                                                                                                if (textView8 != null) {
                                                                                                                                                                                                                                                                                    i13 = R.id.tv_open_download_button;
                                                                                                                                                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.tv_open_download_button);
                                                                                                                                                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                                                                                                                                                        i13 = R.id.tv_percentage_downloaded;
                                                                                                                                                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.tv_percentage_downloaded);
                                                                                                                                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                                                                                                                                            i13 = R.id.tv_size_downloaded;
                                                                                                                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.tv_size_downloaded);
                                                                                                                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                                                                                                                i13 = R.id.tv_size_total;
                                                                                                                                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.tv_size_total);
                                                                                                                                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                                                                                                                                    i13 = R.id.tv_status_download;
                                                                                                                                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.tv_status_download);
                                                                                                                                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                                                                                                                                        i13 = R.id.tv_status_pre_register;
                                                                                                                                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById10, R.id.tv_status_pre_register);
                                                                                                                                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                                                                                                                                            d5.k kVar = new d5.k((RelativeLayout) viewFindChildViewById10, imageView11, imageView12, imageView13, progressBar, linearLayout16, relativeLayout4, relativeLayout5, relativeLayout6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
                                                                                                                                                                                                                                                                                                            i10 = R.id.rl_container_about_app;
                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_container_about_app);
                                                                                                                                                                                                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                                                                                                                                                                                                i10 = R.id.rl_container_description_app_detail;
                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_container_description_app_detail);
                                                                                                                                                                                                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                                                                                                                                                                                                    i10 = R.id.rl_container_title_reviews;
                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_container_title_reviews);
                                                                                                                                                                                                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById11 = ViewBindings.findChildViewById(viewInflate, R.id.rl_download_button_root_app_detail);
                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById11 != null) {
                                                                                                                                                                                                                                                                                                                            int i14 = R.id.iv_deactivated;
                                                                                                                                                                                                                                                                                                                            if (((ImageView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.iv_deactivated)) != null) {
                                                                                                                                                                                                                                                                                                                                i14 = R.id.iv_download_remote;
                                                                                                                                                                                                                                                                                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.iv_download_remote);
                                                                                                                                                                                                                                                                                                                                if (imageView14 != null) {
                                                                                                                                                                                                                                                                                                                                    i14 = R.id.iv_open_remote;
                                                                                                                                                                                                                                                                                                                                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.iv_open_remote);
                                                                                                                                                                                                                                                                                                                                    if (imageView15 != null) {
                                                                                                                                                                                                                                                                                                                                        i14 = R.id.iv_uninstall;
                                                                                                                                                                                                                                                                                                                                        ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.iv_uninstall);
                                                                                                                                                                                                                                                                                                                                        if (imageView16 != null) {
                                                                                                                                                                                                                                                                                                                                            i14 = R.id.iv_virustotal;
                                                                                                                                                                                                                                                                                                                                            ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.iv_virustotal);
                                                                                                                                                                                                                                                                                                                                            if (imageView17 != null) {
                                                                                                                                                                                                                                                                                                                                                ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.iv_wishlist);
                                                                                                                                                                                                                                                                                                                                                if (imageView18 != null) {
                                                                                                                                                                                                                                                                                                                                                    i14 = R.id.rl_deactivated;
                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.rl_deactivated);
                                                                                                                                                                                                                                                                                                                                                    if (linearLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                        i14 = R.id.rl_download_cancel;
                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.rl_download_cancel);
                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.rl_open);
                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout11 != null) {
                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.rl_status_loading);
                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout12 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i14 = R.id.tv_deactivated;
                                                                                                                                                                                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.tv_deactivated);
                                                                                                                                                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i14 = R.id.tv_download_cancel;
                                                                                                                                                                                                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.tv_download_cancel);
                                                                                                                                                                                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i14 = R.id.tv_open;
                                                                                                                                                                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.tv_open);
                                                                                                                                                                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i14 = R.id.tv_pause;
                                                                                                                                                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById11, R.id.tv_pause);
                                                                                                                                                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    d5.g gVar = new d5.g((RelativeLayout) viewFindChildViewById11, imageView14, imageView15, imageView16, imageView17, imageView18, linearLayout17, relativeLayout10, relativeLayout11, relativeLayout12, textView15, textView16, textView17, textView18);
                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.rl_editor_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_editor_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout13 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.rl_header_app_details;
                                                                                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById12 = ViewBindings.findChildViewById(viewInflate, R.id.rl_header_app_details);
                                                                                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById12 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(viewFindChildViewById12, R.id.iv_feature_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                            if (fullWidthImageView == null) {
                                                                                                                                                                                                                                                                                                                                                                                                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById12.getResources().getResourceName(R.id.iv_feature_app_detail)));
                                                                                                                                                                                                                                                                                                                                                                                                return null;
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                            a4.f fVar = new a4.f((RelativeLayout) viewFindChildViewById12, fullWidthImageView, 9, false);
                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.rl_main_info_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                            View viewFindChildViewById13 = ViewBindings.findChildViewById(viewInflate, R.id.rl_main_info_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                            if (viewFindChildViewById13 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                int i15 = R.id.iv_logo_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.iv_logo_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                if (imageView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i15 = R.id.ll_app_info;
                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.ll_app_info);
                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i15 = R.id.ll_download_info_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.ll_download_info_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                        if (linearLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i15 = R.id.ll_downloads_counter_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.ll_downloads_counter_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i15 = R.id.ll_info_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.ll_info_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i15 = R.id.ll_last_update_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.ll_last_update_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i15 = R.id.ll_valoration_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.ll_valoration_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (linearLayout23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i15 = R.id.pb_progress_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.pb_progress_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (progressBar2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i15 = R.id.rl_head_main_info;
                                                                                                                                                                                                                                                                                                                                                                                                                                if (((RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.rl_head_main_info)) != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i15 = R.id.rl_logo_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (((RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.rl_logo_app_detail)) != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i15 = R.id.rl_valoration_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.rl_valoration_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i15 = R.id.tv_author_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_author_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                i15 = R.id.tv_author_onboard_badge;
                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_author_onboard_badge);
                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i15 = R.id.tv_badge_ranking;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_badge_ranking);
                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                        i15 = R.id.tv_downloads_counter_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_downloads_counter_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                            i15 = R.id.tv_downloads_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_downloads_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                i15 = R.id.tv_last_update_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_last_update_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i15 = R.id.tv_last_update_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_last_update_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i15 = R.id.tv_name_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView26 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_name_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i15 = R.id.tv_phase_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView27 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_phase_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i15 = R.id.tv_progress_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_progress_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i15 = R.id.tv_reviews_counter_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_reviews_counter_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i15 = R.id.tv_valoration_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_valoration_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i15 = R.id.tv_verified_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView31 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_verified_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i15 = R.id.tv_version_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView32 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById13, R.id.tv_version_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView32 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i15 = R.id.v_separator_downloads_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById14 = ViewBindings.findChildViewById(viewFindChildViewById13, R.id.v_separator_downloads_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById14 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i15 = R.id.v_separator_last_update_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById15 = ViewBindings.findChildViewById(viewFindChildViewById13, R.id.v_separator_last_update_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            d5.c cVar = new d5.c((RelativeLayout) viewFindChildViewById13, imageView19, linearLayout18, linearLayout19, linearLayout20, linearLayout21, linearLayout22, linearLayout23, progressBar2, relativeLayout14, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, viewFindChildViewById14, viewFindChildViewById15);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.rl_recommended_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_recommended_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.rl_responsibilities_notes;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_responsibilities_notes);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.rl_similars_container;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_similars_container);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.rl_version_required;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_version_required);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.rl_whats_new;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            View viewFindChildViewById16 = ViewBindings.findChildViewById(viewInflate, R.id.rl_whats_new);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (viewFindChildViewById16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                int i16 = R.id.tv_read_more_whats_new;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView33 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById16, R.id.tv_read_more_whats_new);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i16 = R.id.tv_whats_new;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView34 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById16, R.id.tv_whats_new);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i16 = R.id.tv_whats_new_content;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView35 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById16, R.id.tv_whats_new_content);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView35 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i16 = R.id.v_shadow_whats_new;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            View viewFindChildViewById17 = ViewBindings.findChildViewById(viewFindChildViewById16, R.id.v_shadow_whats_new);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (viewFindChildViewById17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                a3.z0 z0Var = new a3.z0((RelativeLayout) viewFindChildViewById16, textView33, textView34, textView35, viewFindChildViewById17, 5);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.rl_wishlist_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_wishlist_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.rv_promoted_apps;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_promoted_apps);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (recyclerView != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.rv_screenshots_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_screenshots_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.rv_similars_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_similars_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (recyclerView3 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.s_automatic_download_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewInflate, R.id.s_automatic_download_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (switchCompat != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.shadow_description_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById18 = ViewBindings.findChildViewById(viewInflate, R.id.shadow_description_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.sv_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(viewInflate, R.id.sv_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (nestedScrollView != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.toolbar_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (toolbar != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_about_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView36 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_about_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView36 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_automatic_download_desc_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView37 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_automatic_download_desc_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView37 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_desc_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView38 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_desc_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView38 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_dmca_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView39 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_dmca_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView39 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_editor_job_title_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView40 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_editor_job_title_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView40 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_editor_name_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView41 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_editor_name_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView41 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_editor_name_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView42 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_editor_name_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView42 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_floating_categories_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView43 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_floating_categories_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView43 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_more_info_packagename_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView44 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_more_info_packagename_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView44 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_more_info_packagename_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView45 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_more_info_packagename_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView45 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_more_info_pegi_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView46 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_more_info_pegi_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView46 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_more_info_pegi_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView47 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_more_info_pegi_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView47 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_more_info_size_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView48 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_more_info_size_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView48 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_more_info_size_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView49 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_more_info_size_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView49 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_old_versions_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView50 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_old_versions_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView50 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_promoted_apps_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView51 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_promoted_apps_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView51 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_read_more_desc_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView52 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_read_more_desc_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView52 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_recommended_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView53 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_recommended_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView53 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_remove_ads_with_turbo_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView54 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_remove_ads_with_turbo_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView54 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_responsibilities_notes;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView55 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_responsibilities_notes);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView55 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_reviews_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView56 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_reviews_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView56 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_reviews_see_more_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView57 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_reviews_see_more_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView57 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_short_desc_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView58 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_short_desc_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView58 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_similars_label_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView59 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_similars_label_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView59 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_user_says_ai_msg_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView60 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_user_says_ai_msg_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView60 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_user_says_title_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView61 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_user_says_title_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView61 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_version_required_content;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView62 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_version_required_content);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView62 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_version_required_title;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView63 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_version_required_title);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView63 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_version_required_version;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView64 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_version_required_version);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView64 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_wishlist_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView65 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_wishlist_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView65 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i10 = R.id.warning_not_space_available_app_detail;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById19 = ViewBindings.findChildViewById(viewInflate, R.id.warning_not_space_available_app_detail);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            this.f7785b = new d5.b(coordinatorLayout, appBarLayout, collapsingToolbarLayout, frameLayout, frameLayout2, imageView, imageView2, imageView3, imageView4, uVar, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, hVar, linearLayout12, linearLayout13, linearLayout14, hVar2, mBBannerView, relativeLayout, relativeLayout2, relativeLayout3, kVar, relativeLayout7, relativeLayout8, relativeLayout9, gVar, relativeLayout13, fVar, cVar, relativeLayout15, relativeLayout16, relativeLayout17, relativeLayout18, z0Var, relativeLayout19, recyclerView, recyclerView2, recyclerView3, switchCompat, viewFindChildViewById18, nestedScrollView, toolbar, textView36, textView37, textView38, textView39, textView40, textView41, textView42, textView43, textView44, textView45, textView46, textView47, textView48, textView49, textView50, textView51, textView52, textView53, textView54, textView55, textView56, textView57, textView58, textView59, textView60, textView61, textView62, textView63, textView64, textView65, d5.j.a(viewFindChildViewById19));
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            FragmentActivity fragmentActivityRequireActivity = requireActivity();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fragmentActivityRequireActivity.getClass();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            K(fragmentActivityRequireActivity);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            d5.b bVar = this.f7785b;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            bVar.getClass();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            return bVar.f6867a;
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById16.getResources().getResourceName(i16)));
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                return null;
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
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById13.getResources().getResourceName(i15)));
                                                                                                                                                                                                                                                                                                                                                                                                return null;
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                                                                                                    i14 = R.id.rl_status_loading;
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                                                                                                                i14 = R.id.rl_open;
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                                                                                    i14 = R.id.iv_wishlist;
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById11.getResources().getResourceName(i14)));
                                                                                                                                                                                                                                                                                                                            return null;
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        i10 = R.id.rl_download_button_root_app_detail;
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
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                        i13 = R.id.rl_status_loading;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById10.getResources().getResourceName(i13)));
                                                                                                                                                                                                                                        return null;
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
                                                                                                                                                                                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById9.getResources().getResourceName(i12)));
                                                                                                                                                                                return null;
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
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById2.getResources().getResourceName(i11)));
                                                                                                    return null;
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
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        try {
            d5.b bVar = this.f7785b;
            bVar.getClass();
            bVar.y.release();
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        u7.m0 m0Var = G().L;
        Boolean boolValueOf = Boolean.valueOf(!((Boolean) G().L.getValue()).booleanValue());
        m0Var.getClass();
        m0Var.g(null, boolValueOf);
        d5.b bVar = this.f7785b;
        bVar.getClass();
        bVar.y.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        String str;
        String str2;
        super.onResume();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        s7.c cVar = w7.n.f13548a;
        w6.c cVar2 = null;
        r7.y.q(lifecycleScope, cVar, null, new b0(this, cVar2, 5), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new b0(this, cVar2, 6), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new b0(this, cVar2, 7), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new b0(this, cVar2, 8), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new b0(this, cVar2, 9), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new b0(this, cVar2, 10), 2);
        if (!((Boolean) G().M.getValue()).booleanValue()) {
            Rect rect = new Rect();
            d5.b bVar = this.f7785b;
            bVar.getClass();
            bVar.V.getHitRect(rect);
            k0(rect);
        }
        if (((Boolean) G().M.getValue()).booleanValue() || (str2 = D().N) == null || str2.length() == 0) {
            u7.m0 m0Var = G().M;
            Boolean bool = Boolean.FALSE;
            m0Var.getClass();
            m0Var.g(null, bool);
        } else {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            p0(contextRequireContext);
        }
        String str3 = D().g;
        int i10 = 0;
        if (str3 == null || str3.length() == 0 || H()) {
            d5.b bVar2 = this.f7785b;
            bVar2.getClass();
            ((RelativeLayout) bVar2.K0.f7134b).setVisibility(8);
        } else {
            d5.b bVar3 = this.f7785b;
            bVar3.getClass();
            ((RelativeLayout) bVar3.K0.f7134b).setVisibility(0);
        }
        B();
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        if (bVar4.V.getScrollY() > 0) {
            Context contextRequireContext2 = requireContext();
            contextRequireContext2.getClass();
            s0(contextRequireContext2);
            String strE = D().e();
            if (strE == null || strE.length() == 0) {
                d5.b bVar5 = this.f7785b;
                bVar5.getClass();
                bVar5.f6869c.setTitle("");
            }
        }
        n4.t0 t0Var = this.h;
        if (t0Var != null) {
            t0Var.notifyDataSetChanged();
        }
        n4.t0 t0Var2 = this.f7788i;
        if (t0Var2 != null) {
            t0Var2.notifyDataSetChanged();
        }
        ArrayList arrayList = this.f7789j;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((n4.t0) obj).notifyDataSetChanged();
        }
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), w7.n.f13548a, null, new b0(this, cVar2, 11), 2);
        try {
            if (!((Boolean) G().M.getValue()).booleanValue()) {
                Rect rect2 = new Rect();
                d5.b bVar6 = this.f7785b;
                bVar6.getClass();
                bVar6.V.getHitRect(rect2);
                k0(rect2);
            }
            if (((Boolean) G().M.getValue()).booleanValue() || (str = D().N) == null || str.length() == 0) {
                u7.m0 m0Var2 = G().M;
                Boolean bool2 = Boolean.FALSE;
                m0Var2.getClass();
                m0Var2.g(null, bool2);
            } else {
                Context contextRequireContext3 = requireContext();
                contextRequireContext3.getClass();
                p0(contextRequireContext3);
            }
            String str4 = D().g;
            if (str4 == null || str4.length() == 0 || H()) {
                d5.b bVar7 = this.f7785b;
                bVar7.getClass();
                ((RelativeLayout) bVar7.K0.f7134b).setVisibility(8);
            } else {
                d5.b bVar8 = this.f7785b;
                bVar8.getClass();
                ((RelativeLayout) bVar8.K0.f7134b).setVisibility(0);
            }
            B();
            d5.b bVar9 = this.f7785b;
            bVar9.getClass();
            if (bVar9.V.getScrollY() > 0) {
                Context contextRequireContext4 = requireContext();
                contextRequireContext4.getClass();
                s0(contextRequireContext4);
                String strE2 = D().e();
                if (strE2 == null || strE2.length() == 0) {
                    d5.b bVar10 = this.f7785b;
                    bVar10.getClass();
                    bVar10.f6869c.setTitle("");
                }
            }
            n4.t0 t0Var3 = this.h;
            if (t0Var3 != null) {
                t0Var3.notifyDataSetChanged();
            }
            n4.t0 t0Var4 = this.f7788i;
            if (t0Var4 != null) {
                t0Var4.notifyDataSetChanged();
            }
            int size2 = arrayList.size();
            while (i10 < size2) {
                Object obj2 = arrayList.get(i10);
                i10++;
                ((n4.t0) obj2).notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        d5.b bVar11 = this.f7785b;
        bVar11.getClass();
        bVar11.y.onResume();
        d5.b bVar12 = this.f7785b;
        bVar12.getClass();
        bVar12.y.onResume();
    }

    public final void p() {
        if (getContext() != null) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            if (h5.c1.h(contextRequireContext) == null) {
                S();
                return;
            }
            if (D().A0 == 1) {
                c1 c1VarG = G();
                Context contextRequireContext2 = requireContext();
                contextRequireContext2.getClass();
                long j10 = D().f8566a;
                c1VarG.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(c1VarG);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new y0(1, j10, contextRequireContext2, c1VarG, null), 2);
                return;
            }
            c1 c1VarG2 = G();
            Context contextRequireContext3 = requireContext();
            contextRequireContext3.getClass();
            long j11 = D().f8566a;
            c1VarG2.getClass();
            r7.w viewModelScope2 = ViewModelKt.getViewModelScope(c1VarG2);
            y7.e eVar2 = r7.i0.f12407a;
            r7.y.q(viewModelScope2, y7.d.f14116a, null, new y0(0, j11, contextRequireContext3, c1VarG2, null), 2);
        }
    }

    public final void p0(Context context) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, y7.d.f14116a, null, new a3.o(this, context, (w6.c) null, 9), 2);
    }

    public final void q() {
        if (getContext() != null) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            if (h5.c1.h(contextRequireContext) == null) {
                S();
                return;
            }
            if (D().z0 == 1) {
                c1 c1VarG = G();
                Context contextRequireContext2 = requireContext();
                contextRequireContext2.getClass();
                long j10 = D().f8566a;
                c1VarG.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(c1VarG);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new y0(3, j10, contextRequireContext2, c1VarG, null), 2);
                return;
            }
            c1 c1VarG2 = G();
            Context contextRequireContext3 = requireContext();
            contextRequireContext3.getClass();
            long j11 = D().f8566a;
            c1VarG2.getClass();
            r7.w viewModelScope2 = ViewModelKt.getViewModelScope(c1VarG2);
            y7.e eVar2 = r7.i0.f12407a;
            r7.y.q(viewModelScope2, y7.d.f14116a, null, new y0(2, j11, contextRequireContext3, c1VarG2, null), 2);
        }
    }

    public final void q0() {
        d5.b bVar = this.f7785b;
        bVar.getClass();
        bVar.J.f.setVisibility(0);
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        bVar2.J.f6917d.setVisibility(8);
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.G.f7054i).setVisibility(0);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        bVar4.G.f.setVisibility(0);
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        ((RelativeLayout) bVar5.G.f7055j).setVisibility(8);
        d5.b bVar6 = this.f7785b;
        bVar6.getClass();
        bVar6.G.h.setVisibility(8);
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        bVar7.C.f7155p.setVisibility(0);
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        bVar8.C.g.setVisibility(8);
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        bVar9.C.f7151l.setVisibility(8);
    }

    public final void r() {
        boolean zContains;
        float f = UptodownApp.E;
        String str = D().f8595w;
        h5.l lVar = UptodownApp.Z;
        if (lVar == null || !o7.u.Z(r0.f.C(lVar.a()), str, true)) {
            return;
        }
        h5.l lVar2 = UptodownApp.Z;
        lVar2.getClass();
        if (lVar2.f8646c != -1 || getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        if (z1.t1.r(contextRequireContext, "is_device_tracking_registered", false)) {
            Context contextRequireContext2 = requireContext();
            contextRequireContext2.getClass();
            try {
                zContains = contextRequireContext2.getSharedPreferences("SettingsPreferences", 0).contains("storage_sdcard");
            } catch (Exception unused) {
                zContains = false;
            }
            if (!zContains) {
                Context contextRequireContext3 = requireContext();
                contextRequireContext3.getClass();
                z1.t1.N(contextRequireContext3, "storage_sdcard", false);
            }
            Context contextRequireContext4 = requireContext();
            contextRequireContext4.getClass();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            fragmentActivityRequireActivity.getClass();
            l1.b.h(contextRequireContext4, (l4.w) fragmentActivityRequireActivity, D(), this.f7792m, false);
        }
    }

    public final void r0() {
        d5.b bVar = this.f7785b;
        bVar.getClass();
        bVar.J.f.setVisibility(8);
        d5.b bVar2 = this.f7785b;
        bVar2.getClass();
        bVar2.J.f6917d.setVisibility(0);
        d5.b bVar3 = this.f7785b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.G.f7054i).setVisibility(0);
        d5.b bVar4 = this.f7785b;
        bVar4.getClass();
        bVar4.G.f.setVisibility(0);
        d5.b bVar5 = this.f7785b;
        bVar5.getClass();
        bVar5.G.f7052c.setVisibility(8);
        d5.b bVar6 = this.f7785b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.G.f7055j).setVisibility(8);
        d5.b bVar7 = this.f7785b;
        bVar7.getClass();
        bVar7.C.h.setVisibility(8);
        d5.b bVar8 = this.f7785b;
        bVar8.getClass();
        bVar8.C.f7155p.setVisibility(8);
        d5.b bVar9 = this.f7785b;
        bVar9.getClass();
        bVar9.C.g.setVisibility(0);
        d5.b bVar10 = this.f7785b;
        bVar10.getClass();
        bVar10.C.f7151l.setVisibility(8);
    }

    public final void s(Context context) {
        if (a.a.D(D().f8566a)) {
            String str = D().f8595w;
            str.getClass();
            a.a.l(str);
            Object systemService = context.getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(261);
        } else {
            String str2 = D().f8595w;
            str2.getClass();
            if (a.a.F(str2)) {
                String str3 = D().f8595w;
                str3.getClass();
                a.a.l(str3);
            } else {
                v5.g gVarL = v5.g.f13148u.l(context);
                gVarL.a();
                h5.q qVarY = gVarL.y(String.valueOf(D().A));
                if (qVarY != null) {
                    if (qVarY.o()) {
                        gVarL.j(qVarY);
                    } else {
                        Iterator it = qVarY.f8716v.iterator();
                        it.getClass();
                        while (it.hasNext()) {
                            Object next = it.next();
                            next.getClass();
                            h5.r rVar = (h5.r) next;
                            rVar.f = 0L;
                            rVar.f8724i = 0;
                            gVarL.e0(rVar);
                        }
                    }
                }
                gVarL.b();
            }
        }
        p0(context);
    }

    public final void s0(Context context) {
        d5.b bVar = this.f7785b;
        bVar.getClass();
        bVar.W.setBackgroundColor(ContextCompat.getColor(context, R.color.transparent));
        if ((context.getResources().getConfiguration().uiMode & 48) == 16) {
            int color = ContextCompat.getColor(context, R.color.main_blue);
            Menu menu = this.g;
            menu.getClass();
            Drawable icon = menu.findItem(R.id.action_search).getIcon();
            if (icon != null) {
                DrawableCompat.setTint(icon, color);
            }
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.core_vector_back);
            if (drawable != null) {
                d5.b bVar2 = this.f7785b;
                bVar2.getClass();
                bVar2.W.setNavigationIcon(drawable);
            }
            Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.core_vector_menu_dots_blue);
            if (drawable2 != null) {
                d5.b bVar3 = this.f7785b;
                bVar3.getClass();
                bVar3.W.setOverflowIcon(drawable2);
            }
        }
    }

    public final void t() {
        if (D().l()) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(lifecycleScope, w7.n.f13548a, null, new b0(this, null, 0), 2);
            c1 c1VarG = G();
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            long j10 = D().f8566a;
            c1VarG.getClass();
            r7.y.q(ViewModelKt.getViewModelScope(c1VarG), y7.d.f14116a, null, new r0(1, j10, contextRequireContext, c1VarG, null), 2);
        }
    }

    public final void t0(FragmentActivity fragmentActivity) {
        d5.b bVar = this.f7785b;
        bVar.getClass();
        bVar.W.setBackgroundColor(ContextCompat.getColor(fragmentActivity, R.color.transparent));
        int color = ContextCompat.getColor(fragmentActivity, R.color.white);
        Menu menu = this.g;
        menu.getClass();
        Drawable icon = menu.findItem(R.id.action_search).getIcon();
        if (icon != null) {
            DrawableCompat.setTint(icon, color);
        }
        Drawable drawable = ContextCompat.getDrawable(fragmentActivity, R.drawable.vector_arrow_left_white);
        if (drawable != null) {
            d5.b bVar2 = this.f7785b;
            bVar2.getClass();
            bVar2.W.setNavigationIcon(drawable);
        }
        Drawable drawable2 = ContextCompat.getDrawable(fragmentActivity, R.drawable.vector_menu_dots);
        if (drawable2 != null) {
            d5.b bVar3 = this.f7785b;
            bVar3.getClass();
            bVar3.W.setOverflowIcon(drawable2);
        }
    }

    public final void u(a3.x xVar) throws Resources.NotFoundException {
        int i10 = 0;
        boolean z9 = true;
        if (G().V.compareAndSet(false, true)) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            fragmentActivityRequireActivity.getClass();
            new w4(fragmentActivityRequireActivity, 5, false).E((View) xVar.f183d, 0.0f);
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            fragmentActivityRequireActivity2.getClass();
            RelativeLayout relativeLayout = (RelativeLayout) xVar.f182c;
            d0 d0Var = new d0(this, i10);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(fragmentActivityRequireActivity2, R.anim.slide_out_bottom);
            float f = UptodownApp.E;
            try {
                SharedPreferences sharedPreferences = fragmentActivityRequireActivity2.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("animations")) {
                    z9 = sharedPreferences.getBoolean("animations", true);
                }
            } catch (Exception unused) {
            }
            if (!z9) {
                d0Var.onAnimationEnd(animationLoadAnimation);
                return;
            }
            float f10 = UptodownApp.E;
            animationLoadAnimation.setAnimationListener(d0Var);
            relativeLayout.startAnimation(animationLoadAnimation);
        }
    }

    public final void u0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new i0(str, this, null, 0), 2);
    }

    public final void v() {
        FragmentActivity activity = getActivity();
        activity.getClass();
        AlertDialog alertDialog = ((l4.w) activity).f10935w;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
        if (L(null)) {
            uVar.f10135a = DownloadWorker.f;
            DownloadWorker.f = true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        a3.z0 z0VarK = a3.z0.k(getLayoutInflater());
        TextView textView = (TextView) z0VarK.f198d;
        TextView textView2 = (TextView) z0VarK.e;
        TextView textView3 = (TextView) z0VarK.f197c;
        if (getActivity() != null && !requireActivity().isFinishing()) {
            textView.setTypeface(o4.b.f11720s);
            textView.setText(requireContext().getString(R.string.download_cancel_confimation_title));
            textView3.setTypeface(o4.b.f11719r);
            textView3.setText(requireContext().getString(R.string.dialog_confirmation_verify_negative));
            textView3.setOnClickListener(new b5.a(15, uVar, this));
            textView2.setTypeface(o4.b.f11719r);
            textView2.setText(requireContext().getString(R.string.dialog_confirmation_verify_afirmative));
            textView2.setOnClickListener(new r(this, 15));
        }
        builder.setView((LinearLayout) z0VarK.f);
        builder.setCancelable(false);
        l0(builder);
    }

    public final void v0(String str) {
        str.getClass();
        if (getContext() == null || D().f8595w == null || !o7.u.Z(D().f8595w, str, true)) {
            return;
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        p0(contextRequireContext);
        if (getActivity() == null || requireActivity().isFinishing() || !(getActivity() instanceof l4.w)) {
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        String string = getString(R.string.install_compatibility_error, D().f8567b);
        string.getClass();
        ((l4.w) activity).C(string);
    }

    public final void w(String str) {
        ArrayList arrayList;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            AlertDialog alertDialog = ((l4.w) activity).f10935w;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
        if (getContext() != null) {
            ArrayList arrayList2 = new ArrayList();
            String str2 = D().f8595w;
            if (str2 != null && str2.length() != 0 && (arrayList = D().L) != null && !arrayList.isEmpty()) {
                ArrayList arrayList3 = D().L;
                arrayList3.getClass();
                Context contextRequireContext = requireContext();
                contextRequireContext.getClass();
                arrayList2 = h5.p.c(arrayList3, contextRequireContext);
            }
            if (!arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                it.getClass();
                String strJ = "";
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    String str3 = (String) next;
                    if (str3.equals(t6.l.i0(arrayList2))) {
                        strJ = a3.a.j(strJ, "- ", str3);
                    } else {
                        strJ = strJ + "- " + str3 + '\n';
                    }
                }
                str = a3.a.j(str, "\n\n", strJ);
            }
            a3.z0 z0VarK = a3.z0.k(getLayoutInflater());
            TextView textView = (TextView) z0VarK.f197c;
            TextView textView2 = (TextView) z0VarK.e;
            TextView textView3 = (TextView) z0VarK.f198d;
            CheckBox checkBox = (CheckBox) z0VarK.f196b;
            textView3.setTypeface(o4.b.f11720s);
            textView3.setText(str);
            checkBox.setVisibility(0);
            checkBox.setTypeface(o4.b.f11720s);
            checkBox.setOnCheckedChangeListener(new o(this, 1));
            textView2.setTypeface(o4.b.f11719r);
            textView2.setOnClickListener(new r(this, 21));
            textView.setTypeface(o4.b.f11719r);
            textView.setOnClickListener(new b5.a(6, z0VarK, this));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView((LinearLayout) z0VarK.f);
            builder.setCancelable(false);
            l0(builder);
        }
    }

    public final void w0() {
        try {
            if (D().f8584q <= 0 || ((Number) G().Q.getValue()).intValue() <= 0) {
                d5.b bVar = this.f7785b;
                bVar.getClass();
                ((LinearLayout) bVar.t.f7082b).setVisibility(8);
                d5.b bVar2 = this.f7785b;
                bVar2.getClass();
                ((TextView) bVar2.t.e).setVisibility(8);
                return;
            }
            int dimension = (int) getResources().getDimension(R.dimen.margin_m);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * D().f8593v) / D().f8584q, dimension);
            d5.b bVar3 = this.f7785b;
            bVar3.getClass();
            ((View) bVar3.t.f7086j).setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * D().f8591u) / D().f8584q, dimension);
            d5.b bVar4 = this.f7785b;
            bVar4.getClass();
            ((View) bVar4.t.f7085i).setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * D().t) / D().f8584q, dimension);
            d5.b bVar5 = this.f7785b;
            bVar5.getClass();
            ((View) bVar5.t.h).setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * D().f8588s) / D().f8584q, dimension);
            d5.b bVar6 = this.f7785b;
            bVar6.getClass();
            ((View) bVar6.t.g).setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * D().f8586r) / D().f8584q, dimension);
            d5.b bVar7 = this.f7785b;
            bVar7.getClass();
            ((View) bVar7.t.f).setLayoutParams(layoutParams5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void x(String str) {
        if (getActivity() == null || !isAdded() || requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        AlertDialog alertDialog = ((l4.w) activity).f10935w;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        a3.z0 z0VarK = a3.z0.k(getLayoutInflater());
        TextView textView = (TextView) z0VarK.e;
        TextView textView2 = (TextView) z0VarK.f198d;
        textView2.setTypeface(o4.b.f11720s);
        textView2.setText(str);
        ((TextView) z0VarK.f197c).setVisibility(8);
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new r(this, 0));
        builder.setView((LinearLayout) z0VarK.f);
        builder.setCancelable(false);
        l0(builder);
    }

    public final void y(g7.a aVar) {
        FragmentActivity activity = getActivity();
        activity.getClass();
        AlertDialog alertDialog = ((l4.w) activity).f10935w;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (getContext() != null) {
            a3.z0 z0VarK = a3.z0.k(getLayoutInflater());
            TextView textView = (TextView) z0VarK.f198d;
            TextView textView2 = (TextView) z0VarK.f197c;
            TextView textView3 = (TextView) z0VarK.e;
            textView.setTypeface(o4.b.f11720s);
            textView.setText(getString(R.string.resume_downloads_queue_dialog, D().f8567b));
            textView3.setTypeface(o4.b.f11719r);
            textView3.setText(getString(R.string.updates_button_resume));
            textView3.setOnClickListener(new b5.a(7, aVar, this));
            textView2.setTypeface(o4.b.f11719r);
            l5.F(textView2);
            textView2.setOnClickListener(new e(this, 2));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView((LinearLayout) z0VarK.f);
            builder.setCancelable(false);
            l0(builder);
        }
    }

    public final void z(Context context) {
        int i10;
        FragmentActivity activity = getActivity();
        activity.getClass();
        AlertDialog alertDialog = ((l4.w) activity).f10935w;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        final Drawable drawable = ContextCompat.getDrawable(context, R.drawable.vector_star_on);
        final Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.vector_star_off);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_review_stars, (ViewGroup) null, false);
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        int i11 = R.id.et_review;
        EditText editText = (EditText) ViewBindings.findChildViewById(viewInflate, R.id.et_review);
        if (editText != null) {
            i11 = R.id.iv_avatar_dialog_review;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_avatar_dialog_review);
            if (imageView != null) {
                i11 = R.id.iv_star1_dialog_review;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star1_dialog_review);
                if (imageView2 != null) {
                    i11 = R.id.iv_star2_dialog_review;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star2_dialog_review);
                    if (imageView3 != null) {
                        i11 = R.id.iv_star3_dialog_review;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star3_dialog_review);
                        if (imageView4 != null) {
                            i11 = R.id.iv_star4_dialog_review;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star4_dialog_review);
                            if (imageView5 != null) {
                                i11 = R.id.iv_star5_dialog_review;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star5_dialog_review);
                                if (imageView6 != null) {
                                    i11 = R.id.tv_app_name_dialog_review;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name_dialog_review);
                                    if (textView != null) {
                                        i11 = R.id.tv_cancel;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_cancel);
                                        if (textView2 != null) {
                                            i11 = R.id.tv_ok;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ok);
                                            if (textView3 != null) {
                                                final c2.d dVar = new c2.d(linearLayout, editText, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2, textView3);
                                                String strI = D().i();
                                                if (strI == null || strI.length() == 0) {
                                                    imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_app_icon_placeholder));
                                                } else {
                                                    j4.d0 d0VarE = j4.y.d().e(D().i());
                                                    float f = UptodownApp.E;
                                                    d0VarE.g(k4.c.y(context));
                                                    d0VarE.e(imageView, null);
                                                }
                                                textView.setTypeface(o4.b.f11719r);
                                                textView.setText(D().f8567b);
                                                editText.setText((CharSequence) G().H.getValue());
                                                int iIntValue = ((Number) G().S.getValue()).intValue();
                                                int i12 = 2;
                                                if (iIntValue == 1) {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable2);
                                                    imageView4.setImageDrawable(drawable2);
                                                    imageView5.setImageDrawable(drawable2);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else if (iIntValue == 2) {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable);
                                                    imageView4.setImageDrawable(drawable2);
                                                    imageView5.setImageDrawable(drawable2);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else if (iIntValue == 3) {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable);
                                                    imageView4.setImageDrawable(drawable);
                                                    imageView5.setImageDrawable(drawable2);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else if (iIntValue == 4) {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable);
                                                    imageView4.setImageDrawable(drawable);
                                                    imageView5.setImageDrawable(drawable);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else if (iIntValue != 5) {
                                                    imageView2.setImageDrawable(drawable2);
                                                    imageView3.setImageDrawable(drawable2);
                                                    imageView4.setImageDrawable(drawable2);
                                                    imageView5.setImageDrawable(drawable2);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable);
                                                    imageView4.setImageDrawable(drawable);
                                                    imageView5.setImageDrawable(drawable);
                                                    imageView6.setImageDrawable(drawable);
                                                }
                                                final int i13 = 0;
                                                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: e5.t

                                                    /* renamed from: b, reason: collision with root package name */
                                                    public final /* synthetic */ j0 f7859b;

                                                    {
                                                        this.f7859b = this;
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        int i14 = i13;
                                                        Drawable drawable3 = drawable2;
                                                        Drawable drawable4 = drawable;
                                                        c2.d dVar2 = dVar;
                                                        j0 j0Var = this.f7859b;
                                                        switch (i14) {
                                                            case 0:
                                                                float f10 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(1, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 1:
                                                                float f11 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(2, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 2:
                                                                float f12 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(3, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                float f13 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(4, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    }
                                                });
                                                final int i14 = 1;
                                                imageView3.setOnClickListener(new View.OnClickListener(this) { // from class: e5.t

                                                    /* renamed from: b, reason: collision with root package name */
                                                    public final /* synthetic */ j0 f7859b;

                                                    {
                                                        this.f7859b = this;
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        int i142 = i14;
                                                        Drawable drawable3 = drawable2;
                                                        Drawable drawable4 = drawable;
                                                        c2.d dVar2 = dVar;
                                                        j0 j0Var = this.f7859b;
                                                        switch (i142) {
                                                            case 0:
                                                                float f10 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(1, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 1:
                                                                float f11 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(2, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 2:
                                                                float f12 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(3, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                float f13 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(4, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    }
                                                });
                                                final int i15 = 2;
                                                imageView4.setOnClickListener(new View.OnClickListener(this) { // from class: e5.t

                                                    /* renamed from: b, reason: collision with root package name */
                                                    public final /* synthetic */ j0 f7859b;

                                                    {
                                                        this.f7859b = this;
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        int i142 = i15;
                                                        Drawable drawable3 = drawable2;
                                                        Drawable drawable4 = drawable;
                                                        c2.d dVar2 = dVar;
                                                        j0 j0Var = this.f7859b;
                                                        switch (i142) {
                                                            case 0:
                                                                float f10 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(1, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 1:
                                                                float f11 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(2, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 2:
                                                                float f12 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(3, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                float f13 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(4, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    }
                                                });
                                                final int i16 = 3;
                                                imageView5.setOnClickListener(new View.OnClickListener(this) { // from class: e5.t

                                                    /* renamed from: b, reason: collision with root package name */
                                                    public final /* synthetic */ j0 f7859b;

                                                    {
                                                        this.f7859b = this;
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        int i142 = i16;
                                                        Drawable drawable3 = drawable2;
                                                        Drawable drawable4 = drawable;
                                                        c2.d dVar2 = dVar;
                                                        j0 j0Var = this.f7859b;
                                                        switch (i142) {
                                                            case 0:
                                                                float f10 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(1, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 1:
                                                                float f11 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(2, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 2:
                                                                float f12 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(3, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                float f13 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    com.mbridge.msdk.dycreator.baseview.a.o(4, j0Var.G().S, null);
                                                                    ((ImageView) dVar2.f1643d).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.e).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.g).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.h).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    }
                                                });
                                                imageView6.setOnClickListener(new j(this, dVar, drawable, i12));
                                                editText.setTypeface(o4.b.f11720s);
                                                if (G().f7711v.getValue() != null) {
                                                    Object value = G().f7711v.getValue();
                                                    value.getClass();
                                                    String str = ((h5.t0) value).f;
                                                    if (str != null && str.length() != 0) {
                                                        Object value2 = G().f7711v.getValue();
                                                        value2.getClass();
                                                        editText.setText(String.valueOf(((h5.t0) value2).f));
                                                    }
                                                    Object value3 = G().f7711v.getValue();
                                                    value3.getClass();
                                                    if (((h5.t0) value3).g >= 1) {
                                                        i10 = R.drawable.vector_star_on;
                                                        com.mbridge.msdk.dycreator.baseview.a.r(this, R.drawable.vector_star_on, imageView2);
                                                    } else {
                                                        i10 = R.drawable.vector_star_on;
                                                    }
                                                    Object value4 = G().f7711v.getValue();
                                                    value4.getClass();
                                                    if (((h5.t0) value4).g >= 2) {
                                                        com.mbridge.msdk.dycreator.baseview.a.r(this, i10, imageView3);
                                                    }
                                                    Object value5 = G().f7711v.getValue();
                                                    value5.getClass();
                                                    if (((h5.t0) value5).g >= 3) {
                                                        com.mbridge.msdk.dycreator.baseview.a.r(this, i10, imageView4);
                                                    }
                                                    Object value6 = G().f7711v.getValue();
                                                    value6.getClass();
                                                    if (((h5.t0) value6).g >= 4) {
                                                        com.mbridge.msdk.dycreator.baseview.a.r(this, i10, imageView5);
                                                    }
                                                    Object value7 = G().f7711v.getValue();
                                                    value7.getClass();
                                                    if (((h5.t0) value7).g == 5) {
                                                        com.mbridge.msdk.dycreator.baseview.a.r(this, i10, imageView6);
                                                    }
                                                }
                                                textView3.setTypeface(o4.b.f11719r);
                                                textView3.setOnClickListener(new j(context, this, dVar));
                                                textView2.setTypeface(o4.b.f11719r);
                                                textView2.setOnClickListener(new b5.a(14, this, dVar));
                                                builder.setView(linearLayout);
                                                FragmentActivity activity2 = getActivity();
                                                activity2.getClass();
                                                AlertDialog alertDialog2 = ((l4.w) activity2).f10935w;
                                                if (alertDialog2 != null) {
                                                    alertDialog2.setOnDismissListener(new l9(this, context, i12));
                                                }
                                                l0(builder);
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
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
    }
}
