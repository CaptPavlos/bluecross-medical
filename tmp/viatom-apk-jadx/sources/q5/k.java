package q5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends RowHeaderPresenter {
    @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        HeaderItem headerItem = ((PageRow) obj).getHeaderItem();
        headerItem.getClass();
        View view = viewHolder.view;
        view.setFocusable(true);
        View viewFindViewById = view.findViewById(R.id.iv_icon_header_item);
        viewFindViewById.getClass();
        ((ImageView) viewFindViewById).setImageDrawable(ContextCompat.getDrawable(view.getContext(), ((o5.a) headerItem).f11730a));
    }

    @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        Object systemService = viewGroup.getContext().getSystemService("layout_inflater");
        systemService.getClass();
        return new RowHeaderPresenter.ViewHolder(((LayoutInflater) systemService).inflate(R.layout.tv_icon_header_item, viewGroup, false));
    }
}
