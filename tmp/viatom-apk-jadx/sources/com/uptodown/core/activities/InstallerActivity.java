package com.uptodown.core.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b9.p;
import c1.g1;
import c1.w4;
import com.google.android.gms.internal.measurement.j4;
import com.uptodown.R;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.core.view.WrapContentLinearLayoutManager;
import d5.j;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import l4.b;
import l4.f5;
import l5.a;
import o7.m;
import o7.u;
import org.xmlpull.v1.XmlPullParserException;
import p4.a0;
import p4.b0;
import p4.c0;
import p4.d0;
import p4.e0;
import p4.f;
import p4.v;
import p4.w;
import p4.z;
import r7.i0;
import r7.o1;
import r7.y;
import t6.r;
import w6.c;
import x4.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class InstallerActivity extends f {

    /* renamed from: m0, reason: collision with root package name */
    public static final /* synthetic */ int f6676m0 = 0;
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public ImageView G;
    public ImageView H;
    public String I;
    public ArrayList J;
    public String K;
    public Uri L;
    public String M;
    public AlertDialog N;
    public AlertDialog O;
    public ArrayList P;
    public o1 Q;
    public d0 R;
    public a0 S;
    public boolean T;
    public LinearLayout U;
    public boolean V;
    public String W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: j0, reason: collision with root package name */
    public final b f6677j0 = new b(this, 9);

    /* renamed from: k0, reason: collision with root package name */
    public final a0 f6678k0 = new a0(this);
    public final d0 l0 = new d0(this);

    /* renamed from: p, reason: collision with root package name */
    public ProgressBar f6679p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f6680q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f6681r;

    /* renamed from: s, reason: collision with root package name */
    public RelativeLayout f6682s;
    public ImageView t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f6683u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f6684v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f6685w;

    /* renamed from: x, reason: collision with root package name */
    public LinearLayout f6686x;
    public TextView y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f6687z;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r7.y.z(r1, r10, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object E(com.uptodown.core.activities.InstallerActivity r7, android.net.Uri r8, java.lang.String r9, y6.c r10) {
        /*
            boolean r0 = r10 instanceof p4.f0
            if (r0 == 0) goto L13
            r0 = r10
            p4.f0 r0 = (p4.f0) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            p4.f0 r0 = new p4.f0
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f11956d
            int r1 = r0.f
            r2 = 2
            r3 = 1
            r4 = 0
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L3b
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            s6.a.e(r10)
            goto L70
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            return r4
        L31:
            java.lang.String r9 = r0.f11955c
            android.net.Uri r8 = r0.f11954b
            com.uptodown.core.activities.InstallerActivity r7 = r0.f11953a
            s6.a.e(r10)
            goto L58
        L3b:
            s6.a.e(r10)
            y7.e r10 = r7.i0.f12407a
            s7.c r10 = w7.n.f13548a
            a6.n r1 = new a6.n
            r6 = 24
            r1.<init>(r7, r4, r6)
            r0.f11953a = r7
            r0.f11954b = r8
            r0.f11955c = r9
            r0.f = r3
            java.lang.Object r10 = r7.y.z(r1, r10, r0)
            if (r10 != r5) goto L58
            goto L6f
        L58:
            y7.e r10 = r7.i0.f12407a
            y7.d r10 = y7.d.f14116a
            p4.e0 r1 = new p4.e0
            r1.<init>(r9, r7, r8, r4)
            r0.f11953a = r4
            r0.f11954b = r4
            r0.f11955c = r4
            r0.f = r2
            java.lang.Object r7 = r7.y.z(r1, r10, r0)
            if (r7 != r5) goto L70
        L6f:
            return r5
        L70:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.E(com.uptodown.core.activities.InstallerActivity, android.net.Uri, java.lang.String, y6.c):java.lang.Object");
    }

    public final void F() {
        Activity activity = o4.b.g;
        r0.f.n(null);
        ArrayList arrayList = this.J;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            it.getClass();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (file != null && file.exists()) {
                    file.delete();
                }
            }
        }
        finish();
    }

    public final void G() {
        TextView textView;
        InstallerActivity installerActivity;
        String str;
        ImageView imageView;
        setContentView(R.layout.installer_activity);
        try {
            this.T = false;
            Intent intent = getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                this.L = data;
                if (data != null) {
                    this.I = d.b(data, this);
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    if (extras.containsKey("realPath")) {
                        this.K = extras.getString("realPath");
                    }
                    if (extras.containsKey("newFeatures")) {
                        this.W = extras.getString("newFeatures");
                    }
                    if (extras.containsKey("requireUserAction")) {
                        this.X = extras.getBoolean("requireUserAction");
                    }
                    if (extras.containsKey("action")) {
                        this.M = extras.getString("action");
                    }
                    if (extras.containsKey("notificationId")) {
                        int i10 = extras.getInt("notificationId");
                        Object systemService = getSystemService("notification");
                        systemService.getClass();
                        ((NotificationManager) systemService).cancel(i10);
                    }
                    if (extras.containsKey("backgroundInstallation")) {
                        this.Y = extras.getBoolean("backgroundInstallation");
                    }
                }
            }
            this.f6682s = (RelativeLayout) findViewById(R.id.rl_logo_app_detail);
            this.U = (LinearLayout) findViewById(R.id.ll_installer_activity);
            ImageView imageView2 = (ImageView) findViewById(R.id.iv_hide_installer_activity);
            this.H = imageView2;
            imageView2.getClass();
            imageView2.setOnClickListener(new v(this, 5));
            this.G = (ImageView) findViewById(R.id.iv_logo_apk_installer_activity);
            TextView textView2 = (TextView) findViewById(R.id.tv_app_name_installer_activity);
            this.f6685w = textView2;
            if (textView2 != null) {
                textView2.setTypeface(o4.b.f11719r);
            }
            String str2 = this.I;
            int i11 = 6;
            if (str2 != null) {
                TextView textView3 = this.y;
                if (textView3 != null) {
                    textView3.setText(str2);
                }
                String str3 = this.I;
                str3.getClass();
                if (u.X(str3, ".apk", false)) {
                    ImageView imageView3 = this.G;
                    if (imageView3 != null) {
                        imageView3.setImageResource(R.drawable.core_vector_apk);
                    }
                } else {
                    String str4 = this.I;
                    str4.getClass();
                    if (u.X(str4, ".xapk", false) && (imageView = this.G) != null) {
                        imageView.setImageResource(R.drawable.core_vector_xapk);
                    }
                }
            } else {
                String str5 = this.K;
                if (str5 != null && (textView = this.y) != null) {
                    str5.getClass();
                    textView.setText(str5.substring(m.m0("/", str5, 6) + 1));
                }
            }
            this.f6686x = (LinearLayout) findViewById(R.id.ll_info_installer_activity);
            TextView textView4 = (TextView) findViewById(R.id.tv_file_name_label_installer_activity);
            if (textView4 != null) {
                textView4.setTypeface(o4.b.f11720s);
            }
            TextView textView5 = (TextView) findViewById(R.id.tv_file_name_installer_activity);
            this.y = textView5;
            if (textView5 != null) {
                textView5.setTypeface(o4.b.f11719r);
            }
            TextView textView6 = (TextView) findViewById(R.id.tv_size_label_installer_activity);
            if (textView6 != null) {
                textView6.setTypeface(o4.b.f11720s);
            }
            TextView textView7 = (TextView) findViewById(R.id.tv_size_installer_activity);
            this.f6687z = textView7;
            if (textView7 != null) {
                textView7.setTypeface(o4.b.f11719r);
            }
            TextView textView8 = (TextView) findViewById(R.id.tv_version_label_installer_activity);
            if (textView8 != null) {
                textView8.setTypeface(o4.b.f11720s);
            }
            TextView textView9 = (TextView) findViewById(R.id.tv_version_installer_activity);
            this.A = textView9;
            if (textView9 != null) {
                textView9.setTypeface(o4.b.f11719r);
            }
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_installer_activity);
            this.f6679p = progressBar;
            progressBar.getClass();
            progressBar.setInterpolator(new AccelerateDecelerateInterpolator());
            TextView textView10 = (TextView) findViewById(R.id.tv_msg_info_installer_activity);
            this.f6680q = textView10;
            if (textView10 != null) {
                textView10.setTypeface(o4.b.f11720s);
            }
            TextView textView11 = (TextView) findViewById(R.id.tv_msg_installer_activity);
            this.D = textView11;
            if (textView11 != null) {
                textView11.setTypeface(o4.b.f11720s);
            }
            TextView textView12 = (TextView) findViewById(R.id.tv_install_installer_activity);
            this.E = textView12;
            if (textView12 != null) {
                textView12.setTypeface(o4.b.f11719r);
            }
            TextView textView13 = this.E;
            int i12 = 8;
            if (textView13 != null) {
                textView13.setVisibility(8);
            }
            TextView textView14 = this.E;
            if (textView14 != null) {
                textView14.setOnClickListener(new v(this, i11));
            }
            TextView textView15 = (TextView) findViewById(R.id.tv_cancel_installer_activity);
            this.F = textView15;
            if (textView15 != null) {
                textView15.setTypeface(o4.b.f11719r);
            }
            TextView textView16 = this.F;
            if (textView16 != null) {
                textView16.setVisibility(8);
            }
            TextView textView17 = this.F;
            if (textView17 != null) {
                textView17.setOnClickListener(new v(this, 7));
            }
            String str6 = this.W;
            if (str6 == null || str6.length() == 0) {
                installerActivity = this;
            } else {
                TextView textView18 = this.f6680q;
                textView18.getClass();
                textView18.setVisibility(8);
                kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_show_version_new_features);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ll_version_new_features);
                TextView textView19 = (TextView) findViewById(R.id.tv_version_new_features);
                ImageView imageView4 = (ImageView) findViewById(R.id.iv_version_new_features);
                textView19.setTypeface(o4.b.f11719r);
                TextView textView20 = (TextView) findViewById(R.id.tv_version_new_features_content);
                textView20.setTypeface(o4.b.f11720s);
                textView20.setText(this.W);
                textView20.setVisibility(8);
                linearLayout2.setVisibility(0);
                installerActivity = this;
                try {
                    linearLayout.setOnClickListener(new e5.f(uVar, textView19, installerActivity, imageView4, textView20));
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return;
                }
            }
            installerActivity.R = new d0(this);
            installerActivity.S = new a0(this);
            String str7 = installerActivity.M;
            if (str7 == null || !str7.equalsIgnoreCase("delete")) {
                installerActivity.P = L();
                if (installerActivity.L == null || (str = installerActivity.I) == null || !(u.X(str, ".apk", true) || u.X(str, ".xapk", true) || u.X(str, ".apks", true) || u.X(str, ".apkm", true))) {
                    N(installerActivity.K);
                    return;
                }
                Uri uri = installerActivity.L;
                uri.getClass();
                String str8 = installerActivity.I;
                str8.getClass();
                e eVar = i0.f12407a;
                y.q(y.a(y7.d.f14116a), null, null, new e0(this, uri, str8, (c) null), 3);
                return;
            }
            LinearLayout linearLayout3 = installerActivity.U;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            RelativeLayout relativeLayout = installerActivity.f6682s;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            TextView textView21 = installerActivity.D;
            if (textView21 != null) {
                textView21.setVisibility(8);
            }
            ImageView imageView5 = installerActivity.H;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            TextView textView22 = installerActivity.y;
            if (textView22 != null) {
                textView22.setText(getString(R.string.dialog_delete_download_msg, installerActivity.K));
            }
            TextView textView23 = installerActivity.F;
            if (textView23 != null) {
                textView23.setAllCaps(true);
            }
            TextView textView24 = installerActivity.E;
            if (textView24 != null) {
                textView24.setAllCaps(true);
            }
            TextView textView25 = installerActivity.E;
            if (textView25 != null) {
                textView25.setVisibility(0);
            }
            TextView textView26 = installerActivity.E;
            if (textView26 != null) {
                textView26.setText(R.string.option_button_delete);
            }
            TextView textView27 = installerActivity.E;
            if (textView27 != null) {
                textView27.setTag(installerActivity.K);
            }
            TextView textView28 = installerActivity.E;
            if (textView28 != null) {
                textView28.setOnClickListener(new v(this, i12));
            }
            TextView textView29 = installerActivity.F;
            if (textView29 != null) {
                textView29.setVisibility(0);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final void H(File file) {
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        j4 j4Var = new j4(applicationContext, this.R);
        j4Var.f2007a = this.X;
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        e eVar = i0.f12407a;
        y.q(y.a(y7.d.f14116a), null, null, new p4.i0(j4Var, arrayList, (c) null, 16), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I(Activity activity, final File file) {
        final int i10 = 0;
        Object[] objArr = 0;
        w4 w4Var = new w4(activity, 3, false);
        boolean zG = w4Var.g("device_rooted", false);
        boolean zG2 = w4Var.g("system_app", false);
        if (!this.T) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(file);
            if (K(arrayList)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(file);
                P(arrayList2);
                return;
            }
        }
        if (!zG && !zG2) {
            H(file);
            return;
        }
        if (!w4Var.g("user_asked_for_show_permissions", false)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.warning_title));
            builder.setMessage(R.string.msg_dialog_install_auto);
            builder.setCancelable(false);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(this) { // from class: p4.x

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ InstallerActivity f12026b;

                {
                    this.f12026b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    int i12 = i10;
                    File file2 = file;
                    InstallerActivity installerActivity = this.f12026b;
                    switch (i12) {
                        case 0:
                            int i13 = InstallerActivity.f6676m0;
                            w4 w4Var2 = new w4(installerActivity, 3, false);
                            w4Var2.R(true);
                            w4Var2.N("install_apk_as_root_system", true);
                            installerActivity.I(installerActivity, file2);
                            break;
                        default:
                            int i14 = InstallerActivity.f6676m0;
                            w4 w4Var3 = new w4(installerActivity, 3, false);
                            w4Var3.R(true);
                            w4Var3.N("install_apk_as_root_system", false);
                            installerActivity.I(installerActivity, file2);
                            break;
                    }
                }
            });
            final int i11 = 1;
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: p4.x

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ InstallerActivity f12026b;

                {
                    this.f12026b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i112) {
                    int i12 = i11;
                    File file2 = file;
                    InstallerActivity installerActivity = this.f12026b;
                    switch (i12) {
                        case 0:
                            int i13 = InstallerActivity.f6676m0;
                            w4 w4Var2 = new w4(installerActivity, 3, false);
                            w4Var2.R(true);
                            w4Var2.N("install_apk_as_root_system", true);
                            installerActivity.I(installerActivity, file2);
                            break;
                        default:
                            int i14 = InstallerActivity.f6676m0;
                            w4 w4Var3 = new w4(installerActivity, 3, false);
                            w4Var3.R(true);
                            w4Var3.N("install_apk_as_root_system", false);
                            installerActivity.I(installerActivity, file2);
                            break;
                    }
                }
            });
            builder.create().show();
            return;
        }
        if (!w4Var.g("install_apk_as_root_system", false)) {
            H(file);
            return;
        }
        c cVar = null;
        if (w4Var.g("device_rooted", false)) {
            String absolutePath = file.getAbsolutePath();
            absolutePath.getClass();
            y.q(y.a(i0.f12407a), null, null, new p(absolutePath, activity, this.l0, cVar, 27), 3);
            return;
        }
        if (w4Var.g("system_app", false)) {
            t1.c cVar2 = new t1.c(activity, this.f6678k0, 12, objArr == true ? 1 : 0);
            e eVar = i0.f12407a;
            y.q(y.a(y7.d.f14116a), null, null, new p4.i0(cVar2, file, cVar, 17), 3);
        }
    }

    public final void J(Activity activity, ArrayList arrayList) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        SharedPreferences sharedPreferences3;
        activity.getClass();
        try {
            sharedPreferences3 = activity.getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences3.contains("device_rooted") ? sharedPreferences3.getBoolean("device_rooted", false) : false;
        try {
            sharedPreferences2 = activity.getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused2) {
        }
        boolean z10 = sharedPreferences2.contains("system_app") ? sharedPreferences2.getBoolean("system_app", false) : false;
        if (!this.T && K(arrayList)) {
            P(arrayList);
            return;
        }
        if (z9 || z10) {
            try {
                sharedPreferences = activity.getSharedPreferences("CoreSettings", 0);
            } catch (Exception unused3) {
            }
            boolean z11 = sharedPreferences.contains("user_asked_for_show_permissions") ? sharedPreferences.getBoolean("user_asked_for_show_permissions", false) : false;
            if (!z11) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(R.string.warning_title));
                builder.setMessage(R.string.msg_dialog_install_auto);
                builder.setCancelable(false);
                builder.setPositiveButton(android.R.string.ok, new w(this, arrayList, 0));
                builder.setNegativeButton(android.R.string.cancel, new w(this, arrayList, 1));
                builder.create().show();
                return;
            }
        }
        runOnUiThread(new p4.y(this, 1));
        new j4(activity, this.R).k(arrayList, this.X);
    }

    public final boolean K(ArrayList arrayList) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        if (sharedPreferences.contains("warn_installed") ? sharedPreferences.getBoolean("warn_installed", true) : true) {
            try {
                if (arrayList.size() == 1) {
                    String name = ((File) arrayList.get(0)).getName();
                    name.getClass();
                    if (u.X(name, ".apk", false)) {
                        PackageManager packageManager = getPackageManager();
                        packageManager.getClass();
                        String absolutePath = ((File) arrayList.get(0)).getAbsolutePath();
                        absolutePath.getClass();
                        PackageInfo packageInfoD = a.d(packageManager, absolutePath, 0);
                        if (packageInfoD != null) {
                            PackageManager packageManager2 = getPackageManager();
                            packageManager2.getClass();
                            String str = packageInfoD.packageName;
                            str.getClass();
                            if (d.d(a.f(packageManager2, str, 0)) == d.d(packageInfoD)) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public final ArrayList L() throws Resources.NotFoundException {
        String string = getString(R.string.app_name);
        string.getClass();
        ArrayList arrayList = new ArrayList();
        try {
            String[] stringArray = getResources().getStringArray(R.array.messages_info);
            stringArray.getClass();
            for (String str : stringArray) {
                str.getClass();
                if (str.length() > 0) {
                    if (m.d0(str, "%s", false)) {
                        arrayList.add(u.b0(str, "%s", string, false));
                    } else {
                        arrayList.add(str);
                    }
                }
            }
            for (String str2 : getResources().getStringArray(R.array.messages_info_core)) {
                str2.getClass();
                if (str2.length() > 0) {
                    if (m.d0(str2, "%s", false)) {
                        arrayList.add(u.b0(str2, "%s", string, false));
                    } else {
                        arrayList.add(str2);
                    }
                }
            }
            return arrayList;
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public final void M(File file, ArrayList arrayList) throws XmlPullParserException, IOException {
        Window window;
        SharedPreferences sharedPreferences;
        int i10 = 0;
        try {
            sharedPreferences = getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        if (!(sharedPreferences.contains("show_installation_details") ? sharedPreferences.getBoolean("show_installation_details", false) : false)) {
            j jVar = new j(this);
            jVar.l(arrayList);
            J(this, jVar.m());
            return;
        }
        String name = file != null ? file.getName() : null;
        android.app.AlertDialog alertDialog = this.N;
        if (alertDialog != null && alertDialog.isShowing()) {
            android.app.AlertDialog alertDialog2 = this.N;
            alertDialog2.getClass();
            alertDialog2.dismiss();
        }
        j jVar2 = new j(this);
        jVar2.l(arrayList);
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_splits_selector, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_app_name_dialog_splits);
        textView.setTypeface(o4.b.f11719r);
        textView.setText(name);
        ((TextView) viewInflate.findViewById(R.id.tv_label_packagename_dialog_splits)).setTypeface(o4.b.f11719r);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_packagename_dialog_splits);
        textView2.setTypeface(o4.b.f11720s);
        z zVar = (z) jVar2.f7135c;
        textView2.setText(zVar != null ? zVar.f12032c : null);
        ((TextView) viewInflate.findViewById(R.id.tv_label_version_dialog_splits)).setTypeface(o4.b.f11719r);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_version_dialog_splits);
        textView3.setTypeface(o4.b.f11720s);
        ((TextView) viewInflate.findViewById(R.id.tv_label_apps_to_install_dialog_splits)).setTypeface(o4.b.f11719r);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.cb_base_apk_dialog_splits);
        checkBox.setTypeface(o4.b.f11720s);
        if (((z) jVar2.f7135c) != null) {
            StringBuilder sb = new StringBuilder();
            z zVar2 = (z) jVar2.f7135c;
            zVar2.getClass();
            sb.append(zVar2.f12033d);
            sb.append(" (");
            z zVar3 = (z) jVar2.f7135c;
            zVar3.getClass();
            sb.append(zVar3.e);
            sb.append(')');
            textView3.setText(sb.toString());
            z zVar4 = (z) jVar2.f7135c;
            zVar4.getClass();
            checkBox.setText(zVar4.f12030a.getName());
        }
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_label_arquitecture_dialog_splits);
        textView4.setTypeface(o4.b.f11719r);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_device_supported_abis_dialog_splits);
        textView5.setTypeface(o4.b.f11720s);
        View viewFindViewById = viewInflate.findViewById(R.id.rv_arquitecture_dialog_splits);
        viewFindViewById.getClass();
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        int i11 = 1;
        if (((ArrayList) jVar2.f7136d).size() > 0) {
            recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView.addItemDecoration(new x4.j((int) getResources().getDimension(R.dimen.margin_generic_item_recyclerview)));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(new r4.c((ArrayList) jVar2.f7136d, new b0(jVar2, i10)));
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr == null || strArr.length == 0) {
                textView5.setVisibility(8);
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = strArr.length;
                for (int i12 = 0; i12 < length; i12++) {
                    if (i12 == 0) {
                        sb2 = new StringBuilder("(" + strArr[i12]);
                    } else {
                        sb2.append(",");
                        sb2.append(strArr[i12]);
                    }
                }
                sb2.append(")");
                String string = getString(R.string.device_supported_abis_split_selector);
                string.getClass();
                textView5.setText(String.format(string, Arrays.copyOf(new Object[]{sb2.toString()}, 1)));
            }
        } else {
            recyclerView.setVisibility(8);
            textView4.setVisibility(8);
            textView5.setVisibility(8);
            viewInflate.findViewById(R.id.separator_abis_split_selector).setVisibility(8);
        }
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_label_dpi_dialog_splits);
        textView6.setTypeface(o4.b.f11719r);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.tv_device_supported_pdis_dialog_splits);
        textView7.setTypeface(o4.b.f11720s);
        View viewFindViewById2 = viewInflate.findViewById(R.id.rv_dpi_dialog_splits);
        viewFindViewById2.getClass();
        RecyclerView recyclerView2 = (RecyclerView) viewFindViewById2;
        if (((ArrayList) jVar2.e).size() > 0) {
            recyclerView2.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView2.addItemDecoration(new x4.j((int) getResources().getDimension(R.dimen.margin_generic_item_recyclerview)));
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
            recyclerView2.setAdapter(new r4.c((ArrayList) jVar2.e, new c0(jVar2, i10)));
            String string2 = getString(R.string.device_supported_dpis_split_selector);
            string2.getClass();
            textView7.setText(String.format(string2, Arrays.copyOf(new Object[]{getString(R.string.dpi_device)}, 1)));
        } else {
            recyclerView2.setVisibility(8);
            textView6.setVisibility(8);
            textView7.setVisibility(8);
            viewInflate.findViewById(R.id.separator_dpis_split_selector).setVisibility(8);
        }
        TextView textView8 = (TextView) viewInflate.findViewById(R.id.tv_label_lang_dialog_splits);
        textView8.setTypeface(o4.b.f11719r);
        TextView textView9 = (TextView) viewInflate.findViewById(R.id.tv_device_lang_dialog_splits);
        textView9.setTypeface(o4.b.f11720s);
        View viewFindViewById3 = viewInflate.findViewById(R.id.rv_lang_dialog_splits);
        viewFindViewById3.getClass();
        RecyclerView recyclerView3 = (RecyclerView) viewFindViewById3;
        if (((ArrayList) jVar2.f).size() > 0) {
            recyclerView3.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView3.addItemDecoration(new x4.j((int) getResources().getDimension(R.dimen.margin_generic_item_recyclerview)));
            recyclerView3.setItemAnimator(new DefaultItemAnimator());
            recyclerView3.setAdapter(new r4.c((ArrayList) jVar2.f, new c0(jVar2, i11)));
            textView9.setText(getString(R.string.device_lang_split_selector));
        } else {
            recyclerView3.setVisibility(8);
            textView8.setVisibility(8);
            textView9.setVisibility(8);
            viewInflate.findViewById(R.id.separator_lang_split_selector).setVisibility(8);
        }
        TextView textView10 = (TextView) viewInflate.findViewById(R.id.tv_label_features_dialog_splits);
        textView10.setTypeface(o4.b.f11719r);
        TextView textView11 = (TextView) viewInflate.findViewById(R.id.tv_device_features_dialog_splits);
        textView11.setTypeface(o4.b.f11720s);
        View viewFindViewById4 = viewInflate.findViewById(R.id.rv_features_dialog_splits);
        viewFindViewById4.getClass();
        RecyclerView recyclerView4 = (RecyclerView) viewFindViewById4;
        if (((ArrayList) jVar2.g).size() > 0) {
            recyclerView4.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView4.addItemDecoration(new x4.j((int) getResources().getDimension(R.dimen.margin_generic_item_recyclerview)));
            recyclerView4.setItemAnimator(new DefaultItemAnimator());
            recyclerView4.setAdapter(new r4.c((ArrayList) jVar2.g, new b0(jVar2, i11)));
        } else {
            recyclerView4.setVisibility(8);
            textView10.setVisibility(8);
            textView11.setVisibility(8);
            viewInflate.findViewById(R.id.separator_features_split_selector).setVisibility(8);
        }
        TextView textView12 = (TextView) viewInflate.findViewById(R.id.tv_install_dialog_splits);
        textView12.setTypeface(o4.b.f11719r);
        textView12.setOnClickListener(new f5(18, this, jVar2));
        TextView textView13 = (TextView) viewInflate.findViewById(R.id.tv_cancel_dialog_splits);
        textView13.setTypeface(o4.b.f11719r);
        textView13.setOnClickListener(new v(this, 2));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate);
        builder.setCancelable(true);
        this.N = builder.create();
        if (isFinishing()) {
            return;
        }
        android.app.AlertDialog alertDialog3 = this.N;
        if (alertDialog3 != null && (window = alertDialog3.getWindow()) != null) {
            a3.a.A(window, 0);
        }
        android.app.AlertDialog alertDialog4 = this.N;
        if (alertDialog4 != null) {
            alertDialog4.show();
        }
    }

    public final void N(String str) throws XmlPullParserException, IOException {
        if (str == null || !new File(str).exists()) {
            String string = getString(R.string.installable_files_not_found);
            string.getClass();
            C(string);
            finish();
            return;
        }
        if (new File(str).isDirectory()) {
            ArrayList arrayList = new ArrayList();
            File[] fileArrListFiles = new File(str).listFiles();
            if (fileArrListFiles != null) {
                r.Y(arrayList, fileArrListFiles);
                M(null, arrayList);
                return;
            }
            return;
        }
        if (u.X(str, ".xapk", true) || u.X(str, ".apks", true) || u.X(str, ".apkm", true)) {
            a0 a0Var = this.S;
            a0Var.getClass();
            new g1(this, str, a0Var, o());
        } else {
            if (u.X(str, ".apk", false)) {
                I(this, new File(str));
                return;
            }
            String string2 = getString(R.string.installable_files_not_found);
            string2.getClass();
            C(string2);
            finish();
        }
    }

    public final void O(String str) {
        str.getClass();
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(str);
        }
        ProgressBar progressBar = this.f6679p;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        getWindow().clearFlags(128);
        o1 o1Var = this.Q;
        if (o1Var != null) {
            o1Var.a(null);
        }
        TextView textView2 = this.f6680q;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.F;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.F;
        if (textView4 != null) {
            textView4.setOnClickListener(new v(this, 4));
        }
        C(str);
    }

    public final void P(ArrayList arrayList) {
        android.app.AlertDialog alertDialog;
        android.app.AlertDialog alertDialog2 = this.O;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            android.app.AlertDialog alertDialog3 = this.O;
            alertDialog3.getClass();
            alertDialog3.dismiss();
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_installed_version, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.tv_msg_installed_version)).setTypeface(o4.b.f11720s);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.cb_not_again_installed_version);
        checkBox.setTypeface(o4.b.f11720s);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_install);
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new e5.j(this, checkBox, arrayList, 13));
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new v(this, 1));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate);
        builder.setCancelable(false);
        android.app.AlertDialog alertDialogCreate = builder.create();
        this.O = alertDialogCreate;
        Window window = alertDialogCreate != null ? alertDialogCreate.getWindow() : null;
        window.getClass();
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (isFinishing() || (alertDialog = this.O) == null) {
            return;
        }
        alertDialog.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0075, code lost:
    
        if (r7.y.z(r4, r12, r0) == r10) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q(int r12, y6.c r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof p4.h0
            if (r0 == 0) goto L13
            r0 = r13
            p4.h0 r0 = (p4.h0) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            p4.h0 r0 = new p4.h0
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.f11966d
            int r1 = r0.f
            r2 = 2
            r3 = 1
            r8 = 0
            x6.a r10 = x6.a.f13718a
            if (r1 == 0) goto L3f
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2b
            s6.a.e(r13)
            goto L78
        L2b:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r12)
            r12 = 0
            return r12
        L32:
            int r12 = r0.f11965c
            kotlin.jvm.internal.x r1 = r0.f11964b
            com.uptodown.core.activities.InstallerActivity r3 = r0.f11963a
            s6.a.e(r13)
            r5 = r3
        L3c:
            r6 = r12
            r7 = r1
            goto L61
        L3f:
            s6.a.e(r13)
            kotlin.jvm.internal.x r1 = new kotlin.jvm.internal.x
            r1.<init>()
            y7.e r13 = r7.i0.f12407a
            y7.d r13 = y7.d.f14116a
            p4.g0 r4 = new p4.g0
            r4.<init>(r11, r1, r8, r3)
            r0.f11963a = r11
            r0.f11964b = r1
            r0.f11965c = r12
            r0.f = r3
            java.lang.Object r13 = r7.y.z(r4, r13, r0)
            if (r13 != r10) goto L5f
            goto L77
        L5f:
            r5 = r11
            goto L3c
        L61:
            y7.e r12 = r7.i0.f12407a
            s7.c r12 = w7.n.f13548a
            p4.i0 r4 = new p4.i0
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f11963a = r8
            r0.f11964b = r8
            r0.f = r2
            java.lang.Object r12 = r7.y.z(r4, r12, r0)
            if (r12 != r10) goto L78
        L77:
            return r10
        L78:
            s6.w r12 = s6.w.f12711a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.Q(int, y6.c):java.lang.Object");
    }

    @Override // p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        TextView textView;
        super.onCreate(bundle);
        Activity activity = o4.b.g;
        if (r0.f.A() == null && o4.b.f11718q == null) {
            G();
        } else {
            setContentView(R.layout.installer_activity_dialog);
            this.V = true;
            Application application = getApplication();
            application.getClass();
            ((o4.b) application).f11726a.send(224, null);
            TextView textView2 = (TextView) findViewById(R.id.tv_header_ready_to_install);
            this.f6681r = textView2;
            textView2.getClass();
            textView2.setTypeface(o4.b.f11719r);
            this.t = (ImageView) findViewById(R.id.iv_app_to_install);
            TextView textView3 = (TextView) findViewById(R.id.tv_app_to_install_name);
            this.f6683u = textView3;
            textView3.getClass();
            textView3.setTypeface(o4.b.f11719r);
            TextView textView4 = (TextView) findViewById(R.id.tv_app_to_install_filename);
            this.f6684v = textView4;
            textView4.getClass();
            textView4.setTypeface(o4.b.f11720s);
            TextView textView5 = (TextView) findViewById(R.id.tv_installation_in_progress_title);
            this.B = textView5;
            textView5.getClass();
            textView5.setTypeface(o4.b.f11720s);
            TextView textView6 = (TextView) findViewById(R.id.tv_cancel_installer_activity);
            this.F = textView6;
            textView6.getClass();
            textView6.setTypeface(o4.b.f11719r);
            TextView textView7 = this.F;
            textView7.getClass();
            textView7.setOnClickListener(new v(this, 0));
            TextView textView8 = (TextView) findViewById(R.id.tv_install_installer_activity);
            this.E = textView8;
            textView8.getClass();
            textView8.setTypeface(o4.b.f11719r);
            TextView textView9 = this.E;
            textView9.getClass();
            textView9.setOnClickListener(new v(this, 3));
            this.f6679p = (ProgressBar) findViewById(R.id.pb_installer_activity);
            TextView textView10 = (TextView) findViewById(R.id.tv_installation_in_progress_filename);
            this.C = textView10;
            textView10.getClass();
            textView10.setTypeface(o4.b.f11720s);
            u4.a aVarA = r0.f.A();
            String str = aVarA != null ? aVarA.f12893c : null;
            if (str != null && (textView = this.C) != null) {
                textView.setText(str);
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.f6677j0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        o1 o1Var = this.Q;
        if (o1Var != null) {
            o1Var.a(null);
        }
        getWindow().clearFlags(128);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        LinearLayout linearLayout;
        super.onResume();
        Activity activity = o4.b.g;
        if (r0.f.A() == null && (linearLayout = this.U) != null && linearLayout.getVisibility() == 0 && this.M == null) {
            finish();
        }
    }

    @Override // p4.f
    public final void y() {
        a0 a0Var;
        if (!o() || new File("/Android/obb").canRead() || (a0Var = this.S) == null) {
            return;
        }
        a0Var.l();
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
    public final void u() {
    }

    @Override // p4.f
    public final void w() {
    }
}
