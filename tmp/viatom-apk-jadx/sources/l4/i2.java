package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i2 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10485a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10486b;

    public /* synthetic */ i2(int i10, MainActivity mainActivity) {
        this.f10485a = i10;
        this.f10486b = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f10485a;
        MainActivity mainActivity = this.f10486b;
        switch (i10) {
            case 0:
                int i11 = MainActivity.B0;
                Intent intent = new Intent(mainActivity, (Class<?>) Updates.class);
                float f = UptodownApp.E;
                mainActivity.startActivity(intent, k4.c.a(mainActivity));
                break;
            case 1:
                int i12 = MainActivity.B0;
                Intent intent2 = new Intent(mainActivity, (Class<?>) MyApps.class);
                float f10 = UptodownApp.E;
                mainActivity.startActivity(intent2, k4.c.a(mainActivity));
                break;
            case 2:
                int i13 = MainActivity.B0;
                Intent intent3 = new Intent(mainActivity, (Class<?>) MyDownloads.class);
                float f11 = UptodownApp.E;
                mainActivity.startActivity(intent3, k4.c.a(mainActivity));
                break;
            case 3:
                int i14 = MainActivity.B0;
                Intent intent4 = new Intent(mainActivity, (Class<?>) PreferencesActivity.class);
                ActivityResultLauncher activityResultLauncher = mainActivity.f6652w0;
                float f12 = UptodownApp.E;
                activityResultLauncher.launch(intent4, k4.c.b(mainActivity));
                break;
            case 4:
                int i15 = MainActivity.B0;
                mainActivity.U0();
                break;
            case 5:
                int i16 = MainActivity.B0;
                mainActivity.R0();
                break;
            case 6:
                int i17 = MainActivity.B0;
                Intent intent5 = new Intent(mainActivity, (Class<?>) SearchActivity.class);
                float f13 = UptodownApp.E;
                mainActivity.startActivity(intent5, k4.c.a(mainActivity));
                mainActivity.E0();
                mainActivity.H0();
                break;
            case 7:
                int i18 = MainActivity.B0;
                float f14 = UptodownApp.E;
                if (k4.c.s()) {
                    mainActivity.l0();
                    break;
                }
                break;
            case 8:
                int i19 = MainActivity.B0;
                Intent intent6 = new Intent(mainActivity, (Class<?>) UserActivity.class);
                ActivityResultLauncher activityResultLauncher2 = mainActivity.f6654y0;
                float f15 = UptodownApp.E;
                activityResultLauncher2.launch(intent6, k4.c.b(mainActivity));
                break;
            default:
                AlertDialog alertDialog = mainActivity.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
        }
    }
}
