package s5;

import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k0 implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f12646a;

    public k0(p0 p0Var) {
        this.f12646a = p0Var;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof h5.h) {
            p0 p0Var = this.f12646a;
            if (p0Var.getActivity() == null || viewHolder == null) {
                return;
            }
            r5.b bVar = (r5.b) p0Var.getActivity();
            bVar.getClass();
            bVar.i((h5.h) obj, viewHolder);
        }
    }
}
