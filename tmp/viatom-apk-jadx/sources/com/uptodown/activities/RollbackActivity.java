package com.uptodown.activities;

import a6.c;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.RollbackActivity;
import d5.u0;
import e5.n;
import g5.o;
import kotlin.jvm.internal.y;
import l4.a4;
import l4.m8;
import l4.n8;
import l4.p8;
import l4.x2;
import n4.j0;
import o4.b;
import r7.i0;
import r7.w;
import s6.m;
import x5.f;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class RollbackActivity extends a4 implements o {
    public static final /* synthetic */ int Y = 0;
    public final m U = new m(new x2(this, 12));
    public final ViewModelLazy V = new ViewModelLazy(y.a(p8.class), new n8(this, 0), new m8(this), new n8(this, 1));
    public j0 W;
    public final ActivityResultLauncher X;

    public RollbackActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 18));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.X = activityResultLauncherRegisterForActivityResult;
    }

    public final u0 B0() {
        return (u0) this.U.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = B0().f7367a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            B0().f7370d.setNavigationIcon(drawable);
            B0().f7370d.setNavigationContentDescription(getString(R.string.back));
        }
        Toolbar toolbar = B0().f7370d;
        boolean z9 = false;
        z9 = false;
        final int i10 = z9 ? 1 : 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.l8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RollbackActivity f10601b;

            {
                this.f10601b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                RollbackActivity rollbackActivity = this.f10601b;
                switch (i11) {
                    case 0:
                        int i12 = RollbackActivity.Y;
                        rollbackActivity.finish();
                        break;
                    default:
                        int i13 = RollbackActivity.Y;
                        Intent intent = new Intent(rollbackActivity.getApplicationContext(), (Class<?>) GdprPrivacySettings.class);
                        ActivityResultLauncher activityResultLauncher = rollbackActivity.X;
                        float f = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(rollbackActivity));
                        break;
                }
            }
        });
        B0().h.setTypeface(b.f11719r);
        final int i11 = 1;
        B0().f7369c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        B0().f7369c.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        B0().f7369c.addItemDecoration(new f(dimension, dimension));
        B0().f.setTypeface(b.f11720s);
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("gdpr_tracking_allowed")) {
                z9 = sharedPreferences.getBoolean("gdpr_tracking_allowed", false);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            B0().f.setText(getString(R.string.msg_permissions_rollback));
        }
        B0().g.setTypeface(b.f11720s);
        B0().e.setTypeface(b.f11720s);
        B0().e.setOnClickListener(new View.OnClickListener(this) { // from class: l4.l8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RollbackActivity f10601b;

            {
                this.f10601b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                RollbackActivity rollbackActivity = this.f10601b;
                switch (i112) {
                    case 0:
                        int i12 = RollbackActivity.Y;
                        rollbackActivity.finish();
                        break;
                    default:
                        int i13 = RollbackActivity.Y;
                        Intent intent = new Intent(rollbackActivity.getApplicationContext(), (Class<?>) GdprPrivacySettings.class);
                        ActivityResultLauncher activityResultLauncher = rollbackActivity.X;
                        float f = UptodownApp.E;
                        activityResultLauncher.launch(intent, k4.c.b(rollbackActivity));
                        break;
                }
            }
        });
        B0().f7368b.setOnClickListener(new n(21));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new c(this, null, 26), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        p8 p8Var = (p8) this.V.getValue();
        p8Var.getClass();
        w viewModelScope = ViewModelKt.getViewModelScope(p8Var);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new l4.u0(true, p8Var, this, null, 2), 2);
    }

    @Override // l4.a4
    public final void z0() {
    }
}
