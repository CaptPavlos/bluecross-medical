package com.uptodown.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.SendUserUsageStatsWorker;
import d5.c0;
import e5.n;
import e5.s;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.y;
import l4.r4;
import l4.s4;
import l4.u4;
import l4.v4;
import l4.w;
import l4.x2;
import o4.b;
import r7.i0;
import s6.m;
import v5.o;
import w6.c;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MyStatsActivity extends w {
    public static final /* synthetic */ int K = 0;
    public final m H = new m(new x2(this, 2));
    public final ViewModelLazy I = new ViewModelLazy(y.a(v4.class), new s4(this, 0), new r4(this), new s4(this, 1));
    public final ActivityResultLauncher J;

    public MyStatsActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 14));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.J = activityResultLauncherRegisterForActivityResult;
    }

    public final c0 n0() {
        return (c0) this.H.getValue();
    }

    public final void o0() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            n0().e.setNavigationIcon(drawable);
            n0().e.setNavigationContentDescription(getString(R.string.back));
        }
        n0().e.setNavigationOnClickListener(new s(this, 13));
        n0().f6950v.setTypeface(b.f11719r);
        n0().f6951w.setTypeface(b.f11719r);
        n0().f6952x.setTypeface(b.f11719r);
        n0().g.setTypeface(b.f11720s);
        n0().h.setTypeface(b.f11719r);
        n0().y.setTypeface(b.f11720s);
        n0().f6953z.setTypeface(b.f11719r);
        n0().f.setTypeface(b.f11720s);
        n0().f6948s.setTypeface(b.f11719r);
        n0().t.setTypeface(b.f11719r);
        n0().f6940k.setTypeface(b.f11719r);
        n0().f6941l.setTypeface(b.f11719r);
        n0().f6946q.setTypeface(b.f11719r);
        n0().f6947r.setTypeface(b.f11719r);
        n0().f6938i.setTypeface(b.f11719r);
        n0().f6939j.setTypeface(b.f11719r);
        n0().f6944o.setTypeface(b.f11719r);
        n0().f6945p.setTypeface(b.f11719r);
        n0().f6942m.setTypeface(b.f11719r);
        n0().f6943n.setTypeface(b.f11719r);
        n0().A.setTypeface(b.f11719r);
        n0().f6949u.setTypeface(b.f11719r);
        n0().f6936c.setOnClickListener(new n(14));
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f6934a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        c cVar = null;
        if (o.b(this)) {
            float f = UptodownApp.E;
            if (!k4.c.o(this, "SendUserUsageStatsWorker")) {
                WorkManager.Companion.getInstance(this).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) SendUserUsageStatsWorker.class, 24L, TimeUnit.HOURS).addTag("SendUserUsageStatsWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
            }
            o0();
            v4 v4Var = (v4) this.I.getValue();
            v4Var.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(v4Var);
            e eVar = i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new u4(v4Var, this, cVar, 0), 2);
        } else {
            this.J.launch(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar2 = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.c(this, cVar, 19), 2);
    }
}
