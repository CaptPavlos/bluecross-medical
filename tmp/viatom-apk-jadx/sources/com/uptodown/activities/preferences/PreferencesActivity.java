package com.uptodown.activities.preferences;

import a3.x;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.window.layout.c;
import c1.w4;
import com.mbridge.msdk.dycreator.baseview.a;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import d5.k0;
import e5.j;
import g7.l;
import h5.v0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.v;
import l4.f5;
import l4.w;
import l4.x2;
import m4.h;
import o4.b;
import r0.f;
import s6.i;
import s6.m;
import t6.a0;
import w2.r;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PreferencesActivity extends w {
    public static final /* synthetic */ int M = 0;
    public final m H = new m(new x2(this, 26));
    public final w4 I = new w4(this, 3, false);
    public v0 J;
    public final ActivityResultLauncher K;
    public final ActivityResultLauncher L;

    public PreferencesActivity() {
        final int i10 = 0;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: m4.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11207b;

            {
                this.f11207b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws Resources.NotFoundException {
                int i11 = i10;
                PreferencesActivity preferencesActivity = this.f11207b;
                switch (i11) {
                    case 0:
                        int i12 = PreferencesActivity.M;
                        if (((ActivityResult) obj).getResultCode() == 1003) {
                            preferencesActivity.setResult(PointerIconCompat.TYPE_HELP);
                            preferencesActivity.finish();
                            preferencesActivity.startActivity(preferencesActivity.getIntent());
                            break;
                        }
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i13 = PreferencesActivity.M;
                        int i14 = 0;
                        if (!zBooleanValue) {
                            preferencesActivity.p0().y.f7139c.setChecked(false);
                            preferencesActivity.s0();
                            int i15 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).getInt("notification_permission_request_api33", -1) + 1;
                            try {
                                SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit.putInt("notification_permission_request_api33", i15);
                                editorEdit.apply();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (Build.VERSION.SDK_INT >= 33 && i15 >= 2 && ContextCompat.checkSelfPermission(preferencesActivity, "android.permission.POST_NOTIFICATIONS") != 0) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(preferencesActivity);
                                builder.setTitle(R.string.title_notification_dialog_permission);
                                builder.setMessage(R.string.description_notification_dialog_permission);
                                builder.setPositiveButton(R.string.button_notification_dialog_permission, new k(preferencesActivity, i14));
                                builder.create().show();
                                break;
                            }
                        } else {
                            try {
                                SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit2.putBoolean("recibir_notificaciones", true);
                                editorEdit2.apply();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            preferencesActivity.t0();
                            break;
                        }
                        break;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult.getClass();
        this.K = activityResultLauncherRegisterForActivityResult;
        final int i11 = 1;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback(this) { // from class: m4.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11207b;

            {
                this.f11207b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws Resources.NotFoundException {
                int i112 = i11;
                PreferencesActivity preferencesActivity = this.f11207b;
                switch (i112) {
                    case 0:
                        int i12 = PreferencesActivity.M;
                        if (((ActivityResult) obj).getResultCode() == 1003) {
                            preferencesActivity.setResult(PointerIconCompat.TYPE_HELP);
                            preferencesActivity.finish();
                            preferencesActivity.startActivity(preferencesActivity.getIntent());
                            break;
                        }
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i13 = PreferencesActivity.M;
                        int i14 = 0;
                        if (!zBooleanValue) {
                            preferencesActivity.p0().y.f7139c.setChecked(false);
                            preferencesActivity.s0();
                            int i15 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).getInt("notification_permission_request_api33", -1) + 1;
                            try {
                                SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit.putInt("notification_permission_request_api33", i15);
                                editorEdit.apply();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (Build.VERSION.SDK_INT >= 33 && i15 >= 2 && ContextCompat.checkSelfPermission(preferencesActivity, "android.permission.POST_NOTIFICATIONS") != 0) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(preferencesActivity);
                                builder.setTitle(R.string.title_notification_dialog_permission);
                                builder.setMessage(R.string.description_notification_dialog_permission);
                                builder.setPositiveButton(R.string.button_notification_dialog_permission, new k(preferencesActivity, i14));
                                builder.create().show();
                                break;
                            }
                        } else {
                            try {
                                SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit2.putBoolean("recibir_notificaciones", true);
                                editorEdit2.apply();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            preferencesActivity.t0();
                            break;
                        }
                        break;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.L = activityResultLauncherRegisterForActivityResult2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void finish() {
        /*
            r7 = this;
            h5.v0 r1 = new h5.v0
            r1.<init>(r7)
            h5.v0 r0 = r7.J
            if (r0 == 0) goto L41
            java.lang.String r2 = r0.f8777a
            java.lang.String r3 = r1.f8777a
            if (r2 != 0) goto L11
            if (r3 == 0) goto L19
        L11:
            if (r2 == 0) goto L41
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L41
        L19:
            boolean r2 = r0.f8778b
            boolean r3 = r1.f8778b
            if (r2 != r3) goto L41
            boolean r2 = r0.f8780d
            boolean r3 = r1.f8780d
            if (r2 != r3) goto L41
            java.lang.String r2 = r0.f8779c
            java.lang.String r3 = r1.f8779c
            r4 = 1
            boolean r2 = o7.u.Z(r2, r3, r4)
            if (r2 == 0) goto L41
            java.lang.String r2 = r0.e
            java.lang.String r3 = r1.e
            boolean r2 = kotlin.jvm.internal.l.a(r2, r3)
            if (r2 == 0) goto L41
            boolean r0 = r0.f
            boolean r2 = r1.f
            if (r0 != r2) goto L41
            goto L5a
        L41:
            h5.p r3 = new h5.p
            r3.<init>()
            r3.f(r7)
            androidx.lifecycle.LifecycleCoroutineScope r6 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r7)
            b9.p r0 = new b9.p
            r5 = 23
            r4 = 0
            r2 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = 3
            r7.y.q(r6, r4, r4, r0, r1)
        L5a:
            super.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.preferences.PreferencesActivity.finish():void");
    }

    public final void n0(String str, HashMap map, int i10, l lVar) {
        AlertDialog alertDialog;
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialog2 = this.f10935w;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        r rVarC = r.C(getLayoutInflater());
        TextView textView = (TextView) rVarC.f13464d;
        TextView textView2 = (TextView) rVarC.e;
        v vVar = new v();
        vVar.f10136a = i10;
        textView2.setTypeface(b.f11719r);
        textView2.setText(str);
        for (Map.Entry entry : map.entrySet()) {
            View viewInflate = getLayoutInflater().inflate(R.layout.settings_radio_button, (ViewGroup) null, false);
            if (viewInflate == null) {
                c.k("rootView");
                return;
            }
            RadioButton radioButton = (RadioButton) viewInflate;
            radioButton.setId(((Number) entry.getKey()).intValue());
            radioButton.setTypeface(b.f11720s);
            radioButton.setText((CharSequence) entry.getValue());
            radioButton.setOnClickListener(new f5(11, vVar, entry));
            if (((Number) entry.getKey()).intValue() == i10) {
                radioButton.setChecked(true);
            }
            ((RadioGroup) rVarC.f13463c).addView(radioButton);
        }
        textView.setTypeface(b.f11719r);
        textView.setOnClickListener(new j(lVar, vVar, this, 12));
        builder.setView((LinearLayout) rVarC.f13462b);
        this.f10935w = builder.create();
        if (isFinishing() || (alertDialog = this.f10935w) == null) {
            return;
        }
        alertDialog.setCancelable(true);
        j0();
    }

    public final String o0() throws NumberFormatException {
        String str = "0";
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("autoplay_video")) {
                String string = sharedPreferences.getString("autoplay_video", "0");
                string.getClass();
                str = string;
            }
        } catch (Exception unused) {
        }
        int i10 = Integer.parseInt(str);
        if (i10 == -1) {
            String string2 = getString(R.string.setting_play_video_array_never);
            string2.getClass();
            return string2;
        }
        if (i10 == 0) {
            String string3 = getString(R.string.setting_play_video_array_only_wifi);
            string3.getClass();
            return string3;
        }
        if (i10 != 1) {
            return "";
        }
        String string4 = getString(R.string.setting_play_video_array_wifi_and_data);
        string4.getClass();
        return string4;
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        String str;
        boolean zContains;
        File externalFilesDir;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        final int i10 = 2;
        boolean z9 = true;
        z9 = true;
        final int i11 = 0;
        super.onCreate(bundle);
        LinearLayout linearLayout = p0().f7157a;
        linearLayout.getClass();
        setContentView(linearLayout);
        this.J = new v0(this);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            p0().f7176z.setNavigationIcon(drawable);
            p0().f7176z.setNavigationContentDescription(getString(R.string.back));
        }
        final int i12 = 13;
        p0().f7176z.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i13 = i12;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i13) {
                    case 0:
                        int i14 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i15 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i16 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i17 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i18 = PreferencesActivity.M;
                        float f10 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i19 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i20 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i21 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i22 = PreferencesActivity.M;
                        String string = preferencesActivity.getString(R.string.privacy_policy_title);
                        string.getClass();
                        String string2 = preferencesActivity.getString(R.string.url_advertising);
                        string2.getClass();
                        v5.c.e(preferencesActivity, string2, string);
                        break;
                    case 9:
                        int i23 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i24 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i25 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i26 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i27 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i28 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().B.setTypeface(b.f11719r);
        p0().f7167o.e.setTypeface(b.f11719r);
        a.j(this, R.string.item_menu_idioma, p0().f7167o.e).f7167o.f7329d.setTypeface(b.f11720s);
        p0().f7167o.f7329d.setVisibility(0);
        try {
            sharedPreferences2 = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = sharedPreferences2.contains("Language") ? sharedPreferences2.getString("Language", null) : null;
        String[] stringArray = getResources().getStringArray(R.array.languageCodes);
        stringArray.getClass();
        String[] stringArray2 = getResources().getStringArray(R.array.localizedLang);
        stringArray2.getClass();
        int length = stringArray.length;
        int i13 = 0;
        while (true) {
            if (i13 >= length) {
                str = "";
                break;
            } else {
                if (stringArray[i13].equals(string)) {
                    str = stringArray2[i13];
                    str.getClass();
                    break;
                }
                i13++;
            }
        }
        p0().f7167o.f7329d.setText(str);
        p0().f7167o.f7327b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i10;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i14 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i15 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i16 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i17 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i18 = PreferencesActivity.M;
                        float f10 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i19 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i20 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i21 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i22 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string2.getClass();
                        String string22 = preferencesActivity.getString(R.string.url_advertising);
                        string22.getClass();
                        v5.c.e(preferencesActivity, string22, string2);
                        break;
                    case 9:
                        int i23 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i24 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i25 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i26 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i27 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i28 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        ((TextView) p0().C.f219c).setTypeface(b.f11719r);
        a.j(this, R.string.updates, (TextView) p0().C.f219c).E.e.setTypeface(b.f11719r);
        a.j(this, R.string.updates, p0().E.e).E.f7140d.setTypeface(b.f11720s);
        p0().E.f7140d.setText(q0());
        final HashMap mapG0 = a0.g0(new i(Integer.valueOf(Integer.parseInt("1")), getString(R.string.preference_only_notify)), new i(Integer.valueOf(Integer.parseInt("2")), getString(R.string.pref_auto_update_title)));
        RelativeLayout relativeLayout = p0().E.f7138b;
        final int i14 = true ? 1 : 0;
        relativeLayout.setOnClickListener(new View.OnClickListener(this) { // from class: m4.g

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11200b;

            {
                this.f11200b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i15 = i14;
                final int i16 = 0;
                HashMap map = mapG0;
                final PreferencesActivity preferencesActivity = this.f11200b;
                switch (i15) {
                    case 0:
                        int i17 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.updates);
                        string2.getClass();
                        final int i18 = 2;
                        preferencesActivity.n0(string2, map, Integer.parseInt(t1.x(preferencesActivity)), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i19 = i18;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i19) {
                                    case 0:
                                        int i20 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i21 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i22 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i23 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                    case 1:
                        int i19 = PreferencesActivity.M;
                        if (preferencesActivity.p0().E.f7139c.isChecked()) {
                            String string3 = preferencesActivity.getString(R.string.download_updates_automatically_title);
                            string3.getClass();
                            String str2 = "2";
                            try {
                                SharedPreferences sharedPreferences3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                                if (sharedPreferences3.contains("download_updates_options")) {
                                    String string4 = sharedPreferences3.getString("download_updates_options", "2");
                                    string4.getClass();
                                    str2 = string4;
                                }
                            } catch (Exception unused) {
                            }
                            preferencesActivity.n0(string3, map, Integer.parseInt(str2), new l() { // from class: m4.j
                                @Override // g7.l
                                public final Object invoke(Object obj) {
                                    int i192 = i16;
                                    s6.w wVar = s6.w.f12711a;
                                    PreferencesActivity preferencesActivity2 = preferencesActivity;
                                    int iIntValue = ((Integer) obj).intValue();
                                    switch (i192) {
                                        case 0:
                                            int i20 = PreferencesActivity.M;
                                            String strValueOf = String.valueOf(iIntValue);
                                            strValueOf.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit.putString("download_updates_options", strValueOf);
                                                editorEdit.apply();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                            preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                            break;
                                        case 1:
                                            int i21 = PreferencesActivity.M;
                                            String strValueOf2 = String.valueOf(iIntValue);
                                            strValueOf2.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit2.putString("autoplay_video", strValueOf2);
                                                editorEdit2.apply();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                            }
                                            ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                            break;
                                        case 2:
                                            int i22 = PreferencesActivity.M;
                                            String strValueOf3 = String.valueOf(iIntValue);
                                            strValueOf3.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit3.putString("notifications_frecuency", strValueOf3);
                                                editorEdit3.apply();
                                            } catch (Exception e10) {
                                                e10.printStackTrace();
                                            }
                                            ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                            break;
                                        default:
                                            int i23 = PreferencesActivity.M;
                                            if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                                String strValueOf4 = String.valueOf(iIntValue);
                                                strValueOf4.getClass();
                                                t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                                preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                                break;
                                            }
                                            break;
                                    }
                                    return wVar;
                                }
                            });
                            break;
                        }
                        break;
                    case 2:
                        int i20 = PreferencesActivity.M;
                        String string5 = preferencesActivity.getString(R.string.setting_title_play_video_app_details);
                        string5.getClass();
                        String str3 = "0";
                        try {
                            SharedPreferences sharedPreferences4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences4.contains("autoplay_video")) {
                                String string6 = sharedPreferences4.getString("autoplay_video", "0");
                                string6.getClass();
                                str3 = string6;
                            }
                        } catch (Exception unused2) {
                        }
                        final int i21 = 1;
                        preferencesActivity.n0(string5, map, Integer.parseInt(str3), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i192 = i21;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i192) {
                                    case 0:
                                        int i202 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i212 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i22 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i23 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                    default:
                        int i22 = PreferencesActivity.M;
                        String string7 = preferencesActivity.getString(R.string.data_saver_preference_subtitle);
                        string7.getClass();
                        String str4 = "1";
                        try {
                            SharedPreferences sharedPreferences5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences5.contains("data_saver_options")) {
                                String string8 = sharedPreferences5.getString("data_saver_options", "1");
                                string8.getClass();
                                str4 = string8;
                            }
                        } catch (Exception unused3) {
                        }
                        final int i23 = 3;
                        preferencesActivity.n0(string7, map, Integer.parseInt(str4), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i192 = i23;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i192) {
                                    case 0:
                                        int i202 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i212 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                }
            }
        });
        final int i15 = 5;
        if (t1.B(this, "download_updates_options", "2").equals("0")) {
            new w4(this, 5, false).E(p0().E.f7138b, 0.3f);
            w4 w4Var = new w4(this, 5, false);
            RelativeLayout relativeLayout2 = (RelativeLayout) p0().D.f181b;
            relativeLayout2.getClass();
            w4Var.E(relativeLayout2, 0.3f);
            p0().E.f7139c.setChecked(false);
        } else {
            new w4(this, 5, false).E(p0().E.f7138b, 1.0f);
            w4 w4Var2 = new w4(this, 5, false);
            RelativeLayout relativeLayout3 = (RelativeLayout) p0().D.f181b;
            relativeLayout3.getClass();
            w4Var2.E(relativeLayout3, 1.0f);
            p0().E.f7139c.setChecked(true);
        }
        final int i16 = 4;
        p0().E.f7139c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11196b;

            {
                this.f11196b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                int i17 = i16;
                PreferencesActivity preferencesActivity = this.f11196b;
                switch (i17) {
                    case 0:
                        int i18 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putBoolean("install_apk_as_root_system", z10);
                            editorEdit.apply();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (z10) {
                            preferencesActivity.I.R(true);
                            break;
                        }
                        break;
                    case 1:
                        int i19 = PreferencesActivity.M;
                        if (z10) {
                            preferencesActivity.t0();
                            if (Build.VERSION.SDK_INT < 33) {
                                try {
                                    SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit2.putBoolean("recibir_notificaciones", true);
                                    editorEdit2.apply();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                preferencesActivity.t0();
                                break;
                            } else {
                                preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                break;
                            }
                        } else {
                            preferencesActivity.s0();
                            try {
                                SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit3.putBoolean("recibir_notificaciones", false);
                                editorEdit3.apply();
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                    case 2:
                        int i20 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit4.putBoolean("download_notification", z10);
                            editorEdit4.apply();
                            break;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            return;
                        }
                    case 3:
                        int i21 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit5.putBoolean("installation_notification", z10);
                            editorEdit5.apply();
                            break;
                        } catch (Exception e12) {
                            e12.printStackTrace();
                            return;
                        }
                    case 4:
                        int i22 = PreferencesActivity.M;
                        if (!z10) {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                            w4 w4Var3 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout4 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout4.getClass();
                            w4Var3.E(relativeLayout4, 0.3f);
                            try {
                                SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit6.putString("download_updates_options", "0");
                                editorEdit6.apply();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                            break;
                        } else {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                            w4 w4Var4 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout5.getClass();
                            w4Var4.E(relativeLayout5, 1.0f);
                            try {
                                SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit7.putString("download_updates_options", "2");
                                editorEdit7.apply();
                            } catch (Exception e14) {
                                e14.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                            break;
                        }
                    case 5:
                        int i23 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                            editorEdit8.putBoolean("search_apk_worker_active", z10);
                            editorEdit8.apply();
                            break;
                        } catch (Exception e15) {
                            e15.printStackTrace();
                            return;
                        }
                    case 6:
                        int i24 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit9.putBoolean("animations", z10);
                            editorEdit9.apply();
                            break;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    case 7:
                        int i25 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit10.putBoolean("only_wifi", z10);
                            editorEdit10.apply();
                            break;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return;
                        }
                    default:
                        int i26 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit11.putBoolean("install_apk_rooted", z10);
                            editorEdit11.apply();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        if (z10) {
                            try {
                                r0.f.G();
                                break;
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        break;
                }
            }
        });
        ((TextView) p0().f7164l.f219c).setTypeface(b.f11719r);
        final int i17 = 11;
        a.j(this, R.string.preference_file_management, (TextView) p0().f7164l.f219c).f7165m.f7138b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i17;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i18 = PreferencesActivity.M;
                        float f10 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i19 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i20 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i21 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i22 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string2.getClass();
                        String string22 = preferencesActivity.getString(R.string.url_advertising);
                        string22.getClass();
                        v5.c.e(preferencesActivity, string22, string2);
                        break;
                    case 9:
                        int i23 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i24 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i25 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i26 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i27 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i28 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f7165m.e.setTypeface(b.f11719r);
        a.j(this, R.string.search_apk_file_worker_preference_title, p0().f7165m.e).f7165m.f7140d.setTypeface(b.f11720s);
        SwitchCompat switchCompat = a.j(this, R.string.preference_locate_files_in_storage, p0().f7165m.f7140d).f7165m.f7139c;
        try {
            sharedPreferences = getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        boolean z10 = sharedPreferences.contains("search_apk_worker_active") ? sharedPreferences.getBoolean("search_apk_worker_active", true) : true;
        switchCompat.setChecked(z10);
        p0().f7165m.f7139c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11196b;

            {
                this.f11196b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                int i172 = i15;
                PreferencesActivity preferencesActivity = this.f11196b;
                switch (i172) {
                    case 0:
                        int i18 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putBoolean("install_apk_as_root_system", z102);
                            editorEdit.apply();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (z102) {
                            preferencesActivity.I.R(true);
                            break;
                        }
                        break;
                    case 1:
                        int i19 = PreferencesActivity.M;
                        if (z102) {
                            preferencesActivity.t0();
                            if (Build.VERSION.SDK_INT < 33) {
                                try {
                                    SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit2.putBoolean("recibir_notificaciones", true);
                                    editorEdit2.apply();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                preferencesActivity.t0();
                                break;
                            } else {
                                preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                break;
                            }
                        } else {
                            preferencesActivity.s0();
                            try {
                                SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit3.putBoolean("recibir_notificaciones", false);
                                editorEdit3.apply();
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                    case 2:
                        int i20 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit4.putBoolean("download_notification", z102);
                            editorEdit4.apply();
                            break;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            return;
                        }
                    case 3:
                        int i21 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit5.putBoolean("installation_notification", z102);
                            editorEdit5.apply();
                            break;
                        } catch (Exception e12) {
                            e12.printStackTrace();
                            return;
                        }
                    case 4:
                        int i22 = PreferencesActivity.M;
                        if (!z102) {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                            w4 w4Var3 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout4 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout4.getClass();
                            w4Var3.E(relativeLayout4, 0.3f);
                            try {
                                SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit6.putString("download_updates_options", "0");
                                editorEdit6.apply();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                            break;
                        } else {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                            w4 w4Var4 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout5.getClass();
                            w4Var4.E(relativeLayout5, 1.0f);
                            try {
                                SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit7.putString("download_updates_options", "2");
                                editorEdit7.apply();
                            } catch (Exception e14) {
                                e14.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                            break;
                        }
                    case 5:
                        int i23 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                            editorEdit8.putBoolean("search_apk_worker_active", z102);
                            editorEdit8.apply();
                            break;
                        } catch (Exception e15) {
                            e15.printStackTrace();
                            return;
                        }
                    case 6:
                        int i24 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit9.putBoolean("animations", z102);
                            editorEdit9.apply();
                            break;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    case 7:
                        int i25 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit10.putBoolean("only_wifi", z102);
                            editorEdit10.apply();
                            break;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return;
                        }
                    default:
                        int i26 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit11.putBoolean("install_apk_rooted", z102);
                            editorEdit11.apply();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        if (z102) {
                            try {
                                r0.f.G();
                                break;
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        break;
                }
            }
        });
        ((TextView) p0().t.f219c).setTypeface(b.f11719r);
        final int i18 = 12;
        a.j(this, R.string.preference_performance_and_data_saver, (TextView) p0().t.f219c).f.f7138b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i18;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f10 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i19 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i20 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i21 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i22 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string2.getClass();
                        String string22 = preferencesActivity.getString(R.string.url_advertising);
                        string22.getClass();
                        v5.c.e(preferencesActivity, string22, string2);
                        break;
                    case 9:
                        int i23 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i24 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i25 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i26 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i27 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i28 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f.e.setTypeface(b.f11719r);
        final int i19 = 8;
        a.j(this, R.string.preference_title_allow_animations, p0().f.e).f.f7140d.setVisibility(8);
        SwitchCompat switchCompat2 = p0().f.f7139c;
        float f = UptodownApp.E;
        switchCompat2.setChecked(t1.r(this, "animations", true));
        final int i20 = 6;
        p0().f.f7139c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11196b;

            {
                this.f11196b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                int i172 = i20;
                PreferencesActivity preferencesActivity = this.f11196b;
                switch (i172) {
                    case 0:
                        int i182 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putBoolean("install_apk_as_root_system", z102);
                            editorEdit.apply();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (z102) {
                            preferencesActivity.I.R(true);
                            break;
                        }
                        break;
                    case 1:
                        int i192 = PreferencesActivity.M;
                        if (z102) {
                            preferencesActivity.t0();
                            if (Build.VERSION.SDK_INT < 33) {
                                try {
                                    SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit2.putBoolean("recibir_notificaciones", true);
                                    editorEdit2.apply();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                preferencesActivity.t0();
                                break;
                            } else {
                                preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                break;
                            }
                        } else {
                            preferencesActivity.s0();
                            try {
                                SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit3.putBoolean("recibir_notificaciones", false);
                                editorEdit3.apply();
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                    case 2:
                        int i202 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit4.putBoolean("download_notification", z102);
                            editorEdit4.apply();
                            break;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            return;
                        }
                    case 3:
                        int i21 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit5.putBoolean("installation_notification", z102);
                            editorEdit5.apply();
                            break;
                        } catch (Exception e12) {
                            e12.printStackTrace();
                            return;
                        }
                    case 4:
                        int i22 = PreferencesActivity.M;
                        if (!z102) {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                            w4 w4Var3 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout4 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout4.getClass();
                            w4Var3.E(relativeLayout4, 0.3f);
                            try {
                                SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit6.putString("download_updates_options", "0");
                                editorEdit6.apply();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                            break;
                        } else {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                            w4 w4Var4 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout5.getClass();
                            w4Var4.E(relativeLayout5, 1.0f);
                            try {
                                SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit7.putString("download_updates_options", "2");
                                editorEdit7.apply();
                            } catch (Exception e14) {
                                e14.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                            break;
                        }
                    case 5:
                        int i23 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                            editorEdit8.putBoolean("search_apk_worker_active", z102);
                            editorEdit8.apply();
                            break;
                        } catch (Exception e15) {
                            e15.printStackTrace();
                            return;
                        }
                    case 6:
                        int i24 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit9.putBoolean("animations", z102);
                            editorEdit9.apply();
                            break;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    case 7:
                        int i25 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit10.putBoolean("only_wifi", z102);
                            editorEdit10.apply();
                            break;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return;
                        }
                    default:
                        int i26 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit11.putBoolean("install_apk_rooted", z102);
                            editorEdit11.apply();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        if (z102) {
                            try {
                                r0.f.G();
                                break;
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        break;
                }
            }
        });
        ((TextView) p0().g.f183d).setTypeface(b.f11719r);
        ((TextView) a.j(this, R.string.setting_title_play_video_app_details, (TextView) p0().g.f183d).g.f182c).setTypeface(b.f11720s);
        ((TextView) p0().g.f182c).setText(o0());
        final int i21 = 3;
        final HashMap mapG02 = a0.g0(new i(-1, getString(R.string.setting_play_video_array_never)), new i(0, getString(R.string.setting_play_video_array_only_wifi)), new i(1, getString(R.string.setting_play_video_array_wifi_and_data)));
        ((RelativeLayout) p0().g.f181b).setOnClickListener(new View.OnClickListener(this) { // from class: m4.g

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11200b;

            {
                this.f11200b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i152 = i10;
                final int i162 = 0;
                HashMap map = mapG02;
                final PreferencesActivity preferencesActivity = this.f11200b;
                switch (i152) {
                    case 0:
                        int i172 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.updates);
                        string2.getClass();
                        final int i182 = 2;
                        preferencesActivity.n0(string2, map, Integer.parseInt(t1.x(preferencesActivity)), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i192 = i182;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i192) {
                                    case 0:
                                        int i202 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i212 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                    case 1:
                        int i192 = PreferencesActivity.M;
                        if (preferencesActivity.p0().E.f7139c.isChecked()) {
                            String string3 = preferencesActivity.getString(R.string.download_updates_automatically_title);
                            string3.getClass();
                            String str2 = "2";
                            try {
                                SharedPreferences sharedPreferences3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                                if (sharedPreferences3.contains("download_updates_options")) {
                                    String string4 = sharedPreferences3.getString("download_updates_options", "2");
                                    string4.getClass();
                                    str2 = string4;
                                }
                            } catch (Exception unused2) {
                            }
                            preferencesActivity.n0(string3, map, Integer.parseInt(str2), new l() { // from class: m4.j
                                @Override // g7.l
                                public final Object invoke(Object obj) {
                                    int i1922 = i162;
                                    s6.w wVar = s6.w.f12711a;
                                    PreferencesActivity preferencesActivity2 = preferencesActivity;
                                    int iIntValue = ((Integer) obj).intValue();
                                    switch (i1922) {
                                        case 0:
                                            int i202 = PreferencesActivity.M;
                                            String strValueOf = String.valueOf(iIntValue);
                                            strValueOf.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit.putString("download_updates_options", strValueOf);
                                                editorEdit.apply();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                            preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                            break;
                                        case 1:
                                            int i212 = PreferencesActivity.M;
                                            String strValueOf2 = String.valueOf(iIntValue);
                                            strValueOf2.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit2.putString("autoplay_video", strValueOf2);
                                                editorEdit2.apply();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                            }
                                            ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                            break;
                                        case 2:
                                            int i222 = PreferencesActivity.M;
                                            String strValueOf3 = String.valueOf(iIntValue);
                                            strValueOf3.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit3.putString("notifications_frecuency", strValueOf3);
                                                editorEdit3.apply();
                                            } catch (Exception e10) {
                                                e10.printStackTrace();
                                            }
                                            ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                            break;
                                        default:
                                            int i232 = PreferencesActivity.M;
                                            if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                                String strValueOf4 = String.valueOf(iIntValue);
                                                strValueOf4.getClass();
                                                t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                                preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                                break;
                                            }
                                            break;
                                    }
                                    return wVar;
                                }
                            });
                            break;
                        }
                        break;
                    case 2:
                        int i202 = PreferencesActivity.M;
                        String string5 = preferencesActivity.getString(R.string.setting_title_play_video_app_details);
                        string5.getClass();
                        String str3 = "0";
                        try {
                            SharedPreferences sharedPreferences4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences4.contains("autoplay_video")) {
                                String string6 = sharedPreferences4.getString("autoplay_video", "0");
                                string6.getClass();
                                str3 = string6;
                            }
                        } catch (Exception unused22) {
                        }
                        final int i212 = 1;
                        preferencesActivity.n0(string5, map, Integer.parseInt(str3), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i1922 = i212;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i1922) {
                                    case 0:
                                        int i2022 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i2122 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                    default:
                        int i22 = PreferencesActivity.M;
                        String string7 = preferencesActivity.getString(R.string.data_saver_preference_subtitle);
                        string7.getClass();
                        String str4 = "1";
                        try {
                            SharedPreferences sharedPreferences5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences5.contains("data_saver_options")) {
                                String string8 = sharedPreferences5.getString("data_saver_options", "1");
                                string8.getClass();
                                str4 = string8;
                            }
                        } catch (Exception unused3) {
                        }
                        final int i23 = 3;
                        preferencesActivity.n0(string7, map, Integer.parseInt(str4), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i1922 = i23;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i1922) {
                                    case 0:
                                        int i2022 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i2122 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                }
            }
        });
        ((TextView) p0().f7161i.f183d).setTypeface(b.f11719r);
        ((TextView) a.j(this, R.string.data_saver_preference_title, (TextView) p0().f7161i.f183d).f7161i.f182c).setTypeface(b.f11720s);
        ((TextView) p0().f7161i.f182c).setText(getString(R.string.data_saver_preference_summary));
        final HashMap mapG03 = a0.g0(new i(0, getString(R.string.data_saver_preference_save_option)), new i(1, getString(R.string.data_saver_preference_auto_option)), new i(2, getString(R.string.data_saver_preference_hd_option)));
        ((RelativeLayout) p0().f7161i.f181b).setOnClickListener(new View.OnClickListener(this) { // from class: m4.g

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11200b;

            {
                this.f11200b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i152 = i21;
                final int i162 = 0;
                HashMap map = mapG03;
                final PreferencesActivity preferencesActivity = this.f11200b;
                switch (i152) {
                    case 0:
                        int i172 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.updates);
                        string2.getClass();
                        final int i182 = 2;
                        preferencesActivity.n0(string2, map, Integer.parseInt(t1.x(preferencesActivity)), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i1922 = i182;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i1922) {
                                    case 0:
                                        int i2022 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i2122 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                    case 1:
                        int i192 = PreferencesActivity.M;
                        if (preferencesActivity.p0().E.f7139c.isChecked()) {
                            String string3 = preferencesActivity.getString(R.string.download_updates_automatically_title);
                            string3.getClass();
                            String str2 = "2";
                            try {
                                SharedPreferences sharedPreferences3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                                if (sharedPreferences3.contains("download_updates_options")) {
                                    String string4 = sharedPreferences3.getString("download_updates_options", "2");
                                    string4.getClass();
                                    str2 = string4;
                                }
                            } catch (Exception unused2) {
                            }
                            preferencesActivity.n0(string3, map, Integer.parseInt(str2), new l() { // from class: m4.j
                                @Override // g7.l
                                public final Object invoke(Object obj) {
                                    int i1922 = i162;
                                    s6.w wVar = s6.w.f12711a;
                                    PreferencesActivity preferencesActivity2 = preferencesActivity;
                                    int iIntValue = ((Integer) obj).intValue();
                                    switch (i1922) {
                                        case 0:
                                            int i2022 = PreferencesActivity.M;
                                            String strValueOf = String.valueOf(iIntValue);
                                            strValueOf.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit.putString("download_updates_options", strValueOf);
                                                editorEdit.apply();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                            preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                            break;
                                        case 1:
                                            int i2122 = PreferencesActivity.M;
                                            String strValueOf2 = String.valueOf(iIntValue);
                                            strValueOf2.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit2.putString("autoplay_video", strValueOf2);
                                                editorEdit2.apply();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                            }
                                            ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                            break;
                                        case 2:
                                            int i222 = PreferencesActivity.M;
                                            String strValueOf3 = String.valueOf(iIntValue);
                                            strValueOf3.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit3.putString("notifications_frecuency", strValueOf3);
                                                editorEdit3.apply();
                                            } catch (Exception e10) {
                                                e10.printStackTrace();
                                            }
                                            ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                            break;
                                        default:
                                            int i232 = PreferencesActivity.M;
                                            if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                                String strValueOf4 = String.valueOf(iIntValue);
                                                strValueOf4.getClass();
                                                t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                                preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                                break;
                                            }
                                            break;
                                    }
                                    return wVar;
                                }
                            });
                            break;
                        }
                        break;
                    case 2:
                        int i202 = PreferencesActivity.M;
                        String string5 = preferencesActivity.getString(R.string.setting_title_play_video_app_details);
                        string5.getClass();
                        String str3 = "0";
                        try {
                            SharedPreferences sharedPreferences4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences4.contains("autoplay_video")) {
                                String string6 = sharedPreferences4.getString("autoplay_video", "0");
                                string6.getClass();
                                str3 = string6;
                            }
                        } catch (Exception unused22) {
                        }
                        final int i212 = 1;
                        preferencesActivity.n0(string5, map, Integer.parseInt(str3), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i1922 = i212;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i1922) {
                                    case 0:
                                        int i2022 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i2122 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                    default:
                        int i22 = PreferencesActivity.M;
                        String string7 = preferencesActivity.getString(R.string.data_saver_preference_subtitle);
                        string7.getClass();
                        String str4 = "1";
                        try {
                            SharedPreferences sharedPreferences5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences5.contains("data_saver_options")) {
                                String string8 = sharedPreferences5.getString("data_saver_options", "1");
                                string8.getClass();
                                str4 = string8;
                            }
                        } catch (Exception unused3) {
                        }
                        final int i23 = 3;
                        preferencesActivity.n0(string7, map, Integer.parseInt(str4), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i1922 = i23;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i1922) {
                                    case 0:
                                        int i2022 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i2122 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                }
            }
        });
        final int i22 = 14;
        p0().f7171s.f7138b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i22;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string2.getClass();
                        String string22 = preferencesActivity.getString(R.string.url_advertising);
                        string22.getClass();
                        v5.c.e(preferencesActivity, string22, string2);
                        break;
                    case 9:
                        int i23 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i24 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i25 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i26 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i27 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i28 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f7171s.e.setTypeface(b.f11719r);
        a.j(this, R.string.solo_wifi, p0().f7171s.e).f7171s.f7140d.setTypeface(b.f11720s);
        a.j(this, R.string.solo_wifi_desc, p0().f7171s.f7140d).f7171s.f7139c.setChecked(t1.r(this, "only_wifi", true));
        final int i23 = 7;
        p0().f7171s.f7139c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11196b;

            {
                this.f11196b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                int i172 = i23;
                PreferencesActivity preferencesActivity = this.f11196b;
                switch (i172) {
                    case 0:
                        int i182 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putBoolean("install_apk_as_root_system", z102);
                            editorEdit.apply();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (z102) {
                            preferencesActivity.I.R(true);
                            break;
                        }
                        break;
                    case 1:
                        int i192 = PreferencesActivity.M;
                        if (z102) {
                            preferencesActivity.t0();
                            if (Build.VERSION.SDK_INT < 33) {
                                try {
                                    SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit2.putBoolean("recibir_notificaciones", true);
                                    editorEdit2.apply();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                preferencesActivity.t0();
                                break;
                            } else {
                                preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                break;
                            }
                        } else {
                            preferencesActivity.s0();
                            try {
                                SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit3.putBoolean("recibir_notificaciones", false);
                                editorEdit3.apply();
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                    case 2:
                        int i202 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit4.putBoolean("download_notification", z102);
                            editorEdit4.apply();
                            break;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            return;
                        }
                    case 3:
                        int i212 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit5.putBoolean("installation_notification", z102);
                            editorEdit5.apply();
                            break;
                        } catch (Exception e12) {
                            e12.printStackTrace();
                            return;
                        }
                    case 4:
                        int i222 = PreferencesActivity.M;
                        if (!z102) {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                            w4 w4Var3 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout4 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout4.getClass();
                            w4Var3.E(relativeLayout4, 0.3f);
                            try {
                                SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit6.putString("download_updates_options", "0");
                                editorEdit6.apply();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                            break;
                        } else {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                            w4 w4Var4 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout5.getClass();
                            w4Var4.E(relativeLayout5, 1.0f);
                            try {
                                SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit7.putString("download_updates_options", "2");
                                editorEdit7.apply();
                            } catch (Exception e14) {
                                e14.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                            break;
                        }
                    case 5:
                        int i232 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                            editorEdit8.putBoolean("search_apk_worker_active", z102);
                            editorEdit8.apply();
                            break;
                        } catch (Exception e15) {
                            e15.printStackTrace();
                            return;
                        }
                    case 6:
                        int i24 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit9.putBoolean("animations", z102);
                            editorEdit9.apply();
                            break;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    case 7:
                        int i25 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit10.putBoolean("only_wifi", z102);
                            editorEdit10.apply();
                            break;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return;
                        }
                    default:
                        int i26 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit11.putBoolean("install_apk_rooted", z102);
                            editorEdit11.apply();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        if (z102) {
                            try {
                                r0.f.G();
                                break;
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        break;
                }
            }
        });
        if (this.I.g("system_app", false) || f.G()) {
            ((TextView) p0().f7175x.f219c).setTypeface(b.f11719r);
            final int i24 = 15;
            a.j(this, R.string.pref_category_title_install_as_root_system, (TextView) p0().f7175x.f219c).h.f7138b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ PreferencesActivity f11198b;

                {
                    this.f11198b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i132 = i24;
                    PreferencesActivity preferencesActivity = this.f11198b;
                    switch (i132) {
                        case 0:
                            int i142 = PreferencesActivity.M;
                            preferencesActivity.p0().y.f7139c.performClick();
                            break;
                        case 1:
                            int i152 = PreferencesActivity.M;
                            preferencesActivity.p0().f7162j.f7139c.performClick();
                            break;
                        case 2:
                            int i162 = PreferencesActivity.M;
                            Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                            ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                            float f10 = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                            break;
                        case 3:
                            int i172 = PreferencesActivity.M;
                            preferencesActivity.p0().f7166n.f7139c.performClick();
                            break;
                        case 4:
                            int i182 = PreferencesActivity.M;
                            float f102 = UptodownApp.E;
                            if (!k4.c.m(preferencesActivity)) {
                                preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                                break;
                            } else {
                                preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                                break;
                            }
                        case 5:
                            int i192 = PreferencesActivity.M;
                            Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                            intent2.putExtra("advanced_settings_index", 3);
                            float f11 = UptodownApp.E;
                            preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                            break;
                        case 6:
                            int i202 = PreferencesActivity.M;
                            Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                            intent3.putExtra("advanced_settings_index", 0);
                            float f12 = UptodownApp.E;
                            preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                            break;
                        case 7:
                            int i212 = PreferencesActivity.M;
                            Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                            intent4.putExtra("advanced_settings_index", 1);
                            float f13 = UptodownApp.E;
                            preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                            break;
                        case 8:
                            int i222 = PreferencesActivity.M;
                            String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                            string2.getClass();
                            String string22 = preferencesActivity.getString(R.string.url_advertising);
                            string22.getClass();
                            v5.c.e(preferencesActivity, string22, string2);
                            break;
                        case 9:
                            int i232 = PreferencesActivity.M;
                            Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                            intent5.putExtra("advanced_settings_index", 2);
                            float f14 = UptodownApp.E;
                            preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                            break;
                        case 10:
                            int i242 = PreferencesActivity.M;
                            Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                            intent6.putExtra("advanced_settings_index", 4);
                            float f15 = UptodownApp.E;
                            preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                            break;
                        case 11:
                            int i25 = PreferencesActivity.M;
                            preferencesActivity.p0().f7165m.f7139c.performClick();
                            break;
                        case 12:
                            int i26 = PreferencesActivity.M;
                            preferencesActivity.p0().f.f7139c.performClick();
                            break;
                        case 13:
                            int i27 = PreferencesActivity.M;
                            preferencesActivity.finish();
                            break;
                        case 14:
                            int i28 = PreferencesActivity.M;
                            preferencesActivity.p0().f7171s.f7139c.performClick();
                            break;
                        case 15:
                            int i29 = PreferencesActivity.M;
                            preferencesActivity.p0().h.f7139c.performClick();
                            break;
                        default:
                            int i30 = PreferencesActivity.M;
                            preferencesActivity.p0().f7174w.f7139c.performClick();
                            break;
                    }
                }
            });
            p0().h.e.setTypeface(b.f11719r);
            a.j(this, R.string.pref_auto_update_title, p0().h.e).h.f7140d.setTypeface(b.f11720s);
            a.j(this, R.string.pref_auto_update_sumary, p0().h.f7140d).h.f7139c.setChecked(t1.r(this, "install_apk_rooted", false));
            p0().h.f7139c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ PreferencesActivity f11196b;

                {
                    this.f11196b = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                    int i172 = i19;
                    PreferencesActivity preferencesActivity = this.f11196b;
                    switch (i172) {
                        case 0:
                            int i182 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit.putBoolean("install_apk_as_root_system", z102);
                                editorEdit.apply();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            if (z102) {
                                preferencesActivity.I.R(true);
                                break;
                            }
                            break;
                        case 1:
                            int i192 = PreferencesActivity.M;
                            if (z102) {
                                preferencesActivity.t0();
                                if (Build.VERSION.SDK_INT < 33) {
                                    try {
                                        SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                        editorEdit2.putBoolean("recibir_notificaciones", true);
                                        editorEdit2.apply();
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                    }
                                    preferencesActivity.t0();
                                    break;
                                } else {
                                    preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                    break;
                                }
                            } else {
                                preferencesActivity.s0();
                                try {
                                    SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit3.putBoolean("recibir_notificaciones", false);
                                    editorEdit3.apply();
                                    break;
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                    return;
                                }
                            }
                        case 2:
                            int i202 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit4.putBoolean("download_notification", z102);
                                editorEdit4.apply();
                                break;
                            } catch (Exception e11) {
                                e11.printStackTrace();
                                return;
                            }
                        case 3:
                            int i212 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit5.putBoolean("installation_notification", z102);
                                editorEdit5.apply();
                                break;
                            } catch (Exception e12) {
                                e12.printStackTrace();
                                return;
                            }
                        case 4:
                            int i222 = PreferencesActivity.M;
                            if (!z102) {
                                new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                                w4 w4Var3 = new w4(preferencesActivity, 5, false);
                                RelativeLayout relativeLayout4 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                                relativeLayout4.getClass();
                                w4Var3.E(relativeLayout4, 0.3f);
                                try {
                                    SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit6.putString("download_updates_options", "0");
                                    editorEdit6.apply();
                                } catch (Exception e13) {
                                    e13.printStackTrace();
                                }
                                preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                                break;
                            } else {
                                new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                                w4 w4Var4 = new w4(preferencesActivity, 5, false);
                                RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                                relativeLayout5.getClass();
                                w4Var4.E(relativeLayout5, 1.0f);
                                try {
                                    SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit7.putString("download_updates_options", "2");
                                    editorEdit7.apply();
                                } catch (Exception e14) {
                                    e14.printStackTrace();
                                }
                                preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                                break;
                            }
                        case 5:
                            int i232 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                                editorEdit8.putBoolean("search_apk_worker_active", z102);
                                editorEdit8.apply();
                                break;
                            } catch (Exception e15) {
                                e15.printStackTrace();
                                return;
                            }
                        case 6:
                            int i242 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit9.putBoolean("animations", z102);
                                editorEdit9.apply();
                                break;
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                return;
                            }
                        case 7:
                            int i25 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit10.putBoolean("only_wifi", z102);
                                editorEdit10.apply();
                                break;
                            } catch (Exception e17) {
                                e17.printStackTrace();
                                return;
                            }
                        default:
                            int i26 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit11.putBoolean("install_apk_rooted", z102);
                                editorEdit11.apply();
                            } catch (Exception e18) {
                                e18.printStackTrace();
                            }
                            if (z102) {
                                try {
                                    r0.f.G();
                                    break;
                                } catch (Exception e19) {
                                    e19.printStackTrace();
                                }
                            }
                            break;
                    }
                }
            });
            final int i25 = 16;
            p0().f7174w.f7138b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ PreferencesActivity f11198b;

                {
                    this.f11198b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i132 = i25;
                    PreferencesActivity preferencesActivity = this.f11198b;
                    switch (i132) {
                        case 0:
                            int i142 = PreferencesActivity.M;
                            preferencesActivity.p0().y.f7139c.performClick();
                            break;
                        case 1:
                            int i152 = PreferencesActivity.M;
                            preferencesActivity.p0().f7162j.f7139c.performClick();
                            break;
                        case 2:
                            int i162 = PreferencesActivity.M;
                            Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                            ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                            float f10 = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                            break;
                        case 3:
                            int i172 = PreferencesActivity.M;
                            preferencesActivity.p0().f7166n.f7139c.performClick();
                            break;
                        case 4:
                            int i182 = PreferencesActivity.M;
                            float f102 = UptodownApp.E;
                            if (!k4.c.m(preferencesActivity)) {
                                preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                                break;
                            } else {
                                preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                                break;
                            }
                        case 5:
                            int i192 = PreferencesActivity.M;
                            Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                            intent2.putExtra("advanced_settings_index", 3);
                            float f11 = UptodownApp.E;
                            preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                            break;
                        case 6:
                            int i202 = PreferencesActivity.M;
                            Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                            intent3.putExtra("advanced_settings_index", 0);
                            float f12 = UptodownApp.E;
                            preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                            break;
                        case 7:
                            int i212 = PreferencesActivity.M;
                            Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                            intent4.putExtra("advanced_settings_index", 1);
                            float f13 = UptodownApp.E;
                            preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                            break;
                        case 8:
                            int i222 = PreferencesActivity.M;
                            String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                            string2.getClass();
                            String string22 = preferencesActivity.getString(R.string.url_advertising);
                            string22.getClass();
                            v5.c.e(preferencesActivity, string22, string2);
                            break;
                        case 9:
                            int i232 = PreferencesActivity.M;
                            Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                            intent5.putExtra("advanced_settings_index", 2);
                            float f14 = UptodownApp.E;
                            preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                            break;
                        case 10:
                            int i242 = PreferencesActivity.M;
                            Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                            intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                            intent6.putExtra("advanced_settings_index", 4);
                            float f15 = UptodownApp.E;
                            preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                            break;
                        case 11:
                            int i252 = PreferencesActivity.M;
                            preferencesActivity.p0().f7165m.f7139c.performClick();
                            break;
                        case 12:
                            int i26 = PreferencesActivity.M;
                            preferencesActivity.p0().f.f7139c.performClick();
                            break;
                        case 13:
                            int i27 = PreferencesActivity.M;
                            preferencesActivity.finish();
                            break;
                        case 14:
                            int i28 = PreferencesActivity.M;
                            preferencesActivity.p0().f7171s.f7139c.performClick();
                            break;
                        case 15:
                            int i29 = PreferencesActivity.M;
                            preferencesActivity.p0().h.f7139c.performClick();
                            break;
                        default:
                            int i30 = PreferencesActivity.M;
                            preferencesActivity.p0().f7174w.f7139c.performClick();
                            break;
                    }
                }
            });
            p0().f7174w.e.setTypeface(b.f11719r);
            a.j(this, R.string.pref_install_apk_as_root_system_title, p0().f7174w.e).f7174w.f7140d.setTypeface(b.f11720s);
            a.j(this, R.string.pref_install_apk_as_root_system_summary, p0().f7174w.f7140d).f7174w.f7139c.setChecked(t1.r(this, "install_apk_as_root_system", false));
            p0().f7174w.f7139c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ PreferencesActivity f11196b;

                {
                    this.f11196b = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                    int i172 = i11;
                    PreferencesActivity preferencesActivity = this.f11196b;
                    switch (i172) {
                        case 0:
                            int i182 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit.putBoolean("install_apk_as_root_system", z102);
                                editorEdit.apply();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            if (z102) {
                                preferencesActivity.I.R(true);
                                break;
                            }
                            break;
                        case 1:
                            int i192 = PreferencesActivity.M;
                            if (z102) {
                                preferencesActivity.t0();
                                if (Build.VERSION.SDK_INT < 33) {
                                    try {
                                        SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                        editorEdit2.putBoolean("recibir_notificaciones", true);
                                        editorEdit2.apply();
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                    }
                                    preferencesActivity.t0();
                                    break;
                                } else {
                                    preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                    break;
                                }
                            } else {
                                preferencesActivity.s0();
                                try {
                                    SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit3.putBoolean("recibir_notificaciones", false);
                                    editorEdit3.apply();
                                    break;
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                    return;
                                }
                            }
                        case 2:
                            int i202 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit4.putBoolean("download_notification", z102);
                                editorEdit4.apply();
                                break;
                            } catch (Exception e11) {
                                e11.printStackTrace();
                                return;
                            }
                        case 3:
                            int i212 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit5.putBoolean("installation_notification", z102);
                                editorEdit5.apply();
                                break;
                            } catch (Exception e12) {
                                e12.printStackTrace();
                                return;
                            }
                        case 4:
                            int i222 = PreferencesActivity.M;
                            if (!z102) {
                                new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                                w4 w4Var3 = new w4(preferencesActivity, 5, false);
                                RelativeLayout relativeLayout4 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                                relativeLayout4.getClass();
                                w4Var3.E(relativeLayout4, 0.3f);
                                try {
                                    SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit6.putString("download_updates_options", "0");
                                    editorEdit6.apply();
                                } catch (Exception e13) {
                                    e13.printStackTrace();
                                }
                                preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                                break;
                            } else {
                                new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                                w4 w4Var4 = new w4(preferencesActivity, 5, false);
                                RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                                relativeLayout5.getClass();
                                w4Var4.E(relativeLayout5, 1.0f);
                                try {
                                    SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit7.putString("download_updates_options", "2");
                                    editorEdit7.apply();
                                } catch (Exception e14) {
                                    e14.printStackTrace();
                                }
                                preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                                break;
                            }
                        case 5:
                            int i232 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                                editorEdit8.putBoolean("search_apk_worker_active", z102);
                                editorEdit8.apply();
                                break;
                            } catch (Exception e15) {
                                e15.printStackTrace();
                                return;
                            }
                        case 6:
                            int i242 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit9.putBoolean("animations", z102);
                                editorEdit9.apply();
                                break;
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                return;
                            }
                        case 7:
                            int i252 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit10.putBoolean("only_wifi", z102);
                                editorEdit10.apply();
                                break;
                            } catch (Exception e17) {
                                e17.printStackTrace();
                                return;
                            }
                        default:
                            int i26 = PreferencesActivity.M;
                            try {
                                SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit11.putBoolean("install_apk_rooted", z102);
                                editorEdit11.apply();
                            } catch (Exception e18) {
                                e18.printStackTrace();
                            }
                            if (z102) {
                                try {
                                    r0.f.G();
                                    break;
                                } catch (Exception e19) {
                                    e19.printStackTrace();
                                }
                            }
                            break;
                    }
                }
            });
        } else {
            ((TextView) p0().f7175x.f219c).setVisibility(8);
            p0().h.f7138b.setVisibility(8);
            p0().f7174w.f7138b.setVisibility(8);
        }
        ((TextView) p0().f7170r.f219c).setTypeface(b.f11719r);
        a.j(this, R.string.recibir_notificaciones, (TextView) p0().f7170r.f219c).y.f7138b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i11;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string2.getClass();
                        String string22 = preferencesActivity.getString(R.string.url_advertising);
                        string22.getClass();
                        v5.c.e(preferencesActivity, string22, string2);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i26 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i27 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i28 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().y.e.setTypeface(b.f11719r);
        a.j(this, R.string.preference_notifications, p0().y.e).y.f7140d.setTypeface(b.f11720s);
        if (t1.r(this, "recibir_notificaciones", true)) {
            p0().y.f7140d.setText(getString(R.string.enabled));
        } else {
            p0().y.f7140d.setText(getString(R.string.disabled));
        }
        SwitchCompat switchCompat3 = p0().y.f7139c;
        final int i26 = true ? 1 : 0;
        switchCompat3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11196b;

            {
                this.f11196b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                int i172 = i26;
                PreferencesActivity preferencesActivity = this.f11196b;
                switch (i172) {
                    case 0:
                        int i182 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putBoolean("install_apk_as_root_system", z102);
                            editorEdit.apply();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (z102) {
                            preferencesActivity.I.R(true);
                            break;
                        }
                        break;
                    case 1:
                        int i192 = PreferencesActivity.M;
                        if (z102) {
                            preferencesActivity.t0();
                            if (Build.VERSION.SDK_INT < 33) {
                                try {
                                    SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit2.putBoolean("recibir_notificaciones", true);
                                    editorEdit2.apply();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                preferencesActivity.t0();
                                break;
                            } else {
                                preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                break;
                            }
                        } else {
                            preferencesActivity.s0();
                            try {
                                SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit3.putBoolean("recibir_notificaciones", false);
                                editorEdit3.apply();
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                    case 2:
                        int i202 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit4.putBoolean("download_notification", z102);
                            editorEdit4.apply();
                            break;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            return;
                        }
                    case 3:
                        int i212 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit5.putBoolean("installation_notification", z102);
                            editorEdit5.apply();
                            break;
                        } catch (Exception e12) {
                            e12.printStackTrace();
                            return;
                        }
                    case 4:
                        int i222 = PreferencesActivity.M;
                        if (!z102) {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                            w4 w4Var3 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout4 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout4.getClass();
                            w4Var3.E(relativeLayout4, 0.3f);
                            try {
                                SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit6.putString("download_updates_options", "0");
                                editorEdit6.apply();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                            break;
                        } else {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                            w4 w4Var4 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout5.getClass();
                            w4Var4.E(relativeLayout5, 1.0f);
                            try {
                                SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit7.putString("download_updates_options", "2");
                                editorEdit7.apply();
                            } catch (Exception e14) {
                                e14.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                            break;
                        }
                    case 5:
                        int i232 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                            editorEdit8.putBoolean("search_apk_worker_active", z102);
                            editorEdit8.apply();
                            break;
                        } catch (Exception e15) {
                            e15.printStackTrace();
                            return;
                        }
                    case 6:
                        int i242 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit9.putBoolean("animations", z102);
                            editorEdit9.apply();
                            break;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    case 7:
                        int i252 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit10.putBoolean("only_wifi", z102);
                            editorEdit10.apply();
                            break;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return;
                        }
                    default:
                        int i262 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit11.putBoolean("install_apk_rooted", z102);
                            editorEdit11.apply();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        if (z102) {
                            try {
                                r0.f.G();
                                break;
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        break;
                }
            }
        });
        ((TextView) p0().D.f183d).setTypeface(b.f11719r);
        ((TextView) a.j(this, R.string.updates, (TextView) p0().D.f183d).D.f182c).setTypeface(b.f11720s);
        ((TextView) p0().D.f182c).setText(r0());
        final HashMap mapG04 = a0.g0(new i(1, getString(R.string.answer_always)), new i(2, getString(R.string.answer_daily)), new i(3, getString(R.string.answer_weekly)), new i(4, getString(R.string.answer_never)));
        ((RelativeLayout) p0().D.f181b).setOnClickListener(new View.OnClickListener(this) { // from class: m4.g

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11200b;

            {
                this.f11200b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i152 = i11;
                final int i162 = 0;
                HashMap map = mapG04;
                final PreferencesActivity preferencesActivity = this.f11200b;
                switch (i152) {
                    case 0:
                        int i172 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.updates);
                        string2.getClass();
                        final int i182 = 2;
                        preferencesActivity.n0(string2, map, Integer.parseInt(t1.x(preferencesActivity)), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i1922 = i182;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i1922) {
                                    case 0:
                                        int i2022 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i2122 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                    case 1:
                        int i192 = PreferencesActivity.M;
                        if (preferencesActivity.p0().E.f7139c.isChecked()) {
                            String string3 = preferencesActivity.getString(R.string.download_updates_automatically_title);
                            string3.getClass();
                            String str2 = "2";
                            try {
                                SharedPreferences sharedPreferences3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                                if (sharedPreferences3.contains("download_updates_options")) {
                                    String string4 = sharedPreferences3.getString("download_updates_options", "2");
                                    string4.getClass();
                                    str2 = string4;
                                }
                            } catch (Exception unused2) {
                            }
                            preferencesActivity.n0(string3, map, Integer.parseInt(str2), new l() { // from class: m4.j
                                @Override // g7.l
                                public final Object invoke(Object obj) {
                                    int i1922 = i162;
                                    s6.w wVar = s6.w.f12711a;
                                    PreferencesActivity preferencesActivity2 = preferencesActivity;
                                    int iIntValue = ((Integer) obj).intValue();
                                    switch (i1922) {
                                        case 0:
                                            int i2022 = PreferencesActivity.M;
                                            String strValueOf = String.valueOf(iIntValue);
                                            strValueOf.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit.putString("download_updates_options", strValueOf);
                                                editorEdit.apply();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                            preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                            break;
                                        case 1:
                                            int i2122 = PreferencesActivity.M;
                                            String strValueOf2 = String.valueOf(iIntValue);
                                            strValueOf2.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit2.putString("autoplay_video", strValueOf2);
                                                editorEdit2.apply();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                            }
                                            ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                            break;
                                        case 2:
                                            int i222 = PreferencesActivity.M;
                                            String strValueOf3 = String.valueOf(iIntValue);
                                            strValueOf3.getClass();
                                            try {
                                                SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                                editorEdit3.putString("notifications_frecuency", strValueOf3);
                                                editorEdit3.apply();
                                            } catch (Exception e10) {
                                                e10.printStackTrace();
                                            }
                                            ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                            break;
                                        default:
                                            int i232 = PreferencesActivity.M;
                                            if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                                String strValueOf4 = String.valueOf(iIntValue);
                                                strValueOf4.getClass();
                                                t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                                preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                                break;
                                            }
                                            break;
                                    }
                                    return wVar;
                                }
                            });
                            break;
                        }
                        break;
                    case 2:
                        int i202 = PreferencesActivity.M;
                        String string5 = preferencesActivity.getString(R.string.setting_title_play_video_app_details);
                        string5.getClass();
                        String str3 = "0";
                        try {
                            SharedPreferences sharedPreferences4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences4.contains("autoplay_video")) {
                                String string6 = sharedPreferences4.getString("autoplay_video", "0");
                                string6.getClass();
                                str3 = string6;
                            }
                        } catch (Exception unused22) {
                        }
                        final int i212 = 1;
                        preferencesActivity.n0(string5, map, Integer.parseInt(str3), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i1922 = i212;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i1922) {
                                    case 0:
                                        int i2022 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i2122 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i232 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                    default:
                        int i222 = PreferencesActivity.M;
                        String string7 = preferencesActivity.getString(R.string.data_saver_preference_subtitle);
                        string7.getClass();
                        String str4 = "1";
                        try {
                            SharedPreferences sharedPreferences5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences5.contains("data_saver_options")) {
                                String string8 = sharedPreferences5.getString("data_saver_options", "1");
                                string8.getClass();
                                str4 = string8;
                            }
                        } catch (Exception unused3) {
                        }
                        final int i232 = 3;
                        preferencesActivity.n0(string7, map, Integer.parseInt(str4), new l() { // from class: m4.j
                            @Override // g7.l
                            public final Object invoke(Object obj) {
                                int i1922 = i232;
                                s6.w wVar = s6.w.f12711a;
                                PreferencesActivity preferencesActivity2 = preferencesActivity;
                                int iIntValue = ((Integer) obj).intValue();
                                switch (i1922) {
                                    case 0:
                                        int i2022 = PreferencesActivity.M;
                                        String strValueOf = String.valueOf(iIntValue);
                                        strValueOf.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit.putString("download_updates_options", strValueOf);
                                            editorEdit.apply();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                        preferencesActivity2.p0().E.f7140d.setText(preferencesActivity2.q0());
                                        break;
                                    case 1:
                                        int i2122 = PreferencesActivity.M;
                                        String strValueOf2 = String.valueOf(iIntValue);
                                        strValueOf2.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit2 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit2.putString("autoplay_video", strValueOf2);
                                            editorEdit2.apply();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().g.f182c).setText(preferencesActivity2.o0());
                                        break;
                                    case 2:
                                        int i2222 = PreferencesActivity.M;
                                        String strValueOf3 = String.valueOf(iIntValue);
                                        strValueOf3.getClass();
                                        try {
                                            SharedPreferences.Editor editorEdit3 = preferencesActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                            editorEdit3.putString("notifications_frecuency", strValueOf3);
                                            editorEdit3.apply();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                        ((TextView) preferencesActivity2.p0().D.f182c).setText(preferencesActivity2.r0());
                                        break;
                                    default:
                                        int i2322 = PreferencesActivity.M;
                                        if (Integer.parseInt(t1.B(preferencesActivity2, "data_saver_options", "1")) != iIntValue) {
                                            String strValueOf4 = String.valueOf(iIntValue);
                                            strValueOf4.getClass();
                                            t1.R(preferencesActivity2, "data_saver_options", strValueOf4);
                                            preferencesActivity2.setResult(PointerIconCompat.TYPE_WAIT);
                                            break;
                                        }
                                        break;
                                }
                                return wVar;
                            }
                        });
                        break;
                }
            }
        });
        RelativeLayout relativeLayout4 = p0().f7162j.f7138b;
        final int i27 = true ? 1 : 0;
        relativeLayout4.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i27;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string2.getClass();
                        String string22 = preferencesActivity.getString(R.string.url_advertising);
                        string22.getClass();
                        v5.c.e(preferencesActivity, string22, string2);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i28 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f7162j.e.setTypeface(b.f11719r);
        a.j(this, R.string.downloads_title, p0().f7162j.e).f7162j.f7140d.setTypeface(b.f11720s);
        a.j(this, R.string.downloads_notification_permission_description, p0().f7162j.f7140d).f7162j.f7139c.setChecked(t1.r(this, "download_notification", true));
        p0().f7162j.f7139c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11196b;

            {
                this.f11196b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                int i172 = i10;
                PreferencesActivity preferencesActivity = this.f11196b;
                switch (i172) {
                    case 0:
                        int i182 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putBoolean("install_apk_as_root_system", z102);
                            editorEdit.apply();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (z102) {
                            preferencesActivity.I.R(true);
                            break;
                        }
                        break;
                    case 1:
                        int i192 = PreferencesActivity.M;
                        if (z102) {
                            preferencesActivity.t0();
                            if (Build.VERSION.SDK_INT < 33) {
                                try {
                                    SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit2.putBoolean("recibir_notificaciones", true);
                                    editorEdit2.apply();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                preferencesActivity.t0();
                                break;
                            } else {
                                preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                break;
                            }
                        } else {
                            preferencesActivity.s0();
                            try {
                                SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit3.putBoolean("recibir_notificaciones", false);
                                editorEdit3.apply();
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                    case 2:
                        int i202 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit4.putBoolean("download_notification", z102);
                            editorEdit4.apply();
                            break;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            return;
                        }
                    case 3:
                        int i212 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit5.putBoolean("installation_notification", z102);
                            editorEdit5.apply();
                            break;
                        } catch (Exception e12) {
                            e12.printStackTrace();
                            return;
                        }
                    case 4:
                        int i222 = PreferencesActivity.M;
                        if (!z102) {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                            w4 w4Var3 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout42 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout42.getClass();
                            w4Var3.E(relativeLayout42, 0.3f);
                            try {
                                SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit6.putString("download_updates_options", "0");
                                editorEdit6.apply();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                            break;
                        } else {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                            w4 w4Var4 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout5.getClass();
                            w4Var4.E(relativeLayout5, 1.0f);
                            try {
                                SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit7.putString("download_updates_options", "2");
                                editorEdit7.apply();
                            } catch (Exception e14) {
                                e14.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                            break;
                        }
                    case 5:
                        int i232 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                            editorEdit8.putBoolean("search_apk_worker_active", z102);
                            editorEdit8.apply();
                            break;
                        } catch (Exception e15) {
                            e15.printStackTrace();
                            return;
                        }
                    case 6:
                        int i242 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit9.putBoolean("animations", z102);
                            editorEdit9.apply();
                            break;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    case 7:
                        int i252 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit10.putBoolean("only_wifi", z102);
                            editorEdit10.apply();
                            break;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return;
                        }
                    default:
                        int i262 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit11.putBoolean("install_apk_rooted", z102);
                            editorEdit11.apply();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        if (z102) {
                            try {
                                r0.f.G();
                                break;
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        break;
                }
            }
        });
        p0().f7166n.f7138b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i21;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string2 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string2.getClass();
                        String string22 = preferencesActivity.getString(R.string.url_advertising);
                        string22.getClass();
                        v5.c.e(preferencesActivity, string22, string2);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i28 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f7166n.e.setTypeface(b.f11719r);
        a.j(this, R.string.installations, p0().f7166n.e).f7166n.f7140d.setTypeface(b.f11720s);
        a.j(this, R.string.installs_notification_permission_description, p0().f7166n.f7140d).f7166n.f7139c.setChecked(t1.r(this, "installation_notification", true));
        p0().f7166n.f7139c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: m4.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11196b;

            {
                this.f11196b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z102) {
                int i172 = i21;
                PreferencesActivity preferencesActivity = this.f11196b;
                switch (i172) {
                    case 0:
                        int i182 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit.putBoolean("install_apk_as_root_system", z102);
                            editorEdit.apply();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (z102) {
                            preferencesActivity.I.R(true);
                            break;
                        }
                        break;
                    case 1:
                        int i192 = PreferencesActivity.M;
                        if (z102) {
                            preferencesActivity.t0();
                            if (Build.VERSION.SDK_INT < 33) {
                                try {
                                    SharedPreferences.Editor editorEdit2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                    editorEdit2.putBoolean("recibir_notificaciones", true);
                                    editorEdit2.apply();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                preferencesActivity.t0();
                                break;
                            } else {
                                preferencesActivity.L.launch("android.permission.POST_NOTIFICATIONS");
                                break;
                            }
                        } else {
                            preferencesActivity.s0();
                            try {
                                SharedPreferences.Editor editorEdit3 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit3.putBoolean("recibir_notificaciones", false);
                                editorEdit3.apply();
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                    case 2:
                        int i202 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit4 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit4.putBoolean("download_notification", z102);
                            editorEdit4.apply();
                            break;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            return;
                        }
                    case 3:
                        int i212 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit5 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit5.putBoolean("installation_notification", z102);
                            editorEdit5.apply();
                            break;
                        } catch (Exception e12) {
                            e12.printStackTrace();
                            return;
                        }
                    case 4:
                        int i222 = PreferencesActivity.M;
                        if (!z102) {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 0.3f);
                            w4 w4Var3 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout42 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout42.getClass();
                            w4Var3.E(relativeLayout42, 0.3f);
                            try {
                                SharedPreferences.Editor editorEdit6 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit6.putString("download_updates_options", "0");
                                editorEdit6.apply();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
                            break;
                        } else {
                            new w4(preferencesActivity, 5, false).E(preferencesActivity.p0().E.f7138b, 1.0f);
                            w4 w4Var4 = new w4(preferencesActivity, 5, false);
                            RelativeLayout relativeLayout5 = (RelativeLayout) preferencesActivity.p0().D.f181b;
                            relativeLayout5.getClass();
                            w4Var4.E(relativeLayout5, 1.0f);
                            try {
                                SharedPreferences.Editor editorEdit7 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit7.putString("download_updates_options", "2");
                                editorEdit7.apply();
                            } catch (Exception e14) {
                                e14.printStackTrace();
                            }
                            preferencesActivity.p0().E.f7140d.setText(preferencesActivity.q0());
                            break;
                        }
                    case 5:
                        int i232 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit8 = preferencesActivity.getSharedPreferences("CoreSettings", 0).edit();
                            editorEdit8.putBoolean("search_apk_worker_active", z102);
                            editorEdit8.apply();
                            break;
                        } catch (Exception e15) {
                            e15.printStackTrace();
                            return;
                        }
                    case 6:
                        int i242 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit9 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit9.putBoolean("animations", z102);
                            editorEdit9.apply();
                            break;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    case 7:
                        int i252 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit10 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit10.putBoolean("only_wifi", z102);
                            editorEdit10.apply();
                            break;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return;
                        }
                    default:
                        int i262 = PreferencesActivity.M;
                        try {
                            SharedPreferences.Editor editorEdit11 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                            editorEdit11.putBoolean("install_apk_rooted", z102);
                            editorEdit11.apply();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        if (z102) {
                            try {
                                r0.f.G();
                                break;
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        break;
                }
            }
        });
        if (v5.i.a(this)) {
            t0();
            p0().y.f7139c.setChecked(true);
        } else {
            s0();
            p0().y.f7139c.setChecked(false);
        }
        v vVar = new v();
        String string2 = getString(R.string.internal_storage);
        string2.getClass();
        try {
            zContains = getSharedPreferences("SettingsPreferences", 0).contains("storage_sdcard");
        } catch (Exception unused2) {
            zContains = false;
        }
        if (!zContains) {
            string2 = getString(R.string.internal_storage);
            string2.getClass();
            vVar.f10136a = 0;
        } else if (t1.r(this, "storage_sdcard", false)) {
            string2 = getString(R.string.sd_card);
            string2.getClass();
            vVar.f10136a = 1;
        }
        HashMap map = new HashMap();
        w4 w4Var3 = new w4(this, 3, false);
        if (w4Var3.D()) {
            File[] externalFilesDirs = getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalFilesDir = externalFilesDirs[1];
            } else {
                externalFilesDir = getExternalFilesDir(null);
                w4Var3.P();
                w4Var3.O();
            }
        } else {
            externalFilesDir = getExternalFilesDir(null);
        }
        File file = new File(externalFilesDir, "Apps");
        if (!file.exists()) {
            file.mkdirs();
        }
        map.put(0, getString(R.string.internal_memory_free, l1.b.M(this, file.getFreeSpace())));
        ArrayList arrayListI = t1.I(this);
        if (!arrayListI.isEmpty()) {
            map.put(1, getString(R.string.sd_card_free, l1.b.M(this, ((u4.f) arrayListI.get(0)).f12911d)));
        }
        if (map.size() > 1) {
            HashMap map2 = new HashMap();
            for (Map.Entry entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
            x xVarR = x.r(getLayoutInflater().inflate(R.layout.preference_list, (ViewGroup) null, false));
            RelativeLayout relativeLayout5 = (RelativeLayout) xVarR.f181b;
            TextView textView = (TextView) xVarR.f183d;
            textView.setTypeface(b.f11719r);
            textView.setText(getString(R.string.download_path));
            ((TextView) xVarR.f182c).setText(string2);
            relativeLayout5.setOnClickListener(new h(this, map2, vVar, xVarR, 0));
            p0().f7168p.addView(relativeLayout5, p0().f7168p.indexOfChild(p0().f7165m.f7138b));
        }
        ((TextView) p0().f7172u.f219c).setTypeface(b.f11719r);
        a.j(this, R.string.preference_privacy_and_security, (TextView) p0().f7172u.f219c).f7173v.e.setTypeface(b.f11719r);
        final int i28 = 4;
        a.j(this, R.string.gdpr_title, p0().f7173v.e).f7173v.f7327b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i28;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string22 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string22.getClass();
                        String string222 = preferencesActivity.getString(R.string.url_advertising);
                        string222.getClass();
                        v5.c.e(preferencesActivity, string222, string22);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i282 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i29 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        try {
            SharedPreferences sharedPreferences3 = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences3.contains("is_in_eea")) {
                z9 = sharedPreferences3.getBoolean("is_in_eea", true);
            }
        } catch (Exception unused3) {
        }
        if (!z9) {
            p0().f7173v.f7327b.setVisibility(8);
        }
        p0().e.e.setTypeface(b.f11719r);
        final int i29 = 5;
        a.j(this, R.string.advanced_settings, p0().e.e).e.f7327b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i29;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string22 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string22.getClass();
                        String string222 = preferencesActivity.getString(R.string.url_advertising);
                        string222.getClass();
                        v5.c.e(preferencesActivity, string222, string22);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i282 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i292 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i30 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        ((TextView) p0().f7169q.f219c).setTypeface(b.f11719r);
        a.j(this, R.string.app_detail_more_info_title, (TextView) p0().f7169q.f219c).A.e.setTypeface(b.f11719r);
        final int i30 = 6;
        a.j(this, R.string.preference_tos_and_pp, p0().A.e).A.f7327b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i30;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string22 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string22.getClass();
                        String string222 = preferencesActivity.getString(R.string.url_advertising);
                        string222.getClass();
                        v5.c.e(preferencesActivity, string222, string22);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i282 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i292 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i302 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f7163k.e.setTypeface(b.f11719r);
        final int i31 = 7;
        a.j(this, R.string.feedback, p0().f7163k.e).f7163k.f7327b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i31;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string22 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string22.getClass();
                        String string222 = preferencesActivity.getString(R.string.url_advertising);
                        string222.getClass();
                        v5.c.e(preferencesActivity, string222, string22);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i282 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i292 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i302 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f7160d.e.setTypeface(b.f11719r);
        a.j(this, R.string.advertising, p0().f7160d.e).f7160d.f7327b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i19;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string22 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string22.getClass();
                        String string222 = preferencesActivity.getString(R.string.url_advertising);
                        string222.getClass();
                        v5.c.e(preferencesActivity, string222, string22);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i282 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i292 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i302 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f7158b.e.setTypeface(b.f11719r);
        final int i32 = 9;
        a.j(this, R.string.about, p0().f7158b.e).f7158b.f7327b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i32;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string22 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string22.getClass();
                        String string222 = preferencesActivity.getString(R.string.url_advertising);
                        string222.getClass();
                        v5.c.e(preferencesActivity, string222, string22);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i282 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i292 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i302 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
        p0().f7159c.e.setTypeface(b.f11719r);
        final int i33 = 10;
        a.j(this, R.string.about_uptodown, p0().f7159c.e).f7159c.f7327b.setOnClickListener(new View.OnClickListener(this) { // from class: m4.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f11198b;

            {
                this.f11198b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i33;
                PreferencesActivity preferencesActivity = this.f11198b;
                switch (i132) {
                    case 0:
                        int i142 = PreferencesActivity.M;
                        preferencesActivity.p0().y.f7139c.performClick();
                        break;
                    case 1:
                        int i152 = PreferencesActivity.M;
                        preferencesActivity.p0().f7162j.f7139c.performClick();
                        break;
                    case 2:
                        int i162 = PreferencesActivity.M;
                        Intent intent = new Intent(preferencesActivity, (Class<?>) LanguageSettingsActivity.class);
                        ActivityResultLauncher activityResultLauncher = preferencesActivity.K;
                        float f10 = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(preferencesActivity));
                        break;
                    case 3:
                        int i172 = PreferencesActivity.M;
                        preferencesActivity.p0().f7166n.f7139c.performClick();
                        break;
                    case 4:
                        int i182 = PreferencesActivity.M;
                        float f102 = UptodownApp.E;
                        if (!k4.c.m(preferencesActivity)) {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) GdprPrivacySettings.class), k4.c.a(preferencesActivity));
                            break;
                        } else {
                            preferencesActivity.startActivity(new Intent(preferencesActivity, (Class<?>) TvPrivacyPreferences.class));
                            break;
                        }
                    case 5:
                        int i192 = PreferencesActivity.M;
                        Intent intent2 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent2.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
                        intent2.putExtra("advanced_settings_index", 3);
                        float f11 = UptodownApp.E;
                        preferencesActivity.startActivity(intent2, k4.c.a(preferencesActivity));
                        break;
                    case 6:
                        int i202 = PreferencesActivity.M;
                        Intent intent3 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent3.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
                        intent3.putExtra("advanced_settings_index", 0);
                        float f12 = UptodownApp.E;
                        preferencesActivity.startActivity(intent3, k4.c.a(preferencesActivity));
                        break;
                    case 7:
                        int i212 = PreferencesActivity.M;
                        Intent intent4 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent4.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
                        intent4.putExtra("advanced_settings_index", 1);
                        float f13 = UptodownApp.E;
                        preferencesActivity.startActivity(intent4, k4.c.a(preferencesActivity));
                        break;
                    case 8:
                        int i222 = PreferencesActivity.M;
                        String string22 = preferencesActivity.getString(R.string.privacy_policy_title);
                        string22.getClass();
                        String string222 = preferencesActivity.getString(R.string.url_advertising);
                        string222.getClass();
                        v5.c.e(preferencesActivity, string222, string22);
                        break;
                    case 9:
                        int i232 = PreferencesActivity.M;
                        Intent intent5 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent5.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
                        intent5.putExtra("advanced_settings_index", 2);
                        float f14 = UptodownApp.E;
                        preferencesActivity.startActivity(intent5, k4.c.a(preferencesActivity));
                        break;
                    case 10:
                        int i242 = PreferencesActivity.M;
                        Intent intent6 = new Intent(preferencesActivity, (Class<?>) AdvancedPreferencesActivity.class);
                        intent6.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
                        intent6.putExtra("advanced_settings_index", 4);
                        float f15 = UptodownApp.E;
                        preferencesActivity.startActivity(intent6, k4.c.a(preferencesActivity));
                        break;
                    case 11:
                        int i252 = PreferencesActivity.M;
                        preferencesActivity.p0().f7165m.f7139c.performClick();
                        break;
                    case 12:
                        int i262 = PreferencesActivity.M;
                        preferencesActivity.p0().f.f7139c.performClick();
                        break;
                    case 13:
                        int i272 = PreferencesActivity.M;
                        preferencesActivity.finish();
                        break;
                    case 14:
                        int i282 = PreferencesActivity.M;
                        preferencesActivity.p0().f7171s.f7139c.performClick();
                        break;
                    case 15:
                        int i292 = PreferencesActivity.M;
                        preferencesActivity.p0().h.f7139c.performClick();
                        break;
                    default:
                        int i302 = PreferencesActivity.M;
                        preferencesActivity.p0().f7174w.f7139c.performClick();
                        break;
                }
            }
        });
    }

    public final k0 p0() {
        return (k0) this.H.getValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String q0() {
        /*
            r7 = this;
            java.lang.String r0 = "SettingsPreferences"
            java.lang.String r1 = "download_updates_options"
            java.lang.String r2 = "2"
            r3 = 0
            android.content.SharedPreferences r4 = r7.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> L19
            boolean r5 = r4.contains(r1)     // Catch: java.lang.Exception -> L19
            if (r5 == 0) goto L19
            java.lang.String r4 = r4.getString(r1, r2)     // Catch: java.lang.Exception -> L19
            r4.getClass()     // Catch: java.lang.Exception -> L19
            goto L1a
        L19:
            r4 = r2
        L1a:
            int r5 = r4.hashCode()
            r6 = 2131952484(0x7f130364, float:1.9541412E38)
            switch(r5) {
                case 48: goto L48;
                case 49: goto L34;
                case 50: goto L25;
                default: goto L24;
            }
        L24:
            goto L50
        L25:
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L2c
            goto L50
        L2c:
            java.lang.String r0 = r7.getString(r6)
            r0.getClass()
            goto L75
        L34:
            java.lang.String r5 = "1"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L3d
            goto L50
        L3d:
            r0 = 2131952492(0x7f13036c, float:1.9541428E38)
            java.lang.String r0 = r7.getString(r0)
            r0.getClass()
            goto L75
        L48:
            java.lang.String r5 = "0"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L6b
        L50:
            android.content.SharedPreferences r0 = r7.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> L5f
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch: java.lang.Exception -> L5f
            r0.putString(r1, r2)     // Catch: java.lang.Exception -> L5f
            r0.apply()     // Catch: java.lang.Exception -> L5f
            goto L63
        L5f:
            r0 = move-exception
            r0.printStackTrace()
        L63:
            java.lang.String r0 = r7.getString(r6)
            r0.getClass()
            goto L75
        L6b:
            r0 = 2131952497(0x7f130371, float:1.9541438E38)
            java.lang.String r0 = r7.getString(r0)
            r0.getClass()
        L75:
            r1 = 0
            java.io.File r2 = r7.getExternalFilesDir(r1)
            if (r2 == 0) goto L84
            long r1 = r2.getUsableSpace()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L84:
            java.lang.String r2 = "\n⚠ "
            if (r1 != 0) goto L9b
            java.lang.StringBuilder r0 = a3.a.w(r0, r2)
            r1 = 2131951986(0x7f130172, float:1.9540402E38)
            java.lang.String r1 = r7.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L9b:
            long r3 = r1.longValue()
            r5 = 262144000(0xfa00000, double:1.295163447E-315)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto Lb8
            java.lang.StringBuilder r0 = a3.a.w(r0, r2)
            r1 = 2131951997(0x7f13017d, float:1.9540424E38)
            java.lang.String r1 = r7.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.preferences.PreferencesActivity.q0():java.lang.String");
    }

    public final String r0() throws NumberFormatException {
        int i10 = Integer.parseInt(t1.x(this));
        if (i10 == 1) {
            String string = getString(R.string.updates_notification_description_always);
            string.getClass();
            return string;
        }
        if (i10 == 2) {
            String string2 = getString(R.string.updates_notification_description_daily);
            string2.getClass();
            return string2;
        }
        if (i10 == 3) {
            String string3 = getString(R.string.updates_notification_description_weekly);
            string3.getClass();
            return string3;
        }
        if (i10 != 4) {
            return "";
        }
        String string4 = getString(R.string.updates_notification_description_never);
        string4.getClass();
        return string4;
    }

    public final void s0() {
        p0().y.f7140d.setText(getString(R.string.disabled));
        w4 w4Var = new w4(this, 5, false);
        RelativeLayout relativeLayout = (RelativeLayout) p0().D.f181b;
        relativeLayout.getClass();
        w4Var.E(relativeLayout, 0.3f);
        w4 w4Var2 = new w4(this, 5, false);
        RelativeLayout relativeLayout2 = p0().f7162j.f7138b;
        relativeLayout2.getClass();
        w4Var2.E(relativeLayout2, 0.3f);
        p0().f7162j.f7139c.setClickable(false);
        w4 w4Var3 = new w4(this, 5, false);
        RelativeLayout relativeLayout3 = p0().f7166n.f7138b;
        relativeLayout3.getClass();
        w4Var3.E(relativeLayout3, 0.3f);
        p0().f7166n.f7139c.setClickable(false);
        w4 w4Var4 = new w4(this, 5, false);
        RelativeLayout relativeLayout4 = p0().f7165m.f7138b;
        relativeLayout4.getClass();
        w4Var4.E(relativeLayout4, 0.3f);
        p0().f7165m.f7139c.setClickable(false);
    }

    public final void t0() {
        p0().y.f7140d.setText(getString(R.string.enabled));
        String str = "2";
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("download_updates_options")) {
                String string = sharedPreferences.getString("download_updates_options", "2");
                string.getClass();
                str = string;
            }
        } catch (Exception unused) {
        }
        if (str.equals("0")) {
            w4 w4Var = new w4(this, 5, false);
            RelativeLayout relativeLayout = (RelativeLayout) p0().D.f181b;
            relativeLayout.getClass();
            w4Var.E(relativeLayout, 0.3f);
        } else {
            w4 w4Var2 = new w4(this, 5, false);
            RelativeLayout relativeLayout2 = (RelativeLayout) p0().D.f181b;
            relativeLayout2.getClass();
            w4Var2.E(relativeLayout2, 1.0f);
        }
        w4 w4Var3 = new w4(this, 5, false);
        RelativeLayout relativeLayout3 = p0().f7162j.f7138b;
        relativeLayout3.getClass();
        w4Var3.E(relativeLayout3, 1.0f);
        p0().f7162j.f7139c.setClickable(true);
        w4 w4Var4 = new w4(this, 5, false);
        RelativeLayout relativeLayout4 = p0().f7166n.f7138b;
        relativeLayout4.getClass();
        w4Var4.E(relativeLayout4, 1.0f);
        p0().f7166n.f7139c.setClickable(true);
        w4 w4Var5 = new w4(this, 5, false);
        RelativeLayout relativeLayout5 = p0().f7165m.f7138b;
        relativeLayout5.getClass();
        w4Var5.E(relativeLayout5, 1.0f);
        p0().f7165m.f7139c.setClickable(true);
    }
}
