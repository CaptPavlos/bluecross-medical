package s5;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.tv.ui.fragment.TvAppsListFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements OnItemViewSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvAppsListFragment f12635a;

    public h(TvAppsListFragment tvAppsListFragment) {
        this.f12635a = tvAppsListFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj != null) {
            TvAppsListFragment tvAppsListFragment = this.f12635a;
            ArrayObjectAdapter arrayObjectAdapter = tvAppsListFragment.f6704a;
            arrayObjectAdapter.getClass();
            int iIndexOf = arrayObjectAdapter.indexOf(obj);
            int i10 = tvAppsListFragment.f6706c;
            if (iIndexOf >= i10 || iIndexOf < i10 - 5 || tvAppsListFragment.f6707d) {
                return;
            }
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(tvAppsListFragment), null, null, new i(tvAppsListFragment, null, 1), 3);
        }
    }
}
