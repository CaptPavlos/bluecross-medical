package com.uptodown.tv.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.inputmethod.a;
import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.SearchBar;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import r7.o1;
import r7.y;
import s5.h0;
import s5.j0;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvSearchFragment extends SearchSupportFragment implements SearchSupportFragment.SearchResultProvider {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f6719d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayObjectAdapter f6720a = new ArrayObjectAdapter(new ListRowPresenter());

    /* renamed from: b, reason: collision with root package name */
    public String f6721b;

    /* renamed from: c, reason: collision with root package name */
    public o1 f6722c;

    public final void a(String str) {
        this.f6720a.clear();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        o1 o1Var = this.f6722c;
        c cVar = null;
        if (o1Var != null) {
            o1Var.a(null);
        }
        this.f6722c = y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new h0(this, str, cVar, 0), 3);
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public final ObjectAdapter getResultsAdapter() {
        return this.f6720a;
    }

    @Override // androidx.leanback.app.SearchSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSearchResultProvider(this);
        setOnItemViewClickedListener(new a(this, 28));
    }

    @Override // androidx.leanback.app.SearchSupportFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        o1 o1Var = this.f6722c;
        if (o1Var != null) {
            o1Var.a(null);
        }
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public final boolean onQueryTextChange(String str) {
        if (str == null || str.length() <= 2 || str.equalsIgnoreCase(this.f6721b)) {
            return true;
        }
        this.f6721b = str;
        a(str);
        return true;
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public final boolean onQueryTextSubmit(String str) {
        if (str == null || str.length() <= 2 || str.equalsIgnoreCase(this.f6721b)) {
            return true;
        }
        this.f6721b = str;
        a(str);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        SearchBar searchBar = (SearchBar) view.findViewById(R.id.lb_search_bar);
        if (searchBar != null) {
            searchBar.setSearchBarListener(new j0(this));
        }
    }
}
