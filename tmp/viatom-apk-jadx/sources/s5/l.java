package s5;

import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements g5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f12647a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Presenter.ViewHolder f12648b;

    public l(m mVar, Presenter.ViewHolder viewHolder) {
        this.f12647a = mVar;
        this.f12648b = viewHolder;
    }

    @Override // g5.i
    public final void l(h5.h hVar) {
        m mVar = this.f12647a;
        if (mVar.getActivity() == null || !(mVar.getActivity() instanceof r5.b)) {
            return;
        }
        try {
            r5.b bVar = (r5.b) mVar.getActivity();
            bVar.getClass();
            bVar.i(hVar, this.f12648b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // g5.i
    public final void f(int i10) {
    }
}
