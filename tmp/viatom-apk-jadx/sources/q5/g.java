package q5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public Context f12265a;

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (!(viewHolder instanceof u5.d) || obj == null) {
            return;
        }
        ((u5.d) viewHolder).b(obj);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.tv_card_small_item, viewGroup, false);
        viewG.getClass();
        return new u5.d(viewG, this.f12265a);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
        if (viewHolder instanceof u5.d) {
            ((u5.d) viewHolder).d();
        }
    }
}
