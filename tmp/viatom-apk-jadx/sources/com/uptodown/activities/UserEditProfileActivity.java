package com.uptodown.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.PasswordEditActivity;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.activities.UserEditProfileActivity;
import com.uptodown.activities.UsernameEditActivity;
import d5.g1;
import l4.w;
import l4.x2;
import o4.b;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UserEditProfileActivity extends w {
    public static final /* synthetic */ int K = 0;
    public final m H = new m(new x2(this, 21));
    public final ActivityResultLauncher I;
    public final ActivityResultLauncher J;

    public UserEditProfileActivity() {
        final int i10 = 0;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: l4.pb

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserEditProfileActivity f10741b;

            {
                this.f10741b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i11 = i10;
                UserEditProfileActivity userEditProfileActivity = this.f10741b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i11) {
                    case 0:
                        int i12 = UserEditProfileActivity.K;
                        if (activityResult.getResultCode() == 2) {
                            h5.c1.b(userEditProfileActivity);
                            userEditProfileActivity.setResult(2);
                            userEditProfileActivity.finish();
                            break;
                        }
                        break;
                    default:
                        int i13 = UserEditProfileActivity.K;
                        if (activityResult.getResultCode() == 10) {
                            userEditProfileActivity.setResult(10);
                            userEditProfileActivity.finish();
                            break;
                        }
                        break;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult.getClass();
        this.I = activityResultLauncherRegisterForActivityResult;
        final int i11 = 1;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: l4.pb

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserEditProfileActivity f10741b;

            {
                this.f10741b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i112 = i11;
                UserEditProfileActivity userEditProfileActivity = this.f10741b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i112) {
                    case 0:
                        int i12 = UserEditProfileActivity.K;
                        if (activityResult.getResultCode() == 2) {
                            h5.c1.b(userEditProfileActivity);
                            userEditProfileActivity.setResult(2);
                            userEditProfileActivity.finish();
                            break;
                        }
                        break;
                    default:
                        int i13 = UserEditProfileActivity.K;
                        if (activityResult.getResultCode() == 10) {
                            userEditProfileActivity.setResult(10);
                            userEditProfileActivity.finish();
                            break;
                        }
                        break;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.J = activityResultLauncherRegisterForActivityResult2;
    }

    public final g1 n0() {
        return (g1) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7074a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            n0().f.setNavigationIcon(drawable);
            n0().f.setNavigationContentDescription(getString(R.string.back));
        }
        final int i10 = 0;
        n0().f.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.qb

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserEditProfileActivity f10775b;

            {
                this.f10775b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                UserEditProfileActivity userEditProfileActivity = this.f10775b;
                switch (i11) {
                    case 0:
                        int i12 = UserEditProfileActivity.K;
                        userEditProfileActivity.finish();
                        break;
                    case 1:
                        int i13 = UserEditProfileActivity.K;
                        h5.e1 e1VarH = h5.c1.h(userEditProfileActivity);
                        if (e1VarH == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent = new Intent(userEditProfileActivity, (Class<?>) UsernameEditActivity.class);
                            intent.putExtra("user", e1VarH);
                            ActivityResultLauncher activityResultLauncher = userEditProfileActivity.J;
                            float f = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 2:
                        int i14 = UserEditProfileActivity.K;
                        if (h5.c1.h(userEditProfileActivity) == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent2 = new Intent(userEditProfileActivity, (Class<?>) PasswordEditActivity.class);
                            ActivityResultLauncher activityResultLauncher2 = userEditProfileActivity.I;
                            float f10 = UptodownApp.E;
                            activityResultLauncher2.launch(intent2, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 3:
                        int i15 = UserEditProfileActivity.K;
                        h5.e1 e1VarH2 = h5.c1.h(userEditProfileActivity);
                        if (e1VarH2 == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent3 = new Intent(userEditProfileActivity, (Class<?>) UserAvatarActivity.class);
                            intent3.putExtra("user", e1VarH2);
                            ActivityResultLauncher activityResultLauncher3 = userEditProfileActivity.J;
                            float f11 = UptodownApp.E;
                            activityResultLauncher3.launch(intent3, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    default:
                        int i16 = UserEditProfileActivity.K;
                        h5.c1.b(userEditProfileActivity);
                        userEditProfileActivity.finish();
                        break;
                }
            }
        });
        n0().f7079j.setTypeface(b.f11719r);
        n0().f7080k.setTypeface(b.f11719r);
        n0().f7078i.setTypeface(b.f11719r);
        n0().g.setTypeface(b.f11719r);
        n0().h.setTypeface(b.f11719r);
        final int i11 = 1;
        n0().e.setOnClickListener(new View.OnClickListener(this) { // from class: l4.qb

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserEditProfileActivity f10775b;

            {
                this.f10775b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                UserEditProfileActivity userEditProfileActivity = this.f10775b;
                switch (i112) {
                    case 0:
                        int i12 = UserEditProfileActivity.K;
                        userEditProfileActivity.finish();
                        break;
                    case 1:
                        int i13 = UserEditProfileActivity.K;
                        h5.e1 e1VarH = h5.c1.h(userEditProfileActivity);
                        if (e1VarH == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent = new Intent(userEditProfileActivity, (Class<?>) UsernameEditActivity.class);
                            intent.putExtra("user", e1VarH);
                            ActivityResultLauncher activityResultLauncher = userEditProfileActivity.J;
                            float f = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 2:
                        int i14 = UserEditProfileActivity.K;
                        if (h5.c1.h(userEditProfileActivity) == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent2 = new Intent(userEditProfileActivity, (Class<?>) PasswordEditActivity.class);
                            ActivityResultLauncher activityResultLauncher2 = userEditProfileActivity.I;
                            float f10 = UptodownApp.E;
                            activityResultLauncher2.launch(intent2, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 3:
                        int i15 = UserEditProfileActivity.K;
                        h5.e1 e1VarH2 = h5.c1.h(userEditProfileActivity);
                        if (e1VarH2 == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent3 = new Intent(userEditProfileActivity, (Class<?>) UserAvatarActivity.class);
                            intent3.putExtra("user", e1VarH2);
                            ActivityResultLauncher activityResultLauncher3 = userEditProfileActivity.J;
                            float f11 = UptodownApp.E;
                            activityResultLauncher3.launch(intent3, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    default:
                        int i16 = UserEditProfileActivity.K;
                        h5.c1.b(userEditProfileActivity);
                        userEditProfileActivity.finish();
                        break;
                }
            }
        });
        final int i12 = 2;
        n0().f7077d.setOnClickListener(new View.OnClickListener(this) { // from class: l4.qb

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserEditProfileActivity f10775b;

            {
                this.f10775b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                UserEditProfileActivity userEditProfileActivity = this.f10775b;
                switch (i112) {
                    case 0:
                        int i122 = UserEditProfileActivity.K;
                        userEditProfileActivity.finish();
                        break;
                    case 1:
                        int i13 = UserEditProfileActivity.K;
                        h5.e1 e1VarH = h5.c1.h(userEditProfileActivity);
                        if (e1VarH == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent = new Intent(userEditProfileActivity, (Class<?>) UsernameEditActivity.class);
                            intent.putExtra("user", e1VarH);
                            ActivityResultLauncher activityResultLauncher = userEditProfileActivity.J;
                            float f = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 2:
                        int i14 = UserEditProfileActivity.K;
                        if (h5.c1.h(userEditProfileActivity) == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent2 = new Intent(userEditProfileActivity, (Class<?>) PasswordEditActivity.class);
                            ActivityResultLauncher activityResultLauncher2 = userEditProfileActivity.I;
                            float f10 = UptodownApp.E;
                            activityResultLauncher2.launch(intent2, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 3:
                        int i15 = UserEditProfileActivity.K;
                        h5.e1 e1VarH2 = h5.c1.h(userEditProfileActivity);
                        if (e1VarH2 == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent3 = new Intent(userEditProfileActivity, (Class<?>) UserAvatarActivity.class);
                            intent3.putExtra("user", e1VarH2);
                            ActivityResultLauncher activityResultLauncher3 = userEditProfileActivity.J;
                            float f11 = UptodownApp.E;
                            activityResultLauncher3.launch(intent3, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    default:
                        int i16 = UserEditProfileActivity.K;
                        h5.c1.b(userEditProfileActivity);
                        userEditProfileActivity.finish();
                        break;
                }
            }
        });
        final int i13 = 3;
        n0().f7075b.setOnClickListener(new View.OnClickListener(this) { // from class: l4.qb

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserEditProfileActivity f10775b;

            {
                this.f10775b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                UserEditProfileActivity userEditProfileActivity = this.f10775b;
                switch (i112) {
                    case 0:
                        int i122 = UserEditProfileActivity.K;
                        userEditProfileActivity.finish();
                        break;
                    case 1:
                        int i132 = UserEditProfileActivity.K;
                        h5.e1 e1VarH = h5.c1.h(userEditProfileActivity);
                        if (e1VarH == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent = new Intent(userEditProfileActivity, (Class<?>) UsernameEditActivity.class);
                            intent.putExtra("user", e1VarH);
                            ActivityResultLauncher activityResultLauncher = userEditProfileActivity.J;
                            float f = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 2:
                        int i14 = UserEditProfileActivity.K;
                        if (h5.c1.h(userEditProfileActivity) == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent2 = new Intent(userEditProfileActivity, (Class<?>) PasswordEditActivity.class);
                            ActivityResultLauncher activityResultLauncher2 = userEditProfileActivity.I;
                            float f10 = UptodownApp.E;
                            activityResultLauncher2.launch(intent2, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 3:
                        int i15 = UserEditProfileActivity.K;
                        h5.e1 e1VarH2 = h5.c1.h(userEditProfileActivity);
                        if (e1VarH2 == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent3 = new Intent(userEditProfileActivity, (Class<?>) UserAvatarActivity.class);
                            intent3.putExtra("user", e1VarH2);
                            ActivityResultLauncher activityResultLauncher3 = userEditProfileActivity.J;
                            float f11 = UptodownApp.E;
                            activityResultLauncher3.launch(intent3, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    default:
                        int i16 = UserEditProfileActivity.K;
                        h5.c1.b(userEditProfileActivity);
                        userEditProfileActivity.finish();
                        break;
                }
            }
        });
        final int i14 = 4;
        n0().f7076c.setOnClickListener(new View.OnClickListener(this) { // from class: l4.qb

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserEditProfileActivity f10775b;

            {
                this.f10775b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i14;
                UserEditProfileActivity userEditProfileActivity = this.f10775b;
                switch (i112) {
                    case 0:
                        int i122 = UserEditProfileActivity.K;
                        userEditProfileActivity.finish();
                        break;
                    case 1:
                        int i132 = UserEditProfileActivity.K;
                        h5.e1 e1VarH = h5.c1.h(userEditProfileActivity);
                        if (e1VarH == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent = new Intent(userEditProfileActivity, (Class<?>) UsernameEditActivity.class);
                            intent.putExtra("user", e1VarH);
                            ActivityResultLauncher activityResultLauncher = userEditProfileActivity.J;
                            float f = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 2:
                        int i142 = UserEditProfileActivity.K;
                        if (h5.c1.h(userEditProfileActivity) == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent2 = new Intent(userEditProfileActivity, (Class<?>) PasswordEditActivity.class);
                            ActivityResultLauncher activityResultLauncher2 = userEditProfileActivity.I;
                            float f10 = UptodownApp.E;
                            activityResultLauncher2.launch(intent2, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    case 3:
                        int i15 = UserEditProfileActivity.K;
                        h5.e1 e1VarH2 = h5.c1.h(userEditProfileActivity);
                        if (e1VarH2 == null) {
                            userEditProfileActivity.finish();
                            break;
                        } else {
                            Intent intent3 = new Intent(userEditProfileActivity, (Class<?>) UserAvatarActivity.class);
                            intent3.putExtra("user", e1VarH2);
                            ActivityResultLauncher activityResultLauncher3 = userEditProfileActivity.J;
                            float f11 = UptodownApp.E;
                            activityResultLauncher3.launch(intent3, k4.c.b(userEditProfileActivity));
                            break;
                        }
                    default:
                        int i16 = UserEditProfileActivity.K;
                        h5.c1.b(userEditProfileActivity);
                        userEditProfileActivity.finish();
                        break;
                }
            }
        });
    }
}
