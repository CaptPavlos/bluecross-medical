package l4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.workers.DownloadWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10374a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppInstalledDetailsActivity f10375b;

    public /* synthetic */ f(AppInstalledDetailsActivity appInstalledDetailsActivity, int i10) {
        this.f10374a = i10;
        this.f10375b = appInstalledDetailsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10374a;
        AppInstalledDetailsActivity appInstalledDetailsActivity = this.f10375b;
        switch (i10) {
            case 0:
                int i11 = AppInstalledDetailsActivity.Y;
                appInstalledDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 1:
                int i12 = AppInstalledDetailsActivity.Y;
                v5.g gVarL = v5.g.f13148u.l(appInstalledDetailsActivity);
                gVarL.a();
                h5.f fVar = appInstalledDetailsActivity.V;
                fVar.getClass();
                String str = fVar.f8526c;
                str.getClass();
                h5.y0 y0VarM = gVarL.M(str);
                if (y0VarM != null) {
                    String str2 = y0VarM.f8795b;
                    float f = UptodownApp.E;
                    if (k4.c.k(y0VarM)) {
                        str2.getClass();
                        h5.q qVar = DownloadWorker.f6738d;
                        if (kotlin.jvm.internal.l.a(qVar != null ? qVar.f8701b : null, str2)) {
                            DownloadWorker.f = false;
                            DownloadWorker.e = true;
                        }
                        k4.c.v(y0VarM);
                    } else if (k4.c.l(str2)) {
                        k4.c.w(str2);
                    }
                }
                gVarL.b();
                break;
            case 2:
                int i13 = AppInstalledDetailsActivity.Y;
                PackageManager packageManager = appInstalledDetailsActivity.getPackageManager();
                h5.f fVar2 = appInstalledDetailsActivity.V;
                fVar2.getClass();
                String str3 = fVar2.f8526c;
                str3.getClass();
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                if (launchIntentForPackage != null) {
                    appInstalledDetailsActivity.startActivity(launchIntentForPackage);
                    break;
                }
                break;
            case 3:
                int i14 = AppInstalledDetailsActivity.Y;
                h5.f fVar3 = appInstalledDetailsActivity.V;
                fVar3.getClass();
                String str4 = fVar3.f8526c;
                str4.getClass();
                Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str4)));
                intent.addFlags(268435456);
                appInstalledDetailsActivity.startActivity(intent);
                appInstalledDetailsActivity.finish();
                break;
            case 4:
                int i15 = AppInstalledDetailsActivity.Y;
                Intent intent2 = new Intent(appInstalledDetailsActivity, (Class<?>) AppFilesActivity.class);
                intent2.putExtra("appInstalled", appInstalledDetailsActivity.V);
                float f10 = UptodownApp.E;
                appInstalledDetailsActivity.startActivity(intent2, k4.c.a(appInstalledDetailsActivity));
                break;
            case 5:
                int i16 = AppInstalledDetailsActivity.Y;
                if (appInstalledDetailsActivity.F0().h.getVisibility() != 0) {
                    appInstalledDetailsActivity.F0().h.setVisibility(0);
                    appInstalledDetailsActivity.F0().f6989d.setImageResource(R.drawable.vector_remove);
                    appInstalledDetailsActivity.F0().f7011w.post(new androidx.constraintlayout.helper.widget.a(appInstalledDetailsActivity, 6));
                    break;
                } else {
                    appInstalledDetailsActivity.F0().h.setVisibility(8);
                    appInstalledDetailsActivity.F0().f6989d.setImageResource(R.drawable.vector_add);
                    break;
                }
            default:
                if (appInstalledDetailsActivity.W == null) {
                    appInstalledDetailsActivity.E0();
                    break;
                } else {
                    Intent intent3 = new Intent(appInstalledDetailsActivity, (Class<?>) AppDetailActivity.class);
                    intent3.putExtra("appInfo", appInstalledDetailsActivity.W);
                    float f11 = UptodownApp.E;
                    appInstalledDetailsActivity.startActivity(intent3, k4.c.a(appInstalledDetailsActivity));
                    break;
                }
        }
    }
}
