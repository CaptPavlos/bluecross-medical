package com.uptodown.tv.ui.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.helper.widget.a;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import q5.n;
import r7.y;
import s5.w;
import s5.x;
import s5.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvMyAppsFragment extends VerticalGridSupportFragment {

    /* renamed from: b, reason: collision with root package name */
    public w f6709b;

    /* renamed from: c, reason: collision with root package name */
    public AlertDialog f6710c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6711d;
    public boolean e;

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleCoroutineScope f6708a = LifecycleOwnerKt.getLifecycleScope(this);
    public final int f = 5;

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        n nVar = new n();
        nVar.f12271a = -1;
        nVar.f12272b = -1;
        nVar.f12273c = -1;
        nVar.f12274d = -1;
        w wVar = new w(nVar);
        this.f6709b = wVar;
        setAdapter(wVar);
        FragmentActivity activity = getActivity();
        if (activity != null && (extras = activity.getIntent().getExtras()) != null) {
            if (extras.containsKey("updates")) {
                this.f6711d = extras.getBoolean("updates");
            }
            if (extras.containsKey("rollback")) {
                this.e = extras.getBoolean("rollback");
            }
        }
        if (this.f6711d) {
            setTitle(getString(R.string.updates));
        } else if (this.e) {
            setTitle(getString(R.string.rollback_title));
        } else {
            setTitle(getString(R.string.installed));
        }
        if (bundle == null) {
            prepareEntranceTransition();
        }
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(this.f);
        setGridPresenter(verticalGridPresenter);
        new Handler(Looper.getMainLooper()).postDelayed(new a(this, 10), 500L);
        setOnItemViewClickedListener(new x(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        y.q(this.f6708a, null, null, new z(this, null, 0), 3);
    }
}
