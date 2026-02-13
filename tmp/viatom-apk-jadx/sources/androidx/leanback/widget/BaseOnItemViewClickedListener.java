package androidx.leanback.widget;

import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface BaseOnItemViewClickedListener<T> {
    void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, T t);
}
