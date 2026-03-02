package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.FileExplorerActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class r3 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10785a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a4 f10786b;

    public /* synthetic */ r3(a4 a4Var, int i10) {
        this.f10785a = i10;
        this.f10786b = a4Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f10785a;
        boolean z9 = false;
        w6.c cVar = null;
        a4 a4Var = this.f10786b;
        switch (i10) {
            case 0:
                AlertDialog alertDialog = a4Var.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    return;
                }
                return;
            case 1:
                AlertDialog alertDialog2 = a4Var.f10935w;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                return;
            case 2:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    AlertDialog alertDialog3 = a4Var.f10935w;
                    alertDialog3.getClass();
                    alertDialog3.dismiss();
                    return;
                }
                return;
            case 3:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    AlertDialog alertDialog4 = a4Var.f10935w;
                    if (alertDialog4 != null) {
                        alertDialog4.dismiss();
                    }
                    a4Var.f10935w = null;
                    return;
                }
                return;
            case 4:
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    Intent intent = new Intent(a4Var, (Class<?>) FileExplorerActivity.class);
                    intent.putExtra("subdir", new c1.w4(a4Var, 3, false).f());
                    try {
                        SharedPreferences sharedPreferences = a4Var.getSharedPreferences("CoreSettings", 0);
                        if (sharedPreferences.contains("sdcard_as_backup_storage")) {
                            z9 = sharedPreferences.getBoolean("sdcard_as_backup_storage", false);
                        }
                    } catch (Exception unused) {
                    }
                    intent.putExtra("subdir_sd", z9);
                    a4Var.startActivity(intent);
                    AlertDialog alertDialog5 = a4Var.f10935w;
                    if (alertDialog5 != null) {
                        alertDialog5.dismiss();
                    }
                    a4Var.f10935w = null;
                    return;
                }
                return;
            case 5:
                float f12 = UptodownApp.E;
                if (k4.c.s()) {
                    r7.o1 o1Var = a4Var.M;
                    if (o1Var == null) {
                        kotlin.jvm.internal.l.i("jobBackup");
                        throw null;
                    }
                    o1Var.a(null);
                    AlertDialog alertDialog6 = a4Var.f10935w;
                    if (alertDialog6 != null) {
                        alertDialog6.dismiss();
                    }
                    a4Var.f10935w = null;
                    return;
                }
                return;
            case 6:
                AlertDialog alertDialog7 = a4Var.f10935w;
                alertDialog7.getClass();
                alertDialog7.dismiss();
                a4Var.O = false;
                return;
            case 7:
                a4Var.Q();
                return;
            case 8:
                TextView textView = a4Var.f11946i;
                if (textView == null) {
                    kotlin.jvm.internal.l.i("tvErrorPath");
                    throw null;
                }
                if (textView.getVisibility() == 0) {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(a4Var.getApplicationContext(), R.anim.core_shake);
                    TextView textView2 = a4Var.f11946i;
                    if (textView2 != null) {
                        textView2.startAnimation(animationLoadAnimation);
                        return;
                    } else {
                        kotlin.jvm.internal.l.i("tvErrorPath");
                        throw null;
                    }
                }
                Boolean bool = a4Var.f11947j;
                if (bool != null) {
                    boolean zEquals = bool.equals(Boolean.TRUE);
                    try {
                        SharedPreferences.Editor editorEdit = a4Var.getSharedPreferences("CoreSettings", 0).edit();
                        editorEdit.putBoolean("sdcard_as_backup_storage", zEquals);
                        editorEdit.apply();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String str = a4Var.f11948k;
                if (str != null) {
                    try {
                        SharedPreferences.Editor editorEdit2 = a4Var.getSharedPreferences("CoreSettings", 0).edit();
                        editorEdit2.putString("outputdir", str);
                        editorEdit2.apply();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                c1.w4 w4Var = new c1.w4(a4Var, 3, false);
                RadioButton radioButton = a4Var.f11944c;
                if (radioButton == null) {
                    kotlin.jvm.internal.l.i("rbAppName");
                    throw null;
                }
                w4Var.N("app_name_included", radioButton.isChecked());
                RadioButton radioButton2 = a4Var.f11945d;
                if (radioButton2 == null) {
                    kotlin.jvm.internal.l.i("rbPackagename");
                    throw null;
                }
                w4Var.N("packagename_included", radioButton2.isChecked());
                CheckBox checkBox = a4Var.f;
                if (checkBox == null) {
                    kotlin.jvm.internal.l.i("cbVersioncode");
                    throw null;
                }
                w4Var.N("versioncode_included", checkBox.isChecked());
                CheckBox checkBox2 = a4Var.g;
                if (checkBox2 == null) {
                    kotlin.jvm.internal.l.i("cbVersionname");
                    throw null;
                }
                w4Var.N("versionname_included", checkBox2.isChecked());
                RadioButton radioButton3 = a4Var.e;
                if (radioButton3 == null) {
                    kotlin.jvm.internal.l.i("rbXapkExtension");
                    throw null;
                }
                w4Var.Q("xapk_extension", radioButton3.isChecked() ? ".xapk" : ".apks");
                AlertDialog alertDialog8 = a4Var.f11942a;
                if (alertDialog8 != null) {
                    alertDialog8.dismiss();
                }
                a4Var.f11942a = null;
                c1.g1 g1Var = new c1.g1(a4Var, new d0.i((Object) a4Var, 27));
                ArrayList arrayList = a4Var.N;
                arrayList.getClass();
                y7.e eVar = r7.i0.f12407a;
                a4Var.M = r7.y.q(r7.y.a(y7.d.f14116a), null, null, new p4.i0(g1Var, arrayList, cVar, 2), 3);
                a4Var.N = new ArrayList();
                return;
            case 9:
                AlertDialog alertDialog9 = a4Var.f11942a;
                if (alertDialog9 != null) {
                    alertDialog9.dismiss();
                }
                a4Var.f11942a = null;
                return;
            default:
                Intent intent2 = new Intent(a4Var.getApplicationContext(), (Class<?>) FileExplorerActivity.class);
                intent2.putExtra("select_path", 1);
                a4Var.f11952o.launch(intent2);
                return;
        }
    }
}
