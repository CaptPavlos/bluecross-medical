package q5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends Presenter {
    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        View view = viewHolder.view;
        view.getClass();
        ((Button) view).setText(((Action) obj).getLabel1());
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new Presenter.ViewHolder(com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.tv_custom_action, viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
