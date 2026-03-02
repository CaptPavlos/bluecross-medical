package com.uptodown.tv.ui.fragment;

import android.R;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import c1.d0;
import c1.l;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import h5.c1;
import h5.e1;
import h5.h;
import h5.o0;
import h5.p;
import h5.q;
import h5.r;
import h5.y0;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import l4.n5;
import l4.w;
import m4.k;
import o7.u;
import p4.i0;
import q5.b;
import q5.d;
import r7.y;
import s4.n;
import s5.c;
import s5.e;
import v5.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvAppDetailFragment extends DetailsSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public h f6693a;

    /* renamed from: d, reason: collision with root package name */
    public ArrayObjectAdapter f6696d;
    public BackgroundManager e;
    public AlertDialog f;
    public AlertDialog g;
    public DetailsOverviewRow h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6697i;

    /* renamed from: j, reason: collision with root package name */
    public y0 f6698j;

    /* renamed from: k, reason: collision with root package name */
    public b f6699k;

    /* renamed from: o, reason: collision with root package name */
    public final ActivityResultLauncher f6703o;

    /* renamed from: b, reason: collision with root package name */
    public long f6694b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f6695c = -1;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6700l = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6701m = true;

    /* renamed from: n, reason: collision with root package name */
    public final d0 f6702n = new d0(this);

    public TvAppDetailFragment() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 25));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f6703o = activityResultLauncherRegisterForActivityResult;
    }

    public static void a(TvAppDetailFragment tvAppDetailFragment) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30 ? Environment.isExternalStorageManager() : i10 >= 33 || ContextCompat.checkSelfPermission(tvAppDetailFragment.requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            tvAppDetailFragment.j();
        }
    }

    public final void b() {
        if (this.f6693a == null || getContext() == null) {
            return;
        }
        h hVar = this.f6693a;
        hVar.getClass();
        long j10 = hVar.f8566a;
        q qVar = DownloadWorker.f6738d;
        if (qVar == null || qVar.h != j10) {
            return;
        }
        DownloadWorker.f = false;
        DownloadWorker.e = true;
    }

    public final void c(q qVar, String str) {
        AlertDialog alertDialog = this.f;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(R.string.ok, new c(this, qVar));
        builder.setNegativeButton(R.string.cancel, new r5.c(5));
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        this.f = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
    }

    public final boolean d() {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        AlertDialog alertDialog = this.g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        try {
            sharedPreferences2 = contextRequireContext.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences2.contains("is_in_eea") ? sharedPreferences2.getBoolean("is_in_eea", true) : true;
        if (z9) {
            Context contextRequireContext2 = requireContext();
            contextRequireContext2.getClass();
            try {
                sharedPreferences = contextRequireContext2.getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception unused2) {
            }
            boolean z10 = sharedPreferences.contains("gdpr_tracking_allowed") ? sharedPreferences.getBoolean("gdpr_tracking_allowed", false) : false;
            if (!z10) {
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setMessage(getString(com.uptodown.R.string.tracking_disabled_warning_gdpr));
                builder.setPositiveButton(com.uptodown.R.string.gdpr_set_up, new k(this, 2));
                builder.setNegativeButton(R.string.cancel, new r5.c(4));
                builder.setCancelable(true);
                this.g = builder.create();
                if (!requireActivity().isFinishing()) {
                    AlertDialog alertDialog2 = this.g;
                    if (alertDialog2 != null) {
                        alertDialog2.show();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final void e(String str) {
        AlertDialog alertDialog = this.f;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(R.string.ok, new r5.c(2));
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        this.f = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
    }

    public final void f() {
        File parentFile;
        PackageManager packageManager;
        h hVar = this.f6693a;
        if (hVar == null || hVar.f8595w == null || getContext() == null) {
            n();
            return;
        }
        t3.h hVar2 = g.f13148u;
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        g gVarL = hVar2.l(contextRequireContext);
        gVarL.a();
        h hVar3 = this.f6693a;
        hVar3.getClass();
        String str = hVar3.f8595w;
        str.getClass();
        h hVar4 = this.f6693a;
        hVar4.getClass();
        q qVarB = gVarL.B(hVar4.B, str);
        ApplicationInfo applicationInfoB = null;
        if (qVarB == null || !qVarB.c() || qVarB.f8716v.isEmpty()) {
            parentFile = null;
            break;
        }
        Iterator it = qVarB.f8716v.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            r rVar = (r) next;
            if (rVar.h != null) {
                String str2 = rVar.h;
                str2.getClass();
                File file = new File(str2);
                if (file.exists() && rVar.f == file.length()) {
                }
            }
            parentFile = null;
        }
        parentFile = qVarB.g();
        gVarL.b();
        if (parentFile == null) {
            n();
            return;
        }
        h hVar5 = this.f6693a;
        hVar5.getClass();
        String str3 = hVar5.f8595w;
        str3.getClass();
        y0 y0VarM = gVarL.M(str3);
        this.f6698j = y0VarM;
        if (y0VarM == null || y0VarM.g != 1) {
            float f = UptodownApp.E;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            fragmentActivityRequireActivity.getClass();
            k4.c.q(fragmentActivityRequireActivity, parentFile, null);
            return;
        }
        if (!parentFile.isDirectory()) {
            parentFile = new File(parentFile.getAbsolutePath()).getParentFile();
        }
        File file2 = parentFile;
        i0.k kVar = new i0.k(28, file2, this);
        try {
            FragmentActivity activity = getActivity();
            if (activity != null && (packageManager = activity.getPackageManager()) != null) {
                y0 y0Var = this.f6698j;
                y0Var.getClass();
                applicationInfoB = l5.a.b(packageManager, y0Var.f8795b, 128);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (applicationInfoB == null) {
            String string = getString(com.uptodown.R.string.installable_files_not_found);
            string.getClass();
            e(string);
            return;
        }
        File file3 = new File(applicationInfoB.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(file3);
        file2.getClass();
        Context contextRequireContext2 = requireContext();
        contextRequireContext2.getClass();
        new n(arrayList, file2, kVar, false, contextRequireContext2);
    }

    public final void i(q qVar) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            h hVar = this.f6693a;
            hVar.getClass();
            qVar.a(hVar);
            int iQ = qVar.q(activity);
            if (iQ < 0) {
                String string = getString(com.uptodown.R.string.descarga_error);
                string.getClass();
                e(string);
                o();
                return;
            }
            float f = UptodownApp.E;
            if (!k4.c.o(activity, "downloadApkWorker")) {
                WorkManager.Companion.getInstance(activity).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", iQ).build()).build());
                return;
            }
            String string2 = getString(com.uptodown.R.string.msg_added_to_downlads_queue);
            string2.getClass();
            h hVar2 = this.f6693a;
            hVar2.getClass();
            e(String.format(string2, Arrays.copyOf(new Object[]{hVar2.f8567b}, 1)));
        }
    }

    public final void j() {
        boolean zE;
        boolean zD;
        boolean zIsEmpty;
        boolean z9;
        SharedPreferences sharedPreferences;
        if (this.f6693a == null || getActivity() == null || k() || d()) {
            return;
        }
        h hVar = this.f6693a;
        if (hVar == null || !hVar.j()) {
            l("no_file_id");
            String string = getString(com.uptodown.R.string.msg_app_no_compatible_files);
            string.getClass();
            e(string);
            return;
        }
        q qVar = new q();
        h hVar2 = this.f6693a;
        hVar2.getClass();
        qVar.a(hVar2);
        p pVar = new p();
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        pVar.g(contextRequireContext);
        Context contextRequireContext2 = requireContext();
        contextRequireContext2.getClass();
        try {
            sharedPreferences = contextRequireContext2.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z10 = sharedPreferences.contains("show_warning_download_incompatible") ? sharedPreferences.getBoolean("show_warning_download_incompatible", true) : true;
        if (z10) {
            z9 = qVar.f8707l <= pVar.h;
            zD = pVar.d(qVar);
            zE = pVar.e(qVar);
            h hVar3 = this.f6693a;
            hVar3.getClass();
            if (hVar3.L != null) {
                h hVar4 = this.f6693a;
                hVar4.getClass();
                ArrayList arrayList = hVar4.L;
                arrayList.getClass();
                Context contextRequireContext3 = requireContext();
                contextRequireContext3.getClass();
                zIsEmpty = p.c(arrayList, contextRequireContext3).isEmpty();
            } else {
                zIsEmpty = true;
            }
        } else {
            zE = true;
            zD = true;
            zIsEmpty = true;
            z9 = true;
        }
        if (!z9 || !zD || !zE || !zIsEmpty) {
            if (!z9) {
                l("sdk");
                String string2 = getString(com.uptodown.R.string.msg_warning_incompatible_sdk);
                string2.getClass();
                c(qVar, string2);
                return;
            }
            if (!zD) {
                l("abi");
                String string3 = getString(com.uptodown.R.string.msg_warning_incompatible_abi);
                string3.getClass();
                c(qVar, string3);
                return;
            }
            if (zE) {
                l("required_feature");
                String string4 = getString(com.uptodown.R.string.msg_warning_incompatible_required_features);
                string4.getClass();
                c(qVar, string4);
                return;
            }
            l("density");
            String string5 = getString(com.uptodown.R.string.msg_warning_incompatible_density);
            string5.getClass();
            c(qVar, string5);
            return;
        }
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        e1 e1VarH = c1.h(fragmentActivityRequireActivity);
        if (e1VarH == null || !e1VarH.d()) {
            i(qVar);
            return;
        }
        h hVar5 = this.f6693a;
        hVar5.getClass();
        if (hVar5.Q == null) {
            y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new i0(this, qVar, (w6.c) null, 8), 3);
            return;
        }
        h hVar6 = this.f6693a;
        hVar6.getClass();
        o0 o0Var = hVar6.Q;
        o0Var.getClass();
        if (o0Var.f8677c <= 0) {
            i(qVar);
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        h hVar7 = this.f6693a;
        hVar7.getClass();
        ((w) activity).P(hVar7, new s5.a(this, qVar, 0), new s5.b(this, 0));
    }

    public final boolean k() {
        h hVar = this.f6693a;
        hVar.getClass();
        long j10 = hVar.f8566a;
        q qVar = DownloadWorker.f6738d;
        return qVar != null && qVar.h == j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(java.lang.String r5) {
        /*
            r4 = this;
            h5.h r0 = r4.f6693a
            if (r0 == 0) goto L83
            java.lang.String r0 = "type"
            android.os.Bundle r5 = com.mbridge.msdk.dycreator.baseview.a.f(r0, r5)
            h5.h r0 = r4.f6693a
            r0.getClass()
            java.lang.String r0 = r0.f8595w
            java.lang.String r1 = "packagename"
            r5.putString(r1, r0)
            h5.h r0 = r4.f6693a
            r0.getClass()
            long r0 = r0.f8566a
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            h5.h r0 = r4.f6693a
            r0.getClass()
            long r0 = r0.f8566a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "appId"
            r5.putString(r1, r0)
        L33:
            h5.h r0 = r4.f6693a
            r0.getClass()
            long r0 = r0.A
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L4e
            h5.h r0 = r4.f6693a
            r0.getClass()
            long r0 = r0.A
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "fileId"
            r5.putString(r1, r0)
        L4e:
            h5.h r0 = r4.f6693a
            java.lang.String r1 = "deeplink"
            if (r0 != 0) goto L55
            goto L70
        L55:
            float r2 = com.uptodown.UptodownApp.E
            java.lang.String r0 = r0.f8595w
            h5.l r2 = com.uptodown.UptodownApp.Z
            if (r2 == 0) goto L70
            java.lang.String r2 = r2.a()
            java.lang.String r2 = r0.f.C(r2)
            r3 = 1
            boolean r0 = o7.u.Z(r2, r0, r3)
            if (r0 == 0) goto L70
            r5.putInt(r1, r3)
            goto L74
        L70:
            r0 = 0
            r5.putInt(r1, r0)
        L74:
            t1.c r0 = new t1.c
            androidx.fragment.app.FragmentActivity r1 = r4.requireActivity()
            r2 = 4
            r0.<init>(r1, r2)
            java.lang.String r1 = "warning"
            r0.e(r5, r1)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.l(java.lang.String):void");
    }

    public final void m() {
        if (Build.VERSION.SDK_INT >= 33 || ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            j();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
        }
    }

    public final void n() {
        if (Build.VERSION.SDK_INT < 30) {
            m();
            return;
        }
        if (Environment.isExternalStorageManager()) {
            m();
            return;
        }
        try {
            this.f6703o.launch(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + requireContext().getPackageName())));
        } catch (ActivityNotFoundException unused) {
            m();
        }
    }

    public final void o() {
        long j10;
        h hVar;
        if (getActivity() != null) {
            if (this.f6695c != 1) {
                try {
                    SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new q5.a());
                    try {
                        hVar = this.f6693a;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (hVar == null || hVar.g == null) {
                        j10 = 0;
                    } else {
                        hVar.getClass();
                        String str = hVar.g;
                        str.getClass();
                        j10 = Long.parseLong(str);
                    }
                    String string = requireActivity().getString(com.uptodown.R.string.updates_button_download_app);
                    Context contextRequireContext = requireContext();
                    contextRequireContext.getClass();
                    sparseArrayObjectAdapter.set(1, new Action(1L, string, l1.b.M(contextRequireContext, j10)));
                    sparseArrayObjectAdapter.set(3, new Action(3L, requireActivity().getString(com.uptodown.R.string.dialogo_app_old_versions)));
                    sparseArrayObjectAdapter.set(4, new Action(4L, requireActivity().getString(com.uptodown.R.string.virustotal_safety_report_title)));
                    sparseArrayObjectAdapter.set(5, new Action(5L, requireActivity().getString(com.uptodown.R.string.app_detail_more_info_title)));
                    DetailsOverviewRow detailsOverviewRow = this.h;
                    detailsOverviewRow.getClass();
                    detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.f6695c = 1;
            }
            b bVar = this.f6699k;
            bVar.getClass();
            u5.b bVar2 = bVar.f12259b;
            if (bVar2 != null) {
                bVar2.a(0);
            }
        }
    }

    @Override // androidx.leanback.app.DetailsSupportFragment, androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        BackgroundManager backgroundManager;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Bundle extras = activity.getIntent().getExtras();
            if (extras != null) {
                if (extras.containsKey("appId")) {
                    this.f6694b = extras.getLong("appId");
                }
                if (extras.containsKey("appInfo")) {
                    h hVar = (h) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", h.class) : extras.getParcelable("appInfo"));
                    this.f6693a = hVar;
                    if (hVar != null) {
                        this.f6694b = hVar.f8566a;
                    }
                }
            }
            BackgroundManager backgroundManager2 = BackgroundManager.getInstance(activity);
            this.e = backgroundManager2;
            if (backgroundManager2 != null && !backgroundManager2.isAttached() && (backgroundManager = this.e) != null) {
                backgroundManager.attach(activity.getWindow());
            }
            Drawable drawable = ContextCompat.getDrawable(activity, com.uptodown.R.drawable.tv_default_background);
            BackgroundManager backgroundManager3 = this.e;
            if (backgroundManager3 != null) {
                backgroundManager3.setDrawable(drawable);
            }
            this.f6699k = new b(this.f6702n);
            FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter = new FullWidthDetailsOverviewRowPresenter(this.f6699k, new d());
            fullWidthDetailsOverviewRowPresenter.setBackgroundColor(ContextCompat.getColor(activity, com.uptodown.R.color.background_color));
            fullWidthDetailsOverviewRowPresenter.setInitialState(0);
            FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
            fullWidthDetailsOverviewSharedElementHelper.setSharedElementEnterTransition(activity, "transition_name");
            fullWidthDetailsOverviewRowPresenter.setListener(fullWidthDetailsOverviewSharedElementHelper);
            fullWidthDetailsOverviewRowPresenter.setParticipatingEntranceTransition(false);
            prepareEntranceTransition();
            fullWidthDetailsOverviewRowPresenter.setOnActionClickedListener(new androidx.privacysandbox.ads.adservices.java.internal.a(4, this, activity));
            fullWidthDetailsOverviewRowPresenter.setActionsBackgroundColor(ContextCompat.getColor(activity, com.uptodown.R.color.main_blue));
            ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
            classPresenterSelector.addClassPresenter(DetailsOverviewRow.class, fullWidthDetailsOverviewRowPresenter);
            classPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(classPresenterSelector);
            this.f6696d = arrayObjectAdapter;
            setAdapter(arrayObjectAdapter);
            if (this.f6693a != null) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new q5.a());
                h hVar2 = this.f6693a;
                hVar2.getClass();
                DetailsOverviewRow detailsOverviewRow = new DetailsOverviewRow(hVar2);
                this.h = detailsOverviewRow;
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                h hVar3 = this.f6693a;
                hVar3.getClass();
                if (hVar3.e() != null) {
                    j4.y yVarD = j4.y.d();
                    h hVar4 = this.f6693a;
                    hVar4.getClass();
                    yVarD.e(hVar4.e()).b(new n5(this, 20));
                } else if (getContext() != null) {
                    Drawable drawable2 = ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.feature_tv);
                    BackgroundManager backgroundManager4 = this.e;
                    backgroundManager4.getClass();
                    backgroundManager4.setDrawable(drawable2);
                }
                j4.y yVarD2 = j4.y.d();
                h hVar5 = this.f6693a;
                hVar5.getClass();
                yVarD2.e(hVar5.h()).b(new e(this));
                ArrayObjectAdapter arrayObjectAdapter2 = this.f6696d;
                arrayObjectAdapter2.getClass();
                DetailsOverviewRow detailsOverviewRow2 = this.h;
                detailsOverviewRow2.getClass();
                arrayObjectAdapter2.add(detailsOverviewRow2);
            }
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            new l(contextRequireContext, this.f6694b, new e(this), LifecycleOwnerKt.getLifecycleScope(this));
            d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 831) {
            if ((iArr.length == 0) || iArr[0] != 0) {
                return;
            }
            j();
        }
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f6701m) {
            this.f6701m = false;
        } else {
            u();
        }
    }

    @Override // androidx.leanback.app.DetailsSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (!this.f6700l) {
            y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new s5.d(this, null, 2), 3);
        }
        this.f6700l = false;
    }

    @Override // androidx.leanback.app.DetailsSupportFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        BackgroundManager backgroundManager = this.e;
        backgroundManager.getClass();
        backgroundManager.release();
        super.onStop();
    }

    public final void p(q qVar) {
        if (getActivity() != null) {
            if (this.f6695c != 3) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new q5.a());
                sparseArrayObjectAdapter.set(1, new Action(1L, requireActivity().getString(R.string.cancel)));
                if (this.f6693a != null) {
                    String packageName = requireActivity().getPackageName();
                    h hVar = this.f6693a;
                    hVar.getClass();
                    if (!u.Z(packageName, hVar.f8595w, true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3L, getString(com.uptodown.R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4L, getString(com.uptodown.R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5L, getString(com.uptodown.R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.h;
                detailsOverviewRow.getClass();
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f6695c = 3;
            }
            b bVar = this.f6699k;
            bVar.getClass();
            int i10 = qVar.i();
            u5.b bVar2 = bVar.f12259b;
            if (bVar2 != null) {
                bVar2.a(i10);
            }
        }
    }

    public final void q() {
        if (getActivity() != null) {
            if (this.f6695c != 2) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new q5.a());
                sparseArrayObjectAdapter.set(1, new Action(1L, getString(com.uptodown.R.string.option_button_install)));
                if (getActivity() != null && this.f6693a != null) {
                    String packageName = requireActivity().getPackageName();
                    h hVar = this.f6693a;
                    hVar.getClass();
                    if (!u.Z(packageName, hVar.f8595w, true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3L, getString(com.uptodown.R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4L, getString(com.uptodown.R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5L, getString(com.uptodown.R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.h;
                detailsOverviewRow.getClass();
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f6695c = 2;
            }
            b bVar = this.f6699k;
            bVar.getClass();
            u5.b bVar2 = bVar.f12259b;
            if (bVar2 != null) {
                bVar2.a(0);
            }
        }
    }

    public final void r() {
        if (getActivity() != null) {
            if (this.f6695c != 7) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new q5.a());
                sparseArrayObjectAdapter.set(1, new Action(1L, getString(com.uptodown.R.string.installing)));
                if (getActivity() != null && this.f6693a != null) {
                    String packageName = requireActivity().getPackageName();
                    h hVar = this.f6693a;
                    hVar.getClass();
                    if (!u.Z(packageName, hVar.f8595w, true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3L, getString(com.uptodown.R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4L, getString(com.uptodown.R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5L, getString(com.uptodown.R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.h;
                detailsOverviewRow.getClass();
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f6695c = 7;
            }
            b bVar = this.f6699k;
            bVar.getClass();
            u5.b bVar2 = bVar.f12259b;
            if (bVar2 != null) {
                bVar2.g.setIndeterminate(true);
            }
        }
    }

    public final void s() {
        if (getActivity() == null || this.f6695c == 0) {
            return;
        }
        SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new q5.a());
        if (getActivity() != null && this.f6693a != null) {
            String packageName = requireActivity().getPackageName();
            h hVar = this.f6693a;
            hVar.getClass();
            if (!u.Z(packageName, hVar.f8595w, true)) {
                sparseArrayObjectAdapter.set(1, new Action(1L, getString(com.uptodown.R.string.open)));
                sparseArrayObjectAdapter.set(2, new Action(2L, getString(com.uptodown.R.string.dialogo_app_selected_uninstall)));
                sparseArrayObjectAdapter.set(3, new Action(3L, getString(com.uptodown.R.string.dialogo_app_old_versions)));
            }
        }
        sparseArrayObjectAdapter.set(4, new Action(4L, getString(com.uptodown.R.string.virustotal_safety_report_title)));
        sparseArrayObjectAdapter.set(5, new Action(5L, getString(com.uptodown.R.string.app_detail_more_info_title)));
        DetailsOverviewRow detailsOverviewRow = this.h;
        detailsOverviewRow.getClass();
        detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
        this.f6695c = 0;
    }

    public final void t() {
        long j10;
        h hVar;
        try {
            if (getActivity() != null && this.f6693a != null) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new q5.a());
                try {
                    hVar = this.f6693a;
                    hVar.getClass();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (hVar.g != null) {
                    h hVar2 = this.f6693a;
                    hVar2.getClass();
                    String str = hVar2.g;
                    str.getClass();
                    j10 = Long.parseLong(str);
                } else {
                    j10 = 0;
                }
                String string = getString(com.uptodown.R.string.updates_button_download_app);
                Context contextRequireContext = requireContext();
                contextRequireContext.getClass();
                sparseArrayObjectAdapter.set(1, new Action(1L, string, l1.b.M(contextRequireContext, j10)));
                String packageName = requireActivity().getPackageName();
                h hVar3 = this.f6693a;
                hVar3.getClass();
                if (!u.Z(packageName, hVar3.f8595w, true)) {
                    sparseArrayObjectAdapter.set(2, new Action(2L, getString(com.uptodown.R.string.dialogo_app_selected_uninstall)));
                    sparseArrayObjectAdapter.set(3, new Action(3L, getString(com.uptodown.R.string.dialogo_app_old_versions)));
                }
                sparseArrayObjectAdapter.set(4, new Action(4L, getString(com.uptodown.R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5L, getString(com.uptodown.R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.h;
                detailsOverviewRow.getClass();
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.f6695c = 5;
    }

    public final void u() {
        y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new s5.d(this, null, 5), 3);
    }
}
