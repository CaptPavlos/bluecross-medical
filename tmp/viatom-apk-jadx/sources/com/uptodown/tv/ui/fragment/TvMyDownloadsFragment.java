package com.uptodown.tv.ui.fragment;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import l4.kb;
import q5.o;
import r7.y;
import s5.b0;
import s5.c0;
import t3.h;
import v5.g;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvMyDownloadsFragment extends VerticalGridSupportFragment implements BrowseSupportFragment.MainFragmentAdapterProvider {

    /* renamed from: a, reason: collision with root package name */
    public ArrayObjectAdapter f6712a;

    /* renamed from: b, reason: collision with root package name */
    public AlertDialog f6713b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f6714c = new c0(this);

    @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapterProvider
    public final BrowseSupportFragment.MainFragmentAdapter getMainFragmentAdapter() {
        return this.f6714c;
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o oVar = new o();
        oVar.f12275a = -1;
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(oVar);
        this.f6712a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        setTitle(getString(R.string.downloads_title));
        if (bundle == null) {
            prepareEntranceTransition();
        }
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(2);
        setGridPresenter(verticalGridPresenter);
        startEntranceTransition();
        setOnItemViewClickedListener(new b0(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        h hVar = g.f13148u;
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        g gVarL = hVar.l(contextRequireContext);
        gVarL.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("checked", (Integer) 1);
        SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("downloads", contentValues, null, null);
        gVarL.b();
        super.onPause();
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            Object systemService = context.getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(258);
        }
        y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new kb(this, (c) null, 9), 3);
    }
}
