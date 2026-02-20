package com.uptodown.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;
import d5.v0;
import e5.n;
import kotlin.jvm.internal.y;
import l4.b9;
import l4.n5;
import l4.q8;
import l4.s1;
import l4.t5;
import l4.t8;
import l4.u8;
import l4.v8;
import l4.w;
import l4.w2;
import l4.x2;
import l4.x8;
import l4.y8;
import l4.z8;
import n4.l0;
import o4.b;
import o7.u;
import r7.i0;
import r7.o1;
import s6.m;
import w6.c;
import x5.f;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class SearchActivity extends w {
    public static final /* synthetic */ int Q = 0;
    public o1 J;
    public l0 K;
    public t8 L;
    public final ActivityResultLauncher P;
    public final m H = new m(new x2(this, 13));
    public final ViewModelLazy I = new ViewModelLazy(y.a(b9.class), new z8(this, 0), new y8(this), new z8(this, 1));
    public boolean M = true;
    public final u8 N = new u8(this);
    public final n5 O = new n5(this, 8);

    public SearchActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 19));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.P = activityResultLauncherRegisterForActivityResult;
    }

    public static final String n0(SearchActivity searchActivity, String str) {
        str.getClass();
        return u.b0(str, "/", "", false);
    }

    public final v0 o0() {
        return (v0) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = o0().f7376a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back_search_bar);
        int i10 = 0;
        if (imageView != null) {
            imageView.setOnClickListener(new q8(this, i10));
        }
        ((ImageView) o0().f7377b.f13464d).setOnClickListener(new q8(this, 1));
        int i11 = 2;
        ((ImageView) o0().f7377b.e).setOnClickListener(new q8(this, i11));
        ((InstantAutoCompleteTextView) o0().f7377b.f13463c).requestFocus();
        ((InstantAutoCompleteTextView) o0().f7377b.f13463c).setTypeface(b.f11720s);
        ((InstantAutoCompleteTextView) o0().f7377b.f13463c).setOnEditorActionListener(new s1(this, i11));
        this.L = new t8(this, this);
        ((InstantAutoCompleteTextView) o0().f7377b.f13463c).setAdapter(this.L);
        ((InstantAutoCompleteTextView) o0().f7377b.f13463c).setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: l4.r8
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                int i13 = SearchActivity.Q;
                adapterView.getClass();
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    Object itemAtPosition = adapterView.getItemAtPosition(i12);
                    itemAtPosition.getClass();
                    String str = ((h5.i0) itemAtPosition).f8614a;
                    if (str != null) {
                        this.f10798a.q0(0, str);
                    }
                }
            }
        });
        ((InstantAutoCompleteTextView) o0().f7377b.f13463c).addTextChangedListener(new t5(this, i11));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        o0().f7379d.setLayoutManager(linearLayoutManager);
        c cVar = null;
        o0().f7379d.setItemAnimator(null);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        o0().f7379d.addItemDecoration(new f(dimension, dimension));
        o0().f7379d.addOnScrollListener(new v8(linearLayoutManager, this));
        hideKeyboardOnScroll(o0().f7379d);
        o0().f7378c.setOnClickListener(new n(22));
        o0().e.setTypeface(b.f11720s);
        t8 t8Var = this.L;
        t8Var.getClass();
        t8Var.getFilter().filter(((InstantAutoCompleteTextView) o0().f7377b.f13463c).getText().toString());
        Intent intent = getIntent();
        if (intent != null && "android.intent.action.SEARCH".equals(intent.getAction()) && (stringExtra = intent.getStringExtra(MBridgeConstans.DYNAMIC_VIEW_WX_QUERY)) != null) {
            q0(0, stringExtra);
        }
        o0().f7378c.setVisibility(8);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.c(this, cVar, 27), 2);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.getClass();
        menuInflater.inflate(R.menu.menu_search, menu);
        Object systemService = getSystemService("search");
        systemService.getClass();
        SearchManager searchManager = (SearchManager) systemService;
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        if (searchView == null) {
            return true;
        }
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        String stringExtra;
        intent.getClass();
        super.onNewIntent(intent);
        if (!"android.intent.action.SEARCH".equals(intent.getAction()) || (stringExtra = intent.getStringExtra(MBridgeConstans.DYNAMIC_VIEW_WX_QUERY)) == null) {
            return;
        }
        q0(0, stringExtra);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).hideSoftInputFromWindow(((InstantAutoCompleteTextView) o0().f7377b.f13463c).getWindowToken(), 0);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        showKeyboard((InstantAutoCompleteTextView) o0().f7377b.f13463c);
        l0 l0Var = this.K;
        if (l0Var != null) {
            l0Var.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onSearchRequested() {
        startSearch(null, false, new Bundle(), false);
        return true;
    }

    public final b9 p0() {
        return (b9) this.I.getValue();
    }

    public final void q0(int i10, String str) {
        o1 o1Var = this.J;
        if (o1Var != null) {
            o1Var.a(null);
        }
        this.J = r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new w2(i10, this, str, null), 3);
    }

    public final void r0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new x8(1, this, str, null), 2);
    }
}
