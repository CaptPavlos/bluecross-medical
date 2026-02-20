package com.uptodown.tv.ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.app.BackgroundManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvMainActivity;
import g5.i;
import h5.a0;
import h5.h;
import h5.l;
import h5.q;
import java.io.File;
import java.util.List;
import m4.k;
import o7.u;
import r0.f;
import r5.b;
import r5.c;
import s5.j;
import s5.s;
import v5.g;
import w2.r;
import x4.d;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvMainActivity extends b implements i {
    public static final /* synthetic */ int f = 0;

    /* renamed from: b, reason: collision with root package name */
    public AlertDialog f6689b;

    /* renamed from: c, reason: collision with root package name */
    public s f6690c;

    /* renamed from: d, reason: collision with root package name */
    public final ActivityResultLauncher f6691d;
    public final ActivityResultLauncher e;

    public TvMainActivity() {
        final int i10 = 0;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: r5.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TvMainActivity f12386b;

            {
                this.f12386b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle extras;
                int i11 = i10;
                boolean z9 = false;
                TvMainActivity tvMainActivity = this.f12386b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i11) {
                    case 0:
                        int i12 = TvMainActivity.f;
                        if (activityResult.getResultCode() == 10) {
                            Intent data = activityResult.getData();
                            String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("realPath");
                            if (string != null && string.length() != 0) {
                                boolean zF = v5.a.f(tvMainActivity);
                                File file = new File(string);
                                String absolutePath = file.getAbsolutePath();
                                absolutePath.getClass();
                                Intent intent = new Intent(tvMainActivity, (Class<?>) InstallerActivity.class);
                                intent.putExtra("realPath", absolutePath);
                                intent.putExtra("requireUserAction", zF);
                                intent.putExtra("backgroundInstallation", false);
                                intent.addFlags(268435456);
                                tvMainActivity.startActivity(intent);
                                g gVarL = g.f13148u.l(tvMainActivity);
                                gVarL.a();
                                String name = file.getName();
                                name.getClass();
                                q qVarW = gVarL.w(name);
                                gVarL.b();
                                Bundle bundle = new Bundle();
                                if ((qVarW != null ? qVarW.f8701b : null) != null) {
                                    String str = qVarW.f8701b;
                                    str.getClass();
                                    l lVar = UptodownApp.Z;
                                    if (lVar != null) {
                                        String strC = f.C(lVar.a());
                                        if (strC != null && strC.equalsIgnoreCase(str)) {
                                            bundle.putString("source", "deeplink");
                                        }
                                    } else {
                                        a0 a0VarJ = t1.J(tvMainActivity);
                                        if (a0VarJ != null && u.Z(a0VarJ.f8461b, str, true)) {
                                            bundle.putString("source", "notification_fcm");
                                        }
                                    }
                                    bundle.putString("packagename", qVarW.f8701b);
                                }
                                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
                                t1.c cVar = tvMainActivity.f12383a;
                                if (cVar != null) {
                                    cVar.e(bundle, "install");
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        int i13 = TvMainActivity.f;
                        try {
                            SharedPreferences sharedPreferences = tvMainActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences.contains("gdpr_tracking_allowed")) {
                                z9 = sharedPreferences.getBoolean("gdpr_tracking_allowed", false);
                            }
                        } catch (Exception unused) {
                        }
                        if (z9) {
                            float f10 = UptodownApp.E;
                            k4.c.E(tvMainActivity);
                            break;
                        }
                        break;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f6691d = activityResultLauncherRegisterForActivityResult;
        final int i11 = 1;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: r5.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TvMainActivity f12386b;

            {
                this.f12386b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle extras;
                int i112 = i11;
                boolean z9 = false;
                TvMainActivity tvMainActivity = this.f12386b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i112) {
                    case 0:
                        int i12 = TvMainActivity.f;
                        if (activityResult.getResultCode() == 10) {
                            Intent data = activityResult.getData();
                            String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("realPath");
                            if (string != null && string.length() != 0) {
                                boolean zF = v5.a.f(tvMainActivity);
                                File file = new File(string);
                                String absolutePath = file.getAbsolutePath();
                                absolutePath.getClass();
                                Intent intent = new Intent(tvMainActivity, (Class<?>) InstallerActivity.class);
                                intent.putExtra("realPath", absolutePath);
                                intent.putExtra("requireUserAction", zF);
                                intent.putExtra("backgroundInstallation", false);
                                intent.addFlags(268435456);
                                tvMainActivity.startActivity(intent);
                                g gVarL = g.f13148u.l(tvMainActivity);
                                gVarL.a();
                                String name = file.getName();
                                name.getClass();
                                q qVarW = gVarL.w(name);
                                gVarL.b();
                                Bundle bundle = new Bundle();
                                if ((qVarW != null ? qVarW.f8701b : null) != null) {
                                    String str = qVarW.f8701b;
                                    str.getClass();
                                    l lVar = UptodownApp.Z;
                                    if (lVar != null) {
                                        String strC = f.C(lVar.a());
                                        if (strC != null && strC.equalsIgnoreCase(str)) {
                                            bundle.putString("source", "deeplink");
                                        }
                                    } else {
                                        a0 a0VarJ = t1.J(tvMainActivity);
                                        if (a0VarJ != null && u.Z(a0VarJ.f8461b, str, true)) {
                                            bundle.putString("source", "notification_fcm");
                                        }
                                    }
                                    bundle.putString("packagename", qVarW.f8701b);
                                }
                                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
                                t1.c cVar = tvMainActivity.f12383a;
                                if (cVar != null) {
                                    cVar.e(bundle, "install");
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        int i13 = TvMainActivity.f;
                        try {
                            SharedPreferences sharedPreferences = tvMainActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences.contains("gdpr_tracking_allowed")) {
                                z9 = sharedPreferences.getBoolean("gdpr_tracking_allowed", false);
                            }
                        } catch (Exception unused) {
                        }
                        if (z9) {
                            float f10 = UptodownApp.E;
                            k4.c.E(tvMainActivity);
                            break;
                        }
                        break;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.e = activityResultLauncherRegisterForActivityResult2;
    }

    @Override // g5.i
    public final void f(int i10) {
        String string = getString(R.string.msg_app_not_found);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(string);
        builder.setPositiveButton(android.R.string.ok, new c(0));
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        if (isFinishing()) {
            return;
        }
        alertDialogCreate.show();
    }

    @Override // g5.i
    public final void l(h hVar) {
        Intent intent = new Intent(this, (Class<?>) TvAppDetailActivity.class);
        intent.putExtra("appInfo", hVar);
        float f10 = UptodownApp.E;
        startActivity(intent, k4.c.a(this));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        fragments.getClass();
        if (t6.l.i0(fragments) instanceof j) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override // r5.b, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Throwable {
        Uri data;
        SharedPreferences sharedPreferences;
        super.onCreate(bundle);
        setContentView(R.layout.tv_activity_main);
        this.f6690c = new s();
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        s sVar = this.f6690c;
        if (sVar == null) {
            kotlin.jvm.internal.l.i("tvMainFragment");
            throw null;
        }
        fragmentTransactionBeginTransaction.replace(R.id.fragmentContainer, sVar).commit();
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences.contains("gdpr_tracking_allowed") ? sharedPreferences.getBoolean("gdpr_tracking_allowed", false) : false;
        if (z9) {
            float f10 = UptodownApp.E;
            k4.c.E(this);
        }
        BackgroundManager backgroundManager = BackgroundManager.getInstance(this);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.tv_default_background);
        if (backgroundManager != null) {
            backgroundManager.setDrawable(drawable);
        }
        Intent intent = getIntent();
        if (intent == null || (intent.getFlags() & 1048576) == 1048576 || (data = intent.getData()) == null) {
            return;
        }
        String strB = d.b(data, this);
        if (strB != null) {
            boolean z10 = true;
            if (!u.X(strB, ".xapk", true) && !u.X(strB, ".apks", true) && !u.X(strB, ".apkm", true)) {
                z10 = false;
            }
            if (z10 || u.X(strB, ".apk", false)) {
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) InstallerActivity.class);
                intent2.setData(data);
                this.f6691d.launch(intent2);
                return;
            }
        }
        new r(this, v5.c.d(data), this, LifecycleOwnerKt.getLifecycleScope(this));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        AlertDialog alertDialog;
        SharedPreferences sharedPreferences;
        super.onResume();
        AlertDialog alertDialog2 = this.f6689b;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        boolean z9 = false;
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z10 = sharedPreferences.contains("is_in_eea") ? sharedPreferences.getBoolean("is_in_eea", true) : true;
        if (z10) {
            try {
                SharedPreferences sharedPreferences2 = getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences2.contains("gdpr_tracking_allowed")) {
                    z9 = sharedPreferences2.getBoolean("gdpr_tracking_allowed", false);
                }
            } catch (Exception unused2) {
            }
            if (z9) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.tracking_disabled_warning_gdpr));
            builder.setPositiveButton(R.string.gdpr_set_up, new k(this, 1));
            builder.setNegativeButton(android.R.string.cancel, new c(1));
            builder.setCancelable(true);
            this.f6689b = builder.create();
            if (isFinishing() || (alertDialog = this.f6689b) == null) {
                return;
            }
            alertDialog.show();
        }
    }
}
