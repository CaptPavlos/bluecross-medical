package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.PreregistrationActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e6 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10361a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreregistrationActivity f10362b;

    public /* synthetic */ e6(PreregistrationActivity preregistrationActivity, int i10) {
        this.f10361a = i10;
        this.f10362b = preregistrationActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10361a;
        PreregistrationActivity preregistrationActivity = this.f10362b;
        switch (i10) {
            case 0:
                int i11 = PreregistrationActivity.M;
                preregistrationActivity.finish();
                break;
            case 1:
                int i12 = PreregistrationActivity.M;
                h5.k kVar = new h5.k(1090, (String) null, 6);
                kVar.f8635d = true;
                preregistrationActivity.o0(kVar);
                break;
            case 2:
                int i13 = PreregistrationActivity.M;
                Intent intent = new Intent(preregistrationActivity.getApplicationContext(), (Class<?>) LoginActivity.class);
                ActivityResultLauncher activityResultLauncher = preregistrationActivity.L;
                float f = UptodownApp.E;
                activityResultLauncher.launch(intent, k4.c.b(preregistrationActivity));
                AlertDialog alertDialog = preregistrationActivity.f10935w;
                alertDialog.getClass();
                alertDialog.dismiss();
                break;
            case 3:
                int i14 = PreregistrationActivity.M;
                AlertDialog alertDialog2 = preregistrationActivity.f10935w;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                break;
            case 4:
                int i15 = PreregistrationActivity.M;
                AlertDialog alertDialog3 = preregistrationActivity.f10935w;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                break;
            default:
                int i16 = PreregistrationActivity.M;
                AlertDialog alertDialog4 = preregistrationActivity.f10935w;
                alertDialog4.getClass();
                alertDialog4.dismiss();
                break;
        }
    }
}
