package com.uptodown.activities;

import a.a;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Updates;
import com.uptodown.workers.DownloadUpdatesWorker;
import com.uptodown.workers.DownloadWorker;
import d5.z0;
import e5.n;
import h5.f;
import h5.q;
import h5.r;
import h5.y0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import k4.c;
import kotlin.jvm.internal.y;
import l4.a4;
import l4.b;
import l4.h9;
import l4.j9;
import l4.n9;
import l4.o9;
import l4.q9;
import l4.r9;
import l4.s9;
import l4.w3;
import l4.w9;
import l4.x2;
import l4.y9;
import n4.u0;
import n4.w0;
import o7.u;
import r7.i0;
import s6.m;
import s6.w;
import t3.h;
import v5.g;
import y6.i;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Updates extends a4 {

    /* renamed from: p0, reason: collision with root package name */
    public static final /* synthetic */ int f6656p0 = 0;
    public ArrayList W;
    public w0 X;
    public boolean Z;

    /* renamed from: n0, reason: collision with root package name */
    public final ActivityResultLauncher f6660n0;

    /* renamed from: o0, reason: collision with root package name */
    public final b f6661o0;
    public final m U = new m(new x2(this, 15));
    public final ViewModelLazy V = new ViewModelLazy(y.a(y9.class), new r9(this, 0), new q9(this), new r9(this, 1));
    public ArrayList Y = new ArrayList();

    /* renamed from: j0, reason: collision with root package name */
    public final j9 f6657j0 = new j9(this, 1);

    /* renamed from: k0, reason: collision with root package name */
    public final j9 f6658k0 = new j9(this, 0);
    public final o9 l0 = new o9(this);

    /* renamed from: m0, reason: collision with root package name */
    public final o9 f6659m0 = new o9(this);

    public Updates() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h9(this));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f6660n0 = activityResultLauncherRegisterForActivityResult;
        this.f6661o0 = new b(this, 5);
    }

    public static final int B0(Updates updates, String str) {
        if (str == null) {
            updates.getClass();
            return -1;
        }
        w0 w0Var = updates.X;
        if (w0Var != null) {
            ArrayList arrayListA = w0Var.a();
            Iterator it = arrayListA.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                int i11 = i10 + 1;
                if (it.next() instanceof u0) {
                    Object obj = arrayListA.get(i10);
                    obj.getClass();
                    if (u.Z(((u0) obj).f11493a.f8526c, str, true)) {
                        return i10;
                    }
                }
                i10 = i11;
            }
        }
        return -1;
    }

    public static final void C0(Updates updates, String str) {
        y0 y0VarM;
        if (updates.Y.isEmpty()) {
            return;
        }
        float f = UptodownApp.E;
        if (c.h() != null) {
            ArrayList arrayListH = c.h();
            arrayListH.getClass();
            if (arrayListH.isEmpty()) {
                return;
            }
            Object obj = updates.Y.get(0);
            obj.getClass();
            f fVar = (f) obj;
            g gVarL = g.f13148u.l(updates);
            gVarL.a();
            q qVarA = null;
            if (str != null && (y0VarM = gVarL.M(str)) != null) {
                qVarA = y0VarM.a(updates);
            }
            gVarL.b();
            updates.I0().f.setOnClickListener(new n(24));
            updates.I0().f7452m.setText(fVar.f8525b);
            updates.I0().f7450k.setText(updates.getString(R.string.dialog_update_all_desc, String.valueOf(updates.Y.size())));
            if (qVarA != null) {
                updates.I0().f7446c.setIndeterminate(false);
                updates.I0().f7446c.setProgress(qVarA.i());
            }
        }
    }

    public final void D0(int i10) {
        if (L0(i10)) {
            w0 w0Var = this.X;
            w0Var.getClass();
            Object obj = w0Var.a().get(i10);
            obj.getClass();
            f fVar = ((u0) obj).f11493a;
            F0(fVar.f8526c);
            v0(fVar);
            w0 w0Var2 = this.X;
            if (w0Var2 != null) {
                w0Var2.notifyItemChanged(i10);
            }
        }
    }

    public final void E0() throws Resources.NotFoundException {
        this.Y = new ArrayList();
        float f = UptodownApp.E;
        UptodownApp.l0 = null;
        K0();
        w0 w0Var = this.X;
        Integer numValueOf = w0Var != null ? Integer.valueOf(w0Var.a().size()) : null;
        if (numValueOf == null || numValueOf.intValue() <= 0) {
            return;
        }
        int iIntValue = numValueOf.intValue();
        for (int i10 = 0; i10 < iIntValue; i10++) {
            D0(i10);
        }
    }

    public final void F0(String str) {
        if (str != null) {
            Iterator it = this.Y.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                }
                int i11 = i10 + 1;
                if (u.Z(((f) it.next()).f8526c, str, true)) {
                    break;
                } else {
                    i10 = i11;
                }
            }
            if (i10 >= 0) {
                this.Y.remove(i10);
            }
        }
    }

    public final void G0() {
        if (!a.f0a) {
            E0();
            return;
        }
        if (!this.Y.isEmpty()) {
            Activity activity = o4.b.g;
            if (r0.f.A() == null) {
                float f = UptodownApp.E;
                if (UptodownApp.l0 == null && !c.o(this, "GenerateQueueWorker") && !c.o(this, "downloadApkWorker")) {
                    Object obj = this.Y.get(0);
                    obj.getClass();
                    f fVar = (f) obj;
                    h hVar = g.f13148u;
                    g gVarL = hVar.l(this);
                    gVarL.a();
                    String str = fVar.f8526c;
                    str.getClass();
                    y0 y0VarM = gVarL.M(str);
                    q qVarA = y0VarM != null ? y0VarM.a(this) : null;
                    gVarL.b();
                    O0(fVar.f8525b);
                    if (qVarA == null || !qVarA.c()) {
                        if (c.o(this, "DownloadUpdatesWorker")) {
                            return;
                        }
                        WorkManager.Companion.getInstance(this).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(DownloadUpdatesWorker.class, "DownloadUpdatesWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", this.Z).build()).build());
                        return;
                    }
                    String str2 = fVar.f8526c;
                    str2.getClass();
                    c.w(str2);
                    if (r0.f.A() != null || UptodownApp.l0 != null) {
                        P0();
                        return;
                    }
                    if (this.Y.isEmpty()) {
                        P0();
                        return;
                    }
                    Object objRemove = this.Y.remove(0);
                    objRemove.getClass();
                    f fVar2 = (f) objRemove;
                    Context applicationContext = getApplicationContext();
                    applicationContext.getClass();
                    g gVarL2 = hVar.l(applicationContext);
                    gVarL2.a();
                    String str3 = fVar2.f8526c;
                    str3.getClass();
                    y0 y0VarM2 = gVarL2.M(str3);
                    q qVarA2 = y0VarM2 != null ? y0VarM2.a(this) : null;
                    gVarL2.b();
                    O0(fVar2.f8525b);
                    if (qVarA2 != null && qVarA2.c()) {
                        UptodownApp.l0 = fVar2;
                        File fileG = qVarA2.g();
                        if (fileG != null) {
                            if (y0VarM2.g == 1) {
                                t0(y0VarM2, fileG);
                            } else {
                                U(fileG, null);
                            }
                            if (this.Y.isEmpty()) {
                                E0();
                                return;
                            }
                            return;
                        }
                    }
                    G0();
                    return;
                }
            }
        }
        w0 w0Var = this.X;
        if (w0Var != null) {
            w0Var.h = false;
        }
        P0();
    }

    public final Object H0(String str, String str2, i iVar) throws Throwable {
        e eVar = i0.f12407a;
        Object objZ = r7.y.z(new c5.m(str, this, str2, null, 14), w7.n.f13548a, iVar);
        return objZ == x6.a.f13718a ? objZ : w.f12711a;
    }

    public final z0 I0() {
        return (z0) this.U.getValue();
    }

    public final y9 J0() {
        return (y9) this.V.getValue();
    }

    public final void K0() throws Resources.NotFoundException {
        SharedPreferences sharedPreferences;
        int i10 = 0;
        I0().f7451l.setVisibility(0);
        I0().f.setVisibility(8);
        if (I0().f7447d.getVisibility() == 0) {
            RelativeLayout relativeLayout = I0().f7447d;
            n9 n9Var = new n9(this, i10);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
            float f = UptodownApp.E;
            boolean z9 = true;
            try {
                sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception unused) {
            }
            boolean z10 = sharedPreferences.contains("animations") ? sharedPreferences.getBoolean("animations", true) : true;
            if (z10) {
                float f10 = UptodownApp.E;
                animationLoadAnimation.setAnimationListener(n9Var);
                relativeLayout.startAnimation(animationLoadAnimation);
            }
            RelativeLayout relativeLayout2 = I0().e;
            float f11 = UptodownApp.E;
            try {
                SharedPreferences sharedPreferences2 = getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences2.contains("animations")) {
                    z9 = sharedPreferences2.getBoolean("animations", true);
                }
            } catch (Exception unused2) {
            }
            if (z9) {
                float f12 = UptodownApp.E;
                relativeLayout2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom));
                relativeLayout2.setVisibility(8);
            } else {
                relativeLayout2.setVisibility(8);
            }
            I0().f7447d.setVisibility(8);
        }
    }

    public final boolean L0(int i10) {
        w0 w0Var = this.X;
        if (w0Var == null || i10 < 0) {
            return false;
        }
        w0Var.getClass();
        if (i10 >= w0Var.getItemCount()) {
            return false;
        }
        w0 w0Var2 = this.X;
        ArrayList arrayListA = w0Var2 != null ? w0Var2.a() : null;
        if (arrayListA == null || arrayListA.isEmpty()) {
            return false;
        }
        w0 w0Var3 = this.X;
        ArrayList arrayListA2 = w0Var3 != null ? w0Var3.a() : null;
        arrayListA2.getClass();
        if (arrayListA2.size() <= i10) {
            return false;
        }
        w0 w0Var4 = this.X;
        ArrayList arrayListA3 = w0Var4 != null ? w0Var4.a() : null;
        arrayListA3.getClass();
        return arrayListA3.get(i10) instanceof u0;
    }

    public final void M0(boolean z9) {
        y9 y9VarJ0 = J0();
        y9VarJ0.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(y9VarJ0);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new w9(z9, y9VarJ0, this, null), 2);
    }

    public final void N0() throws Resources.NotFoundException {
        float f = UptodownApp.E;
        int i10 = 0;
        if (c.o(this, "downloadApkWorker")) {
            w0 w0Var = this.X;
            if (w0Var != null) {
                w0Var.h = false;
                return;
            }
            return;
        }
        this.Y = new ArrayList();
        ArrayList arrayList = this.W;
        arrayList.getClass();
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            this.Y.add(((u0) next).f11493a);
        }
        ArrayList arrayList2 = this.Y;
        if (arrayList2.size() > 1) {
            t6.q.W(arrayList2, new s9(this));
        }
        Iterator it2 = this.Y.iterator();
        it2.getClass();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            next2.getClass();
            a4.r0((f) next2);
        }
        w0 w0Var2 = this.X;
        if (w0Var2 != null) {
            w0Var2.h = true;
            Iterator it3 = w0Var2.a().iterator();
            int i11 = 0;
            int i12 = -1;
            while (it3.hasNext()) {
                int i13 = i10 + 1;
                if (it3.next() instanceof u0) {
                    if (i12 == -1) {
                        i12 = i10;
                    } else {
                        i11++;
                    }
                } else if (i12 != -1) {
                    break;
                }
                i10 = i13;
            }
            if (i12 >= 0) {
                w0Var2.notifyItemRangeChanged(i12, i11);
            } else {
                w0Var2.notifyDataSetChanged();
            }
        }
        P0();
        G0();
    }

    public final void O0(String str) {
        if (this.Y.isEmpty()) {
            return;
        }
        float f = UptodownApp.E;
        if (c.h() != null) {
            ArrayList arrayListH = c.h();
            arrayListH.getClass();
            if (arrayListH.isEmpty()) {
                return;
            }
            I0().f7452m.setText(str);
            I0().f7450k.setText(getString(R.string.dialog_update_all_desc, String.valueOf(this.Y.size())));
            I0().f7446c.setIndeterminate(true);
        }
    }

    public final void P0() throws Resources.NotFoundException {
        SharedPreferences sharedPreferences;
        ArrayList arrayList = this.W;
        if (arrayList != null) {
            boolean z9 = true;
            z9 = true;
            if (arrayList.size() > 1) {
                if (this.Y.size() > 0) {
                    I0().f7451l.setVisibility(8);
                    I0().f.setVisibility(0);
                } else {
                    I0().f7451l.setVisibility(0);
                    I0().f.setVisibility(8);
                }
                if (I0().f7447d.getVisibility() == 8) {
                    RelativeLayout relativeLayout = I0().f7447d;
                    n9 n9Var = new n9(this, z9 ? 1 : 0);
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);
                    float f = UptodownApp.E;
                    try {
                        sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
                    } catch (Exception unused) {
                    }
                    boolean z10 = sharedPreferences.contains("animations") ? sharedPreferences.getBoolean("animations", true) : true;
                    if (z10) {
                        float f10 = UptodownApp.E;
                        animationLoadAnimation.setAnimationListener(n9Var);
                        relativeLayout.startAnimation(animationLoadAnimation);
                    } else {
                        n9Var.onAnimationEnd(animationLoadAnimation);
                    }
                    RelativeLayout relativeLayout2 = I0().e;
                    float f11 = UptodownApp.E;
                    try {
                        SharedPreferences sharedPreferences2 = getSharedPreferences("SettingsPreferences", 0);
                        if (sharedPreferences2.contains("animations")) {
                            z9 = sharedPreferences2.getBoolean("animations", true);
                        }
                    } catch (Exception unused2) {
                    }
                    if (z9) {
                        float f12 = UptodownApp.E;
                        relativeLayout2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom));
                        relativeLayout2.setVisibility(0);
                    } else {
                        relativeLayout2.setVisibility(0);
                    }
                    I0().f7447d.setVisibility(0);
                    return;
                }
                return;
            }
        }
        K0();
    }

    @Override // l4.w
    public final void d0() {
        w0 w0Var = this.X;
        if (w0Var != null) {
            w0Var.g = -1;
        }
    }

    @Override // l4.w
    public final void f0(File file) {
        w0 w0Var = this.X;
        if (w0Var != null) {
            w0Var.g = -1;
        }
        if (w0Var != null) {
            w0Var.b(this, file);
        }
    }

    @Override // l4.w
    public final void g0(File file) {
        file.getClass();
        w0 w0Var = this.X;
        if (w0Var != null) {
            w0Var.b(this, file);
        }
    }

    @Override // l4.w
    public final void h0(File file) {
        f fVar;
        String str;
        w0 w0Var = this.X;
        if (w0Var != null) {
            g gVarL = g.f13148u.l(this);
            gVarL.a();
            int i10 = 0;
            for (Object obj : w0Var.a()) {
                int i11 = i10 + 1;
                if ((obj instanceof f) && (str = (fVar = (f) obj).f8526c) != null && str.length() != 0) {
                    String str2 = fVar.f8526c;
                    str2.getClass();
                    y0 y0VarM = gVarL.M(str2);
                    q qVarA = y0VarM != null ? y0VarM.a(this) : null;
                    if (qVarA != null && qVarA.f8716v.size() > 0) {
                        Iterator it = qVarA.f8716v.iterator();
                        it.getClass();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                if (u.Z(((r) next).h, file.getAbsolutePath(), true)) {
                                    w0Var.g = i10;
                                    break;
                                }
                            }
                        }
                    }
                } else if (obj instanceof u0) {
                    y0 y0Var = ((u0) obj).f11494b;
                    q qVar = y0Var.f8798i;
                    if ((qVar != null ? qVar.f8716v : null) != null) {
                        qVar.getClass();
                        if (qVar.f8716v.size() > 0) {
                            q qVar2 = y0Var.f8798i;
                            qVar2.getClass();
                            Iterator it2 = qVar2.f8716v.iterator();
                            it2.getClass();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object next2 = it2.next();
                                    next2.getClass();
                                    if (u.Z(((r) next2).h, file.getAbsolutePath(), true)) {
                                        w0Var.g = i10;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                i10 = i11;
            }
            gVarL.b();
            int i12 = w0Var.g;
            if (i12 >= 0) {
                w0Var.notifyItemChanged(i12);
            }
        }
    }

    @Override // l4.a4
    public final void o0(String str, ArrayList arrayList, boolean z9) {
        str.getClass();
        String string = getString(R.string.msg_warning_incompatible_required_features_to_install);
        string.getClass();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new w3(this, str, string, arrayList, z9, null, 1), 2);
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = I0().f7444a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            I0().f7448i.setNavigationIcon(drawable);
            I0().f7448i.setNavigationContentDescription(getString(R.string.back));
        }
        final int i10 = 0;
        I0().f7448i.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.i9

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Updates f10501b;

            {
                this.f10501b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i11 = i10;
                Updates updates = this.f10501b;
                switch (i11) {
                    case 0:
                        int i12 = Updates.f6656p0;
                        updates.finish();
                        break;
                    case 1:
                        int i13 = Updates.f6656p0;
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            if (!a.a.f0a) {
                                String string = updates.getString(R.string.error_no_connection);
                                string.getClass();
                                updates.N(string);
                                break;
                            } else if (!a.a.f3d && !updates.Z) {
                                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(updates);
                                y7.e eVar = r7.i0.f12407a;
                                r7.y.q(lifecycleScope, w7.n.f13548a, null, new m9(updates, null, 0), 2);
                                break;
                            } else {
                                updates.N0();
                                break;
                            }
                        }
                        break;
                    default:
                        int i14 = Updates.f6656p0;
                        float f10 = UptodownApp.E;
                        if (k4.c.s()) {
                            updates.E0();
                            updates.P0();
                            break;
                        }
                        break;
                }
            }
        });
        I0().f7453n.setTypeface(o4.b.f11719r);
        I0().f7448i.inflateMenu(R.menu.toolbar_menu_updates);
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable);
        if (drawable2 != null) {
            I0().f7448i.setOverflowIcon(drawable2);
        }
        try {
            sharedPreferences2 = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences2.contains("show_system_apps") ? sharedPreferences2.getBoolean("show_system_apps", false) : false;
        I0().f7448i.getMenu().findItem(R.id.action_show_system_apps).setChecked(z9);
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused2) {
        }
        boolean z10 = sharedPreferences.contains("show_system_services") ? sharedPreferences.getBoolean("show_system_services", false) : false;
        I0().f7448i.getMenu().findItem(R.id.action_show_system_services).setChecked(z10);
        a4.q0(I0().f7448i, z9);
        I0().f7448i.setOnMenuItemClickListener(new h9(this));
        final int i11 = 1;
        I0().g.setLayoutManager(new LinearLayoutManager(this, 1, false));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        I0().g.addItemDecoration(new x5.f(dimension, dimension));
        I0().g.setItemAnimator(defaultItemAnimator);
        I0().f7445b.setOnClickListener(new n(24));
        I0().f7451l.setTypeface(o4.b.f11719r);
        I0().f7451l.setOnClickListener(new View.OnClickListener(this) { // from class: l4.i9

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Updates f10501b;

            {
                this.f10501b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i112 = i11;
                Updates updates = this.f10501b;
                switch (i112) {
                    case 0:
                        int i12 = Updates.f6656p0;
                        updates.finish();
                        break;
                    case 1:
                        int i13 = Updates.f6656p0;
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            if (!a.a.f0a) {
                                String string = updates.getString(R.string.error_no_connection);
                                string.getClass();
                                updates.N(string);
                                break;
                            } else if (!a.a.f3d && !updates.Z) {
                                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(updates);
                                y7.e eVar = r7.i0.f12407a;
                                r7.y.q(lifecycleScope, w7.n.f13548a, null, new m9(updates, null, 0), 2);
                                break;
                            } else {
                                updates.N0();
                                break;
                            }
                        }
                        break;
                    default:
                        int i14 = Updates.f6656p0;
                        float f10 = UptodownApp.E;
                        if (k4.c.s()) {
                            updates.E0();
                            updates.P0();
                            break;
                        }
                        break;
                }
            }
        });
        I0().f7452m.setTypeface(o4.b.f11719r);
        I0().f7450k.setTypeface(o4.b.f11720s);
        I0().f7449j.setTypeface(o4.b.f11719r);
        final int i12 = 2;
        I0().f7449j.setOnClickListener(new View.OnClickListener(this) { // from class: l4.i9

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Updates f10501b;

            {
                this.f10501b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i112 = i12;
                Updates updates = this.f10501b;
                switch (i112) {
                    case 0:
                        int i122 = Updates.f6656p0;
                        updates.finish();
                        break;
                    case 1:
                        int i13 = Updates.f6656p0;
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            if (!a.a.f0a) {
                                String string = updates.getString(R.string.error_no_connection);
                                string.getClass();
                                updates.N(string);
                                break;
                            } else if (!a.a.f3d && !updates.Z) {
                                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(updates);
                                y7.e eVar = r7.i0.f12407a;
                                r7.y.q(lifecycleScope, w7.n.f13548a, null, new m9(updates, null, 0), 2);
                                break;
                            } else {
                                updates.N0();
                                break;
                            }
                        }
                        break;
                    default:
                        int i14 = Updates.f6656p0;
                        float f10 = UptodownApp.E;
                        if (k4.c.s()) {
                            updates.E0();
                            updates.P0();
                            break;
                        }
                        break;
                }
            }
        });
        I0().h.setColorSchemeColors(ContextCompat.getColor(this, R.color.main_blue), ContextCompat.getColor(this, R.color.main_blue_pressed));
        I0().h.setOnRefreshListener(new h9(this));
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        try {
            SharedPreferences sharedPreferences3 = applicationContext.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences3.contains("install_apk_rooted")) {
                sharedPreferences3.getBoolean("install_apk_rooted", false);
            }
        } catch (Exception unused3) {
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.c(this, null, 29), 2);
        getOnBackPressedDispatcher().addCallback(this, this.f6661o0);
        M0(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (DownloadWorker.f) {
            WorkManager.Companion.getInstance(this).cancelAllWorkByTag("DownloadUpdatesWorker");
            float f = UptodownApp.E;
            c.f();
        }
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        w0 w0Var = this.X;
        if (w0Var != null) {
            w0Var.notifyDataSetChanged();
        }
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
        G0();
    }

    @Override // l4.a4
    public final void x0() {
        M0(false);
    }

    @Override // l4.a4
    public final void y0() {
        M0(false);
    }

    @Override // l4.a4
    public final void z0() {
        M0(false);
    }
}
