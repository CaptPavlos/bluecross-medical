package b5;

import a3.s;
import a3.z0;
import a6.j;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import c.h;
import c1.w4;
import com.google.android.material.snackbar.Snackbar;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.DownloadWorker;
import com.uptodown.workers.GenerateQueueWorker;
import d5.q0;
import d5.s0;
import e5.b2;
import e5.j0;
import h5.k;
import h5.o0;
import h5.w0;
import h5.x0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.x;
import l4.a4;
import l4.i3;
import l4.n5;
import l4.w;
import l4.x4;
import o7.m;
import o7.u;
import p4.m0;
import r7.i0;
import r7.y;
import v4.f;
import z5.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f842a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f843b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f844c;

    public /* synthetic */ a(int i10, Object obj, Object obj2) {
        this.f842a = i10;
        this.f843b = obj;
        this.f844c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int absoluteAdapterPosition;
        int i10 = this.f842a;
        w6.c cVar = null;
        int i11 = 1;
        int i12 = 0;
        Object obj = this.f844c;
        Object obj2 = this.f843b;
        switch (i10) {
            case 0:
                n5 n5Var = (n5) obj2;
                b bVar = (b) obj;
                if (n5Var != null && (absoluteAdapterPosition = bVar.getAbsoluteAdapterPosition()) != -1) {
                    ((m0) n5Var.f10654b).G();
                    f fVar = o4.b.t;
                    fVar.getClass();
                    int size = fVar.g.size();
                    if (size > 0 && size > absoluteAdapterPosition) {
                        f fVar2 = o4.b.t;
                        fVar2.getClass();
                        Object obj3 = fVar2.g.get(absoluteAdapterPosition);
                        obj3.getClass();
                        f fVar3 = o4.b.t;
                        fVar3.getClass();
                        fVar3.d((NsdServiceInfo) obj3);
                        break;
                    }
                }
                break;
            case 1:
                d dVar = (d) obj2;
                int absoluteAdapterPosition2 = dVar.getAbsoluteAdapterPosition();
                if (absoluteAdapterPosition2 != -1) {
                    x4 x4Var = dVar.f849a;
                    x4Var.getClass();
                    FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) x4Var.f10987b;
                    r4.b bVar2 = fileExplorerActivity.M;
                    if (bVar2 != null && bVar2.f12376c) {
                        bVar2.b(absoluteAdapterPosition2);
                        r4.b bVar3 = fileExplorerActivity.M;
                        bVar3.getClass();
                        if (!bVar3.a().isEmpty()) {
                            FileExplorerActivity.S(fileExplorerActivity);
                            break;
                        } else {
                            r4.b bVar4 = fileExplorerActivity.M;
                            bVar4.getClass();
                            bVar4.c(false);
                            fileExplorerActivity.W();
                            break;
                        }
                    } else if (!(obj instanceof File)) {
                        if (obj instanceof DocumentFile) {
                            DocumentFile documentFile = (DocumentFile) obj;
                            if (!documentFile.isDirectory()) {
                                if (fileExplorerActivity.getIntent().getExtras() != null) {
                                    Bundle extras = fileExplorerActivity.getIntent().getExtras();
                                    extras.getClass();
                                    if (extras.containsKey("select_file")) {
                                        Bundle extras2 = fileExplorerActivity.getIntent().getExtras();
                                        extras2.getClass();
                                        if (extras2.getInt("select_file") == 1) {
                                            Intent intent = new Intent();
                                            if (documentFile.isFile()) {
                                                intent.setData(documentFile.getUri());
                                                intent.putExtra("sdcard_selected", fileExplorerActivity.V);
                                                fileExplorerActivity.setResult(145, intent);
                                                fileExplorerActivity.finish();
                                                break;
                                            }
                                        }
                                    }
                                }
                                if (documentFile.getName() != null) {
                                    String name = documentFile.getName();
                                    name.getClass();
                                    if (u.X(name, ".apk", true) || u.X(name, ".xapk", true) || u.X(name, ".apks", true) || u.X(name, ".apkm", true)) {
                                        String name2 = documentFile.getName();
                                        name2.getClass();
                                        FileExplorerActivity.P(fileExplorerActivity, obj, name2);
                                        break;
                                    }
                                }
                                if (documentFile.getName() != null) {
                                    String name3 = documentFile.getName();
                                    name3.getClass();
                                    if (u.X(name3, ".zip", false)) {
                                        FileExplorerActivity.O(fileExplorerActivity, obj);
                                        break;
                                    }
                                }
                                Uri uri = documentFile.getUri();
                                uri.getClass();
                                fileExplorerActivity.d0(uri);
                                break;
                            } else {
                                fileExplorerActivity.P = documentFile;
                                fileExplorerActivity.T = null;
                                fileExplorerActivity.Y(true);
                                break;
                            }
                        }
                    } else {
                        File file = (File) obj;
                        if (!file.isDirectory()) {
                            if (fileExplorerActivity.getIntent().getExtras() != null) {
                                Bundle extras3 = fileExplorerActivity.getIntent().getExtras();
                                extras3.getClass();
                                if (extras3.containsKey("select_file")) {
                                    Bundle extras4 = fileExplorerActivity.getIntent().getExtras();
                                    extras4.getClass();
                                    if (extras4.getInt("select_file") == 1) {
                                        Intent intent2 = new Intent();
                                        if (file.isFile()) {
                                            intent2.putExtra("path_selected", file.getAbsolutePath());
                                            intent2.putExtra("sdcard_selected", fileExplorerActivity.V);
                                            fileExplorerActivity.setResult(145, intent2);
                                            fileExplorerActivity.finish();
                                            break;
                                        }
                                    }
                                }
                            }
                            String name4 = file.getName();
                            name4.getClass();
                            if (!u.X(name4, ".apk", true) && !u.X(name4, ".xapk", true) && !u.X(name4, ".apks", true) && !u.X(name4, ".apkm", true)) {
                                String name5 = file.getName();
                                name5.getClass();
                                if (!u.X(name5, ".zip", false)) {
                                    Uri uriForFile = FileProvider.getUriForFile(fileExplorerActivity, fileExplorerActivity.getApplicationContext().getPackageName() + ".provider", file);
                                    uriForFile.getClass();
                                    fileExplorerActivity.d0(uriForFile);
                                    break;
                                } else {
                                    FileExplorerActivity.O(fileExplorerActivity, obj);
                                    break;
                                }
                            } else {
                                String name6 = file.getName();
                                name6.getClass();
                                FileExplorerActivity.P(fileExplorerActivity, obj, name6);
                                break;
                            }
                        } else {
                            fileExplorerActivity.T = file;
                            fileExplorerActivity.P = null;
                            fileExplorerActivity.Y(true);
                            break;
                        }
                    }
                }
                break;
            case 2:
                t4.c cVar2 = (t4.c) obj;
                int absoluteAdapterPosition3 = ((e) obj2).getAbsoluteAdapterPosition();
                if (absoluteAdapterPosition3 != -1) {
                    cVar2.a(absoluteAdapterPosition3);
                    break;
                }
                break;
            case 3:
                c.f fVar4 = (c.f) obj2;
                fVar4.getClass();
                fVar4.f953a.g((h) obj);
                break;
            case 4:
                c6.c cVar3 = (c6.c) obj2;
                String str = (String) obj;
                try {
                    if (str.length() > 0) {
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(Uri.parse(str));
                        cVar3.startActivity(intent3);
                        break;
                    }
                } catch (ActivityNotFoundException unused) {
                    Log.e("c", "No a valid URL has been passed");
                    return;
                }
                break;
            case 5:
                ((Snackbar) obj2).lambda$setAction$0((View.OnClickListener) obj, view);
                break;
            case 6:
                j0 j0Var = (j0) obj;
                if (((CheckBox) ((z0) obj2).f196b).isChecked()) {
                    Context contextRequireContext = j0Var.requireContext();
                    contextRequireContext.getClass();
                    try {
                        SharedPreferences.Editor editorEdit = contextRequireContext.getSharedPreferences("SettingsPreferences", 0).edit();
                        editorEdit.putBoolean("show_warning_download_incompatible", true);
                        editorEdit.apply();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Context contextRequireContext2 = j0Var.requireContext();
                contextRequireContext2.getClass();
                j0Var.c0(contextRequireContext2);
                if (j0Var.getActivity() != null) {
                    FragmentActivity activity = j0Var.getActivity();
                    activity.getClass();
                    AlertDialog alertDialog = ((w) activity).f10935w;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                        break;
                    }
                }
                break;
            case 7:
                ((g7.a) obj2).invoke();
                FragmentActivity activity2 = ((j0) obj).getActivity();
                activity2.getClass();
                AlertDialog alertDialog2 = ((w) activity2).f10935w;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            case 8:
                j0 j0Var2 = (j0) obj2;
                k kVar = (k) obj;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    j0Var2.R(kVar);
                    break;
                }
                break;
            case 9:
                s0 s0Var = (s0) obj2;
                j0 j0Var3 = (j0) obj;
                TextView textView = s0Var.f7339n;
                TextView textView2 = s0Var.f7344s;
                if (textView.getMaxLines() != Integer.MAX_VALUE) {
                    textView.setMaxLines(Integer.MAX_VALUE);
                    textView2.setText(j0Var3.getString(R.string.read_less_desc_app_detail));
                    break;
                } else {
                    textView.setMaxLines(4);
                    textView2.setText(j0Var3.getString(R.string.read_more_desc_app_detail));
                    break;
                }
            case 10:
                j0 j0Var4 = (j0) obj2;
                x0 x0Var = (x0) obj;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    j0Var4.R(x0Var.f8788a);
                    break;
                }
                break;
            case 11:
                q0 q0Var = (q0) obj2;
                j0 j0Var5 = (j0) obj;
                TextView textView3 = q0Var.f7303m;
                TextView textView4 = q0Var.f7308r;
                if (textView3.getMaxLines() != Integer.MAX_VALUE) {
                    textView3.setMaxLines(Integer.MAX_VALUE);
                    textView4.setText(j0Var5.getString(R.string.read_less_desc_app_detail));
                    break;
                } else {
                    textView3.setMaxLines(4);
                    textView4.setText(j0Var5.getString(R.string.read_more_desc_app_detail));
                    break;
                }
            case 12:
                j0 j0Var6 = (j0) obj;
                if (((d5.k) obj2).f7145b.getVisibility() == 0) {
                    j0Var6.v();
                    break;
                }
                break;
            case 13:
                ((j0) obj2).G().R.f(((Map.Entry) obj).getKey());
                break;
            case 14:
                j0 j0Var7 = (j0) obj2;
                EditText editText = (EditText) ((c2.d) obj).f1642c;
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    u7.m0 m0Var = j0Var7.G().H;
                    Editable text = editText.getText();
                    text.getClass();
                    m0Var.f(m.v0(text).toString());
                    editText.setText((CharSequence) j0Var7.G().H.getValue());
                    FragmentActivity activity3 = j0Var7.getActivity();
                    activity3.getClass();
                    AlertDialog alertDialog3 = ((w) activity3).f10935w;
                    if (alertDialog3 != null) {
                        alertDialog3.dismiss();
                        break;
                    }
                }
                break;
            case 15:
                j0 j0Var8 = (j0) obj;
                if (!((kotlin.jvm.internal.u) obj2).f10135a) {
                    DownloadWorker.f = false;
                    DownloadWorker.e = false;
                }
                FragmentActivity activity4 = j0Var8.getActivity();
                activity4.getClass();
                AlertDialog alertDialog4 = ((w) activity4).f10935w;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                    break;
                }
                break;
            case 16:
                j0 j0Var9 = (j0) obj2;
                h5.d dVar2 = (h5.d) obj;
                if (j0Var9.getActivity() != null && (j0Var9.getActivity() instanceof MainActivity)) {
                    FragmentActivity activity5 = j0Var9.getActivity();
                    activity5.getClass();
                    MainActivity mainActivity = (MainActivity) activity5;
                    dVar2.getClass();
                    mainActivity.E0();
                    mainActivity.H0();
                    e5.d dVar3 = new e5.d();
                    dVar3.f7718b = dVar2;
                    FragmentTransaction fragmentTransactionBeginTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
                    fragmentTransactionBeginTransaction.getClass();
                    if (((CoordinatorLayout) mainActivity.findViewById(R.id.rl_main_scrollable)) == null) {
                        String string = mainActivity.getString(R.string.error_generico);
                        string.getClass();
                        mainActivity.C(string);
                        break;
                    } else {
                        try {
                            float f12 = UptodownApp.E;
                            k4.c.D(fragmentTransactionBeginTransaction, mainActivity);
                            fragmentTransactionBeginTransaction.add(R.id.rl_main_scrollable, dVar3);
                            fragmentTransactionBeginTransaction.addToBackStack(dVar2.f8490a);
                            if (mainActivity.G0() instanceof b2) {
                                fragmentTransactionBeginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                            }
                            if (!mainActivity.isFinishing() && !mainActivity.getSupportFragmentManager().isDestroyed()) {
                                try {
                                    fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                                    break;
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    String string2 = mainActivity.getString(R.string.error_generico);
                                    string2.getClass();
                                    mainActivity.C(string2);
                                    return;
                                }
                            }
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            String string3 = mainActivity.getString(R.string.error_generico);
                            string3.getClass();
                            mainActivity.C(string3);
                            return;
                        }
                    }
                } else if (j0Var9.getActivity() != null && (j0Var9.getActivity() instanceof AppDetailActivity)) {
                    FragmentActivity activity6 = j0Var9.getActivity();
                    activity6.getClass();
                    AppDetailActivity appDetailActivity = (AppDetailActivity) activity6;
                    dVar2.getClass();
                    e5.d dVar4 = new e5.d();
                    dVar4.f7718b = dVar2;
                    FragmentTransaction fragmentTransactionBeginTransaction2 = appDetailActivity.getSupportFragmentManager().beginTransaction();
                    fragmentTransactionBeginTransaction2.getClass();
                    float f13 = UptodownApp.E;
                    k4.c.D(fragmentTransactionBeginTransaction2, appDetailActivity);
                    fragmentTransactionBeginTransaction2.add(R.id.fl_main_app_detail_activity, dVar4, (String) null).addToBackStack(dVar2.f8490a).commit();
                    appDetailActivity.K.add(dVar4);
                    break;
                }
                break;
            case 17:
                b2 b2Var = (b2) obj;
                Intent intent4 = new Intent("android.intent.action.SEND");
                intent4.addFlags(524288);
                intent4.setType("text/plain");
                w0 w0Var = ((x0) obj2).f8791d;
                w0Var.getClass();
                intent4.putExtra("android.intent.extra.TEXT", w0Var.g);
                b2Var.startActivity(Intent.createChooser(intent4, b2Var.getString(R.string.option_button_share)));
                break;
            case 18:
                String str2 = (String) obj;
                str2.getClass();
                Context context = ((i6.d) obj2).getContext();
                if (context != null) {
                    Intent intent5 = new Intent("android.intent.action.VIEW");
                    intent5.setData(Uri.parse(str2));
                    context.startActivity(intent5);
                    break;
                }
                break;
            case 19:
                k9.b bVar5 = (k9.b) obj2;
                String str3 = (String) obj;
                try {
                    if (str3.length() > 0) {
                        Intent intent6 = new Intent("android.intent.action.VIEW");
                        intent6.setData(Uri.parse(str3));
                        bVar5.startActivity(intent6);
                        break;
                    }
                } catch (ActivityNotFoundException unused2) {
                    Log.e(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "No a valid URL has been passed");
                    return;
                }
                break;
            case 20:
                AppInstalledDetailsActivity appInstalledDetailsActivity = (AppInstalledDetailsActivity) obj2;
                appInstalledDetailsActivity.w0(appInstalledDetailsActivity.V);
                float f14 = UptodownApp.E;
                if (!k4.c.l((String) obj)) {
                    appInstalledDetailsActivity.G0();
                    break;
                } else {
                    appInstalledDetailsActivity.H0();
                    appInstalledDetailsActivity.F0().M.setText(appInstalledDetailsActivity.getString(R.string.status_download_update_pending));
                    break;
                }
            case 21:
                AppInstalledDetailsActivity appInstalledDetailsActivity2 = (AppInstalledDetailsActivity) obj2;
                h5.h hVar = (h5.h) obj;
                float f15 = UptodownApp.E;
                if (k4.c.s()) {
                    appInstalledDetailsActivity2.Y(hVar.f8566a);
                    break;
                }
                break;
            case 22:
                ((w) obj2).c0(((o0) obj).f8675a);
                break;
            case 23:
                h5.u uVar = (h5.u) obj2;
                int i13 = ListsActivity.K;
                k kVar2 = new k(0, (String) null, 7);
                kVar2.f8632a = uVar.f8750a;
                kVar2.f8633b = uVar.f8751b;
                kVar2.f8635d = true;
                ((ListsActivity) obj).r0(kVar2);
                break;
            case 24:
                TextView textView5 = (TextView) obj2;
                ImageView imageView = (ImageView) obj;
                int i14 = MainActivity.B0;
                if (textView5.getVisibility() != 0) {
                    textView5.setVisibility(0);
                    imageView.setScaleY(-1.0f);
                    break;
                } else {
                    textView5.setVisibility(8);
                    imageView.setScaleY(1.0f);
                    break;
                }
            case 25:
                MainActivity mainActivity2 = (MainActivity) obj2;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(mainActivity2);
                y7.e eVar = i0.f12407a;
                y.q(lifecycleScope, y7.d.f14116a, null, new j(mainActivity2, (x) obj, cVar, 25), 2).s(new s(mainActivity2, 14));
                AlertDialog alertDialog5 = mainActivity2.f10935w;
                if (alertDialog5 != null) {
                    alertDialog5.dismiss();
                    break;
                }
                break;
            case 26:
                MyApps myApps = (MyApps) obj2;
                int i15 = MyApps.f6655j0;
                view.getClass();
                new n(myApps, view, (HashMap) obj, new i3(myApps, i12)).a();
                break;
            case 27:
                ArrayList arrayList = (ArrayList) obj2;
                MyApps myApps2 = (MyApps) obj;
                if (arrayList.size() > 0) {
                    String str4 = ((h5.f) arrayList.get(0)).f8526c;
                    float f16 = UptodownApp.E;
                    if (!k4.c.o(myApps2, "GenerateQueueWorker")) {
                        WorkManager.Companion.getInstance(myApps2).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", true).putString("packagename", str4).build()).build());
                    }
                }
                AlertDialog alertDialog6 = myApps2.f10935w;
                if (alertDialog6 != null) {
                    alertDialog6.dismiss();
                    break;
                }
                break;
            case 28:
                a4 a4Var = (a4) obj2;
                String str5 = (String) obj;
                float f17 = UptodownApp.E;
                if (k4.c.s()) {
                    Intent intent7 = new Intent("android.intent.action.SEND");
                    Object objE = new w4(a4Var, 3, false).e();
                    if (!(objE instanceof File)) {
                        if (objE instanceof DocumentFile) {
                            intent7.putExtra("android.intent.extra.STREAM", ((DocumentFile) objE).getUri());
                            a4Var.startActivity(Intent.createChooser(intent7, a4Var.getString(R.string.intent_chooser_title_share_file)));
                            break;
                        }
                    } else {
                        File file2 = new File((File) objE, str5);
                        if (file2.exists()) {
                            intent7.setType("application/vnd.android.package-archive");
                            intent7.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(a4Var, a4Var.getPackageName() + ".provider", file2));
                            a4Var.startActivity(Intent.createChooser(intent7, a4Var.getString(R.string.intent_chooser_title_share_file)));
                            break;
                        }
                    }
                }
                break;
            default:
                MyDownloads myDownloads = (MyDownloads) obj2;
                int i16 = MyDownloads.O;
                view.getClass();
                new n(myDownloads, view, (HashMap) obj, new i3(myDownloads, i11)).a();
                break;
        }
    }
}
