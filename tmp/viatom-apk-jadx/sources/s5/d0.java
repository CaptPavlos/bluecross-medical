package s5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import c1.w4;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import com.uptodown.workers.DownloadWorker;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvOldVersionsFragment f12621a;

    public d0(TvOldVersionsFragment tvOldVersionsFragment) {
        this.f12621a = tvOldVersionsFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        File externalFilesDir;
        if (obj instanceof h5.c0) {
            TvOldVersionsFragment tvOldVersionsFragment = this.f12621a;
            h5.f fVar = tvOldVersionsFragment.f6716b;
            if (fVar == null || ((h5.c0) obj).f8488d != fVar.f8527d) {
                t3.h hVar = v5.g.f13148u;
                Context contextRequireContext = tvOldVersionsFragment.requireContext();
                contextRequireContext.getClass();
                v5.g gVarL = hVar.l(contextRequireContext);
                gVarL.a();
                h5.h hVar2 = tvOldVersionsFragment.f6715a;
                hVar2.getClass();
                String str = hVar2.f8595w;
                str.getClass();
                h5.c0 c0Var = (h5.c0) obj;
                h5.q qVarB = gVarL.B(c0Var.f8488d, str);
                gVarL.b();
                if (qVarB == null) {
                    h5.q qVar = new h5.q();
                    h5.h hVar3 = tvOldVersionsFragment.f6715a;
                    hVar3.getClass();
                    qVar.b(hVar3, c0Var);
                    TvOldVersionsFragment.a(tvOldVersionsFragment, qVar);
                    return;
                }
                if (a.a.E(qVarB)) {
                    String str2 = qVarB.f8701b;
                    if (str2 != null) {
                        a.a.l(str2);
                        return;
                    }
                    long j10 = qVarB.h;
                    if (j10 <= 0 || !a.a.D(j10)) {
                        return;
                    }
                    DownloadWorker.f = false;
                    DownloadWorker.e = true;
                    return;
                }
                if (!qVarB.c() || qVarB.f8709n == null) {
                    h5.h hVar4 = tvOldVersionsFragment.f6715a;
                    hVar4.getClass();
                    qVarB.a(hVar4);
                    TvOldVersionsFragment.a(tvOldVersionsFragment, qVarB);
                    return;
                }
                h5.h hVar5 = tvOldVersionsFragment.f6715a;
                hVar5.getClass();
                String str3 = hVar5.f8595w;
                long j11 = qVarB.e;
                String str4 = qVarB.f8709n;
                str4.getClass();
                if (tvOldVersionsFragment.getActivity() != null) {
                    PackageManager packageManager = tvOldVersionsFragment.requireActivity().getPackageManager();
                    try {
                        packageManager.getClass();
                        str3.getClass();
                        if (j11 < x4.d.d(l5.a.f(packageManager, str3, 1))) {
                            AlertDialog alertDialog = tvOldVersionsFragment.f6717c;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                            }
                            AlertDialog.Builder builder = new AlertDialog.Builder(tvOldVersionsFragment.getContext());
                            builder.setTitle(tvOldVersionsFragment.getString(R.string.warning_title));
                            builder.setMessage(R.string.msg_warning_old_versions);
                            builder.setCancelable(false);
                            builder.setPositiveButton(android.R.string.ok, new p4.w(tvOldVersionsFragment, str3, 2));
                            builder.setNegativeButton(android.R.string.cancel, new r5.c(10));
                            AlertDialog alertDialogCreate = builder.create();
                            tvOldVersionsFragment.f6717c = alertDialogCreate;
                            if (alertDialogCreate != null) {
                                alertDialogCreate.show();
                                return;
                            }
                            return;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                Context contextRequireContext2 = tvOldVersionsFragment.requireContext();
                contextRequireContext2.getClass();
                w4 w4Var = new w4(contextRequireContext2, 3, false);
                if (w4Var.D()) {
                    File[] externalFilesDirs = contextRequireContext2.getExternalFilesDirs(null);
                    if (externalFilesDirs.length > 1) {
                        externalFilesDir = externalFilesDirs[1];
                    } else {
                        externalFilesDir = contextRequireContext2.getExternalFilesDir(null);
                        w4Var.P();
                        w4Var.O();
                    }
                } else {
                    externalFilesDir = contextRequireContext2.getExternalFilesDir(null);
                }
                File file = new File(externalFilesDir, "Apps");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str4);
                float f = UptodownApp.E;
                FragmentActivity fragmentActivityRequireActivity = tvOldVersionsFragment.requireActivity();
                fragmentActivityRequireActivity.getClass();
                k4.c.q(fragmentActivityRequireActivity, file2, null);
            }
        }
    }
}
