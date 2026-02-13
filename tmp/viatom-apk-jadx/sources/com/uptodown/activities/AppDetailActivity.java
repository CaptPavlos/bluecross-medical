package com.uptodown.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentTransaction;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import e5.b2;
import e5.j0;
import h5.h;
import h5.k;
import java.util.ArrayList;
import k4.c;
import l4.a;
import l4.b;
import l4.w;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class AppDetailActivity extends w {
    public static final /* synthetic */ int N = 0;
    public k H;
    public final ArrayList I = new ArrayList();
    public final ArrayList J = new ArrayList();
    public final ArrayList K = new ArrayList();
    public final ActivityResultLauncher L;
    public final b M;

    public AppDetailActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 1));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.L = activityResultLauncherRegisterForActivityResult;
        this.M = new b(this, 0);
    }

    @Override // l4.w
    public final void m0(h hVar) {
        hVar.getClass();
        j0 j0Var = new j0();
        Bundle bundle = new Bundle();
        bundle.putParcelable("appInfo", hVar);
        j0Var.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_app_detail_activity, j0Var, (String) null).addToBackStack(String.valueOf(hVar.f8566a)).commit();
        this.I.add(j0Var);
    }

    public final j0 n0() {
        ArrayList arrayList = this.I;
        if (arrayList.size() > 0) {
            return (j0) l.i0(arrayList);
        }
        return null;
    }

    public final void o0(k kVar) {
        kVar.getClass();
        b2 b2Var = new b2();
        b2Var.f7688c = kVar;
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.getClass();
        float f = UptodownApp.E;
        c.D(fragmentTransactionBeginTransaction, this);
        fragmentTransactionBeginTransaction.add(R.id.fl_main_app_detail_activity, b2Var, (String) null).addToBackStack(String.valueOf(kVar.f8632a)).commit();
        this.J.add(b2Var);
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        h hVar;
        Bundle extras;
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.app_detail_activity, (ViewGroup) null);
        viewInflate.getClass();
        setContentView(viewInflate);
        Intent intent = getIntent();
        this.F = (RelativeLayout) findViewById(R.id.app_info_selected_popup);
        if (intent == null || (extras = intent.getExtras()) == null) {
            hVar = null;
        } else {
            if (extras.containsKey("appInfo")) {
                hVar = (h) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", h.class) : extras.getParcelable("appInfo"));
            } else {
                hVar = null;
            }
            if (extras.containsKey("viewCategory")) {
                this.H = (k) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("viewCategory", k.class) : extras.getParcelable("viewCategory"));
            }
        }
        j0 j0Var = new j0();
        Bundle bundle2 = new Bundle();
        if (hVar != null) {
            bundle2.putParcelable("appInfo", hVar);
        }
        j0Var.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_app_detail_activity, j0Var, (String) null).commit();
        getOnBackPressedDispatcher().addCallback(this, this.M);
        this.D = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 0));
        this.I.add(j0Var);
        k kVar = this.H;
        if (kVar != null) {
            o0(kVar);
        }
    }
}
