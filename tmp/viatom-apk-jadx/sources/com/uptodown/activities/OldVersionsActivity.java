package com.uptodown.activities;

import a6.c;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d5.f0;
import e5.n;
import h5.c0;
import h5.f;
import h5.h;
import h5.q;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.y;
import l4.h5;
import l4.i5;
import l4.k5;
import l4.u4;
import l4.w;
import l4.x2;
import l4.x4;
import l5.a;
import n4.s;
import o4.b;
import r7.i0;
import s6.m;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class OldVersionsActivity extends w {
    public static final /* synthetic */ int L = 0;
    public s J;
    public final m H = new m(new x2(this, 4));
    public final ViewModelLazy I = new ViewModelLazy(y.a(k5.class), new i5(this, 0), new h5(this), new i5(this, 1));
    public final x4 K = new x4(this, 1);

    public static final void n0(OldVersionsActivity oldVersionsActivity, q qVar) {
        c0 c0Var;
        Object obj;
        Object value = oldVersionsActivity.q0().f10552d.getValue();
        value.getClass();
        ArrayList arrayList = ((h) value).C0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i10);
                i10++;
                c0 c0Var2 = (c0) obj;
                if (qVar != null && c0Var2.f8488d == qVar.e) {
                    break;
                }
            }
            c0Var = (c0) obj;
        } else {
            c0Var = null;
        }
        Object value2 = oldVersionsActivity.q0().f10552d.getValue();
        value2.getClass();
        ArrayList arrayList2 = ((h) value2).C0;
        Integer numValueOf = arrayList2 != null ? Integer.valueOf(arrayList2.indexOf(c0Var)) : null;
        if (c0Var == null || numValueOf == null) {
            s sVar = oldVersionsActivity.J;
            if (sVar != null) {
                sVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        s sVar2 = oldVersionsActivity.J;
        if (sVar2 != null) {
            sVar2.notifyItemChanged(numValueOf.intValue());
        }
    }

    public final f0 o0() {
        return (f0) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = o0().f7041a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        q0().f = true;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                q0().f10551c.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP, f.class) : extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP));
            }
            if (extras.containsKey("appInfo")) {
                q0().f10552d.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", h.class) : extras.getParcelable("appInfo"));
            }
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_old_versions);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription(getString(R.string.back));
            }
            toolbar.setNavigationOnClickListener(new e5.s(this, 15));
        }
        ((TextView) findViewById(R.id.tv_toolbar_old_versions)).setTypeface(b.f11719r);
        o0().f7044d.setTypeface(b.f11720s);
        o0().f7043c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        o0().f7043c.setItemAnimator(null);
        o0().f7043c.addItemDecoration(new x5.f((int) getResources().getDimension(R.dimen.margin_m), (int) getResources().getDimension(R.dimen.margin_xl)));
        o0().f7042b.setOnClickListener(new n(16));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new c(this, null, 20), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        p0();
    }

    public final void p0() {
        q0().e = true;
        if (q0().f10552d.getValue() != null) {
            k5 k5VarQ0 = q0();
            k5VarQ0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(k5VarQ0);
            e eVar = i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new u4(k5VarQ0, this, null, 2), 2);
        }
    }

    public final k5 q0() {
        return (k5) this.I.getValue();
    }

    public final void r0(q qVar) {
        String str = qVar.f8701b;
        str.getClass();
        long j10 = qVar.e;
        PackageManager packageManager = getPackageManager();
        try {
            packageManager.getClass();
            if (j10 < x4.d.d(a.f(packageManager, str, 128))) {
                String str2 = qVar.f8701b;
                str2.getClass();
                String string = getString(R.string.msg_warning_old_versions);
                string.getClass();
                K(string, new androidx.room.b(this, qVar, str2, 4));
                return;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        File fileG = qVar.g();
        if (fileG == null || !fileG.exists()) {
            return;
        }
        float f = UptodownApp.E;
        k4.c.q(this, fileG, null);
    }

    public final void s0(q qVar) {
        int iQ = qVar.q(this);
        if (iQ < 0) {
            C(getString(R.string.error_cant_enqueue_download) + " (108)");
            return;
        }
        Object value = q0().f10552d.getValue();
        value.getClass();
        String str = ((h) value).f8567b;
        str.getClass();
        e0(iQ, str);
    }
}
