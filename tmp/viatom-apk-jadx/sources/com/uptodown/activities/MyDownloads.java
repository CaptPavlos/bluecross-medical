package com.uptodown.activities;

import a3.x;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyDownloads;
import d0.i;
import d5.b0;
import d5.j;
import e5.n;
import h5.h;
import h5.q;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import k4.c;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import l4.d4;
import l4.j4;
import l4.k4;
import l4.l4;
import l4.m4;
import l4.n4;
import l4.p4;
import l4.q4;
import l4.v;
import l4.w;
import l4.w2;
import n4.b;
import r7.i0;
import s6.m;
import v5.g;
import x5.f;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MyDownloads extends w {
    public static final /* synthetic */ int O = 0;
    public b J;
    public boolean L;
    public final m H = new m(new d4(this, 0));
    public final ViewModelLazy I = new ViewModelLazy(y.a(q4.class), new n4(this, 0), new m4(this), new n4(this, 1));
    public p4 K = p4.f10722b;
    public final l4.b M = new l4.b(this, 4);
    public final i N = new i((Object) this, 28);

    @Override // l4.w
    public final void d0() {
        b bVar = this.J;
        if (bVar != null) {
            bVar.e = -1;
        }
    }

    @Override // l4.w
    public final void f0(File file) {
        b bVar = this.J;
        if (bVar != null) {
            bVar.e = -1;
        }
        if (bVar != null) {
            bVar.a(this, file);
        }
    }

    @Override // l4.w
    public final void g0(File file) {
        file.getClass();
        b bVar = this.J;
        if (bVar != null) {
            bVar.a(this, file);
        }
    }

    @Override // l4.w
    public final void h0(File file) {
        b bVar = this.J;
        if (bVar != null) {
            Iterator it = bVar.f11300b.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i11 = i10 + 1;
                if (l.a(((q) it.next()).f(this), file)) {
                    bVar.e = i10;
                    break;
                }
                i10 = i11;
            }
            int i12 = bVar.e;
            if (i12 >= 0) {
                bVar.notifyItemChanged(i12);
            }
        }
    }

    @Override // l4.w
    public final void m0(h hVar) {
        hVar.getClass();
        if (isFinishing()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) AppDetailActivity.class);
        intent.putExtra("appInfo", hVar);
        float f = UptodownApp.E;
        startActivity(intent, c.a(this));
    }

    public final void n0(boolean z9) {
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new j4(this, z9, null), 3);
    }

    public final void o0(int i10) {
        b bVar = this.J;
        if (bVar == null || bVar.f11300b.size() <= 0) {
            return;
        }
        b bVar2 = this.J;
        bVar2.getClass();
        if (i10 < bVar2.f11300b.size()) {
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new w2(this, i10, null), 3);
        }
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        final int i10 = 1;
        w6.c cVar = null;
        if (extras != null && extras.containsKey("remoteInstallPath")) {
            Bundle extras2 = getIntent().getExtras();
            String string = extras2 != null ? extras2.getString("remoteInstallPath") : null;
            string.getClass();
            File file = new File(string);
            if (file.exists()) {
                U(file, null);
            }
            Object systemService = getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(8);
        }
        RelativeLayout relativeLayout = p0().f6902a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            p0().g.setNavigationIcon(drawable);
            p0().g.setNavigationContentDescription(getString(R.string.back));
        }
        ((TextView) findViewById(R.id.tv_toolbar_title_downloads)).setTypeface(o4.b.f11719r);
        final int i11 = 0;
        p0().g.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.i4

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MyDownloads f10490b;

            {
                this.f10490b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i11;
                MyDownloads myDownloads = this.f10490b;
                switch (i12) {
                    case 0:
                        int i13 = MyDownloads.O;
                        myDownloads.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i14 = MyDownloads.O;
                        myDownloads.p0().f.setIconified(false);
                        break;
                    case 2:
                        int i15 = MyDownloads.O;
                        String string2 = myDownloads.getString(R.string.dialog_delete_all_download_msg);
                        string2.getClass();
                        myDownloads.K(String.format(string2, Arrays.copyOf(new Object[0], 0)), new d4(myDownloads, 4));
                        break;
                    default:
                        int i16 = MyDownloads.O;
                        String string3 = myDownloads.getString(R.string.dialog_delete_selected_download_msg);
                        string3.getClass();
                        myDownloads.K(String.format(string3, Arrays.copyOf(new Object[0], 0)), new d4(myDownloads, 1));
                        break;
                }
            }
        });
        p0().g.inflateMenu(R.menu.toolbar_menu_my_downloads);
        int i12 = 13;
        p0().g.setOnMenuItemClickListener(new a(this, i12));
        p0().f.setOnQueryTextListener(new k4(this));
        p0().f.setOnClickListener(new View.OnClickListener(this) { // from class: l4.i4

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MyDownloads f10490b;

            {
                this.f10490b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i10;
                MyDownloads myDownloads = this.f10490b;
                switch (i122) {
                    case 0:
                        int i13 = MyDownloads.O;
                        myDownloads.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i14 = MyDownloads.O;
                        myDownloads.p0().f.setIconified(false);
                        break;
                    case 2:
                        int i15 = MyDownloads.O;
                        String string2 = myDownloads.getString(R.string.dialog_delete_all_download_msg);
                        string2.getClass();
                        myDownloads.K(String.format(string2, Arrays.copyOf(new Object[0], 0)), new d4(myDownloads, 4));
                        break;
                    default:
                        int i16 = MyDownloads.O;
                        String string3 = myDownloads.getString(R.string.dialog_delete_selected_download_msg);
                        string3.getClass();
                        myDownloads.K(String.format(string3, Arrays.copyOf(new Object[0], 0)), new d4(myDownloads, 1));
                        break;
                }
            }
        });
        ((ImageView) p0().f.findViewById(R.id.search_close_btn)).setBackgroundResource(R.drawable.core_shape_transparent);
        EditText editText = (EditText) p0().f.findViewById(R.id.search_src_text);
        editText.setTypeface(o4.b.f11720s);
        editText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.core_search_view_color));
        ((TextView) ((x) p0().f6904c.f).f182c).setTypeface(o4.b.f11720s);
        ((TextView) ((x) p0().f6904c.f).f183d).setTypeface(o4.b.f11719r);
        ((TextView) ((x) p0().f6904c.f).f183d).setText(getString(R.string.order_by_date));
        HashMap map = new HashMap();
        map.put(0, getString(R.string.order_by_name));
        map.put(1, getString(R.string.order_by_date));
        final int i13 = 2;
        map.put(2, getString(R.string.order_by_size));
        ((LinearLayout) ((x) p0().f6904c.f).f181b).setOnClickListener(new b5.a(29, this, map));
        p0().e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        p0().e.addItemDecoration(new f(dimension, dimension));
        p0().e.setItemAnimator(null);
        p0().e.addOnItemTouchListener(new l4(this));
        p0().h.setTypeface(o4.b.f11720s);
        j jVar = p0().f6904c;
        ((TextView) p0().f6904c.e).setTypeface(o4.b.f11720s);
        ((TextView) p0().f6904c.f7135c).setTypeface(o4.b.f11719r);
        ((TextView) p0().f6904c.f7135c).setOnClickListener(new View.OnClickListener(this) { // from class: l4.i4

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MyDownloads f10490b;

            {
                this.f10490b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i13;
                MyDownloads myDownloads = this.f10490b;
                switch (i122) {
                    case 0:
                        int i132 = MyDownloads.O;
                        myDownloads.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i14 = MyDownloads.O;
                        myDownloads.p0().f.setIconified(false);
                        break;
                    case 2:
                        int i15 = MyDownloads.O;
                        String string2 = myDownloads.getString(R.string.dialog_delete_all_download_msg);
                        string2.getClass();
                        myDownloads.K(String.format(string2, Arrays.copyOf(new Object[0], 0)), new d4(myDownloads, 4));
                        break;
                    default:
                        int i16 = MyDownloads.O;
                        String string3 = myDownloads.getString(R.string.dialog_delete_selected_download_msg);
                        string3.getClass();
                        myDownloads.K(String.format(string3, Arrays.copyOf(new Object[0], 0)), new d4(myDownloads, 1));
                        break;
                }
            }
        });
        ((TextView) p0().f6904c.f7136d).setTypeface(o4.b.f11719r);
        final int i14 = 3;
        ((TextView) p0().f6904c.f7136d).setOnClickListener(new View.OnClickListener(this) { // from class: l4.i4

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MyDownloads f10490b;

            {
                this.f10490b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i14;
                MyDownloads myDownloads = this.f10490b;
                switch (i122) {
                    case 0:
                        int i132 = MyDownloads.O;
                        myDownloads.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i142 = MyDownloads.O;
                        myDownloads.p0().f.setIconified(false);
                        break;
                    case 2:
                        int i15 = MyDownloads.O;
                        String string2 = myDownloads.getString(R.string.dialog_delete_all_download_msg);
                        string2.getClass();
                        myDownloads.K(String.format(string2, Arrays.copyOf(new Object[0], 0)), new d4(myDownloads, 4));
                        break;
                    default:
                        int i16 = MyDownloads.O;
                        String string3 = myDownloads.getString(R.string.dialog_delete_selected_download_msg);
                        string3.getClass();
                        myDownloads.K(String.format(string3, Arrays.copyOf(new Object[0], 0)), new d4(myDownloads, 1));
                        break;
                }
            }
        });
        p0().f6903b.setOnClickListener(new n(i12));
        u0();
        hideKeyboardOnScroll(p0().f6905d);
        B();
        getOnBackPressedDispatcher().addCallback(this, this.M);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.c(this, cVar, 18), 2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        try {
            g gVarL = g.f13148u.l(this);
            gVarL.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("checked", (Integer) 1);
            SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.update("downloads", contentValues, null, null);
            gVarL.b();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
        r0(true);
    }

    public final b0 p0() {
        return (b0) this.H.getValue();
    }

    public final q4 q0() {
        return (q4) this.I.getValue();
    }

    public final void r0(boolean z9) {
        q4 q4VarQ0 = q0();
        p4 p4Var = this.K;
        q4VarQ0.getClass();
        p4Var.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(q4VarQ0);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new v(z9, q4VarQ0, this, p4Var, null), 2);
    }

    public final void s0() {
        int i10;
        b bVar = this.J;
        if (bVar != null) {
            boolean[] zArr = bVar.f11302d;
            if (zArr != null) {
                i10 = 0;
                for (boolean z9 : zArr) {
                    if (z9) {
                        i10++;
                    }
                }
            } else {
                i10 = 0;
            }
            TextView textView = (TextView) p0().f6904c.f7135c;
            b bVar2 = this.J;
            bVar2.getClass();
            textView.setEnabled(bVar2.f11300b.size() > 0);
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            ((TextView) p0().f6904c.f7136d).setEnabled(true);
            ((TextView) p0().f6904c.f7136d).setBackground(ContextCompat.getDrawable(this, R.drawable.ripple_blue_primary_button));
        } else {
            ((TextView) p0().f6904c.f7136d).setEnabled(false);
            ((TextView) p0().f6904c.f7136d).setBackground(ContextCompat.getDrawable(this, R.drawable.ripple_light_grey));
        }
        ((TextView) p0().f6904c.e).setText(getString(R.string.core_x_items_selected, String.valueOf(i10)));
    }

    public final void t0() {
        ((RelativeLayout) p0().f6904c.f7134b).setVisibility(0);
        ((RelativeLayout) p0().f6904c.g).setVisibility(0);
        ((LinearLayout) ((x) p0().f6904c.f).f181b).setVisibility(4);
        s0();
    }

    public final void u0() {
        b bVar = this.J;
        if (bVar != null) {
            bVar.c(false);
        }
        ((RelativeLayout) p0().f6904c.f7134b).setVisibility(0);
        ((LinearLayout) ((x) p0().f6904c.f).f181b).setVisibility(0);
        ((RelativeLayout) p0().f6904c.g).setVisibility(4);
    }
}
