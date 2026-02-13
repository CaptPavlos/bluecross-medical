package com.uptodown.activities;

import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.uptodown.R;
import d5.a0;
import e5.n;
import h5.f;
import h5.q;
import h5.r;
import h5.y0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.y;
import l4.a4;
import l4.c4;
import l4.h3;
import l4.j3;
import l4.k3;
import l4.m3;
import l4.n3;
import l4.x2;
import n4.p;
import n4.u0;
import o4.b;
import o7.u;
import r7.i0;
import r7.w;
import s6.m;
import v5.g;
import y2.c;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MyApps extends a4 {

    /* renamed from: j0, reason: collision with root package name */
    public static final /* synthetic */ int f6655j0 = 0;
    public p W;
    public final m U = new m(new x2(this, 1));
    public final ViewModelLazy V = new ViewModelLazy(y.a(c4.class), new n3(this, 0), new m3(this), new n3(this, 1));
    public final j3 X = new j3(this, 0);
    public final j3 Y = new j3(this, 1);
    public final c Z = new c(this, 29);

    public static final int B0(MyApps myApps, String str) {
        p pVar = myApps.W;
        ArrayList arrayList = pVar != null ? pVar.f11451d : null;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        p pVar2 = myApps.W;
        ArrayList arrayList2 = pVar2 != null ? pVar2.f11451d : null;
        arrayList2.getClass();
        int i10 = 0;
        for (Object obj : arrayList2) {
            int i11 = i10 + 1;
            if (((obj instanceof y0) && u.Z(((y0) obj).f8795b, str, true)) || (((obj instanceof f) && u.Z(((f) obj).f8526c, str, true)) || ((obj instanceof u0) && u.Z(((u0) obj).f11493a.f8526c, str, true)))) {
                return i10;
            }
            i10 = i11;
        }
        return -1;
    }

    public static final boolean C0(MyApps myApps, int i10) {
        ArrayList arrayList;
        p pVar = myApps.W;
        if (pVar == null || (arrayList = pVar.f11451d) == null || arrayList.isEmpty()) {
            return false;
        }
        p pVar2 = myApps.W;
        ArrayList arrayList2 = pVar2 != null ? pVar2.f11451d : null;
        arrayList2.getClass();
        if (arrayList2.size() <= i10) {
            return false;
        }
        p pVar3 = myApps.W;
        ArrayList arrayList3 = pVar3 != null ? pVar3.f11451d : null;
        arrayList3.getClass();
        return arrayList3.get(i10) instanceof f;
    }

    public static final boolean D0(MyApps myApps, int i10) {
        ArrayList arrayList;
        p pVar = myApps.W;
        if (pVar == null || (arrayList = pVar.f11451d) == null || arrayList.isEmpty()) {
            return false;
        }
        p pVar2 = myApps.W;
        ArrayList arrayList2 = pVar2 != null ? pVar2.f11451d : null;
        arrayList2.getClass();
        if (arrayList2.size() <= i10) {
            return false;
        }
        p pVar3 = myApps.W;
        ArrayList arrayList3 = pVar3 != null ? pVar3.f11451d : null;
        arrayList3.getClass();
        return arrayList3.get(i10) instanceof u0;
    }

    public final a0 E0() {
        return (a0) this.U.getValue();
    }

    public final c4 F0() {
        return (c4) this.V.getValue();
    }

    public final void G0(boolean z9) {
        c4 c4VarF0 = F0();
        c4VarF0.getClass();
        w viewModelScope = ViewModelKt.getViewModelScope(c4VarF0);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new l4.u0(z9, c4VarF0, this, null, 1), 2);
    }

    @Override // l4.w
    public final void d0() {
        p pVar = this.W;
        if (pVar != null) {
            pVar.e = -1;
        }
    }

    @Override // l4.w
    public final void f0(File file) {
        p pVar = this.W;
        if (pVar != null) {
            pVar.e = -1;
        }
        if (pVar != null) {
            pVar.a(this, file);
        }
    }

    @Override // l4.w
    public final void g0(File file) {
        file.getClass();
        p pVar = this.W;
        if (pVar != null) {
            pVar.a(this, file);
        }
    }

    @Override // l4.w
    public final void h0(File file) {
        f fVar;
        String str;
        p pVar = this.W;
        if (pVar != null) {
            g gVarL = g.f13148u.l(this);
            gVarL.a();
            Iterator it = pVar.f11451d.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i11 = i10 + 1;
                Object next = it.next();
                if ((next instanceof f) && (str = (fVar = (f) next).f8526c) != null && str.length() != 0) {
                    String str2 = fVar.f8526c;
                    str2.getClass();
                    y0 y0VarM = gVarL.M(str2);
                    q qVarA = y0VarM != null ? y0VarM.a(this) : null;
                    if (qVarA != null && qVarA.f8716v.size() == 1 && u.Z(((r) qVarA.f8716v.get(0)).h, file.getAbsolutePath(), true)) {
                        pVar.e = i10;
                        break;
                    }
                }
                i10 = i11;
            }
            gVarL.b();
            int i12 = pVar.e;
            if (i12 >= 0) {
                pVar.notifyItemChanged(i12);
            }
        }
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = E0().f6842a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            E0().g.setNavigationIcon(drawable);
            E0().g.setNavigationContentDescription(getString(R.string.back));
        }
        E0().g.setNavigationOnClickListener(new h3(this, 0));
        E0().g.inflateMenu(R.menu.toolbar_menu_my_apps);
        E0().f6846i.setTypeface(b.f11719r);
        E0().h.setTypeface(b.f11720s);
        try {
            sharedPreferences2 = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        boolean z9 = sharedPreferences2.contains("show_system_apps") ? sharedPreferences2.getBoolean("show_system_apps", false) : false;
        E0().g.getMenu().findItem(R.id.action_show_system_apps).setChecked(z9);
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused2) {
        }
        boolean z10 = sharedPreferences.contains("show_system_services") ? sharedPreferences.getBoolean("show_system_services", false) : false;
        E0().g.getMenu().findItem(R.id.action_show_system_services).setChecked(z10);
        a4.q0(E0().g, z9);
        E0().g.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable));
        E0().g.setOnMenuItemClickListener(new a(this, 12));
        ((TextView) E0().f6843b.f182c).setTypeface(b.f11720s);
        ((TextView) E0().f6843b.f183d).setTypeface(b.f11719r);
        ((TextView) E0().f6843b.f183d).setText(getString(R.string.order_by_name));
        HashMap map = new HashMap();
        map.put(0, getString(R.string.order_by_name));
        map.put(1, getString(R.string.order_by_last_update));
        map.put(2, getString(R.string.order_by_size));
        ((LinearLayout) E0().f6843b.f181b).setOnClickListener(new b5.a(26, this, map));
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        E0().e.addItemDecoration(new x5.f(dimension, dimension));
        E0().e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        E0().e.setItemAnimator(new DefaultItemAnimator());
        hideKeyboardOnScroll(E0().f6845d);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) E0().e.getItemAnimator();
        simpleItemAnimator.getClass();
        simpleItemAnimator.setSupportsChangeAnimations(false);
        E0().f.setOnQueryTextListener(new k3(this));
        EditText editText = (EditText) E0().f.findViewById(R.id.search_src_text);
        editText.setTypeface(b.f11720s);
        editText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.core_search_view_color));
        E0().f.setOnClickListener(new h3(this, 1));
        E0().f6844c.setOnClickListener(new n(11));
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new a6.c(this, null, 17), 3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        keyEvent.getClass();
        if (i10 != 82) {
            return super.onKeyDown(i10, keyEvent);
        }
        E0().g.showOverflowMenu();
        return true;
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        G0(true);
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
    }

    @Override // l4.a4
    public final void x0() {
        G0(false);
    }

    @Override // l4.a4
    public final void y0() {
        G0(false);
    }

    @Override // l4.a4
    public final void z0() {
        G0(false);
    }
}
