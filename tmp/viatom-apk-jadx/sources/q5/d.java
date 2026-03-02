package q5;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.leanback.widget.DetailsOverviewLogoPresenter;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends DetailsOverviewLogoPresenter {
    @Override // androidx.leanback.widget.DetailsOverviewLogoPresenter, androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) throws Resources.NotFoundException {
        FullWidthDetailsOverviewRowPresenter parentPresenter;
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        View view = viewHolder.view;
        view.getClass();
        ((ImageView) view).setImageDrawable(detailsOverviewRow.getImageDrawable());
        c cVar = (c) viewHolder;
        if (!isBoundToImage(cVar, detailsOverviewRow) || (parentPresenter = cVar.getParentPresenter()) == null) {
            return;
        }
        parentPresenter.notifyOnBindLogo(cVar.getParentViewHolder());
    }

    @Override // androidx.leanback.widget.DetailsOverviewLogoPresenter, androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_fullwidth_details_overview_logo, viewGroup, false);
        viewInflate.getClass();
        ImageView imageView = (ImageView) viewInflate;
        Resources resources = viewGroup.getResources();
        imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(resources.getDimensionPixelSize(R.dimen.tv_detail_thumb_width), resources.getDimensionPixelSize(R.dimen.tv_detail_thumb_height)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new c(imageView);
    }
}
