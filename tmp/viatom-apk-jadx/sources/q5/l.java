package q5;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public int f12268a;

    /* renamed from: b, reason: collision with root package name */
    public int f12269b;

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        o5.b bVar = (o5.b) obj;
        u5.e eVar = (u5.e) viewHolder;
        eVar.f12926b.setText(bVar.f11732b);
        eVar.f12925a.setImageResource(bVar.f11733c);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.tv_manage_apps_item, viewGroup, false);
        this.f12269b = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue);
        this.f12268a = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue_pressed);
        viewG.setFocusable(true);
        viewG.setFocusableInTouchMode(true);
        viewG.setOnFocusChangeListener(new com.google.android.material.datepicker.c(this, 1));
        viewG.setBackgroundColor(this.f12269b);
        return new u5.e(viewG);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
