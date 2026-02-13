package l4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.nsd.NsdServiceInfo;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import com.uptodown.workers.GenerateQueueWorker;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a4 extends w {
    public static final /* synthetic */ int T = 0;
    public ProgressBar H;
    public TextView I;
    public TextView J;
    public boolean K;
    public boolean L;
    public r7.o1 M;
    public boolean O;
    public d5.d0 P;
    public File Q;
    public boolean R;
    public ArrayList N = new ArrayList();
    public final t3 S = new t3(this);

    public static final void n0(a4 a4Var, String str, String str2) {
        AlertDialog alertDialog = a4Var.f10935w;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        View viewInflate = a4Var.getLayoutInflater().inflate(R.layout.dialog_backup_result, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.tv_title_dialog_backup_result)).setTypeface(o4.b.f11719r);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_msg_dialog_backup_result);
        textView.setTypeface(o4.b.f11720s);
        textView.setText(str);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_ok_dialog_backup_result);
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new r3(a4Var, 3));
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_browse_dialog_backup_result);
        textView3.setTypeface(o4.b.f11719r);
        textView3.setOnClickListener(new r3(a4Var, 4));
        if (str2 != null && str2.length() != 0) {
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_share_dialog_backup_result);
            textView4.setTypeface(o4.b.f11719r);
            textView4.setOnClickListener(new b5.a(28, a4Var, str2));
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(a4Var);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        a4Var.f10935w = alertDialogCreate;
        alertDialogCreate.getClass();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            a3.a.A(window, 0);
        }
        AlertDialog alertDialog2 = a4Var.f10935w;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    public static void q0(Toolbar toolbar, boolean z9) {
        if (toolbar.getMenu() != null) {
            Menu menu = toolbar.getMenu();
            menu.getClass();
            menu.findItem(R.id.action_show_system_services).setEnabled(z9);
        }
    }

    public static void r0(h5.f fVar) {
        fVar.getClass();
        float f = UptodownApp.E;
        String str = fVar.f8526c;
        str.getClass();
        if (k4.c.l(str)) {
            return;
        }
        k4.c.c(fVar);
    }

    public final void A0(String str, boolean z9) {
        ArrayList arrayList;
        float f = UptodownApp.E;
        if (k4.c.o(this, "GenerateQueueWorker") || k4.c.o(this, "downloadApkWorker") || k4.c.o(this, "DownloadUpdatesWorker")) {
            if (k4.c.o(this, "downloadApkWorker")) {
                String string = getString(R.string.error_download_in_progress_wait);
                string.getClass();
                N(string);
                return;
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!z9 && str != null && str.length() != 0) {
            t3.h hVar = v5.g.f13148u;
            Context applicationContext = getApplicationContext();
            applicationContext.getClass();
            v5.g gVarL = hVar.l(applicationContext);
            gVarL.a();
            h5.y0 y0VarM = gVarL.M(str);
            gVarL.b();
            if (y0VarM != null && (arrayList = y0VarM.f8799j) != null && !arrayList.isEmpty()) {
                ArrayList arrayList3 = y0VarM.f8799j;
                arrayList3.getClass();
                arrayList2 = h5.p.c(arrayList3, this);
            }
        }
        if (!arrayList2.isEmpty()) {
            str.getClass();
            o0(str, arrayList2, z9);
        } else {
            this.L = true;
            if (k4.c.o(this, "GenerateQueueWorker")) {
                return;
            }
            WorkManager.Companion.getInstance(this).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", z9).putString("packagename", str).build()).build());
        }
    }

    @Override // p4.m0
    public final void H() {
        File file;
        v4.f fVar = o4.b.t;
        fVar.getClass();
        if (fVar.f == null || (file = this.Q) == null || file.isDirectory()) {
            return;
        }
        new UptodownApp();
        File file2 = this.Q;
        file2.getClass();
        o4.b.c(file2);
    }

    public void o0(String str, ArrayList arrayList, boolean z9) {
        str.getClass();
        String string = getString(R.string.msg_warning_incompatible_required_features_to_install);
        string.getClass();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new w3(this, str, string, arrayList, z9, null, 0), 2);
    }

    public final void p0(final h5.f fVar, final int i10) throws Resources.NotFoundException {
        long j10;
        Window window;
        Socket socket;
        NsdServiceInfo nsdServiceInfo;
        String str;
        if (isFinishing()) {
            return;
        }
        int i11 = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.myappsupdates_options_dialog, (ViewGroup) null, false);
        int i12 = R.id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_icon);
        if (imageView != null) {
            i12 = R.id.rl_exclude;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_exclude);
            if (relativeLayout != null) {
                i12 = R.id.rl_header;
                if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_header)) != null) {
                    i12 = R.id.sc_exclude;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewInflate, R.id.sc_exclude);
                    if (switchCompat != null) {
                        i12 = R.id.tv_app_installed_details;
                        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_installed_details);
                        if (textView != null) {
                            i12 = R.id.tv_app_name;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name);
                            if (textView2 != null) {
                                i12 = R.id.tv_backup;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_backup);
                                if (textView3 != null) {
                                    i12 = R.id.tv_check_updates;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_check_updates);
                                    if (textView4 != null) {
                                        i12 = R.id.tv_exclude;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_exclude);
                                        if (textView5 != null) {
                                            i12 = R.id.tv_ignore_version;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ignore_version);
                                            if (textView6 != null) {
                                                i12 = R.id.tv_nsd_send;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_nsd_send);
                                                if (textView7 != null) {
                                                    i12 = R.id.tv_old_versions;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_old_versions);
                                                    if (textView8 != null) {
                                                        i12 = R.id.tv_open;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_open);
                                                        if (textView9 != null) {
                                                            i12 = R.id.tv_see_on_uptodown;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_see_on_uptodown);
                                                            if (textView10 != null) {
                                                                i12 = R.id.tv_share;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_share);
                                                                if (textView11 != null) {
                                                                    i12 = R.id.tv_title_app_general_management;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_app_general_management);
                                                                    if (textView12 != null) {
                                                                        i12 = R.id.tv_title_info_and_share;
                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_info_and_share);
                                                                        if (textView13 != null) {
                                                                            i12 = R.id.tv_title_security;
                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_security);
                                                                            if (textView14 != null) {
                                                                                i12 = R.id.tv_title_update_config;
                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_update_config);
                                                                                if (textView15 != null) {
                                                                                    i12 = R.id.tv_uninstall;
                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_uninstall);
                                                                                    if (textView16 != null) {
                                                                                        i12 = R.id.tv_update;
                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_update);
                                                                                        if (textView17 != null) {
                                                                                            i12 = R.id.tv_version_changelog_details;
                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_version_changelog_details);
                                                                                            if (textView18 != null) {
                                                                                                i12 = R.id.tv_version_details;
                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_version_details);
                                                                                                if (textView19 != null) {
                                                                                                    i12 = R.id.tv_virustotal_report;
                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_virustotal_report);
                                                                                                    if (textView20 != null) {
                                                                                                        i12 = R.id.v_outside_header;
                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.v_outside_header);
                                                                                                        if (viewFindChildViewById != null) {
                                                                                                            this.P = new d5.d0((RelativeLayout) viewInflate, imageView, relativeLayout, switchCompat, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, viewFindChildViewById);
                                                                                                            textView2.setTypeface(o4.b.f11719r);
                                                                                                            d5.d0 d0Var = this.P;
                                                                                                            if (d0Var == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var.f.setText(fVar.f8525b);
                                                                                                            d5.d0 d0Var2 = this.P;
                                                                                                            if (d0Var2 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var2.f6977s.setTypeface(o4.b.f11719r);
                                                                                                            d5.d0 d0Var3 = this.P;
                                                                                                            if (d0Var3 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var3.f6976r.setTypeface(o4.b.f11719r);
                                                                                                            d5.d0 d0Var4 = this.P;
                                                                                                            if (d0Var4 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var4.f6975q.setTypeface(o4.b.f11719r);
                                                                                                            d5.d0 d0Var5 = this.P;
                                                                                                            if (d0Var5 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var5.f6974p.setTypeface(o4.b.f11719r);
                                                                                                            ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
                                                                                                            Drawable drawableC = v5.n.c(this, fVar.f8526c);
                                                                                                            d5.d0 d0Var6 = this.P;
                                                                                                            if (d0Var6 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var6.f6964b.setImageDrawable(drawableC);
                                                                                                            String str2 = fVar.f8526c;
                                                                                                            int i13 = 8;
                                                                                                            if (str2 == null || str2.length() == 0 || (str = fVar.f8531l) == null || str.length() == 0 || fVar.f8541w == 0) {
                                                                                                                d5.d0 d0Var7 = this.P;
                                                                                                                if (d0Var7 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var7.f6972n.setVisibility(8);
                                                                                                            } else {
                                                                                                                d5.d0 d0Var8 = this.P;
                                                                                                                if (d0Var8 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var8.f6972n.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var9 = this.P;
                                                                                                                if (d0Var9 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var9.f6972n.setOnClickListener(new p3(this, fVar, i11));
                                                                                                            }
                                                                                                            t3.h hVar = v5.g.f13148u;
                                                                                                            Context applicationContext = getApplicationContext();
                                                                                                            applicationContext.getClass();
                                                                                                            final v5.g gVarL = hVar.l(applicationContext);
                                                                                                            gVarL.a();
                                                                                                            String str3 = fVar.f8526c;
                                                                                                            str3.getClass();
                                                                                                            h5.y0 y0VarM = gVarL.M(str3);
                                                                                                            gVarL.b();
                                                                                                            h5.q qVar = y0VarM != null ? y0VarM.f8798i : null;
                                                                                                            d5.d0 d0Var10 = this.P;
                                                                                                            int i14 = 1;
                                                                                                            if (y0VarM != null) {
                                                                                                                if (d0Var10 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var10.f6978u.setTypeface(o4.b.f11720s);
                                                                                                                float f = UptodownApp.E;
                                                                                                                if (k4.c.k(y0VarM)) {
                                                                                                                    d5.d0 d0Var11 = this.P;
                                                                                                                    if (d0Var11 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var11.f6978u.setText(getString(R.string.action_cancel_download));
                                                                                                                } else if (qVar != null && qVar.c()) {
                                                                                                                    d5.d0 d0Var12 = this.P;
                                                                                                                    if (d0Var12 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var12.f6978u.setText(getString(R.string.notification_msg_update_uptodown));
                                                                                                                } else if (qVar == null || qVar.i() <= 0) {
                                                                                                                    d5.d0 d0Var13 = this.P;
                                                                                                                    if (d0Var13 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var13.f6978u.setText(getString(R.string.action_update));
                                                                                                                } else {
                                                                                                                    d5.d0 d0Var14 = this.P;
                                                                                                                    if (d0Var14 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var14.f6978u.setText(getString(R.string.updates_button_resume));
                                                                                                                }
                                                                                                                d5.d0 d0Var15 = this.P;
                                                                                                                if (d0Var15 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var15.f6978u.setOnClickListener(new p3(this, fVar, i14));
                                                                                                            } else {
                                                                                                                if (d0Var10 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var10.f6978u.setVisibility(8);
                                                                                                            }
                                                                                                            boolean Z = o7.u.Z(getPackageName(), fVar.f8526c, true);
                                                                                                            d5.d0 d0Var16 = this.P;
                                                                                                            int i15 = 2;
                                                                                                            if (Z) {
                                                                                                                if (d0Var16 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var16.f6971m.setVisibility(8);
                                                                                                                d5.d0 d0Var17 = this.P;
                                                                                                                if (d0Var17 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var17.t.setVisibility(8);
                                                                                                            } else {
                                                                                                                if (d0Var16 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var16.f6971m.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var18 = this.P;
                                                                                                                if (d0Var18 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var18.f6971m.setOnClickListener(new p3(fVar, this, i15));
                                                                                                                d5.d0 d0Var19 = this.P;
                                                                                                                if (d0Var19 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var19.t.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var20 = this.P;
                                                                                                                if (d0Var20 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var20.t.setOnClickListener(new p3(fVar, this, 3));
                                                                                                            }
                                                                                                            float f10 = UptodownApp.E;
                                                                                                            String str4 = fVar.f;
                                                                                                            if (str4 == null || str4.length() == 0) {
                                                                                                                d5.d0 d0Var21 = this.P;
                                                                                                                if (d0Var21 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var21.f6973o.setVisibility(8);
                                                                                                            } else {
                                                                                                                d5.d0 d0Var22 = this.P;
                                                                                                                if (d0Var22 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var22.f6973o.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var23 = this.P;
                                                                                                                if (d0Var23 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var23.f6973o.setOnClickListener(new p3(this, fVar, 4));
                                                                                                            }
                                                                                                            d5.d0 d0Var24 = this.P;
                                                                                                            if (d0Var24 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var24.f6969k.setTypeface(o4.b.f11720s);
                                                                                                            d5.d0 d0Var25 = this.P;
                                                                                                            if (d0Var25 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            int i16 = 5;
                                                                                                            d0Var25.f6969k.setOnClickListener(new p3(this, fVar, i16));
                                                                                                            v4.a aVar = o4.b.f11721u;
                                                                                                            int i17 = 6;
                                                                                                            if (aVar == null || (socket = aVar.f13128d) == null || socket.isClosed()) {
                                                                                                                j10 = 0;
                                                                                                            } else {
                                                                                                                v4.f fVar2 = o4.b.t;
                                                                                                                String serviceName = (fVar2 == null || (nsdServiceInfo = fVar2.f) == null) ? null : nsdServiceInfo.getServiceName();
                                                                                                                d5.d0 d0Var26 = this.P;
                                                                                                                if (serviceName == null) {
                                                                                                                    j10 = 0;
                                                                                                                    if (d0Var26 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var26.f6969k.setVisibility(8);
                                                                                                                } else {
                                                                                                                    if (d0Var26 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    j10 = 0;
                                                                                                                    d0Var26.f6969k.setText(String.format("%s%s", Arrays.copyOf(new Object[]{getString(R.string.nsd_option_send_to), serviceName.substring(0, o7.m.k0(serviceName, "_d:_", 0, false, 6))}, 2)));
                                                                                                                }
                                                                                                            }
                                                                                                            if (fVar.f8542x != 1 || fVar.f8541w == j10) {
                                                                                                                d5.d0 d0Var27 = this.P;
                                                                                                                if (d0Var27 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var27.f6970l.setVisibility(8);
                                                                                                            } else {
                                                                                                                d5.d0 d0Var28 = this.P;
                                                                                                                if (d0Var28 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var28.f6970l.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var29 = this.P;
                                                                                                                if (d0Var29 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var29.f6970l.setOnClickListener(new p3(this, fVar, i17));
                                                                                                            }
                                                                                                            d5.d0 d0Var30 = this.P;
                                                                                                            if (d0Var30 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var30.f6967i.setTypeface(o4.b.f11720s);
                                                                                                            d5.d0 d0Var31 = this.P;
                                                                                                            if (d0Var31 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var31.f6966d.setChecked(fVar.f8532m == 0);
                                                                                                            d5.d0 d0Var32 = this.P;
                                                                                                            if (d0Var32 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            final int i18 = 0;
                                                                                                            d0Var32.f6965c.setOnClickListener(new View.OnClickListener(this) { // from class: l4.q3

                                                                                                                /* renamed from: b, reason: collision with root package name */
                                                                                                                public final /* synthetic */ a4 f10754b;

                                                                                                                {
                                                                                                                    this.f10754b = this;
                                                                                                                }

                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                public final void onClick(View view) {
                                                                                                                    switch (i18) {
                                                                                                                        case 0:
                                                                                                                            this.f10754b.s0(gVarL, fVar, i10);
                                                                                                                            break;
                                                                                                                        default:
                                                                                                                            this.f10754b.s0(gVarL, fVar, i10);
                                                                                                                            break;
                                                                                                                    }
                                                                                                                }
                                                                                                            });
                                                                                                            d5.d0 d0Var33 = this.P;
                                                                                                            if (d0Var33 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            final int i19 = 1;
                                                                                                            d0Var33.f6966d.setOnClickListener(new View.OnClickListener(this) { // from class: l4.q3

                                                                                                                /* renamed from: b, reason: collision with root package name */
                                                                                                                public final /* synthetic */ a4 f10754b;

                                                                                                                {
                                                                                                                    this.f10754b = this;
                                                                                                                }

                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                public final void onClick(View view) {
                                                                                                                    switch (i19) {
                                                                                                                        case 0:
                                                                                                                            this.f10754b.s0(gVarL, fVar, i10);
                                                                                                                            break;
                                                                                                                        default:
                                                                                                                            this.f10754b.s0(gVarL, fVar, i10);
                                                                                                                            break;
                                                                                                                    }
                                                                                                                }
                                                                                                            });
                                                                                                            if (y0VarM != null && fVar.g == h5.e.f8506a && fVar.f8532m == 0) {
                                                                                                                d5.d0 d0Var34 = this.P;
                                                                                                                if (d0Var34 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var34.h.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var35 = this.P;
                                                                                                                if (d0Var35 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var35.h.setOnClickListener(new s3(y0VarM, this));
                                                                                                                d5.d0 d0Var36 = this.P;
                                                                                                                if (d0Var36 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var36.f6980w.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var37 = this.P;
                                                                                                                if (d0Var37 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var37.f6980w.setOnClickListener(new e5.j(this, fVar, y0VarM, i16));
                                                                                                                String str5 = y0VarM.h;
                                                                                                                if (str5 == null || str5.length() == 0) {
                                                                                                                    d5.d0 d0Var38 = this.P;
                                                                                                                    if (d0Var38 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var38.f6979v.setVisibility(8);
                                                                                                                } else {
                                                                                                                    d5.d0 d0Var39 = this.P;
                                                                                                                    if (d0Var39 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var39.f6979v.setTypeface(o4.b.f11720s);
                                                                                                                    d5.d0 d0Var40 = this.P;
                                                                                                                    if (d0Var40 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var40.f6979v.setOnClickListener(new s3(this, y0VarM));
                                                                                                                }
                                                                                                            } else {
                                                                                                                d5.d0 d0Var41 = this.P;
                                                                                                                if (d0Var41 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var41.h.setVisibility(8);
                                                                                                                d5.d0 d0Var42 = this.P;
                                                                                                                if (d0Var42 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var42.f6980w.setVisibility(8);
                                                                                                                d5.d0 d0Var43 = this.P;
                                                                                                                if (d0Var43 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var43.f6979v.setVisibility(8);
                                                                                                            }
                                                                                                            d5.d0 d0Var44 = this.P;
                                                                                                            if (y0VarM != null) {
                                                                                                                if (d0Var44 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var44.f6968j.setVisibility(0);
                                                                                                                d5.d0 d0Var45 = this.P;
                                                                                                                if (d0Var45 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var45.f6968j.setTypeface(o4.b.f11720s);
                                                                                                                boolean zB = y0VarM.b();
                                                                                                                d5.d0 d0Var46 = this.P;
                                                                                                                if (zB) {
                                                                                                                    if (d0Var46 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var46.f6968j.setText(R.string.reactivate_skipped_update);
                                                                                                                } else {
                                                                                                                    if (d0Var46 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    d0Var46.f6968j.setText(R.string.skip_update);
                                                                                                                }
                                                                                                                d5.d0 d0Var47 = this.P;
                                                                                                                if (d0Var47 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var47.f6968j.setOnClickListener(new e5.j(this, y0VarM, gVarL, i10));
                                                                                                            } else {
                                                                                                                if (d0Var44 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var44.f6968j.setVisibility(8);
                                                                                                            }
                                                                                                            if (fVar.f8526c != null) {
                                                                                                                d5.d0 d0Var48 = this.P;
                                                                                                                if (d0Var48 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var48.g.setVisibility(0);
                                                                                                                d5.d0 d0Var49 = this.P;
                                                                                                                if (d0Var49 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var49.g.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var50 = this.P;
                                                                                                                if (d0Var50 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var50.g.setOnClickListener(new p3(this, fVar, 7));
                                                                                                            }
                                                                                                            if (fVar.f8538s != null) {
                                                                                                                d5.d0 d0Var51 = this.P;
                                                                                                                if (d0Var51 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var51.f6981x.setVisibility(0);
                                                                                                                d5.d0 d0Var52 = this.P;
                                                                                                                if (d0Var52 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var52.f6981x.setTypeface(o4.b.f11720s);
                                                                                                                d5.d0 d0Var53 = this.P;
                                                                                                                if (d0Var53 == null) {
                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                d0Var53.f6981x.setOnClickListener(new p3(this, fVar, i13));
                                                                                                            }
                                                                                                            d5.d0 d0Var54 = this.P;
                                                                                                            if (d0Var54 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var54.e.setTypeface(o4.b.f11720s);
                                                                                                            d5.d0 d0Var55 = this.P;
                                                                                                            if (d0Var55 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var55.e.setOnClickListener(new p3(this, fVar, 9));
                                                                                                            d5.d0 d0Var56 = this.P;
                                                                                                            if (d0Var56 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            d0Var56.y.setOnClickListener(new r3(this, i17));
                                                                                                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                                                                                            d5.d0 d0Var57 = this.P;
                                                                                                            if (d0Var57 == null) {
                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                throw null;
                                                                                                            }
                                                                                                            builder.setView(d0Var57.f6963a);
                                                                                                            AlertDialog alertDialogCreate = builder.create();
                                                                                                            this.f10935w = alertDialogCreate;
                                                                                                            if (alertDialogCreate != null) {
                                                                                                                alertDialogCreate.setOnCancelListener(new k(this, 1));
                                                                                                            }
                                                                                                            if (isFinishing()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            AlertDialog alertDialog = this.f10935w;
                                                                                                            if (alertDialog != null && (window = alertDialog.getWindow()) != null) {
                                                                                                                a3.a.A(window, 0);
                                                                                                            }
                                                                                                            AlertDialog alertDialog2 = this.f10935w;
                                                                                                            if (alertDialog2 != null) {
                                                                                                                alertDialog2.show();
                                                                                                            }
                                                                                                            this.O = true;
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
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i12)));
    }

    public final void s0(v5.g gVar, h5.f fVar, int i10) {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            AlertDialog alertDialog = this.f10935w;
            alertDialog.getClass();
            alertDialog.dismiss();
            this.O = false;
            gVar.a();
            if (fVar.f8532m == 0) {
                fVar.f8532m = 1;
                fVar.g = h5.e.f8507b;
                Context applicationContext = getApplicationContext();
                applicationContext.getClass();
                r0.f.o(applicationContext);
            } else {
                fVar.f8532m = 0;
                fVar.g = h5.e.f8506a;
            }
            gVar.Z(fVar);
            gVar.b();
            x0();
        }
    }

    public final void t0(h5.y0 y0Var, File file) {
        ApplicationInfo applicationInfoB;
        y0Var.getClass();
        if (!file.isDirectory()) {
            file = new File(file.getAbsolutePath()).getParentFile();
        }
        File file2 = file;
        y3 y3Var = new y3(this, file2, y0Var, 0);
        try {
            PackageManager packageManager = getPackageManager();
            packageManager.getClass();
            applicationInfoB = l5.a.b(packageManager, y0Var.f8795b, 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfoB = null;
        }
        if (applicationInfoB == null) {
            String string = getString(R.string.installable_files_not_found);
            string.getClass();
            N(string);
        } else {
            File file3 = new File(applicationInfoB.sourceDir);
            ArrayList arrayList = new ArrayList();
            arrayList.add(file3);
            file2.getClass();
            new s4.n(arrayList, file2, y3Var, false, this);
        }
    }

    public final void u0() {
        if (this.K) {
            return;
        }
        this.K = true;
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new u3(this, null), 3);
    }

    public final void v0(h5.f fVar) {
        String str = fVar.f8526c;
        if (str == null || str.length() == 0) {
            return;
        }
        v5.g gVarL = v5.g.f13148u.l(this);
        gVarL.a();
        String str2 = fVar.f8526c;
        str2.getClass();
        h5.y0 y0VarM = gVarL.M(str2);
        if (y0VarM != null) {
            String str3 = y0VarM.f8795b;
            float f = UptodownApp.E;
            if (k4.c.k(y0VarM)) {
                str3.getClass();
                h5.q qVar = DownloadWorker.f6738d;
                if (kotlin.jvm.internal.l.a(qVar != null ? qVar.f8701b : null, str3)) {
                    DownloadWorker.f = false;
                    DownloadWorker.e = true;
                }
                k4.c.v(y0VarM);
            } else if (k4.c.l(str3)) {
                k4.c.w(str3);
            }
        }
        gVarL.b();
    }

    public final void w0(h5.f fVar) {
        if (!a.a.f0a) {
            String string = getString(R.string.error_no_connection);
            string.getClass();
            N(string);
            return;
        }
        ApplicationInfo applicationInfoB = null;
        if ((fVar != null ? fVar.f8526c : null) != null) {
            t3.h hVar = v5.g.f13148u;
            Context applicationContext = getApplicationContext();
            applicationContext.getClass();
            v5.g gVarL = hVar.l(applicationContext);
            gVarL.a();
            String str = fVar.f8526c;
            str.getClass();
            h5.y0 y0VarM = gVarL.M(str);
            if (y0VarM != null) {
                String str2 = y0VarM.f8795b;
                float f = UptodownApp.E;
                int i10 = 1;
                if (!k4.c.k(y0VarM)) {
                    h5.q qVar = y0VarM.f8798i;
                    if (qVar != null) {
                        if (qVar.c()) {
                            h5.q qVar2 = y0VarM.f8798i;
                            qVar2.getClass();
                            boolean Z = o7.u.Z(qVar2.f8701b, getApplicationContext().getPackageName(), true);
                            h5.q qVar3 = y0VarM.f8798i;
                            if (Z) {
                                qVar3.getClass();
                                File fileG = qVar3.g();
                                if (fileG == null || !fileG.exists()) {
                                    h5.q qVar4 = y0VarM.f8798i;
                                    qVar4.getClass();
                                    Context applicationContext2 = getApplicationContext();
                                    applicationContext2.getClass();
                                    qVar4.s(applicationContext2);
                                    String string2 = getString(R.string.installable_files_not_found);
                                    string2.getClass();
                                    N(string2);
                                } else {
                                    M(fileG);
                                }
                            } else {
                                qVar3.getClass();
                                File fileG2 = qVar3.g();
                                if (fileG2 == null || !fileG2.exists()) {
                                    h5.q qVar5 = y0VarM.f8798i;
                                    qVar5.getClass();
                                    Context applicationContext3 = getApplicationContext();
                                    applicationContext3.getClass();
                                    qVar5.s(applicationContext3);
                                    String string3 = getString(R.string.installable_files_not_found);
                                    string3.getClass();
                                    N(string3);
                                } else if (y0VarM.g == 1) {
                                    if (!fileG2.isDirectory()) {
                                        fileG2 = new File(fileG2.getAbsolutePath()).getParentFile();
                                    }
                                    File file = fileG2;
                                    y3 y3Var = new y3(this, file, y0VarM, i10);
                                    try {
                                        PackageManager packageManager = getPackageManager();
                                        packageManager.getClass();
                                        applicationInfoB = l5.a.b(packageManager, str2, 128);
                                    } catch (PackageManager.NameNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    if (applicationInfoB != null) {
                                        File file2 = new File(applicationInfoB.sourceDir);
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(file2);
                                        file.getClass();
                                        new s4.n(arrayList, file, y3Var, false, this);
                                    } else {
                                        String string4 = getString(R.string.installable_files_not_found);
                                        string4.getClass();
                                        N(string4);
                                    }
                                } else {
                                    U(fileG2, y0VarM.h);
                                }
                            }
                        } else {
                            boolean zO = k4.c.o(this, "DownloadUpdatesWorker");
                            String str3 = fVar.f8526c;
                            if (zO) {
                                str3.getClass();
                                if (k4.c.l(str3)) {
                                    String str4 = fVar.f8526c;
                                    str4.getClass();
                                    k4.c.w(str4);
                                } else {
                                    r0(fVar);
                                }
                            } else {
                                A0(str3, false);
                            }
                        }
                    } else if (k4.c.o(this, "DownloadUpdatesWorker")) {
                        r0(fVar);
                    } else {
                        A0(fVar.f8526c, false);
                    }
                } else if (DownloadWorker.f) {
                    DownloadWorker.f = false;
                    DownloadWorker.e = false;
                } else if (k4.c.o(this, "DownloadUpdatesWorker")) {
                    str2.getClass();
                    h5.q qVar6 = DownloadWorker.f6738d;
                    if (kotlin.jvm.internal.l.a(qVar6 != null ? qVar6.f8701b : null, str2)) {
                        DownloadWorker.f = false;
                        DownloadWorker.e = true;
                    }
                } else {
                    A0(fVar.f8526c, false);
                }
            }
            gVarL.b();
        }
    }

    public abstract void z0();

    public void x0() {
    }

    public void y0() {
    }
}
