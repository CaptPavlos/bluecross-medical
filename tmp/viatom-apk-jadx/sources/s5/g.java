package s5;

import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.tv.ui.fragment.TvAppsListFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvAppsListFragment f12630a;

    public g(TvAppsListFragment tvAppsListFragment) {
        this.f12630a = tvAppsListFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof h5.h) {
            TvAppsListFragment tvAppsListFragment = this.f12630a;
            if (tvAppsListFragment.getActivity() == null || viewHolder == null) {
                return;
            }
            r5.b bVar = (r5.b) tvAppsListFragment.getActivity();
            bVar.getClass();
            bVar.i((h5.h) obj, viewHolder);
        }
    }
}
