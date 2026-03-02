package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h3 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10453a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyApps f10454b;

    public /* synthetic */ h3(MyApps myApps, int i10) {
        this.f10453a = i10;
        this.f10454b = myApps;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10453a;
        MyApps myApps = this.f10454b;
        switch (i10) {
            case 0:
                int i11 = MyApps.f6655j0;
                myApps.finish();
                break;
            case 1:
                int i12 = MyApps.f6655j0;
                myApps.E0().f.setIconified(false);
                break;
            case 2:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    myApps.startActivity(new Intent(myApps.getApplicationContext(), (Class<?>) PreferencesActivity.class), k4.c.a(myApps));
                    AlertDialog alertDialog = myApps.f10935w;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                        break;
                    }
                }
                break;
            default:
                AlertDialog alertDialog2 = myApps.f10935w;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
        }
    }
}
