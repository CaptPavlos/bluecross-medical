package com.uptodown.activities;

import a3.i0;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import c1.w4;
import com.uptodown.R;
import d5.p;
import e5.s;
import h5.f;
import h5.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.y;
import l4.p0;
import l4.r0;
import l4.s0;
import l4.u0;
import l4.v0;
import l4.w;
import n4.e;
import o4.b;
import o7.u;
import s6.m;
import w7.n;
import x6.a;
import y2.c;
import y6.i;
import y7.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class FreeUpSpaceActivity extends w {
    public static final /* synthetic */ int M = 0;
    public e J;
    public h K;
    public final m H = new m(new i0(this, 23));
    public final ViewModelLazy I = new ViewModelLazy(y.a(v0.class), new s0(this, 0), new r0(this), new s0(this, 1));
    public final c L = new c(this, 26);

    public static final int n0(FreeUpSpaceActivity freeUpSpaceActivity, String str) {
        e eVar = freeUpSpaceActivity.J;
        ArrayList arrayListA = eVar != null ? eVar.a() : null;
        if (arrayListA == null || arrayListA.isEmpty()) {
            return -1;
        }
        e eVar2 = freeUpSpaceActivity.J;
        ArrayList arrayListA2 = eVar2 != null ? eVar2.a() : null;
        arrayListA2.getClass();
        Iterator it = arrayListA2.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            if (u.Z(((f) it.next()).f8526c, str, true)) {
                return i10;
            }
            i10 = i11;
        }
        return -1;
    }

    public final Object o0(String str, String str2, i iVar) throws Throwable {
        y7.e eVar = r7.i0.f12407a;
        Object objZ = r7.y.z(new c5.m(this, str2, str, null, 7), n.f13548a, iVar);
        return objZ == a.f13718a ? objZ : s6.w.f12711a;
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("appInfo")) {
            Intent intent2 = getIntent();
            intent2.getClass();
            Bundle extras2 = intent2.getExtras();
            extras2.getClass();
            this.K = (h) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras2.getParcelable("appInfo", h.class) : extras2.getParcelable("appInfo"));
        }
        RelativeLayout relativeLayout = p0().f7273a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            p0().e.setNavigationIcon(drawable);
            p0().e.setNavigationContentDescription(getString(R.string.back));
        }
        p0().e.setNavigationOnClickListener(new s(this, 9));
        p0().f.setTypeface(b.f11719r);
        ((TextView) p0().f7274b.f7136d).setTypeface(b.f11720s);
        ((TextView) p0().f7274b.e).setTypeface(b.f11720s);
        ((TextView) p0().f7274b.f7135c).setTypeface(b.f11719r);
        ((TextView) p0().f7274b.f7135c).setVisibility(8);
        q0();
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        p0().f7276d.addItemDecoration(new x5.f(dimension, dimension));
        p0().f7276d.setLayoutManager(new LinearLayoutManager(this, 1, false));
        p0().f7276d.setItemAnimator(new DefaultItemAnimator());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) p0().f7276d.getItemAnimator();
        simpleItemAnimator.getClass();
        simpleItemAnimator.setSupportsChangeAnimations(false);
        p0().f7275c.setOnClickListener(new e5.n(5));
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new p0(this, null, 1), 3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        keyEvent.getClass();
        if (i10 != 82) {
            return super.onKeyDown(i10, keyEvent);
        }
        p0().e.showOverflowMenu();
        return true;
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        v0 v0Var = (v0) this.I.getValue();
        v0Var.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(v0Var);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new u0(true, v0Var, this, null, 0), 2);
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
    }

    public final p p0() {
        return (p) this.H.getValue();
    }

    public final void q0() {
        long j10;
        File externalFilesDir;
        String str;
        h hVar = this.K;
        if (hVar == null || (str = hVar.g) == null) {
            j10 = 0;
        } else {
            try {
                str.getClass();
                j10 = Long.parseLong(str);
            } catch (Exception unused) {
            }
        }
        w4 w4Var = new w4(this, 3, false);
        if (w4Var.D()) {
            File[] externalFilesDirs = getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalFilesDir = externalFilesDirs[1];
            } else {
                File externalFilesDir2 = getExternalFilesDir(null);
                w4Var.P();
                w4Var.O();
                externalFilesDir = externalFilesDir2;
            }
        } else {
            externalFilesDir = getExternalFilesDir(null);
        }
        File file = new File(externalFilesDir, "Apps");
        if (!file.exists()) {
            file.mkdirs();
        }
        long jE = r0.f.E(this, file);
        long totalSpace = file.getTotalSpace();
        long j11 = (long) (j10 * 2.25d);
        long j12 = totalSpace - jE;
        long j13 = (100 * j12) / totalSpace;
        long j14 = totalSpace - ((9 * totalSpace) / 10);
        if (j11 > jE) {
            String strM = l1.b.M(this, j11 - jE);
            ((ProgressBar) p0().f7274b.g).setProgress((int) j13);
            ((ProgressBar) p0().f7274b.f).setVisibility(8);
            ((ProgressBar) p0().f7274b.g).setVisibility(0);
            ((TextView) p0().f7274b.f7136d).setText(getString(R.string.error_not_enough_space));
            ((TextView) p0().f7274b.e).setText(getString(R.string.no_storage_text, strM));
            return;
        }
        if (jE < j14) {
            ((ProgressBar) p0().f7274b.g).setProgress((int) j13);
            ((ProgressBar) p0().f7274b.f).setVisibility(8);
            ((ProgressBar) p0().f7274b.g).setVisibility(0);
            ((TextView) p0().f7274b.f7136d).setText(getString(R.string.error_not_enough_space));
            ((TextView) p0().f7274b.e).setText(getString(R.string.enough_storage_text, l1.b.M(this, j12), l1.b.M(this, totalSpace)));
            return;
        }
        ((ProgressBar) p0().f7274b.f).setProgress((int) j13);
        ((ProgressBar) p0().f7274b.g).setVisibility(8);
        ((ProgressBar) p0().f7274b.f).setVisibility(0);
        ((TextView) p0().f7274b.f7136d).setText(getString(R.string.enough_storage_title));
        ((TextView) p0().f7274b.e).setText(getString(R.string.enough_storage_text, l1.b.M(this, j12), l1.b.M(this, totalSpace)));
    }
}
