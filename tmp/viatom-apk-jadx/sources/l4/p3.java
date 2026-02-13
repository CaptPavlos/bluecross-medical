package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppInstalledDetailsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class p3 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10718a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a4 f10719b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.f f10720c;

    public /* synthetic */ p3(h5.f fVar, a4 a4Var, int i10) {
        this.f10718a = i10;
        this.f10720c = fVar;
        this.f10719b = a4Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i10 = this.f10718a;
        w6.c cVar = null;
        int i11 = 1;
        a4 a4Var = this.f10719b;
        h5.f fVar = this.f10720c;
        int i12 = 0;
        switch (i10) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    a4Var.Y(fVar.f8541w);
                    AlertDialog alertDialog = a4Var.f10935w;
                    alertDialog.getClass();
                    alertDialog.dismiss();
                    a4Var.O = false;
                    break;
                }
                break;
            case 1:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    a4Var.w0(fVar);
                    AlertDialog alertDialog2 = a4Var.f10935w;
                    alertDialog2.getClass();
                    alertDialog2.dismiss();
                    a4Var.O = false;
                    break;
                }
                break;
            case 2:
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    String str = fVar.f8526c;
                    if (str != null && str.length() != 0) {
                        PackageManager packageManager = a4Var.getPackageManager();
                        String str2 = fVar.f8526c;
                        str2.getClass();
                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str2);
                        if (launchIntentForPackage != null) {
                            a4Var.startActivity(launchIntentForPackage);
                        } else {
                            String string = a4Var.getString(R.string.error_open_app, fVar.f8525b);
                            string.getClass();
                            a4Var.N(string);
                        }
                    }
                    AlertDialog alertDialog3 = a4Var.f10935w;
                    alertDialog3.getClass();
                    alertDialog3.dismiss();
                    a4Var.O = false;
                    break;
                }
                break;
            case 3:
                float f12 = UptodownApp.E;
                if (k4.c.s()) {
                    String str3 = fVar.f8526c;
                    if (str3 != null && str3.length() != 0) {
                        String str4 = fVar.f8526c;
                        str4.getClass();
                        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str4)));
                        intent.addFlags(268435456);
                        a4Var.startActivity(intent);
                    }
                    AlertDialog alertDialog4 = a4Var.f10935w;
                    alertDialog4.getClass();
                    alertDialog4.dismiss();
                    a4Var.O = false;
                    break;
                }
                break;
            case 4:
                float f13 = UptodownApp.E;
                if (k4.c.s()) {
                    r7.y.q(LifecycleOwnerKt.getLifecycleScope(a4Var), null, null, new x3(a4Var, fVar, cVar, i12), 3);
                    AlertDialog alertDialog5 = a4Var.f10935w;
                    alertDialog5.getClass();
                    alertDialog5.dismiss();
                    a4Var.O = false;
                    break;
                }
                break;
            case 5:
                float f14 = UptodownApp.E;
                if (k4.c.s()) {
                    a4 a4Var2 = this.f10719b;
                    AlertDialog alertDialog6 = a4Var2.f10935w;
                    alertDialog6.getClass();
                    alertDialog6.dismiss();
                    a4Var2.O = false;
                    a4Var2.R = true;
                    a4Var2.N = new ArrayList();
                    String str5 = fVar.f8526c;
                    str5.getClass();
                    String str6 = fVar.f8525b;
                    str6.getClass();
                    a4Var2.N.add(new u4.b(str5, str6));
                    ArrayList arrayList3 = fVar.f8543z;
                    boolean z9 = ((arrayList3 == null || arrayList3.isEmpty()) && ((arrayList = fVar.A) == null || arrayList.isEmpty())) ? false : true;
                    String str7 = fVar.f8525b;
                    str7.getClass();
                    String str8 = fVar.f8526c;
                    str8.getClass();
                    a4Var2.i(str7, str8, fVar.f8527d, fVar.e, z9);
                    break;
                }
                break;
            case 6:
                long j10 = fVar.f8541w;
                a4 a4Var3 = this.f10719b;
                new c1.l(a4Var3, j10, new z3(a4Var3, fVar), LifecycleOwnerKt.getLifecycleScope(a4Var3));
                AlertDialog alertDialog7 = a4Var3.f10935w;
                alertDialog7.getClass();
                alertDialog7.dismiss();
                a4Var3.O = false;
                break;
            case 7:
                float f15 = UptodownApp.E;
                if (k4.c.s()) {
                    a4 a4Var4 = this.f10719b;
                    AlertDialog alertDialog8 = a4Var4.f10935w;
                    alertDialog8.getClass();
                    alertDialog8.dismiss();
                    a4Var4.O = false;
                    a4Var4.N = new ArrayList();
                    String str9 = fVar.f8526c;
                    str9.getClass();
                    String str10 = fVar.f8525b;
                    str10.getClass();
                    a4Var4.N.add(new u4.b(str9, str10));
                    ArrayList arrayList4 = fVar.f8543z;
                    boolean z10 = ((arrayList4 == null || arrayList4.isEmpty()) && ((arrayList2 = fVar.A) == null || arrayList2.isEmpty())) ? false : true;
                    String str11 = fVar.f8525b;
                    str11.getClass();
                    String str12 = fVar.f8526c;
                    str12.getClass();
                    a4Var4.i(str11, str12, fVar.f8527d, fVar.e, z10);
                    break;
                }
                break;
            case 8:
                float f16 = UptodownApp.E;
                if (k4.c.s()) {
                    AlertDialog alertDialog9 = a4Var.f10935w;
                    alertDialog9.getClass();
                    alertDialog9.dismiss();
                    a4Var.O = false;
                    if (!a4Var.isFinishing()) {
                        r7.y.q(LifecycleOwnerKt.getLifecycleScope(a4Var), null, null, new x3(a4Var, fVar, cVar, i11), 3);
                        break;
                    }
                }
                break;
            default:
                float f17 = UptodownApp.E;
                if (k4.c.s()) {
                    AlertDialog alertDialog10 = a4Var.f10935w;
                    alertDialog10.getClass();
                    alertDialog10.dismiss();
                    a4Var.O = false;
                    Intent intent2 = new Intent(a4Var, (Class<?>) AppInstalledDetailsActivity.class);
                    intent2.putExtra("appInstalled", fVar);
                    a4Var.startActivity(intent2, k4.c.a(a4Var));
                    break;
                }
                break;
        }
    }

    public /* synthetic */ p3(a4 a4Var, h5.f fVar, int i10) {
        this.f10718a = i10;
        this.f10719b = a4Var;
        this.f10720c = fVar;
    }
}
