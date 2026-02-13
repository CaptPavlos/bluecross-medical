package q5;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import j4.d0;
import j4.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public int f12261a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f12262b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f12263c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f12264d = -1;

    public final void a(e eVar, boolean z9) {
        int i10 = z9 ? this.f12261a : this.f12262b;
        int i11 = z9 ? this.f12264d : this.f12263c;
        eVar.setBackgroundColor(i10);
        View viewFindViewById = eVar.findViewById(R.id.info_field);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(i10);
        }
        TextView textView = (TextView) eVar.findViewById(R.id.title_text);
        if (textView != null) {
            textView.setTextColor(i11);
        }
        TextView textView2 = (TextView) eVar.findViewById(R.id.content_text);
        if (textView2 != null) {
            textView2.setTextColor(i11);
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) throws Resources.NotFoundException {
        viewHolder.getClass();
        View view = viewHolder.view;
        view.getClass();
        ImageCardView imageCardView = (ImageCardView) view;
        if (!(obj instanceof h5.h)) {
            if (obj instanceof o5.c) {
                Resources resources = imageCardView.getResources();
                imageCardView.setMainImageDimensions(resources.getDimensionPixelSize(R.dimen.tv_card_height) / 2, resources.getDimensionPixelSize(R.dimen.tv_card_height) / 2);
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.margin_m) * 5;
                imageCardView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                imageCardView.setMainImage(ContextCompat.getDrawable(imageCardView.getContext(), R.drawable.vector_plus));
                TextView textView = (TextView) imageCardView.findViewById(R.id.title_text);
                if (textView != null) {
                    textView.setVisibility(8);
                    textView.setText("");
                }
                TextView textView2 = (TextView) imageCardView.findViewById(R.id.content_text);
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    textView2.setText("");
                    return;
                }
                return;
            }
            return;
        }
        h5.h hVar = (h5.h) obj;
        imageCardView.setTitleText(hVar.f8567b);
        imageCardView.setContentText(hVar.f);
        TextView textView3 = (TextView) imageCardView.findViewById(R.id.title_text);
        if (textView3 != null) {
            textView3.setVisibility(0);
            textView3.setTextColor(this.f12263c);
            textView3.setTypeface(o4.b.f11719r);
        }
        TextView textView4 = (TextView) imageCardView.findViewById(R.id.content_text);
        if (textView4 != null) {
            textView4.setVisibility(0);
            textView4.setTextColor(this.f12263c);
            textView4.setTypeface(o4.b.f11720s);
            textView4.setMaxLines(2);
            textView4.setLines(2);
        }
        Resources resources2 = imageCardView.getResources();
        int dimensionPixelSize2 = resources2.getDimensionPixelSize(R.dimen.tv_card_height);
        imageCardView.setMainImageDimensions(dimensionPixelSize2, resources2.getDimensionPixelSize(R.dimen.tv_card_height));
        d0 d0VarE = y.d().e(hVar.g(dimensionPixelSize2));
        d0VarE.f(R.drawable.shape_bg_placeholder);
        d0VarE.e(imageCardView.getMainImageView(), null);
        int dimensionPixelSize3 = resources2.getDimensionPixelSize(R.dimen.margin_m);
        imageCardView.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.f12262b = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f12261a = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f12263c = ContextCompat.getColor(viewGroup.getContext(), R.color.text_secundary);
        this.f12264d = ContextCompat.getColor(viewGroup.getContext(), R.color.text_primary);
        e eVar = new e(this, viewGroup.getContext());
        eVar.setFocusable(true);
        eVar.setFocusableInTouchMode(true);
        a(eVar, false);
        return new Presenter.ViewHolder(eVar);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
        View view = viewHolder.view;
        view.getClass();
        ImageCardView imageCardView = (ImageCardView) view;
        imageCardView.setBadgeImage(null);
        imageCardView.setMainImage(null);
    }
}
