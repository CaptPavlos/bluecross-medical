package com.uptodown.tv.ui.fragment;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import h5.k;
import java.util.ArrayList;
import q5.f;
import r5.c;
import r7.y;
import s5.g;
import s5.h;
import s5.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvAppsListFragment extends VerticalGridSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public ArrayObjectAdapter f6704a;

    /* renamed from: b, reason: collision with root package name */
    public k f6705b;

    /* renamed from: c, reason: collision with root package name */
    public int f6706c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6707d;

    public static final void a(TvAppsListFragment tvAppsListFragment, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ArrayObjectAdapter arrayObjectAdapter = tvAppsListFragment.f6704a;
                arrayObjectAdapter.getClass();
                arrayObjectAdapter.add(arrayList.get(i10));
            }
            return;
        }
        String string = tvAppsListFragment.getString(R.string.no_data_available);
        string.getClass();
        FragmentActivity activity = tvAppsListFragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(string);
        builder.setPositiveButton(android.R.string.ok, new c(6));
        builder.setCancelable(true);
        builder.create().show();
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new f());
        this.f6704a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        FragmentActivity activity = getActivity();
        if (activity != null && (extras = activity.getIntent().getExtras()) != null && extras.containsKey("category")) {
            this.f6705b = (k) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("category", k.class) : extras.getParcelable("category"));
        }
        k kVar = this.f6705b;
        setTitle(kVar != null ? kVar.f8633b : null);
        if (bundle == null) {
            prepareEntranceTransition();
        }
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(5);
        setGridPresenter(verticalGridPresenter);
        startEntranceTransition();
        setOnItemViewClickedListener(new g(this));
        setOnItemViewSelectedListener(new h(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new i(this, null, 1), 3);
    }
}
