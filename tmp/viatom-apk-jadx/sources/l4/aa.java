package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.PointerIconCompat;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserEditProfileActivity;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class aa implements Toolbar.OnMenuItemClickListener, ActivityResultCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10228a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserActivity f10229b;

    public /* synthetic */ aa(UserActivity userActivity, int i10) {
        this.f10228a = i10;
        this.f10229b = userActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i10 = this.f10228a;
        UserActivity userActivity = this.f10229b;
        ActivityResult activityResult = (ActivityResult) obj;
        switch (i10) {
            case 1:
                int i11 = UserActivity.Q;
                int resultCode = activityResult.getResultCode();
                if (resultCode == -1) {
                    userActivity.n0(userActivity);
                    userActivity.setResult(-1);
                    break;
                } else if (resultCode == 1) {
                    userActivity.setResult(1);
                    break;
                } else if (resultCode == 1002) {
                    Intent intent = new Intent(userActivity, (Class<?>) PreferencesActivity.class);
                    ActivityResultLauncher activityResultLauncher = userActivity.M;
                    float f = UptodownApp.E;
                    activityResultLauncher.launch(intent, k4.c.b(userActivity));
                    break;
                }
                break;
            case 2:
                int i12 = UserActivity.Q;
                int resultCode2 = activityResult.getResultCode();
                if (resultCode2 == 1003) {
                    v5.g gVarL = v5.g.f13148u.l(userActivity);
                    gVarL.a();
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.delete("responses", null, null);
                    gVarL.b();
                    userActivity.setResult(PointerIconCompat.TYPE_HELP);
                    userActivity.finish();
                    break;
                } else if (resultCode2 == 1004) {
                    float f10 = UptodownApp.E;
                    k4.c.d(userActivity);
                    userActivity.setResult(PointerIconCompat.TYPE_WAIT);
                    userActivity.finish();
                    break;
                }
                break;
            case 3:
                int i13 = UserActivity.Q;
                if (activityResult.getResultCode() == 1) {
                    userActivity.finish();
                    break;
                }
                break;
            case 4:
                int i14 = UserActivity.Q;
                if (activityResult.getResultCode() == 5) {
                    userActivity.n0(userActivity);
                    break;
                }
                break;
            default:
                int i15 = UserActivity.Q;
                if (activityResult.getResultCode() == 2) {
                    userActivity.n0(userActivity);
                    userActivity.q0();
                    break;
                }
                break;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        SharedPreferences sharedPreferences;
        int i10 = UserActivity.Q;
        menuItem.getClass();
        int itemId = menuItem.getItemId();
        final UserActivity userActivity = this.f10229b;
        final int i11 = 1;
        if (itemId == R.id.action_protect) {
            float f = UptodownApp.E;
            if (k4.c.s()) {
                userActivity.startActivity(new Intent(userActivity, (Class<?>) SecurityActivity.class), k4.c.a(userActivity));
                return true;
            }
        } else {
            final int i12 = 0;
            if (menuItem.getItemId() == R.id.action_dark_mode) {
                final kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                View viewInflate = userActivity.getLayoutInflater().inflate(R.layout.dialog_dark_mode_options, (ViewGroup) null, false);
                int i13 = R.id.rb_disabled;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_disabled);
                if (radioButton != null) {
                    i13 = R.id.rb_enabled;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_enabled);
                    if (radioButton2 != null) {
                        i13 = R.id.rb_follow_system;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(viewInflate, R.id.rb_follow_system);
                        if (radioButton3 != null) {
                            i13 = R.id.tv_title_dark_mode_options;
                            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dark_mode_options);
                            if (textView != null) {
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                textView.setTypeface(o4.b.f11719r);
                                radioButton2.setTypeface(o4.b.f11720s);
                                radioButton.setTypeface(o4.b.f11720s);
                                radioButton3.setTypeface(o4.b.f11720s);
                                String str = "system";
                                try {
                                    SharedPreferences sharedPreferences2 = userActivity.getSharedPreferences("SettingsPreferences", 0);
                                    if (sharedPreferences2.contains("dark_mode")) {
                                        String string = sharedPreferences2.getString("dark_mode", "system");
                                        string.getClass();
                                        str = string;
                                    }
                                } catch (Exception unused) {
                                }
                                if (str.equalsIgnoreCase("yes")) {
                                    radioButton2.setChecked(true);
                                } else if (str.equalsIgnoreCase("no")) {
                                    radioButton.setChecked(true);
                                } else {
                                    radioButton3.setChecked(true);
                                }
                                radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: l4.ba
                                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                                        int i14 = i12;
                                        UserActivity userActivity2 = userActivity;
                                        kotlin.jvm.internal.x xVar2 = xVar;
                                        switch (i14) {
                                            case 0:
                                                int i15 = UserActivity.Q;
                                                if (z9) {
                                                    Object obj = xVar2.f10138a;
                                                    obj.getClass();
                                                    ((AlertDialog) obj).dismiss();
                                                    try {
                                                        SharedPreferences.Editor editorEdit = userActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                        editorEdit.putString("dark_mode", "yes");
                                                        editorEdit.apply();
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                    AppCompatDelegate.setDefaultNightMode(2);
                                                    UptodownApp.Y = true;
                                                    break;
                                                }
                                                break;
                                            default:
                                                int i16 = UserActivity.Q;
                                                if (z9) {
                                                    Object obj2 = xVar2.f10138a;
                                                    obj2.getClass();
                                                    ((AlertDialog) obj2).dismiss();
                                                    try {
                                                        SharedPreferences.Editor editorEdit2 = userActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                        editorEdit2.putString("dark_mode", "no");
                                                        editorEdit2.apply();
                                                    } catch (Exception e3) {
                                                        e3.printStackTrace();
                                                    }
                                                    AppCompatDelegate.setDefaultNightMode(1);
                                                    UptodownApp.Y = true;
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                });
                                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: l4.ba
                                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                                        int i14 = i11;
                                        UserActivity userActivity2 = userActivity;
                                        kotlin.jvm.internal.x xVar2 = xVar;
                                        switch (i14) {
                                            case 0:
                                                int i15 = UserActivity.Q;
                                                if (z9) {
                                                    Object obj = xVar2.f10138a;
                                                    obj.getClass();
                                                    ((AlertDialog) obj).dismiss();
                                                    try {
                                                        SharedPreferences.Editor editorEdit = userActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                        editorEdit.putString("dark_mode", "yes");
                                                        editorEdit.apply();
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                    AppCompatDelegate.setDefaultNightMode(2);
                                                    UptodownApp.Y = true;
                                                    break;
                                                }
                                                break;
                                            default:
                                                int i16 = UserActivity.Q;
                                                if (z9) {
                                                    Object obj2 = xVar2.f10138a;
                                                    obj2.getClass();
                                                    ((AlertDialog) obj2).dismiss();
                                                    try {
                                                        SharedPreferences.Editor editorEdit2 = userActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                        editorEdit2.putString("dark_mode", "no");
                                                        editorEdit2.apply();
                                                    } catch (Exception e3) {
                                                        e3.printStackTrace();
                                                    }
                                                    AppCompatDelegate.setDefaultNightMode(1);
                                                    UptodownApp.Y = true;
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                });
                                radioButton3.setOnCheckedChangeListener(new ca(xVar, userActivity));
                                AlertDialog.Builder builder = new AlertDialog.Builder(userActivity);
                                builder.setView(coordinatorLayout);
                                builder.setCancelable(true);
                                AlertDialog alertDialogCreate = builder.create();
                                xVar.f10138a = alertDialogCreate;
                                if (alertDialogCreate != null) {
                                    Window window = alertDialogCreate.getWindow();
                                    if (window != null) {
                                        a3.a.A(window, 0);
                                    }
                                    ((AlertDialog) xVar.f10138a).show();
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i13)));
                return false;
            }
            if (menuItem.getItemId() == R.id.action_edit_profile) {
                SharedPreferences sharedPreferences3 = userActivity.getSharedPreferences("SharedPreferencesUser", 0);
                try {
                    sharedPreferences = userActivity.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String string2 = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                if (string2 == null && sharedPreferences3.getString("is_turbo", null) == null) {
                    userActivity.q0();
                } else {
                    Intent intent = new Intent(userActivity, (Class<?>) UserEditProfileActivity.class);
                    ActivityResultLauncher activityResultLauncher = userActivity.P;
                    float f10 = UptodownApp.E;
                    activityResultLauncher.launch(intent, k4.c.b(userActivity));
                }
            }
        }
        return true;
    }
}
