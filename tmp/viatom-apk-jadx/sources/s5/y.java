package s5;

import androidx.leanback.widget.Presenter;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y implements g5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f12679a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Presenter.ViewHolder f12680b;

    public y(TvMyAppsFragment tvMyAppsFragment, Presenter.ViewHolder viewHolder) {
        this.f12679a = tvMyAppsFragment;
        this.f12680b = viewHolder;
    }

    @Override // g5.i
    public final void l(h5.h hVar) {
        TvMyAppsFragment tvMyAppsFragment = this.f12679a;
        if (tvMyAppsFragment.getActivity() != null) {
            r5.b bVar = (r5.b) tvMyAppsFragment.getActivity();
            bVar.getClass();
            bVar.i(hVar, this.f12680b);
        }
    }

    @Override // g5.i
    public final void f(int i10) {
    }
}
