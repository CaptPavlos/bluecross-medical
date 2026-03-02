package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class z9 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11075a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserActivity f11076b;

    public /* synthetic */ z9(UserActivity userActivity, int i10) {
        this.f11075a = i10;
        this.f11076b = userActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        int i10 = this.f11075a;
        w6.c cVar = null;
        UserActivity userActivity = this.f11076b;
        switch (i10) {
            case 0:
                int i11 = UserActivity.Q;
                userActivity.finish();
                break;
            case 1:
                int i12 = UserActivity.Q;
                h5.e1 e1VarH = h5.c1.h(userActivity);
                if (e1VarH == null) {
                    userActivity.q0();
                    break;
                } else {
                    Intent intent = new Intent(userActivity, (Class<?>) UserAvatarActivity.class);
                    intent.putExtra("user", e1VarH);
                    float f = UptodownApp.E;
                    userActivity.startActivity(intent, k4.c.a(userActivity));
                    break;
                }
            case 2:
                int i13 = UserActivity.Q;
                if (h5.c1.h(userActivity) == null) {
                    userActivity.q0();
                    break;
                }
                break;
            case 3:
                int i14 = UserActivity.Q;
                h5.e1 e1VarH2 = h5.c1.h(userActivity);
                if (e1VarH2 != null && (str = e1VarH2.f8512a) != null && str.length() != 0) {
                    c5.x xVar = new c5.x(userActivity, LifecycleOwnerKt.getLifecycleScope(userActivity));
                    String str3 = e1VarH2.f8512a;
                    str3.getClass();
                    xVar.a(str3, new n5(userActivity, 10));
                    break;
                }
                break;
            case 4:
                int i15 = UserActivity.Q;
                Intent intent2 = new Intent(userActivity, (Class<?>) Updates.class);
                float f10 = UptodownApp.E;
                userActivity.startActivity(intent2, k4.c.a(userActivity));
                break;
            case 5:
                int i16 = UserActivity.Q;
                Intent intent3 = new Intent(userActivity, (Class<?>) MyApps.class);
                float f11 = UptodownApp.E;
                userActivity.startActivity(intent3, k4.c.a(userActivity));
                break;
            case 6:
                int i17 = UserActivity.Q;
                Intent intent4 = new Intent(userActivity, (Class<?>) MyDownloads.class);
                float f12 = UptodownApp.E;
                userActivity.startActivity(intent4, k4.c.a(userActivity));
                break;
            case 7:
                int i18 = UserActivity.Q;
                Intent intent5 = new Intent(userActivity, (Class<?>) RollbackActivity.class);
                float f13 = UptodownApp.E;
                userActivity.startActivity(intent5, k4.c.a(userActivity));
                break;
            case 8:
                int i19 = UserActivity.Q;
                h5.e1 e1VarH3 = h5.c1.h(userActivity);
                if (e1VarH3 == null) {
                    userActivity.q0();
                    break;
                } else {
                    Intent intent6 = new Intent(userActivity, (Class<?>) UserCommentsActivity.class);
                    intent6.putExtra("userID", e1VarH3.f8512a);
                    float f14 = UptodownApp.E;
                    userActivity.startActivity(intent6, k4.c.a(userActivity));
                    break;
                }
            case 9:
                int i20 = UserActivity.Q;
                if (h5.c1.h(userActivity) == null) {
                    userActivity.q0();
                    break;
                } else {
                    Intent intent7 = new Intent(userActivity, (Class<?>) FeedActivity.class);
                    float f15 = UptodownApp.E;
                    userActivity.startActivity(intent7, k4.c.a(userActivity));
                    break;
                }
            case 10:
                int i21 = UserActivity.Q;
                if (h5.c1.h(userActivity) == null) {
                    userActivity.q0();
                    break;
                } else {
                    Intent intent8 = new Intent(userActivity, (Class<?>) ListsActivity.class);
                    ActivityResultLauncher activityResultLauncher = userActivity.N;
                    float f16 = UptodownApp.E;
                    activityResultLauncher.launch(intent8, k4.c.b(userActivity));
                    break;
                }
            case 11:
                int i22 = UserActivity.Q;
                if (h5.c1.h(userActivity) == null) {
                    userActivity.q0();
                    break;
                } else {
                    userActivity.startActivity(new Intent(userActivity, (Class<?>) MyStatsActivity.class));
                    break;
                }
            case 12:
                int i23 = UserActivity.Q;
                h5.e1 e1VarH4 = h5.c1.h(userActivity);
                if (e1VarH4 != null && (str2 = e1VarH4.f8512a) != null && str2.length() != 0 && e1VarH4.d()) {
                    tb tbVarP0 = userActivity.p0();
                    tbVarP0.getClass();
                    r7.w viewModelScope = ViewModelKt.getViewModelScope(tbVarP0);
                    y7.e eVar = r7.i0.f12407a;
                    r7.y.q(viewModelScope, y7.d.f14116a, null, new u4(userActivity, tbVarP0, cVar, 14), 2);
                    break;
                } else {
                    userActivity.l0();
                    break;
                }
            case 13:
                int i24 = UserActivity.Q;
                if (h5.c1.h(userActivity) == null) {
                    userActivity.q0();
                    break;
                } else {
                    ActivityResultLauncher activityResultLauncher2 = userActivity.O;
                    Intent intent9 = new Intent(userActivity, (Class<?>) UserDevicesActivity.class);
                    float f17 = UptodownApp.E;
                    activityResultLauncher2.launch(intent9, k4.c.b(userActivity));
                    break;
                }
            case 14:
                int i25 = UserActivity.Q;
                Intent intent10 = new Intent(userActivity, (Class<?>) NotificationsRegistryActivity.class);
                float f18 = UptodownApp.E;
                userActivity.startActivity(intent10, k4.c.a(userActivity));
                break;
            case 15:
                int i26 = UserActivity.Q;
                Intent intent11 = new Intent(userActivity, (Class<?>) PreferencesActivity.class);
                ActivityResultLauncher activityResultLauncher3 = userActivity.M;
                float f19 = UptodownApp.E;
                activityResultLauncher3.launch(intent11, k4.c.b(userActivity));
                break;
            case 16:
                int i27 = UserActivity.Q;
                v5.c.e(userActivity, userActivity.getString(R.string.url) + "/android", null);
                break;
            case 17:
                int i28 = UserActivity.Q;
                kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                a3.z0 z0VarK = a3.z0.k(userActivity.getLayoutInflater());
                TextView textView = (TextView) z0VarK.f198d;
                textView.setTypeface(o4.b.f11720s);
                textView.setText(userActivity.getString(R.string.log_out_confirmation_msg));
                TextView textView2 = (TextView) z0VarK.e;
                textView2.setTypeface(o4.b.f11719r);
                textView2.setOnClickListener(new e5.j(userActivity, userActivity, xVar2, 9));
                TextView textView3 = (TextView) z0VarK.f197c;
                textView3.setTypeface(o4.b.f11719r);
                textView3.setOnClickListener(new h4(xVar2, 1));
                AlertDialog.Builder builder = new AlertDialog.Builder(userActivity);
                builder.setView((LinearLayout) z0VarK.f);
                builder.setCancelable(true);
                AlertDialog alertDialogCreate = builder.create();
                xVar2.f10138a = alertDialogCreate;
                if (alertDialogCreate != null) {
                    Window window = alertDialogCreate.getWindow();
                    if (window != null) {
                        a3.a.A(window, 0);
                    }
                    ((AlertDialog) xVar2.f10138a).show();
                    break;
                }
                break;
            default:
                String str4 = userActivity.K;
                if (str4 != null) {
                    v5.c.e(userActivity, str4, null);
                    break;
                }
                break;
        }
    }
}
