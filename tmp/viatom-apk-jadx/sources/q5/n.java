package q5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public int f12271a;

    /* renamed from: b, reason: collision with root package name */
    public int f12272b;

    /* renamed from: c, reason: collision with root package name */
    public int f12273c;

    /* renamed from: d, reason: collision with root package name */
    public int f12274d;
    public Drawable e;

    public final void a(m mVar, boolean z9) {
        int i10 = z9 ? this.f12271a : this.f12272b;
        int i11 = z9 ? this.f12274d : this.f12273c;
        mVar.setBackgroundColor(i10);
        mVar.findViewById(R.id.info_field).setBackgroundColor(i10);
        View viewFindViewById = mVar.findViewById(R.id.title_text);
        viewFindViewById.getClass();
        ((TextView) viewFindViewById).setTextColor(i11);
        View viewFindViewById2 = mVar.findViewById(R.id.content_text);
        viewFindViewById2.getClass();
        ((TextView) viewFindViewById2).setTextColor(i11);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        View view = viewHolder.view;
        view.getClass();
        ImageCardView imageCardView = (ImageCardView) view;
        if (obj instanceof h5.f) {
            h5.f fVar = (h5.f) obj;
            imageCardView.setTitleText(fVar.f8525b);
            Context context = imageCardView.getContext();
            context.getClass();
            imageCardView.setContentText(l1.b.M(context, fVar.f8533n));
            ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
            Context context2 = viewHolder.view.getContext();
            context2.getClass();
            String str = fVar.f8526c;
            str.getClass();
            Drawable drawableC = v5.n.c(context2, str);
            Resources resources = imageCardView.getResources();
            imageCardView.setMainImageDimensions(resources.getDimensionPixelSize(R.dimen.tv_card_height), resources.getDimensionPixelSize(R.dimen.tv_card_height));
            if (drawableC != null) {
                imageCardView.setMainImage(drawableC);
            } else {
                imageCardView.setMainImage(this.e);
            }
            imageCardView.setPadding(18, 18, 18, 18);
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.f12272b = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f12271a = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f12273c = ContextCompat.getColor(viewGroup.getContext(), R.color.text_primary);
        this.f12274d = ContextCompat.getColor(viewGroup.getContext(), R.color.text_secundary);
        this.e = ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.vector_uptodown_logo_disabled);
        m mVar = new m(this, viewGroup.getContext());
        mVar.setFocusable(true);
        mVar.setFocusableInTouchMode(true);
        a(mVar, false);
        return new Presenter.ViewHolder(mVar);
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
