package com.uptodown.activities;

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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import d5.f1;
import e5.s;
import kotlin.jvm.internal.y;
import l4.kb;
import l4.lb;
import l4.mb;
import l4.ob;
import l4.u4;
import l4.w;
import l4.x2;
import o4.b;
import r7.i0;
import s6.m;
import w6.c;
import w7.n;
import x5.f;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UserDevicesActivity extends w {
    public static final /* synthetic */ int K = 0;
    public final m H = new m(new x2(this, 20));
    public final ViewModelLazy I = new ViewModelLazy(y.a(ob.class), new mb(this, 0), new lb(this), new mb(this, 1));
    public final ActivityResultLauncher J;

    public UserDevicesActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 20));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.J = activityResultLauncherRegisterForActivityResult;
    }

    public final f1 n0() {
        return (f1) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7045a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            n0().e.setNavigationIcon(drawable);
            n0().e.setNavigationContentDescription(getString(R.string.back));
        }
        n0().e.setNavigationOnClickListener(new s(this, 20));
        n0().h.setTypeface(b.f11719r);
        n0().g.setTypeface(b.f11720s);
        n0().f.setTypeface(b.f11720s);
        n0().f7048d.setLayoutManager(new LinearLayoutManager(this, 1, false));
        n0().f7048d.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        n0().f7048d.addItemDecoration(new f(dimension, dimension));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        c cVar = null;
        r7.y.q(lifecycleScope, n.f13548a, null, new kb(this, cVar, 0), 2);
        ob obVar = (ob) this.I.getValue();
        obVar.getClass();
        r7.y.q(ViewModelKt.getViewModelScope(obVar), d.f14116a, null, new u4(this, obVar, cVar, 13), 2);
    }
}
