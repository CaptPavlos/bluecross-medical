package q5;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import j4.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public int f12278a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f12279b = -1;

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        y.d().e(((h5.h) obj).e()).e(((u5.h) viewHolder).f12935a, null);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.tv_program_day, viewGroup, false);
        this.f12279b = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue);
        this.f12278a = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue_pressed);
        viewG.setFocusable(true);
        viewG.setFocusableInTouchMode(true);
        viewG.setOnFocusChangeListener(new com.google.android.material.datepicker.c(this, 2));
        viewG.setBackgroundColor(this.f12279b);
        return new u5.h(viewG);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
