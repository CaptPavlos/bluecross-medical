package l4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBindings;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.core.view.WrapContentLinearLayoutManager;
import com.uptodown.workers.DownloadApkWorker;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import l4.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class w extends p4.m0 {
    public static final /* synthetic */ int G = 0;
    public n4.c0 A;
    public final q B = new q(this);
    public ArrayList C = new ArrayList();
    public ActivityResultLauncher D;
    public z5.d E;
    public RelativeLayout F;

    /* renamed from: v, reason: collision with root package name */
    public t1.c f10934v;

    /* renamed from: w, reason: collision with root package name */
    public AlertDialog f10935w;

    /* renamed from: x, reason: collision with root package name */
    public long f10936x;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public RecyclerView f10937z;

    public final void J() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f10936x > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            this.f10936x = jCurrentTimeMillis;
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(r7.y.a(y7.d.f14116a), null, null, new a6.c(this, null, 14), 3);
        }
    }

    public final void K(String str, g7.a aVar) {
        if (isFinishing()) {
            return;
        }
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        a3.z0 z0VarK = a3.z0.k(getLayoutInflater());
        TextView textView = (TextView) z0VarK.f197c;
        TextView textView2 = (TextView) z0VarK.e;
        TextView textView3 = (TextView) z0VarK.f198d;
        textView3.setTypeface(o4.b.f11720s);
        textView3.setText(str);
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new o(aVar, this, 0));
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new n(this, 1));
        builder.setView((LinearLayout) z0VarK.f);
        this.f10935w = builder.create();
        if (isFinishing() || this.f10935w == null) {
            return;
        }
        j0();
    }

    public final void L(String str, g7.a aVar, g7.a aVar2) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new c5.c(this, str, aVar, aVar2, (w6.c) null, 7), 2);
    }

    public final void M(File file) {
        String string = getString(R.string.warning_auto_update);
        string.getClass();
        K(string, new androidx.work.impl.utils.c(8, this, file));
    }

    public final void N(String str) {
        str.getClass();
        if (isFinishing()) {
            return;
        }
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        a3.z0 z0VarK = a3.z0.k(getLayoutInflater());
        TextView textView = (TextView) z0VarK.e;
        TextView textView2 = (TextView) z0VarK.f198d;
        textView2.setTypeface(o4.b.f11720s);
        textView2.setText(str);
        ((TextView) z0VarK.f197c).setVisibility(8);
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new n(this, 0));
        builder.setView((LinearLayout) z0VarK.f);
        this.f10935w = builder.create();
        if (isFinishing() || this.f10935w == null) {
            return;
        }
        j0();
    }

    public final void O() {
        AlertDialog alertDialog;
        if (isFinishing()) {
            return;
        }
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        a3.z0 z0VarK = a3.z0.k(getLayoutInflater());
        TextView textView = (TextView) z0VarK.e;
        TextView textView2 = (TextView) z0VarK.f198d;
        TextView textView3 = (TextView) z0VarK.f197c;
        textView2.setTypeface(o4.b.f11720s);
        textView2.setText(getString(R.string.msg_storage_permission_required));
        textView.setTypeface(o4.b.f11719r);
        MainActivity mainActivity = (MainActivity) this;
        textView.setOnClickListener(new m(0, mainActivity));
        textView3.setTypeface(o4.b.f11719r);
        textView3.setText(getString(R.string.exit));
        textView3.setOnClickListener(new m(1, mainActivity));
        builder.setView((LinearLayout) z0VarK.f);
        builder.setCancelable(false);
        this.f10935w = builder.create();
        if (isFinishing() || (alertDialog = this.f10935w) == null) {
            return;
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            a3.a.A(window, 0);
        }
        AlertDialog alertDialog2 = this.f10935w;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    public final void P(h5.h hVar, g7.a aVar, g7.a aVar2) {
        hVar.getClass();
        Q();
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_turbo_positives_detected, (ViewGroup) null, false);
        int i10 = R.id.iv_close_dialog_turbo_positives_detected;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_close_dialog_turbo_positives_detected);
        if (imageView != null) {
            i10 = R.id.tv_action_dialog_turbo_positives_detected;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_action_dialog_turbo_positives_detected);
            if (textView != null) {
                i10 = R.id.tv_description_dialog_turbo_positives_detected;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_description_dialog_turbo_positives_detected);
                if (textView2 != null) {
                    i10 = R.id.tv_title_dialog_turbo_positives_detected;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dialog_turbo_positives_detected);
                    if (textView3 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                        textView3.setTypeface(o4.b.f11719r);
                        textView2.setTypeface(o4.b.f11720s);
                        imageView.setOnClickListener(new o(this, aVar2));
                        if (kotlin.jvm.internal.l.a(hVar.N, "ExternalDownload")) {
                            textView2.setText(hVar.f8572j0);
                            textView.setText(getString(R.string.leave_anyways));
                        } else {
                            textView.setText(getString(R.string.download_anyways));
                        }
                        textView.setTypeface(o4.b.f11719r);
                        textView.setOnClickListener(new o(aVar, this, 2));
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setView(relativeLayout);
                        builder.setCancelable(true);
                        builder.setOnCancelListener(new k(aVar2, 0));
                        this.f10935w = builder.create();
                        j0();
                        return;
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        AlertDialog alertDialog = this.f10935w;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void R() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_preregister_notifications);
        this.f10937z = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            RecyclerView recyclerView2 = this.f10937z;
            recyclerView2.getClass();
            recyclerView2.addItemDecoration(new x5.g((int) getResources().getDimension(R.dimen.margin_m)));
            MainActivity mainActivity = (MainActivity) this;
            this.A = new n4.c0(mainActivity, this.B);
            RecyclerView recyclerView3 = this.f10937z;
            recyclerView3.getClass();
            recyclerView3.setAdapter(this.A);
            new ItemTouchHelper(new p(mainActivity)).attachToRecyclerView(this.f10937z);
        }
    }

    public final void S(File file, String str) {
        s sVar = new s(this, file);
        Activity activity = o4.b.g;
        if (r0.f.A() != null || o4.b.f11718q != null) {
            String string = getString(R.string.core_installation_in_progress_msg);
            string.getClass();
            C(string);
            return;
        }
        String name = file.getName();
        name.getClass();
        if (!o7.u.X(name, ".xapk", true) && !o7.u.X(name, ".apks", true) && !o7.u.X(name, ".apkm", true)) {
            float f = UptodownApp.E;
            k4.c.p(this, file, str);
        } else {
            String absolutePath = file.getAbsolutePath();
            absolutePath.getClass();
            new c1.g1(this, absolutePath, sVar, o());
        }
    }

    public final void T(File file, String str) {
        file.getClass();
        boolean zF = v5.a.f(this);
        h5.e1 e1VarH = h5.c1.h(this);
        v5.g gVarL = v5.g.f13148u.l(this);
        gVarL.a();
        if (file.isFile()) {
            String name = file.getName();
            name.getClass();
            h5.q qVarW = gVarL.w(name);
            if (e1VarH == null || !e1VarH.d()) {
                String absolutePath = file.getAbsolutePath();
                absolutePath.getClass();
                Intent intent = new Intent(this, (Class<?>) InstallerActivity.class);
                intent.putExtra("realPath", absolutePath);
                intent.putExtra("requireUserAction", zF);
                intent.putExtra("backgroundInstallation", false);
                intent.addFlags(268435456);
                if (str != null && str.length() != 0) {
                    intent.putExtra("newFeatures", str);
                }
                startActivity(intent);
                if (qVarW != null) {
                    V(qVarW);
                }
            } else {
                r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new v(this, com.google.android.gms.internal.measurement.l5.y(file.getAbsolutePath()), file, str, zF, qVarW, null), 3);
            }
        } else {
            String absolutePath2 = file.getAbsolutePath();
            absolutePath2.getClass();
            Intent intent2 = new Intent(this, (Class<?>) InstallerActivity.class);
            intent2.putExtra("realPath", absolutePath2);
            intent2.putExtra("requireUserAction", zF);
            intent2.putExtra("backgroundInstallation", false);
            intent2.addFlags(268435456);
            if (str != null && str.length() != 0) {
                intent2.putExtra("newFeatures", str);
            }
            startActivity(intent2);
            String absolutePath3 = file.getAbsolutePath();
            absolutePath3.getClass();
            h5.q qVarX = gVarL.x(absolutePath3);
            if (qVarX != null) {
                V(qVarX);
            }
        }
        gVarL.b();
    }

    public final void U(File file, String str) {
        file.getClass();
        boolean z9 = false;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("show_installation_details")) {
                z9 = sharedPreferences.getBoolean("show_installation_details", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            T(file, str);
            return;
        }
        h5.e1 e1VarH = h5.c1.h(this);
        if (e1VarH == null || !e1VarH.d()) {
            S(file, str);
        } else if (!file.isFile()) {
            S(file, str);
        } else {
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new a6.q((Object) this, com.google.android.gms.internal.measurement.l5.y(file.getAbsolutePath()), (Object) file, (Object) str, (w6.c) null, 8), 3);
        }
    }

    public final void V(h5.q qVar) {
        qVar.getClass();
        Bundle bundle = new Bundle();
        String str = qVar.f8701b;
        if (str != null) {
            h5.l lVar = UptodownApp.Z;
            if (lVar != null) {
                String strC = r0.f.C(lVar.a());
                if (strC != null && strC.equalsIgnoreCase(str)) {
                    bundle.putString("source", "deeplink");
                }
            } else {
                h5.a0 a0VarJ = z1.t1.J(this);
                if (a0VarJ != null && o7.u.Z(a0VarJ.f8461b, str, true)) {
                    bundle.putString("source", "notification_fcm");
                }
            }
            bundle.putString("packagename", qVar.f8701b);
        }
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
        t1.c cVar = this.f10934v;
        if (cVar != null) {
            cVar.e(bundle, "install");
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, y7.d.f14116a, null, new a6.j(this, qVar, (w6.c) null, 21), 2);
    }

    public void W(h5.h hVar) {
        m0(hVar);
    }

    public void Y(long j10) {
        if (j10 > 0) {
            new c1.l(this, j10, new y2.c(this, 23), LifecycleOwnerKt.getLifecycleScope(this));
        } else {
            b0();
        }
    }

    public final void Z(long j10, String str) {
        if (j10 > 0) {
            new c1.l(this, j10, new i0.k(6, this, str), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void a0(String str, h5.l lVar) {
        str.getClass();
        new w2.r(this, str, new i0.k(7, lVar, this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final void applyWindowInsets(View view) {
        view.getClass();
        ViewCompat.setOnApplyWindowInsetsListener(view, new com.google.gson.internal.a(18));
    }

    public final void b0() {
        if (isFinishing() || (o4.b.g instanceof MyDownloads)) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) MyDownloads.class);
        float f = UptodownApp.E;
        startActivity(intent, k4.c.a(this));
    }

    public final void c0(String str) {
        if (str == null || isFinishing()) {
            return;
        }
        String strX = androidx.constraintlayout.core.widgets.analyzer.a.x("https://www.virustotal.com/gui/file/", str, "/detection");
        String string = getString(R.string.virustotal_safety_report_title);
        string.getClass();
        v5.c.e(this, strX, string);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getSource() != 8194) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public final void e0(int i10, String str) {
        if (!a.a.f0a) {
            String string = getString(R.string.error_no_connection);
            string.getClass();
            C(string);
            return;
        }
        float f = UptodownApp.E;
        if (!k4.c.o(this, "downloadApkWorker")) {
            WorkManager.Companion.getInstance(this).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", i10).build()).build());
        } else {
            if (str == null || str.length() == 0) {
                return;
            }
            String string2 = getString(R.string.msg_added_to_downlads_queue);
            string2.getClass();
            C(String.format(string2, Arrays.copyOf(new Object[]{str}, 1)));
        }
    }

    public void g0(File file) {
        file.getClass();
    }

    public final void hideKeyboardOnScroll(final View view) {
        view.getClass();
        view.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: l4.j
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i10, int i11, int i12, int i13) {
                if (i11 > i13) {
                    Object systemService = this.f10509a.getSystemService("input_method");
                    systemService.getClass();
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v2 */
    public final void i0(h5.h hVar, g7.a aVar) {
        LifecycleCoroutineScope lifecycleCoroutineScope;
        Throwable th;
        final ?? r12;
        SharedPreferences sharedPreferences;
        hVar.getClass();
        i0.k kVar = new i0.k(9, aVar, this);
        RelativeLayout relativeLayout = this.F;
        if (relativeLayout != null) {
            final z5.d dVar = new z5.d(hVar, relativeLayout, kVar);
            this.E = dVar;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            lifecycleScope.getClass();
            int i10 = 2;
            z5.c cVar = new z5.c(this, dVar, i10);
            z5.c cVar2 = new z5.c(this, dVar, 3);
            View viewFindViewById = relativeLayout.findViewById(R.id.v_background_app_info_selected);
            viewFindViewById.getClass();
            dVar.f14416d = viewFindViewById;
            final int i11 = 0;
            viewFindViewById.setVisibility(0);
            View viewFindViewById2 = relativeLayout.findViewById(R.id.rl_app_info_selected);
            viewFindViewById2.getClass();
            dVar.e = (RelativeLayout) viewFindViewById2;
            View viewFindViewById3 = relativeLayout.findViewById(R.id.iv_logo_app_info_selected);
            viewFindViewById3.getClass();
            dVar.f = (ImageView) viewFindViewById3;
            View viewFindViewById4 = relativeLayout.findViewById(R.id.tv_name_app_info_selected);
            viewFindViewById4.getClass();
            dVar.g = (TextView) viewFindViewById4;
            View viewFindViewById5 = relativeLayout.findViewById(R.id.tv_author_app_info_selected);
            viewFindViewById5.getClass();
            dVar.f14417i = (TextView) viewFindViewById5;
            View viewFindViewById6 = relativeLayout.findViewById(R.id.ll_download_app_info_selected);
            viewFindViewById6.getClass();
            dVar.f14421m = (LinearLayout) viewFindViewById6;
            View viewFindViewById7 = relativeLayout.findViewById(R.id.pb_progress_app_info_selected);
            viewFindViewById7.getClass();
            dVar.f14422n = (ProgressBar) viewFindViewById7;
            View viewFindViewById8 = relativeLayout.findViewById(R.id.tv_progress_app_info_selected);
            viewFindViewById8.getClass();
            dVar.f14423o = (TextView) viewFindViewById8;
            View viewFindViewById9 = relativeLayout.findViewById(R.id.tv_verified_app_info_selected);
            viewFindViewById9.getClass();
            dVar.f14418j = (TextView) viewFindViewById9;
            View viewFindViewById10 = relativeLayout.findViewById(R.id.tv_valoration_app_info_selected);
            viewFindViewById10.getClass();
            dVar.f14419k = (TextView) viewFindViewById10;
            View viewFindViewById11 = relativeLayout.findViewById(R.id.tv_action_app_info_selected);
            viewFindViewById11.getClass();
            dVar.h = (TextView) viewFindViewById11;
            View viewFindViewById12 = relativeLayout.findViewById(R.id.iv_wishlist_action_app_info_selected);
            viewFindViewById12.getClass();
            dVar.f14420l = (ImageView) viewFindViewById12;
            TextView textView = dVar.g;
            if (textView == null) {
                kotlin.jvm.internal.l.i("tvNameAppInfoSelected");
                throw null;
            }
            textView.setTypeface(o4.b.f11719r);
            TextView textView2 = dVar.f14417i;
            if (textView2 == null) {
                kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
                throw null;
            }
            textView2.setTypeface(o4.b.f11720s);
            TextView textView3 = dVar.f14423o;
            if (textView3 == null) {
                kotlin.jvm.internal.l.i("tvProgressAppInfoSelected");
                throw null;
            }
            textView3.setTypeface(o4.b.f11720s);
            TextView textView4 = dVar.f14418j;
            if (textView4 == null) {
                kotlin.jvm.internal.l.i("tvVerifiedAppInfoSelected");
                throw null;
            }
            textView4.setTypeface(o4.b.f11720s);
            TextView textView5 = dVar.f14419k;
            if (textView5 == null) {
                kotlin.jvm.internal.l.i("tvValorationAppInfoSelected");
                throw null;
            }
            textView5.setTypeface(o4.b.f11720s);
            TextView textView6 = dVar.h;
            if (textView6 == null) {
                kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
                throw null;
            }
            textView6.setTypeface(o4.b.f11719r);
            ImageView imageView = dVar.f;
            if (imageView == null) {
                kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
                throw null;
            }
            imageView.setScaleX(1.0f);
            ImageView imageView2 = dVar.f;
            if (imageView2 == null) {
                kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
                throw null;
            }
            imageView2.setScaleY(1.0f);
            ProgressBar progressBar = dVar.f14422n;
            if (progressBar == null) {
                kotlin.jvm.internal.l.i("pbAppInfoSelected");
                throw null;
            }
            progressBar.setVisibility(8);
            dVar.c(dVar.f14413a, this);
            if (dVar.f14413a.z0 == 1) {
                dVar.g(this);
                lifecycleCoroutineScope = lifecycleScope;
                r12 = 1;
                th = null;
            } else {
                ImageView imageView3 = dVar.f14420l;
                if (imageView3 == null) {
                    kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
                    throw null;
                }
                imageView3.setVisibility(8);
                lifecycleCoroutineScope = lifecycleScope;
                th = null;
                r12 = 1;
                new c1.l(this, dVar.f14413a.f8566a, new z5.c(dVar, this, i11), lifecycleCoroutineScope);
            }
            TextView textView7 = dVar.h;
            if (textView7 == null) {
                kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
                throw th;
            }
            textView7.setOnClickListener(new z5.a(this, dVar));
            ImageView imageView4 = dVar.f;
            if (imageView4 == null) {
                kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
                throw th;
            }
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: z5.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i11) {
                        case 0:
                            d dVar2 = dVar;
                            dVar2.f14414b.setVisibility(8);
                            i0.k kVar2 = dVar2.f14415c;
                            h5.h hVar2 = dVar2.f14413a;
                            hVar2.getClass();
                            ((w) kVar2.f8924c).m0(hVar2);
                            break;
                        default:
                            d dVar3 = dVar;
                            dVar3.f14414b.setVisibility(8);
                            i0.k kVar3 = dVar3.f14415c;
                            h5.h hVar3 = dVar3.f14413a;
                            hVar3.getClass();
                            ((w) kVar3.f8924c).m0(hVar3);
                            break;
                    }
                }
            });
            TextView textView8 = dVar.g;
            if (textView8 == null) {
                kotlin.jvm.internal.l.i("tvNameAppInfoSelected");
                throw th;
            }
            textView8.setOnClickListener(new View.OnClickListener() { // from class: z5.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (r12) {
                        case 0:
                            d dVar2 = dVar;
                            dVar2.f14414b.setVisibility(8);
                            i0.k kVar2 = dVar2.f14415c;
                            h5.h hVar2 = dVar2.f14413a;
                            hVar2.getClass();
                            ((w) kVar2.f8924c).m0(hVar2);
                            break;
                        default:
                            d dVar3 = dVar;
                            dVar3.f14414b.setVisibility(8);
                            i0.k kVar3 = dVar3.f14415c;
                            h5.h hVar3 = dVar3.f14413a;
                            hVar3.getClass();
                            ((w) kVar3.f8924c).m0(hVar3);
                            break;
                    }
                }
            });
            ImageView imageView5 = dVar.f14420l;
            if (imageView5 == null) {
                kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
                throw th;
            }
            imageView5.setOnClickListener(new e5.f(this, lifecycleCoroutineScope, dVar, cVar2, cVar));
            View view = dVar.f14416d;
            if (view == null) {
                kotlin.jvm.internal.l.i("vBackground");
                throw th;
            }
            view.setOnClickListener(new z5.a(dVar, this, i10));
            if (relativeLayout.getVisibility() != 0) {
                relativeLayout.setVisibility(0);
                RelativeLayout relativeLayout2 = dVar.e;
                if (relativeLayout2 == null) {
                    kotlin.jvm.internal.l.i("rlAppInfoSelected");
                    throw th;
                }
                float f = UptodownApp.E;
                try {
                    sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception unused) {
                }
                boolean z9 = sharedPreferences.contains("animations") ? sharedPreferences.getBoolean("animations", r12) : r12;
                if (z9) {
                    float f10 = UptodownApp.E;
                    relativeLayout2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom));
                    relativeLayout2.setVisibility(0);
                } else {
                    relativeLayout2.setVisibility(0);
                }
            }
            RelativeLayout relativeLayout3 = dVar.e;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
            } else {
                kotlin.jvm.internal.l.i("rlAppInfoSelected");
                throw th;
            }
        }
    }

    public final void j0() {
        AlertDialog alertDialog = this.f10935w;
        alertDialog.getClass();
        Window window = alertDialog.getWindow();
        if (window != null) {
            a3.a.A(window, 0);
        }
        AlertDialog alertDialog2 = this.f10935w;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    public void k0(long j10) {
        String string = getString(R.string.core_kill_this_app, getString(R.string.app_name));
        string.getClass();
        N(string);
    }

    public final void l0() {
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
        customTabsIntentBuild.getClass();
        String strA = com.google.android.gms.internal.measurement.l5.A(this);
        if (o7.m.d0(strA, ".uptodown.com/", false)) {
            strA = (o7.m.d0(strA, "?", false) ? strA.concat("&") : strA.concat("?")).concat("userAgent=uptodownandroid");
        }
        customTabsIntentBuild.intent.setData(Uri.parse(strA));
        ActivityResultLauncher activityResultLauncher = this.D;
        Intent intent = customTabsIntentBuild.intent;
        if (activityResultLauncher != null) {
            float f = UptodownApp.E;
            activityResultLauncher.launch(intent, k4.c.b(this));
        } else {
            float f10 = UptodownApp.E;
            startActivity(intent, k4.c.a(this));
        }
    }

    public void m0(h5.h hVar) {
        hVar.getClass();
    }

    @Override // p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10934v = new t1.c(this, 4);
    }

    @Override // p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        r7.y.q(r7.y.a(r7.i0.f12407a), null, null, new t(this, null), 3);
        d0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i10) {
        super.setContentView(i10);
        View viewFindViewById = findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            applyWindowInsets(viewFindViewById);
        }
    }

    public final void showKeyboard(View view) {
        view.getClass();
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).showSoftInput(view.findFocus(), 1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        view.getClass();
        super.setContentView(view);
        applyWindowInsets(view);
    }

    public void X() {
    }

    public void d0() {
    }

    @Override // p4.f
    public final void r() {
    }

    @Override // p4.f
    public final void s() {
    }

    @Override // p4.f
    public final void t() {
    }

    @Override // p4.f
    public void u() {
    }

    @Override // p4.f
    public void w() {
    }

    public void f0(File file) {
    }

    public void h0(File file) {
    }
}
