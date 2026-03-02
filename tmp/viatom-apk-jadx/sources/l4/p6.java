package l4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserEditProfileActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class p6 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10727a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10728b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.e1 f10729c;

    public /* synthetic */ p6(h5.e1 e1Var, PublicProfileActivity publicProfileActivity) {
        this.f10727a = 3;
        this.f10729c = e1Var;
        this.f10728b = publicProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SharedPreferences sharedPreferences;
        String str;
        SharedPreferences sharedPreferences2;
        int i10 = this.f10727a;
        PublicProfileActivity publicProfileActivity = this.f10728b;
        h5.e1 e1Var = this.f10729c;
        switch (i10) {
            case 0:
                int i11 = PublicProfileActivity.K;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    publicProfileActivity.p0(1, e1Var.f8515d, e1Var.f8512a);
                    break;
                }
                break;
            case 1:
                int i12 = PublicProfileActivity.K;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    publicProfileActivity.p0(2, e1Var.f8515d, e1Var.f8512a);
                    break;
                }
                break;
            case 2:
                int i13 = PublicProfileActivity.K;
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    String str2 = e1Var.f8512a;
                    Intent intent = new Intent(publicProfileActivity, (Class<?>) UserCommentsActivity.class);
                    intent.putExtra("userID", str2);
                    publicProfileActivity.startActivity(intent, k4.c.a(publicProfileActivity));
                    break;
                }
                break;
            case 3:
                int i14 = PublicProfileActivity.K;
                if (e1Var != null) {
                    SharedPreferences sharedPreferences3 = publicProfileActivity.getSharedPreferences("SharedPreferencesUser", 0);
                    try {
                        sharedPreferences = publicProfileActivity.getSharedPreferences("SettingsPreferences", 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                    if (string != null || sharedPreferences3.getString("is_turbo", null) != null) {
                        Intent intent2 = new Intent(publicProfileActivity, (Class<?>) UserEditProfileActivity.class);
                        ActivityResultLauncher activityResultLauncher = publicProfileActivity.J;
                        float f12 = UptodownApp.E;
                        activityResultLauncher.launch(intent2, k4.c.b(publicProfileActivity));
                        break;
                    }
                }
                break;
            case 4:
                int i15 = PublicProfileActivity.K;
                Intent intent3 = new Intent(publicProfileActivity, (Class<?>) UserAvatarActivity.class);
                intent3.putExtra("user", e1Var);
                ActivityResultLauncher activityResultLauncher2 = publicProfileActivity.J;
                float f13 = UptodownApp.E;
                activityResultLauncher2.launch(intent3, k4.c.b(publicProfileActivity));
                break;
            default:
                int i16 = PublicProfileActivity.K;
                PublicProfileActivity publicProfileActivity2 = this.f10728b;
                SharedPreferences sharedPreferences4 = publicProfileActivity2.getSharedPreferences("SharedPreferencesUser", 0);
                try {
                    sharedPreferences2 = publicProfileActivity2.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                String string2 = sharedPreferences2.contains("UTOKEN") ? sharedPreferences2.getString("UTOKEN", null) : null;
                if ((string2 != null || sharedPreferences4.getString("is_turbo", null) != null) && (str = e1Var.f8512a) != null && str.length() != 0) {
                    c7 c7VarO0 = publicProfileActivity2.o0();
                    String str3 = e1Var.f8512a;
                    str3.getClass();
                    c7VarO0.getClass();
                    u7.m0 m0Var = c7VarO0.g;
                    if (m0Var.getValue() instanceof v5.l) {
                        Object value = m0Var.getValue();
                        value.getClass();
                        if (((h5.d1) ((v5.l) value).f13168a).f8505d != 1) {
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(c7VarO0);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new a7(publicProfileActivity2, str3, c7VarO0, null, 0), 2);
                            break;
                        } else {
                            r7.w viewModelScope2 = ViewModelKt.getViewModelScope(c7VarO0);
                            y7.e eVar2 = r7.i0.f12407a;
                            r7.y.q(viewModelScope2, y7.d.f14116a, null, new a7(publicProfileActivity2, str3, c7VarO0, null, 1), 2);
                            break;
                        }
                    }
                } else {
                    String string3 = publicProfileActivity2.getString(R.string.login_required_follow_title);
                    string3.getClass();
                    String string4 = publicProfileActivity2.getString(R.string.login_required_follow_msg);
                    string4.getClass();
                    a.a.q(publicProfileActivity2, string3, string4);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ p6(PublicProfileActivity publicProfileActivity, h5.e1 e1Var, int i10) {
        this.f10727a = i10;
        this.f10728b = publicProfileActivity;
        this.f10729c = e1Var;
    }
}
