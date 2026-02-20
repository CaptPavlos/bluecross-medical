package q5;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends Presenter {
    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        TextView textView = (TextView) viewHolder.view.findViewById(R.id.tv_name);
        textView.setTypeface(o4.b.f11719r);
        textView.setText(((h5.k) obj).f8633b);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new Presenter.ViewHolder(com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.tv_category_tag, viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
