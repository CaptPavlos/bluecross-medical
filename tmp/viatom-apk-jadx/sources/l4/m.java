package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.SwitchCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.Updates;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10610a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10611b;

    public /* synthetic */ m(int i10, MainActivity mainActivity) {
        this.f10610a = i10;
        this.f10611b = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f10610a;
        File fileG = null;
        MainActivity mainActivity = this.f10611b;
        switch (i10) {
            case 0:
                mainActivity.Q();
                mainActivity.B();
                break;
            case 1:
                mainActivity.Q();
                mainActivity.finish();
                break;
            case 2:
                int i11 = MainActivity.B0;
                try {
                    v5.g gVarL = v5.g.f13148u.l(mainActivity);
                    gVarL.a();
                    String packageName = mainActivity.getPackageName();
                    packageName.getClass();
                    h5.y0 y0VarM = gVarL.M(packageName);
                    h5.q qVarA = y0VarM != null ? y0VarM.a(mainActivity) : null;
                    if (qVarA != null && qVarA.c()) {
                        fileG = qVarA.g();
                    }
                    gVarL.b();
                    if (fileG != null && fileG.exists()) {
                        mainActivity.M(fileG);
                        break;
                    } else {
                        mainActivity.S0();
                        break;
                    }
                } catch (Exception unused) {
                    mainActivity.Z0();
                    return;
                }
                break;
            case 3:
                int i12 = MainActivity.B0;
                mainActivity.finish();
                break;
            case 4:
                int i13 = MainActivity.B0;
                String string = mainActivity.getString(R.string.tos_title);
                string.getClass();
                String string2 = mainActivity.getString(R.string.url_privacy);
                string2.getClass();
                v5.c.e(mainActivity, string2, string);
                break;
            case 5:
                int i14 = MainActivity.B0;
                Intent intent = new Intent(mainActivity, (Class<?>) GdprPrivacySettings.class);
                ActivityResultLauncher activityResultLauncher = mainActivity.f6651v0;
                float f = UptodownApp.E;
                activityResultLauncher.launch(intent, k4.c.b(mainActivity));
                break;
            case 6:
                int i15 = MainActivity.B0;
                mainActivity.v0();
                break;
            case 7:
                int i16 = MainActivity.B0;
                v5.g gVarL2 = v5.g.f13148u.l(mainActivity);
                gVarL2.a();
                String packageName2 = mainActivity.getPackageName();
                packageName2.getClass();
                h5.y0 y0VarM2 = gVarL2.M(packageName2);
                h5.q qVarA2 = y0VarM2 != null ? y0VarM2.a(mainActivity) : null;
                File fileG2 = (qVarA2 == null || !qVarA2.c()) ? null : qVarA2.g();
                gVarL2.b();
                if (fileG2 == null) {
                    mainActivity.Z0();
                    break;
                } else {
                    float f10 = UptodownApp.E;
                    k4.c.q(mainActivity, fileG2, null);
                    break;
                }
            case 8:
                int i17 = MainActivity.B0;
                mainActivity.p0();
                break;
            case 9:
                int i18 = MainActivity.B0;
                Intent intent2 = new Intent(mainActivity, (Class<?>) LoginActivity.class);
                ActivityResultLauncher activityResultLauncher2 = mainActivity.f6653x0;
                float f11 = UptodownApp.E;
                activityResultLauncher2.launch(intent2, k4.c.b(mainActivity));
                break;
            case 10:
                int i19 = MainActivity.B0;
                mainActivity.A0();
                break;
            case 11:
                int i20 = MainActivity.B0;
                AlertDialog alertDialog = mainActivity.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                mainActivity.V0();
                Intent intent3 = new Intent(mainActivity, (Class<?>) Updates.class);
                float f12 = UptodownApp.E;
                mainActivity.startActivity(intent3, k4.c.a(mainActivity));
                break;
            case 12:
                int i21 = MainActivity.B0;
                AlertDialog alertDialog2 = mainActivity.f10935w;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                if (Build.VERSION.SDK_INT >= 33) {
                    mainActivity.z();
                }
                try {
                    SharedPreferences.Editor editorEdit = mainActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putBoolean("recibir_notificaciones", true);
                    editorEdit.apply();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 13:
                int i22 = MainActivity.B0;
                AlertDialog alertDialog3 = mainActivity.f10935w;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                }
                mainActivity.V0();
                Intent intent4 = new Intent(mainActivity, (Class<?>) MyDownloads.class);
                float f13 = UptodownApp.E;
                mainActivity.startActivity(intent4, k4.c.a(mainActivity));
                break;
            case 14:
                int i23 = MainActivity.B0;
                AlertDialog alertDialog4 = mainActivity.f10935w;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                    break;
                }
                break;
            case 15:
                int i24 = MainActivity.B0;
                AlertDialog alertDialog5 = mainActivity.f10935w;
                if (alertDialog5 != null) {
                    alertDialog5.dismiss();
                    break;
                }
                break;
            case 16:
                int i25 = MainActivity.B0;
                mainActivity.H0();
                break;
            case 17:
                int i26 = MainActivity.B0;
                AlertDialog alertDialog6 = mainActivity.f10935w;
                alertDialog6.getClass();
                alertDialog6.dismiss();
                break;
            case 18:
                int i27 = MainActivity.B0;
                mainActivity.H0();
                mainActivity.l0();
                break;
            case 19:
                SwitchCompat switchCompat = mainActivity.S;
                if (switchCompat != null && !switchCompat.isChecked()) {
                    mainActivity.z();
                    break;
                }
                break;
            case 20:
                SwitchCompat switchCompat2 = mainActivity.R;
                if (switchCompat2 != null && !switchCompat2.isChecked() && !mainActivity.o()) {
                    mainActivity.A();
                    break;
                }
                break;
            case 21:
                int i28 = MainActivity.B0;
                mainActivity.A0();
                break;
            case 22:
                int i29 = MainActivity.B0;
                mainActivity.z0();
                break;
            case 23:
                int i30 = MainActivity.B0;
                Intent intent5 = new Intent(mainActivity, (Class<?>) LoginActivity.class);
                float f14 = UptodownApp.E;
                mainActivity.startActivity(intent5, k4.c.a(mainActivity));
                mainActivity.E0();
                break;
            case 24:
                int i31 = MainActivity.B0;
                mainActivity.E0();
                break;
            case 25:
                int i32 = MainActivity.B0;
                String string3 = mainActivity.getString(R.string.tos_title);
                string3.getClass();
                String string4 = mainActivity.getString(R.string.url_privacy);
                string4.getClass();
                v5.c.e(mainActivity, string4, string3);
                break;
            case 26:
                int i33 = MainActivity.B0;
                float f15 = UptodownApp.E;
                if (k4.c.s()) {
                    mainActivity.C0(0);
                    e5.t1 t1Var = mainActivity.f6641k0;
                    if (t1Var != null) {
                        t1Var.b().f7348d.smoothScrollToPosition(0);
                    }
                    e5.n1 n1Var = mainActivity.Z;
                    if (n1Var != null) {
                        n1Var.f().smoothScrollToPosition(0);
                    }
                    e5.d1 d1Var = mainActivity.f6640j0;
                    if (d1Var != null) {
                        d1Var.f().smoothScrollToPosition(0);
                    }
                    e5.m1 m1Var = mainActivity.l0;
                    if (m1Var != null) {
                        m1Var.a().g.smoothScrollToPosition(0);
                        break;
                    }
                }
                break;
            case 27:
                int i34 = MainActivity.B0;
                Intent intent6 = new Intent(mainActivity, (Class<?>) GdprPrivacySettings.class);
                ActivityResultLauncher activityResultLauncher3 = mainActivity.f6651v0;
                float f16 = UptodownApp.E;
                activityResultLauncher3.launch(intent6, k4.c.b(mainActivity));
                break;
            case 28:
                int i35 = MainActivity.B0;
                mainActivity.v0();
                break;
            default:
                int i36 = MainActivity.B0;
                mainActivity.A0();
                break;
        }
    }
}
